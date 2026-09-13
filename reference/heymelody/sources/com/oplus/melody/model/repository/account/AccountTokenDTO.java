package com.oplus.melody.model.repository.account;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: AccountTokenDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/model/repository/account/AccountTokenDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "token", "", "deviceId", "accountType", "timeMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getToken", "()Ljava/lang/String;", "getDeviceId", "getAccountType", "getTimeMillis", "()J", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AccountTokenDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<AccountTokenDTO> CREATOR = new a();
    private final String accountType;
    private final String deviceId;
    private final long timeMillis;
    private final String token;

    /* JADX INFO: compiled from: AccountTokenDTO.kt */
    public static final class a implements Parcelable.Creator<AccountTokenDTO> {
        @Override // android.os.Parcelable.Creator
        public final AccountTokenDTO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new AccountTokenDTO(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final AccountTokenDTO[] newArray(int i10) {
            return new AccountTokenDTO[i10];
        }
    }

    public AccountTokenDTO(String str, String str2, String str3, long j5) {
        this.token = str;
        this.deviceId = str2;
        this.accountType = str3;
        this.timeMillis = j5;
    }

    public static /* synthetic */ AccountTokenDTO copy$default(AccountTokenDTO accountTokenDTO, String str, String str2, String str3, long j5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = accountTokenDTO.token;
        }
        if ((i10 & 2) != 0) {
            str2 = accountTokenDTO.deviceId;
        }
        if ((i10 & 4) != 0) {
            str3 = accountTokenDTO.accountType;
        }
        if ((i10 & 8) != 0) {
            j5 = accountTokenDTO.timeMillis;
        }
        String str4 = str3;
        return accountTokenDTO.copy(str, str2, str4, j5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAccountType() {
        return this.accountType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimeMillis() {
        return this.timeMillis;
    }

    public final AccountTokenDTO copy(String token, String deviceId, String accountType, long timeMillis) {
        return new AccountTokenDTO(token, deviceId, accountType, timeMillis);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getTimeMillis() {
        return this.timeMillis;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.token);
        dest.writeString(this.deviceId);
        dest.writeString(this.accountType);
        dest.writeLong(this.timeMillis);
    }

    public /* synthetic */ AccountTokenDTO(String str, String str2, String str3, long j5, int i10, d dVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? SystemClock.elapsedRealtime() : j5);
    }
}
