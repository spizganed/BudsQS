package com.oplus.melody.model.repository.hearingenhance;

import D7.q0;
import L8.C0456c;
import android.content.Intent;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.db.CarouselDressDao;
import com.oplus.melody.model.db.CarouselDressEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20020a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f20022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f20023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f20024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f20025f;

    public /* synthetic */ d(String str, int i10, int i11, String str2, ArrayList arrayList) {
        this.f20022c = str;
        this.f20021b = i10;
        this.f20023d = i11;
        this.f20024e = str2;
        this.f20025f = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f20020a) {
            case 0:
                String str = this.f20022c;
                int i10 = this.f20021b;
                int i11 = this.f20023d;
                String str2 = (String) this.f20024e;
                ArrayList arrayList = (ArrayList) this.f20025f;
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1029);
                intentU.putExtra("param_address", str);
                intentU.putExtra("param_hearing_action_type", i10);
                intentU.putExtra("param_hearing_uid", i11);
                intentU.putExtra("param_hearing_name", str2);
                intentU.putParcelableArrayListExtra("param_detecting_info_list", C0901g.b(arrayList));
                com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                return new q0(5L, TimeUnit.SECONDS);
            default:
                n8.f fVar = (n8.f) this.f20024e;
                CarouselDressDao carouselDressDao = fVar.f26483p;
                int i12 = this.f20021b;
                CarouselDressEntity carouselDressEntityH = carouselDressDao != null ? carouselDressDao.h(i12) : 0;
                boolean z2 = false;
                if (carouselDressEntityH != 0) {
                    carouselDressEntityH.setName(this.f20022c);
                    carouselDressEntityH.setCarouselType(this.f20023d);
                    carouselDressEntityH.setThemeIdList(this.f20025f);
                    CarouselDressDao carouselDressDao2 = fVar.f26483p;
                    int iJ = carouselDressDao2 != null ? carouselDressDao2.j(carouselDressEntityH) : 0;
                    A.c("CarouselDressRepositoryServerImpl", new C0456c(i12, iJ, 3));
                    if (iJ > 0) {
                        z2 = true;
                    }
                } else {
                    A.h("CarouselDressRepositoryServerImpl", "updateCarouselDress id:" + i12 + " not found");
                }
                return Boolean.valueOf(z2);
        }
    }

    public /* synthetic */ d(n8.f fVar, int i10, String str, int i11, List list) {
        this.f20024e = fVar;
        this.f20021b = i10;
        this.f20022c = str;
        this.f20023d = i11;
        this.f20025f = list;
    }
}
