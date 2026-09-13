package com.oplus.melody.ui.widget;

import Aa.e;
import D7.o0;
import Ea.C;
import Ea.D;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.coui.appcompat.seekbar.FixCOUISectionSeekBar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import g0.C1065d;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyPromptVolumeSeekBarPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyPromptVolumeSeekBarPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSeekBar", "Lcom/coui/appcompat/seekbar/FixCOUISectionSeekBar;", "iconImg", "Landroid/widget/ImageView;", "mProcessTxt", "Landroid/widget/TextView;", "mTrackChangeListener", "Lcom/oplus/melody/ui/widget/MelodyPromptVolumeSeekBarPreference$OnTrackChanged;", "mCurrentValue", "mLastValue", "barMaxValue", "getBarMaxValue", "()I", "setBarMaxValue", "(I)V", "mOffset", "getMOffset", "setMOffset", "pendingRunnable", "Ljava/lang/Runnable;", "setOnTrackChangeListener", "", "listener", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setProgress", "value", "isMuteBackground", "isMute", "", "Companion", "OnTrackChanged", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MelodyPromptVolumeSeekBarPreference extends COUIPreference {
    private static final String TAG = "MelodyPromptVolumeSeekBarPreference";
    private int barMaxValue;
    private ImageView iconImg;
    private int mCurrentValue;
    private int mLastValue;
    private int mOffset;
    private TextView mProcessTxt;
    private FixCOUISectionSeekBar mSeekBar;
    private b mTrackChangeListener;
    private Runnable pendingRunnable;

    /* JADX INFO: compiled from: MelodyPromptVolumeSeekBarPreference.kt */
    public interface b {
        void a(int i10);
    }

    public MelodyPromptVolumeSeekBarPreference(Context context) {
        super(context);
        this.mCurrentValue = 6;
        this.barMaxValue = 10;
        this.mOffset = 1;
        setLayoutResource(R.layout.melody_ui_preference_prompt_volume_seek_bar);
        setWidgetLayoutResource(R.layout.melody_ui_preference_prompt_volume_seek_bar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setProgress$lambda$0(int i10, MelodyPromptVolumeSeekBarPreference melodyPromptVolumeSeekBarPreference) {
        return C1065d.e("setProgress, progress: ", " , mCurrentValue: ", i10, melodyPromptVolumeSeekBarPreference.mCurrentValue);
    }

    public final int getBarMaxValue() {
        return this.barMaxValue;
    }

    public final int getMOffset() {
        return this.mOffset;
    }

    public final void isMuteBackground(boolean isMute) {
        if (Q1.a.a(getContext())) {
            ImageView imageView = this.iconImg;
            if (imageView != null) {
                imageView.setBackgroundResource(isMute ? R.drawable.prompt_volume_mute_dark : R.drawable.prompt_volume_normal_dark);
                return;
            }
            return;
        }
        ImageView imageView2 = this.iconImg;
        if (imageView2 != null) {
            imageView2.setBackgroundResource(isMute ? R.drawable.prompt_volume_mute_light : R.drawable.prompt_volume_normal_light);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.prompt_volume_seek_bar);
        h.c(viewA, "null cannot be cast to non-null type com.coui.appcompat.seekbar.FixCOUISectionSeekBar");
        this.mSeekBar = (FixCOUISectionSeekBar) viewA;
        View viewA2 = holder.a(R.id.prompt_volume_icon);
        h.c(viewA2, "null cannot be cast to non-null type android.widget.ImageView");
        this.iconImg = (ImageView) viewA2;
        View viewA3 = holder.a(R.id.prompt_volume_seek_bar_process_txt);
        h.c(viewA3, "null cannot be cast to non-null type android.widget.TextView");
        this.mProcessTxt = (TextView) viewA3;
        J7.b.a().e();
        if (Q1.a.a(getContext())) {
            holder.itemView.setBackgroundResource(R.drawable.melody_ui_seekbar_night_bg_all_radius);
            ImageView imageView = this.iconImg;
            if (imageView != null) {
                imageView.setBackgroundResource(this.mCurrentValue == 1 ? R.drawable.prompt_volume_mute_dark : R.drawable.prompt_volume_normal_dark);
            }
        } else {
            holder.itemView.setBackgroundResource(R.drawable.melody_ui_iot_udevice_preview_shape_all_radius);
            ImageView imageView2 = this.iconImg;
            if (imageView2 != null) {
                imageView2.setBackgroundResource(this.mCurrentValue == 1 ? R.drawable.prompt_volume_mute_light : R.drawable.prompt_volume_normal_light);
            }
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar = this.mSeekBar;
        if (fixCOUISectionSeekBar != null) {
            fixCOUISectionSeekBar.setMoveDamping(1.0f);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar2 = this.mSeekBar;
        if (fixCOUISectionSeekBar2 != null) {
            fixCOUISectionSeekBar2.setMax(this.barMaxValue - this.mOffset);
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar3 = this.mSeekBar;
        if (fixCOUISectionSeekBar3 != null) {
            fixCOUISectionSeekBar3.setProgress(this.mCurrentValue - this.mOffset);
        }
        TextView textView = this.mProcessTxt;
        if (textView != null) {
            textView.setText((this.mCurrentValue * 10) + "%");
        }
        FixCOUISectionSeekBar fixCOUISectionSeekBar4 = this.mSeekBar;
        if (fixCOUISectionSeekBar4 != null) {
            fixCOUISectionSeekBar4.setOnSeekBarChangeListener(new c());
        }
    }

    public final void setBarMaxValue(int i10) {
        this.barMaxValue = i10;
    }

    public final void setMOffset(int i10) {
        this.mOffset = i10;
    }

    public final void setOnTrackChangeListener(b listener) {
        h.e(listener, "listener");
        this.mTrackChangeListener = listener;
    }

    public final void setProgress(int value) {
        A.c(TAG, new C(value, this, 0));
        if (this.mCurrentValue != value) {
            this.mCurrentValue = value;
            FixCOUISectionSeekBar fixCOUISectionSeekBar = this.mSeekBar;
            if (fixCOUISectionSeekBar != null) {
                fixCOUISectionSeekBar.setProgress(value - this.mOffset);
            }
            TextView textView = this.mProcessTxt;
            if (textView != null) {
                textView.setText((this.mCurrentValue * 10) + "%");
            }
            isMuteBackground(value == 1);
        }
    }

    public MelodyPromptVolumeSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentValue = 6;
        this.barMaxValue = 10;
        this.mOffset = 1;
        setLayoutResource(R.layout.melody_ui_preference_prompt_volume_seek_bar);
        setWidgetLayoutResource(R.layout.melody_ui_preference_prompt_volume_seek_bar);
    }

    public MelodyPromptVolumeSeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mCurrentValue = 6;
        this.barMaxValue = 10;
        this.mOffset = 1;
        setLayoutResource(R.layout.melody_ui_preference_prompt_volume_seek_bar);
        setWidgetLayoutResource(R.layout.melody_ui_preference_prompt_volume_seek_bar);
    }

    /* JADX INFO: compiled from: MelodyPromptVolumeSeekBarPreference.kt */
    public static final class c implements COUISeekBar.l {
        public c() {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void a(COUISeekBar cOUISeekBar) {
            MelodyPromptVolumeSeekBarPreference melodyPromptVolumeSeekBarPreference = MelodyPromptVolumeSeekBarPreference.this;
            A.c(MelodyPromptVolumeSeekBarPreference.TAG, new B6.a(melodyPromptVolumeSeekBarPreference, 7));
            melodyPromptVolumeSeekBarPreference.isMuteBackground(melodyPromptVolumeSeekBarPreference.mCurrentValue == 1);
            Runnable runnable = melodyPromptVolumeSeekBarPreference.pendingRunnable;
            if (runnable != null) {
                o0.c.f1143a.removeCallbacks(runnable);
            }
            e eVar = new e(melodyPromptVolumeSeekBarPreference, 4);
            o0.c.f1143a.postDelayed(eVar, 500L);
            melodyPromptVolumeSeekBarPreference.pendingRunnable = eVar;
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void c(COUISeekBar cOUISeekBar, int i10, boolean z2) {
            A.c(MelodyPromptVolumeSeekBarPreference.TAG, new D(i10, 0));
            if (z2) {
                MelodyPromptVolumeSeekBarPreference melodyPromptVolumeSeekBarPreference = MelodyPromptVolumeSeekBarPreference.this;
                melodyPromptVolumeSeekBarPreference.mLastValue = melodyPromptVolumeSeekBarPreference.getMOffset() + i10;
                melodyPromptVolumeSeekBarPreference.mCurrentValue = melodyPromptVolumeSeekBarPreference.getMOffset() + i10;
                TextView textView = melodyPromptVolumeSeekBarPreference.mProcessTxt;
                if (textView != null) {
                    textView.setText((melodyPromptVolumeSeekBarPreference.mCurrentValue * 10) + "%");
                }
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void d(COUISeekBar cOUISeekBar) {
        }
    }
}
