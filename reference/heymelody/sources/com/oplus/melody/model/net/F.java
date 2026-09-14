package com.oplus.melody.model.net;

import com.oplus.melody.common.helper.MelodyException;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.io.IOException;

/* JADX INFO: compiled from: SmartHomeIotCallHelperServerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class F implements uc.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E f19818a;

    public F(E e10) {
        this.f19818a = e10;
    }

    @Override // uc.e
    public final void onFailure(uc.d dVar, IOException iOException) {
        this.f19818a.f19811t.completeExceptionally(MelodyException.e(0, iOException.toString()));
    }

    @Override // uc.e
    public final void onResponse(uc.d dVar, uc.r rVar) throws IOException {
        ZonedDateTime zonedDateTime;
        try {
            zonedDateTime = ZonedDateTime.parse(uc.r.b("date", rVar), DateTimeFormatter.RFC_1123_DATE_TIME);
        } catch (Throwable th) {
            com.oplus.melody.common.util.A.i("SmartHomeIotCallHelper", "requestServerTimeInside", th);
            zonedDateTime = null;
        }
        E e10 = this.f19818a;
        if (zonedDateTime != null) {
            e10.f19811t.complete(Long.valueOf(zonedDateTime.toInstant().toEpochMilli()));
        } else {
            e10.f19811t.completeExceptionally(MelodyException.e(404, "requestServerTime date is null"));
        }
    }
}
