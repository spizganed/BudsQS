package com.oplus.melody.ui.component.detail.opsreduction.buttonseekbar;

import A9.o;
import D7.H;
import G9.a;
import G9.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.common.addon.MelodyLinearMotorVibrators;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.CurrentNoiseModeDTO;
import com.oplus.melody.model.repository.earphone.NoiseReductionInfoDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyCompatSectionSeekBar;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class NoiseReductionButtonSeekBarView extends ConstraintLayout implements DeviceControlWidget.a {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final /* synthetic */ int f21146D = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f21147A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f21148B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f21149C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f21150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DetailMainViewModel f21151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MelodyCompatSectionSeekBar f21152c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DeviceControlWidget f21153p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21154q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public NoiseReductionInfoBus f21155r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public NoiseReductionInfoDTO f21156s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CurrentNoiseModeDTO f21157t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Handler f21158u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f21159v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f21160w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21161x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f21162y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f21163z;

    public NoiseReductionButtonSeekBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21150a = new c();
        this.f21154q = null;
        this.f21162y = false;
        this.f21163z = false;
        this.f21147A = false;
        this.f21148B = true;
        this.f21149C = false;
    }

    public static ModeItem f(Context context, int i10, Drawable drawable, String str, boolean z2) {
        int iB = P1.a.b(context, R.attr.couiColorPrimary, 0);
        ModeItem modeItem = new ModeItem();
        modeItem.q(String.valueOf(i10));
        modeItem.p(drawable);
        modeItem.s(str);
        modeItem.u(z2);
        modeItem.w(true);
        modeItem.t(false);
        modeItem.n(Integer.valueOf(iB));
        return modeItem;
    }

    @Override // com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget.a
    public final void a(ModeItem modeItem, boolean z2) {
        if (this.f21148B && modeItem != null && z2) {
            int i10 = modeItem.getId() != null ? Integer.parseInt(modeItem.getId()) : -1;
            if (i10 == -1) {
                return;
            }
            this.f21160w = SystemClock.elapsedRealtime();
            if (i10 == 0) {
                if (this.f21149C) {
                    g(0);
                    e();
                    return;
                } else {
                    MelodyLinearMotorVibrators.INSTANCE.vibrate(getContext());
                    E8.a.S(getContext(), R.string.melody_ui_fit_detection_no_device);
                    i();
                    return;
                }
            }
            if (i10 == 1) {
                g(1);
                e();
            } else {
                if (i10 != 2) {
                    return;
                }
                g(2);
                e();
            }
        }
    }

    public final void d() {
        int i10 = 4;
        CurrentNoiseModeDTO currentNoiseModeDTO = new CurrentNoiseModeDTO();
        currentNoiseModeDTO.setType(1);
        int i11 = this.f21161x;
        currentNoiseModeDTO.setCurrentNoiseReductionModeValue(0, false);
        currentNoiseModeDTO.setCurrentNoiseReductionModeValue(1, false);
        currentNoiseModeDTO.setCurrentNoiseReductionModeValue(2, false);
        currentNoiseModeDTO.setCurrentNoiseReductionModeValue(3, false);
        currentNoiseModeDTO.setCurrentNoiseReductionModeValue(4, false);
        if (i11 == 1) {
            currentNoiseModeDTO.setCurrentNoiseReductionModeValue(0, true);
        } else if (i11 == 2) {
            currentNoiseModeDTO.setCurrentNoiseReductionModeValue(1, true);
        } else if (i11 == 4) {
            currentNoiseModeDTO.setCurrentNoiseReductionModeValue(2, true);
        } else if (i11 == 8) {
            currentNoiseModeDTO.setCurrentNoiseReductionModeValue(3, true);
        } else if (i11 == 16) {
            currentNoiseModeDTO.setCurrentNoiseReductionModeValue(4, true);
        }
        int i12 = this.f21161x;
        if (i12 == 4 || i12 == 8 || i12 == 16) {
            Type type = MelodyAlivePreferencesHelper.f19403a;
            MelodyAlivePreferencesHelper.d(getContext()).edit().putInt("key_last_noise_reduction_mode", this.f21161x).apply();
        }
        NoiseReductionInfoDTO noiseReductionInfoDTO = this.f21156s;
        String address = this.f21155r.getAddress();
        if ((currentNoiseModeDTO.isNoiseReductionModeOpened(2) || currentNoiseModeDTO.isNoiseReductionModeOpened(3) || currentNoiseModeDTO.isNoiseReductionModeOpened(4)) && noiseReductionInfoDTO != null) {
            if (noiseReductionInfoDTO.isSupportNoiseReductionModeValue(2) || noiseReductionInfoDTO.isSupportNoiseReductionModeValue(3) || noiseReductionInfoDTO.isSupportNoiseReductionModeValue(4)) {
                noiseReductionInfoDTO.setSupportNoiseReductionModeValue(2, false);
                noiseReductionInfoDTO.setSupportNoiseReductionModeValue(3, false);
                noiseReductionInfoDTO.setSupportNoiseReductionModeValue(4, false);
                if (currentNoiseModeDTO.isNoiseReductionModeOpened(2)) {
                    noiseReductionInfoDTO.setSupportNoiseReductionModeValue(2, true);
                }
                if (currentNoiseModeDTO.isNoiseReductionModeOpened(3)) {
                    noiseReductionInfoDTO.setSupportNoiseReductionModeValue(3, true);
                }
                if (currentNoiseModeDTO.isNoiseReductionModeOpened(4)) {
                    noiseReductionInfoDTO.setSupportNoiseReductionModeValue(4, true);
                }
            }
            AbstractC0939b.E().D0(C0906l.f19501a, address, noiseReductionInfoDTO);
        }
        CompletableFuture<SetCommandStateDTO> completableFuture = this.f21154q;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        AbstractC0939b abstractC0939bE = AbstractC0939b.E();
        String address2 = this.f21155r.getAddress();
        int i13 = this.f21161x;
        CompletableFuture<SetCommandStateDTO> completableFutureK0 = abstractC0939bE.k0(i13 != 2 ? i13 != 4 ? i13 != 8 ? i13 != 16 ? 0 : 4 : 3 : 2 : 1, address2);
        this.f21154q = completableFutureK0;
        if (completableFutureK0 != null) {
            completableFutureK0.thenAccept((Consumer<? super SetCommandStateDTO>) new H(this, 5)).exceptionally((Function<Throwable, ? extends Void>) new o(this, i10));
        }
    }

    public final void e() {
        if (this.f21163z) {
            this.f21162y = true;
            return;
        }
        this.f21163z = true;
        this.f21158u.postDelayed(this.f21159v, 1000L);
        d();
    }

    public final void g(int i10) {
        this.f21152c.setEnabled(i10 == 0);
        c cVar = this.f21150a;
        if (i10 == 1) {
            this.f21161x = 1;
            cVar.a(-1);
        } else if (i10 == 2) {
            this.f21161x = 2;
            cVar.a(-1);
        } else {
            int thumbIndex = this.f21152c.getThumbIndex();
            if (thumbIndex == 0) {
                this.f21161x = 4;
                cVar.a(0);
            } else if (thumbIndex == 1) {
                this.f21161x = 16;
                cVar.a(1);
            } else if (thumbIndex == 2) {
                this.f21161x = 8;
                cVar.a(2);
            }
        }
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.opsreduction.buttonseekbar.NoiseReductionButtonSeekBarView.h():void");
    }

    public final void i() {
        A.b("NoiseReductionButtonSeekBarView", "updateActionView...");
        ArrayList arrayList = new ArrayList();
        Context context = getContext();
        Drawable drawableM = d.m(getContext(), R.drawable.melody_ui_reduction_noise_strong);
        String string = getContext().getString(R.string.melody_ui_noise_reduction_open_choose);
        int i10 = this.f21161x;
        arrayList.add(f(context, 0, drawableM, string, i10 == 4 || i10 == 8 || i10 == 16));
        arrayList.add(f(getContext(), 1, d.m(getContext(), R.drawable.melody_ui_reduction_noise_close), getContext().getString(R.string.melody_ui_noise_reduction_action_close_reduction), this.f21161x == 1));
        arrayList.add(f(getContext(), 2, d.m(getContext(), R.drawable.melody_ui_reduction_noise_transparent), getContext().getString(R.string.melody_ui_noise_reduction_action_pass_through_reduction), this.f21161x == 2));
        this.f21153p.b(arrayList);
    }

    public void setDisabled(boolean z2) {
        if (this.f21147A) {
            this.f21148B = !z2;
            if (!z2) {
                this.f21153p.setEnabled(true);
                this.f21153p.setAlpha(1.0f);
                h();
            } else {
                this.f21150a.a(-1);
                this.f21153p.setEnabled(false);
                this.f21153p.setAlpha(0.3f);
                this.f21152c.setEnabled(false);
            }
        }
    }

    @Override // com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget.a
    public final void b(ModeItem modeItem) {
    }
}
