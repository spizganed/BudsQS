package com.oplus.melody.common.util;

import D7.o0;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: compiled from: MelodyAudioManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AudioFocusRequest f19424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f19425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Ea.S f19426d = new Ea.S(this, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f19423a = (AudioManager) C0906l.f19501a.getSystemService("audio");

    /* JADX INFO: compiled from: MelodyAudioManager.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final B f19427a = new B();
    }

    public final boolean a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, String str) {
        int iAbandonAudioFocus;
        AudioManager audioManager = this.f19423a;
        if (audioManager == null || this.f19425c != onAudioFocusChangeListener) {
            iAbandonAudioFocus = 0;
        } else {
            this.f19425c = null;
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequest = this.f19424b;
                this.f19424b = null;
                iAbandonAudioFocus = audioFocusRequest != null ? audioManager.abandonAudioFocusRequest(audioFocusRequest) : 0;
            } else {
                iAbandonAudioFocus = audioManager.abandonAudioFocus(this.f19426d);
            }
            onAudioFocusChangeListener.onAudioFocusChange(0);
        }
        if (iAbandonAudioFocus == 1) {
            A.c("MelodyAudioManager", new D6.c(str, 15));
            return true;
        }
        A.x("MelodyAudioManager", "abandonAudioFocus FAILURE from ".concat(str));
        return false;
    }

    public final boolean b(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, String str) {
        int iRequestAudioFocus;
        AudioManager audioManager = this.f19423a;
        if (audioManager != null) {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener2 = this.f19425c;
            if (onAudioFocusChangeListener2 != null && onAudioFocusChangeListener2 != onAudioFocusChangeListener) {
                a(onAudioFocusChangeListener2, "MelodyAudioManager");
            }
            this.f19425c = onAudioFocusChangeListener;
            int i10 = Build.VERSION.SDK_INT;
            Ea.S s4 = this.f19426d;
            if (i10 >= 26) {
                if (this.f19424b == null) {
                    this.f19424b = Q7.d.f().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setOnAudioFocusChangeListener(s4, o0.c.f1145c.a()).build();
                }
                iRequestAudioFocus = audioManager.requestAudioFocus(this.f19424b);
            } else {
                iRequestAudioFocus = audioManager.requestAudioFocus(s4, 3, 1);
            }
        } else {
            iRequestAudioFocus = 0;
        }
        if (iRequestAudioFocus == 1) {
            A.c("MelodyAudioManager", new C8.a(str, 26));
            return true;
        }
        A.x("MelodyAudioManager", "requestAudioFocus FAILURE from ".concat(str));
        return false;
    }
}
