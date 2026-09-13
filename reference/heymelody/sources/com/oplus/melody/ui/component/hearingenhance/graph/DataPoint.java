package com.oplus.melody.ui.component.hearingenhance.graph;

import android.os.Parcel;
import android.os.Parcelable;
import ma.b;

/* JADX INFO: loaded from: classes3.dex */
public class DataPoint extends com.oplus.melody.common.data.a implements b, Parcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new a();
    private double mX;
    private double mY;

    public class a implements Parcelable.Creator<DataPoint> {
        @Override // android.os.Parcelable.Creator
        public final DataPoint createFromParcel(Parcel parcel) {
            return new DataPoint(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final DataPoint[] newArray(int i10) {
            return new DataPoint[i10];
        }
    }

    public DataPoint(double d10, double d11) {
        this.mX = d10;
        this.mY = d11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // ma.b
    public double getX() {
        return this.mX;
    }

    @Override // ma.b
    public double getY() {
        return this.mY;
    }

    public void setX(double d10) {
        this.mX = d10;
    }

    public void setY(double d10) {
        this.mY = d10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeDouble(this.mX);
        parcel.writeDouble(this.mY);
    }

    public DataPoint(Parcel parcel) {
        this.mX = parcel.readDouble();
        this.mY = parcel.readDouble();
    }
}
