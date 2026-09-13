package com.oplus.melody.ui.component.detail.gamemode;

import C6.g;
import D7.C0368b;
import D7.H;
import Ea.K;
import F8.b;
import Kb.j;
import Kb.k;
import Wb.l;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.i;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.v;
import androidx.media3.session.q1;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.btsdk.api.data.GameSoundInfo;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0897c;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyRadioPreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import q9.d;
import s8.AbstractC1508a;

/* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.gamemode.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: GameSetFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010%\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\u001e2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u001cH\u0002J \u00108\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020:H\u0002J(\u0010=\u001a\u00020!2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020:2\u0006\u0010>\u001a\u00020:H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010@2\u0006\u00109\u001a\u00020:H\u0002J\u0012\u0010A\u001a\u0004\u0018\u00010\u00102\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0002J(\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001eH\u0002J \u0010I\u001a\u00020!2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001eH\u0002J\u0018\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J \u0010M\u001a\u00020!2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u001eH\u0002J\u0010\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020:H\u0002J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020:H\u0002J\u0012\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010O\u001a\u00020:H\u0003J\u0010\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020UH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/oplus/melody/ui/component/detail/gamemode/GameSetFragment;", "Lcom/oplus/melody/ui/base/BaseCOUIPreferenceFragment;", "<init>", "()V", "mAddress", "", "mProductId", "mProductName", "mGameSetVM", "Lcom/oplus/melody/ui/component/detail/gamemode/GameSetViewModel;", "mGameModeSwitchPreference", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "mGameLowLatencyCategory", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "mGameLowLatencySwitchPreference", "mGameLowLatencyPreference", "Lcom/coui/appcompat/preference/COUIPreference;", "mGameSoundCategory", "mGameSoundSwitchPreference", "mSetGameModeMainFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "mSetGameSoundFuture", "mSetGameModeFuture", "mGameSoundList", "", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$GameSound;", "mGameSoundInfo", "Lcom/oplus/melody/btsdk/api/data/GameSoundInfo;", "mGameSoundDisabled", "", "mGameLowLatencyDisabled", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "onCreate", "onViewCreated", "view", "Landroid/view/View;", "mRadioPreferenceChangeListener", "Landroidx/preference/Preference$OnPreferenceChangeListener;", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "onGameModeMainStateChanged", "gameModeMainVO", "Lcom/oplus/melody/ui/component/detail/gamemode/GameModeMainVO;", "onGameSoundStateChanged", "gameSoundVO", "Lcom/oplus/melody/ui/component/detail/gamemode/GameSoundVO;", "hasPackagesName", "gameSoundList", "onGameSoundInfoChanged", "info", "updatePreferenceWithPackageName", "index", "", "gameSound", "selectType", "updatePreferenceWithoutPackageName", "realSupportCount", "getGameSoundRadioPreference", "Lcom/oplus/melody/ui/widget/MelodyRadioPreference;", "getGameSoundMelodyPreference", "onGameModeStateChanged", "gameModeVO", "Lcom/oplus/melody/ui/component/detail/gamemode/GameModeVO;", "setGameModeMainEnable", "address", "productId", "enable", "setGameSoundEnable", "getRealSupportTypes", "supportTypes", "", "setGameModeEnable", "getGameSoundTitle", SpeechFindManager.TYPE, "getGameSoundSummary", "getGameSoundIcon", "Landroid/graphics/drawable/Drawable;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GameSetFragment extends b {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public String f21021A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f21022B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public GameSetViewModel f21023C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public COUISwitchPreference f21024D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public COUIPreferenceCategory f21025E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public COUISwitchPreference f21026F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public COUIPreference f21027G;
    public COUIPreferenceCategory H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public COUISwitchPreference f21028I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21029J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21030K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f21031L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public List<WhitelistConfigDTO.GameSound> f21032M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public GameSoundInfo f21033N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f21034O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f21035P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final q1 f21036Q = new q1(this, 22);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f21037z;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.gamemode.a$a */
    /* JADX INFO: compiled from: GameSetFragment.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21038a;

        public a(l lVar) {
            this.f21038a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21038a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21038a.d(obj);
        }
    }

    public final CompletableFuture<SetCommandStateDTO> A(String address, String str, boolean z2) {
        CompletableFuture<SetCommandStateDTO> completableFuture = this.f21029J;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        if (this.f21023C == null) {
            h.i("mGameSetVM");
            throw null;
        }
        h.e(address, "address");
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(40, z2, address);
        h.d(completableFutureE0, "setGameModeMainEnable(...)");
        this.f21029J = completableFutureE0;
        CompletableFuture<Void> completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new C0368b(new q9.f(this, str, address, z2), 25));
        if (completableFutureThenAccept != null) {
            completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new C0940c(29));
        }
        COUIPreferenceCategory cOUIPreferenceCategory = this.H;
        if (cOUIPreferenceCategory == null) {
            h.i("mGameSoundCategory");
            throw null;
        }
        cOUIPreferenceCategory.setEnabled(z2);
        COUIPreferenceCategory cOUIPreferenceCategory2 = this.f21025E;
        if (cOUIPreferenceCategory2 != null) {
            cOUIPreferenceCategory2.setEnabled(z2);
            return this.f21029J;
        }
        h.i("mGameLowLatencyCategory");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad  */
    @Override // androidx.preference.g, androidx.preference.k.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(androidx.preference.Preference r9) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.gamemode.GameSetFragment.f(androidx.preference.Preference):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0242  */
    @Override // androidx.preference.g, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 950
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.gamemode.GameSetFragment.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // F8.b, com.coui.appcompat.preference.g, androidx.preference.g, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        MelodyCompatToolbar melodyCompatToolbar;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        i iVar = (i) getActivity();
        if (iVar == null || (melodyCompatToolbar = (MelodyCompatToolbar) view.findViewById(R.id.tool_bar)) == null) {
            return;
        }
        iVar.y(melodyCompatToolbar);
        androidx.appcompat.app.a aVarX = iVar.x();
        h.b(aVarX);
        aVarX.t(R.string.melody_ui_guide_control_game_mode_title);
        androidx.appcompat.app.a aVarX2 = iVar.x();
        h.b(aVarX2);
        aVarX2.n(true);
        if (C0897c.b(requireActivity()) || C0897c.c(requireActivity())) {
            View viewFindViewById = view.findViewById(android.R.id.list_container);
            h.d(viewFindViewById, "findViewById(...)");
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) viewFindViewById).getLayoutParams();
            h.c(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
            fVar.setMarginStart((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
            fVar.setMarginEnd((int) getResources().getDimension(R.dimen.melody_ui_layout_margin_left_in_magic));
        }
    }

    @Override // com.coui.appcompat.preference.g, androidx.preference.g
    public final void p() {
        o(R.xml.melody_ui_game_set_preference);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final Drawable s(int i10) {
        try {
            if (i10 == 0) {
                return getResources().getDrawable(R.drawable.melody_ui_game_type_close_icon, null);
            }
            if (i10 == 1) {
                return getResources().getDrawable(R.drawable.melody_ui_game_type_peace_icon, null);
            }
            if (i10 != 3) {
                return null;
            }
            return getResources().getDrawable(R.drawable.melody_ui_game_type_3_icon, null);
        } catch (Resources.NotFoundException e10) {
            A.i("GameSetFragment", "getGameSoundIcon", e10);
            return null;
        }
    }

    public final COUIPreference t(int i10) {
        COUIPreferenceCategory cOUIPreferenceCategory = this.H;
        if (cOUIPreferenceCategory == null) {
            h.i("mGameSoundCategory");
            throw null;
        }
        int size = cOUIPreferenceCategory.f11662c.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            COUIPreferenceCategory cOUIPreferenceCategory2 = this.H;
            if (cOUIPreferenceCategory2 == null) {
                h.i("mGameSoundCategory");
                throw null;
            }
            Preference preferenceH = cOUIPreferenceCategory2.h(i12);
            h.d(preferenceH, "getPreference(...)");
            if (preferenceH instanceof COUIPreference) {
                if (i10 == i11) {
                    return (COUIPreference) preferenceH;
                }
                i11++;
            }
        }
        return null;
    }

    public final MelodyRadioPreference u(int i10) {
        COUIPreferenceCategory cOUIPreferenceCategory = this.H;
        if (cOUIPreferenceCategory == null) {
            h.i("mGameSoundCategory");
            throw null;
        }
        int size = cOUIPreferenceCategory.f11662c.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            COUIPreferenceCategory cOUIPreferenceCategory2 = this.H;
            if (cOUIPreferenceCategory2 == null) {
                h.i("mGameSoundCategory");
                throw null;
            }
            Preference preferenceH = cOUIPreferenceCategory2.h(i12);
            h.d(preferenceH, "getPreference(...)");
            if (preferenceH instanceof MelodyRadioPreference) {
                if (i10 == i11) {
                    return (MelodyRadioPreference) preferenceH;
                }
                i11++;
            }
        }
        return null;
    }

    public final String v(int i10) {
        if (i10 == 1) {
            String string = getString(R.string.melody_ui_game_sound_type_peace_summary);
            h.d(string, "getString(...)");
            return string;
        }
        if (i10 != 3) {
            return "";
        }
        String string2 = getString(R.string.melody_ui_game_sound_type_1_summary);
        h.d(string2, "getString(...)");
        return string2;
    }

    public final String w(int i10) {
        if (i10 == 0) {
            String string = getString(R.string.melody_ui_game_sound_type_close);
            h.d(string, "getString(...)");
            return string;
        }
        if (i10 == 1) {
            String string2 = getString(R.string.melody_ui_game_sound_type_peace_title);
            h.d(string2, "getString(...)");
            return string2;
        }
        if (i10 != 3) {
            return "";
        }
        String string3 = getString(R.string.melody_ui_game_sound_type_1_title);
        h.d(string3, "getString(...)");
        return string3;
    }

    public final ArrayList x(int[] iArr) {
        WhitelistConfigDTO.Function function;
        ArrayList arrayList = new ArrayList();
        if (this.f21032M == null) {
            AbstractC1508a abstractC1508aF = AbstractC1508a.f();
            String str = this.f21021A;
            if (str == null) {
                h.i("mProductId");
                throw null;
            }
            String str2 = this.f21022B;
            if (str2 == null) {
                h.i("mProductName");
                throw null;
            }
            WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(str, str2);
            this.f21032M = (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : function.getGameSoundList();
            Jb.l lVar = Jb.l.f2618a;
        }
        List<WhitelistConfigDTO.GameSound> list = this.f21032M;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                WhitelistConfigDTO.GameSound gameSound = (WhitelistConfigDTO.GameSound) obj;
                if (iArr != null && j.Z(iArr, gameSound.getType()) && gameSound.getType() != 0) {
                    arrayList2.add(obj);
                }
            }
            int size = arrayList2.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList2.get(i11);
                i11++;
                int i12 = i10 + 1;
                if (i10 < 0) {
                    Kb.l.h();
                    throw null;
                }
                arrayList.add((WhitelistConfigDTO.GameSound) obj2);
                i10 = i12;
            }
        }
        A.c("GameSetFragment", new g(arrayList, 12));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v10 */
    /* JADX WARN: Type inference failed for: r19v11 */
    /* JADX WARN: Type inference failed for: r19v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r19v6, types: [android.util.AttributeSet, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.util.AttributeSet, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final void y(GameSoundInfo gameSoundInfo) {
        boolean z2;
        ?? r19;
        if (getActivity() == null) {
            return;
        }
        A.c("GameSetFragment", new g9.f(gameSoundInfo, 1));
        this.f21033N = gameSoundInfo;
        boolean z4 = false;
        this.f21034O = gameSoundInfo.getSelectType() == 0;
        String str = this.f21021A;
        ?? r62 = 0;
        if (str == null) {
            h.i("mProductId");
            throw null;
        }
        String str2 = this.f21037z;
        if (str2 == null) {
            h.i("mAddress");
            throw null;
        }
        GameSetViewModel gameSetViewModel = this.f21023C;
        if (gameSetViewModel == null) {
            h.i("mGameSetVM");
            throw null;
        }
        C1264t.t(AppConstant$FunctionType.GAME_SOUND.getFunType(), str, str2, N.t(gameSetViewModel.d(str2)), this.f21034O ? VersionInfo.VENDOR_CODE_DEFAULT_VERSION : BaseHealthModule.TRACK_FATIGUE_REMIND);
        GameSoundInfo gameSoundInfo2 = this.f21033N;
        ArrayList arrayListX = x(gameSoundInfo2 != null ? gameSoundInfo2.getSupportTypes() : null);
        if (arrayListX.isEmpty()) {
            A.h("GameSetFragment", "onGameSoundInfoChanged realSupportTypes is empty");
            return;
        }
        List<WhitelistConfigDTO.GameSound> list = this.f21032M;
        if (list == null) {
            z2 = false;
        } else {
            Iterator<WhitelistConfigDTO.GameSound> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().isPackagesEmpty()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        List<WhitelistConfigDTO.GameSound> list2 = this.f21032M;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                int[] supportTypes = gameSoundInfo.getSupportTypes();
                h.d(supportTypes, "getSupportTypes(...)");
                if (j.Z(supportTypes, ((WhitelistConfigDTO.GameSound) obj).getType())) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = arrayList.get(i11);
                i11++;
                int i12 = i10 + 1;
                if (i10 < 0) {
                    ?? r192 = r62;
                    Kb.l.h();
                    throw r192;
                }
                WhitelistConfigDTO.GameSound gameSound = (WhitelistConfigDTO.GameSound) obj2;
                A.c("GameSetFragment", new O9.h(i10, gameSound, z2));
                q1 q1Var = this.f21036Q;
                if (z2) {
                    int selectType = gameSoundInfo.getSelectType();
                    if (!S.t(getContext())) {
                        MelodyRadioPreference melodyRadioPreferenceU = u(i10);
                        if (melodyRadioPreferenceU == null) {
                            androidx.fragment.app.f fVarRequireActivity = requireActivity();
                            h.d(fVarRequireActivity, "requireActivity(...)");
                            melodyRadioPreferenceU = new MelodyRadioPreference(fVarRequireActivity, r62);
                            melodyRadioPreferenceU.setOnPreferenceChangeListener(q1Var);
                            COUIPreferenceCategory cOUIPreferenceCategory = this.H;
                            if (cOUIPreferenceCategory == null) {
                                h.i("mGameSoundCategory");
                                throw r62;
                            }
                            cOUIPreferenceCategory.e(melodyRadioPreferenceU);
                        }
                        melodyRadioPreferenceU.setTitle(w(gameSound.getType()));
                        melodyRadioPreferenceU.setSummary(v(gameSound.getType()));
                        melodyRadioPreferenceU.setKey(String.valueOf(gameSound.getType()));
                        melodyRadioPreferenceU.setChecked(gameSound.getType() == selectType);
                        melodyRadioPreferenceU.setIcon(s(gameSound.getType()));
                    } else if (gameSound.getType() != 0) {
                        COUIPreference cOUIPreferenceT = t(i10);
                        if (cOUIPreferenceT == null) {
                            cOUIPreferenceT = new COUIPreference(requireActivity());
                            cOUIPreferenceT.setBackgroundAnimationEnabled(z4);
                            COUIPreferenceCategory cOUIPreferenceCategory2 = this.H;
                            if (cOUIPreferenceCategory2 == null) {
                                h.i("mGameSoundCategory");
                                throw r62;
                            }
                            cOUIPreferenceCategory2.e(cOUIPreferenceT);
                        }
                        cOUIPreferenceT.setTitle(w(gameSound.getType()));
                        cOUIPreferenceT.setSummary(v(gameSound.getType()));
                        cOUIPreferenceT.setKey(String.valueOf(gameSound.getType()));
                        COUISwitchPreference cOUISwitchPreference = this.f21028I;
                        if (cOUISwitchPreference == null) {
                            h.i("mGameSoundSwitchPreference");
                            throw r62;
                        }
                        cOUIPreferenceT.setEnabled(cOUISwitchPreference.isChecked());
                        cOUIPreferenceT.setIcon(s(gameSound.getType()));
                    }
                } else {
                    int selectType2 = gameSoundInfo.getSelectType();
                    int size2 = arrayListX.size();
                    if (!S.t(getContext()) || gameSound.getType() != 0) {
                        r19 = r62;
                        if (size2 != 1 || gameSound.getType() == 0) {
                            MelodyRadioPreference melodyRadioPreferenceU2 = u(i10);
                            if (melodyRadioPreferenceU2 == null) {
                                androidx.fragment.app.f fVarRequireActivity2 = requireActivity();
                                h.d(fVarRequireActivity2, "requireActivity(...)");
                                melodyRadioPreferenceU2 = new MelodyRadioPreference(fVarRequireActivity2, r19);
                                melodyRadioPreferenceU2.setOnPreferenceChangeListener(q1Var);
                                COUIPreferenceCategory cOUIPreferenceCategory3 = this.H;
                                if (cOUIPreferenceCategory3 == null) {
                                    h.i("mGameSoundCategory");
                                    throw r19;
                                }
                                cOUIPreferenceCategory3.e(melodyRadioPreferenceU2);
                            }
                            melodyRadioPreferenceU2.setTitle(w(gameSound.getType()));
                            melodyRadioPreferenceU2.setSummary(v(gameSound.getType()));
                            melodyRadioPreferenceU2.setKey(String.valueOf(gameSound.getType()));
                            melodyRadioPreferenceU2.setChecked(gameSound.getType() == selectType2);
                            melodyRadioPreferenceU2.setIcon(s(gameSound.getType()));
                            if (S.t(getContext())) {
                                COUISwitchPreference cOUISwitchPreference2 = this.f21028I;
                                if (cOUISwitchPreference2 == null) {
                                    h.i("mGameSoundSwitchPreference");
                                    throw null;
                                }
                                melodyRadioPreferenceU2.setEnabled(cOUISwitchPreference2.isChecked());
                            }
                            r19 = 0;
                        } else {
                            COUIPreference cOUIPreferenceT2 = t(i10);
                            if (cOUIPreferenceT2 == null) {
                                cOUIPreferenceT2 = new COUIPreference(requireActivity());
                                cOUIPreferenceT2.setBackgroundAnimationEnabled(false);
                                COUIPreferenceCategory cOUIPreferenceCategory4 = this.H;
                                if (cOUIPreferenceCategory4 == null) {
                                    h.i("mGameSoundCategory");
                                    throw r19;
                                }
                                cOUIPreferenceCategory4.e(cOUIPreferenceT2);
                            }
                            cOUIPreferenceT2.setTitle(w(gameSound.getType()));
                            cOUIPreferenceT2.setSummary(v(gameSound.getType()));
                            cOUIPreferenceT2.setKey(String.valueOf(gameSound.getType()));
                            COUISwitchPreference cOUISwitchPreference3 = this.f21028I;
                            if (cOUISwitchPreference3 == null) {
                                h.i("mGameSoundSwitchPreference");
                                throw r19;
                            }
                            cOUIPreferenceT2.setEnabled(cOUISwitchPreference3.isChecked());
                            cOUIPreferenceT2.setIcon(s(gameSound.getType()));
                        }
                    }
                    i10 = i12;
                    r62 = r19;
                    z4 = false;
                }
                r19 = r62;
                i10 = i12;
                r62 = r19;
                z4 = false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    public final void z(String address, String str, final boolean z2) {
        Object objB;
        int[] supportTypes;
        A.c("GameSetFragment", new K(z2, this, 9));
        if (z2 || !this.f21034O) {
            CompletableFuture<SetCommandStateDTO> completableFuture = this.f21031L;
            if (completableFuture != null) {
                completableFuture.cancel(true);
            }
            if (this.f21023C == null) {
                h.i("mGameSetVM");
                throw null;
            }
            h.e(address, "address");
            CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(6, z2, address);
            h.d(completableFutureE0, "setGameModeStatus(...)");
            this.f21031L = completableFutureE0;
            CompletableFuture<Void> completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new H(new d(this, str, address, z2), 29));
            if (completableFutureThenAccept != null) {
                completableFutureThenAccept.exceptionally(new Function() { // from class: q9.e
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        A.i("GameSetFragment", "setGameModeEnable enable:" + z2, (Throwable) obj);
                        return null;
                    }
                });
                return;
            }
            return;
        }
        A(address, str, false);
        GameSoundInfo gameSoundInfo = this.f21033N;
        ArrayList arrayListX = x(gameSoundInfo != null ? gameSoundInfo.getSupportTypes() : null);
        GameSoundInfo gameSoundInfo2 = this.f21033N;
        if (gameSoundInfo2 == null || (supportTypes = gameSoundInfo2.getSupportTypes()) == null) {
            objB = 0;
        } else {
            int length = supportTypes.length;
            if (length == 0) {
                objB = EmptyList.f25350a;
            } else if (length != 1) {
                objB = new ArrayList(supportTypes.length);
                for (int i10 : supportTypes) {
                    objB.add(Integer.valueOf(i10));
                }
            } else {
                objB = k.b(Integer.valueOf(supportTypes[0]));
            }
        }
        Objects.toString(objB);
        arrayListX.toString();
        if (!arrayListX.isEmpty() && ((WhitelistConfigDTO.GameSound) arrayListX.get(0)).getType() != 0) {
            GameSetViewModel gameSetViewModel = this.f21023C;
            if (gameSetViewModel == null) {
                h.i("mGameSetVM");
                throw null;
            }
            String str2 = this.f21037z;
            if (str2 == null) {
                h.i("mAddress");
                throw null;
            }
            gameSetViewModel.h(((WhitelistConfigDTO.GameSound) arrayListX.get(0)).getType(), str2);
        }
        COUISwitchPreference cOUISwitchPreference = this.f21026F;
        if (cOUISwitchPreference == null) {
            h.i("mGameLowLatencySwitchPreference");
            throw null;
        }
        cOUISwitchPreference.setChecked(true);
    }
}
