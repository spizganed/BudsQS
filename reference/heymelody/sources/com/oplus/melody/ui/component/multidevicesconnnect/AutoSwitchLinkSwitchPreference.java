package com.oplus.melody.ui.component.multidevicesconnnect;

import A6.e;
import A6.g;
import A6.j;
import D6.b;
import D7.C0373g;
import D7.C0379m;
import E9.a;
import E9.i;
import Ea.G;
import Ha.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.lifecycle.InterfaceC0601m;
import androidx.media3.session.D0;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.widget.MelodyUiCOUISwitchPreference;
import ea.C1023b;
import g0.f;
import g9.s;
import g9.t;
import i8.AbstractC1148a;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import kc.C1264t;
import l9.C1286a;
import la.C1294g;
import la.C1310x;
import la.j0;
import oa.C1383a;
import oa.C1384b;
import t8.q;

/* JADX INFO: loaded from: classes3.dex */
public class AutoSwitchLinkSwitchPreference extends MelodyUiCOUISwitchPreference {
    public static final String ITEM_NAME = "AutoSwitchLinkSwitchPreference";
    private boolean mConnected;
    private Context mContext;
    private boolean mIsMultiConnectSwitchStatusOpened;
    private InterfaceC0601m mLifecycleOwner;
    private MultiDevicesConnectViewModel mViewModel;

    public AutoSwitchLinkSwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mIsMultiConnectSwitchStatusOpened = false;
        this.mConnected = false;
    }

    private boolean handleSwitchChange(boolean z2) {
        A.c(ITEM_NAME, new b(this, z2, 11));
        String str = this.mViewModel.f21640b;
        q.c("melody-model-settings").edit().putBoolean("auto_switch_link" + str, z2).apply();
        q.A(this.mViewModel.f21640b);
        ForkJoinPool.commonPool().execute(new i(this, z2, 3));
        MultiDevicesConnectViewModel multiDevicesConnectViewModel = this.mViewModel;
        String str2 = multiDevicesConnectViewModel.f21641c;
        String str3 = multiDevicesConnectViewModel.f21640b;
        C1264t.t(AppConstant$FunctionType.AUTO_SWITCH_LINK.getFunType(), str2, str3, N.t(multiDevicesConnectViewModel.d(str3)), String.valueOf(z2 ? 1 : 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$handleSwitchChange$8(boolean z2) {
        return "handleSwitchChange isChecked = " + z2 + ", mIsMultiConnectSwitchStatusOpened = " + this.mIsMultiConnectSwitchStatusOpened;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$handleSwitchChange$9(boolean z2) {
        MultiDevicesConnectViewModel multiDevicesConnectViewModel = this.mViewModel;
        if (multiDevicesConnectViewModel != null) {
            AbstractC0939b.E().O0(multiDevicesConnectViewModel.f21640b, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(boolean z2) {
        if (z2) {
            setDisabled(true);
            setAllowClickWhenDisabled(this.mConnected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$init$1(C1286a c1286a) {
        if (c1286a == null || c1286a.getDeviceVersionList() == null) {
            A.b(ITEM_NAME, "getVersionInfoList result null");
        } else {
            b.C0229b.f19632a.a(this.mViewModel.f21640b, LeFilterConstants.FunType.AUTO_SWITCH_LINK.getFunType(), new C1383a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(boolean z2) {
        if (z2) {
            setDisabled(true);
            setAllowClickWhenDisabled(this.mConnected);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$init$3(String str) {
        StringBuilder sbI = D0.i("getLeAudioSwitchStatusChanged, addr: ", str, ", vm.addr: ");
        sbI.append(this.mViewModel.f21640b);
        A.f(ITEM_NAME, sbI.toString());
        if (!TextUtils.equals(str, this.mViewModel.f21640b)) {
            A.x(ITEM_NAME, "getLeAudioSwitchStatusChanged addr not same");
            return;
        }
        setPreferenceListener();
        setDisabled(!this.mConnected);
        b.C0229b.f19632a.a(str, LeFilterConstants.FunType.AUTO_SWITCH_LINK.getFunType(), new t(this, 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$onEarphoneChanged$10() {
        return "onEarphoneChanged mIsMultiConnectSwitchStatusOpened = " + this.mIsMultiConnectSwitchStatusOpened + ", mConnected = " + this.mConnected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onEarphoneChanged$11(C1384b c1384b) {
        MultiDevicesConnectViewModel multiDevicesConnectViewModel = this.mViewModel;
        if (multiDevicesConnectViewModel != null) {
            AbstractC0939b.E().O0(multiDevicesConnectViewModel.f21640b, q.i(c1384b.getAddress()) && this.mIsMultiConnectSwitchStatusOpened);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onEarphoneChanged$12(C1384b c1384b, boolean z2) {
        if (z2) {
            setDisabled(true);
            setAllowClickWhenDisabled(this.mConnected);
            return;
        }
        this.mIsMultiConnectSwitchStatusOpened = c1384b.isMultiConnectSwitchStatusOpened();
        A.c(ITEM_NAME, new C1294g(this, 9));
        setChecked(q.i(c1384b.getAddress()) && this.mIsMultiConnectSwitchStatusOpened);
        ForkJoinPool.commonPool().execute(new g0.i(12, this, c1384b));
        setDisabled(!this.mConnected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$setPreferenceListener$4(boolean z2) {
        return e.f("canDisabled ", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$setPreferenceListener$5(Preference preference) {
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f21640b, LeFilterConstants.FunType.AUTO_SWITCH_LINK.getFunType(), null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setPreferenceListener$6(Preference preference, Object obj) {
        return handleSwitchChange(((Boolean) obj).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setPreferenceListener$7(boolean z2) {
        A.c(ITEM_NAME, new G(28, z2));
        if (z2) {
            setOnPreferenceClickListener(new C1310x(this, 3));
        } else {
            setOnPreferenceChangeListener(new C1383a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEarphoneChanged(C1384b c1384b) {
        if (c1384b == null) {
            A.h(ITEM_NAME, "onEarphoneChanged autoSwitchLinkVO is null!");
            return;
        }
        if (A.l()) {
            A.f(ITEM_NAME, "onEarphoneChanged autoSwitchLinkVO = " + c1384b);
        }
        this.mConnected = c1384b.getConnectionState() == 2;
        b.C0229b.f19632a.a(this.mViewModel.f21640b, LeFilterConstants.FunType.AUTO_SWITCH_LINK.getFunType(), new c(11, this, c1384b));
    }

    private void setPreferenceListener() {
        b.C0229b.f19632a.a(this.mViewModel.f21640b, LeFilterConstants.FunType.AUTO_SWITCH_LINK.getFunType(), new s(this, 2));
    }

    public void init(Context context, MultiDevicesConnectViewModel multiDevicesConnectViewModel, InterfaceC0601m interfaceC0601m) {
        int i10 = 11;
        A.b(ITEM_NAME, "init..");
        this.mContext = context;
        this.mViewModel = multiDevicesConnectViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(R.string.melody_common_auto_switch_link_title);
        setSummary(R.string.melody_common_auto_switch_link_summary);
        setPreferenceListener();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f21640b), new f(6))).e(this.mLifecycleOwner, new C1023b(this, i10));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f21640b), new g(i10))).e(this.mLifecycleOwner, new a(this, 26));
        if (C0373g.d()) {
            this.mViewModel.getClass();
            int i11 = AbstractC1148a.f24096c;
            ((androidx.lifecycle.s) Optional.ofNullable(AbstractC1148a.C0266a.a()).map(new A6.c(9)).orElseGet(new j(0))).e(this.mLifecycleOwner, new j0(this, 4));
        }
    }

    public AutoSwitchLinkSwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsMultiConnectSwitchStatusOpened = false;
        this.mConnected = false;
    }

    public AutoSwitchLinkSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsMultiConnectSwitchStatusOpened = false;
        this.mConnected = false;
    }

    public AutoSwitchLinkSwitchPreference(Context context) {
        super(context);
        this.mIsMultiConnectSwitchStatusOpened = false;
        this.mConnected = false;
    }
}
