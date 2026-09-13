package com.oplus.melody.common.widget;

import A9.d;
import Ea.C0404m;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.m;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes.dex */
public class MelodyCOUISwitchPreference extends COUISwitchPreference {
    private static final float DISABLE_VIEW_ALPHA = 0.3f;
    private static final float ENABLE_VIEW_ALPHA = 1.0f;
    private static final String TAG = "MelodyCOUISwitchPreference";
    private boolean mAllowClickDisabled;
    private COUICardListSelectedItemLayout mItemView;
    private View.OnClickListener mListener;

    public MelodyCOUISwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mAllowClickDisabled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$onBindViewHolder$0() {
        return "onBindViewHolder, mAllowClickDisabled = " + this.mAllowClickDisabled + ", mItemView = " + this.mItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$setAllowClickDisabled$1() {
        return "setAllowClickDisabled, mAllowClickDisabled = " + this.mAllowClickDisabled + ", mItemView = " + this.mItemView;
    }

    public View getItemView() {
        return this.mItemView;
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        View view = mVar.itemView;
        if (view instanceof COUICardListSelectedItemLayout) {
            this.mItemView = (COUICardListSelectedItemLayout) view;
        }
        A.c(TAG, new d(this, 15));
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = this.mItemView;
        if (cOUICardListSelectedItemLayout == null || cOUICardListSelectedItemLayout.getChildCount() <= 0) {
            return;
        }
        for (int i10 = 0; i10 < this.mItemView.getChildCount(); i10++) {
            View childAt = this.mItemView.getChildAt(i10);
            if (childAt != null) {
                childAt.setAlpha(this.mAllowClickDisabled ? DISABLE_VIEW_ALPHA : 1.0f);
            }
        }
        if (this.mAllowClickDisabled) {
            this.mItemView.setOnClickListener(this.mListener);
        }
    }

    public void setAllowClickDisabled(boolean z2) {
        this.mAllowClickDisabled = z2;
        A.c(TAG, new C0404m(this, 5));
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = this.mItemView;
        if (cOUICardListSelectedItemLayout != null && cOUICardListSelectedItemLayout.getChildCount() > 0) {
            for (int i10 = 0; i10 < this.mItemView.getChildCount(); i10++) {
                View childAt = this.mItemView.getChildAt(i10);
                if (childAt != null) {
                    childAt.setAlpha(this.mAllowClickDisabled ? DISABLE_VIEW_ALPHA : 1.0f);
                }
            }
        }
        notifyChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = this.mItemView;
        if (cOUICardListSelectedItemLayout == null || !this.mAllowClickDisabled) {
            return;
        }
        cOUICardListSelectedItemLayout.setOnClickListener(onClickListener);
    }

    public MelodyCOUISwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAllowClickDisabled = false;
    }

    public MelodyCOUISwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAllowClickDisabled = false;
    }

    public MelodyCOUISwitchPreference(Context context) {
        super(context);
        this.mAllowClickDisabled = false;
    }
}
