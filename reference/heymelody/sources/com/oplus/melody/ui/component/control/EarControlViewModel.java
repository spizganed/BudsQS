package com.oplus.melody.ui.component.control;

import A6.d;
import G8.n;
import G8.v;
import O7.l;
import androidx.lifecycle.u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import u8.C1554b;

/* JADX INFO: loaded from: classes3.dex */
public class EarControlViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<C1554b> f20413b = new l<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u<n> f20414c = new u<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20415d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f20416e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l<Boolean> f20417f = new l<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<Integer, HashMap<String, Boolean>> f20418g = new HashMap<>();

    public static List d(List list) {
        return (List) list.stream().filter(new v(0)).map(new d(5)).collect(Collectors.toList());
    }

    public final EarphoneDTO e(String str) {
        return AbstractC0939b.E().w(str);
    }
}
