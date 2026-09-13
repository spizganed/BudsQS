package com.oplus.melody.model.repository.firmware;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public final class FirmwareDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<FirmwareDTO> CREATOR = new a();
    private String mDownloadSha256;
    private int mDownloadSize;
    private String mDownloadUrl;
    private String mHardwareVersion;
    private String mName;
    private String mProductId;
    private String mProductName;
    private String mSoftwareVersion;
    private String mUpdateInfo;
    private String mVendorCode;

    public class a implements Parcelable.Creator<FirmwareDTO> {
        @Override // android.os.Parcelable.Creator
        public final FirmwareDTO createFromParcel(Parcel parcel) {
            return new FirmwareDTO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FirmwareDTO[] newArray(int i10) {
            return new FirmwareDTO[i10];
        }
    }

    public FirmwareDTO(Parcel parcel) {
        this.mName = parcel.readString();
        this.mDownloadUrl = parcel.readString();
        this.mDownloadSize = parcel.readInt();
        this.mDownloadSha256 = parcel.readString();
        this.mProductName = parcel.readString();
        this.mProductId = parcel.readString();
        this.mUpdateInfo = parcel.readString();
        this.mSoftwareVersion = parcel.readString();
        this.mHardwareVersion = parcel.readString();
        this.mVendorCode = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDownloadSha256() {
        return this.mDownloadSha256;
    }

    public int getDownloadSize() {
        return this.mDownloadSize;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String getHardwareVersion() {
        return this.mHardwareVersion;
    }

    public String getName() {
        return this.mName;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public String getSoftwareVersion() {
        return this.mSoftwareVersion;
    }

    public String getUpdateInfo() {
        return this.mUpdateInfo;
    }

    public String getVendorCode() {
        return this.mVendorCode;
    }

    public void setDownloadSha256(String str) {
        this.mDownloadSha256 = str;
    }

    public void setDownloadSize(int i10) {
        this.mDownloadSize = i10;
    }

    public void setDownloadUrl(String str) {
        this.mDownloadUrl = str;
    }

    public void setHardwareVersion(String str) {
        this.mHardwareVersion = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setProductName(String str) {
        this.mProductName = str;
    }

    public void setSoftwareVersion(String str) {
        this.mSoftwareVersion = str;
    }

    public void setUpdateInfo(String str) {
        this.mUpdateInfo = str;
    }

    public void setVendorCode(String str) {
        this.mVendorCode = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mDownloadUrl);
        parcel.writeInt(this.mDownloadSize);
        parcel.writeString(this.mDownloadSha256);
        parcel.writeString(this.mProductName);
        parcel.writeString(this.mProductId);
        parcel.writeString(this.mUpdateInfo);
        parcel.writeString(this.mSoftwareVersion);
        parcel.writeString(this.mHardwareVersion);
        parcel.writeString(this.mVendorCode);
    }

    public FirmwareDTO() {
    }
}
