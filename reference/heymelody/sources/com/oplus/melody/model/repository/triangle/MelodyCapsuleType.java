package com.oplus.melody.model.repository.triangle;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MelodyCapsuleType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/oplus/melody/model/repository/triangle/MelodyCapsuleType;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECT", "LOW_BATTERY", "CONNECTED", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyCapsuleType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MelodyCapsuleType f20138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ MelodyCapsuleType[] f20139b;

    /* JADX INFO: Fake field, exist only in values array */
    MelodyCapsuleType EF0;

    static {
        MelodyCapsuleType melodyCapsuleType = new MelodyCapsuleType("CONNECT", 0);
        MelodyCapsuleType melodyCapsuleType2 = new MelodyCapsuleType("LOW_BATTERY", 1);
        MelodyCapsuleType melodyCapsuleType3 = new MelodyCapsuleType("CONNECTED", 2);
        f20138a = melodyCapsuleType3;
        f20139b = new MelodyCapsuleType[]{melodyCapsuleType, melodyCapsuleType2, melodyCapsuleType3};
    }

    public MelodyCapsuleType() {
        throw null;
    }

    public static MelodyCapsuleType valueOf(String str) {
        return (MelodyCapsuleType) Enum.valueOf(MelodyCapsuleType.class, str);
    }

    public static MelodyCapsuleType[] values() {
        return (MelodyCapsuleType[]) f20139b.clone();
    }
}
