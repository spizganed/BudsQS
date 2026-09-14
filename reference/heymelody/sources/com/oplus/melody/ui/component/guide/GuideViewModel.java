package com.oplus.melody.ui.component.guide;

import E9.q;
import O7.l;
import Z7.a;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import ka.C1241a;
import ka.C1242b;

/* JADX INFO: loaded from: classes3.dex */
public final class GuideViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Integer> f21542b = new l<>(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l<C1241a> f21543c = new l<>();

    public final void d(C1242b c1242b) {
        a aVarG = a.g();
        String productId = c1242b.getProductId();
        int productColor = c1242b.getProductColor();
        aVarG.getClass();
        int iW = N.w(productColor, productId);
        Locale locale = Locale.ENGLISH;
        aVarG.j(iW, "function_" + productId + "_" + iW, productId, "function", true).thenAcceptAsync((Consumer) new q(this, 11)).whenComplete((BiConsumer<? super Void, ? super Throwable>) new A9.q(this, 18));
    }
}
