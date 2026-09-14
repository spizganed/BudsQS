package com.oplus.melody.ui.component.detail.zenmode.scene;

import E9.r;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.db.s;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.zenmode.ZenModeViewModel;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: ZenModeScenePresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f21499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f21501g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SharedPreferences f21503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ZenModeViewModel f21504k;

    public static String a(ArrayList arrayList) {
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            da.d dVar = (da.d) obj;
            if (dVar.h) {
                ZenModeInfoDO zenModeInfoDO = dVar.f22301c;
                return zenModeInfoDO != null ? zenModeInfoDO.getResId() : VersionInfo.VENDOR_CODE_ERROR_VERSION;
            }
        }
        return null;
    }

    public static int b(String str, ArrayList arrayList) {
        int i10 = 0;
        if (TextUtils.equals(str, VersionInfo.VENDOR_CODE_ERROR_VERSION)) {
            return 0;
        }
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            da.d dVar = (da.d) obj;
            ZenModeInfoDO zenModeInfoDO = dVar.f22301c;
            if (zenModeInfoDO != null && TextUtils.equals(zenModeInfoDO.getResId(), str)) {
                return dVar.f22300b;
            }
        }
        return -1;
    }

    public final String c() {
        Bundle bundle = this.f21499e;
        if (!(bundle == null ? false : bundle.getBoolean("extra_is_created_by_failure", false))) {
            Bundle bundle2 = this.f21499e;
            if (!(bundle2 != null ? bundle2.getBoolean("extra_is_created_by_success", false) : false)) {
                com.oplus.melody.model.repository.zenmode.d dVar = b.C0235b.f21441a.f21434d;
                return dVar == null ? VersionInfo.VENDOR_CODE_ERROR_VERSION : String.valueOf(dVar.getFileId());
            }
        }
        return this.f21499e.getString("extra_zen_mode_notification_sending_music_id");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(java.util.ArrayList r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.zenmode.scene.o.d(java.util.ArrayList, boolean):void");
    }

    public final void e() {
        if (b.C0235b.f21441a.f21437g) {
            A.c("ZenModeScenePresenter", new s(this, 9));
            this.f21501g = Boolean.valueOf(this.f21500f);
        } else {
            A.c("ZenModeScenePresenter", new n(this, 0));
            if (this.f21500f) {
                AbstractC0939b.E().E0(4, true, this.f21495a);
            }
        }
    }

    public final void f() {
        if (b.C0235b.f21441a.f21437g) {
            A.b("ZenModeScenePresenter", "turnOffWearCheck, isSending, mPendingWearStatus: false");
            this.f21501g = Boolean.FALSE;
        } else if (this.f21495a != null) {
            boolean z2 = this.h == 1;
            A.c("ZenModeScenePresenter", new r(10, z2));
            if (z2) {
                AbstractC0939b.E().E0(4, false, this.f21495a);
            }
            this.f21500f = z2;
        }
    }
}
