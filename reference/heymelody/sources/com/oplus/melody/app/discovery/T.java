package com.oplus.melody.app.discovery;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import com.oplus.melody.app.discovery.DiscoveryDialogActivity;
import w1.AbstractC1591c;

/* JADX INFO: compiled from: DiscoveryDialogActivity.java */
/* JADX INFO: loaded from: classes.dex */
public final class T extends AbstractC1591c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity.a f18995b;

    public T(DiscoveryDialogActivity.a aVar) {
        this.f18995b = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w1.AbstractC1591c
    public final void a(Drawable drawable) {
        if (drawable instanceof Animatable2) {
            ((Animatable2) drawable).stop();
        }
        DiscoveryDialogActivity.a aVar = this.f18995b;
        aVar.f18882c.f18850W.post(new F9.i(this, aVar.f18881b, aVar.f18880a, 6));
    }
}
