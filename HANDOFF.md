# Buds QS — Handoff Document
Date: 2026-09-14
Status: WORKING — all core features functional

## What Works
- RFCOMM on UUID 0000079A-D102-11E1-9B23-00025B00A5A5 (channel 15 fallback)
- Full init: HANDSHAKE -> QUERY_PRODUCT_ID -> QUERY_BROADCAST_CODES -> QUERY_STATUS -> QUERY_ANC -> QUERY_BATTERY
- ANC: Off(0x01) Trans(0x04) Deep(0x10) Medium(0x20) Light(0x40) Smart(0x80)
- Game Mode: feature 0x06
- Live battery from AA 0D/0F (L/C/R with charging flag)
- Bud state from AA 07
- Poll every 5s
- Foreground service survives app close
- Widget (4 buttons + battery) works when app closed
- Quick Settings tile
- Themes: OLED / Dark / Light

## Key Files
app/src/main/kotlin/com/example/oneplusbudsqs/
  bluetooth/BudsConnectionManager.kt
  bluetooth/BudsService.kt
  bluetooth/KeepAliveReceiver.kt
  bluetooth/WidgetActions.kt
  protocol/OpoProtocol.kt
  protocol/OppoPacketFramer.kt
  protocol/BatteryParser.kt
  protocol/BudStateParser.kt
  ui/MainActivity.kt
  ui/AncTileService.kt
  widget/AncWidgetProvider.kt
  widget/WidgetActionReceiver.kt
  widget/WidgetStateStore.kt

## Protocol
Wire: AA [TotalLen=7+payload] 00 00 [Cmd LE] [Seq] [PayLen LE] [Payload]
Seq starts 0x01, wraps 0xFE. Cmd LE.
Cmds: 0x0404 set ANC, 0x0403 set feature, 0x0100 handshake, 0x0103 product id, 0x0200 broadcast codes, 0x010D status, 0x0106 battery, 0x010C ANC
ANC bitmap: 0=Off 1=NC 2=Trans 4=Deep 5=Medium 6=Light 7=Smart
Feature IDs: 0x06=GameMode 0x04=AutoPlay 0x11=DualDevice 0x1B=Spatial
Battery: [Index,RawValue] pairs, Index 1=L 2=R 3=C, level=val&0x7F, charging=(val&0x80)!=0
Bud state: AA 07 00 00 01 05 [XX] 00 00, 0x05=Right out, 0x06=Left out

## Bugs Fixed
- Widget actions: full action string vs short name mismatch -> use short names as extras
- writeExecutor hang -> fresh thread per send

## Widget Flow
Widget tap -> AncWidgetProvider PendingIntent -> WidgetActionReceiver -> WidgetStateStore.write -> broadcast ACTION_WIDGET_COMMAND (short name) -> BudsService.widgetCommandReceiver -> executeWidgetCommand -> manager.sendAncXxx()

## Next Tasks
1. Visual widget redesign (Nothing OS style): battery-only widget with circular rings, and controls widget with segmented ANC
2. No accidental app-open on widget tap

## Environment
- Code Assist mobile IDE
- Buds: OnePlus Buds 4 MAC A8:E6:E8:92:C1:25
- Phone: Nothing Phone 3a, Android 15
- Refs: github.com/Leaf-lsgtky/OppoPods, github.com/Zhaoyi-ya/OppoPodsManager

## Notes
- Do NOT use HFP UUID 0000111E
- Case battery only when buds in case
- queryStatus 0x010D has game mode, spatial, dual device, auto play/pause
