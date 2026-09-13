package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class ZenModeFileInformation extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ZenModeFileInformation> CREATOR = new a();
    public static final int LENGTH_ZENMODE_FILE_ID = 4;
    public static final int LENGTH_ZENMODE_FILE_STATUS = 1;
    public static final int MIN_LENGTH_ZENMODE_FILE_INFO = 6;
    private int fileId;
    private String fileName;
    private boolean fileWell;

    public class a implements Parcelable.Creator<ZenModeFileInformation> {
        @Override // android.os.Parcelable.Creator
        public final ZenModeFileInformation createFromParcel(Parcel parcel) {
            return new ZenModeFileInformation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ZenModeFileInformation[] newArray(int i10) {
            return new ZenModeFileInformation[i10];
        }
    }

    public ZenModeFileInformation(int i10, int i11, byte[] bArr) {
        this.fileId = i10;
        this.fileWell = i11 == 0;
        this.fileName = new String(bArr, Charset.defaultCharset());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public boolean isFileWell() {
        return this.fileWell;
    }

    public void setFileId(int i10) {
        this.fileId = i10;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileWell(boolean z2) {
        this.fileWell = z2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.fileId);
        parcel.writeInt(this.fileWell ? 1 : 0);
        parcel.writeString(this.fileName);
    }

    public ZenModeFileInformation(Parcel parcel) {
        this.fileId = parcel.readInt();
        this.fileWell = parcel.readInt() != 0;
        this.fileName = parcel.readString();
    }
}
