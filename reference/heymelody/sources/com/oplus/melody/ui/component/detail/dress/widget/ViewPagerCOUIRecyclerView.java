package com.oplus.melody.ui.component.detail.dress.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.COUIRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ViewPagerCOUIRecyclerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/widget/ViewPagerCOUIRecyclerView;", "Landroidx/recyclerview/widget/COUIRecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLastMotionX", "", "mLastMotionY", "mActivePointerId", "mInitialMotionX", "mInitialMotionY", "mIsUnableDrag", "", "mTouchSlop", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ViewPagerCOUIRecyclerView extends COUIRecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20946c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f20947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f20948q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerCOUIRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        int iFindPointerIndex;
        h.e(ev, "ev");
        int action = ev.getAction() & 255;
        if (action == 0) {
            this.f20945b = ev.getPointerId(0);
            float x10 = ev.getX();
            this.f20946c = x10;
            this.f20944a = x10;
            this.f20947p = ev.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
            this.f20948q = false;
        } else if (action == 2 && (iFindPointerIndex = ev.findPointerIndex(this.f20945b)) >= 0) {
            float x11 = ev.getX(iFindPointerIndex);
            float y5 = ev.getY(iFindPointerIndex);
            float f9 = x11 - this.f20944a;
            float f10 = y5 - this.f20947p;
            float fAbs = Math.abs(f9);
            float fAbs2 = Math.abs(f10);
            float f11 = 0;
            if (fAbs > f11 && fAbs * 0.5f > fAbs2) {
                getParent().requestDisallowInterceptTouchEvent(false);
                this.f20944a = f9 > 0.0f ? this.f20946c + f11 : this.f20946c - f11;
                if (!this.f20948q) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (fAbs2 > f11) {
                getParent().requestDisallowInterceptTouchEvent(true);
                this.f20948q = true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
