package com.oplus.melody.btsdk.api.data;

import A6.f;
import D5.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: OneshotExeResultInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0010H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006*"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/OneshotExeResultInfo;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "TAG", "", "mAddress", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mWakeupTime", "", "getMWakeupTime", "()I", "setMWakeupTime", "(I)V", "mEncodeTime", "getMEncodeTime", "setMEncodeTime", "mSendingTime", "getMSendingTime", "setMSendingTime", "mWakeupLen", "getMWakeupLen", "setMWakeupLen", "initData", "", "address", ClientDataEntity.COL_DATA, "", "dataOffset", "writeToParcel", "", "dest", "flags", "describeContents", "CREATOR", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OneshotExeResultInfo extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private final String TAG;
    private String mAddress;
    private int mEncodeTime;
    private int mSendingTime;
    private int mWakeupLen;
    private int mWakeupTime;

    /* JADX INFO: renamed from: com.oplus.melody.btsdk.api.data.OneshotExeResultInfo$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: OneshotExeResultInfo.kt */
    public static final class Companion implements Parcelable.Creator<OneshotAudioDataInfo> {
        @Override // android.os.Parcelable.Creator
        public final OneshotAudioDataInfo createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new OneshotAudioDataInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final OneshotAudioDataInfo[] newArray(int i10) {
            return new OneshotAudioDataInfo[i10];
        }
    }

    public OneshotExeResultInfo() {
        this.TAG = "OneshotExeResultInfo";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getMAddress() {
        return this.mAddress;
    }

    public final int getMEncodeTime() {
        return this.mEncodeTime;
    }

    public final int getMSendingTime() {
        return this.mSendingTime;
    }

    public final int getMWakeupLen() {
        return this.mWakeupLen;
    }

    public final int getMWakeupTime() {
        return this.mWakeupTime;
    }

    public final boolean initData(String address, byte[] data, int dataOffset) {
        h.e(address, "address");
        h.e(data, "data");
        this.mAddress = address;
        if (dataOffset + 10 > data.length) {
            f.g(dataOffset, "initData offset not valid before parse mWakeupTime, offset = ", this.TAG);
            return false;
        }
        this.mWakeupTime = c.p(data, dataOffset, 2, true);
        this.mEncodeTime = c.p(data, dataOffset + 2, 2, true);
        this.mSendingTime = c.p(data, dataOffset + 4, 2, true);
        this.mWakeupLen = c.p(data, dataOffset + 6, 4, true);
        return true;
    }

    public final void setMAddress(String str) {
        this.mAddress = str;
    }

    public final void setMEncodeTime(int i10) {
        this.mEncodeTime = i10;
    }

    public final void setMSendingTime(int i10) {
        this.mSendingTime = i10;
    }

    public final void setMWakeupLen(int i10) {
        this.mWakeupLen = i10;
    }

    public final void setMWakeupTime(int i10) {
        this.mWakeupTime = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.mAddress);
        dest.writeInt(this.mWakeupTime);
        dest.writeInt(this.mEncodeTime);
        dest.writeInt(this.mSendingTime);
        dest.writeInt(this.mWakeupLen);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneshotExeResultInfo(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        this.mAddress = parcel.readString();
        this.mWakeupTime = parcel.readInt();
        this.mEncodeTime = parcel.readInt();
        this.mSendingTime = parcel.readInt();
        this.mWakeupLen = parcel.readInt();
    }
}
