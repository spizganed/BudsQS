package com.oplus.melody.btsdk.protocol.commands;

import android.os.Handler;
import b7.d;
import com.oplus.melody.btsdk.api.data.BluetoothReceiveData;
import com.oplus.melody.btsdk.api.data.SetCommandStateInfo;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import f7.C1046a;
import f7.C1047b;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SetCommandManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HeadsetCoreService f19335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f19336c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1047b f19334a = C1047b.a.f23117a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b7.d f19337d = d.a.f13069a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, WeakReference<d>> f19338e = new ConcurrentHashMap<>();

    public s(HeadsetCoreService headsetCoreService, Handler handler) {
        this.f19336c = handler;
        this.f19335b = headsetCoreService;
    }

    public final void a(String str, C1046a c1046a, int i10) {
        d dVar;
        SetCommandStateInfo setCommandStateInfo = new SetCommandStateInfo();
        setCommandStateInfo.mAddress = str;
        setCommandStateInfo.mSetStatus = i10;
        setCommandStateInfo.mResponseCommand = c1046a.f23110a;
        byte[] bArr = c1046a.f23113d;
        if (bArr != null && bArr.length > 1) {
            setCommandStateInfo.mRspValue = bArr[1];
        }
        BluetoothReceiveData bluetoothReceiveData = new BluetoothReceiveData(1048576, setCommandStateInfo);
        HeadsetCoreService.d.f19289a.getClass();
        HeadsetCoreService.m0(bluetoothReceiveData);
        WeakReference<d> weakReferenceRemove = this.f19338e.remove(Integer.valueOf(c1046a.a()));
        if (weakReferenceRemove == null || (dVar = weakReferenceRemove.get()) == null) {
            return;
        }
        if (i10 == 0) {
            dVar.a();
        } else {
            dVar.b();
        }
    }
}
