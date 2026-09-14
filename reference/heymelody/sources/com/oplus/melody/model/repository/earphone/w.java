package com.oplus.melody.model.repository.earphone;

import D7.q0;
import android.content.Context;
import android.content.Intent;
import com.oplus.melody.common.util.C0901g;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19999a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f20002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f20003e;

    public /* synthetic */ w(Number number, String str, String str2, int i10) {
        this.f20002d = number;
        this.f20000b = str;
        this.f20003e = str2;
        this.f20001c = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19999a) {
            case 0:
                List list = (List) ((List) this.f20002d).stream().filter(new A6.h(5)).map(new C0940c(9)).collect(Collectors.toList());
                Context context = (Context) this.f20003e;
                Intent intentU = com.google.android.play.core.appupdate.c.u(context, 1021);
                intentU.putExtra("param_address", this.f20000b);
                intentU.putExtra("param_protocol", this.f20001c);
                intentU.putParcelableArrayListExtra("param_key_function_info", C0901g.b(list));
                com.google.android.play.core.appupdate.c.Q(context, intentU);
                return new q0(5L, TimeUnit.SECONDS);
            default:
                return "saveCarouselDress id:" + ((Number) this.f20002d) + " name:" + this.f20000b + " productId:" + ((String) this.f20003e) + " colorId:" + this.f20001c;
        }
    }

    public /* synthetic */ w(String str, Context context, List list, int i10) {
        this.f20002d = list;
        this.f20003e = context;
        this.f20000b = str;
        this.f20001c = i10;
    }
}
