package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class GameSoundInfo extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<GameSoundInfo> CREATOR = new a();
    private int mSelectType;
    private int[] mSupportTypes;

    public class a implements Parcelable.Creator<GameSoundInfo> {
        @Override // android.os.Parcelable.Creator
        public final GameSoundInfo createFromParcel(Parcel parcel) {
            return new GameSoundInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final GameSoundInfo[] newArray(int i10) {
            return new GameSoundInfo[i10];
        }
    }

    public GameSoundInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getSelectType() {
        return this.mSelectType;
    }

    public int[] getSupportTypes() {
        return this.mSupportTypes;
    }

    public void setSelectType(int i10) {
        this.mSelectType = i10;
    }

    public void setSupportTypes(int[] iArr) {
        this.mSupportTypes = iArr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mSelectType);
        parcel.writeIntArray(this.mSupportTypes);
    }

    public GameSoundInfo(Parcel parcel) {
        this.mSelectType = parcel.readInt();
        this.mSupportTypes = parcel.createIntArray();
    }
}
