package com.oplus.melody.alive.provider;

import D7.C0391z;
import D7.o0;
import E6.b;
import F6.a;
import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import kotlin.Metadata;

/* JADX INFO: compiled from: MelodyAliveRepositoryProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JM\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0002¨\u0006\u0015"}, d2 = {"Lcom/oplus/melody/alive/provider/MelodyAliveRepositoryProvider;", "Lcom/oplus/melody/alive/provider/MelodyAliveBaseProvider;", "<init>", "()V", "onCreate", "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getRemoteDeviceByAddress", "Landroid/bluetooth/BluetoothDevice;", "address", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyAliveRepositoryProvider extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18806a = 0;

    public static BluetoothDevice a(String str) {
        C0391z.f1171d.getClass();
        return C0391z.i(str);
    }

    @Override // F6.a, android.content.ContentProvider
    public final boolean onCreate() {
        super.onCreate();
        b.f1355a.getClass();
        o0.c.f1145c.execute(new E6.a("MelodyAliveRepositoryProvider", SystemClock.elapsedRealtime()));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:418:0x08b5  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x09a2  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0a0a  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.database.Cursor query(android.net.Uri r11, java.lang.String[] r12, java.lang.String r13, java.lang.String[] r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 3365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.alive.provider.MelodyAliveRepositoryProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }
}
