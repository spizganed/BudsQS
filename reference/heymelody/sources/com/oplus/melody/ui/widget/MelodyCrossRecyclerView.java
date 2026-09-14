package com.oplus.melody.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.COUIRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyCrossRecyclerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyCrossRecyclerView;", "Landroidx/recyclerview/widget/COUIRecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mTouchSlop", "mCanInterceptEventFlag", "", "Ljava/lang/Boolean;", "mOrientation", "mRatio", "", "mDownTouchEventX", "mDownTouchEventY", "setOrientation", "", "orientation", "setRatio", "ratio", "onInterceptTouchEvent", "e", "Landroid/view/MotionEvent;", "canInterceptEvent", "event", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyCrossRecyclerView extends COUIRecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f21817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21818c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f21819p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f21820q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f21821r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyCrossRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        h.e(context, "context");
        this.f21816a = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f21818c = 1;
        this.f21819p = 1.0f;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent e10) {
        boolean zBooleanValue;
        h.e(e10, "e");
        int actionMasked = e10.getActionMasked();
        if (actionMasked != 0) {
            boolean z2 = true;
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    return super.onInterceptTouchEvent(e10);
                }
                Boolean bool = this.f21817b;
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    float fAbs = Math.abs(e10.getX() - this.f21820q);
                    float fAbs2 = Math.abs(e10.getY() - this.f21821r);
                    float f9 = this.f21816a;
                    if (fAbs >= f9 || fAbs2 >= f9) {
                        if (this.f21818c != 1 ? fAbs * this.f21819p <= fAbs2 : fAbs2 * this.f21819p <= fAbs) {
                            z2 = false;
                        }
                        this.f21817b = Boolean.valueOf(z2);
                        zBooleanValue = z2;
                    } else {
                        zBooleanValue = false;
                    }
                }
                if (zBooleanValue) {
                    return super.onInterceptTouchEvent(e10);
                }
                return false;
            }
        }
        super.onInterceptTouchEvent(e10);
        this.f21820q = e10.getX();
        this.f21821r = e10.getY();
        this.f21817b = null;
        return false;
    }

    public final void setOrientation(int orientation) {
        this.f21818c = orientation;
    }

    public final void setRatio(float ratio) {
        this.f21819p = ratio;
    }
}
