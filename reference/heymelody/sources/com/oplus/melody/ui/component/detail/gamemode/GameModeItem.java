package com.oplus.melody.ui.component.detail.gamemode;

import A6.b;
import D7.C0379m;
import D7.o0;
import W9.f;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.media3.session.q1;
import androidx.preference.Preference;
import ba.C0741b;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import la.D;
import la.j0;
import q9.C1447b;

/* JADX INFO: loaded from: classes3.dex */
public class GameModeItem extends COUISwitchPreference {
    public static final String ITEM_NAME = "GameModeItem";
    private InterfaceC0601m mLifecycleOwner;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private boolean mSupportGameSound;
    private DetailMainViewModel mViewModel;

    public GameModeItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mSetCommandFuture = null;
        this.mSupportGameSound = false;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(R.string.melody_ui_guide_control_game_mode_title);
        setSummary(R.string.melody_ui_guide_game_mode_intro);
        setOnPreferenceChangeListener(new q1(this, 21));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new b(12))).e(this.mLifecycleOwner, new j0(this, 6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(boolean z2) {
        setChecked(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$1(boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO.getSetCommandStatus() != 0) {
            A.x(ITEM_NAME, "set gamemode failed ");
            o0.c.f1143a.post(new f(this, z2, 3));
            return;
        }
        A.b(ITEM_NAME, "set gamemode succeed");
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.GAME_MODE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), String.valueOf(z2 ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$new$2(Throwable th) {
        A.i(ITEM_NAME, "set gamemode", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$3(Preference preference, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        if (this.mSupportGameSound) {
            this.mSetCommandFuture = AbstractC0939b.E().E0(40, zBooleanValue, this.mViewModel.f20397b);
        } else {
            this.mSetCommandFuture = AbstractC0939b.E().E0(6, zBooleanValue, this.mViewModel.f20397b);
        }
        CompletableFuture<SetCommandStateDTO> completableFuture2 = this.mSetCommandFuture;
        if (completableFuture2 != null) {
            completableFuture2.thenAccept((Consumer<? super SetCommandStateDTO>) new C0741b(this, zBooleanValue, 2)).exceptionally((Function<Throwable, ? extends Void>) new D(6));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onEarphoneChanged$4(C1447b c1447b) {
        return "onEarphoneChanged gameMode = " + c1447b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEarphoneChanged(C1447b c1447b) {
        A.c(ITEM_NAME, new I(c1447b, 26));
        if (c1447b == null) {
            return;
        }
        setEnabled(c1447b.getConnectionState() == 2);
        boolean zIsSupportGameSound = c1447b.isSupportGameSound();
        this.mSupportGameSound = zIsSupportGameSound;
        if (zIsSupportGameSound) {
            setChecked(c1447b.isMainEnable());
        } else {
            setChecked(c1447b.getStatus() == 1);
        }
    }
}
