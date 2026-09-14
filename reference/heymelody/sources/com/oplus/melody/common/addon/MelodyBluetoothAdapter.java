package com.oplus.melody.common.addon;

import A6.e;
import Ca.p;
import Jb.l;
import Kb.q;
import android.bluetooth.OplusBluetoothAdapter;
import android.bluetooth.OplusBluetoothRssiDetectCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import androidx.collection.b;
import com.google.android.play.core.appupdate.c;
import com.oplus.melody.btsdk.protocol.commands.r;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.S;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.a;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyBluetoothAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\n \b*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyBluetoothAdapter;", "", "<init>", "()V", "TAG", "", "ADV_SERVICE_UUID", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "OPLUS_DATA_MASK", "", "OPLUS_DATA", "mBluetoothRssiDetectCallbacks", "Landroidx/collection/ArraySet;", "Lcom/oplus/melody/common/addon/MelodyBluetoothRssiDetectCallback;", "mOplusBluetoothAdapter", "Landroid/bluetooth/OplusBluetoothAdapter;", "getMOplusBluetoothAdapter", "()Landroid/bluetooth/OplusBluetoothAdapter;", "mOplusBluetoothAdapter$delegate", "Lkotlin/Lazy;", "mOplusBluetoothRssiDetectCallback", "com/oplus/melody/common/addon/MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1", "getMOplusBluetoothRssiDetectCallback", "()Lcom/oplus/melody/common/addon/MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1;", "mOplusBluetoothRssiDetectCallback$delegate", "mOplusBluetoothRssiDetectCallbackRegistered", "", "registerBluetoothRssiDetectCallback", "", "callback", "unregisterBluetoothRssiDetectCallback", "setPageScanInterval", "interval", "", "registerOplusBluetoothRssiDetectCallback", "unregisterOplusBluetoothRssiDetectCallback", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyBluetoothAdapter {
    private static final String TAG = "MelodyBluetoothAdapter";
    private static volatile boolean mOplusBluetoothRssiDetectCallbackRegistered;
    public static final MelodyBluetoothAdapter INSTANCE = new MelodyBluetoothAdapter();
    private static final UUID ADV_SERVICE_UUID = UUID.fromString("00009801-0000-1000-8000-00805f9b34fb");
    private static final byte[] OPLUS_DATA_MASK = {0, 0, 0, 0, 0, 0, -1};
    private static final byte[] OPLUS_DATA = {0, 0, 0, 0, 0, 0, -104};
    private static final b<MelodyBluetoothRssiDetectCallback> mBluetoothRssiDetectCallbacks = new b<>(0);
    private static final Jb.b mOplusBluetoothAdapter$delegate = a.a(new p(10));
    private static final Jb.b mOplusBluetoothRssiDetectCallback$delegate = a.a(new A7.a(12));

    private MelodyBluetoothAdapter() {
    }

    private final OplusBluetoothAdapter getMOplusBluetoothAdapter() {
        return (OplusBluetoothAdapter) mOplusBluetoothAdapter$delegate.getValue();
    }

    private final MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1 getMOplusBluetoothRssiDetectCallback() {
        return (MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1) mOplusBluetoothRssiDetectCallback$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.oplus.melody.common.addon.MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1] */
    public static final MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1 mOplusBluetoothRssiDetectCallback_delegate$lambda$0() {
        return new OplusBluetoothRssiDetectCallback() { // from class: com.oplus.melody.common.addon.MelodyBluetoothAdapter$mOplusBluetoothRssiDetectCallback$2$1
            public void onRssiDetectDistanceCallback(ScanResult result, float modifRssi, float distance) {
                List listF;
                Object objA;
                if (result != null) {
                    synchronized (MelodyBluetoothAdapter.mBluetoothRssiDetectCallbacks) {
                        listF = q.F(MelodyBluetoothAdapter.mBluetoothRssiDetectCallbacks);
                    }
                    Iterator it = listF.iterator();
                    while (it.hasNext()) {
                        try {
                            ((MelodyBluetoothRssiDetectCallback) it.next()).onRssiDetectDistanceCallback(result, modifRssi, distance);
                            objA = l.f2618a;
                        } catch (Throwable th) {
                            objA = kotlin.b.a(th);
                        }
                        Throwable thA = Result.a(objA);
                        if (thA != null) {
                            A.i("MelodyBluetoothAdapter", "onRssiDetectDistanceCallback callback error", thA);
                        }
                    }
                }
            }

            public void onRssiDetectResultCallback(ScanResult result, float modifRssi) {
                List listF;
                Object objA;
                if (result != null) {
                    synchronized (MelodyBluetoothAdapter.mBluetoothRssiDetectCallbacks) {
                        listF = q.F(MelodyBluetoothAdapter.mBluetoothRssiDetectCallbacks);
                    }
                    Iterator it = listF.iterator();
                    while (it.hasNext()) {
                        try {
                            ((MelodyBluetoothRssiDetectCallback) it.next()).onRssiDetectResultCallback(result, modifRssi);
                            objA = l.f2618a;
                        } catch (Throwable th) {
                            objA = kotlin.b.a(th);
                        }
                        Throwable thA = Result.a(objA);
                        if (thA != null) {
                            A.i("MelodyBluetoothAdapter", "onRssiDetectResultCallback callback error", thA);
                        }
                    }
                }
            }
        };
    }

    private final void registerOplusBluetoothRssiDetectCallback() {
        Object objA;
        if (mOplusBluetoothRssiDetectCallbackRegistered) {
            return;
        }
        try {
            boolean z2 = false;
            if (S.j() >= 37) {
                ScanFilter.Builder builder = new ScanFilter.Builder();
                byte[] bArr = OPLUS_DATA;
                byte[] bArr2 = OPLUS_DATA_MASK;
                List listE = c.e(new ScanFilter[]{builder.setManufacturerData(1946, bArr, bArr2).build(), new ScanFilter.Builder().setManufacturerData(1839, bArr, bArr2).build(), new ScanFilter.Builder().setManufacturerData(41992, bArr, bArr2).build(), new ScanFilter.Builder().setServiceUuid(new ParcelUuid(ADV_SERVICE_UUID)).build()});
                OplusBluetoothAdapter mOplusBluetoothAdapter = getMOplusBluetoothAdapter();
                if (mOplusBluetoothAdapter != null && mOplusBluetoothAdapter.registerFilteredBluetoothRssiDetectCallback(getMOplusBluetoothRssiDetectCallback(), listE)) {
                    z2 = true;
                }
                mOplusBluetoothRssiDetectCallbackRegistered = z2;
                objA = l.f2618a;
            } else {
                OplusBluetoothAdapter mOplusBluetoothAdapter2 = getMOplusBluetoothAdapter();
                if (mOplusBluetoothAdapter2 != null && mOplusBluetoothAdapter2.registerOplusBluetoothRssiDetectCallback(getMOplusBluetoothRssiDetectCallback())) {
                    z2 = true;
                }
                mOplusBluetoothRssiDetectCallbackRegistered = z2;
                objA = l.f2618a;
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            A.c(TAG, new r(1));
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.i(TAG, "registerOplusBluetoothRssiDetectCallback failed", thA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String registerOplusBluetoothRssiDetectCallback$lambda$1$0() {
        return e.f("registerOplusBluetoothRssiDetectCallback registered=", mOplusBluetoothRssiDetectCallbackRegistered);
    }

    private final void unregisterOplusBluetoothRssiDetectCallback() {
        Object objA;
        if (mOplusBluetoothRssiDetectCallbackRegistered) {
            try {
                OplusBluetoothAdapter mOplusBluetoothAdapter = getMOplusBluetoothAdapter();
                if (mOplusBluetoothAdapter != null && mOplusBluetoothAdapter.unregisterOplusBluetoothRssiDetectCallback(getMOplusBluetoothRssiDetectCallback())) {
                    mOplusBluetoothRssiDetectCallbackRegistered = false;
                }
                objA = l.f2618a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                A.c(TAG, new com.oplus.melody.btsdk.protocol.commands.p(1));
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                A.i(TAG, "unregisterOplusBluetoothRssiDetectCallback failed", thA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String unregisterOplusBluetoothRssiDetectCallback$lambda$1$0() {
        return e.f("unregisterOplusBluetoothRssiDetectCallback registered=", mOplusBluetoothRssiDetectCallbackRegistered);
    }

    public final void registerBluetoothRssiDetectCallback(MelodyBluetoothRssiDetectCallback callback) {
        Object objA;
        boolean zAdd;
        h.e(callback, "callback");
        try {
            b<MelodyBluetoothRssiDetectCallback> bVar = mBluetoothRssiDetectCallbacks;
            synchronized (bVar) {
                try {
                    if (bVar.isEmpty()) {
                        unregisterOplusBluetoothRssiDetectCallback();
                        registerOplusBluetoothRssiDetectCallback();
                    }
                    zAdd = bVar.add(callback);
                } finally {
                }
            }
            objA = Boolean.valueOf(zAdd);
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.i(TAG, "registerBluetoothRssiDetectCallback failed", thA);
        }
    }

    public final void setPageScanInterval(int interval) {
        Object objA;
        OplusBluetoothAdapter mOplusBluetoothAdapter;
        try {
            if (S.j() >= 33 && (mOplusBluetoothAdapter = getMOplusBluetoothAdapter()) != null) {
                mOplusBluetoothAdapter.setPageScanInterval(interval);
            }
            objA = l.f2618a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.i(TAG, "setPageScanInterval", thA);
        }
    }

    public final void unregisterBluetoothRssiDetectCallback(MelodyBluetoothRssiDetectCallback callback) {
        Object objA;
        h.e(callback, "callback");
        try {
            b<MelodyBluetoothRssiDetectCallback> bVar = mBluetoothRssiDetectCallbacks;
            synchronized (bVar) {
                bVar.remove(callback);
                if (bVar.isEmpty()) {
                    unregisterOplusBluetoothRssiDetectCallback();
                }
            }
            objA = l.f2618a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.i(TAG, "unregisterBluetoothRssiDetectCallback failed", thA);
        }
    }
}
