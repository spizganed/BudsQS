package com.oplus.melody.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyErrorLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f21852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f21853c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f21854p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f21855q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f21856r;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MelodyErrorLayout melodyErrorLayout = MelodyErrorLayout.this;
            melodyErrorLayout.f21852b.setVisibility(8);
            melodyErrorLayout.f21853c.setVisibility(0);
            Drawable drawable = melodyErrorLayout.f21855q;
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    public MelodyErrorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21851a = new a();
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f21854p.setOnClickListener(onClickListener);
        a aVar = this.f21851a;
        removeCallbacks(aVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f21856r;
        if (jElapsedRealtime >= 200 || !postDelayed(aVar, 200 - jElapsedRealtime)) {
            aVar.run();
        }
    }

    public final void b() {
        removeCallbacks(this.f21851a);
        this.f21856r = SystemClock.elapsedRealtime();
        Drawable drawable = this.f21855q;
        if (drawable instanceof AnimatedVectorDrawable) {
            ((AnimatedVectorDrawable) drawable).stop();
        }
        this.f21853c.setVisibility(8);
        this.f21852b.setVisibility(0);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f21852b = findViewById(R.id.melody_ui_progress_container);
        View viewFindViewById = findViewById(R.id.melody_ui_error_container);
        this.f21853c = viewFindViewById;
        this.f21854p = (TextView) viewFindViewById.findViewById(R.id.melody_ui_btn_retry);
        this.f21855q = ((MelodyCompatImageView) this.f21853c.findViewById(R.id.melody_ui_img_error)).getDrawable();
    }
}
