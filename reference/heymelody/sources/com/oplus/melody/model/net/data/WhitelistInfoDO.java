package com.oplus.melody.model.net.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: WhitelistInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, d2 = {"Lcom/oplus/melody/model/net/data/WhitelistInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "downloadUrl", "", "fileName", "id", "size", "", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getDownloadUrl", "()Ljava/lang/String;", "getFileName", "getId", "getSize", "()J", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WhitelistInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<WhitelistInfoDO> CREATOR = new a();
    private final String downloadUrl;
    private final String fileName;
    private final String id;
    private final long size;
    private final long version;

    /* JADX INFO: compiled from: WhitelistInfoDO.kt */
    public static final class a implements Parcelable.Creator<WhitelistInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final WhitelistInfoDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new WhitelistInfoDO(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final WhitelistInfoDO[] newArray(int i10) {
            return new WhitelistInfoDO[i10];
        }
    }

    public WhitelistInfoDO() {
        this(null, null, null, 0L, 0L, 31, null);
    }

    public static /* synthetic */ WhitelistInfoDO copy$default(WhitelistInfoDO whitelistInfoDO, String str, String str2, String str3, long j5, long j9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = whitelistInfoDO.downloadUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = whitelistInfoDO.fileName;
        }
        if ((i10 & 4) != 0) {
            str3 = whitelistInfoDO.id;
        }
        if ((i10 & 8) != 0) {
            j5 = whitelistInfoDO.size;
        }
        if ((i10 & 16) != 0) {
            j9 = whitelistInfoDO.version;
        }
        long j10 = j9;
        String str4 = str3;
        return whitelistInfoDO.copy(str, str2, str4, j5, j10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getVersion() {
        return this.version;
    }

    public final WhitelistInfoDO copy(String downloadUrl, String fileName, String id, long size, long version) {
        return new WhitelistInfoDO(downloadUrl, fileName, id, size, version);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getId() {
        return this.id;
    }

    public final long getSize() {
        return this.size;
    }

    public final long getVersion() {
        return this.version;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.downloadUrl);
        dest.writeString(this.fileName);
        dest.writeString(this.id);
        dest.writeLong(this.size);
        dest.writeLong(this.version);
    }

    public WhitelistInfoDO(String str, String str2, String str3, long j5, long j9) {
        this.downloadUrl = str;
        this.fileName = str2;
        this.id = str3;
        this.size = j5;
        this.version = j9;
    }

    public /* synthetic */ WhitelistInfoDO(String str, String str2, String str3, long j5, long j9, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? 0L : j5, (i10 & 16) != 0 ? 0L : j9);
    }
}
