package com.oplus.melody.ui.component.hearingenhance.widget;

import E9.o;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.hearingenhance.widget.ExpandedTextView;
import na.ViewTreeObserverOnGlobalLayoutListenerC1356a;

/* JADX INFO: loaded from: classes3.dex */
public class ExpandedTextView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21601c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RotateAnimation f21602p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RotateAnimation f21603q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f21604r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f21605s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public o f21606t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewTreeObserverOnGlobalLayoutListenerC1356a f21607u;

    public ExpandedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21599a = false;
        this.f21600b = true;
        this.f21601c = 0;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.f21603q = rotateAnimation;
        rotateAnimation.setDuration(300L);
        this.f21603q.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.f21602p = rotateAnimation2;
        rotateAnimation2.setDuration(300L);
        this.f21602p.setFillAfter(true);
    }

    public static /* synthetic */ void a(ExpandedTextView expandedTextView) {
        if (expandedTextView.f21600b) {
            expandedTextView.f21600b = false;
            int lineCount = expandedTextView.f21604r.getLineCount();
            expandedTextView.f21601c = lineCount;
            if (lineCount <= 4) {
                expandedTextView.f21605s.setVisibility(8);
                expandedTextView.f21599a = true;
                return;
            }
            expandedTextView.f21604r.setMaxLines(4);
            expandedTextView.f21604r.measure(0, 0);
            expandedTextView.f21605s.setVisibility(0);
            expandedTextView.f21605s.setOnClickListener(expandedTextView.getIndicatorOnClickListener());
            expandedTextView.f21599a = false;
        }
    }

    private View.OnClickListener getIndicatorOnClickListener() {
        if (this.f21606t == null) {
            this.f21606t = new o(this, 19);
        }
        return this.f21606t;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [na.a] */
    public void setText(CharSequence charSequence) {
        if (this.f21604r == null) {
            this.f21604r = (TextView) findViewById(R.id.enhance_des_id);
            this.f21605s = (ImageView) findViewById(R.id.expanded_indicator);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f21604r.setText(charSequence);
        }
        if (this.f21607u == null) {
            this.f21607u = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: na.a
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    ExpandedTextView.a(this.f26494a);
                }
            };
            this.f21604r.getViewTreeObserver().addOnGlobalLayoutListener(this.f21607u);
        }
    }

    public void setTextGravity(int i10) {
        if (this.f21604r == null) {
            this.f21604r = (TextView) findViewById(R.id.enhance_des_id);
            this.f21605s = (ImageView) findViewById(R.id.expanded_indicator);
        }
        this.f21604r.setGravity(i10);
    }
}
