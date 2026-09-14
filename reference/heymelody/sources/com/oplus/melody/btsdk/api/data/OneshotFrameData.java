package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: OneshotFrameData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/OneshotFrameData;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mSeqNum", "", "getMSeqNum", "()I", "setMSeqNum", "(I)V", "mAudioDataSize", "getMAudioDataSize", "setMAudioDataSize", "mAudioData", "", "getMAudioData", "()[B", "setMAudioData", "([B)V", "writeToParcel", "", "flags", "describeContents", "CREATOR", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OneshotFrameData extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private byte[] mAudioData;
    private int mAudioDataSize;
    private int mSeqNum;

    /* JADX INFO: renamed from: com.oplus.melody.btsdk.api.data.OneshotFrameData$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: OneshotFrameData.kt */
    public static final class Companion implements Parcelable.Creator<OneshotFrameData> {
        @Override // android.os.Parcelable.Creator
        public final OneshotFrameData createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new OneshotFrameData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final OneshotFrameData[] newArray(int i10) {
            return new OneshotFrameData[i10];
        }
    }

    public OneshotFrameData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final byte[] getMAudioData() {
        return this.mAudioData;
    }

    public final int getMAudioDataSize() {
        return this.mAudioDataSize;
    }

    public final int getMSeqNum() {
        return this.mSeqNum;
    }

    public final void setMAudioData(byte[] bArr) {
        this.mAudioData = bArr;
    }

    public final void setMAudioDataSize(int i10) {
        this.mAudioDataSize = i10;
    }

    public final void setMSeqNum(int i10) {
        this.mSeqNum = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        h.e(parcel, "parcel");
        parcel.writeInt(this.mSeqNum);
        parcel.writeInt(this.mAudioDataSize);
        parcel.writeByteArray(this.mAudioData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneshotFrameData(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        this.mSeqNum = parcel.readInt();
        int i10 = parcel.readInt();
        this.mAudioDataSize = i10;
        byte[] bArr = new byte[i10];
        this.mAudioData = bArr;
        parcel.readByteArray(bArr);
    }
}
