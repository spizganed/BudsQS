package com.oplus.melody.ui.widget;

import A9.d;
import A9.k;
import D7.L;
import D7.o0;
import Ea.E;
import J7.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.PreferenceGroup;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.coui.appcompat.seekbar.FixCOUISectionSeekBar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.taplevelsetting.TapLevelSettingFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyTapLevelSettingSeekBarPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0002J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020&J\b\u0010'\u001a\u00020(H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyTapLevelSettingSeekBarPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSeekBar", "Lcom/coui/appcompat/seekbar/FixCOUISectionSeekBar;", "mProcessTxt", "Landroid/widget/TextView;", "mRestoreTxt", "mTrackChangeListener", "Lcom/oplus/melody/ui/widget/MelodyTapLevelSettingSeekBarPreference$OnTrackChanged;", "mContext", "mCurrentValue", "defaultProcessValue", "touchStartTime", "", "mLastValue", "pendingRunnable", "Ljava/lang/Runnable;", "setOnTrackChangeListener", "", "listener", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "changeRestoreBtnColor", "convert2LevelValue", "value", "convert2ProcessValue", "setProgress", "Lcom/oplus/melody/ui/component/detail/taplevelsetting/TapLevelSettingInfoVO;", "isFastClick", "", "Companion", "OnTrackChanged", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyTapLevelSettingSeekBarPreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FixCOUISectionSeekBar f21937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f21938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f21939c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TapLevelSettingFragment.b f21940p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21941q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f21942r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f21943s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21944t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public k f21945u;

    public MelodyTapLevelSettingSeekBarPreference(Context context) {
        this(context, null);
    }

    public final void e() {
        Context context;
        Context context2;
        if (this.f21941q == this.f21942r) {
            TextView textView = this.f21939c;
            if (textView != null) {
                textView.setText(R.string.melody_ui_default);
            }
            PreferenceGroup parent = getParent();
            if (parent == null || (context2 = parent.getContext()) == null) {
                return;
            }
            int color = context2.getColor(R.color.melody_ui_hearing_enhancement_top_tips_text_color);
            TextView textView2 = this.f21939c;
            if (textView2 != null) {
                textView2.setTextColor(color);
                return;
            }
            return;
        }
        TextView textView3 = this.f21939c;
        if (textView3 != null) {
            textView3.setText(R.string.melody_ui_restore);
        }
        PreferenceGroup parent2 = getParent();
        if (parent2 == null || (context = parent2.getContext()) == null) {
            return;
        }
        int color2 = context.getColor(R.color.melody_ui_control_guide_indicator_color);
        TextView textView4 = this.f21939c;
        if (textView4 != null) {
            textView4.setTextColor(color2);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.tap_level_setting_seek_bar);
        h.c(viewA, "null cannot be cast to non-null type com.coui.appcompat.seekbar.FixCOUISectionSeekBar");
        this.f21937a = (FixCOUISectionSeekBar) viewA;
        View viewA2 = holder.a(R.id.tap_level_setting_seek_bar_process_txt);
        h.c(viewA2, "null cannot be cast to non-null type android.widget.TextView");
        this.f21938b = (TextView) viewA2;
        View viewA3 = holder.a(R.id.tap_level_setting_restore_btn);
        h.c(viewA3, "null cannot be cast to non-null type android.widget.TextView");
        this.f21939c = (TextView) viewA3;
        b.a().e();
        if (Q1.a.a(getContext())) {
            holder.itemView.setBackgroundResource(R.drawable.melody_ui_seekbar_night_bg_all_radius);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.melody_ui_iot_udevice_preview_shape_all_radius);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar = this.f21937a;
        if (fixCOUISectionSeekBar != null) {
            fixCOUISectionSeekBar.setMoveDamping(1.0f);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar2 = this.f21937a;
        if (fixCOUISectionSeekBar2 != null) {
            fixCOUISectionSeekBar2.setMax(4);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar3 = this.f21937a;
        if (fixCOUISectionSeekBar3 != null) {
            fixCOUISectionSeekBar3.setProgress(this.f21941q - 1);
        }
        e();
        TextView textView = this.f21938b;
        if (textView != null) {
            textView.setText(String.valueOf(this.f21941q));
        }
        TextView textView2 = this.f21939c;
        if (textView2 != null) {
            textView2.setOnClickListener(new E(this, 0));
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar4 = this.f21937a;
        if (fixCOUISectionSeekBar4 != null) {
            fixCOUISectionSeekBar4.setOnSeekBarChangeListener(new a());
        }
    }

    public MelodyTapLevelSettingSeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MelodyTapLevelSettingSeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21941q = 1;
        this.f21942r = 1;
        setWidgetLayoutResource(R.layout.melody_ui_preference_tap_level_setting_seek_bar);
        setTitle(context != null ? context.getString(R.string.melody_ui_tap_level_setting_title) : null);
    }

    /* JADX INFO: compiled from: MelodyTapLevelSettingSeekBarPreference.kt */
    public static final class a implements COUISeekBar.l {
        public a() {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void a(COUISeekBar cOUISeekBar) {
            MelodyTapLevelSettingSeekBarPreference melodyTapLevelSettingSeekBarPreference = MelodyTapLevelSettingSeekBarPreference.this;
            A.c("MelodyTapLevelSettingSeekBarPreference", new d(melodyTapLevelSettingSeekBarPreference, 10));
            k kVar = melodyTapLevelSettingSeekBarPreference.f21945u;
            if (kVar != null) {
                o0.c.f1143a.removeCallbacks(kVar);
            }
            k kVar2 = new k(melodyTapLevelSettingSeekBarPreference, 5);
            o0.c.f1143a.postDelayed(kVar2, 500L);
            melodyTapLevelSettingSeekBarPreference.f21945u = kVar2;
            TapLevelSettingFragment.b bVar = melodyTapLevelSettingSeekBarPreference.f21940p;
            if (bVar != null) {
                bVar.a(melodyTapLevelSettingSeekBarPreference.f21941q < melodyTapLevelSettingSeekBarPreference.f21942r);
            }
            melodyTapLevelSettingSeekBarPreference.f21943s = System.currentTimeMillis();
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void c(COUISeekBar cOUISeekBar, int i10, boolean z2) {
            A.c("MelodyTapLevelSettingSeekBarPreference", new L(i10, 2));
            if (z2) {
                MelodyTapLevelSettingSeekBarPreference melodyTapLevelSettingSeekBarPreference = MelodyTapLevelSettingSeekBarPreference.this;
                int i11 = i10 + 1;
                melodyTapLevelSettingSeekBarPreference.f21944t = i11;
                melodyTapLevelSettingSeekBarPreference.f21941q = i11;
                TextView textView = melodyTapLevelSettingSeekBarPreference.f21938b;
                if (textView != null) {
                    textView.setText(String.valueOf(i11));
                }
                melodyTapLevelSettingSeekBarPreference.e();
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void d(COUISeekBar cOUISeekBar) {
        }
    }
}
