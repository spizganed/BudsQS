package com.oplus.melody.ui.component.detail.fitdetection;

import A6.e;
import A9.c;
import D7.C0373g;
import D7.C0379m;
import D7.C0386u;
import D7.o0;
import E9.a;
import F8.i;
import Jb.b;
import O7.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.s;
import androidx.media3.session.D0;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import g9.t;
import i8.AbstractC1148a;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.jvm.internal.h;
import l9.C1286a;
import la.C1310x;
import la.j0;
import m8.g;

/* JADX INFO: loaded from: classes3.dex */
public class FitDetectionItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "fitDetection";
    public static final String TAG = "FitDetectionItem";
    private Context mContext;
    private MoreSettingViewModel mViewModel;

    public FitDetectionItem(Context context, MoreSettingViewModel moreSettingViewModel, InterfaceC0601m interfaceC0601m) {
        s<String> sVarB;
        super(context);
        this.mContext = context;
        this.mViewModel = moreSettingViewModel;
        setTitle(R.string.melody_ui_fit_detection_title);
        setSummary(R.string.melody_ui_fit_detection_summary);
        setOnPreferenceClickListener(new C1310x(this, 2));
        MoreSettingViewModel moreSettingViewModel2 = this.mViewModel;
        moreSettingViewModel2.d(moreSettingViewModel2.f21136b).e(interfaceC0601m, new a(this, 25));
        String macAddress = this.mViewModel.f21136b;
        h.e(macAddress, "macAddress");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new e(5))).e(interfaceC0601m, new j0(this, 3));
        if (C0373g.d()) {
            this.mViewModel.getClass();
            int i10 = AbstractC1148a.f24096c;
            AbstractC1148a abstractC1148aA = AbstractC1148a.C0266a.a();
            ((abstractC1148aA == null || (sVarB = abstractC1148aA.b()) == null) ? new l<>() : sVarB).e(interfaceC0601m, new g(this, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDetailFunction() {
        E8.a.w().getClass();
        b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/fit_detection");
        iVarA.f("device_mac_info", this.mViewModel.f21136b);
        iVarA.f("device_name", this.mViewModel.f21138d);
        iVarA.f("product_id", this.mViewModel.f21137c);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f21139e));
        iVarA.b(this.mContext);
        MoreSettingViewModel moreSettingViewModel = this.mViewModel;
        String str = moreSettingViewModel.f21137c;
        String str2 = moreSettingViewModel.f21136b;
        C1264t.t(AppConstant$FunctionType.FIT_DETECT.getFunType(), str, str2, N.t(moreSettingViewModel.e(str2)), "");
    }

    public static boolean hasFunction(WhitelistConfigDTO.Function function) {
        return function != null && Y.e(function.getFitDetection(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(Preference preference) {
        A.b(TAG, "onClick, view: ");
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f21136b, LeFilterConstants.FunType.FIT_DETECT.getFunType(), new t(this, 3));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(C1286a c1286a) {
        if (c1286a == null || c1286a.getDeviceVersionList() == null) {
            A.b(TAG, "getVersionInfoList result null");
        } else {
            onEarphoneDataChanged(c1286a.isConnected() ? 2 : 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EarphoneDTO lambda$new$2(String str) {
        return this.mViewModel.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(EarphoneDTO earphoneDTO) {
        onEarphoneDataChanged(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$4(EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new h0.h(8, this, earphoneDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$5(String str) {
        StringBuilder sbI = D0.i("getLeAudioSwitchStatusChanged, addr: ", str, ", vm.addr: ");
        sbI.append(this.mViewModel.f21136b);
        A.f(TAG, sbI.toString());
        if (TextUtils.equals(str, this.mViewModel.f21136b)) {
            CompletableFuture.supplyAsync(new C0386u(29, this, str)).whenComplete((BiConsumer) new c(this, 19));
        } else {
            A.x(TAG, "getLeAudioSwitchStatusChanged addr not same");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEarphoneDataChanged$6(int i10, boolean z2) {
        if (z2) {
            setDisabled(true);
            setAllowClickWhenDisabled(i10 == 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEarphoneDataChanged(int i10) {
        setDisabled(i10 != 2);
        b.C0229b.f19632a.a(this.mViewModel.f21136b, LeFilterConstants.FunType.FIT_DETECT.getFunType(), new W8.c(this, i10, 5));
    }
}
