package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class PersonalizedNoiseReductionResult extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PersonalizedNoiseReductionResult> CREATOR = new a();
    public static final int LENGTH_PERSONALIZED_NOISE_REDUCTION = 1;
    private static final int OFFSET_RESULT = 0;
    private String mAddress;
    private int mNoiseReductionResult;

    public class a implements Parcelable.Creator<PersonalizedNoiseReductionResult> {
        @Override // android.os.Parcelable.Creator
        public final PersonalizedNoiseReductionResult createFromParcel(Parcel parcel) {
            return new PersonalizedNoiseReductionResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalizedNoiseReductionResult[] newArray(int i10) {
            return new PersonalizedNoiseReductionResult[i10];
        }
    }

    public PersonalizedNoiseReductionResult(int i10, byte[] bArr) {
        this.mNoiseReductionResult = bArr[i10];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getNoiseReductionResult() {
        return this.mNoiseReductionResult;
    }

    public void readFromParcel(Parcel parcel) {
        this.mNoiseReductionResult = parcel.readInt();
        this.mAddress = parcel.readString();
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mNoiseReductionResult);
        parcel.writeString(this.mAddress);
    }

    public PersonalizedNoiseReductionResult(int i10) {
        this.mNoiseReductionResult = i10;
    }

    public PersonalizedNoiseReductionResult(Parcel parcel) {
        this.mNoiseReductionResult = parcel.readInt();
        this.mAddress = parcel.readString();
    }
}
