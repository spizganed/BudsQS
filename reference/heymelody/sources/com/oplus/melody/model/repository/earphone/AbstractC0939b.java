package com.oplus.melody.model.repository.earphone;

import D7.C0379m;
import android.content.Context;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.personaldress.ToneFileVerifyInformationDTO;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EarphoneRepository.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0939b extends K7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AbstractC0939b f19942c;

    public AbstractC0939b() {
        super(3000);
    }

    public static AbstractC0939b E() {
        if (f19942c == null) {
            synchronized (AbstractC0939b.class) {
                try {
                    if (f19942c == null) {
                        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                        if (E7.a.d(heyMelodyApplication)) {
                            f19942c = new L(heyMelodyApplication);
                        } else {
                            f19942c = new EarphoneRepositoryClientImpl();
                        }
                    }
                } finally {
                }
            }
        }
        return f19942c;
    }

    public abstract androidx.lifecycle.s<List<FitDetectionDTO>> A();

    public abstract void A0(int i10, String str);

    public abstract androidx.lifecycle.s<HeadMotionTryResultDTO> B();

    public abstract CompletableFuture<SetCommandStateDTO> B0(String str, boolean z2);

    public abstract void C(String str);

    public abstract CompletableFuture C0(int i10, boolean z2, String str);

    public abstract void D(String str);

    public abstract void D0(Context context, String str, NoiseReductionInfoDTO noiseReductionInfoDTO);

    public abstract CompletableFuture E0(int i10, boolean z2, String str);

    public abstract void F(Context context, String str);

    public abstract CompletableFuture<SetCommandStateDTO> F0(String str, int i10, boolean z2, boolean z4);

    public abstract androidx.lifecycle.s<PersonalNoiseDTO> G(String str);

    public abstract CompletableFuture G0(int i10, String str);

    public List<String> H() {
        E7.a.a();
        return Collections.EMPTY_LIST;
    }

    public abstract CompletableFuture<SetCommandStateDTO> H0(String str, ToneFileVerifyInformationDTO toneFileVerifyInformationDTO);

    public abstract void I(String str);

    public abstract CompletableFuture I0(int i10, String str);

    public abstract void J(String str);

    public abstract void J0(String str);

    public abstract void K(String str);

    public abstract androidx.lifecycle.s<EarphoneDTO> K0();

    public abstract CompletableFuture<List<EarToneDTO>> L(String str);

    public abstract CompletableFuture<SetCommandStateDTO> L0(String str);

    public abstract androidx.lifecycle.s<UserInteractionDTO> M();

    public abstract CompletableFuture<PersonalNoiseDTO> M0(String str);

    public abstract void N(String str);

    public abstract void N0(String str);

    public abstract void O(Context context, String str, String str2);

    public abstract void O0(String str, boolean z2);

    public abstract void P(Context context, String str, String str2);

    public abstract void Q(int i10, String str, String str2, String str3);

    public abstract boolean R();

    public abstract boolean S(String str);

    public abstract void T(Context context, String str);

    public abstract void U(String str);

    public abstract void V(String str);

    public abstract void W(String str);

    public abstract void X();

    public abstract void Y();

    public abstract void Z();

    public boolean a(String str, int... iArr) {
        E7.a.a();
        return false;
    }

    public abstract void a0(String str);

    public abstract CompletableFuture<SetCommandStateDTO> b(String str, boolean z2);

    public abstract void b0();

    public abstract void c(String str);

    public abstract CompletableFuture c0(int i10, String str);

    public abstract void d(String str, boolean z2);

    public abstract CompletableFuture d0(int i10, int i11, String str);

    public abstract void e(String str);

    public abstract CompletableFuture e0(int i10, String str);

    public abstract void f(String str);

    public abstract void f0(int i10, String str);

    public abstract androidx.lifecycle.s<List<EarphoneDTO>> g();

    public abstract CompletableFuture g0(int i10, int i11, int i12, String str);

    public abstract androidx.lifecycle.s<EarphoneDTO> h();

    public abstract void h0(int i10, String str);

    public abstract androidx.lifecycle.s<EarphoneDTO> i();

    public abstract void i0(String str, String str2);

    public abstract androidx.lifecycle.s<EarphoneDTO> j();

    public abstract CompletableFuture<SetCommandStateDTO> j0(String str, boolean z2);

    public abstract void k(String str);

    public abstract CompletableFuture k0(int i10, String str);

    public abstract void l(String str);

    public abstract CompletableFuture l0(int i10, String str);

    public abstract EarphoneDTO m();

    public abstract CompletableFuture<SetCommandStateDTO> m0(String str, boolean z2);

    public abstract androidx.lifecycle.s<EarphoneDTO> n();

    public abstract CompletableFuture<SetCommandStateDTO> n0(String str, byte b4);

    public abstract androidx.lifecycle.s<EarphoneDTO> o();

    public abstract CompletableFuture o0(int i10, int i11, String str);

    public abstract EarphoneDTO p();

    public abstract CompletableFuture p0(int i10, boolean z2, String str);

    public abstract androidx.lifecycle.s<Integer> q();

    public abstract CompletableFuture q0(int i10, String str);

    public abstract androidx.lifecycle.s<BoxCoverActionDTO> r();

    public abstract CompletableFuture r0(int i10, String str);

    public abstract BoxCoverActionDTO s();

    public abstract CompletableFuture s0(int i10, String str);

    public abstract void t(String str);

    public abstract CompletableFuture t0(int i10, int i11, int i12, String str);

    public abstract EarphoneDTO u();

    public abstract CompletableFuture u0(String str, Context context, List list, int i10);

    public final androidx.lifecycle.t v(String str) {
        return C0379m.b(x(str));
    }

    public abstract CompletableFuture v0(int i10, int i11, String str);

    public abstract EarphoneDTO w(String str);

    public abstract void w0(String str, int i10, boolean z2, boolean z4);

    public abstract androidx.lifecycle.s<EarphoneDTO> x(String str);

    public abstract CompletableFuture x0(int i10, String str);

    public abstract void y(String str);

    public abstract CompletableFuture y0(int i10, String str);

    public abstract HeadsetRssiDetectionDTO z(String str);

    public abstract void z0(String str, String str2);
}
