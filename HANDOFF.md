# Buds QS — Handoff Document
Date: 2026-09-17
Status: WORKING — core features functional; wear, battery and game mode all push-driven
Working tree: **UNCOMMITTED** (50:50 battery card + 52dp icons; layout-report tool). See
"What is not verified" below before touching anything visual.

## What Works
- RFCOMM on UUID `0000079A-D102-11E1-9B23-00025B00A5A5` (channel 15 fallback)
- Full init: HANDSHAKE -> QUERY_PRODUCT_ID -> QUERY_BROADCAST_CODES -> REGISTER_NOTIFY -> QUERY_STATUS -> QUERY_ANC -> QUERY_BATTERY -> QUERY_WEARING
- ANC: Off(0x01) Trans(0x04) Deep(0x10) Medium(0x20) Light(0x40) Smart(0x80)
- Game Mode: feature 0x06 — **and it is now PUSHED by the buds (0x0204 subType 0x05), so the
  widget/app buttons track bud-side gesture toggles**
- Live battery from AA 0D/0F (L/C/R with charging flag) — **battery pushes on change**
- Bud state from AA 07
- **Wear state pushed by the buds (0x0204 subType 02) — instant, no visible lag**
- **Poll every 60s, status only** — it is now a pure keep-alive; see Next Tasks
- Foreground service survives app close (`bluetooth/KeepAliveReceiver.kt`)
- Widget (4 buttons + battery) works when app closed
- Quick Settings tile
- Themes: OLED / Dark / Light (Light is slated for REMOVAL, see Next Tasks)
- Main screen: battery card (L/case/R icons + three labelled bars), ANC circles, settings card
- Settings card rows, built by `ui/SettingRowFactory.kt`: Game Mode (live), Hi-Res codec
  (stub — subtitle only), Spatial audio (legacy feature `0x1B`), Equalizer, Find my earbuds,
  App update
- Secondary screens: `DevToolsActivity`, `EqActivity`, `FindBudsActivity`, `UpdateActivity`
- **`devtool/LayoutReport.kt` — the layout-report tool. This is how the agent "sees" the UI.**

## Reading the UI without screenshots (IMPORTANT — read this before any layout work)
The agent working on this project **cannot read images**. `screenshots/*.png` are useless to it.
`LayoutReport.kt` exists to close that gap: it walks the laid-out view tree and writes the
measured geometry and content out as TEXT (bounds, weights, margins, padding, gravity, text
size/style/colour, drawable intrinsic vs actual size) plus a `SIBLING GAPS` section.

- Capture: open the main screen once (MainActivity parks a report in `onResume`), then
  Dev Tools -> Layout report (cached on resume) / live. Files land in `testlogs/layout_main_<ts>.txt`.
- **Order of operations for any layout/spacing/alignment complaint: capture a report FIRST.**
  It usually answers the question outright, which avoids the build cycles that guessing cost.
- All bounds are in pixels relative to the ROOT view, with dp alongside (density 2.625 on the
  1080x2392 test device, so 1dp = 2.625px).
- `!! OVERLAP` on `status_bar_* -> status_text_*` (-13dp) is **by design**: the number TextView
  sits on top of the bar. Not a bug.
- When changing `collectGaps`, keep it to DIRECT children of each container, measured against
  that container's own origin and on its own stacking axis. Two earlier versions broke this:
  one walked only unnamed direct children (every line read `(no id) -> (no id) = 0.0dp`), and
  one flattened whole subtrees, pairing children of different containers and reading full-width
  stacked siblings as `-202.3dp OVERLAP`, while double-reporting every pair.

## Main screen layout (settled)
Header (fixed: device name + dev-tools icon + settings cog) / ScrollView `mainScroll`.

**The 2026-09-16 redesign replaced the old "capped status panel" arrangement.** The current
structure, top to bottom inside the scroll:
1. `batteryCard` — full width, **halves now EQUAL (weight 1 / weight 1**; they were 0.8 / 1.2
   on 2026-09-16, changed 2026-09-17 so the icon side gets more room**)**. Left half:
   `status_bud_left`, a weighted frame holding `status_case_icon`, `status_bud_right`.
   Right half (marginStart 14dp): three rows `status_row_left` / `status_row_case` /
   `status_row_right`, each a letter TextView plus a `ProgressBar` (`status_bar_*`) with a
   centred number TextView (`status_text_*`) on top. The numbers are normally empty because
   `SegmentedBarDrawable` draws the value inside the bar; the TextViews are the fallback for a
   non-segmented bar. See `renderBar`.
2. ANC switcher — three circles: `anc_btn_off`, `anc_btn_anc`, `anc_btn_trans`. Tapping the
   **active** circle opens the full mode chooser (`showAncChooser`) because three buttons
   cannot represent five modes. Off / Transparency apply directly.
3. `featureList` — the settings card, `@drawable/app_card_outline_bg`, filled at runtime by
   `MainActivity.buildFeatureRows()`. Declared empty in XML on purpose: six near-identical row
   layouts in XML would be six places to edit, and the icons need a themed tint that XML
   cannot apply to a vector drawable. `addRow()` inserts the hairline divider before every
   row except the first.

The main screen carries NO log. Dev Tools owns logging (both views + Mark/Clear/Export).
**Status events on the main screen are silent by design.** An earlier revision toasted them,
which stormed the UI because several call sites fire once per packet — do not put user-visible
output on a packet-listener call path. `appendStatus()` now only appends to a bounded in-memory
tail.

## Battery icon sizing — SOLVED, do not re-litigate
All three battery icons (`ic_bud_left`, `ic_bud_right`, `ic_case`) are authored on a **48x48
viewport** and drawn into same-sized slots (**52dp as of 2026-09-17**), so one vector unit means
the same physical distance in every file: 52/48 = 1.083dp per unit.

The bug that took several cycles: he reported the icons looked misaligned and different sizes.
Every measured *box* was correct and every aspect ratio matched, so the obvious suspects were
all innocent. The cause was **fill fraction** — the case was a 48x40 viewport on a 1:1 slot
(ellipse edge to edge, 100% fill) while the buds were inset to ~79% of their viewport. A case
unit was therefore 48/48dp against a bud's 40/48dp, so the case drew ~20% larger per unit and
sat on a different optical line. Fixed by rescaling `ic_case.xml` to the buds' ~79% fill on a
shared 48x48 viewport. **If you change one icon's frame or insets, scale the others to match or
this comes back.**

Verified from a capture: all three 40dp at the time, equal gaps either side of the case
(`0.0dp` / `0.0dp`; previously 114px vs 135px).

## What is NOT verified on device (2026-09-17)
- **The 50:50 split and 52dp icons** (this session's change) have NOT been captured yet. The
  arithmetic is verified, the on-device result is not.
- **Game-mode gesture sync** (the code path is proven from captures; the on-device feel is not).
- Widget/app icon changes, header icons, dev-menu long-press copy.
- The three new screens (`EqActivity`, `FindBudsActivity`, `UpdateActivity`).

### Now verified (previously on the "not verified" list)
- The 2026-09-16 redesign HAS been seen via layout reports: battery card geometry, the three
  ANC buttons (52.2dp tall, ~118dp wide), header, feature rows and dividers all check out.
- Battery icon alignment — fixed and confirmed by measurement (see above).
Repeated WARNING in `MainActivity`: "Use property access syntax" — cosmetic, ignore it.


## Key Files
app/src/main/kotlin/com/spizganed/quickbuds/
  bluetooth/BudsConnectionManager.kt
  bluetooth/BudsService.kt
  bluetooth/KeepAliveReceiver.kt     <- NEW: reconnect-after-kill receiver
  bluetooth/WidgetActions.kt
  protocol/OpoProtocol.kt
  protocol/OppoPacketFramer.kt
  protocol/BatteryParser.kt
  protocol/WearingStatusParser.kt
  protocol/GameModeParser.kt          <- NEW: 0x0204 subType 0x05
  protocol/LogDecoder.kt
  devtool/LayoutReport.kt             <- NEW: the agent's eyes. Read its header before editing.
  ui/MainActivity.kt                  <- REDESIGNED (see layout section)
  ui/SettingRowFactory.kt             <- NEW: the one place a settings row is defined
  ui/SegmentedBarDrawable.kt          <- NEW: draws the value inside a battery bar
  ui/ThemeRes.kt                      <- theme select / dp / tint / colour helpers
  ui/AncTileService.kt
  ui/DevToolsActivity.kt
  ui/EqActivity.kt                    <- NEW (placeholder destination)
  ui/FindBudsActivity.kt              <- NEW
  ui/UpdateActivity.kt                <- NEW (never auto-updates)
  ui/ChimePlayer.kt                   <- NEW
  widget/AncWidgetProvider.kt
  widget/WidgetActionReceiver.kt
  widget/WidgetStateStore.kt

> Historical note: older revisions of this document listed the package as
> `com.example.oneplusbudsqs` and referenced `protocol/BudStateParser.kt`. The package is
> `com.spizganed.quickbuds` and that parser is now `protocol/WearingStatusParser.kt`.

## Log storage & export (where the files actually are)
- Live log: `Android/data/com.spizganed.quickbuds/files/packets.log`, rotating to
  `packets.old.log` past 512 KB. This path is inside app-specific external storage, which
  **file managers and the system Files app cannot browse on Android 11+** — that is why it
  seems to "vanish".
- Reachable from Termux: `cat /storage/emulated/0/Android/data/com.spizganed.quickbuds/files/packets.log`
- Dev Tools **Export** now writes to `Download/QuickBudsLogs/packets_export_<yyyyMMdd_HHmmss>.log`
  via `MediaStore.Downloads`, so it shows up in any file manager and over MTP.
- Deliberate choice: `Download/QuickBudsLogs/` rather than a sibling
  `/storage/emulated/0/QuickBudsLogs/`. The shared-storage *root* needs All-Files-Access on
  Android 11+, which is restricted and blocks Play distribution; MediaStore Downloads needs
  no permission at all. Do not "simplify" this back to a plain File write.

## Protocol
Wire: AA [TotalLen=7+payload] 00 00 [Cmd LE] [Seq] [PayLen LE] [Payload]
Seq starts 0x01, wraps 0xFE. Cmd LE.
Cmds: 0x0404 set ANC, 0x0403 set feature, 0x0100 handshake, 0x0103 product id, 0x0200 broadcast codes, 0x010D status, 0x0106 battery, 0x010C ANC
ANC bitmap: 0=Off 1=NC 2=Trans 4=Deep 5=Medium 6=Light 7=Smart
Feature IDs: 0x06=GameMode 0x04=AutoPlay 0x11=DualDevice 0x1B=Spatial
Battery: [Index,RawValue] pairs, Index 1=L 2=R 3=C, level=val&0x7F, charging=(val&0x80)!=0
Bud state: AA 07 00 00 01 05 [XX] 00 00, 0x05=Right out, 0x06=Left out

## Push notifications (0x0205 register / 0x0204 events) — SOLVED
- To have the buds report spontaneously, send `0x0205` with payload `02 01 02`.
  The payload is **count first, then event ids**: count=2, battery `01`, wearing `02`.
- Getting this wrong is silent. The old payload `01 01 02 02` reads as count=1 (battery
  only); firmware ACKs it happily and just never sends wear events. That is why wear used
  to lag behind a 5 s poll. **Do not "fix" this back to the 4-byte literal.**
- ACK shape when correct: `AA 0D 00 00 05 82 04 06 00 01 02 01 00 02 00` — lists BOTH events.
- Pushed wear event shape: `AA 0F 00 00 04 02 FF 08 00 02 03 01 <st> 02 04 03 04`
  (cmd `0x0204`, payload[0] = subType `02`, `<st>` is the wear status code).
- `handlePacket()` already routes both `0x8109` (query reply) and `0x0204` (push) into the
  same handler, so the UI needs no special-casing — push arrived for free.
- Registration happens only in `runInitSequence()` at connect time. A payload change is NOT
  picked up by an already-connected session — you must reconnect to test it.

### Game mode push (0x0204 subType 0x05) — SOLVED
- Separate from wear and battery, the buds push Game Mode changes:
  `AA 09 00 00 04 02 FF 02 00 05 <state>` where `<state>` is `0x01` = ON, `0x00` = OFF.
- **The frame length is 0x09, not 0x0F/0x0D like the others** — the payload is only 2 bytes.
  Anything that assumes a fixed frame length will skip it.
- This fires for BOTH our own `setGameMode()` and the user toggling on the buds, so it is the
  authoritative state. `BudsService.onGameModeState()` writes it into `WidgetStateStore`,
  which refreshes the widget and the app UI with **no view-level changes**.
- **This event is GAME MODE ONLY. It is NOT raised for ANC changes** — verified three times
  (ANC Off, ANC Light, ANC Medium all produced no frame). Do not try to read ANC out of it.

### Measured latency
- Poll (old): 0–4 s after the physical action, varying with where you landed in the 5 s window.
- Push (now): a few milliseconds from event to UI update.
- Remaining ~2 s between `out` -> `EAR` -> `out` transitions in the log is the **bud's own
  hardware debounce**, not app latency. Don't chase it.

## Bugs Fixed
- Widget actions: full action string vs short name mismatch -> use short names as extras
- writeExecutor hang -> fresh thread per send

## Widget Flow
Widget tap -> AncWidgetProvider PendingIntent -> WidgetActionReceiver -> WidgetStateStore.write -> broadcast ACTION_WIDGET_COMMAND (short name) -> BudsService.widgetCommandReceiver -> executeWidgetCommand -> manager.sendAncXxx()

## Next Tasks
1. **ANC gesture sync — HIGHEST PRIORITY.** The buds raise NO event for ANC changes (proven:
   three ANC-only changes produced no frame), so ANC cannot be synced by push the way game mode
   can. Test whether bud-side ANC gestures emit anything at all (prediction: nothing, or a frame
   from the unexplained `F1` family — NOT a 0x05). If nothing, the only route is a one-shot
   `queryAncMode()` (0x810C reply, format already parsed) after a gesture. **A gesture capture
   brief exists (`testlogs/ANC-GESTURE-CAPTURE.md`) and the new build logs `MARK`, `BTN EVT:`
   and `UNATTR RX:`, but NO capture has been handed over yet.** That log decides one-shot vs
   short poll, and it is the blocker.
2. **Icon rework — HE HAS A BRIEF, NOT WRITTEN YET.** Outstanding request: "modify the icons
   and the way [they are] shown". Wait for it; do not start guessing. He was explicit that this
   is a separate session's work. Sketch in ASCII and confirm before coding — that is what saved
   this project from repeated build cycles.
3. **Remove the Light/white theme.** Decided 2026-09-17: he does not use it and it "introduces
   problems". It is the source of two recurring awkwards (white L/C/R letters and a white
   in-case state are both invisible on a light background), and it is a whole colour-qualifier
   branch to keep in sync. Delete the Light qualifier and fold its colours into the dark/OLED
   path. **Do not start until asked** — but this makes the theme-aware colour work in Q2/Q4
   simpler once done.
4. **Dual device + codec feature ids** — `OpoProtocol` already has `FEATURE_DUAL_DEVICE=0x11`,
   `FEATURE_SPATIAL_SOUND=0x1B`, `FEATURE_AUTO_PLAY_PAUSE=0x04` alongside `FEATURE_GAME_MODE=0x06`,
   and the init sequence queries broadcast codes, so a feature get/set pattern likely exists.
   CAPTURE the buds' replies before building any of them, and before making the Hi-Res codec row
   (currently a subtitle-only stub) actually switch the codec.
5. **Widget colour states** — apply the Q4 rule (in-ear = full strength, out-of-ear = grey,
   in-case = full strength, all theme-aware) to the widget. The widget is a separate view tree
   and was NOT touched by the app-side icon fix.
6. Visual widget redesign (Nothing OS style): battery-only widget with circular rings, and
   controls widget with segmented ANC.
7. No accidental app-open on widget tap.
8. Connection robustness: `Connection reset by peer` / `Broken pipe` during long sessions, and
   the primary UUID `00001107-...` appears to never connect (5 s timeout each attempt) while
   the `0000079A-...` fallback works. Consider trying the working UUID first. A 14-minute gap
   with no reconnect attempt was also observed after `Connection lost`.
9. Decode the remaining unknown frames: the recurring `F1` family
   (`AA 0D 00 00 04 02 FF 06 00 F1 01 01 XX YY 02`), and `02 01 08 0C 02` / `02 01 07 0B 02`
   (carry non-multiples of ten — possible fine-grained battery/case field). Also `0x0510`
   Spatial Audio Notify. **Do not guess from a couple of samples.**
10. Alert-sound volume slider (the one remaining "easy parity" row; the rest are in).

### Done
- ~~**Confirm the redesign on device.**~~ The 2026-09-16 redesign HAS now been seen, via layout
  reports rather than screenshots: battery card geometry, the ANC buttons, the header and the
  feature rows all check out. See the layout-report section above for how.
- ~~Battery icon misalignment ("icons are misaligned, different sizes")~~ — root cause was fill
  fraction, not aspect ratio. Fixed and verified by measurement. See "Battery icon sizing".
- ~~Battery card halves~~ — now a 50:50 split (were 0.8/1.2), icons 40dp -> 52dp. Built; the
  on-device result is not yet captured.

### Resolved (kept for the reasoning)
- ~~5s poll~~ -> **60s, status only.** Confirmed by long capture: the buds push battery on
  change, and NO `poll status` reply ever contained a battery byte (always `06 01 1B 00`).
  The poll is now a pure keep-alive; keep `0x010D` for that reason.
- ~~Does battery event `01` actually push?~~ -> **Yes.** Three pushes (100->90->80) observed,
  each arriving with no poll adjacent.
- Battery granularity: **tens** (100/90/80 only, even during an aggressive ~1-hour 20% drain).
  The reference implementation reads the same bytes raw with no scaling, so the firmware reports
  in tens. Nothing to fix in our parser.
- ~~LogDecoder discards pushes~~ -> 0x0204 subType 0x05 is now decoded as game mode; unknown
  subTypes still print as `Active report: subType=0xNN` rather than being hidden.

## Environment
- Code Assist mobile IDE
- Buds: OnePlus Buds 4 MAC A8:E6:E8:92:C1:25
- Phone: Nothing Phone 3a, Android 15
- Refs: github.com/Leaf-lsgtky/OppoPods, github.com/Zhaoyi-ya/OppoPodsManager

## Notes
- Do NOT use HFP UUID 0000111E
- Case battery only when buds in case
- queryStatus 0x010D has game mode, spatial, dual device, auto play/pause
