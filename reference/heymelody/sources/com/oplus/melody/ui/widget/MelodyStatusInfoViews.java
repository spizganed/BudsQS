package com.oplus.melody.ui.widget;

import E8.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyStatusInfoViews.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyStatusInfoViews;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mStyle", "", "mBatteryViews", "Lcom/oplus/melody/ui/widget/MelodyBatteryViews;", "mDisconnectStateTv", "Landroid/widget/TextView;", "mSameAccountViewGroup", "Landroid/view/View;", "mDividerView", "inflateLayout", "", "onFinishInflate", "initView", "updateViews", "address", "batteryInfoVO", "Lcom/oplus/melody/ui/component/detail/batteryinfo/BatteryInfoVO;", "updateSameAccountViewGroup", "isShow", "", "updateBatteryValueTextSize", "size", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyStatusInfoViews extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MelodyBatteryViews f21920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f21921c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f21922p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f21923q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyStatusInfoViews(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f21919a = "portLayout";
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1366d, 0, 0);
        String string = typedArrayObtainStyledAttributes.getString(0);
        String str = string != null ? string : "portLayout";
        this.f21919a = str;
        typedArrayObtainStyledAttributes.recycle();
        if (h.a(str, "landLayout")) {
            View.inflate(getContext(), R.layout.melody_ui_status_info_views_land, this);
        } else {
            View.inflate(getContext(), R.layout.melody_ui_status_info_views, this);
        }
    }

    public final void a(boolean z2) {
        View view = this.f21922p;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f21920b = (MelodyBatteryViews) findViewById(R.id.device_battery_view);
        this.f21921c = (TextView) findViewById(R.id.disconnect_state_tv);
        this.f21922p = findViewById(R.id.same_account_group);
        this.f21923q = findViewById(R.id.divider);
    }
}
