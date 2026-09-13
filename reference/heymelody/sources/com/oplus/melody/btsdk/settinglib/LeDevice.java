package com.oplus.melody.btsdk.settinglib;

import D7.o0;
import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.e;
import com.oplus.melody.btsdk.api.data.BluetoothReceiveData;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.manager.DeviceInfoManager;
import com.oplus.melody.btsdk.multidevice.HeadsetCoreService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: LeDevice.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/oplus/melody/btsdk/settinglib/LeDevice;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "mainAddress", "", "subAddress", "isLeOpen", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getMainAddress", "()Ljava/lang/String;", "setMainAddress", "(Ljava/lang/String;)V", "getSubAddress", "setSubAddress", "()Z", "setLeOpen", "(Z)V", "notifyAndSetLeOpen", "", "open", "component1", "component2", "component3", "copy", "describeContents", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LeDevice extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<LeDevice> CREATOR = new a();
    private boolean isLeOpen;
    private String mainAddress;
    private String subAddress;

    /* JADX INFO: compiled from: LeDevice.kt */
    public static final class a implements Parcelable.Creator<LeDevice> {
        @Override // android.os.Parcelable.Creator
        public final LeDevice createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new LeDevice(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final LeDevice[] newArray(int i10) {
            return new LeDevice[i10];
        }
    }

    public LeDevice() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ LeDevice copy$default(LeDevice leDevice, String str, String str2, boolean z2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = leDevice.mainAddress;
        }
        if ((i10 & 2) != 0) {
            str2 = leDevice.subAddress;
        }
        if ((i10 & 4) != 0) {
            z2 = leDevice.isLeOpen;
        }
        return leDevice.copy(str, str2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyAndSetLeOpen$lambda$0(LeDevice leDevice, boolean z2) {
        DeviceInfo deviceInfoF = DeviceInfoManager.a.f19280a.f(leDevice.mainAddress);
        HeadsetCoreService headsetCoreService = HeadsetCoreService.d.f19289a;
        BluetoothReceiveData bluetoothReceiveData = new BluetoothReceiveData(1048671, deviceInfoF);
        headsetCoreService.getClass();
        HeadsetCoreService.m0(bluetoothReceiveData);
        if (z2) {
            return;
        }
        deviceInfoF.setDeviceLeAudioConnectState(3);
        if (BluetoothAdapter.checkBluetoothAddress(leDevice.subAddress)) {
            deviceInfoF.setDeviceLeAudioConnectState(leDevice.subAddress, 3);
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMainAddress() {
        return this.mainAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubAddress() {
        return this.subAddress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLeOpen() {
        return this.isLeOpen;
    }

    public final LeDevice copy(String mainAddress, String subAddress, boolean isLeOpen) {
        return new LeDevice(mainAddress, subAddress, isLeOpen);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getMainAddress() {
        return this.mainAddress;
    }

    public final String getSubAddress() {
        return this.subAddress;
    }

    public final boolean isLeOpen() {
        return this.isLeOpen;
    }

    public final void notifyAndSetLeOpen(boolean open) {
        this.isLeOpen = open;
        o0.b.f1142a.schedule(new e(this, open, 3), 1L, TimeUnit.SECONDS);
    }

    public final void setLeOpen(boolean z2) {
        this.isLeOpen = z2;
    }

    public final void setMainAddress(String str) {
        this.mainAddress = str;
    }

    public final void setSubAddress(String str) {
        this.subAddress = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.mainAddress);
        dest.writeString(this.subAddress);
        dest.writeInt(this.isLeOpen ? 1 : 0);
    }

    public LeDevice(String str, String str2, boolean z2) {
        this.mainAddress = str;
        this.subAddress = str2;
        this.isLeOpen = z2;
    }

    public /* synthetic */ LeDevice(String str, String str2, boolean z2, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? false : z2);
    }
}
