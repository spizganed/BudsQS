package com.oplus.melody.ui.component.detail.highaudio;

import D7.C0379m;
import D7.f0;
import O7.l;
import androidx.lifecycle.L;
import androidx.lifecycle.u;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.zenmode.scene.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import v9.C1582a;
import v9.b;

/* JADX INFO: compiled from: HighAudioViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00120\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007J\u0010\u0010)\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010*\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020+0\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u0005J\u0006\u00101\u001a\u00020!J\u000e\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u0007J\u0012\u00104\u001a\u0004\u0018\u0001052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u00067"}, d2 = {"Lcom/oplus/melody/ui/component/detail/highaudio/HighAudioViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mHaveInit", "", "mInitCodec", "", "mInitHiRes", "mCheckedCodecType", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "mApplyBtEnable", "Landroidx/lifecycle/MutableLiveData;", "mCurrentCodecStatus", "Lcom/oplus/melody/ui/component/detail/highaudio/CodecStatus;", "getMCurrentCodecStatus", "()Lcom/oplus/melody/ui/component/detail/highaudio/CodecStatus;", "codecList", "", "Lcom/oplus/melody/ui/component/detail/highaudio/CodecItem;", "getCodecList", "()Ljava/util/List;", "setCodecList", "(Ljava/util/List;)V", "getHiResStatus", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/ui/component/detail/highaudio/HiResVO;", "macAddress", "", "getCodecType", "getConnectionState", "getCapability", "connect", "", "setHighAudioCodecType", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "address", "codecType", "hiResOpened", "allCapability", "requestCodecList", "requestCodecType", "Lcom/oplus/melody/ui/component/detail/highaudio/CodecVO;", "getCheckCodeType", "getApplyBtEnable", "hiResStatusChanged", "enable", "isCurrentHiResOpened", "checkStatusChanged", "setCodecType", "position", "getEarphoneDirect", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HighAudioViewModel extends L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21091b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21093d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f21096g;
    public List<C1582a> h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21092c = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l<Integer> f21094e = new l<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u<Boolean> f21095f = new u<>();

    public HighAudioViewModel() {
        int i10 = this.f21092c;
        boolean z2 = this.f21093d;
        b bVar = new b();
        bVar.f28405a = i10;
        bVar.f28406b = z2;
        this.f21096g = bVar;
        this.h = EmptyList.f25350a;
    }

    public final void d() {
        A.c("HighAudioViewModel", new a(this, 28));
        b bVar = this.f21096g;
        boolean z2 = bVar.f28406b;
        boolean z4 = this.f21093d;
        u<Boolean> uVar = this.f21095f;
        if (z2 == z4 && bVar.f28405a == this.f21092c) {
            C0379m.k(uVar, Boolean.FALSE);
        } else {
            C0379m.k(uVar, Boolean.TRUE);
        }
    }

    public final void e(int i10) {
        if (this.h.isEmpty() || i10 > this.h.size()) {
            A.h("HighAudioViewModel", "setCodec error " + i10 + ", not a valid type");
            return;
        }
        A.c("HighAudioViewModel", new f0(this, i10, 13));
        this.f21096g.f28405a = this.h.get(i10).f28400a;
        this.f21094e.m(Integer.valueOf(this.h.get(i10).f28400a));
        d();
    }
}
