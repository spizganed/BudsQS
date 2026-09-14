# BudsQS

> **Working title.** The repo/app is currently called *BudsQS* — a placeholder until a better name lands.

A lightweight, standalone Android app for controlling **OnePlus / OPPO / realme** Bluetooth earbuds directly over RFCOMM — no HeyMelody, no Wearable app, no root, no Shizuku, no ADB permissions. Install, run, done.

It speaks the earbuds' private OPPO protocol directly, giving you ANC control, battery readout, game mode, and a home-screen widget / Quick Settings tile that work **even when the app is closed**.

---

## Features

- **ANC control** — Off, Noise Cancellation, Transparency, plus Smart / Deep / Medium / Light sub-modes
- **Live battery** — Left / Right / Case with charging state, polled every 5s
- **Game Mode** — low-latency toggle
- **Home-screen widget** — 4 buttons + battery, functional while the app is closed
- **Quick Settings tile** — ANC toggle straight from the QS panel
- **Foreground service** — keeps the connection alive and survives the app being swiped away
- **Bud state** — detects which bud is in / out / in the case
- **Themes** — OLED, Dark, Light

---

## Requirements

- Android device with Bluetooth Classic (RFCOMM) support
- **Tested on:** Nothing Phone (3a), Android 15, latest stock firmware
- **No root. No Shizuku. No ADB. No special permissions beyond normal install.**
- Earphones: **OnePlus Buds 4** (tested). Other OPPO / OnePlus / realme buds using the same protocol may work — untested.

---

## Install

1. Download the latest APK from the [Releases](../../releases) page.
2. Install it (you may need to allow "Install unknown apps" for your browser/file manager).
3. Open the app, grant the Bluetooth permissions it asks for.
4. Make sure your earbuds are already **paired** in system Bluetooth settings — the app connects to paired devices, it does not pair them for you.

The app connects automatically once the earbuds are paired and nearby.

---

## Usage

- **In-app:** open the app for full controls (ANC, battery, game mode, themes).
- **Widget:** add the BudsQS widget to your home screen. The four buttons control ANC and Game Mode; the battery row updates live. Works while the app is closed.
- **Quick Settings:** add the BudsQS tile from the QS edit screen for a one-tap ANC toggle.

---

## Build from source

```bash
git clone https://github.com/spizganed/BudsQS.git
cd BudsQS
./gradlew assembleDebug
```

The APK lands in `app/build/outputs/apk/debug/`.

Built with the [CodeAssist IDE](https://github.com/TyronNeo/CodeAssist) on Android.

---

## Protocol (brief)

Communication uses **Bluetooth Classic RFCOMM** on UUID `0000079A-D102-11E1-9B23-00025B00A5A5`, with a fallback to RFCOMM channel 15.

Packet frame:

```
AA [TotalLen] 00 00 [Cmd LE] [Seq] [PayLen LE] [Payload...]
```

Key commands:

| Function        | Cmd    |
|-----------------|--------|
| Handshake       | 0x0100 |
| Product ID      | 0x0103 |
| Broadcast codes | 0x0200 |
| Status query    | 0x010D |
| Battery query   | 0x0106 |
| ANC query       | 0x010C |
| Set ANC         | 0x0404 |
| Set feature     | 0x0403 |

Battery values are `[Index, RawValue]` pairs — `level = val & 0x7F`, `charging = (val & 0x80) != 0`. Index `1` = Left, `2` = Right, `3` = Case.

For a deeper protocol write-up, see the reference projects credited below.

---

## Credits

This project would not exist without the reverse-engineering work done by others. The protocol was deciphered with the help of:

- **[Leaf-lsgtky/OppoPods](https://github.com/Leaf-lsgtky/OppoPods)** — OPPO earbud protocol reverse engineering
- **[Zhaoyi-ya/OppoPodsManager](https://github.com/Zhaoyi-ya/OppoPodsManager)** — OPPO earbud protocol reference and feature implementation

Their source was cloned and used as reference material while building BudsQS. Because of that, **BudsQS is licensed under GPL-3.0**, the same license as both projects above.

Built with:
- [CodeAssist IDE](https://github.com/TyronNeo/CodeAssist) by Tyron

---

## License

**GPL-3.0** — see [LICENSE](LICENSE).

You are free to use, study, modify, and redistribute this project, including commercially, **as long as** any derivative work is also released under GPL-3.0 and credits the original authors.

---

## Status

- Working — all core features functional.
- The package name (`com.example.oneplusbudsqs`) is temporary and will change when the UI is redesigned.
- The widget and UI are due for a visual redesign.