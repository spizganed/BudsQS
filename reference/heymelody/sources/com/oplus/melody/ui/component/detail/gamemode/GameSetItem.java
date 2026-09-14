package com.oplus.melody.ui.component.detail.gamemode;

import A9.j;
import A9.p;
import D7.C0373g;
import D7.o0;
import F8.i;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.GameSoundInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import d8.AbstractC0972a;
import e9.C1017a;
import e9.C1020d;
import g9.r;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import q9.i;
import q9.n;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: GameSetItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/ui/component/detail/gamemode/GameSetItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mContext", "mViewModel", "mLifecycleOwner", "doDetailFunction", "", "onEarphoneDataChanged", "state", "", "onGameSoundChanged", "gameSoundInfo", "Lcom/oplus/melody/btsdk/api/data/GameSoundInfo;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GameSetItem extends MelodyUiCOUIJumpPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "GameSetItem";
    private Context mContext;
    private InterfaceC0601m mLifecycleOwner;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.gamemode.GameSetItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GameSetItem.kt */
    public static final class Companion {
        public static boolean a(List list) {
            boolean z2 = C0373g.f1088n && C0373g.f1089o;
            boolean zK = N.k(61192, list);
            A.c(GameSetItem.ITEM_NAME, new W9.b(3, z2, zK));
            return z2 && zK;
        }
    }

    /* JADX INFO: compiled from: GameSetItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21020a;

        public b(l lVar) {
            this.f21020a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21020a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21020a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameSetItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        List<Integer> gameSoundMutexes;
        super(context);
        int i10 = 5;
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mContext = context;
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewModel = viewModel;
        setTitle(R.string.melody_ui_guide_control_game_mode_title);
        setOnPreferenceClickListener(new i(this));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(this.mLifecycleOwner, new b(new j(this, 29)));
        AbstractC0972a.c().b(this.mViewModel.f20397b).e(this.mLifecycleOwner, new b(new C1020d(this, i10)));
        if (C0373g.d()) {
            this.mViewModel.k().e(lifecycleOwner, new b(new C1017a(this, i10)));
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = n.f27216a;
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        String address = detailMainViewModel2.f20397b;
        String name = detailMainViewModel2.f20398c;
        String pId = detailMainViewModel2.f20400e;
        h.e(address, "address");
        h.e(name, "name");
        h.e(pId, "pId");
        A.f("GameSoundMutexHelper", "init, name: " + name + ", address: " + address + ", pId: " + pId);
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(pId, name);
        if (whitelistConfigDTOC != null) {
            WhitelistConfigDTO.Function function = whitelistConfigDTOC.getFunction();
            A.f("GameSoundMutexHelper", "init, address: " + address + ", gameSoundMutexes: " + (function != null ? function.getGameSoundMutexes() : null));
            WhitelistConfigDTO.Function function2 = whitelistConfigDTOC.getFunction();
            if (function2 == null || (gameSoundMutexes = function2.getGameSoundMutexes()) == null) {
                return;
            }
            Iterator<T> it = gameSoundMutexes.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue == 1) {
                    n.f27217b.put(address, Boolean.TRUE);
                } else if (iIntValue == 2) {
                    n.f27216a.put(address, Boolean.TRUE);
                } else if (iIntValue == 3) {
                    n.f27218c.put(address, Boolean.TRUE);
                } else if (iIntValue == 4) {
                    n.f27219d.put(address, Boolean.TRUE);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(GameSetItem gameSetItem, Preference it) {
        h.e(it, "it");
        A.b(ITEM_NAME, "setOnClickListener ");
        b.C0229b.f19632a.b(gameSetItem.mContext, gameSetItem.mViewModel.f20397b, LeFilterConstants.FunType.GAME_MODE.getFunType(), new i(gameSetItem));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(GameSetItem gameSetItem, int i10) {
        gameSetItem.onEarphoneDataChanged(i10);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(GameSetItem gameSetItem, GameSoundInfo gameSoundInfo) {
        h.b(gameSoundInfo);
        gameSetItem.onGameSoundChanged(gameSoundInfo);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3(GameSetItem gameSetItem, String str) {
        A.f(ITEM_NAME, "getLeAudioSwitchStatusChanged, addr: " + str + ", vm.addr: " + gameSetItem.mViewModel.f20397b);
        if (TextUtils.equals(str, gameSetItem.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new B9.f(28, gameSetItem, str)).whenComplete((BiConsumer) new r(new p(gameSetItem, 11), 3));
            return Jb.l.f2618a;
        }
        A.x(ITEM_NAME, "getLeAudioSwitchStatusChanged addr not same");
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO _init_$lambda$3$0(GameSetItem gameSetItem, String str) {
        DetailMainViewModel detailMainViewModel = gameSetItem.mViewModel;
        h.b(str);
        return detailMainViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3$1(GameSetItem gameSetItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new g0.i(14, gameSetItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3$1$0$0(GameSetItem gameSetItem, EarphoneDTO earphoneDTO) {
        gameSetItem.onEarphoneDataChanged(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doDetailFunction() {
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20398c;
        String str2 = detailMainViewModel.f20397b;
        int i10 = detailMainViewModel.f20401f;
        StringBuilder sbI = Y.r.i("doDetailFunction, name:", str, ", addr:", str2, ", color:");
        sbI.append(i10);
        A.f(ITEM_NAME, sbI.toString());
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
        F8.i iVarA = i.a.a("/ui/game_sound");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
        iVarA.b(this.mContext);
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        String str3 = detailMainViewModel2.f20400e;
        String str4 = detailMainViewModel2.f20397b;
        C1264t.t(AppConstant$FunctionType.GAME_MODE.getFunType(), str3, str4, N.t(detailMainViewModel2.i(str4)), "");
    }

    public static final boolean isBrLeCoexist(List<Integer> list) {
        INSTANCE.getClass();
        return Companion.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEarphoneDataChanged$lambda$0(GameSetItem gameSetItem, int i10, boolean z2) {
        if (z2) {
            gameSetItem.setDisabled(true);
            gameSetItem.setAllowClickWhenDisabled(i10 == 2);
        }
    }

    private final void onGameSoundChanged(GameSoundInfo gameSoundInfo) {
        A.c(ITEM_NAME, new g9.f(gameSoundInfo, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onGameSoundChanged$lambda$0(GameSoundInfo gameSoundInfo) {
        return "onGameSoundChanged:" + gameSoundInfo;
    }

    public final void onEarphoneDataChanged(int state) {
        setDisabled(state != 2);
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.GAME_MODE.getFunType(), new E9.b(this, state, 3));
    }
}
