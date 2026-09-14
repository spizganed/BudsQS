package com.oplus.melody.ui.component.detail.gamemode;

import A9.c;
import D7.C0379m;
import a9.C0541g;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.btsdk.api.data.GameSoundInfo;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import d8.AbstractC0972a;
import g0.e;
import g0.f;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: GameSetViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bJ$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\r¨\u0006#"}, d2 = {"Lcom/oplus/melody/ui/component/detail/gamemode/GameSetViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "getConnectionState", "Landroidx/lifecycle/LiveData;", "", "address", "", "setGameModeMainEnable", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "enable", "", "needGetState", "setGameSoundEnable", "getGameModeMainState", "Lcom/oplus/melody/ui/component/detail/gamemode/GameModeMainVO;", "getGameSoundState", "Lcom/oplus/melody/ui/component/detail/gamemode/GameSoundVO;", "getGameSoundInfo", "", "setGameSoundTypeEnable", SpeechFindManager.TYPE, "getGameSoundLiveData", "Lcom/oplus/melody/btsdk/api/data/GameSoundInfo;", "getGameModeState", "Lcom/oplus/melody/ui/component/detail/gamemode/GameModeVO;", "setGameModeStatus", "getEarphoneDirect", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "macAddress", "safeCloseGameSound", "lowLatencyDisabled", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GameSetViewModel extends BaseViewModel {
    public static t e(String address) {
        h.e(address, "address");
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new e(20)));
    }

    public static t f(String address) {
        h.e(address, "address");
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new f(8)));
    }

    public static s g(String address) {
        h.e(address, "address");
        s<GameSoundInfo> sVarB = AbstractC0972a.c().b(address);
        h.d(sVarB, "getGameSoundLiveData(...)");
        return sVarB;
    }

    public final EarphoneDTO d(String macAddress) {
        h.e(macAddress, "macAddress");
        return AbstractC0939b.E().w(macAddress);
    }

    public final CompletableFuture h(int i10, String address) {
        h.e(address, "address");
        CompletableFuture completableFutureWhenComplete = AbstractC0972a.c().d(i10, true, address).whenComplete((BiConsumer) new c(new C0541g(1, this, address), 22));
        h.d(completableFutureWhenComplete, "whenComplete(...)");
        return completableFutureWhenComplete;
    }
}
