package com.oplus.melody.ui.component.detail.voiceassist;

import F8.i;
import a9.C0531H;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;

/* JADX INFO: compiled from: VoiceCommandItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceCommandItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VoiceCommandItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "VoiceCommandItem";
    public static final String TAG = "VoiceCommandItem";
    private InterfaceC0601m lifecycleOwner;
    private DetailMainViewModel viewModel;

    /* JADX INFO: compiled from: VoiceCommandItem.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0531H f21348a;

        public b(C0531H c0531h) {
            this.f21348a = c0531h;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return kotlin.jvm.internal.h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21348a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21348a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceCommandItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        kotlin.jvm.internal.h.e(context, "context");
        kotlin.jvm.internal.h.e(viewModel, "viewModel");
        kotlin.jvm.internal.h.e(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        this.viewModel = viewModel;
        setTitle(R.string.melody_common_voice_wake_pref_order_title);
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new b(new C0531H(this, 10)));
        setOnPreferenceClickListener(new P8.c(viewModel, context, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$0(VoiceCommandItem voiceCommandItem, Integer num) {
        voiceCommandItem.setEnabled(num != null && num.intValue() == 2);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(DetailMainViewModel detailMainViewModel, Context context, Preference it) {
        kotlin.jvm.internal.h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
        F8.i iVarA = i.a.a("/ui/voice_assist/voice_command");
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("device_name", detailMainViewModel.f20398c);
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(detailMainViewModel.f20401f));
        iVarA.b(context);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.VOICE_COMMAND.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }
}
