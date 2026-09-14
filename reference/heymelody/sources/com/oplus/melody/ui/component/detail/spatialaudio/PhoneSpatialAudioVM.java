package com.oplus.melody.ui.component.detail.spatialaudio;

import A6.i;
import A6.j;
import D7.C0368b;
import D7.o0;
import Ea.G;
import K.g;
import Q7.o;
import R9.p;
import android.content.Context;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import androidx.lifecycle.u;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.spatialaudio.PhoneSpatialAudioVM;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: PhoneSpatialAudioVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\t\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u001a\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\"\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\u0012\u0010&\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/oplus/melody/ui/component/detail/spatialaudio/PhoneSpatialAudioVM;", "Lcom/oplus/melody/ui/component/detail/spatialaudio/BaseSpatialAudioVM;", "<init>", "()V", "spatializer", "Landroid/media/Spatializer;", "audioManager", "Landroid/media/AudioManager;", "spatializerStateChangeListener", "com/oplus/melody/ui/component/detail/spatialaudio/PhoneSpatialAudioVM$spatializerStateChangeListener$1", "Lcom/oplus/melody/ui/component/detail/spatialaudio/PhoneSpatialAudioVM$spatializerStateChangeListener$1;", "spatializerAvailableListener", "Landroid/media/Spatializer$OnHeadTrackerAvailableListener;", "initSpatialAudio", "", "context", "Landroid/content/Context;", "address", "", "zipConfig", "Lcom/oplus/melody/ui/component/detail/spatialaudio/SpatialAudioZipConfig;", "hasHeadTracker", "", "getSpatialType", "", "getSpatializerType", "Landroidx/lifecycle/LiveData;", "updateSpatializerType", "setSpatializerEnable", "enable", "setDesiredHeadTrackingMode", "mode", "setHeadTrackerEnabled", "onItemClick", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "id", "releaseSpatialAudio", "isSupportHeadTracker", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PhoneSpatialAudioVM extends BaseSpatialAudioVM {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Spatializer f21249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioManager f21250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f21251g = new a();
    public final R9.d h = new Spatializer.OnHeadTrackerAvailableListener() { // from class: R9.d
        @Override // android.media.Spatializer.OnHeadTrackerAvailableListener
        public final void onHeadTrackerAvailableChanged(Spatializer p02, boolean z2) {
            PhoneSpatialAudioVM phoneSpatialAudioVM = this.f4688a;
            kotlin.jvm.internal.h.e(p02, "p0");
            A.c("PhoneSpatialAudioVM", new G(8, z2));
            phoneSpatialAudioVM.i();
        }
    };

    /* JADX INFO: compiled from: PhoneSpatialAudioVM.kt */
    public static final class a implements Spatializer$OnSpatializerStateChangedListener {
        public a() {
        }

        public final void onSpatializerAvailableChanged(Spatializer p02, boolean z2) {
            h.e(p02, "p0");
            A.c("PhoneSpatialAudioVM", new A9.h(4, z2));
            PhoneSpatialAudioVM.this.i();
        }

        public final void onSpatializerEnabledChanged(Spatializer p02, boolean z2) {
            h.e(p02, "p0");
            A.c("PhoneSpatialAudioVM", new G(9, z2));
            PhoneSpatialAudioVM.this.i();
        }
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final u d(String address) {
        h.e(address, "address");
        i();
        return this.f21248d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.spatialaudio.PhoneSpatialAudioVM.e(java.lang.String):boolean");
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final void f(Context context, String address, p pVar) {
        h.e(context, "context");
        h.e(address, "address");
        super.f(context, address, pVar);
        A.c("PhoneSpatialAudioVM", new D6.c(address, 10));
        Object systemService = context.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        this.f21250f = audioManager;
        Spatializer spatializer = audioManager != null ? audioManager.getSpatializer() : null;
        this.f21249e = spatializer;
        if (spatializer != null) {
            spatializer.addOnSpatializerStateChangedListener(o0.c.f1144b, g.c(this.f21251g));
        }
        Spatializer spatializer2 = this.f21249e;
        if (spatializer2 != null) {
            spatializer2.addOnHeadTrackerAvailableListener(o0.c.f1144b, this.h);
        }
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final CompletableFuture<SetCommandStateDTO> g(int i10, String address) {
        h.e(address, "address");
        if (i10 == 0) {
            l(false);
            k(address, false);
        } else if (i10 == 1) {
            l(true);
            k(address, false);
            j(-1);
        } else if (i10 == 2) {
            l(true);
            k(address, true);
            j(1);
        }
        AbstractC0939b abstractC0939bE = AbstractC0939b.E();
        String str = this.f21246b;
        if (str == null) {
            h.i("mAddress");
            throw null;
        }
        abstractC0939bE.y0(i10, str);
        i();
        return null;
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final void h() {
        try {
            Spatializer spatializer = this.f21249e;
            if (spatializer != null) {
                spatializer.removeOnSpatializerStateChangedListener(g.c(this.f21251g));
            }
            Spatializer spatializer2 = this.f21249e;
            if (spatializer2 != null) {
                spatializer2.removeOnHeadTrackerAvailableListener(this.h);
            }
        } catch (Exception e10) {
            A.i("PhoneSpatialAudioVM", "releaseSpatialAudio error ", e10);
        }
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final void i() {
        CompletableFuture.supplyAsync(new j(5), o0.c.f1145c).thenAccept((Consumer) new C0368b(new B9.d(this, 15), 8)).exceptionally((Function<Throwable, ? extends Void>) new i(10));
    }

    public final void j(int i10) {
        A.c("PhoneSpatialAudioVM", new Ba.b(i10, 12));
        AudioManager audioManager = this.f21250f;
        if (audioManager != null) {
            audioManager.setParameters("OPLUS_AUDIO_SET_SPATIALIZER_AUDIO;setDesiredHeadTrackingMode;" + i10);
        }
    }

    public final void k(String str, boolean z2) {
        A.c("PhoneSpatialAudioVM", new o(z2, str, 1));
        AudioManager audioManager = this.f21250f;
        if (audioManager != null) {
            audioManager.setParameters("OPLUS_AUDIO_SET_SPATIALIZER_AUDIO;setHeadTrackerEnabled;" + z2 + ";" + str);
        }
    }

    public final void l(boolean z2) {
        A.c("PhoneSpatialAudioVM", new A9.i(13, z2));
        AudioManager audioManager = this.f21250f;
        if (audioManager != null) {
            audioManager.setParameters("OPLUS_AUDIO_SET_SPATIALIZER_AUDIO;setEnabled;" + z2);
        }
    }
}
