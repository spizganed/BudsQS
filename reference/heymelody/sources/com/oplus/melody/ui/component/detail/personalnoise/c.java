package com.oplus.melody.ui.component.detail.personalnoise;

import com.oplus.melody.model.repository.earphone.PersonalNoiseDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PersonalNoiseItem f21172b;

    public /* synthetic */ c(PersonalNoiseItem personalNoiseItem, int i10) {
        this.f21171a = i10;
        this.f21172b = personalNoiseItem;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f21171a) {
            case 0:
                this.f21172b.lambda$useDirectly$17((SetCommandStateDTO) obj);
                break;
            default:
                this.f21172b.lambda$startPersonalizedNoise$11((PersonalNoiseDTO) obj);
                break;
        }
    }
}
