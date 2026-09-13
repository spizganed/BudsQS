package com.oplus.melody.ui.component.detail.zenmode.scene;

import F9.s;
import android.content.DialogInterface;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.ui.component.detail.zenmode.scene.g;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.b f21491b;

    public /* synthetic */ j(g.b bVar, int i10) {
        this.f21490a = i10;
        this.f21491b = bVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        switch (this.f21490a) {
            case 0:
                g.b bVar = this.f21491b;
                bVar.getClass();
                b.C0229b.f19632a.b(bVar.f21471a, bVar.f21472b.f21455F, LeFilterConstants.FunType.ZEN_MODE.getFunType(), new s(bVar, 27));
                break;
            default:
                this.f21491b.f21471a.finish();
                break;
        }
    }
}
