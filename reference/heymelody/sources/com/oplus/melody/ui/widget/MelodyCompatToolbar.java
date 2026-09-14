package com.oplus.melody.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.heytap.headset.R;
import com.oplus.melody.common.util.S;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyCompatToolbar extends COUIToolbar {
    public MelodyCompatToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (S.j() < 26) {
            setPadding(getPaddingLeft(), Math.round(getResources().getDimension(R.dimen.melody_ui_toolbar_top_padding_os12)), getPaddingRight(), getPaddingBottom());
        }
    }
}
