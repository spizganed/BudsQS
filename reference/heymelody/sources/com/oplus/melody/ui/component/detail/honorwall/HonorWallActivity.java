package com.oplus.melody.ui.component.detail.honorwall;

import A6.b;
import F8.d;
import Wb.l;
import android.os.Bundle;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0914u;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HonorWallActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/honorwall/HonorWallViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRetryClick", "onLoadingStateChanged", "state", "", "shouldExcludeNavigation", "", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HonorWallActivity extends d {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f21097b0 = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public HonorWallViewModel f21098a0;

    /* JADX INFO: compiled from: HonorWallActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21099a;

        public a(l lVar) {
            this.f21099a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21099a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21099a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.honorwall.HonorWallActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: HonorWallActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            HonorWallActivity honorWallActivity = (HonorWallActivity) this.receiver;
            int i10 = HonorWallActivity.f21097b0;
            honorWallActivity.K(iIntValue);
            return Jb.l.f2618a;
        }
    }

    @Override // F8.a
    public final boolean F() {
        return true;
    }

    @Override // F8.d
    public final void J() {
        HonorWallViewModel honorWallViewModel = this.f21098a0;
        if (honorWallViewModel == null) {
            h.i("mViewModel");
            throw null;
        }
        honorWallViewModel.f21111b.m(2);
        honorWallViewModel.d(honorWallViewModel.f21113d);
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p pVarU = u();
        String str = this.f1646Q;
        Fragment fragmentD = pVarU.D(str);
        if (fragmentD == null) {
            j jVarI = u().I();
            getClassLoader();
            fragmentD = jVarI.a(HonorWallFragment.class.getName());
            h.d(fragmentD, "instantiate(...)");
        }
        p pVarU2 = u();
        pVarU2.getClass();
        C0585a c0585a = new C0585a(pVarU2);
        c0585a.d(R.id.melody_ui_fragment_container, fragmentD, str);
        c0585a.g();
        String strH = C0914u.h(getIntent(), "product_id");
        if (strH == null) {
            strH = "";
        }
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(HonorWallViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        HonorWallViewModel honorWallViewModel = (HonorWallViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21098a0 = honorWallViewModel;
        honorWallViewModel.d(strH);
        HonorWallViewModel honorWallViewModel2 = this.f21098a0;
        if (honorWallViewModel2 == null) {
            h.i("mViewModel");
            throw null;
        }
        honorWallViewModel2.f21111b.e(this, new a(new AnonymousClass2(1, this, HonorWallActivity.class, "onLoadingStateChanged", "onLoadingStateChanged(I)V", 0)));
    }
}
