package com.heytap.headset.component.supporteddevices;

import O7.l;
import a4.C0516a;
import androidx.lifecycle.v;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SupportedDevicesViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0019H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/heytap/headset/component/supporteddevices/SupportedDevicesViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "allDeviceItemListLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "Lcom/heytap/headset/component/supporteddevices/DeviceItemVO;", "opoDeviceItemListLiveData", "opsDeviceItemListLiveData", "productIdUrlMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "observeData", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getAllDeviceItemListLiveData", "getOPODeviceItemListLiveData", "getOPSDeviceItemListLiveData", "onWhiteListChange", "whiteList", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "onImageUrlsChange", "map", "", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SupportedDevicesViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<List<C0516a>> f17578b = new l<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l<List<C0516a>> f17579c = new l<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l<List<C0516a>> f17580d = new l<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f17581e = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SupportedDevicesViewModel.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f17582a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Wb.l lVar) {
            this.f17582a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17582a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17582a.d(obj);
        }
    }
}
