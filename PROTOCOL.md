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
writer works today. A gesture-config write (`0x0402`) with several entries can
exceed 127 bytes, and would need real LEB128. `OpoProtocol.buildPacket()` does
not implement it yet.

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
| `0x0402` | **setKeyFunction** (gestures) | `<count> [deviceType, button, buttonAction, function]...` `[OSS]` |
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
9. TX 0x0108 query key function       -> 0x8108   (added 2026-09-19, READ-ONLY)
```

Then a periodic status poll (the app uses ~60 s).

`[CAPTURE]` Step 9 is settled: the buds answer it in ~40 ms and nothing objects,
so it stays. It is a read, so it cannot change a binding. See §6 for the reply.
**If the timing of the earlier steps ever looks disturbed, step 9 is still the
first suspect** — it remains the only step here that was added late.

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
| Adaptive | `01 01 00 08` | 8 → note the **4-byte** payload |

The bitfield grows: `index / 8 + 1` bytes after the `01 01` prefix.

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
`[OSS]`-only until then. Full capture: `local/logs/anc-cycle-gesture-4stop.txt`.
Two consequences worth keeping:

- `0x0020` was NOT the "ANC on" stop in general. The cycle above never produced
  it, because Light was the level in force. Both earlier captures that read it as
  *the* ANC-on value were simply starting from Medium. The bitmask reading is the
  correct one and this capture is the second, independent confirmation.
- **`0x0040` (Light) and `0x0800` (Adaptive) are byte-distinct but map to the same
  UI state**, because the app has three ANC levels and lights Low for both. A log
  that prints only the UI name shows two different stops as `ANC-Light`, so a
  capture cannot be read back. `AncEventParser.describe()` therefore prints
  `raw=0x0800 -> Adaptive (app shows ANC-Light)` while `modeForRaw()` — which the
  circles and the widget actually use — still returns `ANC-Light` for it. **Do not
  "unify" these two back into one name.**

### Querying

```
TX  AA 09 00 00 0C 01 05 02 00 01 01
RX  AA 0C 00 00 0C 81 05 05 00 00 01 01 08 00
                                           ^^^^^ last two bytes = the notify bitmask
```
`[CAPTURE]` Off returned `08 00` here, consistent with the notify table.

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
       |    |    |    +------- byte3: modifier / flag bits
       |    |    +------------ byte2: ACTION
       |    +----------------- byte1: button / zone id (model dependent)
       +---------------------- byte0: SIDE
```

| Field | Values |
|-------|--------|
| side (byte0) | `0x01` left, `0x02` right `[CAPTURE]` |
| button (byte1) | model dependent; `0x01` on Buds 4 `[CAPTURE]` |
| action (byte2) | `00` single tap, `02` double tap, `03` triple tap, **`04` long press**, `07` slide up, `08` slide down `[OSS]`+`[CAPTURE]` |
| modifier (byte3) | non-zero on some long presses (`0x08` seen) |
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
- It is **identical for every gesture of the same action + side**, so it does
  **NOT** tell you what the gesture *did*. Two long presses on the right bud — one
  cycling ANC, one triggering voice assistant — produce the same `F1` frame.
- Consequence: the app's `F1` log line is diagnostic only. It is never a control
  signal. The *effect* must come from a separate event (§5) or a query.

### Gesture configuration — researched, NOT implemented

| Direction | Cmd | Payload |
|-----------|-----|---------|
| Read | `0x0108` → `0x8108` | `<status> <count> <4-byte entries>...` `[CAPTURE]` |
| Write | `0x0402` | `<count> [deviceType, button, buttonAction, function]...` `[OSS]` |

Each entry is 4 bytes `[deviceType, button, buttonAction, function]`
(`[OSS]` `Models/KeyFunctionItem.cs`, confirmed on the read side by our capture).
The read reply's 2-byte header is our own finding — see just below.

**The `function` VALUES are UNKNOWN.** That is the one blocking gap, and it is
narrower than it looks: the read half is DONE, only the enum is missing. Two ways to
get it, cheapest first:

1. **Ask the buds, then DIFF.** Send `0x0108` and read the `0x8108` reply; it
   describes the *current* assignment. One reading alone cannot name anything (see
   below), but two readings around ONE change in HeyMelody name that value outright.
2. **Capture HeyMelody.** Change one gesture assignment in the official app and
   log the `TX` frame; that is the write we need to imitate, plus its ack. Only
   needed if the diff in (1) proves unreadable.

Note the source conflict: an `ai-generated/` doc says `0x0401`; `OppoPodsManager`'s
command table says **`0x0402`**. Prefer `0x0402`, and confirm from a capture.

#### Route 1 — ANSWERED. The reply is readable, and the layout guess was WRONG.

`[CAPTURE]` The buds answer `0x0108`, and the reply decodes completely. The capture
is in `local/logs/keyfn-reply-capture.txt`.

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

#### STILL UNKNOWN, AND STILL NOT TO BE NAMED

The `function` VALUES are unread: `0x00`, `0x07`, `0x08`, `0x11`. Reading them off
this one reply is not possible — the app has no idea what its own bindings currently
are, so there is nothing to compare against. `fn` is printed as a **number and never
named**, and no UI may offer a function list yet: a dropdown of guessed values looks
finished while sending the wrong thing, which is the SET-ANC mistake again (§5).

`[GUESS]` Two weak hints, recorded so the next capture can confirm or kill them:
`0x00` on 13 of 18 entries (so, something like "unbound/default"); long press
(`act 0x04`) is `0x08` on BOTH buds, and the slide-ish `act 0x05` is `0x07` on both
— consistent with `fn` being an action-level value.

The `buttonAction` NUMBERS are also unmapped, and they are **NOT** the `0xF1` action
numbers: `F1` calls single tap `0x00` and long press `0x04`, while this reply binds
`0x01` as well as `0x04`. `[GUESS]` `1..6` could be single, double, triple, long
press, slide up, slide down — but that is a guess and stays one.

#### THE ONE CAPTURE THAT FINISHES IT — no HCI snoop needed

`0x8108` describes the CURRENT binding, so **DIFF TWO READINGS**: change ONE gesture
in HeyMelody from a KNOWN value, reconnect our app, and compare the `KEYFN:` lines.
Whichever `fn` byte moves for that button is that function's value, and each further
action can be learned the same way. This is why the reply is now printed GROUPED per
`dev/btn` — the single entry that changed is meant to be visible at a glance.

**Note the write path is not built.** `0x0402` is deliberately not defined as a
constant yet, and `buildPacket()` still lacks LEB128 `TotalLen` (§2), which a
multi-entry write needs. Neither should be added until the enum is known.

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

### Things that look like bugs and are not

- The first RFCOMM UUID failing.
- Two `BTN EVT` frames plus two state events for one physical double-tap: the
  firmware **double-reports**. The app faithfully follows, which looks like a
  flap. Do not "fix" it in the parse path.
- ANC writing and nothing appearing to change: check the **SET** table (§5) before
  suspecting the buds.

---

## 12. Open questions

- `function` enum values for gesture configuration (§6). **Blocks the feature.**
- What `0x0501` / `0x0500` are.
- Broadcast codes `0x04`, `0x08`, `0x0B`.
- The `0x810D` batch status reply layout.
- The `0x8205` ack layout (§4) — only one sample, and it does not obviously echo
  the request.
- Whether `0x0404` supports the `type=2` level-setting form `01 02 <level>` (the
  `[OSS]` doc mentions it for "set noise reduction info") — unverified here.
- Case **lid** state is not reported by any command we know. The app only infers
  it from the socket dropping. Do not claim to support it.
