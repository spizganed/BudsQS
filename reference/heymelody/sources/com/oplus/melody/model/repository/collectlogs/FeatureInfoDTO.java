package com.oplus.melody.model.repository.collectlogs;

import A6.b;
import A6.e;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: FeatureInfoDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J;\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0006\u0010#\u001a\u00020\bJ\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006)"}, d2 = {"Lcom/oplus/melody/model/repository/collectlogs/FeatureInfoDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "selected", "", "address", "", SpeechFindManager.TYPE, "", "moduleList", "", "Lcom/oplus/melody/model/repository/collectlogs/ModuleLevelDTO;", "<init>", "(ZLjava/lang/String;ILjava/util/List;)V", "getSelected", "()Z", "setSelected", "(Z)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getModuleList", "()Ljava/util/List;", "setModuleList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FeatureInfoDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<FeatureInfoDTO> CREATOR = new a();
    private String address;
    private List<ModuleLevelDTO> moduleList;
    private boolean selected;
    private int type;

    /* JADX INFO: compiled from: FeatureInfoDTO.kt */
    public static final class a implements Parcelable.Creator<FeatureInfoDTO> {
        @Override // android.os.Parcelable.Creator
        public final FeatureInfoDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            h.e(parcel, "parcel");
            int iB = 0;
            boolean z2 = parcel.readInt() != 0;
            String string = parcel.readString();
            int i10 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                while (iB != i11) {
                    iB = b.b(ModuleLevelDTO.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new FeatureInfoDTO(z2, string, i10, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureInfoDTO[] newArray(int i10) {
            return new FeatureInfoDTO[i10];
        }
    }

    public FeatureInfoDTO() {
        this(false, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureInfoDTO copy$default(FeatureInfoDTO featureInfoDTO, boolean z2, String str, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z2 = featureInfoDTO.selected;
        }
        if ((i11 & 2) != 0) {
            str = featureInfoDTO.address;
        }
        if ((i11 & 4) != 0) {
            i10 = featureInfoDTO.type;
        }
        if ((i11 & 8) != 0) {
            list = featureInfoDTO.moduleList;
        }
        return featureInfoDTO.copy(z2, str, i10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final List<ModuleLevelDTO> component4() {
        return this.moduleList;
    }

    public final FeatureInfoDTO copy(boolean selected, String address, int type, List<ModuleLevelDTO> moduleList) {
        return new FeatureInfoDTO(selected, address, type, moduleList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<ModuleLevelDTO> getModuleList() {
        return this.moduleList;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final int getType() {
        return this.type;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setModuleList(List<ModuleLevelDTO> list) {
        this.moduleList = list;
    }

    public final void setSelected(boolean z2) {
        this.selected = z2;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeInt(this.selected ? 1 : 0);
        dest.writeString(this.address);
        dest.writeInt(this.type);
        List<ModuleLevelDTO> list = this.moduleList;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((ModuleLevelDTO) itG.next()).writeToParcel(dest, flags);
        }
    }

    public FeatureInfoDTO(boolean z2, String str, int i10, List<ModuleLevelDTO> list) {
        this.selected = z2;
        this.address = str;
        this.type = i10;
        this.moduleList = list;
    }

    public /* synthetic */ FeatureInfoDTO(boolean z2, String str, int i10, List list, int i11, d dVar) {
        this((i11 & 1) != 0 ? false : z2, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : list);
    }
}
