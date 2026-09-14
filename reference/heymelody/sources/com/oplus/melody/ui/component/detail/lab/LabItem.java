package com.oplus.melody.ui.component.detail.lab;

import F8.i;
import Ha.c;
import Jb.a;
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
import r9.C1479c;

/* JADX INFO: compiled from: LabItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/oplus/melody/ui/component/detail/lab/LabItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LabItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "LabItem";
    private InterfaceC0601m mLifecycleOwner;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: compiled from: LabItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1479c f21114a;

        public b(C1479c c1479c) {
            this.f21114a = c1479c;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21114a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21114a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mLifecycleOwner = lifecycleOwner;
        this.mViewModel = viewModel;
        setTitle(R.string.melody_ui_lab_title_new);
        setOnPreferenceClickListener(new c(15, this, context));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.d(detailMainViewModel.f20397b).e(lifecycleOwner, new b(new C1479c(this, 5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(LabItem labItem, Context context, Preference it) {
        h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/lab");
        iVarA.f("device_mac_info", labItem.mViewModel.f20397b);
        iVarA.f("device_name", labItem.mViewModel.f20398c);
        iVarA.f("product_id", labItem.mViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(labItem.mViewModel.f20401f));
        iVarA.b(context);
        DetailMainViewModel detailMainViewModel = labItem.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.LAB.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(LabItem labItem, Integer num) {
        labItem.setEnabled(num != null && num.intValue() == 2);
        return Jb.l.f2618a;
    }
}
