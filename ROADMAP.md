## QuickBuds (BudsQS) - Development Roadmap & Priority List

> Living document. Updated as items complete or priorities shift.
> Last updated: 2026-02-14 (wear push fix)

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
| 4| **Widget wear-change latency** — DONE 2026-02-14. Root cause was `0x0205`'s payload: it is count-then-event-ids, and the old literal `01 01 02 02` registered battery only, so wear was never pushed and lagged a 5s poll. Sending `02 01 02` registers battery + wear. Icons now react in milliseconds; residual ~2s is the bud's hardware debounce| Icons felt poll-bound and inconsistent (0-4s). Push makes it feel instant| Done| Quick|
| 5| **FGS notification**: AUDITED 2026 — already optimal. Channel is `IMPORTANCE_MIN`, no badge/lights/vibration/sound, `PRIORITY_MIN`, `ongoing(false)` so it is swipeable. Android 15 requires it for a `connectedDevice` FGS; no setting removes it. The only true fix (dropping the persistent connection) would cost the instant push updates. **Leave as is.** | Serves no user purpose; annoying. Not officially supported on Android 15 - spike| 30 min| Spike|
| 6| **Adaptive app icon** — DONE. `ic_launcher_foreground.xml` rebuilt at 108x108 from the traced `ic_bud_left`/`ic_bud_right` paths (reused verbatim via group transforms, scaled 0.62 into the safe zone), monochrome white on black, buds side by side as if in the case. Added an explicit `monochrome` layer for themed icons to stop the launcher synthesising one. Deleted the legacy `mipmap/ic_launcher.xml` layer-lists and the shadowed `ic_launcher_foreground.png`. Widget preview decoupled from the launcher icon via new `drawable/widget_preview_buds.xml`| Replaces placeholder; Nothing OS was wrapping the icon in a white circle| Done| Medium|
| 7| **Dev Tools screen** - separate menu in-app (out of the settings cog where manual connect/disconnect currently sits with themes): (a) human-readable log ("L bud: in ear", "ANC -> Deep", "Battery L=70"), (b) raw hex log (current one, expanded) keeping hold-to-copy + new export-to-file button| Raw log is hard to read; also the diagnostic tool for #4| 2-3 h| Medium|
| 8| **Auto play/pause, two phases**: (a) firmware toggle button in app UI (autoPlayPauseOn/Off commands already exist in manager), near ANC/Game Mode or in settings; (b) Smart Pause v2 - app-handled: both buds out -> pause; single out -> keep playing; never auto-resume; never fight manual user playback. Latency target 0-250 ms, depends on #4| Firmware version resumes accidentally when holding a removed bud; software rules fix it| a: 30 min / b: 2-3 h| Quick + Medium|

## Priority 3 - Features & research (parity with original app)

| #| Item| Details from app screenshots| Est. time| Type|
| ---| ---| ---| ---| ---| ---| ---| ---| ---| ---|
| 9| **Easy parity batch**: spatial sound switch (commands exist), find my earbuds (loud beep), alert-sound volume slider (More settings shows it as a slider), game mode done| Quick wins, commands mostly exist| 2-3 h| Medium|
| 10| **Medium parity batch + spikes**: dual device ("connect 2 devices and switch"), ANC-Smart behavior (spike: app adapts or buds themselves?), Hi-Res mode (switch BT codec - LHDC; screenshot shows simple toggle), earbud fit test (unknown)| Listed for parity| spikes 30 min each| Spike -> Medium|
| 11| **Hard parity batch - EQ + Golden Sound + controls**: EQ = 6 bands (62/250/1k/4k/8k/16k Hz), +/-6 dB, presets (Balanced/Clear Vocals/Bass), custom presets with rename, BassWave dynamic-bass toggle + intensity slider. Golden Sound = one-time hearing test, likely produces an EQ profile. Earbud controls = per-bud single/double/triple tap + slide + touch&hold, separate "when not on a call" / "when on a call" sections (screenshots 22:02)| Complex, long-term; needs packet research vs reference projects| many hours| Big|
| 12| **Case lid state research**: read Leaf-lsgtky/OppoPods + Zhaoyi-ya/OppoPodsManager - do buds/case report lid open/closed (0x8105 ear-status bit 0x04?)? KEEP current case code + ic_case.xml until resolved. Note: verified HeyMelody also cannot read case battery when buds are out + lid closed| Case icon comeback depends on this; parked by user decision 2026-09-15| 1-2 h research| Spike|
| 13| **Lock screen widget** feasibility research (Android 15 / Nothing OS)| Worth a peek, low importance| 30 min| Spike|

## Priority 4 - Before release

| #| Item| Why / when| Est. time| Type|
| ---| ---| ---| ---| ---| ---| ---| ---|
| 14| Credits section - in-app + README: Leaf-lsgtky/OppoPods, Zhaoyi-ya/OppoPodsManager, tools, thanks. GPL-3.0 obligation| Ships with 1.1| 1 h| Quick|
| 15| Source cleanup pass - unused files/dead code (ic_case.xml stays - parked per #12), verify .gitignore| Before redesign| 1-2 h| Medium|
| 16| ~~Package rename~~ - CLOSED: package is already `com.spizganed.quickbuds`; app name QuickBuds pending final decision with #6| -| -| -|

## Priority 5 - The final step

| #| Item| Why / when| Est. time| Type|
| ---| ---| ---| ---| ---|
| 17| **Full app UI v1.1** - bottom navigation (Device / Earbud controls / About) exactly like the original app's structure, mimic finished widget style, only wanted functions, hosts features #9-#11 as they land| Last by design| full day+ across sessions| Big|

## Execution order

```
7 -> 4 -> 5 -> 6 -> 8a -> 9 (easy batch)
-> 8b (needs #4) -> 10/12/13 spikes anytime
-> 14 -> 15 -> 17 (with 10/11 slotted in as the UI grows)
```

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
