package com.oplus.melody.btbase.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: BtDataReceived.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0011J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/btbase/domain/model/BtDataReceived;", "Landroid/os/Parcelable;", "device", "Lcom/oplus/melody/btbase/domain/model/BtDevice;", ClientDataEntity.COL_DATA, "", "<init>", "(Lcom/oplus/melody/btbase/domain/model/BtDevice;[B)V", "getDevice", "()Lcom/oplus/melody/btbase/domain/model/BtDevice;", "getData", "()[B", "equals", "", "other", "", "hashCode", "", "component1", "component2", "copy", "describeContents", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btbase_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BtDataReceived implements Parcelable {
    public static final Parcelable.Creator<BtDataReceived> CREATOR = new a();
    private final byte[] data;
    private final BtDevice device;

    /* JADX INFO: compiled from: BtDataReceived.kt */
    public static final class a implements Parcelable.Creator<BtDataReceived> {
        @Override // android.os.Parcelable.Creator
        public final BtDataReceived createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new BtDataReceived(BtDevice.CREATOR.createFromParcel(parcel), parcel.createByteArray());
        }

        @Override // android.os.Parcelable.Creator
        public final BtDataReceived[] newArray(int i10) {
            return new BtDataReceived[i10];
        }
    }

    public BtDataReceived(BtDevice device, byte[] data) {
        h.e(device, "device");
        h.e(data, "data");
        this.device = device;
        this.data = data;
    }

    public static /* synthetic */ BtDataReceived copy$default(BtDataReceived btDataReceived, BtDevice btDevice, byte[] bArr, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            btDevice = btDataReceived.device;
        }
        if ((i10 & 2) != 0) {
            bArr = btDataReceived.data;
        }
        return btDataReceived.copy(btDevice, bArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BtDevice getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public final BtDataReceived copy(BtDevice device, byte[] data) {
        h.e(device, "device");
        h.e(data, "data");
        return new BtDataReceived(device, data);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!BtDataReceived.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        h.c(other, "null cannot be cast to non-null type com.oplus.melody.btbase.domain.model.BtDataReceived");
        BtDataReceived btDataReceived = (BtDataReceived) other;
        return h.a(this.device, btDataReceived.device) && Arrays.equals(this.data, btDataReceived.data);
    }

    public final byte[] getData() {
        return this.data;
    }

    public final BtDevice getDevice() {
        return this.device;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data) + (this.device.hashCode() * 31);
    }

    public String toString() {
        return "BtDataReceived(device=" + this.device + ", data=" + Arrays.toString(this.data) + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        this.device.writeToParcel(dest, flags);
        dest.writeByteArray(this.data);
    }
}
