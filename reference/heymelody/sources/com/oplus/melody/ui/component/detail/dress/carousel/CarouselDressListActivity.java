package com.oplus.melody.ui.component.detail.dress.carousel;

import Wb.l;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.InterfaceC0575p;
import androidx.lifecycle.v;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CarouselDressListActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressListActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "Landroidx/core/view/MenuProvider;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressListViewModel;", "mCreateBtn", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mBtnContainer", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViewModel", "initView", "onConnectionStateChange", "state", "", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "shouldExcludeNavigation", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressListActivity extends F8.a implements InterfaceC0575p {

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final /* synthetic */ int f20803W = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public CarouselDressListViewModel f20804U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public View f20805V;

    /* JADX INFO: compiled from: CarouselDressListActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20806a;

        public a(l lVar) {
            this.f20806a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20806a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20806a.d(obj);
        }
    }

    @Override // F8.a
    public final boolean F() {
        return true;
    }

    @Override // androidx.core.view.InterfaceC0575p
    public final boolean g(MenuItem menuItem) {
        h.e(menuItem, "menuItem");
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        getOnBackPressedDispatcher().c();
        return true;
    }

    @Override // androidx.core.view.InterfaceC0575p
    public final void j(Menu menu, MenuInflater menuInflater) {
        h.e(menu, "menu");
        h.e(menuInflater, "menuInflater");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressListActivity.onCreate(android.os.Bundle):void");
    }
}
