package com.oplus.melody.model.db;

import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.util.S;
import com.oplus.melody.track.constant.AppConstant$CustomThemeResType;
import com.oplus.melody.track.track.Track;
import q1.InterfaceC1431a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19659a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19661c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f19662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f19663q;

    public /* synthetic */ B(int i10, AppConstant$CustomThemeResType appConstant$CustomThemeResType, String str, String str2) {
        this.f19660b = i10;
        this.f19663q = appConstant$CustomThemeResType;
        this.f19661c = str;
        this.f19662p = str2;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws Exception {
        switch (this.f19659a) {
            case 0:
                int i10 = this.f19660b;
                InterfaceC1431a interfaceC1431a = (InterfaceC1431a) obj;
                q1.c cVarV0 = interfaceC1431a.v0("UPDATE melody_equipment SET name = ?, productId = ?, colorId = ? WHERE macAddress = ?");
                String str = this.f19661c;
                try {
                    if (str == null) {
                        cVarV0.a(1);
                    } else {
                        cVarV0.V(1, str);
                    }
                    String str2 = this.f19662p;
                    if (str2 == null) {
                        cVarV0.a(2);
                    } else {
                        cVarV0.V(2, str2);
                    }
                    cVarV0.h(3, i10);
                    String str3 = (String) this.f19663q;
                    if (str3 == null) {
                        cVarV0.a(4);
                    } else {
                        cVarV0.V(4, str3);
                    }
                    cVarV0.l0();
                    Integer numValueOf = Integer.valueOf(D1.f.z(interfaceC1431a));
                    cVarV0.close();
                    return numValueOf;
                } catch (Throwable th) {
                    cVarV0.close();
                    throw th;
                }
            case 1:
                Track it = (Track) obj;
                kotlin.jvm.internal.h.e(it, "it");
                it.a(Integer.valueOf(this.f19660b), "fun_type");
                it.a(this.f19661c, "earbuds_id");
                it.a(B8.a.c(this.f19662p), "earbuds_addr_id");
                it.a(g0.f.a(it, "earbuds_version", (String) this.f19663q, "device_id", "os_version"), "app_version");
                it.d();
                return Jb.l.f2618a;
            case 2:
                Track it2 = (Track) obj;
                kotlin.jvm.internal.h.e(it2, "it");
                it2.a(this.f19661c, "theme_id");
                it2.a(Integer.valueOf(this.f19660b), "click_type");
                it2.a(this.f19662p, "earbuds_id");
                it2.a(B8.a.c((String) this.f19663q), "earbuds_addr_id");
                it2.a(B8.a.a(), "device_id");
                it2.a(S.k(), "os_version");
                it2.a(B8.a.b(), "app_version");
                it2.d();
                return Jb.l.f2618a;
            default:
                Track it3 = (Track) obj;
                kotlin.jvm.internal.h.e(it3, "it");
                it3.a(VersionInfo.VENDOR_CODE_DEFAULT_VERSION, "theme_id");
                it3.a(Integer.valueOf(this.f19660b), "click_type");
                AppConstant$CustomThemeResType appConstant$CustomThemeResType = (AppConstant$CustomThemeResType) this.f19663q;
                if (appConstant$CustomThemeResType == null) {
                    appConstant$CustomThemeResType = AppConstant$CustomThemeResType.NONE;
                }
                it3.a(appConstant$CustomThemeResType, "custom_theme_type");
                it3.a(this.f19661c, "earbuds_id");
                it3.a(B8.a.c(this.f19662p), "earbuds_addr_id");
                it3.a(B8.a.a(), "device_id");
                it3.a(S.k(), "os_version");
                it3.a(B8.a.b(), "app_version");
                it3.d();
                return Jb.l.f2618a;
        }
    }

    public /* synthetic */ B(int i10, String str, String str2, String str3) {
        this.f19660b = i10;
        this.f19661c = str;
        this.f19662p = str2;
        this.f19663q = str3;
    }

    public /* synthetic */ B(String str, int i10, String str2, String str3) {
        this.f19661c = str;
        this.f19660b = i10;
        this.f19662p = str2;
        this.f19663q = str3;
    }

    public /* synthetic */ B(String str, String str2, int i10, String str3) {
        this.f19661c = str;
        this.f19662p = str2;
        this.f19660b = i10;
        this.f19663q = str3;
    }
}
