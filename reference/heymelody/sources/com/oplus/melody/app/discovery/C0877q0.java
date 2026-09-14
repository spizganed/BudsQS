package com.oplus.melody.app.discovery;

import android.content.SharedPreferences;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.db.MelodyTypeConverters;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.personaldress.a;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0877q0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19172a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f19175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f19176e;

    public /* synthetic */ C0877q0(DiscoveryDialogViewModel discoveryDialogViewModel, String str, int i10, String str2) {
        this.f19176e = discoveryDialogViewModel;
        this.f19173b = str;
        this.f19175d = i10;
        this.f19174c = str2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        String str;
        final String str2 = this.f19174c;
        Object obj = this.f19176e;
        final int i10 = this.f19175d;
        String str3 = this.f19173b;
        switch (this.f19172a) {
            case 0:
                DiscoveryDialogViewModel discoveryDialogViewModel = (DiscoveryDialogViewModel) obj;
                discoveryDialogViewModel.getClass();
                if (!t8.q.j()) {
                    return null;
                }
                if ("onPreviewPopup".equals(discoveryDialogViewModel.f18890j) && (str = discoveryDialogViewModel.f18893m) != null) {
                    return str;
                }
                Object obj2 = com.oplus.melody.model.repository.personaldress.a.f20060c;
                return a.C0231a.a().e(i10, str3, str2);
            default:
                final SharedPreferences sharedPreferencesC = t8.q.c("melody-model-zen2");
                List<String> listA = MelodyTypeConverters.a(sharedPreferencesC.getString(str3, null));
                if (listA == null) {
                    listA = Collections.EMPTY_LIST;
                }
                final String str4 = (String) obj;
                return (List) listA.stream().map(new Function() { // from class: com.oplus.melody.model.repository.zenmode.m
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return (ZenModeInfoDO) C0917x.c(ZenModeInfoDO.class, sharedPreferencesC.getString(s.F("scene", (String) obj3, str2, Integer.valueOf(i10), str4), null));
                    }
                }).filter(new com.oplus.melody.model.db.u(2)).collect(Collectors.toList());
        }
    }

    public /* synthetic */ C0877q0(String str, String str2, int i10, String str3) {
        this.f19173b = str;
        this.f19174c = str2;
        this.f19175d = i10;
        this.f19176e = str3;
    }
}
