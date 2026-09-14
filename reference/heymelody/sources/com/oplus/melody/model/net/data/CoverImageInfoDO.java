package com.oplus.melody.model.net.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: CoverImageInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/oplus/melody/model/net/data/CoverImageInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "productId", "", "listCoverImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "getListCoverImage", "component1", "component2", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CoverImageInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<CoverImageInfoDO> CREATOR = new a();
    private final String listCoverImage;
    private final String productId;

    /* JADX INFO: compiled from: CoverImageInfoDO.kt */
    public static final class a implements Parcelable.Creator<CoverImageInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final CoverImageInfoDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new CoverImageInfoDO(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CoverImageInfoDO[] newArray(int i10) {
            return new CoverImageInfoDO[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CoverImageInfoDO() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CoverImageInfoDO copy$default(CoverImageInfoDO coverImageInfoDO, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = coverImageInfoDO.productId;
        }
        if ((i10 & 2) != 0) {
            str2 = coverImageInfoDO.listCoverImage;
        }
        return coverImageInfoDO.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getListCoverImage() {
        return this.listCoverImage;
    }

    public final CoverImageInfoDO copy(String productId, String listCoverImage) {
        return new CoverImageInfoDO(productId, listCoverImage);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getListCoverImage() {
        return this.listCoverImage;
    }

    public final String getProductId() {
        return this.productId;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.productId);
        dest.writeString(this.listCoverImage);
    }

    public CoverImageInfoDO(String str, String str2) {
        this.productId = str;
        this.listCoverImage = str2;
    }

    public /* synthetic */ CoverImageInfoDO(String str, String str2, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2);
    }
}
