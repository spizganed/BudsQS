package com.oplus.melody.ui.component.detail.spatialaudio;

import A6.e;
import A9.o;
import D7.C0374h;
import D7.C0379m;
import D7.L;
import Ea.C0402k;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeadSetSpatialAudioVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J$\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/ui/component/detail/spatialaudio/HeadSetSpatialAudioVM;", "Lcom/oplus/melody/ui/component/detail/spatialaudio/BaseSpatialAudioVM;", "<init>", "()V", "setSpatializerEnable", "", "enable", "", "setDesiredHeadTrackingMode", "mode", "", "getSpatializerType", "Landroidx/lifecycle/LiveData;", "address", "", "onItemClick", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", SpeechFindManager.TYPE, "releaseSpatialAudio", "setSpatialSoundStatus", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadSetSpatialAudioVM extends BaseSpatialAudioVM {
    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final u d(String address) {
        h.e(address, "address");
        t tVarB = C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new e(23)));
        this.f21248d = tVarB;
        return tVarB;
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final CompletableFuture<SetCommandStateDTO> g(int i10, String address) {
        CompletableFuture completableFutureThenApply;
        CompletableFuture completableFutureThenApply2;
        h.e(address, "address");
        A.c("HeadSetSpatialAudioVM", new L(i10, 12));
        Integer numD = this.f21248d.d();
        if (i10 == 0) {
            C0379m.k(this.f21248d, 0);
            String str = this.f21246b;
            if (str == null) {
                h.i("mAddress");
                throw null;
            }
            CompletableFuture completableFutureE0 = AbstractC0939b.E().E0(27, false, str);
            if (completableFutureE0 != null && (completableFutureThenApply = completableFutureE0.thenApply((Function) new Aa.c(new J8.e(1, this, numD), 4))) != null) {
                return completableFutureThenApply.exceptionally((Function) new C0402k(2, this, numD));
            }
        } else if (i10 == 1) {
            C0379m.k(this.f21248d, 1);
            String str2 = this.f21246b;
            if (str2 == null) {
                h.i("mAddress");
                throw null;
            }
            CompletableFuture completableFutureE02 = AbstractC0939b.E().E0(27, true, str2);
            if (completableFutureE02 != null && (completableFutureThenApply2 = completableFutureE02.thenApply((Function) new o(new C0374h(1, this, numD), 10))) != null) {
                return completableFutureThenApply2.exceptionally((Function) new F9.u(1, this, numD));
            }
        }
        return null;
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final void h() {
        A.b("HeadSetSpatialAudioVM", "releaseSpatialAudio:");
    }
}
