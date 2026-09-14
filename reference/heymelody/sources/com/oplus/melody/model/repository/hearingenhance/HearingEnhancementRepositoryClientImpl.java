package com.oplus.melody.model.repository.hearingenhance;

import D7.E;
import D7.S;
import D7.U;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.s;
import b9.C0738g;
import com.google.gson.reflect.TypeToken;
import com.oplus.melody.btsdk.api.data.EarRestoreDataInfo;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.C0941d;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.hearingenhance.HearingEnhancementRepositoryClientImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public final class HearingEnhancementRepositoryClientImpl extends a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public U f20016p;

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.hearingenhance.HearingEnhancementRepositoryClientImpl$1, reason: invalid class name */
    class AnonymousClass1 extends TypeToken<List<EarRestoreDataInfo>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.hearingenhance.HearingEnhancementRepositoryClientImpl$2, reason: invalid class name */
    public class AnonymousClass2 extends TypeToken<Map<Integer, HearingEnhanceDataDTO>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.hearingenhance.HearingEnhancementRepositoryClientImpl$3, reason: invalid class name */
    public class AnonymousClass3 extends TypeToken<Map<Integer, HearingEnhanceDataDTO>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.hearingenhance.HearingEnhancementRepositoryClientImpl$4, reason: invalid class name */
    public class AnonymousClass4 extends TypeToken<List<HearingEnhancementEntity>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.hearingenhance.HearingEnhancementRepositoryClientImpl$5, reason: invalid class name */
    public class AnonymousClass5 extends TypeToken<List<HearingEnhancementEntity>> {
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void A() {
        S.d(18011, null, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void B() {
        S.d(18032, null, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void C(HearingEnhancementEntity hearingEnhancementEntity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg1", hearingEnhancementEntity);
        S.h(18030, bundle, String.class);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> D(String str, int i10, int i11, byte[] bArr) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putInt("arg3", i11);
        bundleD.putByteArray("arg4", bArr);
        return S.h(18024, bundleD, String.class).thenApply((Function) new C0738g(27));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture E(String str, int i10, int i11, String str2, ArrayList arrayList) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putInt("arg3", i11);
        bundleD.putString("arg4", str2);
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        bundleD.putParcelableArrayList("arg5", arrayList2);
        return S.h(18023, bundleD, String.class).thenApply((Function) new C0928l(20));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> F(String str, ArrayList<EarRestoreDataDTO> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putParcelableArrayList("arg2", arrayList);
        return S.h(18025, bundle, String.class).thenApply((Function) new C0941d(11));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> G(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putBoolean("arg2", z2);
        return S.h(18019, bundle, String.class).thenApply((Function) new C0940c(10));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> H(String str, HearingDetectInfoDTO hearingDetectInfoDTO) {
        Bundle bundle = new Bundle();
        bundle.putString("arg1", str);
        bundle.putParcelable("arg2", hearingDetectInfoDTO);
        return S.h(18022, bundle, String.class).thenApply((Function) new C0928l(19));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<Integer> a(ArrayList<HearingEnhancementEntity> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("arg1", arrayList);
        return S.d(18029, bundle, null).thenApply((Function) new C0738g(28));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture b(int i10, int i11, String str) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putInt("arg3", i11);
        return S.h(18021, bundleD, String.class).thenApply((Function) new C0928l(21));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        S.d(18017, bundle, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<Map<Integer, HearingEnhanceDataDTO>> d() {
        return new U(18007, null, new AnonymousClass3().getType());
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void e(String str, int i10, byte[] bArr) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putByteArray("arg3", bArr);
        S.d(18018, bundleD, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<EarScanResultDTO> f() {
        return new U(18005, null, EarScanResultDTO.class);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<EarScanStatusDTO> g() {
        return new U(18004, null, EarScanStatusDTO.class);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<Map<Integer, HearingEnhanceDataDTO>> h() {
        return new U(18006, null, new AnonymousClass2().getType());
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<List<HearingEnhancementEntity>> i(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return new U(18026, bundle, new Function() { // from class: com.oplus.melody.model.repository.hearingenhance.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                this.f20019a.getClass();
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    return (List) (bArr == null ? null : C0917x.j("parseJsonBlob", new com.oplus.anim.s(2, bArr, new HearingEnhancementRepositoryClientImpl.AnonymousClass4().getType())));
                }
                throw MelodyException.e(0, "Unknown value type " + obj.getClass());
            }
        }, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final List<HearingEnhancementEntity> j(String str) {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("macAddress", str);
        E e10 = S.f1011a;
        return S.g(C0906l.f19501a, 18028, aVar, new C0941d(10));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void k(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        S.d(18014, bundle, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<List<HearingEnhancementEntity>> l(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return S.d(18027, bundle, null).thenApply(new Function() { // from class: com.oplus.melody.model.repository.hearingenhance.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                this.f20018a.getClass();
                byte[] byteArray = ((Bundle) obj).getByteArray("value");
                if (byteArray != null) {
                    return (List) C0917x.j("parseJsonBlob", new com.oplus.anim.s(2, byteArray, new HearingEnhancementRepositoryClientImpl.AnonymousClass5().getType()));
                }
                return null;
            }
        });
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void m(int i10, String str, ArrayList arrayList) {
        Bundle bundleD = A6.e.d(i10, "arg1", str, "arg2");
        bundleD.putParcelableArrayList("arg3", arrayList);
        S.d(18015, bundleD, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<HearingStatusDTO> n() {
        return new U(18003, null, HearingStatusDTO.class);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final byte[] p(int i10) {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("arg1", String.valueOf(i10));
        E e10 = S.f1011a;
        Cursor cursorE = S.e(C0906l.f19501a, 18031, aVar);
        if (cursorE == null || !cursorE.moveToFirst()) {
            return null;
        }
        return cursorE.getBlob(cursorE.getColumnIndex("value"));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<HearingEnhancementEntity> q(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return S.d(18016, bundle, null).thenApply((Function) new C0941d(13));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<HearingEnhancementEntity> r() {
        if (this.f20016p == null) {
            this.f20016p = new U(18001, null, HearingEnhancementEntity.class);
        }
        return this.f20016p;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<HearingEnhancementEntity> s(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("macAddress", str);
        return S.d(18013, bundle, null).thenApply((Function) new C0940c(12));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final boolean t(String str) {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("macAddress", str);
        Boolean bool = Boolean.TRUE;
        E e10 = S.f1011a;
        return bool.equals(S.f(C0906l.f19501a, 18033, aVar, new C0940c(11)));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture u(int i10, String str) {
        return S.h(18020, A6.e.d(i10, "arg1", str, "arg2"), String.class).thenApply((Function) new C0941d(12));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void v(String str, String str2) {
        S.d(18008, androidx.appcompat.widget.a.e("arg1", str, "arg2", str2), null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final boolean w(String str) {
        androidx.collection.a aVar = new androidx.collection.a();
        aVar.put("deviceName", str);
        Boolean bool = Boolean.TRUE;
        E e10 = S.f1011a;
        return bool.equals(S.f(C0906l.f19501a, 18009, aVar, new C0738g(29)));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void y() {
        S.d(18012, null, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void z() {
        S.d(18010, null, null);
    }
}
