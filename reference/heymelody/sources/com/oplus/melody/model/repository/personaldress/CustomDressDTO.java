package com.oplus.melody.model.repository.personaldress;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: CustomDressDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "productId", "", "colorId", "customDressData", "", "Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO$CustomDressData;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getColorId", "setColorId", "getCustomDressData", "()Ljava/util/List;", "setCustomDressData", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CustomDressData", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CustomDressDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<CustomDressDTO> CREATOR = new a();
    private String colorId;
    private List<CustomDressData> customDressData;
    private String productId;

    /* JADX INFO: compiled from: CustomDressDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001dJT\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u000bJ\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO$CustomDressData;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "themeId", "", "name", "bgType", "iconPath", ClientDataEntity.COL_PRIORITY, "", "blurProgress", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)V", "getThemeId", "()Ljava/lang/String;", "setThemeId", "(Ljava/lang/String;)V", "getName", "setName", "getBgType", "setBgType", "getIconPath", "setIconPath", "getPriority", "()J", "setPriority", "(J)V", "getBlurProgress", "()Ljava/lang/Integer;", "setBlurProgress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Integer;)Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO$CustomDressData;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class CustomDressData extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<CustomDressData> CREATOR = new a();
        private String bgType;
        private Integer blurProgress;
        private String iconPath;
        private String name;
        private long priority;
        private String themeId;

        /* JADX INFO: compiled from: CustomDressDTO.kt */
        public static final class a implements Parcelable.Creator<CustomDressData> {
            @Override // android.os.Parcelable.Creator
            public final CustomDressData createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new CustomDressData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            public final CustomDressData[] newArray(int i10) {
                return new CustomDressData[i10];
            }
        }

        public CustomDressData() {
            this(null, null, null, null, 0L, null, 63, null);
        }

        public static /* synthetic */ CustomDressData copy$default(CustomDressData customDressData, String str, String str2, String str3, String str4, long j5, Integer num, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = customDressData.themeId;
            }
            if ((i10 & 2) != 0) {
                str2 = customDressData.name;
            }
            if ((i10 & 4) != 0) {
                str3 = customDressData.bgType;
            }
            if ((i10 & 8) != 0) {
                str4 = customDressData.iconPath;
            }
            if ((i10 & 16) != 0) {
                j5 = customDressData.priority;
            }
            if ((i10 & 32) != 0) {
                num = customDressData.blurProgress;
            }
            Integer num2 = num;
            long j9 = j5;
            return customDressData.copy(str, str2, str3, str4, j9, num2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getThemeId() {
            return this.themeId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBgType() {
            return this.bgType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getIconPath() {
            return this.iconPath;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getPriority() {
            return this.priority;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getBlurProgress() {
            return this.blurProgress;
        }

        public final CustomDressData copy(String themeId, String name, String bgType, String iconPath, long priority, Integer blurProgress) {
            return new CustomDressData(themeId, name, bgType, iconPath, priority, blurProgress);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getBgType() {
            return this.bgType;
        }

        public final Integer getBlurProgress() {
            return this.blurProgress;
        }

        public final String getIconPath() {
            return this.iconPath;
        }

        public final String getName() {
            return this.name;
        }

        public final long getPriority() {
            return this.priority;
        }

        public final String getThemeId() {
            return this.themeId;
        }

        public final void setBgType(String str) {
            this.bgType = str;
        }

        public final void setBlurProgress(Integer num) {
            this.blurProgress = num;
        }

        public final void setIconPath(String str) {
            this.iconPath = str;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final void setPriority(long j5) {
            this.priority = j5;
        }

        public final void setThemeId(String str) {
            this.themeId = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.themeId);
            dest.writeString(this.name);
            dest.writeString(this.bgType);
            dest.writeString(this.iconPath);
            dest.writeLong(this.priority);
            Integer num = this.blurProgress;
            if (num == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(num.intValue());
            }
        }

        public CustomDressData(String str, String str2, String str3, String str4, long j5, Integer num) {
            this.themeId = str;
            this.name = str2;
            this.bgType = str3;
            this.iconPath = str4;
            this.priority = j5;
            this.blurProgress = num;
        }

        public /* synthetic */ CustomDressData(String str, String str2, String str3, String str4, long j5, Integer num, int i10, kotlin.jvm.internal.d dVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? Long.MAX_VALUE : j5, (i10 & 32) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: CustomDressDTO.kt */
    public static final class a implements Parcelable.Creator<CustomDressDTO> {
        @Override // android.os.Parcelable.Creator
        public final CustomDressDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i10 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i10);
                int iB = 0;
                while (iB != i10) {
                    iB = A6.b.b(CustomDressData.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new CustomDressDTO(string, string2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomDressDTO[] newArray(int i10) {
            return new CustomDressDTO[i10];
        }
    }

    public CustomDressDTO() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomDressDTO copy$default(CustomDressDTO customDressDTO, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = customDressDTO.productId;
        }
        if ((i10 & 2) != 0) {
            str2 = customDressDTO.colorId;
        }
        if ((i10 & 4) != 0) {
            list = customDressDTO.customDressData;
        }
        return customDressDTO.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getColorId() {
        return this.colorId;
    }

    public final List<CustomDressData> component3() {
        return this.customDressData;
    }

    public final CustomDressDTO copy(String productId, String colorId, List<CustomDressData> customDressData) {
        return new CustomDressDTO(productId, colorId, customDressData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getColorId() {
        return this.colorId;
    }

    public final List<CustomDressData> getCustomDressData() {
        return this.customDressData;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setColorId(String str) {
        this.colorId = str;
    }

    public final void setCustomDressData(List<CustomDressData> list) {
        this.customDressData = list;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.productId);
        dest.writeString(this.colorId);
        List<CustomDressData> list = this.customDressData;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = A6.e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((CustomDressData) itG.next()).writeToParcel(dest, flags);
        }
    }

    public CustomDressDTO(String str, String str2, List<CustomDressData> list) {
        this.productId = str;
        this.colorId = str2;
        this.customDressData = list;
    }

    public /* synthetic */ CustomDressDTO(String str, String str2, List list, int i10, kotlin.jvm.internal.d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : list);
    }
}
