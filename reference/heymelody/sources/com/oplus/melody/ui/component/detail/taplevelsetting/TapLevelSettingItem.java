package com.oplus.melody.ui.component.detail.taplevelsetting;

import B9.d;
import E9.u;
import F8.i;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: TapLevelSettingItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/taplevelsetting/TapLevelSettingItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TapLevelSettingItem extends MelodyUiCOUIJumpPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "TapLevelSettingItem";
    public static final String TAG = "TapLevelSettingItem";

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.taplevelsetting.TapLevelSettingItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TapLevelSettingItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: TapLevelSettingItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f21299a;

        public b(d dVar) {
            this.f21299a = dVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21299a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Throwable {
            this.f21299a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapLevelSettingItem(Context context, MoreSettingViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_tap_level_setting_title);
        setSummary(context.getString(R.string.melody_ui_tap_level_setting_summary));
        setOnPreferenceClickListener(new u(2, viewModel, context));
        viewModel.d(viewModel.f21136b).e(lifecycleOwner, new b(new d(this, 18)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(MoreSettingViewModel moreSettingViewModel, Context context, Preference it) {
        h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/tap_level_setting");
        iVarA.f("device_mac_info", moreSettingViewModel.f21136b);
        iVarA.f("device_name", moreSettingViewModel.f21138d);
        String str = moreSettingViewModel.f21137c;
        iVarA.f("product_id", str);
        iVarA.f("product_color", moreSettingViewModel.f21139e);
        iVarA.b(context);
        String str2 = moreSettingViewModel.f21136b;
        C1264t.t(AppConstant$FunctionType.TAP_LEVEL_SETTING.getFunType(), str, str2, N.t(moreSettingViewModel.e(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(TapLevelSettingItem tapLevelSettingItem, int i10) {
        tapLevelSettingItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }
}
