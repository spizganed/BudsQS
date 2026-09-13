package com.oplus.melody.ui.widget;

import Ea.F;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyUiJumpSwitchPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u000fJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u000fJ\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000fH\u0002R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyUiJumpSwitchPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mDisabled", "", "Ljava/lang/Boolean;", "mAllowClickWhenDisabled", "mIsSwitch", "mChecked", "mCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "init", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setChecked", "checked", "isChecked", "isSwitch", "setSwitch", "mSwitchClickListener", "Landroid/view/View$OnClickListener;", "setOnSwitchChangeListener", "onCheckedChangeListener", "setDisabled", "disabled", "setAllowClickWhenDisabled", "allowClickWhenDisabled", "setEnabledStateOnViews", "v", "Landroid/view/View;", "enabled", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MelodyUiJumpSwitchPreference extends COUIPreference {
    private boolean mAllowClickWhenDisabled;
    private boolean mChecked;
    private CompoundButton.OnCheckedChangeListener mCheckedChangeListener;
    private Boolean mDisabled;
    private boolean mIsSwitch;
    private final View.OnClickListener mSwitchClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiJumpSwitchPreference(Context context) {
        super(context);
        h.e(context, "context");
        this.mSwitchClickListener = new F(this, 0);
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSwitchClickListener$lambda$0(MelodyUiJumpSwitchPreference melodyUiJumpSwitchPreference, View view) {
        melodyUiJumpSwitchPreference.mChecked = !melodyUiJumpSwitchPreference.mChecked;
        melodyUiJumpSwitchPreference.notifyChanged();
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

    public final void init() {
        setWidgetLayoutResource(R.layout.melody_ui_preference_widget_switch_jump);
    }

    /* JADX INFO: renamed from: isChecked, reason: from getter */
    public final boolean getMChecked() {
        return this.mChecked;
    }

    /* JADX INFO: renamed from: isSwitch, reason: from getter */
    public final boolean getMIsSwitch() {
        return this.mIsSwitch;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(m holder) {
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
        View viewA = holder.a(R.id.melody_ui_preference_widget_switch_container);
        View viewA2 = holder.a(R.id.coui_preference_widget_jump);
        View viewA3 = holder.a(android.R.id.switch_widget);
        SwitchCompat switchCompat = viewA3 instanceof SwitchCompat ? (SwitchCompat) viewA3 : null;
        if (viewA != null) {
            viewA.setVisibility(this.mIsSwitch ? 0 : 8);
        }
        if (viewA2 != null) {
            viewA2.setVisibility(this.mIsSwitch ? 8 : 0);
        }
        if (!this.mIsSwitch) {
            ImageView imageView = viewA2 instanceof ImageView ? (ImageView) viewA2 : null;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.coui_btn_next);
            }
        }
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(null);
        }
        if (switchCompat != null) {
            switchCompat.setChecked(this.mChecked);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mCheckedChangeListener;
        if (onCheckedChangeListener != null && switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(onCheckedChangeListener);
        }
        if (switchCompat != null) {
            switchCompat.setOnClickListener(this.mSwitchClickListener);
        }
    }

    public final void setAllowClickWhenDisabled(boolean allowClickWhenDisabled) {
        this.mAllowClickWhenDisabled = allowClickWhenDisabled;
        notifyChanged();
    }

    public final void setChecked(boolean checked) {
        this.mChecked = checked;
        notifyChanged();
    }

    public final void setDisabled(boolean disabled) {
        this.mDisabled = Boolean.valueOf(disabled);
        notifyChanged();
    }

    public final void setOnSwitchChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        h.e(onCheckedChangeListener, "onCheckedChangeListener");
        this.mCheckedChangeListener = onCheckedChangeListener;
        notifyChanged();
    }

    public final void setSwitch(boolean isSwitch) {
        this.mIsSwitch = isSwitch;
        notifyChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiJumpSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.mSwitchClickListener = new F(this, 0);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiJumpSwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        this.mSwitchClickListener = new F(this, 0);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyUiJumpSwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        this.mSwitchClickListener = new F(this, 0);
        init();
    }
}
