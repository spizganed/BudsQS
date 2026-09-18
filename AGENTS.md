# AGENTS.md — working notes for this project

**Read this before touching anything.** It carries the state that is not derivable from the code:
the toolchain, the conventions, the mistakes already paid for, and what is currently open.

## What this project is

**QuickBuds** — an Android app that controls OnePlus / OPPO / realme earbuds directly over classic
Bluetooth **RFCOMM**, with no HeyMelody, no vendor app, no root, no Shizuku, no ADB. Kotlin.

- Package `com.spizganed.quickbuds` (final). App name **QuickBuds**, renamed from **BudsQS** — old
  repo URLs redirect. GitHub: `spizganed/QuickBuds`, branch `main`.
- License **GPL-3.0**. Test device: **OnePlus Buds 4** on a **Nothing Phone (3a), Android 15**.
- Single module, `:app`. All sources are Kotlin under `app/src/main/kotlin/`; no Java.

**The north star is parity with HeyMelody**, then this project's own improvements on top (the widget,
the wear-state display). Only after that, other earbud models.

## Read order

| File | What it is |
|---|---|
| [START-HERE.md](./START-HERE.md) | **The entry point for a new session.** Read order, PC setup, and the first task. Temporary — delete it once the move is settled. |
| [ROADMAP.md](./ROADMAP.md) | The plan: what is next, in order, and what is done or undecided. |
| [PROTOCOL.md](./PROTOCOL.md) | **The wire format, end to end.** Read before any protocol work. |
| [DeepSeek_CodeAssist_memory.md](./DeepSeek_CodeAssist_memory.md) | The previous agent's memory, carried over from the phone. Absorb what is useful, then delete it — it is NOT authoritative. See the cleanup checklist below. |
| [README.md](./README.md) | The accurate feature summary. |
| [CREDITS.md](./CREDITS.md) | Whose reverse-engineering this stands on. Add a row when you add a constant. |
| [PACKET-CAPTURE.md](./PACKET-CAPTURE.md) | How to capture a packet log, kept as a backup procedure. |
| AGENTS.md | This file — the durable reference, loaded automatically. |

## Build and run

Plain desktop Gradle. There are no CodeAssist prerequisites or dependencies any more.

- **Toolchain:** Gradle **8.13** · Android Gradle Plugin **8.13.0** · Kotlin **2.4.0**
- **SDK levels:** `compileSdk 36`, `minSdk 26`, `targetSdk 35`, Java 8
- **Only dependency:** `androidx.core:core:1.13.1`
- `./gradlew assembleDebug` → `app/build/outputs/apk/debug/app-debug.apk` — **use this one.** There
  is no signing config, so a release build comes out unsigned and will not install (see *Signing*).
- `./gradlew assembleRelease` → `app/build/outputs/apk/release/app-release-unsigned.apk`
- `./gradlew bundleRelease` → `app/build/outputs/bundle/release/app-release.aab`
- Deploy with `adb install -r <apk>`. **adb over USB is the debugging path**; use `adb logcat` for
  anything the in-app logs do not show.
- `local.properties` must contain `sdk.dir=...`; it is git-ignored and must not be committed.

### Environment you need

Everything below is a one-time PC setup. Nothing here was recorded anywhere before the move,
because the phone side had it all built in.

| Need | Version / note |
|---|---|
| JDK | **17 or newer** — required by AGP 8.13. Set `JAVA_HOME`. |
| Android SDK | `platforms;android-36` (for `compileSdk 36`) and `platform-tools` (for adb). `build-tools` matching AGP. |
| Gradle | Only to generate the wrapper (below). After that `./gradlew` is self-sufficient. |
| adb | For deploying to the phone and reading `logcat`. |
| kotlin-stdlib | **No** manual install — it comes with the Kotlin Gradle plugin. The only app dependency is `androidx.core:core:1.13.1`. |

### First run on the PC

The build files are committed, but **the wrapper scripts are not yet generated** — this project
never had a `gradlew` (CodeAssist drove the build itself), so the first step on the PC is to create
them once:

```bash
gradle wrapper --gradle-version 8.13     # writes gradlew, gradlew.bat, gradle-wrapper.jar
./gradlew assembleDebug                  # first real build
```

Set `sdk.dir` in a local `local.properties` (or export `ANDROID_HOME`). `local.properties` is
git-ignored — never commit it.

The wrapper JAR and scripts **should be committed** afterwards, so nobody needs a local Gradle
install or a matching Gradle version again. **Commit them as a follow-up, and note in the commit
that they are generated.** They are the one piece of the build that is not yet in the repo.

**The first build also downloads a lot** — Gradle 8.13, AGP, and the Kotlin plugin. That is expected,
not a stall.

**Expect a Kotlin-metadata warning on the first build.** Kotlin 2.4.0 is newer than the D8/R8 that
AGP 8.13.0 bundles, which warns that it cannot rewrite the newer metadata. It is a warning, not an
error — the build succeeds. Raising the AGP version clears it.

Two things were carried over from the mobile setup that are no longer load-bearing on the PC:

- **`app/module.toml`** is CodeAssist's project model. It is git-ignored (not in the repo) and the
  Gradle build does not read it. It is still present in the working copy only so the on-device
  CodeAssist build keeps working until the PC workflow is fully settled. Ignore it; delete it when
  you are confident the phone is no longer needed.
- **`.platform/`** is CodeAssist's own cache and settings, including the generated Gradle export
  this repo's build files were based on. Also ignored. Nothing on the PC reads it.

### Signing — there is none

There is **no release signing config** and no keystore in the project — the developer has decided
not to sign yet, and sideloaded installs simply raise the usual "unknown app" / Play Protect
warning on first install. Do not add a keystore without being asked.

**This is the first thing that will bite on the PC.** The CodeAssist build signed its output
in-process, so `androidRun:app:release` produced an installable APK. Plain Gradle does not: with no
`signingConfig`, `./gradlew assembleRelease` emits **`app-release-unsigned.apk`, which Android will
refuse to install**. Until a keystore exists, build and deploy with the **debug** variant
(`./gradlew assembleDebug`, or `assembleRelease` only once a signing config is added) — do not
report "the release APK is fine" without checking that it is signed.

When signing is eventually set up: the key must be kept, because **the in-app updater can only
install over an app signed with the same key**. Losing it means every installed copy has to be
uninstalled first.

### Versioning — the manifest is the single source of truth

`versionCode` / `versionName` are declared **only** in
`app/src/main/AndroidManifest.xml` on `<application>`. `app/build.gradle.kts` deliberately does
**not** set them (see the comment there), so there is exactly one place to edit and nothing to keep
in step.

This is a fix, not a preference. On the mobile setup the version was declared twice — in
`app/module.toml` (CodeAssist's project model, now retired and not in the repo) and in the manifest
— and the two drifted apart:

- v1.0.0 declared **no version at all**.
- A later build put **0.4.0 in the manifest** while `module.toml` said `1.0`, so the installed app
  reported 0.4.0 while the release was tagged 1.0.0.

**Current: versionCode 2 / versionName 1.1.0.** Verify what actually ships in
`app/build/intermediates/android/release/merged-manifest/AndroidManifest.xml`, not in a source file.
`UpdateActivity` reads the installed version through `PackageManager`, deliberately, because the
generated build script did not always emit a `BuildConfig` (and `buildConfig` is still off — see
`app/build.gradle.kts`).

### Release flow

The in-app updater (`UpdateActivity`) compares the **GitHub release tag** against the installed
version and requires an **`.apk` asset** on the release. A `.aab` alone is invisible to it, so an
APK must be attached as well. v1.1.0 is live with `QuickBuds1.1.0.apk` attached.

## History: mobile → PC

Everything up to and including **v1.1.0** (commit `2875262`) was written on a **mobile-only
workflow** — Nothing Phone (3a), CodeAssist IDE, Termux, GitHub mobile. Work has since moved to
**Claude Code on a PC**, with Gradle and adb. Attribution: DeepSeek chat (~15% — first codebase,
first RE steps), the CodeAssist agent via OpenRouter on DeepSeek v4.1-fast (~80% of the current
code), Kimi / Gemini / Grok for small tasks, then Claude Code from here on.

**Some habits below are CodeAssist artefacts. They are marked, and they do not apply on PC.**

## Protocol work — the rules that were paid for

Use [PROTOCOL.md](./PROTOCOL.md) as the reference; it tags every claim `[VENDOR]` / `[OSS]` /
`[CAPTURE]` / `[GUESS]`. The short version of what bites:

- **Never guess a payload.** Confirming a read is cheap; a guessed write to the buds fails
  silently. This is the single most expensive mistake in the project's history — see PROTOCOL.md's
  "History of Getting This Wrong".
- **The SET and NOTIFY ANC encodings are different tables** and are not supposed to agree.
- **Adaptive's SET mask is `0x0800` (bit 11), not bit 8.** Its payload is `01 01 00 08`. The value
  `8` produced `01 01 00 01`, a different mode. Derive an index from the mask, never from a mode's
  position in the vendor's list.
- **`0x01F0` / `0x01F2` are not commands.** They are the command byte welded to its SEQ value. The
  real numbers are **`0x0106`** (battery) and **`0x0109`** (wearing). Searching logs for `0x01F0`
  finds nothing because no such command exists.
- **`0x0205`'s payload is count-first**, ids after: `[count][eventId...]`. `01 01 02 02` is a
  misread — it means "count=1, battery only", which the firmware ACKs while silently never pushing
  wear. **The app sends `03 01 02 03`** — count=3, then battery `01`, wearing `02`, **ANC `03`**
  (`OpoProtocol.registerNotifications()`). Omitting `03` makes bud-side ANC gestures look silent,
  which is exactly how that bug hid for three captures. Never shorten this list.
- **The gesture write is `0x0401`, not `0x0402`.** `0x0402` is ignored in total silence and cost a
  session. **A wrong command number fails silently**, which is why every gesture write re-reads the
  table and diffs it.
- **`TotalLen` is LEB128.** All frames the app builds today are under 127 bytes so a single-byte
  writer is correct, but `OpoProtocol.buildPacket()` does not implement real LEB128 — a much larger
  key-function table would need it.
- **Payload always starts at byte index 9** (`BudsConnectionManager.payloadOf()`).

### Gesture configuration (the newest, most delicate code)

- The `function` values are **MEASURED, not guessed** — see `GestureAction.functionByte` and
  PROTOCOL.md §6. **Do not re-derive them**; a previous session declared the theory refuted on the
  strength of one frame that turned out not to be the same kind of event at all.
- **`writeGestureBinding(side, ...)` takes NO button list from our code.** It writes every slot the
  bud actually has for that action, excluding only the `BUTTON_ON_CALL_GUESS` (`0x06`) group.
  **Never reintroduce a hardcoded button group** — the bud's slot layout differs per bud and
  normalises itself between writes, so any fixed group is wrong about half the time. This broke
  slide twice, in opposite directions.
- `KeyFunctionParser.HEADER_SIZE = 2` — the reply is `<status> <count> <entries>`. The OSS source
  models one entry, not the envelope, and taking `payload[0]` as the count cost an off-by-one.
- **The hold's function byte does not control the ANC cycle.** Clearing it to `0x00` does not stop
  the cycle. The cycle's membership is a *separate* command, `setSupportNoiseReduction`
  (`0x0404`), read back with `0x010C` payloads `02 01` / `02 03` / `02 04`. Not wired yet.
- Baseline for the diff is persisted in its own prefs (`QuickBudsKeyFnDiff`) because the experiment
  needs a reconnect that can restart the process. **An empty reply must never overwrite a good
  baseline.**
- The reply is printed in three places, so a capture is readable even if the parse is wrong: the raw
  `RX:` line, `BudsConnectionManager`'s `KEYFN:` line, and `LogDecoder` — **all end with `RAW=[...]`**.

### Where ANC lives

Adding an ANC mode means touching all of these, or the surfaces drift apart:

`OpoProtocol` builders · `AncEventParser` (buds→app names) · `LogDecoder` (SET-table log names) ·
`BudsConnectionManager` (`sendAnc*`, `lastAncLevelSent`) · `BudsService` routing ·
`WidgetStateStore` (state + `*IsActive()`) · `AncWidgetProvider` segments ·
`WidgetActionReceiver` · `MainActivity` circles · `AncTileService`.

## UI conventions and traps

- **Theming is attribute-based.** Colours are read from theme attributes during inflation
  (`ThemeRes`), not applied by walking the view tree afterwards. `ThemeRes.select(this)` must run
  **before** `super.onCreate` in every activity.
- **Never add `android:theme` to `<application>` in the manifest.** It makes the framework resolve a
  theme during Activity attach, which breaks `applyOverrideConfiguration()` — the app then crashes
  on launch. Per-activity theming is the only supported path here.
- **Prefs file name lives in one place**: `ThemeRes.PREFS_NAME` (`"QuickBudsPrefs"`). `QuickBudsApp`
  and `DevToolsActivity` used to hardcode the literal — keep all three in sync or prefs split in two.
- **Widget icon sizing:** `android:width`/`android:height` in a vector must be the **layout** size,
  never the source viewBox. A 1024dp intrinsic size once built 10752px bitmaps → 462 MB →
  "RemoteViews exceeds maximum bitmap memory usage", crashing on connect.
- **Never size these icons with `wrap_content` + `adjustViewBounds`.** Intrinsic size is stored in
  whole pixels at density, so the ratio drifts and the artwork is clipped at the box bounds. Set the
  box explicitly.
- **All icons in a set must share units-per-dp and layout height**, with widths from each icon's own
  ratio. The battery icon misalignment was a **fill fraction** difference (~100% vs ~79%), not an
  aspect-ratio bug — every measured box and ratio was correct.
- **Never put user-visible output on a packet-listener path.** Status events on the main screen are
  silent by design; several call sites fire once per packet and a toast there storms the UI.
- **A `when` on UI string keys with no `else` is a silent-failure generator.** The Transparency bug
  was `"Trans"` vs `"Transparency"` and hid for weeks. Also check for a state write with no matching
  refresh call — that was a widget one-way sync.
- **The download folders are `QuickBudsCrash/`, `QuickBudsLogs/`, `QuickBudsShot/`**, written through
  MediaStore. Do not write to public Downloads with a plain `File` — it is scoped-storage-blocked on
  API 29+, and the failure is silent if the result is not checked.

## Working with the developer

- **He handles device testing, git operations, publishing and design decisions.** The agent handles
  reverse-engineering, parsers, protocol work and code.
- **Revert first, reason after.** When he reports a regression and asks for a revert, do the revert,
  then investigate. Arguing has cost a whole session before.
- **He is the only source of on-device results.** Ask for the specific log line or measurement you
  need; one sentence from him has replaced an entire diagnostic loop.
- **Docs are updated in the same commit as the change**, and protocol changes always land with
  their PROTOCOL.md entry.
- **Do not mark roadmap items with release versions.** Releases happen when he feels the app is
  ready, not on a schedule.

## CodeAssist-era notes — do NOT carry these forward

These were real limits of the old environment only. On PC, with Gradle and a normal source tree,
they are historical:

- `search_text` did not index Markdown, so docs had to be read with the file reader.
- `project_diagnostics` reported **false errors** on nested classes named `Result`/`State`
  (`BatteryParser`, `EarStatusParser`, `WearingStatusParser`, `WidgetStateStore.write`). The build
  was always fine; do not chase these.
- There was no `assemble` task: the only build tasks were `bundle:app:release` and
  `androidRun:app:release`. On PC, use Gradle's own tasks.
- `get_diagnostics` could report "No diagnostics" for a file that did not compile (a missing import
  across packages). After a cross-package change, always run the compiler.
- `noteUnattributed` blanket-excluded cmd `0x0204`, so an undecoded `0x0204` subType printed nothing.
  That hid the ANC push frame for three captures and produced a confident, wrong claim that ANC has
  no push event.

## Dev tools inside the app

`devtool/LayoutReport.kt` writes the laid-out view tree as text — bounds, weights, margins, padding,
gravity, text sizes, and drawable intrinsic vs actual size, plus a `SIBLING GAPS` section. It exists
because a screenshot does not show view ids or exact spacing. **If you change `collectGaps`, keep it
to direct children of each container, measured against that container's own origin and on its own
stacking axis** — two earlier versions broke that and produced confident nonsense. `!! OVERLAP` on
`status_bar_* -> status_text_*` is **by design** (the battery percentage is drawn over the bar).

`devtool/ScreenshotToText.kt` converts a picked screenshot into ascii / grid / colour / rows text.

**Both are slated to be hidden from the UI, with the logic kept** — they may be useful again. Do not
delete them, and do not treat "the agent cannot read images" as a constraint any more.

## Current open items

- **The hold gesture** — finish it. Confirm the `0x810C` `02 01` read on the device first; no capture
  has ever shown a reply to it, so the shape is unknown. Then build the mode picker.
- **Slide up vs slide down** — both directions are written with the same action because which is
  which is not established.
- **On-call gestures** — to be added for parity (this reverses an earlier "never" decision).
- **Light theme** — either removed or left untouched until the final UI lands. It is the source of
  invisible-on-light bugs. Do not polish it.
- **Case lid state** — keep, remove or change: undecided. `ic_case.xml` stays until then.
- **Auto play/pause on wear** — add the firmware switch, plus our own layer: pause **only when both
  buds are out**, never auto-play.
- **Alert-sound volume slider** — the last remaining "easy parity" row; the rest are in.
- **Localisation** — text is in `strings.xml` but only English exists, and hardcoded strings remain in
  `MainActivity` dialogs, the Dev Tools labels and legend, and `BottomSheetDialog` callers.
- **Undecoded families** — `0x0500`/`0x0501` (they have empty payloads, so they cannot be gesture
  bindings), broadcast codes `0x04`/`0x08`/`0x0B`, the `0x810D` batch-status layout, the recurring
  `F1` family (`AA 0D 00 00 04 02 FF 06 00 F1 01 01 XX YY 02`), and `02 01 08 0C 02` /
  `02 01 07 0B 02` (these carry non-multiples of ten — possibly a fine-grained battery/case field).
  Also `0x0510`, a Spatial Audio notify. **Do not guess any of these from a couple of samples.**
  See PROTOCOL.md §12.

### Connection robustness — known rough edges

From `bluetooth/BudsConnectionManager.kt`. None of these are fixed:

- The **primary UUID `00001107-...` never connects** — it burns a ~5 s timeout on every attempt, and
  the `0000079A-...` fallback is the one that works. **Trying the working UUID first would save 5 s
  per connect.** Not done.
- `Connection reset by peer` / `Broken pipe` appear during long sessions.
- **A 14-minute gap with no reconnect attempt** was observed after `Connection lost`.

## Main screen structure — settled

Header (fixed: device name + dev-tools icon + settings cog) over a `ScrollView` named `mainScroll`.
Inside it, top to bottom:

1. `batteryCard` — full width, halves **equal** (`weight 1 / 1`; they were 0.8 / 1.2 until
   2026-09-17). Left half: `status_bud_left`, a weighted frame holding `status_case_icon` and
   `status_bud_right`. Right half (`marginStart 14dp`): rows `status_row_left` / `status_row_case` /
   `status_row_right`, each a letter `TextView` plus a `ProgressBar` (`status_bar_*`) with a centred
   number `TextView` (`status_text_*`) on top. The numbers are normally empty because
   `SegmentedBarDrawable` draws the value inside the bar; the TextViews are the fallback for a
   non-segmented bar. See `renderBar`.
2. `batteryBarsCard` — the bars only. Splitting it from `batteryCard` was deliberate: as one grid,
   the icon block and the bars fought over the card's height, so resizing icons moved the bars.
3. The ANC switcher — four circles (`anc_btn_off` / `anc_btn_anc` / `anc_btn_adapt` / `anc_btn_trans`).
   Tapping the **active** ANC circle opens the full mode chooser (`showAncChooser`), because four
   buttons cannot represent every mode.
4. `featureList` — the settings card, `@drawable/app_card_outline_bg`, filled at runtime by
   `MainActivity.buildFeatureRows()`. Declared empty in XML on purpose: six near-identical row
   layouts in XML would be six places to edit, and the icons need a themed tint that XML cannot
   apply to a vector drawable. `addRow()` inserts the hairline divider before every row but the first.

**The main screen carries no log**, by design — Dev Tools owns logging. `appendStatus()` only
appends to a bounded in-memory tail. See the note above about not putting user-visible output on a
packet-listener path.

## Widget flow

```
Widget tap
  -> AncWidgetProvider PendingIntent
  -> WidgetActionReceiver
  -> WidgetStateStore.write
  -> broadcast ACTION_WIDGET_COMMAND (short action name)
  -> BudsService.widgetCommandReceiver
  -> executeWidgetCommand
  -> manager.sendAncXxx()
```

The action travels as the **short** name; a full-string-vs-short-name mismatch here was a real bug
(use short names as extras). The send executor was also reworked to a fresh thread per send, because
a shared one hung.

## Settled design decisions — do not re-litigate

- **The battery card is TWO STACKED CARDS**: `batteryCard` holds only the icons, `batteryBarsCard`
  only the bars. An earlier single-card grid was abandoned because the icon block and the bars fought
  over one card's height, so resizing the icons moved the bars.
- **The L / C / R letters stay theme-aware** (`?attr/appColorLetter`). Do not "improve" them into a
  fixed colour.
- **The case icon keeps its LED dot**, and the lid cut stays full width — no hinge bulge or opening.
- **All icons in a set share units-per-dp and layout height**, widths taken from each icon's own true
  ratio. The wear icons are 96dp tall with widths 62 / 124 / 62dp.
- The 2026 icon work is done for the app and the launcher; **the widget preview
  (`drawable/widget_preview_buds.xml`) is a separate copy** and must be updated alongside
  `ic_launcher_foreground.xml`.

## Repo hygiene

- **`local/` is committed to carry the mobile working state to the PC**: `logs/` (packet captures
  cited as evidence by PROTOCOL.md), `svgs/` (the source SVGs the wear icons were traced from, named
  in the drawables' own headers), and `commits/` (the v1.1.0 commit message and release body).
- **`local/notes/` and `local/NEXT-SESSION.md` are gone, on purpose** — all superseded, and their
  surviving content was folded into this file, PROTOCOL.md, ROADMAP.md and PACKET-CAPTURE.md.
  **Do not recreate a notes folder or a session-plan file.** Scattered per-purpose notes are exactly
  the drift that AGENTS.md exists to stop — put new durable knowledge here, or in PROTOCOL.md if it
  is about the wire format.
- Runtime `*.log` files written by the app are ignored — they are regenerated every run. Handed-over
  captures (`*.log.txt`) are evidence and **are** tracked.
- There are no committed screenshots.
- Root docs: `README.md`, `ROADMAP.md`, `AGENTS.md`, `PROTOCOL.md`, `CREDITS.md`, `PACKET-CAPTURE.md`,
  `LICENSE`, plus two temporary files — `START-HERE.md` and `DeepSeek_CodeAssist_memory.md`. Both are
  listed in the cleanup checklist above and should be deleted once the move is settled.

### The carried-over memory file

`DeepSeek_CodeAssist_memory.md` is the private memory of the **CodeAssist/DeepSeek agent** that built
this project on the phone. It exists only so the move to the PC did not lose anything mid-flight.
**Read it, fold anything still useful into this file, PROTOCOL.md or your own memory, then delete
it.** Where it disagrees with this file, PROTOCOL.md or the code, those win.

---

## Post-move cleanup checklist

The move happened, and it deliberately carried more than a PC needs. **Work through this once the PC
build is confirmed working**, and delete what is listed. Everything here is either obsolete on the
PC, or was only ever kept so nothing was lost mid-flight.

**Do not do this before the first successful PC build** — the point of dragging the mobile material
along was to survive a failed transfer.

### Delete from the repo (safe once the build works on PC)

| Item | Why it can go |
|---|---|
| `START-HERE.md` | Temporary bootstrap for the move. Once the build works and this checklist is done, AGENTS.md covers everything it says. **Delete this file last**, after the entries below are gone. |
| `DeepSeek_CodeAssist_memory.md` | Temporary by design. Fold anything still useful into AGENTS.md or PROTOCOL.md first, then delete. |
| `local/commits/` | Commit-message files, prepared because the phone's commit box was too small to paste into. Obsolete — commits are made on PC now. |

**Already deleted during the move** — do not add them back: `local/notes/` (folded into AGENTS.md,
PROTOCOL.md, ROADMAP.md and PACKET-CAPTURE.md) and `local/NEXT-SESSION.md` (a mobile-era session plan,
fully superseded).

### Delete from the phone's working copy (not in the repo, so no commit needed)

- **`app/module.toml`** — CodeAssist's project model, which the phone build used. **Do not delete it
  until you are confident nothing on the phone is still being built**: while it exists, the phone can
  still build the project. Once the PC is the only build, it is dead weight. The version it holds is
  already duplicated authoritatively in the manifest.
- **`.platform/`** — CodeAssist's cache, settings and generated Gradle export. Pure IDE state. The
  only thing in it of any value was the agent memory, now copied to
  `DeepSeek_CodeAssist_memory.md`.

Both are git-ignored, so deleting them is a local action with no repo consequence.

### Keep

- **`local/logs/`** — real captures, referenced as evidence by PROTOCOL.md and by source comments.
  This is the one part of `local/` that has lasting value; do not delete it.
- **`local/svgs/`** — the source SVGs the wear-icon drawables were traced from. The drawables
  themselves say so in their headers, so these are the provenance for that artwork.
- All root docs.

### Also worth doing in that pass

- **Re-check `CREDITS.md` and `README.md` end to end.** Both were edited piecemeal across the move
  and have not had a full read-through since.
- **Consider whether `local/` should stay in the repo at all** once the transfer is settled. It is
  tracked now purely to carry the workflow across; if only `logs/` and `svgs/` are worth keeping,
  narrowing `.gitignore` to the rest is the tidy end state.
- **Empty folders are fine and need no attention.** Git does not track them, so they do not exist in
  a fresh clone at all. Do not add `.gitkeep` files to force one in, and do not list empty
  directories in any doc.
