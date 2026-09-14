package com.oplus.melody.alive.provider;

import D6.f;
import F6.a;
import F6.b;
import X3.l;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.drs.core.d;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.db.C;
import com.oplus.melody.model.db.E;
import com.oplus.melody.model.db.MelodyDatabase;
import com.oplus.melody.model.db.MelodyEquipmentDao;
import com.oplus.melody.model.db.r;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.h;
import t8.C1532B;
import t8.j;
import u8.C1554b;

/* JADX INFO: loaded from: classes.dex */
public final class MelodyAliveProvider extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f18804b = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UriMatcher f18805a;

    public static boolean a(String str) {
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str);
        if (earphoneDTOW == null) {
            A.c("MelodyAliveProvider", new f(str, 3));
            return false;
        }
        EarStatusDTO earStatus = earphoneDTOW.getEarStatus();
        if (earStatus != null) {
            boolean zBothInEar = earStatus.bothInEar();
            A.c("MelodyAliveProvider", new b(0, earStatus, str, zBothInEar));
            return zBothInEar;
        }
        A.h("MelodyAliveProvider", "isEarphoneBothInEar earStatus is null! adr = " + A.r(str));
        return false;
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String method, String str, Bundle bundle) {
        MelodyEquipmentDao melodyEquipmentDaoS;
        String callPkg = getCallingPackage();
        h.e(callPkg, "callPkg");
        h.e(method, "method");
        A.c("MelodyEquipmentProviderInner", new C(callPkg, method, 1));
        Bundle bundle2 = null;
        if (callPkg.equals("com.android.systemui") && "pick_equipment_image".equals(method)) {
            String string = bundle != null ? bundle.getString("address") : null;
            if (string == null) {
                A.h("MelodyEquipmentProviderInner", "pick_equipment_image address null");
            } else {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    h.i("context");
                    throw null;
                }
                String strB = r.b(string);
                MelodyDatabase melodyDatabaseT = MelodyDatabase.t(heyMelodyApplication);
                E eF = (melodyDatabaseT == null || (melodyEquipmentDaoS = melodyDatabaseT.s()) == null) ? null : melodyEquipmentDaoS.f(strB);
                if (eF == null) {
                    A.h("MelodyEquipmentProviderInner", "pick_equipment_image equipment null address:" + A.r(string));
                } else {
                    A.c("MelodyEquipmentProviderInner", new l(eF, 13));
                    String productId = eF.getProductId();
                    int iW = N.w(eF.getColorId(), productId);
                    Locale locale = Locale.ENGLISH;
                    File fileK = Z7.a.k("control_" + productId + "_" + iW);
                    if (fileK.exists()) {
                        C1554b c1554b = (C1554b) C1532B.d(fileK, C1554b.class);
                        File fileN = d.n(heyMelodyApplication, c1554b.getBoxImageRes(), c1554b.getRootPath());
                        if (fileN == null || true != fileN.exists()) {
                            A.h("MelodyEquipmentProviderInner", "pick_equipment_image boxImageFile not exist");
                        } else {
                            Uri uriB = FileProvider.c(heyMelodyApplication, j.b(heyMelodyApplication)).b(fileN);
                            heyMelodyApplication.grantUriPermission(callPkg, uriB, 1);
                            bundle2 = new Bundle();
                            bundle2.putString("uri", uriB.toString());
                        }
                    } else {
                        A.h("MelodyEquipmentProviderInner", "pick_equipment_image controlResource not exist");
                    }
                }
            }
        }
        return bundle2 != null ? bundle2 : super.call(method, str, bundle);
    }

    @Override // F6.a, android.content.ContentProvider
    public final boolean onCreate() {
        super.onCreate();
        Context context = getContext();
        UriMatcher uriMatcher = new UriMatcher(-1);
        String strD = Y.d(context);
        uriMatcher.addURI(strD, "all_whitelist", 1);
        uriMatcher.addURI(strD, "ears_whitelist", 2);
        uriMatcher.addURI(strD, "earphone_immersive_record_available", 3);
        uriMatcher.addURI(strD, "earphone_both_in_ear", 4);
        uriMatcher.addURI(strD, "active_earphone_immersive_record_available", 5);
        uriMatcher.addURI(strD, "active_earphone_both_in_ear", 6);
        uriMatcher.addURI(strD, "diagnosis_list", 7);
        uriMatcher.addURI(strD, "find_whitelist", 8);
        uriMatcher.addURI(strD, "whitelist_content", 9);
        this.f18805a = uriMatcher;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x02f7  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.database.Cursor query(android.net.Uri r18, java.lang.String[] r19, java.lang.String r20, java.lang.String[] r21, java.lang.String r22) {
        /*
            Method dump skipped, instruction units count: 806
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.alive.provider.MelodyAliveProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }
}
