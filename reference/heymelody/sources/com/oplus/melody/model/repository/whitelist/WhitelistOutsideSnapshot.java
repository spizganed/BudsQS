package com.oplus.melody.model.repository.whitelist;

import A6.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: WhitelistOutsideSnapshot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0018B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/model/repository/whitelist/WhitelistOutsideSnapshot;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "version", "", "whitelist", "", "Lcom/oplus/melody/model/repository/whitelist/WhitelistOutsideSnapshot$Item;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "getWhitelist", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Item", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WhitelistOutsideSnapshot extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<WhitelistOutsideSnapshot> CREATOR = new a();
    private final String version;
    private final List<Item> whitelist;

    /* JADX INFO: compiled from: WhitelistOutsideSnapshot.kt */
    public static final class a implements Parcelable.Creator<WhitelistOutsideSnapshot> {
        @Override // android.os.Parcelable.Creator
        public final WhitelistOutsideSnapshot createFromParcel(Parcel parcel) {
            h.e(parcel, "parcel");
            String string = parcel.readString();
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            int iB = 0;
            while (iB != i10) {
                iB = b.b(Item.CREATOR, parcel, arrayList, iB, 1);
            }
            return new WhitelistOutsideSnapshot(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final WhitelistOutsideSnapshot[] newArray(int i10) {
            return new WhitelistOutsideSnapshot[i10];
        }
    }

    public WhitelistOutsideSnapshot(String version, List<Item> whitelist) {
        h.e(version, "version");
        h.e(whitelist, "whitelist");
        this.version = version;
        this.whitelist = whitelist;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistOutsideSnapshot copy$default(WhitelistOutsideSnapshot whitelistOutsideSnapshot, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = whitelistOutsideSnapshot.version;
        }
        if ((i10 & 2) != 0) {
            list = whitelistOutsideSnapshot.whitelist;
        }
        return whitelistOutsideSnapshot.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<Item> component2() {
        return this.whitelist;
    }

    public final WhitelistOutsideSnapshot copy(String version, List<Item> whitelist) {
        h.e(version, "version");
        h.e(whitelist, "whitelist");
        return new WhitelistOutsideSnapshot(version, whitelist);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getVersion() {
        return this.version;
    }

    public final List<Item> getWhitelist() {
        return this.whitelist;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.version);
        List<Item> list = this.whitelist;
        dest.writeInt(list.size());
        Iterator<Item> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }

    /* JADX INFO: compiled from: WhitelistOutsideSnapshot.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/model/repository/whitelist/WhitelistOutsideSnapshot$Item;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "pid", "", "name", "wear", "", SpeechFindManager.TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getPid", "()Ljava/lang/String;", "getName", "getWear", "()I", "getType", "component1", "component2", "component3", "component4", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Item extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Item> CREATOR = new a();
        private final String name;
        private final String pid;
        private final String type;
        private final int wear;

        /* JADX INFO: compiled from: WhitelistOutsideSnapshot.kt */
        public static final class a implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            public final Item createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Item(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Item[] newArray(int i10) {
                return new Item[i10];
            }
        }

        public Item(String pid, String name, int i10, String type) {
            h.e(pid, "pid");
            h.e(name, "name");
            h.e(type, "type");
            this.pid = pid;
            this.name = name;
            this.wear = i10;
            this.type = type;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, int i10, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = item.pid;
            }
            if ((i11 & 2) != 0) {
                str2 = item.name;
            }
            if ((i11 & 4) != 0) {
                i10 = item.wear;
            }
            if ((i11 & 8) != 0) {
                str3 = item.type;
            }
            return item.copy(str, str2, i10, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPid() {
            return this.pid;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getWear() {
            return this.wear;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public final Item copy(String pid, String name, int wear, String type) {
            h.e(pid, "pid");
            h.e(name, "name");
            h.e(type, "type");
            return new Item(pid, name, wear, type);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPid() {
            return this.pid;
        }

        public final String getType() {
            return this.type;
        }

        public final int getWear() {
            return this.wear;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.pid);
            dest.writeString(this.name);
            dest.writeInt(this.wear);
            dest.writeString(this.type);
        }

        public /* synthetic */ Item(String str, String str2, int i10, String str3, int i11, d dVar) {
            this(str, str2, i10, (i11 & 8) != 0 ? "" : str3);
        }
    }
}
