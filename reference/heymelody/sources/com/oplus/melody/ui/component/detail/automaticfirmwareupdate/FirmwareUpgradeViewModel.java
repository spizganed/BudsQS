package com.oplus.melody.ui.component.detail.automaticfirmwareupdate;

import O7.l;
import R8.y;
import c8.AbstractC0763a;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.base.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: FirmwareUpgradeViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0010\u001a\u00020\u000bJ\"\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0018\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J4\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fJ\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010&\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010(\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010)\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0010\u001a\u00020\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/oplus/melody/ui/component/detail/automaticfirmwareupdate/FirmwareUpgradeViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "mDownloadProgress", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "getFirmwareUpgradeLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/model/repository/firmware/FirmwareDTO;", "address", "", "getFirmwareUpgradeStateLiveData", "Lcom/oplus/melody/model/repository/firmware/FirmwareUpgradeStateDTO;", "setAutoFirmwareUpdateSwitch", "", "macAddress", "switchValue", "getVersionInfoList", "Lcom/oplus/melody/ui/component/detail/firmwareversion/FirmwareVersionVO;", "initHeadsetVersion", "context", "Landroid/content/Context;", "deviceName", "requestDeviceVersion", "getDownloadProgress", "startCheckUpgrade", "Ljava/util/concurrent/CompletableFuture;", "productId", "versionStr", "versionList", "", "Lcom/oplus/melody/model/repository/earphone/DeviceVersionDTO;", "startForegroundUpgrade", "Ljava/lang/Void;", "firmwareDTO", "isBackgroundUpgrading", "", "cancelUpgrade", "getUpgradeStatus", "getUpgradeType", "doLocalUpgrade", "file", "Ljava/io/File;", "getConnectionState", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FirmwareUpgradeViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Integer> f20640b = new l<>();

    public static int d(String macAddress) {
        h.e(macAddress, "macAddress");
        int iG = AbstractC0763a.e().g(macAddress);
        A.c("FirmwareUpgradeViewModel", new y(iG, macAddress, 0));
        return iG;
    }
}
