# Capturing a packet log

How to get a raw RFCOMM capture off the device. Kept as a **backup procedure** — it was written to
answer whether bud-side ANC gestures produce any attributable frame (they do, see below), and it is
still the way to capture anything new.

## When you need this

Any time a protocol question cannot be settled from the code or from
[PROTOCOL.md](./PROTOCOL.md). **Capture first, then build.** Guessing a payload has cost this project
real sessions more than once, and a wrong write to the buds fails completely silently.

## Option A — the app's own log (no PC needed)

1. Force-stop the app, reopen it, connect, and let the init burst finish.
2. Dev Tools → **Clear** (so the export is one clean session with no dead gaps).
3. Be in the app **before** each gesture, so the mark and the gesture land in the right order.
   There is no need to open Dev Tools between gestures.
4. For each thing you want to capture:
   - perform the gesture / action on the buds,
   - press **MARK** within about 2 seconds after it,
   - wait at least 3 seconds before the next one.
5. Repeat the whole cycle **twice**, so a one-off frame gets a chance to appear again.
6. Dev Tools → **Export**. Files land in `Download/QuickBudsLogs/` via MediaStore.

Hand over only the lines between the first and last `MARK`, plus the two lines either side of each
one. The 60-second `TX[poll status]` keep-alives in between can be left out.

## Option B — btsnoop / Wireshark (when the app's log is not enough)

Captures the HCI layer, so it sees frames the app never decoded. Wireshark opens a btsnoop log
directly (filter to Bluetooth RFCOMM); on a phone, an app that reads btsnoop works without a desktop.

**Warning:** nothing in this repo reads a btsnoop file. It is raw HCI — L2CAP and RFCOMM framing must
be walked by hand, or with Wireshark, before any payload starting `AA` is visible.

## Lines worth knowing

| Line | What it is |
|---|---|
| `MARK #n` | A manual timestamp. Press it *after* the gesture. |
| `BTN EVT:` | The `0xF1` user-interaction family, decoded — side, button, action, modifier, context. |
| `UNATTR RX:` | Any frame the app does not already decode, with payload head. |
| `TX[...]: AA ..` | A command the app sent. |
| `KEYFN DIFF:` | What changed in the key-function table between two reads. |

`UNATTR RX:` and `BTN EVT:` are usually the whole point of a capture.

## What this already answered

**Bud-side ANC gestures DO raise a frame.** The `0x0204` subType `0x03` push follows an ANC hold.
This was believed impossible for a long time — it was declared "verified 3 times" that ANC raises no
event — because `noteUnattributed` blanket-excluded cmd `0x0204`, so an undecoded subType printed
nothing at all and genuine silence looked identical to unparsed data. The lesson is in
[PROTOCOL.md](./PROTOCOL.md) §5 ("History of Getting This Wrong"): **absence of a log line is not
absence of a frame.**

Also settled by capture: `F1` `byte3` carries the resolved function, and a hold's `F1` frame still
reports `byte3 = 0x08` even when the stored function byte has been cleared to `0x00`.

## Still open, and capturable

- **The `0x810C` `02 01` reply** — the hold's switch list. `queryNoiseSwitchModes()` is sent in the
  init sequence, but **no capture has ever shown an answer to it**, so the reply's shape is unknown.
  This is the blocker for the hold mode picker.
- `0x0500` / `0x0501` — empty payloads, so they cannot be gesture bindings. Seen right after ANC
  writes; possibly this firmware's alternate ANC notification.
- Broadcast codes `0x04` / `0x08` / `0x0B`.
- The `0x810D` batch-status reply layout.
