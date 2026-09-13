package com.oplus.melody.model.repository.personaldress.carousel;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: CarouselDressDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003JU\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0006\u0010-\u001a\u00020\u0004J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b#\u0010$¨\u00063"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/carousel/CarouselDressDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "carouselId", "", "productId", "", "colorId", "name", "carouselType", "themeIdList", "", "isApplied", "", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/util/List;Z)V", "getCarouselId", "()I", "setCarouselId", "(I)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getColorId", "setColorId", "getName", "setName", "getCarouselType", "setCarouselType", "getThemeIdList", "()Ljava/util/List;", "setThemeIdList", "(Ljava/util/List;)V", "()Z", "setApplied", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CarouselDressDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<CarouselDressDTO> CREATOR = new a();
    private int carouselId;
    private int carouselType;
    private int colorId;
    private boolean isApplied;
    private String name;
    private String productId;
    private List<String> themeIdList;

    /* JADX INFO: compiled from: CarouselDressDTO.kt */
    public static final class a implements Parcelable.Creator<CarouselDressDTO> {
        @Override // android.os.Parcelable.Creator
        public final CarouselDressDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new CarouselDressDTO(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.createStringArrayList(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final CarouselDressDTO[] newArray(int i10) {
            return new CarouselDressDTO[i10];
        }
    }

    public CarouselDressDTO() {
        this(0, null, 0, null, 0, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarouselDressDTO copy$default(CarouselDressDTO carouselDressDTO, int i10, String str, int i11, String str2, int i12, List list, boolean z2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = carouselDressDTO.carouselId;
        }
        if ((i13 & 2) != 0) {
            str = carouselDressDTO.productId;
        }
        if ((i13 & 4) != 0) {
            i11 = carouselDressDTO.colorId;
        }
        if ((i13 & 8) != 0) {
            str2 = carouselDressDTO.name;
        }
        if ((i13 & 16) != 0) {
            i12 = carouselDressDTO.carouselType;
        }
        if ((i13 & 32) != 0) {
            list = carouselDressDTO.themeIdList;
        }
        if ((i13 & 64) != 0) {
            z2 = carouselDressDTO.isApplied;
        }
        List list2 = list;
        boolean z4 = z2;
        int i14 = i12;
        int i15 = i11;
        return carouselDressDTO.copy(i10, str, i15, str2, i14, list2, z4);
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

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsApplied() {
        return this.isApplied;
    }

    public final CarouselDressDTO copy(int carouselId, String productId, int colorId, String name, int carouselType, List<String> themeIdList, boolean isApplied) {
        h.e(productId, "productId");
        h.e(name, "name");
        h.e(themeIdList, "themeIdList");
        return new CarouselDressDTO(carouselId, productId, colorId, name, carouselType, themeIdList, isApplied);
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

    public final boolean isApplied() {
        return this.isApplied;
    }

    public final void setApplied(boolean z2) {
        this.isApplied = z2;
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
        h.e(str, "<set-?>");
        this.name = str;
    }

    public final void setProductId(String str) {
        h.e(str, "<set-?>");
        this.productId = str;
    }

    public final void setThemeIdList(List<String> list) {
        h.e(list, "<set-?>");
        this.themeIdList = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeInt(this.carouselId);
        dest.writeString(this.productId);
        dest.writeInt(this.colorId);
        dest.writeString(this.name);
        dest.writeInt(this.carouselType);
        dest.writeStringList(this.themeIdList);
        dest.writeInt(this.isApplied ? 1 : 0);
    }

    public CarouselDressDTO(int i10, String productId, int i11, String name, int i12, List<String> themeIdList, boolean z2) {
        h.e(productId, "productId");
        h.e(name, "name");
        h.e(themeIdList, "themeIdList");
        this.carouselId = i10;
        this.productId = productId;
        this.colorId = i11;
        this.name = name;
        this.carouselType = i12;
        this.themeIdList = themeIdList;
        this.isApplied = z2;
    }

    public CarouselDressDTO(int i10, String str, int i11, String str2, int i12, List list, boolean z2, int i13, d dVar) {
        this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? "" : str, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? "" : str2, (i13 & 16) != 0 ? 1 : i12, (i13 & 32) != 0 ? EmptyList.f25350a : list, (i13 & 64) != 0 ? false : z2);
    }
}
