package com.oplus.melody.ui.component.detail.meetingassist;

import F8.i;
import Jb.a;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MeetingAssistItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/meetingassist/MeetingAssistItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MeetingAssistItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "MeetingAssistItem";
    private final DetailMainViewModel viewModel;

    /* JADX INFO: compiled from: MeetingAssistItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Aa.b f21132a;

        public b(Aa.b bVar) {
            this.f21132a = bVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21132a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21132a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeetingAssistItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.viewModel = viewModel;
        setTitle(R.string.melody_ui_meeting_assist_title);
        setOnPreferenceClickListener(new A9.f(1, this, context));
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new b(new Aa.b(this, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(MeetingAssistItem meetingAssistItem, Context context, Preference preference) {
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/meeting_assist");
        iVarA.f("device_mac_info", meetingAssistItem.viewModel.f20397b);
        iVarA.f("device_name", meetingAssistItem.viewModel.f20398c);
        iVarA.f("product_id", meetingAssistItem.viewModel.f20400e);
        iVarA.f("product_color", String.valueOf(meetingAssistItem.viewModel.f20401f));
        iVarA.b(context);
        DetailMainViewModel detailMainViewModel = meetingAssistItem.viewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        String strT = N.t(detailMainViewModel.i(str2));
        int funType = AppConstant$FunctionType.MEETING_ASSIST.getFunType();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String strO = S.o(heyMelodyApplication, "com.tencent.wemeet.app");
        int i10 = TextUtils.isEmpty(strO) ? 1 : S.c("3.34.0.0", strO) < 0 ? 2 : 0;
        A.f("MeetingMicController", "pkgInstallState, result=" + i10 + ", MUTE_SUPPORT_VER=3.34.0.0, versionName=" + strO);
        C1264t.t(funType, str, str2, strT, String.valueOf(i10));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(MeetingAssistItem meetingAssistItem, int i10) {
        meetingAssistItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }
}
