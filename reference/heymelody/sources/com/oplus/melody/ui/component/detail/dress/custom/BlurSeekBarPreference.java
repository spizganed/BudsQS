package com.oplus.melody.ui.component.detail.dress.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: BlurSeekBarPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0010J\"\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/custom/BlurSeekBarPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "Lcom/coui/appcompat/seekbar/COUISeekBar$OnSeekBarChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSeekBar", "Lcom/coui/appcompat/seekbar/COUISeekBar;", "mProgressChangeListener", "Lcom/oplus/melody/ui/component/detail/dress/custom/BlurSeekBarPreference$OnProgressChangeListener;", "mProgress", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "setProgress", "progress", "setOnProgressChangeListener", "listener", "onProgressChanged", "p0", "p1", "p2", "", "onStartTrackingTouch", "onStopTrackingTouch", "OnProgressChangeListener", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BlurSeekBarPreference extends COUIPreference implements COUISeekBar.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public COUISeekBar f20827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f20828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20829c;

    /* JADX INFO: compiled from: BlurSeekBarPreference.kt */
    public interface a {
        void a(int i10);
    }

    public BlurSeekBarPreference(Context context) {
        super(context);
        setLayoutResource(R.layout.melody_ui_blur_seekbar_preference);
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar.l
    public final void c(COUISeekBar cOUISeekBar, int i10, boolean z2) {
        a aVar = this.f20828b;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.seekbar_custom_blur_radius);
        COUISeekBar cOUISeekBar = viewA instanceof COUISeekBar ? (COUISeekBar) viewA : null;
        this.f20827a = cOUISeekBar;
        if (cOUISeekBar != null) {
            cOUISeekBar.setMax(100);
            cOUISeekBar.setProgress(this.f20829c);
            cOUISeekBar.setMaxMovingDistance(0);
            cOUISeekBar.setMaxWidthDeformed(0.0f);
            cOUISeekBar.setMaxHeightDeformed(0.0f);
        }
        COUISeekBar cOUISeekBar2 = this.f20827a;
        if (cOUISeekBar2 != null) {
            cOUISeekBar2.setOnSeekBarChangeListener(this);
        }
    }

    public BlurSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(R.layout.melody_ui_blur_seekbar_preference);
    }

    public BlurSeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setLayoutResource(R.layout.melody_ui_blur_seekbar_preference);
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar.l
    public final void a(COUISeekBar cOUISeekBar) {
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar.l
    public final void d(COUISeekBar cOUISeekBar) {
    }
}
