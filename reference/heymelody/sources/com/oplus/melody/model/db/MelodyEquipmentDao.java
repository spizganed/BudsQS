package com.oplus.melody.model.db;

import android.text.TextUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MelodyEquipmentDao extends w<E> {
    public void d(E e10) {
        if (l(e10.getColorId(), e10.getMacAddress(), e10.getName(), e10.getProductId()) <= 0) {
            b(Collections.singletonList(e10));
            return;
        }
        if (e10.getAutoOTASwitch() != -1) {
            g(e10.getAutoOTASwitch(), e10.getMacAddress());
        }
        if (e10.getChannelSwitch() != -1) {
            h(e10.getChannelSwitch(), e10.getMacAddress());
        }
        if (!TextUtils.isEmpty(e10.getPopTheme())) {
            j(e10.getMacAddress(), e10.getPopTheme());
        }
        if (e10.getMultiConversationSwitch() != -1) {
            i(e10.getMultiConversationSwitch(), e10.getMacAddress());
        }
        if (e10.getReconnectPopupSwitch() != -1) {
            k(e10.getReconnectPopupSwitch(), e10.getMacAddress());
        }
    }

    public abstract androidx.lifecycle.s<List<E>> e();

    public abstract E f(String str);

    public abstract void g(int i10, String str);

    public abstract void h(int i10, String str);

    public abstract void i(int i10, String str);

    public abstract void j(String str, String str2);

    public abstract void k(int i10, String str);

    public abstract int l(int i10, String str, String str2, String str3);
}
