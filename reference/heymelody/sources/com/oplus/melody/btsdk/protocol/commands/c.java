package com.oplus.melody.btsdk.protocol.commands;

import com.oplus.melody.btsdk.api.data.BassEngineInfo;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.btsdk.api.data.EarTone;
import com.oplus.melody.btsdk.api.data.EqInfo;
import com.oplus.melody.btsdk.api.data.FeatureSwitchInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhancementEarScanResult;
import com.oplus.melody.btsdk.api.data.MultiConnectInformationElement;
import com.oplus.melody.btsdk.api.data.MultiConnectInformations;
import com.oplus.melody.btsdk.api.data.StatusInfo;
import com.oplus.melody.common.util.K;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import z7.C1725a;

/* JADX INFO: compiled from: CommandUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static String a(Set<Integer> set) {
        if (set == null || set.isEmpty()) {
            return "Set is empty";
        }
        StringBuilder sb2 = new StringBuilder("Set is ");
        for (Integer num : set) {
            sb2.append("0x");
            sb2.append(Integer.toHexString(num.intValue() & 65535));
            sb2.append(";");
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<EqInfo> b(int i10, byte[] bArr) {
        ArrayList arrayList;
        int i11;
        byte[] bArr2;
        List<EqInfo> list = null;
        if (bArr == null || bArr.length <= i10) {
            C1725a.a("CommandUtil", "The length of data is not valid when all eq data");
            return null;
        }
        int i12 = i10 + 1;
        int i13 = bArr[i10] & 255;
        if (i13 <= 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList2 = new ArrayList(i13);
        int i14 = 0;
        while (i14 < i13) {
            int i15 = i12 + 1;
            try {
                if (i15 > bArr.length) {
                    C1725a.f("CommandUtil", "parseAllEqData isSelect error i:" + i14 + " offset:" + i12 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    return list;
                }
                int iP = D5.c.p(bArr, i12, 1, true);
                int i16 = i12 + 2;
                if (i16 > bArr.length) {
                    C1725a.f("CommandUtil", "parseAllEqData minValue error i:" + i14 + " offset:" + i15 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    return list;
                }
                byte b4 = bArr[i15];
                int i17 = i12 + 3;
                List<EqInfo> list2 = list;
                if (i17 > bArr.length) {
                    C1725a.f("CommandUtil", "parseAllEqData maxValue error i:" + i14 + " offset:" + i16 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    return list2;
                }
                byte b5 = bArr[i16];
                int i18 = i12 + 4;
                if (i18 > bArr.length) {
                    C1725a.f("CommandUtil", "parseAllEqData eqId error i:" + i14 + " offset:" + i17 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    return list2;
                }
                int iP2 = D5.c.p(bArr, i17, 1, true);
                int i19 = i12 + 5;
                if (i19 > bArr.length) {
                    C1725a.f("CommandUtil", "parseAllEqData nameLength error i:" + i14 + " offset:" + i18 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    return list2;
                }
                int iP3 = D5.c.p(bArr, i18, 1, true);
                int i20 = i19 + iP3;
                if (i20 > bArr.length) {
                    C1725a.f("CommandUtil", "parseAllEqData name error i:" + i14 + " offset:" + i19 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    return list2;
                }
                if (iP3 > 0) {
                    i11 = i13;
                    byte[] bArr3 = new byte[iP3];
                    System.arraycopy(bArr, i19, bArr3, 0, iP3);
                    i19 = i20;
                    bArr2 = bArr3;
                } else {
                    i11 = i13;
                    C1725a.l("CommandUtil", "parseAllEqData nameLength error, nameLength = " + iP3 + ", i:" + i14 + " offset:" + i19 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                    bArr2 = list2;
                }
                int i21 = i19 + 1;
                ArrayList arrayList3 = arrayList2;
                try {
                    if (i21 > bArr.length) {
                        C1725a.f("CommandUtil", "parseAllEqData frequencyNum error i:" + i14 + " offset:" + i19 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                        return list2;
                    }
                    int iP4 = D5.c.p(bArr, i19, 1, true);
                    if (iP4 < 1) {
                        C1725a.f("CommandUtil", "parseAllEqData frequencyNum error, frequencyNum = " + iP4 + ", i:" + i14 + " offset:" + i21 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                        return list2;
                    }
                    int[] iArr = new int[iP4];
                    int[] iArr2 = new int[iP4];
                    int i22 = 0;
                    while (i22 < iP4) {
                        int i23 = iP4;
                        int i24 = i21 + 2;
                        int[] iArr3 = iArr2;
                        int[] iArr4 = iArr;
                        byte b10 = b5;
                        if (i24 > bArr.length) {
                            C1725a.f("CommandUtil", "parseAllEqData frequency error i:" + i14 + ", k:" + i22 + ", offset:" + i21 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                            return list2;
                        }
                        byte b11 = b4;
                        iArr4[i22] = D5.c.p(bArr, i21, 2, true);
                        i21 += 3;
                        if (i21 > bArr.length) {
                            C1725a.f("CommandUtil", "parseAllEqData dbValue error i:" + i14 + ", k:" + i22 + ", offset:" + i24 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                            return list2;
                        }
                        iArr3[i22] = bArr[i24];
                        i22++;
                        iP4 = i23;
                        iArr2 = iArr3;
                        iArr = iArr4;
                        b5 = b10;
                        b4 = b11;
                    }
                    byte b12 = b5;
                    int[] iArr5 = iArr;
                    byte b13 = b4;
                    int[] iArr6 = iArr2;
                    EqInfo eqInfo = new EqInfo();
                    eqInfo.setEqId(iP2);
                    if (bArr2 != 0) {
                        eqInfo.setName(new String(bArr2, Charset.defaultCharset()));
                    }
                    eqInfo.setNameLength(iP3);
                    eqInfo.setIsSelected(iP);
                    eqInfo.setMinValue(b13);
                    eqInfo.setMaxValue(b12);
                    eqInfo.setFrequency(iArr5);
                    eqInfo.setDbValue(iArr6);
                    arrayList = arrayList3;
                    try {
                        arrayList.add(eqInfo);
                        C1725a.c("CommandUtil", new P3.d(eqInfo, 24));
                        i14++;
                        arrayList2 = arrayList;
                        i12 = i21;
                        list = list2;
                        i13 = i11;
                    } catch (Exception e10) {
                        e = e10;
                        C1725a.f("CommandUtil", "parseAllEqData throws Exception:" + e);
                        return arrayList;
                    }
                } catch (Exception e11) {
                    e = e11;
                    arrayList = arrayList3;
                }
            } catch (Exception e12) {
                e = e12;
                arrayList = arrayList2;
            }
        }
        return arrayList2;
    }

    public static BassEngineInfo c(int i10, byte[] bArr) {
        int i11;
        if (bArr == null || bArr.length <= (i11 = i10 + 2)) {
            C1725a.f("CommandUtil", "The length of data is not valid when parse bass engine status");
            return null;
        }
        BassEngineInfo bassEngineInfo = new BassEngineInfo();
        bassEngineInfo.setMinValue(bArr[i10]);
        bassEngineInfo.setMaxValue(bArr[i10 + 1]);
        bassEngineInfo.setCurrentValue(bArr[i11]);
        return bassEngineInfo;
    }

    public static ArrayList d(int i10, byte[] bArr) {
        if (bArr == null || bArr.length <= i10) {
            C1725a.a("CommandUtil", "The length of data is not valid when receive battery info");
            return null;
        }
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        if (i12 == 0 || bArr.length < (i12 * 2) + i11) {
            A6.g.j(androidx.appcompat.widget.a.n(i12, "Length is not valid when receive battery information. number=", ", length="), bArr.length, "CommandUtil");
            return null;
        }
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            arrayList.add(new BatteryInfo(i11, bArr));
            i11 += 2;
        }
        return arrayList;
    }

    public static ArrayList e(int i10, byte[] bArr) {
        if (bArr == null || bArr.length <= i10) {
            C1725a.f("CommandUtil", "The length is not valid when receive ear buds key");
            return null;
        }
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        if (i12 == 0 || bArr.length < (i12 * 2) + i11) {
            C1725a.c("CommandUtil", new S6.d(i12, 1, bArr));
            return null;
        }
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            arrayList.add(new StatusInfo(i11, bArr));
            i11 += 2;
        }
        return arrayList;
    }

    public static HearingEnhancementEarScanResult f(int i10, byte[] bArr) {
        try {
            HearingEnhancementEarScanResult hearingEnhancementEarScanResult = new HearingEnhancementEarScanResult();
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.position(i10);
            hearingEnhancementEarScanResult.setAction(byteBufferWrap.get());
            byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
            hearingEnhancementEarScanResult.setDataLength(byteBufferWrap.getShort());
            byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
            byte[] bArr2 = new byte[hearingEnhancementEarScanResult.getDataLength()];
            byteBufferWrap.get(bArr2);
            hearingEnhancementEarScanResult.setResultData(bArr2);
            hearingEnhancementEarScanResult.setUniqueId(byteBufferWrap.getInt());
            return hearingEnhancementEarScanResult;
        } catch (Exception e10) {
            C1725a.f("CommandUtil", "parseEarScanResult throws Exception: " + e10);
            return null;
        }
    }

    public static ArrayList g(int i10, byte[] bArr) {
        String str;
        try {
            int iP = D5.c.p(bArr, i10, 1, true);
            int i11 = i10 + 1;
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < iP; i12++) {
                int iP2 = D5.c.p(bArr, i11, 4, true);
                int iP3 = D5.c.p(bArr, i11 + 4, 1, true);
                int iP4 = D5.c.p(bArr, i11 + 5, 4, true);
                int iP5 = D5.c.p(bArr, i11 + 9, 1, true);
                int i13 = i11 + 10;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.position(i13);
                if (byteBufferWrap.hasRemaining()) {
                    int i14 = bArr[i13] & 255;
                    byte[] bArr2 = new byte[i14];
                    byteBufferWrap.get(bArr2, 0, i14);
                    i11 = i11 + 11 + i14;
                    str = new String(bArr2, Charset.defaultCharset());
                } else {
                    str = null;
                    i11 = i13;
                }
                arrayList.add(new EarTone(iP2, iP3, str, iP4, iP5));
            }
            return arrayList;
        } catch (Exception e10) {
            C1725a.f("CommandUtil", "parseEarToneResult throws Exception: " + e10);
            return null;
        }
    }

    public static MultiConnectInformations h(String str, int i10, byte[] bArr) {
        MultiConnectInformations multiConnectInformations;
        MultiConnectInformations multiConnectInformations2 = null;
        if (bArr == null || bArr.length <= i10) {
            C1725a.f("CommandUtil", "parseMultiConnectStateInfo length error data = " + E8.a.e(bArr));
            return null;
        }
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        if (i12 <= 0) {
            A6.g.j(androidx.appcompat.widget.a.n(i12, "parseMultiConnectStateInfo error number: ", ", length = "), bArr.length, "CommandUtil");
            return null;
        }
        ArrayList arrayList = new ArrayList(i12);
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i11 + 6;
            try {
                try {
                    if (i14 > bArr.length) {
                        C1725a.f("CommandUtil", "parseMultiConnectStateInfo mac error i:" + i13 + " offset:" + i11 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                        return multiConnectInformations2;
                    }
                    try {
                        String strD = K.d(bArr, i11, 6, true, ":");
                        int i15 = i11 + 7;
                        if (i15 > bArr.length) {
                            C1725a.f("CommandUtil", "parseMultiConnectStateInfo length error i:" + i13 + " offset:" + i14 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                            return multiConnectInformations2;
                        }
                        int iP = D5.c.p(bArr, i14, 1, true);
                        int i16 = i11 + 8;
                        multiConnectInformations = multiConnectInformations2;
                        try {
                            if (i16 > bArr.length) {
                                C1725a.f("CommandUtil", "parseMultiConnectStateInfo state error i:" + i13 + " offset:" + i15 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                                return multiConnectInformations;
                            }
                            int iP2 = D5.c.p(bArr, i15, 1, true);
                            int i17 = i11 + 9;
                            if (i17 > bArr.length) {
                                C1725a.f("CommandUtil", "parseMultiConnectStateInfo flag error i:" + i13 + " offset:" + i16 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                                return multiConnectInformations;
                            }
                            int iP3 = D5.c.p(bArr, i16, 1, true);
                            C1725a.c("CommandUtil", new Ba.b(iP3, 26));
                            boolean z2 = (iP3 & 1) != 0;
                            boolean z4 = (iP3 & 2) != 0;
                            boolean z10 = (iP3 & 4) != 0;
                            int i18 = (((iP3 >> 5) & 1) * 4) + (((iP3 >> 4) & 1) * 2) + ((iP3 >> 3) & 1);
                            int i19 = i11 + 10;
                            if (i19 > bArr.length) {
                                C1725a.f("CommandUtil", "parseMultiConnectStateInfo nameLen error i:" + i13 + " offset:" + i17 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                                return multiConnectInformations;
                            }
                            int iP4 = D5.c.p(bArr, i17, 1, true);
                            int i20 = i19 + iP4;
                            if (i20 > bArr.length) {
                                C1725a.f("CommandUtil", "parseMultiConnectStateInfo name error i:" + i13 + " offset:" + i19 + " len:" + bArr.length + " data:" + E8.a.e(bArr));
                                return multiConnectInformations;
                            }
                            byte[] bArr2 = new byte[iP4];
                            System.arraycopy(bArr, i19, bArr2, 0, iP4);
                            i11 = ((iP - iP4) - 3) + i20;
                            if (strD != null && !strD.equalsIgnoreCase("00:00:00:00:00:00")) {
                                arrayList.add(new MultiConnectInformationElement(strD, new String(bArr2, Charset.defaultCharset()), iP2, z2, z4, z10, i18));
                            }
                            i13++;
                            multiConnectInformations2 = multiConnectInformations;
                        } catch (Exception e10) {
                            e = e10;
                            multiConnectInformations2 = multiConnectInformations;
                            C1725a.f("CommandUtil", "parseMultiConnectStateInfo throws Exception:" + e.toString());
                            return multiConnectInformations2;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        multiConnectInformations = multiConnectInformations2;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
            }
        }
        MultiConnectInformations multiConnectInformations3 = new MultiConnectInformations();
        try {
            multiConnectInformations3.setList(arrayList);
            multiConnectInformations3.setAddress(str);
            return multiConnectInformations3;
        } catch (Exception e14) {
            e = e14;
            multiConnectInformations2 = multiConnectInformations3;
            C1725a.f("CommandUtil", "parseMultiConnectStateInfo throws Exception:" + e.toString());
            return multiConnectInformations2;
        }
    }

    public static ArrayList i(int i10, byte[] bArr) {
        if (bArr == null || bArr.length <= i10) {
            C1725a.a("CommandUtil", "The length of data is not valid when feature switch info");
            return null;
        }
        int i11 = i10 + 1;
        int i12 = bArr[i10] & 255;
        if (i12 == 0 || bArr.length < (i12 * 2) + i11) {
            A6.g.j(androidx.appcompat.widget.a.n(i12, "Length is not valid when receive feature switch information. number = ", ", length = "), bArr.length, "CommandUtil");
            return null;
        }
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            FeatureSwitchInfo featureSwitchInfo = new FeatureSwitchInfo(i11, bArr);
            i11 += 2;
            arrayList.add(featureSwitchInfo);
        }
        return arrayList;
    }

    public static int j(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            return bArr[0];
        }
        C1725a.f("CommandUtil", "The length is 0, when parse data is null.");
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList k(int r8, byte[] r9) {
        /*
            r0 = 1
            r1 = 0
            java.lang.String r2 = "CommandUtil"
            if (r9 == 0) goto L55
            int r3 = r9.length
            if (r3 > r8) goto La
            goto L55
        La:
            int r3 = r8 + 1
            r8 = r9[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r4 = r9.length
            if (r4 > r3) goto L20
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r3 = "The length of data is not valid "
            r8.<init>(r3)
            int r9 = r9.length
            A6.g.j(r8, r9, r2)
        L1e:
            r9 = r1
            goto L5b
        L20:
            java.lang.String r4 = new java.lang.String
            int r5 = r9.length
            int r5 = r5 - r3
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            r4.<init>(r9, r3, r5, r6)
            java.lang.String r9 = ","
            java.lang.String[] r9 = r4.split(r9)
            if (r9 == 0) goto L36
            int r3 = r9.length
            int r5 = r8 * 3
            if (r3 == r5) goto L5b
        L36:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r3 = "The number is not valid "
            r9.<init>(r3)
            r9.append(r8)
            java.lang.String r8 = ", raw string = "
            r9.append(r8)
            r9.append(r4)
            java.lang.String r8 = ", count = 3"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            z7.C1725a.f(r2, r8)
            goto L1e
        L55:
            java.lang.String r8 = "There is no continue value when parse key type value."
            z7.C1725a.f(r2, r8)
            goto L1e
        L5b:
            if (r9 != 0) goto L63
            java.lang.String r8 = "Parse value failed when receive remote version command"
            z7.C1725a.f(r2, r8)
            return r1
        L63:
            int r8 = r9.length
            int r8 = r8 / 3
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r8)
            r3 = 0
        L6c:
            if (r3 >= r8) goto L84
            int r4 = r3 * 3
            com.oplus.melody.btsdk.api.data.VersionInfo r5 = new com.oplus.melody.btsdk.api.data.VersionInfo
            r6 = r9[r4]
            int r7 = r4 + 1
            r7 = r9[r7]
            int r4 = r4 + 2
            r4 = r9[r4]
            r5.<init>(r6, r7, r4)
            r1.add(r5)
            int r3 = r3 + r0
            goto L6c
        L84:
            com.oplus.melody.common.util.A$a r8 = z7.C1725a.f29476a
            boolean r8 = com.oplus.melody.common.util.A.l()
            if (r8 == 0) goto L94
            W3.c r8 = new W3.c
            r8.<init>(r1, r0)
            z7.C1725a.c(r2, r8)
        L94:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.protocol.commands.c.k(int, byte[]):java.util.ArrayList");
    }
}
