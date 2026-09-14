package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.common.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: OneshotEncodeState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0010J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u001e\u001a\u00020\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/oplus/melody/btsdk/api/data/OneshotEncodeState;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "TAG", "", "mAddress", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mState", "", "getMState", "()I", "setMState", "(I)V", "init", "", "address", "state", "writeToParcel", "dest", "flags", "describeContents", "getAddress", "getState", "CREATOR", "btsdk_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class OneshotEncodeState extends a implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private final String TAG;
    private String mAddress;
    private int mState;

    /* JADX INFO: renamed from: com.oplus.melody.btsdk.api.data.OneshotEncodeState$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: OneshotEncodeState.kt */
    public static final class Companion implements Parcelable.Creator<OneshotAudioDataInfo> {
        @Override // android.os.Parcelable.Creator
        public final OneshotAudioDataInfo createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new OneshotAudioDataInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final OneshotAudioDataInfo[] newArray(int i10) {
            return new OneshotAudioDataInfo[i10];
        }
    }

    public OneshotEncodeState() {
        this.TAG = "OneshotEncodeState";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: getAddress, reason: from getter */
    public final String getMAddress() {
        return this.mAddress;
    }

    public final String getMAddress() {
        return this.mAddress;
    }

    public final int getMState() {
        return this.mState;
    }

    public final int getState() {
        return this.mState;
    }

    public final void init(String address, int state) {
        h.e(address, "address");
        this.mAddress = address;
        this.mState = state;
    }

    public final void setMAddress(String str) {
        this.mAddress = str;
    }

    public final void setMState(int i10) {
        this.mState = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.mAddress);
        dest.writeInt(this.mState);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OneshotEncodeState(Parcel parcel) {
        this();
        h.e(parcel, "parcel");
        this.mAddress = parcel.readString();
        this.mState = parcel.readInt();
    }
}
