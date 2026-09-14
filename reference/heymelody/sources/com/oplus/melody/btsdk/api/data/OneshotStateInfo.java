package com.oplus.melody.btsdk.api.data;

import A6.f;
import D5.c;
import S6.d;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import z7.C1725a;

/* JADX INFO: compiled from: OneshotStateInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0017\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u00029:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$J \u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010$J\u0018\u0010&\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0012H\u0016J\b\u0010*\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u0004\u0018\u00010\tJ\u0006\u0010,\u001a\u00020\u0012J\u0006\u0010-\u001a\u00020\u0012J\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010/\u001a\u00020\u0010J\u0006\u00100\u001a\u00020\u0012J\u0006\u00101\u001a\u00020\u0012J\u0006\u00102\u001a\u00020\u0012J\u0006\u00103\u001a\u00020\u0012J\u0006\u00104\u001a\u00020\u0012J\b\u00105\u001a\u0004\u0018\u00010\tJ\u0006\u00106\u001a\u00020\u0012J\u0006\u00107\u001a\u00020\u0012J\u0006\u00108\u001a\u00020\u0012R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0004R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/OneshotStateInfo;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ENCODE_TYPE_OPUS", "getENCODE_TYPE_OPUS", "mAddress", "mIsEvent", "", "mRspStatus", "", "mOperateType", "getMOperateType$annotations", "mIsSupportOneshot", "mWakeupSwitch", "mSampleRateType", "mSampleRate", "mAudioEncodeFormat", "mChannelNum", "mEncodeType", "mFrameSize", "mEarphoneSessionStatus", "mVadStatus", "initRspData", "", "address", "dataOffset", ClientDataEntity.COL_DATA, "", "initEventData", "initData", "writeToParcel", "dest", "flags", "describeContents", "getAddress", "getRspStatus", "getOperateType", "isEvent", "isSupportOneshot", "getWakeupSwitch", "getSampleRateType", "getSampleRate", "getAudioEncodeFormat", "getChannelNum", "getEncodeType", "getFrameSize", "getEarphoneSessionStatus", "getVadStatus", "SampleRateType", "CREATOR", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OneshotStateInfo extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private final String ENCODE_TYPE_OPUS;
    private final String TAG;
    private String mAddress;
    private int mAudioEncodeFormat;
    private int mChannelNum;
    private int mEarphoneSessionStatus;
    private String mEncodeType;
    private int mFrameSize;
    private boolean mIsEvent;
    private boolean mIsSupportOneshot;
    private int mOperateType;
    private int mRspStatus;
    private int mSampleRate;
    private int mSampleRateType;
    private int mVadStatus;
    private int mWakeupSwitch;

    /* JADX INFO: compiled from: OneshotStateInfo.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/OneshotStateInfo$SampleRateType;", "", SpeechFindManager.TYPE, "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SAMPLE_RATE_TYPE_16K", "SAMPLE_RATE_TYPE_32K", "SAMPLE_RATE_TYPE_48K", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum SampleRateType {
        SAMPLE_RATE_TYPE_16K(0),
        SAMPLE_RATE_TYPE_32K(1),
        SAMPLE_RATE_TYPE_48K(2);

        private final int type;

        SampleRateType(int i10) {
            this.type = i10;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.btsdk.api.data.OneshotStateInfo$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: OneshotStateInfo.kt */
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

    public OneshotStateInfo() {
        this.TAG = "OneshotStateInfo";
        this.ENCODE_TYPE_OPUS = "opus";
    }

    private final void initData(int dataOffset, byte[] data) {
        if (dataOffset >= data.length) {
            f.g(dataOffset, "initData offset not valid before parse mIsSupportOneshot, offset = ", this.TAG);
            return;
        }
        byte b4 = data[dataOffset];
        if (((byte) (b4 & 1)) == 1) {
            this.mIsSupportOneshot = true;
            if (((byte) (b4 & 2)) != 0) {
                this.mWakeupSwitch = 1;
            }
        }
        int i10 = dataOffset + 1;
        if (i10 >= data.length) {
            f.g(i10, "initData offset not valid before parse mSampleRate, offset = ", this.TAG);
            return;
        }
        byte b5 = data[i10];
        this.mSampleRateType = b5;
        if (b5 == SampleRateType.SAMPLE_RATE_TYPE_16K.getType()) {
            this.mSampleRate = 16000;
        } else if (this.mSampleRateType == SampleRateType.SAMPLE_RATE_TYPE_32K.getType()) {
            this.mSampleRate = 32000;
        } else if (this.mSampleRateType == SampleRateType.SAMPLE_RATE_TYPE_48K.getType()) {
            this.mSampleRate = 48000;
        } else {
            f.g(this.mSampleRateType, "initData sampleRateType not valid, mSampleRateType = ", this.TAG);
        }
        int i11 = dataOffset + 2;
        if (i11 >= data.length) {
            f.g(i11, "initData offset not valid before parse mAudioEncodeFormat, offset = ", this.TAG);
            return;
        }
        this.mAudioEncodeFormat = data[i11];
        int i12 = dataOffset + 3;
        if (i12 >= data.length) {
            f.g(i12, "initData offset not valid before parse mChannelNum, offset = ", this.TAG);
            return;
        }
        this.mChannelNum = data[i12] + 1;
        int i13 = dataOffset + 4;
        if (i13 >= data.length) {
            f.g(i13, "initData offset not valid before parse mEncodeType, offset = ", this.TAG);
            return;
        }
        byte b10 = data[i13];
        if (b10 == 0) {
            this.mEncodeType = this.ENCODE_TYPE_OPUS;
        } else {
            f.g(b10, "initData encodeType not valid, encodeType = ", this.TAG);
        }
        int i14 = dataOffset + 5;
        if (dataOffset + 6 >= data.length) {
            f.g(i14, "initData offset not valid before parse mFrameSize, offset = ", this.TAG);
            return;
        }
        this.mFrameSize = c.p(data, i14, 2, true);
        int i15 = dataOffset + 7;
        if (i15 >= data.length) {
            f.g(i15, "initData offset not valid before parse mEarphoneSessionStatus, offset = ", this.TAG);
            return;
        }
        this.mEarphoneSessionStatus = data[i15];
        int i16 = dataOffset + 8;
        if (i16 >= data.length) {
            f.g(i16, "initData offset not valid before parse mVadStatus, offset = ", this.TAG);
        } else {
            this.mVadStatus = data[i16];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initEventData$lambda$0(int i10, byte[] bArr) {
        return "initEventData dataOffset：" + i10 + ", data:" + E8.a.e(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String initRspData$lambda$0(int i10, byte[] bArr) {
        return "initRspData dataOffset：" + i10 + ", data:" + E8.a.e(bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: getAddress, reason: from getter */
    public final String getMAddress() {
        return this.mAddress;
    }

    /* JADX INFO: renamed from: getAudioEncodeFormat, reason: from getter */
    public final int getMAudioEncodeFormat() {
        return this.mAudioEncodeFormat;
    }

    /* JADX INFO: renamed from: getChannelNum, reason: from getter */
    public final int getMChannelNum() {
        return this.mChannelNum;
    }

    public final String getENCODE_TYPE_OPUS() {
        return this.ENCODE_TYPE_OPUS;
    }

    /* JADX INFO: renamed from: getEarphoneSessionStatus, reason: from getter */
    public final int getMEarphoneSessionStatus() {
        return this.mEarphoneSessionStatus;
    }

    /* JADX INFO: renamed from: getEncodeType, reason: from getter */
    public final String getMEncodeType() {
        return this.mEncodeType;
    }

    /* JADX INFO: renamed from: getFrameSize, reason: from getter */
    public final int getMFrameSize() {
        return this.mFrameSize;
    }

    /* JADX INFO: renamed from: getOperateType, reason: from getter */
    public final int getMOperateType() {
        return this.mOperateType;
    }

    /* JADX INFO: renamed from: getRspStatus, reason: from getter */
    public final int getMRspStatus() {
        return this.mRspStatus;
    }

    /* JADX INFO: renamed from: getSampleRate, reason: from getter */
    public final int getMSampleRate() {
        return this.mSampleRate;
    }

    /* JADX INFO: renamed from: getSampleRateType, reason: from getter */
    public final int getMSampleRateType() {
        return this.mSampleRateType;
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: renamed from: getVadStatus, reason: from getter */
    public final int getMVadStatus() {
        return this.mVadStatus;
    }

    /* JADX INFO: renamed from: getWakeupSwitch, reason: from getter */
    public final int getMWakeupSwitch() {
        return this.mWakeupSwitch;
    }

    public final void initEventData(String address, int dataOffset, byte[] data) {
        h.e(address, "address");
        C1725a.c(this.TAG, new S6.c(dataOffset, 0, data));
        this.mIsEvent = true;
        this.mAddress = address;
        if (data == null) {
            C1725a.f(this.TAG, "initEventData data is null!");
        } else {
            initData(dataOffset, data);
        }
    }

    public final void initRspData(String address, int dataOffset, byte[] data) {
        h.e(address, "address");
        C1725a.c(this.TAG, new d(dataOffset, 0, data));
        this.mIsEvent = false;
        this.mAddress = address;
        if (data == null) {
            C1725a.f(this.TAG, "initRspData data is null!");
            return;
        }
        if (dataOffset >= data.length) {
            f.g(dataOffset, "initRspData offset not valid before parse mRspStatus, offset = ", this.TAG);
            return;
        }
        this.mRspStatus = data[dataOffset];
        int i10 = dataOffset + 1;
        if (i10 >= data.length) {
            f.g(i10, "initRspData offset not valid before parse mOperateType, offset = ", this.TAG);
            return;
        }
        byte b4 = data[i10];
        this.mOperateType = b4;
        int i11 = dataOffset + 2;
        if (b4 == 3) {
            initData(i11, data);
        }
    }

    /* JADX INFO: renamed from: isEvent, reason: from getter */
    public final boolean getMIsEvent() {
        return this.mIsEvent;
    }

    /* JADX INFO: renamed from: isSupportOneshot, reason: from getter */
    public final boolean getMIsSupportOneshot() {
        return this.mIsSupportOneshot;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.mAddress);
        dest.writeInt(this.mRspStatus);
        dest.writeInt(this.mOperateType);
        dest.writeInt(this.mIsEvent ? 1 : 0);
        dest.writeInt(this.mIsSupportOneshot ? 1 : 0);
        dest.writeInt(this.mWakeupSwitch);
        dest.writeInt(this.mSampleRateType);
        dest.writeInt(this.mSampleRate);
        dest.writeInt(this.mAudioEncodeFormat);
        dest.writeInt(this.mChannelNum);
        dest.writeString(this.mEncodeType);
        dest.writeInt(this.mFrameSize);
        dest.writeInt(this.mEarphoneSessionStatus);
        dest.writeInt(this.mVadStatus);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneshotStateInfo(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        this.mAddress = parcel.readString();
        this.mRspStatus = parcel.readInt();
        this.mOperateType = parcel.readInt();
        this.mIsEvent = parcel.readInt() == 1;
        this.mIsSupportOneshot = parcel.readInt() == 1;
        this.mWakeupSwitch = parcel.readInt();
        this.mSampleRateType = parcel.readInt();
        this.mSampleRate = parcel.readInt();
        this.mAudioEncodeFormat = parcel.readInt();
        this.mChannelNum = parcel.readInt();
        this.mEncodeType = parcel.readString();
        this.mFrameSize = parcel.readInt();
        this.mEarphoneSessionStatus = parcel.readInt();
        this.mVadStatus = parcel.readInt();
    }

    private static /* synthetic */ void getMOperateType$annotations() {
    }
}
