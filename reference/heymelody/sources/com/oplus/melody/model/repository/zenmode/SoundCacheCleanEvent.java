package com.oplus.melody.model.repository.zenmode;

import android.os.Parcel;
import android.os.Parcelable;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: SoundCacheCleanEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u0003J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/model/repository/zenmode/SoundCacheCleanEvent;", "Landroid/os/Parcelable;", DcsCompatEventConverter.EVT_EVENT_ID, "", "cleanState", "<init>", "(II)V", "getEventId", "()I", "getCleanState", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SoundCacheCleanEvent implements Parcelable {
    public static final Parcelable.Creator<SoundCacheCleanEvent> CREATOR = new a();
    private final int cleanState;
    private final int eventId;

    /* JADX INFO: compiled from: SoundCacheCleanEvent.kt */
    public static final class a implements Parcelable.Creator<SoundCacheCleanEvent> {
        @Override // android.os.Parcelable.Creator
        public final SoundCacheCleanEvent createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.h.e(parcel, "parcel");
            return new SoundCacheCleanEvent(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final SoundCacheCleanEvent[] newArray(int i10) {
            return new SoundCacheCleanEvent[i10];
        }
    }

    public SoundCacheCleanEvent(int i10, int i11) {
        this.eventId = i10;
        this.cleanState = i11;
    }

    public static /* synthetic */ SoundCacheCleanEvent copy$default(SoundCacheCleanEvent soundCacheCleanEvent, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = soundCacheCleanEvent.eventId;
        }
        if ((i12 & 2) != 0) {
            i11 = soundCacheCleanEvent.cleanState;
        }
        return soundCacheCleanEvent.copy(i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEventId() {
        return this.eventId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCleanState() {
        return this.cleanState;
    }

    public final SoundCacheCleanEvent copy(int eventId, int cleanState) {
        return new SoundCacheCleanEvent(eventId, cleanState);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SoundCacheCleanEvent)) {
            return false;
        }
        SoundCacheCleanEvent soundCacheCleanEvent = (SoundCacheCleanEvent) other;
        return this.eventId == soundCacheCleanEvent.eventId && this.cleanState == soundCacheCleanEvent.cleanState;
    }

    public final int getCleanState() {
        return this.cleanState;
    }

    public final int getEventId() {
        return this.eventId;
    }

    public int hashCode() {
        return Integer.hashCode(this.cleanState) + (Integer.hashCode(this.eventId) * 31);
    }

    public String toString() {
        return "SoundCacheCleanEvent(eventId=" + this.eventId + ", cleanState=" + this.cleanState + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeInt(this.eventId);
        dest.writeInt(this.cleanState);
    }
}
