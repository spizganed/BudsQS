package com.oplus.melody.ui.component.detail.dress.carousel;

import Wb.l;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.InterfaceC0575p;
import androidx.lifecycle.v;
import com.oplus.melody.ui.widget.MelodyErrorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CarouselDressEditActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "Landroidx/core/view/MenuProvider;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditViewModel;", "mSaveBtn", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mErrorLayout", "Lcom/oplus/melody/ui/widget/MelodyErrorLayout;", "mFragmentContainer", "Landroid/view/View;", "mBottomBar", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViewModel", "initView", "saveCarouselDress", "onConnectionStateChange", "state", "", "dealErrorState", "showContentView", "success", "", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "shouldExcludeNavigation", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressEditActivity extends F8.a implements InterfaceC0575p {

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public static final /* synthetic */ int f20767Y = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public CarouselDressEditViewModel f20768U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public MelodyErrorLayout f20769V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public View f20770W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public View f20771X;

    /* JADX INFO: compiled from: CarouselDressEditActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f20772a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f20772a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20772a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20772a.d(obj);
        }
    }

    @Override // F8.a
    public final boolean F() {
        return true;
    }

    public final void I(boolean z2) {
        if (z2) {
            MelodyErrorLayout melodyErrorLayout = this.f20769V;
            if (melodyErrorLayout != null) {
                melodyErrorLayout.setVisibility(8);
            }
            View view = this.f20770W;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f20771X;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        MelodyErrorLayout melodyErrorLayout2 = this.f20769V;
        if (melodyErrorLayout2 != null) {
            melodyErrorLayout2.setVisibility(0);
        }
        View view3 = this.f20770W;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f20771X;
        if (view4 != null) {
            view4.setVisibility(8);
        }
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

    /* JADX WARN: Removed duplicated region for block: B:58:0x0155  */
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressEditActivity.onCreate(android.os.Bundle):void");
    }
}
