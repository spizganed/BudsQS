package com.oplus.melody.ui.component.detail.sound.main;

import kotlin.Metadata;

/* JADX INFO: compiled from: SoundItemState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/oplus/melody/ui/component/detail/sound/main/SoundItemState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "NONE", "UN_DOWNLOAD", "DOWNLOADING", "PLAYING", "PAUSED", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum SoundItemState {
    NONE(0),
    UN_DOWNLOAD(1),
    DOWNLOADING(2),
    PLAYING(3),
    PAUSED(4);

    private final int state;

    SoundItemState(int i10) {
        this.state = i10;
    }
}
