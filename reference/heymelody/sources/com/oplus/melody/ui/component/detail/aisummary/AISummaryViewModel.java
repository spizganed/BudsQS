package com.oplus.melody.ui.component.detail.aisummary;

import A9.r;
import A9.s;
import Ca.p;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: AISummaryViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ0\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/ui/component/detail/aisummary/AISummaryViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "getAISummaryState", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/ui/component/detail/aisummary/AISummaryVO;", "address", "", "getAISummaryType", "", "setAISummaryType", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", SpeechFindManager.TYPE, "", "callback", "Lkotlin/Function0;", "getWhitelistConfigLiveData", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "productId", "productName", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AISummaryViewModel extends BaseViewModel {
    public static void d(AISummaryViewModel aISummaryViewModel, String address, int i10) {
        p pVar = new p(5);
        aISummaryViewModel.getClass();
        h.e(address, "address");
        CompletableFuture completableFutureE0 = AbstractC0939b.E().e0(i10, address);
        if (completableFutureE0 != null) {
            completableFutureE0.whenComplete((BiConsumer) new s(new r(1, pVar), 17));
        }
    }
}
