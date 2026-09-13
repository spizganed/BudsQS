package com.oplus.melody.ui.component.control.guide;

import Aa.c;
import Ea.C0403l;
import F9.g;
import I8.B;
import I8.C;
import I8.C0425a;
import I8.C0426b;
import O7.l;
import androidx.lifecycle.u;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ControlGuideViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\tJ\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u0014J\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0007J\b\u0010,\u001a\u0004\u0018\u00010\u0018J\u0010\u0010-\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010\u0018J\u0006\u0010/\u001a\u00020\u0014J\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u0014J8\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00052\u001e\u00106\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u000107j\f\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u0001`9J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0 J\u0016\u0010;\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005J\u001e\u0010=\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@2\u0006\u00105\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0014J\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0 J\u0006\u0010E\u001a\u00020\u001dJ\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070 2\u0006\u0010G\u001a\u00020\u0005J \u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010A\u0018\u00010@2\u0006\u00105\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0014J\u0010\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010G\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006L"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/ControlGuideViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "TAG", "", "mGuideEntrancePageIndex", "", "mConfig", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "Lcom/oplus/melody/ui/component/control/guide/ControlGuideConfigVO;", "mSoundSampleConfig", "Lcom/oplus/melody/ui/component/control/guide/SoundSampleZipConfig;", "mHeadsetRes", "Lcom/oplus/melody/ui/component/control/guide/HeadSetResVO;", "mGuideState", "Lcom/oplus/melody/ui/component/control/guide/CommandStatus;", "mErrorState", "Landroidx/lifecycle/MutableLiveData;", "mIsGuideFinish", "", "mProductId", "mCurrentGuidePageIndex", "mPlayingFile", "Ljava/io/File;", "mIsPlaying", "Ljava/lang/Boolean;", "getProductId", "setProductId", "", "productId", "getConfig", "Landroidx/lifecycle/LiveData;", "getHeadsetRes", "getErrorState", "getControlGuideState", "getIsGuideFinish", "setIsGuideFinish", "isFinish", "getGuideEntrancePageIndex", "setGuideEntrancePageIndex", "index", "getCurrentGuidePageIndex", "setCurrentGuidePageIndex", "getPlayingFile", "setPlayingFile", "file", "isPlaying", "setPlaying", "playing", "setKeyFunctions", "context", "Landroid/content/Context;", "address", "infoList", "Ljava/util/ArrayList;", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "Lkotlin/collections/ArrayList;", "getSoundSampleZipConfigLiveData", "loadControlGuideResource", "colorId", "loadHeadImageRes", "deviceType", "enterControlMode", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "enter", "getCommandType", "Lcom/oplus/melody/model/repository/earphone/UserInteractionDTO;", "resetCommandType", "getConnectionState", "macAddress", "setMultiConnectSwitchStatus", ClientDataEntity.COL_STATUS, "getEarphoneDirect", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ControlGuideViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20494c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f20499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public File f20501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f20502l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20493b = "ControlGuideViewModel";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l<C0426b> f20495d = new l<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l<C> f20496e = new l<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l<B> f20497f = new l<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l<C0425a> f20498g = new l<>();
    public final u<Integer> h = new u<>();

    public final CompletableFuture<SetCommandStateDTO> d(String address, boolean z2) {
        h.e(address, "address");
        CompletableFuture<SetCommandStateDTO> completableFutureJ0 = AbstractC0939b.E().j0(address, z2);
        h.d(completableFutureJ0, "setControlGuideMode(...)");
        return completableFutureJ0;
    }

    public final void e(String productId, String colorId) {
        h.e(productId, "productId");
        h.e(colorId, "colorId");
        Z7.a.g().d(Integer.parseInt(colorId), 4, productId).thenCompose((Function) new C0403l(new g(this, productId, colorId, 1), 1)).thenAccept((Consumer) new G8.h(new Aa.b(this, 5), 2)).exceptionally((Function<Throwable, ? extends Void>) new c(this, 3));
    }

    public final void f(boolean z2) {
        this.f20502l = Boolean.valueOf(z2);
    }
}
