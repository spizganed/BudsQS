package com.oplus.melody.ui.component.detail.zenmode.main;

import A9.s;
import D7.C0386u;
import D7.o0;
import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.m;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyAnimationLayout;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeVideoTextPreference extends Preference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MelodyAnimationLayout f21417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SpannableStringBuilder f21418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f21419c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public File f21420p;

    public ZenModeVideoTextPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public final void e(File file) {
        MelodyAnimationLayout melodyAnimationLayout;
        this.f21419c = file;
        if (file == null || (melodyAnimationLayout = this.f21417a) == null) {
            return;
        }
        if (!file.exists()) {
            MelodyVideoAnimationView melodyVideoAnimationView = melodyAnimationLayout.f21742b;
            if (melodyVideoAnimationView != null) {
                melodyVideoAnimationView.setVisibility(8);
                return;
            }
            return;
        }
        final MelodyLottieAnimationView lottieView = melodyAnimationLayout.getLottieView();
        lottieView.getClass();
        if (!Objects.equals(file.getAbsolutePath(), lottieView.getTag(R.id.melody_ui_image_path_tag))) {
            final long j5 = lottieView.f21876a + 1;
            lottieView.f21876a = j5;
            CompletableFuture.supplyAsync(new C0386u(5, file, file.getAbsolutePath())).thenAcceptAsync(new Consumer() { // from class: Ea.y
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    int i10 = MelodyLottieAnimationView.f21875b;
                    lottieView.d((MelodyLottieAnimationView.a) obj, j5);
                }
            }, (Executor) o0.c.f1144b);
        }
        lottieView.setVisibility(0);
    }

    public final void f(File file) {
        MelodyAnimationLayout melodyAnimationLayout;
        this.f21420p = file;
        if (file == null || (melodyAnimationLayout = this.f21417a) == null) {
            return;
        }
        if (file.exists()) {
            MelodyVideoAnimationView videoView = melodyAnimationLayout.getVideoView();
            videoView.setVisibility(0);
            melodyAnimationLayout.f21746r = videoView.e(file).whenCompleteAsync((BiConsumer<? super Uri, ? super Throwable>) new s(videoView, 5), (Executor) o0.c.f1144b);
        } else {
            MelodyVideoAnimationView melodyVideoAnimationView = melodyAnimationLayout.f21742b;
            if (melodyVideoAnimationView != null) {
                melodyVideoAnimationView.setVisibility(8);
            }
        }
        this.f21417a.getVideoView().setHoldMode(true);
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        mVar.itemView.setClickable(false);
        mVar.itemView.setFocusable(false);
        this.f21417a = (MelodyAnimationLayout) mVar.a(R.id.zen_mode_function_description_preference_video);
        if (!TextUtils.isEmpty(this.f21418b)) {
            TextView textView = (TextView) mVar.a(R.id.zen_mode_function_description_preference_text);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(this.f21418b);
        }
        f(this.f21420p);
        e(this.f21419c);
    }

    public ZenModeVideoTextPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public ZenModeVideoTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ZenModeVideoTextPreference(Context context) {
        super(context);
    }
}
