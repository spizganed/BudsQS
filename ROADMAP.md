# QuickBuds — Roadmap & Plan

**What this file is.** A checklist of plans: what is planned, in what order, and whether it is
done, partly done, or still undecided. It is written for the developer to remember his own plan,
and it is the first thing the agent should read to know what to work on next.

**How to read it.**

- Status words: **Done**, **Partly**, **Next**, **Undecided**, **Parked**.
- There is no release targeting. Releases happen when the developer feels the app is ready;
  nothing here is marked "must ship in version X".
- **Protocol findings do not live here.** They belong in [PROTOCOL.md](./PROTOCOL.md), which is the
  single reference for the wire format. Where an item below depends on protocol work, it points there.
- Screenshots and log files are not committed. Working material lives in `local/` — see the
  transfer note at the end.

## State of play: mobile → PC

- **v1.1.0 is the last release built entirely on the mobile workflow** — Nothing Phone (3a),
  Android 15, CodeAssist, Termux, GitHub mobile. That is commit `2875262`.
- The project has now **moved to Claude Code on a PC**. CodeAssist is no longer the build
  environment, and none of its prerequisites or dependencies apply any more.
- The build is plain desktop Gradle from here: **AGP 8.13.0, Kotlin 2.4.0, Gradle 8.13**,
  compileSdk 36 / minSdk 26 / targetSdk 35, Java 8, one dependency (`androidx.core:core:1.13.1`).
- Source, docs and build files live on **GitHub**. Only logs and other debug documents stay local.

## Working principles

- **Feature philosophy — the north star is parity.** Match HeyMelody as much as possible first,
  then expand with this project's own ideas and improvements (the widget, the wear-state display).
  Support for other earbud models is considered only after that, through the HeyMelody app and its
  protocol — other OnePlus / OPPO / realme models first, since they share it.
- **Who does what.** Human: device testing, git operations, publishing, design decisions.
  Agent: reverse-engineering, parsers, protocol work, code.
- **App identity.** Package `com.spizganed.quickbuds` (final). App name **QuickBuds**, renamed from
  BudsQS — old repo URLs redirect.
- **AI attribution** (full history in README + CREDITS): the project began on DeepSeek chat (~15% —
  first codebase, first reverse-engineering steps, basic UI/logger/widget; that widget was later
  rewritten almost entirely), then moved to the CodeAssist agent via OpenRouter running DeepSeek
  v4.1-fast (~80% of the current code). Kimi, Gemini (images) and Grok did small odd jobs. From
  this release and the last commit onward, development is handed to **Claude Code on PC**.

## Next up, in order

1. **Finish the hold gesture — the last broken piece of gesture configuration.** Everything else in
   "Earbud controls" works and writes to the buds. The hold is different: its stored function byte
   cannot select a mode. The mode list belongs to `setSupportNoiseReduction` (`0x0404`), read back
   through `0x010C` payloads `02 01` / `02 03` / `02 04`. **Confirm that read on the device first** —
   no capture has ever shown a `0x810C` answer to `02 01`, so the reply shape is unknown — then build
   the picker on it. See PROTOCOL.md §5 and §6.
2. **Spatial sound.** The commands exist; decide which one the firmware honours (the legacy feature
   `0x1B` vs the newer three-mode `0x0422`). Unverified today.
3. **Codec switching (Hi-Res).** The row currently toggles only its own subtitle. Needs a capture of
   the reference implementation to find the feature id (LHDC) before it can be wired honestly.
4. **Find my earbuds.** The screen exists and plays the locating chime; volume and duration are not
   tunable yet.
5. **Equalizer — last in the parity chain.** Six bands (62/250/1k/4k/8k/16k Hz), ±6 dB, presets
   (Balanced / Clear Vocals / Bass), custom presets with rename, and BassWave dynamic bass with an
   intensity slider. The screen is a placeholder today: presets are not sent to the buds.
6. **Dual device** — expected quick. Two devices connected, with a switch.
7. **On-call gestures** — add them. (This reverses the earlier "never" decision; parity wins.) The
   screen currently has no on-call section at all.
8. **Auto play/pause on wear** — two parts: (a) a switch in the UI that tells the firmware to react
   by itself (`autoPlayPauseOn` / `autoPlayPauseOff` already exist in the manager); (b) our own
   implementation on top — **pause only when both buds are out of the ear; a single bud out keeps
   playing; never auto-play, only pause.**
9. **Golden Sound** — spike only. A one-time hearing test that probably produces an EQ profile. It
   may be hard or impossible through this protocol; find out before promising it.

## The final UI

- **Full app UI** — bottom navigation (Device / Earbud controls / About) like the original app's
  structure, in the finished widget's style, carrying only the wanted functions. Last by design; the
  remaining screens are slotted in as it grows.
- **Theming is not properly finished**, and the Light theme is the known offender — it is the source
  of invisible-on-light bugs, e.g. white L/C/R letters. Decision: either remove it, or leave it
  exactly as it is until the final UI lands. Do not polish it in the meantime.
- **The widget is on hold** until the final UI and full HeyMelody parity. The decided colour rule
  (in-ear full strength, out-of-ear grey, in-case full strength, all theme-aware) is therefore not
  implemented in the widget yet.

## Undecided

- **Case lid state** — the buds or case may report lid open/closed, but it is not established. Keep
  as is, remove, or change: **not decided.** The case code and `ic_case.xml` stay until then.
- **When the next release happens** — by feel, not by schedule. There is no version target.

## Parked

- **Lock screen widget** — feasibility only, low importance.
- **Screenshot-to-text tool** — remove from the UI, or hide it. Keep the logic; it may be useful
  again someday.
- **Layout report tool** — same treatment: remove or hide it from the UI, keep the logic.
- **Other earbud models** — after parity.

## Known loose ends

- Localisation: all user-facing text is in `strings.xml`, but only `values/` (English) exists, and
  hardcoded strings remain in `MainActivity` dialogs (crash report, Bluetooth permission), the
  Dev Tools labels and legend, and `BottomSheetDialog` callers.
- Slide up vs slide down: both directions are written with the same action, because which is which
  is not established. Harmless, worth settling.
- The app is **not signed** at all yet — the installer warns the user on first install. Revisit later.
- The in-app updater should check the latest GitHub release, download it, and start the update when
  it is ready.

## Decided against — do not re-suggest

- **Guessing protocol payloads before a capture.** This has cost real time more than once; see
  PROTOCOL.md's "History of Getting This Wrong".
- **Hardcoded gesture button groups.** The buds' slot layout differs per bud and changes itself, so
  the write must be table-driven — every slot the bud actually has.
- **A log on the main screen.** Status events there are silent by design; the Dev Tools screen owns
  logging.
- **Removing the foreground-service notification.** Android 15 requires it for a `connectedDevice`
  service, and the only real fix would cost the instant push updates.
- **Committing logs, screenshots or debug documents to GitHub.**
- **Marking roadmap items "must ship in version X".**

## Done

Foundation & debugging:

- Packet logging foundation — every received `AA` frame and sent command, timestamped.
- Bud icon states on the widget: in case / grey out-of-ear / full strength in-ear.
- Battery rows show last-known values, updated on every hardware packet.

Push and control:

- Wear, battery and Game Mode are all pushed by the buds; the 60s poll is only a keep-alive now.
- ANC gesture sync — bud-side ANC changes light the app's circles and the widget.
- Adaptive is a fourth ANC surface (main-screen circle, widget segment, Quick Settings tile), and
  its SET payload is fixed.
- Dev Tools screen — human-readable log, raw-hex log, Mark / Clear / Export, Reconnect / Disconnect.
- Settings card and secondary screens (EQ, Find my earbuds, App update, chime player).
- Gesture configuration ("Earbud controls") — writes to the buds, verified on the device; the
  function values were measured, not guessed. The hold is the one part still open (Next up #1).

Appearance and tooling:

- Adaptive launcher icon; the bud artwork is traced from source SVGs and used verbatim; the widget
  preview is decoupled from the launcher icon.
- Battery icon alignment fixed by fill fraction, not by eye.
- PROTOCOL.md and CREDITS.md written.
- Layout-report and screenshot-to-text tools built (both now parked — see *Parked*).
- `local/` folder created so working material stays out of the repo root.

## Build and transfer notes

- **Build and run:** Gradle on PC. No CodeAssist prerequisites — the toolchain is Gradle 8.13 +
  AGP 8.13.0 + Kotlin 2.4.0.
- **adb over USB** pushes the `.apk` to the device and is the debugging path. On-device logs, and
  the Dev Tools output that cannot be reached from the PC, move to `local/logs` at the root.
- `local/commits/` (commit-message files) is no longer needed now that commits are made on PC.
- `local/` is brought onto GitHub **temporarily**, to carry the workflow across to the PC. Logs and
  other pure debug documents stay out.

**Docs:** [README.md](./README.md) is the accurate feature summary. [PROTOCOL.md](./PROTOCOL.md) is
the wire format end to end — read it before touching anything protocol-related.
[CREDITS.md](./CREDITS.md) is whose reverse-engineering this stands on.
