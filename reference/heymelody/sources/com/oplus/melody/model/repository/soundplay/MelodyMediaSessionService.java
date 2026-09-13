package com.oplus.melody.model.repository.soundplay;

import B.G;
import B.t;
import D7.K;
import D7.f0;
import Ea.C0401j;
import Ea.L;
import L8.C0478z;
import O9.d;
import Y.C0498b;
import Y.q;
import Y.y;
import Y.z;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import androidx.media3.datasource.b;
import androidx.media3.exoplayer.C;
import androidx.media3.exoplayer.C0621q;
import androidx.media3.session.A1;
import androidx.media3.session.C0;
import androidx.media3.session.C0633b;
import androidx.media3.session.C0681v0;
import androidx.media3.session.C0683w0;
import androidx.media3.session.D1;
import androidx.media3.session.H1;
import androidx.media3.session.I1;
import androidx.media3.session.U0;
import androidx.media3.session.z1;
import b0.InterfaceC0716d;
import bc.C0747d;
import com.google.common.base.f;
import com.google.common.primitives.ImmutableIntArray;
import com.google.common.util.concurrent.n;
import com.google.common.util.concurrent.p;
import com.google.common.util.concurrent.r;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.P;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.soundplay.a;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import la.C1294g;
import q8.C1445b;
import q8.c;
import q8.e;

/* JADX INFO: compiled from: MelodyMediaSessionService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u000245B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020!H\u0016J\u0012\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000fH\u0002J\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020!H\u0002J\u0012\u00101\u001a\u00020!2\b\b\u0002\u00102\u001a\u00020\u0012H\u0002J\b\u00103\u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/oplus/melody/model/repository/soundplay/MelodyMediaSessionService;", "Landroidx/media3/session/MediaSessionService;", "<init>", "()V", "player", "Landroidx/media3/common/Player;", "session", "Landroidx/media3/session/MediaSession;", "backgroundSoundController", "Lcom/oplus/melody/model/repository/soundplay/BackgroundSoundPlaybackController;", "timer", "Lcom/oplus/melody/model/repository/soundplay/MelodySoundCountDownTimer;", "playStartTime", "", "mPid", "", "mAddress", "isForegroundStarted", "", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "hasPlaybackAudioFocus", "playbackFocusGainType", "", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "audioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "onCreate", "", "onGetSession", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "createActivityIntent", "Landroid/app/PendingIntent;", "onTaskRemoved", "rootIntent", "Landroid/content/Intent;", "onDestroy", "startForegroundSafely", "title", "addCustomSessionCommand", "Landroidx/media3/session/SessionCommands;", "resolvePlaybackFocusGain", "requestPlaybackAudioFocus", "abandonPlaybackAudioFocus", "force", "refreshPlaybackAudioFocus", "Companion", "MediaSessionCallback", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyMediaSessionService extends U0 {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final /* synthetic */ int f20104I = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f20105A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f20106B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f20107C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public AudioFocusRequest f20108D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f20109E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f20110F = 1;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final Jb.b f20111G = kotlin.a.a(new d(this, 14));
    public final L H = new L(this, 3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public C f20112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public C0683w0 f20113w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public C1445b f20114x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.oplus.melody.model.repository.soundplay.a f20115y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f20116z;

    /* JADX INFO: compiled from: MelodyMediaSessionService.kt */
    public final class a implements C0683w0.c {
        public a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // androidx.media3.session.C0683w0.c
        public final p a(C0683w0 session, C0683w0.f controller, z1 z1Var, Bundle args) {
            com.oplus.melody.model.repository.soundplay.a aVar;
            com.oplus.melody.model.repository.soundplay.a aVar2;
            com.oplus.melody.model.repository.soundplay.a aVar3;
            h.e(session, "session");
            h.e(controller, "controller");
            h.e(args, "args");
            String customAction = z1Var.f11633b;
            h.d(customAction, "customAction");
            A.c("MelodyMediaSessionService", new Ca.b(customAction, 28));
            int iHashCode = customAction.hashCode();
            MelodyMediaSessionService melodyMediaSessionService = MelodyMediaSessionService.this;
            switch (iHashCode) {
                case -1522868952:
                    if (customAction.equals("start_timer") && (aVar = melodyMediaSessionService.f20115y) != null) {
                        aVar.c();
                    }
                    break;
                case -1125041433:
                    if (customAction.equals("set_background_sound_settings")) {
                        boolean z2 = args.getBoolean("background_sound_mode_item_key", false);
                        int i10 = args.getInt("background_sound_volume_item_key", 7);
                        C1445b c1445b = melodyMediaSessionService.f20114x;
                        if (c1445b == null) {
                            h.i("backgroundSoundController");
                            throw null;
                        }
                        boolean z4 = c1445b.f27178a;
                        c1445b.b(C0747d.Z(i10, 10), z2);
                        if (z4 != z2) {
                            C c6 = melodyMediaSessionService.f20112v;
                            if (c6 == null) {
                                h.i("player");
                                throw null;
                            }
                            if (c6.N()) {
                                melodyMediaSessionService.j(true);
                                C c10 = melodyMediaSessionService.f20112v;
                                if (c10 == null) {
                                    h.i("player");
                                    throw null;
                                }
                                if (c10.N()) {
                                    melodyMediaSessionService.l();
                                }
                                A.c("MelodyMediaSessionService", new c(melodyMediaSessionService, 0));
                            }
                        }
                    }
                    break;
                case -1005786936:
                    if (customAction.equals("stop_timer") && (aVar2 = melodyMediaSessionService.f20115y) != null) {
                        aVar2.d();
                    }
                    break;
                case 16115698:
                    if (customAction.equals("cancel_countdown_timer") && (aVar3 = melodyMediaSessionService.f20115y) != null) {
                        e eVar = aVar3.f20132c;
                        if (eVar != null) {
                            eVar.cancel();
                        }
                        aVar3.f20132c = null;
                    }
                    break;
                case 805012398:
                    if (customAction.equals("get_timer_state")) {
                        com.oplus.melody.model.repository.soundplay.a aVar4 = melodyMediaSessionService.f20115y;
                        int i11 = aVar4 != null ? aVar4.f20133d : 0;
                        int i12 = aVar4 != null ? aVar4.f20134e : 0;
                        long j5 = aVar4 != null ? aVar4.f20135f : 0L;
                        Bundle bundle = new Bundle();
                        bundle.putInt("timer_value_item_key", i11);
                        bundle.putInt("timer_state_item_key", i12);
                        bundle.putLong("timer_remaining_item_key", j5);
                        session.b(controller, new z1("get_timer_state_resp", Bundle.EMPTY), bundle);
                    }
                    break;
                case 1717980058:
                    if (customAction.equals("set_timer_value")) {
                        int i13 = args.getInt("set_timer_value");
                        com.oplus.melody.model.repository.soundplay.a aVar5 = melodyMediaSessionService.f20115y;
                        if (aVar5 != null) {
                            aVar5.b(i13);
                        }
                    }
                    break;
            }
            return n.C(new D1(0));
        }

        @Override // androidx.media3.session.C0683w0.c
        public final r<List<q>> b(C0683w0 mediaSession, C0683w0.f controller, List<q> mediaItems) {
            h.e(mediaSession, "mediaSession");
            h.e(controller, "controller");
            h.e(mediaItems, "mediaItems");
            A.c("MelodyMediaSessionService", new C0401j(4, mediaItems));
            return super.b(mediaSession, controller, mediaItems);
        }

        @Override // androidx.media3.session.C0683w0.c
        public final p c(C0683w0 session, C0683w0.f controller, String mediaId, z rating) {
            h.e(session, "session");
            h.e(controller, "controller");
            h.e(mediaId, "mediaId");
            h.e(rating, "rating");
            A.c("MelodyMediaSessionService", new C1294g(rating, 12));
            return super.c(session, controller, mediaId, rating);
        }

        @Override // androidx.media3.session.C0683w0.c
        public final void d(C0683w0 session, C0683w0.f fVar) {
            h.e(session, "session");
            A.b("MelodyMediaSessionService", "onPostConnect");
        }

        @Override // androidx.media3.session.C0683w0.c
        public final p e(C0683w0 session, C0683w0.f controller, z rating) {
            h.e(session, "session");
            h.e(controller, "controller");
            h.e(rating, "rating");
            A.c("MelodyMediaSessionService", new com.oplus.melody.ui.component.detail.zenmode.scene.a(rating, 24));
            return super.e(session, controller, rating);
        }

        @Override // androidx.media3.session.C0683w0.c
        public final void f(C0683w0 session, C0683w0.f controller) {
            h.e(session, "session");
            h.e(controller, "controller");
            Object obj = com.oplus.melody.model.repository.soundplay.a.f20129g;
            a.C0232a.a().f20131b = null;
            A.b("MelodyMediaSessionService", "onDisconnected");
        }

        @Override // androidx.media3.session.C0683w0.c
        public final C0683w0.d g(C0683w0 session, C0683w0.f controller) {
            h.e(session, "session");
            h.e(controller, "controller");
            A.b("MelodyMediaSessionService", "onConnect");
            Object obj = com.oplus.melody.model.repository.soundplay.a.f20129g;
            a.C0232a.a().f20130a = session;
            a.C0232a.a().f20131b = controller;
            HashSet hashSet = new HashSet();
            Bundle bundle = Bundle.EMPTY;
            hashSet.add(new z1("get_timer_state", bundle));
            hashSet.add(new z1("start_timer", bundle));
            hashSet.add(new z1("stop_timer", bundle));
            hashSet.add(new z1("cancel_countdown_timer", bundle));
            hashSet.add(new z1("set_timer_value", bundle));
            hashSet.add(new z1("set_background_sound_settings", bundle));
            return new C0683w0.d(new A1(hashSet), C0683w0.d.f11582f, null, null);
        }

        @Override // androidx.media3.session.C0683w0.c
        public final int h(C0683w0 session, C0683w0.f controller, int i10) {
            h.e(session, "session");
            h.e(controller, "controller");
            A.c("MelodyMediaSessionService", new com.oplus.melody.btsdk.protocol.commands.q(i10, 17));
            MelodyMediaSessionService melodyMediaSessionService = MelodyMediaSessionService.this;
            if (i10 != 7) {
                if (i10 != 9) {
                    return 0;
                }
                C c6 = melodyMediaSessionService.f20112v;
                if (c6 == null) {
                    h.i("player");
                    throw null;
                }
                if (c6.N()) {
                    return 0;
                }
                C c10 = melodyMediaSessionService.f20112v;
                if (c10 != null) {
                    c10.d();
                    return 0;
                }
                h.i("player");
                throw null;
            }
            C c11 = melodyMediaSessionService.f20112v;
            if (c11 == null) {
                h.i("player");
                throw null;
            }
            boolean zI = c11.I();
            A.c("MelodyMediaSessionService", new E9.r(16, zI));
            if (zI) {
                C c12 = melodyMediaSessionService.f20112v;
                if (c12 == null) {
                    h.i("player");
                    throw null;
                }
                c12.p();
            }
            C c13 = melodyMediaSessionService.f20112v;
            if (c13 == null) {
                h.i("player");
                throw null;
            }
            if (c13.N()) {
                return 1;
            }
            C c14 = melodyMediaSessionService.f20112v;
            if (c14 != null) {
                c14.d();
                return 1;
            }
            h.i("player");
            throw null;
        }
    }

    /* JADX INFO: compiled from: MelodyMediaSessionService.kt */
    public static final class b implements y.c {
        public b() {
        }

        @Override // Y.y.c
        public final void j(int i10, q qVar) {
            A.c("MelodyMediaSessionService", new f0(qVar, i10, 12));
            if (qVar != null) {
                t8.q.c("melody-model-settings").edit().putString("sound_settings_current_media_id", qVar.f6333a).apply();
            }
        }

        @Override // Y.y.c
        public final void x0(boolean z2) {
            com.oplus.melody.model.repository.soundplay.a aVar;
            com.oplus.melody.model.repository.soundplay.a aVar2;
            com.oplus.melody.model.repository.soundplay.a aVar3;
            A.c("MelodyMediaSessionService", new q8.d(1, z2));
            MelodyMediaSessionService melodyMediaSessionService = MelodyMediaSessionService.this;
            if (z2) {
                int i10 = MelodyMediaSessionService.f20104I;
                melodyMediaSessionService.l();
            } else {
                int i11 = MelodyMediaSessionService.f20104I;
                melodyMediaSessionService.j(false);
            }
            com.oplus.melody.model.repository.soundplay.a aVar4 = melodyMediaSessionService.f20115y;
            Integer numValueOf = aVar4 != null ? Integer.valueOf(aVar4.f20134e) : null;
            com.oplus.melody.model.repository.soundplay.a aVar5 = melodyMediaSessionService.f20115y;
            Long lValueOf = aVar5 != null ? Long.valueOf(aVar5.f20135f) : null;
            com.oplus.melody.model.repository.soundplay.a aVar6 = melodyMediaSessionService.f20115y;
            int i12 = aVar6 != null ? aVar6.f20133d : -1;
            if (z2) {
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    if (lValueOf != null && lValueOf.longValue() == 0 && (aVar3 = melodyMediaSessionService.f20115y) != null) {
                        aVar3.b(i12);
                    }
                    com.oplus.melody.model.repository.soundplay.a aVar7 = melodyMediaSessionService.f20115y;
                    if (aVar7 != null) {
                        aVar7.c();
                    }
                }
                melodyMediaSessionService.f20116z = System.currentTimeMillis();
                return;
            }
            A.c("MelodyMediaSessionService", new C0478z(3, numValueOf));
            if (numValueOf != null && numValueOf.intValue() == 0) {
                if (lValueOf != null && lValueOf.longValue() == 0 && (aVar2 = melodyMediaSessionService.f20115y) != null) {
                    aVar2.b(i12);
                }
            } else if (numValueOf != null && numValueOf.intValue() == 1 && (aVar = melodyMediaSessionService.f20115y) != null) {
                aVar.d();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - melodyMediaSessionService.f20116z;
            EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(melodyMediaSessionService.f20106B);
            if (earphoneDTOW == null || TimeUnit.MILLISECONDS.toMinutes(jCurrentTimeMillis) < 1) {
                return;
            }
            String strT = N.t(AbstractC0939b.E().w(melodyMediaSessionService.f20106B));
            String str = melodyMediaSessionService.f20105A;
            String str2 = melodyMediaSessionService.f20106B;
            C1264t.t(AppConstant$FunctionType.SOUND_PLAY_TIME.getFunType(), str, str2, strT, jCurrentTimeMillis + "|" + earphoneDTOW.getConnectionState());
            A.c("MelodyMediaSessionService", new K(jCurrentTimeMillis, earphoneDTOW));
        }
    }

    @Override // androidx.media3.session.U0
    public final C0683w0 f(C0683w0.f fVar) {
        int i10 = 1;
        Bundle bundle = new Bundle(fVar.f11591e);
        this.f20105A = bundle.getString("sound_play_pid_key");
        this.f20106B = bundle.getString("sound_play_address_key");
        String string = bundle.getString("sound_play_notify_title_key");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName()) && !this.f20107C) {
            try {
                P p6 = P.f19456a;
                P.b(this, "headset_channel", null);
                t tVar = new t(this, "headset_channel");
                tVar.f314Q.icon = getApplicationInfo().icon;
                tVar.f322e = t.c(string);
                tVar.h = k();
                tVar.d(2, true);
                tVar.d(8, true);
                Notification notificationA = tVar.a();
                h.d(notificationA, "build(...)");
                if (Build.VERSION.SDK_INT >= 34) {
                    startForeground(5, notificationA, 2);
                } else {
                    startForeground(5, notificationA);
                }
                this.f20107C = true;
            } catch (Exception e10) {
                A.i("MelodyMediaSessionService", "startForegroundSafely failed", e10);
            }
        }
        A.c("MelodyMediaSessionService", new c(this, i10));
        C0683w0 c0683w0 = this.f20113w;
        if (c0683w0 != null) {
            return c0683w0;
        }
        h.i("session");
        throw null;
    }

    public final void j(boolean z2) {
        if (z2 || this.f20109E) {
            int i10 = Build.VERSION.SDK_INT;
            Jb.b bVar = this.f20111G;
            if (i10 >= 26) {
                AudioFocusRequest audioFocusRequest = this.f20108D;
                if (audioFocusRequest != null) {
                    ((AudioManager) bVar.getValue()).abandonAudioFocusRequest(audioFocusRequest);
                }
                this.f20108D = null;
            } else {
                ((AudioManager) bVar.getValue()).abandonAudioFocus(this.H);
            }
            this.f20109E = false;
            A.c("MelodyMediaSessionService", new q8.d(0, z2));
        }
    }

    public final PendingIntent k() {
        Intent launchIntentForPackage;
        try {
            if (h.a(getPackageName(), "com.oplus.melody")) {
                launchIntentForPackage = new Intent();
                launchIntentForPackage.setComponent(new ComponentName(getPackageName(), "com.oplus.melody.ui.component.detail.DetailMainActivity"));
                launchIntentForPackage.setFlags(805306368);
            } else if (!h.a(getPackageName(), "com.heytap.headset") || (launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName())) == null) {
                launchIntentForPackage = null;
            } else {
                launchIntentForPackage.setFlags(805306368);
            }
            A.h("MelodyMediaSessionService", "pkg:" + (launchIntentForPackage != null ? launchIntentForPackage.getPackage() : null) + ", component:" + (launchIntentForPackage != null ? launchIntentForPackage.getComponent() : null) + ",action:" + (launchIntentForPackage != null ? launchIntentForPackage.getAction() : null));
            if (launchIntentForPackage != null) {
                return PendingIntent.getActivity(this, 0, launchIntentForPackage, 201326592);
            }
            A.h("MelodyMediaSessionService", "createActivityIntent failed: launch intent is null");
            return null;
        } catch (Exception e10) {
            A.i("MelodyMediaSessionService", "createActivityIntent failed", e10);
            return null;
        }
    }

    public final void l() {
        int iRequestAudioFocus;
        C1445b c1445b = this.f20114x;
        int i10 = (c1445b == null || !c1445b.f27178a) ? 1 : 2;
        boolean z2 = this.f20109E;
        if (z2 && this.f20110F == i10) {
            return;
        }
        if (z2) {
            j(true);
        }
        this.f20110F = i10;
        boolean z4 = i10 == 1;
        int i11 = Build.VERSION.SDK_INT;
        Jb.b bVar = this.f20111G;
        L l4 = this.H;
        if (i11 >= 26) {
            this.f20108D = G.j(i10).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(z4).setOnAudioFocusChangeListener(l4).build();
            AudioManager audioManager = (AudioManager) bVar.getValue();
            AudioFocusRequest audioFocusRequest = this.f20108D;
            h.b(audioFocusRequest);
            iRequestAudioFocus = audioManager.requestAudioFocus(audioFocusRequest);
        } else {
            iRequestAudioFocus = ((AudioManager) bVar.getValue()).requestAudioFocus(l4, 3, i10);
        }
        this.f20109E = iRequestAudioFocus == 1;
        A.c("MelodyMediaSessionService", new Ga.a(this, i10, 10));
    }

    @Override // androidx.media3.session.U0, androidx.lifecycle.q, android.app.Service
    public final void onCreate() {
        super.onCreate();
        A.b("MelodyMediaSessionService", "onCreate");
        Object obj = com.oplus.melody.model.repository.soundplay.a.f20129g;
        this.f20115y = a.C0232a.a();
        C0621q c0621q = new C0621q(this);
        C0498b c0498b = new C0498b(2, 0, 1, 1, 0, false, true);
        f.n(!c0621q.f10179B);
        c0621q.f10191k = c0498b;
        f.n(!c0621q.f10179B);
        c0621q.f10192l = true;
        f.n(!c0621q.f10179B);
        c0621q.f10179B = true;
        C c6 = new C(c0621q);
        this.f20112v = c6;
        C1445b c1445b = new C1445b();
        c1445b.f27181d = c6;
        c1445b.f27180c = 7;
        c1445b.b(t8.q.g(), t8.q.c("melody-model-settings").getBoolean("sound_settings_background_sound_mode", false));
        this.f20114x = c1445b;
        PendingIntent pendingIntentK = k();
        C c10 = this.f20112v;
        if (c10 == null) {
            h.i("player");
            throw null;
        }
        C0683w0.a aVar = new C0683w0.a(this, c10, new C0681v0());
        aVar.f11572d = new a();
        if (pendingIntentK != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                f.d(pendingIntentK.isActivity());
            }
            aVar.f11573e = pendingIntentK;
            A.b("MelodyMediaSessionService", "setSessionActivity for app launch");
        }
        f.n(!aVar.f11567o);
        aVar.f11567o = true;
        Object obj2 = C0683w0.f11564b;
        int iIntValue = C0.f10678F.get().intValue();
        int i10 = Build.VERSION.SDK_INT;
        Context context = aVar.f11569a;
        if (i10 < 27) {
            iIntValue = Math.max(iIntValue, (int) TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()));
        }
        InterfaceC0716d interfaceC0716d = aVar.h;
        if (interfaceC0716d == null) {
            b.a aVar2 = new b.a(context);
            aVar2.f9197b = iIntValue;
            aVar2.f9198c = true;
            aVar.h = new androidx.media3.datasource.b(aVar2);
        } else {
            aVar.h = new I1(interfaceC0716d, iIntValue);
        }
        if (i10 == 29) {
            InterfaceC0716d interfaceC0716d2 = aVar.h;
            AtomicReference<ImmutableIntArray> atomicReference = C0683w0.b.f11568n;
            ImmutableIntArray immutableIntArray = atomicReference.get();
            if (immutableIntArray == null) {
                Display defaultDisplay = ((WindowManager) context.getSystemService(WindowManager.class)).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                Point point2 = new Point();
                defaultDisplay.getRealSize(point2);
                int i11 = point2.y;
                int i12 = point2.x;
                Point point3 = new Point(i11 - (i12 - point.x), i12 - (i11 - point.y));
                ImmutableIntArray immutableIntArray2 = new ImmutableIntArray(new int[]{Math.max(point.x / 6, point.y / 6), Math.max(point3.x / 6, point3.y / 6)});
                atomicReference.set(immutableIntArray2);
                immutableIntArray = immutableIntArray2;
            }
            aVar.h = new H1(interfaceC0716d2, immutableIntArray);
        }
        aVar.h = new C0633b(aVar.h);
        this.f20113w = new C0683w0(aVar.f11569a, aVar.f11571c, aVar.f11570b, aVar.f11573e, aVar.f11577j, aVar.f11578k, aVar.f11579l, aVar.f11572d, aVar.f11574f, aVar.f11575g, aVar.h, aVar.f11576i, aVar.f11580m);
        C c11 = this.f20112v;
        if (c11 == null) {
            h.i("player");
            throw null;
        }
        c11.f9300m.a(new b());
    }

    @Override // androidx.media3.session.U0, androidx.lifecycle.q, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        A.b("MelodyMediaSessionService", "destroy");
        j(false);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName()) && this.f20107C) {
            stopForeground(1);
            this.f20107C = false;
        }
        C c6 = this.f20112v;
        if (c6 == null) {
            h.i("player");
            throw null;
        }
        c6.x0();
        C0683w0 c0683w0 = this.f20113w;
        if (c0683w0 == null) {
            h.i("session");
            throw null;
        }
        try {
            synchronized (C0683w0.f11564b) {
                C0683w0.f11565c.remove(c0683w0.f11566a.f10690i);
            }
            c0683w0.f11566a.v();
        } catch (Exception unused) {
        }
        Object obj = com.oplus.melody.model.repository.soundplay.a.f20129g;
        a.C0232a.a().f20130a = null;
        a.C0232a.a().f20131b = null;
    }

    @Override // androidx.media3.session.U0, android.app.Service
    public final void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        A.b("MelodyMediaSessionService", "TaskRemoved");
        C1445b c1445b = this.f20114x;
        if (c1445b != null && c1445b.f27178a) {
            A.b("MelodyMediaSessionService", "TaskRemoved skip stop, background sound mode enabled");
            return;
        }
        C c6 = this.f20112v;
        if (c6 != null) {
            c6.stop();
        } else {
            h.i("player");
            throw null;
        }
    }
}
