package com.oplus.melody.model.db;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.hearingenhance.HearingEnhanceDataDTO;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HearingEnhancementEntity extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<HearingEnhancementEntity> CREATOR = new a();
    private static final int START_INDEX = 1;
    private String mAddress;
    private long mCreateTime;
    private HearingEnhanceDataDTO mData;
    private String mLocalIndex;
    private String mName;
    private String mUid;

    public class a implements Parcelable.Creator<HearingEnhancementEntity> {
        @Override // android.os.Parcelable.Creator
        public final HearingEnhancementEntity createFromParcel(Parcel parcel) {
            return new HearingEnhancementEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final HearingEnhancementEntity[] newArray(int i10) {
            return new HearingEnhancementEntity[i10];
        }
    }

    public HearingEnhancementEntity() {
        this.mUid = "";
    }

    public static HearingEnhancementEntity findMatchEntity(List<HearingEnhancementEntity> list, HearingEnhancementEntity hearingEnhancementEntity) {
        if (hearingEnhancementEntity != null && list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                if (list.get(i10) != null && TextUtils.equals(list.get(i10).getUid(), hearingEnhancementEntity.getUid())) {
                    return list.get(i10);
                }
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public long getCreateTime() {
        return this.mCreateTime;
    }

    public HearingEnhanceDataDTO getData() {
        return this.mData;
    }

    public String getDisplayName(int i10) {
        HearingEnhanceDataDTO hearingEnhanceDataDTO = this.mData;
        if (hearingEnhanceDataDTO == null || TextUtils.isEmpty(hearingEnhanceDataDTO.getRecordName())) {
            return String.format(C0906l.f19501a.getString(i10), TextUtils.isEmpty(this.mLocalIndex) ? "" : this.mLocalIndex);
        }
        return this.mData.getRecordName();
    }

    public String getLocalIndex() {
        return this.mLocalIndex;
    }

    public String getName() {
        return this.mName;
    }

    public String getUid() {
        return this.mUid;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setCreateTime(long j5) {
        this.mCreateTime = j5;
    }

    public void setData(HearingEnhanceDataDTO hearingEnhanceDataDTO) {
        this.mData = hearingEnhanceDataDTO;
    }

    public void setLocalIndex(String str) {
        this.mLocalIndex = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mUid);
        parcel.writeString(this.mName);
        parcel.writeString(this.mAddress);
        parcel.writeParcelable(this.mData, i10);
        parcel.writeLong(this.mCreateTime);
        parcel.writeString(this.mLocalIndex);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getLocalIndex(java.util.List<com.oplus.melody.model.db.HearingEnhancementEntity> r6, com.oplus.melody.model.db.HearingEnhancementEntity r7) {
        /*
            if (r6 == 0) goto L82
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto La
            goto L82
        La:
            r0 = 0
            if (r7 == 0) goto L3a
            r1 = r0
        Le:
            int r2 = r6.size()
            if (r1 >= r2) goto L3a
            java.lang.Object r2 = r6.get(r1)
            com.oplus.melody.model.db.HearingEnhancementEntity r2 = (com.oplus.melody.model.db.HearingEnhancementEntity) r2
            java.lang.String r3 = r2.getUid()
            java.lang.String r4 = r7.getUid()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L37
            java.lang.String r3 = r2.getLocalIndex()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L37
            java.lang.String r6 = r2.getLocalIndex()
            return r6
        L37:
            int r1 = r1 + 1
            goto Le
        L3a:
            r7 = 1
            r1 = r7
        L3c:
            r2 = r0
        L3d:
            int r3 = r6.size()
            if (r2 >= r3) goto L7f
            java.lang.Object r3 = r6.get(r2)
            com.oplus.melody.model.db.HearingEnhancementEntity r3 = (com.oplus.melody.model.db.HearingEnhancementEntity) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r5 = ""
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r3 = r3.getLocalIndex()
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            if (r3 == 0) goto L65
            goto L7f
        L65:
            int r3 = r6.size()
            int r3 = r3 - r7
            if (r2 != r3) goto L7c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            return r6
        L7c:
            int r2 = r2 + 1
            goto L3d
        L7f:
            int r1 = r1 + 1
            goto L3c
        L82:
            java.lang.String r6 = "1"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.model.db.HearingEnhancementEntity.getLocalIndex(java.util.List, com.oplus.melody.model.db.HearingEnhancementEntity):java.lang.String");
    }

    public HearingEnhancementEntity(Parcel parcel) {
        this.mUid = "";
        String string = parcel.readString();
        this.mUid = string != null ? string : "";
        this.mName = parcel.readString();
        this.mAddress = parcel.readString();
        this.mData = (HearingEnhanceDataDTO) parcel.readParcelable(HearingEnhanceDataDTO.class.getClassLoader());
        this.mCreateTime = parcel.readLong();
        this.mLocalIndex = parcel.readString();
    }
}
