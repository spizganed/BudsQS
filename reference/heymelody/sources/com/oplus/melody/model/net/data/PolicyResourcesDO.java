package com.oplus.melody.model.net.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: PolicyResourcesDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/model/net/data/PolicyResourcesDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "htmlUrl", "", "<init>", "(Ljava/lang/String;)V", "getHtmlUrl", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PolicyResourcesDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PolicyResourcesDO> CREATOR = new a();
    private final String htmlUrl;

    /* JADX INFO: compiled from: PolicyResourcesDO.kt */
    public static final class a implements Parcelable.Creator<PolicyResourcesDO> {
        @Override // android.os.Parcelable.Creator
        public final PolicyResourcesDO createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            return new PolicyResourcesDO(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PolicyResourcesDO[] newArray(int i10) {
            return new PolicyResourcesDO[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PolicyResourcesDO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PolicyResourcesDO copy$default(PolicyResourcesDO policyResourcesDO, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = policyResourcesDO.htmlUrl;
        }
        return policyResourcesDO.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHtmlUrl() {
        return this.htmlUrl;
    }

    public final PolicyResourcesDO copy(String htmlUrl) {
        return new PolicyResourcesDO(htmlUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getHtmlUrl() {
        return this.htmlUrl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.htmlUrl);
    }

    public PolicyResourcesDO(String str) {
        this.htmlUrl = str;
    }

    public /* synthetic */ PolicyResourcesDO(String str, int i10, d dVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}
