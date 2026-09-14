package com.oplus.melody.ui.component.hearingenhance.widget;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.B;

/* JADX INFO: loaded from: classes3.dex */
public class CustomTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21586a = 0;

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMovementMethod(ScrollingMovementMethod.getInstance());
        post(new B(this, 26));
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }
}
