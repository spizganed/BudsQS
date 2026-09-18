# DeepSeek / CodeAssist agent memory — carried over from the mobile era

> **This file is temporary, and it has a job to do.**
>
> It is the private memory of the AI agent that built QuickBuds on the phone (the CodeAssist agent,
> running DeepSeek v4.1-fast via OpenRouter), dumped here so it survives the move to the PC.
>
> **For the current agent:** read this, fold anything still useful into
> [AGENTS.md](./AGENTS.md), [PROTOCOL.md](./PROTOCOL.md) or your own memory, and then **delete this
> file**. Nothing here should stay authoritative — where it disagrees with AGENTS.md, PROTOCOL.md or
> the code, they win. It is kept only so that a hard-won detail is not lost in the handover.
>
> Sections that were purely about the mobile build environment are marked **historical**.

---

## Build / verify — HISTORICAL (CodeAssist era)

The on-phone build had no Gradle CLI:

- Real build was `bundle:app:release` → `app/build/outputs/bundle/release/app-release.aab`.
  There was **no `assemble` / `assembleDebug` task**. `androidRun:app:release` also produced and
  installed `app/build/outputs/apk/release/app-release.apk`.
- `project_diagnostics` reported **false errors** on nested classes named `Result` / `State`
  (`BatteryParser`, `EarStatusParser`, `WearingStatusParser`, `WidgetStateStore.write`). The build
  succeeded every time — analyzer artifacts, not real errors.
- `search_text` did **not** index Markdown. Finding text in README / PROTOCOL / ROADMAP / CREDITS
  required reading the file; searching a phrase that was definitely in README returned nothing.
- `get_diagnostics` could report "No diagnostics" for a file that did not compile (a missing import
  across packages). After a cross-package change, the build had to be run.

All four are CodeAssist artefacts and do not apply on the PC.

## Versioning

Version is declared in `app/src/main/AndroidManifest.xml` on `<application>`; the manifest is the
authority. There is a drift history worth knowing, because it explains user-visible weirdness:

- **v1.0.0 declared NO version at all.**
- A later build declared **0.4.0 in the manifest** while `module.toml` said `1.0`, so an installed
  app reported **0.4.0** while the release was tagged **1.0.0**.

Current: **versionCode 2 / versionName 1.1.0**. On the mobile setup the value also lived in
`app/module.toml`, which is now retired — on the PC the manifest is the only place.

`UpdateActivity.isNewer()` compares the **GitHub release TAG** against the installed versionName and
requires an **`.apk` asset** on the release (`extractApkUrl`). The build produces an `.aab`, so an
APK had to be uploaded separately or the in-app updater found nothing.

## Renamed BudsQS → QuickBuds (2026-09-22)

The GitHub repo was renamed; old URLs redirect (the API returns canonical `spizganed/QuickBuds`).

- `UpdateActivity.REPO` = `spizganed/QuickBuds`; `.git/config` origin → `QuickBuds.git`.
- Log tag / wakelock / service channel: `QuickBuds-Packets`, `QuickBuds::GattWakeLock`,
  `QuickBuds_Service`.
- **Prefs file `BudsQSPrefs` → `QuickBudsPrefs`** (`ThemeRes.PREFS`). This was a deliberate one-time
  settings reset (theme + gestures). `QuickBudsApp` and `DevToolsActivity` used to hardcode the
  literal; both now use `ThemeRes.PREFS_NAME`. **Keep those three in sync** or prefs split in two
  (`QuickBudsApp` needs the `ui.ThemeRes` import).
- Download folders: `QuickBudsCrash/`, `QuickBudsLogs/`, `QuickBudsShot/`.

## Adaptive (2026-09-22)

- **Adaptive's SET mask is `0x0800` = bit 11, NOT bit 8.** Payload `01 01 00 08`. The old code passed
  `8` to `ancPayload()`, producing `01 01 00 01` — a different mode. It is now built literally.
  `ancPayload(11)` **would** produce the right bytes; an earlier claim that "Adaptive cannot be
  expressed as an index" was **wrong** and is corrected everywhere. **Derive the index from the mask,
  never from a mode's position in the vendor list.**
- `LogDecoder.ancPayloadToString()` read `0x0100` for Adaptive; it now reads `0x0800`.
- `AncEventParser.modeForRaw()` returns `"Adaptive"` for `0x0800`. It used to fold into `"ANC-Light"`
  and a `describe()` special-cased the log line. **If the Adaptive control is ever removed, the fold
  has to come back**, or a bud-side Adaptive lights nothing.
- Store `adaptiveIsActive()`; manager `sendAncAdaptive()` (with `lastAncLevelSent = null`).
- Main screen: **4 circles OFF | ANC | ADAPT | TRANS** (`ancRow` `weightSum="4"`, ids
  `anc_btn_off` / `anc_btn_anc` / `anc_btn_adapt` / `anc_btn_trans`, `app_anc_adapt` = "ADAPT"). ANC
  stays a Low/Med/High chooser; Adaptive applies directly and is deliberately **not** in the chooser.
- Widget: 6th segment `widget_seg_adapt` ("Adpt"), request code 205, target `"adapt"`, added to the
  disconnected `dead` list. Tile cycle: Off / Trans / Smart / Adaptive, Adaptive = `STATE_ACTIVE`.
- Routing: the widget tags Adaptive `ANC_CYCLE`; `BudsService.executeWidgetCommand` and
  `WidgetActionReceiver` each gained an Adaptive arm.

## The ANC hold-cycle question — answered

Can the app choose which modes the hold cycles through? **Yes in principle. The limit is our own
protocol coverage, not the hardware and not HeyMelody's design.**

- **Not a hardware limit** — the buds hold a *changeable* list. The same stored `fn` byte (`0x08`)
  covered two modes once and four another time.
- **Not a HeyMelody choice** — the vendor app does offer the mode list for the hold.
- **It is the protocol's shape** — the key-function table stores one byte meaning "this gesture
  cycles ANC", with no membership. Clearing it to `0x00` did **not** stop the cycle (measured).
  HeyMelody shows a list because it *also* sends `setSupportNoiseReduction` alongside the binding.
- The missing half here is that write: `0x0404`, `[action=2][noiseType][modeMask LE]` (upstream
  `LongPressNoisePayload`), read back with `0x010C` payloads `02 01` / `02 03` / `02 04`.

**Required order: confirm the `0x810C 02 01` READ first.** `queryNoiseSwitchModes()` is already sent
in the init sequence, but **no capture has ever shown a `0x810C` answer to `02 01`**, so the reply's
shape is unknown. Building a picker first would repeat the SET-vs-NOTIFY guessing mistake.

## Where ANC lives

Adding an ANC mode means touching **all** of these, or the surfaces drift apart:

`OpoProtocol` builders · `AncEventParser` (buds→app names) · `LogDecoder` (SET-table log names) ·
`BudsConnectionManager` (`sendAnc*`, `lastAncLevelSent`) · `BudsService` routing ·
`WidgetStateStore` (state + `*IsActive()`) · `AncWidgetProvider` segments ·
`WidgetActionReceiver` · `MainActivity` circles · `AncTileService`.

## The readable-screenshot path

It is real and was undocumented for a while: Dev Tools → **Screen** runs
`devtool/ScreenshotToText.kt`, writing ascii / grid / colour / rows text files through MediaStore.
Do **not** claim the agent can only read layout reports. (On the PC the agent can read screenshots
directly, and both tools are slated to be hidden from the UI with the logic kept.)

## Docs — state and ownership

- **README.md is the accurate feature summary**; ROADMAP.md is the plan.
- The developer reads the docs and reports misunderstandings himself; treat his summaries as
  useful but unverified against the code.
- **Attribution he gave** (now in README + CREDITS + ROADMAP): DeepSeek chat ~15% (first codebase,
  first RE steps, basic UI/logger/widget — that widget was later rewritten almost entirely), the
  **CodeAssist agent via OpenRouter running DeepSeek v4.1-fast** ~80% (the bulk of the current
  code), Kimi / Gemini (images) / Grok ~5% on small tasks. **All free tiers.** An earlier ROADMAP
  line credited "AI (Kimi)", which was wrong.
- Credited repos, all verified to exist via the GitHub API: `Zhaoyi-ya/OppoPodsManager`,
  `Star-ZER0/Pods-Protocol-Reverse-Engineering`, `Leaf-lsgtky/OppoPods`, `Zhaoyi-ya/OPPO-Pods-Win`,
  `ORION2809/DevPods`, plus the sibling project `elaxptr/baseus-desktop`.

## Corrected errors — errata, do not re-introduce

- **`0x01F0` / `0x01F2` are NOT commands.** They are the command byte welded to its sequence value.
  The real numbers are **`0x0106`** (battery) and **`0x0109`** (wearing).
- **The widget is 4x2, not 3x2** (`widget_anc_info.xml`, `targetCellWidth=4`).
- The panel layout `activity_status_panel.xml` **no longer exists** — the panel is inside
  `activity_main.xml`.
- The gesture write is **`0x0401`**, not `0x0402`. `0x0402` is ignored in total silence and cost a
  session; a wrong command number fails silently, which is why the write always re-reads and diffs.

## Release 1.1.0 — published

v1.1.0 is live on GitHub **with** a `QuickBuds1.1.0.apk` asset attached, which is what the in-app
updater needs.

It was not "last session's changes" — it is **everything since the `v1.0.0` tag (2026-09-14)**, an
effective rebuild. Two earlier drafts of the release body were rejected as too thin; his words were
"the release body doesn't include the insane amount of changes" and "just look at commit titles and
descriptions". **To get the true scope, do not guess** — use:

- `https://api.github.com/repos/spizganed/QuickBuds/compare/v1.0.0...main` — `total_commits`, the
  full commit list and the per-file patch set
- `https://api.github.com/repos/spizganed/QuickBuds/commits?sha=main&per_page=40` — messages
- Raw files at a tag: `https://raw.githubusercontent.com/spizganed/QuickBuds/<sha>/<path>`
  (**v1.0.0 sha `81a71578f9a0040006abbfe0b4751e7ef49feb6d`**)

**What v1.0.0 actually was**, so comparisons stay grounded: package `com.example.oneplusbudsqs`,
`Theme.DeviceDefault.Light.NoActionBar`, **no declared version**, ANC mode buttons + Game Mode +
battery text, a 5-second poll, a four-button widget, sources under `com/example/oneplusbudsqs/`,
and docs of README + HANDOFF + GRADLE-EXPORT only. So `PROTOCOL.md`, `CREDITS.md`, `ROADMAP.md`,
`LICENSE` and the whole `devtool/` + `ui/` + `widget/` structure are all **new** in 1.1.0. (v1.0.0
did have OLED / Dark / Light — applied by walking the view tree and setting colours per-view, which
is exactly why the redesign needed a real palette system.)

Credential note: the developer holds the publishing credentials and publishes manually. `local/commits/`
held ready-made commit messages for that workflow; it is obsolete now that commits are made on PC.

## Other open items at handover

- **Slide up vs slide down** share one action — which is which is not established.
- **Light theme**: unmaintained; remove it, or leave it until the final UI lands.
- Hi-Res codec, spatial audio and EQ rows are placeholders (see ROADMAP.md for their order).
- **The `0x810C 02 01` read test on hardware**, then the hold mode picker.
