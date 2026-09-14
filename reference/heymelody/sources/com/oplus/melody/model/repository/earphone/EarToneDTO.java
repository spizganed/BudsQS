package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.btsdk.api.data.EarTone;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: EarToneDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0004J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/oplus/melody/model/repository/earphone/EarToneDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "isValid", "name", "", "isSelect", "crc", "<init>", "(IILjava/lang/String;II)V", "earTone", "Lcom/oplus/melody/btsdk/api/data/EarTone;", "(Lcom/oplus/melody/btsdk/api/data/EarTone;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getCrc", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EarToneDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<EarToneDTO> CREATOR = new a();
    private final int crc;
    private final int id;
    private final int isSelect;
    private final int isValid;
    private final String name;

    /* JADX INFO: compiled from: EarToneDTO.kt */
    public static final class a implements Parcelable.Creator<EarToneDTO> {
        @Override // android.os.Parcelable.Creator
        public final EarToneDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new EarToneDTO(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EarToneDTO[] newArray(int i10) {
            return new EarToneDTO[i10];
        }
    }

    public EarToneDTO(int i10, int i11, String str, int i12, int i13) {
        this.id = i10;
        this.isValid = i11;
        this.name = str;
        this.isSelect = i12;
        this.crc = i13;
    }

    public static /* synthetic */ EarToneDTO copy$default(EarToneDTO earToneDTO, int i10, int i11, String str, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = earToneDTO.id;
        }
        if ((i14 & 2) != 0) {
            i11 = earToneDTO.isValid;
        }
        if ((i14 & 4) != 0) {
            str = earToneDTO.name;
        }
        if ((i14 & 8) != 0) {
            i12 = earToneDTO.isSelect;
        }
        if ((i14 & 16) != 0) {
            i13 = earToneDTO.crc;
        }
        int i15 = i13;
        String str2 = str;
        return earToneDTO.copy(i10, i11, str2, i12, i15);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getIsValid() {
        return this.isValid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getIsSelect() {
        return this.isSelect;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getCrc() {
        return this.crc;
    }

    public final EarToneDTO copy(int id, int isValid, String name, int isSelect, int crc) {
        return new EarToneDTO(id, isValid, name, isSelect, crc);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getCrc() {
        return this.crc;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int isSelect() {
        return this.isSelect;
    }

    public final int isValid() {
        return this.isValid;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.id);
        dest.writeInt(this.isValid);
        dest.writeString(this.name);
        dest.writeInt(this.isSelect);
        dest.writeInt(this.crc);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EarToneDTO(EarTone earTone) {
        kotlin.jvm.internal.h.e(earTone, "earTone");
        int crc = earTone.getCrc();
        int id = earTone.getId();
        int isSelect = earTone.getIsSelect();
        this(id, earTone.isVaild(), earTone.getName(), isSelect, crc);
    }
}
