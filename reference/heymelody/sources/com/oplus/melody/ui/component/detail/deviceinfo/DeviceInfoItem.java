package com.oplus.melody.ui.component.detail.deviceinfo;

import A9.e;
import D9.a;
import F8.i;
import Wb.l;
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
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import org.json.JSONException;

/* JADX INFO: compiled from: DeviceInfoItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/deviceinfo/DeviceInfoItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeviceInfoItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "DeviceInfoItem";
    private final DetailMainViewModel viewModel;

    /* JADX INFO: compiled from: DeviceInfoItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20662a;

        public b(a aVar) {
            this.f20662a = aVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20662a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws JSONException {
            this.f20662a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.viewModel = viewModel;
        setTitle(R.string.melody_ui_device_info_title);
        setOnPreferenceClickListener(new e(3, this, context));
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new b(new a(this, 15)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(DeviceInfoItem deviceInfoItem, Context context, Preference it) {
        h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/device_info");
        iVarA.f("device_mac_info", deviceInfoItem.viewModel.f20397b);
        iVarA.f("device_name", deviceInfoItem.viewModel.f20398c);
        iVarA.f("product_id", deviceInfoItem.viewModel.f20400e);
        iVarA.f("product_color", String.valueOf(deviceInfoItem.viewModel.f20401f));
        iVarA.b(context);
        DetailMainViewModel detailMainViewModel = deviceInfoItem.viewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.DEVICE_INFO.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(DeviceInfoItem deviceInfoItem, int i10) {
        deviceInfoItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }
}
