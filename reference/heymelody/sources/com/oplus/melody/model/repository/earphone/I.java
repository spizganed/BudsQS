package com.oplus.melody.model.repository.earphone;

import D7.C0391z;
import androidx.fragment.app.Fragment;
import com.oplus.melody.btsdk.api.data.HearingEnhancementEarScanResult;
import com.oplus.melody.btsdk.api.data.SimpleStateInfo;
import com.oplus.melody.common.data.DiagnosisConfigDTO;
import com.oplus.melody.common.data.WhitelistContentDO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.hearingenhance.HearingStatusDTO;
import com.oplus.melody.ui.component.detail.gamemode.GameModeItem;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;
import com.oplus.melody.ui.component.fitdetection.FitDetectionFragment;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import com.oplus.melody.ui.component.tutorialguide.TutorialGuideFunctionsViewModel;
import ea.C1028g;
import h7.C1090a;
import h7.C1093d;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import la.n0;
import p7.C1402a;
import q9.C1447b;
import x3.C1656o;
import z7.C1725a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class I implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19887b;

    public /* synthetic */ I(Object obj, int i10) {
        this.f19886a = i10;
        this.f19887b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19886a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("EVENT_ID_BT_RECEIVE_VOICE_RECOGNITION isOpen=");
                SimpleStateInfo simpleStateInfo = (SimpleStateInfo) this.f19887b;
                sb2.append(simpleStateInfo.getState());
                sb2.append(" mac=");
                sb2.append(com.oplus.melody.common.util.A.r(simpleStateInfo.getAddress()));
                return sb2.toString();
            case 1:
                return "request spine data " + ((com.oplus.melody.model.db.M) this.f19887b).getUtc();
            case 2:
                return "EVENT_ID_BT_EAR_SCAN_RESULT, earScanResult: " + ((HearingEnhancementEarScanResult) this.f19887b);
            case 3:
                return PersonalNoiseItem.lambda$initItem$5((com.oplus.melody.ui.component.detail.personalnoise.g) this.f19887b);
            case 4:
                return "PersonalNoiseItem: mBothInEar:" + ((com.oplus.melody.ui.component.detail.personalnoise.j) this.f19887b).f21189q;
            case 5:
                return "no remote data, set raw name: " + ((com.oplus.melody.ui.component.detail.zenmode.scene.b) this.f19887b).f21435e;
            case 6:
                StringBuilder sb3 = new StringBuilder("zen mode initializing, on download succeed, mRecyclerViewWrapper is not null: ");
                sb3.append(((com.oplus.melody.ui.component.detail.zenmode.scene.g) this.f19887b).f21461r != null);
                return sb3.toString();
            case 7:
                return A6.b.d(((Set) this.f19887b).size(), "hasOplusDevice allBondDevices.size ");
            case 8:
                return "onStopClick " + ((C1028g) this.f19887b).getData().getResId();
            case 9:
                return "mGameModeMainEnable changed:" + ((g9.j) this.f19887b).f23368j0;
            case 10:
                return "onCustomDataChanged assignment mAdjustEqInfo " + ((a8.b) this.f19887b).getEqId();
            case 11:
                return "Start upgrade mUpgradeFileInfoList.size()" + ((C1090a) this.f19887b).f23704j.size();
            case 12:
                return "Validation is success, send the next file " + C1093d.this.f23730s;
            case 13:
                return "CheckConnectedState enter mConnectState = " + ia.b.this.f24135s;
            case 14:
                return FitDetectionFragment.u((FitDetectionFragment) this.f19887b);
            case 15:
                k7.j jVar = (k7.j) this.f19887b;
                jVar.getClass();
                StringBuilder sb4 = new StringBuilder(" Clearing all connection state for dev:");
                String strF = C0391z.f1171d.f(jVar.f25198c);
                A.a aVar = C1725a.f29476a;
                sb4.append(com.oplus.melody.common.util.A.q(strF));
                return sb4.toString();
            case 16:
                int i10 = HearingEnhancementActivity.f21566m0;
                return "turnBack, currentFragment=" + ((Fragment) this.f19887b);
            case 17:
                int i11 = HearingEnhancementActivity.f21566m0;
                StringBuilder sb5 = new StringBuilder("fetchResource, pid=");
                HearingEnhancementActivity hearingEnhancementActivity = (HearingEnhancementActivity) this.f19887b;
                sb5.append(hearingEnhancementActivity.f21571e0.f21583d);
                sb5.append(", colorId=");
                sb5.append(hearingEnhancementActivity.f21571e0.f21584e);
                return sb5.toString();
            case 18:
                return "onViewCreated.onRecentClick mCurrentFragment: " + HearingEnhancementActivity.this.f21568b0;
            case 19:
                float[] fArr = la.L.f25669Q0;
                return "releaseVisualizer, mVisualizer: " + ((la.L) this.f19887b).f25742v0;
            case 20:
                List<Integer> list = n0.f25864d0;
                StringBuilder sb6 = new StringBuilder("detect_value.current value = ");
                n0 n0Var = (n0) this.f19887b;
                sb6.append(n0Var.f25902x);
                sb6.append(", currentIndex = ");
                sb6.append(n0Var.f25903y);
                sb6.append(", ");
                sb6.append(n0Var.f25881Q);
                return sb6.toString();
            case 21:
                List<Integer> list2 = n0.f25864d0;
                return "onHearingStatusChanged statusDTO: " + ((HearingStatusDTO) this.f19887b);
            case 22:
                return "requestPermissionResult: " + ((Map) this.f19887b);
            case 23:
                return "onDeviceAbort, mConnectionState: " + ((p7.b) this.f19887b).f26455q;
            case 24:
                return C1656o.a("checkRemoveConnectTimeoutRunnable connect success! handheldAddress = ", com.oplus.melody.common.util.A.r((String) ((Map.Entry) this.f19887b).getKey()));
            case 25:
                return g0.e.b(new StringBuilder("startConnect, mState is : "), ((C1402a) this.f19887b).f27145e, ", return it");
            case 26:
                return GameModeItem.lambda$onEarphoneChanged$4((C1447b) this.f19887b);
            case 27:
                TutorialGuideFunctionsViewModel tutorialGuideFunctionsViewModel = ((qa.b) this.f19887b).f27233z;
                if (tutorialGuideFunctionsViewModel != null) {
                    return tutorialGuideFunctionsViewModel.d();
                }
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            case 28:
                return A6.b.d(((WhitelistContentDO) this.f19887b).getVersionCode(), "updateValueAndClearTask IGNORE ver=");
            default:
                DiagnosisConfigDTO diagnosisConfigDTO = (DiagnosisConfigDTO) this.f19887b;
                return "processWhitelistContent: diagnosis filter " + diagnosisConfigDTO.getId() + "(" + com.oplus.melody.common.util.A.q(diagnosisConfigDTO.getName()) + ")";
        }
    }
}
