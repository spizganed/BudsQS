package com.oplus.melody.common.util;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: MelodyMediaPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public final class J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f19442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19443b;

    /* JADX INFO: compiled from: MelodyMediaPlayer.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final J f19444a;

        static {
            J j5 = new J();
            j5.f19443b = 0;
            f19444a = j5;
        }
    }

    public static void d(MediaPlayer mediaPlayer) {
        try {
            mediaPlayer.start();
        } catch (Exception e10) {
            A.i("MelodyMediaPlayer", "startMediaPlayer", e10);
        }
    }

    public final void a() {
        MediaPlayer mediaPlayer = this.f19442a;
        if (mediaPlayer != null) {
            this.f19443b = 0;
            try {
                mediaPlayer.stop();
            } catch (Exception e10) {
                A.i("MelodyMediaPlayer", "stopMediaPlayer", e10);
            }
            try {
                this.f19442a.release();
            } catch (Exception e11) {
                A.i("MelodyMediaPlayer", "releaseMediaPlayer", e11);
            }
            this.f19442a = null;
        }
    }

    public final void b(File file, boolean z2) {
        boolean zIsPlaying;
        e();
        this.f19442a = new MediaPlayer();
        if (z2) {
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    this.f19442a.setAudioAttributes(new AudioAttributes.Builder().setIsContentSpatialized(true).setSpatializationBehavior(0).build());
                }
            } catch (Exception e10) {
                A.i("MelodyMediaPlayer", "createPlayer", e10);
                return;
            }
        }
        this.f19442a.setDataSource(file.getAbsolutePath());
        this.f19442a.prepareAsync();
        this.f19442a.setLooping(true);
        try {
            zIsPlaying = this.f19442a.isPlaying();
        } catch (Exception e11) {
            A.i("MelodyMediaPlayer", "createPlayer playing error: ", e11);
            zIsPlaying = false;
        }
        if (zIsPlaying) {
            try {
                this.f19442a.stop();
            } catch (Exception e12) {
                A.i("MelodyMediaPlayer", "stopMediaPlayer", e12);
            }
        }
        this.f19442a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.melody.common.util.G
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                J j5 = this.f19438a;
                j5.f19443b = 1;
                MediaPlayer mediaPlayer2 = j5.f19442a;
                if (mediaPlayer2 != null) {
                    j5.f19443b = 2;
                    J.d(mediaPlayer2);
                }
            }
        });
        this.f19442a.setOnErrorListener(new D(file, 1));
    }

    public final void c(String str, AudioAttributes audioAttributes, MediaPlayer.OnCompletionListener onCompletionListener) {
        if (TextUtils.isEmpty(str)) {
            A.h("MelodyMediaPlayer", "start failed , param is null");
            return;
        }
        if (this.f19443b == 2) {
            A.h("MelodyMediaPlayer", "now is playing");
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f19442a = mediaPlayer;
        if (audioAttributes != null) {
            try {
                mediaPlayer.setAudioAttributes(audioAttributes);
            } catch (Exception e10) {
                A.i("MelodyMediaPlayer", "createPlayer error: ", e10);
                return;
            }
        }
        this.f19442a.setDataSource(str);
        this.f19442a.prepareAsync();
        this.f19442a.setLooping(false);
        this.f19442a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.melody.common.util.H
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                J j5 = this.f19439a;
                j5.f19443b = 1;
                MediaPlayer mediaPlayer3 = j5.f19442a;
                if (mediaPlayer3 != null) {
                    j5.f19443b = 2;
                    J.d(mediaPlayer3);
                }
            }
        });
        this.f19442a.setOnCompletionListener(onCompletionListener);
    }

    public final void e() {
        if (this.f19442a != null) {
            int i10 = this.f19443b;
            if (i10 == 2 || i10 == 3) {
                a();
            }
        }
    }
}
