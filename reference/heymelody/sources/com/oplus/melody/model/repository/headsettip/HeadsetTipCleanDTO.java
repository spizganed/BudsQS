package com.oplus.melody.model.repository.headsettip;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeadsetTipCleanDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000fJ\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0015J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/oplus/melody/model/repository/headsettip/HeadsetTipCleanDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mEnable", "", "getMEnable", "()Z", "setMEnable", "(Z)V", "mTime", "", "getMTime", "()J", "setMTime", "(J)V", "getAddress", "setAddress", "", "address", "getEnable", "setEnable", "enable", "getTime", "setTime", "time", "writeToParcel", "flags", "", "describeContents", "CREATOR", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadsetTipCleanDTO extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private String mAddress;
    private boolean mEnable;
    private long mTime;

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.headsettip.HeadsetTipCleanDTO$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: HeadsetTipCleanDTO.kt */
    public static final class Companion implements Parcelable.Creator<HeadsetTipCleanDTO> {
        @Override // android.os.Parcelable.Creator
        public final HeadsetTipCleanDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new HeadsetTipCleanDTO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HeadsetTipCleanDTO[] newArray(int i10) {
            return new HeadsetTipCleanDTO[i10];
        }
    }

    public HeadsetTipCleanDTO() {
        this.mAddress = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: getAddress, reason: from getter */
    public final String getMAddress() {
        return this.mAddress;
    }

    /* JADX INFO: renamed from: getEnable, reason: from getter */
    public final boolean getMEnable() {
        return this.mEnable;
    }

    public final String getMAddress() {
        return this.mAddress;
    }

    public final boolean getMEnable() {
        return this.mEnable;
    }

    public final long getMTime() {
        return this.mTime;
    }

    public final long getTime() {
        return this.mTime;
    }

    public final void setAddress(String address) {
        h.e(address, "address");
        this.mAddress = address;
    }

    public final void setEnable(boolean enable) {
        this.mEnable = enable;
    }

    public final void setMAddress(String str) {
        h.e(str, "<set-?>");
        this.mAddress = str;
    }

    public final void setMEnable(boolean z2) {
        this.mEnable = z2;
    }

    public final void setMTime(long j5) {
        this.mTime = j5;
    }

    public final void setTime(long time) {
        this.mTime = time;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        h.e(parcel, "parcel");
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mEnable ? 1 : 0);
        parcel.writeLong(this.mTime);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadsetTipCleanDTO(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        String string = parcel.readString();
        this.mAddress = string == null ? "" : string;
        this.mEnable = parcel.readInt() != 0;
        this.mTime = parcel.readLong();
    }
}
