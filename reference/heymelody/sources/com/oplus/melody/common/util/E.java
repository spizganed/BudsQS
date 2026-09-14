package com.oplus.melody.common.util;

import android.media.MediaPlayer;
import android.net.Uri;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;

/* JADX INFO: compiled from: MelodyBasePlayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f19434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaPlayer f19435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19436c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f19437d = new LinkedList();

    /* JADX INFO: compiled from: MelodyBasePlayer.java */
    public interface a {
        void a(int i10, int i11);
    }

    public E(Uri uri) {
        this.f19434a = uri;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f19435b = mediaPlayer;
        mediaPlayer.setOnErrorListener(new D(this, 0));
    }

    public final boolean a() {
        if (this.f19436c != 3) {
            A.x("MelodyVideoPlayer", "pause IGNORE state=" + this.f19436c);
            return false;
        }
        try {
            this.f19435b.pause();
            d(4);
            return true;
        } catch (Exception e10) {
            A.i("MelodyVideoPlayer", "pause", e10);
            return false;
        }
    }

    public final boolean b() {
        if (this.f19436c == 0) {
            try {
                A.c("MelodyVideoPlayer", new S7.c((L) this, 25));
                this.f19435b.setDataSource(C0906l.f19501a, this.f19434a);
                d(1);
            } catch (Exception e10) {
                A.i("MelodyVideoPlayer", "setDataSource", e10);
            }
        }
        int i10 = this.f19436c;
        if (i10 != 1 && i10 != 5) {
            A.x("MelodyVideoPlayer", "prepare IGNORE state=" + this.f19436c);
            return false;
        }
        try {
            this.f19435b.prepare();
            d(2);
            return true;
        } catch (Exception e11) {
            A.i("MelodyVideoPlayer", "prepare", e11);
            return false;
        }
    }

    public final void c() {
        d(6);
        ForkJoinPool.commonPool().execute(new X3.w((L) this, 17));
    }

    public final void d(int i10) {
        int i11 = this.f19436c;
        if (i10 >= 0) {
            this.f19436c = i10;
        }
        if (i11 != i10) {
            A.c("MelodyVideoPlayer", new Q7.l(this, i11, i10));
            Iterator it = this.f19437d.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(i11, i10);
            }
        }
    }

    public final boolean e() {
        int i10 = this.f19436c;
        if (i10 != 2 && i10 != 4) {
            A.x("MelodyVideoPlayer", "start IGNORE state=" + this.f19436c);
            return false;
        }
        try {
            this.f19435b.start();
            d(3);
            return true;
        } catch (Exception e10) {
            A.i("MelodyVideoPlayer", "start", e10);
            return false;
        }
    }

    public final void f() {
        int i10 = this.f19436c;
        if (i10 != 3 && i10 != 4) {
            A.x("MelodyVideoPlayer", "stop IGNORE state=" + this.f19436c);
        } else {
            try {
                this.f19435b.stop();
                d(5);
            } catch (Exception e10) {
                A.i("MelodyVideoPlayer", "stop", e10);
            }
        }
    }
}
