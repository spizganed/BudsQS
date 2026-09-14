package com.oplus.melody.ui.widget;

import D7.o0;
import Ea.C0416z;
import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyLottieAnimationView extends LottieAnimationView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f21875b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21876a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f21879c;

        public a(String str, String str2, String str3) {
            this.f21877a = str;
            this.f21878b = str2;
            this.f21879c = str3;
        }
    }

    public MelodyLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void d(a aVar, long j5) {
        if (aVar == null || j5 != this.f21876a) {
            return;
        }
        Object tag = getTag(R.id.melody_ui_image_path_tag);
        String str = aVar.f21877a;
        if (Objects.equals(str, tag)) {
            return;
        }
        setTag(R.id.melody_ui_image_path_tag, str);
        setAnimationFromJson(aVar.f21878b, aVar.f21879c);
        playAnimation();
    }

    public final void e(MelodyResourceDO melodyResourceDO, String str, boolean z2) {
        final long j5 = this.f21876a + 1;
        this.f21876a = j5;
        CompletableFuture.supplyAsync(new C0416z(0, getContext(), melodyResourceDO, str, z2)).thenAcceptAsync(new Consumer() { // from class: Ea.A
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i10 = MelodyLottieAnimationView.f21875b;
                this.f1433a.d((MelodyLottieAnimationView.a) obj, j5);
            }
        }, (Executor) o0.c.f1144b);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(LottieComposition lottieComposition) {
        try {
            super.setComposition(lottieComposition);
        } catch (Exception e10) {
            A.i("MelodyLottieAnimationView", "setComposition", e10);
        }
    }
}
