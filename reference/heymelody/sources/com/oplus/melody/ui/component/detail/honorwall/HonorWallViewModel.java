package com.oplus.melody.ui.component.detail.honorwall;

import O7.l;
import Z7.a;
import androidx.lifecycle.L;
import c9.g;
import com.oplus.melody.common.util.A;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import w9.C1606b;
import w9.C1607c;

/* JADX INFO: compiled from: HonorWallViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mLoadingState", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "mHonorWallData", "Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallDataVO;", "mProductId", "", "loadHonorResource", "", "productId", "reLoadHonorResource", "getLoadingState", "Landroidx/lifecycle/LiveData;", "getHonorWallData", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HonorWallViewModel extends L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Integer> f21111b = new l<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l<C1606b> f21112c = new l<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21113d = "";

    public final void d(String productId) {
        h.e(productId, "productId");
        A.c("HonorWallViewModel", new C1607c(productId, 0));
        this.f21113d = productId;
        a.g().d(0, 9, productId).whenComplete((BiConsumer) new g(new F8.g(this, 19), 15));
    }
}
