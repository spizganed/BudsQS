package com.oplus.melody.model.repository.triangle;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MelodyCapsuleShowType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/oplus/melody/model/repository/triangle/MelodyCapsuleShowType;", "", "<init>", "(Ljava/lang/String;I)V", "PANEL", "CAPSULE", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyCapsuleShowType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MelodyCapsuleShowType f20136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ MelodyCapsuleShowType[] f20137b;

    /* JADX INFO: Fake field, exist only in values array */
    MelodyCapsuleShowType EF0;

    static {
        MelodyCapsuleShowType melodyCapsuleShowType = new MelodyCapsuleShowType("PANEL", 0);
        MelodyCapsuleShowType melodyCapsuleShowType2 = new MelodyCapsuleShowType("CAPSULE", 1);
        f20136a = melodyCapsuleShowType2;
        f20137b = new MelodyCapsuleShowType[]{melodyCapsuleShowType, melodyCapsuleShowType2};
    }

    public MelodyCapsuleShowType() {
        throw null;
    }

    public static MelodyCapsuleShowType valueOf(String str) {
        return (MelodyCapsuleShowType) Enum.valueOf(MelodyCapsuleShowType.class, str);
    }

    public static MelodyCapsuleShowType[] values() {
        return (MelodyCapsuleShowType[]) f20137b.clone();
    }
}
