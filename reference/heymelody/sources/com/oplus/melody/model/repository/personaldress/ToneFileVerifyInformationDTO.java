package com.oplus.melody.model.repository.personaldress;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.oplus.melody.common.util.A;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class ToneFileVerifyInformationDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<ToneFileVerifyInformationDTO> CREATOR = new a();
    public static final int MAX_ZENDMOE_NAME_LENGTH_TO_SET = 50;
    public static final int PAYLOAD_CRC32_LENGTH = 4;
    public static final int PAYLOAD_ID_LENGTH = 4;
    public static final int PAYLOAD_SIZE_LENGTH = 4;
    private int mCRC32;
    private int mId;
    private String mName;
    private int mSize;

    public class a implements Parcelable.Creator<ToneFileVerifyInformationDTO> {
        @Override // android.os.Parcelable.Creator
        public final ToneFileVerifyInformationDTO createFromParcel(Parcel parcel) {
            return new ToneFileVerifyInformationDTO(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ToneFileVerifyInformationDTO[] newArray(int i10) {
            return new ToneFileVerifyInformationDTO[i10];
        }
    }

    public ToneFileVerifyInformationDTO(int i10, int i11, int i12, String str) {
        this.mId = i10;
        this.mSize = i11;
        this.mCRC32 = i12;
        this.mName = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCRC32() {
        return this.mCRC32;
    }

    public byte[] getData() {
        String name = getName();
        if (this.mId != 1 && (TextUtils.isEmpty(name) || this.mCRC32 == 0 || this.mSize == 0)) {
            return new byte[0];
        }
        byte[] bytes = name.getBytes(Charset.defaultCharset());
        int length = bytes.length;
        byte[] bArr = new byte[12 + length];
        try {
            D5.c.i(this.mId, 0, 4, bArr);
            D5.c.i(this.mSize, 4, 4, bArr);
            D5.c.i(this.mCRC32, 8, 4, bArr);
            System.arraycopy(bytes, 0, bArr, 12, length);
            return bArr;
        } catch (Exception e10) {
            A.i("ToneFileVerifyInformationDTO", "getData", e10);
            return new byte[0];
        }
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        if (this.mName.length() > 50) {
            this.mName = this.mName.substring(0, 50);
        }
        return this.mName;
    }

    public int getSize() {
        return this.mSize;
    }

    public void setCRC32(int i10) {
        this.mCRC32 = i10;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSize(int i10) {
        this.mSize = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mSize);
        parcel.writeInt(this.mCRC32);
        parcel.writeString(this.mName);
    }

    public ToneFileVerifyInformationDTO(Parcel parcel) {
        this.mId = parcel.readInt();
        this.mSize = parcel.readInt();
        this.mCRC32 = parcel.readInt();
        this.mName = parcel.readString();
    }
}
