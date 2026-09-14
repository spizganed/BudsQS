package com.oplus.melody.ui.component.detail.zenmode.net;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
public final class ZenModeResourcesType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ZenModeResourcesType f21421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ZenModeResourcesType f21422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ZenModeResourcesType[] f21423c;

    static {
        ZenModeResourcesType zenModeResourcesType = new ZenModeResourcesType("AUDIO_MP3", 0);
        f21421a = zenModeResourcesType;
        ZenModeResourcesType zenModeResourcesType2 = new ZenModeResourcesType("AUDIO_BIN", 1);
        f21422b = zenModeResourcesType2;
        f21423c = new ZenModeResourcesType[]{zenModeResourcesType, zenModeResourcesType2};
    }

    public ZenModeResourcesType() {
        throw null;
    }

    public static ZenModeResourcesType valueOf(String str) {
        return (ZenModeResourcesType) Enum.valueOf(ZenModeResourcesType.class, str);
    }

    public static ZenModeResourcesType[] values() {
        return (ZenModeResourcesType[]) f21423c.clone();
    }
}
