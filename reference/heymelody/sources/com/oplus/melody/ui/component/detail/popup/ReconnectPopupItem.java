package com.oplus.melody.ui.component.detail.popup;

import A6.g;
import B9.d;
import D7.C0379m;
import Jb.a;
import R1.e;
import Wb.l;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.component.detail.popup.ReconnectPopupItem;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ReconnectPopupItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/oplus/melody/ui/component/detail/popup/ReconnectPopupItem;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReconnectPopupItem extends COUISwitchPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "ReconnectPopupItem";
    private f mAlertDialog;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.popup.ReconnectPopupItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ReconnectPopupItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: ReconnectPopupItem.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21207a;

        public b(l lVar) {
            this.f21207a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21207a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21207a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReconnectPopupItem(Context context, MoreSettingViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_reconnect_popup_switch_title);
        setSummary(R.string.melody_ui_reconnect_popup_switch_summary);
        String address = viewModel.f21136b;
        h.e(address, "address");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new g(4))).e(lifecycleOwner, new b(new d(this, 5)));
        setOnPreferenceChangeListener(new H9.a(this, context, viewModel, 0));
        viewModel.f(address).e(lifecycleOwner, new b(new Aa.b(this, 4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$0(ReconnectPopupItem reconnectPopupItem, Integer num) {
        reconnectPopupItem.setChecked(num == null || num.intValue() != 0);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(final ReconnectPopupItem reconnectPopupItem, Context context, final MoreSettingViewModel moreSettingViewModel, Preference preference, Object obj) {
        h.e(preference, "<unused var>");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        final boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue) {
            String address = moreSettingViewModel.f21136b;
            h.e(address, "address");
            AbstractC0939b.E().A0(zBooleanValue ? 1 : 0, address);
            return false;
        }
        e eVar = new e(context);
        eVar.n(R.string.melody_ui_long_press_volume_notice_title);
        eVar.f(R.string.melody_ui_reconnect_popup_disable_hint);
        eVar.h(R.string.melody_ui_common_cancel, null);
        eVar.l(R.string.melody_ui_common_confirm, new DialogInterface.OnClickListener() { // from class: H9.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ReconnectPopupItem._init_$lambda$1$0(this.f2093a, moreSettingViewModel, zBooleanValue, dialogInterface, i10);
            }
        });
        reconnectPopupItem.mAlertDialog = eVar.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1$0(ReconnectPopupItem reconnectPopupItem, MoreSettingViewModel moreSettingViewModel, boolean z2, DialogInterface dialogInterface, int i10) {
        reconnectPopupItem.setChecked(false);
        String address = moreSettingViewModel.f21136b;
        h.e(address, "address");
        AbstractC0939b.E().A0(z2 ? 1 : 0, address);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(ReconnectPopupItem reconnectPopupItem, int i10) {
        f fVar;
        reconnectPopupItem.setEnabled(i10 == 2);
        if (!reconnectPopupItem.isEnabled() && (fVar = reconnectPopupItem.mAlertDialog) != null && fVar.isShowing()) {
            fVar.dismiss();
        }
        return Jb.l.f2618a;
    }
}
