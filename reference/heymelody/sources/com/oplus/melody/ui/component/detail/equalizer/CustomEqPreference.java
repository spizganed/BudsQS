package com.oplus.melody.ui.component.detail.equalizer;

import X3.w;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.f;
import androidx.preference.CheckBoxPreference;
import androidx.preference.m;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.b;
import com.google.android.play.core.appupdate.c;
import com.heytap.headset.R;
import g9.j;

/* JADX INFO: loaded from: classes3.dex */
public class CustomEqPreference extends CheckBoxPreference implements b, COUIRecyclerView.b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public RelativeLayout f20952A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public TextView f20953B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RadioButton f20954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CheckBox f20955c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f20956p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f20957q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f20958r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a8.b f20959s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f20960t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public j.ViewOnClickListenerC0255j f20961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f20962v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f20963w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f20964x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TextView f20965y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f20966z;

    public CustomEqPreference(f fVar) {
        super(fVar);
        setLayoutResource(R.layout.melody_ui_preference_custom_eq);
        setWidgetLayoutResource(R.layout.melody_ui_preference_widget_checkbox_custom);
        this.f20966z = fVar.getResources().getDimensionPixelSize(R.dimen.coui_preference_divider_default_horizontal_padding);
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public final boolean drawDivider() {
        if (!(this.f20963w instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int iZ = c.z(this);
        return iZ == 1 || iZ == 2;
    }

    public final void f(j.ViewOnClickListenerC0255j viewOnClickListenerC0255j) {
        this.f20961u = viewOnClickListenerC0255j;
        View view = this.f20962v;
        if (view != null) {
            view.setTag(this);
            this.f20962v.setOnClickListener(this.f20961u);
            this.f20962v.setClickable(this.f20961u != null);
        }
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    /* JADX INFO: renamed from: getDividerEndInset */
    public final int getF21896x() {
        return this.f20966z;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public final View getDividerStartAlignView() {
        return this.f20965y;
    }

    @Override // androidx.recyclerview.widget.COUIRecyclerView.b
    public final int getDividerStartInset() {
        return this.f20966z;
    }

    public final void h() {
        RadioButton radioButton;
        CheckBox checkBox = this.f20955c;
        if (checkBox == null || (radioButton = this.f20954b) == null) {
            return;
        }
        if (this.f20958r) {
            checkBox.setVisibility(0);
            this.f20954b.setVisibility(8);
        } else {
            radioButton.setVisibility(0);
            this.f20955c.setVisibility(8);
        }
    }

    public final void i() {
        if (this.f20956p != null) {
            if (TextUtils.isEmpty(this.f20960t)) {
                this.f20956p.setVisibility(8);
                this.f20956p.setText("");
            } else if (this.f20960t.equals(String.valueOf(3))) {
                this.f20957q.setVisibility(0);
                this.f20957q.setImageResource(R.drawable.melody_ui_equalizer_dynaudio);
            } else {
                this.f20956p.setVisibility(0);
                this.f20956p.setText(this.f20960t);
            }
            if (String.valueOf(3).equals(this.f20960t)) {
                this.f20952A.post(new w(this, 26));
            } else {
                this.f20965y.setMaxWidth(Integer.MAX_VALUE);
            }
        }
    }

    @Override // com.coui.appcompat.preference.b
    /* JADX INFO: renamed from: isSupportCardUse */
    public final boolean getF21890r() {
        return this.f20964x;
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public final void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        View view = mVar.itemView;
        this.f20963w = view;
        this.f20964x = true;
        c.S(c.z(this), view);
        this.f20954b = (RadioButton) mVar.a(R.id.radio);
        this.f20955c = (CheckBox) mVar.a(android.R.id.checkbox);
        this.f20956p = (TextView) mVar.a(R.id.tag);
        this.f20957q = (ImageView) mVar.a(R.id.img_tag);
        this.f20952A = (RelativeLayout) mVar.a(R.id.text_container);
        this.f20962v = mVar.a(R.id.widget_layout);
        this.f20954b.setChecked(this.mChecked);
        h();
        this.f20962v.setTag(this);
        this.f20962v.setOnClickListener(this.f20961u);
        this.f20962v.setClickable(this.f20961u != null);
        this.f20965y = (TextView) mVar.a(android.R.id.title);
        i();
        this.f20953B = (TextView) mVar.a(R.id.melody_ui_preference_value);
        if (TextUtils.isEmpty(null)) {
            this.f20953B.setVisibility(8);
        } else {
            this.f20953B.setVisibility(0);
            this.f20953B.setText((CharSequence) null);
        }
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public final void onClick() {
        if (this.f20958r) {
            super.onClick();
        } else {
            if (isChecked() || !callChangeListener(Boolean.TRUE)) {
                return;
            }
            setChecked(true);
        }
    }
}
