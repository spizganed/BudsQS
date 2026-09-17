NEXT SESSION — START HERE
=====================================================================

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
   `commit-title-short.txt` / `commit-title-anc.txt` were used.
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

Note the source conflict: the `ai-generated/` doc says 0x0401;
OppoPodsManager's command table says **0x0402**. Prefer 0x0402.

Caution: **TotalLen is LEB128** (PROTOCOL.md §2). A gesture config with
several entries can exceed 127 bytes, so `buildPacket()` will need real
LEB128 encoding before a multi-entry write. Do not ship a long write without it.

### WHERE THE SESSION GOT TO (2026-09-19 late) — step 1 is SHIPPED, UNREAD

Route (a) is coded and in the init sequence. **Nothing is claimed about the reply,
because it has not been seen.** What to do next, in order:

1. **Build and connect, then find the `0x8108` reply.** It is sent last in the init
   sequence, so it is near the top of a fresh Dev Tools log. Three lines print it —
   the raw `RX:`, a `KEYFN:` line, and `LogDecoder`'s description — and **all three
   end with `RAW=[...]`** so the bytes survive even if the parse is wrong.
2. **Read the reply together.** The guards to look for: `!LAYOUT` (the 4-byte entry
   assumption is wrong, i.e. the payload does not begin with a count byte), and
   `parsed=N` disagreeing with `count=M`.
3. **ONLY THEN build gesture UI**, and only for actions that can actually be NAMED.
   A dropdown offering guessed functions is worse than no UI.

**DO NOT** name the `fn=` byte, define `0x0402`, or add LEB128 to `buildPacket()`
until the enum is confirmed. The write path is deliberately unbuilt.

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
- READ `testlogs/layout_*.txt` OR THE WIDGET REPORT BEFORE CHANGING ANY LAYOUT.
- WRITE THE COMMIT MESSAGE TO A FILE. His CodeAssist commit box is too small.
