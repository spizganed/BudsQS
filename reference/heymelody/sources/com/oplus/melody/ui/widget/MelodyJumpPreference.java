package com.oplus.melody.ui.widget;

import E8.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyJumpPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010 \u001a\u00020!2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\"\u001a\u00020!H\u0014J\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020!2\u0006\u0010$\u001a\u00020\nJ\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020!2\u0006\u0010$\u001a\u00020\nJ\u0010\u0010)\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010\u0019J\u000e\u0010*\u001a\u00020!2\u0006\u0010$\u001a\u00020\nJ\u0010\u0010*\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010\u0019J\b\u0010+\u001a\u00020!H\u0002J\u000e\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\nJ\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\nJ\u0012\u00100\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u001cJ\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u001cH\u0016J\u000e\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\nJ\u0006\u0010<\u001a\u00020\nJ\u0006\u0010=\u001a\u00020!J\u0006\u0010>\u001a\u00020!R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyJumpPreference;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mJumpPrefView", "Landroid/view/View;", "mJumpPrefIcon", "Landroid/widget/ImageView;", "mTextContainer", "mJumpPrefTitle", "Landroid/widget/TextView;", "mJumpPrefSummary", "mJumpUnderSummary", "mJumpPrefNext", "mRedHot", "Lcom/coui/appcompat/reddot/COUIHintRedDot;", "mTitle", "", "mSummary", "mDisabled", "", "mClickableWhenDisabled", "mEndRedDotMode", "mEndRedDotNum", "init", "", "onFinishInflate", "setIcon", "resId", "setShowNext", "visible", "setTitle", "text", "setSummary", "setUnderSummary", "invalidateSummary", "setSummaryColor", "colorResId", "setBackgroundType", SpeechFindManager.TYPE, "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "setDisabled", "disabled", "setAllowClickWhenDisabled", "clickableWhenDisabled", "setEndRedDotMode", "mode", "getEndRedDotMode", "setEndRedDotNum", "num", "getEndRedDotNum", "showEndRedDot", "hideEndRedDot", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyJumpPreference extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f21859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f21860c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f21861p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f21862q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f21863r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f21864s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public COUIHintRedDot f21865t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f21866u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f21867v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f21868w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f21869x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f21870y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f21871z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyJumpPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.f1364b);
            h.d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.f21866u = typedArrayObtainStyledAttributes.getString(1);
            this.f21867v = typedArrayObtainStyledAttributes.getString(0);
            typedArrayObtainStyledAttributes.recycle();
        }
        View.inflate(getContext(), R.layout.melody_ui_jump_preference_view, this);
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f21867v)) {
            View view = this.f21860c;
            if (view == null) {
                h.i("mTextContainer");
                throw null;
            }
            view.setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.melody_ui_jump_pref_single_text_vertical_padding), 0, getContext().getResources().getDimensionPixelSize(R.dimen.melody_ui_jump_pref_single_text_vertical_padding));
            TextView textView = this.f21862q;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            } else {
                h.i("mJumpPrefSummary");
                throw null;
            }
        }
        View view2 = this.f21860c;
        if (view2 == null) {
            h.i("mTextContainer");
            throw null;
        }
        view2.setPadding(0, getContext().getResources().getDimensionPixelSize(R.dimen.melody_ui_jump_pref_multi_text_vertical_padding), 0, getContext().getResources().getDimensionPixelSize(R.dimen.melody_ui_jump_pref_multi_text_vertical_padding));
        TextView textView2 = this.f21862q;
        if (textView2 == null) {
            h.i("mJumpPrefSummary");
            throw null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.f21862q;
        if (textView3 != null) {
            textView3.setText(this.f21867v);
        } else {
            h.i("mJumpPrefSummary");
            throw null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        if (!this.f21868w || this.f21869x) {
            return super.dispatchTouchEvent(ev);
        }
        return false;
    }

    /* JADX INFO: renamed from: getEndRedDotMode, reason: from getter */
    public final int getF21870y() {
        return this.f21870y;
    }

    /* JADX INFO: renamed from: getEndRedDotNum, reason: from getter */
    public final int getF21871z() {
        return this.f21871z;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(R.id.jump_pref);
        h.d(viewFindViewById, "findViewById(...)");
        this.f21858a = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.jump_pref_icon);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f21859b = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.text_container);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f21860c = viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.jump_pref_title);
        h.d(viewFindViewById4, "findViewById(...)");
        this.f21861p = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.jump_pref_summary);
        h.d(viewFindViewById5, "findViewById(...)");
        this.f21862q = (TextView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.jump_under_summary);
        h.d(viewFindViewById6, "findViewById(...)");
        this.f21863r = (TextView) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.jump_pref_next);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f21864s = (ImageView) viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.jump_pref_red_dot);
        h.d(viewFindViewById8, "findViewById(...)");
        this.f21865t = (COUIHintRedDot) viewFindViewById8;
        TextView textView = this.f21861p;
        if (textView == null) {
            h.i("mJumpPrefTitle");
            throw null;
        }
        textView.setText(this.f21866u);
        a();
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
    }

    @Override // android.view.View
    public void setAllowClickWhenDisabled(boolean clickableWhenDisabled) {
        this.f21869x = clickableWhenDisabled;
        super.setAllowClickWhenDisabled(clickableWhenDisabled);
    }

    public final void setBackgroundType(int type) {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        if (type == 1) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(getContext().getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_up_radius));
            dimensionPixelOffset2 = 0;
        } else if (type == 2) {
            dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(getContext().getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_down_radius));
            dimensionPixelOffset = 0;
        } else if (type != 3) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(getContext().getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_all_radius));
        } else {
            setBackground(getContext().getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_no_radius));
            dimensionPixelOffset = 0;
            dimensionPixelOffset2 = 0;
        }
        View view = this.f21858a;
        if (view != null) {
            view.setPadding(0, dimensionPixelOffset, 0, dimensionPixelOffset2);
        } else {
            h.i("mJumpPrefView");
            throw null;
        }
    }

    public final void setDisabled(boolean disabled) {
        this.f21868w = disabled;
        if (disabled) {
            ImageView imageView = this.f21859b;
            if (imageView == null) {
                h.i("mJumpPrefIcon");
                throw null;
            }
            imageView.setAlpha(0.3f);
            TextView textView = this.f21861p;
            if (textView == null) {
                h.i("mJumpPrefTitle");
                throw null;
            }
            textView.setAlpha(0.3f);
            TextView textView2 = this.f21862q;
            if (textView2 == null) {
                h.i("mJumpPrefSummary");
                throw null;
            }
            textView2.setAlpha(0.3f);
            TextView textView3 = this.f21863r;
            if (textView3 == null) {
                h.i("mJumpUnderSummary");
                throw null;
            }
            textView3.setAlpha(0.3f);
            ImageView imageView2 = this.f21864s;
            if (imageView2 != null) {
                imageView2.setAlpha(0.3f);
                return;
            } else {
                h.i("mJumpPrefNext");
                throw null;
            }
        }
        ImageView imageView3 = this.f21859b;
        if (imageView3 == null) {
            h.i("mJumpPrefIcon");
            throw null;
        }
        imageView3.setAlpha(1.0f);
        TextView textView4 = this.f21861p;
        if (textView4 == null) {
            h.i("mJumpPrefTitle");
            throw null;
        }
        textView4.setAlpha(1.0f);
        TextView textView5 = this.f21862q;
        if (textView5 == null) {
            h.i("mJumpPrefSummary");
            throw null;
        }
        textView5.setAlpha(1.0f);
        TextView textView6 = this.f21863r;
        if (textView6 == null) {
            h.i("mJumpUnderSummary");
            throw null;
        }
        textView6.setAlpha(1.0f);
        ImageView imageView4 = this.f21864s;
        if (imageView4 != null) {
            imageView4.setAlpha(1.0f);
        } else {
            h.i("mJumpPrefNext");
            throw null;
        }
    }

    public final void setEndRedDotMode(int mode) {
        this.f21870y = mode;
        COUIHintRedDot cOUIHintRedDot = this.f21865t;
        if (cOUIHintRedDot != null) {
            cOUIHintRedDot.setPointMode(mode);
        } else {
            h.i("mRedHot");
            throw null;
        }
    }

    public final void setEndRedDotNum(int num) {
        this.f21871z = num;
        COUIHintRedDot cOUIHintRedDot = this.f21865t;
        if (cOUIHintRedDot != null) {
            cOUIHintRedDot.setPointNumber(num);
        } else {
            h.i("mRedHot");
            throw null;
        }
    }

    public final void setIcon(int resId) {
        Drawable drawable = getContext().getDrawable(resId);
        if (drawable == null) {
            ImageView imageView = this.f21859b;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            } else {
                h.i("mJumpPrefIcon");
                throw null;
            }
        }
        ImageView imageView2 = this.f21859b;
        if (imageView2 == null) {
            h.i("mJumpPrefIcon");
            throw null;
        }
        imageView2.setImageDrawable(drawable);
        ImageView imageView3 = this.f21859b;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        } else {
            h.i("mJumpPrefIcon");
            throw null;
        }
    }

    public final void setShowNext(boolean visible) {
        ImageView imageView = this.f21864s;
        if (imageView != null) {
            imageView.setVisibility(visible ? 0 : 8);
        } else {
            h.i("mJumpPrefNext");
            throw null;
        }
    }

    public final void setSummary(int resId) {
        this.f21867v = getContext().getString(resId);
        a();
    }

    public final void setSummaryColor(int colorResId) {
        TextView textView = this.f21862q;
        if (textView != null) {
            textView.setTextColor(colorResId);
        } else {
            h.i("mJumpPrefSummary");
            throw null;
        }
    }

    public final void setTitle(int resId) {
        String string = getContext().getString(resId);
        this.f21866u = string;
        TextView textView = this.f21861p;
        if (textView != null) {
            textView.setText(string);
        } else {
            h.i("mJumpPrefTitle");
            throw null;
        }
    }

    public final void setUnderSummary(int resId) {
        String string = getContext().getString(resId);
        h.d(string, "getString(...)");
        if (TextUtils.isEmpty(string)) {
            TextView textView = this.f21863r;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            } else {
                h.i("mJumpUnderSummary");
                throw null;
            }
        }
        TextView textView2 = this.f21863r;
        if (textView2 == null) {
            h.i("mJumpUnderSummary");
            throw null;
        }
        textView2.setVisibility(0);
        TextView textView3 = this.f21863r;
        if (textView3 != null) {
            textView3.setText(string);
        } else {
            h.i("mJumpUnderSummary");
            throw null;
        }
    }

    public final void setSummary(String text) {
        this.f21867v = text;
        a();
    }

    public final void setTitle(String text) {
        h.e(text, "text");
        this.f21866u = text;
        TextView textView = this.f21861p;
        if (textView != null) {
            textView.setText(text);
        } else {
            h.i("mJumpPrefTitle");
            throw null;
        }
    }

    public final void setUnderSummary(String text) {
        if (TextUtils.isEmpty(text)) {
            TextView textView = this.f21863r;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            } else {
                h.i("mJumpUnderSummary");
                throw null;
            }
        }
        TextView textView2 = this.f21863r;
        if (textView2 != null) {
            textView2.setVisibility(0);
            TextView textView3 = this.f21863r;
            if (textView3 != null) {
                textView3.setText(text);
                return;
            } else {
                h.i("mJumpUnderSummary");
                throw null;
            }
        }
        h.i("mJumpUnderSummary");
        throw null;
    }
}
