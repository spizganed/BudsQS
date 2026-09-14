package com.oplus.melody.app.discovery;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewStub;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.widget.MelodyCompatImageView;
import java.io.File;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiscoveryBatteryDefaultViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0833a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewStub f19027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f19028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f19029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MelodyCompatImageView f19030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f19031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f19032g;
    public Integer h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f19033i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19035k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Fa.b> f19026a = new SparseArray<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19034j = true;

    public C0833a(int i10, View view) {
        this.f19027b = (ViewStub) view.findViewById(i10);
    }

    public final void a() {
        SparseArray<Fa.b> sparseArray = this.f19026a;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fa.b bVarValueAt = sparseArray.valueAt(i10);
            if (bVarValueAt != null && !bVarValueAt.f1770j) {
                J6.d.a(bVarValueAt.f1762a);
            }
        }
    }

    public final void b() {
        SparseArray<Fa.b> sparseArray = this.f19026a;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fa.b bVarValueAt = sparseArray.valueAt(i10);
            if (bVarValueAt != null && bVarValueAt.f1770j && bVarValueAt.f1762a.getVisibility() == 0) {
                bVarValueAt.h(4);
            }
        }
    }

    public final void c() {
        if (this.f19029d == null) {
            View viewInflate = this.f19027b.inflate();
            this.f19029d = viewInflate;
            this.f19030e = (MelodyCompatImageView) viewInflate.findViewById(R.id.melody_app_discovery_animation_iv);
        }
    }

    public final void d(MelodyResourceDO melodyResourceDO, C1 c12, int i10) {
        c();
        MelodyCompatImageView melodyCompatImageView = this.f19030e;
        boolean z2 = this.f19035k;
        melodyCompatImageView.getClass();
        melodyCompatImageView.d(melodyResourceDO, c12.getRootPath(), i10, z2);
    }

    public final void e(File file, int i10, D1 d12) {
        RequestBuilder<Bitmap> requestBuilderLoad;
        if (file == null && i10 == 0) {
            com.oplus.melody.common.util.A.f("DiscoveryBatteryDefaultViewHolder", "setImageRes not found");
            return;
        }
        c();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        String str = (String) this.f19030e.getTag(R.id.melody_ui_image_path_tag);
        String str2 = file + "&transformation=" + d12;
        if (TextUtils.equals(str, str2)) {
            com.oplus.melody.common.util.A.f("DiscoveryBatteryDefaultViewHolder", "setImageRes not modified, " + str2);
            return;
        }
        this.f19030e.setTag(R.id.melody_ui_image_path_tag, str2);
        if (str != null) {
            Glide.with(heyMelodyApplication).clear(this.f19030e);
        }
        RequestBuilder<Bitmap> requestBuilderAsBitmap = Glide.with(heyMelodyApplication).asBitmap();
        if (file == null) {
            requestBuilderLoad = requestBuilderAsBitmap.load(Integer.valueOf(i10));
        } else {
            requestBuilderLoad = requestBuilderAsBitmap.load(file);
            if (i10 != 0) {
                requestBuilderLoad = (RequestBuilder) requestBuilderLoad.error(i10);
            }
        }
        if (d12 != null) {
            requestBuilderLoad = (RequestBuilder) requestBuilderLoad.transform(d12);
        }
        requestBuilderLoad.into(this.f19030e);
    }

    public final void f(boolean z2) {
        View view;
        this.f19028c = z2;
        if (z2 && (view = this.f19029d) != null) {
            DiscoveryDialogActivity.Q(view);
        }
        SparseArray<Fa.b> sparseArray = this.f19026a;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fa.b bVarValueAt = sparseArray.valueAt(i10);
            if (bVarValueAt != null) {
                bVarValueAt.d(this.f19028c);
            }
        }
    }

    public final void g(int i10, boolean z2, int i11, boolean z4, int i12, boolean z10) {
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        int i15;
        boolean z13;
        boolean z14;
        C0833a c0833a;
        boolean z15 = i10 > 0 && i10 <= 100;
        boolean z16 = i11 > 0 && i11 <= 100;
        if (i12 <= 0 || i12 > 100) {
            z11 = false;
            i13 = i10;
            z12 = z2;
            i14 = i11;
            i15 = i12;
            z13 = z10;
            z14 = z15;
            c0833a = this;
        } else {
            z11 = true;
            c0833a = this;
            i13 = i10;
            i14 = i11;
            i15 = i12;
            z13 = z10;
            z14 = z15;
            z12 = z2;
        }
        c0833a.h(i13, z12, z14, i14, z4, z16, i15, z13, z11);
    }

    public final void h(int i10, boolean z2, boolean z4, int i11, boolean z10, boolean z11, int i12, boolean z12, boolean z13) {
        c();
        k(i10, R.id.melody_app_discovery_battery_left, z2, z4);
        k(i11, R.id.melody_app_discovery_battery_center, z10, z11);
        k(i12, R.id.melody_app_discovery_battery_right, z12, z13);
    }

    public final void i(boolean z2) {
        this.f19034j = z2;
        if (z2) {
            return;
        }
        SparseArray<Fa.b> sparseArray = this.f19026a;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fa.b bVarValueAt = sparseArray.valueAt(i10);
            if (bVarValueAt != null && bVarValueAt.f1770j && bVarValueAt.f1762a.getVisibility() == 0) {
                bVarValueAt.h(4);
            }
        }
    }

    public final void j() {
        SparseArray<Fa.b> sparseArray = this.f19026a;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            Fa.b bVarValueAt = sparseArray.valueAt(i10);
            if (bVarValueAt != null && bVarValueAt.f1770j && this.f19034j) {
                J6.d.c(bVarValueAt.f1762a, null);
            }
        }
    }

    public final void k(int i10, int i11, boolean z2, boolean z4) {
        SparseArray<Fa.b> sparseArray = this.f19026a;
        Fa.b bVar = sparseArray.get(i11);
        if (bVar == null && z4) {
            ViewStub viewStub = (ViewStub) this.f19029d.findViewById(i11);
            viewStub.setLayoutResource(R.layout.melody_ui_battery_style_default);
            Fa.b bVar2 = new Fa.b(viewStub.inflate());
            bVar2.d(this.f19028c);
            if (!this.f19034j) {
                bVar2.h(4);
            }
            sparseArray.put(i11, bVar2);
            bVar = bVar2;
        }
        if (bVar != null) {
            if (this.f19031f != null) {
                bVar.f1765d.setTextSize(0, r5.intValue());
            }
            Integer num = this.f19032g;
            if (num != null) {
                bVar.f1772l = num;
                bVar.i();
            }
            Integer num2 = this.h;
            if (num2 != null) {
                bVar.f1773m = num2;
                bVar.i();
            }
            Integer num3 = this.f19033i;
            if (num3 != null) {
                bVar.f1774n = num3;
                bVar.i();
            }
            bVar.f1770j = z4;
            if (z4) {
                bVar.g(i10, z2);
            }
            if (this.f19028c) {
                DiscoveryDialogActivity.Q(this.f19029d);
            }
        }
    }
}
