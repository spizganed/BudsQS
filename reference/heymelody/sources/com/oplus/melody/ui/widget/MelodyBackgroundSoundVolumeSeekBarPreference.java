package com.oplus.melody.ui.widget;

import Ea.C0396e;
import P9.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.coui.appcompat.seekbar.FixCOUISectionSeekBar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyBackgroundSoundVolumeSeekBarPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006("}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyBackgroundSoundVolumeSeekBarPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSeekBar", "Lcom/coui/appcompat/seekbar/FixCOUISectionSeekBar;", "mIconImg", "Landroid/widget/ImageView;", "mTrackChangeListener", "Lcom/oplus/melody/ui/widget/MelodyBackgroundSoundVolumeSeekBarPreference$OnTrackChanged;", "mCurrentValue", "barMaxValue", "getBarMaxValue", "()I", "setBarMaxValue", "(I)V", "barMinValue", "getBarMinValue", "setBarMinValue", "setOnTrackChangeListener", "", "listener", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setProgress", "value", "updateMuteIcon", "isMute", "", "Companion", "OnTrackChanged", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyBackgroundSoundVolumeSeekBarPreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FixCOUISectionSeekBar f21747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f21748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0.a f21749c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21750p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f21751q;

    public MelodyBackgroundSoundVolumeSeekBarPreference(Context context) {
        super(context);
        this.f21750p = 7;
        this.f21751q = 10;
        setLayoutResource(R.layout.melody_ui_preference_background_sound_volume_seek_bar);
        setWidgetLayoutResource(R.layout.melody_ui_preference_background_sound_volume_seek_bar);
    }

    public final void e(boolean z2) {
        ImageView imageView = this.f21748b;
        if (imageView == null) {
            return;
        }
        Q1.a.c(imageView, false);
        if (Q1.a.a(getContext())) {
            imageView.setImageResource(z2 ? R.drawable.prompt_volume_mute_dark : R.drawable.prompt_volume_normal_dark);
        } else {
            imageView.setImageResource(z2 ? R.drawable.prompt_volume_mute_light : R.drawable.prompt_volume_normal_light);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.background_sound_volume_seek_bar);
        h.c(viewA, "null cannot be cast to non-null type com.coui.appcompat.seekbar.FixCOUISectionSeekBar");
        this.f21747a = (FixCOUISectionSeekBar) viewA;
        View viewA2 = holder.a(R.id.background_sound_volume_icon);
        h.c(viewA2, "null cannot be cast to non-null type android.widget.ImageView");
        this.f21748b = (ImageView) viewA2;
        holder.itemView.setBackgroundResource(R.drawable.melody_ui_preference_card_bg_no_radius);
        e(this.f21750p == 0);
        FixCOUISectionSeekBar fixCOUISectionSeekBar = this.f21747a;
        if (fixCOUISectionSeekBar != null) {
            fixCOUISectionSeekBar.setMoveDamping(1.0f);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar2 = this.f21747a;
        if (fixCOUISectionSeekBar2 != null) {
            fixCOUISectionSeekBar2.setMax(this.f21751q);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar3 = this.f21747a;
        if (fixCOUISectionSeekBar3 != null) {
            fixCOUISectionSeekBar3.setProgress(this.f21750p);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar4 = this.f21747a;
        if (fixCOUISectionSeekBar4 != null) {
            fixCOUISectionSeekBar4.setOnSeekBarChangeListener(new a());
        }
    }

    public MelodyBackgroundSoundVolumeSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21750p = 7;
        this.f21751q = 10;
        setLayoutResource(R.layout.melody_ui_preference_background_sound_volume_seek_bar);
        setWidgetLayoutResource(R.layout.melody_ui_preference_background_sound_volume_seek_bar);
    }

    public MelodyBackgroundSoundVolumeSeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21750p = 7;
        this.f21751q = 10;
        setLayoutResource(R.layout.melody_ui_preference_background_sound_volume_seek_bar);
        setWidgetLayoutResource(R.layout.melody_ui_preference_background_sound_volume_seek_bar);
    }

    /* JADX INFO: compiled from: MelodyBackgroundSoundVolumeSeekBarPreference.kt */
    public static final class a implements COUISeekBar.l {
        public a() {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void c(COUISeekBar cOUISeekBar, int i10, boolean z2) {
            A.c("MelodyBackgroundSoundVolumeSeekBarPreference", new C0396e(i10, 0, z2));
            if (z2) {
                MelodyBackgroundSoundVolumeSeekBarPreference melodyBackgroundSoundVolumeSeekBarPreference = MelodyBackgroundSoundVolumeSeekBarPreference.this;
                melodyBackgroundSoundVolumeSeekBarPreference.f21750p = i10;
                melodyBackgroundSoundVolumeSeekBarPreference.e(i10 == 0);
                C0.a aVar = melodyBackgroundSoundVolumeSeekBarPreference.f21749c;
                if (aVar != null) {
                    ((c) aVar.f608b).e(melodyBackgroundSoundVolumeSeekBarPreference.f21750p);
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
