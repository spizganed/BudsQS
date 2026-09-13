package com.oplus.melody.ui.component.detail.personalnoise;

import androidx.fragment.app.FragmentManager;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PersonalNoiseItem f21170b;

    public /* synthetic */ b(PersonalNoiseItem personalNoiseItem, int i10) {
        this.f21169a = i10;
        this.f21170b = personalNoiseItem;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f21169a) {
            case 0:
                this.f21170b.lambda$showPersonalizedNoiseExistDialog$15((FragmentManager) obj);
                break;
            default:
                this.f21170b.lambda$showPersonalizedNoiseNotExistDialog$19((FragmentManager) obj);
                break;
        }
    }
}
