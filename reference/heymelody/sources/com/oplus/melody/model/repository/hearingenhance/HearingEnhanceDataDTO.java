package com.oplus.melody.model.repository.hearingenhance;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: HearingEnhanceDataDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B¡\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010=\u001a\u00020\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0013HÆ\u0003J£\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0006\u0010@\u001a\u00020\u0004J\u0016\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001e\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006F"}, d2 = {"Lcom/oplus/melody/model/repository/hearingenhance/HearingEnhanceDataDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "enhanceType", "", "restoreDesId", "freqType", "frequencyLeftCurveData", "", "", "frequencyRightCurveData", "hearingEnhancementList", "Lcom/oplus/melody/model/repository/hearingenhance/HearingDetectInfoDTO;", "earScanData", "", "earScanFrequencyLeftCurveData", "earScanFrequencyRightCurveData", "samplingFrequency", "recordName", "", "<init>", "(IIILjava/util/List;Ljava/util/List;Ljava/util/List;[BLjava/util/List;Ljava/util/List;ILjava/lang/String;)V", "getEnhanceType", "()I", "setEnhanceType", "(I)V", "getRestoreDesId", "setRestoreDesId", "getFreqType", "setFreqType", "getFrequencyLeftCurveData", "()Ljava/util/List;", "setFrequencyLeftCurveData", "(Ljava/util/List;)V", "getFrequencyRightCurveData", "setFrequencyRightCurveData", "getHearingEnhancementList", "setHearingEnhancementList", "getEarScanData", "()[B", "setEarScanData", "([B)V", "getEarScanFrequencyLeftCurveData", "setEarScanFrequencyLeftCurveData", "getEarScanFrequencyRightCurveData", "setEarScanFrequencyRightCurveData", "getSamplingFrequency", "setSamplingFrequency", "getRecordName", "()Ljava/lang/String;", "setRecordName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HearingEnhanceDataDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingEnhanceDataDTO> CREATOR = new a();

    @I3.b("mEarScanData")
    private byte[] earScanData;

    @I3.b("mEarScanFrequencyLeftCurveData")
    private List<Float> earScanFrequencyLeftCurveData;

    @I3.b("mEarScanFrequencyRightCurveData")
    private List<Float> earScanFrequencyRightCurveData;

    @I3.b("mEnhanceType")
    private int enhanceType;

    @I3.b("mType")
    private int freqType;

    @I3.b("mFrequencyLeftCurveData")
    private List<Float> frequencyLeftCurveData;

    @I3.b("mFrequencyRightCurveData")
    private List<Float> frequencyRightCurveData;

    @I3.b("mHearingEnhancementList")
    private List<HearingDetectInfoDTO> hearingEnhancementList;

    @I3.b("mRecordName")
    private String recordName;

    @I3.b("mEnhanceDesId")
    private int restoreDesId;

    @I3.b("mSamplingFrequency")
    private int samplingFrequency;

    /* JADX INFO: compiled from: HearingEnhanceDataDTO.kt */
    public static final class a implements Parcelable.Creator<HearingEnhanceDataDTO> {
        @Override // android.os.Parcelable.Creator
        public final HearingEnhanceDataDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            kotlin.jvm.internal.h.e(parcel, "parcel");
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i13 = parcel.readInt();
                arrayList = new ArrayList(i13);
                for (int i14 = 0; i14 != i13; i14++) {
                    arrayList.add(Float.valueOf(parcel.readFloat()));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i15 = parcel.readInt();
                arrayList2 = new ArrayList(i15);
                for (int i16 = 0; i16 != i15; i16++) {
                    arrayList2.add(Float.valueOf(parcel.readFloat()));
                }
            }
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int i17 = parcel.readInt();
                arrayList3 = new ArrayList(i17);
                int iB = 0;
                while (iB != i17) {
                    iB = A6.b.b(HearingDetectInfoDTO.CREATOR, parcel, arrayList3, iB, 1);
                }
            }
            byte[] bArrCreateByteArray = parcel.createByteArray();
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int i18 = parcel.readInt();
                ArrayList arrayList6 = new ArrayList(i18);
                for (int i19 = 0; i19 != i18; i19++) {
                    arrayList6.add(Float.valueOf(parcel.readFloat()));
                }
                arrayList4 = arrayList6;
            }
            if (parcel.readInt() == 0) {
                arrayList5 = null;
            } else {
                int i20 = parcel.readInt();
                arrayList5 = new ArrayList(i20);
                for (int i21 = 0; i21 != i20; i21++) {
                    arrayList5.add(Float.valueOf(parcel.readFloat()));
                }
            }
            return new HearingEnhanceDataDTO(i10, i11, i12, arrayList, arrayList2, arrayList3, bArrCreateByteArray, arrayList4, arrayList5, parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final HearingEnhanceDataDTO[] newArray(int i10) {
            return new HearingEnhanceDataDTO[i10];
        }
    }

    public HearingEnhanceDataDTO() {
        this(0, 0, 0, null, null, null, null, null, null, 0, null, 2047, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HearingEnhanceDataDTO copy$default(HearingEnhanceDataDTO hearingEnhanceDataDTO, int i10, int i11, int i12, List list, List list2, List list3, byte[] bArr, List list4, List list5, int i13, String str, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = hearingEnhanceDataDTO.enhanceType;
        }
        if ((i14 & 2) != 0) {
            i11 = hearingEnhanceDataDTO.restoreDesId;
        }
        if ((i14 & 4) != 0) {
            i12 = hearingEnhanceDataDTO.freqType;
        }
        if ((i14 & 8) != 0) {
            list = hearingEnhanceDataDTO.frequencyLeftCurveData;
        }
        if ((i14 & 16) != 0) {
            list2 = hearingEnhanceDataDTO.frequencyRightCurveData;
        }
        if ((i14 & 32) != 0) {
            list3 = hearingEnhanceDataDTO.hearingEnhancementList;
        }
        if ((i14 & 64) != 0) {
            bArr = hearingEnhanceDataDTO.earScanData;
        }
        if ((i14 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
            list4 = hearingEnhanceDataDTO.earScanFrequencyLeftCurveData;
        }
        if ((i14 & 256) != 0) {
            list5 = hearingEnhanceDataDTO.earScanFrequencyRightCurveData;
        }
        if ((i14 & 512) != 0) {
            i13 = hearingEnhanceDataDTO.samplingFrequency;
        }
        if ((i14 & 1024) != 0) {
            str = hearingEnhanceDataDTO.recordName;
        }
        int i15 = i13;
        String str2 = str;
        List list6 = list4;
        List list7 = list5;
        List list8 = list3;
        byte[] bArr2 = bArr;
        List list9 = list2;
        int i16 = i12;
        return hearingEnhanceDataDTO.copy(i10, i11, i16, list, list9, list8, bArr2, list6, list7, i15, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEnhanceType() {
        return this.enhanceType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getSamplingFrequency() {
        return this.samplingFrequency;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRecordName() {
        return this.recordName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRestoreDesId() {
        return this.restoreDesId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFreqType() {
        return this.freqType;
    }

    public final List<Float> component4() {
        return this.frequencyLeftCurveData;
    }

    public final List<Float> component5() {
        return this.frequencyRightCurveData;
    }

    public final List<HearingDetectInfoDTO> component6() {
        return this.hearingEnhancementList;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final byte[] getEarScanData() {
        return this.earScanData;
    }

    public final List<Float> component8() {
        return this.earScanFrequencyLeftCurveData;
    }

    public final List<Float> component9() {
        return this.earScanFrequencyRightCurveData;
    }

    public final HearingEnhanceDataDTO copy(int enhanceType, int restoreDesId, int freqType, List<Float> frequencyLeftCurveData, List<Float> frequencyRightCurveData, List<HearingDetectInfoDTO> hearingEnhancementList, byte[] earScanData, List<Float> earScanFrequencyLeftCurveData, List<Float> earScanFrequencyRightCurveData, int samplingFrequency, String recordName) {
        return new HearingEnhanceDataDTO(enhanceType, restoreDesId, freqType, frequencyLeftCurveData, frequencyRightCurveData, hearingEnhancementList, earScanData, earScanFrequencyLeftCurveData, earScanFrequencyRightCurveData, samplingFrequency, recordName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final byte[] getEarScanData() {
        return this.earScanData;
    }

    public final List<Float> getEarScanFrequencyLeftCurveData() {
        return this.earScanFrequencyLeftCurveData;
    }

    public final List<Float> getEarScanFrequencyRightCurveData() {
        return this.earScanFrequencyRightCurveData;
    }

    public final int getEnhanceType() {
        return this.enhanceType;
    }

    public final int getFreqType() {
        return this.freqType;
    }

    public final List<Float> getFrequencyLeftCurveData() {
        return this.frequencyLeftCurveData;
    }

    public final List<Float> getFrequencyRightCurveData() {
        return this.frequencyRightCurveData;
    }

    public final List<HearingDetectInfoDTO> getHearingEnhancementList() {
        return this.hearingEnhancementList;
    }

    public final String getRecordName() {
        return this.recordName;
    }

    public final int getRestoreDesId() {
        return this.restoreDesId;
    }

    public final int getSamplingFrequency() {
        return this.samplingFrequency;
    }

    public final void setEarScanData(byte[] bArr) {
        this.earScanData = bArr;
    }

    public final void setEarScanFrequencyLeftCurveData(List<Float> list) {
        this.earScanFrequencyLeftCurveData = list;
    }

    public final void setEarScanFrequencyRightCurveData(List<Float> list) {
        this.earScanFrequencyRightCurveData = list;
    }

    public final void setEnhanceType(int i10) {
        this.enhanceType = i10;
    }

    public final void setFreqType(int i10) {
        this.freqType = i10;
    }

    public final void setFrequencyLeftCurveData(List<Float> list) {
        this.frequencyLeftCurveData = list;
    }

    public final void setFrequencyRightCurveData(List<Float> list) {
        this.frequencyRightCurveData = list;
    }

    public final void setHearingEnhancementList(List<HearingDetectInfoDTO> list) {
        this.hearingEnhancementList = list;
    }

    public final void setRecordName(String str) {
        this.recordName = str;
    }

    public final void setRestoreDesId(int i10) {
        this.restoreDesId = i10;
    }

    public final void setSamplingFrequency(int i10) {
        this.samplingFrequency = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.enhanceType);
        dest.writeInt(this.restoreDesId);
        dest.writeInt(this.freqType);
        List<Float> list = this.frequencyLeftCurveData;
        if (list == null) {
            dest.writeInt(0);
        } else {
            Iterator itG = A6.e.g(dest, 1, list);
            while (itG.hasNext()) {
                dest.writeFloat(((Number) itG.next()).floatValue());
            }
        }
        List<Float> list2 = this.frequencyRightCurveData;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG2 = A6.e.g(dest, 1, list2);
            while (itG2.hasNext()) {
                dest.writeFloat(((Number) itG2.next()).floatValue());
            }
        }
        List<HearingDetectInfoDTO> list3 = this.hearingEnhancementList;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG3 = A6.e.g(dest, 1, list3);
            while (itG3.hasNext()) {
                ((HearingDetectInfoDTO) itG3.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeByteArray(this.earScanData);
        List<Float> list4 = this.earScanFrequencyLeftCurveData;
        if (list4 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG4 = A6.e.g(dest, 1, list4);
            while (itG4.hasNext()) {
                dest.writeFloat(((Number) itG4.next()).floatValue());
            }
        }
        List<Float> list5 = this.earScanFrequencyRightCurveData;
        if (list5 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG5 = A6.e.g(dest, 1, list5);
            while (itG5.hasNext()) {
                dest.writeFloat(((Number) itG5.next()).floatValue());
            }
        }
        dest.writeInt(this.samplingFrequency);
        dest.writeString(this.recordName);
    }

    public HearingEnhanceDataDTO(int i10, int i11, int i12, List<Float> list, List<Float> list2, List<HearingDetectInfoDTO> list3, byte[] bArr, List<Float> list4, List<Float> list5, int i13, String str) {
        this.enhanceType = i10;
        this.restoreDesId = i11;
        this.freqType = i12;
        this.frequencyLeftCurveData = list;
        this.frequencyRightCurveData = list2;
        this.hearingEnhancementList = list3;
        this.earScanData = bArr;
        this.earScanFrequencyLeftCurveData = list4;
        this.earScanFrequencyRightCurveData = list5;
        this.samplingFrequency = i13;
        this.recordName = str;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ HearingEnhanceDataDTO(int r3, int r4, int r5, java.util.List r6, java.util.List r7, java.util.List r8, byte[] r9, java.util.List r10, java.util.List r11, int r12, java.lang.String r13, int r14, kotlin.jvm.internal.d r15) {
        /*
            r2 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L5
            r3 = -1
        L5:
            r15 = r14 & 2
            r0 = 0
            if (r15 == 0) goto Lb
            r4 = r0
        Lb:
            r15 = r14 & 4
            if (r15 == 0) goto L10
            r5 = 2
        L10:
            r15 = r14 & 8
            r1 = 0
            if (r15 == 0) goto L16
            r6 = r1
        L16:
            r15 = r14 & 16
            if (r15 == 0) goto L1b
            r7 = r1
        L1b:
            r15 = r14 & 32
            if (r15 == 0) goto L20
            r8 = r1
        L20:
            r15 = r14 & 64
            if (r15 == 0) goto L25
            r9 = r1
        L25:
            r15 = r14 & 128(0x80, float:1.8E-43)
            if (r15 == 0) goto L2a
            r10 = r1
        L2a:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L2f
            r11 = r1
        L2f:
            r15 = r14 & 512(0x200, float:7.17E-43)
            if (r15 == 0) goto L34
            r12 = r0
        L34:
            r14 = r14 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L45
            r15 = r1
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r4 = r2
            goto L51
        L45:
            r15 = r13
            r14 = r12
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
        L51:
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.model.repository.hearingenhance.HearingEnhanceDataDTO.<init>(int, int, int, java.util.List, java.util.List, java.util.List, byte[], java.util.List, java.util.List, int, java.lang.String, int, kotlin.jvm.internal.d):void");
    }
}
