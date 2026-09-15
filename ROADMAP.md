# BudsQS - Development Roadmap & Priority List

> Living document. Updated as items complete or priorities shift.
> Last updated: 2026-09-14

## Working principles

- Mobile-only workflow: Nothing Phone (3a), Android 15, CodeAssist, Termux, GitHub mobile.
- AI (Kimi) handles heavy logic: reverse-engineering, parsers, protocol work.
- Human handles: device testing, Termux commands, git operations, design decisions.
- Feature philosophy: **only what I want** - every new idea is filtered through this list before any work starts.
- No desktop Android Studio. Ever.

## Priority list

### Priority 1 - Foundation & debugging (ASAP)

| # | Item | Why / when | Est. time | Type |
|---|------|-----------|-----------|------|
| 1 | **Packet logging foundation** - dump all received AA frames + sent commands with timestamps to a log file, behind a debug flag | Everything below depends on seeing what the Buds 4 actually sends. No more blind debugging. | 15-30 min | Quick |
| 2 | **Bud icons hide when bud is in case** (0x010D parse + widget visibility) | Core widget feature. Driven by real data from #1. | 1-2 h | Debug/fix |

### Priority 2 - 1.1 release content

| # | Item | Why / when | Est. time | Type |
|---|------|-----------|-----------|------|
| 3 | **Battery rows + case status hide logic** - battery row hides when its bud is in case; case battery hides if no response; **widget refresh button** that manually requests status/battery (improvement over HeyMelody, which only displays what it has) | Direct extension of #1/#2, same parser. Do immediately after #2 while context is fresh. | 1-2 h | Medium |
| 4 | **Silent foreground service notification** | Small UX win, quick to slot in anytime. | 15-30 min | Quick |
| 5 | **Verify git/GitHub setup in CodeAssist** + correct `.gitignore` | Before the big edits, so commits stay clean. | 30 min | Quick check |
| 6 | **Proper app icon** - stylised left+right bud pair, dot-matrix concept | Release blocker for 1.1. Existing Termux icon pipeline applies. | 1-3 h | Medium |
| 7 | **Full dev mode UI** - hidden-by-default switch revealing debug tools: log viewer, packet inspector (Stage B of #1) | Polish once #1-#3 are proven stable. | 1-2 h | Medium |

### Priority 3 - Before the final step

| # | Item | Why / when | Est. time | Type |
|---|------|-----------|-----------|------|
| 8 | **Lock screen widget feasibility research** (Android 15) | Unknown if possible at all - research before committing effort. | 30 min research | Spike - possibly not doable |
| 9 | **Credits section** - in-app + README: GitHub projects used (Leaf-lsgtky/OppoPods, Zhaoyi-ya/OppoPodsManager) with authors, tools used (CodeAssist, Termux, decompile.com, etc.), thanks to all authors | Moral + GPL-3.0 obligation. Must ship with 1.1. | 1 h | Quick-medium |
| 10 | **Source cleanup pass** - delete unused files, dead classes, junk in source folder; verify `.gitignore` | Must happen BEFORE the redesign so the new UI is built on a clean base, not on accumulated junk. | 1-2 h | Medium |
| 11 | **Package rename + final app name** | Do together with #12 - touching every file twice is wasted work. | 1-2 h | Medium |

### Priority 4 - The final step

| # | Item | Why / when | Est. time | Type |
|---|------|-----------|-----------|------|
| 12 | **Full app UI redesign + polish (v1.1)** - mimic finished widget style, only wanted functions | Last, by design: builds on locked widget logic (#1-#3), clean source (#10), final identity (#11), proper credits (#9). | many hours (full day+ across sessions) | Big |

## Execution order

    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> (research 8) -> 9 -> 10 -> 11 -> 12

Rationale:
- 1-2-3 is one continuous debugging arc - the parser and logging built in #1 serve #2 and #3 directly.
- 4-7 are independent quick/medium wins, any order.
- 8 is a research spike that may be dropped.
- 9-11 are the pre-redesign gate: credits, cleanup, identity.
- 12 happens only when everything above is done. No exceptions - redesigning on unstable logic or dirty source doubles the work.

## Credits (draft for #9)

### Reference projects (protocol reverse engineering)

- **Leaf-lsgtky/OppoPods** - OPPO earbud protocol reverse engineering
- **Zhaoyi-ya/OppoPodsManager** - OPPO earbud protocol reference and feature implementation

BudsQS is licensed GPL-3.0, same as both projects above.

### Tools

- CodeAssist IDE (Tyron) - development
- Termux - terminal, scripting, icon processing
- decompile.com - HeyMelody decompilation
- Brave browser, Google Files, hex editor - research & inspection
- GitHub mobile - repo management
- Kimi (Moonshot AI) - AI-assisted development
