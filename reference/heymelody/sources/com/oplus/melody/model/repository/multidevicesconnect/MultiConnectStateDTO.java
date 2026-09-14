package com.oplus.melody.model.repository.multidevicesconnect;

import A6.b;
import A6.e;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: MultiConnectStateDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J8\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/oplus/melody/model/repository/multidevicesconnect/MultiConnectStateDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "createTime", "", "elements", "", "Lcom/oplus/melody/model/repository/multidevicesconnect/MultiConnectStateDTO$Element;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getElements", "()Ljava/util/List;", "setElements", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lcom/oplus/melody/model/repository/multidevicesconnect/MultiConnectStateDTO;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Element", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class MultiConnectStateDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<MultiConnectStateDTO> CREATOR = new a();
    private String address;
    private Long createTime;
    private List<Element> elements;

    /* JADX INFO: compiled from: MultiConnectStateDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003JS\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0006\u0010(\u001a\u00020\u0007J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001c\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018¨\u0006."}, d2 = {"Lcom/oplus/melody/model/repository/multidevicesconnect/MultiConnectStateDTO$Element;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "address", "", "deviceName", "connectionState", "", "isCurrentDevice", "", "isMainAudioDevice", "isAudioActive", "deviceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;IZZZI)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getDeviceName", "setDeviceName", "getConnectionState", "()I", "setConnectionState", "(I)V", "()Z", "setCurrentDevice", "(Z)V", "setMainAudioDevice", "setAudioActive", "getDeviceType", "setDeviceType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Element extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Element> CREATOR = new a();
        private String address;
        private int connectionState;
        private String deviceName;
        private int deviceType;
        private boolean isAudioActive;
        private boolean isCurrentDevice;
        private boolean isMainAudioDevice;

        /* JADX INFO: compiled from: MultiConnectStateDTO.kt */
        public static final class a implements Parcelable.Creator<Element> {
            @Override // android.os.Parcelable.Creator
            public final Element createFromParcel(Parcel parcel) {
                boolean z2;
                boolean z4;
                h.e(parcel, "parcel");
                String string = parcel.readString();
                String string2 = parcel.readString();
                int i10 = parcel.readInt();
                boolean z10 = false;
                boolean z11 = true;
                if (parcel.readInt() != 0) {
                    z2 = false;
                    z10 = true;
                } else {
                    z2 = false;
                }
                if (parcel.readInt() != 0) {
                    z4 = true;
                } else {
                    z4 = true;
                    z11 = z2;
                }
                if (parcel.readInt() == 0) {
                    z4 = z2;
                }
                return new Element(string, string2, i10, z10, z11, z4, parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final Element[] newArray(int i10) {
                return new Element[i10];
            }
        }

        public Element(String str, String str2, int i10, boolean z2, boolean z4, boolean z10, int i11) {
            this.address = str;
            this.deviceName = str2;
            this.connectionState = i10;
            this.isCurrentDevice = z2;
            this.isMainAudioDevice = z4;
            this.isAudioActive = z10;
            this.deviceType = i11;
        }

        public static /* synthetic */ Element copy$default(Element element, String str, String str2, int i10, boolean z2, boolean z4, boolean z10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = element.address;
            }
            if ((i12 & 2) != 0) {
                str2 = element.deviceName;
            }
            if ((i12 & 4) != 0) {
                i10 = element.connectionState;
            }
            if ((i12 & 8) != 0) {
                z2 = element.isCurrentDevice;
            }
            if ((i12 & 16) != 0) {
                z4 = element.isMainAudioDevice;
            }
            if ((i12 & 32) != 0) {
                z10 = element.isAudioActive;
            }
            if ((i12 & 64) != 0) {
                i11 = element.deviceType;
            }
            boolean z11 = z10;
            int i13 = i11;
            boolean z12 = z4;
            int i14 = i10;
            return element.copy(str, str2, i14, z2, z12, z11, i13);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getDeviceName() {
            return this.deviceName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getConnectionState() {
            return this.connectionState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsCurrentDevice() {
            return this.isCurrentDevice;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsMainAudioDevice() {
            return this.isMainAudioDevice;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsAudioActive() {
            return this.isAudioActive;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getDeviceType() {
            return this.deviceType;
        }

        public final Element copy(String address, String deviceName, int connectionState, boolean isCurrentDevice, boolean isMainAudioDevice, boolean isAudioActive, int deviceType) {
            return new Element(address, deviceName, connectionState, isCurrentDevice, isMainAudioDevice, isAudioActive, deviceType);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getAddress() {
            return this.address;
        }

        public final int getConnectionState() {
            return this.connectionState;
        }

        public final String getDeviceName() {
            return this.deviceName;
        }

        public final int getDeviceType() {
            return this.deviceType;
        }

        public final boolean isAudioActive() {
            return this.isAudioActive;
        }

        public final boolean isCurrentDevice() {
            return this.isCurrentDevice;
        }

        public final boolean isMainAudioDevice() {
            return this.isMainAudioDevice;
        }

        public final void setAddress(String str) {
            this.address = str;
        }

        public final void setAudioActive(boolean z2) {
            this.isAudioActive = z2;
        }

        public final void setConnectionState(int i10) {
            this.connectionState = i10;
        }

        public final void setCurrentDevice(boolean z2) {
            this.isCurrentDevice = z2;
        }

        public final void setDeviceName(String str) {
            this.deviceName = str;
        }

        public final void setDeviceType(int i10) {
            this.deviceType = i10;
        }

        public final void setMainAudioDevice(boolean z2) {
            this.isMainAudioDevice = z2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.address);
            dest.writeString(this.deviceName);
            dest.writeInt(this.connectionState);
            dest.writeInt(this.isCurrentDevice ? 1 : 0);
            dest.writeInt(this.isMainAudioDevice ? 1 : 0);
            dest.writeInt(this.isAudioActive ? 1 : 0);
            dest.writeInt(this.deviceType);
        }
    }

    /* JADX INFO: compiled from: MultiConnectStateDTO.kt */
    public static final class a implements Parcelable.Creator<MultiConnectStateDTO> {
        @Override // android.os.Parcelable.Creator
        public final MultiConnectStateDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            String string = parcel.readString();
            ArrayList arrayList = null;
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() != 0) {
                int i10 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i10);
                int iB = 0;
                while (iB != i10) {
                    iB = b.b(Element.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new MultiConnectStateDTO(string, lValueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final MultiConnectStateDTO[] newArray(int i10) {
            return new MultiConnectStateDTO[i10];
        }
    }

    public MultiConnectStateDTO(String str, Long l4, List<Element> list) {
        this.address = str;
        this.createTime = l4;
        this.elements = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiConnectStateDTO copy$default(MultiConnectStateDTO multiConnectStateDTO, String str, Long l4, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = multiConnectStateDTO.address;
        }
        if ((i10 & 2) != 0) {
            l4 = multiConnectStateDTO.createTime;
        }
        if ((i10 & 4) != 0) {
            list = multiConnectStateDTO.elements;
        }
        return multiConnectStateDTO.copy(str, l4, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getCreateTime() {
        return this.createTime;
    }

    public final List<Element> component3() {
        return this.elements;
    }

    public final MultiConnectStateDTO copy(String address, Long createTime, List<Element> elements) {
        return new MultiConnectStateDTO(address, createTime, elements);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final List<Element> getElements() {
        return this.elements;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setCreateTime(Long l4) {
        this.createTime = l4;
    }

    public final void setElements(List<Element> list) {
        this.elements = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.address);
        Long l4 = this.createTime;
        if (l4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l4.longValue());
        }
        List<Element> list = this.elements;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((Element) itG.next()).writeToParcel(dest, flags);
        }
    }

    public /* synthetic */ MultiConnectStateDTO(String str, Long l4, List list, int i10, d dVar) {
        this(str, (i10 & 2) != 0 ? Long.valueOf(SystemClock.elapsedRealtime()) : l4, list);
    }
}
