package com.oplus.melody.ui.component.detail.freedialog;

import G7.e;
import android.widget.RadioButton;
import android.widget.TextView;
import com.heytap.headset.R;

/* JADX INFO: compiled from: FreeDialogAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends e<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FreeDialogPanelFragment f21015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21016c;

    /* JADX INFO: compiled from: FreeDialogAdapter.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f21017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f21018b;
    }

    @Override // G7.e
    public final void c(e.a aVar, a aVar2, int i10) {
        a aVar3 = aVar2;
        TextView textView = (TextView) aVar.a(R.id.tv_entry);
        RadioButton radioButton = (RadioButton) aVar.a(R.id.rb_button);
        textView.setText(aVar3.f21018b);
        radioButton.setChecked(this.f21016c == aVar3.f21017a);
        aVar.a(R.id.item_view).setOnClickListener(new com.oplus.melody.ui.component.detail.freedialog.a(this, aVar3));
        radioButton.setOnCheckedChangeListener(new b(this, aVar3));
    }

    @Override // G7.e
    public final int d() {
        return R.layout.melody_ui_single_select_simple_item_layout;
    }
}
