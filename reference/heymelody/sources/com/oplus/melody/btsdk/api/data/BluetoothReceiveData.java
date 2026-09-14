package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: BluetoothReceiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0002B\u001d\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/BluetoothReceiveData;", "T", "Landroid/os/Parcelable;", "Lcom/oplus/melody/common/data/BaseBean;", DcsCompatEventConverter.EVT_EVENT_ID, "", ClientDataEntity.COL_DATA, "<init>", "(ILandroid/os/Parcelable;)V", "getEventId", "()I", "getData", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "component1", "component2", "copy", "(ILandroid/os/Parcelable;)Lcom/oplus/melody/btsdk/api/data/BluetoothReceiveData;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BluetoothReceiveData<T extends Parcelable> extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<BluetoothReceiveData<?>> CREATOR = new a();
    private final T data;
    private final int eventId;

    /* JADX INFO: compiled from: BluetoothReceiveData.kt */
    public static final class a implements Parcelable.Creator<BluetoothReceiveData<?>> {
        @Override // android.os.Parcelable.Creator
        public final BluetoothReceiveData<?> createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new BluetoothReceiveData<>(parcel.readInt(), parcel.readParcelable(BluetoothReceiveData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final BluetoothReceiveData<?>[] newArray(int i10) {
            return new BluetoothReceiveData[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BluetoothReceiveData() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BluetoothReceiveData copy$default(BluetoothReceiveData bluetoothReceiveData, int i10, Parcelable parcelable, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = bluetoothReceiveData.eventId;
        }
        if ((i11 & 2) != 0) {
            parcelable = bluetoothReceiveData.data;
        }
        return bluetoothReceiveData.copy(i10, parcelable);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEventId() {
        return this.eventId;
    }

    public final T component2() {
        return this.data;
    }

    public final BluetoothReceiveData<T> copy(int eventId, T data) {
        return new BluetoothReceiveData<>(eventId, data);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final T getData() {
        return this.data;
    }

    public final int getEventId() {
        return this.eventId;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeInt(this.eventId);
        dest.writeParcelable(this.data, flags);
    }

    public BluetoothReceiveData(int i10, T t10) {
        this.eventId = i10;
        this.data = t10;
    }

    public /* synthetic */ BluetoothReceiveData(int i10, Parcelable parcelable, int i11, d dVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : parcelable);
    }
}
