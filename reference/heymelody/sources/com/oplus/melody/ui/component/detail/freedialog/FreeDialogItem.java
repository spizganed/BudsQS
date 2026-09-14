package com.oplus.melody.ui.component.detail.freedialog;

import D7.C0379m;
import D7.o0;
import E9.q;
import T8.e;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.AbsItem;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.freedialog.FreeDialogPanelFragment;
import com.oplus.melody.ui.component.detail.freedialog.c;
import com.oplus.melody.ui.widget.MelodyUiCOUISwitchPreference;
import e9.C1020d;
import g9.o;
import g9.s;
import g9.t;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import n9.C1355a;

/* JADX INFO: compiled from: FreeDialogItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/oplus/melody/ui/component/detail/freedialog/FreeDialogItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mContext", "mViewModel", "mLifecycleOwner", "mBottomSheetDialogFragment", "Lcom/coui/appcompat/panel/COUIBottomSheetDialogFragment;", "mPanelFragment", "Lcom/oplus/melody/ui/component/detail/freedialog/FreeDialogPanelFragment;", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "mLastSummary", "", "onFreeDialogModeChanged", "", "vo", "Lcom/oplus/melody/ui/component/detail/freedialog/FreeDialogVO;", "showPanel", "setFreeDialogModeEnable", "enable", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FreeDialogItem extends MelodyUiCOUISwitchPreference {
    public static final String ITEM_NAME = "FreeDialogItem";
    public static final String TAG = "FreeDialogItem";
    private COUIBottomSheetDialogFragment mBottomSheetDialogFragment;
    private Context mContext;
    private CharSequence mLastSummary;
    private InterfaceC0601m mLifecycleOwner;
    private FreeDialogPanelFragment mPanelFragment;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.freedialog.FreeDialogItem$4, reason: invalid class name */
    /* JADX INFO: compiled from: FreeDialogItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements l<C1355a, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(C1355a c1355a) {
            C1355a p02 = c1355a;
            h.e(p02, "p0");
            ((FreeDialogItem) this.receiver).onFreeDialogModeChanged(p02);
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: compiled from: FreeDialogItem.kt */
    public static final class a implements FreeDialogPanelFragment.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f21009b;

        public a(Context context) {
            this.f21009b = context;
        }

        @Override // com.oplus.melody.ui.component.detail.freedialog.FreeDialogPanelFragment.a
        public final void a(c.a aVar) {
            FreeDialogItem freeDialogItem = FreeDialogItem.this;
            if (freeDialogItem.isChecked()) {
                if (aVar == null || aVar.f21017a != 0) {
                    string = freeDialogItem.mContext.getString(R.string.melody_common_smart_call_recovery_time, aVar != null ? aVar.f21018b : null);
                } else if (aVar != null) {
                    string = aVar.f21018b;
                }
                freeDialogItem.setSummary(string);
                freeDialogItem.setSummaryTextColor(o.g(this.f21009b, R.attr.couiColorPrimary));
            }
            COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = freeDialogItem.mBottomSheetDialogFragment;
            h.b(cOUIBottomSheetDialogFragment);
            cOUIBottomSheetDialogFragment.dismiss();
        }

        @Override // com.oplus.melody.ui.component.detail.freedialog.FreeDialogPanelFragment.a
        public final void b() {
            A.b("FreeDialogItem", "OnItemSelectFailed:");
            FreeDialogItem freeDialogItem = FreeDialogItem.this;
            freeDialogItem.setSummary(freeDialogItem.mLastSummary);
        }
    }

    /* JADX INFO: compiled from: FreeDialogItem.kt */
    public static final class c implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21010a;

        public c(l lVar) {
            this.f21010a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21010a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21010a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FreeDialogItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mContext = context;
        this.mViewModel = viewModel;
        this.mLifecycleOwner = lifecycleOwner;
        FreeDialogPanelFragment freeDialogPanelFragment = new FreeDialogPanelFragment();
        this.mPanelFragment = freeDialogPanelFragment;
        freeDialogPanelFragment.r(this.mContext);
        FreeDialogPanelFragment freeDialogPanelFragment2 = this.mPanelFragment;
        if (freeDialogPanelFragment2 != null) {
            freeDialogPanelFragment2.v(this.mViewModel);
        }
        FreeDialogPanelFragment freeDialogPanelFragment3 = this.mPanelFragment;
        if (freeDialogPanelFragment3 != null) {
            freeDialogPanelFragment3.u(new a(context));
        }
        setTitle(R.string.melody_common_smart_call_title);
        setSummary(R.string.melody_common_smart_call_summary);
        setOnPreferenceClickListener(new s(this, 1));
        setOnPreferenceChangeListener(new t(this, 4));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new A6.b(17))).e(this.mLifecycleOwner, new c(new AnonymousClass4(1, this, FreeDialogItem.class, "onFreeDialogModeChanged", "onFreeDialogModeChanged(Lcom/oplus/melody/ui/component/detail/freedialog/FreeDialogVO;)V", 0)));
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new c(new C1020d(this, 4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(FreeDialogItem freeDialogItem, Preference it) {
        h.e(it, "it");
        if (!freeDialogItem.isChecked()) {
            return false;
        }
        freeDialogItem.showPanel();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(FreeDialogItem freeDialogItem, Preference preference, Object obj) {
        h.e(preference, "preference");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        freeDialogItem.setFreeDialogModeEnable(((Boolean) obj).booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(FreeDialogItem freeDialogItem, int i10) {
        freeDialogItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFreeDialogModeChanged(C1355a c1355a) {
        FreeDialogPanelFragment freeDialogPanelFragment = this.mPanelFragment;
        if (freeDialogPanelFragment != null) {
            freeDialogPanelFragment.t(c1355a.getFullDialogRecoveryTime());
        }
        setChecked(c1355a.isFreeDialogEnable());
        FreeDialogPanelFragment freeDialogPanelFragment2 = this.mPanelFragment;
        String strQ = freeDialogPanelFragment2 != null ? freeDialogPanelFragment2.q() : null;
        if (TextUtils.isEmpty(strQ) || !c1355a.isFreeDialogEnable()) {
            setSummary(this.mContext.getString(R.string.melody_common_smart_call_summary));
            setSummaryTextColor(this.mContext.getColor(R.color.melody_ui_jump_pref_text_color_gray));
        } else {
            if (c1355a.getFullDialogRecoveryTime() != 0) {
                setSummary(this.mContext.getString(R.string.melody_common_smart_call_recovery_time, strQ));
            } else {
                setSummary(strQ);
            }
            setSummaryTextColor(o.g(this.mContext, R.attr.couiColorPrimary));
        }
        this.mLastSummary = getSummary();
    }

    private final void setFreeDialogModeEnable(boolean enable) {
        CompletableFuture<Void> completableFutureThenAccept;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(21, enable, this.mViewModel.f20397b);
        this.mSetCommandFuture = completableFutureE0;
        if (completableFutureE0 == null || (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new q(new S8.b(this, enable, 3), 19))) == null) {
            return;
        }
        completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new com.oplus.melody.ui.component.detail.voiceassist.a(this, enable, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l setFreeDialogModeEnable$lambda$0(FreeDialogItem freeDialogItem, boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
            o0.d(new e(freeDialogItem, z2, 7));
            A.b("FreeDialogItem", "set free dialog mode failed");
        } else {
            A.b("FreeDialogItem", "set free dialog mode succeed");
            DetailMainViewModel detailMainViewModel = freeDialogItem.mViewModel;
            AbstractC0939b.E().T(freeDialogItem.mContext, detailMainViewModel.f20397b);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFreeDialogModeEnable$lambda$0$0(FreeDialogItem freeDialogItem, boolean z2) {
        freeDialogItem.setChecked(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setFreeDialogModeEnable$lambda$2(FreeDialogItem freeDialogItem, boolean z2, Throwable th) {
        o0.d(new com.google.android.material.internal.e(freeDialogItem, z2, 4));
        A.i("FreeDialogItem", "set free dialog mode", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFreeDialogModeEnable$lambda$2$0(FreeDialogItem freeDialogItem, boolean z2) {
        freeDialogItem.setChecked(!z2);
    }

    private final void showPanel() {
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment;
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2;
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment3 = this.mBottomSheetDialogFragment;
        if (cOUIBottomSheetDialogFragment3 != null) {
            h.b(cOUIBottomSheetDialogFragment3);
            if (cOUIBottomSheetDialogFragment3.isAdded() && (cOUIBottomSheetDialogFragment2 = this.mBottomSheetDialogFragment) != null) {
                cOUIBottomSheetDialogFragment2.dismiss();
            }
        }
        FragmentManager fragmentManagerJ = this.mViewModel.j();
        if (fragmentManagerJ != null) {
            cOUIBottomSheetDialogFragment = new COUIBottomSheetDialogFragment();
            cOUIBottomSheetDialogFragment.setMainPanelFragment(this.mPanelFragment);
            cOUIBottomSheetDialogFragment.show(fragmentManagerJ, AbsItem.DIALOG_FRAGMENT_TAG);
        } else {
            cOUIBottomSheetDialogFragment = null;
        }
        this.mBottomSheetDialogFragment = cOUIBottomSheetDialogFragment;
    }
}
