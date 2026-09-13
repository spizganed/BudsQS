package com.oplus.melody.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class MelodySingleChoiceRadioView extends FrameLayout implements View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f21912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f21913c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f21914p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f21915q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RadioButton f21916r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LinearLayout f21917s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f21918t;

    public interface a {
    }

    public MelodySingleChoiceRadioView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21911a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.melody_ui_radio_preference_view, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return !this.f21918t && super.dispatchTouchEvent(motionEvent);
    }

    public String getSummary() {
        return this.f21914p.getText().toString();
    }

    public String getTitle() {
        return (String) this.f21913c.getText();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f21916r.isChecked()) {
            return;
        }
        this.f21916r.setChecked(true);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f21912b = findViewById(R.id.list_divider);
        this.f21913c = (TextView) findViewById(R.id.switch_prefernece_title);
        this.f21914p = (TextView) findViewById(R.id.switch_preference_summary);
        this.f21917s = (LinearLayout) findViewById(R.id.content_layout);
        this.f21916r = (RadioButton) findViewById(R.id.switch_btn);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f21916r.setClickable(false);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return true;
    }

    public void setBackgroundType(int i10) {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        View view = this.f21912b;
        if (view != null) {
            view.setVisibility(8);
        }
        if (i10 == 1) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(this.f21911a.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_down_radius));
            dimensionPixelOffset2 = 0;
        } else if (i10 == 2) {
            setBackground(this.f21911a.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_no_radius));
            View view2 = this.f21912b;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            dimensionPixelOffset2 = 0;
            dimensionPixelOffset = 0;
        } else if (i10 != 3) {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(this.f21911a.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_all_radius));
        } else {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(this.f21911a.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_up_radius));
            View view3 = this.f21912b;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            dimensionPixelOffset = 0;
        }
        setPadding(0, dimensionPixelOffset2, 0, dimensionPixelOffset);
    }

    public void setChecked(boolean z2) {
        this.f21916r.setChecked(z2);
    }

    public void setDisabled(boolean z2) {
        this.f21918t = z2;
        this.f21917s.setAlpha(z2 ? 0.3f : 1.0f);
        this.f21916r.setAlpha(this.f21918t ? 0.3f : 1.0f);
    }

    public void setOnSwitchChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f21916r.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setSummary(int i10) {
        setSummary(getResources().getString(i10));
    }

    public void setSummaryColor(int i10) {
        this.f21914p.setTextColor(i10);
    }

    public void setTitle(int i10) {
        this.f21913c.setText(i10);
    }

    public void setSummary(String str) {
        this.f21915q = str;
        if (TextUtils.isEmpty(str)) {
            this.f21917s.setPadding(getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_single_text_vertical_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_single_text_vertical_padding));
            this.f21914p.setVisibility(8);
        } else {
            this.f21917s.setPadding(getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_multi_text_vertical_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_multi_text_vertical_padding));
            this.f21914p.setVisibility(0);
            this.f21914p.setText(this.f21915q);
        }
        requestLayout();
    }

    public void setTitle(String str) {
        this.f21913c.setText(str);
    }

    public void setDetailClickListener(a aVar) {
    }
}
