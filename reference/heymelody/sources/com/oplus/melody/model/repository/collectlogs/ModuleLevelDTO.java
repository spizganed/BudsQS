package com.oplus.melody.model.repository.collectlogs;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: FeatureInfoDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/model/repository/collectlogs/ModuleLevelDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "module", "", "level", "<init>", "(II)V", "getModule", "()I", "setModule", "(I)V", "getLevel", "setLevel", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ModuleLevelDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ModuleLevelDTO> CREATOR = new a();
    private int level;
    private int module;

    /* JADX INFO: compiled from: FeatureInfoDTO.kt */
    public static final class a implements Parcelable.Creator<ModuleLevelDTO> {
        @Override // android.os.Parcelable.Creator
        public final ModuleLevelDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new ModuleLevelDTO(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ModuleLevelDTO[] newArray(int i10) {
            return new ModuleLevelDTO[i10];
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ModuleLevelDTO() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public static /* synthetic */ ModuleLevelDTO copy$default(ModuleLevelDTO moduleLevelDTO, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = moduleLevelDTO.module;
        }
        if ((i12 & 2) != 0) {
            i11 = moduleLevelDTO.level;
        }
        return moduleLevelDTO.copy(i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getModule() {
        return this.module;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public final ModuleLevelDTO copy(int module, int level) {
        return new ModuleLevelDTO(module, level);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getModule() {
        return this.module;
    }

    public final void setLevel(int i10) {
        this.level = i10;
    }

    public final void setModule(int i10) {
        this.module = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeInt(this.module);
        dest.writeInt(this.level);
    }

    public ModuleLevelDTO(int i10, int i11) {
        this.module = i10;
        this.level = i11;
    }

    public /* synthetic */ ModuleLevelDTO(int i10, int i11, int i12, d dVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
    }
}
