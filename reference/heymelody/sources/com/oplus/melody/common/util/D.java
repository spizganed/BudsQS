package com.oplus.melody.common.util;

import android.media.MediaPlayer;
import java.io.File;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class D implements MediaPlayer.OnErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19433b;

    public /* synthetic */ D(Object obj, int i10) {
        this.f19432a = i10;
        this.f19433b = obj;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        switch (this.f19432a) {
            case 0:
                E e10 = (E) this.f19433b;
                e10.getClass();
                A.h("MelodyVideoPlayer", "onError what=" + i10 + " extra=" + i11);
                e10.d(-1);
                break;
            default:
                StringBuilder sbM = androidx.appcompat.widget.a.m(i10, i11, "setOnErrorListener, what: ", ", extra: ", ", file: ");
                sbM.append(((File) this.f19433b).getAbsolutePath());
                A.x("MelodyMediaPlayer", sbM.toString());
                break;
        }
        return false;
    }
}
