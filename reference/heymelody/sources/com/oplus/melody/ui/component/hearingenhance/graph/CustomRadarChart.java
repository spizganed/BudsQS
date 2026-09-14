package com.oplus.melody.ui.component.hearingenhance.graph;

import C2.d;
import android.content.Context;
import android.util.AttributeSet;
import ma.C1333a;

/* JADX INFO: loaded from: classes3.dex */
public class CustomRadarChart extends d {
    public CustomRadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // C2.d, C2.c, C2.a
    public final void d() {
        super.d();
        this.f627B = new C1333a(this, this.f630E, this.f629D);
    }

    public void setCornerRadius(float f9) {
        C1333a c1333a = (C1333a) this.f627B;
        c1333a.getClass();
        c1333a.f26364j = K2.d.c(f9);
    }
}
