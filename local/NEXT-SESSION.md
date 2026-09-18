NEXT SESSION — START HERE
=====================================================================

Written 2026-09-18 (night), updated 2026-09-21 (late).
**NEXT FEATURE: gesture configuration — CODE-COMPLETE, ONE NUMBER UNVERIFIED.**

## ⚡ RESUME HERE (2026-09-21 late) — READ THIS BEFORE ANYTHING ELSE

**He restarted his device. Do these in order.**

### 1. TEST `0x0401` FIRST — it is already built and installed
Nothing else needs doing for this. He taps one gesture in our app, changes it to a
DIFFERENT value, then reads the log for:
- `KEYFN WRITE: dev=.. btn=.. act=.. -> 0x..` (what we sent)
- `KEYFN DIFF: ...` immediately after the verify re-read

### 1b. ✅ THE WRITE WORKS — TESTED AND CONFIRMED 2026-09-22
`0x0401` is right. Every write acks (`RX AA 08 00 00 01 84 .. 01 00 00`, payload `00`)
and the read-back shows a real `KEYFN DIFF:` change. **The feature works.** Two bugs he
then found are FIXED and built (see below), and need a retest.

### 1c. THE TWO BUGS HE FOUND — CAUSES FOUND IN HIS LOG, BOTH FIXED
**Log: `local/logs/packets_export_20260918_010608.log.txt` (his app log).**

- **SLIDE did nothing / "only sometimes".** The table went from 18 to **20 entries** and
  slide's slots MOVED OUT of `btn 0x01` into their own groups:
  ```
  18: dev=0x01/btn=0x01[01 02 03 04 06 05]   <- 05 was in here
  20: dev=0x01/btn=0x01[01 02 03 04 06]      <- gone
      dev=0x01/btn=0x02[05:..]  dev=0x01/btn=0x03[05:..]   <- the two slide directions
  **FIRST FIX WAS WRONG TOO.** A hardcoded `intArrayOf(0x02, 0x03)` fixed the RIGHT bud and
  broke the LEFT, because each bud has a DIFFERENT shape — both in one capture:
  ```
  LEFT   19 entries  dev=0x01/btn=0x01[.. 05:07]   slide already bound INSIDE btn 0x01
  RIGHT  19 entries  dev=0x02/btn=0x02[05:00]      slide SPLIT OUT, both halves unbound
                     dev=0x02/btn=0x03[05:00]
  ```
  His log shows `NO SLOT MATCHED for dev=0x01 btn=0x02,0x03`. **Both hardcodes are wrong half
  the time.**
- **AND THE DEVICE CONSOLIDATES — proven by arithmetic in his log.** Writing `0x07` to the right
  bud's two split slots got `Ack for set 0x0401 (status=0x00 = ok)`, then the re-read showed
  `btn=0x01 act=0x05 added: 0x07`, `btn=0x02 removed`, `btn=0x03 removed` — 19 → 18 entries
  (=-2, +1 ✓). **The split is a "two unbound halves" state that the firmware folds back into one
  `btn 0x01` slot once both halves agree.** THAT is why slide worked exactly once and then never
  again: the first write collapsed the shape, so every later write aimed at `0x02`/`0x03` and
  matched nothing.
- ✅ **FIXED PROPERLY AND TABLE-DRIVEN:** `writeGestureBinding(side, keyFnAction, functionByte)`
  takes NO button list from our code. It writes every slot that bud actually has for the action,
  excluding only `BUTTON_ON_CALL_GUESS` (`0x06`), and logs the buttons it matched.
  **`Gesture.keyFnButtons` and `EXTRA_GESTURE_BUTTONS` were removed** — do not reintroduce a
  hardcoded button group; it is wrong by construction.
- **BONUS, and it explains §6.1's "outlier":** slide F1 `byte3` is the function the direction
  RESOLVES to. Slot `0x0A` (switch track) → `0x05`/`0x06` (prev/next); slot `0x07` (volume) →
  **`0x0B`/`0x0C`**. So **`0x0B` = volume up, `0x0C` = volume down** (pairings measured, names
  inferred), and `0x0A`/`0x07` are composites.
- **HOLD is "weird", AND THIS IS NOT FIXABLE IN THE KEY-FUNCTION TABLE.** Clearing its `fn` to
  `0x00` **did NOT stop the ANC cycle** — the next long press still changed the mode and F1 still
  reported `byte3 = 0x08`. The cycle's mode list is firmware-side (two modes here, four earlier,
  same `fn`). **An empty hold selection now sends NOTHING** (writing `0x00` only makes the table
  lie about a gesture that still works). **Every keyfn write is a no-op for the hold's modes — the
  real fix is the separate `0x0404` `setSupportNoiseReduction` command, payload
  `[action=2][noiseType][modeMask LE]`, read back via `0x010C` payloads `02 01`/`02 03`/`02 04`.
  NOT wired — his call on the UI.**

### ⚠️ RETEST NEEDED: slide (now table-driven, so it should work on BOTH buds) and the hold
(it will STILL cycle — that needs `0x0404`, not a keyfn write).

**Why 0x0401:** `0x0402` was sent in a WELL-FORMED frame and the buds ignored it in
total silence (no ack, read-back unchanged). The Melody-derived tables list
`setKeyFunction` at `0x0401` and run 0x0400, 0x0401, 0x0403, 0x0404 — `0x0402` is not
among them. OppoPodsManager only ever mentions 0x0402 **in a comment**, which is how the
wrong number got in. Both numbers are `[OSS]`, so only the device settles it.

### 2. HE IS DOING A BLUETOOTH HCI CAPTURE (vendor app changing a gesture)
**FILE GOES IN `local/logs/`** (git-ignored whole).

**⚠️ I CANNOT READ THE RAW FILE.** `btsnoop_hci.log` is BINARY; `read_file` returns
garbage, not frames. Saving it is only step one — it must be DECODED to the
RFCOMM/SPP payload hex (frames starting `AA`). Options:
  a. **Wireshark on a desktop**: Export Packet Dissections → As Plain Text, filtered to
     Bluetooth RFCOMM.
  b. An **Android app that opens btsnoop** (no desktop needed).
  c. **I BUILD A btsnoop READER INTO DEV TOOLS.** Same class of problem as
     `LayoutReport.kt` (which exists because the agent cannot see screenshots). Scope:
     read `btsnoop_hci.log`, walk HCI ACL → L2CAP → RFCOMM, print payloads starting `AA`.
     **OFFER THIS, DO NOT BUILD IT UNASKED.**
  **Tell him (a)/(b)/(c) up front so he does not capture and then find it unreadable.**

### 3. THE GESTURE ENUM IS NAMEED — DO NOT RE-MEASURE IT
Measured, not guessed, cross-checked against what HE bound (zero contradictions):
`0x00` none · `0x01` play/pause · `0x03` voice assistant · `0x05` prev ·
`0x06` next · `0x07` volume · `0x08` ANC cycle (the hold) · `0x0A` switch track ·
`0x11` game mode. Lives in `GestureAction.functionByte`.

### 4. THE DIFF TOOL IS THE ONLY WAY TO SEE A BINDING — KEEP IT
`KeyFunctionParser.signature()`/`.diff()` + `BudsConnectionManager.keyFnDiff()`, printing
`KEYFN DIFF:`. Baseline is PERSISTED in its own prefs (`QuickBudsKeyFnDiff`) because the
experiment requires a disconnect/reconnect that can restart the process. **An empty reply
never overwrites a good baseline.**

### 5. DO NOT RE-LITIGATE §6.1 — IT IS CONFIRMED
F1 `byte2`/`byte3` ARE the key-function `act`/`function` pair (matched across 5 slots,
5 different values). **I first recorded this as REFUTED and was WRONG** — I used a frame
with `byte2=0x00`, which is not a key-function act at all (acts are 1..6), so it was not
the binding firing. **Do not refute a theory with a sample that may not be the same kind
of thing.** Still diagnostic-only: slides resolve to prev/next while the slot is
"switch track" (unproven), and F1 action `0x00` vs `0x01` is unresolved.

### 6. STILL OPEN, HIS CALL
- **The hold**: in the key-function byte it can only be `0x00` (off) or `0x08` (cycle).
  The four-mode list IS settable but via a DIFFERENT command — `0x0404`
  `setSupportNoiseReduction`, payload `[action=2][type][modeMask LE]`, read back with
  `0x010C` payloads `02 01`/`02 03`/`02 04`. Separate feature; do NOT fold into the save.
- **`btn 0x06`** is probably the on-call group (every entry `fn=0x00`). He may test it.
  He does not plan to implement on-call. Our writes send the whole table back untouched.
- **`0x0500`/`0x0501`** have EMPTY payloads, so they CANNOT be gesture bindings.

### 7. DOCS — ONE PASS, ONLY WHEN THE FEATURE IS DONE
Per his rule (2026-09-21) docs are updated ONCE at the end, with a commit. **Not yet.**
Known drift to fix then:
- `ROADMAP.md` says the `0x8108` reply "has not been read yet" (3 places) — it was read.
- `PROTOCOL.md` §6.1 says `[CONTENDED]` — it is now CONFIRMED (and my "refuted" detour
  should be recorded as the lesson it is).
- `PROTOCOL.md` §6 + this file over-warn about LEB128 (18 entries = 80, one byte).
- `PROTOCOL.md` §5 should gain `0x0404`'s two roles (`setCurrentNoiseMode` vs
  `setNoiseReductionInfo`).

### 8. THEN A COMMIT
Latest message staged in `local/commits/commit-title-anc-log.txt` is about the ANC log
work and is now PARTLY STALE (it predates the enum + the write). **Rewrite it.** Keep it
to ~10-12 lines, under ~450 chars, every line ≤ 72 chars, and tell him to PASTE FROM THE
FILE — chat code blocks truncate.

---

Written 2026-09-18 (night), updated 2026-09-19 (late).
**NEXT FEATURE: gesture configuration.** See the section below.

## STEP 0 DONE — 2026-09-19. What was checked, and what was wrong.

Run again anyway if time has passed, but this is the state as of the above date:

- Checked `PROTOCOL.md` §3 command numbers against `OpoProtocol.kt` — **agreed.**
- Checked §5's **two ANC tables** vs `ancPayload()` and `AncEventParser.modeForRaw()`
  — **still deliberately different** (SET bit 0 Off / bit 2 Trans; NOTIFY bits 3 and
  8). No unification, no regression.
- Checked §4's init sequence vs `BudsConnectionManager.runInitSequence()` — agreed.
  `0x0108` was then APPENDED to the sequence (see below), and §4 was updated in the
  same edit to list 9 steps, so doc and code still match. Step 9 is tagged `[GUESS]`
  there because whether the buds answer it is unknown.
- **Drift found and fixed, two places:**
  1. `OpoProtocol.registerNotifications()`'s comment still ended "NOT YET CONFIRMED
     ON DEVICE" long after he confirmed it. Now records the 2026-09-19 confirmation.
  2. **`ROADMAP.md` was badly stale on ANC** — row 4b, row #19, the execution-order
     block, "Next up", and the UI-debt table all still asserted *"ANC raises no push
     event (verified 3x)"* and listed ANC gesture sync as unfinished. All superseded
     by his verified result. Corrected, with the wrong claim kept visible rather
     than deleted, because the way it was wrong is the lesson (PROTOCOL.md §5).

## STEP 0 — CHECK THE MDs ARE UP TO DATE (he asked for this explicitly)

Do this before writing any code:

1. `git log --oneline -5` and `git status` — is the tree clean? Are the
   2026-09-18 commits actually in, or still uncommitted? Check whether
   `local/commits/commit-title-short.txt` / `commit-title-anc.txt` were used.
2. Read, in this order: **`PROTOCOL.md`**, **`CREDITS.md`**, this file, and the
   memory note.
3. **Cross-check the docs against the CODE.** A doc that disagrees with the code
   is worse than no doc, because it will be trusted. Specifically:
   - `PROTOCOL.md` §3 command numbers vs `OpoProtocol.kt`
   - **§5's two ANC tables** vs `ancPayload()` and `AncEventParser.modeForRaw()`
     — these MUST still differ from each other. If someone "unified" them, that
     is a regression.
   - §4's init sequence vs `BudsConnectionManager`
   - anything marked `[GUESS]` that a later session resolved
4. Fix any drift, and say what you checked. Correcting a stale doc IS a
   deliverable — the whole point of writing it down was so it could be trusted.

## STATUS: EVERYTHING SHIPPED SO FAR IS VERIFIED ON DEVICE (2026-09-19)

He confirmed all of this himself, after the last rebuild:

- ANC Off / Light / Medium / High / Transparency all apply, and the right circle
  lights. **The SET-table regression is gone.**
- Trans works, audibly.
- A bud gesture updates the app circles AND the widget.
- **He REBOUND a gesture on the right bud to a different mode cycle and the app
  followed it.** Strongest possible confirmation the push path is sound: the app
  tracks real bud state, not just echoes of its own commands.
- Tapping in the APP updates the WIDGET (the one-way sync bug is fixed).

Do not re-open any of that unless something regresses. There is nothing to
verify right now — go straight to the feature.


## THE FEATURE: GESTURE CONFIGURATION IN OUR APP

**His goal, in his words:** manage the gesture bindings from our app, so he does
not have to rebind them in HeyMelody.

Commands are known. ONE gap blocks it.

    Read   getKeyFunction  0x0108  -> 0x8108   payload <count> <deviceType...>
    Write  setKeyFunction  0x0402             payload <count> [deviceType,
                                              button, buttonAction, function]...

**THE BLOCKING GAP IS THE `function` ENUM** — which value means "ANC cycle",
which means "game mode", which means "voice assistant". Nobody publishes it.
**DO NOT GUESS IT.** Guessing ANC bits already cost us a regression.

Cheapest path first:

    a. Send 0x0108 and read the 0x8108 reply. It describes the CURRENT
       assignment, so it may hand us the enum directly, from the device.
       TRY THIS FIRST — one query, no HeyMelody capture needed.
    b. Only if (a) is opaque: capture HeyMelody changing ONE gesture
       assignment, and read the TX frame plus its ack.

    b2. BEFORE GOING TO A BLUETOOTH CAPTURE, TRY THIS — it needs no capture at all.
       HeyMelody holds the single RFCOMM socket, so OUR app cannot log what it
       sends; that is why (b) implies an HCI snoop log (Developer options ->
       Bluetooth HCI snoop log), which normally wants Wireshark on a DESKTOP and
       this project is MOBILE-ONLY. So:
         1. close OUR app / disconnect it (HeyMelody needs the link)
         2. change ONE gesture in HeyMelody, e.g. set double tap to "next track"
            when it was "play/pause" — from a KNOWN previous value, so the diff
            is unambiguous
         3. reconnect OUR app and READ THE 0x8108 REPLY AGAIN
       If the reply shows the new binding, it handed us the enum for that action
       without any capture, and each extra action can be learned the same way.
       This ONLY works if (a) is readable — if 0x8108 is opaque, skip to (b).

Note the source conflict: the `ai-generated/` doc says 0x0401;
OppoPodsManager's command table says **0x0402**. Prefer 0x0402.

Caution: **TotalLen is LEB128** (PROTOCOL.md §2). A gesture config with
several entries can exceed 127 bytes, so `buildPacket()` will need real
LEB128 encoding before a multi-entry write. Do not ship a long write without it.

### WHERE THIS GOT TO (2026-09-20) — REPLY READ, LAYOUT FIXED, ENUM STILL UNNAMED

Route (a) is coded and in the init sequence, AND the reply has now been read.

**The reply decodes, and our layout guess was WRONG.** The payload is
`<status> <count> <4-byte entries>...` — a LEADING STATUS BYTE that
`KeyFunctionItem.cs` does not model. Reading `payload[0]` as the count is an
off-by-one that printed `!LAYOUT`. `KeyFunctionParser.HEADER_SIZE = 2` now, and the
first good capture is in `local/logs/keyfn-reply-capture.txt` (74 bytes = 2 + 18*4).

What to do next, in order:

1. **DIFF TWO READINGS — that is the whole remaining task for the enum.** The app
   has no idea what its own current bindings mean, so one `0x8108` reading cannot
   name its own values. Change ONE gesture in HeyMelody, reconnect our app, and
   compare the two `KEYFN:` lines. The `fn` byte that moved IS that function's value.
   **Do it from the UNBOUND side, not the bound one:** 13 of the 18 entries read
   `fn=0x00`, so a `0x00` that moves is unambiguous where a swap of two bound values
   is not. **`[USER]` RIGHT double tap currently reads `fn=0x00`, and game mode is
   offered on double/triple tap — set right double tap to Game Mode.** That is the
   cleanest first diff: one `0x00` should move, and it becomes Game Mode.
2. **Then, and only then, fill in the action bytes** in `GestureAction` and send the
   write. Until the names are known the screen stores its choices on the phone only,
   and says so on screen in plain words.

**TWO TRAPS ON THAT DIFF, `[USER]`-sourced, both of which already looked like real
experiments (corrected 2026-09-21):**

- **DO NOT diff the hold.** HeyMelody offers the hold *only* the ANC modes
  (`ANC on`, `Adaptive`, `Transparency`, `ANC off`); game mode is offered on double
  and triple tap only. So a hold rebind cannot vary `fn` in a way the ANC cycle does
  not already cover, and "rebind the hold to game mode" is not a thing that can be
  done. A no-change result would look like a finding and be nothing.
- **"ANC on" is a SLOT, not a level.** He expects that stop to re-apply the last
  *manually* chosen level, and §5's captures agree (`0x0040` that day, `0x0010` /
  `0x0020` on others). So name the slot if the diff moves it — never record
  "fn=0xNN = ANC on" as if it selected a level.

The hold constraint is worth noting against our own UI: `GestureConfig.actionsFor()`
already gives `TAP_HOLD` the four ANC actions and nothing else, and `GAME_MODE` to
double/triple tap only — arrived at independently, and it matches. **Not ours to
widen.**

**§6.1 adds a second, cheaper unknown.** `[CONTENDED]`: `F1` byte3 (called
"modifier" by the OSS source) may actually be the FUNCTION — on both buds' holds it
equals the reply's `fn=0x08`. If true the buds tell us what a gesture does, live, and
no `0x8108` round trip is needed. It is not a finding, because **every `F1` sample we
own is a hold** — one gesture, seen repeatedly. A single `F1` line from a **double
tap**, read against the reply's `act=0x02` entry, settles it. That line is worth
grabbing during the same session as step 1.

**DO NOT** name the `fn=` byte, define `0x0402`, or add LEB128 to `buildPacket()`
until the diff confirms them. The write path is deliberately unbuilt.

The `KEYFN:` line is now printed GROUPED per `dev/btn` (`dev=0x01/btn=0x01[...]`) so
the one entry that moved between two readings is visible at a glance — that grouping
exists for step 1 and nothing else.

### THE GESTURE UI IS BUILT — what exists, and what it refuses to do

`ui/GestureActivity.kt` + `ui/GestureConfig.kt`, opened from a new home-screen row
**"Earbud controls"** above App update.

- Bud icon, then **Left / Right** chips — the two buds are configured separately.
- **"When not on call"**, then one row per gesture. **There is no on-call section,
  by request**; do not add it as an empty one.
- Tapping a row opens the app's own **bottom sheet** (`BottomSheetDialog`) with the
  actions that gesture may take, exactly as specified in `actionsFor()`.
- **Tap-and-hold is multi-select and cycles.** It must have none, or at least two —
  never exactly one. The rule is explained only when Done is pressed with exactly
  one selected, and the message clears as soon as the selection is valid.
- Gesture row summary uses SHORT labels ("ANC, Adapt, Trans, Off") so the row keeps
  the same height as its neighbours; the sheet itself uses the full names.
- **`GestureAction` carries a LABEL and NO PROTOCOL BYTE.** That is the deliberate
  placeholder: the write needs the enum, and a guessed value is the mistake that
  already cost this project one regression.

Suggested shape for the session (keep it small):

1. Add `queryKeyFunction()` (`0x0108`) and log the `0x8108` reply RAW.
   Ship that alone if budget is tight — cheapest way to learn the layout, and
   it is read-only so it cannot break anything.
2. Read the reply with him, then decide.
3. Only then build UI, and only for gestures/actions we can actually NAME. A
   dropdown offering functions we guessed is worse than no UI.


THE REST OF THE QUEUE
---------------------------------------------------------------------
- LAUNCHER / PACKAGE ICON from his three SVGs. `ic_launcher_foreground.xml`
  still traces the OLD bud artwork. Needs a layer-list + safe-zone scale —
  the same ratio math that ate a whole night on the widget buds.
  **ITS OWN SESSION.**
- LIGHT THEME REMOVAL — decided, not started. Mostly deletion.
- targetSdk 35 edge-to-edge warning. Bundle with light-theme removal.
- Case LID is NOT readable. The case ICON must stay visible regardless.
- Undecoded families: `0x0501`/`0x0500` (seen after ANC writes, may be this
  firmware's alternate ANC notification), broadcast codes `0x04`/`0x08`/`0x0B`,
  and the `0x810D` batch-status reply layout. PROTOCOL.md §12 lists them.


DOCS — KEEP THEM CURRENT
---------------------------------------------------------------------
- **PROTOCOL.md** — the wire format. Tag every claim `[VENDOR]` / `[OSS]` /
  `[CAPTURE]` / `[GUESS]`. **Update it in the same commit as a protocol change.**
  Its §5 "History of Getting This Wrong" and §11 "Method" exist on purpose.
- **CREDITS.md** — whose work we rely on, area by area. **Add a row when you add
  a constant.** Also lists what is original to this project.
- `NEXT-SESSION.md` (this file) — the plan.


PROCESS NOTES THAT SAVED REAL TIME
---------------------------------------------------------------------
- **A `when` on UI string keys with NO `else` is a silent-failure generator.**
  The Transparency bug was `"Trans"` vs `"Transparency"` and hid for weeks.
  Also check for a state write with no matching refresh call — that was the
  widget one-way sync.
- **REVERT FIRST, REASON AFTER.** He reported the game-mode flap and asked for a
  revert; arguing cost a session. His later log cleared our code, but the revert
  was still right. Do the revert, then investigate.
- **His screenshots are PNGs — the agent CANNOT read them.** One sentence from
  him replaced an entire diagnostic loop. Ask for the sentence.
- **`search_text` returns false negatives.** It reported "No matches" for
  `onAncCircleTapped`, which exists. Read the file.
- **`get_diagnostics` can say "No diagnostics" on a file that fails to compile**
  (missing import across packages). After a cross-package call, run the BUILD.
- `noteUnattributed` blanket-excludes cmd 0x0204, so an undecoded 0x0204 subType
  prints NOTHING. That hid the ANC frame for three captures.
- READ `local/logs/layout_*.txt` OR THE WIDGET REPORT BEFORE CHANGING ANY LAYOUT.
- WRITE THE COMMIT MESSAGE TO A FILE. His CodeAssist commit box is too small —
  see below for where it goes and the size limit.


WHERE FILES LIVE NOW (moved 2026-09-19)
---------------------------------------------------------------------
Everything that does not belong on GitHub is under **`local/`**, which is ignored
WHOLE — drop a new file in and it needs no `.gitignore` edit.

    local/commits/     commit messages for `git commit -F`
    local/crashlogs/   crash reports off the device
    local/logs/        packet logs + layout reports   (was testlogs/)
    local/notes/       HANDOFF.md, GRADLE-EXPORT.md, the gesture-capture brief,
                       QUESTIONS.md
    local/svgs/        the source SVGs the wear icons were traced from (was svgs/)

**THE COMMIT MESSAGE GOES IN `local/commits/`.** Still the same rule as before:
keep it to ~10-12 lines and under ~450 chars, every line ≤ 72 chars, and tell him
to PASTE FROM THE FILE — chat code blocks truncate.

Deliberately STILL TRACKED at the root: `README.md`, `PROTOCOL.md`, `CREDITS.md`,
`ROADMAP.md`, `LICENSE`. Those are the public record.

**THIS FILE NOW LIVES IN `local/` TOO** (moved 2026-09-19), so it is git-ignored
like the rest. That means it does NOT travel with the repo any more — if the
project is ever cloned somewhere else, this plan is not in it. It was moved on
purpose: it is a working note, not project documentation. Keep reading and
updating it here.
