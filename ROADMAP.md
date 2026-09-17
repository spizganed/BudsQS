## QuickBuds (BudsQS) - Development Roadmap & Priority List

> Living document. Updated as items complete or priorities shift.
> Last updated: 2026-09-22 (FIFTH pass — **gesture configuration is DONE and verified on the
> device.** The `function` enum was MEASURED rather than guessed, the write is `0x0401` (not
> `0x0402`, which the buds ignore in silence), and two real bugs he found are fixed: slide wrote to
> a button group its slots had moved out of, and the hold's function byte does not control the ANC
> cycle. **This file said the `0x8108` reply "has not been read yet" in two places long after it had
> been** — that staleness is a large part of why the enum hunt took as long as it did, and it is
> recorded rather than quietly deleted.)
> THIRD pass 2026-09-19 — `NEXT-SESSION.md` moved into `local/` and is now
> git-ignored too, along with everything else in that folder; all doc references to the old
> `testlogs/`, `svgs/`, `HANDOFF.md`, `GRADLE-EXPORT.md` and `screenshots/` paths corrected.
> SECOND pass same day: gesture UI built, app-owned bottom sheets, connect controls moved to
> Dev Tools, `local/` folder created. FIRST pass: ANC gesture sync VERIFIED — the "ANC has no
> push event" claim was wrong, see #19; gesture-config route 1 shipped (0x0108 query +
> KeyFunctionParser). Previous: 2026-09-17 battery icon alignment fixed + verified; 50:50
> battery card, icons 52dp; layout-report dev tool; Q2/Q3/Q4 answered; Light theme slated for
> removal)

## Working principles

- Mobile-only workflow: Nothing Phone (3a), Android 15, CodeAssist, Termux, GitHub mobile.
- AI (Kimi) handles heavy logic: reverse-engineering, parsers, protocol work.
- Human handles: device testing, Termux commands, git operations, design decisions.
- Feature philosophy: **only what I want** - every new idea is filtered through this list before any work starts.
- North star for 1.1: **match the original HeyMelody functionality as much as possible**, with our smart-pause improvements on top.
- App identity: package `com.spizganed.quickbuds` (final, already in place). App name: **QuickBuds** (working name, may still change).
- No desktop Android Studio. Ever.

## Priority 1 - Foundation & debugging - DONE

| #| Item| Status|
| ---| ---| ---|
| 1| Packet logging foundation - all received AA frames + sent commands, timestamped| Done|
| 2| Bud icon states on widget (hidden in case / grey out-of-ear / white in-ear)| Done|
| 3| Battery rows: always show last known values, update on every hardware packet (poll or pushed event); hidden only while disconnected. No manual refresh - react as fast as hardware allows| Done + spec locked 2026-09-15|

## Priority 2 - 1.1 release content

| #| Item| Why / when| Est. time| Type|
| ---| ---| ---| ---| ---| ---| ---|
| 4| **Widget wear-change latency** — DONE. Root cause was `0x0205`'s payload: it is count-then-event-ids, and the old literal `01 01 02 02` registered battery only, so wear was never pushed and lagged a 5s poll. Sending `02 01 02` registers battery + wear. Icons now react in milliseconds; residual ~2s is the bud's hardware debounce| Icons felt poll-bound and inconsistent (0-4s). Push makes it feel instant| Done| Quick|
| 4b| **Battery + Game Mode push, and poll trim** — DONE 2026-09. Long captures proved (a) battery pushes on change and no `poll status` reply EVER contained a battery byte, so the 60s poll is now a pure keep-alive; (b) Game Mode is pushed as `0x0204` subType `0x05` and fires on BUD-SIDE gestures too, so the widget/app buttons now track the earbuds. Battery resolution is tens (100/90/80) — a firmware trait, confirmed against the reference implementation which reads the bytes raw. ~~**ANC has no push event at all** (verified 3x)~~ **SUPERSEDED 2026-09-19 — that was WRONG.** ANC *does* push, as `0x0204` subType `0x03`; the belief survived three captures because the frames were arriving undecoded and `noteUnattributed` printed nothing for them (PROTOCOL.md §5, "History of Getting This Wrong"). See #19. Earlier note kept for the record: the main-screen redesign made a compact capped panel with a reserved `featureList` area below it for the upcoming controls (dual device, spatial audio, codec, EQ, find my earbuds)| Completes the push story and frees the poll; unblocks the feature rows| Done| Medium|
| 5| **FGS notification**: AUDITED 2026 — already optimal. Channel is `IMPORTANCE_MIN`, no badge/lights/vibration/sound, `PRIORITY_MIN`, `ongoing(false)` so it is swipeable. Android 15 requires it for a `connectedDevice` FGS; no setting removes it. The only true fix (dropping the persistent connection) would cost the instant push updates. **Leave as is.** | Serves no user purpose; annoying. Not officially supported on Android 15 - spike| 30 min| Spike|
| 6| **Adaptive app icon** — DONE (redone 2026-09). Traced `ic_bud_left`/`ic_bud_right` paths reused verbatim via group transforms, monochrome white on black, buds side by side. Geometry is **solved, not eyeballed**: the adaptive safe zone is a circle of radius 33 centred on (54,54), so the binding constraint is each ink corner's distance from the centre. Final scale S=0.756 puts the worst corner at 94.1% of the safe radius (S=0.62 filled only 77.5% and looked undersized). Added an explicit `monochrome` layer for themed icons to stop the launcher synthesising one. Deleted the legacy `mipmap/ic_launcher.xml` layer-lists and the shadowed `ic_launcher_foreground.png`. Widget preview decoupled from the launcher icon via new `drawable/widget_preview_buds.xml` — **note it is a separate copy and must be updated alongside `ic_launcher_foreground.xml`.** Also added `ic_stat_buds` for the FGS notification (was the generic `stat_sys_headset`)| Replaces placeholder; Nothing OS was wrapping the icon in a white circle| Done| Medium|
| 7| **Dev Tools screen** - DONE. Separate in-app screen with (a) a human-readable log ("L bud: in ear", "ANC -> Deep", "Battery L=70"), (b) a raw-hex log, plus hold-to-copy on the current tab and export-to-file via MediaStore Downloads. Mark / Clear / Export all live here, so the main screen carries no log at all — status events there are silent by design. **An earlier revision toasted them, which stormed the UI because several call sites fire once per packet; do not put user-visible output on a packet listener.**| Raw log is hard to read; also the diagnostic tool for #4| Done| Medium|
| 8| **Auto play/pause, two phases**: (a) firmware toggle button in app UI (autoPlayPauseOn/Off commands already exist in manager), near ANC/Game Mode or in settings; (b) Smart Pause v2 - app-handled: both buds out -> pause; single out -> keep playing; never auto-resume; never fight manual user playback. Latency target 0-250 ms, depends on #4| Firmware version resumes accidentally when holding a removed bud; software rules fix it| a: 30 min / b: 2-3 h| Quick + Medium|

### Priority 2 follow-ups (added 2026-09-16)

| #| Item| Why / when| Est. time| Type|
| ---| ---| ---| ---| ---|
| 18| **Settings-card rows + secondary screens** — DONE 2026-09-16. The reserved `featureList` area is now a real card: Game Mode (live, driven by the pushed `0x0204` subType `0x05`), Hi-Res codec (preference toggle only — the feature id is not captured, see below), spatial audio (legacy feature `0x1B`), Equalizer, Find my earbuds, App update. Rows are built in code by `ui/SettingRowFactory.kt` (one place for row shape + themed icon tint) instead of six near-identical XML blocks. New screens: `ui/EqActivity.kt`, `ui/FindBudsActivity.kt`, `ui/UpdateActivity.kt` (never auto-updates), `ui/ChimePlayer.kt`, `ui/SegmentedBarDrawable.kt` (number drawn inside the bar), `bluetooth/KeepAliveReceiver.kt`| Parity with the original app's settings list; the main screen needed real content below the battery block| Done| Medium|
| 19| **ANC gesture sync** — DONE + VERIFIED ON DEVICE 2026-09-19. The premise ("ANC raises no push event, verified 3x") was **WRONG**: ANC pushes as `0x0204` subType `0x03`, payload `03 01 01 LO HI`. The frames had been arriving all along; `noteUnattributed` blanket-excluded cmd `0x0204`, so an undecoded subType logged nothing and it read as silence. The subscribe also had to include event `0x03`. No poll and no `0x810C`-after-gesture was needed. Value is the buds' own ANC bitmask (bit `index` set), NOT a three-value enum — see PROTOCOL.md §5, and "History of Getting This Wrong" there| ANC set from the buds must be reflected in the widget/app circles| 1-2 h| Medium — DONE|
| 20| **Hi-Res codec honesty** — the row currently toggles only its own subtitle; no codec set/get command has been captured on this firmware. Needs a capture of the reference implementation to find the feature id (LHDC). Until then the row is deliberately a preference stub, not a lie| A switch that silently does nothing is worse than one that is honest| 1-2 h + capture| Spike|
| 21| **Layout-report dev tool** — DONE 2026-09-17. `devtool/LayoutReport.kt` writes the measured view tree as TEXT (bounds, weights, margins, padding, gravity, text size/style/colour, drawable intrinsic vs actual) plus a `SIBLING GAPS` section, because the AI agent **cannot read images** and `screenshots/*.png` are opaque to it. MainActivity parks a report in `onResume`; Dev Tools reads it (cached or live) and it lands in `local/logs/`. This is now the primary way layout bugs are diagnosed, and it is what made the icon fix verifiable rather than a guess. `collectGaps` must report DIRECT children only, each container against its own origin and on its own axis — two earlier versions broke this (see `local/notes/HANDOFF.md`)| Descriptions of a layout ("the card looks too close to the header") failed because the agent had to guess which of ~30 view ids was meant, and a wrong guess cost a build cycle| Done| Medium|
| 22| **Battery icon alignment** — DONE + VERIFIED 2026-09-17. He reported "the icons are misaligned different sizes". Every measured *box* was correct and every aspect ratio matched, so all the obvious suspects were innocent. The cause was **fill fraction**: the case was a 48x40 viewport on a 1:1 slot (ellipse edge to edge, 100% fill) while the buds were inset to ~79% of their viewport, so a case unit was 48/48dp against a bud's 40/48dp — it drew ~20% larger per unit and sat on a different optical line. Fixed by rescaling `ic_case.xml` to the buds' ~79% fill on a shared 48x48 viewport. Confirmed by measurement: equal gaps either side of the case (`0.0dp`/`0.0dp`; previously 114px vs 135px). **If one icon's frame or insets change, the others must be rescaled to match or this returns**| Visible on every screen, every session| Done| Medium|
| 23| **Battery card 50:50 + bigger icons** — DONE (built 2026-09-17, not yet captured). Halves were `weight 0.8 / 1.2`; now `1 / 1` so the icon side gains ~33dp. Icons 40dp -> 52dp (`battery_bud_size`, `battery_case_width`, `battery_case_height`). **The on-device result is verified arithmetically but not visually** — capture a layout report to confirm. If the card (now ~12dp taller) squeezes the feature list, trim `battery_card_padding_v` (24dp) rather than shrinking the icons| He wanted more room on the left and larger icons| Done| Quick|
| 24| **Remove the Light/white theme** — DECIDED 2026-09-17: he does not use it and it "introduces problems". It is the source of two recurring awkward cases (white L/C/R letters and a white in-case state are both invisible on a light background) and it is a whole colour-qualifier branch to keep in sync. Touches `ThemeRes.kt` (LIGHT = 2, the three-style selection), the `Theme.App.Light` style, and the light colour qualifier files. **Not started — do not begin until asked.** Once gone, the theme-aware colour logic in Q2/Q4 becomes simpler| Fewer moving parts; removes a class of invisible-on-light bugs| 1-2 h| Medium|

## Priority 3 - Features & research (parity with original app)

> NOTE: this list was originally written from HeyMelody screenshots. That folder is
> **deleted** (see the UI-debt table) — the agent cannot read images, so anything
> still needed from it must be described in words. The rows below are kept as the
> record of what was asked for.

| #| Item| Details from the original app| Est. time| Type|
| ---| ---| ---| ---| ---| ---| ---| ---| ---| ---|
| 9| **Easy parity batch**: spatial sound switch (commands exist), find my earbuds (loud beep), alert-sound volume slider (More settings shows it as a slider), game mode done| Quick wins, commands mostly exist — the switch, beep screen and game mode are already in (2026-09-16); the volume slider is not| 2-3 h| Medium|
| 10| **Medium parity batch + spikes**: dual device ("connect 2 devices and switch"), ANC-Smart behavior (spike: app adapts or buds themselves?), Hi-Res mode (switch BT codec - LHDC; the original app shows a simple toggle), earbud fit test (unknown)| Listed for parity| spikes 30 min each| Spike -> Medium|
| 11| **Hard parity batch - EQ + Golden Sound + controls**: EQ = 6 bands (62/250/1k/4k/8k/16k Hz), +/-6 dB, presets (Balanced/Clear Vocals/Bass), custom presets with rename, BassWave dynamic-bass toggle + intensity slider. Golden Sound = one-time hearing test, likely produces an EQ profile. Earbud controls = per-bud single/double/triple tap + slide + touch&hold — **DONE and writing to the buds (see #26)**; what remains from this row is EQ / Golden Sound. The on-call section is deliberately NOT implemented and never will be, by his decision| Complex, long-term; needs packet research vs reference projects| many hours| Big|
| 12| **Case lid state research**: read Leaf-lsgtky/OppoPods + Zhaoyi-ya/OppoPodsManager - do buds/case report lid open/closed (0x8105 ear-status bit 0x04?)? KEEP current case code + ic_case.xml until resolved. Note: verified HeyMelody also cannot read case battery when buds are out + lid closed| Case icon comeback depends on this; parked by user decision 2026-09-15| 1-2 h research| Spike|
| 13| **Lock screen widget** feasibility research (Android 15 / Nothing OS)| Worth a peek, low importance| 30 min| Spike|

## Priority 4 - Before release

| #| Item| Why / when| Est. time| Type|
| ---| ---| ---| ---| ---| ---| ---| ---|
| 14| Credits section - in-app + README: Leaf-lsgtky/OppoPods, Zhaoyi-ya/OppoPodsManager, tools, thanks. GPL-3.0 obligation| Ships with 1.1| 1 h| Quick|
| 15| Source cleanup pass - unused files/dead code (ic_case.xml stays - parked per #12), verify .gitignore. **Partly done 2026-09-19 via #25** — the root is cleaned up and `.gitignore` now covers `local/` whole; dead-code removal still outstanding| Before redesign| 1-2 h| Medium|
| 25| **`local/` folder + .gitignore** - DONE 2026-09-19. All working material moved under one ignored folder: `local/NEXT-SESSION.md` (the plan — moved at his request, so it no longer travels with a clone), `local/commits/`, `local/crashlogs/`, `local/logs/` (was `testlogs/`), `local/notes/` (HANDOFF, GRADLE-EXPORT, the gesture-capture brief, QUESTIONS), `local/svgs/` (was `svgs/`). `local/` is ignored WHOLE, so a new file dropped in needs no `.gitignore` edit. `screenshots/`, `testlogs/`, `svgs/` and `crashlog/` are DELETED. Only README / PROTOCOL / CREDITS / ROADMAP / LICENSE remain tracked at the root| The root had grown a file-per-purpose; one ignore rule beats a list of one-off patterns| 30 min| Quick|
| 26| **Gesture configuration** ("Earbud controls") — **DONE + VERIFIED ON DEVICE 2026-09-22. IT WRITES.** `ui/GestureActivity.kt` + `ui/GestureConfig.kt`, opened from a home-screen row above App update: bud icon, Left/Right per-bud selector, "When not on call", one row per gesture. `actionsFor()` holds exactly the permitted actions. **Tap-and-hold is multi-select and must have none or at least two** — explained only when Done is pressed with exactly one. Selections persist per side AND gesture. **The `function` values are MEASURED, not guessed** (`GestureAction.functionByte`), obtained by diffing two `0x8108` readings around changes he made — the app prints `KEYFN DIFF:` for exactly that. The write is **`0x0401`** (NOT `0x0402`, which the buds ignore in total silence), and every write re-reads the table and diffs it because a wrong command number fails silently. It listed "not yet read" here long after it HAD been read; that staleness is why the enum hunt took as long as it did. **Two known bugs, both fixed 2026-09-22** — slide wrote to a button group its slots had moved out of, and the hold's function byte does not actually control the ANC cycle (that needs the separate `0x0404` command). See PROTOCOL.md §6| He wants to manage gesture bindings without HeyMelody| built across 3 sessions| Medium — DONE|
| 16| ~~Package rename~~ - CLOSED: package is already `com.spizganed.quickbuds`; app name QuickBuds pending final decision with #6| -| -| -|

## Priority 5 - The final step

| #| Item| Why / when| Est. time| Type|
| ---| ---| ---| ---| ---|
| 17| **Full app UI v1.1** - bottom navigation (Device / Earbud controls / About) exactly like the original app's structure, mimic finished widget style, only wanted functions, hosts features #9-#11 as they land| Last by design| full day+ across sessions| Big|

## Execution order

```
4b -> 7 -> ANC gesture sync (#19, DONE + verified) -> gesture configuration (#26, DONE +
verified 2026-09-22) -> icon rework (his brief)
-> #24 remove Light theme -> dual device / codec feature ids (capture first)
-> 5 -> 8a -> 9 (easy batch: alert-sound volume slider)
-> widget colour states (Q4 rule) -> 8b (needs #4) -> 10/12/13/6? spikes anytime
-> 14 -> 15 -> 17 (with 10/11 slotted in as the UI grows)
```

Next up: **finish the gesture feature's leftovers, then replace the remaining placeholder rows.**
The `function` enum is no longer a blocker — it was MEASURED (see #26 and PROTOCOL.md §6), and the
write is confirmed working on the device. What is left:

1. **The hold is not a normal binding.** Its function byte does not control the ANC cycle: clearing
   it to `0x00` did not stop the cycle, and its mode list lives in the separate
   `setSupportNoiseReduction` (`0x0404`) command, which is still unwired. Needs a decision on the UI
   (an on/off, or the mode picker wired properly).
2. **Slide's two directions** (`btn 0x02` / `btn 0x03`) are written with the same action because
   which is up and which is down is not yet known. Harmless, and worth establishing.
3. **The remaining placeholder rows** — Hi-Res codec, spatial audio, EQ, find-my-earbuds (#9/#10).

**Icon rework (his brief) is still pending** and is its own session.

## Known UI debt (honest list, 2026-09-17)

Everything below is working but not finished. None of it blocks a release; all of it is
visible to a new user.

| Area | What is unfinished |
| --- | --- |
| 50:50 card + 52dp icons | Built and installed 2026-09-17, but **not yet captured** — the arithmetic is checked, the on-device result is not |
| Hi-Res codec row | Toggles only its own subtitle. No codec command is captured, so it does not change the stream (see #20) |
| Spatial audio row | Wired to the legacy feature `0x1B`; the newer three-mode `0x0422` may be what this firmware honours. Unverified |
| Equalizer screen | Placeholder destination: presets are not yet sent to the buds |
| Find my earbuds | Opens the buds' locate flow; volume/duration are not tunable |
| ~~ANC sync~~ | **RESOLVED (#19, verified 2026-09-19)** — the circles follow bud-side gestures |
| Widget colour states | The Q4 rule (in-ear full strength, out-of-ear grey, in-case full strength, all theme-aware) is decided but **not implemented in the widget** — the app-side icon fix did not touch it |
| Light theme | Still present and still a source of invisible-on-light bugs; slated for removal (#24) |
| Localisation | All user-facing text is in `strings.xml` but only `values/` (English) exists. Hardcoded strings remain in `MainActivity` dialogs (crash report, Bluetooth permission dialog), the Dev Tools labels and legend, and `BottomSheetDialog` callers |
| ~~README screenshots~~ | **REMOVED 2026-09-19** — the `screenshots/` folder is deleted. It was doubly useless: the images predated the redesign, and **the agent cannot read them anyway.** Use a layout report for anything geometry-related (#21) |

### Resolved since the 2026-09-16 list
- ~~Main screen polish — never confirmed visually~~ **Now confirmed via layout reports**: battery
  card geometry, the three ANC buttons (52.2dp tall, ~118dp wide), the header and the feature rows
  and dividers all check out. See #21 for how, and use it for any future visual complaint.
- ~~Battery icon alignment~~ — fixed and verified (#22).

## Credits (draft for #14)

### Reference projects (protocol reverse engineering)

- **Leaf-lsgtky/OppoPods** - OPPO earbud protocol reverse engineering
- **Zhaoyi-ya/OppoPodsManager** - OPPO earbud protocol reference and feature implementation

QuickBuds is licensed GPL-3.0, same as both projects above.

### Tools

- CodeAssist IDE (Tyron) - development
- Termux - terminal, scripting, icon processing
- decompile.com - HeyMelody decompilation
- Brave browser, Google Files, hex editor - research & inspection
- GitHub mobile - repo management
- Kimi (Moonshot AI) - AI-assisted development
