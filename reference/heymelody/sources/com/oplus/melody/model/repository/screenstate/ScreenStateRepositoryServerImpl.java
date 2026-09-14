package com.oplus.melody.model.repository.screenstate;

import D6.f;
import D7.C0379m;
import D7.E;
import D7.h0;
import D7.o0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import android.os.SystemClock;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.media3.session.N0;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.screenstate.ScreenStateRepositoryServerImpl;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import o.InterfaceC1361a;
import o8.AbstractC1382a;

/* JADX INFO: compiled from: ScreenStateRepositoryServerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScreenStateRepositoryServerImpl extends AbstractC1382a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f20085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ScreenState f20086q = ScreenState.f20088a;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final u<ScreenState> f20087r = new u<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ScreenStateRepositoryServerImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/oplus/melody/model/repository/screenstate/ScreenStateRepositoryServerImpl$ScreenState;", "", "<init>", "(Ljava/lang/String;I)V", "UNSET", "SCREEN_OFF", "SCREEN_ON", "USER_PRESENT", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ScreenState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScreenState f20088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ScreenState f20089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final ScreenState f20090c;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final ScreenState f20091p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ ScreenState[] f20092q;

        static {
            ScreenState screenState = new ScreenState("UNSET", 0);
            f20088a = screenState;
            ScreenState screenState2 = new ScreenState("SCREEN_OFF", 1);
            f20089b = screenState2;
            ScreenState screenState3 = new ScreenState("SCREEN_ON", 2);
            f20090c = screenState3;
            ScreenState screenState4 = new ScreenState("USER_PRESENT", 3);
            f20091p = screenState4;
            f20092q = new ScreenState[]{screenState, screenState2, screenState3, screenState4};
        }

        public ScreenState() {
            throw null;
        }

        public static ScreenState valueOf(String str) {
            return (ScreenState) Enum.valueOf(ScreenState.class, str);
        }

        public static ScreenState[] values() {
            return (ScreenState[]) f20092q.clone();
        }
    }

    /* JADX INFO: compiled from: ScreenStateRepositoryServerImpl.kt */
    public static final class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null) {
                return;
            }
            A.c("ScreenStateRepository", new f(action, 22));
            int iHashCode = action.hashCode();
            ScreenStateRepositoryServerImpl screenStateRepositoryServerImpl = ScreenStateRepositoryServerImpl.this;
            if (iHashCode == -2128145023) {
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    screenStateRepositoryServerImpl.e(ScreenState.f20089b);
                }
            } else if (iHashCode == -1454123155) {
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    screenStateRepositoryServerImpl.e(ScreenState.f20090c);
                }
            } else if (iHashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                screenStateRepositoryServerImpl.e(ScreenState.f20091p);
            }
        }
    }

    public ScreenStateRepositoryServerImpl() {
        a aVar = new a();
        o0.c.f1145c.execute(new N0(this, 20));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            C0905k.e(heyMelodyApplication, aVar, intentFilter);
        } else {
            h.i("context");
            throw null;
        }
    }

    @Override // o8.AbstractC1382a
    public final s<Boolean> a() {
        return C0379m.b(C0379m.g(this.f20087r, new InterfaceC1361a() { // from class: com.oplus.melody.model.repository.screenstate.c
            @Override // o.InterfaceC1361a, com.google.common.base.b
            public final Object apply(Object obj) {
                ScreenStateRepositoryServerImpl.ScreenState screenState = (ScreenStateRepositoryServerImpl.ScreenState) obj;
                h.b(screenState);
                this.f20096a.getClass();
                return Boolean.valueOf(screenState != ScreenStateRepositoryServerImpl.ScreenState.f20091p);
            }
        }));
    }

    @Override // o8.AbstractC1382a
    public final s<Boolean> b() {
        return C0379m.b(C0379m.g(this.f20087r, new InterfaceC1361a() { // from class: com.oplus.melody.model.repository.screenstate.a
            @Override // o.InterfaceC1361a, com.google.common.base.b
            public final Object apply(Object obj) {
                ScreenStateRepositoryServerImpl.ScreenState screenState = (ScreenStateRepositoryServerImpl.ScreenState) obj;
                h.b(screenState);
                this.f20094a.getClass();
                return Boolean.valueOf(screenState != ScreenStateRepositoryServerImpl.ScreenState.f20089b);
            }
        }));
    }

    @Override // o8.AbstractC1382a
    public final boolean c() {
        f();
        return this.f20086q != ScreenState.f20091p;
    }

    @Override // o8.AbstractC1382a
    public final boolean d() {
        f();
        return this.f20086q != ScreenState.f20089b;
    }

    public final void e(final ScreenState screenState) {
        if (this.f20086q == screenState) {
            return;
        }
        this.f20086q = screenState;
        this.f20085p = SystemClock.elapsedRealtime();
        C0379m.k(this.f20087r, screenState);
        A.c("ScreenStateRepository", new Supplier() { // from class: com.oplus.melody.model.repository.screenstate.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return "handleScreenStateChange " + screenState;
            }
        });
    }

    public final void f() {
        if (this.f20085p <= 0 || SystemClock.elapsedRealtime() - this.f20085p > TimeUnit.SECONDS.toMillis(1L)) {
            if (!super.d()) {
                e(ScreenState.f20089b);
            } else if (super.c()) {
                e(ScreenState.f20090c);
            } else {
                e(ScreenState.f20091p);
            }
        }
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message msg) {
        h.e(msg, "msg");
        int i10 = msg.what;
        if (i10 == 28002) {
            E e10 = h0.f1099c;
            h0.j(msg, b(), null);
            return true;
        }
        if (i10 != 28003) {
            return false;
        }
        E e11 = h0.f1099c;
        h0.j(msg, a(), null);
        return true;
    }
}
