package com.oplus.melody.ui.component.detail.moresetting;

import A6.b;
import D7.C0379m;
import O7.l;
import androidx.lifecycle.L;
import androidx.lifecycle.s;
import androidx.lifecycle.v;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MoreSettingViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001<B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJ\u001e\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00110\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u001e\u001a\u00020\u0003J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00182\u0006\u0010\u0002\u001a\u00020\u0003J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00182\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0018J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00182\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0003J \u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010,2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0012J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00182\u0006\u0010\u001e\u001a\u00020\u0003J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u001e\u001a\u00020\u0003J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u000204J\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u0002\u001a\u00020\u0003J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u000204J\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120\u00182\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010;\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u000204R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "address", "", "productId", "deviceName", "colorId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getProductId", "getDeviceName", "getColorId", "mWhitelist", "Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "mCapability", "", "", "mItemsLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "Ljava/lang/Class;", "getWhitelist", "getItemsLiveData", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "updateItems", "", "getConnectionState", "macAddress", "getEffectiveConnectionState", "getEarphoneDirect", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "getCapabilityLiveData", "getWhitelistConfigLiveData", "productName", "getVersionInfoList", "Lcom/oplus/melody/ui/component/detail/firmwareversion/FirmwareVersionVO;", "getLeAudioSwitchStatusChanged", "getVolumeValueInfoState", "Lcom/oplus/melody/ui/component/detail/promptvolume/VolumeValueInfoVO;", "getVolumeValueInfo", "setVolumeValueInfo", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "value", "getChannelSwitchLiveData", "Lcom/oplus/melody/ui/component/detail/weardetection/ChannelSwitchVO;", "getWearDetectionStatus", "setWearDetectionStatus", ClientDataEntity.COL_STATUS, "", "setChannelSwitch", "channelSwitch", "getSwiftPairStateLiveData", "setSwiftPairEnable", "enable", "getReconnectPopupSwitchLiveData", "setReconnectPopupEnable", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MoreSettingViewModel extends L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f21139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WhitelistConfigDTO f21140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<Integer> f21141g;
    public final l<List<Class<?>>> h;

    /* JADX INFO: compiled from: MoreSettingViewModel.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wb.l f21142a;

        public a(Wb.l lVar) {
            this.f21142a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21142a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21142a.d(obj);
        }
    }

    public MoreSettingViewModel(String address, String productId, String deviceName, String colorId) {
        h.e(address, "address");
        h.e(productId, "productId");
        h.e(deviceName, "deviceName");
        h.e(colorId, "colorId");
        this.f21136b = address;
        this.f21137c = productId;
        this.f21138d = deviceName;
        this.f21139e = colorId;
        this.h = new l<>();
    }

    public final s<Integer> d(String macAddress) {
        h.e(macAddress, "macAddress");
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new A6.f(5)));
    }

    public final EarphoneDTO e(String macAddress) {
        h.e(macAddress, "macAddress");
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(macAddress);
        h.d(earphoneDTOW, "getEarphoneData(...)");
        return earphoneDTOW;
    }

    public final s<Integer> f(String macAddress) {
        h.e(macAddress, "macAddress");
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new b(7)));
    }
}
