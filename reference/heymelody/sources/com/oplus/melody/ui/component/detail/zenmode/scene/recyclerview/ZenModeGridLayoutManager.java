package com.oplus.melody.ui.component.detail.zenmode.scene.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeGridLayoutManager extends GridLayoutManager {
    public ZenModeGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public final void v0(RecyclerView.w wVar, RecyclerView.A a3) {
        try {
            super.v0(wVar, a3);
        } catch (IndexOutOfBoundsException e10) {
            A.i("ZenModeGridLayoutManager", "onLayoutChildren", e10);
        }
    }
}
