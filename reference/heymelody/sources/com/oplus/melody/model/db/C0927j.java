package com.oplus.melody.model.db;

/* JADX INFO: renamed from: com.oplus.melody.model.db.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConnectedDeviceDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C0927j extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f19772j;

    @Override // G0.c
    public final void b(q1.c cVar, Object obj) {
        switch (this.f19772j) {
            case 0:
                C0929m c0929m = (C0929m) obj;
                if (c0929m.getMacAddress() != null) {
                    cVar.V(1, c0929m.getMacAddress());
                } else {
                    cVar.a(1);
                }
                break;
            case 1:
                E e10 = (E) obj;
                if (e10.getMacAddress() != null) {
                    cVar.V(1, e10.getMacAddress());
                } else {
                    cVar.a(1);
                }
                break;
            default:
                N n10 = (N) obj;
                String str = n10.mResId;
                if (str == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, str);
                }
                String str2 = n10.mRandomId;
                if (str2 == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, str2);
                }
                String str3 = n10.mNameCN;
                if (str3 == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, str3);
                }
                String str4 = n10.mNameEN;
                if (str4 == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, str4);
                }
                String str5 = n10.mImgUrl;
                if (str5 == null) {
                    cVar.a(5);
                } else {
                    cVar.V(5, str5);
                }
                String str6 = n10.mAudioUrl;
                if (str6 == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, str6);
                }
                String str7 = n10.mAudioBinUrl;
                if (str7 == null) {
                    cVar.a(7);
                } else {
                    cVar.V(7, str7);
                }
                String str8 = n10.mMD5;
                if (str8 == null) {
                    cVar.a(8);
                } else {
                    cVar.V(8, str8);
                }
                String str9 = n10.mCreateTime;
                if (str9 == null) {
                    cVar.a(9);
                } else {
                    cVar.V(9, str9);
                }
                String str10 = n10.mUpdateTime;
                if (str10 == null) {
                    cVar.a(10);
                } else {
                    cVar.V(10, str10);
                }
                cVar.h(11, n10.mAudioExist);
                String str11 = n10.mProductId;
                if (str11 == null) {
                    cVar.a(12);
                } else {
                    cVar.V(12, str11);
                }
                String str12 = n10.mColor;
                if (str12 == null) {
                    cVar.a(13);
                } else {
                    cVar.V(13, str12);
                }
                String str13 = n10.mResId;
                if (str13 != null) {
                    cVar.V(14, str13);
                } else {
                    cVar.a(14);
                }
                break;
        }
    }

    @Override // G0.c
    public final String c() {
        switch (this.f19772j) {
            case 0:
                return "DELETE FROM `connected_device` WHERE `mac_address` = ?";
            case 1:
                return "DELETE FROM `melody_equipment` WHERE `macAddress` = ?";
            default:
                return "UPDATE OR REPLACE `zenmode_resource_info` SET `resid` = ?,`randomid` = ?,`name_cn` = ?,`name_en` = ?,`imgurl` = ?,`audiourl` = ?,`audiobinurl` = ?,`audiobinmd5` = ?,`createtime` = ?,`updatetime` = ?,`audioexist` = ?,`productId` = ?,`color` = ? WHERE `resid` = ?";
        }
    }
}
