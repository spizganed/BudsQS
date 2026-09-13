package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: HeadMotionTryResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/btsdk/api/data/HeadMotionTryResult;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "resultCode", "", "<init>", "(Ljava/lang/String;I)V", "getAddress", "()Ljava/lang/String;", "getResultCode", "()I", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class HeadMotionTryResult extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HeadMotionTryResult> CREATOR = new a();
    private final String address;
    private final int resultCode;

    /* JADX INFO: compiled from: HeadMotionTryResult.kt */
    public static final class a implements Parcelable.Creator<HeadMotionTryResult> {
        @Override // android.os.Parcelable.Creator
        public final HeadMotionTryResult createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new HeadMotionTryResult(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final HeadMotionTryResult[] newArray(int i10) {
            return new HeadMotionTryResult[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeadMotionTryResult() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HeadMotionTryResult copy$default(HeadMotionTryResult headMotionTryResult, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = headMotionTryResult.address;
        }
        if ((i11 & 2) != 0) {
            i10 = headMotionTryResult.resultCode;
        }
        return headMotionTryResult.copy(str, i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getResultCode() {
        return this.resultCode;
    }

    public final HeadMotionTryResult copy(String address, int resultCode) {
        h.e(address, "address");
        return new HeadMotionTryResult(address, resultCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        dest.writeInt(this.resultCode);
    }

    public HeadMotionTryResult(String address, int i10) {
        h.e(address, "address");
        this.address = address;
        this.resultCode = i10;
    }

    public /* synthetic */ HeadMotionTryResult(String str, int i10, int i11, d dVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? -1 : i10);
    }
}
