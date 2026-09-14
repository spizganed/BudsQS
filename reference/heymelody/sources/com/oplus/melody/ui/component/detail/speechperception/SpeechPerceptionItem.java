package com.oplus.melody.ui.component.detail.speechperception;

import D7.C0379m;
import D9.d;
import F8.i;
import Jb.a;
import S9.e;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpeechPerceptionItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/ui/component/detail/speechperception/SpeechPerceptionItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "onEarphoneChanged", "", "speechPerception", "Lcom/oplus/melody/ui/component/detail/speechperception/SpeechPerceptionVO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpeechPerceptionItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "SpeechPerceptionItem";

    /* JADX INFO: compiled from: SpeechPerceptionItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Aa.b f21297a;

        public b(Aa.b bVar) {
            this.f21297a = bVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21297a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21297a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeechPerceptionItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_guide_speech_perception_title);
        setOnPreferenceClickListener(new d(viewModel, context, 2));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(viewModel.f20397b), new A6.b(13))).e(lifecycleOwner, new b(new Aa.b(this, 21)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(DetailMainViewModel detailMainViewModel, Context context, Preference it) {
        h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/speech_perception");
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("device_name", detailMainViewModel.f20398c);
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(detailMainViewModel.f20401f));
        iVarA.b(context);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.SPEECH_PERCEPTION.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(SpeechPerceptionItem speechPerceptionItem, e eVar) {
        speechPerceptionItem.onEarphoneChanged(eVar);
        return Jb.l.f2618a;
    }

    private final void onEarphoneChanged(e eVar) {
        A.c(ITEM_NAME, new S9.a(eVar, 1));
        if (eVar == null) {
            return;
        }
        setEnabled(eVar.getConnectionState() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onEarphoneChanged$lambda$0(e eVar) {
        return "onEarphoneChanged speechPerception = " + eVar;
    }
}
