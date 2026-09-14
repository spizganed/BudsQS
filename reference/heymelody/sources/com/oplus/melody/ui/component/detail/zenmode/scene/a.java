package com.oplus.melody.ui.component.detail.zenmode.scene;

import Y.z;
import androidx.media3.session.D0;
import com.heytap.headset.service.KeepAliveFgService;
import com.heytap.upgrade.model.UpgradeInfo;
import com.oplus.melody.btsdk.settinglib.LeDevice;
import com.oplus.melody.common.addon.MelodyAppExitInfo;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.ui.component.detail.hearingoptimize.HearingOptimizeItem;
import com.oplus.melody.ui.component.detail.highaudio.HighAudioViewModel;
import com.oplus.melody.ui.component.finddevice.preference.FindDevicePreference;
import com.oplus.melody.ui.component.fitdetection.FitDetectionFragment;
import com.oplus.melody.ui.component.hearingenhance.EarScanFragmentV2;
import h7.C1093d;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import k7.s;
import la.C1306t;
import la.n0;
import la.u0;
import o7.C1376d;
import o7.C1381i;
import p8.e;
import q7.AbstractC1439a;
import q9.C1446a;
import x3.C1656o;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21430b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f21429a = i10;
        this.f21430b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        ArrayList arrayList;
        Object obj = this.f21430b;
        switch (this.f21429a) {
            case 0:
                return "set name by id: " + ((b) obj).f21435e;
            case 1:
                return "onUpgradeCancel UpgradeInfo = " + ((UpgradeInfo) obj);
            case 2:
                StringBuilder sb2 = new StringBuilder("mCurrentBlockSize ");
                C1093d.e eVar = (C1093d.e) obj;
                sb2.append(eVar.h);
                sb2.append(" mFileSendOffset = ");
                sb2.append(eVar.f23740c);
                return sb2.toString();
            case 3:
                return "The transfer complete ind is received, send next file " + C1093d.this.f23730s;
            case 4:
                FindDevicePreference.a aVar = FindDevicePreference.f21529u;
                return "FindDevicePreference connection " + ((FindDevicePreference) obj).hashCode();
            case 5:
                return "onEarCapabilityChanged mSupportEarStatus = " + ((ia.b) obj).f24139w;
            case 6:
                int i10 = FitDetectionFragment.f21539a;
                StringBuilder sb3 = new StringBuilder("mStatusInfoObserver.onChanged, bothInEar: ");
                EarStatusDTO earStatusDTO = (EarStatusDTO) obj;
                sb3.append(earStatusDTO.bothInEar());
                sb3.append(", statusInfo: ");
                sb3.append(earStatusDTO);
                return sb3.toString();
            case 7:
                return A6.e.f("forceForeground hasStartForeground = ", ((KeepAliveFgService) obj).f17594p);
            case 8:
                return "readPairedDevices mPairedDevices.size() =" + ((k7.h) obj).f25183g.size();
            case 9:
                return "connectWithoutResettingTimer.connectInt profile = " + ((s) obj);
            case 10:
                return "checkAndGetDevice " + ((LeDevice) obj);
            case 11:
                return "onSaveInstanceState pageIndex=" + ((ka.c) obj).f25269v;
            case 12:
                ka.g gVar = (ka.g) obj;
                return "initGuideView OnDismiss mIsFromGuideEntranceActivity = " + gVar.f25287d + ", mShouldShowTurnAutoSwitchOn = false, mGuideEntranceMode = " + gVar.f25289f;
            case 13:
                return A6.e.f("onClick.startHearingEnhancementDetection, mClickable: ", ((EarScanFragmentV2) obj).f21563z);
            case 14:
                return "getCurrentChildFragment, mCurrentFragment = " + ((C1306t) obj).f25946v;
            case 15:
                List<Integer> list = n0.f25864d0;
                return "createDetectionRecord, mHearingEnhanceInfo = " + ((n0) obj).f25882R;
            case 16:
                return "refresh mSwitchStatus" + ((u0) obj).f25960p;
            case 17:
                m4.f fVar = (m4.f) obj;
                return "RuntimePermissionAlert(" + fVar + ") onDestroy, mActivity: " + fVar.f26310a;
            case 18:
                List<PersonalDressDTO> list2 = ((com.oplus.melody.model.repository.personaldress.e) obj).f20078x;
                ArrayList arrayList2 = new ArrayList(Kb.m.i(list2));
                for (PersonalDressDTO personalDressDTO : list2) {
                    String productId = personalDressDTO.getProductId();
                    int color = personalDressDTO.getColor();
                    List<PersonalDressDTO.PersonalDressData> personalDressData = personalDressDTO.getPersonalDressData();
                    if (personalDressData != null) {
                        arrayList = new ArrayList(Kb.m.i(personalDressData));
                        for (PersonalDressDTO.PersonalDressData personalDressData2 : personalDressData) {
                            arrayList.add(personalDressData2.getThemeId() + " " + personalDressData2.getPriority());
                        }
                    } else {
                        arrayList = null;
                    }
                    StringBuilder sbG = D0.g(color, "productId:", productId, " color:", " dress:");
                    sbG.append(arrayList);
                    arrayList2.add(sbG.toString());
                }
                return "personalDressDtoList db:" + arrayList2;
            case 19:
                C1376d c1376d = (C1376d) obj;
                c1376d.getClass();
                return "close, post delay to closeGatt, " + c1376d;
            case 20:
                C1381i c1381i = (C1381i) obj;
                c1381i.getClass();
                return "execute, Writing " + c1381i;
            case 21:
                return "handleDisconnectingTimeout: mConnectionState=" + ((p7.b) obj).f26455q;
            case 22:
                return C1656o.a("onActive ", ((e.a) obj).f26939l);
            case 23:
                StringBuilder sb4 = new StringBuilder("notifyDisconnect, mIsWriteLoopExit = ");
                AbstractC1439a abstractC1439a = (AbstractC1439a) obj;
                sb4.append(abstractC1439a.f27152m);
                sb4.append(", mIsReadLoopExit = ");
                sb4.append(abstractC1439a.f27153n);
                return sb4.toString();
            case 24:
                return A6.e.f("onSetRating:", ((z) obj).b());
            case 25:
                return A6.e.f("onGameSoundStateChanged:", ((q9.o) obj).getEnable());
            case 26:
                return "onGameModeMainStateChanged: " + ((C1446a) obj);
            case 27:
                return HearingOptimizeItem.onEarphoneChanged$lambda$0((t9.d) obj);
            case 28:
                HighAudioViewModel highAudioViewModel = (HighAudioViewModel) obj;
                boolean z2 = highAudioViewModel.f21093d;
                int i11 = highAudioViewModel.f21092c;
                v9.b bVar = highAudioViewModel.f21096g;
                return "checkStatusChanged: mInitHiRes: " + z2 + ", mInitCodec: " + i11 + ", hiResOpened: " + bVar.f28406b + ", codec: " + bVar.f28405a;
            default:
                return C1656o.a("mAppObserver onAppExit:", ((MelodyAppExitInfo) obj).getTargetName());
        }
    }
}
