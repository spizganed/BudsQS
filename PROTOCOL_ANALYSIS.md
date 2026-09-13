```0markdown
# OPO Protocol Analysis — HeyMelody Reverse Engineering

**Date:** 2026-09-13
**Analysis source:** Decompiled HeyMelody 116.9.0 APK (com.heytap.headset)
**Decompiler:** apktool (smali) + JADX (Java sources)

---

## 1. Connection Channel

- **Transport:** Classic Bluetooth RFCOMM (not BLE GATT)
- **UUID:** `0000111E-0000-1000-8000-00805F9B34FB` (Hands-Free Profile)
- **Socket type:** `createRfcommSocketToServiceRecord` (secure)
- **Location:** `q7/a.smali` (`BaseBRConnection.java`) — holds `BluetoothSocket`, `InputStream`, `OutputStream`, dedicated reader/writer threads via `LinkedBlockingDeque`
- **NO HFP AT handshake is sent** — `BRSF`, `CIND`, `CMER` do not appear anywhere in the codebase. HeyMelody opens the RFCOMM socket and immediately treats it as a raw byte pipe.

## 2. Internal Packet Format (f7/a — Packet.java)

Every command is a `f7/a` object with:

| Field | Size | Notes |
|-------|------|-------|
| Command ID | 16-bit (big-endian) | Parsed from bytes[0..1], masked with `0x7FFF` |
| Sequence | 8-bit | Per-device counter, increments by 1, wraps at `0xFF` |
| Payload length | 16-bit (big-endian) | Parsed from bytes[3..4] |
| Payload | N bytes | Raw command data |
| Version/Flag | 8-bit | Defaults to `0x65` (101) |

**Serialized wire format (from `f7/a([B)` parser):**
```

[ID_hi][ID_lo][SEQ][LEN_hi][LEN_lo][PAYLOAD...]

```

**Response marker:** HeyMelody sets `0x8000` bit on IDs in *responses*. So `0x0446` request → `0x8446` response.

## 3. Command ID Ranges

| Range | Purpose |
|-------|---------|
| `0x100`-`0x1FF` | Polling / status requests (e.g. `0x10C`, `0x11D`) |
| `0x300` | Special class of commands |
| `0x400`-`0x4FF` | Device controls (ANC, EQ, Game Mode, Find My, etc.) |

### Confirmed Command IDs

| ID | Purpose | Evidence |
|----|---------|----------|
| `0x400` | setFindMode | `L.smali:13430` |
| `0x401` | getSupportNoiseReduction (ANC capability query) | `L.smali:3068` |
| `0x403` | setSwitchFeature (Game Mode = feature 0x28) | `L.smali:2538` + `GameModeItem.smali:472` |
| `0x405` | startFitDetection (Ear Fit Test) | `L.smali:3436` |
| `0x406` | setEqualizerMode (EQ) | `L.smali:13107` |
| `0x409` | (firmware/version?) | `L.smali:3488` |
| `0x412` | setPersonalizedNoiseReduction | `L.smali:16344` |
| `0x413` | (with param_product_id) | `L.smali:4046` |
| `0x414` | requestDeviceVersion | `L.smali:5063` |
| `0x415` | (unknown, refresh?) | `L.smali:2449` |
| `0x423` | getGameSoundList check | `i.smali:405` |
| `0x42d` | (with param_host_triangle_info) | `L.smali:3980` |

## 4. Feature IDs (used inside `0x403` setSwitchFeature)

Feature IDs are capability bits, not command bytes:

| Feature ID | Purpose |
|-----------|---------|
| `0x22` | (Unknown - from whitelist) |
| `0x23` | (Unknown - from whitelist) |
| `0x24` | (Unknown - from whitelist) |
| `0x27` | (Game Sound related) |
| `0x28` | **Game Mode (low latency)** |
| `0x30` | Adaptive Volume |
| `0x31` | Adaptive Ear |
| `0x32` | Speech Perception |

## 5. The Game Mode Command Chain

```

GameModeItem.setChecked(true)
→ EarphoneRepositoryClientImpl.E0(0x28, true, macAddress)
→ EarphoneRepositoryClientImpl.F0(macAddress, 0x28, true, true)
→ L.w1(macAddress, 0x403, supplier)
→ DeviceInteractionImpl.b(deviceInfo, packet, bytes, callback)
→ HeadsetCoreService.u0(deviceAddress, packet)
→ RFCOMM OutputStream.write(serializedBytes)

```

**The actual bytes sent:** To be captured with Wireshark. The internal packet is `[id=0x0403][seq][len=2][payload=0x28 0x01]`, but the wire format wrapper (with `AA` header) is applied somewhere between `u0` and `OutputStream.write` — this is the missing piece.

## 6. Captured Packets (RFCOMM, raw bytes)

### ANC Off
```

AA 0A 00 00 04 04 46 03 00 01 01 01

```

### ANC Medium
```

AA 0A 00 00 04 04 48 03 00 01 01 20

```

### ANC High (Real-time)
```

AA 0A 00 00 04 04 4A 03 00 01 01 10

```

### ANC Low
```

AA 0A 00 00 04 04 4C 03 00 01 01 40

```

### ANC Auto
```

AA 0A 00 00 04 04 4E 03 00 01 01 80

```

### Game Mode ON (full packet from capture)
```

AA 09 00 00 0C 01 53 02 00 02 01 F1 00 00 00 08 00 00 00 08 00 00 00 03 00

```

### Game Mode OFF
```

AA 09 00 00 0C 01 54 02 00 02 01 F1 00 00 00 08 00 00 00 08 00 00 00 03 00

```

### Response from Buds (ACK)
```

AA 08 00 00 04 84 [seq] 01 00 00     ← success (0x8000 bit set on id 0x0446|0x8000=0x8446)
AA 08 00 00 04 84 [seq] 01 00 02     ← error
AA 0D 00 00 04 02 FF 06 00 F1 [L] [R] 00 00 03   ← battery/state packet
AA 07 00 00 01 05 [XX] 00 00         ← bud-out state (0x05=right, 0x06=left, 0x02=both)

```

## 7. Wire Format Observations

From the raw packet captures, the outer wire format appears to be:

```

AA [class] [00] [00] [svc_hi] [svc_lo] [seq] [subcmd] [len_hi] [len_lo] [payload...]

```

Where:
- `AA` = magic byte
- `[class]` = command class (0x09 = Game Mode class, 0x0A = ANC class)
- `00 00` = reserved
- `[svc_hi][svc_lo]` = service identifier
- `[seq]` = sequence counter
- `[subcmd]` = subcommand
- `[len]` = payload length

**TODO:** Confirm with Wireshark capture comparing ANC and Game Mode packets byte-by-byte.

## 8. HeyMelody's Service Architecture

Key components (from manifest and smali):

- **`com.heytap.headset.service.KeepAliveFgService`** — Foreground service, type `connectedDevice`
- **`com.heytap.headset.service.KeepAliveBgService`** — Background companion
- **`com.heytap.headset.service.KeepAliveJobService`** — JobScheduler-based restart
- **`com.heytap.headset.receiver.KeepAliveReceiver`** — Listens for Bluetooth ACL/A2DP/HFP state changes
- **`com.oplus.melody.btsdk.multidevice.HeadsetCoreService`** — Main Bluetooth orchestration service
- **`com.oplus.melody.btsdk.manager.service.BluetoothService`** — Legacy BT service
- **`com.oplus.melody.btsdk.spp.internal.connect.ble.GattConnectionAttempt`** — Enum with 11 states (IDLE, CONNECTING_ACTIVE, CONNECTING_PASSIVE, etc.)
- **`com.oplus.melody.btsdk.spp.internal.connect.br.EnumCloseType`** — UNKNOWN, ACTIVE, INACTIVE
- **`com.oplus.melody.btsdk.spp.internal.connect.br.*`** — BR/EDR connection classes

## 9. Outstanding Questions (for Wireshark analysis)

1. What bytes does the phone send for "Game Mode On" over the wire?
2. What is the exact framing (`AA` header) applied around the internal packet?
3. Is there a session initialization sequence required before Game Mode commands are accepted?
4. What are the exact battery byte offsets in the `AA 0D` packet?
5. How does HeyMelody maintain the RFCOMM connection across disconnects (case in/out, range)?
6. What is the "private command over flag" (`q7/c;->b:[B` = `[0x00]`, `q7/c;->c:[B` = `[0x00]`) used for?
7. Does the packet require a specific sequence byte range, or is any counter valid?

## 10. Known Command Behaviors

- **`f7/b.a(address, cmdId, payload)`** — builds an `f7/a` Packet. Sequence counter is per-device in a `HashMap<String, Integer>`.
- **`f7/b.b(packet, bytes)`** — marks a packet as response by setting `0x8000` bit on the command ID.
- **`HeadsetCoreService.u0(address, packet)`** — the send entry point.
- **`r7/c.b(deviceInfo, packet, bytes, callback)`** — device interaction layer; checks connection state; branches on `overGattDevice`.
- **`m7/b.a(deviceInfo, [B)`** and **`m7/b.a(deviceInfo, IIZ)`** — connection state handling.

---

## Analysis Notes

- `0x65` is a default protocol version constant appearing in every `f7/a` construction.
- The `AA` bytes we captured are **not** in the smali as literals — the wire format is likely computed via `ByteBuffer.put()` inside `q7/a` or `p7/a`, or inside `HeadsetCoreService` before dispatch to the RFCOMM socket.
- `0x403` is **not** a command byte — it's a 16-bit **command ID** in the internal packet header.
- `0x28` is **not** a command byte — it's a **feature ID** in the payload of a `0x403` packet.
- Standard Bluetooth UUIDs (`00001101`, `0000111E`) are the *only* UUIDs referenced — no custom UUIDs for the OPO protocol.
```
