package com.oplus.melody.model.repository.earphone;

import D7.U;
import D7.q0;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.session.D0;
import b9.C0738g;
import com.google.gson.reflect.TypeToken;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.repository.personaldress.ToneFileVerifyInformationDTO;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class EarphoneRepositoryClientImpl extends AbstractC0939b {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f19876s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Type f19873p = new AnonymousClass1().getType();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Type f19874q = new AnonymousClass2().getType();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Type f19875r = new AnonymousClass3().getType();

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.EarphoneRepositoryClientImpl$1, reason: invalid class name */
    public class AnonymousClass1 extends TypeToken<List<EarToneDTO>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.EarphoneRepositoryClientImpl$2, reason: invalid class name */
    public class AnonymousClass2 extends TypeToken<List<EarphoneDTO>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.EarphoneRepositoryClientImpl$3, reason: invalid class name */
    public class AnonymousClass3 extends TypeToken<List<FitDetectionDTO>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.EarphoneRepositoryClientImpl$4, reason: invalid class name */
    public class AnonymousClass4 extends TypeToken<Map<String, HeadsetRssiDetectionDTO>> {
    }

    public EarphoneRepositoryClientImpl() {
        new AnonymousClass4().getType();
    }

    public static CompletableFuture P0(int i10, Bundle bundle) {
        return D7.S.h(i10, bundle, String.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<List<FitDetectionDTO>> A() {
        return new U(3019, null, this.f19875r);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void A0(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putInt("arg1", i10);
        P0(3106, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<HeadMotionTryResultDTO> B() {
        return new U(3111, null, HeadMotionTryResultDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> B0(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putBoolean("value", z2);
        return D7.S.h(3078, bundle, String.class).thenApply((Function) new C0928l(4));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void C(String str) {
        D0.k(3110, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture C0(int i10, boolean z2, String str) {
        Bundle bundleD = A6.e.d(i10, "macAddress", str, "arg1");
        bundleD.putBoolean("value", z2);
        return D7.S.h(3079, bundleD, String.class).thenApply((Function) new C0928l(5));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void D(String str) {
        D0.k(3066, "arg1", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void D0(Context context, String str, NoiseReductionInfoDTO noiseReductionInfoDTO) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putParcelable("value", noiseReductionInfoDTO);
        P0(3036, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture E0(int i10, boolean z2, String str) {
        return F0(str, i10, z2, true);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void F(Context context, String str) {
        D0.k(3035, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> F0(String str, int i10, boolean z2, boolean z4) {
        Bundle bundleD = A6.e.d(i10, "macAddress", str, "featureId");
        bundleD.putBoolean("value", z2);
        bundleD.putBoolean("arg1", z4);
        return D7.S.h(3039, bundleD, String.class).thenApply((Function) new C0941d(1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<PersonalNoiseDTO> G(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return new U(3025, bundle, PersonalNoiseDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture G0(int i10, String str) {
        return D7.S.h(3105, A6.e.d(i10, "macAddress", str, "arg1"), String.class).thenApply((Function) new C0940c(1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> H0(String str, ToneFileVerifyInformationDTO toneFileVerifyInformationDTO) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putParcelable("value", toneFileVerifyInformationDTO);
        return D7.S.h(3056, bundle, String.class).thenApply((Function) new C0738g(17));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void I(String str) {
        D0.k(3080, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture I0(int i10, String str) {
        return D7.S.h(3097, A6.e.d(i10, "macAddress", str, "arg1"), String.class).thenApply((Function) new C0940c(2));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void J(String str) {
        D0.k(3047, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void J0(String str) {
        D0.k(3088, "arg1", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void K(String str) {
        D0.k(3104, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> K0() {
        return new U(3011, null, EarphoneDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<List<EarToneDTO>> L(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        return D7.S.h(3068, bundle, String.class).thenApply((Function) new A6.p(this, 18));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> L0(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return D7.S.h(3042, bundle, String.class).thenApply((Function) new C0941d(5));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<UserInteractionDTO> M() {
        return new U(3051, null, UserInteractionDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<PersonalNoiseDTO> M0(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return D7.S.h(3043, bundle, String.class).thenApply((Function) new C0738g(12));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void N(String str) {
        D0.k(3096, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void N0(String str) {
        D0.k(3049, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void O(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putString("deviceName", str2);
        P0(3021, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void O0(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putBoolean("arg2", z2);
        P0(3076, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void P(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putString("deviceName", str2);
        P0(3022, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void Q(int i10, String str, String str2, String str3) {
        Bundle bundleE = androidx.appcompat.widget.a.e("macAddress", str, "deviceName", str2);
        bundleE.putString("productId", str3);
        bundleE.putInt("intColor", i10);
        P0(3001, bundleE);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final boolean R() {
        D7.E e10 = D7.S.f1011a;
        Boolean bool = (Boolean) D7.S.f(C0906l.f19501a, 3082, null, new A6.i(2));
        return bool != null && bool.booleanValue();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final boolean S(String str) {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("macAddress", str);
        D7.E e10 = D7.S.f1011a;
        Boolean bool = (Boolean) D7.S.f(C0906l.f19501a, 3064, aVar, new A6.i(2));
        return bool != null && bool.booleanValue();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void T(Context context, String str) {
        D0.k(3040, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void U(String str) {
        D0.k(3048, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void V(String str) {
        D0.k(3030, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void W(String str) {
        D0.k(3031, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void X() {
        P0(3028, null);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void Y() {
        P0(3027, null);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void Z() {
        P0(3112, null);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void a0(String str) {
        D0.k(3026, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> b(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putBoolean("arg2", z2);
        return D7.S.h(3087, bundle, String.class).thenApply((Function) new C0928l(6));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void b0() {
        P0(3059, null);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void c(String str) {
        D0.k(3033, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture c0(int i10, String str) {
        return D7.S.h(3007, A6.e.d(i10, "macAddress", str, "value"), String.class).thenApply((Function) new C0928l(12));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void d(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putBoolean("value", z2);
        P0(3029, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture d0(int i10, int i11, String str) {
        Bundle bundleD = A6.e.d(i10, "macAddress", str, "arg1");
        bundleD.putInt("arg2", i11);
        return D7.S.h(3098, bundleD, String.class).thenApply((Function) new C0941d(4));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void e(String str) {
        D0.k(3086, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture e0(int i10, String str) {
        return D7.S.h(3094, A6.e.d(i10, "macAddress", str, "arg1"), String.class).thenApply((Function) new C0738g(14));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void f(String str) {
        D0.k(3032, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void f0(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putInt("value", i10);
        P0(3004, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<List<EarphoneDTO>> g() {
        return new U(3010, null, this.f19874q);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture g0(int i10, int i11, int i12, String str) {
        Bundle bundleD = A6.e.d(i10, "macAddress", str, "arg1");
        bundleD.putInt("arg2", i11);
        bundleD.putInt("arg3", i12);
        return D7.S.h(3069, bundleD, String.class).thenApply((Function) new C0928l(11));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> h() {
        return new U(3012, null, EarphoneDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void h0(int i10, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putInt("value", i10);
        P0(3099, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> i() {
        return new U(3013, null, EarphoneDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void i0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putString("arg2", "DiscoveryDialogViewModel");
        P0(3101, bundle);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> j() {
        return new U(3014, null, EarphoneDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> j0(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putBoolean("value", z2);
        return D7.S.h(3041, bundle, String.class).thenApply((Function) new C0738g(13));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void k(String str) {
        D0.k(3093, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture k0(int i10, String str) {
        return D7.S.h(3058, A6.e.d(i10, "macAddress", str, "value"), String.class).thenApply((Function) new C0738g(15));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void l(String str) {
        D0.k(3100, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture l0(int i10, String str) {
        return D7.S.h(3057, A6.e.d(i10, "macAddress", str, "value"), String.class).thenApply((Function) new C0940c(0));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO m() {
        D7.E e10 = D7.S.f1011a;
        return (EarphoneDTO) D7.S.f(C0906l.f19501a, 3061, null, new C0738g(19));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> m0(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putBoolean("value", z2);
        return D7.S.h(3050, bundle, String.class).thenApply((Function) new C0928l(10));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> n() {
        return new U(3071, null, EarphoneDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> n0(String str, byte b4) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putByte("value", b4);
        return D7.S.h(3055, bundle, String.class).thenApply((Function) new C0941d(3));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> o() {
        return new U(3095, null, EarphoneDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture o0(int i10, int i11, String str) {
        Bundle bundleD = A6.e.d(1, "macAddress", str, "arg1");
        bundleD.putInt("arg2", i11);
        return D7.S.h(3077, bundleD, String.class).thenApply((Function) new C0940c(6));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO p() {
        D7.E e10 = D7.S.f1011a;
        return (EarphoneDTO) D7.S.f(C0906l.f19501a, 3091, null, new C0928l(13));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture p0(int i10, boolean z2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putBoolean("value", z2);
        bundle.putInt("arg1", i10);
        return D7.S.h(3108, bundle, String.class).thenApply((Function) new C0940c(4));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<Integer> q() {
        return new U(3020, null);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture q0(int i10, String str) {
        return D7.S.h(3109, A6.e.d(i10, "macAddress", str, "value"), String.class).thenApply((Function) new C0928l(9));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<BoxCoverActionDTO> r() {
        return new U(3038, null, BoxCoverActionDTO.class);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture r0(int i10, String str) {
        return D7.S.h(3081, A6.e.d(i10, "macAddress", str, "arg1"), String.class).thenApply((Function) new C0738g(16));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final BoxCoverActionDTO s() {
        D7.E e10 = D7.S.f1011a;
        return (BoxCoverActionDTO) D7.S.f(C0906l.f19501a, 3074, null, new C0941d(7));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture s0(int i10, String str) {
        return D7.S.h(3070, A6.e.d(i10, "macAddress", str, "value"), String.class).thenApply((Function) new C0941d(6));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void t(String str) {
        D0.k(3046, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture t0(int i10, int i11, int i12, String str) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putInt("arg3", i11);
        bundleD.putInt("arg4", 0);
        return D7.S.h(3065, bundleD, String.class).thenApply((Function) new C0928l(7));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO u() {
        D7.E e10 = D7.S.f1011a;
        return (EarphoneDTO) D7.S.f(C0906l.f19501a, 3075, null, new C0940c(8));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture u0(String str, Context context, List list, int i10) {
        if (list == null || list.isEmpty()) {
            return q0.b(MelodyException.e(0, "infoList null or empty"));
        }
        Bundle bundleD = A6.e.d(i10, "macAddress", str, "command");
        bundleD.putParcelableArrayList("value", C0901g.b(list));
        return D7.S.h(3034, bundleD, String.class).thenApply((Function) new C0940c(3));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture v0(int i10, int i11, String str) {
        Bundle bundleD = A6.e.d(1, "arg1", str, "arg2");
        bundleD.putInt("arg3", 1);
        return D7.S.h(3092, bundleD, String.class).thenApply((Function) new C0928l(8));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO w(String str) {
        EarphoneDTO earphoneDTOD;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        androidx.lifecycle.s<EarphoneDTO> sVarX = x(str);
        if (sVarX.f8952c > 0 && (earphoneDTOD = sVarX.d()) != null) {
            return earphoneDTOD;
        }
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("macAddress", str);
        D7.E e10 = D7.S.f1011a;
        return (EarphoneDTO) D7.S.f(C0906l.f19501a, 3060, aVar, new C0940c(5));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void w0(String str, int i10, boolean z2, boolean z4) {
        Bundle bundleD = A6.e.d(i10, "macAddress", str, "arg1");
        bundleD.putBoolean("arg2", z2);
        bundleD.putBoolean("arg3", z4);
        P0(3103, bundleD);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> x(String str) {
        ConcurrentHashMap concurrentHashMap = this.f19876s;
        if (str == null) {
            str = "";
        }
        return (androidx.lifecycle.s) concurrentHashMap.computeIfAbsent(str, new A9.o(this, 29));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture x0(int i10, String str) {
        return D7.S.h(3044, A6.e.d(i10, "macAddress", str, "value"), String.class).thenApply((Function) new C0738g(18));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void y(String str) {
        D0.k(3045, "macAddress", str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture y0(int i10, String str) {
        return D7.S.h(3107, A6.e.d(i10, "macAddress", str, "arg1"), String.class).thenApply((Function) new C0941d(2));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final HeadsetRssiDetectionDTO z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("macAddress", str);
        D7.E e10 = D7.S.f1011a;
        return (HeadsetRssiDetectionDTO) D7.S.f(C0906l.f19501a, 3067, aVar, new C0940c(7));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void z0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        bundle.putString("value", str2);
        P0(3102, bundle);
    }
}
