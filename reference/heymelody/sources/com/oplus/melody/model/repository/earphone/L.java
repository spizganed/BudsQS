package com.oplus.melody.model.repository.earphone;

import D7.C0373g;
import D7.C0379m;
import D7.C0386u;
import D7.C0389x;
import D7.C0390y;
import D7.C0391z;
import D7.RunnableC0369c;
import D7.h0;
import D7.o0;
import D7.q0;
import L7.a;
import X7.b;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.b;
import androidx.media3.exoplayer.C0625v;
import androidx.media3.session.D0;
import androidx.media3.session.RunnableC0668o0;
import androidx.media3.session.RunnableC0677t0;
import b9.C0738g;
import b9.C0739h;
import c8.AbstractC0763a;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.drs.statistics.DataTypeConstants;
import com.oplus.melody.btsdk.api.data.BatteryInfo;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.data.DiagnosisJsonDataInfo;
import com.oplus.melody.btsdk.api.data.NoiseReductionInfo;
import com.oplus.melody.btsdk.api.data.SetCommandStateInfo;
import com.oplus.melody.btsdk.api.manager.DeviceInfoManager;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0899e;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.bluetooth.BluetoothReceiveDTO;
import com.oplus.melody.model.db.MelodyDatabase;
import com.oplus.melody.model.db.MelodyEquipmentEncryptDao;
import com.oplus.melody.model.helper.WirelessSettingHelper;
import com.oplus.melody.model.repository.earphone.EarphoneStatusDO;
import com.oplus.melody.model.repository.personaldress.ToneFileVerifyInformationDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.track.track.Track;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import kc.C1264t;
import org.json.JSONException;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: EarphoneRepositoryServerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends AbstractC0939b {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final long f19899b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final /* synthetic */ int f19900c0 = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final O7.l<List<String>> f19901A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final O7.l<List<FitDetectionDTO>> f19902B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final ConcurrentHashMap f19903C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final O7.l<Integer> f19904D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final O7.l<BoxCoverActionDTO> f19905E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final androidx.lifecycle.u<String> f19906F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final androidx.lifecycle.u<String> f19907G;
    public final androidx.lifecycle.u<String> H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final androidx.lifecycle.u<UserInteractionDTO> f19908I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final androidx.lifecycle.u<DeviceInfo> f19909J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final androidx.lifecycle.u<DeviceInfo> f19910K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final androidx.lifecycle.u<DiagnosisJsonDataInfo> f19911L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final androidx.lifecycle.u<HeadMotionTryResultDTO> f19912M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public final O7.l<EarphoneDTO> f19913N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public final O7.l<EarphoneDTO> f19914O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public final O7.l<String> f19915P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final ConcurrentHashMap f19916Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public final ConcurrentHashMap f19917R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public final ConcurrentHashMap f19918S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final com.oplus.melody.model.scan.b f19919T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public final LinkedList f19920U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public final AtomicInteger f19921V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f19922W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f19923X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public q0 f19924Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public q0 f19925Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CompletableFuture<Void> f19926a0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MelodyEquipmentEncryptDao f19932u;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap f19927p = new ConcurrentHashMap();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap f19928q = new ConcurrentHashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap f19929r = new ConcurrentHashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConcurrentHashMap f19930s = new ConcurrentHashMap();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap f19931t = new ConcurrentHashMap();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ConcurrentHashMap f19933v = new ConcurrentHashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap f19934w = new ConcurrentHashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConcurrentHashMap f19935x = new ConcurrentHashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap f19936y = new ConcurrentHashMap();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f19937z = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: EarphoneRepositoryServerImpl.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19940c;
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f19899b0 = timeUnit.toMillis(3L);
        timeUnit.toMillis(5L);
        TimeUnit.DAYS.toMillis(1L);
    }

    public L(HeyMelodyApplication heyMelodyApplication) {
        new CopyOnWriteArrayList();
        this.f19901A = new O7.l<>();
        this.f19902B = new O7.l<>();
        this.f19903C = new ConcurrentHashMap();
        this.f19904D = new O7.l<>();
        this.f19905E = new O7.l<>();
        this.f19906F = new androidx.lifecycle.u<>();
        this.f19907G = new androidx.lifecycle.u<>();
        this.H = new androidx.lifecycle.u<>();
        this.f19908I = new androidx.lifecycle.u<>();
        this.f19909J = new androidx.lifecycle.u<>();
        this.f19910K = new androidx.lifecycle.u<>();
        this.f19911L = new androidx.lifecycle.u<>();
        this.f19912M = new androidx.lifecycle.u<>();
        this.f19913N = new O7.l<>();
        this.f19914O = new O7.l<>();
        this.f19915P = new O7.l<>();
        this.f19916Q = new ConcurrentHashMap();
        this.f19917R = new ConcurrentHashMap();
        this.f19918S = new ConcurrentHashMap();
        this.f19920U = new LinkedList();
        this.f19921V = new AtomicInteger();
        this.f19922W = new ConcurrentHashMap<>();
        MelodyEquipmentEncryptDao melodyEquipmentEncryptDaoN = MelodyEquipmentEncryptDao.n();
        this.f19932u = melodyEquipmentEncryptDaoN;
        this.f19919T = new com.oplus.melody.model.scan.b(heyMelodyApplication.getApplicationContext(), this);
        O7.l<List<com.oplus.melody.model.db.E>> lVar = melodyEquipmentEncryptDaoN.f19735a;
        D7.E e10 = o0.c.f1146d;
        C0379m.i(lVar, new C9.a(this, 15), e10);
        Object obj = L7.a.f3010c;
        C0379m.i(a.C0032a.a().a(), new C6.e(this, 21), e10);
        s1("<init>");
    }

    public static void Q0(int i10, DeviceInfo deviceInfo) {
        if (!C0373g.f1086l && i10 == 2 && com.oplus.melody.common.util.S.s(C0906l.f19501a) && !TextUtils.isEmpty(deviceInfo.getDeviceAddress())) {
            Object obj = X7.b.f5996c;
            b.a.a().d(deviceInfo.getDeviceAddress(), deviceInfo.getDeviceName(), D1.f.M(deviceInfo.getProductId()), null);
        }
    }

    public static int T0(int[] iArr, int i10) {
        for (int i11 : iArr) {
            if (i11 == i10) {
                return 3;
            }
        }
        return i10;
    }

    public static NoiseReductionInfoDTO U0(NoiseReductionInfo noiseReductionInfo) {
        if (noiseReductionInfo == null) {
            return null;
        }
        com.oplus.melody.common.util.A.b("EarphoneRepository", "refreshNoiseReductionInfo: start convert noiseReductionInfo");
        NoiseReductionInfoDTO noiseReductionInfoDTO = new NoiseReductionInfoDTO(noiseReductionInfo);
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "refreshNoiseReductionInfo: after convert result:" + noiseReductionInfoDTO);
        }
        return noiseReductionInfoDTO;
    }

    public static com.oplus.melody.model.db.E W0(int i10, String str, String str2, String str3) {
        com.oplus.melody.common.util.A.r(str);
        com.oplus.melody.common.util.A.q(str2);
        if (TextUtils.isEmpty(str2) || !com.google.android.play.core.appupdate.c.J(D1.f.m(str3))) {
            WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str3, str2);
            if (whitelistConfigDTOC == null && (whitelistConfigDTOC = AbstractC1508a.f().a(str)) == null) {
                return null;
            }
            String name = whitelistConfigDTOC.getName();
            str3 = whitelistConfigDTOC.getId();
            str2 = name;
        }
        int iW = N.w(i10, str3);
        if (iW != -1) {
            Z7.a.g().l(iW, str3);
        }
        com.oplus.melody.model.db.E e10 = new com.oplus.melody.model.db.E();
        e10.setMacAddress(str);
        e10.setName(str2);
        e10.setProductId(str3);
        e10.setColorId(iW);
        return e10;
    }

    public static boolean h1(DeviceInfo deviceInfo) {
        if (!i1(deviceInfo, deviceInfo.getBatteryInfoMillis())) {
            return false;
        }
        List<BatteryInfo> batteryInfo = deviceInfo.getBatteryInfo();
        if (batteryInfo == null) {
            batteryInfo = Collections.EMPTY_LIST;
        }
        for (BatteryInfo batteryInfo2 : batteryInfo) {
            if (batteryInfo2 != null && batteryInfo2.mLevel > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean i1(DeviceInfo deviceInfo, long j5) {
        return (deviceInfo.isConnected() && j5 >= deviceInfo.getConnectedChangedMillis()) || SystemClock.elapsedRealtime() < j5 + f19899b0;
    }

    public static String j1(int i10, String str) {
        return str + '_' + i10;
    }

    public static void u1(Set set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        com.oplus.melody.common.util.A.f("EarphoneRepository", "resetPopCloseTime " + set);
        SharedPreferences.Editor editorEdit = MelodyAlivePreferencesHelper.e().edit();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            editorEdit.remove(MelodyAlivePreferencesHelper.g(12, (String) it.next()));
        }
        editorEdit.apply();
    }

    public static void v1(BluetoothReceiveDTO bluetoothReceiveDTO) {
        DeviceInfo deviceInfo;
        if (bluetoothReceiveDTO == null || (deviceInfo = (DeviceInfo) bluetoothReceiveDTO.getData()) == null) {
            return;
        }
        WirelessSettingHelper.sendBatteryInfo(C0906l.f19501a, deviceInfo.getDeviceAddress(), N.e(1, deviceInfo.getBatteryInfo()), N.e(2, deviceInfo.getBatteryInfo()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y1(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        com.oplus.melody.common.util.A.f("EarphoneRepository", "updatePopCloseTime " + collection);
        androidx.collection.b bVar = new androidx.collection.b(collection);
        String string = Long.toString(System.currentTimeMillis());
        SharedPreferences sharedPreferencesE = MelodyAlivePreferencesHelper.e();
        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
        b.a aVar = new b.a();
        while (aVar.hasNext()) {
            String strG = MelodyAlivePreferencesHelper.g(12, (String) aVar.next());
            androidx.collection.b bVar2 = new androidx.collection.b(sharedPreferencesE.getStringSet(strG, Collections.EMPTY_SET));
            bVar2.add(string);
            while (bVar2.f7498c > 2) {
                bVar2.remove((String) Collections.min(bVar2, new V0.b(1)));
            }
            editorEdit.putStringSet(strG, bVar2);
        }
        editorEdit.apply();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<List<FitDetectionDTO>> A() {
        return this.f19902B;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void A0(int i10, String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            com.oplus.melody.common.util.A.f("EarphoneRepository", "setReconnectPopupSwitch invalid address " + str);
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null || eC1.getReconnectPopupSwitch() != i10) {
            if (eC1 != null) {
                eC1.setReconnectPopupSwitch(i10);
                m1(str);
            }
            ForkJoinPool.commonPool().execute(new y(this, str, i10, 1));
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<HeadMotionTryResultDTO> B() {
        return this.f19912M;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> B0(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setControlGuideModeStatus addr is null!");
            return e1();
        }
        return w1(str, 1037, new R8.y(str, z2 ? 1 : 0, 3));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void C(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "getHeadMotionType: address is empty ...");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1101, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture C0(int i10, boolean z2, String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setControlGuideModeStatus addr is null!");
            return e1();
        }
        return w1(str, 1057, new x(str, z2 ? 1 : 0, i10, 0));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void D(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "getCodecType: address is empty ...");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1065, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void D0(Context context, String str, NoiseReductionInfoDTO noiseReductionInfoDTO) {
        Optional.ofNullable(noiseReductionInfoDTO).map(new C0738g(23)).ifPresent(new I6.g(1, context, str));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture E0(int i10, boolean z2, String str) {
        return F0(str, i10, z2, true);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void F(Context context, String str) {
        Intent intentU = com.google.android.play.core.appupdate.c.u(context, 1045);
        intentU.putExtra("param_address", str);
        com.google.android.play.core.appupdate.c.Q(context, intentU);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> F0(final String str, final int i10, final boolean z2, final boolean z4) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1027, new Supplier() { // from class: com.oplus.melody.model.repository.earphone.H
                @Override // java.util.function.Supplier
                public final Object get() {
                    com.google.android.play.core.appupdate.c.U(C0906l.f19501a, str, i10, z2, z4);
                    return new q0(5L, TimeUnit.SECONDS);
                }
            });
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setSwitchFeature addr is null!");
        return e1();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s G(String str) {
        return (O7.l) this.f19903C.computeIfAbsent(str, new C0738g(21));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture G0(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setTapLevelSettingValue addr is null!");
            return e1();
        }
        CompletableFuture<SetCommandStateDTO> completableFutureW1 = w1(str, 1069, new D6.a(str, i10, 4));
        completableFutureW1.whenComplete((BiConsumer<? super SetCommandStateDTO, ? super Throwable>) new com.oplus.melody.app.discovery.C(this, str, i10, 1));
        return completableFutureW1;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final List<String> H() {
        CompletableFuture<Void> completableFuture = this.f19926a0;
        if (completableFuture != null && completableFuture.isCompletedExceptionally()) {
            s1("getSortedBondedDeviceIds");
        }
        return (List) this.f19934w.entrySet().stream().filter(new c8.l(this, 1)).map(new C0738g(26)).sorted().collect(Collectors.toList());
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> H0(String str, ToneFileVerifyInformationDTO toneFileVerifyInformationDTO) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1047, new C0386u(20, str, toneFileVerifyInformationDTO));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setToneTheme addr is null!");
        return e1();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void I(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "getSpineRelatedDataRange addr is null!");
        } else {
            ForkJoinPool.commonPool().execute(new Ca.h(str, 1));
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture I0(final int i10, final String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setVolumeValueInfo addr is null!");
            return e1();
        }
        CompletableFuture<SetCommandStateDTO> completableFutureW1 = w1(str, 1063, new R8.y(str, i10, 4));
        completableFutureW1.whenComplete(new BiConsumer() { // from class: com.oplus.melody.model.repository.earphone.G
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                SetCommandStateDTO setCommandStateDTO = (SetCommandStateDTO) obj;
                Throwable th = (Throwable) obj2;
                L l4 = this.f19879a;
                l4.getClass();
                int i11 = i10;
                if (th != null) {
                    com.oplus.melody.common.util.A.i("EarphoneRepository", "setVolumeValueInfo set value " + i11, th);
                    return;
                }
                int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
                if (setCommandStatus != 0) {
                    com.oplus.melody.common.util.A.h("EarphoneRepository", "setVolumeValueInfo fail, getSetCommandStatus " + setCommandStatus);
                } else {
                    String str2 = str;
                    l4.N(str2);
                    EarphoneDTO earphoneDTOW = l4.w(str2);
                    C1264t.t(AppConstant$FunctionType.HEADPHONE_PROMPT_VOLUME.getFunType(), earphoneDTOW.getProductId(), str2, N.t(earphoneDTOW), String.valueOf(i11));
                }
            }
        });
        return completableFutureW1;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void J(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "getSupportNoiseReduction: address is empty ...");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1025, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void J0(String str) {
        com.oplus.melody.common.util.A.c("EarphoneRepository", new C8.a(str, 29));
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, DataTypeConstants.COMMON, "param_address", str, heyMelodyApplication);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void K(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "getVolumeValueInfo addr is null!");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1092, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> K0() {
        O7.l<BoxCoverActionDTO> lVar = this.f19905E;
        BoxCoverActionDTO boxCoverActionDTOD = lVar.d();
        if (boxCoverActionDTOD != null && !boxCoverActionDTOD.isBoxOpen()) {
            x1(null, "sppCoverOpen");
        }
        return C0379m.e(lVar, new B(this, 0));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<List<EarToneDTO>> L(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1062);
        intentU.putExtra("param_address", str);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
        q0 q0Var = new q0(5L, TimeUnit.SECONDS);
        Z6.a aVar = new Z6.a(q0Var, 2);
        synchronized (this.f19920U) {
            this.f19920U.add(aVar);
        }
        return q0Var;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> L0(String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1029, new D6.c(str, 16));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "startFitDetection addr is null!");
        return e1();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<UserInteractionDTO> M() {
        return this.f19908I;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<PersonalNoiseDTO> M0(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, 1033, "param_address", str, heyMelodyApplication);
        q0 q0Var = this.f19924Y;
        if (q0Var != null) {
            q0Var.cancel(true);
        }
        q0 q0Var2 = new q0(5L, TimeUnit.SECONDS);
        this.f19924Y = q0Var2;
        return q0Var2;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void N(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "getVolumeValueInfo addr is null!");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1084, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void N0(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "stopFitDetection addr is null!");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, DataTypeConstants.SETTING_KEY, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    @SuppressLint({"MissingPermission"})
    public final void O(Context context, String str, String str2) {
        if (Y.j(AbstractC1508a.f().c(null, str2)) || !E8.a.H(str2)) {
            Context applicationContext = context.getApplicationContext();
            C0391z.f1171d.getClass();
            BluetoothDevice bluetoothDeviceI = C0391z.i(str);
            BluetoothProfile bluetoothProfileC = U6.a.b(applicationContext).c(1);
            if (bluetoothProfileC == null || bluetoothDeviceI == null) {
                return;
            }
            int connectionState = bluetoothProfileC.getConnectionState(bluetoothDeviceI);
            com.oplus.melody.common.util.A.c("EarphoneRepository", new I8.s(connectionState, str, 8));
            final int iH = connectionState == 2 ? com.oplus.drs.core.d.h(bluetoothDeviceI) : -1;
            try {
                if (TextUtils.isEmpty(str2)) {
                    throw MelodyException.e(0, "isSingleHeadsetByConfig deviceName is empty!");
                }
                final boolean zK = Y.k(AbstractC1508a.f().c(null, str2));
                R0(true, str, Integer.valueOf(connectionState), new BiConsumer() { // from class: com.oplus.melody.model.repository.earphone.z
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        int i10;
                        Integer num = (Integer) obj;
                        EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                        if (zK && (i10 = iH) != -1) {
                            EarphoneStatusDO.a aVar = (EarphoneStatusDO.a) com.oplus.melody.common.data.a.copyOf(earphoneStatusDO.getHeadsetLeftBatteryStatus(), EarphoneStatusDO.a.class);
                            aVar.setBattery(i10);
                            earphoneStatusDO.setHeadsetLeftBatteryStatus(aVar);
                        }
                        int iIntValue = num.intValue();
                        Pattern pattern = N.f19941a;
                        int i11 = 2;
                        if (iIntValue != 2) {
                            i11 = 1;
                            if (iIntValue != 1) {
                                i11 = 3;
                                if (iIntValue == 3) {
                                    i11 = 4;
                                }
                            }
                        }
                        earphoneStatusDO.setHeadsetConnectionState(i11);
                    }
                });
            } catch (MelodyException e10) {
                com.oplus.melody.common.util.A.i("EarphoneRepository", "initHeadsetConnectionStateAndBatteryInfo", e10);
            }
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void O0(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("param_host_triangle_is_auto_switch_link_opened", !z2 ? 1 : 0);
        com.oplus.melody.common.util.A.c("EarphoneRepository", new E9.r(7, z2));
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1069);
        intentU.putExtra("param_address", str);
        intentU.putExtra("param_host_triangle_info", bundle);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void P(Context context, String str, String str2) {
        if (E8.a.H(str2)) {
            return;
        }
        int iA = com.google.android.play.core.appupdate.c.A(str);
        Intent intentU = com.google.android.play.core.appupdate.c.u(context, 1043);
        intentU.putExtra("param_address", str);
        intentU.putExtra("param_product_id", iA);
        com.google.android.play.core.appupdate.c.Q(context, intentU);
    }

    public final void P0(DeviceInfo deviceInfo) {
        if (TextUtils.isEmpty(deviceInfo.getDeviceAddress())) {
            return;
        }
        Q(deviceInfo.getColorId(), deviceInfo.getDeviceAddress(), deviceInfo.getDeviceName(), D1.f.M(deviceInfo.getProductId()));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void Q(int i10, String str, String str2, String str3) {
        com.oplus.melody.model.db.E eW0 = W0(i10, str, str2, str3);
        if (eW0 == null) {
            com.oplus.melody.common.util.A.r(str);
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null || !TextUtils.equals(eW0.getMacAddress(), eC1.getMacAddress())) {
            ForkJoinPool.commonPool().execute(new E9.k(21, this, eW0));
        } else {
            com.oplus.melody.common.util.A.r(str);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final boolean R() {
        return MelodyDatabase.f19707l != null;
    }

    public final <T> boolean R0(final boolean z2, final String str, final T t10, final BiConsumer<T, EarphoneStatusDO> biConsumer) {
        final boolean[] zArr = {false};
        this.f19934w.compute(str, new BiFunction() { // from class: com.oplus.melody.model.repository.earphone.J
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                EarphoneStatusDO earphoneStatusDO2 = (EarphoneStatusDO) com.oplus.melody.common.data.a.copyOf(earphoneStatusDO, EarphoneStatusDO.class);
                if (!earphoneStatusDO2.isInitialized()) {
                    DeviceInfoManager deviceInfoManager = DeviceInfoManager.a.f19280a;
                    String str2 = str;
                    DeviceInfo deviceInfoF = deviceInfoManager.f(str2);
                    com.oplus.melody.common.util.A.c("EarphoneRepository", new B9.f(16, deviceInfoF, str2));
                    if (deviceInfoF != null) {
                        earphoneStatusDO2.setInitialized(true);
                        earphoneStatusDO2.setDeviceBonded(deviceInfoF.getDeviceBondState() == 12);
                        int deviceAclConnectState = deviceInfoF.getDeviceAclConnectState();
                        Pattern pattern = N.f19941a;
                        earphoneStatusDO2.setAclConnectionState(deviceAclConnectState);
                        earphoneStatusDO2.setHeadsetConnectionState(deviceInfoF.getDeviceHeadsetConnectState());
                        earphoneStatusDO2.setA2dpConnectionState(deviceInfoF.getDeviceA2dpConnectState());
                        earphoneStatusDO2.setLeAudioConnectionStateMap(C0901g.c(deviceInfoF.getDeviceLeAudioConnectStateMap()));
                        earphoneStatusDO2.setLeAudioConnectionTimeMap(C0901g.c(deviceInfoF.getLeAudioConnectionTimeMap()));
                    }
                }
                biConsumer.accept(t10, earphoneStatusDO2);
                boolean z4 = z2;
                if (z4 && earphoneStatusDO != null && earphoneStatusDO.equals(earphoneStatusDO2)) {
                    return earphoneStatusDO;
                }
                zArr[0] = z4;
                return earphoneStatusDO2;
            }
        });
        if (!zArr[0]) {
            return false;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 != null) {
            m1(eC1.getMacAddress());
        }
        return true;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final boolean S(String str) {
        DeviceInfo deviceInfoF = DeviceInfoManager.a.f19280a.f(str);
        if (deviceInfoF == null || deviceInfoF.getDeviceA2dpConnectState() != 2) {
            return false;
        }
        Object obj = L7.a.f3010c;
        return a.C0032a.a().c(1, deviceInfoF.getDevice()) == 2;
    }

    public final void S0(final int i10, final DeviceInfo deviceInfo) {
        int deviceAclConnectState;
        String str;
        if (i10 == 1) {
            deviceAclConnectState = deviceInfo.getDeviceAclConnectState();
            str = "ACL";
        } else if (i10 == 2) {
            deviceAclConnectState = deviceInfo.getDeviceHeadsetConnectState();
            str = "HFP";
        } else if (i10 != 3) {
            str = "";
            deviceAclConnectState = 0;
        } else {
            deviceAclConnectState = deviceInfo.getDeviceConnectState();
            str = "SPP";
        }
        if (deviceAclConnectState == 2 || deviceAclConnectState == 3) {
            String deviceAddress = deviceInfo.getDeviceAddress();
            ConcurrentHashMap concurrentHashMap = this.f19928q;
            Long l4 = (Long) concurrentHashMap.get(deviceAddress);
            long jElapsedRealtime = l4 == null ? 0L : SystemClock.elapsedRealtime() - l4.longValue();
            ConcurrentHashMap concurrentHashMap2 = this.f19927p;
            Pair pair = (Pair) concurrentHashMap2.get(deviceAddress);
            if (com.oplus.melody.common.util.A.l()) {
                com.oplus.melody.common.util.A.f("EarphoneRepository", "connectTrack: state:" + deviceAclConnectState + ", type: " + str + ", name: " + deviceInfo.getDeviceName() + ", addr: " + deviceAddress + ", costTime: " + jElapsedRealtime + ", errorState: " + deviceInfo.getDeviceErrorState() + ", pair: " + pair + ", connectMap: " + concurrentHashMap2);
            }
            if (pair == null || ((Integer) pair.first).intValue() != deviceAclConnectState) {
                if (deviceAclConnectState == 2) {
                    concurrentHashMap2.put(deviceAddress, new Pair(Integer.valueOf(deviceAclConnectState), Long.valueOf(SystemClock.elapsedRealtime())));
                    final long j5 = jElapsedRealtime;
                    o0.c.f1146d.a().postDelayed(new Runnable() { // from class: com.oplus.melody.model.repository.earphone.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            L l10 = this.f19975a;
                            l10.getClass();
                            EarphoneDTO earphoneDTOW = l10.w(deviceInfo.getDeviceAddress());
                            if (earphoneDTOW == null) {
                                return;
                            }
                            final String productId = earphoneDTOW.getProductId();
                            final String macAddress = earphoneDTOW.getMacAddress();
                            final String strT = N.t(earphoneDTOW);
                            final String strS = N.s(earphoneDTOW);
                            final int i11 = C0373g.f1076a ? 10 : 1;
                            if (TextUtils.isEmpty(productId) || !B8.a.d(productId, macAddress)) {
                                A6.b.g("trackEarbudsConnect, someone is null, earbudsId: ", productId, "AppTrackHelper");
                                return;
                            }
                            final int i12 = i10;
                            final long j9 = j5;
                            ForkJoinPool.commonPool().execute(new RunnableC0903i(16, new Wb.l() { // from class: z8.h
                                @Override // Wb.l
                                public final Object d(Object obj) throws JSONException {
                                    Track it = (Track) obj;
                                    kotlin.jvm.internal.h.e(it, "it");
                                    it.a(strS, "earbuds_batteries");
                                    int i13 = i12;
                                    if (i13 > 0) {
                                        it.a(Integer.valueOf(i13), "connect_type");
                                    }
                                    int i14 = i11;
                                    if (i14 >= 0) {
                                        it.a(Integer.valueOf(i14), "connect_state");
                                    }
                                    long j10 = j9;
                                    if (j10 > 0) {
                                        it.a(Long.valueOf(j10), "cost_time");
                                    }
                                    it.a(productId, "earbuds_id");
                                    it.a(B8.a.c(macAddress), "earbuds_addr_id");
                                    it.a(g0.f.a(it, "earbuds_version", strT, "device_id", "os_version"), "app_version");
                                    it.d();
                                    return Jb.l.f2618a;
                                }
                            }, new Track("melody_earbuds_connect", "10610001")));
                        }
                    }, 1000L);
                } else if (pair != null) {
                    concurrentHashMap2.remove(deviceAddress);
                    concurrentHashMap.remove(deviceAddress);
                    EarphoneDTO earphoneDTOW = w(deviceInfo.getDeviceAddress());
                    if (earphoneDTOW == null) {
                        return;
                    }
                    o0.c.f1146d.a().postDelayed(new RunnableC0668o0(this, pair, earphoneDTOW, deviceInfo, 4), 1000L);
                }
            }
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void T(Context context, String str) {
        Intent intentU = com.google.android.play.core.appupdate.c.u(context, 1038);
        intentU.putExtra("param_address", str);
        com.google.android.play.core.appupdate.c.Q(context, intentU);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void U(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "requestDeviceVersion: address is empty ...");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1044, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void V(String str) {
        com.oplus.melody.common.util.A.f("EarphoneRepository", "resetCurrentCoverState: " + str);
        BoxCoverActionDTO boxCoverActionDTOD = this.f19905E.d();
        if (boxCoverActionDTOD != null && TextUtils.equals(boxCoverActionDTOD.getMacAddress(), str)) {
            x1(null, "resetCurrentCoverState");
        }
        C0379m.a(this.f19906F, str, null);
    }

    public final EarphoneDTO V0(String str) {
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null) {
            com.oplus.melody.common.util.A.r(str);
            return null;
        }
        EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) this.f19934w.get(eC1.getMacAddress());
        if (earphoneStatusDO == null) {
            com.oplus.melody.common.util.A.r(str);
            earphoneStatusDO = new EarphoneStatusDO();
        }
        return EarphoneDTO.createFrom(eC1, earphoneStatusDO);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [int[], java.lang.Cloneable, java.lang.Object] */
    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void W(String str) {
        ?? r02 = {5};
        com.oplus.melody.common.util.A.f("EarphoneRepository", "resetCurrentFailedState: " + str);
        R0(true, str, r02, new C0949l(this, r02, 1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void X() {
        this.f19936y.clear();
        com.oplus.melody.model.scan.b bVar = this.f19919T;
        bVar.getClass();
        com.oplus.melody.common.util.A.b("OplusBleRssiManager", "resetDiscoveryForeground");
        bVar.f20227c.clear();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.f19937z;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        copyOnWriteArrayList.clear();
        l1("resetDiscoveryForeground");
    }

    public final EarphoneDTO X0(String str) {
        if (str == null || !t8.q.j()) {
            return null;
        }
        return V0(str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void Y() {
        this.f19902B.m(null);
    }

    public final void Y0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f19936y.remove(str);
        if (this.f19937z.remove(str)) {
            l1("discoverClose");
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void Z() {
        C0379m.k(this.f19912M, new HeadMotionTryResultDTO(null, -1));
    }

    public final void Z0(BluetoothReceiveDTO<?> bluetoothReceiveDTO) {
        SetCommandStateInfo setCommandStateInfo;
        if (bluetoothReceiveDTO == null || (setCommandStateInfo = (SetCommandStateInfo) bluetoothReceiveDTO.getData()) == null) {
            return;
        }
        CompletableFuture completableFuture = (CompletableFuture) this.f19916Q.remove(j1(setCommandStateInfo.mResponseCommand & (-32769), setCommandStateInfo.getAddress()));
        if (completableFuture != null && !completableFuture.isDone()) {
            Pattern pattern = N.f19941a;
            SetCommandStateDTO setCommandStateDTO = new SetCommandStateDTO();
            setCommandStateDTO.setAddress(setCommandStateInfo.getAddress());
            setCommandStateDTO.setSetCommandStatus(setCommandStateInfo.getSetStatus());
            completableFuture.complete(setCommandStateDTO);
        }
        if (setCommandStateInfo.isNoiseReductionRsp() && setCommandStateInfo.isSuccess()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "afterNoiseSetCommandStateInfo: start get the new Noise reduction info from remote device");
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1023, "param_address", setCommandStateInfo.mAddress, heyMelodyApplication);
        }
        if (setCommandStateInfo.isSetEqStatusRsp() && setCommandStateInfo.isSuccess()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "afterEqSetCommandStateInfo: start get the new eq mode from remote device");
            HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
            A6.g.i(heyMelodyApplication2, 1016, "param_address", setCommandStateInfo.mAddress, heyMelodyApplication2);
        }
        if (setCommandStateInfo.isSetFreeDialogRsp() && setCommandStateInfo.isSuccess()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "after free dialog time SetCommandStateInfo: start get the new free dialog time");
            HeyMelodyApplication heyMelodyApplication3 = C0906l.f19501a;
            A6.g.i(heyMelodyApplication3, 1038, "param_address", setCommandStateInfo.mAddress, heyMelodyApplication3);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final boolean a(String str, int... iArr) {
        int iIntValue = ((Integer) Optional.ofNullable((EarphoneStatusDO) this.f19934w.get(str)).map(new C0738g(24)).orElse(0)).intValue();
        for (int i10 : iArr) {
            if (i10 == iIntValue) {
                return true;
            }
        }
        return false;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void a0(String str) {
        O7.l lVar = (O7.l) this.f19903C.get(str);
        if (lVar != null) {
            lVar.m(null);
        }
    }

    public final void a1(DeviceInfo deviceInfo) {
        if (TextUtils.isEmpty(deviceInfo.getDeviceAddress())) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "fillDeviceInfoColor deviceInfo exception , return");
            return;
        }
        if (deviceInfo.getColorId() >= 0) {
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(deviceInfo.getDeviceAddress());
        if (eC1 != null) {
            if (eC1.getColorId() >= 0) {
                deviceInfo.setColorId(eC1.getColorId());
                return;
            }
            com.oplus.melody.common.util.A.h("EarphoneRepository", " fillDeviceInfoColor exception ,current colorId = " + eC1.getColorId() + " , addr = " + com.oplus.melody.common.util.A.r(deviceInfo.getDeviceAddress()));
            return;
        }
        WhitelistConfigDTO whitelistConfigDTOB = AbstractC1508a.f().b(deviceInfo.getProductId(), deviceInfo.getDeviceName());
        if (com.oplus.melody.common.util.S.s(C0906l.f19501a) || whitelistConfigDTOB == null) {
            return;
        }
        if ("realme".equals(whitelistConfigDTOB.getBrand()) && whitelistConfigDTOB.getSupportSpp()) {
            return;
        }
        int iW = N.w(deviceInfo.getColorId(), whitelistConfigDTOB.getId());
        if (iW >= 0) {
            deviceInfo.setColorId(iW);
            com.oplus.melody.common.util.A.c("EarphoneRepository", new Z6.d(deviceInfo, iW));
            g1(iW, deviceInfo.getDeviceAddress(), deviceInfo.getDeviceName(), whitelistConfigDTOB.getId());
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> b(String str, boolean z2) {
        if (TextUtils.isEmpty(str) && z2) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "m_spp_le.directConnectSpp addr is null!");
            return q0.b(MelodyException.e(0, "Invalid address"));
        }
        com.oplus.melody.common.util.A.c("EarphoneRepository", new S6.b(z2, str, 1));
        q0 q0Var = this.f19925Z;
        if (q0Var != null && !q0Var.isDone()) {
            this.f19925Z.cancel(true);
        }
        if (!z2) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1078);
            intentU.putExtra("param_address", str);
            intentU.putExtra("param_connect_state", false);
            com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
            return q0.b(MelodyException.e(0, "device not connected"));
        }
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        Intent intentU2 = com.google.android.play.core.appupdate.c.u(heyMelodyApplication2, 1078);
        intentU2.putExtra("param_address", str);
        intentU2.putExtra("param_connect_state", true);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication2, intentU2);
        q0 q0Var2 = new q0(5L, TimeUnit.SECONDS);
        this.f19925Z = q0Var2;
        return q0Var2;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void b0() {
        C0379m.k(this.f19908I, new UserInteractionDTO(-1, -1, -1, -1));
    }

    public final String b1() {
        EarphoneDTO earphoneDTOD;
        List<String> listH = H();
        Iterator<String> it = listH.iterator();
        int i10 = 0;
        String macAddress = null;
        while (it.hasNext()) {
            com.oplus.melody.model.db.E eC1 = c1(it.next());
            if (eC1 != null) {
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) this.f19934w.get(eC1.getMacAddress());
                if (earphoneStatusDO != null) {
                    i = earphoneStatusDO.getMConnectionState() == 2 ? 129 : 1;
                    if (earphoneStatusDO.getMHeadsetConnectionState() == 2) {
                        i |= 2;
                    }
                    if (earphoneStatusDO.getMA2dpConnectionState() == 2) {
                        i |= 4;
                    }
                    if (earphoneStatusDO.getLeAudioConnectionStateMap().containsValue(2)) {
                        i |= 8;
                    }
                    if (earphoneStatusDO.getHeadsetActive() > 0) {
                        i |= 16;
                    }
                    if (earphoneStatusDO.getA2dpActive() > 0) {
                        i |= 32;
                    }
                    if (earphoneStatusDO.getLeActive() > 0) {
                        i |= 64;
                    }
                }
                if (i > i10) {
                    macAddress = eC1.getMacAddress();
                    i10 = i;
                }
            }
        }
        if (TextUtils.isEmpty(macAddress) && (earphoneDTOD = this.f19914O.d()) != null && listH.contains(earphoneDTOD.getMacAddress())) {
            macAddress = earphoneDTOD.getMacAddress();
        }
        com.oplus.melody.common.util.A.r(macAddress);
        Integer.toHexString(i10);
        return macAddress;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void c(String str) {
        com.oplus.melody.common.util.A.x("EarphoneRepository", "disconnect: " + com.oplus.melody.common.util.A.r(str));
        EarphoneDTO earphoneDTOW = w(str);
        if (earphoneDTOW == null) {
            return;
        }
        if (earphoneDTOW.getConnectionState() == 2) {
            n1(str, 4, null);
        }
        if (earphoneDTOW.getHeadsetConnectionState() == 2) {
            o1(4, str);
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, DataTypeConstants.SPECIAL_APP_START, "param_address", str, heyMelodyApplication);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture c0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1039, new R8.y(str, i10, 5));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "sendCameraStatus addr is null!");
        return e1();
    }

    public final com.oplus.melody.model.db.E c1(String str) {
        if (com.oplus.melody.model.db.r.f(str)) {
            str = com.oplus.melody.model.db.r.c(str);
        }
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return (com.oplus.melody.model.db.E) this.f19933v.get(str);
        }
        return null;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void d(String str, boolean z2) {
        if (z2) {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            ConcurrentHashMap concurrentHashMap = this.f19936y;
            if (zIsEmpty) {
                concurrentHashMap.replaceAll(new com.oplus.drs.track.init.c(2));
            } else {
                concurrentHashMap.put(str, Boolean.TRUE);
            }
        }
        x1(null, "discoverCancel");
        boolean zIsEmpty2 = TextUtils.isEmpty(str);
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.f19937z;
        com.oplus.melody.model.scan.b bVar = this.f19919T;
        if (zIsEmpty2) {
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            y1(copyOnWriteArrayList);
            copyOnWriteArrayList.clear();
            bVar.getClass();
            com.oplus.melody.common.util.A.b("OplusBleRssiManager", "resetDiscoveryForeground");
            bVar.f20227c.clear();
            l1("discoverCancel");
            return;
        }
        bVar.getClass();
        com.oplus.melody.common.util.A.c("OplusBleRssiManager", new D6.f(str, 16));
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            bVar.f20227c.remove(str);
        }
        if (copyOnWriteArrayList.remove(str)) {
            y1(Collections.singleton(str));
            l1("discoverCancel");
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture d0(int i10, int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1064, new Z7.h(i10, i11, 3, str));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "sendTranslationAppStatus addr is null!");
        return e1();
    }

    public final O7.l<EarphoneDTO> d1(String str) {
        ConcurrentHashMap concurrentHashMap = this.f19935x;
        if (str == null) {
            str = "";
        }
        return (O7.l) concurrentHashMap.computeIfAbsent(str, new C0738g(22));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void e(String str) {
        int i10;
        int i11;
        Y.r.l(str, "EarphoneRepository", new StringBuilder("discoverClick: "));
        com.oplus.melody.model.scan.b bVar = this.f19919T;
        bVar.getClass();
        if (TextUtils.isEmpty(str)) {
            i11 = 0;
        } else {
            synchronized (bVar.f20229e) {
                try {
                    int iIndexOf = bVar.f20229e.indexOf(str);
                    if (iIndexOf < 0 && bVar.f20229e.add(str)) {
                        iIndexOf = bVar.f20229e.indexOf(str);
                    }
                    i10 = iIndexOf + 1;
                } catch (Throwable th) {
                    throw th;
                }
            }
            i11 = i10;
        }
        if (i11 == 0) {
            return;
        }
        com.oplus.melody.common.util.A.c("OplusBleRssiManager", new Aa.a(i11, str, 14));
        bVar.f20225a.removeMessages(i11);
        bVar.f20225a.sendMessageDelayed(Message.obtain(bVar.f20225a, i11, str), 15000L);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture e0(final int i10, final String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setAISummaryType addr is null!");
            return e1();
        }
        CompletableFuture<SetCommandStateDTO> completableFutureW1 = w1(str, 1061, new I8.s(str, i10, 5));
        completableFutureW1.whenComplete(new BiConsumer() { // from class: com.oplus.melody.model.repository.earphone.k
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                SetCommandStateDTO setCommandStateDTO = (SetCommandStateDTO) obj;
                Throwable th = (Throwable) obj2;
                L l4 = this.f19953a;
                l4.getClass();
                if (th != null) {
                    com.oplus.melody.common.util.A.i("EarphoneRepository", "setAISummaryType set type " + i10, th);
                    return;
                }
                int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
                if (setCommandStatus == 0) {
                    l4.k(str);
                    return;
                }
                com.oplus.melody.common.util.A.h("EarphoneRepository", "setAISummaryType fail, getSetCommandStatus " + setCommandStatus);
            }
        });
        return completableFutureW1;
    }

    public final CompletableFuture<SetCommandStateDTO> e1() {
        if (this.f19923X == null) {
            this.f19923X = q0.b(MelodyException.e(0, "Invalid address"));
        }
        return this.f19923X;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void f(String str) {
        com.oplus.melody.common.util.A.x("EarphoneRepository", "discoverConnect: " + com.oplus.melody.common.util.A.r(str));
        EarphoneDTO earphoneDTOW = w(str);
        if (earphoneDTOW == null) {
            return;
        }
        List listAsList = Arrays.asList(3, 5, 0);
        if (listAsList.contains(Integer.valueOf(earphoneDTOW.getConnectionState()))) {
            n1(str, 1, null);
        }
        if (listAsList.contains(Integer.valueOf(earphoneDTOW.getHeadsetConnectionState()))) {
            o1(1, str);
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, DataTypeConstants.EXCEPTION, "param_address", str, heyMelodyApplication);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void f0(int i10, String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            com.oplus.melody.common.util.A.f("EarphoneRepository", "setAutoFirmwareUpdateSwitch invalid address " + str);
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null || eC1.getAutoOTASwitch() != i10) {
            if (eC1 != null) {
                eC1.setAutoOTASwitch(i10);
                m1(str);
            }
            ForkJoinPool.commonPool().execute(new y(this, str, i10, 0));
        }
        J7.b.a().f();
        AbstractC0763a abstractC0763aE = AbstractC0763a.e();
        if (i10 != 1) {
            if (abstractC0763aE.f(str) == 2 && 1 == abstractC0763aE.g(str)) {
                abstractC0763aE.a(str);
                return;
            }
            return;
        }
        EarphoneDTO earphoneDTOW = w(str);
        if (earphoneDTOW != null) {
            this.f19918S.put(str, Boolean.FALSE);
            abstractC0763aE.o(str, earphoneDTOW);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void f1(HeyMelodyApplication heyMelodyApplication) {
        DeviceInfo deviceInfoF;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            Object obj = L7.a.f3010c;
            if (a.C0032a.a().i()) {
                L7.a aVarA = a.C0032a.a();
                Set<BluetoothDevice> setD = C0391z.f1171d.d(defaultAdapter);
                if (setD == null) {
                    setD = Collections.EMPTY_SET;
                }
                for (BluetoothDevice bluetoothDevice : setD) {
                    if (bluetoothDevice != null) {
                        int iC = aVarA.h(bluetoothDevice) ? 2 : aVarA.c(1, bluetoothDevice);
                        com.oplus.melody.common.util.A.c("EarphoneRepository", new Ea.C(iC, bluetoothDevice, 3));
                        if (R0(true, bluetoothDevice.getAddress(), Integer.valueOf(iC), new C0943f(7)) && iC == 2) {
                            O(heyMelodyApplication, bluetoothDevice.getAddress(), bluetoothDevice.getName());
                        }
                        if (C0373g.f1086l && (deviceInfoF = DeviceInfoManager.a.f19280a.f(bluetoothDevice.getAddress())) != null) {
                            P0(deviceInfoF);
                        }
                    }
                }
                return;
            }
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "initHeadsetConnectionState adapter is null! or bluetooth off");
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<List<EarphoneDTO>> g() {
        return C0379m.d(this.f19901A, o0.c.f1146d, new E9.h(this, 25));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture g0(final int i10, final int i11, final int i12, final String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1051, new Supplier() { // from class: com.oplus.melody.model.repository.earphone.E
                @Override // java.util.function.Supplier
                public final Object get() {
                    String str2 = str;
                    int i13 = i10;
                    int i14 = i11;
                    int i15 = i12;
                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                    Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1066);
                    intentU.putExtra("param_address", str2);
                    intentU.putExtra("param_bass_engine_min_value", i13);
                    intentU.putExtra("param_bass_engine_max_value", i14);
                    intentU.putExtra("param_bass_engine_current_value", i15);
                    com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                    return new q0(5L, TimeUnit.SECONDS);
                }
            });
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setBassEngineValue addr is null!");
        return e1();
    }

    public final void g1(int i10, String str, String str2, String str3) {
        com.oplus.melody.model.db.E eW0 = W0(i10, str, str2, str3);
        if (eW0 == null || eW0.getColorId() == -1) {
            com.oplus.melody.common.util.A.r(str);
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 != null && eW0.getColorId() == eC1.getColorId() && TextUtils.equals(eW0.getName(), eC1.getName()) && TextUtils.equals(eW0.getProductId(), eC1.getProductId()) && TextUtils.equals(eW0.getMacAddress(), eC1.getMacAddress())) {
            com.oplus.melody.common.util.A.r(str);
        } else {
            ForkJoinPool.commonPool().execute(new RunnableC0903i(2, this, eW0));
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> h() {
        return C0379m.e(this.f19906F, new B(this, 1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void h0(int i10, String str) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            com.oplus.melody.common.util.A.f("EarphoneRepository", "setChannelSwitch invalid address " + str);
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null || eC1.getChannelSwitch() != i10) {
            if (eC1 != null) {
                eC1.setChannelSwitch(i10);
                m1(str);
            }
            ForkJoinPool.commonPool().execute(new I6.d(this, str, i10, 4));
        }
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        CompletableFuture<SetCommandStateDTO> completableFutureW1;
        Bundle data = message.getData();
        switch (message.what) {
            case 3001:
                Q(data.getInt("intColor"), data.getString("macAddress"), data.getString("deviceName"), data.getString("productId"));
                break;
            case 3002:
                g1(data.getInt("intColor"), data.getString("macAddress"), data.getString("deviceName"), data.getString("productId"));
                break;
            case 3003:
                ForkJoinPool.commonPool().execute(new RunnableC0369c(24, this, data.getString("macAddress")));
                break;
            case 3004:
                f0(data.getInt("value"), data.getString("macAddress"));
                break;
            case 3005:
                this.f19919T.getClass();
                s1("registerDiscoverPolicy");
                break;
            case 3006:
                this.f19936y.clear();
                com.oplus.melody.model.scan.b bVar = this.f19919T;
                bVar.getClass();
                com.oplus.melody.common.util.A.b("OplusBleRssiManager", "unregisterDiscoverPolicy");
                bVar.f20225a.removeCallbacksAndMessages(null);
                bVar.a();
                CopyOnWriteArrayList<String> copyOnWriteArrayList = this.f19937z;
                if (!copyOnWriteArrayList.isEmpty()) {
                    copyOnWriteArrayList.clear();
                    l1("unregisterDiscoverPolicy");
                }
                break;
            case 3007:
                D7.E e10 = h0.f1099c;
                h0.c(message, c0(data.getInt("value"), data.getString("macAddress")));
                return true;
            case 3008:
            case 3015:
            case 3017:
            case 3018:
            case 3023:
            case 3024:
            case 3060:
            case 3061:
            case 3062:
            case 3063:
            case 3064:
            case 3067:
            case 3070:
            case 3074:
            case 3075:
            case 3082:
            case 3083:
            case 3084:
            case 3090:
            case 3091:
            default:
                return false;
            case 3009:
                Y0(data.getString("macAddress"));
                break;
            case 3010:
                D7.E e11 = h0.f1099c;
                h0.i(message, g());
                return true;
            case 3011:
                D7.E e12 = h0.f1099c;
                h0.i(message, K0());
                return true;
            case 3012:
                D7.E e13 = h0.f1099c;
                h0.i(message, h());
                return true;
            case 3013:
                D7.E e14 = h0.f1099c;
                h0.i(message, i());
                return true;
            case 3014:
                D7.E e15 = h0.f1099c;
                h0.i(message, j());
                return true;
            case 3016:
                C0379m.k(this.H, data.getString("macAddress"));
                break;
            case 3019:
                D7.E e16 = h0.f1099c;
                h0.i(message, this.f19902B);
                return true;
            case 3020:
                D7.E e17 = h0.f1099c;
                h0.i(message, this.f19904D);
                return true;
            case 3021:
                if (!data.containsKey("macAddress")) {
                    f1(C0906l.f19501a);
                } else {
                    O(C0906l.f19501a, data.getString("macAddress"), data.getString("deviceName"));
                }
                break;
            case 3022:
                P(C0906l.f19501a, data.getString("macAddress"), data.getString("deviceName"));
                break;
            case 3025:
                D7.E e18 = h0.f1099c;
                h0.i(message, (O7.l) this.f19903C.computeIfAbsent(data.getString("macAddress"), new C0738g(21)));
                return true;
            case 3026:
                a0(data.getString("macAddress"));
                break;
            case 3027:
                Y();
                break;
            case 3028:
                X();
                break;
            case 3029:
                d(data.getString("macAddress"), data.getBoolean("value"));
                break;
            case 3030:
                V(data.getString("macAddress"));
                break;
            case 3031:
                W(data.getString("macAddress"));
                break;
            case 3032:
                f(data.getString("macAddress"));
                break;
            case 3033:
                c(data.getString("macAddress"));
                break;
            case 3034:
                ArrayList arrayListE = C0914u.e(data, "value", KeyFunctionInfoDTO.class);
                D7.E e19 = h0.f1099c;
                h0.c(message, u0(data.getString("macAddress"), C0906l.f19501a, arrayListE, data.getInt("command")));
                return true;
            case 3035:
                F(C0906l.f19501a, data.getString("macAddress"));
                break;
            case 3036:
                D0(C0906l.f19501a, data.getString("macAddress"), (NoiseReductionInfoDTO) C0914u.g(data, "value", NoiseReductionInfoDTO.class));
                break;
            case 3037:
                D7.E e20 = h0.f1099c;
                h0.i(message, x(data.getString("macAddress")));
                return true;
            case 3038:
                D7.E e21 = h0.f1099c;
                h0.i(message, C0379m.b(this.f19905E));
                return true;
            case 3039:
                D7.E e22 = h0.f1099c;
                h0.c(message, F0(data.getString("macAddress"), data.getInt("featureId"), data.getBoolean("value"), data.getBoolean("arg1")));
                return true;
            case 3040:
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                A6.g.i(heyMelodyApplication, 1038, "param_address", data.getString("macAddress"), heyMelodyApplication);
                break;
            case 3041:
                D7.E e23 = h0.f1099c;
                h0.c(message, j0(data.getString("macAddress"), data.getBoolean("value")));
                return true;
            case 3042:
                D7.E e24 = h0.f1099c;
                h0.c(message, L0(data.getString("macAddress")));
                return true;
            case 3043:
                D7.E e25 = h0.f1099c;
                h0.c(message, M0(data.getString("macAddress")));
                return true;
            case 3044:
                D7.E e26 = h0.f1099c;
                h0.c(message, x0(data.getInt("value"), data.getString("macAddress")));
                return true;
            case 3045:
                y(data.getString("macAddress"));
                break;
            case 3046:
                t(data.getString("macAddress"));
                break;
            case 3047:
                J(data.getString("macAddress"));
                break;
            case 3048:
                U(data.getString("macAddress"));
                break;
            case 3049:
                N0(data.getString("macAddress"));
                break;
            case 3050:
                D7.E e27 = h0.f1099c;
                h0.c(message, m0(data.getString("macAddress"), data.getBoolean("value")));
                return true;
            case 3051:
                D7.E e28 = h0.f1099c;
                h0.i(message, this.f19908I);
                return true;
            case 3052:
                D7.E e29 = h0.f1099c;
                h0.i(message, this.f19909J);
                return true;
            case 3053:
                D7.E e30 = h0.f1099c;
                h0.i(message, this.f19910K);
                return true;
            case 3054:
                D7.E e31 = h0.f1099c;
                h0.i(message, this.f19919T.f20226b);
                return true;
            case 3055:
                D7.E e32 = h0.f1099c;
                h0.c(message, n0(data.getString("macAddress"), data.getByte("value")));
                return true;
            case 3056:
                ToneFileVerifyInformationDTO toneFileVerifyInformationDTO = (ToneFileVerifyInformationDTO) C0914u.g(data, "value", ToneFileVerifyInformationDTO.class);
                D7.E e33 = h0.f1099c;
                h0.c(message, H0(data.getString("macAddress"), toneFileVerifyInformationDTO));
                return true;
            case 3057:
                D7.E e34 = h0.f1099c;
                h0.c(message, l0(data.getInt("value"), data.getString("macAddress")));
                return true;
            case 3058:
                D7.E e35 = h0.f1099c;
                h0.c(message, k0(data.getInt("value"), data.getString("macAddress")));
                return true;
            case 3059:
                b0();
                break;
            case 3065:
                String string = data.getString("arg1");
                int i10 = data.getInt("arg2");
                int i11 = data.getInt("arg3");
                int i12 = data.getInt("arg4");
                D7.E e36 = h0.f1099c;
                h0.c(message, t0(i10, i11, i12, string));
                return true;
            case 3066:
                D(data.getString("arg1"));
                break;
            case 3068:
                String string2 = data.getString("arg1");
                D7.E e37 = h0.f1099c;
                h0.c(message, L(string2));
                return true;
            case 3069:
                String string3 = data.getString("macAddress");
                int i13 = data.getInt("arg1");
                int i14 = data.getInt("arg2");
                int i15 = data.getInt("arg3");
                D7.E e38 = h0.f1099c;
                h0.c(message, g0(i13, i14, i15, string3));
                return true;
            case 3071:
                D7.E e39 = h0.f1099c;
                h0.i(message, n());
                return true;
            case 3072:
                D7.E e40 = h0.f1099c;
                String string4 = data.getString("macAddress");
                int i16 = data.getInt("arg1");
                String string5 = data.getString("arg2");
                if (TextUtils.isEmpty(string4)) {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "setAccountKey: address is empty ...");
                    completableFutureW1 = e1();
                } else {
                    completableFutureW1 = w1(string4, 1052, new P3.l(i16, 4, string5, string4));
                }
                h0.c(message, completableFutureW1);
                return true;
            case 3073:
                String string6 = data.getString("macAddress");
                if (!TextUtils.isEmpty(string6)) {
                    HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
                    A6.g.i(heyMelodyApplication2, 1071, "param_address", string6, heyMelodyApplication2);
                } else {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "requestAccountKey: address is empty ...");
                }
                break;
            case 3076:
                O0(data.getString("arg1"), data.getBoolean("arg2"));
                break;
            case 3077:
                String string7 = data.getString("macAddress");
                int i17 = data.getInt("arg1");
                int i18 = data.getInt("arg2");
                D7.E e41 = h0.f1099c;
                h0.c(message, o0(i17, i18, string7));
                return true;
            case 3078:
                D7.E e42 = h0.f1099c;
                h0.c(message, B0(data.getString("macAddress"), data.getBoolean("value")));
                return true;
            case 3079:
                D7.E e43 = h0.f1099c;
                h0.c(message, C0(data.getInt("arg1"), data.getBoolean("value"), data.getString("macAddress")));
                return true;
            case 3080:
                I(data.getString("macAddress"));
                break;
            case 3081:
                String string8 = data.getString("macAddress");
                int i19 = data.getInt("arg1");
                D7.E e44 = h0.f1099c;
                h0.c(message, r0(i19, string8));
                return true;
            case 3085:
                D7.E e45 = h0.f1099c;
                h0.i(message, this.f19911L);
                return true;
            case 3086:
                e(data.getString("macAddress"));
                break;
            case 3087:
                String string9 = data.getString("arg1");
                boolean z2 = data.getBoolean("arg2");
                D7.E e46 = h0.f1099c;
                h0.c(message, b(string9, z2));
                return true;
            case 3088:
                J0(data.getString("arg1"));
                break;
            case 3089:
                com.oplus.melody.common.util.A.b("EarphoneRepository", "sppConnectAll");
                HeyMelodyApplication heyMelodyApplication3 = C0906l.f19501a;
                com.google.android.play.core.appupdate.c.Q(heyMelodyApplication3, com.google.android.play.core.appupdate.c.u(heyMelodyApplication3, DataTypeConstants.USER_ACTION));
                break;
            case 3092:
                String string10 = data.getString("arg1");
                int i20 = data.getInt("arg2");
                int i21 = data.getInt("arg3");
                D7.E e47 = h0.f1099c;
                h0.c(message, v0(i20, i21, string10));
                return true;
            case 3093:
                k(data.getString("macAddress"));
                break;
            case 3094:
                e0(data.getInt("arg1"), data.getString("macAddress"));
                break;
            case 3095:
                D7.E e48 = h0.f1099c;
                h0.i(message, this.f19913N);
                return true;
            case 3096:
                N(data.getString("macAddress"));
                break;
            case 3097:
                I0(data.getInt("arg1"), data.getString("macAddress"));
                break;
            case 3098:
                String string11 = data.getString("macAddress");
                int i22 = data.getInt("arg1");
                int i23 = data.getInt("arg2");
                D7.E e49 = h0.f1099c;
                h0.c(message, d0(i22, i23, string11));
                return true;
            case 3099:
                h0(data.getInt("value"), data.getString("macAddress"));
                break;
            case 3100:
                l(data.getString("macAddress"));
                break;
            case 3101:
                i0(data.getString("arg1"), data.getString("arg2"));
                break;
            case 3102:
                z0(data.getString("macAddress"), data.getString("value"));
                break;
            case 3103:
                w0(data.getString("macAddress"), data.getInt("arg1"), data.getBoolean("arg2"), data.getBoolean("arg3"));
                break;
            case 3104:
                K(data.getString("macAddress"));
                break;
            case 3105:
                G0(data.getInt("arg1"), data.getString("macAddress"));
                break;
            case 3106:
                A0(data.getInt("arg1"), data.getString("macAddress"));
                break;
            case 3107:
                String string12 = data.getString("macAddress");
                int i24 = data.getInt("arg1");
                D7.E e50 = h0.f1099c;
                h0.c(message, y0(i24, string12));
                return true;
            case 3108:
                D7.E e51 = h0.f1099c;
                String string13 = data.getString("macAddress");
                h0.c(message, p0(data.getInt("arg1"), data.getBoolean("value"), string13));
                return true;
            case 3109:
                D7.E e52 = h0.f1099c;
                h0.c(message, q0(data.getInt("value"), data.getString("macAddress")));
                return true;
            case 3110:
                C(data.getString("macAddress"));
                break;
            case 3111:
                D7.E e53 = h0.f1099c;
                h0.i(message, this.f19912M);
                return true;
            case 3112:
                Z();
                break;
        }
        h0.h(message, null);
        return true;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> i() {
        return C0379m.e(this.f19907G, new B(this, 1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void i0(final String str, final String str2) {
        R0(false, str, Boolean.TRUE, new BiConsumer() { // from class: com.oplus.melody.model.repository.earphone.C
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                Boolean bool = (Boolean) obj;
                EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) obj2;
                if (com.oplus.melody.common.util.A.l() && bool.booleanValue() != earphoneStatusDO.isConnectedShown()) {
                    com.oplus.melody.common.util.A.b("EarphoneRepository", "setConnectedShown from " + str2 + ", mac=" + com.oplus.melody.common.util.A.r(str));
                }
                earphoneStatusDO.setConnectedShown(bool.booleanValue());
            }
        });
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> j() {
        return C0379m.e(this.H, new B(this, 1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> j0(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setControlGuideModeStatus addr is null!");
            return e1();
        }
        return w1(str, 1037, new I8.s(str, z2 ? 1 : 0, 11));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void k(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "getAISummaryType addr is null!");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1081, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture k0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1028, new R8.y(i10, str, 6));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setCurrentNoiseReduction addr is null!");
        return e1();
    }

    public final void k1(DeviceInfo deviceInfo, String str) {
        WhitelistConfigDTO whitelistConfigDTOB;
        String str2;
        final String deviceAddress = deviceInfo.getDeviceAddress();
        EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) this.f19934w.get(deviceAddress);
        final String strI = C0625v.i(deviceAddress, new StringBuilder("notifyConnectedEarphone "));
        ConcurrentHashMap concurrentHashMap = this.f19917R;
        boolean z2 = false;
        if (earphoneStatusDO != null && earphoneStatusDO.isConnectedShown()) {
            com.oplus.melody.common.util.A.c("EarphoneRepository", new C0739h(strI, str, 1));
            CompletableFuture completableFuture = (CompletableFuture) concurrentHashMap.remove(deviceAddress);
            if (completableFuture != null) {
                completableFuture.completeExceptionally(MelodyException.e(0, "Connected shown from ".concat(str)));
                return;
            }
            return;
        }
        if (deviceInfo.getColorId() < 0 && deviceInfo.isSupportSpp()) {
            str2 = "COLOR";
        } else if (h1(deviceInfo)) {
            boolean z4 = true;
            if ((C0901g.a(deviceInfo.getStatusInfo()) || !i1(deviceInfo, deviceInfo.getStatusInfoTimeMillis())) && (whitelistConfigDTOB = AbstractC1508a.f().b(deviceInfo.getProductId(), deviceInfo.getDeviceName())) != null && Y.m(whitelistConfigDTOB.getType())) {
                if (whitelistConfigDTOB != null && whitelistConfigDTOB.getFunction() != null && Y.e(whitelistConfigDTOB.getFunction().getInBoxStatus(), !Y.j(whitelistConfigDTOB))) {
                    z2 = true;
                }
                z4 = true ^ z2;
            }
            str2 = !z4 ? "EAR_STATUS" : null;
        } else {
            str2 = "BATTERY";
        }
        CompletableFuture completableFuture2 = (CompletableFuture) concurrentHashMap.get(deviceAddress);
        if (str2 != null) {
            if (completableFuture2 != null) {
                com.oplus.melody.common.util.A.c("EarphoneRepository", new I7.f(strI, str2, str));
                return;
            }
            com.oplus.melody.common.util.A.x("EarphoneRepository", strI + " mConnectedFuture.create because " + str2 + " from " + str);
            q0 q0Var = new q0(8L, TimeUnit.SECONDS);
            q0Var.exceptionally((Function) new Z7.c(this, deviceAddress, strI, 1)).whenCompleteAsync(new BiConsumer() { // from class: com.oplus.melody.model.repository.earphone.m
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Throwable th = (Throwable) obj2;
                    L l4 = this.f19959a;
                    String str3 = deviceAddress;
                    if (th == null) {
                        C0379m.l(l4.f19906F, str3);
                    } else {
                        l4.getClass();
                        com.oplus.melody.common.util.A.i("EarphoneRepository", strI + " exceptionally", th);
                    }
                    l4.f19917R.remove(str3);
                }
            }, (Executor) o0.c.f1146d);
            concurrentHashMap.put(deviceAddress, q0Var);
            return;
        }
        if (completableFuture2 != null) {
            com.oplus.melody.common.util.A.x("EarphoneRepository", strI + " mConnectedFuture.complete from " + str);
            i0(deviceAddress, str);
            completableFuture2.complete(deviceInfo);
            return;
        }
        com.oplus.melody.common.util.A.x("EarphoneRepository", strI + " from " + str);
        i0(deviceAddress, str);
        C0379m.l(this.f19906F, deviceAddress);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void l(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "getAITranslationAppStatus addr is null!");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1091, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture l0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1030, new I8.s(i10, str, 9));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setEqualizerMode addr is null!");
        return e1();
    }

    public final void l1(String str) {
        com.oplus.melody.common.util.A.x("EarphoneRepository", "notifyDiscoveryChanged " + this.f19937z.size() + " from " + str);
        this.f19901A.m(new ArrayList(this.f19937z));
        if (Build.VERSION.SDK_INT < 26 || !com.oplus.melody.common.util.S.t(C0906l.f19501a)) {
            return;
        }
        if (this.f19937z.isEmpty()) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1055);
            intentU.putExtra("scan_flag", 1);
            com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
            return;
        }
        int i10 = C0373g.d() ? 5 : 9;
        HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
        Intent intentU2 = com.google.android.play.core.appupdate.c.u(heyMelodyApplication2, 1054);
        intentU2.putExtra("scan_flag", i10);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication2, intentU2);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO m() {
        return V0(b1());
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> m0(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setFindMode addr is null!");
            return e1();
        }
        C0899e c0899e = new C0899e(str, z2, 1);
        return (CompletableFuture) this.f19916Q.compute(j1(1024, str), new C0389x(c0899e, 4));
    }

    public final void m1(String str) {
        int iIncrementAndGet = this.f19921V.incrementAndGet();
        if (com.oplus.melody.common.util.A.l()) {
            StringBuilder sbN = androidx.appcompat.widget.a.n(iIncrementAndGet, "notifyEarphoneChanged ", " prepare ");
            sbN.append(com.oplus.melody.common.util.A.r(str));
            com.oplus.melody.common.util.A.b("EarphoneRepository", sbN.toString());
        }
        a aVarComputeIfAbsent = this.f19922W.computeIfAbsent(str, new C0941d(9));
        synchronized (aVarComputeIfAbsent) {
            aVarComputeIfAbsent.f19938a = iIncrementAndGet;
        }
        o0.c.f1146d.execute(new RunnableC0677t0(this, aVarComputeIfAbsent, iIncrementAndGet, str, 3));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> n() {
        EarphoneDTO earphoneDTOM = m();
        O7.l<EarphoneDTO> lVar = this.f19914O;
        if (earphoneDTOM != null) {
            lVar.m(earphoneDTOM);
            return lVar;
        }
        o0.c.f1146d.a().postDelayed(new com.airbnb.lottie.B(this, 10), 1000L);
        return lVar;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture<SetCommandStateDTO> n0(final String str, final byte b4) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1044, new Supplier() { // from class: com.oplus.melody.model.repository.earphone.F
                @Override // java.util.function.Supplier
                public final Object get() {
                    String str2 = str;
                    byte b5 = b4;
                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                    Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1037);
                    intentU.putExtra("param_address", str2);
                    intentU.putExtra("dialog_recovery_time", (int) b5);
                    com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                    return new q0(5L, TimeUnit.SECONDS);
                }
            });
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setFreeDialogRecoveryTime addr is null!");
        return e1();
    }

    public final boolean n1(String str, int i10, DeviceInfo deviceInfo) {
        if (i10 == 1 && com.oplus.melody.common.util.S.t(C0906l.f19501a)) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1055);
            intentU.putExtra("scan_flag", 1);
            com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
        }
        return R0(true, str, Integer.valueOf(i10), new c8.n(this, str, deviceInfo));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> o() {
        return this.f19913N;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture o0(int i10, int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1056, new Z7.h(i10, i11, 2, str));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setGameEqualizerStatus addr is null!");
        return e1();
    }

    public final boolean o1(int i10, String str) {
        return R0(true, str, Integer.valueOf(i10), new C0947j(str, 1));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO p() {
        String strD = this.f19915P.d();
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return V0(strD);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture p0(int i10, boolean z2, String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setHeadMotionTryMode address is null!");
            return e1();
        }
        return w1(str, 1037, new O7.r(z2 ? 1 : 0, i10, 1, str));
    }

    public final void p1(DeviceInfo deviceInfo, EarStatusDTO earStatusDTO, boolean z2) {
        WhitelistConfigDTO whitelistConfigDTOB = AbstractC1508a.f().b(deviceInfo.getProductId(), deviceInfo.getDeviceName());
        if (whitelistConfigDTOB == null || whitelistConfigDTOB.getFunction() == null || !Y.e(whitelistConfigDTOB.getFunction().getWearDetection(), false)) {
            com.oplus.melody.common.util.A.r(deviceInfo.getDeviceAddress());
            com.oplus.melody.common.util.A.q(deviceInfo.getDeviceName());
            return;
        }
        ConcurrentHashMap concurrentHashMap = this.f19929r;
        Long l4 = (Long) concurrentHashMap.get(deviceInfo.getDeviceAddress());
        if (l4 == null && earStatusDTO.leastOneInEar() && !z2) {
            concurrentHashMap.put(deviceInfo.getDeviceAddress(), Long.valueOf(System.currentTimeMillis()));
            if (com.oplus.melody.common.util.A.l()) {
                com.oplus.melody.common.util.A.f("EarphoneRepository", "recordWearTime: in ear, " + deviceInfo.getDeviceAddress() + ", " + deviceInfo.getDeviceName() + ", " + earStatusDTO);
                return;
            }
            return;
        }
        if (l4 != null) {
            if (earStatusDTO.bothNotInEar() || z2) {
                long jCurrentTimeMillis = System.currentTimeMillis() - l4.longValue();
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.f("EarphoneRepository", "recordWearTime: out ear, wearTime: " + jCurrentTimeMillis + ", disconnect: " + z2 + ", " + deviceInfo.getDeviceAddress() + ", " + deviceInfo.getDeviceName() + ", " + earStatusDTO);
                }
                concurrentHashMap.remove(deviceInfo.getDeviceAddress());
                EarphoneDTO earphoneDTOW = w(deviceInfo.getDeviceAddress());
                if (earphoneDTOW == null || TimeUnit.MILLISECONDS.toMinutes(jCurrentTimeMillis) < 1) {
                    return;
                }
                C1264t.n(earphoneDTOW.getProductId(), earphoneDTOW.getMacAddress(), N.t(earphoneDTOW), 0L, jCurrentTimeMillis);
            }
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<Integer> q() {
        return this.f19904D;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture q0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1073, new Aa.a(str, i10, 13));
        }
        com.oplus.melody.common.util.A.b("EarphoneRepository", "setHeadMotionType: address is empty ...");
        return e1();
    }

    public final void q1(BluetoothReceiveDTO<?> bluetoothReceiveDTO) {
        DeviceInfo deviceInfo = (DeviceInfo) bluetoothReceiveDTO.getData();
        if (deviceInfo != null && R0(true, deviceInfo.getDeviceAddress(), deviceInfo, new C0945h(4)) && com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "refreshActiveState hfp=" + deviceInfo.isHeadsetActive() + " a2dp=" + deviceInfo.isA2dpActive() + " lea=" + deviceInfo.isLeAudioActive() + " mac=" + com.oplus.melody.common.util.A.r(deviceInfo.getDeviceAddress()));
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<BoxCoverActionDTO> r() {
        return C0379m.b(this.f19905E);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture r0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1058, new Aa.a(str, i10, 12));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setHeadSetSpatialType addr is null!");
        return e1();
    }

    public final void r1(BluetoothReceiveDTO<?> bluetoothReceiveDTO, BiConsumer<DeviceInfo, EarphoneStatusDO> biConsumer) {
        DeviceInfo deviceInfo;
        if (bluetoothReceiveDTO == null || (deviceInfo = (DeviceInfo) bluetoothReceiveDTO.getData()) == null) {
            return;
        }
        R0(true, deviceInfo.getDeviceAddress(), deviceInfo, biConsumer);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final BoxCoverActionDTO s() {
        return this.f19905E.d();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture s0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1054, new R8.y(str, i10, 2));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "sendCameraStatus addr is null!");
        return e1();
    }

    public final void s1(String str) {
        CompletableFuture<Void> completableFuture = this.f19926a0;
        if (completableFuture == null || completableFuture.isDone()) {
            this.f19926a0 = CompletableFuture.supplyAsync(new com.oplus.melody.btsdk.protocol.commands.n(2)).thenAccept((Consumer) new com.oplus.melody.model.db.k(2, this, str));
        } else {
            com.oplus.melody.common.util.A.c("EarphoneRepository", new D(str, 0));
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void t(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "getCodecType: address is empty ...");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1039, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture t0(final int i10, final int i11, final int i12, final String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1050, new Supplier() { // from class: com.oplus.melody.model.repository.earphone.A
                @Override // java.util.function.Supplier
                public final Object get() {
                    String str2 = str;
                    int i13 = i10;
                    int i14 = i11;
                    int i15 = i12;
                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                    Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1064);
                    intentU.putExtra("param_address", str2);
                    intentU.putExtra("param_high_audio_codec_type", i13);
                    intentU.putExtra("param_hires_switch_status", i14);
                    intentU.putExtra("param_all_capability", i15);
                    com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                    return new q0(5L, TimeUnit.SECONDS);
                }
            });
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setHighAudioCodecType addr is null!");
        return e1();
    }

    public final void t1(BluetoothReceiveDTO<?> bluetoothReceiveDTO) {
        DeviceInfo deviceInfo = (DeviceInfo) bluetoothReceiveDTO.getData();
        if (deviceInfo != null) {
            S0(1, deviceInfo);
            P0(deviceInfo);
            String deviceAddress = deviceInfo.getDeviceAddress();
            int deviceAclConnectState = deviceInfo.getDeviceAclConnectState();
            if (R0(true, deviceAddress, Integer.valueOf(deviceAclConnectState), new c9.g(deviceAddress, 2))) {
                if (deviceAclConnectState == 2) {
                    W(deviceAddress);
                }
                ConcurrentHashMap concurrentHashMap = this.f19931t;
                Runnable runnable = (Runnable) concurrentHashMap.remove(deviceAddress);
                if (runnable != null) {
                    o0.c.f1146d.a().removeCallbacks(runnable);
                }
                if (deviceAclConnectState == 3) {
                    com.oplus.melody.alive.component.clicktakephoto.b bVar = new com.oplus.melody.alive.component.clicktakephoto.b(2, this, deviceAddress);
                    concurrentHashMap.put(deviceAddress, bVar);
                    o0.c.f1146d.a().postDelayed(bVar, 500L);
                }
            }
            o0.c.f1146d.execute(new RunnableC0677t0(this, deviceInfo, deviceAclConnectState, deviceAddress, 2));
            Q0(deviceAclConnectState, deviceInfo);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO u() {
        return X0(this.f19906F.d());
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    @SuppressLint({"WrongConstant"})
    public final CompletableFuture u0(String str, Context context, List list, int i10) {
        if (!TextUtils.isEmpty(str)) {
            return (list == null || list.isEmpty()) ? q0.b(MelodyException.e(0, "infoList null or empty")) : w1(str, i10, new w(str, context, list, i10));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setKeyFunctions addr is null!");
        return e1();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture v0(int i10, int i11, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1060, new C6.f(i10, i11, 1, str));
        }
        com.oplus.melody.common.util.A.h("EarphoneRepository", "setLeAudioAction addr is null!");
        return e1();
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final EarphoneDTO w(String str) {
        EarphoneDTO earphoneDTOD;
        if (str == null || c1(str) == null) {
            return null;
        }
        a aVar = this.f19922W.get(str);
        if (aVar != null && aVar.f19940c == aVar.f19938a && (earphoneDTOD = d1(str).d()) != null) {
            com.oplus.melody.common.util.A.r(str);
            return earphoneDTOD;
        }
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "getEarphoneData create " + com.oplus.melody.common.util.A.r(str));
        }
        return V0(str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void w0(String str, int i10, boolean z2, boolean z4) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            com.oplus.melody.common.util.A.f("EarphoneRepository", "setMultiConversationSwitch invalid address " + str);
            return;
        }
        if (!z4) {
            if (z2) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1094);
                intentU.putExtra("param_address", str);
                intentU.putExtra("param_value", i10);
                com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                return;
            }
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null || eC1.getMultiConversationSwitch() != i10) {
            if (eC1 != null) {
                eC1.setMultiConversationSwitch(i10);
                m1(str);
            }
            ForkJoinPool.commonPool().execute(new o(this, str, i10, z2, 0));
        }
    }

    public final CompletableFuture<SetCommandStateDTO> w1(String str, int i10, Supplier<CompletableFuture<SetCommandStateDTO>> supplier) {
        return (CompletableFuture) this.f19916Q.compute(j1(i10, str), new C0390y(supplier, 2));
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final androidx.lifecycle.s<EarphoneDTO> x(String str) {
        O7.l<EarphoneDTO> lVarD1 = d1(str);
        EarphoneDTO earphoneDTOV0 = V0(str);
        if (earphoneDTOV0 != null) {
            lVarD1.m(earphoneDTOV0);
        }
        return lVarD1;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture x0(int i10, String str) {
        if (!TextUtils.isEmpty(str)) {
            return w1(str, 1042, new I8.s(str, i10, 10));
        }
        com.oplus.melody.common.util.A.b("EarphoneRepository", "setPersonalizedNoiseReduction: address is empty ...");
        return e1();
    }

    public final void x1(BoxCoverActionDTO boxCoverActionDTO, String str) {
        if (com.oplus.melody.common.util.A.l()) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "updateBoxCoverChangeValue " + boxCoverActionDTO + " from " + str);
        }
        this.f19905E.m(boxCoverActionDTO);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void y(String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.b("EarphoneRepository", "getFeatureSwitchStatus: address is empty ...");
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            A6.g.i(heyMelodyApplication, 1035, "param_address", str, heyMelodyApplication);
        }
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final CompletableFuture y0(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            com.oplus.melody.common.util.A.h("EarphoneRepository", "setPhoneSpatialType addr is null!");
            return e1();
        }
        SetCommandStateDTO setCommandStateDTO = new SetCommandStateDTO();
        setCommandStateDTO.setAddress(str);
        EarphoneStatusDO earphoneStatusDO = (EarphoneStatusDO) this.f19934w.get(str);
        if (earphoneStatusDO != null) {
            earphoneStatusDO.setPhoneSpatialType(i10);
            setCommandStateDTO.setSetCommandStatus(0);
        } else {
            setCommandStateDTO.setSetCommandStatus(1);
        }
        StringBuilder sbG = D0.g(i10, "setPhoneSpatialType ok, address = ", str, ", type = ", ", stateDTO = ");
        sbG.append(setCommandStateDTO);
        com.oplus.melody.common.util.A.f("EarphoneRepository", sbG.toString());
        q0 q0Var = new q0(5L, TimeUnit.SECONDS);
        q0Var.complete(setCommandStateDTO);
        return q0Var;
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final HeadsetRssiDetectionDTO z(String str) {
        return (HeadsetRssiDetectionDTO) this.f19919T.f20228d.get(str);
    }

    @Override // com.oplus.melody.model.repository.earphone.AbstractC0939b
    public final void z0(String str, String str2) {
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            com.oplus.melody.common.util.A.f("EarphoneRepository", "setPopTheme invalid address " + str);
            return;
        }
        com.oplus.melody.model.db.E eC1 = c1(str);
        if (eC1 == null || !TextUtils.equals(eC1.getPopTheme(), str2)) {
            if (eC1 != null) {
                eC1.setPopTheme(str2);
                m1(str);
            }
            ForkJoinPool.commonPool().execute(new A6.o(this, str, str2, 6));
        }
    }
}
