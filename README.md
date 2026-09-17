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
- Full init handshake, then the buds **push** battery, wearing **and Game Mode** events to the app
  (see *Push vs poll* below — no visible lag)
- ANC: Off / Transparency / Light / Medium / Deep (+ Smart command ready)
- Game Mode toggle — follows bud-side gestures too
- Auto-retry connection logic (survives the buds being busy)

**Home-screen widget (3x2)**
- Battery bars for Left / Case / Right — always showing last-known values, updated on every hardware packet (poll or push)
- Wear icons update instantly: the buds **push** wear events, so tap-to-icon latency is milliseconds, not poll-bound
- Bud status icons: **full strength (theme colour)** = in ear, **grey** = out of ear. The in-case
  state is due to switch to full strength too (decided 2026-09-17); the widget's recolour rules
  are not yet updated to match the app — see ROADMAP
- 5-segment ANC switcher + Game Mode row — works even with the app closed
- Nothing to configure; reacts as fast as the hardware reports

**App & service**
- Foreground service keeps the link alive (notification is `IMPORTANCE_MIN` and swipeable —
  Android 15 requires it for a `connectedDevice` service, so it can't be removed)
- Quick Settings tile
- OLED Black / Dark themes (a Light theme still exists but is slated for removal — it is the
  source of several invisible-on-light bugs, e.g. white L/C/R letters)
- Main screen: battery card, circular ANC switcher (tap the active circle for the full mode
  list), and a settings card — Game Mode (live), Hi-Res codec, spatial audio, Equalizer,
  Find my earbuds, Earbud controls, App update
- Dedicated screens: **Dev Tools**, **Equalizer**, **Find my earbuds**, **Earbud controls**,
  **App update**
- **Earbud controls** — bind each bud's gestures (single / double / triple tap, slide, hold)
  separately, since the two buds can be configured differently. Tap-and-hold takes several
  actions and cycles through them. **The choices are stored on the phone only:** sending them
  to the buds needs the `function` value for each action, which is not yet confirmed, and the
  screen says so rather than pretending otherwise — see ROADMAP #26 and PROTOCOL.md §6
- Dialogs are the app's own **bottom sheets**, so the theme picker, the ANC mode chooser and
  the gesture picker match the app's palette instead of the platform's
- Dev Tools screen with a human-readable log and a raw-hex log, hold-to-copy, and
  export-to-file; packet logging captures every sent command and received frame, timestamped
- Dev Tools also holds Reconnect / Disconnect, and dumps a **layout report**: the measured view
  tree as text (bounds, weights, margins, text sizes, gaps between siblings). This exists
  because the AI that works on this repo cannot read screenshots — see *Reading the layout* below

> The main screen carries **no** log — Dev Tools owns logging. Status events on the main
> screen are silent by design; a toast on a packet-listener path storms the UI.

## Reading the layout (contributors and AI agents)

This project is developed by an AI agent that **cannot see images**. A screenshot cannot be
converted into anything it can read, so describing a layout bug by screenshot fails: the agent
has to guess which of ~30 view ids you mean, and a wrong guess costs a build cycle.

`devtool/LayoutReport.kt` removes the guesswork. It walks the laid-out view tree and writes the
numbers that a screenshot only approximates — exactly, and with view ids attached:

- per-view bounds in px + dp, parent-relative position
- `layout_weight`, margins, padding, gravity
- text size, style, colour, line count
- for images, the **drawable's intrinsic size vs the size it is actually drawn at** (this is what
  caught the battery icon bug — see ROADMAP #22)
- a `SIBLING GAPS` section listing the space between adjacent siblings, so an inconsistent
  spacing is visible at a glance

To capture: open the main screen once (it parks a report in `onResume`), then
Dev Tools → *Layout report*. Files land in `local/logs/`.

**If you change `collectGaps`, keep it to direct children of each container, measured against
that container's own origin and on its own stacking axis.** Two earlier versions broke that
rule and produced confident nonsense — first `(no id) -> (no id) = 0.0dp` for everything, then
phantom `-202.3dp !! OVERLAP` between full-width stacked siblings.

Also note: `!! OVERLAP` on `status_bar_* -> status_text_*` is **by design** — the battery
percentage is drawn on top of the bar. It is not a bug.

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
                              registration, ANC/GameMode/codec/spatial builders
                                                  |
              WearingStatusParser / BatteryParser / GameModeParser -> state
                                                  |
                              WidgetStateStore -> AncWidgetProvider (refresh)
```

Key protocol facts (observed on Buds 4):
- Battery query `0x01F0` -> components `(01,L) (02,R) (03,C)`
- Wearing query `0x01F2` -> status codes: `4` = in case, `1/5` = out idle, `3/7` = wearing
- `0x0205` registration makes the buds push `0x0204` events. The payload is a **count** byte
  followed by event ids. Registering battery (`01`), wearing (`02`) **and ANC (`03`)** makes
  wear changes and ANC changes arrive instantly, no polling.
  Do not write `01 01 02 02`: under the count-first shape that means "count=1, battery only",
  which the firmware accepts while silently never sending the rest.
- Game Mode is also pushed, as `0x0204` subType `0x05`, **including from bud-side gestures**
- **ANC is pushed too**, as `0x0204` subType `0x03`, and **including from bud-side gestures** —
  so the app's ANC circles and the widget follow a gesture made on the buds. See
  `AncEventParser`. (An earlier revision of this file claimed ANC raised no event at all; that
  was wrong, and it is why ANC sync took so long to land.)
  - To receive it you must subscribe to broadcast code `0x03` in the `0x0205` registration.
    We had only registered `01` (battery) and `02` (wearing), which is why ANC gestures
    appeared silent.
  - The buds' advertised broadcast codes come back in the `0x8200` reply — read it before
    assuming an event is unsupported.
- **The SET and NOTIFY encodings for ANC are different tables.** Setting uses bit 0 = Off,
  bit 2 = Transparency, bits 4-7 = Deep/Medium/Light/Smart. The buds *report* Off as bit 3
  and Transparency as bit 8. Do not unify them; see `OpoProtocol.ancPayload()`.
- Closing the lid with buds docked kills the RFCOMM socket — used as one of the lid-state signals

### Push vs poll (the latency story)

The buds report state two ways: on demand via a query, or spontaneously as `0x0204`
events once `0x0205` registration succeeds. QuickBuds originally registered battery only, so
wear lagged behind a 5-second poll — which is why bud icons used to update late,
and Game Mode never followed a bud-side gesture at all. Registering battery **and**
wear, plus decoding the Game Mode subType, makes all three push-driven; the icons
react in milliseconds (the residual ~2s is the bud's own hardware debounce). Long
captures also proved that **no** poll reply ever contained a battery byte, so the
remaining 60-second poll is now a pure keep-alive.

## Repo contents

| File | What it is |
| --- | --- |
| [ROADMAP.md](./ROADMAP.md) | The priority list. Read this first if you want to help. |
| [**PROTOCOL.md**](./PROTOCOL.md) | **The wire format, end to end** — frame layout, every command, ANC, gestures, and the mistakes already made. Read before touching anything protocol-related. |
| [CREDITS.md](./CREDITS.md) | **Whose reverse-engineering this stands on, and which parts are ours.** Read before adding protocol constants. |
| [LICENSE](./LICENSE) | GPL-3.0. |

Everything else the developer works with lives under a git-ignored `local/` folder, so the
public repo stays readable:

| Path | What is in it |
| --- | --- |
| `local/NEXT-SESSION.md` | The session plan and handover note. **Deliberately not published** — it is a working note, and it does not travel with a clone. |
| `local/notes/` | Internal notes: the handoff document, the desktop Gradle export guide, the gesture-capture brief, open questions. |
| `local/logs/` | Packet captures and layout reports handed over for analysis. |
| `local/crashlogs/` | Crash reports pulled off the device. |
| `local/commits/` | Commit messages, because the commit box on the target device is too small to paste into. |
| `local/svgs/` | The source SVGs the three wear-icon drawables were traced from. |

There are no committed screenshots. This project is developed by an AI agent that **cannot read
images**, so screenshots are useless to it — for anything about geometry or spacing, a layout
report is captured instead. See *Reading the layout* below.

## Credits

The OPPO/OnePlus/realme earbud protocol was never publicly documented. Everything this project
knows about it came from people who reverse-engineered it first and published their work —
most of all [Zhaoyi-ya/OppoPodsManager](https://github.com/Zhaoyi-ya/OppoPodsManager), plus
[Leaf-lsgtky/OppoPods](https://github.com/Leaf-lsgtky/OppoPods),
[Star-ZER0/Pods-Protocol-Reverse-Engineering](https://github.com/Star-ZER0/Pods-Protocol-Reverse-Engineering),
[Zhaoyi-ya/OPPO-Pods-Win](https://github.com/Zhaoyi-ya/OPPO-Pods-Win) and
[ORION2809/DevPods](https://github.com/ORION2809/DevPods).

See **[CREDITS.md](./CREDITS.md)** for exactly what came from where, what is original to this
project, and a list of previously-wrong assumptions kept on purpose.

## License

GPL-3.0. See [LICENSE](./LICENSE). Protocol references are used as documentation; check
[CREDITS.md](./CREDITS.md) for the license of each source before copying text from it.
