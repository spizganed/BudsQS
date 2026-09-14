package com.oplus.melody.model.net;

import android.text.TextUtils;
import androidx.media3.session.D0;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.model.net.E;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import retrofit2.C1487a;
import retrofit2.C1488b;
import retrofit2.g;
import uc.n;
import uc.q;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class A implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ E f19796b;

    public /* synthetic */ A(E e10, int i10) {
        this.f19795a = i10;
        this.f19796b = e10;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f19795a) {
            case 0:
                String str = (String) obj;
                E e10 = this.f19796b;
                e10.getClass();
                Vc.b bVarE = D1.f.E(str);
                kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(InterfaceC0932a.class);
                Nc.a aVar = Pc.a.f4080b;
                if (aVar == null) {
                    throw new IllegalStateException("KoinApplication has not been started");
                }
                InterfaceC0932a interfaceC0932a = (InterfaceC0932a) ((Wc.b) aVar.f3515c).f5616d.c(bVarA, bVarE, null);
                if (interfaceC0932a == null) {
                    if ("pall".equals(str)) {
                        throw MelodyException.e(0, "fetchUrlRecord fallback failed");
                    }
                    return e10.p("pall");
                }
                Pair<String, String> pairA = interfaceC0932a.a();
                StringBuilder sbI = D0.i("fetchUrlRecord ", str, " host='");
                sbI.append(pairA.e());
                sbI.append("'");
                com.oplus.melody.common.util.A.x("SmartHomeIotCallHelper", sbI.toString());
                String strE = pairA.e();
                String strF = pairA.f();
                uc.p pVar = C0938g.f19822a;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Objects.requireNonNull(strE, "baseUrl == null");
                n.a aVar2 = new n.a();
                aVar2.c(null, strE);
                uc.n nVarA = aVar2.a();
                ArrayList arrayList3 = nVarA.f28165f;
                if (!"".equals(arrayList3.get(arrayList3.size() - 1))) {
                    throw new IllegalArgumentException("baseUrl must end in /: " + nVarA);
                }
                uc.p pVarA = C0938g.a();
                Objects.requireNonNull(pVarA, "client == null");
                C0934c c0934c = C0934c.f19820a;
                Objects.requireNonNull(c0934c, "factory == null");
                arrayList.add(c0934c);
                androidx.core.provider.l lVar = retrofit2.t.f27463a;
                C1488b c1488b = retrofit2.t.f27465c;
                ArrayList arrayList4 = new ArrayList(arrayList2);
                List listA = c1488b.a(lVar);
                arrayList4.addAll(listA);
                List<? extends g.a> listB = c1488b.b();
                ArrayList arrayList5 = new ArrayList(arrayList.size() + 1 + listB.size());
                arrayList5.add(new C1487a());
                arrayList5.addAll(arrayList);
                arrayList5.addAll(listB);
                List listUnmodifiableList = Collections.unmodifiableList(arrayList5);
                List listUnmodifiableList2 = Collections.unmodifiableList(arrayList4);
                listA.size();
                retrofit2.z zVar = new retrofit2.z(pVarA, nVarA, listUnmodifiableList, listUnmodifiableList2, lVar);
                if (!G.class.isInterface()) {
                    throw new IllegalArgumentException("API declarations must be interfaces.");
                }
                ArrayDeque arrayDeque = new ArrayDeque(1);
                arrayDeque.add(G.class);
                while (!arrayDeque.isEmpty()) {
                    Class cls = (Class) arrayDeque.removeFirst();
                    if (cls.getTypeParameters().length != 0) {
                        StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                        sb2.append(cls.getName());
                        if (cls != G.class) {
                            sb2.append(" which is an interface of ");
                            sb2.append(G.class.getName());
                        }
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    Collections.addAll(arrayDeque, cls.getInterfaces());
                }
                return new E.b(strE, new SecretKeySpec(strF.getBytes(StandardCharsets.UTF_8), "HmacSha1"), (G) Proxy.newProxyInstance(G.class.getClassLoader(), new Class[]{G.class}, new retrofit2.y(zVar, G.class)));
            default:
                E e11 = this.f19796b;
                String str2 = e11.p("pall").f19815a;
                CompletableFuture<Long> completableFuture = e11.f19811t;
                if (completableFuture == null || completableFuture.isDone()) {
                    completableFuture = new CompletableFuture<>();
                    if (TextUtils.isEmpty(str2)) {
                        completableFuture.completeExceptionally(MelodyException.e(502, "Fail to requestServerTime"));
                    } else {
                        e11.f19811t = completableFuture;
                        q.a aVar3 = new q.a();
                        aVar3.c(str2);
                        uc.q qVar = new uc.q(aVar3);
                        uc.p pVarA2 = C0938g.a();
                        pVarA2.getClass();
                        new yc.i(pVarA2, qVar).A(new F(e11));
                    }
                }
                return completableFuture;
        }
    }
}
