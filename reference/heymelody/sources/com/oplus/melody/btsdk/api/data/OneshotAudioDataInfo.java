package com.oplus.melody.btsdk.api.data;

import A6.f;
import D5.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.data.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import z7.C1725a;

/* JADX INFO: compiled from: OneshotAudioDataInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0010J\u0018\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0016H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u0004\u0018\u00010\tJ\u0006\u00100\u001a\u00020\u0016J\u0006\u00101\u001a\u00020\u0016J\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!J\b\u00103\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR*\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/OneshotAudioDataInfo;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "TAG", "", "mAddress", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mOriginData", "", "getMOriginData", "()[B", "setMOriginData", "([B)V", "mFrameNum", "", "getMFrameNum", "()I", "setMFrameNum", "(I)V", "mChannelNum", "getMChannelNum", "setMChannelNum", "mFrameDataList", "Ljava/util/ArrayList;", "Lcom/oplus/melody/btsdk/api/data/OneshotFrameData;", "Lkotlin/collections/ArrayList;", "getMFrameDataList", "()Ljava/util/ArrayList;", "setMFrameDataList", "(Ljava/util/ArrayList;)V", "initData", "", "address", "dataOffset", ClientDataEntity.COL_DATA, "writeToParcel", "dest", "flags", "describeContents", "getAddress", "getFrameNum", "getChannelNum", "getFrameDataList", "getOriginData", "CREATOR", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OneshotAudioDataInfo extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private final String TAG;
    private String mAddress;
    private int mChannelNum;
    private ArrayList<OneshotFrameData> mFrameDataList;
    private int mFrameNum;
    private byte[] mOriginData;

    /* JADX INFO: renamed from: com.oplus.melody.btsdk.api.data.OneshotAudioDataInfo$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: OneshotAudioDataInfo.kt */
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

    public OneshotAudioDataInfo() {
        this.TAG = "OneshotAudioDataInfo";
        this.mFrameDataList = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: getAddress, reason: from getter */
    public final String getMAddress() {
        return this.mAddress;
    }

    /* JADX INFO: renamed from: getChannelNum, reason: from getter */
    public final int getMChannelNum() {
        return this.mChannelNum;
    }

    public final ArrayList<OneshotFrameData> getFrameDataList() {
        return this.mFrameDataList;
    }

    /* JADX INFO: renamed from: getFrameNum, reason: from getter */
    public final int getMFrameNum() {
        return this.mFrameNum;
    }

    public final String getMAddress() {
        return this.mAddress;
    }

    public final int getMChannelNum() {
        return this.mChannelNum;
    }

    public final ArrayList<OneshotFrameData> getMFrameDataList() {
        return this.mFrameDataList;
    }

    public final int getMFrameNum() {
        return this.mFrameNum;
    }

    public final byte[] getMOriginData() {
        return this.mOriginData;
    }

    public final byte[] getOriginData() {
        return this.mOriginData;
    }

    public final void initData(String address, int dataOffset, byte[] data) {
        h.e(address, "address");
        h.e(data, "data");
        this.mOriginData = data;
        this.mAddress = address;
        if (dataOffset + 1 >= data.length) {
            f.g(dataOffset, "initData offset not valid before parse mFrameNum, offset = ", this.TAG);
            return;
        }
        this.mFrameNum = c.p(data, dataOffset, 2, true);
        int i10 = dataOffset + 2;
        if (dataOffset + 3 >= data.length) {
            f.g(i10, "initData offset not valid before parse channelCode, offset = ", this.TAG);
            return;
        }
        this.mChannelNum = c.p(data, i10, 2, true) == 1 ? 1 : 2;
        int i11 = dataOffset + 4;
        int i12 = this.mFrameNum;
        if (i12 <= 0) {
            f.g(i12, "initData mFrameNum not valid!, mFrameNum = ", this.TAG);
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i11 + 2;
            if (i14 >= data.length) {
                f.g(i11, "initData offset not valid before parse seq num, offset = ", this.TAG);
                return;
            }
            int iP = c.p(data, i11, 2, true);
            if (i11 + 3 >= data.length) {
                f.g(i14, "initData offset not valid before parse data size, offset = ", this.TAG);
                return;
            }
            int iP2 = c.p(data, i14, 1, true);
            if (iP2 <= 0) {
                f.g(iP2, "initData dataSize not valid!, dataSize = ", this.TAG);
                return;
            }
            int i15 = i11 + 4;
            int i16 = i15 + iP2;
            if (i16 - 1 >= data.length) {
                C1725a.f(this.TAG, "initData offset not valid before parse position, offset = " + i15 + " + dataSize = " + iP2);
                return;
            }
            byte[] bArr = new byte[iP2];
            System.arraycopy(data, i15, bArr, 0, iP2);
            OneshotFrameData oneshotFrameData = new OneshotFrameData();
            oneshotFrameData.setMSeqNum(iP);
            oneshotFrameData.setMAudioDataSize(iP2);
            oneshotFrameData.setMAudioData(bArr);
            this.mFrameDataList.add(oneshotFrameData);
            i13++;
            i11 = i16;
        }
    }

    public final void setMAddress(String str) {
        this.mAddress = str;
    }

    public final void setMChannelNum(int i10) {
        this.mChannelNum = i10;
    }

    public final void setMFrameDataList(ArrayList<OneshotFrameData> arrayList) {
        h.e(arrayList, "<set-?>");
        this.mFrameDataList = arrayList;
    }

    public final void setMFrameNum(int i10) {
        this.mFrameNum = i10;
    }

    public final void setMOriginData(byte[] bArr) {
        this.mOriginData = bArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.mAddress);
        dest.writeInt(this.mFrameNum);
        dest.writeInt(this.mChannelNum);
        dest.writeList(this.mFrameDataList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneshotAudioDataInfo(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        this.mAddress = parcel.readString();
        this.mFrameNum = parcel.readInt();
        this.mChannelNum = parcel.readInt();
        ArrayList<OneshotFrameData> arrayList = parcel.readArrayList(OneshotFrameData.INSTANCE.getClass().getClassLoader());
        h.c(arrayList, "null cannot be cast to non-null type java.util.ArrayList<com.oplus.melody.btsdk.api.data.OneshotFrameData>");
        this.mFrameDataList = arrayList;
    }
}
