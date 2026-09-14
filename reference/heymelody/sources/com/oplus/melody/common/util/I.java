package com.oplus.melody.common.util;

import D7.q0;
import android.media.MediaPlayer;
import com.oplus.melody.common.util.J;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class I implements MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f19441b;

    public /* synthetic */ I(q0 q0Var, int i10) {
        this.f19440a = i10;
        switch (i10) {
            case 1:
                this.f19441b = q0Var;
                break;
            default:
                J j5 = J.a.f19444a;
                this.f19441b = q0Var;
                break;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        q0 q0Var = this.f19441b;
        switch (this.f19440a) {
            case 0:
                J j5 = J.a.f19444a;
                j5.f19443b = 1;
                MediaPlayer mediaPlayer2 = j5.f19442a;
                if (mediaPlayer2 != null) {
                    j5.f19443b = 2;
                    J.d(mediaPlayer2);
                    q0Var.complete(Boolean.TRUE);
                }
                break;
            default:
                float[] fArr = la.L.f25669Q0;
                q0Var.complete(Integer.valueOf(mediaPlayer.getAudioSessionId()));
                break;
        }
    }
}
