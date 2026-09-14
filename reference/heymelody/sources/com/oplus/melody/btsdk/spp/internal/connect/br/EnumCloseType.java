package com.oplus.melody.btsdk.spp.internal.connect.br;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class EnumCloseType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumCloseType f19399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumCloseType f19400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumCloseType f19401c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ EnumCloseType[] f19402p;

    static {
        EnumCloseType enumCloseType = new EnumCloseType("UNKNOWN", 0);
        f19399a = enumCloseType;
        EnumCloseType enumCloseType2 = new EnumCloseType("ACTIVE", 1);
        f19400b = enumCloseType2;
        EnumCloseType enumCloseType3 = new EnumCloseType("INACTIVE", 2);
        f19401c = enumCloseType3;
        f19402p = new EnumCloseType[]{enumCloseType, enumCloseType2, enumCloseType3};
    }

    public EnumCloseType() {
        throw null;
    }

    public static EnumCloseType valueOf(String str) {
        return (EnumCloseType) Enum.valueOf(EnumCloseType.class, str);
    }

    public static EnumCloseType[] values() {
        return (EnumCloseType[]) f19402p.clone();
    }
}
