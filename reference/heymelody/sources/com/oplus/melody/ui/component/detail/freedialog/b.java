package com.oplus.melody.ui.component.detail.freedialog;

import android.widget.CompoundButton;
import com.oplus.melody.ui.component.detail.freedialog.c;

/* JADX INFO: compiled from: FreeDialogAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f21013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f21014b;

    public b(c cVar, c.a aVar) {
        this.f21014b = cVar;
        this.f21013a = aVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        FreeDialogPanelFragment freeDialogPanelFragment = this.f21014b.f21015b;
        if (freeDialogPanelFragment != null) {
            freeDialogPanelFragment.s(this.f21013a);
        }
    }
}
