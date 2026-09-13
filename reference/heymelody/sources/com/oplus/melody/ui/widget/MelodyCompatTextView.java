package com.oplus.melody.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.coui.appcompat.textview.COUITextView;
import com.heytap.headset.R;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyCompatTextView extends COUITextView {
    public MelodyCompatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnVisibilityChangedConsumer(Consumer<Integer> consumer) {
        setTag(R.id.melody_ui_tag_on_visibility_changed_consumer, consumer);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        int visibility = getVisibility();
        super.setVisibility(i10);
        if (i10 != visibility) {
            Object tag = getTag(R.id.melody_ui_tag_on_visibility_changed_consumer);
            if (tag instanceof Consumer) {
                ((Consumer) tag).accept(Integer.valueOf(i10));
            }
        }
    }
}
