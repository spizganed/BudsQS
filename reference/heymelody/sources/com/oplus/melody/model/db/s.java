package com.oplus.melody.model.db;

import androidx.media3.exoplayer.C0625v;
import com.heytap.headset.service.KeepAliveFgService;
import com.oplus.melody.btsdk.api.data.HeadsetTipInfo;
import com.oplus.melody.btsdk.api.data.SimpleStateInfo;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.PersonalNoiseDTO;
import com.oplus.melody.model.repository.hearingenhance.HearingEnhanceDataDTO;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;
import com.oplus.melody.ui.component.detail.voiceassist.VoiceCommandFragment;
import com.oplus.melody.ui.component.detail.zenmode.scene.ZenModeSceneActivity;
import com.oplus.melody.ui.component.finddevice.preference.FindDevicePreference;
import com.oplus.melody.ui.component.fitdetection.FitDetectionFragment;
import com.oplus.melody.ui.component.hearingenhance.EarScanFragmentV2;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import f7.C1046a;
import ia.b;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import la.d0;
import la.n0;
import la.w0;
import la.y0;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19785b;

    public /* synthetic */ s(Object obj, int i10) {
        this.f19784a = i10;
        this.f19785b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Object obj = this.f19785b;
        switch (this.f19784a) {
            case 0:
                return "insertSource, ids: " + Arrays.toString((long[]) obj);
            case 1:
                return "EVENT_ID_BT_START_FREE_MUSIC mac=" + com.oplus.melody.common.util.A.r(((SimpleStateInfo) obj).getAddress());
            case 2:
                return ((PersonalNoiseItem) obj).lambda$initItem$2();
            case 3:
                return PersonalNoiseItem.lambda$initItem$7((PersonalNoiseDTO) obj);
            case 4:
                return "onStart: mOnClickListener" + ((com.oplus.melody.ui.component.detail.personalnoise.m) obj).f21197c;
            case 5:
                List<Integer> list = VoiceCommandFragment.H;
                return AbstractC0939b.E().w(((VoiceCommandFragment) obj).f21346z);
            case 6:
                return "no data has the same id, set raw name: " + ((com.oplus.melody.ui.component.detail.zenmode.scene.b) obj).f21435e;
            case 7:
                int i10 = ZenModeSceneActivity.f21424f0;
                StringBuilder sb2 = new StringBuilder("switchFragment: mZenModeSceneFragment == null");
                sb2.append(((ZenModeSceneActivity) obj).f21425c0 == null);
                return sb2.toString();
            case 8:
                return "onEarStatusChanged, bothInEar: " + ((com.oplus.melody.ui.component.detail.zenmode.scene.g) obj).f21460q.f21502i;
            case 9:
                return "turnOffWearCheck, isSending, mPendingWearStatus: " + ((com.oplus.melody.ui.component.detail.zenmode.scene.o) obj).f21500f;
            case 10:
                return A6.b.d(((Set) obj).size(), "requestUpdateCardDataFromBt allBondDevices.size ");
            case 11:
                return "sendMultiSppCmdInfo, cmd: 0x" + E8.a.D(303) + ", data: " + E8.a.e(((C1046a) obj).f23113d);
            case 12:
                HeadsetTipInfo headsetTipInfo = (HeadsetTipInfo) obj;
                return "handTip address:" + com.oplus.melody.common.util.A.r(headsetTipInfo.getAddress()) + " type:" + headsetTipInfo.getType();
            case 13:
                return "mLowLatencyDisabled changed:" + ((g9.j) obj).f23370l0;
            case 14:
                FindDevicePreference.a aVar = FindDevicePreference.f21529u;
                return "onConnectionStateChange mConnectState = " + ((FindDevicePreference) obj).f21537t;
            case 15:
                return "transitionToState =" + ((E8.a) obj).x();
            case 16:
                StringBuilder sb3 = new StringBuilder("onEarCapabilityChanged  mIsCapabilityReady = ");
                ia.b bVar = (ia.b) obj;
                sb3.append(bVar.f24136t);
                sb3.append(", listeners num = ");
                sb3.append(bVar.f24126j.size());
                return sb3.toString();
            case 17:
                return "enter CheckInEarState mSupportEarStatus = " + ((b.d) obj).f24145g.f24139w;
            case 18:
                return C0625v.i(((FitDetectionFragment) obj).mAddress, new StringBuilder("m_spp_le.onChanged.directConnectSpp, addr: "));
            case 19:
                return A6.e.f("onStartCommand force update notification hasStartForeground = ", ((KeepAliveFgService) obj).f17594p);
            case 20:
                StringBuilder sb4 = new StringBuilder("getConnectionStatus: mService == null:");
                sb4.append(((k7.d) obj).f25145a == null);
                return sb4.toString();
            case 21:
                return "onBluetoothManagerInitialized name =  " + ((k7.r) obj);
            case 22:
                return A6.b.d(((EarScanFragmentV2) obj).f21554q, "earScanCallback send success..., mDetectionId = ");
            case 23:
                return "onViewCreated.onHomeClick mCurrentFragment: " + HearingEnhancementActivity.this.f21568b0;
            case 24:
                HearingEnhancementActivity.b bVar2 = (HearingEnhancementActivity.b) obj;
                bVar2.getClass();
                StringBuilder sb5 = new StringBuilder("onViewCreated.handleOnBackPressed, isInLoadScreen=");
                int i11 = HearingEnhancementActivity.f21566m0;
                HearingEnhancementActivity hearingEnhancementActivity = HearingEnhancementActivity.this;
                sb5.append(hearingEnhancementActivity.f1660W >= 2);
                sb5.append(", mNoneRecord=");
                sb5.append(hearingEnhancementActivity.f21567a0);
                sb5.append(", mCurrentFragment=");
                sb5.append(hearingEnhancementActivity.f21568b0);
                return sb5.toString();
            case 25:
                return "onEarScanDataMapChanged mHearingEnhanceInfo is null , mDetectionId: " + ((d0) obj).f25817w;
            case 26:
                return "onEnhanceDataMapChanged left--->" + ((HearingEnhanceDataDTO) obj).getFrequencyLeftCurveData();
            case 27:
                List<Integer> list2 = n0.f25864d0;
                StringBuilder sb6 = new StringBuilder("click, button_next, mCurrentDetectIndex = ");
                n0 n0Var = (n0) obj;
                sb6.append(n0Var.f25904z);
                sb6.append(", size = ");
                sb6.append(n0Var.f25894p.size());
                return sb6.toString();
            case 28:
                return "onClick.startHearingEnhancementDetection, mClickable: " + ((w0) obj).f25976p;
            default:
                return "onClick.startHearingEnhancementDetection, mClickable: " + ((y0) obj).f25992p;
        }
    }
}
