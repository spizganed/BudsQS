package com.oplus.melody.ui.widget.sound;

import C0.a;
import Ca.n;
import Ca.r;
import D7.C0379m;
import E8.b;
import E9.o;
import Ha.c;
import Ha.f;
import Ha.g;
import Kb.m;
import Kb.s;
import M9.b;
import M9.e;
import Wb.l;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import bc.C0745b;
import bc.C0746c;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.soundplay.ListenLimitedTime;
import com.oplus.melody.model.repository.soundplay.ViewStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyNumberPicker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 M2\u00020\u0001:\u0001MB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010:\u001a\u00020)J\u0010\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020\u001fH\u0002J\b\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020/H\u0002J\u0016\u0010?\u001a\u00020/2\u0006\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020/H\u0002J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020BH\u0002J\u0010\u0010F\u001a\u00020/2\u0006\u0010E\u001a\u00020BH\u0002J\b\u0010G\u001a\u0004\u0018\u00010\u001bJ\b\u0010H\u001a\u00020\u001bH\u0002J\u000e\u0010I\u001a\u00020/2\u0006\u0010E\u001a\u00020\u000fJ\u0006\u0010J\u001a\u00020\u000fJ\u0010\u0010K\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u000fH\u0002J\u0006\u0010L\u001a\u00020/R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006N"}, d2 = {"Lcom/oplus/melody/ui/widget/sound/MelodyNumberPicker;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mHeight", "", "mUnitState", "mCurrentNumber", "Lcom/oplus/melody/model/repository/soundplay/ListenLimitedTime;", "mState", "Lcom/oplus/melody/model/repository/soundplay/ViewStatus;", "mLastScrollState", "mTimeNameList", "", "", "[Ljava/lang/String;", "mTimeArray", "[Ljava/lang/Integer;", "mType", "mShowAnimatorSet", "Landroid/animation/AnimatorSet;", "mHideAnimatorSet", "mMoveHeight", "bottomView", "Landroid/view/View;", "textDisplayBackground", "Landroid/widget/ImageView;", "fakeNumber", "Landroid/widget/TextView;", "bannerTop", "bannerBottom", "numberPicker", "Lcom/oplus/melody/ui/widget/sound/MelodyColorNumberPicker;", "textDisplayRoot", "Landroid/widget/FrameLayout;", "unit", "Landroidx/constraintlayout/widget/ConstraintLayout;", "formatPickerTime", "mVisibilityListener", "Lkotlin/Function1;", "", "getMVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setMVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "stopRec", "", "getStopRec", "()Z", "setStopRec", "(Z)V", "getTextDisplay", "findViewById", "view", "setPickerView", "startHidePicker", "setCurrentCountDownTimeValue", "showInitState", "remainingTime", "", "updatePickerView", "animatorToLoop", "time", "animatorToMin", "showAnimator", "hideAnimator", "setNumber", "getNumber", "getIndex", "releaseAnimator", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyNumberPicker extends LinearLayout {
    public static final /* synthetic */ int H = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final TextView f22082A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final MelodyColorNumberPicker f22083B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final FrameLayout f22084C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ConstraintLayout f22085D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public String f22086E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public l<? super ViewStatus, Jb.l> f22087F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public boolean f22088G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f22089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ListenLimitedTime f22091c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewStatus f22092p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile int f22093q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String[] f22094r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer[] f22095s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AnimatorSet f22096t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f22097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f22098v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f22099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f22100x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f22101y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f22102z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        h.e(context, "context");
        this.f22091c = ListenLimitedTime.f20101c;
        this.f22092p = ViewStatus.f20126c;
        this.f22094r = new String[0];
        this.f22095s = new Integer[0];
        this.f22086E = "";
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1370i);
        h.d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = View.inflate(getContext(), R.layout.melody_ui_number_picker_view, this);
        h.b(viewInflate);
        View viewFindViewById = viewInflate.findViewById(R.id.bottom_view);
        h.d(viewFindViewById, "findViewById(...)");
        this.f22099w = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.text_display_background);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f22100x = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.fake_number);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f22101y = (TextView) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.banner_bottom);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f22082A = (TextView) viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.text_display_root);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f22084C = (FrameLayout) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.number_picker);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f22083B = (MelodyColorNumberPicker) viewFindViewById6;
        View viewFindViewById7 = viewInflate.findViewById(R.id.unit);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f22085D = (ConstraintLayout) viewFindViewById7;
        View viewFindViewById8 = viewInflate.findViewById(R.id.banner_top);
        h.d(viewFindViewById8, "findViewById(...)");
        this.f22102z = (TextView) viewFindViewById8;
        ImageView imageView = this.f22100x;
        if (imageView == null) {
            h.i("textDisplayBackground");
            throw null;
        }
        imageView.setBackground(getResources().getDrawable(R.drawable.melody_ui_time_button_listen));
        TextView textView = this.f22101y;
        if (textView == null) {
            h.i("fakeNumber");
            throw null;
        }
        textView.setTextColor(getResources().getColor(R.color.White));
        TextView textView2 = this.f22082A;
        if (textView2 == null) {
            h.i("bannerBottom");
            throw null;
        }
        textView2.setTextColor(getResources().getColor(R.color.White));
        List list = ListenLimitedTime.f20103q;
        ArrayList arrayList = new ArrayList(m.i(list));
        Iterator it = ((Kb.b) list).iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((ListenLimitedTime) it.next()).getValueInMinute()));
        }
        Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
        this.f22095s = numArr;
        this.f22094r = new String[numArr.length];
        Iterator<Integer> it2 = new C0746c(0, numArr.length - 1, 1).iterator();
        while (((C0745b) it2).f13175c) {
            int iA = ((s) it2).a();
            if (this.f22094r.length != 0) {
                if (this.f22095s[iA].intValue() == ListenLimitedTime.f20100b.getValueInMinute()) {
                    this.f22094r[iA] = getResources().getString(R.string.melody_ui_unlimited);
                } else {
                    this.f22094r[iA] = String.valueOf(this.f22095s[iA].intValue());
                }
            }
        }
        this.f22089a = getResources().getDimensionPixelOffset(R.dimen.melody_ui_listen_guide_text_height);
        MelodyColorNumberPicker melodyColorNumberPicker = this.f22083B;
        if (melodyColorNumberPicker == null) {
            h.i("numberPicker");
            throw null;
        }
        melodyColorNumberPicker.setMinValue(0);
        melodyColorNumberPicker.setMaxValue(this.f22094r.length - 1);
        melodyColorNumberPicker.setDisplayedValues(this.f22094r);
        melodyColorNumberPicker.setPickerNormalColor(melodyColorNumberPicker.getContext().getColor(R.color.melody_ui_color_white_80));
        melodyColorNumberPicker.setPickerFocusColor(melodyColorNumberPicker.getContext().getColor(R.color.White));
        melodyColorNumberPicker.setOnValueChangedListener(new n(this, 4));
        melodyColorNumberPicker.setOnScrollListener(new a(this, 5));
        melodyColorNumberPicker.setOnClickEventXListener(new c(0, melodyColorNumberPicker, this));
        melodyColorNumberPicker.setEnabled(false);
        View view = this.f22099w;
        if (view == null) {
            h.i("bottomView");
            throw null;
        }
        view.setEnabled(false);
        View view2 = this.f22099w;
        if (view2 != null) {
            view2.setOnClickListener(new o(this, 2));
        } else {
            h.i("bottomView");
            throw null;
        }
    }

    public final void a(long j5) {
        float f9 = this.f22089a;
        TextView textView = this.f22102z;
        if (textView == null) {
            h.i("bannerTop");
            throw null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "translationY", -f9, 0.0f);
        objectAnimatorOfFloat.setDuration(j5);
        objectAnimatorOfFloat.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.3f, 1.0f));
        TextView textView2 = this.f22082A;
        if (textView2 == null) {
            h.i("bannerBottom");
            throw null;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", -f9, 0.0f);
        objectAnimatorOfFloat2.setDuration(j5);
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.3f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public final void b(long j5) {
        float f9 = this.f22089a;
        TextView textView = this.f22102z;
        if (textView == null) {
            h.i("bannerTop");
            throw null;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "translationY", 0.0f, -f9);
        objectAnimatorOfFloat.setDuration(j5);
        objectAnimatorOfFloat.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.3f, 1.0f));
        TextView textView2 = this.f22082A;
        if (textView2 == null) {
            h.i("bannerBottom");
            throw null;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView2, "translationY", 0.0f, -f9);
        objectAnimatorOfFloat2.setDuration(j5);
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.3f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        animatorSet.start();
    }

    public final int c(ListenLimitedTime listenLimitedTime) {
        if (this.f22095s.length == 0) {
            return 0;
        }
        int i10 = 0;
        while (true) {
            Integer[] numArr = this.f22095s;
            if (i10 >= numArr.length) {
                return 0;
            }
            if (numArr[i10].intValue() == listenLimitedTime.getValueInMinute()) {
                return i10;
            }
            i10++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(long j5, boolean z2) {
        if (this.f22088G) {
            return;
        }
        Object obj = M9.b.h;
        Integer num = (Integer) C0379m.b(b.a.a().f3348g).d();
        int iIntValue = num != null ? num.intValue() : 0;
        String strB = e.b(j5);
        if (strB.length() == 0) {
            strB = getResources().getString(R.string.melody_ui_unlimited);
            h.d(strB, "getString(...)");
            this.f22086E = "";
        } else {
            ListenLimitedTime.f20099a.getClass();
            long jA = ListenLimitedTime.a.a(iIntValue).a();
            if (j5 == 0 || (j5 == jA && z2)) {
                strB = getResources().getQuantityString(R.plurals.melody_ui_time_minute, iIntValue, Integer.valueOf(iIntValue));
                h.d(strB, "getQuantityString(...)");
                this.f22086E = "";
            } else {
                this.f22086E = strB;
            }
        }
        MelodyColorNumberPicker melodyColorNumberPicker = this.f22083B;
        if (melodyColorNumberPicker == null) {
            h.i("numberPicker");
            throw null;
        }
        melodyColorNumberPicker.f22013E0 = this.f22086E;
        melodyColorNumberPicker.f22015F0 = String.valueOf(iIntValue);
        melodyColorNumberPicker.invalidate();
        TextView textView = this.f22101y;
        if (textView == null) {
            h.i("fakeNumber");
            throw null;
        }
        textView.setText(strB);
        f();
    }

    public final void e() {
        int i10 = 0;
        MelodyColorNumberPicker melodyColorNumberPicker = this.f22083B;
        if (melodyColorNumberPicker == null) {
            h.i("numberPicker");
            throw null;
        }
        if (melodyColorNumberPicker.f22056s.isFinished() && melodyColorNumberPicker.f22058t.isFinished() && this.f22093q == 0) {
            MelodyColorNumberPicker melodyColorNumberPicker2 = this.f22083B;
            if (melodyColorNumberPicker2 == null) {
                h.i("numberPicker");
                throw null;
            }
            melodyColorNumberPicker2.setEnabled(false);
            View view = this.f22099w;
            if (view == null) {
                h.i("bottomView");
                throw null;
            }
            view.setEnabled(false);
            this.f22092p = ViewStatus.f20127p;
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, -this.f22098v);
            valueAnimatorOfInt.setDuration(380L);
            valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            valueAnimatorOfInt.addUpdateListener(new Ha.b(i10, this, ref$IntRef));
            valueAnimatorOfInt.addListener(new g(this, 0));
            MelodyColorNumberPicker melodyColorNumberPicker3 = this.f22083B;
            if (melodyColorNumberPicker3 == null) {
                h.i("numberPicker");
                throw null;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(melodyColorNumberPicker3, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setDuration(180L);
            objectAnimatorOfFloat.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(30.0f, 16.0f);
            valueAnimatorOfFloat.setDuration(180L);
            valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            valueAnimatorOfFloat.addUpdateListener(new F9.n(this, 1));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(valueAnimatorOfInt).with(valueAnimatorOfFloat).with(objectAnimatorOfFloat);
            animatorSet.addListener(new f(this));
            this.f22097u = animatorSet;
            l<? super ViewStatus, Jb.l> lVar = this.f22087F;
            if (lVar != null) {
                lVar.d(this.f22092p);
            }
            AnimatorSet animatorSet2 = this.f22097u;
            if (animatorSet2 != null) {
                animatorSet2.start();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        TextView textView = this.f22082A;
        Object obj = M9.b.h;
        Integer num = (Integer) C0379m.b(b.a.a().f3348g).d();
        int iIntValue = num != null ? num.intValue() : 0;
        int iC = c(this.f22091c);
        ListenLimitedTime.f20099a.getClass();
        if (iC != ListenLimitedTime.a.a(iIntValue).ordinal() || TextUtils.isEmpty(this.f22086E)) {
            if (textView != null) {
                textView.setText(getResources().getQuantityString(R.plurals.melody_ui_minute_unit, this.f22091c.getValueInMinute()));
                return;
            } else {
                h.i("bannerBottom");
                throw null;
            }
        }
        if (textView != null) {
            textView.setText("");
        } else {
            h.i("bannerBottom");
            throw null;
        }
    }

    public final l<ViewStatus, Jb.l> getMVisibilityListener() {
        return this.f22087F;
    }

    /* JADX INFO: renamed from: getNumber, reason: from getter */
    public final ListenLimitedTime getF22091c() {
        return this.f22091c;
    }

    /* JADX INFO: renamed from: getStopRec, reason: from getter */
    public final boolean getF22088G() {
        return this.f22088G;
    }

    public final FrameLayout getTextDisplay() {
        FrameLayout frameLayout = this.f22084C;
        if (frameLayout != null) {
            return frameLayout;
        }
        h.i("textDisplayRoot");
        throw null;
    }

    public final void setMVisibilityListener(l<? super ViewStatus, Jb.l> lVar) {
        this.f22087F = lVar;
    }

    public final void setNumber(ListenLimitedTime time) {
        int i10;
        h.e(time, "time");
        A.c("MelodyNumberPicker", new r(time, 13));
        this.f22091c = time;
        MelodyColorNumberPicker melodyColorNumberPicker = this.f22083B;
        if (melodyColorNumberPicker == null) {
            h.i("numberPicker");
            throw null;
        }
        melodyColorNumberPicker.setValue(c(time));
        if (this.f22091c.getValueInMinute() == -1) {
            a(1L);
            i10 = 1;
        } else {
            b(1L);
            i10 = 0;
        }
        this.f22090b = i10;
    }

    public final void setStopRec(boolean z2) {
        this.f22088G = z2;
    }
}
