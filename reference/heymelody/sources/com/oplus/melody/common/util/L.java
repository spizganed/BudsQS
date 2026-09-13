package com.oplus.melody.common.util;

import android.media.AudioAttributes;
import android.net.Uri;

/* JADX INFO: compiled from: MelodyVideoPlayer.java */
/* JADX INFO: loaded from: classes.dex */
public final class L extends E {
    public L(Uri uri, AudioAttributes audioAttributes) {
        super(uri);
        if (audioAttributes == null) {
            this.f19435b.setAudioStreamType(-100);
        } else {
            this.f19435b.setAudioAttributes(audioAttributes);
        }
        this.f19435b.setScreenOnWhilePlaying(true);
    }
}
