package com.oplus.melody.model.repository.interrupt;

import D7.S;
import D7.U;
import androidx.lifecycle.s;
import com.google.gson.reflect.TypeToken;
import h8.AbstractC1094a;
import java.lang.reflect.Type;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: InterruptRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InterruptRepositoryClientImpl extends AbstractC1094a {
    @Override // h8.AbstractC1094a
    public final void a() {
        S.h(33002, null, String.class);
    }

    @Override // h8.AbstractC1094a
    public final s<InterruptInfoDTO> b() {
        Type type = new TypeToken<InterruptInfoDTO>() { // from class: com.oplus.melody.model.repository.interrupt.InterruptRepositoryClientImpl$getInterruptLiveData$1
        }.getType();
        h.d(type, "getType(...)");
        return new U(33001, null, type);
    }
}
