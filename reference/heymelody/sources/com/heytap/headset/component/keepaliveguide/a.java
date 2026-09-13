package com.heytap.headset.component.keepaliveguide;

import androidx.recyclerview.widget.p;
import g4.C1069a;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: KeepAliveGuideImagesViewPagerActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends p.e<C1069a.C0254a> {
    @Override // androidx.recyclerview.widget.p.e
    public final boolean a(C1069a.C0254a c0254a, C1069a.C0254a c0254a2) {
        return c0254a.equals(c0254a2);
    }

    @Override // androidx.recyclerview.widget.p.e
    public final boolean b(C1069a.C0254a c0254a, C1069a.C0254a c0254a2) {
        return h.a(c0254a.getImage(), c0254a2.getImage());
    }
}
