package com.oplus.melody.app.statement;

import Ca.r;
import D7.C0381o;
import D7.L;
import D7.Y;
import D7.o0;
import Ea.c0;
import L7.a;
import Q7.b;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.appcompat.app.f;
import androidx.lifecycle.s;
import com.heytap.headset.R;
import com.oplus.melody.app.discovery.N;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.Q;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.helper.WirelessSettingHelper;
import com.oplus.melody.model.repository.headsettip.HeadsetTipCleanDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import t8.q;
import w8.m;
import y6.C1708a;

/* JADX INFO: loaded from: classes.dex */
public class PermissionRqActivity extends F8.a {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static Boolean f19255c0;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public c0 f19258W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public f f19259X;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final ArrayList<String> f19256U = new ArrayList<>();

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f19257V = false;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public ArrayList<String> f19260Y = null;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public String f19261Z = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final a f19262a0 = new a();

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final b f19263b0 = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PermissionRqActivity permissionRqActivity = PermissionRqActivity.this;
            if (permissionRqActivity.isDestroyed() || permissionRqActivity.isFinishing()) {
                return;
            }
            f fVar = permissionRqActivity.f19259X;
            if (fVar != null && fVar.isShowing()) {
                permissionRqActivity.f19259X.dismiss();
            }
            PermissionRqActivity.I(permissionRqActivity, false);
            if (TextUtils.isEmpty(permissionRqActivity.f19261Z)) {
                permissionRqActivity.finish();
                A.h("PermissionRqActivity", "mShowPermissionAfterDialogRunnable mPermissionStatementStr is empty!");
                return;
            }
            G7.b bVar = new G7.b(permissionRqActivity);
            bVar.o(permissionRqActivity.getString(R.string.melody_common_permission_statement));
            bVar.g(permissionRqActivity.f19261Z);
            bVar.k(permissionRqActivity.getString(R.string.melody_common_grant_authorization), new H8.f(this, 1));
            f fVarCreate = bVar.setCancelable(false).create();
            permissionRqActivity.f19259X = fVarCreate;
            fVarCreate.show();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instruction units count: 531
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.app.statement.PermissionRqActivity.b.run():void");
        }
    }

    public static void I(PermissionRqActivity permissionRqActivity, boolean z2) {
        permissionRqActivity.f19261Z = null;
        ArrayList<String> arrayList = permissionRqActivity.f19256U;
        arrayList.clear();
        if (permissionRqActivity.f19260Y.size() == 1) {
            String str = permissionRqActivity.f19260Y.get(0);
            if ("type_location".equals(str)) {
                permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_location_permission, S.e(permissionRqActivity));
                if (z2) {
                    q.y();
                }
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                return;
            }
            if ("type_bluetooth".equals(str)) {
                permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_bt_permission, S.e(permissionRqActivity));
                arrayList.add("android.permission.BLUETOOTH_CONNECT");
                arrayList.add("android.permission.BLUETOOTH_SCAN");
                return;
            } else {
                if ("type_notifications".equals(str)) {
                    List<String> list = S.f19463a;
                    if ("com.heytap.headset".equals(permissionRqActivity.getPackageName())) {
                        permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_heymelody_request_notification_permission2);
                    } else {
                        permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_notification_permission, S.e(permissionRqActivity));
                    }
                    if (z2) {
                        q.v();
                    }
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                    return;
                }
                return;
            }
        }
        if (permissionRqActivity.f19260Y.size() != 2) {
            if (permissionRqActivity.f19260Y.size() == 3 && permissionRqActivity.f19260Y.contains("type_bluetooth") && permissionRqActivity.f19260Y.contains("type_notifications") && permissionRqActivity.f19260Y.contains("type_location")) {
                permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_notification_and_bt_and_location_permission, S.e(permissionRqActivity));
                if (z2) {
                    q.v();
                    q.y();
                }
                arrayList.add("android.permission.BLUETOOTH_CONNECT");
                arrayList.add("android.permission.BLUETOOTH_SCAN");
                arrayList.add("android.permission.POST_NOTIFICATIONS");
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                return;
            }
            return;
        }
        if (permissionRqActivity.f19260Y.contains("type_bluetooth") && permissionRqActivity.f19260Y.contains("type_notifications")) {
            permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_bt_and_notification_permission_v2, S.e(permissionRqActivity));
            if (z2) {
                q.v();
            }
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.POST_NOTIFICATIONS");
            return;
        }
        if (permissionRqActivity.f19260Y.contains("type_bluetooth") && permissionRqActivity.f19260Y.contains("type_location")) {
            permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_bt_and_location_permission, S.e(permissionRqActivity));
            if (z2) {
                q.y();
            }
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            return;
        }
        if (permissionRqActivity.f19260Y.contains("type_notifications") && permissionRqActivity.f19260Y.contains("type_location")) {
            permissionRqActivity.f19261Z = permissionRqActivity.getString(R.string.melody_common_request_notification_and_location_permission, S.e(permissionRqActivity));
            if (z2) {
                q.v();
                q.y();
            }
            arrayList.add("android.permission.POST_NOTIFICATIONS");
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.coui_center_dialog_enter, R.anim.coui_center_dialog_exit);
        setResult(0, null);
    }

    @Override // androidx.fragment.app.f, c.i, android.app.Activity
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        A.c("PermissionRqActivity", new Y(i11, 7));
        if (!C0901g.a(this.f19260Y) && this.f19260Y.contains("type_bluetooth")) {
            Object obj = L7.a.f3010c;
            a.C0032a.a().m(Q.a());
            if (Q.a()) {
                WirelessSettingHelper.sendWhiteListChangedBroadCast(this);
                int i12 = Q7.b.f4152c;
                Optional.ofNullable(b.a.a()).ifPresent(new N());
            }
        }
        finish();
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        A.c("PermissionRqActivity", new L6.b(0, bundle));
        Intent intent = getIntent();
        if (intent == null) {
            A.h("PermissionRqActivity", "onCreate getIntent() is null!");
            finish();
            return;
        }
        try {
            bundleExtra = intent.getBundleExtra("route_value");
        } catch (Exception e10) {
            A.o(5, "IntentUtils", "getBundleExtra", e10);
            bundleExtra = null;
        }
        if (bundleExtra == null) {
            A.h("PermissionRqActivity", "onCreate bundle is null!");
            finish();
            return;
        }
        ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("key_permissions");
        this.f19260Y = stringArrayList;
        if (C0901g.a(stringArrayList)) {
            A.h("PermissionRqActivity", "onCreate mPermissionTypeList is empty!");
            finish();
            return;
        }
        if (this.f19258W == null) {
            c0 c0Var = new c0(this);
            this.f19258W = c0Var;
            c0Var.f1513d = true;
        }
        o0.c.f1143a.postDelayed(this.f19263b0, 200L);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Handler handler = o0.c.f1143a;
        handler.removeCallbacks(this.f19263b0);
        handler.removeCallbacks(this.f19262a0);
        f fVar = this.f19259X;
        if (fVar != null && fVar.isShowing()) {
            this.f19259X.dismiss();
        }
        this.f19259X = null;
    }

    @Override // androidx.fragment.app.f, c.i, android.app.Activity
    public final void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        C0381o<ArrayList<HeadsetTipCleanDTO>> c0381o;
        Object next;
        super.onRequestPermissionsResult(i10, strArr, iArr);
        c0 c0Var = this.f19258W;
        if (c0Var != null) {
            c0Var.d();
        }
        A.c("PermissionRqActivity", new B9.f(3, strArr, iArr));
        if (C0901g.a(this.f19260Y)) {
            finish();
            return;
        }
        if (this.f19260Y.contains("type_location") && Q.c("android.permission.ACCESS_FINE_LOCATION")) {
            this.f19260Y.remove("type_location");
        }
        if (this.f19260Y.contains("type_notifications") && Q.b()) {
            this.f19260Y.remove("type_notifications");
            List<String> list = S.f19463a;
            if ("com.heytap.headset".equals(getPackageName()) && (c0381o = C1708a.a().f29198a) != null) {
                s<ArrayList<HeadsetTipCleanDTO>> sVar = c0381o.f1134a;
                ArrayList<HeadsetTipCleanDTO> arrayListD = sVar != null ? sVar.d() : null;
                if (arrayListD != null) {
                    ArrayList arrayList = new ArrayList();
                    int size = arrayListD.size();
                    int i11 = 0;
                    while (i11 < size) {
                        HeadsetTipCleanDTO headsetTipCleanDTO = arrayListD.get(i11);
                        i11++;
                        if (headsetTipCleanDTO.getMEnable()) {
                            arrayList.add(headsetTipCleanDTO);
                        }
                    }
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        if (it.hasNext()) {
                            long time = ((HeadsetTipCleanDTO) next).getTime();
                            do {
                                Object next2 = it.next();
                                long time2 = ((HeadsetTipCleanDTO) next2).getTime();
                                if (time > time2) {
                                    next = next2;
                                    time = time2;
                                }
                            } while (it.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    HeadsetTipCleanDTO headsetTipCleanDTO2 = (HeadsetTipCleanDTO) next;
                    A.c("HeadsetTipNotifyManager", new m(headsetTipCleanDTO2, 2));
                    if (headsetTipCleanDTO2 != null) {
                        C1708a.b(headsetTipCleanDTO2.getMAddress());
                    }
                }
            }
        }
        if (this.f19260Y.contains("type_bluetooth")) {
            if (Q.a()) {
                this.f19260Y.remove("type_bluetooth");
                Object obj = L7.a.f3010c;
                a.C0032a.a().m(true);
                WirelessSettingHelper.sendWhiteListChangedBroadCast(this);
                int i12 = Q7.b.f4152c;
                Optional.ofNullable(b.a.a()).ifPresent(new N());
            } else {
                f19255c0 = Boolean.valueOf(shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_SCAN"));
                A.c("PermissionRqActivity", new r(this, 20));
                if (f19255c0.booleanValue()) {
                    q.c("melody-model-settings").edit().putBoolean("reject_bluetooth_permission_once", true).apply();
                }
                if (!this.f19257V && !f19255c0.booleanValue()) {
                    if (this.f19260Y.size() <= 1) {
                        o0.c.f1143a.postDelayed(this.f19262a0, 200L);
                        return;
                    } else {
                        f19255c0 = null;
                        finish();
                        return;
                    }
                }
            }
        }
        finish();
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (!C0901g.a(this.f19260Y) && this.f19260Y.size() == 1 && this.f19260Y.contains("type_location")) {
            com.oplus.melody.model.scan.a aVarA = com.oplus.melody.model.scan.a.a();
            int iIncrementAndGet = aVarA.f20224c.incrementAndGet();
            aVarA.c(iIncrementAndGet);
            A.c("PermissionRqActivity", new Ba.b(iIncrementAndGet, 7));
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (!C0901g.a(this.f19260Y) && this.f19260Y.size() == 1 && this.f19260Y.contains("type_location")) {
            com.oplus.melody.model.scan.a aVarA = com.oplus.melody.model.scan.a.a();
            int iDecrementAndGet = aVarA.f20224c.decrementAndGet();
            aVarA.c(iDecrementAndGet);
            A.c("PermissionRqActivity", new L(iDecrementAndGet, 8));
        }
    }
}
