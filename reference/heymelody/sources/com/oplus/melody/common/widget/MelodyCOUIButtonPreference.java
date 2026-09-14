package com.oplus.melody.common.widget;

import F9.s;
import G7.c;
import G7.d;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.preference.m;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.preference.COUIButtonPreference;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyCOUIButtonPreference.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0014J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/oplus/melody/common/widget/MelodyCOUIButtonPreference;", "Lcom/coui/appcompat/preference/COUIButtonPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mButton", "Lcom/coui/appcompat/button/COUIButton;", "mIsSetButtonBgEmpty", "", "mShowButton", "mOnPreferenceButtonClickListener", "Lcom/oplus/melody/common/widget/MelodyCOUIButtonPreference$OnPreferenceButtonClickListener;", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mButtonAlpha", "", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "showButton", "setButtonAlpha", "alpha", "setOnPreferenceButtonClickListener", "listener", "showWithAnimation", "view", "Landroid/view/View;", "isShow", "OnPreferenceButtonClickListener", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MelodyCOUIButtonPreference extends COUIButtonPreference {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public COUIButton f19524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f19525t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f19526u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ValueAnimator f19527v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f19528w;

    /* JADX INFO: compiled from: MelodyCOUIButtonPreference.kt */
    public interface a {
        void a(MelodyCOUIButtonPreference melodyCOUIButtonPreference);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyCOUIButtonPreference(Context context) {
        super(context);
        h.e(context, "context");
        this.f19528w = 1.0f;
    }

    public final void f(boolean z2) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        this.f19525t = z2;
        COUIButton cOUIButton = this.f19524s;
        if (cOUIButton != null) {
            ValueAnimator valueAnimator3 = this.f19527v;
            if (((valueAnimator3 != null && valueAnimator3.isRunning()) || ((valueAnimator = this.f19527v) != null && valueAnimator.isStarted())) && (valueAnimator2 = this.f19527v) != null) {
                valueAnimator2.pause();
            }
            ValueAnimator duration = ValueAnimator.ofFloat(cOUIButton.getVisibility() == 0 ? cOUIButton.getAlpha() : 0.0f, z2 ? this.f19528w : 0.0f).setDuration(100L);
            this.f19527v = duration;
            if (duration != null) {
                duration.setInterpolator(new LinearInterpolator());
            }
            ValueAnimator valueAnimator4 = this.f19527v;
            if (valueAnimator4 != null) {
                valueAnimator4.addUpdateListener(new c(0, cOUIButton));
            }
            ValueAnimator valueAnimator5 = this.f19527v;
            if (valueAnimator5 != null) {
                valueAnimator5.addListener(new d(cOUIButton, z2));
            }
            ValueAnimator valueAnimator6 = this.f19527v;
            if (valueAnimator6 != null) {
                valueAnimator6.start();
            }
        }
    }

    @Override // com.coui.appcompat.preference.COUIButtonPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.coui_btn);
        h.c(viewA, "null cannot be cast to non-null type com.coui.appcompat.button.COUIButton");
        COUIButton cOUIButton = (COUIButton) viewA;
        this.f19524s = cOUIButton;
        if (this.f19525t) {
            cOUIButton.setVisibility(0);
        } else {
            cOUIButton.setVisibility(8);
        }
        this.f14538r = new s(this, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyCOUIButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f19528w = 1.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyCOUIButtonPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        this.f19528w = 1.0f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyCOUIButtonPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        this.f19528w = 1.0f;
    }
}
