package com.oplus.melody.ui.component.hearingenhance;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes3.dex */
public class HearingLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public final void v0(RecyclerView.w wVar, RecyclerView.A a3) {
        try {
            super.v0(wVar, a3);
        } catch (Exception e10) {
            A.i("HearingLinearLayoutManager", "onLayoutChildren throws Exception:", e10);
        }
    }
}
