package com.oplus.melody.spy;

import Wb.l;
import c9.g;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpyTapViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ:\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0016¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/spy/SpyTapViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "getConnectionState", "Landroidx/lifecycle/LiveData;", "", "macAddress", "", "getEarphoneDirect", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "getKeyFunctionInfo", "", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "getKeyFunctions", "", "context", "Landroid/content/Context;", "address", "setKeyFunction", "keyFunctions", "callback", "Lkotlin/Function1;", "", "Companion", "spy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpyTapViewModel extends BaseViewModel {
    public static void d(HeyMelodyApplication context, String str, List keyFunctions, l lVar) {
        h.e(context, "context");
        h.e(keyFunctions, "keyFunctions");
        CompletableFuture completableFutureU0 = AbstractC0939b.E().u0(str, context, keyFunctions, 1025);
        if (completableFutureU0 != null) {
            completableFutureU0.whenComplete((BiConsumer) new g(new F8.g(lVar, 18), 14));
        }
    }
}
