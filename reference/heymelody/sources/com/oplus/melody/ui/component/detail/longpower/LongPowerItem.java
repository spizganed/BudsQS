package com.oplus.melody.ui.component.detail.longpower;

import D7.C0368b;
import D7.C0379m;
import D7.o0;
import E9.i;
import Jb.a;
import Wb.l;
import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.google.android.material.internal.e;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import g9.s;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import r9.C1479c;
import z9.C1729a;

/* JADX INFO: compiled from: LongPowerItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/ui/component/detail/longpower/LongPowerItem;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "showConfirmDialog", "", "checked", "", "onLongPowerModeChanged", "vo", "Lcom/oplus/melody/ui/component/detail/longpower/LongPowerVO;", "setLongPowerModeEnable", "enable", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LongPowerItem extends COUISwitchPreference {
    public static final String ITEM_NAME = "SavePowerItem";
    public static final String TAG = "SavePowerItem";
    private InterfaceC0601m mLifecycleOwner;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.longpower.LongPowerItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: LongPowerItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<C1729a, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(C1729a c1729a) {
            C1729a p02 = c1729a;
            h.e(p02, "p0");
            ((LongPowerItem) this.receiver).onLongPowerModeChanged(p02);
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: compiled from: LongPowerItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21115a;

        public b(l lVar) {
            this.f21115a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21115a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21115a.d(obj);
        }
    }

    /* JADX INFO: compiled from: LongPowerItem.kt */
    public static final class c implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f21117b;

        public c(boolean z2) {
            this.f21117b = z2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i10) {
            LongPowerItem.this.setLongPowerModeEnable(this.f21117b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongPowerItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mViewModel = viewModel;
        this.mLifecycleOwner = lifecycleOwner;
        setTitle(R.string.melody_common_save_power_mode_title);
        setSummary(R.string.melody_common_save_power_mode_summary);
        setOnPreferenceChangeListener(new s(this, 7));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new A6.f(12))).e(this.mLifecycleOwner, new b(new AnonymousClass2(1, this, LongPowerItem.class, "onLongPowerModeChanged", "onLongPowerModeChanged(Lcom/oplus/melody/ui/component/detail/longpower/LongPowerVO;)V", 0)));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(this.mLifecycleOwner, new b(new C1479c(this, 6)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(LongPowerItem longPowerItem, Preference preference, Object obj) {
        h.e(preference, "preference");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        longPowerItem.showConfirmDialog(((Boolean) obj).booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(LongPowerItem longPowerItem, Integer num) {
        longPowerItem.setEnabled(num != null && num.intValue() == 2);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLongPowerModeChanged(C1729a c1729a) {
        if (c1729a.isConnected()) {
            setChecked(c1729a.isSavePowerModeEnable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLongPowerModeEnable(boolean enable) {
        CompletableFuture<Void> completableFutureThenAccept;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(23, enable, this.mViewModel.f20397b);
        this.mSetCommandFuture = completableFutureE0;
        if (completableFutureE0 == null || (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new C0368b(new W8.a(this, enable, 1), 28))) == null) {
            return;
        }
        completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new W8.b(this, enable, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l setLongPowerModeEnable$lambda$0(LongPowerItem longPowerItem, boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
            o0.d(new i(longPowerItem, z2, 4));
            A.b("SavePowerItem", "set save power mode failed");
        } else {
            A.b("SavePowerItem", "set save power mode succeed");
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLongPowerModeEnable$lambda$0$0(LongPowerItem longPowerItem, boolean z2) {
        longPowerItem.setChecked(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setLongPowerModeEnable$lambda$2(LongPowerItem longPowerItem, boolean z2, Throwable th) {
        o0.d(new e(longPowerItem, z2, 6));
        A.i("SavePowerItem", "set save power mode", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLongPowerModeEnable$lambda$2$0(LongPowerItem longPowerItem, boolean z2) {
        longPowerItem.setChecked(!z2);
    }

    private final void showConfirmDialog(boolean checked) {
        int i10 = checked ? R.string.melody_common_dialog_save_power_open_title : R.string.melody_common_dialog_save_power_close_title;
        int i11 = checked ? R.string.melody_common_open_save_power_mode_dialog_title : R.string.melody_common_close_save_power_mode_dialog_title;
        int i12 = checked ? R.string.melody_ui_multi_devices_dialog_open : R.string.melody_ui_multi_devices_dialog_close;
        Context context = getContext();
        h.d(context, "getContext(...)");
        G7.b bVar = new G7.b(context);
        bVar.n(i10);
        bVar.f(i11);
        bVar.h(R.string.melody_ui_common_cancel, new T9.a(this, checked, 3));
        bVar.l(i12, new c(checked));
        androidx.appcompat.app.f fVarCreate = bVar.setCancelable(false).create();
        h.d(fVarCreate, "create(...)");
        fVarCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmDialog$lambda$0(LongPowerItem longPowerItem, boolean z2, DialogInterface dialogInterface, int i10) {
        longPowerItem.setChecked(!z2);
        dialogInterface.dismiss();
    }
}
