package com.oplus.melody.ui.widget;

import D7.C0373g;
import E8.b;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.common.util.C0906l;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyBatteryViews.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020!H\u0002J@\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0016\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u001eJ\u0006\u00103\u001a\u00020,R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u00065"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyBatteryViews;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mStyle", "", "mBoxInfoLayout", "mBoxIcon", "Landroid/widget/ImageView;", "mBoxBatteryValueTx", "Landroid/widget/TextView;", "mBoxChargingImg", "mBoxProgressIcon", "Landroid/widget/ProgressBar;", "mLeftInfoLayout", "mLeftIcon", "mLeftBatteryValueTx", "mLeftChargingImg", "mLeftProgressIcon", "mRightInfoLayout", "mRightIcon", "mRightBatteryValueTx", "mRightChargingImg", "mRightProgressIcon", "mBatteryValueTextSize", "", "Ljava/lang/Float;", "onFinishInflate", "", "initView", "updateBatteryView", "batteryLayout", "Landroid/view/View;", "batteryValueTx", "chargingImg", "progressIcon", "batteryValue", "", "isCharging", "", "updateBatteryInfo", "address", "batteryInfoVO", "Lcom/oplus/melody/ui/component/detail/batteryinfo/BatteryInfoVO;", "updateBatteryValueTextSize", "size", "isEmpty", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyBatteryViews extends LinearLayout {

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final /* synthetic */ int f21759C = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ImageView f21760A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ProgressBar f21761B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f21763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f21764c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f21765p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f21766q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ProgressBar f21767r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LinearLayout f21768s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageView f21769t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f21770u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageView f21771v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ProgressBar f21772w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public LinearLayout f21773x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f21774y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f21775z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyBatteryViews(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f21762a = "detailMain";
        View.inflate(getContext(), R.layout.melody_ui_battery_views_layout, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1363a, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(0);
        this.f21762a = string != null ? string : "detailMain";
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(View view, TextView textView, ImageView imageView, ProgressBar progressBar, int i10, boolean z2) {
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
        if (i10 <= 0) {
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        if (z2) {
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (i10 > 20) {
            if (progressBar != null) {
                progressBar.setVisibility(8);
                return;
            }
            return;
        }
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        if (progressBar != null) {
            progressBar.setProgress(i10);
        }
        if (progressBar != null) {
            progressBar.setProgressTintList(ColorStateList.valueOf(getContext().getColor(R.color.melody_ui_iot_link_progress_red)));
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        int iB;
        Drawable drawableM;
        Drawable drawableM2;
        super.onFinishInflate();
        this.f21763b = (LinearLayout) findViewById(R.id.box_info_layout);
        this.f21764c = (ImageView) findViewById(R.id.box_icon);
        this.f21765p = (TextView) findViewById(R.id.box_battery_value);
        this.f21766q = (ImageView) findViewById(R.id.box_charging_img);
        this.f21767r = (ProgressBar) findViewById(R.id.box_progress_icon);
        this.f21768s = (LinearLayout) findViewById(R.id.left_info_layout);
        this.f21769t = (ImageView) findViewById(R.id.left_icon);
        this.f21770u = (TextView) findViewById(R.id.left_battery_value);
        this.f21771v = (ImageView) findViewById(R.id.left_charging_img);
        this.f21772w = (ProgressBar) findViewById(R.id.left_progress_icon);
        this.f21773x = (LinearLayout) findViewById(R.id.right_info_layout);
        this.f21774y = (ImageView) findViewById(R.id.right_icon);
        this.f21775z = (TextView) findViewById(R.id.right_battery_value);
        this.f21760A = (ImageView) findViewById(R.id.right_charging_img);
        this.f21761B = (ProgressBar) findViewById(R.id.right_progress_icon);
        if (h.a(this.f21762a, "detailMain")) {
            ImageView imageView = this.f21764c;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.melody_ui_battery_box_icon_black);
            }
            if (C0373g.e()) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    h.i("context");
                    throw null;
                }
                drawableM2 = d.m(heyMelodyApplication, R.drawable.melody_ui_battery_icon_outline_red);
            } else {
                HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
                if (heyMelodyApplication2 == null) {
                    h.i("context");
                    throw null;
                }
                drawableM2 = d.m(heyMelodyApplication2, R.drawable.melody_ui_battery_icon_outline_black);
            }
            ProgressBar progressBar = this.f21767r;
            if (progressBar != null) {
                progressBar.setForeground(drawableM2);
            }
            ImageView imageView2 = this.f21769t;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.melody_ui_battery_left_icon_black);
            }
            ProgressBar progressBar2 = this.f21772w;
            if (progressBar2 != null) {
                progressBar2.setForeground(drawableM2);
            }
            ImageView imageView3 = this.f21774y;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.melody_ui_battery_right_icon_black);
            }
            ProgressBar progressBar3 = this.f21761B;
            if (progressBar3 != null) {
                progressBar3.setForeground(drawableM2);
            }
            int iB2 = P1.a.b(getContext(), R.attr.couiColorLabelPrimary, 0);
            TextView textView = this.f21765p;
            if (textView != null) {
                textView.setTextColor(iB2);
            }
            TextView textView2 = this.f21770u;
            if (textView2 != null) {
                textView2.setTextColor(iB2);
            }
            TextView textView3 = this.f21775z;
            if (textView3 != null) {
                textView3.setTextColor(iB2);
            }
            TextView textView4 = this.f21765p;
            if (textView4 != null) {
                textView4.setTextSize(1, 12.0f);
            }
            TextView textView5 = this.f21770u;
            if (textView5 != null) {
                textView5.setTextSize(1, 12.0f);
            }
            TextView textView6 = this.f21775z;
            if (textView6 != null) {
                textView6.setTextSize(1, 12.0f);
                return;
            }
            return;
        }
        if (h.a(this.f21762a, "oneSpace")) {
            if (C0373g.e()) {
                iB = P1.a.b(getContext(), R.attr.couiColorLabelPrimary, 0);
                HeyMelodyApplication heyMelodyApplication3 = C0906l.f19501a;
                if (heyMelodyApplication3 == null) {
                    h.i("context");
                    throw null;
                }
                drawableM = d.m(heyMelodyApplication3, R.drawable.melody_ui_battery_icon_outline_red);
                ImageView imageView4 = this.f21764c;
                if (imageView4 != null) {
                    imageView4.setImageResource(R.drawable.melody_ui_battery_box_icon_black);
                }
                ImageView imageView5 = this.f21769t;
                if (imageView5 != null) {
                    imageView5.setImageResource(R.drawable.melody_ui_battery_left_icon_black);
                }
                ImageView imageView6 = this.f21774y;
                if (imageView6 != null) {
                    imageView6.setImageResource(R.drawable.melody_ui_battery_right_icon_black);
                }
            } else {
                iB = P1.a.b(getContext(), R.attr.couiColorLabelSecondary, 0);
                HeyMelodyApplication heyMelodyApplication4 = C0906l.f19501a;
                if (heyMelodyApplication4 == null) {
                    h.i("context");
                    throw null;
                }
                drawableM = d.m(heyMelodyApplication4, R.drawable.melody_ui_battery_icon_outline_grey);
                ImageView imageView7 = this.f21764c;
                if (imageView7 != null) {
                    imageView7.setImageResource(R.drawable.melody_ui_battery_box_icon_grey);
                }
                ImageView imageView8 = this.f21769t;
                if (imageView8 != null) {
                    imageView8.setImageResource(R.drawable.melody_ui_battery_left_icon_grey);
                }
                ImageView imageView9 = this.f21774y;
                if (imageView9 != null) {
                    imageView9.setImageResource(R.drawable.melody_ui_battery_right_icon_grey);
                }
            }
            ProgressBar progressBar4 = this.f21767r;
            if (progressBar4 != null) {
                progressBar4.setForeground(drawableM);
            }
            ProgressBar progressBar5 = this.f21772w;
            if (progressBar5 != null) {
                progressBar5.setForeground(drawableM);
            }
            ProgressBar progressBar6 = this.f21761B;
            if (progressBar6 != null) {
                progressBar6.setForeground(drawableM);
            }
            TextView textView7 = this.f21765p;
            if (textView7 != null) {
                textView7.setTextColor(iB);
            }
            TextView textView8 = this.f21770u;
            if (textView8 != null) {
                textView8.setTextColor(iB);
            }
            TextView textView9 = this.f21775z;
            if (textView9 != null) {
                textView9.setTextColor(iB);
            }
            TextView textView10 = this.f21765p;
            if (textView10 != null) {
                textView10.setTextSize(1, 14.0f);
            }
            TextView textView11 = this.f21770u;
            if (textView11 != null) {
                textView11.setTextSize(1, 14.0f);
            }
            TextView textView12 = this.f21775z;
            if (textView12 != null) {
                textView12.setTextSize(1, 14.0f);
            }
        }
    }
}
