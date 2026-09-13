package com.oplus.melody.ui.component.detail.sound.playing;

import A6.b;
import F8.g;
import M9.b;
import X.d;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import c.k;
import c.s;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import t8.q;

/* JADX INFO: compiled from: SoundPlayingActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/ui/component/detail/sound/playing/SoundPlayingActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/sound/playing/SoundPlayingViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getControlPlayer", "openFragment", "shouldSetSystemUI", "", "shouldSetViewMargin", "finish", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SoundPlayingActivity extends F8.a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final /* synthetic */ int f21241U = 0;

    /* JADX INFO: compiled from: SoundPlayingActivity.kt */
    public static final class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            A.b("SoundPlayingActivity", "handleOnBackPressed");
            SoundPlayingActivity.this.finish();
        }
    }

    @Override // F8.a
    public final boolean G() {
        return false;
    }

    @Override // F8.a
    public final boolean H() {
        return false;
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.melody_ui_slide_out_bottom);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        k.a(this);
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        } else {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setNavigationBarColor(0);
        }
        if (q.c("melody-model-settings").getBoolean("sound_settings_keep_screen_on", true)) {
            getWindow().addFlags(DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
        } else {
            getWindow().clearFlags(DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
        }
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        d dVarC = b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(SoundPlayingViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        getOnBackPressedDispatcher().a(this, new a());
        String strH = C0914u.h(getIntent(), "device_mac_info");
        String strH2 = C0914u.h(getIntent(), "product_id");
        Object obj = M9.b.h;
        M9.b bVarA2 = b.a.a();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            bVarA2.c(heyMelodyApplication, strH2, strH).whenComplete((BiConsumer) new A9.s(new g(this, 3), 13));
        } else {
            h.i("context");
            throw null;
        }
    }
}
