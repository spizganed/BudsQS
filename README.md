# QuickBuds

> Lightweight, open-source control for OnePlus / OPPO / realme earbuds — direct RFCOMM, no bloat.
> Repo name: **QuickBuds** (renamed from `BudsQS`; old links redirect). App name: **QuickBuds**.

[![License: GPL-3.0](https://img.shields.io/badge/License-GPL--3.0-blue.svg)](./LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84.svg)]()

QuickBuds talks to your earbuds directly over a classic Bluetooth RFCOMM channel and undoes
everything the vendor app gets wrong. No HeyMelody, no Wearable app, no account, and no root,
Shizuku or ADB needed to use it. Every packet it sends was reverse-engineered and confirmed on
real hardware.

The app was built entirely on a phone (CodeAssist + Termux) through **v1.1.0**. Development has
since moved to a PC with Claude Code.

## Why this exists

Two frustrations with HeyMelody, specifically:

1. **The UI is white-only.** No dark or OLED option, on an app you open at night.
2. **There is no home-screen widget at all.** Checking ANC or battery meant opening the app.

The vendor apps are also heavy, account-bound and full of features nobody asked for. QuickBuds
implements only what the developer actually uses, and puts a real widget in front of it.

## Where it is going

The goal is **parity with HeyMelody's functionality**, with a better UI and a widget on top. Once
that is matched, this project's own improvements (the widget, the wear-state display) get built on
it. Only after that does support for other earbud models come into scope — other OnePlus / OPPO /
realme models first, since they share the protocol.

See [ROADMAP.md](./ROADMAP.md) for the ordered plan and what is already done.

## Features

**Connection and control**
- Direct RFCOMM to the earbuds (worked UUID `0000079A-D102-11E1-9B23-00025B00A5A5`, tried with fallbacks)
- Full init handshake, then the buds **push** battery, wearing, Game Mode and ANC changes to the
  app — no polling lag
- ANC: Off / Transparency / Adaptive / Light / Medium / Deep, with the Smart command ready
- Game Mode toggle that also follows bud-side gestures
- Auto-retry connection logic, so a busy earbud does not end the session

**Home-screen widget (4x2)**
- Battery bars for Left / Case / Right, always showing last-known values
- Wear icons that update from the buds' own pushes — milliseconds, not poll-bound
- Bud status: **full strength (theme colour)** = in ear, **grey** = out of ear
- Six-segment ANC switcher (Off / Trans / Low / Med / High / Adpt) plus a Game Mode row, working
  even with the app closed
- Nothing to configure; it reacts as fast as the hardware reports

**Earbud controls (per-bud gesture bindings)**
- Bind each bud's single / double / triple tap, slide and hold **separately**, because the two buds
  can be configured differently
- Bindings are **written to the earbuds** through a `0x0401` setKeyFunction write, then read back
  and diffed to confirm they took — a wrong command number fails silently, so the read-back is not
  optional
- Tap-and-hold is the one exception and is still incomplete: it is stored as the earbuds' own
  **ANC cycle**, and which modes that cycle contains is not in the key-function table at all. See
  *The ANC hold cycle* below

**App and service**
- Foreground service keeps the link alive. The notification is `IMPORTANCE_MIN` and swipeable;
  Android 15 requires it for a `connectedDevice` service, so it cannot be removed
- Quick Settings tile
- OLED Black and Dark themes. A Light theme still exists but is unmaintained — it is the source of
  several invisible-on-light bugs (white L/C/R letters), and it will either be removed or left
  untouched until the final UI lands
- Main screen: a battery card, the ANC switcher — four circles (Off / ANC / Adaptive /
  Transparency), where tapping ANC opens the Low/Medium/High chooser — and a settings card holding
  Game Mode (live), Hi-Res codec, spatial audio, Equalizer, Find my earbuds, Earbud controls and
  App update
- Dedicated screens: **Dev Tools**, **Equalizer**, **Find my earbuds**, **Earbud controls**,
  **App update**
- Dialogs are the app's own **bottom sheets**, so the theme picker, the ANC chooser and the gesture
  picker match the app's palette instead of the platform's

**Diagnostics**
- Packet logging: every sent command and every received frame, timestamped
- Dev Tools screen with a human-readable log and a raw-hex log, hold-to-copy, Mark / Clear /
  export-to-file, and Reconnect / Disconnect
- A **layout report** tool that dumps the measured view tree as text, and a **Screen** tool that
  turns a picked screenshot into ASCII / grid / colour / rows text. Both are currently slated to be
  hidden from the UI rather than deleted

> The main screen carries **no** log. Dev Tools owns logging; status events on the main screen are
> silent by design, because a toast on a packet-listener path storms the UI.

## How it works

```
Widget tap / app UI
      |
WidgetActionReceiver  ->  BudsService  ->  BudsConnectionManager (RFCOMM)
                                                  |
                                     OppoPacketFramer (AA framing)
                                                  |
                              OpoProtocol: handshake, queries, the 0x0205 event
                              registration, ANC / GameMode / codec / spatial builders
                                                  |
              WearingStatusParser / BatteryParser / GameModeParser -> state
                                                  |
                              WidgetStateStore -> AncWidgetProvider (refresh)
```

**The protocol is documented end to end in [PROTOCOL.md](./PROTOCOL.md)** — frame layout, every
command, the ANC tables, gestures, and the mistakes already made. Read it before touching anything
protocol-related. A few facts worth knowing up front, because each one cost real time:

- Battery is query `0x0106`; wearing is query `0x0109`. (These were written as `0x01F0`/`0x01F2`
  for a long time, which is wrong — those are the command byte welded to its sequence value.)
- `0x0205` makes the buds push `0x0204` events. Its payload is a **count** byte followed by event
  ids, and getting that shape wrong fails silently: `01 01 02 02` reads as "count=1, battery only",
  so wear events never arrive.
- **The SET and NOTIFY encodings for ANC are different tables** and are not supposed to agree.
  Setting uses bit 0 = Off and bit 2 = Transparency; the buds *report* Off as bit 3 and
  Transparency as bit 8.
- **Adaptive's SET mask is `0x0800` (bit 11), not bit 8.** The build passed `8` once and sent
  `01 01 00 01`, a *different mode*. Its payload is `01 01 00 08`.
- Closing the lid with the buds docked kills the RFCOMM socket, and that is used as a lid signal.

### The ANC hold cycle

Tap-and-hold is bound to a single "ANC cycle" function, and that is all the key-function table
stores — no membership, no mode list. The developer bound the hold to two modes once and four
another time, and the stored byte was `0x08` both times; clearing it to `0x00` did not stop the
cycle either.

That does not make the mode list unreachable. The buds hold a *changeable* list, and the protocol
exposes it through a different command — `setSupportNoiseReduction` (`0x0404`, payload
`[action=2][noiseType][modeMask LE]`), read back with `0x010C` payloads `02 01` / `02 03` / `02 04`.
The app currently only *sends the read*; nothing writes it yet, and no capture has ever shown a
`0x810C` answer to `02 01`, so the reply's shape is unknown. Confirming that read on the device is
the next step — see [PROTOCOL.md](./PROTOCOL.md) §5 and [ROADMAP.md](./ROADMAP.md).

## Requirements and tested setup

- Android, developed and tested on a **Nothing Phone (3a) running Android 15**
- **OnePlus Buds 4**, firmware `B4.1-260810-1153`. Other OnePlus / OPPO / realme buds likely work,
  since the protocol is shared, but they are untested
- The earbuds must already be paired in system Bluetooth settings — the app connects to paired
  buds, it does not pair them for you

## Repo contents

| File | What it is |
| --- | --- |
| [ROADMAP.md](./ROADMAP.md) | The plan: what is next, in order, and what is already done. |
| [AGENTS.md](./AGENTS.md) | How the project is built and worked on — toolchain, conventions, and the mistakes already paid for. |
| [PROTOCOL.md](./PROTOCOL.md) | The wire format end to end. Read before touching anything protocol-related. |
| [CREDITS.md](./CREDITS.md) | Whose reverse-engineering this stands on, and which parts are ours. |
| [PACKET-CAPTURE.md](./PACKET-CAPTURE.md) | The capture procedure, kept as a backup for protocol work. |
| [DeepSeek_CodeAssist_memory.md](./DeepSeek_CodeAssist_memory.md) | The working memory carried over from the mobile/CodeAssist era. Temporary — the current agent is absorbing it and will remove it. |
| [LICENSE](./LICENSE) | GPL-3.0. |

Everything else lives under `local/`, which is tracked while the workflow moves to the PC:

| Path | What is in it |
| --- | --- |
| `local/logs/` | Packet captures and layout reports handed over for analysis. |
| `local/crashlogs/` | Crash reports pulled off the device. |
| `local/svgs/` | The source SVGs the wear-icon drawables were traced from. |
| `local/NEXT-SESSION.md` | A working session note from the mobile era. Historical. |

There are no committed screenshots.

## Credits

### The protocol was reverse-engineered by others first

The OPPO / OnePlus / realme earbud protocol was never publicly documented. Everything this project
knows about it stands on people who worked it out first and published their results:

| Project | What we owe it |
| --- | --- |
| [**Zhaoyi-ya/OppoPodsManager**](https://github.com/Zhaoyi-ya/OppoPodsManager) | The single biggest source. Frame layout and LEB128 length encoding, most of the command table, the ANC set and notify tables, the key-function entry shape, feature IDs. |
| [**Star-ZER0/Pods-Protocol-Reverse-Engineering**](https://github.com/Star-ZER0/Pods-Protocol-Reverse-Engineering) | Independent confirmation of the framing, and the broadcast-codes idea that proved our ANC subscription fix was right. (CC-BY-SA-4.0 — documentation only.) |
| [Leaf-lsgtky/OppoPods](https://github.com/Leaf-lsgtky/OppoPods) | Early OPPO earbud protocol work; origin of some of the framing knowledge. |
| [Zhaoyi-ya/OPPO-Pods-Win](https://github.com/Zhaoyi-ya/OPPO-Pods-Win) | Cross-check on which features exist per device model. |
| [ORION2809/DevPods](https://github.com/ORION2809/DevPods) | A second implementation of the same vendor family; useful for cross-checking. |

Sibling projects solving the same problem for other brands — not sources for our protocol, but
worth knowing: [elaxptr/baseus-desktop](https://github.com/elaxptr/baseus-desktop), a Windows client
for Baseus earbuds.

### How this was actually built

- The project **started on DeepSeek chat** — the first codebase, the first reverse-engineering
  steps, the basic UI, packet logger and a basic ANC-button widget. **That first widget was later
  rewritten almost entirely**; treat the early history as scaffolding.
- It then moved to the **CodeAssist agent, via OpenRouter, running DeepSeek v4.1-fast**, which wrote
  roughly **80%** of what is here now. DeepSeek chat accounts for about **15%**; Kimi, Gemini (image
  generation) and Grok did the remaining small tasks.
- From **v1.1.0 and the last commit of that era onward**, development moved to a PC and to
  **Claude Code**, which is where the work continues.
- **Everything ran on free tiers.** No paid API budget was involved.

Every model involved reasoned about protocol bytes captured on real hardware. The captures and the
on-device testing are what make the claims in [PROTOCOL.md](./PROTOCOL.md) checkable, and they are
the part a language model cannot supply on its own.

### Tools

CodeAssist (on-device IDE) · Termux · decompile.com (HeyMelody) · GitHub mobile — for everything up
to and including v1.1.0. Now: Claude Code on a PC, with Gradle and adb.

See **[CREDITS.md](./CREDITS.md)** for exactly what came from where, what is original to this
project, and a list of previously-wrong assumptions kept on purpose.

## License

GPL-3.0. See [LICENSE](./LICENSE). Protocol references are used as documentation; check
[CREDITS.md](./CREDITS.md) for the license of each source before copying text from it.
