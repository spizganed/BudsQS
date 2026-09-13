# Buds QS

Custom Android controller for OnePlus Buds 4 (running on Nothing Phone 3a).

## Current Status
- Working: ANC Off/Transparency/High/Medium/Low, Quick Settings tile, OLED theme
- Broken: Game Mode, battery display, seamless reconnection after case close
- Reference: see `PROTOCOL_ANALYSIS.md` for the reverse-engineering notes

## Next Steps
1. Migrate to PC with Android Studio
2. Capture clean Wireshark traces of HeyMelody for Game Mode + ANC
3. Decode the `AA` wire format wrapper and rebuild `OpoProtocol.kt`
4. Implement battery byte parsing from `AA 0D` packets
5. Rebuild the connection layer around a proper service architecture like HeyMelody

## Tools
- Android Studio (PC)
- JADX-GUI (PC)
- Wireshark (PC)
- ADB + USB debugging
