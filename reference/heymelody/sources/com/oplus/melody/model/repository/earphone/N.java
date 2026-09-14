package com.oplus.melody.model.repository.earphone;

import D7.C0384s;
import android.text.TextUtils;
import androidx.media3.session.D0;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0912s;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.EarphoneStatusDO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: EarphoneUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f19941a = Pattern.compile("^[0-9]*$");

    public static void a(ArrayList arrayList, int i10, int i11, boolean z2) {
        if (i11 <= 0) {
            return;
        }
        arrayList.add(new BatteryInfo(i10, i11, z2 ? 1 : 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(int r2, java.lang.String r3) {
        /*
            if (r2 == 0) goto L6d
            r0 = 1
            if (r2 == r0) goto L6b
            r1 = 2
            if (r2 == r1) goto L61
            r1 = 17
            if (r2 == r1) goto L5e
            r1 = 18
            if (r2 == r1) goto L5b
            r1 = 22
            if (r2 == r1) goto L57
            r1 = 32
            if (r2 == r1) goto L54
            switch(r2) {
                case 4: goto L4c;
                case 5: goto L43;
                case 6: goto L49;
                case 7: goto L40;
                case 8: goto L3d;
                case 9: goto L3a;
                case 10: goto L37;
                case 11: goto L34;
                case 12: goto L31;
                case 13: goto L2e;
                default: goto L1b;
            }
        L1b:
            switch(r2) {
                case 25: goto L2b;
                case 26: goto L28;
                case 27: goto L25;
                case 28: goto L22;
                case 29: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L53
        L1f:
            r2 = 524288(0x80000, float:7.34684E-40)
            return r2
        L22:
            r2 = 262144(0x40000, float:3.67342E-40)
            return r2
        L25:
            r2 = 2097152(0x200000, float:2.938736E-39)
            return r2
        L28:
            r2 = 1048576(0x100000, float:1.469368E-39)
            return r2
        L2b:
            r2 = 131072(0x20000, float:1.83671E-40)
            return r2
        L2e:
            r2 = 4096(0x1000, float:5.74E-42)
            return r2
        L31:
            r2 = 16
            return r2
        L34:
            r2 = 8
            return r2
        L37:
            r2 = 2048(0x800, float:2.87E-42)
            return r2
        L3a:
            r2 = 256(0x100, float:3.59E-43)
            return r2
        L3d:
            r2 = 128(0x80, float:1.8E-43)
            return r2
        L40:
            r2 = 1024(0x400, float:1.435E-42)
            return r2
        L43:
            boolean r2 = com.google.android.play.core.appupdate.c.I(r3)
            if (r2 == 0) goto L52
        L49:
            r2 = 64
            return r2
        L4c:
            boolean r2 = com.google.android.play.core.appupdate.c.I(r3)
            if (r2 == 0) goto L53
        L52:
            return r1
        L53:
            return r0
        L54:
            r2 = 8388608(0x800000, float:1.1754944E-38)
            return r2
        L57:
            r2 = 32768(0x8000, float:4.5918E-41)
            return r2
        L5b:
            r2 = 65536(0x10000, float:9.1835E-41)
            return r2
        L5e:
            r2 = 8192(0x2000, float:1.148E-41)
            return r2
        L61:
            com.heytap.headset.HeyMelodyApplication r2 = com.oplus.melody.common.util.C0906l.f19501a
            boolean r2 = com.oplus.melody.common.util.S.s(r2)
            if (r2 == 0) goto L6a
            goto L6d
        L6a:
            return r1
        L6b:
            r2 = 4
            return r2
        L6d:
            r2 = 512(0x200, float:7.17E-43)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.model.repository.earphone.N.b(int, java.lang.String):int");
    }

    public static DeviceVersionDTO c(int i10, List<DeviceVersionDTO> list) {
        for (DeviceVersionDTO deviceVersionDTO : list) {
            if (deviceVersionDTO.getDeviceType() == i10) {
                return deviceVersionDTO;
            }
        }
        return null;
    }

    public static String d(String str) {
        String strReplaceAll = (TextUtils.isEmpty(str) || !str.matches("[0-9]+")) ? null : String.format(Locale.getDefault(), "%03d", Integer.valueOf(str)).replaceAll("\\d(?!$)", "$0.");
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("EarphoneUtils", "formatVersionCodeForSingleDevice version is " + strReplaceAll);
        }
        return strReplaceAll;
    }

    public static int e(int i10, List<BatteryInfo> list) {
        if (C0901g.a(list)) {
            return 0;
        }
        for (BatteryInfo batteryInfo : list) {
            if (batteryInfo.mDeviceType == i10) {
                return batteryInfo.mLevel;
            }
        }
        return 0;
    }

    public static List<BatteryInfo> f(EarphoneDTO earphoneDTO) {
        if (earphoneDTO == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(3);
        if (earphoneDTO.isSupportSpp()) {
            a(arrayList, 1, earphoneDTO.getLeftBattery(), earphoneDTO.isLeftCharging());
            a(arrayList, 2, earphoneDTO.getRightBattery(), earphoneDTO.isRightCharging());
            a(arrayList, 3, earphoneDTO.getBoxBattery(), earphoneDTO.isBoxCharging());
            return arrayList;
        }
        a(arrayList, 1, earphoneDTO.getHeadsetLeftBattery(), false);
        a(arrayList, 2, earphoneDTO.getHeadsetRightBattery(), false);
        a(arrayList, 3, earphoneDTO.getHeadsetBoxBattery(), false);
        return arrayList;
    }

    public static int g(String str, List<DeviceVersionDTO> list) {
        String strH = h(str, list);
        if (TextUtils.isEmpty(strH)) {
            Y.r.l(str, "EarphoneUtils", D0.i("getDeviceSoftwareIntVersion, versionStr = ", strH, ", addr = "));
            return -1;
        }
        try {
            return Integer.parseInt(strH);
        } catch (Exception e10) {
            com.oplus.melody.common.util.A.i("EarphoneUtils", "getDeviceSoftwareIntVersion", e10);
            return -1;
        }
    }

    public static String h(String str, List<DeviceVersionDTO> list) {
        DeviceVersionDTO deviceVersionDTOI = i(str, list);
        if (deviceVersionDTOI != null) {
            return deviceVersionDTOI.getRunning();
        }
        return null;
    }

    public static DeviceVersionDTO i(String str, List<DeviceVersionDTO> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        DeviceVersionDTO deviceVersionDTO = null;
        DeviceVersionDTO deviceVersionDTO2 = null;
        for (DeviceVersionDTO deviceVersionDTO3 : list) {
            if (deviceVersionDTO3 != null && !TextUtils.isEmpty(deviceVersionDTO3.getRunning())) {
                int deviceType = deviceVersionDTO3.getDeviceType();
                if (deviceType == 1 || deviceType == 4) {
                    deviceVersionDTO = deviceVersionDTO3;
                } else if (deviceType == 2) {
                    deviceVersionDTO2 = deviceVersionDTO3;
                }
            }
        }
        if (deviceVersionDTO == null || (deviceVersionDTO2 != null && C0912s.b(deviceVersionDTO.getRunning(), deviceVersionDTO2.getRunning()) > 0)) {
            deviceVersionDTO = deviceVersionDTO2;
        }
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("EarphoneUtils", "getMainDeviceVersion " + deviceVersionDTO + " mac=" + com.oplus.melody.common.util.A.r(str));
        }
        return deviceVersionDTO;
    }

    public static int j(int i10, List<WhitelistConfigDTO.NoiseReductionMode> list) {
        if (i10 == -1 || C0901g.a(list)) {
            return 1;
        }
        for (WhitelistConfigDTO.NoiseReductionMode noiseReductionMode : list) {
            if (noiseReductionMode != null) {
                if (noiseReductionMode.getProtocolIndex() == i10) {
                    return noiseReductionMode.getModeType();
                }
                List<WhitelistConfigDTO.NoiseReductionMode> childrenMode = noiseReductionMode.getChildrenMode();
                if (C0901g.a(childrenMode)) {
                    continue;
                } else {
                    Iterator<WhitelistConfigDTO.NoiseReductionMode> it = childrenMode.iterator();
                    while (it.hasNext()) {
                        if (it.next().getProtocolIndex() == i10) {
                            return noiseReductionMode.getModeType();
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static boolean k(int i10, List list) {
        return list != null && list.contains(Integer.valueOf(i10));
    }

    public static boolean l(EarphoneDTO earphoneDTO) {
        if (earphoneDTO == null) {
            return false;
        }
        if (earphoneDTO.getConnectionState() == 2 || earphoneDTO.getHeadsetConnectionState() == 2 || earphoneDTO.getA2dpConnectionState() == 2 || earphoneDTO.getAclConnectionState() == 2) {
            return true;
        }
        Map<String, Integer> leAudioConnectionStateMap = earphoneDTO.getLeAudioConnectionStateMap();
        if (leAudioConnectionStateMap == null) {
            leAudioConnectionStateMap = Collections.EMPTY_MAP;
        }
        Iterator<Integer> it = leAudioConnectionStateMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean m(EarphoneDTO earphoneDTO) {
        boolean z2 = false;
        if (earphoneDTO == null) {
            return false;
        }
        int channelSwitch = earphoneDTO.getChannelSwitch();
        if (channelSwitch != 0) {
            z2 = true;
            if (channelSwitch != 1) {
                return n(earphoneDTO);
            }
        }
        return z2;
    }

    public static boolean n(EarphoneDTO earphoneDTO) {
        WhitelistConfigDTO whitelistConfigDTOC;
        return (earphoneDTO == null || com.oplus.melody.common.util.S.j() < 36 || (whitelistConfigDTOC = AbstractC1508a.f().c(earphoneDTO.getProductId(), earphoneDTO.getName())) == null || whitelistConfigDTOC.getFunction() == null || !Y.e(whitelistConfigDTOC.getFunction().getDefaultSoundChannelSwitchOn(), false)) ? false : true;
    }

    public static boolean o(String str) {
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str, null);
        return whitelistConfigDTOC != null && "OnePlus".equalsIgnoreCase(whitelistConfigDTOC.getBrand());
    }

    public static boolean p(EarphoneDTO earphoneDTO) {
        int autoOTASwitch;
        if (earphoneDTO == null || com.oplus.melody.common.util.S.s(C0906l.f19501a) || (autoOTASwitch = earphoneDTO.getAutoOTASwitch()) == 0) {
            return false;
        }
        if (autoOTASwitch == 1) {
            return true;
        }
        J7.b.a().e();
        t8.t.b();
        return false;
    }

    public static boolean q(EarphoneDTO earphoneDTO) {
        WhitelistConfigDTO.Function function;
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(earphoneDTO.getProductId(), earphoneDTO.getName());
        return (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null || function.getNoiseReductionMode() == null || function.getNoiseReductionMode().isEmpty()) ? false : true;
    }

    public static long r(long j5, long j9) {
        if (j5 > 0) {
            return j9 > 0 ? Math.min(j5, j9) : j5;
        }
        if (j9 > 0) {
            return j9;
        }
        return 0L;
    }

    public static String s(EarphoneDTO earphoneDTO) {
        if (earphoneDTO == null) {
            return null;
        }
        if (earphoneDTO.isSupportSpp()) {
            if (earphoneDTO.getLeftBattery() == 0 && earphoneDTO.getRightBattery() == 0 && earphoneDTO.getBoxBattery() == 0) {
                return null;
            }
            return earphoneDTO.getLeftBattery() + "|" + earphoneDTO.getRightBattery() + "|" + earphoneDTO.getBoxBattery();
        }
        if (earphoneDTO.getHeadsetLeftBattery() == 0 && earphoneDTO.getHeadsetRightBattery() == 0 && earphoneDTO.getHeadsetBoxBattery() == 0) {
            return null;
        }
        return earphoneDTO.getHeadsetLeftBattery() + "|" + earphoneDTO.getHeadsetRightBattery() + "|" + earphoneDTO.getHeadsetBoxBattery();
    }

    public static String t(EarphoneDTO earphoneDTO) {
        if (earphoneDTO == null) {
            return null;
        }
        return u(earphoneDTO.getProductType(), earphoneDTO.getDeviceVersionList(), earphoneDTO.getHeadsetVersionList());
    }

    public static String u(String str, List list, List list2) {
        String strV = v(str, list);
        return TextUtils.isEmpty(strV) ? v(str, list2) : strV;
    }

    public static String v(String str, List list) {
        boolean z2;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z4 = true;
        if (Y.l(str)) {
            DeviceVersionDTO deviceVersionDTOC = c(1, list);
            if (deviceVersionDTOC != null) {
                String strD = d(deviceVersionDTOC.getRunning());
                if (TextUtils.isEmpty(strD)) {
                    com.oplus.melody.common.util.A.x("EarphoneUtils", "parseVersionsInfo, single error version: " + deviceVersionDTOC);
                } else {
                    sb2.append(strD);
                }
            }
        } else {
            DeviceVersionDTO deviceVersionDTOC2 = c(1, list);
            Pattern pattern = f19941a;
            if (deviceVersionDTOC2 == null || TextUtils.isEmpty(deviceVersionDTOC2.getRunning()) || !pattern.matcher(deviceVersionDTOC2.getRunning()).matches()) {
                sb2.append(0);
                z2 = true;
            } else {
                sb2.append(deviceVersionDTOC2.getRunning());
                z2 = false;
            }
            sb2.append('.');
            DeviceVersionDTO deviceVersionDTOC3 = c(2, list);
            if (deviceVersionDTOC3 == null || TextUtils.isEmpty(deviceVersionDTOC3.getRunning()) || !pattern.matcher(deviceVersionDTOC3.getRunning()).matches()) {
                sb2.append(0);
                z2 = true;
            } else {
                sb2.append(deviceVersionDTOC3.getRunning());
            }
            sb2.append('.');
            DeviceVersionDTO deviceVersionDTOC4 = c(3, list);
            if (deviceVersionDTOC4 == null || TextUtils.isEmpty(deviceVersionDTOC4.getRunning()) || !pattern.matcher(deviceVersionDTOC4.getRunning()).matches()) {
                sb2.append(0);
            } else {
                sb2.append(deviceVersionDTOC4.getRunning());
                z4 = z2;
            }
            if (z4) {
                com.oplus.melody.common.util.A.x("EarphoneUtils", "parseVersionsInfo, error version: " + ((Object) sb2) + ", left: " + deviceVersionDTOC2 + ", right: " + deviceVersionDTOC3 + ", box: " + deviceVersionDTOC4);
            }
        }
        return sb2.toString();
    }

    public static int w(int i10, String str) {
        if (i10 != -1) {
            return i10;
        }
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str, null);
        if (whitelistConfigDTOC != null && whitelistConfigDTOC.getDefaultColor() != -1) {
            com.oplus.melody.common.util.A.c("EarphoneUtils", new C0384s(22, whitelistConfigDTOC, str));
            return whitelistConfigDTOC.getDefaultColor();
        }
        if (whitelistConfigDTOC == null || !"realme".equalsIgnoreCase(whitelistConfigDTOC.getBrand())) {
            return i10;
        }
        if (whitelistConfigDTOC.getSupportSpp()) {
            com.oplus.melody.common.util.A.c("EarphoneUtils", new D(str, 1));
            return 0;
        }
        com.oplus.melody.common.util.A.c("EarphoneUtils", new Ca.b(str, 20));
        return 1;
    }

    public static void x(EarphoneStatusDO.a aVar, int i10, List<BatteryInfo> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        Iterator<BatteryInfo> it = list.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                aVar.setBattery(0);
                aVar.setCharging(false);
                return;
            }
            BatteryInfo next = it.next();
            if (next != null && next.mDeviceType == i10) {
                aVar.setBattery(next.mLevel);
                int i11 = next.mCharging;
                boolean zIsCharging = aVar.isCharging();
                if (i11 != 0) {
                    z2 = true;
                    if (i11 != 1) {
                        z2 = zIsCharging;
                    }
                }
                aVar.setCharging(z2);
                return;
            }
        }
    }
}
