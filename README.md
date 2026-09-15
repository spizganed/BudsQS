# QuickBuds

> Lightweight, open-source control for OnePlus / OPPO / realme earbuds — direct RFCOMM, no bloat.
> Repo name: BudsQS (historical). App name: **QuickBuds**.

[![License: GPL-3.0](https://img.shields.io/badge/License-GPL--3.0-blue.svg)](./LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84.svg)]()

Control your earbuds' ANC, Game Mode, and battery monitoring from a clean widget — without HeyMelody, without the Wearable app, without root, Shizuku, or ADB. Built 100% on-device (CodeAssist + Termux), reverse-engineered packet by packet.

## Why

The official apps are heavy, account-bound, and push features you don't want. QuickBuds speaks directly to the buds over a classic Bluetooth RFCOMM channel and implements only what the developer actually uses — see [ROADMAP.md](./ROADMAP.md) for the full, brutally honest priority list.

## Features

**Connection & control**
- Direct RFCOMM to the earbuds (UUID `0000079A-D102-11E1-9B23-00025B00A5A5`, with fallbacks)
- Full init handshake, then the buds **push** battery/wearing events to the app
- ANC: Off / Transparency / Light / Medium / Deep (+ Smart command ready)
- Game Mode toggle
- Auto-retry connection logic (survives the buds being busy)

**Home-screen widget (3x2)**
- Battery bars for Left / Case / Right — always showing last-known values, updated on every hardware packet (poll or push)
- Bud status icons: **white** = in ear, **grey** = out of ear, **hidden** = in case
- 5-segment ANC switcher + Game Mode row — works even with the app closed
- Nothing to configure; reacts as fast as the hardware reports

**App & service**
- Foreground service keeps the link alive (notification: roadmap item to hide it)
- Quick Settings tile
- OLED Black / Dark / Light themes
- Full packet logging (every sent command and received frame, timestamped) behind the in-app log

## Requirements & tested setup

- Android (developed and tested on Nothing Phone (3a), Android 15)
- OnePlus Buds 4 (other OnePlus/OPPO/realme buds likely work — protocol is shared)
- Bluetooth permissions granted on first launch

## How it works

```
Widget tap / app UI
      |
WidgetActionReceiver  ->  BudsService  ->  BudsConnectionManager (RFCOMM)
                                                  |
                                     OppoPacketFramer (AA framing)
                                                  |
                              OpoProtocol: handshake, queries, 0x0205 event
                              registration, ANC/GameMode command builders
                                                  |
                              WearingStatusParser / BatteryParser -> state
                                                  |
                              WidgetStateStore -> AncWidgetProvider (refresh)
```

Key protocol facts (observed on Buds 4):
- Battery query `0x01F0` -> components `(01,L) (02,R) (03,C)`
- Wearing query `0x01F2` -> status codes: `4` = in case, `1/5` = out idle, `3/7` = wearing
- `0x0205` registration makes the buds push `0x0204` events (battery confirmed; wear events under investigation)
- Closing the lid with buds docked kills the RFCOMM socket — used as one of the lid-state signals

## Development workflow

- **No desktop. Ever.** CodeAssist IDE on the phone, Termux for git/build scripts, GitHub mobile for repo ops.
- AI-assisted (Kimi) for protocol reverse-engineering, parsers, and logic; the human does device testing and design decisions.
- App icon pipeline (Termux) documented in the repo history; adaptive icon is on the roadmap.

## Project status

Actively developed against [ROADMAP.md](./ROADMAP.md). Handoff notes for future sessions live in [HANDOFF.md](./HANDOFF.md). Recent milestone: widget overhaul — vector icons traced from the originals (fixes pixelation), locked white/grey/hidden state logic, 3x2 layout, case icon removed after verifying even HeyMelody can't read lid state in all scenarios.

## Screenshots

<!-- Add current screenshots here (widget states + app UI). Older shots may exist in repo history. -->

## Credits

Protocol reverse engineering standing on the shoulders of:

- **[Leaf-lsgtky/OppoPods](https://github.com/Leaf-lsgtky/OppoPods)** — OPPO earbud protocol RE
- **[Zhaoyi-ya/OppoPodsManager](https://github.com/Zhaoyi-ya/OppoPodsManager)** — protocol reference & feature implementation

Tools: CodeAssist IDE (Tyron), Termux, decompile.com, Kimi (Moonshot AI).

## License

GPL-3.0 — see [LICENSE](./LICENSE). Same license as the reference projects above.

## Disclaimer

Unofficial project, not affiliated with OnePlus, OPPO, or realme. Product names are trademarks of their respective owners. You use this software at your own risk; sending raw commands to your earbuds is generally safe but comes with no warranty.
