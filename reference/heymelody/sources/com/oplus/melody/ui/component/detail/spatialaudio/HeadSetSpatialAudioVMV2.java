package com.oplus.melody.ui.component.detail.spatialaudio;

import A6.e;
import D7.C0379m;
import D7.L;
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

/* JADX INFO: compiled from: HeadSetSpatialAudioVMV2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J$\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\nH\u0002¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/ui/component/detail/spatialaudio/HeadSetSpatialAudioVMV2;", "Lcom/oplus/melody/ui/component/detail/spatialaudio/BaseSpatialAudioVM;", "<init>", "()V", "setSpatializerEnable", "", "enable", "", "setDesiredHeadTrackingMode", "mode", "", "getSpatializerType", "Landroidx/lifecycle/LiveData;", "address", "", "onItemClick", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", SpeechFindManager.TYPE, "releaseSpatialAudio", "setHeadsetSpatialType", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeadSetSpatialAudioVMV2 extends BaseSpatialAudioVM {
    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final u d(String address) {
        h.e(address, "address");
        t tVarB = C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new e(24)));
        this.f21248d = tVarB;
        return tVarB;
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final CompletableFuture<SetCommandStateDTO> g(int i10, String address) {
        CompletableFuture completableFutureThenApply;
        h.e(address, "address");
        A.c("HeadSetSpatialAudioVMV2", new L(i10, 13));
        Integer numD = this.f21248d.d();
        C0379m.k(this.f21248d, Integer.valueOf(i10));
        String str = this.f21246b;
        if (str == null) {
            h.i("mAddress");
            throw null;
        }
        CompletableFuture completableFutureR0 = AbstractC0939b.E().r0(i10, str);
        if (completableFutureR0 == null || (completableFutureThenApply = completableFutureR0.thenApply((Function) new Aa.c(new R9.a(this, i10, 0, numD), 5))) == null) {
            return null;
        }
        return completableFutureThenApply.exceptionally((Function) new R9.b(i10, this, numD));
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM
    public final void h() {
        A.b("HeadSetSpatialAudioVMV2", "releaseSpatialAudio:");
    }
}
