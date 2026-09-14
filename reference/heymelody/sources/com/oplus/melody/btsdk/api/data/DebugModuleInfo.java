package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DebugModuleInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DebugModuleInfo> CREATOR = new a();
    public static final int LENGTH_MODULE_ITEM = 2;
    private static final int OFFSET_LEVEL = 1;
    private static final int OFFSET_MODULE = 0;
    private int mLevel;
    private int mModule;

    public class a implements Parcelable.Creator<DebugModuleInfo> {
        @Override // android.os.Parcelable.Creator
        public final DebugModuleInfo createFromParcel(Parcel parcel) {
            return new DebugModuleInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DebugModuleInfo[] newArray(int i10) {
            return new DebugModuleInfo[i10];
        }
    }

    public DebugModuleInfo(int i10, int i11) {
        this.mModule = i10;
        this.mLevel = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public int getModule() {
        return this.mModule;
    }

    public void setLevel(int i10) {
        this.mLevel = i10;
    }

    public void setModule(int i10) {
        this.mModule = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mModule);
        parcel.writeInt(this.mLevel);
    }

    public DebugModuleInfo(int i10, byte[] bArr) {
        this.mModule = bArr[i10];
        this.mLevel = bArr[i10 + 1];
    }

    public DebugModuleInfo(Parcel parcel) {
        this.mModule = parcel.readInt();
        this.mLevel = parcel.readInt();
    }
}
