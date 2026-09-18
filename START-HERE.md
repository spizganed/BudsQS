# START HERE

**Bootstrap for a new agent session on this project.** Follow this in order, before touching code.

> **Temporary file.** Once the PC build works and the cleanup pass is done, delete it and everything
> it points at. [AGENTS.md](./AGENTS.md) is the permanent reference and is loaded automatically.
>
> **Why this file exists:** AGENTS.md is a *reference* (long, durable, loaded into every session).
> This is a *procedure* (short, ordered, temporary). Keep it that way — if it starts restating
> AGENTS.md, it will drift out of sync and become another contradictory document.

---

## 1. Read, in this order

| Order | File | Why |
|---|---|---|
| 1 | [AGENTS.md](./AGENTS.md) | The durable reference: toolchain, conventions, past mistakes, open items. Loaded automatically — read it deliberately anyway. |
| 2 | [ROADMAP.md](./ROADMAP.md) | What to work on, and in what order. |
| 3 | [PROTOCOL.md](./PROTOCOL.md) | The wire format. **Required before any protocol work** — every claim is tagged with how it is known. |
| 4 | [DeepSeek_CodeAssist_memory.md](./DeepSeek_CodeAssist_memory.md) | The previous agent's memory, carried over from the phone. Absorb what is still useful, then delete the file. Not authoritative where it disagrees with AGENTS.md, PROTOCOL.md or the code. |
| 5 | [README.md](./README.md) · [CREDITS.md](./CREDITS.md) · [PACKET-CAPTURE.md](./PACKET-CAPTURE.md) | Reference as needed: feature summary, whose work this stands on, how to capture a packet log. |

## 2. Get the build running — before any feature work

The project moved off the phone and **has never been built with Gradle on a PC**. Expect this to need
attention; fix it first.

1. Install JDK **17+** (`JAVA_HOME`), Android SDK `platforms;android-36` + `platform-tools`, and adb.
   Details: AGENTS.md → *Environment you need*.
2. Create `local.properties` with `sdk.dir=...` (git-ignored — never commit it).
3. Generate the wrapper — the one build file not in the repo:
   `gradle wrapper --gradle-version 8.13`
4. `./gradlew assembleDebug`
   - The first run downloads Gradle, AGP and the Kotlin plugin. Expected, not a stall.
   - A **Kotlin-metadata warning is expected and harmless** (Kotlin 2.4.0 is newer than AGP's D8/R8).
5. Commit the wrapper (`gradlew`, `gradlew.bat`, `gradle-wrapper.jar`) as a follow-up, noting they
   are generated.
6. **Use `assembleDebug`, not `assembleRelease`.** There is no signing config, so a release APK comes
   out `-unsigned` and Android refuses to install it. See AGENTS.md → *Signing*.

## 3. Confirm you can reach the device

`adb devices`, then `adb install -r app/build/outputs/apk/debug/app-debug.apk`. **The phone is still
the test device** — only the build and the agent moved.

## 4. Do the cleanup pass

AGENTS.md → *Post-move cleanup checklist* lists exactly what to delete from the repo and from the
phone's working copy, and what to keep. **Only after step 2 passes.**

## 5. Start real work

Take the top item from ROADMAP.md → *Next up* — currently the hold gesture. Note that it **begins
with a read, not a write**: confirm the `0x810C` `02 01` reply on the device before building any UI.

---

## Before you propose a change

The non-negotiable rules are in AGENTS.md (already in your context) — **read them first.** They are
the accumulated cost of mistakes that were paid for once already.

**Report back before coding:** what you read, whether the build passed, what you had to fix to make
it pass, and what you intend to do next. The developer handles device testing, git operations and
publishing — ask him for anything that needs the hardware.