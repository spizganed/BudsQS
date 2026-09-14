package com.oplus.melody.model.db;

import D7.o0;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.common.util.S;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.C0945h;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.track.Track;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import ea.C1027f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import la.RunnableC1309w;
import la.d0;
import org.json.JSONException;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19775c;

    public /* synthetic */ k(int i10, Object obj, Object obj2) {
        this.f19773a = i10;
        this.f19775c = obj;
        this.f19774b = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws Exception {
        List<ZenModeInfoDO> list;
        int i10 = 2;
        int i11 = 16;
        boolean z2 = true;
        ?? r42 = 0;
        Object obj2 = this.f19774b;
        Object obj3 = this.f19775c;
        switch (this.f19773a) {
            case 0:
                ((ConnectedDeviceEncryptDao) obj3).getClass();
                ((ArrayList) obj2).add(ConnectedDeviceEncryptDao.k((C0929m) obj));
                break;
            case 1:
                ((HearingEnhancementEncryptDao) obj3).getClass();
                ((ArrayList) obj2).add(HearingEnhancementEncryptDao.j((HearingEnhancementEntity) obj));
                break;
            case 2:
                Set<String> set = (Set) obj;
                com.oplus.melody.model.repository.earphone.L l4 = (com.oplus.melody.model.repository.earphone.L) obj3;
                l4.getClass();
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.f("EarphoneRepository", "refreshBondDevices " + set + " from " + ((String) obj2));
                }
                for (String str : set) {
                    if (W6.b.k(str)) {
                        com.oplus.melody.common.util.A.f("EarphoneRepository", "refreshBondDevices isLeOnlyDevice = true, macAddress: " + str);
                    } else {
                        l4.R0(true, str, Boolean.TRUE, new C0945h(6));
                    }
                }
                break;
            case 3:
                List<ZenModeInfoDO> list2 = (List) obj;
                C1027f c1027f = (C1027f) obj3;
                if (!C0901g.a(list2)) {
                    C1027f.a aVar = c1027f.f22958q;
                    if (list2 == null) {
                        aVar.getClass();
                        list = Collections.EMPTY_LIST;
                    } else {
                        list = list2;
                    }
                    aVar.f22962d = list;
                    c1027f.f22958q.i();
                    Glide.with(c1027f).load(list2.get(0).getBackgroundUrl()).apply((BaseRequestOptions<?>) new RequestOptions().transform(new CenterCrop(), new Ca.l(R.drawable.melody_ui_ic_zen_mode_frame_mask_v2))).transition(DrawableTransitionOptions.withCrossFade(150)).into((ImageView) ((View) obj2).findViewById(R.id.zen_mode_scene_image_background));
                    break;
                }
                break;
            case 4:
                List list3 = (List) obj;
                int i12 = HearingEnhancementActivity.f21566m0;
                HearingEnhancementActivity hearingEnhancementActivity = (HearingEnhancementActivity) obj3;
                hearingEnhancementActivity.getClass();
                com.oplus.melody.common.util.A.c("HearingEnhancementActivity", new V6.g(i10, list3));
                Bundle bundle = (Bundle) obj2;
                if (bundle != null) {
                    Fragment fragmentG = hearingEnhancementActivity.u().G("current_fragment", bundle);
                    hearingEnhancementActivity.f21568b0 = fragmentG;
                    Objects.toString(fragmentG);
                    Fragment fragment = hearingEnhancementActivity.f21568b0;
                    if (fragment != null && !(fragment instanceof d0)) {
                        com.oplus.melody.common.util.A.x("HearingEnhancementActivity", "openFragment, savedInstanceState mCurrentFragment: " + hearingEnhancementActivity.f21568b0);
                        if (list3 != null && !list3.isEmpty()) {
                            z2 = false;
                        }
                        hearingEnhancementActivity.f21567a0 = z2;
                        hearingEnhancementActivity.a0(hearingEnhancementActivity.f21568b0);
                    }
                }
                com.oplus.melody.leaudio.a.a(hearingEnhancementActivity.f21571e0.f21582c, LeFilterConstants.FunType.GOLD_HEARING, true, false, null);
                if (list3 == null || list3.isEmpty()) {
                    hearingEnhancementActivity.f21567a0 = true;
                    hearingEnhancementActivity.W(true);
                } else {
                    hearingEnhancementActivity.T(list3, true);
                }
                break;
            case 5:
                int i13 = HearingEnhancementActivity.f21566m0;
                ForkJoinPool.commonPool().execute(new RunnableC1309w((la.L) obj2, r42 == true ? 1 : 0));
                ((HearingEnhancementActivity) obj3).T(null, false);
                break;
            case 6:
                SetCommandStateDTO setCommandStateDTO = (SetCommandStateDTO) obj;
                pa.l lVar = (pa.l) obj3;
                if (lVar.getActivity() != null && !lVar.getActivity().isFinishing() && !lVar.getActivity().isDestroyed() && lVar.isAdded()) {
                    if (setCommandStateDTO == null) {
                        com.oplus.melody.common.util.A.h("MultipleDevicesConnectionFragmentV2", "unpairHandheldDevice setCommandStateDTO is null!");
                    } else if (TextUtils.isEmpty(setCommandStateDTO.getAddress()) || !setCommandStateDTO.getAddress().equals(lVar.f26989z)) {
                        com.oplus.melody.common.util.A.h("MultipleDevicesConnectionFragmentV2", "unpairHandheldDevice setCommandStateDTO address not match!");
                    } else {
                        int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
                        if (setCommandStatus != 0) {
                            com.oplus.melody.common.util.A.x("MultipleDevicesConnectionFragmentV2", "unpairHandheldDevice setCommandStatus = " + setCommandStatus);
                        } else {
                            String str2 = (String) obj2;
                            com.oplus.melody.common.util.A.c("MultipleDevicesConnectionFragmentV2", new Ca.b(str2, 27));
                            o0.c.f1143a.post(new com.oplus.melody.alive.component.clicktakephoto.b(i11, lVar, str2));
                        }
                    }
                    break;
                }
                break;
            default:
                SetCommandStateDTO setCommandStateDTO2 = (SetCommandStateDTO) obj;
                v9.g gVar = (v9.g) obj3;
                gVar.getClass();
                if (setCommandStateDTO2.getSetCommandStatus() == 0) {
                    com.oplus.melody.common.util.A.b("HighAudioDetailFragment", "set codec type succeed");
                    final String str3 = gVar.f28412s;
                    final String str4 = gVar.f28410q;
                    v9.b bVar = (v9.b) obj2;
                    final int i14 = bVar.f28405a;
                    final ?? r43 = (i14 == 3 || i14 == 8) ? bVar.f28406b : 0;
                    if (TextUtils.isEmpty(str3) || !B8.a.d(str3, str4)) {
                        A6.b.g("trackHighAudio, someone is null, earbudsId: ", str3, "AppTrackHelper");
                    } else {
                        ForkJoinPool.commonPool().execute(new RunnableC0903i(i11, new Wb.l() { // from class: z8.i
                            @Override // Wb.l
                            public final Object d(Object obj4) throws JSONException {
                                Track it = (Track) obj4;
                                kotlin.jvm.internal.h.e(it, "it");
                                it.a(Integer.valueOf(r43), "hires_switch_status");
                                it.a(Integer.valueOf(i14), "high_audio_codec_type");
                                it.a(str3, "earbuds_id");
                                it.a(B8.a.c(str4), "earbuds_addr_id");
                                it.a(B8.a.a(), "device_id");
                                it.a(S.k(), "os_version");
                                it.a(B8.a.b(), "app_version");
                                it.d();
                                return Jb.l.f2618a;
                            }
                        }, new Track("melody_high_audio", "10610001")));
                    }
                } else {
                    com.oplus.melody.common.util.A.c("HighAudioDetailFragment", new B6.f(4, setCommandStateDTO2));
                }
                break;
        }
    }
}
