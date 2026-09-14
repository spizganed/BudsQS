package com.oplus.melody.model.repository.personaldress;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: DressBySeriesDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/DressBySeriesDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "seriesId", "", "productId", "", "color", "personalDressData", "", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "<init>", "(ILjava/lang/String;ILjava/util/List;)V", "getSeriesId", "()I", "setSeriesId", "(I)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getColor", "setColor", "getPersonalDressData", "()Ljava/util/List;", "setPersonalDressData", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DressBySeriesDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DressBySeriesDTO> CREATOR = new a();
    private int color;
    private List<PersonalDressDTO.PersonalDressData> personalDressData;
    private String productId;
    private int seriesId;

    /* JADX INFO: compiled from: DressBySeriesDTO.kt */
    public static final class a implements Parcelable.Creator<DressBySeriesDTO> {
        @Override // android.os.Parcelable.Creator
        public final DressBySeriesDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            h.e(parcel, "parcel");
            int i10 = parcel.readInt();
            String string = parcel.readString();
            int i11 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i12 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i12);
                int iB = 0;
                while (iB != i12) {
                    iB = A6.b.b(PersonalDressDTO.PersonalDressData.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new DressBySeriesDTO(i10, string, i11, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final DressBySeriesDTO[] newArray(int i10) {
            return new DressBySeriesDTO[i10];
        }
    }

    public DressBySeriesDTO() {
        this(0, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DressBySeriesDTO copy$default(DressBySeriesDTO dressBySeriesDTO, int i10, String str, int i11, List list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = dressBySeriesDTO.seriesId;
        }
        if ((i12 & 2) != 0) {
            str = dressBySeriesDTO.productId;
        }
        if ((i12 & 4) != 0) {
            i11 = dressBySeriesDTO.color;
        }
        if ((i12 & 8) != 0) {
            list = dressBySeriesDTO.personalDressData;
        }
        return dressBySeriesDTO.copy(i10, str, i11, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getSeriesId() {
        return this.seriesId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final List<PersonalDressDTO.PersonalDressData> component4() {
        return this.personalDressData;
    }

    public final DressBySeriesDTO copy(int seriesId, String productId, int color, List<PersonalDressDTO.PersonalDressData> personalDressData) {
        return new DressBySeriesDTO(seriesId, productId, color, personalDressData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getColor() {
        return this.color;
    }

    public final List<PersonalDressDTO.PersonalDressData> getPersonalDressData() {
        return this.personalDressData;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int getSeriesId() {
        return this.seriesId;
    }

    public final void setColor(int i10) {
        this.color = i10;
    }

    public final void setPersonalDressData(List<PersonalDressDTO.PersonalDressData> list) {
        this.personalDressData = list;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    public final void setSeriesId(int i10) {
        this.seriesId = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeInt(this.seriesId);
        dest.writeString(this.productId);
        dest.writeInt(this.color);
        List<PersonalDressDTO.PersonalDressData> list = this.personalDressData;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = A6.e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((PersonalDressDTO.PersonalDressData) itG.next()).writeToParcel(dest, flags);
        }
    }

    public DressBySeriesDTO(int i10, String str, int i11, List<PersonalDressDTO.PersonalDressData> list) {
        this.seriesId = i10;
        this.productId = str;
        this.color = i11;
        this.personalDressData = list;
    }

    public /* synthetic */ DressBySeriesDTO(int i10, String str, int i11, List list, int i12, kotlin.jvm.internal.d dVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : list);
    }
}
