package com.oplus.melody.btsdk.protocol;

import A6.f;

/* JADX INFO: loaded from: classes.dex */
public class SDKException extends Exception {
    private final int mType = 3;
    private final int mCommand = -1;

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SDKException{mType = ");
        sb2.append(this.mType);
        sb2.append(", mCommand = ");
        return f.d(sb2, this.mCommand, '}');
    }
}
