package com.oplus.melody.app.discovery;

import D7.RunnableC0376j;
import D7.o0;
import com.oplus.melody.app.discovery.DiscoveryDialogViewModel;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class I implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18927b;

    public /* synthetic */ I(Object obj, int i10) {
        this.f18926a = i10;
        this.f18927b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Object obj2 = this.f18927b;
        switch (this.f18926a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return ((DiscoveryDialogActivity) obj2).T();
            default:
                final String str = (String) obj;
                final DiscoveryDialogViewModel discoveryDialogViewModel = (DiscoveryDialogViewModel) obj2;
                discoveryDialogViewModel.getClass();
                androidx.lifecycle.t tVar = new androidx.lifecycle.t();
                final DiscoveryDialogViewModel.a aVar = new DiscoveryDialogViewModel.a(tVar);
                tVar.m(AbstractC0939b.E().v(str), new androidx.lifecycle.v() { // from class: com.oplus.melody.app.discovery.p0
                    @Override // androidx.lifecycle.v
                    public final void onChanged(Object obj3) {
                        DiscoveryDialogViewModel discoveryDialogViewModel2 = discoveryDialogViewModel;
                        discoveryDialogViewModel2.getClass();
                        o0.c.f1145c.execute(new RunnableC0376j(discoveryDialogViewModel2, aVar, str, (EarphoneDTO) obj3, 2));
                    }
                });
                return aVar;
        }
    }
}
