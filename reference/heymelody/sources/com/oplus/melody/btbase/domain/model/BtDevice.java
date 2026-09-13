package com.oplus.melody.btbase.domain.model;

import Y.r;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: BtDevice.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001%B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\bJ\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/oplus/melody/btbase/domain/model/BtDevice;", "Landroid/os/Parcelable;", "address", "", "name", SpeechFindManager.TYPE, "Lcom/oplus/melody/btbase/domain/model/BtDevice$Type;", "rssi", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/oplus/melody/btbase/domain/model/BtDevice$Type;Ljava/lang/Integer;)V", "getAddress", "()Ljava/lang/String;", "getName", "getType", "()Lcom/oplus/melody/btbase/domain/model/BtDevice$Type;", "getRssi", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/oplus/melody/btbase/domain/model/BtDevice$Type;Ljava/lang/Integer;)Lcom/oplus/melody/btbase/domain/model/BtDevice;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Type", "btbase_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class BtDevice implements Parcelable {
    public static final Parcelable.Creator<BtDevice> CREATOR = new a();
    private final String address;
    private final String name;
    private final Integer rssi;
    private final Type type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: BtDevice.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/oplus/melody/btbase/domain/model/BtDevice$Type;", "", "<init>", "(Ljava/lang/String;I)V", "CLASSIC", "BLE", "btbase_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f19272a = {new Type("CLASSIC", 0), new Type("BLE", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public Type() {
            throw null;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f19272a.clone();
        }
    }

    /* JADX INFO: compiled from: BtDevice.kt */
    public static final class a implements Parcelable.Creator<BtDevice> {
        @Override // android.os.Parcelable.Creator
        public final BtDevice createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new BtDevice(parcel.readString(), parcel.readString(), Type.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final BtDevice[] newArray(int i10) {
            return new BtDevice[i10];
        }
    }

    public BtDevice(String address, String str, Type type, Integer num) {
        h.e(address, "address");
        h.e(type, "type");
        this.address = address;
        this.name = str;
        this.type = type;
        this.rssi = num;
    }

    public static /* synthetic */ BtDevice copy$default(BtDevice btDevice, String str, String str2, Type type, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = btDevice.address;
        }
        if ((i10 & 2) != 0) {
            str2 = btDevice.name;
        }
        if ((i10 & 4) != 0) {
            type = btDevice.type;
        }
        if ((i10 & 8) != 0) {
            num = btDevice.rssi;
        }
        return btDevice.copy(str, str2, type, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getRssi() {
        return this.rssi;
    }

    public final BtDevice copy(String address, String name, Type type, Integer rssi) {
        h.e(address, "address");
        h.e(type, "type");
        return new BtDevice(address, name, type, rssi);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BtDevice)) {
            return false;
        }
        BtDevice btDevice = (BtDevice) other;
        return h.a(this.address, btDevice.address) && h.a(this.name, btDevice.name) && this.type == btDevice.type && h.a(this.rssi, btDevice.rssi);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getRssi() {
        return this.rssi;
    }

    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.address.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (this.type.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        Integer num = this.rssi;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        String str = this.address;
        String str2 = this.name;
        Type type = this.type;
        Integer num = this.rssi;
        StringBuilder sbI = r.i("BtDevice(address=", str, ", name=", str2, ", type=");
        sbI.append(type);
        sbI.append(", rssi=");
        sbI.append(num);
        sbI.append(")");
        return sbI.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeString(this.name);
        dest.writeString(this.type.name());
        Integer num = this.rssi;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    public /* synthetic */ BtDevice(String str, String str2, Type type, Integer num, int i10, d dVar) {
        this(str, str2, type, (i10 & 8) != 0 ? null : num);
    }
}
