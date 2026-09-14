package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: SimpleStateInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0005J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/SimpleStateInfo;", "Landroid/os/Parcelable;", "address", "", "state", "", "<init>", "(Ljava/lang/String;I)V", "getAddress", "()Ljava/lang/String;", "getState", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SimpleStateInfo implements Parcelable {
    public static final Parcelable.Creator<SimpleStateInfo> CREATOR = new a();
    private final String address;
    private final int state;

    /* JADX INFO: compiled from: SimpleStateInfo.kt */
    public static final class a implements Parcelable.Creator<SimpleStateInfo> {
        @Override // android.os.Parcelable.Creator
        public final SimpleStateInfo createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new SimpleStateInfo(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleStateInfo[] newArray(int i10) {
            return new SimpleStateInfo[i10];
        }
    }

    public SimpleStateInfo(String address, int i10) {
        h.e(address, "address");
        this.address = address;
        this.state = i10;
    }

    public static /* synthetic */ SimpleStateInfo copy$default(SimpleStateInfo simpleStateInfo, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = simpleStateInfo.address;
        }
        if ((i11 & 2) != 0) {
            i10 = simpleStateInfo.state;
        }
        return simpleStateInfo.copy(str, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public final SimpleStateInfo copy(String address, int state) {
        h.e(address, "address");
        return new SimpleStateInfo(address, state);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleStateInfo)) {
            return false;
        }
        SimpleStateInfo simpleStateInfo = (SimpleStateInfo) other;
        return h.a(this.address, simpleStateInfo.address) && this.state == simpleStateInfo.state;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return Integer.hashCode(this.state) + (this.address.hashCode() * 31);
    }

    public String toString() {
        return "SimpleStateInfo(address=" + this.address + ", state=" + this.state + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeInt(this.state);
    }

    public /* synthetic */ SimpleStateInfo(String str, int i10, int i11, d dVar) {
        this(str, (i11 & 2) != 0 ? 0 : i10);
    }
}
