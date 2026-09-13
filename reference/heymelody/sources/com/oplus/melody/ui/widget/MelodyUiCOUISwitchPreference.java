package com.oplus.melody.ui.widget;

import android.R;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.drs.core.d;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyUiCOUISwitchPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000fJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000fJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\nJ\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000fH\u0002R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006&"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyUiCOUISwitchPreference;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mDisabled", "", "Ljava/lang/Boolean;", "mAllowClickWhenDisabled", "mSummaryTextColor", "Ljava/lang/Integer;", "mTagIconResId", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "onClick", "setDisabled", "disabled", "setAllowClickWhenDisabled", "allowClickWhenDisabled", "setSummaryTextColor", "color", "setTagIcon", "resId", "setEnabledStateOnViews", "v", "Landroid/view/View;", "enabled", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MelodyUiCOUISwitchPreference extends COUISwitchPreference {
    private boolean mAllowClickWhenDisabled;
    private Boolean mDisabled;
    private Integer mSummaryTextColor;
    private Integer mTagIconResId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUISwitchPreference(Context context) {
        super(context);
        h.e(context, "context");
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

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(m holder) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView;
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        Boolean bool = this.mDisabled;
        View itemView = holder.itemView;
        h.d(itemView, "itemView");
        if (bool != null) {
            setEnabledStateOnViews(itemView, !bool.booleanValue());
            if (this.mAllowClickWhenDisabled) {
                itemView.setEnabled(true);
            }
        }
        Integer num = this.mSummaryTextColor;
        if (num != null) {
            int iIntValue = num.intValue();
            View view = holder.itemView;
            if (view != null && (textView = (TextView) view.findViewById(R.id.summary)) != null) {
                textView.setTextColor(iIntValue);
            }
        }
        Integer num2 = this.mTagIconResId;
        if (num2 != null) {
            Drawable drawableM = d.m(getContext(), num2.intValue());
            if (h.a(this.mDisabled, Boolean.TRUE)) {
                if (drawableM != null) {
                    drawableM.mutate();
                }
                if (drawableM != null) {
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.setScale(1.0f, 1.0f, 1.0f, 0.3f);
                    drawableM.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                }
            }
            View view2 = holder.itemView;
            TextView textView2 = view2 != null ? (TextView) view2.findViewById(R.id.title) : null;
            if (textView2 != null && (layoutParams = textView2.getLayoutParams()) != null) {
                layoutParams.width = -2;
            }
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawableM, (Drawable) null);
            }
            if (textView2 != null) {
                textView2.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(com.heytap.headset.R.dimen.melody_ui_custom_eq_preference_tag_margin_start));
            }
        }
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        Boolean bool = this.mDisabled;
        if (bool == null || !bool.booleanValue()) {
            super.onClick();
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

    public final void setSummaryTextColor(int color) {
        this.mSummaryTextColor = Integer.valueOf(color);
        notifyChanged();
    }

    public final void setTagIcon(int resId) {
        this.mTagIconResId = Integer.valueOf(resId);
        notifyChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUISwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUISwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiCOUISwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
    }
}
