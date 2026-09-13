package com.oplus.melody.ui.widget;

import Jb.l;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyUiTipsSwitchPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0006\u0010 \u001a\u00020\u0010J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u001eJ\b\u0010'\u001a\u00020\u0010H\u0014J\u000e\u0010(\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\nJ\u0018\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0016H\u0002R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyUiTipsSwitchPreference;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "initDoneCallback", "Lkotlin/Function0;", "", "getInitDoneCallback", "()Lkotlin/jvm/functions/Function0;", "setInitDoneCallback", "(Lkotlin/jvm/functions/Function0;)V", "disabled", "", "Ljava/lang/Boolean;", "allowClickWhenDisabled", "tagIconResId", "Ljava/lang/Integer;", "tipsView", "Landroid/widget/ImageView;", "tipsViewListener", "Landroid/view/View$OnClickListener;", "allowTipsViewClickWhenDisabled", "init", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "getTipsView", "setTipsViewClickListener", "listener", "onClick", "setDisabled", "setAllowClickWhenDisabled", "setTagIcon", "resId", "setEnabledStateOnViews", "v", "Landroid/view/View;", "enabled", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MelodyUiTipsSwitchPreference extends COUISwitchPreference {
    private boolean allowClickWhenDisabled;
    private boolean allowTipsViewClickWhenDisabled;
    private Boolean disabled;
    private Wb.a<l> initDoneCallback;
    private Integer tagIconResId;
    private ImageView tipsView;
    private View.OnClickListener tipsViewListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiTipsSwitchPreference(Context context) {
        super(context);
        h.e(context, "context");
        init();
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

    public final Wb.a<l> getInitDoneCallback() {
        return this.initDoneCallback;
    }

    public final ImageView getTipsView() {
        return this.tipsView;
    }

    public final void init() {
        setLayoutResource(R.layout.melody_ui_preference_switch_with_tips);
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(m holder) {
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView;
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View itemView = holder.itemView;
        h.d(itemView, "itemView");
        View viewFindViewById = holder.itemView.findViewById(R.id.tips_view);
        ImageView imageView2 = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
        this.tipsView = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.tipsViewListener);
        }
        if (this.disabled != null) {
            setEnabledStateOnViews(itemView, !h.a(r1, Boolean.TRUE));
            if (this.allowClickWhenDisabled) {
                itemView.setEnabled(true);
            }
            if (this.allowTipsViewClickWhenDisabled && (imageView = this.tipsView) != null) {
                imageView.setEnabled(true);
            }
        }
        Integer num = this.tagIconResId;
        if (num != null) {
            Drawable drawableM = d.m(getContext(), num.intValue());
            if (h.a(this.disabled, Boolean.TRUE)) {
                if (drawableM != null) {
                    drawableM.mutate();
                }
                if (drawableM != null) {
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.setScale(1.0f, 1.0f, 1.0f, 0.3f);
                    drawableM.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                }
            }
            TextView textView = (TextView) holder.itemView.findViewById(android.R.id.title);
            if (textView != null && (layoutParams = textView.getLayoutParams()) != null) {
                layoutParams.width = -2;
            }
            if (textView != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawableM, (Drawable) null);
            }
            if (textView != null) {
                textView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_preference_tag_margin_start));
            }
        }
        Wb.a<l> aVar = this.initDoneCallback;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        Boolean bool = this.disabled;
        if (bool == null || !bool.booleanValue()) {
            super.onClick();
        }
    }

    public final void setAllowClickWhenDisabled(boolean allowClickWhenDisabled) {
        this.allowClickWhenDisabled = allowClickWhenDisabled;
        notifyChanged();
    }

    public final void setDisabled(boolean disabled) {
        this.disabled = Boolean.valueOf(disabled);
        notifyChanged();
    }

    public final void setInitDoneCallback(Wb.a<l> aVar) {
        this.initDoneCallback = aVar;
    }

    public final void setTagIcon(int resId) {
        this.tagIconResId = Integer.valueOf(resId);
        notifyChanged();
    }

    public final void setTipsViewClickListener(View.OnClickListener listener) {
        this.tipsViewListener = listener;
        this.allowTipsViewClickWhenDisabled = listener != null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiTipsSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiTipsSwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiTipsSwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        init();
    }
}
