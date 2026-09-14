package com.oplus.melody.common.util;

import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.common.util.r, reason: from Kotlin metadata */
/* JADX INFO: compiled from: FirmwareFileDO.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/common/util/FirmwareFileDO;", "Lcom/oplus/melody/common/data/BaseBean;", "protocolVersion", "", "headerInfo", "Lcom/oplus/melody/common/util/FirmwareFileDO$HeaderDO;", "sectionList", "", "Lcom/oplus/melody/common/util/FirmwareFileDO$SectionDO;", "<init>", "(ILcom/oplus/melody/common/util/FirmwareFileDO$HeaderDO;Ljava/util/List;)V", "getProtocolVersion", "()I", "setProtocolVersion", "(I)V", "getHeaderInfo", "()Lcom/oplus/melody/common/util/FirmwareFileDO$HeaderDO;", "setHeaderInfo", "(Lcom/oplus/melody/common/util/FirmwareFileDO$HeaderDO;)V", "getSectionList", "()Ljava/util/List;", "setSectionList", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "HeaderDO", "SectionDO", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FirmwareFileDO extends com.oplus.melody.common.data.a {
    private a headerInfo;
    private int protocolVersion;
    private List<b> sectionList;

    /* JADX INFO: renamed from: com.oplus.melody.common.util.r$a */
    /* JADX INFO: compiled from: FirmwareFileDO.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J]\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012¨\u0006."}, d2 = {"Lcom/oplus/melody/common/util/FirmwareFileDO$HeaderDO;", "Lcom/oplus/melody/common/data/BaseBean;", "hashId", "", "pkgHash", "", "pkgLen", "pkgType", "productId", "manufacturer", "hardVersion", "", "sectionCount", "<init>", "(I[BIIIILjava/lang/String;I)V", "getHashId", "()I", "setHashId", "(I)V", "getPkgHash", "()[B", "setPkgHash", "([B)V", "getPkgLen", "setPkgLen", "getPkgType", "setPkgType", "getProductId", "setProductId", "getManufacturer", "setManufacturer", "getHardVersion", "()Ljava/lang/String;", "setHardVersion", "(Ljava/lang/String;)V", "getSectionCount", "setSectionCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class a extends com.oplus.melody.common.data.a {
        private String hardVersion;
        private int hashId;
        private int manufacturer;
        private byte[] pkgHash;
        private int pkgLen;
        private int pkgType;
        private int productId;
        private int sectionCount;

        public a() {
            this(0, null, 0, 0, 0, 0, null, 0, 255, null);
        }

        public static /* synthetic */ a copy$default(a aVar, int i10, byte[] bArr, int i11, int i12, int i13, int i14, String str, int i15, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i10 = aVar.hashId;
            }
            if ((i16 & 2) != 0) {
                bArr = aVar.pkgHash;
            }
            if ((i16 & 4) != 0) {
                i11 = aVar.pkgLen;
            }
            if ((i16 & 8) != 0) {
                i12 = aVar.pkgType;
            }
            if ((i16 & 16) != 0) {
                i13 = aVar.productId;
            }
            if ((i16 & 32) != 0) {
                i14 = aVar.manufacturer;
            }
            if ((i16 & 64) != 0) {
                str = aVar.hardVersion;
            }
            if ((i16 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
                i15 = aVar.sectionCount;
            }
            String str2 = str;
            int i17 = i15;
            int i18 = i13;
            int i19 = i14;
            return aVar.copy(i10, bArr, i11, i12, i18, i19, str2, i17);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getHashId() {
            return this.hashId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getPkgHash() {
            return this.pkgHash;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPkgLen() {
            return this.pkgLen;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getPkgType() {
            return this.pkgType;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getProductId() {
            return this.productId;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getManufacturer() {
            return this.manufacturer;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getHardVersion() {
            return this.hardVersion;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getSectionCount() {
            return this.sectionCount;
        }

        public final a copy(int i10, byte[] bArr, int i11, int i12, int i13, int i14, String str, int i15) {
            return new a(i10, bArr, i11, i12, i13, i14, str, i15);
        }

        public final String getHardVersion() {
            return this.hardVersion;
        }

        public final int getHashId() {
            return this.hashId;
        }

        public final int getManufacturer() {
            return this.manufacturer;
        }

        public final byte[] getPkgHash() {
            return this.pkgHash;
        }

        public final int getPkgLen() {
            return this.pkgLen;
        }

        public final int getPkgType() {
            return this.pkgType;
        }

        public final int getProductId() {
            return this.productId;
        }

        public final int getSectionCount() {
            return this.sectionCount;
        }

        public final void setHardVersion(String str) {
            this.hardVersion = str;
        }

        public final void setHashId(int i10) {
            this.hashId = i10;
        }

        public final void setManufacturer(int i10) {
            this.manufacturer = i10;
        }

        public final void setPkgHash(byte[] bArr) {
            this.pkgHash = bArr;
        }

        public final void setPkgLen(int i10) {
            this.pkgLen = i10;
        }

        public final void setPkgType(int i10) {
            this.pkgType = i10;
        }

        public final void setProductId(int i10) {
            this.productId = i10;
        }

        public final void setSectionCount(int i10) {
            this.sectionCount = i10;
        }

        public a(int i10, byte[] bArr, int i11, int i12, int i13, int i14, String str, int i15) {
            this.hashId = i10;
            this.pkgHash = bArr;
            this.pkgLen = i11;
            this.pkgType = i12;
            this.productId = i13;
            this.manufacturer = i14;
            this.hardVersion = str;
            this.sectionCount = i15;
        }

        public /* synthetic */ a(int i10, byte[] bArr, int i11, int i12, int i13, int i14, String str, int i15, int i16, kotlin.jvm.internal.d dVar) {
            this((i16 & 1) != 0 ? 0 : i10, (i16 & 2) != 0 ? null : bArr, (i16 & 4) != 0 ? 0 : i11, (i16 & 8) != 0 ? 0 : i12, (i16 & 16) != 0 ? 0 : i13, (i16 & 32) != 0 ? 0 : i14, (i16 & 64) != 0 ? null : str, (i16 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 0 : i15);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.common.util.r$b */
    /* JADX INFO: compiled from: FirmwareFileDO.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#¨\u00062"}, d2 = {"Lcom/oplus/melody/common/util/FirmwareFileDO$SectionDO;", "Lcom/oplus/melody/common/data/BaseBean;", "id", "", "name", "", "softVersion", "buildTime", "sizeCompress", "sizeRaw", "hash", "", "offset", "hashCompress", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II[BI[B)V", "getId", "()I", "setId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSoftVersion", "setSoftVersion", "getBuildTime", "setBuildTime", "getSizeCompress", "setSizeCompress", "getSizeRaw", "setSizeRaw", "getHash", "()[B", "setHash", "([B)V", "getOffset", "setOffset", "getHashCompress", "setHashCompress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class b extends com.oplus.melody.common.data.a {
        private String buildTime;
        private byte[] hash;
        private byte[] hashCompress;
        private int id;
        private String name;
        private int offset;
        private int sizeCompress;
        private int sizeRaw;
        private String softVersion;

        public b() {
            this(0, null, null, null, 0, 0, null, 0, null, 511, null);
        }

        public static /* synthetic */ b copy$default(b bVar, int i10, String str, String str2, String str3, int i11, int i12, byte[] bArr, int i13, byte[] bArr2, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                i10 = bVar.id;
            }
            if ((i14 & 2) != 0) {
                str = bVar.name;
            }
            if ((i14 & 4) != 0) {
                str2 = bVar.softVersion;
            }
            if ((i14 & 8) != 0) {
                str3 = bVar.buildTime;
            }
            if ((i14 & 16) != 0) {
                i11 = bVar.sizeCompress;
            }
            if ((i14 & 32) != 0) {
                i12 = bVar.sizeRaw;
            }
            if ((i14 & 64) != 0) {
                bArr = bVar.hash;
            }
            if ((i14 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
                i13 = bVar.offset;
            }
            if ((i14 & 256) != 0) {
                bArr2 = bVar.hashCompress;
            }
            int i15 = i13;
            byte[] bArr3 = bArr2;
            int i16 = i12;
            byte[] bArr4 = bArr;
            int i17 = i11;
            String str4 = str2;
            return bVar.copy(i10, str, str4, str3, i17, i16, bArr4, i15, bArr3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getSoftVersion() {
            return this.softVersion;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBuildTime() {
            return this.buildTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getSizeCompress() {
            return this.sizeCompress;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getSizeRaw() {
            return this.sizeRaw;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final byte[] getHash() {
            return this.hash;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final byte[] getHashCompress() {
            return this.hashCompress;
        }

        public final b copy(int i10, String str, String str2, String str3, int i11, int i12, byte[] bArr, int i13, byte[] bArr2) {
            return new b(i10, str, str2, str3, i11, i12, bArr, i13, bArr2);
        }

        public final String getBuildTime() {
            return this.buildTime;
        }

        public final byte[] getHash() {
            return this.hash;
        }

        public final byte[] getHashCompress() {
            return this.hashCompress;
        }

        public final int getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final int getSizeCompress() {
            return this.sizeCompress;
        }

        public final int getSizeRaw() {
            return this.sizeRaw;
        }

        public final String getSoftVersion() {
            return this.softVersion;
        }

        public final void setBuildTime(String str) {
            this.buildTime = str;
        }

        public final void setHash(byte[] bArr) {
            this.hash = bArr;
        }

        public final void setHashCompress(byte[] bArr) {
            this.hashCompress = bArr;
        }

        public final void setId(int i10) {
            this.id = i10;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final void setOffset(int i10) {
            this.offset = i10;
        }

        public final void setSizeCompress(int i10) {
            this.sizeCompress = i10;
        }

        public final void setSizeRaw(int i10) {
            this.sizeRaw = i10;
        }

        public final void setSoftVersion(String str) {
            this.softVersion = str;
        }

        public b(int i10, String str, String str2, String str3, int i11, int i12, byte[] bArr, int i13, byte[] bArr2) {
            this.id = i10;
            this.name = str;
            this.softVersion = str2;
            this.buildTime = str3;
            this.sizeCompress = i11;
            this.sizeRaw = i12;
            this.hash = bArr;
            this.offset = i13;
            this.hashCompress = bArr2;
        }

        public /* synthetic */ b(int i10, String str, String str2, String str3, int i11, int i12, byte[] bArr, int i13, byte[] bArr2, int i14, kotlin.jvm.internal.d dVar) {
            this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? null : str, (i14 & 4) != 0 ? null : str2, (i14 & 8) != 0 ? null : str3, (i14 & 16) != 0 ? 0 : i11, (i14 & 32) != 0 ? 0 : i12, (i14 & 64) != 0 ? null : bArr, (i14 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 0 : i13, (i14 & 256) != 0 ? null : bArr2);
        }
    }

    public FirmwareFileDO() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FirmwareFileDO copy$default(FirmwareFileDO firmwareFileDO, int i10, a aVar, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = firmwareFileDO.protocolVersion;
        }
        if ((i11 & 2) != 0) {
            aVar = firmwareFileDO.headerInfo;
        }
        if ((i11 & 4) != 0) {
            list = firmwareFileDO.sectionList;
        }
        return firmwareFileDO.copy(i10, aVar, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final a getHeaderInfo() {
        return this.headerInfo;
    }

    public final List<b> component3() {
        return this.sectionList;
    }

    public final FirmwareFileDO copy(int i10, a aVar, List<b> list) {
        return new FirmwareFileDO(i10, aVar, list);
    }

    public final a getHeaderInfo() {
        return this.headerInfo;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final List<b> getSectionList() {
        return this.sectionList;
    }

    public final void setHeaderInfo(a aVar) {
        this.headerInfo = aVar;
    }

    public final void setProtocolVersion(int i10) {
        this.protocolVersion = i10;
    }

    public final void setSectionList(List<b> list) {
        this.sectionList = list;
    }

    public FirmwareFileDO(int i10, a aVar, List<b> list) {
        this.protocolVersion = i10;
        this.headerInfo = aVar;
        this.sectionList = list;
    }

    public /* synthetic */ FirmwareFileDO(int i10, a aVar, List list, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : aVar, (i11 & 4) != 0 ? null : list);
    }
}
