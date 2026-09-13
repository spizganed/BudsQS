package com.oplus.melody.btsdk.protocol.commands;

import android.os.Handler;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import f7.C1047b;

/* JADX INFO: compiled from: RequestCommandManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f19315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1047b f19316b = C1047b.a.f23117a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HeadsetCoreService f19317c;

    public j(HeadsetCoreService headsetCoreService, Handler handler) {
        this.f19315a = handler;
        this.f19317c = headsetCoreService;
    }
}
