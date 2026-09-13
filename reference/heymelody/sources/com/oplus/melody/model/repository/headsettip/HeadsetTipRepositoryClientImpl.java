package com.oplus.melody.model.repository.headsettip;

import D7.S;
import D7.U;
import android.os.Bundle;
import androidx.lifecycle.s;
import com.google.gson.reflect.TypeToken;
import f8.AbstractC1048a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeadsetTipRepositoryClientImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HeadsetTipRepositoryClientImpl extends AbstractC1048a {
    @Override // f8.AbstractC1048a
    public final void a(String address) {
        h.e(address, "address");
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", address);
        S.h(27002, bundle, String.class);
    }

    @Override // f8.AbstractC1048a
    public final s<ArrayList<HeadsetTipCleanDTO>> b() {
        Type type = new TypeToken<ArrayList<HeadsetTipCleanDTO>>() { // from class: com.oplus.melody.model.repository.headsettip.HeadsetTipRepositoryClientImpl$getTipCleanLiveData$1
        }.getType();
        h.d(type, "getType(...)");
        return new U(27001, null, type);
    }
}
