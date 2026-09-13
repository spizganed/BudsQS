package com.oplus.melody.common.util;

import android.app.PendingIntent;

/* JADX INFO: compiled from: NotificationUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Wb.a<String> f19446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f19447b;

    public M(Wb.a aVar, PendingIntent pendingIntent) {
        this.f19446a = aVar;
        this.f19447b = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof M)) {
            return false;
        }
        M m9 = (M) obj;
        m9.getClass();
        return this.f19446a.equals(m9.f19446a) && this.f19447b.equals(m9.f19447b);
    }

    public final int hashCode() {
        return this.f19447b.hashCode() + ((this.f19446a.hashCode() + (Integer.hashCode(0) * 31)) * 31);
    }

    public final String toString() {
        return "NotificationButton(icon=0, title=" + this.f19446a + ", intent=" + this.f19447b + ")";
    }
}
