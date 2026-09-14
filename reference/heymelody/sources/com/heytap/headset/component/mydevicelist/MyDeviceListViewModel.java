package com.heytap.headset.component.mydevicelist;

import D7.C0374h;
import D7.C0379m;
import O7.l;
import X7.b;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import f4.C1043b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MyDeviceListViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\r0\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r0\u0007J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0006J\u001c\u0010\u001d\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rH\u0002J\u001a\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\bH\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/heytap/headset/component/mydevicelist/MyDeviceListViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "earphoneLiveDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "deviceItemMap", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "deviceItemMapLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "productIdColorIdUrlMap", "startObserve", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getDeviceItemMap", "requestImageUrl", "productIdColorId", "colorId", "", "getPicUrlsMapLiveData", "deleteDevice", "macAddress", "reconnect", "disconnect", "onPicUrlsMapChange", "urlsMap", "updateTimeAsync", "deviceItem", "earphone", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyDeviceListViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, s<EarphoneDTO>> f17462b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, V3.a> f17463c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l<Map<String, V3.a>> f17464d = new l<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f17465e = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: MyDeviceListViewModel.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wb.l f17466a;

        public a(Wb.l lVar) {
            this.f17466a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17466a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17466a.d(obj);
        }
    }

    public final t d(InterfaceC0601m interfaceC0601m) {
        Object obj = X7.b.f5996c;
        b.a.a().c().e(interfaceC0601m, new a(new C0374h(3, this, interfaceC0601m)));
        return C0379m.b(this.f17464d);
    }

    public final void e(Map<String, String> map) {
        if (map.isEmpty()) {
            return;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f17465e;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(map);
        ConcurrentHashMap<String, V3.a> concurrentHashMap2 = this.f17463c;
        for (Map.Entry<String, V3.a> entry : concurrentHashMap2.entrySet()) {
            String productId = entry.getValue().getProductId();
            if (productId != null && map.containsKey(C1043b.a(entry.getValue().getColorId(), productId))) {
                entry.getValue().setCoverImage(map.get(C1043b.a(entry.getValue().getColorId(), productId)));
            }
        }
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        for (Map.Entry<String, V3.a> entry2 : concurrentHashMap2.entrySet()) {
            concurrentHashMap3.put(entry2.getKey(), com.oplus.melody.common.data.a.copyOf(entry2.getValue(), V3.a.class));
        }
        this.f17464d.m(concurrentHashMap3);
    }
}
