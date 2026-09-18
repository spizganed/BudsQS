QuickBuds v1.1.0

**Second public release — and in practice a rebuild.** v1.0.0 shipped on 2026-09-14 as an early
BudsQS: a bare-bones screen with ANC mode switching and Game Mode, a 5-second battery poll, a
four-button widget, and the package name `com.example.oneplusbudsqs`. Since then the app has
been rebuilt — nearly every file has changed, and almost nothing below the name is the same.

> Renamed from **BudsQS** to **QuickBuds**. Old links still redirect.

**Tested on:** Nothing Phone (3a), Android 15, latest stock firmware + OnePlus Buds 4
**Requires:** Android with Bluetooth Classic; earbuds already paired in system Bluetooth
settings (the app connects to paired buds — it does not pair them for you)

---

### New — control

- **Earbud controls — bind gestures per bud.** Single / double / triple tap, slide and hold,
  configured separately for left and right. Choices are **written to the earbuds** and read
  back to confirm, not just stored on the phone. Tap-and-hold takes none or at least two
  actions, and cycles through them.
- **Adaptive** is its own ANC button on the main screen, beside Off / ANC / Transparency —
  plus a widget segment and a place in the Quick Settings tile's cycle.
- **Find my earbuds** — play a locating chime on one bud, with strict volume limits and a
  channel split by silence so only the chosen bud can hear it.
- **Equalizer** screen (present as a destination; presets are not sent to the buds yet).
- **App update checker** — checks this repo's GitHub releases and hands the APK to Android's
  own installer. Never runs on its own; only when you press it.

### New — interface (rebuilt)

- **The main screen was redesigned end to end.** A battery card with the bud/case artwork, a
  circular ANC switcher (tap ANC for the Low/Medium/High chooser), and a settings card with
  rows for Game Mode, Hi-Res codec, 3D audio, Equalizer, Find my earbuds, Earbud controls and
  App update. At v1.0.0 the screen was buttons and a battery line.
- **The widget was rebuilt.** Vector icon artwork, in-ear / out-of-ear / in-case bud states,
  and a six-segment ANC switcher with a Game Mode row — against v1.0.0's four buttons.
- **Theming was reimplemented.** v1.0.0 did have OLED / Dark / Light, but it applied them by
  walking the inflated view tree after the fact and setting a colour on each `TextView` and
  `Button`. That cannot express the redesigned UI — a settings row is a card, an ANC button is
  a segment — so the palette moved into theme attributes and resources, where it is read while
  the view tree is inflated. The Light theme is slated for removal: it is the source of
  several invisible-on-light bugs.
- **Own bottom sheets** instead of platform dialogs, so the theme, ANC and gesture pickers
  match the app's palette.
- **New Dev Tools screen** — a human-readable log and a raw-hex log, hold-to-copy, Mark /
  Clear / export-to-file, and Reconnect / Disconnect. Plus two tools for describing the UI
  without a screenshot: a **layout report** (the measured view tree as text) and a **Screen**
  button that converts a picked screenshot into text (brightness map, numeric grid, colour
  grid, row profile).
- **New icon set throughout** — the app's own vector artwork traced from source SVGs, a new
  adaptive launcher icon with a monochrome layer for themed icons, and reworked status and
  notification icons.
- **New screens** — Dev Tools, Equalizer, Find my earbuds, Earbud controls, App update.
- **Header connection pill** (dot + word), and fade / scale / slide animations on the battery
  card and its icons.

### New — reliability

- **Crash reporting.** Uncaught exceptions now write a full stack trace to three places,
  including `Download/QuickBudsCrash/`, so a report is reachable even when the app will not
  start. The next launch offers it for copying or sharing.
- **Log and capture export** to `Download/QuickBudsLogs/` through MediaStore, so files are
  visible to any file manager without storage permissions.
- **Auto-retry connection logic**, and clean handling of the socket dying when the case lid
  closes with the buds docked.

### Engine and protocol (mostly invisible, all of it load-bearing)

- **Everything is push-driven now.** v1.0.0 polled battery every 5 seconds and that was the
  only way anything updated. The buds now *push* battery, wearing state, Game Mode **and**
  ANC, so the app and widget react in milliseconds. The poll is a 60-second keep-alive.
- **Wear events fixed.** The subscription payload is count-first, and the old literal
  registered battery only — which the firmware accepted while silently sending nothing. That
  is why bud icons used to lag by seconds.
- **Game Mode push decoded** (`0x0204` subType `0x05`), so a bud-side gesture now updates the
  widget and the app's buttons.
- **ANC push decoded** (`0x0204` subType `0x03`). v1.0.0's code believed ANC raised no event
  at all — that was wrong, and it is why ANC sync took so long to land.
- **Gesture table read and write** (`0x0108` / `0x0401`), including measured action values
  found by diffing two real readings rather than guessing.
- **Lid detection** and the battery/game-mode push work.
- **`PROTOCOL.md`** — the wire format end to end, every claim tagged by how it is known
  (vendor / open-source / our capture / guess). **`CREDITS.md`** — whose reverse-engineering
  this stands on, what is original, and the assumptions already proven wrong. **`LICENSE`** —
  GPL-3.0.

### Fixed

- **The gesture write command is `0x0401`, not `0x0402`.** `0x0402` is ignored by the buds in
  complete silence — no error, no ack, no change.
- **Slide writes aimed at the wrong button group,** which is why slide worked once and then
  silently stopped. The two buds have *different* table shapes for slide — one keeps it in
  `btn 0x01`, the other splits it across `0x02` / `0x03` — so any hardcoded group is wrong half
  the time. Writes are now table-driven.
- **Adaptive was sending the wrong packet.** Built as bit index 8 it produced `01 01 00 01` —
  a *different mode*. Adaptive is mask `0x0800`, i.e. **bit 11**; the correct payload
  `01 01 00 08` is now written literally.
- **The log mislabelled it too**, so a corrected Adaptive command would have printed as
  `Unknown (0x0800)` — the one line you would read to check it.
- **The `0x8108` gesture reply had an off-by-one:** its first byte is a *status* byte, not the
  entry count, so the parser read zero entries and shifted everything by one.
- **The ANC SET bit table was wrong for Off and Transparency.** SET and NOTIFY use different
  encodings; they had been wrongly unified, which sent the wrong bits.
- **The poll latch was never cleared on disconnect,** so every reconnect logged "Polling
  already running" and quietly depended on the previous session's executor still being alive.
- **Transparency did nothing** when tapped — the handler only accepted one of the two
  spellings the UI used, and fell through with no `else`, so no command was sent.
- **Battery icon sizing** (two separate geometry bugs), balanced battery-card halves, and the
  layout report's sibling-gap calculation. The case icon drew ~20% larger per unit than the
  buds; the launcher icon filled only 77% of its safe zone and read undersized.
- **The Dev Tools toolbar** put seven buttons plus a title in one non-wrapping row — ~480dp of
  buttons in ~330dp — so the last ones were clipped off the edge. It also had `Shot` / `Widg` /
  `Wlog` labels, which meant nothing unless you already knew the tools.
- **The widget could show "Can't load widget"** because its declared footprint did not match
  what the launcher actually hands over.
- **Hold no longer writes a lie.** Clearing the hold's function byte does *not* stop the ANC
  cycle (measured on the device), so an empty hold selection now sends nothing rather than
  making the stored table disagree with what the gesture really does.

### Notes

- **Gesture-the-hold mode list:** which modes the hold cycles through is *not* in the
  key-function table — the buds own it. The app cannot set it yet. The command that can
  (`setSupportNoiseReduction`, `0x0404`) is documented in PROTOCOL.md §5 but deliberately
  left unwired until its read side is confirmed on hardware.
- **Settings reset once:** the preferences file was renamed with the project. Theme choice and
  saved gesture selections return to their defaults on first launch of this build.
- **Version reporting was broken before this release.** v1.0.0 declared no version at all, and
  the builds after it declared `0.4.0` in the manifest while the build config said `1.0` — the
  manifest is the one that ships, so an installed app reported `0.4.0` while the release was
  tagged `1.0.0`. Both now say `1.1.0`.
- **Still OnePlus Buds 4 only**, tested. Other OnePlus / OPPO / realme buds use the same
  protocol and may work, but are untested. Support for more models is a goal, not a promise.
- **Placeholder rows remain:** Hi-Res codec, 3D audio and the equalizer presets are wired to
  real commands where known, but are not confirmed on this firmware.

### Architecture

Still 100% on-device: no root, no Shizuku, no ADB, no vendor account, and no network access
needed to function — the only network call is the update check you trigger by hand. Direct
RFCOMM to the buds, built with CodeAssist + Termux on a phone. No desktop toolchain involved.

Protocol notes, including the mistakes above and how each was found, are in
[PROTOCOL.md](./PROTOCOL.md).

Licensed GPL-3.0.
