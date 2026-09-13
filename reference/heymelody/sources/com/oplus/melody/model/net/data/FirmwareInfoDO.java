package com.oplus.melody.model.net.data;

import A6.b;
import A6.e;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: FirmwareInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001!BI\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/oplus/melody/model/net/data/FirmwareInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "name", "", "productId", "updateInfo", "version", "content", "", "Lcom/oplus/melody/model/net/data/FirmwareInfoDO$Content;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getProductId", "getUpdateInfo", "getVersion", "getContent", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Content", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FirmwareInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<FirmwareInfoDO> CREATOR = new a();
    private final List<Content> content;
    private final String name;
    private final String productId;
    private final String updateInfo;
    private final String version;

    /* JADX INFO: compiled from: FirmwareInfoDO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/oplus/melody/model/net/data/FirmwareInfoDO$Content;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "name", "", "url", "size", "", "updateInfo", "firmwareSHA256", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "getSize", "()I", "getUpdateInfo", "getFirmwareSHA256", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Content extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Content> CREATOR = new a();
        private final String firmwareSHA256;
        private final String name;
        private final int size;
        private final String updateInfo;
        private final String url;

        /* JADX INFO: compiled from: FirmwareInfoDO.kt */
        public static final class a implements Parcelable.Creator<Content> {
            @Override // android.os.Parcelable.Creator
            public final Content createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Content(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Content[] newArray(int i10) {
                return new Content[i10];
            }
        }

        public Content() {
            this(null, null, 0, null, null, 31, null);
        }

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, int i10, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = content.name;
            }
            if ((i11 & 2) != 0) {
                str2 = content.url;
            }
            if ((i11 & 4) != 0) {
                i10 = content.size;
            }
            if ((i11 & 8) != 0) {
                str3 = content.updateInfo;
            }
            if ((i11 & 16) != 0) {
                str4 = content.firmwareSHA256;
            }
            String str5 = str4;
            int i12 = i10;
            return content.copy(str, str2, i12, str3, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUpdateInfo() {
            return this.updateInfo;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getFirmwareSHA256() {
            return this.firmwareSHA256;
        }

        public final Content copy(String name, String url, int size, String updateInfo, String firmwareSHA256) {
            return new Content(name, url, size, updateInfo, firmwareSHA256);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getFirmwareSHA256() {
            return this.firmwareSHA256;
        }

        public final String getName() {
            return this.name;
        }

        public final int getSize() {
            return this.size;
        }

        public final String getUpdateInfo() {
            return this.updateInfo;
        }

        public final String getUrl() {
            return this.url;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.name);
            dest.writeString(this.url);
            dest.writeInt(this.size);
            dest.writeString(this.updateInfo);
            dest.writeString(this.firmwareSHA256);
        }

        public Content(String str, String str2, int i10, String str3, String str4) {
            this.name = str;
            this.url = str2;
            this.size = i10;
            this.updateInfo = str3;
            this.firmwareSHA256 = str4;
        }

        public /* synthetic */ Content(String str, String str2, int i10, String str3, String str4, int i11, d dVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4);
        }
    }

    /* JADX INFO: compiled from: FirmwareInfoDO.kt */
    public static final class a implements Parcelable.Creator<FirmwareInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final FirmwareInfoDO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i10 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i10);
                int iB = 0;
                while (iB != i10) {
                    iB = b.b(Content.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new FirmwareInfoDO(string, string2, string3, string4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final FirmwareInfoDO[] newArray(int i10) {
            return new FirmwareInfoDO[i10];
        }
    }

    public FirmwareInfoDO() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirmwareInfoDO copy$default(FirmwareInfoDO firmwareInfoDO, String str, String str2, String str3, String str4, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = firmwareInfoDO.name;
        }
        if ((i10 & 2) != 0) {
            str2 = firmwareInfoDO.productId;
        }
        if ((i10 & 4) != 0) {
            str3 = firmwareInfoDO.updateInfo;
        }
        if ((i10 & 8) != 0) {
            str4 = firmwareInfoDO.version;
        }
        if ((i10 & 16) != 0) {
            list = firmwareInfoDO.content;
        }
        List list2 = list;
        String str5 = str3;
        return firmwareInfoDO.copy(str, str2, str5, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<Content> component5() {
        return this.content;
    }

    public final FirmwareInfoDO copy(String name, String productId, String updateInfo, String version, List<Content> content) {
        return new FirmwareInfoDO(name, productId, updateInfo, version, content);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final List<Content> getContent() {
        return this.content;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    public final String getVersion() {
        return this.version;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.productId);
        dest.writeString(this.updateInfo);
        dest.writeString(this.version);
        List<Content> list = this.content;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((Content) itG.next()).writeToParcel(dest, flags);
        }
    }

    public FirmwareInfoDO(String str, String str2, String str3, String str4, List<Content> list) {
        this.name = str;
        this.productId = str2;
        this.updateInfo = str3;
        this.version = str4;
        this.content = list;
    }

    public /* synthetic */ FirmwareInfoDO(String str, String str2, String str3, String str4, List list, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : list);
    }
}
