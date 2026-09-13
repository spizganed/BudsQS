package com.oplus.melody.btsdk.api.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HearingEnhanceFreqPacket extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingEnhanceFreqPacket> CREATOR = new a();
    private String mAddress;
    private int mEnhanceType;
    private int mKey;
    private final androidx.collection.a<Byte, List<Float>> mLeftFreqPacket;
    private final List<Byte> mLeftPacketIdList;
    private int mPacketId;
    private final androidx.collection.a<Byte, List<Float>> mRightFreqPacket;
    private final List<Byte> mRightPacketIdList;
    private int mSamplingFrequency;
    private int mTotalNum;
    private int mType;
    private int mUid;

    public class a implements Parcelable.Creator<HearingEnhanceFreqPacket> {
        @Override // android.os.Parcelable.Creator
        public final HearingEnhanceFreqPacket createFromParcel(Parcel parcel) {
            return new HearingEnhanceFreqPacket(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingEnhanceFreqPacket[] newArray(int i10) {
            return new HearingEnhanceFreqPacket[i10];
        }
    }

    public HearingEnhanceFreqPacket() {
        this.mLeftPacketIdList = new ArrayList();
        this.mRightPacketIdList = new ArrayList();
        this.mLeftFreqPacket = new androidx.collection.a<>();
        this.mRightFreqPacket = new androidx.collection.a<>();
    }

    public static String getMapKey(String str, int i10) {
        return str + "_" + i10;
    }

    public void addPacket(String str, byte b4, int i10, List<Float> list) {
        if (list == null) {
            return;
        }
        this.mAddress = str;
        if (i10 == 1) {
            this.mLeftFreqPacket.put(Byte.valueOf(b4), list);
            if (this.mLeftPacketIdList.contains(Byte.valueOf(b4))) {
                return;
            }
            this.mLeftPacketIdList.add(Byte.valueOf(b4));
            return;
        }
        if (i10 == 2) {
            this.mRightFreqPacket.put(Byte.valueOf(b4), list);
            if (this.mRightPacketIdList.contains(Byte.valueOf(b4))) {
                return;
            }
            this.mRightPacketIdList.add(Byte.valueOf(b4));
            return;
        }
        if (i10 == 4) {
            this.mLeftFreqPacket.put(Byte.valueOf(b4), list.subList(0, this.mTotalNum / 2));
            if (!this.mLeftPacketIdList.contains(Byte.valueOf(b4))) {
                this.mLeftPacketIdList.add(Byte.valueOf(b4));
            }
            int i11 = this.mTotalNum;
            this.mRightFreqPacket.put(Byte.valueOf(b4), list.subList(i11 / 2, i11));
            if (this.mRightPacketIdList.contains(Byte.valueOf(b4))) {
                return;
            }
            this.mRightPacketIdList.add(Byte.valueOf(b4));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getEnhanceType() {
        return this.mEnhanceType;
    }

    public int getKey() {
        return this.mKey;
    }

    public List<Float> getLeftPerfectData() {
        Collections.sort(this.mLeftPacketIdList);
        ArrayList arrayList = new ArrayList();
        if (isLeftComplete()) {
            Iterator<Byte> it = this.mLeftPacketIdList.iterator();
            while (it.hasNext()) {
                List<Float> list = this.mLeftFreqPacket.get(it.next());
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
        }
        return arrayList;
    }

    public int getPacketId() {
        return this.mPacketId;
    }

    public List<Float> getRightPerfectData() {
        Collections.sort(this.mRightPacketIdList);
        ArrayList arrayList = new ArrayList();
        if (isRightComplete()) {
            Iterator<Byte> it = this.mRightPacketIdList.iterator();
            while (it.hasNext()) {
                List<Float> list = this.mRightFreqPacket.get(it.next());
                if (list != null) {
                    arrayList.addAll(list);
                }
            }
        }
        return arrayList;
    }

    public int getSamplingFrequency() {
        return this.mSamplingFrequency;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public int getType() {
        return this.mType;
    }

    public int getUid() {
        return this.mUid;
    }

    public boolean isComplete() {
        return isLeftComplete() && isRightComplete();
    }

    public boolean isLeftComplete() {
        int size = 0;
        for (int i10 = 0; i10 < this.mLeftFreqPacket.getSize(); i10++) {
            List<Float> listValueAt = this.mLeftFreqPacket.valueAt(i10);
            size += listValueAt == null ? 0 : listValueAt.size();
        }
        return this.mType == 2 ? size >= this.mTotalNum / 2 : size >= this.mTotalNum;
    }

    public boolean isRightComplete() {
        int size = 0;
        for (int i10 = 0; i10 < this.mRightFreqPacket.getSize(); i10++) {
            List<Float> listValueAt = this.mRightFreqPacket.valueAt(i10);
            size += listValueAt == null ? 0 : listValueAt.size();
        }
        return this.mType == 2 ? size >= this.mTotalNum / 2 : size >= this.mTotalNum;
    }

    public void reset() {
        this.mLeftPacketIdList.clear();
        this.mRightPacketIdList.clear();
        this.mLeftFreqPacket.clear();
        this.mRightFreqPacket.clear();
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setEnhanceType(int i10) {
        this.mEnhanceType = i10;
    }

    public void setKey(int i10) {
        this.mKey = i10;
    }

    public void setPacketId(int i10) {
        this.mPacketId = i10;
    }

    public void setSamplingFrequency(int i10) {
        this.mSamplingFrequency = i10;
    }

    public void setTotalNum(int i10) {
        this.mTotalNum = i10;
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public void setUid(int i10) {
        this.mUid = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mTotalNum);
        parcel.writeInt(this.mPacketId);
        parcel.writeInt(this.mKey);
        parcel.writeInt(this.mUid);
        parcel.writeInt(this.mEnhanceType);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mSamplingFrequency);
        parcel.writeList(this.mLeftPacketIdList);
        parcel.writeList(this.mRightPacketIdList);
        parcel.writeMap(this.mLeftFreqPacket);
        parcel.writeMap(this.mRightFreqPacket);
    }

    public HearingEnhanceFreqPacket(Parcel parcel) {
        List arrayList = new ArrayList();
        this.mLeftPacketIdList = arrayList;
        List arrayList2 = new ArrayList();
        this.mRightPacketIdList = arrayList2;
        androidx.collection.a<Byte, List<Float>> aVar = new androidx.collection.a<>();
        this.mLeftFreqPacket = aVar;
        androidx.collection.a<Byte, List<Float>> aVar2 = new androidx.collection.a<>();
        this.mRightFreqPacket = aVar2;
        this.mAddress = parcel.readString();
        this.mTotalNum = parcel.readInt();
        this.mPacketId = parcel.readInt();
        this.mKey = parcel.readInt();
        this.mUid = parcel.readInt();
        this.mEnhanceType = parcel.readInt();
        this.mType = parcel.readInt();
        this.mSamplingFrequency = parcel.readInt();
        parcel.readList(arrayList, Byte.class.getClassLoader());
        parcel.readList(arrayList2, Byte.class.getClassLoader());
        parcel.readMap(aVar, Byte.class.getClassLoader());
        parcel.readMap(aVar2, Byte.class.getClassLoader());
    }
}
