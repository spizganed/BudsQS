package com.oplus.melody.model.repository.earphone;

import android.text.TextUtils;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.constant.AISummaryStatusType;
import com.oplus.melody.model.constant.AISummaryToneType;
import com.oplus.melody.track.track.Track;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import org.json.JSONException;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19985c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f19986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f19987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f19988r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f19989s;

    public /* synthetic */ t(L l4, EarphoneDTO earphoneDTO, UserInteractionDTO userInteractionDTO, int i10, int i11, String str, int i12) {
        this.f19983a = i12;
        this.f19984b = l4;
        this.f19985c = earphoneDTO;
        this.f19986p = userInteractionDTO;
        this.f19987q = i10;
        this.f19988r = i11;
        this.f19989s = str;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws JSONException {
        int code;
        switch (this.f19983a) {
            case 0:
                AISummaryStatusType aISummaryStatusType = (AISummaryStatusType) obj;
                L l4 = (L) this.f19984b;
                l4.getClass();
                if (aISummaryStatusType != AISummaryStatusType.BIND_SERVICE_SUCCESS) {
                    com.oplus.melody.common.util.A.h("EarphoneRepository", "bindAccessibilityAssistantService fail");
                    return null;
                }
                O7.f fVarB = O7.f.b();
                u uVar = new u(l4, (EarphoneDTO) this.f19985c, (UserInteractionDTO) this.f19986p, this.f19987q, this.f19988r, this.f19989s);
                fVarB.getClass();
                CompletableFuture.supplyAsync(new B6.a(fVarB, 17)).whenComplete((BiConsumer) new B9.b(new B9.a(fVarB, uVar, 5), 9));
                return null;
            case 1:
                L l10 = (L) this.f19984b;
                EarphoneDTO earphoneDTO = (EarphoneDTO) this.f19985c;
                UserInteractionDTO userInteractionDTO = (UserInteractionDTO) this.f19986p;
                int i10 = this.f19987q;
                int i11 = this.f19988r;
                String str = this.f19989s;
                AISummaryStatusType aISummaryStatusType2 = (AISummaryStatusType) obj;
                l10.getClass();
                com.oplus.melody.common.util.A.c("EarphoneRepository", new T8.d(aISummaryStatusType2, 29));
                switch (aISummaryStatusType2.ordinal()) {
                    case 1:
                        code = AISummaryToneType.START_SUMMARY_TONE.getCode();
                        z8.v.d(userInteractionDTO.getAction(), i10, i11, userInteractionDTO.getDeviceType(), earphoneDTO.getProductId(), earphoneDTO.getMacAddress(), N.t(earphoneDTO));
                        break;
                    case 2:
                        code = AISummaryToneType.STOP_SUMMARY_TONE.getCode();
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 12:
                    default:
                        code = AISummaryToneType.NO_SUMMARY_TONE.getCode();
                        O7.f.b().c();
                        break;
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 15:
                    case 16:
                        com.oplus.melody.common.util.A.h("EarphoneRepository", "checkTriplePinch callGlobalSummary fail, state:" + aISummaryStatusType2);
                        code = AISummaryToneType.FAIL_SUMMARY_TONE.getCode();
                        O7.f.b().c();
                        break;
                    case 9:
                        com.oplus.melody.common.util.A.h("EarphoneRepository", "checkTriplePinch callGlobalSummary fail, state:" + aISummaryStatusType2);
                        code = AISummaryToneType.FAIL_SUMMARY_TONE.getCode();
                        E8.a.T(C0906l.f19501a, C0906l.f19501a.getString(R.string.melody_common_ai_summary_disable_mode));
                        O7.f.b().c();
                        break;
                    case 13:
                        com.oplus.melody.common.util.A.h("EarphoneRepository", "checkTriplePinch callGlobalSummary fail, state:" + aISummaryStatusType2);
                        code = AISummaryToneType.FAIL_SUMMARY_TONE.getCode();
                        E8.a.T(C0906l.f19501a, C0906l.f19501a.getString(R.string.melody_common_ai_summary_doing_mode));
                        break;
                    case 14:
                        com.oplus.melody.common.util.A.h("EarphoneRepository", "checkTriplePinch callGlobalSummary fail, state:" + aISummaryStatusType2);
                        code = AISummaryToneType.FAIL_SUMMARY_TONE.getCode();
                        E8.a.T(C0906l.f19501a, C0906l.f19501a.getString(R.string.melody_common_ai_summary_power_save_mode));
                        O7.f.b().c();
                        break;
                    case 17:
                        com.oplus.melody.common.util.A.h("EarphoneRepository", "checkTriplePinch callGlobalSummary fail, state:" + aISummaryStatusType2);
                        code = AISummaryToneType.FAIL_SUMMARY_TONE.getCode();
                        E8.a.T(C0906l.f19501a, C0906l.f19501a.getString(R.string.melody_common_ai_summary_zen_mode));
                        O7.f.b().c();
                        break;
                }
                if (TextUtils.isEmpty(str)) {
                    com.oplus.melody.common.util.A.h("EarphoneRepository", "syncAIPromptSound addr is null!");
                    l10.e1();
                } else {
                    l10.w1(str, 1062, new I8.s(str, code, 7));
                }
                ForkJoinPool.commonPool().execute(new R9.h(earphoneDTO.getProductId(), earphoneDTO.getName(), code, 2));
                return null;
            default:
                Track it = (Track) obj;
                kotlin.jvm.internal.h.e(it, "it");
                it.a(Integer.valueOf(this.f19987q), "setting_value");
                int i12 = this.f19988r;
                if (i12 > 0) {
                    it.a(Integer.valueOf(i12), "count");
                }
                String str2 = this.f19989s;
                if (!TextUtils.isEmpty(str2)) {
                    it.a(str2, "eq_freq");
                }
                it.a((String) this.f19984b, "earbuds_id");
                it.a(B8.a.c((String) this.f19985c), "earbuds_addr_id");
                it.a(g0.f.a(it, "earbuds_version", (String) this.f19986p, "device_id", "os_version"), "app_version");
                it.d();
                return Jb.l.f2618a;
        }
    }

    public /* synthetic */ t(String str, String str2, int i10, int i11, String str3, String str4) {
        this.f19983a = 2;
        this.f19987q = i10;
        this.f19988r = i11;
        this.f19989s = str;
        this.f19984b = str2;
        this.f19985c = str3;
        this.f19986p = str4;
    }
}
