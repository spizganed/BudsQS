package com.oplus.melody.model.repository.soundplay;

import Y.AbstractC0500d;
import Y.y;
import android.os.Bundle;
import androidx.media3.session.C0683w0;
import androidx.media3.session.z1;
import com.oplus.melody.btsdk.protocol.commands.k;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0910p;
import com.oplus.melody.model.repository.soundplay.ListenLimitedTime;
import kotlin.LazyThreadSafetyMode;
import q8.e;
import t8.q;

/* JADX INFO: compiled from: MelodySoundCountDownTimer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f20129g = kotlin.a.b(LazyThreadSafetyMode.f25345a, new A7.a(17));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0683w0 f20130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0683w0.f f20131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f20132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f20135f;

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.soundplay.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MelodySoundCountDownTimer.kt */
    public static final class C0232a {
        /* JADX WARN: Type inference failed for: r0v0, types: [Jb.b, java.lang.Object] */
        public static a a() {
            return (a) a.f20129g.getValue();
        }
    }

    public a() {
        this.f20133d = -1;
        int i10 = q.c("melody-model-settings").getInt("sound_settings_countdown_time", -1);
        this.f20133d = i10;
        ListenLimitedTime.f20099a.getClass();
        this.f20135f = ListenLimitedTime.a.a(i10).a();
    }

    public final void a(String str, long j5) {
        C0683w0.f fVar = this.f20131b;
        if (fVar != null) {
            Bundle bundle = new Bundle();
            bundle.putLong(str, j5);
            C0683w0 c0683w0 = this.f20130a;
            if (c0683w0 != null) {
                c0683w0.b(fVar, new z1(str, Bundle.EMPTY), bundle);
            }
        }
    }

    public final void b(int i10) {
        if (i10 < ListenLimitedTime.f20100b.getValueInMinute()) {
            A.c("MelodySoundCountDownTimer", new com.oplus.melody.btsdk.protocol.commands.q(i10, 18));
            return;
        }
        ListenLimitedTime.f20099a.getClass();
        this.f20135f = ListenLimitedTime.a.a(i10).a();
        this.f20133d = i10;
        a("timer_value_change", i10);
        q.c("melody-model-settings").edit().putInt("sound_settings_countdown_time", i10).apply();
        A.c("MelodySoundCountDownTimer", new k(i10, 26));
    }

    public final void c() {
        if (this.f20135f < 0) {
            this.f20134e = 2;
            a("timer_state_change", 2);
        } else {
            if (this.f20134e == 1) {
                A.b("MelodySoundCountDownTimer", "CountDownTimer is already running");
                return;
            }
            this.f20134e = 1;
            a("timer_state_change", 1);
            long j5 = this.f20135f;
            A.c("MelodySoundCountDownTimer", new C0910p(3, j5));
            e eVar = new e(j5, this);
            this.f20132c = eVar;
            eVar.start();
        }
    }

    public final void d() {
        y yVarA;
        C0683w0 c0683w0;
        y yVarA2;
        A.h("MelodySoundCountDownTimer", "stopTimer");
        e eVar = this.f20132c;
        if (eVar != null) {
            eVar.cancel();
        }
        this.f20132c = null;
        this.f20134e = 0;
        a("timer_state_change", 0);
        C0683w0 c0683w02 = this.f20130a;
        if (c0683w02 == null || (yVarA = c0683w02.a()) == null || !((AbstractC0500d) yVarA).N() || this.f20135f != 0 || (c0683w0 = this.f20130a) == null || (yVarA2 = c0683w0.a()) == null) {
            return;
        }
        ((AbstractC0500d) yVarA2).O();
    }
}
