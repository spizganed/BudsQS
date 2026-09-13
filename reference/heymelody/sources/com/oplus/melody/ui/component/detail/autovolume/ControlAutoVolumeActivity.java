package com.oplus.melody.ui.component.detail.autovolume;

import A6.b;
import D7.C0371e;
import D7.C0379m;
import Wb.l;
import X.d;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodySwitchPreference;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: compiled from: ControlAutoVolumeActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/oplus/melody/ui/component/detail/autovolume/ControlAutoVolumeActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mDeviceName", "", "mAddress", "mColorId", "mProductId", "mFrom", "mAutoVolumeVM", "Lcom/oplus/melody/ui/component/detail/autovolume/AutoVolumeViewModel;", "mAutoVolumeSwitch", "Lcom/oplus/melody/ui/widget/MelodySwitchPreference;", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "initView", "setAutoVolumeEnable", "enable", "", "onAutoVolumeStatusChanged", "autoVolumeVO", "Lcom/oplus/melody/ui/component/detail/autovolume/AutoVolumeVO;", "setToolbar", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ControlAutoVolumeActivity extends F8.a {

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final /* synthetic */ int f20641Z = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f20642U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public String f20643V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public AutoVolumeViewModel f20644W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public MelodySwitchPreference f20645X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f20646Y;

    /* JADX INFO: compiled from: ControlAutoVolumeActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20647a;

        public a(l lVar) {
            this.f20647a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20647a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20647a.d(obj);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_auto_volume);
        D(R.id.auto_volume_root, true);
        String strH = C0914u.h(getIntent(), "device_mac_info");
        if (strH == null) {
            strH = "";
        }
        this.f20642U = strH;
        C0914u.h(getIntent(), "device_name");
        C0914u.h(getIntent(), "product_color");
        this.f20643V = C0914u.h(getIntent(), "product_id");
        C0914u.h(getIntent(), "route_from");
        String str = this.f20642U;
        if (str == null) {
            h.i("mAddress");
            throw null;
        }
        if (TextUtils.isEmpty(str)) {
            A.h("AutoVolumeActivity", "addr is null");
            finish();
        }
        A.c("AutoVolumeActivity", new C0371e(5));
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.n(true);
        }
        androidx.appcompat.app.a aVarX2 = x();
        if (aVarX2 != null) {
            aVarX2.r(true);
        }
        androidx.appcompat.app.a aVarX3 = x();
        if (aVarX3 != null) {
            aVarX3.t(R.string.melody_ui_control_auto_volume_title);
        }
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(AutoVolumeViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f20644W = (AutoVolumeViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        String str2 = this.f20642U;
        if (str2 == null) {
            h.i("mAddress");
            throw null;
        }
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str2), new A6.f(22))).e(this, new a(new ControlAutoVolumeActivity$initData$1(1, this, ControlAutoVolumeActivity.class, "onAutoVolumeStatusChanged", "onAutoVolumeStatusChanged(Lcom/oplus/melody/ui/component/detail/autovolume/AutoVolumeVO;)V", 0)));
        View viewFindViewById = findViewById(R.id.switch_auto_volume);
        h.d(viewFindViewById, "findViewById(...)");
        MelodySwitchPreference melodySwitchPreference = (MelodySwitchPreference) viewFindViewById;
        this.f20645X = melodySwitchPreference;
        melodySwitchPreference.setBackgroundType(0);
        MelodySwitchPreference melodySwitchPreference2 = this.f20645X;
        if (melodySwitchPreference2 != null) {
            melodySwitchPreference2.setOnSwitchChangeListener(new N1.b(this, 1));
        } else {
            h.i("mAutoVolumeSwitch");
            throw null;
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }
}
