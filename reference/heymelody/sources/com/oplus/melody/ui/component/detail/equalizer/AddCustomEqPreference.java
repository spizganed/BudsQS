package com.oplus.melody.ui.component.detail.equalizer;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import g9.o;

/* JADX INFO: loaded from: classes3.dex */
public class AddCustomEqPreference extends COUIPreference {
    public AddCustomEqPreference(Context context) {
        super(context);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        ((TextView) mVar.a(R.id.title)).setTextColor(o.g(getContext(), com.heytap.headset.R.attr.couiColorPrimary));
    }

    public AddCustomEqPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddCustomEqPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public AddCustomEqPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
