package com.oplus.melody.ui.widget;

import E9.o;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import t8.s;

/* JADX INFO: compiled from: MelodyUiCOUIJumpPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000fJ\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/coui/appcompat/preference/COUIJumpPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIsHideJumpView", "", "mDisabled", "Ljava/lang/Boolean;", "mAllowClickWhenDisabled", "mClickViewId", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "hideJumpView", "hide", "setDisabled", "disabled", "setAllowClickWhenDisabled", "allowClickWhenDisabled", "setEnabledStateOnViews", "v", "Landroid/view/View;", "enabled", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MelodyUiCOUIJumpPreference extends COUIJumpPreference {
    private boolean mAllowClickWhenDisabled;
    private final int mClickViewId;
    private Boolean mDisabled;
    private boolean mIsHideJumpView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUIJumpPreference(Context context) {
        super(context);
        h.e(context, "context");
        this.mClickViewId = View.generateViewId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MelodyUiCOUIJumpPreference melodyUiCOUIJumpPreference, View view) {
        if (s.a(melodyUiCOUIJumpPreference.mClickViewId)) {
            return;
        }
        melodyUiCOUIJumpPreference.performClick();
    }

    private final void setEnabledStateOnViews(View v5, boolean enabled) {
        v5.setEnabled(enabled);
        if (!(v5 instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) v5;
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                return;
            }
            View childAt = viewGroup.getChildAt(childCount);
            h.d(childAt, "getChildAt(...)");
            setEnabledStateOnViews(childAt, enabled);
        }
    }

    public final void hideJumpView(boolean hide) {
        this.mIsHideJumpView = hide;
        notifyChanged();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    @SuppressLint({"RestrictedApi"})
    public void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.coui_preference_widget_jump);
        if (viewA != null) {
            viewA.setVisibility(this.mIsHideJumpView ? 8 : 0);
        }
        Boolean bool = this.mDisabled;
        View itemView = holder.itemView;
        h.d(itemView, "itemView");
        itemView.setOnClickListener(new o(this, 1));
        if (bool != null) {
            setEnabledStateOnViews(itemView, !bool.booleanValue());
            if (this.mAllowClickWhenDisabled) {
                itemView.setEnabled(true);
            }
        }
    }

    public final void setAllowClickWhenDisabled(boolean allowClickWhenDisabled) {
        this.mAllowClickWhenDisabled = allowClickWhenDisabled;
        notifyChanged();
    }

    public final void setDisabled(boolean disabled) {
        this.mDisabled = Boolean.valueOf(disabled);
        notifyChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUIJumpPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.mClickViewId = View.generateViewId();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUIJumpPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        this.mClickViewId = View.generateViewId();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUIJumpPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        this.mClickViewId = View.generateViewId();
    }
}
