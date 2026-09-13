package com.oplus.melody.ui.component.tutorialguide;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FunctionType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/FunctionType;", "", "funType", "", "<init>", "(Ljava/lang/String;II)V", "getFunType", "()I", "SPATIAL_AUDIO", "EQUALIZER", "NOISE_REALTIME", "AI_CLEAR_CALL", "MULTI_CONNECT", "VOICE_ASSIST", "AI_TRANSLATION", "AI_SUMMARY", "SMART_BLUETOOTH", "SPY_TAP", "ADAPTIVE_HEARING", "VOICE_COMMAND", "GAME_LOW_LATENCY", "SPEECH_PERCEPTION", "DROP_DETECTION", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FunctionType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ FunctionType[] f21662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ Pb.a f21663c;
    private final int funType;

    /* JADX INFO: compiled from: FunctionType.kt */
    public static final class a {
    }

    static {
        FunctionType[] functionTypeArr = {new FunctionType("SPATIAL_AUDIO", 0, 1), new FunctionType("EQUALIZER", 1, 2), new FunctionType("NOISE_REALTIME", 2, 3), new FunctionType("AI_CLEAR_CALL", 3, 4), new FunctionType("MULTI_CONNECT", 4, 5), new FunctionType("VOICE_ASSIST", 5, 6), new FunctionType("AI_TRANSLATION", 6, 7), new FunctionType("AI_SUMMARY", 7, 8), new FunctionType("SMART_BLUETOOTH", 8, 9), new FunctionType("SPY_TAP", 9, 10), new FunctionType("ADAPTIVE_HEARING", 10, 11), new FunctionType("VOICE_COMMAND", 11, 12), new FunctionType("GAME_LOW_LATENCY", 12, 13), new FunctionType("SPEECH_PERCEPTION", 13, 14), new FunctionType("DROP_DETECTION", 14, 15)};
        f21662b = functionTypeArr;
        f21663c = kotlin.enums.a.a(functionTypeArr);
        f21661a = new a();
    }

    public FunctionType(String str, int i10, int i11) {
        this.funType = i11;
    }

    public static FunctionType valueOf(String str) {
        return (FunctionType) Enum.valueOf(FunctionType.class, str);
    }

    public static FunctionType[] values() {
        return (FunctionType[]) f21662b.clone();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getFunType() {
        return this.funType;
    }
}
