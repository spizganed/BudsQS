package com.oplus.melody.ui.component.detail.weardetection;

import A9.i;
import D7.C0379m;
import Ha.c;
import J8.e;
import Jb.a;
import Jb.l;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.widget.MelodyCOUISwitchPreference;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ChannelSwitchItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/weardetection/ChannelSwitchItem;", "Lcom/oplus/melody/common/widget/MelodyCOUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChannelSwitchItem extends MelodyCOUISwitchPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "ChannelSwitchItem";

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.weardetection.ChannelSwitchItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ChannelSwitchItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: ChannelSwitchItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f21389a;

        public b(e eVar) {
            this.f21389a = eVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21389a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21389a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSwitchItem(Context context, MoreSettingViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_wear_detection_change_channel_title);
        setSummary(R.string.melody_ui_wear_detection_change_channel_summary_2);
        com.oplus.melody.leaudio.b bVar = b.C0229b.f19632a;
        String strD = LeFilterConstants.FunType.CHANNEL_SWITCH.getFunType();
        String macAddress = viewModel.f21136b;
        bVar.a(macAddress, strD, new c(4, macAddress, this));
        h.e(macAddress, "macAddress");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new A6.b(6))).e(lifecycleOwner, new b(new e(3, this, viewModel)));
        setOnPreferenceChangeListener(new U9.a(viewModel, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(String str, ChannelSwitchItem channelSwitchItem, boolean z2) {
        A.f(ITEM_NAME, "onCreate.canDisabled, mAddress = " + str + ", canDisabled = " + z2);
        if (z2) {
            channelSwitchItem.setOnClickListener(new Y9.a(0, channelSwitchItem, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0$0(ChannelSwitchItem channelSwitchItem, String str, View view) {
        b.C0229b.f19632a.b(channelSwitchItem.getContext(), str, LeFilterConstants.FunType.CHANNEL_SWITCH.getFunType(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l _init_$lambda$1(ChannelSwitchItem channelSwitchItem, MoreSettingViewModel moreSettingViewModel, Y9.c vo) {
        h.e(vo, "vo");
        A.c(ITEM_NAME, new S7.c(vo, 9));
        boolean z2 = false;
        boolean z4 = vo.getConnectionState() == 2;
        boolean z10 = vo.getWearDetectionStatus() == 1;
        channelSwitchItem.setEnabled(z4 && z10);
        if (channelSwitchItem.isEnabled() && vo.isChannelSwitchOn()) {
            z2 = true;
        }
        channelSwitchItem.setChecked(z2);
        b.C0229b.f19632a.a(moreSettingViewModel.f21136b, LeFilterConstants.FunType.CHANNEL_SWITCH.getFunType(), new Y9.b(z4, z10, vo, channelSwitchItem));
        return l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1$0(Y9.c cVar) {
        int connectionState = cVar.getConnectionState();
        int wearDetectionStatus = cVar.getWearDetectionStatus();
        boolean zIsChannelSwitchOn = cVar.isChannelSwitchOn();
        StringBuilder sbM = androidx.appcompat.widget.a.m(connectionState, wearDetectionStatus, "channelSwitchChanged connectState:", " wearDetectionStatus:", " channelSwitchOn:");
        sbM.append(zIsChannelSwitchOn);
        return sbM.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1$1(boolean z2, boolean z4, Y9.c cVar, ChannelSwitchItem channelSwitchItem, boolean z10) {
        A.c(ITEM_NAME, new i(15, z10));
        if (!z2 || !z4 || !z10) {
            channelSwitchItem.setAllowClickDisabled(false);
            channelSwitchItem.setChecked(channelSwitchItem.isEnabled() && cVar.isChannelSwitchOn());
        } else {
            boolean z11 = cVar.getConnectionState() == 2;
            channelSwitchItem.setEnabled(z11);
            channelSwitchItem.setAllowClickDisabled(z11);
            channelSwitchItem.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$1$1$0(boolean z2) {
        return A6.e.f("channelSwitchChanged canDisabled:", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(MoreSettingViewModel moreSettingViewModel, Preference preference, Object obj) {
        h.e(preference, "<unused var>");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        String address = moreSettingViewModel.f21136b;
        h.e(address, "address");
        AbstractC0939b.E().h0(zBooleanValue ? 1 : 0, address);
        String str = moreSettingViewModel.f21136b;
        String strT = N.t(moreSettingViewModel.e(str));
        C1264t.z(1, zBooleanValue ? 1 : 0, moreSettingViewModel.f21137c, str, strT);
        return true;
    }
}
