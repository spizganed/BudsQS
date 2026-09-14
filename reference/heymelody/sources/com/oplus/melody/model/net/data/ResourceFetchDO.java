package com.oplus.melody.model.net.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: ResourceFetchDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/model/net/data/ResourceFetchDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "fileName", "", "resourceUrl", "resourceName", "resourceDescription", "sha256", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getResourceUrl", "getResourceName", "getResourceDescription", "getSha256", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ResourceFetchDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ResourceFetchDO> CREATOR = new a();
    private final String fileName;
    private final String resourceDescription;
    private final String resourceName;
    private final String resourceUrl;
    private final String sha256;

    /* JADX INFO: compiled from: ResourceFetchDO.kt */
    public static final class a implements Parcelable.Creator<ResourceFetchDO> {
        @Override // android.os.Parcelable.Creator
        public final ResourceFetchDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new ResourceFetchDO(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceFetchDO[] newArray(int i10) {
            return new ResourceFetchDO[i10];
        }
    }

    public ResourceFetchDO(String str, String str2, String str3, String str4, String str5) {
        this.fileName = str;
        this.resourceUrl = str2;
        this.resourceName = str3;
        this.resourceDescription = str4;
        this.sha256 = str5;
    }

    public static /* synthetic */ ResourceFetchDO copy$default(ResourceFetchDO resourceFetchDO, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = resourceFetchDO.fileName;
        }
        if ((i10 & 2) != 0) {
            str2 = resourceFetchDO.resourceUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = resourceFetchDO.resourceName;
        }
        if ((i10 & 8) != 0) {
            str4 = resourceFetchDO.resourceDescription;
        }
        if ((i10 & 16) != 0) {
            str5 = resourceFetchDO.sha256;
        }
        String str6 = str5;
        String str7 = str3;
        return resourceFetchDO.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getResourceName() {
        return this.resourceName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getResourceDescription() {
        return this.resourceDescription;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    public final ResourceFetchDO copy(String fileName, String resourceUrl, String resourceName, String resourceDescription, String sha256) {
        return new ResourceFetchDO(fileName, resourceUrl, resourceName, resourceDescription, sha256);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getResourceDescription() {
        return this.resourceDescription;
    }

    public final String getResourceName() {
        return this.resourceName;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final String getSha256() {
        return this.sha256;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.fileName);
        dest.writeString(this.resourceUrl);
        dest.writeString(this.resourceName);
        dest.writeString(this.resourceDescription);
        dest.writeString(this.sha256);
    }
}
