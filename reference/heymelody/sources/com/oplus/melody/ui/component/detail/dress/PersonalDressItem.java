package com.oplus.melody.ui.component.detail.dress;

import D7.C0374h;
import D7.C0378l;
import D7.o0;
import F8.i;
import J8.e;
import Jb.a;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.personaldress.a;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: PersonalDressItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mNewDressMark", "", "mCustomFeatureMark", "newDressMarkChanged", "", "mark", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "PersonalDress";
    public static final String TAG = "PersonalDressItem";
    private boolean mCustomFeatureMark;
    private boolean mNewDressMark;

    /* JADX INFO: compiled from: PersonalDressItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20728a;

        public b(l lVar) {
            this.f20728a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f20728a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20728a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalDressItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_peronalpress_title);
        setOnPreferenceClickListener(new H9.a(viewModel, this, context));
        s<Integer> sVarD = viewModel.d(viewModel.f20397b);
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        s sVarI = a.C0231a.a().i(viewModel.f20401f, viewModel.f20400e);
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(viewModel.f20400e, viewModel.f20398c);
        WhitelistConfigDTO.Function function = whitelistConfigDTOC != null ? whitelistConfigDTOC.getFunction() : null;
        boolean z2 = false;
        if (function != null && Y.e(function.getCustomDress(), false)) {
            z2 = true;
        }
        t tVar = new t();
        tVar.m(sVarD, new b(new C0374h(this, tVar)));
        tVar.m(sVarI, new b(new e(4, this, tVar)));
        if (z2) {
            tVar.m(a.C0231a.a().g(), new b(new C0378l(2, this, tVar)));
        }
        tVar.e(lifecycleOwner, new b(new D9.a(this, 20)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(DetailMainViewModel detailMainViewModel, PersonalDressItem personalDressItem, Context context, Preference it) {
        h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/dress");
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("device_name", detailMainViewModel.f20398c);
        iVarA.f("product_color", String.valueOf(detailMainViewModel.f20401f));
        iVarA.f("new_dress_mark", String.valueOf(personalDressItem.mNewDressMark || personalDressItem.mCustomFeatureMark));
        iVarA.b(context);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.PERSONAL_THEME.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1$0(PersonalDressItem personalDressItem, t tVar, Integer num) {
        personalDressItem.setEnabled(num != null && num.intValue() == 2);
        Jb.l lVar = Jb.l.f2618a;
        tVar.l(lVar);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1$1(PersonalDressItem personalDressItem, t tVar, Boolean bool) {
        h.b(bool);
        personalDressItem.mNewDressMark = bool.booleanValue();
        Jb.l lVar = Jb.l.f2618a;
        tVar.l(lVar);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1$2(PersonalDressItem personalDressItem, t tVar, Boolean bool) {
        h.b(bool);
        personalDressItem.mCustomFeatureMark = bool.booleanValue();
        Jb.l lVar = Jb.l.f2618a;
        tVar.l(lVar);
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$2(PersonalDressItem personalDressItem, Jb.l lVar) {
        personalDressItem.newDressMarkChanged((personalDressItem.mNewDressMark || personalDressItem.mCustomFeatureMark) && personalDressItem.isEnabled());
        return Jb.l.f2618a;
    }

    private final void newDressMarkChanged(boolean mark) {
        o0.c.f1143a.postDelayed(new T8.e(this, mark, 2), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void newDressMarkChanged$lambda$0(PersonalDressItem personalDressItem, boolean z2) {
        personalDressItem.setEndRedDotMode(z2 ? 1 : 0);
    }
}
