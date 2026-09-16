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
- Full init handshake, then the buds **push** both battery and wearing events to the app
  (see *Push vs poll* below — wear updates are effectively instant)
- ANC: Off / Transparency / Light / Medium / Deep (+ Smart command ready)
- Game Mode toggle
- Auto-retry connection logic (survives the buds being busy)

**Home-screen widget (3x2)**
- Battery bars for Left / Case / Right — always showing last-known values, updated on every hardware packet (poll or push)
- Wear icons update instantly: the buds **push** wear events, so tap-to-icon latency is milliseconds, not poll-bound
- Bud status icons: **white** = in ear, **grey** = out of ear, **hidden** = in case
- 5-segment ANC switcher + Game Mode row — works even with the app closed
- Nothing to configure; reacts as fast as the hardware reports

**App & service**
- Foreground service keeps the link alive (notification is `IMPORTANCE_MIN` and swipeable —
  Android 15 requires it for a `connectedDevice` service, so it can't be removed)
- Quick Settings tile
- OLED Black / Dark / Light themes
- Dev Tools screen with a human-readable log and a raw-hex log, hold-to-copy, and
  export-to-file; packet logging captures every sent command and received frame, timestamped

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
- `0x0205` registration makes the buds push `0x0204` events. The payload is
  `02 01 02` — a **count** byte followed by event ids (count=2: battery `01` + wearing `02`).
  Registering both makes wear changes arrive instantly, no polling.
- Closing the lid with buds docked kills the RFCOMM socket — used as one of the lid-state signals

### Push vs poll (the latency story)

The buds report wear state two ways: on demand via `0x01F2`, or spontaneously as `0x0204`
events once `0x0205` registration succeeds. QuickBuds originally registered battery only, so
wear lagged behind a 5-second poll — which is why bud icons used to update late, and
inconsistently (0–4 s depending on when you acted within a poll window).

The fix was one line: `0x0205`'s payload is a count followed by event ids, and the old
literal `01 01 02 02` read as *count=1* (battery only), silently dropping wear. Sending
`02 01 02` registers both. Measured result: wear changes now surface within a few
milliseconds, and the only remaining delay is the bud's own ~2 s hardware debounce.

### Battery and Game Mode push too

Both were confirmed by long captures, and both explained a "why isn't this instant?" question:

- **Battery** (`0x0204` subType `01`) arrives on change. Registering it with `0x0205` was
  already correct, but the old 5-second poll obscured the fact that it was never needed:
  across hours of logging, **no `poll status` reply ever contained a battery byte**. The poll
  is now 60 s and exists purely as a keep-alive.
  One hardware quirk worth knowing: **levels are reported in tens** (100 → 90 → 80). A fast
  ~1-hour drain of 20% produced exactly three reports, so this is the firmware's resolution,
  not a limitation of the app. Android's own Bluetooth settings show the same steps.
- **Game Mode** (`0x0204` subType `05`) is pushed when you toggle it *on the buds* as well as
  from the app, so the widget and app buttons follow your earbud gestures instead of only
  reflecting the last command the app sent.
  Note the frame is shorter than the others (`len 0x09`), and it is **Game Mode only — the
  buds raise no equivalent event for ANC changes.**

## Development workflow

- **No desktop. Ever.** CodeAssist IDE on the phone, Termux for git/build scripts, GitHub mobile for repo ops.
- AI-assisted (Kimi) for protocol reverse-engineering, parsers, and logic; the human does device testing and design decisions.
- App icon pipeline (Termux) documented in the repo history; the adaptive icon is done (see milestones below).

## Project status

Actively developed against [ROADMAP.md](./ROADMAP.md). Handoff notes for future sessions live in [HANDOFF.md](./HANDOFF.md).

Recent milestones:
- **Instant wear updates** — identified why wear lagged behind a 5 s poll and fixed it (see *Push vs poll*). Bud icons now react to the physical action within milliseconds.
- **Battery and Game Mode push** — long captures proved both are pushed on change; the poll was cut to 60 s as a pure keep-alive, and battery resolution was pinned down to tens (a firmware trait, not an app bug).
- **Bud-side Game Mode sync** — toggling Game Mode on the earbuds now updates the widget and app buttons, because the buds push the new state. (ANC has no equivalent event, so it can't sync the same way.)
- Widget overhaul — vector icons traced from the originals (fixes pixelation), locked white/grey/hidden state logic, 3x2 layout, case icon removed after verifying even HeyMelody can't read lid state in all scenarios.
- Icon and UI pass — adaptive launcher icon rebuilt from the traced buds with a monochrome layer, a dedicated status-bar glyph, and a redrawn main screen: compact status panel with a reserved area below it for upcoming controls.

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
