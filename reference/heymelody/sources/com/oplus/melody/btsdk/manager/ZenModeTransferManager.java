package com.oplus.melody.btsdk.manager;

import A9.h;
import D7.o0;
import android.text.TextUtils;
import com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation;
import com.oplus.melody.btsdk.manager.ZenModeTransferManager;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import com.oplus.melody.btsdk.ota.IUpgradeListener;
import java.io.File;
import java.lang.ref.WeakReference;
import z7.C1725a;

/* JADX INFO: loaded from: classes.dex */
public final class ZenModeTransferManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeadsetCoreService f19281a;

    public ZenModeTransferManager(HeadsetCoreService headsetCoreService) {
        this.f19281a = headsetCoreService;
    }

    public final void a(String str, File file, ZenModeFileVertifyInformation zenModeFileVertifyInformation) {
        boolean zK0;
        if (TextUtils.isEmpty(str)) {
            C1725a.f("ZenModeTransferManager", "start ZenModeTransfer address is empty");
            return;
        }
        HeadsetCoreService headsetCoreService = this.f19281a;
        if (str == null) {
            zK0 = false;
        } else {
            zK0 = headsetCoreService.k0(str);
            C1725a.d("ZenModeTransferManager", new h(7, zK0), str);
        }
        if (zK0) {
            headsetCoreService.p(new UpgradeListener(this, str, file, zenModeFileVertifyInformation));
            headsetCoreService.r(str);
        } else {
            C1725a.b("ZenModeTransferManager", "start ZenMode transfer", str);
            headsetCoreService.j1(str, file, zenModeFileVertifyInformation);
        }
    }

    public static final class UpgradeListener implements IUpgradeListener {
        private boolean mFinished;
        private final ZenModeFileVertifyInformation mInformation;
        private final File mLocalFileName;
        private final String mMacAddress;
        private final WeakReference<ZenModeTransferManager> mManager;

        public UpgradeListener(ZenModeTransferManager zenModeTransferManager, String str, File file, ZenModeFileVertifyInformation zenModeFileVertifyInformation) {
            this.mMacAddress = str;
            this.mLocalFileName = file;
            this.mInformation = zenModeFileVertifyInformation;
            this.mManager = new WeakReference<>(zenModeTransferManager);
        }

        public static /* synthetic */ void a(UpgradeListener upgradeListener) {
            ZenModeTransferManager zenModeTransferManager = upgradeListener.mManager.get();
            if (zenModeTransferManager != null) {
                C1725a.a("ZenModeTransferManager", "start ZenMode transfer");
                zenModeTransferManager.a(upgradeListener.mMacAddress, upgradeListener.mLocalFileName, upgradeListener.mInformation);
            }
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void S(int i10, String str) {
            if (this.mFinished) {
                return;
            }
            this.mFinished = true;
            o0.c.f1143a.postDelayed(new Runnable() { // from class: com.oplus.melody.btsdk.manager.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZenModeTransferManager.UpgradeListener.a(this.f19282a);
                }
            }, 4000L);
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void c(String str) {
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void b(int i10, String str) {
        }
    }
}
