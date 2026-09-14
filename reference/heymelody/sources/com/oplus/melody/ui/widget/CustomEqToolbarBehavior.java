package com.oplus.melody.ui.widget;

import Ea.ViewOnScrollChangeListenerC0392a;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class CustomEqToolbarBehavior extends CoordinatorLayout.c<AppBarLayout> implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f21722A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final Resources f21723B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f21724C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final boolean f21725D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f21727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f21728c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21729p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21730q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int[] f21731r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup.LayoutParams f21732s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f21733t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f21734u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f21735v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f21736w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21737x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f21738y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f21739z;

    public CustomEqToolbarBehavior() {
        this.f21731r = new int[2];
    }

    public final void a() {
        this.f21728c = null;
        View view = this.f21727b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i10 = 0;
                while (true) {
                    if (i10 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i10).getVisibility() == 0) {
                        this.f21728c = viewGroup.getChildAt(i10);
                        break;
                    }
                    i10++;
                }
            }
        }
        if (this.f21728c == null) {
            this.f21728c = this.f21727b;
        }
        View view2 = this.f21728c;
        int[] iArr = this.f21731r;
        view2.getLocationOnScreen(iArr);
        int i11 = iArr[1];
        this.f21729p = i11;
        this.f21730q = 0;
        if (i11 < this.f21735v) {
            this.f21730q = this.f21736w;
        } else {
            int i12 = this.f21734u;
            if (i11 > i12) {
                this.f21730q = 0;
            } else {
                this.f21730q = i12 - i11;
            }
        }
        int i13 = this.f21730q;
        if (this.f21722A <= 1.0f) {
            float fAbs = Math.abs(i13) / this.f21736w;
            this.f21722A = fAbs;
            this.f21726a.setAlpha(fAbs);
        }
        int i14 = this.f21729p;
        if (i14 < this.f21737x) {
            this.f21730q = this.f21739z;
        } else {
            int i15 = this.f21738y;
            if (i14 > i15) {
                this.f21730q = 0;
            } else {
                this.f21730q = i15 - i14;
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f21732s;
        layoutParams.width = (int) ((this.f21733t * (Math.abs(this.f21730q) / this.f21739z)) + this.f21724C);
        this.f21726a.setLayoutParams(layoutParams);
    }

    public final void b(AppBarLayout appBarLayout, View view) {
        int measuredHeight = appBarLayout.getMeasuredHeight();
        if (this.f21734u != measuredHeight) {
            this.f21734u = measuredHeight;
            this.f21727b = view;
            View viewFindViewById = appBarLayout.findViewById(R.id.divider_line);
            this.f21726a = viewFindViewById;
            this.f21724C = viewFindViewById.getWidth();
            this.f21732s = this.f21726a.getLayoutParams();
            appBarLayout.getMeasuredWidth();
            int i10 = this.f21734u;
            this.f21735v = i10 - this.f21736w;
            int dimensionPixelOffset = i10 - this.f21723B.getDimensionPixelOffset(R.dimen.preference_divider_width_start_count_offset);
            this.f21738y = dimensionPixelOffset;
            this.f21737x = dimensionPixelOffset - this.f21739z;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        a();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i10, int i11) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        boolean z2 = (i10 & 2) != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight();
        if (!this.f21725D && z2) {
            b(appBarLayout, view3);
            view3.setOnScrollChangeListener(new ViewOnScrollChangeListenerC0392a(this, appBarLayout, view3));
        }
        return false;
    }

    public CustomEqToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21731r = new int[2];
        Resources resources = context.getResources();
        this.f21723B = resources;
        this.f21733t = resources.getDimensionPixelOffset(R.dimen.preference_divider_margin_horizontal) * 2;
        this.f21736w = this.f21723B.getDimensionPixelOffset(R.dimen.preference_line_alpha_range_change_offset);
        this.f21739z = this.f21723B.getDimensionPixelOffset(R.dimen.preference_divider_width_change_offset);
        this.f21725D = this.f21723B.getBoolean(R.bool.is_dialog_preference_immersive);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
