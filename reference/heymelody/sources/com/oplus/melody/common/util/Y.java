package com.oplus.melody.common.util;

import D7.C0373g;
import D7.C0391z;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: WhitelistUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class Y {
    public static WhitelistConfigDTO a(Collection<WhitelistConfigDTO> collection, String str, String str2) {
        if (collection != null && !collection.isEmpty()) {
            List list = Collections.EMPTY_LIST;
            List<WhitelistConfigDTO> list2 = TextUtils.isEmpty(str2) ? list : (List) collection.stream().filter(new W(str2, 0)).collect(Collectors.toList());
            if (!TextUtils.isEmpty(str)) {
                list = (List) collection.stream().filter(new X(str, 0)).collect(Collectors.toList());
            }
            if (!list2.isEmpty() || !list.isEmpty()) {
                if (list2.isEmpty()) {
                    WhitelistConfigDTO whitelistConfigDTO = (WhitelistConfigDTO) list.get(0);
                    whitelistConfigDTO.getId();
                    whitelistConfigDTO.getName();
                    return whitelistConfigDTO;
                }
                for (WhitelistConfigDTO whitelistConfigDTO2 : list2) {
                    if (list.contains(whitelistConfigDTO2)) {
                        return whitelistConfigDTO2;
                    }
                }
                WhitelistConfigDTO whitelistConfigDTO3 = (WhitelistConfigDTO) list2.get(0);
                whitelistConfigDTO3.getId();
                whitelistConfigDTO3.getName();
                return whitelistConfigDTO3;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.equals("000000", str)) {
                A.o(5, "WhitelistUtils", "findWhitelistConfig failed", MelodyException.e(404, "None by " + str + '(' + A.q(str2) + ')'));
                return null;
            }
        }
        return null;
    }

    public static WhitelistConfigDTO b(BluetoothDevice bluetoothDevice, List list) {
        C0391z c0391z = C0391z.f1171d;
        String strF = c0391z.f(bluetoothDevice);
        if (TextUtils.isEmpty(strF)) {
            return null;
        }
        List<WhitelistConfigDTO> list2 = (List) list.stream().filter(new Z6.a(strF, 1)).collect(Collectors.toList());
        if (list2.isEmpty()) {
            A.j("WhitelistUtils", "findWhitelistConfigByDevice NOT_FOUND name=" + A.q(strF));
            return null;
        }
        if (list2.size() > 1) {
            Set<UUID> setJ = c0391z.j(bluetoothDevice);
            try {
                for (WhitelistConfigDTO whitelistConfigDTO : list2) {
                    if (!TextUtils.isEmpty(whitelistConfigDTO.getUuid())) {
                        UUID uuidFromString = UUID.fromString(whitelistConfigDTO.getUuid());
                        if (!setJ.contains(uuidFromString) && !setJ.contains(new UUID(Long.reverseBytes(uuidFromString.getLeastSignificantBits()), Long.reverseBytes(uuidFromString.getMostSignificantBits())))) {
                        }
                        return whitelistConfigDTO;
                    }
                }
            } catch (Exception e10) {
                A.o(4, "WhitelistUtils", "findWhitelistConfigByDevice NOT_FOUND name=" + A.q(strF), e10);
            }
            A.w("WhitelistUtils", "检测到重复蓝牙名称：size=" + list2.size() + " name=" + A.q(strF), null);
        }
        return (WhitelistConfigDTO) list2.get(0);
    }

    public static List<String> c(String str, WhitelistConfigDTO whitelistConfigDTO) {
        return (List) ((List) Optional.ofNullable(whitelistConfigDTO).map(new A6.i(27)).map(new A6.c(27)).orElse(Collections.EMPTY_LIST)).stream().map(new N9.l(str, 1)).filter(new A6.h(2)).collect(Collectors.toList());
    }

    public static String d(Context context) {
        if (S.t(context)) {
            return "com.oplus.melody.providers.MelodyProvider";
        }
        return context.getPackageName() + ".alive.WhitelistProvider";
    }

    public static boolean e(int i10, boolean z2) {
        if (i10 == 0) {
            return false;
        }
        if (i10 != 1) {
            return z2;
        }
        return true;
    }

    public static boolean f(WhitelistConfigDTO.Function function, int i10) {
        List<WhitelistConfigDTO.GameMode> gameModeList = function.getGameModeList();
        if (gameModeList != null && gameModeList.size() > 0) {
            gameModeList.sort(new androidx.core.provider.d(1));
            for (int i11 = 0; i11 < gameModeList.size(); i11++) {
                WhitelistConfigDTO.GameMode gameMode = gameModeList.get(i11);
                if (i10 >= gameMode.getVersion()) {
                    return e(gameMode.getGameMode(), false);
                }
            }
        }
        return e(function.getGameMode(), false);
    }

    public static boolean g(WhitelistConfigDTO.Function function) {
        return "export".equalsIgnoreCase(C0373g.f1087m) && function != null && e(function.getSpyTap(), false);
    }

    public static boolean h(WhitelistConfigDTO whitelistConfigDTO) {
        return (whitelistConfigDTO == null || whitelistConfigDTO.getFunction() == null || !e(whitelistConfigDTO.getFunction().getWearDetection(), false)) ? false : true;
    }

    public static boolean i(String str) {
        return "O1".equals(str) || "O2".equals(str);
    }

    public static boolean j(WhitelistConfigDTO whitelistConfigDTO) {
        String brand;
        return (whitelistConfigDTO == null || (brand = whitelistConfigDTO.getBrand()) == null || !brand.startsWith("real")) ? false : true;
    }

    public static boolean k(WhitelistConfigDTO whitelistConfigDTO) {
        return whitelistConfigDTO != null && l(whitelistConfigDTO.getType());
    }

    public static boolean l(String str) {
        return "S".equals(str) || "N".equals(str);
    }

    public static boolean m(String str) {
        return "T1".equals(str) || "T2".equals(str) || i(str);
    }

    public static boolean n(String str, WhitelistConfigDTO whitelistConfigDTO) {
        if (str == null || whitelistConfigDTO == null || TextUtils.isEmpty(whitelistConfigDTO.getName())) {
            return false;
        }
        return whitelistConfigDTO.getFuzzyMatchName() ? str.startsWith(whitelistConfigDTO.getName()) : str.equals(whitelistConfigDTO.getName());
    }

    public static WhitelistConfigDTO o(HeyMelodyApplication heyMelodyApplication, Uri uri) throws Throwable {
        Throwable th;
        A7.b.f86a.getClass();
        if (!A7.b.b()) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        int count = 0;
        try {
            Cursor cursorQuery = heyMelodyApplication.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        count = cursorQuery.getCount();
                        WhitelistConfigDTO whitelistConfigDTO = (WhitelistConfigDTO) C0917x.c(WhitelistConfigDTO.class, cursorQuery.getString(cursorQuery.getColumnIndex("content")));
                        cursorQuery.close();
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        if (A.l()) {
                            StringBuilder sbN = androidx.appcompat.widget.a.n(count, "queryOneWhitelist size=", " timeMillis=");
                            sbN.append(SystemClock.elapsedRealtime() - jElapsedRealtime);
                            A.b("WhitelistUtils", sbN.toString());
                        }
                        return whitelistConfigDTO;
                    }
                } catch (Throwable th2) {
                    int i10 = count;
                    try {
                        try {
                            cursorQuery.close();
                            throw th2;
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        count = i10;
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        if (!A.l()) {
                            throw th;
                        }
                        StringBuilder sbN2 = androidx.appcompat.widget.a.n(count, "queryOneWhitelist size=", " timeMillis=");
                        sbN2.append(SystemClock.elapsedRealtime() - jElapsedRealtime);
                        A.b("WhitelistUtils", sbN2.toString());
                        throw th;
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            Binder.restoreCallingIdentity(jClearCallingIdentity);
            if (!A.l()) {
                return null;
            }
            A.b("WhitelistUtils", "queryOneWhitelist size=0 timeMillis=" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            return null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static WhitelistConfigDTO p(HeyMelodyApplication heyMelodyApplication, String str) {
        return o(heyMelodyApplication, Uri.parse("content://" + d(C0906l.f19501a) + "/find_whitelist").buildUpon().appendQueryParameter("macAddress", str).build());
    }

    public static WhitelistConfigDTO q(HeyMelodyApplication heyMelodyApplication, String str, String str2) {
        return o(heyMelodyApplication, Uri.parse("content://" + d(C0906l.f19501a) + "/find_whitelist").buildUpon().appendQueryParameter("productId", str).appendQueryParameter("deviceName", str2).build());
    }

    public static boolean r(WhitelistConfigDTO.Function function, int i10) {
        if (A.l()) {
            A.b("WhitelistUtils", "supportPersonalNoise version=" + i10);
        }
        if (function == null) {
            return false;
        }
        if (e(function.getPersonalNoise(), false)) {
            A.b("WhitelistUtils", "personal noise support");
            return true;
        }
        if (function.getPersonalNoiseCompat() == null || function.getPersonalNoiseCompat().getMinFirmVersion() > i10) {
            return false;
        }
        A.b("WhitelistUtils", "personal noise compat support");
        return true;
    }
}
