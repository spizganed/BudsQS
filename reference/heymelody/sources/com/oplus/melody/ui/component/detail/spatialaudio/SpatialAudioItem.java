package com.oplus.melody.ui.component.detail.spatialaudio;

import A6.g;
import A6.l;
import A9.q;
import C6.e;
import D7.C0373g;
import D7.C0384s;
import D7.o0;
import F8.i;
import I7.m;
import R9.n;
import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.app.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.media3.session.D0;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.spatialaudio.d;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import i8.AbstractC1148a;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kc.C1264t;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import l9.C1286a;
import s8.AbstractC1508a;
import t8.v;

/* JADX INFO: loaded from: classes3.dex */
public class SpatialAudioItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "SpatialAudioItem";
    private static final String TAG = "SpatialAudioItem";
    private Context mContext;
    private InterfaceC0601m mLifecycleOwner;
    private boolean mSupportNewHeadsetSpatial;
    private DetailMainViewModel mViewModel;

    public SpatialAudioItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(n.b(detailMainViewModel.f20400e, detailMainViewModel.f20398c));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        String productId = detailMainViewModel2.f20400e;
        String productName = detailMainViewModel2.f20398c;
        h.e(productId, "productId");
        h.e(productName, "productName");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String string = heyMelodyApplication.getString(R.string.melody_ui_pref_spatial_audio_summary_new, n.a(productId, productName));
        h.d(string, "getString(...)");
        setSummary(string);
        setOnPreferenceClickListener(new C0.a(this, 16));
        DetailMainViewModel detailMainViewModel3 = this.mViewModel;
        detailMainViewModel3.f(detailMainViewModel3.f20397b).e(this.mLifecycleOwner, new l(this, 11));
        DetailMainViewModel detailMainViewModel4 = this.mViewModel;
        detailMainViewModel4.d(detailMainViewModel4.f20397b).e(this.mLifecycleOwner, new C9.a(this, 10));
        DetailMainViewModel detailMainViewModel5 = this.mViewModel;
        detailMainViewModel5.n(detailMainViewModel5.f20397b).e(this.mLifecycleOwner, new e(this, 13));
        A.c("SpatialAudioItem", new P3.d(this, 11));
        Z7.a aVarG = Z7.a.g();
        DetailMainViewModel detailMainViewModel6 = this.mViewModel;
        aVarG.d(detailMainViewModel6.f20401f, 3, detailMainViewModel6.f20400e);
        if (C0373g.d()) {
            this.mViewModel.k().e(this.mLifecycleOwner, new E9.a(this, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDetailFunction() {
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/spatial_audio");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f1670b.putExtra("support_new_headset_spatial", this.mSupportNewHeadsetSpatial);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
        iVarA.b(this.mContext);
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.SPATIAL_AUDIO.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    public static boolean isPhoneSupportSpatial(String str) {
        int i10 = 1;
        if (!v.b(str)) {
            return false;
        }
        if (S.j() >= 34 && C0373g.f1083i) {
            return true;
        }
        int i11 = AbstractC1148a.f24096c;
        return !((Boolean) Optional.ofNullable(AbstractC1148a.C0266a.a()).map(new m(str, i10)).orElse(Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isPhoneSupportSpatial$10(String str, AbstractC1148a abstractC1148a) {
        return Boolean.valueOf(abstractC1148a.d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(Preference preference) {
        A.b("SpatialAudioItem", "click SpatialAudioItem");
        if (isPhoneSupportSpatial(this.mViewModel.f20397b)) {
            doDetailFunction();
            return true;
        }
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f20397b, LeFilterConstants.FunType.SPATIAL_AUDIO.getFunType(), new E9.h(this, 7));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Fragment lambda$new$1(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return (Fragment) list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$2(List list) {
        BaseSpatialAudioVM baseSpatialAudioVM;
        WhitelistConfigDTO.Function function;
        this.mSupportNewHeadsetSpatial = N.k(298, list);
        Fragment fragment = (Fragment) Optional.ofNullable(this.mViewModel.j()).map(new A6.i(11)).map(new A6.c(15)).orElse(null);
        A.f("SpatialAudioItem", "onChanged, mSupportNewHeadsetSpatial: " + this.mSupportNewHeadsetSpatial + ", addr: " + this.mViewModel.f20397b);
        if (fragment != null) {
            d dVar = d.f21291a;
            DetailMainViewModel detailMainViewModel = this.mViewModel;
            String address = detailMainViewModel.f20397b;
            String name = detailMainViewModel.f20398c;
            String pId = detailMainViewModel.f20400e;
            boolean z2 = this.mSupportNewHeadsetSpatial;
            dVar.getClass();
            h.e(address, "address");
            h.e(name, "name");
            h.e(pId, "pId");
            if (v.b(address)) {
                O store = fragment.getViewModelStore();
                N.b factory = fragment.getDefaultViewModelProviderFactory();
                W.a defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                h.e(store, "store");
                h.e(factory, "factory");
                X.d dVarB = g.b(defaultViewModelCreationExtras, "defaultCreationExtras", store, factory, defaultViewModelCreationExtras);
                kotlin.jvm.internal.b bVarA = j.a(PhoneSpatialAudioVM.class);
                String strA = bVarA.a();
                if (strA == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                baseSpatialAudioVM = (BaseSpatialAudioVM) dVarB.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
            } else if (z2) {
                O store2 = fragment.getViewModelStore();
                N.b factory2 = fragment.getDefaultViewModelProviderFactory();
                W.a defaultViewModelCreationExtras2 = fragment.getDefaultViewModelCreationExtras();
                h.e(store2, "store");
                h.e(factory2, "factory");
                X.d dVarB2 = g.b(defaultViewModelCreationExtras2, "defaultCreationExtras", store2, factory2, defaultViewModelCreationExtras2);
                kotlin.jvm.internal.b bVarA2 = j.a(HeadSetSpatialAudioVMV2.class);
                String strA2 = bVarA2.a();
                if (strA2 == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                baseSpatialAudioVM = (BaseSpatialAudioVM) dVarB2.a(bVarA2, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA2));
            } else {
                O store3 = fragment.getViewModelStore();
                N.b factory3 = fragment.getDefaultViewModelProviderFactory();
                W.a defaultViewModelCreationExtras3 = fragment.getDefaultViewModelCreationExtras();
                h.e(store3, "store");
                h.e(factory3, "factory");
                X.d dVarB3 = g.b(defaultViewModelCreationExtras3, "defaultCreationExtras", store3, factory3, defaultViewModelCreationExtras3);
                kotlin.jvm.internal.b bVarA3 = j.a(HeadSetSpatialAudioVM.class);
                String strA3 = bVarA3.a();
                if (strA3 == null) {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
                baseSpatialAudioVM = (BaseSpatialAudioVM) dVarB3.a(bVarA3, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA3));
            }
            d.f21294d = baseSpatialAudioVM;
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            baseSpatialAudioVM.f(heyMelodyApplication, address, null);
            BaseSpatialAudioVM baseSpatialAudioVM2 = d.f21294d;
            if (baseSpatialAudioVM2 == null) {
                h.i("spatialAudioViewModel");
                throw null;
            }
            baseSpatialAudioVM2.d(address).e(fragment, new d.b(new O9.i(address, 1)));
            WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(pId, name);
            if (whitelistConfigDTOC != null && (function = whitelistConfigDTOC.getFunction()) != null && function.getSpatialHiResMutex() == 1) {
                A.f("SpatialAudioHelper", "initSpatialViewModel, address: " + address + ", supportMutex = true");
                d.f21292b.put(address, Boolean.TRUE);
            }
            f fVar = d.f21295e;
            if (fVar == null || !fVar.isShowing()) {
                return;
            }
            A.x("SpatialAudioHelper", "initSpatialViewModel, switchNoticeDialog isShowing, dismiss it.");
            f fVar2 = d.f21295e;
            if (fVar2 != null) {
                fVar2.dismiss();
            }
            d.f21295e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(C1286a c1286a) {
        if (c1286a == null || c1286a.getDeviceVersionList() == null) {
            A.b("SpatialAudioItem", "getVersionInfoList result null");
        } else {
            onConnectionChange(Integer.valueOf(c1286a.isConnected() ? 2 : 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lambda$new$4() {
        return "SpatialAudioItem pid=" + this.mViewModel.f20400e + ", color=" + this.mViewModel.f20401f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EarphoneDTO lambda$new$5(String str) {
        return this.mViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(EarphoneDTO earphoneDTO) {
        onConnectionChange(Integer.valueOf(earphoneDTO.getConnectionState()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$7(EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new B6.b(9, this, earphoneDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$8(String str) {
        StringBuilder sbI = D0.i("getLeAudioSwitchStatusChanged, addr: ", str, ", vm.addr: ");
        sbI.append(this.mViewModel.f20397b);
        A.f("SpatialAudioItem", sbI.toString());
        if (TextUtils.equals(str, this.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new C0384s(10, this, str)).whenComplete((BiConsumer) new q(this, 5));
        } else {
            A.x("SpatialAudioItem", "getLeAudioSwitchStatusChanged addr not same");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onConnectionChange$9(Integer num, boolean z2) {
        if (!z2 || isPhoneSupportSpatial(this.mViewModel.f20397b)) {
            return;
        }
        setDisabled(true);
        setAllowClickWhenDisabled(num.intValue() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectionChange(Integer num) {
        setDisabled(num.intValue() != 2);
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.SPATIAL_AUDIO.getFunType(), new A9.e(2, this, num));
    }
}
