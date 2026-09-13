package com.oplus.melody.ui.component.control.preference;

import A9.k;
import D7.RunnableC0380n;
import K8.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.m;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.COUIListPreference;
import com.heytap.headset.R;
import com.oplus.melody.ui.component.control.b;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ColorSingleSelectPreference extends COUIListPreference implements b {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public b.a f20565K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public Boolean f20566L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f20567M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f20568N;

    public ColorSingleSelectPreference(Context context) {
        super(context);
        this.f20566L = null;
        this.f20568N = false;
        setLayoutResource(R.layout.coui_preference);
        setIconSpaceReserved(false);
    }

    @Override // K8.b
    public final Object getTag() {
        return this.f20565K;
    }

    @Override // com.coui.appcompat.preference.COUIListPreference, androidx.preference.Preference
    public final void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        Boolean bool = this.f20566L;
        if (bool == null || bool.booleanValue()) {
            return;
        }
        View view = mVar.itemView;
        if (view instanceof COUICardListSelectedItemLayout) {
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view;
            Objects.requireNonNull(cOUICardListSelectedItemLayout);
            cOUICardListSelectedItemLayout.postDelayed(new k(cOUICardListSelectedItemLayout, 12), 300L);
            cOUICardListSelectedItemLayout.postDelayed(new RunnableC0380n(cOUICardListSelectedItemLayout, 11), 900L);
            this.f20566L = Boolean.TRUE;
        }
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void onClick() {
        if (this.f20567M) {
            return;
        }
        super.onClick();
    }

    public ColorSingleSelectPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20566L = null;
        this.f20568N = false;
        setLayoutResource(R.layout.coui_preference);
        setIconSpaceReserved(false);
    }
}
