package com.heytap.headset.component.scan;

import D7.C0373g;
import D7.C0391z;
import O7.l;
import X3.f;
import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.drs.core.d;
import com.oplus.melody.app.discovery.C1;
import com.oplus.melody.btsdk.api.scan.BleScanElement;
import com.oplus.melody.btsdk.api.scan.BrScanElement;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.ui.base.BaseViewModel;
import f4.C1043b;
import g0.C1065d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: ScanViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000bJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000bJ\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0002J\u0010\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0002J\u0010\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0002J\u0010\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bH\u0002J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000bH\u0002J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0006H\u0003J\u0012\u0010)\u001a\u0004\u0018\u00010\u00072\u0006\u0010*\u001a\u00020+H\u0003J\u0012\u0010,\u001a\u0004\u0018\u00010\u00072\u0006\u0010*\u001a\u00020-H\u0003J\u0006\u0010.\u001a\u00020\u001aJ\u0006\u0010/\u001a\u00020\u001aJ\u0016\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000eJ\u000e\u00104\u001a\u00020\u001a2\u0006\u00101\u001a\u000202J\u000e\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u0016J\u001a\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016080\u000bH\u0002J\u0018\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020 H\u0002J\u000e\u0010<\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010=\u001a\u00020\u001aH\u0002J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010A\u001a\u00020 2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010B\u001a\u00020 2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0012\u0010E\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010F\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010G\u001a\u00020\u001a2\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010H\u001a\u00020\u001a2\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010I\u001a\u00020\u001a2\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010J\u001a\u00020\u001a2\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010K\u001a\u00020\u001a2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010M\u001a\u00020\u001a2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001608H\u0002J$\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u00070Pj\b\u0012\u0004\u0012\u00020\u0007`Q2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000e0T2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010;\u001a\u00020 J\u001a\u0010V\u001a\u0004\u0018\u00010\u00182\b\u0010U\u001a\u0004\u0018\u00010\u00162\u0006\u0010;\u001a\u00020 J\u0018\u0010W\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u00162\u0006\u0010;\u001a\u00020 H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/heytap/headset/component/scan/ScanViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "mScanItemListLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "Lcom/heytap/headset/component/scan/ScanDeviceVO;", "getMScanItemListLiveData", "()Lcom/oplus/melody/model/helper/MelodyLiveData;", "mBleScanRemoveLiveData", "Landroidx/lifecycle/LiveData;", "mBrScanRemoveLiveData", "isInScanningMode", "", "mBleScanList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mBrScanList", "mScanConnectedList", "mMergedScanList", "productIdColorIdUrlMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "productIdDiscoveryZipConfigMap", "Lcom/oplus/melody/app/discovery/DiscoveryZipConfigVO;", "startObserve", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "exitScanning", "getScanItemListLiveData", "getBluetoothStateLiveData", "", "getBleScanFoundLiveData", "getBleScanRemoveLiveData", "getBrScanFoundLiveData", "getBrScanRemoveLiveData", "getConnectedDeviceListLiveData", "getConnectedDeviceList", "bluetoothDeviceList", "Landroid/bluetooth/BluetoothDevice;", "getBleScanDevice", "element", "Lcom/oplus/melody/btsdk/api/scan/BleScanElement;", "getBrScanDevice", "Lcom/oplus/melody/btsdk/api/scan/BrScanElement;", "clearScanFoundData", "clearScanRemoveData", "startScan", "context", "Landroid/content/Context;", "fromStartPage", "stopScan", "connect", "address", "getPicUrlsMapLiveData", "", "requestPicUrls", "product", "colorId", "observeConnectionState", "updateConnectEnabled", "addToBleList", "scanDeviceVO", "addToBrList", "getBleListIndex", "getBrListIndex", "removeFromBleList", "removeFromBrList", "isExistInBleList", "isExistInBrList", "onBleDeviceFound", "onBleDeviceRemove", "onBrDeviceFound", "onBrDeviceRemove", "onConnectedDeviceListFound", "list", "onPicUrlsMapChange", "urlsMap", "copyList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mergeList", "requestDiscoveryZipConfig", "Ljava/util/concurrent/CompletableFuture;", "productId", "getDiscoveryZipConfig", "getDiscoveryZipConfigKey", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScanViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f17534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f17535d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<List<f>> f17533b = new l<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f17536e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<f> f17537f = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<f> f17538g = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<f> h = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<f> f17539i = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f17540j = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, C1> f17541k = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: ScanViewModel.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wb.l f17542a;

        public a(Wb.l lVar) {
            this.f17542a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17542a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17542a.d(obj);
        }
    }

    public static ArrayList d(List list) {
        h.e(list, "list");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f.copy$default((f) it.next(), null, null, null, null, false, null, 0, null, 0, 0, false, 2047, null));
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public static f e(BleScanElement bleScanElement) {
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        int i10 = bleScanElement.mProductId;
        C0391z c0391z = C0391z.f1171d;
        WhitelistConfigDTO whitelistConfigDTOB = abstractC1508aF.b(i10, c0391z.f(bleScanElement.mDevice));
        if (whitelistConfigDTOB == null) {
            return null;
        }
        f fVar = new f(null, null, null, null, false, null, 0, null, 0, 0, false, 2047, null);
        fVar.setMacAddress(bleScanElement.mMacAddress);
        int i11 = bleScanElement.mProductId;
        if (i11 == -1) {
            return null;
        }
        fVar.setProductId(D1.f.M(i11));
        fVar.setColorId(bleScanElement.mColor);
        fVar.setPariState(Integer.valueOf(bleScanElement.mState));
        fVar.setDeviceName(c0391z.f(bleScanElement.mDevice));
        if (TextUtils.isEmpty(fVar.getDeviceName())) {
            fVar.setDeviceName(whitelistConfigDTOB.getName());
        }
        fVar.setType(whitelistConfigDTOB.getType());
        fVar.setSpp(whitelistConfigDTOB.getSupportSpp());
        return fVar;
    }

    @SuppressLint({"MissingPermission"})
    public static f f(BrScanElement brScanElement) {
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        int i10 = brScanElement.mProductId;
        C0391z c0391z = C0391z.f1171d;
        WhitelistConfigDTO whitelistConfigDTOB = abstractC1508aF.b(i10, c0391z.f(brScanElement.mDevice));
        if (whitelistConfigDTOB == null) {
            return null;
        }
        f fVar = new f(null, null, null, null, false, null, 0, null, 0, 0, false, 2047, null);
        fVar.setMacAddress(brScanElement.mMacAddress);
        int i11 = brScanElement.mProductId;
        if (i11 == -1) {
            return null;
        }
        fVar.setProductId(D1.f.M(i11));
        fVar.setColorId(-1);
        fVar.setDeviceName(c0391z.f(brScanElement.mDevice));
        if (TextUtils.isEmpty(fVar.getDeviceName())) {
            fVar.setDeviceName(whitelistConfigDTOB.getName());
        }
        fVar.setType(whitelistConfigDTOB.getType());
        fVar.setSpp(whitelistConfigDTOB.getSupportSpp());
        return fVar;
    }

    public static String g(int i10, String str) {
        String str2;
        if (C0373g.f1086l) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            str2 = d.v(heyMelodyApplication) ? "night" : "normal";
        } else {
            str2 = "";
        }
        return C1065d.c(C1043b.a(i10, str), str2);
    }

    public final boolean h(f fVar) {
        if (fVar == null) {
            return false;
        }
        Iterator<f> it = this.f17537f.iterator();
        h.d(it, "iterator(...)");
        while (it.hasNext()) {
            f next = it.next();
            h.d(next, "next(...)");
            if (h.a(fVar.getMacAddress(), next.getMacAddress())) {
                return true;
            }
        }
        return false;
    }

    public final CopyOnWriteArrayList i() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f17539i;
        copyOnWriteArrayList.clear();
        A.c("ScanViewModel", new T8.d(this, 2));
        CopyOnWriteArrayList<f> copyOnWriteArrayList2 = this.f17537f;
        if (copyOnWriteArrayList2.size() > 0) {
            copyOnWriteArrayList.addAll(copyOnWriteArrayList2);
        }
        CopyOnWriteArrayList<f> copyOnWriteArrayList3 = this.f17538g;
        if (copyOnWriteArrayList3.size() > 0) {
            Iterator<f> it = copyOnWriteArrayList3.iterator();
            h.d(it, "iterator(...)");
            while (it.hasNext()) {
                f next = it.next();
                if (!h(next)) {
                    copyOnWriteArrayList.add(next);
                }
            }
        }
        CopyOnWriteArrayList<f> copyOnWriteArrayList4 = this.h;
        if (copyOnWriteArrayList4.size() > 0) {
            Iterator<f> it2 = copyOnWriteArrayList4.iterator();
            h.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                f next2 = it2.next();
                Iterator<f> it3 = copyOnWriteArrayList.iterator();
                h.d(it3, "iterator(...)");
                while (true) {
                    if (!it3.hasNext()) {
                        copyOnWriteArrayList.add(next2);
                        break;
                    }
                    f next3 = it3.next();
                    if (h.a(next3.getMacAddress(), next2.getMacAddress())) {
                        next3.setViewType(2);
                        break;
                    }
                }
            }
        }
        j();
        return copyOnWriteArrayList;
    }

    public final void j() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f17539i;
        int size = copyOnWriteArrayList.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            if (copyOnWriteArrayList.get(i11).getConnectionState() == 1) {
                arrayList.add(Integer.valueOf(i11));
            } else {
                arrayList2.add(Integer.valueOf(i11));
            }
        }
        if (arrayList.size() <= 0) {
            int size2 = arrayList2.size();
            while (i10 < size2) {
                Object obj = arrayList2.get(i10);
                i10++;
                copyOnWriteArrayList.get(((Number) obj).intValue()).setConnectEnabled(true);
            }
            return;
        }
        int size3 = arrayList.size();
        int i12 = 0;
        while (i12 < size3) {
            Object obj2 = arrayList.get(i12);
            i12++;
            copyOnWriteArrayList.get(((Number) obj2).intValue()).setConnectEnabled(true);
        }
        int size4 = arrayList2.size();
        int i13 = 0;
        while (i13 < size4) {
            Object obj3 = arrayList2.get(i13);
            i13++;
            copyOnWriteArrayList.get(((Number) obj3).intValue()).setConnectEnabled(false);
        }
    }
}
