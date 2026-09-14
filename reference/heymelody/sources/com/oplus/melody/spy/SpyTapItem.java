package com.oplus.melody.spy;

import E9.u;
import F8.i;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.base.DetailBaseViewModel;
import e9.C1020d;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpyTapItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/oplus/melody/spy/SpyTapItem;", "Lcom/coui/appcompat/preference/COUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/base/DetailBaseViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/base/DetailBaseViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "spy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpyTapItem extends COUIJumpPreference {
    public static final String ITEM_NAME = "SpyTapItem";
    private final DetailBaseViewModel viewModel;

    /* JADX INFO: compiled from: SpyTapItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1020d f20235a;

        public b(C1020d c1020d) {
            this.f20235a = c1020d;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20235a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20235a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpyTapItem(Context context, DetailBaseViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.viewModel = viewModel;
        setTitle(R.string.melody_spy_tap_title);
        setOnPreferenceClickListener(new u(21, this, context));
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new b(new C1020d(this, 8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(SpyTapItem spyTapItem, Context context, Preference it) {
        h.e(it, "it");
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/spy/tap");
        iVarA.f("device_mac_info", spyTapItem.viewModel.f20397b);
        iVarA.f("device_name", spyTapItem.viewModel.f20398c);
        iVarA.f("product_id", spyTapItem.viewModel.f20400e);
        iVarA.f("product_color", String.valueOf(spyTapItem.viewModel.f20401f));
        iVarA.b(context);
        DetailBaseViewModel detailBaseViewModel = spyTapItem.viewModel;
        String str = detailBaseViewModel.f20400e;
        String str2 = detailBaseViewModel.f20397b;
        String strT = N.t(AbstractC0939b.E().w(spyTapItem.viewModel.f20397b));
        int funType = AppConstant$FunctionType.SPY_TAP.getFunType();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String strO = S.o(heyMelodyApplication, "com.spotify.music");
        int i10 = TextUtils.isEmpty(strO) ? 2 : S.c("9.1.14.864", strO) < 0 ? 1 : 0;
        A.f("SpyTopHelper", "pkgInstallState, result=" + i10 + ", SUPPORT_VER=9.1.14.864, versionName=" + strO);
        C1264t.t(funType, str, str2, strT, String.valueOf(i10));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(SpyTapItem spyTapItem, int i10) {
        spyTapItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }
}
