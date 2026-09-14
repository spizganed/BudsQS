package com.oplus.melody.model.net.data;

import I3.b;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: ResourceInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/model/net/data/ResourceInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "url", "", "imageUrl", "animUrl", "productId", "sha256", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getImageUrl", "getAnimUrl", "getProductId", "getSha256", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ResourceInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ResourceInfoDO> CREATOR = new a();

    @b("cartoonUrl")
    private final String animUrl;

    @b("imgUrl")
    private final String imageUrl;

    @b("productId")
    private final String productId;

    @b("sha256")
    private final String sha256;

    @b("url")
    private final String url;

    /* JADX INFO: compiled from: ResourceInfoDO.kt */
    public static final class a implements Parcelable.Creator<ResourceInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final ResourceInfoDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new ResourceInfoDO(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceInfoDO[] newArray(int i10) {
            return new ResourceInfoDO[i10];
        }
    }

    public ResourceInfoDO() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ResourceInfoDO copy$default(ResourceInfoDO resourceInfoDO, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = resourceInfoDO.url;
        }
        if ((i10 & 2) != 0) {
            str2 = resourceInfoDO.imageUrl;
        }
        if ((i10 & 4) != 0) {
            str3 = resourceInfoDO.animUrl;
        }
        if ((i10 & 8) != 0) {
            str4 = resourceInfoDO.productId;
        }
        if ((i10 & 16) != 0) {
            str5 = resourceInfoDO.sha256;
        }
        String str6 = str5;
        String str7 = str3;
        return resourceInfoDO.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAnimUrl() {
        return this.animUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    public final ResourceInfoDO copy(String url, String imageUrl, String animUrl, String productId, String sha256) {
        return new ResourceInfoDO(url, imageUrl, animUrl, productId, sha256);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAnimUrl() {
        return this.animUrl;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.url);
        dest.writeString(this.imageUrl);
        dest.writeString(this.animUrl);
        dest.writeString(this.productId);
        dest.writeString(this.sha256);
    }

    public ResourceInfoDO(String str, String str2, String str3, String str4, String str5) {
        this.url = str;
        this.imageUrl = str2;
        this.animUrl = str3;
        this.productId = str4;
        this.sha256 = str5;
    }

    public /* synthetic */ ResourceInfoDO(String str, String str2, String str3, String str4, String str5, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5);
    }
}
