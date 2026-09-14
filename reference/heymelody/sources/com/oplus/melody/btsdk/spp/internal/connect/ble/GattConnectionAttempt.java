package com.oplus.melody.btsdk.spp.internal.connect.ble;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class GattConnectionAttempt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GattConnectionAttempt f19389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GattConnectionAttempt f19390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final GattConnectionAttempt f19391c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final GattConnectionAttempt f19392p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final GattConnectionAttempt f19393q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final GattConnectionAttempt f19394r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final GattConnectionAttempt f19395s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final GattConnectionAttempt f19396t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final GattConnectionAttempt f19397u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ GattConnectionAttempt[] f19398v;

    static {
        GattConnectionAttempt gattConnectionAttempt = new GattConnectionAttempt("IDLE", 0);
        f19389a = gattConnectionAttempt;
        GattConnectionAttempt gattConnectionAttempt2 = new GattConnectionAttempt("WAITING_TO_START_CONNECTING", 1);
        f19390b = gattConnectionAttempt2;
        GattConnectionAttempt gattConnectionAttempt3 = new GattConnectionAttempt("CONNECTING_ACTIVE", 2);
        f19391c = gattConnectionAttempt3;
        GattConnectionAttempt gattConnectionAttempt4 = new GattConnectionAttempt("CONNECTING_ACTIVE_FAILED", 3);
        GattConnectionAttempt gattConnectionAttempt5 = new GattConnectionAttempt("CONNECTING_ACTIVE_SUCCESS", 4);
        f19392p = gattConnectionAttempt5;
        GattConnectionAttempt gattConnectionAttempt6 = new GattConnectionAttempt("CONNECTING_ACTIVE_TIMED_OUT", 5);
        f19393q = gattConnectionAttempt6;
        GattConnectionAttempt gattConnectionAttempt7 = new GattConnectionAttempt("CONNECTING_ACTIVE_TIMED_OUT_FORCED", 6);
        f19394r = gattConnectionAttempt7;
        GattConnectionAttempt gattConnectionAttempt8 = new GattConnectionAttempt("CONNECTING_PASSIVE", 7);
        f19395s = gattConnectionAttempt8;
        GattConnectionAttempt gattConnectionAttempt9 = new GattConnectionAttempt("CONNECTING_PASSIVE_SUCCESS", 8);
        f19396t = gattConnectionAttempt9;
        GattConnectionAttempt gattConnectionAttempt10 = new GattConnectionAttempt("CONNECTING_PASSIVE_FAILED", 9);
        GattConnectionAttempt gattConnectionAttempt11 = new GattConnectionAttempt("CONNECTING_PASSIVE_TIMED_OUT", 10);
        f19397u = gattConnectionAttempt11;
        f19398v = new GattConnectionAttempt[]{gattConnectionAttempt, gattConnectionAttempt2, gattConnectionAttempt3, gattConnectionAttempt4, gattConnectionAttempt5, gattConnectionAttempt6, gattConnectionAttempt7, gattConnectionAttempt8, gattConnectionAttempt9, gattConnectionAttempt10, gattConnectionAttempt11};
    }

    public GattConnectionAttempt() {
        throw null;
    }

    public static GattConnectionAttempt valueOf(String str) {
        return (GattConnectionAttempt) Enum.valueOf(GattConnectionAttempt.class, str);
    }

    public static GattConnectionAttempt[] values() {
        return (GattConnectionAttempt[]) f19398v.clone();
    }
}
