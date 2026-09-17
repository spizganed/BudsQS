# Credits and protocol sources

BudsQS is a clean-room Android client for the OPPO / OnePlus / realme earbud
RFCOMM protocol. None of the protocol knowledge here was documented by the
vendor. It exists because other people reverse-engineered it first and published
their results. This file records exactly whose work we rely on, and for what, so
the debt is never lost.

**If you add a protocol constant, frame layout, or event mapping to this project,
add its source here in the same commit.**

> **See also [PROTOCOL.md](./PROTOCOL.md)** — the wire format itself, with every
> claim tagged `[VENDOR]` / `[OSS]` / `[CAPTURE]` / `[GUESS]` so it is always clear
> which parts are sourced and which are still guesses.

---

## Primary sources

### Zhaoyi-ya/OppoPodsManager — the main reference
https://github.com/Zhaoyi-ya/OppoPodsManager

A desktop (Windows/Linux) manager for OPPO/OnePlus/realme earbuds. This is the
single most detailed public reference for this protocol, and it is where most of
our command table comes from.

What we use from it:

| Area | What it gave us |
|------|-----------------|
| Frame layout | `AA <TotalLen> 00 00 <Cmd LE> <Seq> <PayLen LE> <Payload>`, and the LEB128 length encoding |
| Command table | The 0x01xx query / 0x81xx response / 0x02xx broadcast / 0x04xx set layout, including `CmdSetAnc=0x0404`, `CmdQueryAnc=0x010C`, `CmdActiveReport=0x0204`, `CmdRegisterNotify=0x0205`, `CmdQueryFunctionKey=0x0108`, `CmdSetKeyFunction=0x0402` |
| ANC (set) | `Protocol/OppoProtocol.Anc.cs` — the `AncOff/AncLight/AncMedium/AncDeep/AncTransparency` payloads and `PktAncByIndex()`, which is the exact bitmask algorithm in our `OpoProtocol.ancPayload()` |
| ANC (notify) | `AncValues` — the `(Val1, Val2) -> name` dictionary for the 0x0204 subType 0x03 push, which matches our own captures exactly and is the basis of `AncEventParser.modeForRaw()` |
| Button/gesture | `Models/UserInteractionEventInfo.cs` — the 0x0204 subType 0xF1 payload body (side, button, action, modifier, context, int16 options) and the action names (0x00 single, 0x02 double, 0x03 triple, 0x04 long press, 0x07 slide up, 0x08 slide down) |
| Key function | `Models/KeyFunctionItem.cs` — `[deviceType, button, buttonAction, function]`, the payload unit of `setKeyFunction` |
| Feature IDs | `Protocol/OppoProtocol.Features.cs` — the `FeatureXxx` constants for the generic 0x0403 feature switch, including `FeatureSpatial=0x1B`, `FeatureDualDevice=0x11`, `FeatureGameLL=0x06`, `FeatureGameMain=0x28` |
| Wearing / in-case | The 0x0109 wearing query and its `[count][component,status]` pairs |

Their work is derived in part from the Melody (HeyMelody) Android APK, which they
cite as `melody 16.8.1` and reference by obfuscated class where relevant.

### Leaf-lsgtky/OppoPods
https://github.com/Leaf-lsgtky/OppoPods

Early OPPO earbud private-protocol reverse engineering. Credited by
OppoPodsManager as a source for the protocol work, and the origin of some of the
framing knowledge.

### Star-ZER0/Pods-Protocol-Reverse-Engineering
https://github.com/Star-ZER0/Pods-Protocol-Reverse-Engineering

Reverse-engineering notes for OPPO, vivo and Moondrop earbuds. Its `handmade/`
folder (hand-made, higher confidence) and `ai-generated/` folder (clearly marked
as lower confidence) are separated, which is a convention worth copying.

What we use from it:

| Area | What it gave us |
|------|-----------------|
| Frame layout | Independent confirmation of the header, reserved bytes, LE cmd, seq, LE payload length |
| LEB128 length | The `TotalLen` encoding rule, including the `>=128` case: subtract 1, then standard LEB128, and the inverse on decode |
| Broadcast codes | That the 0x8200 reply lists the supported broadcast codes, and that `0x03` is the ANC/noise-mode broadcast. **This is what proved our ANC subscription fix was correct.** |
| ANC (query) | The query reply values: `0x0008` Off, `0x0010` ANC on, `0x0100` Transparency, and the separate adaptive value |
| Battery frame | `01LL02RR03MM` with bit 7 of each byte as the charging flag |

License: CC-BY-SA-4.0. See the note at the bottom.

### Zhaoyi-ya/OPPO-Pods-Win
https://github.com/Zhaoyi-ya/OPPO-Pods-Win

The packaged Windows product from the same author as OppoPodsManager. Useful as
a cross-check on which features are exposed per device model, and on the
capability-per-model idea (a device does not support every command).

### ORION2809/DevPods
https://github.com/ORION2809/DevPods

Turns earbuds into a developer control surface, with a multi-provider mesh that
includes an OPPO/Realme/OnePlus provider. Useful as a second implementation of
the same vendor family, and for its `protocol/` and `docs/` folders.

---

## What is ORIGINAL to this project

To keep the credits honest, these are our own captures and findings, not taken
from anyone else:

- The **ANC gesture push** mapping for OnePlus Buds 4 (firmware
  `B4.1-260810-1153`), captured on-device: `0x0008` Off, `0x0020` Medium,
  `0x0010` Deep, `0x0100` Transparency, `0x0001`/`0x0002` Transparency with voice
  enhance — and the finding that the ANC-on stop **echoes the last level**, so the
  value is a bitmask rather than a fixed enum.
- The observation that the **SET and NOTIFY ANC encodings differ** (set uses bit
  0 for Off and bit 2 for Transparency; the buds report bits 3 and 8). This is a
  genuine trap and is documented in `OpoProtocol.ancPayload()`.
- The working `0x0205` registration payload shape for this device, and the fact
  that `0x03` must be included to receive ANC pushes at all.
- Everything in the Android UI layer: the widget, the layout, the theme system,
  the LayoutReport dev tool.

---

## Errata / things that were wrong

Recorded on purpose, because a future session will otherwise re-derive them:

- The 0x0205 register payload `01 01 02 02` seen in older notes is a **misread**.
  Under the count-first shape it means "count=1, register battery only", which the
  firmware accepts while silently never sending wear events.
- The comment in an earlier revision of `GameModeParser` claiming "ANC changes
  raise no 0x0204 event" is **false**. ANC uses subType `0x03`; game mode uses
  `0x05`.
- The SET_ANC bit table was briefly "corrected" to the notify bit numbers on the
  theory that set and query must agree. **They do not.** That change was reverted.

---

## Licensing note

Check the license of each source before copying anything verbatim.

- `Star-ZER0/Pods-Protocol-Reverse-Engineering` is **CC-BY-SA-4.0**. Its content
  is *documentation*, and we have used it as documentation — the factual protocol
  details are not themselves copyrightable, but if you copy text from it into
  this repo, the share-alike terms travel with that text.
- `Zhaoyi-ya/OppoPodsManager` — see `LICENSE` in that repo.
- The protocol facts above were used as reference, and the Kotlin implementation
  here is our own.

If in doubt, re-derive from a capture rather than copying, and add the capture to
`testlogs/`.
