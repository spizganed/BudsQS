package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PersonalizedNoiseReductionResultExist extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PersonalizedNoiseReductionResultExist> CREATOR = new a();
    private static final int OFFSET_RESULT = 0;
    private int mExistResult;

    public class a implements Parcelable.Creator<PersonalizedNoiseReductionResultExist> {
        @Override // android.os.Parcelable.Creator
        public final PersonalizedNoiseReductionResultExist createFromParcel(Parcel parcel) {
            return new PersonalizedNoiseReductionResultExist(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalizedNoiseReductionResultExist[] newArray(int i10) {
            return new PersonalizedNoiseReductionResultExist[i10];
        }
    }

    public PersonalizedNoiseReductionResultExist(int i10, byte[] bArr) {
        this.mExistResult = bArr[i10];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getExistResult() {
        return this.mExistResult;
    }

    public boolean isExistPersonalizedNoiseReductionResult() {
        return this.mExistResult == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mExistResult);
    }

    public PersonalizedNoiseReductionResultExist(Parcel parcel) {
        this.mExistResult = parcel.readInt();
    }
}
