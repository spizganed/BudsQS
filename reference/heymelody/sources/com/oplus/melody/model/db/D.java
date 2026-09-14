package com.oplus.melody.model.db;

import android.os.SystemClock;
import com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import java.util.function.Supplier;
import la.C1306t;
import n7.AbstractC1352b;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class D implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f19681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19682c;

    public /* synthetic */ D(int i10, long j5, Object obj) {
        this.f19680a = i10;
        this.f19682c = obj;
        this.f19681b = j5;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19680a) {
            case 0:
                return "queryByAddress " + com.oplus.melody.common.util.A.r((String) this.f19682c) + " timeMillis=" + (SystemClock.elapsedRealtime() - this.f19681b);
            case 1:
                return "isVoiceAssistOpen, isAssistInit: " + ((VoiceAssistFragmentV3) this.f19682c).f21336z + ", cost: " + (System.currentTimeMillis() - this.f19681b);
            case 2:
                C1306t c1306t = (C1306t) this.f19682c;
                MelodyVideoAnimationView melodyVideoAnimationView = c1306t.f25942r;
                if (melodyVideoAnimationView == null) {
                    kotlin.jvm.internal.h.i("mAnimView");
                    throw null;
                }
                return "onVideoEndDelayed postDelayed, = " + (this.f19681b - ((long) melodyVideoAnimationView.getCurrentPosition())) + ", isStopped: " + c1306t.f25948x;
            default:
                return "handleJudgeRetry mRetryCount " + ((AbstractC1352b) this.f19682c).f26456r + "  delayTime " + this.f19681b;
        }
    }

    public /* synthetic */ D(long j5, C1306t c1306t) {
        this.f19680a = 2;
        this.f19681b = j5;
        this.f19682c = c1306t;
    }
}
