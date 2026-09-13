package com.oplus.melody.ui.component.detail.swiftpair;

import A6.e;
import A9.j;
import D7.C0379m;
import E8.c;
import Jb.a;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SwiftPairItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/swiftpair/SwiftPairItem;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SwiftPairItem extends COUISwitchPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "SwiftPairItem";

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.swiftpair.SwiftPairItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SwiftPairItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: SwiftPairItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21298a;

        public b(l lVar) {
            this.f21298a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21298a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21298a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwiftPairItem(Context context, MoreSettingViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_swift_pair_switch_title);
        setSummary(R.string.melody_ui_swift_pair_switch_summary);
        String address = viewModel.f21136b;
        h.e(address, "address");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(address), new e(6))).e(lifecycleOwner, new b(new j(this, 16)));
        setOnPreferenceChangeListener(new U9.a(viewModel, 0));
        viewModel.d(address).e(lifecycleOwner, new b(new D9.a(this, 11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final Jb.l _init_$lambda$0(com.oplus.melody.ui.component.detail.swiftpair.SwiftPairItem r1, java.lang.Integer r2) {
        /*
            if (r2 != 0) goto L3
            goto Lb
        L3:
            int r2 = r2.intValue()
            r0 = 1
            if (r2 != r0) goto Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            r1.setChecked(r0)
            Jb.l r1 = Jb.l.f2618a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.swiftpair.SwiftPairItem._init_$lambda$0(com.oplus.melody.ui.component.detail.swiftpair.SwiftPairItem, java.lang.Integer):Jb.l");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(MoreSettingViewModel moreSettingViewModel, Preference preference, Object obj) {
        h.e(preference, "<unused var>");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        String address = moreSettingViewModel.f21136b;
        h.e(address, "address");
        CompletableFuture completableFutureE0 = AbstractC0939b.E().E0(55, zBooleanValue, address);
        h.d(completableFutureE0, "setSwiftPairStatus(...)");
        completableFutureE0.whenComplete((BiConsumer) new B9.b(new c(8), 17));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1$0(SetCommandStateDTO setCommandStateDTO, Throwable th) {
        A.c(ITEM_NAME, new B6.f(2, setCommandStateDTO));
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1$0$0(SetCommandStateDTO setCommandStateDTO) {
        return A6.b.d(setCommandStateDTO.getSetCommandStatus(), "setSwiftPairEnable result:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(SwiftPairItem swiftPairItem, int i10) {
        swiftPairItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }
}
