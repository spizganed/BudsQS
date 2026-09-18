# PROTOCOL.md — how the earbuds actually talk

A complete, evidence-first reference for the OPPO / OnePlus / realme earbud
RFCOMM protocol as **this project** understands it. Written so a future session
can re-learn the whole wire format without re-deriving it from captures.

**Rules for this document**

1. Every claim is marked with how we know it. `[VENDOR]` = from an official APK
   or vendor method name. `[OSS]` = from a public reverse-engineering project
   (see `CREDITS.md`). `[CAPTURE]` = observed on our own device, with the capture
   in `local/logs/`. `[GUESS]` = unverified. **Never promote a claim without
   evidence, and never delete a `[GUESS]` marker to make the doc look tidy.**
2. The test device is **OnePlus Buds 4**, firmware `B4.1-260810-1153`, Android.
   Other models differ — notably in feature IDs and button IDs.
3. If you learn something, add it here **in the same commit** as the code change.

---

## 1. Transport

Classic Bluetooth **RFCOMM / SPP**, not BLE.

| UUID | Role |
|------|------|
| `00001107-D102-11E1-9B23-00025B00A5A5` | Tried first |
| `0000079A-D102-11E1-9B23-00025B00A5A5` | The one that actually works on Buds 4 `[CAPTURE]` |

`[CAPTURE]` On this device the first UUID reliably fails with
`read failed, socket might closed or timeout, read ret: -1`, and the second
succeeds. That is normal, not an error worth chasing.

The link is **one long-lived socket**. The buds push events over it at any time;
there is no request/response transaction pairing beyond the sequence number.

`[CAPTURE]` Closing the case lid with the buds docked **kills the socket**, which
is why the app treats that as a disconnect signal.

---

## 2. Frame format

```
AA  <TotalLen>  00 00  <Cmd LE>  <Seq>  <PayLen LE>  <Payload...>
^     ^         ^     ^          ^      ^             ^
1B    LEB128    2B    2B LE      1B     2B LE         PayLen bytes
```

| Field | Size | Meaning |
|-------|------|---------|
| Header | 1 | Always `0xAA` |
| TotalLen | LEB128 | Length of everything **after** the header and this field |
| Reserved | 2 | Always `00 00` |
| Cmd | 2 LE | Command id, low byte first |
| Seq | 1 | Sequence number `0x01`-`0xFE`. **`0xFF` = the buds are broadcasting** `[OSS]` |
| PayLen | 2 LE | Payload length |
| Payload | N | See per-command sections |

### TotalLen is LEB128, not a byte

`[OSS]` — from `Star-ZER0/Pods-Protocol-Reverse-Engineering`, and it is easy to
miss because every short frame looks like a plain byte:

- `< 128` → a single byte, value as-is.
- `>= 128` → **subtract 1**, then encode the result as standard LEB128
  (7 data bits per byte, low bits first, high bit set = "another byte follows").
- Decode: if the high bit is clear it is the value; otherwise accumulate 7-bit
  groups until a clear high bit, then **add 1**.

**Why this matters to us:** our frames are all small, so a naive single-byte
writer is correct for everything the app sends today. The gesture-config write
(`0x0401`, see §6) sends the whole key-function table back, which is the largest
frame we build — on Buds 4 that is ~80 bytes with the 18-20 entries the bud
reports, still under 127, so LEB128 has **not** been needed in practice. A bud
with a much larger table, or a write that adds entries, would cross 127 and need
real LEB128; `OpoProtocol.buildPacket()` does not implement it yet.

### Worked examples

```
AA 07 00 00 00 01 01 00 00         handshake     TotalLen=7,  Cmd=0x0100, Seq=01, PayLen=0
AA 0A 00 00 04 04 06 03 00 01 01 01  set ANC Off  TotalLen=10, Cmd=0x0404, Seq=06, PayLen=3
AA 0C 00 00 04 02 FF 05 00 03 01 01 08 00  ANC push  TotalLen=12, Cmd=0x0204, Seq=FF (broadcast), PayLen=5
```

`[CAPTURE]` Note the pattern: **TotalLen = total bytes − 2**, because the two
sync/length bytes are excluded from their own count.

### Payload offset

**Payload always starts at byte index 9.** Size comes from bytes 7-8. This is
`BudsConnectionManager.payloadOf()`, and getting it wrong silently produces
garbage rather than an error.

---

## 3. Command map

### Query / response (0x01xx → 0x81xx)

| Cmd | Resp | Name | Payload | Status |
|-----|------|------|---------|--------|
| `0x0100` | `0x8100` | Handshake | — | `[CAPTURE]` |
| `0x0103` | `0x8103` | Product ID | — | `[CAPTURE]` |
| `0x0106` | `0x8106` | Battery | — | `[CAPTURE]` |
| `0x0108` | `0x8108` | **getKeyFunction** (gestures) | `<status> <count> <deviceType...>` | `[CAPTURE]` see §6 |
| `0x0109` | `0x8109` | Wearing / in-case | — | `[CAPTURE]` |
| `0x010C` | `0x810C` | ANC state | `01 01` | `[CAPTURE]` |
| `0x010D` | `0x810D` | Feature switch status (batch) | `<count> <featureIds...>` | `[CAPTURE]` |
| `0x010F` | `0x810F` | EQ | — | `[OSS]` |
| `0x0122` | — | EQ all presets | `01 05` | `[OSS]` |

Responses are **`cmd | 0x8000`**. That is a reliable rule `[OSS]`.

### Broadcast / notify (0x02xx)

| Cmd | Name | Notes |
|-----|------|-------|
| `0x0200` | Query broadcast codes | → `0x8200` lists what the firmware supports |
| `0x0201` | Register a single event | `[OSS]` |
| `0x0204` | **Spontaneous push** | `payload[0]` = subType. Seq is `0xFF` |
| `0x0205` | Subscribe to events | → `0x8205` ack |

### Set (0x04xx)

| Cmd | Name | Payload |
|-----|------|---------|
| `0x0401` | **setKeyFunction** (gestures) | `<count> [deviceType, button, buttonAction, function]...` `[OSS]`+`[CAPTURE]` see §6 |
| `0x0403` | Feature switch | `[featureId, status]`, status `01`/`00` |
| `0x0404` | Set ANC | `01 01 <bit>` — see §5 |
| `0x0406` | Set EQ | `[eqMode]` `[OSS]` |
| `0x0422` | Set spatial audio | `00` off / `01` fixed / `02` head-tracking |

Writes are acked by `0x8403` / `0x8404` with a 1-byte payload of `00` for
success `[CAPTURE]`.

---

## 4. Initialisation sequence

A working connection is exactly this, in order `[CAPTURE]`:

```
1. TX 0x0100 handshake                -> 0x8100
2. TX 0x0103 query product id         -> 0x8103
3. TX 0x0200 query broadcast codes    -> 0x8200   (learn what the buds support)
4. TX 0x0205 register notifications   -> 0x8205   (SUBSCRIBE - see below)
5. TX 0x010D query status             -> 0x810D
6. TX 0x010C query ANC                -> 0x810C
7. TX 0x0106 query battery            -> 0x8106
8. TX 0x0109 query wearing            -> 0x8109
9. TX 0x0108 query key function       -> 0x8108   (READ-ONLY, see §6)
10. TX 0x010C query noise switch modes -> 0x810C  (READ-ONLY, payload 02 01, see §5)
```

Each step is 200 ms apart, with a 300 ms delay before the first. Source:
`BudsConnectionManager.runInitSequence()`.

Then a periodic status poll (the app uses `POLL_INTERVAL_SECONDS = 60`). It sends the status
query only — wear is NOT polled, because the buds push it (§8).

Steps 9 and 10 are READ-ONLY additions, so neither can corrupt a binding.

`[CAPTURE]` Step 9 is settled: the buds answer it in ~40 ms and nothing objects, so it stays.
**If the timing of the earlier steps ever looks disturbed, these late additions are the first
suspect** — they are the only steps here that were appended after the sequence was stable.

`[GUESS]` **Step 10 is NOT settled — nothing has ever answered it.** No capture has shown a
`0x810C` reply to payload `02 01`, so even its reply SHAPE is unknown. It is sent anyway because
it is read-only and cheap, and it is the read that must be confirmed before the hold mode picker
can be built (§5). Every log search so far has found no `810C` line at all, which is the whole
reason the hold's mode list is still unwired.

### The broadcast codes reply (0x8200) is the map of what exists

`[CAPTURE]` On Buds 4:

```
AA 12 00 00 00 82 03 0B 00 00 09 01 02 03 04 08 0B F1 F2 F3
                                       ^^ ^^^^^^ ^^^^^^^^^^^
                                      count=9   the codes
```

| Code | Meaning |
|------|---------|
| `0x01` | Battery push |
| `0x02` | Wearing push |
| `0x03` | **ANC push** |
| `0x04` | `[GUESS]` something state-related; not subscribed by us |
| `0x08` | `[GUESS]` |
| `0x0B` | `[GUESS]` |
| `0xF1`–`0xF3` | `[OSS]` debug/JSON channels |

**Read this reply before assuming an event is unsupported.** It is the quickest
way to settle "is the buds' silence real, or are we just not subscribed?".

### Registering: the part that cost three captures

`0x0205` payload is **`[count][eventId...]`** — count FIRST `[CAPTURE]`.

```
02 01 02        count=2: battery + wearing
03 01 02 03     count=3: battery + wearing + ANC   <- current
```

**Do not write `01 01 02 02`.** Under the count-first shape that means "count=1,
register battery only", with `02 02` left over. The firmware ACKs it happily and
then never sends wear events, which is why wear looked poll-only for a long time.
That literal appears in older notes and in some public projects — it is a misread.

**We missed `0x03` (ANC) for the same class of reason.** Without subscribing to
it, ANC gestures were completely silent — no frame at all — and that looked
exactly like "this firmware does not report ANC". It does. See §5.

### The subscription ack (0x8205)

`[FOR VENDOR VERSION]` do not assume the ack echoes your list. On an older
capture the ack was:

```
AA 0D 00 00 05 82 04 06 00 01 02 01 00 02 00
                                   ^^ ^^ ^^ ^^
```
`[GUESS]` reads as `[01][02][01 00][02 00]` — i.e. ids with an enable byte each,
`00` = normal. **Check this ack lists all the ids you asked for**; if it lists
fewer, the firmware rejected part of the list.

---

## 5. ANC (noise cancelling)

### SET vs NOTIFY use DIFFERENT encodings

**This is the single most important trap in this document.** They do not agree,
they are not supposed to agree, and assuming they do produces writes the buds
silently ignore or misinterpret.

#### Set — `0x0404`, payload `01 01 <bitfield>` `[OSS]`

From `OppoPodsManager` `Protocol/OppoProtocol.Anc.cs`, where `PktAncByIndex()` is
the same algorithm as our `OpoProtocol.ancPayload()`:

| Mode | Payload | Bit |
|------|---------|-----|
| Off | `01 01 01` | 0 |
| On | `01 01 02` | 1 |
| **Transparency** | `01 01 04` | **2** |
| Deep | `01 01 10` | 4 |
| Medium | `01 01 20` | 5 |
| Light | `01 01 40` | 6 |
| Smart | `01 01 80` | 7 |
| Adaptive | `01 01 00 08` | mask `0x0800` = **bit 11**, 4-byte payload |

The bitfield grows: `index / 8 + 1` bytes after the `01 01` prefix.

**ADAPTIVE IS BIT 11, NOT BIT 8 — a real bug, found and fixed 2026-09-22.** The old
row here said "8", and `OpoProtocol.ancAdaptive()` passed `8` to `ancPayload()`,
which computes `index / 8 + 1 = 2` mask bytes and sets bit `8 % 8 = 0` of the
SECOND one — producing `01 01 00 01`, a different mode entirely. The mask is
little endian across the bytes after the `01 01` prefix, so `AncAdaptive`
(`01 01 00 08`) is the value **0x0800**, whose bit index is **11**.

**Say it precisely, because an earlier revision of this section said "Adaptive is the
only mode that cannot be expressed as an index", which is WRONG.** `ancPayload(11)`
does reproduce these bytes — the helper was never the problem, the number handed to it
was. 8 is just the plausible-looking wrong answer: the vendor's list reads like
"0-7, then the next one". The builder deliberately spells the four bytes literally
instead, to match `AncAdaptive = { 0x01, 0x01, 0x00, 0x08 }` verbatim rather than
re-deriving a number that was already derived wrong once. Every other row above is
reproduced correctly by the index algorithm. `LogDecoder.ancPayloadToString()` was
also reading `0x0100` for Adaptive and now reads `0x0800`, so an Adaptive command no
longer prints as `Unknown (0x0800)` in our own log.

The bug was INERT for as long as it existed: nothing called the builder. The
Adaptive circle added to the main screen makes it live, which is why it is fixed
in the same change rather than left as a latent wrong packet.

#### Notify — `0x0204` subType `0x03`, and the `0x810C` query reply `[CAPTURE]`+`[OSS]`

Payload `03 01 01 LO HI`; `LO`/`HI` are `(Val1, Val2)`, little endian.

| Raw | Val1, Val2 | Mode |
|-----|-----------|------|
| `0x0008` | `08 00` | **Off** |
| `0x0002` | `02 00` | ANC (generic) |
| `0x0080` | `80 00` | Smart |
| `0x0040` | `40 00` | Light |
| `0x0020` | `20 00` | **Medium** |
| `0x0010` | `10 00` | **Deep** |
| `0x0100` | `00 01` | **Transparency** |
| `0x0200` | `00 02` | Transparency, voice enhance on |
| `0x0800` | `00 08` | Adaptive |

Both our captures and `OppoPodsManager`'s `AncValues` dictionary agree exactly.

`[CAPTURE]` **The ANC-on stop echoes whichever LEVEL was last active.** Cycling
from Deep reported `0x0010`; cycling from Medium reported `0x0020`. So the value
is a **bitmask of the actual mode**, not a fixed three-value enum. Code that
treats it as an enum will be wrong half the time.

`[CAPTURE]` 2026-09-21 — a four-stop gesture cycle (`low -> adaptive ->
transparency -> off`) returned **`0x0800` for the Adaptive stop**, which had been
`[OSS]`-only until then. Two consequences worth keeping:

- `0x0020` was NOT the "ANC on" stop in general. The cycle above never produced
  it, because Light was the level in force. Both earlier captures that read it as
  *the* ANC-on value were simply starting from Medium. The bitmask reading is the
  correct one and this capture is the second, independent confirmation.
- **`0x0040` (Light) and `0x0800` (Adaptive) are byte-distinct and are now ALSO
  UI-distinct.** While the app had three ANC levels and no Adaptive control,
  `modeForRaw()` folded `0x0800` into `ANC-Light`, which meant a log line could not
  be read back: the four-stop cycle above printed `raw=0x0040 -> ANC-Light` followed
  by `raw=0x0800 -> ANC-Light`, two different stops rendered identically. That was
  patched in the LOG (`describe()` special-cased `0x0800`) while the mapping itself
  stayed folded, and the fold was right at the time. **SUPERSEDED 2026-09-22, when
  the main screen gained an Adaptive circle:** `modeForRaw()` now returns `"Adaptive"`
  and there is no special case in `describe()` any more, because the two are no
  longer the same UI state — Adaptive lights its own circle. The old instruction
  "do not unify these two back into one name" is therefore **retired**: they ARE one
  name now, deliberately, and `circleFor()` maps `"Adaptive"` to the ADAPT circle.
  If a future change removes the Adaptive control, the fold has to come back with it
  or a bud-side Adaptive switch will light nothing.
- `[USER]` The hold offers **only** the ANC cycle in HeyMelody, in exactly this order
  (`ANC on -> adaptive -> transparency -> ANC off`), so the four stops above are the
  cycle's canonical order and not an accident of what he happened to press. The
  "ANC on" stop is the last level set BY HAND, which is why it read `0x0040` here and
  `0x0010` / `0x0020` in the earlier captures — same rule, three observations.

### Querying

```
TX  AA 09 00 00 0C 01 05 02 00 01 01
RX  AA 0C 00 00 0C 81 05 05 00 00 01 01 08 00
                                           ^^^^^ last two bytes = the notify bitmask
```
`[CAPTURE]` Off returned `08 00` here, consistent with the notify table.

#### The hold's SWITCH LIST is a different question on the same command number

`0x010C` carries several questions, chosen by the REQUEST payload `[OSS]`:

| Request | Question |
|---------|----------|
| `01 01` | current mode (above) |
| `02 01` / `02 03` / `02 04` | **which modes the hold cycles through** (`getNoiseReductionSwitchMode`) |
| `04 01` | intelligent noise reduction mode |

**NO CAPTURE HAS EVER SHOWN A REPLY TO THE SWITCH-LIST VARIANT — `[GUESS]` beyond
that.** `queryNoiseSwitchModes()` is sent in the init sequence, but searching every
log in `local/logs/` finds no `0x810C` answer to `02 01`, and no `810C` line at all.
So the reply's SHAPE is unknown, not merely unparsed. This matters for the obvious
next question ("can we pick Low/Medium/High for the hold?") — see below.

The write side is `setSupportNoiseReduction` (`0x0404`, payload
`[action=2][noiseType][modeMask LE]`, `OppoProtocol.LongPressNoisePayload`), and
`[OSS]` only, untested.

#### Can the app choose which ANC modes the hold cycles? **Yes in principle — the
#### limit is our own protocol coverage, not the hardware and not HeyMelody's design.**

This is the short answer to a question worth recording, because the "it just uses the
last manually-chosen mode" behaviour is real but its CAUSE is not what it looks like:

- **It is not a hardware limit.** The buds hold a *changeable* list. Same stored `fn`
  byte (`0x08`) covered two modes in one session and four in another, so membership is
  stored somewhere on the device and is not fixed.
- **It is not a HeyMelody design choice either.** The vendor app does offer the mode
  list for the hold — so the capability is real and reachable.
- **It IS the protocol's shape.** The key-function table stores ONE byte meaning "this
  gesture cycles ANC". It carries no membership, so changing that byte cannot change the
  cycle (measured: clearing it to `0x00` did not stop the cycle). HeyMelody shows a mode
  list because it ALSO sends `setSupportNoiseReduction` alongside the binding. That write
  is the missing half in this app — not the hardware.
- **And what the app currently does** — leave the hold alone and set modes manually —
  is therefore a consequence of the two gaps above, not a behaviour anyone chose.

**Order of work, and why it is this order:** confirm the read (`0x010C` `02 01`) FIRST.
A mode picker needs to know the current list and the mask encoding, and building it on a
guessed `0x810C` shape would repeat the exact mistake §5 records three times over. The
read is cheap and read-only, so it cannot cost anything to try.

### The History of Getting This Wrong

Kept deliberately, so it is not repeated:

1. **"ANC raises no event."** Wrong. It raises `0x0204` subType `0x03`. The
   belief survived three captures because `noteUnattributed` in
   `BudsConnectionManager` **blanket-excludes cmd `0x0204`**, so an undecoded
   `0x0204` subType prints *nothing at all*. The F1 button frame also fires
   identically for every gesture, so it said WHEN but never WHAT.
2. **"Set and query must use the same bits."** Wrong. SET uses bit 0 for Off and
   bit 2 for Transparency; the buds *report* bits 3 and 8. The SET table was
   "corrected" to the notify values and sent the wrong bits. Reverted.

---

## 6. Button / gesture events — `0x0204` subType `0xF1`

`[OSS]` Payload body from `OppoPodsManager` `Models/UserInteractionEventInfo.cs`:

```
80 F1 | 01 | 01 | 04 | 08 | 03 | <int16 options...>
       ^    ^    ^    ^    ^
       |    |    |    |    +-- byte4: context / scenario
       |    |    |    +------- byte3: FUNCTION it resolves to (not a modifier, see §6.1)
       |    |    +------------ byte2: ACTION (a key-function `act`, not an F1 action id)
       |    +----------------- byte1: button / zone id (model dependent)
       +---------------------- byte0: SIDE
```

| Field | Values |
|-------|--------|
| side (byte0) | `0x01` left, `0x02` right `[CAPTURE]` |
| button (byte1) | model dependent; `0x01` on Buds 4 `[CAPTURE]` |
| action (byte2) | **a key-function `act`, 1..6** — NOT the `[OSS]` F1 action id. See §6.1, which established this by matching four `F1` frames against their `0x8108` entries: `0x01` single, `0x02` double, `0x03` triple, `0x04` long press `[CONFIRMED]` |
| function (byte3) | **the FUNCTION** the gesture resolves to — `[CONFIRMED]` in §6.1. The `[OSS]` calls this field *modifier / flag bits*, which is wrong |
| context (byte4) | `0x03` seen on Buds 4 |
| options | little-endian int16s to end of payload |

`[CAPTURE]` Worked example — a long press on the right bud:

```
AA 0D 00 00 04 02 FF 06 00 F1 02 01 04 08 03
```

Parsed in our code by `UserInteractionParser`; our index base differs (we skip the
`F1` subtype byte because `payload[0]` is already the subtype) but the resulting
fields are identical.

### What this frame can and cannot tell you

- It tells you **WHEN** a gesture happened, and which action and side.
- It is **identical for every occurrence of the same action + side**.

**THIS SECTION USED TO CONCLUDE THE OPPOSITE, AND IT WAS WRONG — see §6.1.** The frame
does tell you what the gesture does, via `byte2`/`byte3`. This section used to conclude that
the frame therefore does **NOT** tell you what the gesture *did*, and gave as proof "two
long presses on the right bud — one cycling ANC, one triggering voice assistant —
produce the same `F1` frame". `[USER]` That example **cannot be built on this model**:
HeyMelody offers the hold nothing but the ANC cycle (see §6.1), so a hold cannot be
bound to voice assistant at all. The observation is still true, but it no longer
supports the conclusion, because a binding is exactly one function per
`(device, button, action)` — so the frame *would* still look identical on every
occurrence even if it carried the function.

The safe reading, and it still stands now that §6.1 is confirmed: the `F1` log line is
**diagnostic only, never a control signal**. The *effect* must come from a separate event (§5) or a
query. Knowing what a gesture is bound to does not tell you what the buds just did — read that from
the ANC/game-mode/wear pushes instead.

### 6.1 `[CONFIRMED]` `F1` byte3 IS the bound function

**RESOLVED 2026-09-22 — the answer is YES.** `F1` `byte2`/`byte3` are the key-function
`act`/`function` pair, matched across five independent slots with five *different* values:

| `F1` (after `F1`) | byte2 | byte3 | key-function entry | its `fn` |
|---|---|---|---|---|
| `01 01 01 01 02` | 01 | 01 | `dev=01/btn=01 act 01` | 0x01 |
| `01 01 02 06 02` | 02 | 06 | `dev=01/btn=01 act 02` | 0x06 |
| `01 01 03 05 02` | 03 | 05 | `dev=01/btn=01 act 03` | 0x05 |
| `01 01 04 08 02` | 04 | 08 | `dev=01/btn=01 act 04` | 0x08 |

So the buds DO tell us, live, what a bound gesture does — and `byte2` is already a
key-function `act`, not an `F1` action id, which is why the two numberings looked so
confusing for so long.

**HOW THIS WAS FIRST GOT WRONG, AND THE LESSON — kept because it is the useful part.**
An earlier pass declared the theory *refuted* using one frame, `F1 01 01 00 00 03`, where
byte2/byte3 are both `0x00`, against the single-tap slot (`act 01 -> fn 01`). But
**`byte2 = 0x00` is not a key-function `act` at all** — the table's acts are 1..6 — so that
frame is not the single-tap binding firing; it is some other event. The comparison was
between two different kinds of thing. **Do not refute a theory with a sample that may not
be the same kind of event.**

**THE SLIDE "OUTLIER" IS NOW EXPLAINED (2026-09-22): `byte3` IS THE RESOLVED FUNCTION.**
This was listed here as an unexplained counter-example. It is not one — it is the rule
working. The same gesture, with two different slot values, gave two self-consistent pairs:

| slide slot `fn` | `byte3` up | `byte3` down | reading |
|---|---|---|---|
| `0x0A` switch track | `0x05` | `0x06` | resolves to prev / next |
| `0x07` volume | `0x0B` | `0x0C` | resolves to volume up / volume down |

So `0x0A` and `0x07` are **composites** that resolve per direction, and **`0x0B` = volume up,
`0x0C` = volume down** (the pairings are measured; the two NAMES are inferred, and marked so).
This is also the cleanest demonstration of why `byte3` cannot be read as just "the stored
byte" — it reports what the gesture EFFECTIVELY does.

**STILL UNEXPLAINED — so this stays diagnostic, never a control signal:**

- **`F1` action `0x00` vs `0x01`.** Both appear as a left single tap. `0x01` matches the
  bound slot, `0x00` does not — `0x00` is likely a raw touch report, which would also make
  the `[OSS]` action table's "`0x00` = single tap" **suspect**.
- **The hold breaks the pattern in a revealing way:** with its stored `fn` cleared to `0x00`
  the `F1` frame still reported `byte3 = 0x08`. So `byte3` tracks the **effective** function
  — what the gesture really does — not necessarily the byte stored in the table.

The evidence below is the original `[CONTENDED]` reasoning, kept as the record of how a
two-sample match was correctly treated as unproven *at the time*:

`[OSS]` labels byte3 *modifier / flag bits*. A pairing of our own two frames suggests
it may instead carry the **function id** — the same value the `0x8108` reply puts in
its fourth slot. That would mean the buds tell us *what* a gesture does, live, and the
gesture UI would not need a `0x8108` round trip to find out.

Evidence FOR, and it is one gesture only — the hold:

| frame | `F1` | `0x8108` entry |
|-------|------|----------------|
| left hold | `01 01 04 08 03` → side `01`, btn `01`, act `04`, byte3 `08` | `dev=0x01/btn=0x01 04:08` |
| right hold | same shape, side `02` | `dev=0x02/btn=0x01 04:08` |

Same side, same button, same action, and byte3 equals the reply's `fn` on both buds.
`[USER]` Both buds' hold is the ANC cycle, and `fn 0x08` is the only function assigned
to a hold in the reply. So the case is coherent — but it rests on ONE gesture.

Evidence AGAINST, which is why this is `[CONTENDED]` and not a finding:

- `[OSS]` byte3 is non-zero specifically on long presses, which is also what a
  modifier flag would do. The match could be a coincidence of the hold's flags being
  `0x08`.
- **No second data point.** The reply's other assigned slots — `fn 0x07` (act `0x05`)
  and `fn 0x11` (left double tap only) — have no `F1` capture to compare against.
  Every other `F1` sample we hold is a hold, i.e. the same gesture.
- The two readings are **the same event seen twice**, not two independent facts. That
  is exactly the shape of the SET-vs-NOTIFY mistake (§5): plausible, self-consistent,
  and wrong.

`[USER]` **Which functions a gesture may hold is constrained by the model, and that
removes the obvious test.** In HeyMelody the HOLD offers *nothing but* the ANC modes
(`ANC on`, `Adaptive`, `Transparency`, `ANC off`); game mode is only offered on
DOUBLE and TRIPLE tap. So "rebind the hold to game mode and watch byte3 change" is
**not a thing that can be done — do not propose it again.** It also means the
`fn 0x08` in the table above is the whole hold binding, not one of four: the hold is
a single *cycle* function, and the four-stop cycle he ran is its output, not four
separate bindings.

Our own gesture UI already encodes the same constraint independently —
`GestureConfig.actionsFor()` gives `TAP_HOLD` the four ANC actions and nothing else,
and gives `GAME_MODE` to double/triple tap only. The two agree, so that vocabulary is
not ours to widen.

**THE TEST THIS SECTION ASKED FOR WAS RUN, AND IT PASSED — see §6.1.** It wanted a non-hold
`F1` frame compared against its reply entry, and single/double/triple-tap frames all matched
once they were available. The lesson worth keeping is that the *first* attempt at this test
used a frame which was not a binding event at all, and drew the wrong conclusion from it;
§6.1 records that mistake in full.

### Gesture configuration — IMPLEMENTED AND WORKING (2026-09-22)

| Direction | Cmd | Payload |
|-----------|-----|---------|
| Read | `0x0108` → `0x8108` | `<status> <count> <4-byte entries>...` `[CAPTURE]` |
| Write | **`0x0401`** → ack `0x8401` | `<count> [deviceType, button, buttonAction, function]...` `[CAPTURE]` |

Each entry is 4 bytes `[deviceType, button, buttonAction, function]`
(`[OSS]` `Models/KeyFunctionItem.cs`, confirmed on the read side by our capture).

**`0x0402` IS NOT THE WRITE AND COST A SESSION.** It was sent repeatedly in a well-formed
frame (`TotalLen 80 = 7 + 73`, payload `12` + 18×4) and the buds ignored it **in total
silence** — no ack, read-back unchanged. `0x0401` acks immediately:
`RX AA 08 00 00 01 84 .. 01 00 00`, payload `00` = success. Sources:
the Melody-derived setting tables list `setKeyFunction` (`BtOperate.m2699L`) at `0x0401`
and run 0x0400, 0x0401, 0x0403, 0x0404 — 0x0402 is not among them — while OppoPodsManager
mentions 0x0402 **only inside a comment**. That comment was the trap.

**A WRONG COMMAND NUMBER FAILS SILENTLY.** "It worked" and "it did nothing" are
indistinguishable without reading the table back, which is why the write always re-reads
and diffs. A write that matches no slot is now refused loudly, for the same reason.

#### The `function` values — MEASURED, not guessed

Obtained by diffing two `0x8108` readings around changes he made, then checking every value
against what he reported binding (zero contradictions; two values confirmed twice):

| `fn` | meaning | | `fn` | meaning |
|---|---|---|---|---|
| `0x00` | none / unbound | | `0x08` | **ANC cycle** (the hold) |
| `0x01` | play/pause | | `0x0A` | switch track |
| `0x03` | voice assistant | | `0x0B` | volume up `[INFERRED]` |
| `0x05` | previous track | | `0x0C` | volume down `[INFERRED]` |
| `0x06` | next track | | `0x11` | game mode |
| `0x07` | volume | | | |

`0x0B`/`0x0C` come from **`F1` byte3 during a slide**, where the same gesture resolved
per direction (see `byte3` in §6.1): a slot holding `0x07` (volume) reported `0x0B` going up
and `0x0C` going down. The PAIRING is measured; the two **names are inferred**, which is why
they are marked. `0x0A` and `0x07` are **composites** — they resolve per direction, so an
`F1` frame never reports them directly.

Unseen: `0x02`, `0x04`, `0x09`, `0x0D`–`0x10`, `0x12`+.

#### The table's SHAPE IS NOT FIXED — do not hardcode a count OR a button group

`[CAPTURE]` Both the entry COUNT and the button GROUPS a gesture lives in change, and they
differ **per bud, within a single capture**. The slide gesture, one session:

```
LEFT   19 entries  dev=0x01/btn=0x01[01 02 03 04 06 05:07]   slide bound inside btn 0x01
RIGHT  19 entries  dev=0x02/btn=0x02[05:00]                  slide SPLIT OUT, unbound
                   dev=0x02/btn=0x03[05:00]
both   20 entries  (an earlier session)                      slide split out, other side
both   18 entries  (after consolidation)                     slide back inside btn 0x01
```

**This broke slide twice, in opposite directions.** Writing to `btn 0x01` missed the split
shape; writing to `btn 0x02`/`0x03` missed the LEFT bud and produced
`NO SLOT MATCHED for dev=0x01`. **Any hardcoded button group is wrong about half the time,
so a write must take the slots FROM THE TABLE** — every entry for that `(side, action)`,
excluding only the `btn 0x06` group.

**AND THE DEVICE NORMALISES THE SPLIT SHAPE — `[CAPTURE]`, by arithmetic.** Giving the right
bud's two split halves the same function produced an ack (`0x8401`, status `00`), and the
re-read showed `btn=0x01 act=0x05 added: 0x07` with `btn=0x02 removed` and `btn=0x03 removed`
— 19 entries → 18 (=-2, +1 ✓). So the split is a **"two unbound halves" state** that the
firmware folds back into one `btn 0x01` slot once both halves agree. That is exactly why
slide appeared to work once and then never again: the first write collapsed the shape, and
every later write aimed at groups that no longer existed.

`btn 0x06` (all `fn=0x00`) is still unexplained — the on-call hypothesis is neither
confirmed nor refuted, and `0x02`/`0x03` turning out to be slides shows "extra group" does
not automatically mean "on call".

#### THE HOLD'S FUNCTION BYTE DOES NOT CONTROL THE CYCLE

Clearing the hold's stored byte to `0x00` **does not stop the ANC cycle**: he long-pressed
right after and the noise mode still changed, with `F1` still reporting `byte3 = 0x08`.
Which modes the cycle steps through also stayed exactly the set configured in the VENDOR
app (two modes here, four earlier) — same `fn` byte both times.

So the key-function table only *describes* the hold; the cycle itself lives in the separate
**`setSupportNoiseReduction` (`0x0404`)**, payload `[action=2][noiseType][modeMask LE]`
(`OppoProtocol.LongPressNoisePayload`), read back with `0x010C` payloads
`02 01` / `02 03` / `02 04`. `[OSS]`, untested. **Not wired** — it is a different command
and folding it into the key-function save would make a failure impossible to attribute.
The read reply's 2-byte header is our own finding — see just below.

`[USER]` 2026-09-22 asked whether the hold could be given a Low/Medium/High choice, since
today it only uses whatever mode was last set by hand. **Answered: the device can, and the
vendor app does; what is missing is ours.** See "Can the app choose which ANC modes…" in
§5's Querying section for the reasoning and the required order of work.

**The `function` VALUES ARE NO LONGER UNKNOWN — they are in the table above, measured.**
This paragraph used to say they were the one blocking gap and describe two routes to find
them. Both routes were used and both are finished: route 1 (diff two readings) is what
produced the table, and route 2 (a HeyMelody capture) was never needed. Kept as a note only
so the history is not lost — **do not re-open it, and do not "re-derive" the enum.**

Note the source conflict, and its resolution: an `ai-generated/` doc said `0x0401`;
`OppoPodsManager` appeared to say **`0x0402`**. This document originally said "prefer
`0x0402`" — **that was wrong, and it cost a session.** The device settled it: `0x0402` is
ignored in total silence, `0x0401` is acked. See the IMPLEMENTED table above.

#### Route 1 — ANSWERED. The reply is readable, and the layout guess was WRONG.

`[CAPTURE]` The buds answer `0x0108`, and the reply decodes completely.

```
TX  AA 07 00 00 08 01 30 00 00        query key function (payload empty)
RX  AA 51 00 00 08 81 30 4A 00 | 00 12 ...    payLen = 0x4A = 74
```

`TotalLen` is `07` here, matching the handshake, because `TotalLen = 7 + payLen`
and this payload is empty — do not copy `08` from the command number. The seq byte
is whatever the counter was at; it is not fixed (the reply echoes it, `0x30` above).

**THE PAYLOAD HAS A LEADING STATUS BYTE THAT `KeyFunctionItem.cs` DOES NOT MODEL.**

```
<status> <count> <deviceType, button, buttonAction, function>...
  0x00    0x12      4 bytes each
```

`KeyFunctionItem.cs` describes ONE entry's bytes, not the payload wrapped around it.
Taking `payload[0]` as the count is therefore wrong: it is `0x00`, so the parser read
0 entries, shifted every entry one byte left, and printed `dev=0x12` — which is really
the count. The `!LAYOUT` guard caught it (`expected 1+0*4 bytes, got 74`) rather than
decoding garbage silently, which is why the guard exists. **Arithmetic settles the
header size:** 74 bytes with 18 entries is `2 + 18*4`, exactly; no other header size
fits. `KeyFunctionParser.HEADER_SIZE = 2`.

`[CAPTURE]` The 18 entries on Buds 4, grouped by the app (`act:fn`), entries in the
buds' own order:

```
dev=0x01/btn=0x01[01:00 02:11 03:00 04:08 06:00 05:07]
dev=0x01/btn=0x06[02:00 03:00 06:00]
dev=0x02/btn=0x01[01:00 02:00 03:00 04:08 06:00 05:07]
dev=0x02/btn=0x06[02:00 03:00 06:00]
```

`deviceType` matches the `0xF1` frame's side byte (`0x01` left, `0x02` right), and
`button` is `0x01` / `0x06` — `0x01` also being this project's button id from the
`0xF1` captures. So the two frames agree on their two shared fields.

Three places print the reply, so a capture can always be read even if the parse is
wrong: the raw `RX:` line, `BudsConnectionManager`'s `KEYFN:` line, and
`LogDecoder`'s description — **all of which end with `RAW=[...]`**.

#### THE `function` VALUES ARE NOW MEASURED — see the table above

This section used to say they were unread and that no UI may offer a function list. **Both are
obsolete.** The values were obtained by diffing two `0x8108` readings around changes made in the
vendor app, cross-checked against what he had actually bound (zero contradictions, two values
confirmed on two separate slots). They live in `GestureAction.functionByte`, and the Earbud controls
screen offers a real function list built from them.

The two hints recorded here at the time both held up: `0x00` is indeed the unbound/default value
(13 of 18 entries), and long press (`act 0x04`) is `0x08` on both buds. **Do not re-derive the
enum** — the work is done and a "refutation" was already attempted once with a bad sample.

`[USER]` **The hold is offered nothing but the ANC modes, and they CYCLE.** In
HeyMelody the hold's menu is `ANC on / adaptive / transparency / ANC off`, and a press
walks those states. `[USER]` Game mode is offered on double and triple tap ONLY.

Inference from that, ours and not his — kept separate on purpose: **`fn 0x08` is
therefore a CYCLE, not a mode**, and the four ANC menu rows are probably **one `fn`
value, not four**. The reason is structural: an entry is 4 bytes
(`deviceType, button, buttonAction, function`) with no room for a mode list, and
`dev=0x01/btn=0x01` carries exactly ONE `act 0x04` entry, so whatever the cycle
contains is not in this reply. That predicts the enum is closer to *menu rows* than
to *ANC modes* — so do not go looking for four ANC values in it.

This also decides the diff below: the first value we should expect to learn is a
menu-row value (Game Mode), not an ANC mode value.

The `buttonAction` NUMBERS are also unmapped, and they are **NOT** the `0xF1` action
numbers: `F1` calls single tap `0x00` and long press `0x04`, while this reply binds
`0x01` as well as `0x04`. `[GUESS]` `1..6` could be single, double, triple, long
press, slide up, slide down — but that is a guess and stays one. `[USER]` **It is
consistent with the menu he sees:** double and triple tap each accept game mode,
which is why `act 0x02` and `act 0x03` both appear under `btn 0x01` with values,
while the hold row is a single cycle entry.

#### HOW THE ENUM WAS MEASURED — the diff that finished it (DONE 2026-09-22)

This section used to be a plan. **It was carried out, and it is where the `function` table above
comes from.**

`0x8108` describes the CURRENT binding, so **DIFF TWO READINGS**: change ONE gesture in the vendor
app, reconnect our app, and compare the `KEYFN:` lines. Whichever `fn` byte moves for that `act` is
that function's value, and each further action can be learned the same way. This is why the reply is
printed GROUPED per `dev/btn` — the single entry that changed is meant to be visible at a glance.

**Do not re-run this to "verify" the table.** It has been done, the values are in `GestureAction`,
and a re-derivation was already attempted once with a bad sample and drew a wrong conclusion (§6.1).
The method below is kept for the next genuinely-unknown value, not for this enum.

**Pick the change from the UNBOUND side, not the bound one.** The reply above has
`fn=0x00` on 13 of its 18 entries and only three distinct non-zero values, so a
change made from `0x00` is unambiguous in a way that swapping two bound values is
not. `[USER]` Game mode is offered on double and triple tap, and **right** double tap
currently reads `fn=0x00` — so setting right double tap to Game Mode is the cleanest
first diff: one `0x00` should move, and the value it becomes is Game Mode.

Two traps that were live at the time, kept because they generalise to any future diff — not
just this one:

The two traps that were live at the time, kept because they generalise to any future diff — not
just this one:

- **Do not diff the hold.** It offers only the ANC cycle (§6.1), so the `fn` byte
  cannot vary and a "no change" result would tell us nothing while looking like one.
- `[USER]` **`fn` may not be 1:1 with the menu label.** "ANC on" is ambiguous on the
  device itself: he expects it re-applies the last *manually* chosen level, which is
  exactly what §5's captures show (`0x0040`, then `0x0010` / `0x0020` on other days).
  So a diff that moves for "ANC on" names the *slot*, not a level — do not write down
  "0xNN = ANC on" as if it were a level constant.

**Note the write path IS built now.** `0x0401` is defined as a constant and the app writes the full
key-function table back (`BudsConnectionManager.writeGestureBinding`). `buildPacket()` still lacks
real LEB128 `TotalLen` (§2), but no frame the app builds reaches 127 bytes, so it has never been
needed in practice.

---

## 7. Battery — `0x8106` and `0x0204` subType `0x01`

`[OSS]` Payload is `[index][rawValue]` triples: `01LL 02RR 03MM`.

- index `01` left, `02` right, `03` case.
- level = `raw & 0x7F`
- charging = `(raw & 0x80) != 0`

`[CAPTURE]` Example: `... 03 01 64 02 64 03 50` → all three at `0x64` = 100, case
`0x50` = 80.

## 8. Wearing / in-case — `0x8109` and `0x0204` subType `0x02`

`[OSS]` Payload is `[count][component, status] × count`.

| component | Meaning |
|-----------|---------|
| 1 | Left bud |
| 2 | Right bud |
| 3 | Case |

| status | Meaning |
|--------|---------|
| `0` | disconnected |
| `1`, `5` | off-ear / idle |
| `3`, `7` | **in ear** |
| `4` | **in case** |

`[CAPTURE]` Buds 4 query responses sometimes prepend a status byte, so
`WearingStatusParser` tries offset 0 and offset 1 and keeps the first layout that
yields plausible pairs.

---

## 9. Feature switches — `0x0403`

Payload `[featureId, status]`, status `0x01` on / `0x00` off.

`[OSS]` From `OppoPodsManager` `Protocol/OppoProtocol.Features.cs`, which maps
feature IDs to vendor method names:

| ID | Feature | | ID | Feature |
|----|---------|-|----|---------|
| `0x04` | Wear detection / auto play-pause | | `0x1B` | **Spatial sound** |
| `0x06` | **Game mode (low latency, legacy)** | | `0x27` | Game sound |
| `0x09` | Vocal enhance | | `0x28` | **Game mode (main, newer)** |
| `0x0B` | Hearing enhance | | `0x30` | Adaptive volume |
| `0x11` | **Dual device** | | `0x31` | Adaptive ear |
| `0x18` | Hi-quality audio | | `0x3A` | Sleep detection |

`[OSS]` **Worth knowing:** newer devices put game mode on `0x28`, older on `0x06`.
This project uses `0x06`. If game mode misbehaves on a different model, that is
the first thing to try.

### Batch status query — `0x010D`

`[CAPTURE]` The app polls:

```
TX  AA 13 00 00 0D 01 00 0C 00 0B 05 04 0B 11 13 18 06 1B 1C 27 28
                                                     ^^ ^^ ^^ ^^...
RX  AA 17 00 00 0D 81 00 10 00 00 07 05 01 04 00 0B 01 11 01 18 01 06 00 1B 00
```

`[GUESS]` Request reads as `count=0x0B` then feature ids. The reply looks like
`[unknown][count=0x07][id][value]...`, and is not parsed beyond logging.

---

## 10. Debugging: what the log lines mean

| Line | Meaning |
|------|---------|
| `RX:` / `TX[...]:` | Raw hex in/out |
| `BTN EVT:` | `0x0204` subType `0xF1` decoded — a gesture happened |
| `ANC EVT:` | `0x0204` subType `0x03` decoded — the ANC mode, from the buds |
| `GAME EVT:` | `0x0204` subType `0x05` decoded — game mode, from the buds |
| `WEAR EVT:` / `WEAR QRY:` | Wearing push / reply |
| `KEYFN:` | `0x8108` reply decoded — the current gesture bindings. Ends with `RAW=[...]` |
| `UNATTR RX:` | A frame we do not decode, with its payload head |
| `ancFlush=` | Whether we had *just* written an ANC command — attribution aid |

### `UNATTR RX` has a blind spot — remember it

`noteUnattributed()` **blanket-excludes cmd `0x0204`**. So an undecoded `0x0204`
subType produces **no `UNATTR RX` line at all**. This is exactly what made ANC
look like silence for three separate captures.

**If a capture needs to see undecoded `0x0204` frames, change that exemption
first.** The Dev Tools decoder *does* show them
(`Unattributed active report: subType=0x.. [...]`), so the information exists —
it just is not in the raw log.

### Undecoded families worth chasing

`[CAPTURE]` `0x0501` / `0x0500` appear right after ANC writes:

```
AA 07 00 00 01 05 01 00 00
AA 07 00 00 00 05 02 00 00
```

Note these are cmd `0x0501`/`0x0500` — a **different family** from
`0x0204 subType 0x05` (game mode). They may be this firmware's alternate ANC
notification. No payload has been observed. **Capture before writing a parser.**

---

## 11. Method: how to learn a new command safely

This sequence is what has actually worked, and skimping on it has cost whole
sessions:

1. **Read `CREDITS.md` / the source repos first.** Three of the last four
   protocol mistakes were settled for free by an existing document. Fastest path:
   `https://raw.githubusercontent.com/<owner>/<repo>/main/<path>`, file list via
   `https://api.github.com/repos/<owner>/<repo>/git/trees/main?recursive=1`.
2. **Check `0x8200`** — does the firmware even claim to support this?
3. **Subscribe** to the relevant broadcast code, or you will see silence and
   mistake it for absence.
4. **Capture with a known starting state**, and have him say in words what he did
   and in what order. The ANC mapping was only pinned down once the capture began
   from a mode we had set ourselves.
5. **Never guess an enum.** Log the raw value and let the device name it.
6. **Write the brief before capturing.** The capture brief worked because it
   predicted a small number of named outcomes and said exactly which lines to send.
   The procedure now lives in [PACKET-CAPTURE.md](./PACKET-CAPTURE.md).

### Things that look like bugs and are not

- The first RFCOMM UUID failing.
- Two `BTN EVT` frames plus two state events for one physical double-tap: the
  firmware **double-reports**. The app faithfully follows, which looks like a
  flap. Do not "fix" it in the parse path.
- ANC writing and nothing appearing to change: check the **SET** table (§5) before
  suspecting the buds.

---

## 12. Open questions

- **The hold's mode list.** `0x810C` request `02 01` is sent in the init sequence, but no capture has
  ever shown a reply, so the shape is unknown. This blocks the hold mode picker (§5). Everything else
  about gesture configuration is settled — the `function` enum was MEASURED, see §6.
- What `0x0501` / `0x0500` are.
- Broadcast codes `0x04`, `0x08`, `0x0B`.
- The `0x810D` batch status reply layout.
- The `0x8205` ack layout (§4) — only one sample, and it does not obviously echo
  the request.
- Whether `0x0404` supports the `type=2` level-setting form `01 02 <level>` (the
  `[OSS]` doc mentions it for "set noise reduction info") — unverified here.
- Case **lid** state is not reported by any command we know. The app only infers
  it from the socket dropping. Do not claim to support it.
