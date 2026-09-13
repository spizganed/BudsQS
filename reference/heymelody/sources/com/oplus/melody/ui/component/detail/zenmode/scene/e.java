package com.oplus.melody.ui.component.detail.zenmode.scene;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;

/* JADX INFO: compiled from: ZenModePlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaPlayer f21446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21448d;

    /* JADX INFO: compiled from: ZenModePlayer.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SuppressLint({"StaticFieldLeak"})
        public static final e f21449a;

        static {
            e eVar = new e();
            eVar.f21447c = 0;
            eVar.f21448d = false;
            f21449a = eVar;
        }
    }

    public final void a() {
        MediaPlayer mediaPlayer;
        if (this.f21448d && (mediaPlayer = this.f21446b) != null) {
            int i10 = this.f21447c;
            if (i10 == 2 || i10 == 3) {
                this.f21447c = 0;
                mediaPlayer.stop();
                this.f21446b.reset();
                this.f21446b.release();
                this.f21446b = null;
            }
        }
    }
}
