package com.oplus.melody.ui.component.detail.freedialog;

import android.view.View;
import com.oplus.melody.ui.component.detail.freedialog.c;

/* JADX INFO: compiled from: FreeDialogAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f21011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f21012b;

    public a(c cVar, c.a aVar) {
        this.f21012b = cVar;
        this.f21011a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FreeDialogPanelFragment freeDialogPanelFragment = this.f21012b.f21015b;
        if (freeDialogPanelFragment != null) {
            freeDialogPanelFragment.s(this.f21011a);
        }
    }
}
