package com.oplus.melody.model.repository.hearingenhance;

import D7.B;
import D7.C0379m;
import D7.C0384s;
import D7.C0386u;
import D7.C0389x;
import D7.E;
import D7.RunnableC0369c;
import D7.h0;
import D7.o0;
import D7.q0;
import Ea.C0400i;
import L7.a;
import L8.O;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.data.EarRestoreDataInfo;
import com.oplus.melody.btsdk.api.data.HearingDetectingInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhanceEarScanStatusInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhanceFreqPacket;
import com.oplus.melody.btsdk.api.data.HearingEnhanceFreqPacketInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhancementEarScanResult;
import com.oplus.melody.btsdk.api.data.HearingEnhancementInfo;
import com.oplus.melody.btsdk.api.data.HearingStatusInfo;
import com.oplus.melody.btsdk.api.data.SetCommandStateInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0899e;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.bluetooth.BluetoothReceiveDTO;
import com.oplus.melody.model.db.HearingEnhancementEncryptDao;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.earphone.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: HearingEnhancementRepositoryServerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public q0 f20038A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public q0 f20039B;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HearingEnhancementEncryptDao f20040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap f20041q = new ConcurrentHashMap();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final u<HearingEnhancementEntity> f20042r = new u<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final u<HearingStatusDTO> f20043s = new u<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final u<EarScanStatusDTO> f20044t = new u<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u<EarScanResultDTO> f20045u = new u<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final O7.l<Map<Integer, HearingEnhanceDataDTO>> f20046v = new O7.l<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final O7.l<Map<Integer, HearingEnhanceDataDTO>> f20047w = new O7.l<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final O7.l<List<EarRestoreDataInfo>> f20048x = new O7.l<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap f20049y = new ConcurrentHashMap();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f20050z;

    public l() {
        E e10 = o0.c.f1146d;
        HearingEnhancementEncryptDao hearingEnhancementEncryptDaoI = HearingEnhancementEncryptDao.i();
        this.f20040p = hearingEnhancementEncryptDaoI;
        C0379m.i(hearingEnhancementEncryptDaoI.f19693a, new v() { // from class: com.oplus.melody.model.repository.hearingenhance.j
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                List<HearingEnhancementEntity> list = (List) obj;
                l lVar = this.f20036a;
                lVar.getClass();
                A.c("HearingEnhancementRepository", new C0400i(5, list));
                for (HearingEnhancementEntity hearingEnhancementEntity : list) {
                    lVar.f20041q.compute(hearingEnhancementEntity.getUid(), new e(hearingEnhancementEntity, 1));
                }
                A.c("HearingEnhancementRepository", new f(lVar, 2));
            }
        }, e10);
        Object obj = L7.a.f3010c;
        C0379m.i(a.C0032a.a().a(), new v() { // from class: com.oplus.melody.model.repository.hearingenhance.k
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj2) {
                BluetoothReceiveDTO bluetoothReceiveDTO = (BluetoothReceiveDTO) obj2;
                l lVar = this.f20037a;
                lVar.getClass();
                if (bluetoothReceiveDTO == null) {
                    return;
                }
                int eventId = bluetoothReceiveDTO.getEventId();
                if (eventId != 1048576) {
                    switch (eventId) {
                        case 1048621:
                            HearingStatusInfo hearingStatusInfo = (HearingStatusInfo) bluetoothReceiveDTO.getData();
                            A.c("HearingEnhancementRepository", new f(hearingStatusInfo, 0));
                            if (hearingStatusInfo != null) {
                                HearingStatusDTO hearingStatusDTO = new HearingStatusDTO();
                                hearingStatusDTO.setAddress(hearingStatusInfo.getAddress());
                                hearingStatusDTO.setHearingType(hearingStatusInfo.getHearingType());
                                hearingStatusDTO.setStatus(hearingStatusInfo.getStatus());
                                C0379m.k(lVar.f20043s, hearingStatusDTO);
                            }
                            break;
                        case 1048622:
                            HearingEnhanceFreqPacketInfo hearingEnhanceFreqPacketInfo = (HearingEnhanceFreqPacketInfo) bluetoothReceiveDTO.getData();
                            if (A.l()) {
                                A.b("HearingEnhancementRepository", "EVENT_ID_BT_HEARING_ENHANCE_FREQ_PARAMS, packetInfo: " + hearingEnhanceFreqPacketInfo);
                            }
                            if (hearingEnhanceFreqPacketInfo != null && !hearingEnhanceFreqPacketInfo.getFreqPackets().isEmpty()) {
                                HashMap map = new HashMap();
                                for (HearingEnhanceFreqPacket hearingEnhanceFreqPacket : hearingEnhanceFreqPacketInfo.getFreqPackets()) {
                                    if (hearingEnhanceFreqPacket != null && hearingEnhanceFreqPacket.isComplete()) {
                                        HearingEnhanceDataDTO hearingEnhanceDataDTO = new HearingEnhanceDataDTO();
                                        hearingEnhanceDataDTO.setFreqType(hearingEnhanceFreqPacket.getType());
                                        hearingEnhanceDataDTO.setEnhanceType(hearingEnhanceFreqPacket.getEnhanceType());
                                        hearingEnhanceDataDTO.setFrequencyLeftCurveData(hearingEnhanceFreqPacket.getLeftPerfectData());
                                        hearingEnhanceDataDTO.setFrequencyRightCurveData(hearingEnhanceFreqPacket.getRightPerfectData());
                                        map.put(Integer.valueOf(hearingEnhanceFreqPacket.getUid()), hearingEnhanceDataDTO);
                                    }
                                }
                                if (A.l()) {
                                    A.b("HearingEnhancementRepository", "EVENT_ID_BT_HEARING_ENHANCE_FREQ_PARAMS, dataMap: " + map);
                                }
                                lVar.f20046v.m(map);
                            }
                            break;
                        case 1048623:
                            HearingEnhancementInfo hearingEnhancementInfo = (HearingEnhancementInfo) bluetoothReceiveDTO.getData();
                            if (A.l()) {
                                A.b("HearingEnhancementRepository", "EVENT_ID_BT_HEARING_ENHANCE_DATA, hearingEnhancementInfo: " + hearingEnhancementInfo);
                            }
                            if (hearingEnhancementInfo == null) {
                                A.h("HearingEnhancementRepository", "EVENT_ID_BT_HEARING_ENHANCE_DATA, hearingEnhancementInfo is null");
                                return;
                            }
                            o0.c.f1145c.execute(new RunnableC0369c(25, lVar, hearingEnhancementInfo));
                            break;
                        case 1048624:
                            DeviceInfo deviceInfo = (DeviceInfo) bluetoothReceiveDTO.getData();
                            if (deviceInfo != null) {
                                if (A.l()) {
                                    A.b("HearingEnhancementRepository", "EVENT_ID_BT_EAR_RESTORE_DATA_INFO " + A.r(deviceInfo.getDeviceAddress()) + " infoList: " + deviceInfo.getEarRestoreDataInfoList());
                                }
                                lVar.f20048x.m(deviceInfo.getEarRestoreDataInfoList());
                                HearingEnhancementEntity hearingEnhancementEntityD = lVar.f20042r.d();
                                if (hearingEnhancementEntityD == null) {
                                    A.b("HearingEnhancementRepository", "EVENT_ID_BT_EAR_RESTORE_DATA_INFO currentUsageEntity is null when receive restore data");
                                    return;
                                }
                                o0.c.f1145c.execute(new O(lVar, (HearingEnhancementEntity) com.oplus.melody.common.data.a.copyOf(hearingEnhancementEntityD, HearingEnhancementEntity.class), deviceInfo, hearingEnhancementEntityD, 3));
                            }
                            break;
                        default:
                            switch (eventId) {
                                case 1048644:
                                    final HearingEnhanceEarScanStatusInfo hearingEnhanceEarScanStatusInfo = (HearingEnhanceEarScanStatusInfo) bluetoothReceiveDTO.getData();
                                    A.c("HearingEnhancementRepository", new Supplier() { // from class: com.oplus.melody.model.repository.hearingenhance.g
                                        @Override // java.util.function.Supplier
                                        public final Object get() {
                                            return "EVENT_ID_BT_EAR_SCAN_STATUS_CHANGED, statusInfo: " + hearingEnhanceEarScanStatusInfo;
                                        }
                                    });
                                    if (hearingEnhanceEarScanStatusInfo != null) {
                                        EarScanStatusDTO earScanStatusDTO = new EarScanStatusDTO();
                                        earScanStatusDTO.setAddress(hearingEnhanceEarScanStatusInfo.getAddress());
                                        earScanStatusDTO.setHearingType(hearingEnhanceEarScanStatusInfo.getHearingType());
                                        earScanStatusDTO.setStatus(hearingEnhanceEarScanStatusInfo.getStatus());
                                        C0379m.k(lVar.f20044t, earScanStatusDTO);
                                    }
                                    break;
                                case 1048645:
                                    HearingEnhancementEarScanResult hearingEnhancementEarScanResult = (HearingEnhancementEarScanResult) bluetoothReceiveDTO.getData();
                                    A.c("HearingEnhancementRepository", new I(hearingEnhancementEarScanResult, 2));
                                    if (hearingEnhancementEarScanResult != null) {
                                        EarScanResultDTO earScanResultDTO = new EarScanResultDTO();
                                        earScanResultDTO.setAddress(hearingEnhancementEarScanResult.getAddress());
                                        earScanResultDTO.setAction(hearingEnhancementEarScanResult.getAction());
                                        earScanResultDTO.setUniqueId(hearingEnhancementEarScanResult.getUniqueId());
                                        earScanResultDTO.setResultData(hearingEnhancementEarScanResult.getResultData());
                                        C0379m.k(lVar.f20045u, earScanResultDTO);
                                    }
                                    break;
                                case 1048646:
                                    HearingEnhancementEarScanResult hearingEnhancementEarScanResult2 = (HearingEnhancementEarScanResult) bluetoothReceiveDTO.getData();
                                    A.c("HearingEnhancementRepository", new S7.c(hearingEnhancementEarScanResult2, 28));
                                    if (hearingEnhancementEarScanResult2 != null) {
                                        o0.c.f1145c.execute(new E9.k(22, lVar, hearingEnhancementEarScanResult2));
                                    }
                                    break;
                                case 1048647:
                                    HearingEnhanceFreqPacketInfo hearingEnhanceFreqPacketInfo2 = (HearingEnhanceFreqPacketInfo) bluetoothReceiveDTO.getData();
                                    A.c("HearingEnhancementRepository", new f(hearingEnhanceFreqPacketInfo2, 1));
                                    if (hearingEnhanceFreqPacketInfo2 != null && !hearingEnhanceFreqPacketInfo2.getFreqPackets().isEmpty()) {
                                        o0.c.f1145c.execute(new RunnableC0369c(26, lVar, hearingEnhanceFreqPacketInfo2));
                                    }
                                    break;
                                default:
                                    return;
                            }
                            break;
                    }
                } else {
                    SetCommandStateInfo setCommandStateInfo = (SetCommandStateInfo) bluetoothReceiveDTO.getData();
                    if (setCommandStateInfo != null) {
                        CompletableFuture completableFuture = (CompletableFuture) lVar.f20049y.remove(a.x(setCommandStateInfo.mResponseCommand & (-32769), setCommandStateInfo.getAddress()));
                        if (completableFuture != null && !completableFuture.isDone()) {
                            SetCommandStateDTO setCommandStateDTO = new SetCommandStateDTO();
                            setCommandStateDTO.setAddress(setCommandStateInfo.getAddress());
                            setCommandStateDTO.setSetCommandStatus(setCommandStateInfo.getSetStatus());
                            completableFuture.complete(setCommandStateDTO);
                        }
                    }
                }
                Integer.toHexString(eventId);
            }
        }, e10);
    }

    public static byte[] J(int i10, List list) {
        if (C0901g.a(list)) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EarRestoreDataInfo earRestoreDataInfo = (EarRestoreDataInfo) it.next();
            if (earRestoreDataInfo.getRestoreDataType() == i10) {
                return earRestoreDataInfo.getData();
            }
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public static void K(List list, HearingEnhancementEntity hearingEnhancementEntity) {
        HearingEnhanceDataDTO data = hearingEnhancementEntity.getData();
        if (data == null) {
            data = new HearingEnhanceDataDTO();
        }
        byte[] bArrJ = J(1, list);
        if (bArrJ == null) {
            return;
        }
        try {
            data.setRestoreDesId(D5.c.p(bArrJ, 0, bArrJ.length, false));
        } catch (Exception e10) {
            A.i("HearingEnhancementRepository", "resumeRestoreData failed ", e10);
        }
        hearingEnhancementEntity.setData(data);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void A() {
        C0379m.k(this.f20043s, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void B() {
        C0379m.k(this.f20042r, null);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void C(HearingEnhancementEntity hearingEnhancementEntity) {
        HearingEnhancementEntity hearingEnhancementEntity2;
        if (hearingEnhancementEntity == null) {
            A.h("HearingEnhancementRepository", "params is not valid: entity is null");
            return;
        }
        if (TextUtils.isEmpty(hearingEnhancementEntity.getUid()) || TextUtils.isEmpty(hearingEnhancementEntity.getAddress()) || hearingEnhancementEntity.getData() == null) {
            StringBuilder sb2 = new StringBuilder("params is not valid: , entity addr: ");
            sb2.append(hearingEnhancementEntity.getAddress());
            sb2.append(", name: ");
            sb2.append(hearingEnhancementEntity.getName());
            sb2.append(", recordName: ");
            sb2.append(hearingEnhancementEntity.getData() != null ? hearingEnhancementEntity.getData().getRecordName() : null);
            sb2.append(", index: ");
            sb2.append(hearingEnhancementEntity.getLocalIndex());
            A.f("HearingEnhancementRepository", sb2.toString());
            return;
        }
        List<HearingEnhancementEntity> listG = this.f20040p.g(hearingEnhancementEntity.getAddress());
        if (listG == null) {
            A.h("HearingEnhancementRepository", "deleteIfNeeded, entityList is null");
        } else {
            ArrayList arrayList = new ArrayList(listG);
            if (HearingEnhancementEntity.findMatchEntity(arrayList, hearingEnhancementEntity) == null) {
                arrayList.add(hearingEnhancementEntity);
            }
            if (arrayList.size() > 10) {
                HearingEnhancementEntity hearingEnhancementEntityD = this.f20042r.d();
                int size = arrayList.size() - 1;
                while (true) {
                    if (size < 0) {
                        hearingEnhancementEntity2 = null;
                        break;
                    }
                    if ((hearingEnhancementEntityD == null || !TextUtils.equals(((HearingEnhancementEntity) arrayList.get(size)).getUid(), hearingEnhancementEntityD.getUid())) && !TextUtils.equals(((HearingEnhancementEntity) arrayList.get(size)).getUid(), hearingEnhancementEntity.getUid())) {
                        hearingEnhancementEntity2 = (HearingEnhancementEntity) arrayList.get(size);
                        this.f20041q.remove(hearingEnhancementEntity2.getUid());
                        this.f20040p.d(hearingEnhancementEntity2);
                        break;
                    }
                    size--;
                }
                if (hearingEnhancementEntity2 != null) {
                    A.f("HearingEnhancementRepository", "deleteIfNeeded , entity addr: " + hearingEnhancementEntity2.getAddress() + ", name: " + hearingEnhancementEntity2.getName() + ", index: " + hearingEnhancementEntity2.getLocalIndex());
                    listG.remove(hearingEnhancementEntity2);
                }
            }
        }
        for (HearingEnhancementEntity hearingEnhancementEntity3 : listG == null ? Collections.EMPTY_LIST : listG) {
            HearingEnhanceDataDTO data = hearingEnhancementEntity3.getData();
            if (TextUtils.isEmpty(hearingEnhancementEntity3.getLocalIndex()) && (data == null || TextUtils.isEmpty(data.getRecordName()))) {
                hearingEnhancementEntity3.setLocalIndex(HearingEnhancementEntity.getLocalIndex(listG, hearingEnhancementEntity3));
                this.f20040p.h(hearingEnhancementEntity3);
            }
        }
        HearingEnhanceDataDTO data2 = hearingEnhancementEntity.getData();
        if (TextUtils.isEmpty(hearingEnhancementEntity.getLocalIndex()) && (data2 == null || TextUtils.isEmpty(data2.getRecordName()))) {
            hearingEnhancementEntity.setLocalIndex(HearingEnhancementEntity.getLocalIndex(listG, hearingEnhancementEntity));
        }
        if (S.s(C0906l.f19501a)) {
            J7.b.a().d();
        }
        StringBuilder sbN = androidx.appcompat.widget.a.n(this.f20040p.e(hearingEnhancementEntity), "saveEnhanceData ok, id: ", ", entity addr: ");
        sbN.append(hearingEnhancementEntity.getAddress());
        sbN.append(", name: ");
        sbN.append(hearingEnhancementEntity.getName());
        sbN.append(", index: ");
        sbN.append(hearingEnhancementEntity.getLocalIndex());
        sbN.append(", getUid: ");
        sbN.append(hearingEnhancementEntity.getUid());
        sbN.append(", recordName: ");
        sbN.append(hearingEnhancementEntity.getData() != null ? hearingEnhancementEntity.getData().getRecordName() : null);
        A.f("HearingEnhancementRepository", sbN.toString());
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> D(final String str, final int i10, final int i11, final byte[] bArr) {
        return L(str, 1045, new Supplier() { // from class: com.oplus.melody.model.repository.hearingenhance.i
            @Override // java.util.function.Supplier
            public final Object get() {
                String str2 = str;
                int i12 = i10;
                int i13 = i11;
                byte[] bArr2 = bArr;
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1060);
                intentU.putExtra("param_address", str2);
                intentU.putExtra("param_hearing_action_type", i12);
                intentU.putExtra("param_hearing_uid", i13);
                intentU.putExtra("param_ear_scan_data", bArr2);
                com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                return new q0(5L, TimeUnit.SECONDS);
            }
        });
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture E(String str, int i10, int i11, String str2, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList.get(i12);
                i12++;
                HearingDetectInfoDTO hearingDetectInfoDTO = (HearingDetectInfoDTO) obj;
                arrayList2.add(new HearingDetectingInfo(hearingDetectInfoDTO.getDeviceType(), hearingDetectInfoDTO.getType(), hearingDetectInfoDTO.getDbValue()));
            }
        }
        d dVar = new d(str, i10, i11, str2, arrayList2);
        return (CompletableFuture) this.f20049y.compute(a.x(1038, str), new e(dVar, 0));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> F(String str, ArrayList<EarRestoreDataDTO> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            A.h("HearingEnhancementRepository", "setEarRestoreData addr is null!");
            return I();
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            EarRestoreDataDTO earRestoreDataDTO = arrayList.get(i10);
            i10++;
            EarRestoreDataDTO earRestoreDataDTO2 = earRestoreDataDTO;
            arrayList2.add(new EarRestoreDataInfo(earRestoreDataDTO2.getRestoreDataType(), earRestoreDataDTO2.getDataLength(), earRestoreDataDTO2.getData()));
        }
        this.f20048x.m(arrayList2);
        return L(str, 1041, new C0384s(23, str, arrayList2));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> G(String str, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            return L(str, 1027, new C0899e(str, z2, 2));
        }
        A.h("HearingEnhancementRepository", "setSwitchFeature addr is null!");
        return I();
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<SetCommandStateDTO> H(String str, HearingDetectInfoDTO hearingDetectInfoDTO) {
        if (hearingDetectInfoDTO == null) {
            A.h("HearingEnhancementRepository", "switchProcessHearingDetectionParams addr is null!");
            return I();
        }
        C0386u c0386u = new C0386u(21, str, hearingDetectInfoDTO);
        return (CompletableFuture) this.f20049y.compute(a.x(1038, str), new C0389x(c0386u, 5));
    }

    public final CompletableFuture<SetCommandStateDTO> I() {
        if (this.f20050z == null) {
            this.f20050z = q0.b(MelodyException.e(0, "Invalid address"));
        }
        return this.f20050z;
    }

    public final CompletableFuture<SetCommandStateDTO> L(String str, int i10, Supplier<CompletableFuture<SetCommandStateDTO>> supplier) {
        return (CompletableFuture) this.f20049y.compute(a.x(i10, str), new B(supplier, 3));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<Integer> a(ArrayList<HearingEnhancementEntity> arrayList) {
        int i10 = 0;
        if (C0901g.a(arrayList)) {
            return CompletableFuture.completedFuture(0);
        }
        u<HearingEnhancementEntity> uVar = this.f20042r;
        HearingEnhancementEntity hearingEnhancementEntityD = uVar.d();
        int size = arrayList.size();
        while (i10 < size) {
            HearingEnhancementEntity hearingEnhancementEntity = arrayList.get(i10);
            i10++;
            HearingEnhancementEntity hearingEnhancementEntity2 = hearingEnhancementEntity;
            this.f20041q.remove(hearingEnhancementEntity2.getUid());
            if (hearingEnhancementEntityD != null && TextUtils.equals(hearingEnhancementEntity2.getUid(), hearingEnhancementEntityD.getUid())) {
                C0379m.k(uVar, null);
            }
        }
        return CompletableFuture.supplyAsync(new B9.f(17, this, arrayList));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture b(int i10, int i11, String str) {
        if (TextUtils.isEmpty(str)) {
            A.h("HearingEnhancementRepository", "earScan addr is null!");
            return I();
        }
        x xVar = new x(str, i10, i11, 1);
        return (CompletableFuture) this.f20049y.compute(a.x(1037, str), new B(xVar, 4));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void c(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, 1058, "param_address", str, heyMelodyApplication);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<Map<Integer, HearingEnhanceDataDTO>> d() {
        return this.f20047w;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void e(String str, int i10, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            A.h("HearingEnhancementRepository", "getEarScanFilterData earScanData is null!");
            return;
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1059);
        intentU.putExtra("param_address", str);
        intentU.putExtra("param_hearing_uid", i10);
        intentU.putExtra("param_ear_scan_data", bArr);
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<EarScanResultDTO> f() {
        return this.f20045u;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<EarScanStatusDTO> g() {
        return this.f20044t;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<Map<Integer, HearingEnhanceDataDTO>> h() {
        return this.f20046v;
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 18001:
                E e10 = h0.f1099c;
                h0.i(message, this.f20042r);
                return true;
            case 18002:
                E e11 = h0.f1099c;
                h0.i(message, this.f20048x);
                return true;
            case 18003:
                E e12 = h0.f1099c;
                h0.i(message, this.f20043s);
                return true;
            case 18004:
                E e13 = h0.f1099c;
                h0.i(message, this.f20044t);
                return true;
            case 18005:
                E e14 = h0.f1099c;
                h0.i(message, this.f20045u);
                return true;
            case 18006:
                E e15 = h0.f1099c;
                h0.i(message, this.f20046v);
                return true;
            case 18007:
                E e16 = h0.f1099c;
                h0.i(message, this.f20047w);
                return true;
            case 18008:
                v(data.getString("arg1"), data.getString("arg2"));
                break;
            case 18010:
                z();
                break;
            case 18011:
                A();
                break;
            case 18012:
                y();
                break;
            case 18013:
                E e17 = h0.f1099c;
                h0.c(message, s(data.getString("macAddress")));
                return true;
            case 18014:
                k(data.getString("macAddress"));
                break;
            case 18015:
                ArrayList arrayListE = C0914u.e(data, "arg3", HearingDetectInfoDTO.class);
                m(data.getInt("arg2"), data.getString("arg1"), arrayListE);
                break;
            case 18016:
                E e18 = h0.f1099c;
                h0.c(message, q(data.getString("macAddress")));
                return true;
            case 18017:
                c(data.getString("macAddress"));
                break;
            case 18018:
                e(data.getString("arg1"), data.getInt("arg2"), data.getByteArray("arg3"));
                break;
            case 18019:
                String string = data.getString("arg1");
                boolean z2 = data.getBoolean("arg2");
                E e19 = h0.f1099c;
                h0.c(message, G(string, z2));
                return true;
            case 18020:
                String string2 = data.getString("arg1");
                int i10 = data.getInt("arg2");
                E e20 = h0.f1099c;
                h0.c(message, u(i10, string2));
                return true;
            case 18021:
                String string3 = data.getString("arg1");
                int i11 = data.getInt("arg2");
                int i12 = data.getInt("arg3");
                E e21 = h0.f1099c;
                h0.c(message, b(i11, i12, string3));
                return true;
            case 18022:
                HearingDetectInfoDTO hearingDetectInfoDTO = (HearingDetectInfoDTO) C0914u.g(data, "arg2", HearingDetectInfoDTO.class);
                E e22 = h0.f1099c;
                h0.c(message, H(data.getString("arg1"), hearingDetectInfoDTO));
                return true;
            case 18023:
                ArrayList arrayListE2 = C0914u.e(data, "arg5", HearingDetectInfoDTO.class);
                String string4 = data.getString("arg1");
                int i13 = data.getInt("arg2");
                int i14 = data.getInt("arg3");
                String string5 = data.getString("arg4");
                E e23 = h0.f1099c;
                h0.c(message, E(string4, i13, i14, string5, arrayListE2));
                return true;
            case 18024:
                String string6 = data.getString("arg1");
                int i15 = data.getInt("arg2");
                int i16 = data.getInt("arg3");
                byte[] byteArray = data.getByteArray("arg4");
                E e24 = h0.f1099c;
                h0.c(message, D(string6, i15, i16, byteArray));
                return true;
            case 18025:
                ArrayList<EarRestoreDataDTO> arrayListE3 = C0914u.e(data, "arg2", EarRestoreDataDTO.class);
                E e25 = h0.f1099c;
                h0.c(message, F(data.getString("arg1"), arrayListE3));
                return true;
            case 18026:
                E e26 = h0.f1099c;
                h0.j(message, i(data.getString("macAddress")), new C7.d(5));
                return true;
            case 18027:
                String string7 = data.getString("macAddress");
                E e27 = h0.f1099c;
                h0.d(message, l(string7), new C7.d(5));
                return true;
            case 18029:
                E e28 = h0.f1099c;
                h0.c(message, a(C0914u.e(data, "arg1", HearingEnhancementEntity.class)));
                return true;
            case 18030:
                o0.c.f1145c.execute(new E9.k(23, this, (HearingEnhancementEntity) C0914u.g(data, "arg1", HearingEnhancementEntity.class)));
                break;
            case 18032:
                B();
                break;
        }
        h0.h(message, null);
        return true;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<List<HearingEnhancementEntity>> i(String str) {
        ConcurrentHashMap concurrentHashMap = this.f20040p.f19694b;
        O7.l lVar = (O7.l) concurrentHashMap.get(str);
        O7.l lVar2 = new O7.l();
        if (lVar == null) {
            concurrentHashMap.put(str, lVar2);
            return lVar2;
        }
        if (lVar.d() != null) {
            lVar2.m(new ArrayList((Collection) lVar.d()));
        }
        return lVar2;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final List<HearingEnhancementEntity> j(String str) {
        return this.f20040p.g(str);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void k(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, 1031, "param_address", str, heyMelodyApplication);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<List<HearingEnhancementEntity>> l(String str) {
        return CompletableFuture.supplyAsync(new Ca.s(14, this, str));
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void m(int i10, String str, ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            A.h("HearingEnhancementRepository", "getHearingEnhancementFilterData infoList is null!");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            HearingDetectInfoDTO hearingDetectInfoDTO = (HearingDetectInfoDTO) obj;
            arrayList2.add(new HearingDetectingInfo(hearingDetectInfoDTO.getDeviceType(), hearingDetectInfoDTO.getType(), hearingDetectInfoDTO.getDbValue()));
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1030);
        intentU.putExtra("param_address", str);
        intentU.putExtra("param_hearing_uid", i10);
        intentU.putParcelableArrayListExtra("param_detecting_info_list", C0901g.b(arrayList2));
        com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<HearingStatusDTO> n() {
        return this.f20043s;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final byte[] p(int i10) {
        return J(i10, this.f20048x.d());
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<HearingEnhancementEntity> q(String str) {
        if (TextUtils.isEmpty(str)) {
            A.h("HearingEnhancementRepository", "getUsageEarScanFuture: addr is empty...");
            return q0.b(MelodyException.e(0, "addr is empty"));
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, 1058, "param_address", str, heyMelodyApplication);
        q0 q0Var = this.f20039B;
        if (q0Var != null) {
            q0Var.cancel(true);
        }
        q0 q0Var2 = new q0(200L, TimeUnit.MILLISECONDS);
        this.f20039B = q0Var2;
        return q0Var2;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final s<HearingEnhancementEntity> r() {
        return this.f20042r;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture<HearingEnhancementEntity> s(String str) {
        if (TextUtils.isEmpty(str)) {
            A.h("HearingEnhancementRepository", "getUsageEnhanceEntityFuture: addr is empty...");
            return q0.b(MelodyException.e(0, "addr is empty"));
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        A6.g.i(heyMelodyApplication, 1031, "param_address", str, heyMelodyApplication);
        q0 q0Var = this.f20038A;
        if (q0Var != null) {
            q0Var.cancel(true);
        }
        q0 q0Var2 = new q0(200L, TimeUnit.MILLISECONDS);
        this.f20038A = q0Var2;
        return q0Var2;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final boolean t(String str) {
        CompletableFuture completableFuture = (CompletableFuture) this.f20049y.get(a.x(1037, str));
        return (completableFuture == null || completableFuture.isDone()) ? false : true;
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final CompletableFuture u(int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            A.h("HearingEnhancementRepository", "hearingEnhancementDetection addr is null!");
            return I();
        }
        final D6.a aVar = new D6.a(str, i10, 5);
        return (CompletableFuture) this.f20049y.compute(a.x(1037, str), new BiFunction() { // from class: com.oplus.melody.model.repository.hearingenhance.h
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                CompletableFuture completableFuture = (CompletableFuture) obj2;
                if (completableFuture != null && !completableFuture.isDone()) {
                    A.b("HearingEnhancementRepository", "hearingEnhancementDetection compute old future.cancel!");
                    completableFuture.cancel(true);
                }
                return (CompletableFuture) aVar.get();
            }
        });
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void v(String str, String str2) {
        k(str);
        if (w(str2)) {
            c(str);
        }
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final boolean w(String str) {
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(null, str);
        if (whitelistConfigDTOC == null || whitelistConfigDTOC.getFunction() == null) {
            return false;
        }
        return Y.e(whitelistConfigDTOC.getFunction().getEarScan(), false);
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void y() {
        this.f20046v.m(null);
        this.f20047w.m(null);
        A();
        z();
    }

    @Override // com.oplus.melody.model.repository.hearingenhance.a
    public final void z() {
        C0379m.k(this.f20044t, null);
        C0379m.k(this.f20045u, null);
    }
}
