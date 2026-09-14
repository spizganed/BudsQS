package com.oplus.melody.ui.component.detail.weardetection;

import A9.q;
import D7.C0379m;
import D7.e0;
import D7.o0;
import D7.q0;
import Jb.a;
import Wb.l;
import Wb.p;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.component.detail.weardetection.SmartPlayItem;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SmartPlayItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/weardetection/SmartPlayItem;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SmartPlayItem extends COUISwitchPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "SmartPlayItem";
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.weardetection.SmartPlayItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SmartPlayItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: SmartPlayItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21390a;

        public b(l lVar) {
            this.f21390a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21390a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21390a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartPlayItem(Context context, MoreSettingViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_wear_detection_smart_pause_title);
        setSummary(R.string.melody_ui_wear_detection_smart_pause_summary);
        String macAddress = viewModel.f21136b;
        h.e(macAddress, "macAddress");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new A6.f(6))).e(lifecycleOwner, new b(new D9.a(this, 16)));
        viewModel.d(macAddress).e(lifecycleOwner, new b(new Aa.b(this, 26)));
        setOnPreferenceChangeListener(new e0(this, viewModel, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final Jb.l _init_$lambda$0(com.oplus.melody.ui.component.detail.weardetection.SmartPlayItem r2, java.lang.Integer r3) {
        /*
            L8.A r0 = new L8.A
            r1 = 1
            r0.<init>(r1, r3)
            java.lang.String r1 = "SmartPlayItem"
            com.oplus.melody.common.util.A.c(r1, r0)
            if (r3 != 0) goto Le
            goto L16
        Le:
            int r3 = r3.intValue()
            r0 = 1
            if (r3 != r0) goto L16
            goto L17
        L16:
            r0 = 0
        L17:
            r2.setChecked(r0)
            Jb.l r2 = Jb.l.f2618a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.weardetection.SmartPlayItem._init_$lambda$0(com.oplus.melody.ui.component.detail.weardetection.SmartPlayItem, java.lang.Integer):Jb.l");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0$0(Integer num) {
        return "wearDetectionStatusChanged:" + num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(SmartPlayItem smartPlayItem, Integer num) {
        smartPlayItem.setEnabled(num != null && num.intValue() == 2);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(final SmartPlayItem smartPlayItem, final MoreSettingViewModel moreSettingViewModel, final Context context, Preference preference, Object obj) {
        h.e(preference, "<unused var>");
        CompletableFuture<SetCommandStateDTO> completableFuture = smartPlayItem.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        final boolean zBooleanValue = ((Boolean) obj).booleanValue();
        String address = moreSettingViewModel.f21136b;
        h.e(address, "address");
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(4, zBooleanValue, address);
        h.d(completableFutureE0, "setWearDetectionStatus(...)");
        smartPlayItem.mSetCommandFuture = completableFutureE0;
        new q0(smartPlayItem.mSetCommandFuture).whenCompleteAsync((BiConsumer) new q(new p() { // from class: Y9.d
            @Override // Wb.p
            public final Object invoke(Object obj2, Object obj3) {
                MoreSettingViewModel moreSettingViewModel2 = moreSettingViewModel;
                SmartPlayItem smartPlayItem2 = smartPlayItem;
                boolean z2 = zBooleanValue;
                return SmartPlayItem._init_$lambda$2$0(moreSettingViewModel2, context, smartPlayItem2, z2, (SetCommandStateDTO) obj2, (Throwable) obj3);
            }
        }, 9), (Executor) o0.c.f1144b);
        String str = moreSettingViewModel.f21136b;
        String strT = N.t(moreSettingViewModel.e(str));
        C1264t.z(zBooleanValue ? 1 : 0, 0, moreSettingViewModel.f21137c, str, strT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2$0(MoreSettingViewModel moreSettingViewModel, Context context, SmartPlayItem smartPlayItem, boolean z2, SetCommandStateDTO setCommandStateDTO, Throwable th) {
        Activity activity;
        if (th != null || setCommandStateDTO == null || (TextUtils.equals(moreSettingViewModel.f21136b, setCommandStateDTO.getAddress()) && setCommandStateDTO.getSetCommandStatus() != 0)) {
            A.g(ITEM_NAME, "set wear detection failed " + setCommandStateDTO, th);
            h.c(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity2 = (Activity) context;
            Context baseContext = activity2;
            while (true) {
                activity = null;
                if (!(baseContext instanceof ContextWrapper)) {
                    break;
                }
                if (!Activity.class.isInstance(baseContext)) {
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                } else if (baseContext instanceof Activity) {
                    activity = (Activity) baseContext;
                }
            }
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                smartPlayItem.setChecked(!z2);
                if (setCommandStateDTO != null && setCommandStateDTO.getSetCommandStatus() == 14) {
                    Toast.makeText(activity2, R.string.melody_ui_detail_main_need_wear_earphone2, 0).show();
                } else if (!(th instanceof CancellationException)) {
                    Toast.makeText(activity2, R.string.melody_ui_detail_main_set_noise_reduction_failed, 0).show();
                }
            }
        } else {
            A.b(ITEM_NAME, "set wear detection successful");
            String address = moreSettingViewModel.f21136b;
            if (z2) {
                AbstractC0939b.E().h0(N.n(moreSettingViewModel.e(address)) ? 1 : 0, address);
            } else {
                h.e(address, "address");
                AbstractC0939b.E().h0(0, address);
            }
        }
        return Jb.l.f2618a;
    }
}
