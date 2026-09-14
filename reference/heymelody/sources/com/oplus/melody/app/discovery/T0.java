package com.oplus.melody.app.discovery;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.headsettip.HeadsetTipCleanDTO;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import java.io.File;
import java.util.Locale;
import java.util.function.Consumer;
import u8.C1557e;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class T0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I0 f18997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18998c;

    public /* synthetic */ T0(I0 i02, Object obj, int i10) {
        this.f18996a = i10;
        this.f18997b = i02;
        this.f18998c = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        long j5;
        long resShowDelay;
        boolean z2;
        long j9;
        String str;
        G0.c cVar;
        Object obj2 = this.f18998c;
        I0 i02 = this.f18997b;
        switch (this.f18996a) {
            case 0:
                C1 c12 = (C1) obj;
                C0850f1 c0850f1 = (C0850f1) i02;
                E0 e02 = (E0) obj2;
                if (!e02.equals(c0850f1.d())) {
                    com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onBindEarphone IGNORE_BATTERY because earphone changed");
                } else if (e02.isBatteryEquals(c0850f1.f19067B)) {
                    com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onBindEarphone IGNORE_BATTERY because same");
                } else if (c0850f1.f19081Q != null) {
                    c0850f1.f19067B = e02;
                    C1557e c1557eB = c0850f1.b(c12);
                    int iX = c0850f1.f19081Q.x(c0850f1.f18929b, e02, c12, c1557eB, "onPreviewPopup".equals(c0850f1.f18930c.f18890j));
                    MelodyResourceDO videoRes = c12.getVideoRes();
                    MelodyResourceDO bgVideoRes = c1557eB != null ? c1557eB.getBgVideoRes() : null;
                    String rootPath = c12.getRootPath();
                    DiscoveryDialogActivity discoveryDialogActivity = c0850f1.f18929b;
                    com.oplus.drs.core.d.n(discoveryDialogActivity, videoRes, rootPath);
                    File fileN = com.oplus.drs.core.d.n(discoveryDialogActivity, bgVideoRes, c12.getRootPath());
                    boolean z4 = (videoRes == null || videoRes.getBackgroundColor() == null) ? false : true;
                    boolean z10 = e02.getLeftBattery() > 0 && e02.getRightBattery() > 0 && e02.getBoxBattery() > 0;
                    boolean z11 = (iX & 2) != 0;
                    boolean z12 = (iX & 4) != 0;
                    boolean z13 = ((iX & 8) == 0 || c1557eB == null || c1557eB.getFgAnimRes() == null) ? false : true;
                    if (z13) {
                        File fileN2 = com.oplus.drs.core.d.n(discoveryDialogActivity, c1557eB.getFgAnimRes(), c12.getRootPath());
                        ImageView imageView = discoveryDialogActivity.f18874u0;
                        c0850f1.r(imageView, fileN2, false);
                        MelodyResourceDO strangeRes = c12.getStrangeRes();
                        if (strangeRes != null && strangeRes.getFgOffsetMargin() > 0) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                            if (c0850f1.f19075K < 0) {
                                c0850f1.f19075K = marginLayoutParams.topMargin;
                            }
                            marginLayoutParams.topMargin = c0850f1.f19075K + ((int) ((strangeRes.getFgOffsetMargin() * discoveryDialogActivity.getResources().getDisplayMetrics().density) + 0.5f));
                            imageView.setLayoutParams(marginLayoutParams);
                        }
                    }
                    discoveryDialogActivity.f0(c12, c1557eB);
                    MelodyVideoAnimationView melodyVideoAnimationView = c0850f1.f19082m;
                    if (z4) {
                        if (z10) {
                            Object tag = melodyVideoAnimationView.getTag(R.id.melody_app_no_all_battery_hide_video);
                            if (melodyVideoAnimationView.getVisibility() != 0 && (tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                                J6.d.c(melodyVideoAnimationView, null);
                            }
                            melodyVideoAnimationView.setTag(R.id.melody_app_no_all_battery_hide_video, Boolean.FALSE);
                        } else {
                            melodyVideoAnimationView.setHoldMode(true);
                            J6.d.a(melodyVideoAnimationView);
                            melodyVideoAnimationView.setTag(R.id.melody_app_no_all_battery_hide_video, Boolean.TRUE);
                        }
                    }
                    if (discoveryDialogActivity.f18845I0 && c12.getStrangeRes() != null) {
                        J6.d.a(melodyVideoAnimationView);
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - c0850f1.f19069D;
                    long infoFadeInDelay = (c1557eB == null || c1557eB.getInfoFadeInDelay() <= 0) ? 0L : c1557eB.getInfoFadeInDelay() - jElapsedRealtime;
                    long titleFadeInDelay = infoFadeInDelay;
                    long batteryFadeInDelay = titleFadeInDelay;
                    if (c1557eB != null && c1557eB.getBtnFadeInDelay() > 0) {
                        infoFadeInDelay = c1557eB.getBtnFadeInDelay() - jElapsedRealtime;
                    }
                    long j10 = infoFadeInDelay;
                    if (c1557eB != null && c1557eB.getTitleFadeInDelay() > 0) {
                        titleFadeInDelay = c1557eB.getTitleFadeInDelay() - jElapsedRealtime;
                    }
                    long j11 = titleFadeInDelay;
                    if (c1557eB != null && c1557eB.getBatteryFadeInDelay() > 0) {
                        batteryFadeInDelay = c1557eB.getBatteryFadeInDelay() - jElapsedRealtime;
                    }
                    boolean z14 = z4;
                    long j12 = batteryFadeInDelay;
                    if (c1557eB == null || c1557eB.getResShowDelay() <= 0) {
                        j5 = jElapsedRealtime;
                        resShowDelay = 0;
                    } else {
                        j5 = jElapsedRealtime;
                        resShowDelay = c1557eB.getResShowDelay() - jElapsedRealtime;
                    }
                    U0 u02 = c0850f1.f19095z;
                    boolean z15 = z11;
                    Handler handler = discoveryDialogActivity.f18850W;
                    if (u02 != null) {
                        handler.removeCallbacks(u02);
                    }
                    long j13 = resShowDelay;
                    U0 u03 = new U0(c0850f1, 0);
                    c0850f1.f19095z = u03;
                    if (j10 > 0) {
                        J6.d.f(0, 4, c0850f1.f19087r, c0850f1.f19085p, c0850f1.f19086q);
                        handler.postDelayed(c0850f1.f19095z, j10);
                    } else {
                        u03.run();
                    }
                    RunnableC0878r0 runnableC0878r0 = c0850f1.f19094y;
                    if (runnableC0878r0 != null) {
                        handler.removeCallbacks(runnableC0878r0);
                    }
                    RunnableC0878r0 runnableC0878r02 = new RunnableC0878r0(1, c0850f1, e02);
                    c0850f1.f19094y = runnableC0878r02;
                    if (j11 > 0) {
                        J6.d.f(0, 4, c0850f1.f18931d);
                        handler.postDelayed(c0850f1.f19094y, j11);
                    } else {
                        runnableC0878r02.run();
                    }
                    V0 v02 = c0850f1.f19093x;
                    if (v02 != null) {
                        handler.removeCallbacks(v02);
                    }
                    V0 v03 = new V0(0, c12, c0850f1);
                    c0850f1.f19093x = v03;
                    if (j12 > 0) {
                        G0.c cVar2 = c0850f1.f19081Q;
                        if (cVar2 != null) {
                            cVar2.l();
                        } else {
                            com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "hideValidBattery mBatteryGroup is null");
                        }
                        ImageView imageView2 = c0850f1.f19078N;
                        if (imageView2 != null) {
                            imageView2.setVisibility(8);
                        }
                        handler.postDelayed(c0850f1.f19093x, j12);
                    } else {
                        v03.run();
                    }
                    b0.J j14 = c0850f1.f19066A;
                    if (j14 != null) {
                        handler.removeCallbacks(j14);
                    }
                    if (j13 > 0) {
                        z2 = z12;
                        if (!z2 || (cVar = c0850f1.f19081Q) == null) {
                            com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "hideImageView mBatteryGroup is null");
                        } else {
                            cVar.k();
                        }
                        if (z13) {
                            discoveryDialogActivity.f18874u0.setVisibility(8);
                        }
                        b0.J j15 = new b0.J(c0850f1, z2, c1557eB.getResInAnim(), z13);
                        c0850f1.f19066A = j15;
                        j9 = j13;
                        handler.postDelayed(j15, j9);
                    } else {
                        z2 = z12;
                        j9 = j13;
                        G0.c cVar3 = c0850f1.f19081Q;
                        if (cVar3 == null) {
                            str = null;
                            com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "showImageView mBatteryGroup is null");
                        } else if (z2) {
                            str = null;
                            cVar3.y(null);
                        } else {
                            str = null;
                            cVar3.k();
                        }
                        if (z13) {
                            J6.d.c(discoveryDialogActivity.f18874u0, str);
                        } else {
                            discoveryDialogActivity.f18874u0.setVisibility(8);
                        }
                    }
                    if (com.oplus.melody.common.util.A.l()) {
                        StringBuilder sb2 = new StringBuilder("showBatteryViews useCenterHolder:");
                        sb2.append(z15);
                        sb2.append(" passedTimeMillis:");
                        sb2.append(j5);
                        sb2.append(" resDelayMillis:");
                        sb2.append(j9);
                        sb2.append(" btnDelayMillis:");
                        sb2.append(j10);
                        sb2.append(" titleDelayMillis:");
                        sb2.append(j11);
                        sb2.append(" batteryDelayMillis:");
                        sb2.append(j12);
                        sb2.append(" showHolderImage:");
                        sb2.append(z2);
                        sb2.append(" showForegroundAnim:");
                        sb2.append(z13);
                        sb2.append(" bgVideoResFile:");
                        sb2.append(fileN != null);
                        sb2.append(" canHideVideo:");
                        sb2.append(z14);
                        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", sb2.toString());
                    }
                } else {
                    com.oplus.melody.common.util.A.x("DiscoveryViewStateConnectedImpl", "m_bt_bat.showBatteryViews mBatteryGroup is null");
                }
                break;
            case 1:
                HeadsetTipCleanDTO headsetTipCleanDTO = (HeadsetTipCleanDTO) obj;
                C0850f1 c0850f12 = (C0850f1) i02;
                c0850f12.getClass();
                E0 e03 = (E0) obj2;
                if (headsetTipCleanDTO.getMAddress().equals(e03.getId()) && headsetTipCleanDTO.getMEnable()) {
                    com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new C0880s0(e03, 1));
                    c0850f12.f19070E = c0850f12.f18929b.getString(R.string.melody_common_tip_clean_headset);
                    c0850f12.u();
                    break;
                }
                break;
            default:
                MelodyResourceDO melodyResourceDO = (MelodyResourceDO) obj;
                m1 m1Var = (m1) i02;
                String str2 = (String) obj2;
                if (melodyResourceDO != null) {
                    m1Var.getClass();
                    if (!TextUtils.isEmpty(melodyResourceDO.getText())) {
                        str2 = String.format(Locale.getDefault(), melodyResourceDO.getText(), str2);
                    }
                }
                m1Var.f18931d.setText(str2);
                break;
        }
    }
}
