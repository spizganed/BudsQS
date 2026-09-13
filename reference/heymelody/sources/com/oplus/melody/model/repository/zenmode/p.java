package com.oplus.melody.model.repository.zenmode;

import com.oplus.melody.model.net.data.PersonalDressInfoDO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f20200c;

    public /* synthetic */ p(int i10, String str, List list) {
        this.f20198a = i10;
        this.f20199b = str;
        this.f20200c = list;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        ArrayList arrayList;
        switch (this.f20198a) {
            case 0:
                return "getSceneListV2 LOCAL " + this.f20199b + " size=" + this.f20200c.size();
            default:
                List list = this.f20200c;
                if (list != null) {
                    arrayList = new ArrayList(Kb.m.i(list));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((PersonalDressInfoDO) it.next()).getThemeIdentifier());
                    }
                } else {
                    arrayList = null;
                }
                return this.f20199b + " end " + arrayList;
        }
    }
}
