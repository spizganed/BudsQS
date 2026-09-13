package com.oplus.melody.ui.component.detail.headmotion;

import E9.o;
import Ea.E;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUISwitchPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeadMotionSwitchWithTryPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/ui/component/detail/headmotion/HeadMotionSwitchWithTryPreference;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "tryLink", "Landroid/widget/TextView;", "onTryClickListener", "Landroid/view/View$OnClickListener;", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "setOnTryClickListener", "listener", "setEnabled", "enabled", "", "updateTryLinkState", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadMotionSwitchWithTryPreference extends COUISwitchPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f21050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f21051b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadMotionSwitchWithTryPreference(Context context) {
        this(context, null);
        h.e(context, "context");
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.widget_frame);
        if (viewA != null) {
            viewA.setVisibility(0);
        }
        View viewA2 = holder.a(com.heytap.headset.R.id.head_motion_try_link);
        TextView textView = viewA2 instanceof TextView ? (TextView) viewA2 : null;
        this.f21050a = textView;
        if (textView != null) {
            textView.setText(com.heytap.headset.R.string.melody_ui_head_motion_try_title);
            textView.setOnClickListener(new E(this, 20));
        }
        boolean zIsEnabled = isEnabled();
        TextView textView2 = this.f21050a;
        if (textView2 != null) {
            textView2.setEnabled(zIsEnabled);
            textView2.setClickable(zIsEnabled);
            textView2.setAlpha(zIsEnabled ? 1.0f : 0.38f);
        }
    }

    @Override // androidx.preference.Preference
    public final void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        TextView textView = this.f21050a;
        if (textView != null) {
            textView.setEnabled(enabled);
            textView.setClickable(enabled);
            textView.setAlpha(enabled ? 1.0f : 0.38f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadMotionSwitchWithTryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        h.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadMotionSwitchWithTryPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        h.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadMotionSwitchWithTryPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        setLayoutResource(com.heytap.headset.R.layout.melody_ui_head_motion_switch_try_preference);
        setSelectable(true);
    }
}
