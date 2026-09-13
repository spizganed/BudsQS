package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.a;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0004\u0018\u0019\u001a\u001bB\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "jsonData", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getJsonData", "setJsonData", "component1", "component2", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "BaseReq", "SnInfo", "EarbudsSn", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DiagnosisJsonDataInfo extends a implements Parcelable {
    private String address;
    private String jsonData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Parcelable.Creator<DiagnosisJsonDataInfo> CREATOR = new b();

    /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$BaseReq;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "cmd", "", "<init>", "(Ljava/lang/String;)V", "getCmd", "()Ljava/lang/String;", "setCmd", "component1", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BaseReq extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<BaseReq> CREATOR = new a();

        @I3.b("cmd")
        private String cmd;

        /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
        public static final class a implements Parcelable.Creator<BaseReq> {
            @Override // android.os.Parcelable.Creator
            public final BaseReq createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new BaseReq(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final BaseReq[] newArray(int i10) {
                return new BaseReq[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BaseReq() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ BaseReq copy$default(BaseReq baseReq, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = baseReq.cmd;
            }
            return baseReq.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCmd() {
            return this.cmd;
        }

        public final BaseReq copy(String cmd) {
            h.e(cmd, "cmd");
            return new BaseReq(cmd);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getCmd() {
            return this.cmd;
        }

        public final void setCmd(String str) {
            h.e(str, "<set-?>");
            this.cmd = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.cmd);
        }

        public BaseReq(String cmd) {
            h.e(cmd, "cmd");
            this.cmd = cmd;
        }

        public /* synthetic */ BaseReq(String str, int i10, d dVar) {
            this((i10 & 1) != 0 ? "" : str);
        }
    }

    /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$SnInfo;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "sn", "", "<init>", "(Ljava/lang/String;)V", "getSn", "()Ljava/lang/String;", "setSn", "component1", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SnInfo extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<SnInfo> CREATOR = new a();

        @I3.b("sn")
        private String sn;

        /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
        public static final class a implements Parcelable.Creator<SnInfo> {
            @Override // android.os.Parcelable.Creator
            public final SnInfo createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new SnInfo(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final SnInfo[] newArray(int i10) {
                return new SnInfo[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SnInfo() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SnInfo copy$default(SnInfo snInfo, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = snInfo.sn;
            }
            return snInfo.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSn() {
            return this.sn;
        }

        public final SnInfo copy(String sn) {
            h.e(sn, "sn");
            return new SnInfo(sn);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getSn() {
            return this.sn;
        }

        public final void setSn(String str) {
            h.e(str, "<set-?>");
            this.sn = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.sn);
        }

        public SnInfo(String sn) {
            h.e(sn, "sn");
            this.sn = sn;
        }

        public /* synthetic */ SnInfo(String str, int i10, d dVar) {
            this((i10 & 1) != 0 ? "" : str);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.btsdk.api.data.DiagnosisJsonDataInfo$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
    public static final class b implements Parcelable.Creator<DiagnosisJsonDataInfo> {
        @Override // android.os.Parcelable.Creator
        public final DiagnosisJsonDataInfo createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new DiagnosisJsonDataInfo(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final DiagnosisJsonDataInfo[] newArray(int i10) {
            return new DiagnosisJsonDataInfo[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiagnosisJsonDataInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ DiagnosisJsonDataInfo copy$default(DiagnosisJsonDataInfo diagnosisJsonDataInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = diagnosisJsonDataInfo.address;
        }
        if ((i10 & 2) != 0) {
            str2 = diagnosisJsonDataInfo.jsonData;
        }
        return diagnosisJsonDataInfo.copy(str, str2);
    }

    public static final boolean isSnMatches(String str) {
        INSTANCE.getClass();
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[A-Z0-9]{20,22}$").matcher(str).matches();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getJsonData() {
        return this.jsonData;
    }

    public final DiagnosisJsonDataInfo copy(String address, String jsonData) {
        return new DiagnosisJsonDataInfo(address, jsonData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getJsonData() {
        return this.jsonData;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setJsonData(String str) {
        this.jsonData = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeString(this.jsonData);
    }

    public DiagnosisJsonDataInfo(String str, String str2) {
        this.address = str;
        this.jsonData = str2;
    }

    /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
    @Parcelize
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$EarbudsSn;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "rsp", "", "cmd", "", "boxSn", "Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$SnInfo;", "<init>", "(ZLjava/lang/String;Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$SnInfo;)V", "getRsp", "()Z", "setRsp", "(Z)V", "getCmd", "()Ljava/lang/String;", "setCmd", "(Ljava/lang/String;)V", "getBoxSn", "()Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$SnInfo;", "setBoxSn", "(Lcom/oplus/melody/btsdk/api/data/DiagnosisJsonDataInfo$SnInfo;)V", "component1", "component2", "component3", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EarbudsSn extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<EarbudsSn> CREATOR = new a();

        @I3.b("C")
        private SnInfo boxSn;
        private String cmd;
        private boolean rsp;

        /* JADX INFO: compiled from: DiagnosisJsonDataInfo.kt */
        public static final class a implements Parcelable.Creator<EarbudsSn> {
            @Override // android.os.Parcelable.Creator
            public final EarbudsSn createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new EarbudsSn(parcel.readInt() != 0, parcel.readString(), parcel.readInt() == 0 ? null : SnInfo.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public final EarbudsSn[] newArray(int i10) {
                return new EarbudsSn[i10];
            }
        }

        public EarbudsSn(boolean z2, String cmd, SnInfo snInfo) {
            h.e(cmd, "cmd");
            this.rsp = z2;
            this.cmd = cmd;
            this.boxSn = snInfo;
        }

        public static /* synthetic */ EarbudsSn copy$default(EarbudsSn earbudsSn, boolean z2, String str, SnInfo snInfo, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z2 = earbudsSn.rsp;
            }
            if ((i10 & 2) != 0) {
                str = earbudsSn.cmd;
            }
            if ((i10 & 4) != 0) {
                snInfo = earbudsSn.boxSn;
            }
            return earbudsSn.copy(z2, str, snInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getRsp() {
            return this.rsp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCmd() {
            return this.cmd;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final SnInfo getBoxSn() {
            return this.boxSn;
        }

        public final EarbudsSn copy(boolean rsp, String cmd, SnInfo boxSn) {
            h.e(cmd, "cmd");
            return new EarbudsSn(rsp, cmd, boxSn);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final SnInfo getBoxSn() {
            return this.boxSn;
        }

        public final String getCmd() {
            return this.cmd;
        }

        public final boolean getRsp() {
            return this.rsp;
        }

        public final void setBoxSn(SnInfo snInfo) {
            this.boxSn = snInfo;
        }

        public final void setCmd(String str) {
            h.e(str, "<set-?>");
            this.cmd = str;
        }

        public final void setRsp(boolean z2) {
            this.rsp = z2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.rsp ? 1 : 0);
            dest.writeString(this.cmd);
            SnInfo snInfo = this.boxSn;
            if (snInfo == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                snInfo.writeToParcel(dest, flags);
            }
        }

        public /* synthetic */ EarbudsSn(boolean z2, String str, SnInfo snInfo, int i10, d dVar) {
            this((i10 & 1) != 0 ? false : z2, (i10 & 2) != 0 ? "" : str, snInfo);
        }
    }

    public /* synthetic */ DiagnosisJsonDataInfo(String str, String str2, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
