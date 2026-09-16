# Buds QS — Handoff Document
Date: 2026-09-16
Status: WORKING — core features functional; wear, battery and game mode all push-driven

## What Works
- RFCOMM on UUID 0000079A-D102-11E1-9B23-00025B00A5A5 (channel 15 fallback)
- Full init: HANDSHAKE -> QUERY_PRODUCT_ID -> QUERY_BROADCAST_CODES -> REGISTER_NOTIFY -> QUERY_STATUS -> QUERY_ANC -> QUERY_BATTERY -> QUERY_WEARING
- ANC: Off(0x01) Trans(0x04) Deep(0x10) Medium(0x20) Light(0x40) Smart(0x80)
- Game Mode: feature 0x06 — **and it is now PUSHED by the buds (0x0204 subType 0x05), so the
  widget/app buttons track bud-side gesture toggles**
- Live battery from AA 0D/0F (L/C/R with charging flag) — **battery pushes on change**
- Bud state from AA 07
- **Wear state pushed by the buds (0x0204 subType 02) — instant, no visible lag**
- **Poll every 60s, status only** — it is now a pure keep-alive; see Next Tasks
- Foreground service survives app close
- Widget (4 buttons + battery) works when app closed
- Quick Settings tile
- Themes: OLED / Dark / Light
- Main screen: compact capped status panel + reserved `featureList` area below it, scrollable

## Main screen layout (settled)
Header (fixed) / ScrollView `mainScroll` containing the panel row + feature list.
- The status panel is capped in BOTH dimensions: `@dimen/widget_panel_width` (200dp) x
  `@dimen/widget_panel_height` (148dp), top-aligned and flush left. It is deliberately NOT a copy
  of the widget's full 3x2 shape, only a compact "2x2-ish" card. (An earlier revision let it fill
  the height, which left a dead area and no room for anything else.)
- `panelSideSlot` is a weighted spacer to the RIGHT of the panel.
- **`featureList`** (empty LinearLayout, id `featureList`) is the reserved area BELOW the panel for
  the upcoming controls: dual device, spatial audio, codec switching, equalizer, find my earbuds.
  Build rows as a reusable "setting row" (label left, switch/chevron right) in the widget's card
  colours, not platform defaults. It is inside the ScrollView so the list can grow past one screen.
- The main screen carries NO log. Dev Tools owns logging (both views + Mark/Clear/Export).
  **Status events on the main screen are silent by design.** An earlier revision toasted them,
  which stormed the UI because several call sites fire once per packet — do not put user-visible
  output on a packet-listener call path. `appendStatus()` now only appends to a bounded in-memory
  tail.

## Key Files
app/src/main/kotlin/com/spizganed/quickbuds/
  bluetooth/BudsConnectionManager.kt
  bluetooth/BudsService.kt
  bluetooth/KeepAliveReceiver.kt
  bluetooth/WidgetActions.kt
  protocol/OpoProtocol.kt
  protocol/OppoPacketFramer.kt
  protocol/BatteryParser.kt
  protocol/WearingStatusParser.kt
  protocol/GameModeParser.kt          <- NEW: 0x0204 subType 0x05
  protocol/LogDecoder.kt
  ui/MainActivity.kt
  ui/AncTileService.kt
  ui/DevToolsActivity.kt
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
   `queryAncMode()` (0x810C reply, format already parsed) after a gesture.
2. **Confirm on device** (not yet visually verified): game-mode gesture sync, the capped status
   panel + `featureList` layout, and the widget/app icon and panel changes.
3. **Build the feature rows** in `featureList` (id in `activity_main.xml`): dual device, spatial
   audio, codec switching, equalizer, find my earbuds. NOTE: `OpoProtocol` already has
   `FEATURE_DUAL_DEVICE=0x11`, `FEATURE_SPATIAL_SOUND=0x1B`, `FEATURE_AUTO_PLAY_PAUSE=0x04`
   alongside `FEATURE_GAME_MODE=0x06`, and the init sequence queries broadcast codes — so a
   feature get/set pattern likely exists. CAPTURE the buds' replies before building any of them.
4. Visual widget redesign (Nothing OS style): battery-only widget with circular rings, and
   controls widget with segmented ANC.
5. No accidental app-open on widget tap.
6. Connection robustness: `Connection reset by peer` / `Broken pipe` during long sessions, and
   the primary UUID `00001107-...` appears to never connect (5 s timeout each attempt) while
   the `0000079A-...` fallback works. Consider trying the working UUID first. A 14-minute gap
   with no reconnect attempt was also observed after `Connection lost`.
7. Decode the remaining unknown frames: the recurring `F1` family
   (`AA 0D 00 00 04 02 FF 06 00 F1 01 01 XX YY 02`), and `02 01 08 0C 02` / `02 01 07 0B 02`
   (carry non-multiples of ten — possible fine-grained battery/case field). Also `0x0510`
   Spatial Audio Notify. **Do not guess from a couple of samples.**
8. LEAD: the reference projects subscribe to BLE notifications on BOTH the `0000079A` and
   `FE2C` characteristics because responses arrive on both. We only register on the OPO
   service. Worth trying if frames are ever noticed going missing.

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
