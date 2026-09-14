package com.oplus.melody.ui.component.control.guide;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.oplus.melody.ui.component.control.guide.ControlGuideFragment;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ControlGuideFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ControlGuideFragment f20564a;

    public b(ControlGuideFragment controlGuideFragment) {
        this.f20564a = controlGuideFragment;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public final void b(float f9, int i10, int i11) {
        View viewC;
        ViewTreeObserver viewTreeObserver;
        ControlGuideFragment controlGuideFragment = this.f20564a;
        ViewPager2 viewPager2 = controlGuideFragment.f20479q;
        if (viewPager2 == null) {
            h.i("mViewPager");
            throw null;
        }
        View childAt = viewPager2.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        RecyclerView.p layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (viewC = linearLayoutManager.C(i10)) == null) {
            return;
        }
        View viewC2 = linearLayoutManager.C(i10 + 1);
        final I8.h hVar = new I8.h(controlGuideFragment, viewC, viewC2, f9);
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: I8.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                hVar.invoke();
            }
        };
        viewC.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        if (viewC2 != null && (viewTreeObserver = viewC2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
        hVar.invoke();
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public final void c(int i10) {
        ControlGuideFragment controlGuideFragment = this.f20564a;
        MelodyCompatTextView melodyCompatTextView = controlGuideFragment.f20481s;
        if (melodyCompatTextView == null) {
            h.i("mPageIndicator");
            throw null;
        }
        int i11 = i10 + 1;
        ControlGuideFragment.a aVar = controlGuideFragment.f20480r;
        if (aVar == null) {
            h.i("mPageAdapter");
            throw null;
        }
        melodyCompatTextView.setText(i11 + "/" + aVar.getItemCount());
    }
}
