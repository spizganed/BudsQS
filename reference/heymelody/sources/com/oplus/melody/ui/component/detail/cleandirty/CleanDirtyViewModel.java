package com.oplus.melody.ui.component.detail.cleandirty;

import Aa.c;
import D7.C0389x;
import Ea.C0406o;
import O7.l;
import V8.b;
import V8.d;
import Z7.a;
import androidx.lifecycle.L;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CleanDirtyViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0012R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mGuidePagesLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "Lcom/oplus/melody/ui/component/detail/cleandirty/CleanDirtyGuidePageVO;", "mLoadingStateLiveData", "", "loadGuideResource", "", "productId", "", "colorId", "setLoadingState", "state", "getGuidePagesLiveData", "Landroidx/lifecycle/LiveData;", "getLoadingStateLiveData", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CleanDirtyViewModel extends L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<List<b>> f20658b = new l<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l<Integer> f20659c = new l<>();

    public final void d(int i10, String productId) {
        h.e(productId, "productId");
        a.g().e(i10, productId).handle((BiFunction) new C0389x(new H6.b(6), 1)).thenCompose((Function) new c(new d(productId, i10, 0), 6)).whenComplete((BiConsumer) new A9.c(new C0406o(this, 4), 7));
    }
}
