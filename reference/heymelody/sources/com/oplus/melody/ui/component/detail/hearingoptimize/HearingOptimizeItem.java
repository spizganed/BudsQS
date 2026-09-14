package com.oplus.melody.ui.component.detail.hearingoptimize;

import A6.e;
import A9.i;
import D7.C0379m;
import D7.o0;
import E9.q;
import Jb.a;
import R9.g;
import W.a;
import Wb.l;
import X.d;
import a9.C0531H;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0594f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.P;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.GameSoundInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.gamemode.GameSetViewModel;
import com.oplus.melody.ui.component.detail.hearingoptimize.HearingOptimizeItem;
import com.oplus.melody.ui.widget.MelodyUiCOUISwitchPreference;
import e9.C1017a;
import e9.C1020d;
import g9.s;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import la.C1294g;
import q9.C1446a;
import q9.C1447b;
import q9.n;
import r9.C1479c;
import s8.AbstractC1508a;
import t9.C1539a;

/* JADX INFO: compiled from: HearingOptimizeItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/oplus/melody/ui/component/detail/hearingoptimize/HearingOptimizeItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "gameSetVM", "Lcom/oplus/melody/ui/component/detail/gamemode/GameSetViewModel;", "gameModeMainEnable", "", "isSelectGameSound", "lowLatencyDisabled", "onSwitchChanged", "", "isChecked", "showConfirmDialog", "checked", "setHearingOptimizeEnable", "enable", "onEarphoneChanged", "hearingOptimizeVO", "Lcom/oplus/melody/ui/component/detail/hearingoptimize/HearingOptimizeVO;", "checkGameSoundMutexDialog", "dialog", "Landroid/content/DialogInterface;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HearingOptimizeItem extends MelodyUiCOUISwitchPreference {
    public static final String ITEM_NAME = "HearingOptimizeItem";
    public static final String TAG = "HearingOptimizeItem";
    private boolean gameModeMainEnable;
    private GameSetViewModel gameSetVM;
    private boolean isSelectGameSound;
    private boolean lowLatencyDisabled;
    private f mAlertDialog;
    private InterfaceC0601m mLifecycleOwner;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: compiled from: HearingOptimizeItem.kt */
    public static final class b implements n.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f21079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DialogInterface f21080c;

        public b(boolean z2, DialogInterface dialogInterface) {
            this.f21079b = z2;
            this.f21080c = dialogInterface;
        }

        @Override // q9.n.a
        public final void a() {
            boolean z2 = !this.f21079b;
            HearingOptimizeItem hearingOptimizeItem = HearingOptimizeItem.this;
            hearingOptimizeItem.setChecked(z2);
            this.f21080c.dismiss();
            C1264t.t(AppConstant$FunctionType.GAME_EQ_SPATIAL_SWITCH_DIALOG.getFunType(), hearingOptimizeItem.mViewModel.f20400e, hearingOptimizeItem.mViewModel.f20397b, N.t(AbstractC0939b.E().w(hearingOptimizeItem.mViewModel.f20397b)), "40");
        }

        @Override // q9.n.a
        public final void b() {
            HearingOptimizeItem hearingOptimizeItem = HearingOptimizeItem.this;
            hearingOptimizeItem.setHearingOptimizeEnable(this.f21079b);
            C1264t.t(AppConstant$FunctionType.GAME_EQ_SPATIAL_SWITCH_DIALOG.getFunType(), hearingOptimizeItem.mViewModel.f20400e, hearingOptimizeItem.mViewModel.f20397b, N.t(AbstractC0939b.E().w(hearingOptimizeItem.mViewModel.f20397b)), "41");
        }
    }

    /* JADX INFO: compiled from: HearingOptimizeItem.kt */
    public static final class c implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21081a;

        public c(l lVar) {
            this.f21081a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21081a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21081a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HearingOptimizeItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        WhitelistConfigDTO.Function function;
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewModel = viewModel;
        setTitle(R.string.melody_common_hearing_optimize_title);
        setSummary(R.string.melody_common_hearing_optimize_summary);
        int i10 = 6;
        setOnPreferenceChangeListener(new s(this, i10));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = viewModel.f20397b;
        detailMainViewModel.getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new e(12))).e(this.mLifecycleOwner, new c(new C1479c(this, 2)));
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(context.getPackageName()) && (context instanceof androidx.fragment.app.f)) {
            WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(viewModel.f20397b, viewModel.f20398c);
            if (C0901g.a((whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : function.getGameSoundList())) {
                return;
            }
            P p6 = (P) context;
            O store = p6.getViewModelStore();
            boolean z2 = p6 instanceof InterfaceC0594f;
            N.b factory = z2 ? ((InterfaceC0594f) p6).getDefaultViewModelProviderFactory() : X.b.f5618a;
            W.a defaultCreationExtras = z2 ? ((InterfaceC0594f) p6).getDefaultViewModelCreationExtras() : a.C0078a.f5426b;
            h.e(store, "store");
            h.e(factory, "factory");
            h.e(defaultCreationExtras, "defaultCreationExtras");
            d dVar = new d(store, factory, defaultCreationExtras);
            kotlin.jvm.internal.b bVarA = j.a(GameSetViewModel.class);
            String strA = bVarA.a();
            if (strA == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.gameSetVM = (GameSetViewModel) dVar.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
            GameSetViewModel.e(viewModel.f20397b).e(lifecycleOwner, new c(new C1020d(this, i10)));
            if (this.gameSetVM != null) {
                GameSetViewModel.g(viewModel.f20397b).e(lifecycleOwner, new c(new C1017a(this, 7)));
            }
            if (this.gameSetVM != null) {
                GameSetViewModel.f(viewModel.f20397b).e(lifecycleOwner, new c(new C0531H(this, 19)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(HearingOptimizeItem hearingOptimizeItem, Preference preference, Object obj) {
        h.e(preference, "<unused var>");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        hearingOptimizeItem.onSwitchChanged(((Boolean) obj).booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(HearingOptimizeItem hearingOptimizeItem, t9.d dVar) {
        hearingOptimizeItem.onEarphoneChanged(dVar);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(HearingOptimizeItem hearingOptimizeItem, C1446a gameModeMainVO) {
        h.e(gameModeMainVO, "gameModeMainVO");
        hearingOptimizeItem.gameModeMainEnable = gameModeMainVO.getEnable();
        A.c("HearingOptimizeItem", new C1539a(hearingOptimizeItem, 0));
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$2$0(HearingOptimizeItem hearingOptimizeItem) {
        return e.f("getGameModeMainState.gameModeMainEnable:", hearingOptimizeItem.gameModeMainEnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3(HearingOptimizeItem hearingOptimizeItem, GameSoundInfo gameSoundInfo) {
        h.e(gameSoundInfo, "gameSoundInfo");
        hearingOptimizeItem.isSelectGameSound = gameSoundInfo.getSelectType() != 0;
        A.c("HearingOptimizeItem", new g(gameSoundInfo, 1));
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$3$0(GameSoundInfo gameSoundInfo) {
        return A6.b.d(gameSoundInfo.getSelectType(), "getGameSoundLiveData, selectType:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$4(HearingOptimizeItem hearingOptimizeItem, C1447b c1447b) {
        hearingOptimizeItem.lowLatencyDisabled = c1447b.getStatus() != 1;
        A.c("HearingOptimizeItem", new C1294g(hearingOptimizeItem, 19));
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$4$0(HearingOptimizeItem hearingOptimizeItem) {
        return e.f("getGameModeState, lowLatencyDisabled:", hearingOptimizeItem.lowLatencyDisabled);
    }

    private final boolean checkGameSoundMutexDialog(boolean checked, DialogInterface dialog) {
        Boolean bool;
        if (this.gameSetVM != null && this.gameModeMainEnable && this.isSelectGameSound) {
            ConcurrentHashMap<String, Boolean> concurrentHashMap = n.f27216a;
            String str = this.mViewModel.f20397b;
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            List<String> list = S.f19463a;
            if (("com.heytap.headset".equals(heyMelodyApplication.getPackageName()) && (bool = n.f27219d.get(str)) != null) ? bool.booleanValue() : false) {
                Context context = getContext();
                h.d(context, "getContext(...)");
                GameSetViewModel gameSetViewModel = this.gameSetVM;
                h.b(gameSetViewModel);
                n.b(context, gameSetViewModel, this.mViewModel.f20397b, this.lowLatencyDisabled, 4, new b(checked, dialog));
                return true;
            }
        }
        return false;
    }

    private final void onEarphoneChanged(t9.d dVar) {
        A.c("HearingOptimizeItem", new com.oplus.melody.ui.component.detail.zenmode.scene.a(dVar, 27));
        if (dVar != null) {
            setDisabled(dVar.getConnectionState() != 2);
            setChecked(dVar.getStatus() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onEarphoneChanged$lambda$0(t9.d dVar) {
        return "onEarphoneChanged status: " + (dVar != null ? Integer.valueOf(dVar.getStatus()) : null);
    }

    private final void onSwitchChanged(boolean isChecked) {
        A.c("HearingOptimizeItem", new i(29, isChecked));
        if (isChecked) {
            showConfirmDialog(true);
        } else {
            setHearingOptimizeEnable(false);
        }
    }

    public static /* synthetic */ void onSwitchChanged$default(HearingOptimizeItem hearingOptimizeItem, boolean z2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z2 = false;
        }
        hearingOptimizeItem.onSwitchChanged(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onSwitchChanged$lambda$0(boolean z2) {
        return e.f("isChecked: ", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHearingOptimizeEnable(boolean enable) {
        CompletableFuture<Void> completableFutureThenAccept;
        A.x("HearingOptimizeItem", "setHearingOptimizeEnable, enable: " + enable + ", isChecked: " + isChecked());
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(56, enable, this.mViewModel.f20397b);
        this.mSetCommandFuture = completableFutureE0;
        if (completableFutureE0 != null && (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new q(new S8.b(this, enable, 5), 24))) != null) {
            completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new com.oplus.melody.ui.component.detail.voiceassist.a(this, enable, 4));
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.HEARING_OPTIMIZE.getFunType(), str, str2, com.oplus.melody.model.repository.earphone.N.t(detailMainViewModel.i(str2)), String.valueOf(enable ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l setHearingOptimizeEnable$lambda$0(HearingOptimizeItem hearingOptimizeItem, boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
            A.x("HearingOptimizeItem", "setHearingOptimizeEnable failed! setCommandStatus = " + (setCommandStateDTO != null ? Integer.valueOf(setCommandStateDTO.getSetCommandStatus()) : null));
            o0.c.f1144b.execute(new t9.c(hearingOptimizeItem, z2, 0));
        } else {
            A.b("HearingOptimizeItem", "setHearingOptimizeEnable success ");
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHearingOptimizeEnable$lambda$0$0(HearingOptimizeItem hearingOptimizeItem, boolean z2) {
        hearingOptimizeItem.setChecked(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setHearingOptimizeEnable$lambda$2(HearingOptimizeItem hearingOptimizeItem, boolean z2, Throwable th) {
        o0.c.f1144b.execute(new t9.c(hearingOptimizeItem, z2, 1));
        A.i("HearingOptimizeItem", "setHearingOptimizeEnable", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHearingOptimizeEnable$lambda$2$0(HearingOptimizeItem hearingOptimizeItem, boolean z2) {
        hearingOptimizeItem.setChecked(!z2);
    }

    private final void showConfirmDialog(final boolean checked) {
        f fVar = this.mAlertDialog;
        if (fVar != null && fVar.isShowing()) {
            A.c("HearingOptimizeItem", new C1539a(this, 1));
            return;
        }
        R1.e eVar = new R1.e(getContext());
        eVar.n(R.string.melody_common_hearing_optimize_dialog_title);
        eVar.f(R.string.melody_common_hearing_optimize_dialog_msg);
        final int i10 = 1;
        eVar.h(R.string.melody_ui_common_cancel, new DialogInterface.OnClickListener(this) { // from class: t9.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HearingOptimizeItem f27965b;

            {
                this.f27965b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                switch (i10) {
                    case 0:
                        HearingOptimizeItem.showConfirmDialog$lambda$2(this.f27965b, checked, dialogInterface, i11);
                        break;
                    default:
                        HearingOptimizeItem.showConfirmDialog$lambda$1(this.f27965b, checked, dialogInterface, i11);
                        break;
                }
            }
        });
        final int i11 = 0;
        eVar.l(R.string.melody_ui_multi_devices_dialog_open, new DialogInterface.OnClickListener(this) { // from class: t9.b

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ HearingOptimizeItem f27965b;

            {
                this.f27965b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i112) {
                switch (i11) {
                    case 0:
                        HearingOptimizeItem.showConfirmDialog$lambda$2(this.f27965b, checked, dialogInterface, i112);
                        break;
                    default:
                        HearingOptimizeItem.showConfirmDialog$lambda$1(this.f27965b, checked, dialogInterface, i112);
                        break;
                }
            }
        });
        f fVarCreate = eVar.setCancelable(false).create();
        this.mAlertDialog = fVarCreate;
        if (fVarCreate != null) {
            fVarCreate.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showConfirmDialog$lambda$0(HearingOptimizeItem hearingOptimizeItem) {
        return "showConfirmDialog, checked: " + hearingOptimizeItem.isChecked() + ", is dialog showing. return";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmDialog$lambda$1(HearingOptimizeItem hearingOptimizeItem, boolean z2, DialogInterface dialogInterface, int i10) {
        hearingOptimizeItem.setChecked(!z2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmDialog$lambda$2(HearingOptimizeItem hearingOptimizeItem, boolean z2, DialogInterface dialogInterface, int i10) {
        h.b(dialogInterface);
        if (hearingOptimizeItem.checkGameSoundMutexDialog(z2, dialogInterface)) {
            return;
        }
        hearingOptimizeItem.setHearingOptimizeEnable(z2);
    }
}
