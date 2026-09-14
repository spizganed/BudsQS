package com.oplus.melody.model.db;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: CarouselDressEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003JK\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0001J\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/oplus/melody/model/db/CarouselDressEntity;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "carouselId", "", "productId", "", "colorId", "name", "carouselType", "themeIdList", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/util/List;)V", "getCarouselId", "()I", "setCarouselId", "(I)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getColorId", "setColorId", "getName", "setName", "getCarouselType", "setCarouselType", "getThemeIdList", "()Ljava/util/List;", "setThemeIdList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CarouselDressEntity extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<CarouselDressEntity> CREATOR = new a();
    private int carouselId;
    private int carouselType;
    private int colorId;
    private String name;
    private String productId;
    private List<String> themeIdList;

    /* JADX INFO: compiled from: CarouselDressEntity.kt */
    public static final class a implements Parcelable.Creator<CarouselDressEntity> {
        @Override // android.os.Parcelable.Creator
        public final CarouselDressEntity createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new CarouselDressEntity(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final CarouselDressEntity[] newArray(int i10) {
            return new CarouselDressEntity[i10];
        }
    }

    public CarouselDressEntity() {
        this(0, null, 0, null, 0, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarouselDressEntity copy$default(CarouselDressEntity carouselDressEntity, int i10, String str, int i11, String str2, int i12, List list, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = carouselDressEntity.carouselId;
        }
        if ((i13 & 2) != 0) {
            str = carouselDressEntity.productId;
        }
        if ((i13 & 4) != 0) {
            i11 = carouselDressEntity.colorId;
        }
        if ((i13 & 8) != 0) {
            str2 = carouselDressEntity.name;
        }
        if ((i13 & 16) != 0) {
            i12 = carouselDressEntity.carouselType;
        }
        if ((i13 & 32) != 0) {
            list = carouselDressEntity.themeIdList;
        }
        int i14 = i12;
        List list2 = list;
        return carouselDressEntity.copy(i10, str, i11, str2, i14, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCarouselId() {
        return this.carouselId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getColorId() {
        return this.colorId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCarouselType() {
        return this.carouselType;
    }

    public final List<String> component6() {
        return this.themeIdList;
    }

    public final CarouselDressEntity copy(int carouselId, String productId, int colorId, String name, int carouselType, List<String> themeIdList) {
        kotlin.jvm.internal.h.e(productId, "productId");
        kotlin.jvm.internal.h.e(name, "name");
        kotlin.jvm.internal.h.e(themeIdList, "themeIdList");
        return new CarouselDressEntity(carouselId, productId, colorId, name, carouselType, themeIdList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getCarouselId() {
        return this.carouselId;
    }

    public final int getCarouselType() {
        return this.carouselType;
    }

    public final int getColorId() {
        return this.colorId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<String> getThemeIdList() {
        return this.themeIdList;
    }

    public final void setCarouselId(int i10) {
        this.carouselId = i10;
    }

    public final void setCarouselType(int i10) {
        this.carouselType = i10;
    }

    public final void setColorId(int i10) {
        this.colorId = i10;
    }

    public final void setName(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.name = str;
    }

    public final void setProductId(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.productId = str;
    }

    public final void setThemeIdList(List<String> list) {
        kotlin.jvm.internal.h.e(list, "<set-?>");
        this.themeIdList = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.carouselId);
        dest.writeString(this.productId);
        dest.writeInt(this.colorId);
        dest.writeString(this.name);
        dest.writeInt(this.carouselType);
        dest.writeStringList(this.themeIdList);
    }

    public CarouselDressEntity(int i10, String productId, int i11, String name, int i12, List<String> themeIdList) {
        kotlin.jvm.internal.h.e(productId, "productId");
        kotlin.jvm.internal.h.e(name, "name");
        kotlin.jvm.internal.h.e(themeIdList, "themeIdList");
        this.carouselId = i10;
        this.productId = productId;
        this.colorId = i11;
        this.name = name;
        this.carouselType = i12;
        this.themeIdList = themeIdList;
    }

    public CarouselDressEntity(int i10, String str, int i11, String str2, int i12, List list, int i13, kotlin.jvm.internal.d dVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? "" : str, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? "" : str2, (i13 & 16) != 0 ? 0 : i12, (i13 & 32) != 0 ? EmptyList.f25350a : list);
    }
}
