package com.oplus.melody.model.db;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.db.v, reason: from Kotlin metadata */
/* JADX INFO: compiled from: LocationDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lcom/oplus/melody/model/db/LocationDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "latitude", "", "longitude", "address", "", "countryName", "province", "city", "timestamp", "", "<init>", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getLatitude", "()D", "getLongitude", "getAddress", "()Ljava/lang/String;", "getCountryName", "getProvince", "getCity", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class LocationDTO extends com.oplus.melody.common.data.a {
    private final String address;
    private final String city;
    private final String countryName;
    private final double latitude;
    private final double longitude;
    private final String province;
    private final long timestamp;

    public LocationDTO(double d10, double d11, String str, String str2, String str3, String str4, long j5) {
        this.latitude = d10;
        this.longitude = d11;
        this.address = str;
        this.countryName = str2;
        this.province = str3;
        this.city = str4;
        this.timestamp = j5;
    }

    public static /* synthetic */ LocationDTO copy$default(LocationDTO locationDTO, double d10, double d11, String str, String str2, String str3, String str4, long j5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = locationDTO.latitude;
        }
        double d12 = d10;
        if ((i10 & 2) != 0) {
            d11 = locationDTO.longitude;
        }
        return locationDTO.copy(d12, d11, (i10 & 4) != 0 ? locationDTO.address : str, (i10 & 8) != 0 ? locationDTO.countryName : str2, (i10 & 16) != 0 ? locationDTO.province : str3, (i10 & 32) != 0 ? locationDTO.city : str4, (i10 & 64) != 0 ? locationDTO.timestamp : j5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCountryName() {
        return this.countryName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getProvince() {
        return this.province;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final LocationDTO copy(double d10, double d11, String str, String str2, String str3, String str4, long j5) {
        return new LocationDTO(d10, d11, str, str2, str3, str4, j5);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountryName() {
        return this.countryName;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getProvince() {
        return this.province;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
