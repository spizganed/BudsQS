package com.oplus.melody.common.helper;

import android.database.SQLException;

/* JADX INFO: loaded from: classes.dex */
public final class MelodyException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19407a = 0;
    private final int code;

    public MelodyException(int i10, String str, SQLException sQLException) {
        super(str, sQLException);
        if (i10 == 0) {
            this.code = a(sQLException);
        } else {
            this.code = i10;
        }
    }

    public static int a(Throwable th) {
        while (th != null) {
            if (th instanceof MelodyException) {
                return ((MelodyException) th).code;
            }
            th = th.getCause();
        }
        return 0;
    }

    public static String d(Throwable th) {
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            String localizedMessage = cause.getLocalizedMessage();
            if (localizedMessage != null) {
                return localizedMessage;
            }
        }
        return "Unknown " + th;
    }

    public static MelodyException e(int i10, String str) {
        return new MelodyException(i10, str, null);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        Throwable cause = getCause();
        if (cause instanceof MelodyException) {
            return cause.toString();
        }
        String strD = d(this);
        if (strD.startsWith("MelodyException")) {
            return strD;
        }
        StringBuilder sb2 = new StringBuilder("MelodyException{message: \"");
        sb2.append(strD);
        sb2.append('\"');
        if (cause != null) {
            sb2.append(", cause: \"");
            sb2.append(cause);
            sb2.append('\"');
        }
        if (this.code != 0) {
            sb2.append(", code: ");
            sb2.append(this.code);
        }
        sb2.append('}');
        return sb2.toString();
    }
}
