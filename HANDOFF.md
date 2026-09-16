# Buds QS — Handoff Document
Date: 2026-02-14
Status: WORKING — all core features functional; wear state now push-driven (instant)

## What Works
- RFCOMM on UUID 0000079A-D102-11E1-9B23-00025B00A5A5 (channel 15 fallback)
- Full init: HANDSHAKE -> QUERY_PRODUCT_ID -> QUERY_BROADCAST_CODES -> REGISTER_NOTIFY -> QUERY_STATUS -> QUERY_ANC -> QUERY_BATTERY -> QUERY_WEARING
- ANC: Off(0x01) Trans(0x04) Deep(0x10) Medium(0x20) Light(0x40) Smart(0x80)
- Game Mode: feature 0x06
- Live battery from AA 0D/0F (L/C/R with charging flag)
- Bud state from AA 07
- **Wear state pushed by the buds (0x0204 events) — instant, no visible lag**
- Poll every 5s (still running; see Next Tasks)
- Foreground service survives app close
- Widget (4 buttons + battery) works when app closed
- Quick Settings tile
- Themes: OLED / Dark / Light

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
1. Visual widget redesign (Nothing OS style): battery-only widget with circular rings, and controls widget with segmented ANC
2. No accidental app-open on widget tap
3. **Revisit the 5s poll now that wear is pushed.** The wear poll is redundant. Caution:
   `0x010D` (queryStatus) is documented by the reference sources as a FIXED packet that wakes
   the earbuds and acts as a keep-alive — removing it may let the buds sleep and make things
   worse. Widen the interval rather than deleting the packet outright. Also confirm whether
   battery event `01` actually pushes, or whether battery still needs its poll.
4. Connection robustness: `Connection reset by peer` / `Broken pipe` during long sessions, and
   the primary UUID `00001107-...` appears to never connect (5 s timeout each attempt) while
   the `0000079A-...` fallback works. Consider trying the working UUID first.
5. Audit `LogDecoder` for pushes we silently discard: `0x0510` Spatial Audio Notify, and
   `0x0204` subTypes beyond 01/02.

## Environment
- Code Assist mobile IDE
- Buds: OnePlus Buds 4 MAC A8:E6:E8:92:C1:25
- Phone: Nothing Phone 3a, Android 15
- Refs: github.com/Leaf-lsgtky/OppoPods, github.com/Zhaoyi-ya/OppoPodsManager

## Notes
- Do NOT use HFP UUID 0000111E
- Case battery only when buds in case
- queryStatus 0x010D has game mode, spatial, dual device, auto play/pause
