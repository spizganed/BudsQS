package com.oplus.melody.ui.widget;

import D7.o0;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.media3.session.q1;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.protocol.commands.q;
import com.oplus.melody.common.util.A;
import g9.j;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyBassEngineSeekBarPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nJ\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000fJ\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyBassEngineSeekBarPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSeekBar", "Lcom/oplus/melody/ui/widget/MelodyMarkSeekBar;", "mTrackChangeListener", "Lcom/oplus/melody/ui/widget/MelodyBassEngineSeekBarPreference$OnTrackChanged;", "mSeekBarDesStartTv", "Landroid/widget/TextView;", "mSeekBarDesEndTv", "mMinValue", "mMaxValue", "mCurrentValue", "getMinValue", "getMaxValue", "updateValue", "", "min", "max", "progress", "setOnTrackChangeListener", "listener", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "Companion", "OnTrackChanged", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyBassEngineSeekBarPreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MelodyMarkSeekBar f21753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1 f21754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21755c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21757q;

    public MelodyBassEngineSeekBarPreference(Context context) {
        super(context);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        if (Q1.a.a(getContext())) {
            holder.itemView.setBackgroundResource(R.drawable.melody_ui_seekbar_night_bg);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.melody_ui_iot_udevice_preview_shape_down_radius);
        }
        View viewA = holder.a(R.id.section_seek_bar_mark);
        h.c(viewA, "null cannot be cast to non-null type com.oplus.melody.ui.widget.MelodyMarkSeekBar");
        this.f21753a = (MelodyMarkSeekBar) viewA;
        boolean z2 = holder.a(R.id.section_seek_bar_des_start) instanceof TextView;
        boolean z4 = holder.a(R.id.section_seek_bar_des_end) instanceof TextView;
        MelodyMarkSeekBar melodyMarkSeekBar = this.f21753a;
        if (melodyMarkSeekBar != null) {
            melodyMarkSeekBar.setMoveDamping(1.0f);
        }
        MelodyMarkSeekBar melodyMarkSeekBar2 = this.f21753a;
        if (melodyMarkSeekBar2 != null) {
            melodyMarkSeekBar2.setMax(this.f21756p - this.f21755c);
        }
        MelodyMarkSeekBar melodyMarkSeekBar3 = this.f21753a;
        if (melodyMarkSeekBar3 != null) {
            melodyMarkSeekBar3.setProgress(this.f21757q - this.f21755c);
        }
        MelodyMarkSeekBar melodyMarkSeekBar4 = this.f21753a;
        if (melodyMarkSeekBar4 != null) {
            int i10 = this.f21755c;
            int i11 = this.f21757q - i10;
            melodyMarkSeekBar4.f21882c = i10;
            melodyMarkSeekBar4.f21883p = i11;
            melodyMarkSeekBar4.invalidate();
        }
        MelodyMarkSeekBar melodyMarkSeekBar5 = this.f21753a;
        if (melodyMarkSeekBar5 != null) {
            melodyMarkSeekBar5.setOnSeekBarChangeListener(new a());
        }
    }

    public MelodyBassEngineSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MelodyBassEngineSeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setWidgetLayoutResource(R.layout.melody_ui_preference_seek_bar);
    }

    /* JADX INFO: compiled from: MelodyBassEngineSeekBarPreference.kt */
    public static final class a implements COUISeekBar.l {
        public a() {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void c(COUISeekBar cOUISeekBar, int i10, boolean z2) {
            if (z2) {
                MelodyBassEngineSeekBarPreference melodyBassEngineSeekBarPreference = MelodyBassEngineSeekBarPreference.this;
                MelodyMarkSeekBar melodyMarkSeekBar = melodyBassEngineSeekBarPreference.f21753a;
                if (melodyMarkSeekBar != null) {
                    melodyMarkSeekBar.f21882c = melodyBassEngineSeekBarPreference.f21755c;
                    melodyMarkSeekBar.f21883p = i10;
                    melodyMarkSeekBar.invalidate();
                }
                q1 q1Var = melodyBassEngineSeekBarPreference.f21754b;
                if (q1Var != null) {
                    int i11 = i10 + melodyBassEngineSeekBarPreference.f21755c;
                    j jVar = (j) q1Var.f11420b;
                    A.c("CustomEqFragment", new q(i11, 5));
                    D.h hVar = jVar.f23374p0;
                    if (hVar != null) {
                        o0.c.f1143a.removeCallbacks(hVar);
                    }
                    D.h hVar2 = new D.h(jVar, i11, 9);
                    jVar.f23374p0 = hVar2;
                    o0.c.f1143a.postDelayed(hVar2, 500L);
                }
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void a(COUISeekBar cOUISeekBar) {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void d(COUISeekBar cOUISeekBar) {
        }
    }
}
