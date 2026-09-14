package com.oplus.melody.ui.widget;

import android.view.View;
import com.oplus.melody.ui.widget.MelodyRecommendedPreference;

/* JADX INFO: compiled from: MelodyRecommendedPreference.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MelodyRecommendedPreference.a f21985a;

    public a(MelodyRecommendedPreference.a aVar) {
        this.f21985a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MelodyRecommendedPreference.a aVar = this.f21985a;
        MelodyRecommendedPreference.b bVar = aVar.f21903b;
        if (bVar == null || !aVar.f21904c) {
            return;
        }
        bVar.c();
    }
}
