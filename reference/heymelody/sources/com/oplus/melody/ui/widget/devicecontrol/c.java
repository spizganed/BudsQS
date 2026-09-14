package com.oplus.melody.ui.widget.devicecontrol;

import A9.k;
import D7.C0373g;
import E9.t;
import Ea.F;
import Ea.M;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import kotlin.jvm.internal.h;
import s6.C1506a;

/* JADX INFO: compiled from: NormalModeButton.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f21995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f21996c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ProgressBar f21997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f21998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f21999r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f22000s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Boolean f22001t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f22002u;

    /* JADX INFO: compiled from: NormalModeButton.kt */
    public interface a {
        void a(boolean z2);
    }

    public c(Context context) {
        super(context);
        View.inflate(getContext(), R.layout.melody_ui_normal_mode_button, this);
        View viewFindViewById = findViewById(R.id.image);
        h.d(viewFindViewById, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById;
        this.f21995b = imageView;
        View viewFindViewById2 = findViewById(R.id.mode_name);
        h.d(viewFindViewById2, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById2;
        this.f21996c = textView;
        View viewFindViewById3 = findViewById(R.id.progress);
        h.d(viewFindViewById3, "findViewById(...)");
        this.f21997p = (ProgressBar) viewFindViewById3;
        Context context2 = getContext();
        h.d(context2, "getContext(...)");
        float f9 = context2.getResources().getConfiguration().fontScale;
        float f10 = 12.0f / f9;
        float f11 = C1506a.f27731a[3];
        textView.setTextSize(f9 > f11 ? f10 * f11 : f10 * f9);
        imageView.setOnClickListener(new F(this, 2));
    }

    public final void d() {
        boolean zE = C0373g.e();
        ImageView imageView = this.f21995b;
        if (!zE || this.f22002u) {
            imageView.setBackgroundResource(R.drawable.melody_ui_mode_button_bg);
        } else {
            imageView.setBackgroundResource(R.drawable.melody_ui_mode_button_bg_new);
        }
        imageView.setImageDrawable(null);
        this.f21997p.setVisibility(0);
        imageView.setBackgroundTintList(null);
    }

    public final void e(Boolean bool, boolean z2) {
        Drawable drawable = this.f21999r;
        ImageView imageView = this.f21995b;
        imageView.setImageDrawable(drawable);
        boolean zA = h.a(bool, Boolean.TRUE);
        TextView textView = this.f21996c;
        if (zA) {
            imageView.setBackgroundResource(R.drawable.melody_ui_iot_mode_button_bg_selected);
            imageView.setImageTintList(ColorStateList.valueOf(-1));
            Integer num = this.f22000s;
            imageView.setBackgroundTintList(num != null ? ColorStateList.valueOf(num.intValue()) : null);
            if (z2) {
                imageView.post(new t(this, 5));
            }
            if (C0373g.e()) {
                textView.setTextColor(P1.a.b(getContext(), R.attr.couiColorLabelPrimary, 0));
                return;
            }
            return;
        }
        if (!C0373g.e() || this.f22002u) {
            imageView.setBackgroundResource(R.drawable.melody_ui_mode_button_bg);
        } else {
            imageView.setBackgroundResource(R.drawable.melody_ui_mode_button_bg_new);
            textView.setTextColor(P1.a.b(getContext(), R.attr.couiColorLabelSecondary, 0));
        }
        imageView.setBackgroundTintList(null);
        imageView.setImageTintList(ColorStateList.valueOf(getContext().getColor(R.color.melody_ui_iot_mode_button_icon_normal_tint)));
        if (z2) {
            imageView.post(new k(this, 9));
        }
    }

    public final CharSequence getName() {
        return this.f21996c.getText();
    }

    public final TextView getNameTv() {
        return this.f21996c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        isEnabled();
        return false;
    }

    public final void setEnableState(boolean z2) {
        if (isEnabled() == z2) {
            return;
        }
        setEnabled(z2);
    }

    public final void setIcon(int i10) {
        Drawable drawable = getContext().getDrawable(i10);
        if (drawable != null) {
            setIcon(drawable);
        }
    }

    public final void setListener(a listener) {
        h.e(listener, "listener");
        this.f21998q = listener;
    }

    public final void setLoadingState(boolean z2) {
        if (this.f21994a == z2) {
            A.b("UDeviceNormalModeButton", "current loading state is same");
            return;
        }
        this.f21994a = z2;
        if (z2) {
            d();
        } else {
            this.f21997p.setVisibility(8);
            e(this.f22001t, false);
        }
    }

    public final void setName(String name) {
        h.e(name, "name");
        this.f21996c.setText(name);
        this.f21995b.setContentDescription(name);
    }

    public final void setSelect(boolean z2) {
        this.f21996c.setSelected(z2);
    }

    public final void setSelectedColor(int i10) {
        this.f22000s = Integer.valueOf(i10);
        A.c("UDeviceNormalModeButton", new M(this, i10, 1));
        if (!h.a(this.f22001t, Boolean.TRUE) || this.f21994a) {
            return;
        }
        Integer num = this.f22000s;
        this.f21995b.setBackgroundTintList(num != null ? ColorStateList.valueOf(num.intValue()) : null);
    }

    public final void setShowGrayBg(boolean z2) {
        this.f22002u = z2;
    }

    public final void setIcon(Drawable drawable) {
        h.e(drawable, "drawable");
        this.f21999r = drawable;
        this.f21995b.setImageDrawable(drawable);
    }
}
