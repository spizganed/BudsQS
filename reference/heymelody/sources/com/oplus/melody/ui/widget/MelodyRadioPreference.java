package com.oplus.melody.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.b;
import com.coui.appcompat.preference.i;
import com.google.android.play.core.appupdate.c;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyRadioPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 @2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002@AB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000fJ\b\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020)H\u0014J\b\u00101\u001a\u0004\u0018\u00010\u0019J\u0010\u00102\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u00010\u0019J\u000e\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\fJ\u0012\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u0013J\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\fJ\b\u0010<\u001a\u00020\u0013H\u0016J\n\u0010=\u001a\u0004\u0018\u00010%H\u0016J\b\u0010>\u001a\u00020\fH\u0016J\b\u0010?\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyRadioPreference;", "Landroidx/preference/TwoStatePreference;", "Lcom/coui/appcompat/preference/COUICardSupportInterface;", "Landroidx/recyclerview/widget/COUIRecyclerView$ICOUIDividerDecorationInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mListener", "Lcom/oplus/melody/ui/widget/MelodyRadioPreference$Listener;", "mIsEnableClickSpan", "", "mRadioButton", "Landroid/widget/RadioButton;", "mRedDotDiameter", "mRedDotMarginStart", "mAssignment", "", "mHasRedDot", "mTitle", "mIsSupportCardUse", "mIconStyle", "mHasBorder", "mRadius", "mSummaryTv", "Landroid/widget/TextView;", "mSummaryColor", "mTitleView", "mItemView", "Landroid/view/View;", "mDividerDefaultHorizontalPadding", "isSupportCardUse", "setIsSupportCardUse", "", "callCustomChangeListener", "newValue", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "onClick", "getAssignment", "setAssignment", "assignment", "setBorderRectRadius", "radius", "setTitle", "title", "setHasRedDot", "hasRedDot", "setSummaryColor", "color", "drawDivider", "getDividerStartAlignView", "getDividerStartInset", "getDividerEndInset", "Companion", "Listener", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyRadioPreference extends TwoStatePreference implements b, COUIRecyclerView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f21887c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CharSequence f21888p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f21889q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f21890r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f21891s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f21892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f21893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f21894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f21895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f21896x;

    /* JADX INFO: compiled from: MelodyRadioPreference.kt */
    public final class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton buttonView, boolean z2) {
            boolean zE;
            h.e(buttonView, "buttonView");
            MelodyRadioPreference melodyRadioPreference = MelodyRadioPreference.this;
            if (melodyRadioPreference.isChecked() != z2) {
                Boolean boolValueOf = Boolean.valueOf(melodyRadioPreference.isChecked());
                if (melodyRadioPreference.getOnPreferenceChangeListener() == null) {
                    zE = true;
                } else {
                    Preference.c onPreferenceChangeListener = melodyRadioPreference.getOnPreferenceChangeListener();
                    zE = onPreferenceChangeListener != null ? onPreferenceChangeListener.e(melodyRadioPreference, boolValueOf) : false;
                }
                if (zE) {
                    melodyRadioPreference.setChecked(z2);
                } else {
                    buttonView.setChecked(!z2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyRadioPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        h.e(context, "context");
        setLayoutResource(R.layout.coui_preference);
        setWidgetLayoutResource(R.layout.melody_ui_preference_widget_radiobutton);
        this.f21885a = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ub.a.f28102o, 0, 0);
        h.d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f21886b = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f21888p = typedArrayObtainStyledAttributes.getText(1);
        this.f21890r = typedArrayObtainStyledAttributes.getBoolean(25, true);
        this.f21891s = typedArrayObtainStyledAttributes.getInt(8, 1);
        this.f21892t = typedArrayObtainStyledAttributes.getBoolean(21, false);
        this.f21893u = typedArrayObtainStyledAttributes.getDimensionPixelSize(26, 14);
        typedArrayObtainStyledAttributes.recycle();
        this.f21896x = context.getResources().getDimensionPixelSize(R.dimen.coui_preference_divider_default_horizontal_padding);
        this.f21889q = getTitle();
        context.getResources().getDimensionPixelOffset(R.dimen.coui_dot_diameter_small);
        context.getResources().getDimensionPixelOffset(R.dimen.coui_switch_preference_dot_margin_start);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public final boolean drawDivider() {
        if (!(this.f21895w instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int iZ = c.z(this);
        return iZ == 1 || iZ == 2;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    /* JADX INFO: renamed from: getDividerEndInset, reason: from getter */
    public final int getF21896x() {
        return this.f21896x;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public final View getDividerStartAlignView() {
        return this.f21894v;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public final int getDividerStartInset() {
        return this.f21896x;
    }

    @Override // com.coui.appcompat.preference.b
    /* JADX INFO: renamed from: isSupportCardUse, reason: from getter */
    public final boolean getF21890r() {
        return this.f21890r;
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        this.f21895w = holder.itemView;
        View viewA = holder.a(R.id.coui_preference);
        if (viewA != null) {
            viewA.setSoundEffectsEnabled(false);
            viewA.setHapticFeedbackEnabled(false);
        }
        View viewA2 = holder.a(R.id.melody_ui_preference_radio);
        if (viewA2 instanceof RadioButton) {
            RadioButton radioButton = (RadioButton) viewA2;
            radioButton.setChecked(isChecked());
            radioButton.setOnCheckedChangeListener(this.f21885a);
            radioButton.setVerticalScrollBarEnabled(false);
            this.f21887c = radioButton;
        }
        super.onBindViewHolder(holder);
        if (this.f21886b) {
            i.d(getContext(), holder);
        }
        i.c(holder, getContext(), this.f21893u, this.f21892t, this.f21891s, true);
        View viewA3 = holder.a(R.id.img_layout);
        View viewFindViewById = holder.itemView.findViewById(android.R.id.icon);
        if (viewA3 != null) {
            if (viewFindViewById != null) {
                viewA3.setVisibility(viewFindViewById.getVisibility());
            } else {
                viewA3.setVisibility(8);
            }
        }
        View viewFindViewById2 = holder.itemView.findViewById(R.id.assignment);
        TextView textView = viewFindViewById2 instanceof TextView ? (TextView) viewFindViewById2 : null;
        if (textView != null) {
            CharSequence charSequence = this.f21888p;
            if (TextUtils.isEmpty(charSequence)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence);
                textView.setVisibility(0);
            }
        }
        View viewA4 = holder.a(android.R.id.title);
        h.c(viewA4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewA4;
        this.f21894v = textView2;
        textView2.setText(this.f21889q);
        View viewA5 = holder.a(android.R.id.summary);
        h.c(viewA5, "null cannot be cast to non-null type android.widget.TextView");
        c.S(c.z(this), holder.itemView);
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public final void onClick() {
        super.onClick();
        RadioButton radioButton = this.f21887c;
        if (radioButton != null) {
            radioButton.setChecked(isChecked());
        }
    }

    @Override // androidx.preference.Preference
    public final void setTitle(CharSequence title) {
        super.setTitle(title);
        this.f21889q = title;
    }
}
