package com.oplus.melody.model.repository.zenmode;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: ZenModePlayStateDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/model/repository/zenmode/ZenModePlayStateDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "resId", "state", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAddress", "()Ljava/lang/String;", "getResId", "getState", "()I", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ZenModePlayStateDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ZenModePlayStateDTO> CREATOR = new a();
    private final String address;
    private final String resId;
    private final int state;

    /* JADX INFO: compiled from: ZenModePlayStateDTO.kt */
    public static final class a implements Parcelable.Creator<ZenModePlayStateDTO> {
        @Override // android.os.Parcelable.Creator
        public final ZenModePlayStateDTO createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new ZenModePlayStateDTO(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ZenModePlayStateDTO[] newArray(int i10) {
            return new ZenModePlayStateDTO[i10];
        }
    }

    public ZenModePlayStateDTO(String address, String resId, int i10) {
        kotlin.jvm.internal.h.e(address, "address");
        kotlin.jvm.internal.h.e(resId, "resId");
        this.address = address;
        this.resId = resId;
        this.state = i10;
    }

    public static /* synthetic */ ZenModePlayStateDTO copy$default(ZenModePlayStateDTO zenModePlayStateDTO, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = zenModePlayStateDTO.address;
        }
        if ((i11 & 2) != 0) {
            str2 = zenModePlayStateDTO.resId;
        }
        if ((i11 & 4) != 0) {
            i10 = zenModePlayStateDTO.state;
        }
        return zenModePlayStateDTO.copy(str, str2, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getState() {
        return this.state;
    }

    public final ZenModePlayStateDTO copy(String address, String resId, int state) {
        kotlin.jvm.internal.h.e(address, "address");
        kotlin.jvm.internal.h.e(resId, "resId");
        return new ZenModePlayStateDTO(address, resId, state);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getResId() {
        return this.resId;
    }

    public final int getState() {
        return this.state;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeString(this.resId);
        dest.writeInt(this.state);
    }
}
