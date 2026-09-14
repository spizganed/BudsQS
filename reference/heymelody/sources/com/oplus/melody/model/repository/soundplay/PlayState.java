package com.oplus.melody.model.repository.soundplay;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: PlayState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/oplus/melody/model/repository/soundplay/PlayState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "BUFFERING", "PLAYING", "PAUSE", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PlayState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PlayState f20119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PlayState f20120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PlayState f20121c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final PlayState f20122p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ PlayState[] f20123q;

    static {
        PlayState playState = new PlayState("IDLE", 0);
        f20119a = playState;
        PlayState playState2 = new PlayState("BUFFERING", 1);
        f20120b = playState2;
        PlayState playState3 = new PlayState("PLAYING", 2);
        f20121c = playState3;
        PlayState playState4 = new PlayState("PAUSE", 3);
        f20122p = playState4;
        f20123q = new PlayState[]{playState, playState2, playState3, playState4};
    }

    public PlayState() {
        throw null;
    }

    public static PlayState valueOf(String str) {
        return (PlayState) Enum.valueOf(PlayState.class, str);
    }

    public static PlayState[] values() {
        return (PlayState[]) f20123q.clone();
    }
}
