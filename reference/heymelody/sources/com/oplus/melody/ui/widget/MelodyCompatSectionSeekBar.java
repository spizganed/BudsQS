package com.oplus.melody.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.coui.appcompat.seekbar.COUISectionSeekBar;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyCompatSectionSeekBar extends COUISectionSeekBar {

    public class a implements COUISeekBar.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21781a;

        public a(b bVar) {
            this.f21781a = bVar;
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void a(COUISeekBar cOUISeekBar) {
            b bVar = this.f21781a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void c(COUISeekBar cOUISeekBar, int i10, boolean z2) {
            b bVar = this.f21781a;
            if (bVar != null) {
                bVar.c(i10);
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.l
        public final void d(COUISeekBar cOUISeekBar) {
            b bVar = this.f21781a;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public interface b {
        void a();

        void b();

        void c(int i10);
    }

    public MelodyCompatSectionSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.couiSectionSeekBarStyle, R.style.COUISectionSeekBar);
        setMaxMovingDistance(0);
        setMaxWidthDeformed(0.0f);
        setMaxHeightDeformed(0.0f);
    }

    public int getThumbIndex() {
        return getProgress();
    }

    public void setNumber(int i10) {
        setMax(i10);
    }

    public void setOnSectionSeekBarChangeListener(b bVar) {
        setOnSeekBarChangeListener(new a(bVar));
    }

    public void setThumbIndex(int i10) {
        setProgress(i10);
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public final float subtract(float f9, float f10) {
        try {
            return super.subtract(f9, f10);
        } catch (Exception e10) {
            A.i("MelodyCompatSectionSeekBar", "subtract, error: ", e10);
            return 0.0f;
        }
    }
}
