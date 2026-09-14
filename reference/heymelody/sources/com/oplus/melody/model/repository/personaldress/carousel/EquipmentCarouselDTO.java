package com.oplus.melody.model.repository.personaldress.carousel;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: EquipmentCarouselDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u001f\u001a\u00020\u0006J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006%"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/carousel/EquipmentCarouselDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "macAddress", "", "carouselId", "", "carouselStartTime", "", "carouselThemeIndex", "<init>", "(Ljava/lang/String;IJI)V", "getMacAddress", "()Ljava/lang/String;", "setMacAddress", "(Ljava/lang/String;)V", "getCarouselId", "()I", "setCarouselId", "(I)V", "getCarouselStartTime", "()J", "setCarouselStartTime", "(J)V", "getCarouselThemeIndex", "setCarouselThemeIndex", "component1", "component2", "component3", "component4", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EquipmentCarouselDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EquipmentCarouselDTO> CREATOR = new a();
    private int carouselId;
    private long carouselStartTime;
    private int carouselThemeIndex;
    private String macAddress;

    /* JADX INFO: compiled from: EquipmentCarouselDTO.kt */
    public static final class a implements Parcelable.Creator<EquipmentCarouselDTO> {
        @Override // android.os.Parcelable.Creator
        public final EquipmentCarouselDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new EquipmentCarouselDTO(parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EquipmentCarouselDTO[] newArray(int i10) {
            return new EquipmentCarouselDTO[i10];
        }
    }

    public EquipmentCarouselDTO() {
        this(null, 0, 0L, 0, 15, null);
    }

    public static /* synthetic */ EquipmentCarouselDTO copy$default(EquipmentCarouselDTO equipmentCarouselDTO, String str, int i10, long j5, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = equipmentCarouselDTO.macAddress;
        }
        if ((i12 & 2) != 0) {
            i10 = equipmentCarouselDTO.carouselId;
        }
        if ((i12 & 4) != 0) {
            j5 = equipmentCarouselDTO.carouselStartTime;
        }
        if ((i12 & 8) != 0) {
            i11 = equipmentCarouselDTO.carouselThemeIndex;
        }
        int i13 = i11;
        return equipmentCarouselDTO.copy(str, i10, j5, i13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMacAddress() {
        return this.macAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCarouselId() {
        return this.carouselId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCarouselStartTime() {
        return this.carouselStartTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCarouselThemeIndex() {
        return this.carouselThemeIndex;
    }

    public final EquipmentCarouselDTO copy(String macAddress, int carouselId, long carouselStartTime, int carouselThemeIndex) {
        h.e(macAddress, "macAddress");
        return new EquipmentCarouselDTO(macAddress, carouselId, carouselStartTime, carouselThemeIndex);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getCarouselId() {
        return this.carouselId;
    }

    public final long getCarouselStartTime() {
        return this.carouselStartTime;
    }

    public final int getCarouselThemeIndex() {
        return this.carouselThemeIndex;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final void setCarouselId(int i10) {
        this.carouselId = i10;
    }

    public final void setCarouselStartTime(long j5) {
        this.carouselStartTime = j5;
    }

    public final void setCarouselThemeIndex(int i10) {
        this.carouselThemeIndex = i10;
    }

    public final void setMacAddress(String str) {
        h.e(str, "<set-?>");
        this.macAddress = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.macAddress);
        dest.writeInt(this.carouselId);
        dest.writeLong(this.carouselStartTime);
        dest.writeInt(this.carouselThemeIndex);
    }

    public EquipmentCarouselDTO(String macAddress, int i10, long j5, int i11) {
        h.e(macAddress, "macAddress");
        this.macAddress = macAddress;
        this.carouselId = i10;
        this.carouselStartTime = j5;
        this.carouselThemeIndex = i11;
    }

    public /* synthetic */ EquipmentCarouselDTO(String str, int i10, long j5, int i11, int i12, d dVar) {
        this((i12 & 1) != 0 ? "" : str, (i12 & 2) != 0 ? -1 : i10, (i12 & 4) != 0 ? 0L : j5, (i12 & 8) != 0 ? 0 : i11);
    }
}
