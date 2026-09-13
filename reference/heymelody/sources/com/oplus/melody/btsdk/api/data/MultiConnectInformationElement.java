package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: MultiConnectInformationElement.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003JS\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0006\u0010(\u001a\u00020\u0007J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001c\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018¨\u0006/"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/MultiConnectInformationElement;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "deviceName", "connectionState", "", "isCurrentDevice", "", "isMainAudioDevice", "isAudioActive", "deviceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZZI)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getDeviceName", "setDeviceName", "getConnectionState", "()I", "setConnectionState", "(I)V", "()Z", "setCurrentDevice", "(Z)V", "setMainAudioDevice", "setAudioActive", "getDeviceType", "setDeviceType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MultiConnectInformationElement extends a implements Parcelable {
    public static final int LENGTH_ADDRESS = 6;
    public static final int LENGTH_FLAG = 1;
    public static final int LENGTH_LENGTH = 1;
    public static final int LENGTH_NAME_LENGTH = 1;
    public static final int LENGTH_STATE = 1;
    private String address;
    private int connectionState;
    private String deviceName;
    private int deviceType;
    private boolean isAudioActive;
    private boolean isCurrentDevice;
    private boolean isMainAudioDevice;
    public static final Parcelable.Creator<MultiConnectInformationElement> CREATOR = new b();

    /* JADX INFO: compiled from: MultiConnectInformationElement.kt */
    public static final class b implements Parcelable.Creator<MultiConnectInformationElement> {
        @Override // android.os.Parcelable.Creator
        public final MultiConnectInformationElement createFromParcel(Parcel parcel) {
            boolean z2;
            boolean z4;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            boolean z10 = false;
            boolean z11 = true;
            if (parcel.readInt() != 0) {
                z2 = false;
                z10 = true;
            } else {
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z4 = true;
            } else {
                z4 = true;
                z11 = z2;
            }
            if (parcel.readInt() == 0) {
                z4 = z2;
            }
            return new MultiConnectInformationElement(string, string2, i10, z10, z11, z4, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final MultiConnectInformationElement[] newArray(int i10) {
            return new MultiConnectInformationElement[i10];
        }
    }

    public MultiConnectInformationElement(String str, String str2, int i10, boolean z2, boolean z4, boolean z10, int i11) {
        this.address = str;
        this.deviceName = str2;
        this.connectionState = i10;
        this.isCurrentDevice = z2;
        this.isMainAudioDevice = z4;
        this.isAudioActive = z10;
        this.deviceType = i11;
    }

    public static /* synthetic */ MultiConnectInformationElement copy$default(MultiConnectInformationElement multiConnectInformationElement, String str, String str2, int i10, boolean z2, boolean z4, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = multiConnectInformationElement.address;
        }
        if ((i12 & 2) != 0) {
            str2 = multiConnectInformationElement.deviceName;
        }
        if ((i12 & 4) != 0) {
            i10 = multiConnectInformationElement.connectionState;
        }
        if ((i12 & 8) != 0) {
            z2 = multiConnectInformationElement.isCurrentDevice;
        }
        if ((i12 & 16) != 0) {
            z4 = multiConnectInformationElement.isMainAudioDevice;
        }
        if ((i12 & 32) != 0) {
            z10 = multiConnectInformationElement.isAudioActive;
        }
        if ((i12 & 64) != 0) {
            i11 = multiConnectInformationElement.deviceType;
        }
        boolean z11 = z10;
        int i13 = i11;
        boolean z12 = z4;
        int i14 = i10;
        return multiConnectInformationElement.copy(str, str2, i14, z2, z12, z11, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getConnectionState() {
        return this.connectionState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsCurrentDevice() {
        return this.isCurrentDevice;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsMainAudioDevice() {
        return this.isMainAudioDevice;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsAudioActive() {
        return this.isAudioActive;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    public final MultiConnectInformationElement copy(String address, String deviceName, int connectionState, boolean isCurrentDevice, boolean isMainAudioDevice, boolean isAudioActive, int deviceType) {
        return new MultiConnectInformationElement(address, deviceName, connectionState, isCurrentDevice, isMainAudioDevice, isAudioActive, deviceType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getConnectionState() {
        return this.connectionState;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final boolean isAudioActive() {
        return this.isAudioActive;
    }

    public final boolean isCurrentDevice() {
        return this.isCurrentDevice;
    }

    public final boolean isMainAudioDevice() {
        return this.isMainAudioDevice;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setAudioActive(boolean z2) {
        this.isAudioActive = z2;
    }

    public final void setConnectionState(int i10) {
        this.connectionState = i10;
    }

    public final void setCurrentDevice(boolean z2) {
        this.isCurrentDevice = z2;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public final void setMainAudioDevice(boolean z2) {
        this.isMainAudioDevice = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeString(this.deviceName);
        dest.writeInt(this.connectionState);
        dest.writeInt(this.isCurrentDevice ? 1 : 0);
        dest.writeInt(this.isMainAudioDevice ? 1 : 0);
        dest.writeInt(this.isAudioActive ? 1 : 0);
        dest.writeInt(this.deviceType);
    }
}
