package com.heytap.headset.component.mydevicelist;

import Ca.s;
import android.widget.Button;
import com.heytap.headset.component.mydevicelist.a;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDeviceListFragmentForCombine f17501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.heytap.headset.component.mydevicelist.a f17502b;

    /* JADX INFO: compiled from: MyDeviceListFragmentForCombine.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ V3.a f17503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MyDeviceListFragmentForCombine f17504b;

        public a(V3.a aVar, MyDeviceListFragmentForCombine myDeviceListFragmentForCombine) {
            this.f17503a = aVar;
            this.f17504b = myDeviceListFragmentForCombine;
        }

        public final void a(boolean z2) {
            if (z2) {
                return;
            }
            ForkJoinPool.commonPool().execute(new B6.b(11, this.f17503a, this.f17504b));
        }
    }

    public d(MyDeviceListFragmentForCombine myDeviceListFragmentForCombine, com.heytap.headset.component.mydevicelist.a aVar) {
        this.f17501a = myDeviceListFragmentForCombine;
        this.f17502b = aVar;
    }

    @Override // com.heytap.headset.component.mydevicelist.a.c
    public final void a(V3.a aVar) {
        MyDeviceListFragmentForCombine myDeviceListFragmentForCombine = this.f17501a;
        CompletableFuture.supplyAsync(new s(7, new a(aVar, myDeviceListFragmentForCombine), myDeviceListFragmentForCombine));
    }

    @Override // com.heytap.headset.component.mydevicelist.a.c
    public final void c() {
        MyDeviceListFragmentForCombine myDeviceListFragmentForCombine = this.f17501a;
        if (myDeviceListFragmentForCombine.f17459z) {
            Button button = myDeviceListFragmentForCombine.f17452s;
            if (button != null) {
                button.setVisibility(this.f17502b.f17468c.f7498c > 0 ? 0 : 8);
            } else {
                h.i("deleteDeviceButton");
                throw null;
            }
        }
    }

    @Override // com.heytap.headset.component.mydevicelist.a.c
    public final void b(V3.a aVar) {
    }
}
