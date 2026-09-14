package com.oplus.melody.ui.component.detail.dress.custom;

import J8.f;
import O9.e;
import android.content.res.Resources;
import android.graphics.Bitmap;
import c9.m;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.component.detail.dress.custom.a;
import ec.l;
import java.io.File;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.h;
import u8.C1555c;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: TemplateCreateImage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends m {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20941t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public double f20942u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bitmap f20943v;

    @Override // c9.m
    public final boolean a() {
        C1558f mDiscoveryStates;
        C1557e connectedState;
        C1555c c1555c = this.f13523f;
        File file = this.h;
        MelodyResourceDO bgImageRes = (c1555c == null || (mDiscoveryStates = c1555c.getMDiscoveryStates()) == null || (connectedState = mDiscoveryStates.getConnectedState()) == null) ? null : connectedState.getBgImageRes();
        File file2 = this.f13524g;
        if (c1555c == null || file == null || bgImageRes == null || file2 == null) {
            A.h("TemplateCreateImage", "createBackground error config:" + (c1555c == null) + " dressDir:" + (file == null) + " bgImageRes:" + (bgImageRes == null) + " bgFile:" + (file2 == null));
            return false;
        }
        Object obj = a.f20940a;
        String strB = a.C0234a.b(this.f13520c);
        String path = bgImageRes.getPath();
        h.d(path, "getPath(...)");
        if (!l.C(path, strB)) {
            bgImageRes.setPath(bgImageRes.getPath() + strB);
        }
        bgImageRes.setLuminance(this.f20942u);
        c1555c.setBlurProgress(this.f20941t);
        String path2 = bgImageRes.getPath();
        h.d(path2, "getPath(...)");
        File file3 = new File(file, path2);
        Bitmap bitmap = this.f20943v;
        if (bitmap != null) {
            if (!C0911q.t(file3, bitmap)) {
                A.h("TemplateCreateImage", "write bitmap error return");
                return false;
            }
            String path3 = c1555c.getMSrcFile();
            h.e(path3, "path");
            File file4 = new File(file, path3);
            if (file4.getAbsolutePath().equals(file2.getAbsolutePath())) {
                A.c("TemplateCreateImage", new e(file4, 3));
            } else if (!C0911q.b(file2, file4)) {
                A.h("TemplateCreateImage", "write srcFile error return");
                return false;
            }
            LinkedHashSet linkedHashSet = this.f13535s;
            String absolutePath = file4.getAbsolutePath();
            h.d(absolutePath, "getAbsolutePath(...)");
            linkedHashSet.add(absolutePath);
        } else if (file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
            A.c("TemplateCreateImage", new f(file3, 2));
        } else if (!C0911q.b(file2, file3)) {
            A.h("TemplateCreateImage", "write imageFile error return");
            return false;
        }
        LinkedHashSet linkedHashSet2 = this.f13535s;
        String absolutePath2 = file3.getAbsolutePath();
        h.d(absolutePath2, "getAbsolutePath(...)");
        linkedHashSet2.add(absolutePath2);
        if (this.f13533q) {
            return true;
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        Resources resources = heyMelodyApplication.getResources();
        Bitmap bitmapA = Da.a.a(file3.getAbsolutePath(), (resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_res_height) / 2) * (resources.getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_res_width) / 2));
        String path4 = c1555c.getMIcon();
        h.e(path4, "path");
        File file5 = new File(file, path4);
        if (bitmapA == null || !C0911q.t(file5, bitmapA)) {
            A.h("TemplateCreateImage", "write icon fail iconData==null:" + (bitmapA == null));
        }
        LinkedHashSet linkedHashSet3 = this.f13535s;
        String absolutePath3 = file5.getAbsolutePath();
        h.d(absolutePath3, "getAbsolutePath(...)");
        linkedHashSet3.add(absolutePath3);
        return true;
    }

    @Override // c9.m
    public final void b(long j5, boolean z2) {
        C1558f mDiscoveryStates;
        C1557e connectedState;
        MelodyResourceDO bgImageRes;
        C1558f mDiscoveryStates2;
        C1557e connectedState2;
        MelodyResourceDO bgImageRes2;
        C1555c c1555c;
        C1558f mDiscoveryStates3;
        C1557e connectedState3;
        MelodyResourceDO bgImageRes3;
        super.b(j5, z2);
        Object obj = a.f20940a;
        String strB = a.C0234a.b(this.f13520c);
        if (z2) {
            C1555c c1555c2 = this.f13523f;
            if (c1555c2 != null && (mDiscoveryStates3 = c1555c2.getMDiscoveryStates()) != null && (connectedState3 = mDiscoveryStates3.getConnectedState()) != null && (bgImageRes3 = connectedState3.getBgImageRes()) != null) {
                bgImageRes3.setPath("res/image/connected_background_" + j5 + strB);
            }
            if (this.f20943v == null || (c1555c = this.f13523f) == null) {
                return;
            }
            c1555c.setSrcFile("src_" + j5 + strB);
            return;
        }
        if (this.f20943v != null) {
            double d10 = this.f20942u;
            C1555c c1555c3 = this.f13523f;
            Double dValueOf = (c1555c3 == null || (mDiscoveryStates2 = c1555c3.getMDiscoveryStates()) == null || (connectedState2 = mDiscoveryStates2.getConnectedState()) == null || (bgImageRes2 = connectedState2.getBgImageRes()) == null) ? null : Double.valueOf(bgImageRes2.getLuminance());
            if (dValueOf == null || d10 != dValueOf.doubleValue()) {
                C1555c c1555c4 = this.f13523f;
                if (c1555c4 != null && (mDiscoveryStates = c1555c4.getMDiscoveryStates()) != null && (connectedState = mDiscoveryStates.getConnectedState()) != null && (bgImageRes = connectedState.getBgImageRes()) != null) {
                    bgImageRes.setPath("res/image/connected_background_" + j5 + strB);
                }
                C1555c c1555c5 = this.f13523f;
                if (c1555c5 != null) {
                    c1555c5.setIcon("icon_" + j5 + ".png");
                }
            }
        }
    }
}
