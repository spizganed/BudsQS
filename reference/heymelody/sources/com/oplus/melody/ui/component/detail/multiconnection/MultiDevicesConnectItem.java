package com.oplus.melody.ui.component.detail.multiconnection;

import A9.s;
import B9.f;
import D7.C0373g;
import D7.C0379m;
import D7.C0381o;
import D7.o0;
import E8.a;
import E9.c;
import E9.d;
import F8.i;
import Jb.b;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.media3.session.D0;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.widget.MelodyCOUIPreferenceCategory;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kc.C1264t;
import l9.C1286a;

/* JADX INFO: loaded from: classes3.dex */
public class MultiDevicesConnectItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "MultiDevicesConnectItem";
    private final Context mContext;
    private final InterfaceC0601m mLifecycleOwner;
    private final List<C0381o<?>> mLiveDataRecordList;
    private final DetailMainViewModel mViewModel;

    public MultiDevicesConnectItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mLiveDataRecordList = new ArrayList();
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(R.string.melody_ui_multiple_devices_conenct_title);
        setSummary(R.string.melody_ui_multiple_devices_conenct_summary);
        setOnPreferenceClickListener(new d(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDetailFunction() {
        a.w().getClass();
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/multi_connect");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.b(this.mContext);
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.MULTI_CONNECT.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(Preference preference) {
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f20397b, LeFilterConstants.FunType.MULTI_CONNECT.getFunType(), new d(this));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttached$1(C1286a c1286a) {
        if (c1286a == null || c1286a.getDeviceVersionList() == null) {
            A.b(ITEM_NAME, "getVersionInfoList result null");
        } else {
            onEarphoneDataChanged(c1286a.isConnected() ? 2 : 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EarphoneDTO lambda$onAttached$2(String str) {
        return this.mViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttached$3(EarphoneDTO earphoneDTO) {
        onEarphoneDataChanged(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onAttached$4(EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new Aa.d(2, this, earphoneDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onAttached$5(String str) {
        StringBuilder sbI = D0.i("getLeAudioSwitchStatusChanged, addr: ", str, ", vm.addr: ");
        sbI.append(this.mViewModel.f20397b);
        A.f(ITEM_NAME, sbI.toString());
        if (TextUtils.equals(str, this.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new f(1, this, str)).whenComplete((BiConsumer) new s(this, 4));
        } else {
            A.x(ITEM_NAME, "getLeAudioSwitchStatusChanged addr not same");
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
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.MULTI_CONNECT.getFunType(), new E9.b(this, i10, 0));
    }

    private <T> void recordObserve(androidx.lifecycle.s<T> sVar, v<T> vVar) {
        this.mLiveDataRecordList.add(C0379m.j(sVar, this.mLifecycleOwner, vVar));
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        if (isVisible()) {
            PreferenceGroup parent = getParent();
            if (parent instanceof MelodyCOUIPreferenceCategory) {
                ((MelodyCOUIPreferenceCategory) parent).m(0);
            }
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        recordObserve(detailMainViewModel.d(detailMainViewModel.f20397b), new E9.a(this, 0));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        recordObserve(detailMainViewModel2.n(detailMainViewModel2.f20397b), new A6.l(this, 2));
        if (C0373g.d()) {
            recordObserve(this.mViewModel.k(), new C9.a(this, 3));
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        this.mLiveDataRecordList.forEach(new c(0));
        this.mLiveDataRecordList.clear();
    }
}
