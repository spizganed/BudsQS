package com.heytap.headset.component.supporteddevices;

import a4.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.headset.R;
import com.heytap.headset.component.supporteddevices.SupportedDevicesBtnTextView;
import p2.C1395b;

/* JADX INFO: loaded from: classes.dex */
public class SupportedDevicesBtnTextView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f17564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f17565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SupportedDevicesBtnTextView f17566c;

    public SupportedDevicesBtnTextView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17566c = this;
        LayoutInflater.from(context).inflate(R.layout.heymelody_app_brand_btn, this);
        TextView textView = (TextView) findViewById(R.id.tv_btn);
        this.f17564a = textView;
        textView.setFocusable(true);
        this.f17564a.setFocusableInTouchMode(true);
        this.f17564a.setClickable(true);
        this.f17564a.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: a4.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                SupportedDevicesBtnTextView supportedDevicesBtnTextView = this.f7056a;
                Context context2 = context;
                if (!z2) {
                    supportedDevicesBtnTextView.f17564a.setTextColor(context2.getColor(R.color.heymelody_app_brand_btn));
                    supportedDevicesBtnTextView.f17564a.setBackground(com.oplus.drs.core.d.m(context2, R.drawable.heymelody_app_bg_filter_brand_btn));
                } else {
                    supportedDevicesBtnTextView.f17564a.setTextColor(C1395b.a(context2, R.attr.couiColorPrimary));
                    supportedDevicesBtnTextView.f17564a.setBackground(com.oplus.drs.core.d.m(context2, R.drawable.heymelody_app_bg_brand_btn_select));
                    supportedDevicesBtnTextView.f17565b.k(supportedDevicesBtnTextView.f17566c);
                }
            }
        });
    }

    public void setItemListener(b bVar) {
        this.f17565b = bVar;
    }

    public void setText(String str) {
        this.f17564a.setText(str);
    }
}
