package com.oplus.melody.ui.widget.sound;

import Ca.n;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.android.material.timepicker.TimeModel;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.soundplay.ListenLimitedTime;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import g0.C1065d;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import sb.C1511a;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyColorNumberPicker extends LinearLayout {

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public static final /* synthetic */ int f22003G0 = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f22004A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public boolean f22005A0;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public f f22006B;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public final float f22007B0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public e f22008C;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public final float f22009C0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public d f22010D;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public final float f22011D0;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f22012E;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public String f22013E0;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public long f22014F;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public String f22015F0;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public int[] f22016G;
    public int H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f22017I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f22018J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f22019K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public b f22020L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public float f22021M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public long f22022N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public float f22023O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public VelocityTracker f22024P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final int f22025Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final int f22026R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final int f22027S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f22028T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public boolean f22029U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public int f22030V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public int f22031W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22032a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f22033a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22034b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f22035b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22036c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f22037c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public a f22038d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f22039e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final AccessibilityManager f22040f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public HandlerThread f22041g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public h f22042h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f22043i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f22044j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f22045k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f22046l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f22047m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f22048n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f22049o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f22050p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f22051p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SparseArray<String> f22052q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f22053q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f22054r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f22055r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Scroller f22056s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f22057s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Scroller f22058t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final int f22059t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g f22060u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f22061u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f22062v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final int f22063v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f22064w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final int f22065w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String[] f22066x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final int f22067x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f22068y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final float f22069y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f22070z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final float f22071z0;

    public class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f22072a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f22073b = new int[2];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22074c = Integer.MIN_VALUE;

        public a() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(int i10, int i11) {
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            if (melodyColorNumberPicker.f22040f0.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
                accessibilityEventObtain.setPackageName(melodyColorNumberPicker.getContext().getPackageName());
                accessibilityEventObtain.getText().add(null);
                accessibilityEventObtain.setEnabled(melodyColorNumberPicker.isEnabled());
                accessibilityEventObtain.setSource(melodyColorNumberPicker, i10);
                melodyColorNumberPicker.requestSendAccessibilityEvent(melodyColorNumberPicker, accessibilityEventObtain);
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            String strC = melodyColorNumberPicker.f22052q.get(melodyColorNumberPicker.f22004A);
            int scrollX = melodyColorNumberPicker.getScrollX();
            int scrollY = melodyColorNumberPicker.getScrollY();
            int right = (melodyColorNumberPicker.getRight() - melodyColorNumberPicker.getLeft()) + melodyColorNumberPicker.getScrollX();
            int bottom = (melodyColorNumberPicker.getBottom() - melodyColorNumberPicker.getTop()) + melodyColorNumberPicker.getScrollY();
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain.setPackageName(melodyColorNumberPicker.getContext().getPackageName());
            accessibilityNodeInfoObtain.setSource(melodyColorNumberPicker, 0);
            accessibilityNodeInfoObtain.setParent(melodyColorNumberPicker);
            int i11 = MelodyColorNumberPicker.f22003G0;
            if (!TextUtils.isEmpty(null)) {
                strC = C1065d.c(strC, null);
            }
            accessibilityNodeInfoObtain.setText(strC);
            accessibilityNodeInfoObtain.setClickable(true);
            accessibilityNodeInfoObtain.setLongClickable(true);
            accessibilityNodeInfoObtain.setEnabled(melodyColorNumberPicker.isEnabled());
            Rect rect = this.f22072a;
            rect.set(scrollX, scrollY, right, bottom);
            accessibilityNodeInfoObtain.setBoundsInParent(rect);
            int[] iArr = this.f22073b;
            melodyColorNumberPicker.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
            accessibilityNodeInfoObtain.setBoundsInScreen(rect);
            if (this.f22074c != 0) {
                accessibilityNodeInfoObtain.addAction(64);
            }
            if (this.f22074c == 0) {
                accessibilityNodeInfoObtain.addAction(DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
            }
            if (melodyColorNumberPicker.isEnabled()) {
                accessibilityNodeInfoObtain.addAction(16);
            }
            return accessibilityNodeInfoObtain;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            return TextUtils.isEmpty(str) ? Collections.EMPTY_LIST : super.findAccessibilityNodeInfosByText(str, i10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int i10, int i11, Bundle bundle) {
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            if (i10 == -1) {
                if (i11 == 64) {
                    if (this.f22074c == i10) {
                        return false;
                    }
                    this.f22074c = i10;
                    return true;
                }
                if (i11 == 128) {
                    if (this.f22074c != i10) {
                        return false;
                    }
                    this.f22074c = Integer.MIN_VALUE;
                    return true;
                }
                if (i11 == 4096) {
                    if (!melodyColorNumberPicker.isEnabled()) {
                        return false;
                    }
                    int i12 = MelodyColorNumberPicker.f22003G0;
                    melodyColorNumberPicker.a(true);
                    return true;
                }
                if (i11 == 8192) {
                    if (!melodyColorNumberPicker.isEnabled()) {
                        return false;
                    }
                    int i13 = MelodyColorNumberPicker.f22003G0;
                    melodyColorNumberPicker.a(false);
                    return true;
                }
            } else if (i10 == 0) {
                if (i11 == 16) {
                    return melodyColorNumberPicker.isEnabled();
                }
                if (i11 == 64) {
                    if (this.f22074c == i10) {
                        return false;
                    }
                    this.f22074c = i10;
                    a(i10, 32768);
                    melodyColorNumberPicker.invalidate(0, 0, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.f22030V);
                    return true;
                }
                if (i11 == 128) {
                    if (this.f22074c != i10) {
                        return false;
                    }
                    this.f22074c = Integer.MIN_VALUE;
                    a(i10, ArrayPool.STANDARD_BUFFER_SIZE_BYTES);
                    melodyColorNumberPicker.invalidate(0, 0, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.f22030V);
                    return true;
                }
            }
            return super.performAction(i10, i11, bundle);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22076a;

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z2 = this.f22076a;
            int i10 = MelodyColorNumberPicker.f22003G0;
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            melodyColorNumberPicker.a(z2);
            melodyColorNumberPicker.postDelayed(this, melodyColorNumberPicker.f22014F);
        }
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public interface f {
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22079b;

        public g() {
        }

        public final void a() {
            this.f22079b = 0;
            this.f22078a = 0;
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            melodyColorNumberPicker.removeCallbacks(this);
            if (melodyColorNumberPicker.f22035b0) {
                melodyColorNumberPicker.f22035b0 = false;
                melodyColorNumberPicker.invalidate(0, melodyColorNumberPicker.f22031W, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.getBottom());
            }
            melodyColorNumberPicker.f22037c0 = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i10 = this.f22079b;
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            if (i10 == 1) {
                int i11 = this.f22078a;
                if (i11 == 1) {
                    melodyColorNumberPicker.f22035b0 = true;
                    melodyColorNumberPicker.invalidate(0, melodyColorNumberPicker.f22031W, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.getBottom());
                    return;
                } else {
                    if (i11 == 2) {
                        melodyColorNumberPicker.f22037c0 = true;
                        melodyColorNumberPicker.invalidate(0, 0, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.f22030V);
                        return;
                    }
                    return;
                }
            }
            if (i10 != 2) {
                return;
            }
            int i12 = this.f22078a;
            if (i12 == 1) {
                if (!melodyColorNumberPicker.f22035b0) {
                    melodyColorNumberPicker.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                melodyColorNumberPicker.f22035b0 = !melodyColorNumberPicker.f22035b0;
                melodyColorNumberPicker.invalidate(0, melodyColorNumberPicker.f22031W, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.getBottom());
                return;
            }
            if (i12 == 2) {
                if (!melodyColorNumberPicker.f22037c0) {
                    melodyColorNumberPicker.postDelayed(this, ViewConfiguration.getPressedStateDuration());
                }
                melodyColorNumberPicker.f22037c0 = !melodyColorNumberPicker.f22037c0;
                melodyColorNumberPicker.invalidate(0, 0, melodyColorNumberPicker.getRight(), melodyColorNumberPicker.f22030V);
            }
        }
    }

    public class h extends Handler {
        public h(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            MelodyColorNumberPicker melodyColorNumberPicker = MelodyColorNumberPicker.this;
            if (i10 == 0) {
                int i11 = MelodyColorNumberPicker.f22003G0;
                melodyColorNumberPicker.performHapticFeedback(302);
            } else if (i10 == 1) {
                String string = melodyColorNumberPicker.f22052q.get(((Integer) message.obj).intValue());
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                melodyColorNumberPicker.getClass();
                if (!TextUtils.isEmpty(null)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    melodyColorNumberPicker.getClass();
                    sb2.append((String) null);
                    string = sb2.toString();
                }
                melodyColorNumberPicker.announceForAccessibility(string);
            }
            super.handleMessage(message);
        }
    }

    public MelodyColorNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.couiNumberPickerStyle, 0);
        this.f22052q = new SparseArray<>();
        this.f22014F = 300L;
        this.f22017I = Integer.MIN_VALUE;
        this.f22028T = 0;
        this.f22039e0 = -1;
        this.f22013E0 = "";
        this.f22015F0 = "";
        Q1.a.c(this, false);
        context.setTheme(R.style.COUINumberPicker);
        this.f22040f0 = (AccessibilityManager) getContext().getSystemService("accessibility");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1511a.f27747a, R.attr.couiNumberPickerStyle, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(10, 5);
        this.f22043i0 = integer / 2;
        this.f22016G = new int[integer];
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(19, -1);
        this.f22032a = dimensionPixelSize;
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, -1);
        this.f22034b = dimensionPixelSize2;
        if (dimensionPixelSize != -1 && dimensionPixelSize2 != -1 && dimensionPixelSize > dimensionPixelSize2) {
            throw new IllegalArgumentException("minHeight > maxHeight");
        }
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(20, -1);
        this.f22036c = dimensionPixelSize3;
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(18, -1);
        this.f22062v = dimensionPixelSize4;
        if (dimensionPixelSize3 != -1 && dimensionPixelSize4 != -1 && dimensionPixelSize3 > dimensionPixelSize4) {
            throw new IllegalArgumentException("minWidth > maxWidth");
        }
        this.f22061u0 = typedArrayObtainStyledAttributes.getInteger(7, -1);
        this.f22063v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, -1);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(25, -1);
        this.f22050p = dimensionPixelSize5;
        this.f22059t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        this.f22065w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f22067x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        int color = typedArrayObtainStyledAttributes.getColor(5, -1);
        int color2 = typedArrayObtainStyledAttributes.getColor(1, -1);
        this.f22046l0 = Color.alpha(color);
        this.f22051p0 = Color.alpha(color2);
        this.f22047m0 = Color.red(color);
        this.f22053q0 = Color.red(color2);
        this.f22048n0 = Color.green(color);
        this.f22055r0 = Color.green(color2);
        this.f22049o0 = Color.blue(color);
        this.f22057s0 = Color.blue(color2);
        typedArrayObtainStyledAttributes.recycle();
        this.f22007B0 = getResources().getDimension(R.dimen.coui_numberpicker_ignore_bar_width);
        this.f22009C0 = getResources().getDimension(R.dimen.coui_numberpicker_ignore_bar_height);
        this.f22011D0 = getResources().getDimension(R.dimen.coui_numberpicker_ignore_bar_spacing);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f22025Q = viewConfiguration.getScaledTouchSlop();
        this.f22026R = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f22027S = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
        Paint paint = new Paint();
        paint.setTextSize(dimensionPixelSize5);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        paint.setTypeface(Typeface.create("sans-serif-black", 0));
        paint.setFontFeatureSettings("tnum");
        this.f22069y0 = fontMetrics.top;
        this.f22071z0 = fontMetrics.bottom;
        this.f22054r = paint;
        this.f22056s = new Scroller(getContext(), null, true);
        this.f22058t = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f22060u = new g();
        setWillNotDraw(false);
        setVerticalScrollBarEnabled(false);
    }

    public static int f(int i10, int i11) {
        if (i11 != -1) {
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            if (mode == Integer.MIN_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(Math.min(size, i11), 1073741824);
            }
            if (mode == 0) {
                return View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            }
            if (mode != 1073741824) {
                throw new IllegalArgumentException(A6.b.d(mode, "Unknown measure mode: "));
            }
        }
        return i10;
    }

    public final void a(boolean z2) {
        Scroller scroller = this.f22056s;
        if (!g(scroller)) {
            g(this.f22058t);
        }
        this.f22019K = 0;
        if (z2) {
            scroller.startScroll(0, 0, 0, -this.H, 300);
        } else {
            scroller.startScroll(0, 0, 0, this.H, 300);
        }
        invalidate();
    }

    public final void b(int i10) {
        String str;
        SparseArray<String> sparseArray = this.f22052q;
        if (sparseArray.get(i10) != null) {
            return;
        }
        int i11 = this.f22068y;
        if (i10 < i11 || i10 > this.f22070z) {
            str = "";
        } else {
            String[] strArr = this.f22066x;
            str = strArr != null ? strArr[i10 - i11] : String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10));
        }
        sparseArray.put(i10, str);
    }

    public final void c() {
        int i10 = this.f22017I - this.f22018J;
        if (i10 != 0) {
            this.f22019K = 0;
            int iAbs = Math.abs(i10);
            int i11 = this.H;
            if (iAbs > i11 / 2) {
                if (i10 > 0) {
                    i11 = -i11;
                }
                i10 += i11;
            }
            this.f22058t.startScroll(0, 0, 0, i10, 800);
            invalidate();
        }
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller scroller;
        Scroller scroller2 = this.f22056s;
        if (scroller2.isFinished()) {
            scroller = this.f22058t;
            if (scroller.isFinished()) {
                return;
            }
        } else {
            scroller = scroller2;
        }
        scroller.computeScrollOffset();
        int currY = scroller.getCurrY();
        if (this.f22019K == 0) {
            this.f22019K = scroller.getStartY();
        }
        scrollBy(0, currY - this.f22019K);
        this.f22019K = currY;
        if (!scroller.isFinished()) {
            invalidate();
        } else if (scroller == scroller2) {
            c();
            h(0);
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return getHeight();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return this.f22018J;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        return ((this.f22070z - this.f22068y) + 1) * this.H;
    }

    public final int d(int i10, int i11) {
        int i12 = this.f22070z;
        int i13 = this.f22068y;
        if (i12 - i13 <= 0) {
            return -1;
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = i13 - 1;
        }
        int i14 = (i12 - i13) + 1 + (this.f22005A0 ? 1 : 0);
        int i15 = (i10 - i13) + i11;
        int iFloorDiv = i15 - (Math.floorDiv(i15, i14) * i14);
        int i16 = this.f22070z;
        int i17 = this.f22068y;
        if (iFloorDiv < (i16 - i17) + 1) {
            return i17 + iFloorDiv;
        }
        return Integer.MIN_VALUE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f22040f0.isEnabled()) {
            int actionMasked = motionEvent.getActionMasked();
            a aVar = (a) getAccessibilityNodeProvider();
            if (actionMasked == 7) {
                int i10 = this.f22033a0;
                if (i10 != 0 && i10 != -1) {
                    aVar.a(i10, 256);
                    aVar.a(0, DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
                    this.f22033a0 = 0;
                    aVar.performAction(0, 64, null);
                }
            } else if (actionMasked == 9) {
                aVar.a(0, DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE);
                this.f22033a0 = 0;
                aVar.performAction(0, 64, null);
            } else if (actionMasked == 10) {
                aVar.a(0, 256);
                this.f22033a0 = -1;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getKeyCode()
            r1 = 19
            r2 = 20
            if (r0 == r1) goto L19
            if (r0 == r2) goto L19
            r1 = 23
            if (r0 == r1) goto L15
            r1 = 66
            if (r0 == r1) goto L15
            goto L61
        L15:
            r5.i()
            goto L61
        L19:
            int r0 = r6.getKeyCode()
            int r1 = r6.getAction()
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L27
            goto L61
        L27:
            int r1 = r5.f22039e0
            if (r1 != r0) goto L61
            r0 = -1
            r5.f22039e0 = r0
            goto L61
        L2f:
            boolean r1 = r5.f22012E
            if (r1 != 0) goto L4a
            if (r0 != r2) goto L40
            int r1 = r5.getValue()
            int r4 = r5.getMaxValue()
            if (r1 >= r4) goto L61
            goto L4a
        L40:
            int r1 = r5.getValue()
            int r4 = r5.getMinValue()
            if (r1 <= r4) goto L61
        L4a:
            r5.requestFocus()
            r5.f22039e0 = r0
            r5.i()
            android.widget.Scroller r1 = r5.f22056s
            boolean r1 = r1.isFinished()
            if (r1 == 0) goto L61
            if (r0 != r2) goto L5d
            goto L5e
        L5d:
            r3 = 0
        L5e:
            r5.a(r3)
        L61:
            boolean r6 = super.dispatchKeyEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.widget.sound.MelodyColorNumberPicker.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            i();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            i();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    public final void e() {
        this.f22052q.clear();
        int[] iArr = this.f22016G;
        int value = getValue();
        for (int i10 = 0; i10 < this.f22016G.length; i10++) {
            int i11 = i10 - this.f22043i0;
            int iD = this.f22005A0 ? d(value, i11) : i11 + value;
            if (this.f22012E) {
                iD = d(iD, 0);
            }
            iArr[i10] = iD;
            b(iD);
        }
    }

    public final boolean g(Scroller scroller) {
        scroller.forceFinished(true);
        int finalY = scroller.getFinalY() - scroller.getCurrY();
        int i10 = this.f22017I - ((this.f22018J + finalY) % this.H);
        if (i10 == 0) {
            return false;
        }
        int iAbs = Math.abs(i10);
        int i11 = this.H;
        if (iAbs > i11 / 2) {
            i10 = i10 > 0 ? i10 - i11 : i10 + i11;
        }
        scrollBy(0, finalY + i10);
        return true;
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.f22038d0 == null) {
            this.f22038d0 = new a();
        }
        return this.f22038d0;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.9f;
    }

    public String[] getDisplayedValues() {
        return this.f22066x;
    }

    public int getMaxValue() {
        return this.f22070z;
    }

    public int getMinValue() {
        return this.f22068y;
    }

    public float getTextSize() {
        return this.f22054r.getTextSize();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.9f;
    }

    public int getValue() {
        return this.f22004A;
    }

    public boolean getWrapSelectorWheel() {
        return this.f22012E;
    }

    public final void h(int i10) {
        if (this.f22028T == i10) {
            return;
        }
        this.f22028T = i10;
        e eVar = this.f22008C;
        if (eVar != null) {
            ((MelodyNumberPicker) ((C0.a) eVar).f608b).f22093q = i10;
        }
    }

    public final void i() {
        b bVar = this.f22020L;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
        this.f22060u.a();
    }

    public final void j(int i10, boolean z2) {
        int i11;
        if (this.f22004A == i10) {
            e();
            return;
        }
        int iD = this.f22012E ? d(i10, 0) : Math.min(Math.max(i10, this.f22068y), this.f22070z);
        this.f22004A = iD;
        if (z2) {
            f fVar = this.f22006B;
            if (fVar != null) {
                MelodyNumberPicker melodyNumberPicker = (MelodyNumberPicker) ((n) fVar).f817b;
                if (iD == 0) {
                    i11 = -1;
                } else {
                    String str = melodyNumberPicker.f22094r[iD];
                    i11 = str != null ? Integer.parseInt(str) : 0;
                }
                if (iD == 0) {
                    if (melodyNumberPicker.f22090b == 0) {
                        melodyNumberPicker.a(600L);
                        melodyNumberPicker.f22090b = 1;
                    }
                } else if (melodyNumberPicker.f22090b == 1) {
                    melodyNumberPicker.b(600L);
                    melodyNumberPicker.f22090b = 0;
                }
                ListenLimitedTime.f20099a.getClass();
                melodyNumberPicker.f22091c = ListenLimitedTime.a.a(i11);
                melodyNumberPicker.f();
            }
            this.f22042h0.removeMessages(0);
            this.f22042h0.sendEmptyMessage(0);
            AccessibilityManager accessibilityManager = this.f22040f0;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Message message = new Message();
                message.what = 1;
                message.obj = Integer.valueOf(iD);
                this.f22042h0.sendMessage(message);
            }
        }
        e();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        HandlerThread handlerThread = new HandlerThread("touchEffect", -16);
        this.f22041g0 = handlerThread;
        handlerThread.start();
        if (this.f22041g0.getLooper() != null) {
            this.f22042h0 = new h(this.f22041g0.getLooper());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
        HandlerThread handlerThread = this.f22041g0;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f22041g0 = null;
        }
        h hVar = this.f22042h0;
        if (hVar != null) {
            hVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017d  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r30) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.widget.sound.MelodyColorNumberPicker.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || motionEvent.getActionMasked() != 0) {
            return false;
        }
        i();
        float y5 = motionEvent.getY();
        this.f22021M = y5;
        this.f22023O = y5;
        this.f22022N = motionEvent.getEventTime();
        this.f22029U = false;
        float f9 = this.f22021M;
        float f10 = this.f22030V;
        g gVar = this.f22060u;
        if (f9 < f10) {
            if (this.f22028T == 0) {
                gVar.a();
                gVar.f22079b = 1;
                gVar.f22078a = 2;
                MelodyColorNumberPicker.this.postDelayed(gVar, ViewConfiguration.getTapTimeout());
            }
        } else if (f9 > this.f22031W && this.f22028T == 0) {
            gVar.a();
            gVar.f22079b = 1;
            gVar.f22078a = 1;
            MelodyColorNumberPicker.this.postDelayed(gVar, ViewConfiguration.getTapTimeout());
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        Scroller scroller = this.f22056s;
        boolean zIsFinished = scroller.isFinished();
        Scroller scroller2 = this.f22058t;
        if (!zIsFinished) {
            scroller.forceFinished(true);
            scroller2.forceFinished(true);
            h(0);
            return true;
        }
        if (!scroller2.isFinished()) {
            scroller.forceFinished(true);
            scroller2.forceFinished(true);
            return true;
        }
        float f11 = this.f22021M;
        if (f11 < this.f22030V) {
            long longPressTimeout = ViewConfiguration.getLongPressTimeout();
            Runnable runnable = this.f22020L;
            if (runnable == null) {
                this.f22020L = new b();
            } else {
                removeCallbacks(runnable);
            }
            b bVar = this.f22020L;
            bVar.f22076a = false;
            postDelayed(bVar, longPressTimeout);
            return true;
        }
        if (f11 <= this.f22031W) {
            this.f22029U = true;
            return true;
        }
        long longPressTimeout2 = ViewConfiguration.getLongPressTimeout();
        Runnable runnable2 = this.f22020L;
        if (runnable2 == null) {
            this.f22020L = new b();
        } else {
            removeCallbacks(runnable2);
        }
        b bVar2 = this.f22020L;
        bVar2.f22076a = true;
        postDelayed(bVar2, longPressTimeout2);
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i10, int i11, int i12, int i13) {
        if (z2) {
            e();
            int length = this.f22016G.length;
            int i14 = this.f22050p;
            int bottom = (int) ((((((getBottom() - getTop()) - (length * i14)) - getPaddingBottom()) - getPaddingTop()) / r7.length) + 0.5f);
            this.f22064w = bottom;
            this.H = bottom + i14;
            this.f22017I = 0;
            this.f22018J = 0;
            this.f22030V = (getHeight() / 2) - (this.H / 2);
            this.f22031W = (this.H / 2) + (getHeight() / 2);
            setVerticalFadingEdgeEnabled(true);
            setFadingEdgeLength(((((getBottom() - getTop()) - i14) - getPaddingBottom()) - getPaddingTop()) / 2);
        }
        double d10 = this.f22017I;
        double d11 = this.H;
        double d12 = this.f22043i0;
        this.f22044j0 = (int) (((d12 - 0.5d) * d11) + d10);
        this.f22045k0 = (int) (((d12 + 0.5d) * d11) + d10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        super.onMeasure(f(i10, this.f22062v), f(i11, this.f22034b));
        int measuredWidth = getMeasuredWidth();
        int i12 = this.f22036c;
        if (i12 != -1) {
            measuredWidth = View.resolveSizeAndState(Math.max(i12, measuredWidth), i10, 0);
        }
        int i13 = ((this.f22067x0 + this.f22065w0) * 2) + measuredWidth;
        int measuredHeight = getMeasuredHeight();
        int i14 = this.f22032a;
        if (i14 != -1) {
            measuredHeight = View.resolveSizeAndState(Math.max(i14, measuredHeight), i11, 0);
        }
        setMeasuredDimension(i13, measuredHeight);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f22024P == null) {
            this.f22024P = VelocityTracker.obtain();
        }
        this.f22024P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int i10 = this.f22025Q;
        if (actionMasked == 1) {
            b bVar = this.f22020L;
            if (bVar != null) {
                removeCallbacks(bVar);
            }
            this.f22060u.a();
            VelocityTracker velocityTracker = this.f22024P;
            velocityTracker.computeCurrentVelocity(1000, this.f22027S);
            int yVelocity = (int) velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) > this.f22026R) {
                int i11 = yVelocity * 2;
                this.f22019K = 0;
                Scroller scroller = this.f22056s;
                if (i11 > 0) {
                    scroller.fling(0, 0, 0, i11, 0, 0, 0, Integer.MAX_VALUE);
                } else {
                    scroller.fling(0, Integer.MAX_VALUE, 0, i11, 0, 0, 0, Integer.MAX_VALUE);
                }
                invalidate();
                h(2);
            } else {
                int iAbs = (int) Math.abs(((int) motionEvent.getY()) - this.f22021M);
                long eventTime = motionEvent.getEventTime() - this.f22022N;
                if (iAbs > i10 || eventTime >= ViewConfiguration.getTapTimeout()) {
                    c();
                } else {
                    c();
                    if (this.f22029U) {
                        this.f22029U = false;
                        performClick();
                    }
                }
                h(0);
            }
            this.f22024P.recycle();
            this.f22024P = null;
            d dVar = this.f22010D;
            float x10 = motionEvent.getX();
            float y5 = motionEvent.getY();
            Ha.c cVar = (Ha.c) dVar;
            cVar.getClass();
            MelodyColorNumberPicker melodyColorNumberPicker = (MelodyColorNumberPicker) cVar.f2100b;
            if (x10 < melodyColorNumberPicker.getResources().getDimensionPixelOffset(R.dimen.melody_ui_number_picker_click_left) || x10 > melodyColorNumberPicker.getResources().getDimensionPixelOffset(R.dimen.melody_ui_number_picker_click_right) || y5 > melodyColorNumberPicker.getResources().getDimensionPixelOffset(R.dimen.melody_ui_number_picker_click_bottom)) {
                ((MelodyNumberPicker) cVar.f2101c).e();
                return true;
            }
        } else {
            if (actionMasked == 2) {
                float y8 = motionEvent.getY();
                if (this.f22028T == 1) {
                    scrollBy(0, (int) (y8 - this.f22023O));
                    invalidate();
                } else if (((int) Math.abs(y8 - this.f22021M)) > i10) {
                    i();
                    h(1);
                }
                this.f22023O = y8;
                return true;
            }
            if (actionMasked == 3) {
                c();
                return true;
            }
        }
        return true;
    }

    @Override // android.view.View
    public final void scrollBy(int i10, int i11) {
        int i12;
        int[] iArr = this.f22016G;
        int i13 = this.f22018J;
        boolean z2 = this.f22012E;
        if (!z2 && i11 > 0 && iArr[this.f22043i0] <= this.f22068y) {
            this.f22018J = this.f22017I;
            return;
        }
        if (!z2 && i11 < 0 && iArr[this.f22043i0] >= this.f22070z) {
            this.f22018J = this.f22017I;
            return;
        }
        this.f22018J = i11 + i13;
        while (true) {
            int i14 = this.f22018J;
            if (i14 - this.f22017I <= this.f22064w) {
                break;
            }
            this.f22018J = i14 - this.H;
            for (int i15 = 0; i15 < iArr.length; i15++) {
                iArr[i15] = d(iArr[i15], -1);
            }
            b(iArr[0]);
            j(iArr[this.f22043i0], true);
            if (!this.f22012E && iArr[this.f22043i0] <= this.f22068y) {
                this.f22018J = this.f22017I;
            }
        }
        while (true) {
            i12 = this.f22018J;
            if (i12 - this.f22017I >= (-this.f22064w)) {
                break;
            }
            this.f22018J = i12 + this.H;
            for (int i16 = 0; i16 < iArr.length; i16++) {
                iArr[i16] = d(iArr[i16], 1);
            }
            b(iArr[iArr.length - 1]);
            j(iArr[this.f22043i0], true);
            if (!this.f22012E && iArr[this.f22043i0] >= this.f22070z) {
                this.f22018J = this.f22017I;
            }
        }
        if (i13 != i12) {
            onScrollChanged(0, i12, 0, i13);
        }
    }

    public void setAlignPosition(int i10) {
        this.f22061u0 = i10;
    }

    public void setDisplayedValues(String[] strArr) {
        if (this.f22066x == strArr) {
            return;
        }
        this.f22066x = strArr;
        e();
    }

    public void setFormatter(c cVar) {
        if (cVar == null) {
            return;
        }
        e();
    }

    public void setIgnorable(boolean z2) {
        if (this.f22005A0 == z2) {
            return;
        }
        this.f22005A0 = z2;
        e();
        invalidate();
    }

    public void setMaxValue(int i10) {
        if (this.f22070z == i10) {
            return;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("maxValue must be >= 0");
        }
        this.f22070z = i10;
        if (i10 < this.f22004A) {
            this.f22004A = i10;
        }
        e();
        invalidate();
    }

    public void setMinValue(int i10) {
        if (this.f22068y == i10) {
            return;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("minValue must be >= 0");
        }
        this.f22068y = i10;
        if (i10 > this.f22004A) {
            this.f22004A = i10;
        }
        e();
        invalidate();
    }

    public void setOnClickEventXListener(d dVar) {
        this.f22010D = dVar;
    }

    public void setOnLongPressUpdateInterval(long j5) {
        this.f22014F = j5;
    }

    public void setOnScrollListener(e eVar) {
        this.f22008C = eVar;
    }

    public void setOnValueChangedListener(f fVar) {
        this.f22006B = fVar;
    }

    public void setPickerFocusColor(int i10) {
        this.f22051p0 = Color.alpha(i10);
        this.f22053q0 = Color.red(i10);
        this.f22055r0 = Color.green(i10);
        this.f22057s0 = Color.green(i10);
    }

    public void setPickerNormalColor(int i10) {
        this.f22046l0 = Color.alpha(i10);
        this.f22047m0 = Color.red(i10);
        this.f22048n0 = Color.green(i10);
        this.f22049o0 = Color.green(i10);
    }

    public void setPickerRowNumber(int i10) {
        this.f22043i0 = i10 / 2;
        this.f22016G = new int[i10];
    }

    public void setValue(int i10) {
        j(i10, false);
    }

    public void setWrapSelectorWheel(boolean z2) {
        this.f22012E = this.f22070z - this.f22068y >= this.f22016G.length && z2;
    }
}
