package com.oplus.melody.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.viewpager.COUIViewPager2;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyContentViewPager extends COUIViewPager2 {
    public MelodyContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coui.appcompat.viewpager.COUIViewPager2, android.view.View
    public final void onMeasure(int i10, int i11) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            super.onMeasure(i10, i11);
            return;
        }
        int itemCount = adapter.getItemCount();
        int iMax = 0;
        for (int i12 = 0; i12 < itemCount; i12++) {
            RecyclerView.E eOnCreateViewHolder = adapter.onCreateViewHolder(this, i12);
            adapter.onBindViewHolder(eOnCreateViewHolder, i12);
            eOnCreateViewHolder.itemView.measure(i10, 0);
            iMax = Math.max(iMax, eOnCreateViewHolder.itemView.getMeasuredHeight());
            if (A.l()) {
                StringBuilder sbN = androidx.appcompat.widget.a.n(i12, "onMeasure ", " measuredWidth ");
                sbN.append(eOnCreateViewHolder.itemView.getMeasuredWidth());
                sbN.append(" measuredHeight ");
                sbN.append(eOnCreateViewHolder.itemView.getMeasuredHeight());
                A.b("MelodyContentViewPager", sbN.toString());
            }
        }
        if (A.l()) {
            A.b("MelodyContentViewPager", "heightMax " + iMax);
        }
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(iMax, 1073741824));
    }
}
