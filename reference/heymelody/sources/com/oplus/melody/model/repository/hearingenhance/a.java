package com.oplus.melody.model.repository.hearingenhance;

import androidx.lifecycle.s;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: compiled from: HearingEnhancementRepository.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends K7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f20017c;

    public a() {
        super(18000);
    }

    public static a o() {
        if (f20017c == null) {
            synchronized (a.class) {
                try {
                    if (f20017c == null) {
                        if (E7.a.d(C0906l.f19501a)) {
                            f20017c = new l();
                        } else {
                            f20017c = new HearingEnhancementRepositoryClientImpl();
                        }
                    }
                } finally {
                }
            }
        }
        return f20017c;
    }

    public static String x(int i10, String str) {
        return str + '_' + i10;
    }

    public abstract void A();

    public abstract void B();

    public abstract void C(HearingEnhancementEntity hearingEnhancementEntity);

    public abstract CompletableFuture<SetCommandStateDTO> D(String str, int i10, int i11, byte[] bArr);

    public abstract CompletableFuture E(String str, int i10, int i11, String str2, ArrayList arrayList);

    public abstract CompletableFuture<SetCommandStateDTO> F(String str, ArrayList<EarRestoreDataDTO> arrayList);

    public abstract CompletableFuture<SetCommandStateDTO> G(String str, boolean z2);

    public abstract CompletableFuture<SetCommandStateDTO> H(String str, HearingDetectInfoDTO hearingDetectInfoDTO);

    public abstract CompletableFuture<Integer> a(ArrayList<HearingEnhancementEntity> arrayList);

    public abstract CompletableFuture b(int i10, int i11, String str);

    public abstract void c(String str);

    public abstract s<Map<Integer, HearingEnhanceDataDTO>> d();

    public abstract void e(String str, int i10, byte[] bArr);

    public abstract s<EarScanResultDTO> f();

    public abstract s<EarScanStatusDTO> g();

    public abstract s<Map<Integer, HearingEnhanceDataDTO>> h();

    public abstract s<List<HearingEnhancementEntity>> i(String str);

    public abstract List<HearingEnhancementEntity> j(String str);

    public abstract void k(String str);

    public abstract CompletableFuture<List<HearingEnhancementEntity>> l(String str);

    public abstract void m(int i10, String str, ArrayList arrayList);

    public abstract s<HearingStatusDTO> n();

    public abstract byte[] p(int i10);

    public abstract CompletableFuture<HearingEnhancementEntity> q(String str);

    public abstract s<HearingEnhancementEntity> r();

    public abstract CompletableFuture<HearingEnhancementEntity> s(String str);

    public abstract boolean t(String str);

    public abstract CompletableFuture u(int i10, String str);

    public abstract void v(String str, String str2);

    public abstract boolean w(String str);

    public abstract void y();

    public abstract void z();
}
