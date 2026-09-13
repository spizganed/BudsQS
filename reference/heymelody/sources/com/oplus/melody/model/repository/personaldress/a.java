package com.oplus.melody.model.repository.personaldress;

import Jb.l;
import androidx.lifecycle.s;
import com.oplus.melody.btsdk.api.data.UpgradeStateInfo;
import com.oplus.melody.model.db.PersonalDressEntity;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: compiled from: PersonalDressRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends K7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f20060c = kotlin.a.b(LazyThreadSafetyMode.f25345a, new A7.a(13));

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.personaldress.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersonalDressRepository.kt */
    public static final class C0231a {
        /* JADX WARN: Type inference failed for: r0v0, types: [Jb.b, java.lang.Object] */
        public static a a() {
            return (a) a.f20060c.getValue();
        }
    }

    public a() {
        super(17000);
    }

    public abstract void A();

    public abstract void a();

    public abstract PersonalDressEntity b(String str);

    public abstract String c(String str);

    public abstract s<String> d(String str);

    public abstract String e(int i10, String str, String str2);

    public abstract s<CustomDressDTO> f(String str, String str2);

    public abstract s<Boolean> g();

    public abstract void h(String str);

    public abstract s i(int i10, String str);

    public abstract CompletableFuture<l> j(PersonalDressDTO.PersonalDressData personalDressData, String str, int i10, com.oplus.melody.model.repository.zenmode.c cVar);

    public abstract CompletableFuture k(String str, String str2, int i10, int i11, String str3, String str4);

    public abstract CompletableFuture<File> l(String str, String str2, String str3, String str4);

    public abstract CompletableFuture<File> m(String str, String str2, String str3, String str4, com.oplus.melody.model.repository.zenmode.c cVar);

    public abstract s<ToneStateInfoDTO> n();

    public abstract boolean o(String str, String str2, boolean z2, boolean z4);

    public abstract void p(boolean z2);

    public abstract void q(int i10, boolean z2, String str);

    public abstract CompletableFuture r(boolean z2, String str, int i10, int i11);

    public abstract CompletableFuture s(String str, int i10, String str2, boolean z2);

    public abstract CompletableFuture t(int i10, boolean z2, String str);

    public abstract void u(String str, String str2);

    public abstract void v(String str);

    public abstract void w(UpgradeStateInfo upgradeStateInfo);

    public abstract void x(UpgradeStateInfo upgradeStateInfo);

    public abstract void y(UpgradeStateInfo upgradeStateInfo);

    public abstract void z(String str, String str2);
}
