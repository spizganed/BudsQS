package com.oplus.melody.model.repository.personaldress;

import A6.i;
import A6.p;
import A9.j;
import A9.n;
import D7.C;
import D7.C0368b;
import D7.C0379m;
import D7.C0384s;
import D7.E;
import D7.H;
import D7.h0;
import D7.q0;
import Ea.M;
import J8.f;
import Kb.m;
import O7.l;
import a9.C0531H;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.media3.session.D0;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.statistics.DataTypeConstants;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.app.discovery.C0873o0;
import com.oplus.melody.btsdk.api.data.UpgradeStateInfo;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.btsdk.protocol.commands.k;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0908n;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.model.db.MelodyDatabase;
import com.oplus.melody.model.db.PersonalDressDao;
import com.oplus.melody.model.db.PersonalDressEntity;
import com.oplus.melody.model.db.PersonalDressSeriesDao;
import com.oplus.melody.model.db.PersonalDressSeriesEntity;
import com.oplus.melody.model.net.data.PersonalDressInfoDO;
import com.oplus.melody.model.net.data.PersonalDressSeriesInfoDO;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.D;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.personaldress.CustomDressDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.personaldress.carousel.CarouselDressDTO;
import com.oplus.melody.model.repository.personaldress.carousel.EquipmentCarouselDTO;
import e9.C1017a;
import e9.C1020d;
import g0.C1065d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;
import la.j0;
import m8.g;
import n8.AbstractC1353a;
import n8.g;
import s8.AbstractC1508a;
import t8.C1531A;
import t8.q;
import u8.C1555c;

/* JADX INFO: compiled from: PersonalDressRepositoryServerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.oplus.melody.model.repository.personaldress.a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final HashMap<String, l<CustomDressDTO>> f20066A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final l<Boolean> f20067B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final C f20068C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final Jb.b f20069D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap<String, l<String>> f20070p = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u<UpgradeStateInfo> f20071q = new u<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ConcurrentHashMap<String, u<PersonalDressEntity>> f20072r = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompletableFuture<Jb.l> f20073s = new CompletableFuture<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PersonalDressSeriesDao f20074t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<DressSeriesDTO> f20075u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CompletableFuture<Jb.l> f20076v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap<String, PersonalDressEntity> f20077w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<PersonalDressDTO> f20078x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final PersonalDressDao f20079y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentHashMap<String, l<Boolean>> f20080z;

    /* JADX INFO: compiled from: PersonalDressRepositoryServerImpl.kt */
    public static final class a extends com.oplus.melody.model.repository.zenmode.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.oplus.melody.model.repository.zenmode.c f20081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a<String, Integer> f20082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f20083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f20084d;

        public a(com.oplus.melody.model.repository.zenmode.c cVar, androidx.collection.a<String, Integer> aVar, int i10, Map<String, Long> map) {
            this.f20081a = cVar;
            this.f20082b = aVar;
            this.f20083c = i10;
            this.f20084d = map;
        }

        @Override // com.oplus.melody.model.repository.zenmode.c
        public final void a(String str, String str2) {
            com.oplus.melody.model.repository.zenmode.c cVar = this.f20081a;
            if (cVar != null) {
                cVar.a(str, str2);
            }
        }

        @Override // com.oplus.melody.model.repository.zenmode.c
        public final void b(int i10, String str, String str2) {
            com.oplus.melody.model.repository.zenmode.c cVar = this.f20081a;
            if (cVar != null) {
                cVar.b(i10, str, str2);
            }
        }

        @Override // com.oplus.melody.model.repository.zenmode.c
        public final void c(String str) {
            com.oplus.melody.model.repository.zenmode.c cVar = this.f20081a;
            if (cVar != null) {
                cVar.c(str);
            }
        }

        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, java.util.Map] */
        @Override // com.oplus.melody.model.repository.zenmode.c
        public final void d(int i10, String str) {
            long jLongValue;
            androidx.collection.a<String, Integer> aVar = this.f20082b;
            synchronized (aVar) {
                aVar.put(str, Integer.valueOf(i10));
                Jb.l lVar = Jb.l.f2618a;
            }
            androidx.collection.a<String, Integer> aVar2 = this.f20082b;
            ?? r14 = this.f20084d;
            synchronized (aVar2) {
                try {
                    jLongValue = 0;
                    for (Map.Entry<String, Integer> entry : aVar2.entrySet()) {
                        String key = entry.getKey();
                        long jIntValue = entry.getValue().intValue();
                        Long l4 = (Long) r14.get(key);
                        jLongValue += (jIntValue * (l4 != null ? l4.longValue() : 0L)) / ((long) 100);
                    }
                    Jb.l lVar2 = Jb.l.f2618a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i11 = (int) ((jLongValue * ((long) 100)) / ((long) this.f20083c));
            A.c("PersonalDressRepository", new k(i11, 20));
            this.f20081a.e(i11);
        }
    }

    public e() {
        List list = Collections.EMPTY_LIST;
        h.d(list, "emptyList(...)");
        this.f20075u = list;
        this.f20076v = new CompletableFuture<>();
        this.f20077w = new ConcurrentHashMap<>();
        this.f20078x = list;
        this.f20080z = new ConcurrentHashMap<>();
        this.f20066A = new HashMap<>();
        this.f20067B = new l<>();
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.f20068C = new C(10L);
        this.f20069D = kotlin.a.a(new A7.a(15));
        if (this.f20079y == null) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            MelodyDatabase melodyDatabaseT = MelodyDatabase.t(heyMelodyApplication);
            PersonalDressDao personalDressDaoV = melodyDatabaseT != null ? melodyDatabaseT.v() : null;
            this.f20079y = personalDressDaoV;
            C0379m.h(personalDressDaoV != null ? personalDressDaoV.f() : null, new j0(this, 2));
        }
        if (this.f20074t == null) {
            HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
            if (heyMelodyApplication2 == null) {
                h.i("context");
                throw null;
            }
            MelodyDatabase melodyDatabaseT2 = MelodyDatabase.t(heyMelodyApplication2);
            PersonalDressSeriesDao personalDressSeriesDaoW = melodyDatabaseT2 != null ? melodyDatabaseT2.w() : null;
            this.f20074t = personalDressSeriesDaoW;
            C0379m.h(personalDressSeriesDaoW != null ? personalDressSeriesDaoW.d() : null, new g(this, 0));
        }
    }

    public static PersonalDressSeriesEntity B(String str, String str2, int i10, PersonalDressSeriesInfoDO personalDressSeriesInfoDO) {
        PersonalDressSeriesEntity personalDressSeriesEntity = new PersonalDressSeriesEntity();
        personalDressSeriesEntity.setMColorId(i10);
        personalDressSeriesEntity.setMProductId(str2);
        Integer id = personalDressSeriesInfoDO.getId();
        personalDressSeriesEntity.setId(id != null ? id.intValue() : 0);
        personalDressSeriesEntity.setIdentifyId(personalDressSeriesInfoDO.getIdentifyId());
        HashMap map = new HashMap();
        String seriesName = personalDressSeriesInfoDO.getSeriesName();
        if (seriesName == null) {
            seriesName = "";
        }
        map.put(str, seriesName);
        personalDressSeriesEntity.setSeriesName(map);
        HashMap map2 = new HashMap();
        String summary = personalDressSeriesInfoDO.getSummary();
        map2.put(str, summary != null ? summary : "");
        personalDressSeriesEntity.setSummary(map2);
        personalDressSeriesEntity.setPriority(personalDressSeriesInfoDO.getPriority());
        personalDressSeriesEntity.setThemeCount(personalDressSeriesInfoDO.getThemeCount());
        personalDressSeriesEntity.setBannerImgUrl(personalDressSeriesInfoDO.getBannerImgUrl());
        personalDressSeriesEntity.setCreateTime(personalDressSeriesInfoDO.getCreateTime());
        personalDressSeriesEntity.setUpdateTime(personalDressSeriesInfoDO.getUpdateTime());
        personalDressSeriesEntity.setBottomColor(personalDressSeriesInfoDO.getBottomColor());
        return personalDressSeriesEntity;
    }

    public static void D(File file) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName()) && t8.u.a() && Build.VERSION.SDK_INT <= 28 && C1531A.b(file)) {
            A.c("PersonalDressRepository", new f(file, 4));
            q.c("melody-model-download").edit().putString(file.getName(), C0911q.m(file)).apply();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v22, types: [java.util.ArrayList] */
    public static CustomDressDTO L(String pid, String color) {
        ?? arrayList;
        String mIcon;
        File[] fileArrListFiles;
        h.e(pid, "pid");
        h.e(color, "color");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        File file = new File(heyMelodyApplication.getFilesDir(), "custom-dress");
        if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            Regex regex = new Regex("popup-" + pid + "-" + color + "-\\d+");
            arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                h.d(name, "getName(...)");
                if (regex.e(name) && file2.isDirectory()) {
                    arrayList.add(file2);
                }
            }
        } else {
            arrayList = Collections.EMPTY_LIST;
            h.d(arrayList, "emptyList(...)");
        }
        CustomDressDTO customDressDTO = new CustomDressDTO(null, null, null, 7, null);
        customDressDTO.setProductId(pid);
        customDressDTO.setColorId(color);
        ArrayList arrayList2 = new ArrayList(m.i(arrayList));
        for (File zipDir : arrayList) {
            h.e(zipDir, "zipDir");
            C1555c c1555c = (C1555c) C0911q.q(new File(zipDir, "config.json"), C1555c.class);
            CustomDressDTO.CustomDressData customDressData = new CustomDressDTO.CustomDressData(null, null, null, null, 0L, null, 63, null);
            String name2 = zipDir.getName();
            h.d(name2, "getName(...)");
            customDressData.setThemeId((String) ec.m.W(name2, new String[]{"-"}).get(3));
            customDressData.setName(c1555c != null ? c1555c.getMName() : null);
            customDressData.setBgType(c1555c != null ? c1555c.getMBgType() : null);
            customDressData.setBlurProgress(c1555c != null ? Integer.valueOf(c1555c.getMBlurProgress()) : null);
            if (c1555c != null && (mIcon = c1555c.getMIcon()) != null) {
                customDressData.setIconPath(new File(zipDir, mIcon).getAbsolutePath());
            }
            try {
                String themeId = customDressData.getThemeId();
                customDressData.setPriority(themeId != null ? Long.parseLong(themeId) : Long.MAX_VALUE);
            } catch (NumberFormatException unused) {
                customDressData.setPriority(Long.MAX_VALUE);
            }
            arrayList2.add(customDressData);
        }
        customDressDTO.setCustomDressData(arrayList2);
        return customDressDTO;
    }

    public static String M(int i10, String str, String str2) {
        return str + "_" + str2 + "_" + i10;
    }

    public static String N(int i10, String str) {
        return "new_dress_" + str + "_" + i10;
    }

    public static void P(PersonalDressDTO.PersonalDressData personalDressData, PersonalDressInfoDO personalDressInfoDO, String str) {
        personalDressData.setAnimSHA256(personalDressInfoDO.getAnimSHA256());
        Integer animSize = personalDressInfoDO.getAnimSize();
        personalDressData.setAnimSize(animSize != null ? animSize.intValue() : 0);
        Integer animType = personalDressInfoDO.getAnimType();
        personalDressData.setAnimType(animType != null ? animType.intValue() : 0);
        personalDressData.setAnimUploadTime(personalDressInfoDO.getAnimUploadTime());
        personalDressData.setAnimUrl(personalDressInfoDO.getAnimUrl());
        personalDressData.setDarkAnimSHA256(personalDressInfoDO.getDarkAnimSHA256());
        Integer darkAnimSize = personalDressInfoDO.getDarkAnimSize();
        personalDressData.setDarkAnimSize(darkAnimSize != null ? darkAnimSize.intValue() : 0);
        personalDressData.setDarkAnimUploadTime(personalDressInfoDO.getDarkAnimUploadTime());
        personalDressData.setDarkAnimUrl(personalDressInfoDO.getDarkAnimUrl());
        personalDressData.setDarkPreviewAnim(personalDressInfoDO.getDarkPreviewAnim());
        personalDressData.setDarkPreviewAnimSHA256(personalDressInfoDO.getDarkPreviewAnimSHA256());
        Integer darkPreviewAnimSize = personalDressInfoDO.getDarkPreviewAnimSize();
        personalDressData.setDarkPreviewAnimSize(darkPreviewAnimSize != null ? darkPreviewAnimSize.intValue() : 0);
        personalDressData.setId(personalDressInfoDO.getId());
        personalDressData.setStatic(h.a(personalDressInfoDO.isStatic(), Boolean.TRUE) ? 1 : 0);
        personalDressData.setPreviewAnim(personalDressInfoDO.getPreviewAnim());
        personalDressData.setPreviewAnimSHA256(personalDressInfoDO.getPreviewAnimSHA256());
        Integer previewAnimSize = personalDressInfoDO.getPreviewAnimSize();
        personalDressData.setPreviewAnimSize(previewAnimSize != null ? previewAnimSize.intValue() : 0);
        personalDressData.setPreviewDetailImgUrl(personalDressInfoDO.getPreviewDetailImgUrl());
        personalDressData.setPreviewListImgUrl(personalDressInfoDO.getPreviewListImgUrl());
        personalDressData.setSummary(new Bundle());
        String themeIdentifier = personalDressInfoDO.getThemeIdentifier();
        if (themeIdentifier == null) {
            themeIdentifier = VersionInfo.VENDOR_CODE_ERROR_VERSION;
        }
        personalDressData.setThemeId(themeIdentifier);
        personalDressData.setTitle(new Bundle());
        personalDressData.setToneSHA256(personalDressInfoDO.getToneSHA256());
        Integer toneSize = personalDressInfoDO.getToneSize();
        personalDressData.setToneSize(toneSize != null ? toneSize.intValue() : 0);
        personalDressData.setToneUploadTime(personalDressInfoDO.getToneUploadTime());
        personalDressData.setToneUrl(personalDressInfoDO.getToneUrl());
        personalDressData.setTonePreviewSHA256(personalDressInfoDO.getPreviewToneSHA256());
        Integer previewToneSize = personalDressInfoDO.getPreviewToneSize();
        personalDressData.setTonePreviewSize(previewToneSize != null ? previewToneSize.intValue() : 0);
        personalDressData.setTonePreviewUrl(personalDressInfoDO.getPreviewToneUrl());
        Integer materialType = personalDressInfoDO.getMaterialType();
        personalDressData.setMaterialType(materialType != null ? materialType.intValue() : 0);
        Integer publishStatus = personalDressInfoDO.getPublishStatus();
        personalDressData.setPublishStatus(publishStatus != null ? publishStatus.intValue() : 0);
        if (!TextUtils.isEmpty(personalDressInfoDO.getTitle())) {
            Bundle title = personalDressData.getTitle();
            h.b(title);
            title.putString(str, personalDressInfoDO.getTitle());
        }
        if (!TextUtils.isEmpty(personalDressInfoDO.getSummary())) {
            Bundle summary = personalDressData.getSummary();
            h.b(summary);
            summary.putString(str, personalDressInfoDO.getSummary());
        }
        Integer priority = personalDressInfoDO.getPriority();
        personalDressData.setPriority(priority != null ? priority.intValue() : 0);
        personalDressData.setTags(personalDressInfoDO.getTags());
        personalDressData.setCardZipUrl(personalDressInfoDO.getCardZipUrl());
        personalDressData.setCardZipSHA256(personalDressInfoDO.getCardZipSHA256());
        Integer downloadCount = personalDressInfoDO.getDownloadCount();
        personalDressData.setDownloadCount(downloadCount != null ? downloadCount.intValue() : 0);
        Boolean activity = personalDressInfoDO.getActivity();
        personalDressData.setActivity(activity != null ? activity.booleanValue() : false);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void A() {
        Q(this.f20077w);
    }

    public final boolean C(String str, List<WhitelistConfigDTO.DressFilter> list) {
        Object next;
        List<String> modelList;
        if (str == null || list == null) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            List<String> dressList = ((WhitelistConfigDTO.DressFilter) next).getDressList();
            if (dressList != null ? dressList.contains(str) : false) {
                break;
            }
        }
        WhitelistConfigDTO.DressFilter dressFilter = (WhitelistConfigDTO.DressFilter) next;
        if (dressFilter == null || (modelList = dressFilter.getModelList()) == null) {
            return true;
        }
        return modelList.contains((String) this.f20069D.getValue());
    }

    public final PersonalDressDTO E(int i10, String str) {
        Object next;
        Iterator<T> it = this.f20078x.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PersonalDressDTO personalDressDTO = (PersonalDressDTO) next;
            if (personalDressDTO.getColor() == i10 && TextUtils.equals(personalDressDTO.getProductId(), str)) {
                break;
            }
        }
        return (PersonalDressDTO) next;
    }

    public final DressSeriesDTO F(int i10, String str) {
        Object next;
        this.f20073s.join();
        Iterator<T> it = this.f20075u.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            DressSeriesDTO dressSeriesDTO = (DressSeriesDTO) next;
            if (dressSeriesDTO.getColor() == i10 && TextUtils.equals(dressSeriesDTO.getProductId(), str)) {
                break;
            }
        }
        return (DressSeriesDTO) next;
    }

    public final u<PersonalDressEntity> G(String address) {
        h.e(address, "address");
        u<PersonalDressEntity> uVarComputeIfAbsent = this.f20072r.computeIfAbsent(address, new com.oplus.melody.model.repository.zenmode.e(new E8.e(11), 11));
        h.d(uVarComputeIfAbsent, "computeIfAbsent(...)");
        return uVarComputeIfAbsent;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public final l<String> d(String address) {
        h.e(address, "address");
        l<String> lVarComputeIfAbsent = this.f20070p.computeIfAbsent(address, new Aa.c(new j(this, 28), 22));
        h.d(lVarComputeIfAbsent, "computeIfAbsent(...)");
        return lVarComputeIfAbsent;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final l<CustomDressDTO> f(String productId, String colorId) {
        h.e(productId, "productId");
        h.e(colorId, "colorId");
        A.c("PersonalDressRepository", new L6.d(productId, colorId, 2));
        l<CustomDressDTO> lVarComputeIfAbsent = this.f20066A.computeIfAbsent("custom_dress_" + productId + "_" + colorId, new Aa.c(new R8.u(this, productId, colorId, 2), 24));
        h.d(lVarComputeIfAbsent, "computeIfAbsent(...)");
        return lVarComputeIfAbsent;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final l<Boolean> g() {
        if (this.f20067B.d() == null) {
            l<Boolean> lVar = this.f20067B;
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            lVar.m((Boolean) C0908n.c(heyMelodyApplication, "key_custom_feature_mark", Boolean.TRUE));
        }
        return this.f20067B;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final l i(int i10, String productId) {
        h.e(productId, "productId");
        l<Boolean> lVarComputeIfAbsent = this.f20080z.computeIfAbsent(N(i10, productId), new com.oplus.melody.model.repository.zenmode.e(new C0531H(this, 14), 10));
        h.d(lVarComputeIfAbsent, "computeIfAbsent(...)");
        return lVarComputeIfAbsent;
    }

    public final boolean O(String str, String str2, boolean z2) {
        AbstractC0939b.E().z0(str, str2);
        d(str).m(str2);
        if (z2) {
            C0379m.k(G(str), null);
            return true;
        }
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str);
        if (earphoneDTOW == null) {
            A.c("PersonalDressRepository", new D6.f(str, 20));
            return false;
        }
        String strM = M(earphoneDTOW.getColorId(), str2, earphoneDTOW.getProductId());
        this.f20076v.join();
        PersonalDressEntity personalDressEntity = this.f20077w.get(strM);
        if (personalDressEntity != null) {
            A.c("PersonalDressRepository", new C0384s(28, strM, personalDressEntity));
            C0379m.k(G(str), personalDressEntity);
            return true;
        }
        A.h("PersonalDressRepository", "setCurrentPopThemeNoPop dressEntity is null key:" + strM);
        return false;
    }

    public final void Q(ConcurrentHashMap concurrentHashMap) {
        List<String> listH = AbstractC0939b.E().H();
        h.d(listH, "getSortedBondedDeviceIds(...)");
        for (String str : listH) {
            EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str);
            if (earphoneDTOW != null) {
                String popTheme = earphoneDTOW.getPopTheme();
                if (popTheme == null) {
                    popTheme = BaseHealthModule.TRACK_FATIGUE_REMIND;
                }
                PersonalDressEntity personalDressEntity = (PersonalDressEntity) concurrentHashMap.get(M(earphoneDTOW.getColorId(), popTheme, earphoneDTOW.getProductId()));
                if (personalDressEntity != null) {
                    h.b(str);
                    C0379m.k(G(str), personalDressEntity);
                }
            }
        }
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void a() {
        C0379m.k(this.f20071q, null);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final PersonalDressEntity b(String address) {
        h.e(address, "address");
        return G(address).d();
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final String c(String address) {
        WhitelistConfigDTO.Function function;
        h.e(address, "address");
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(address);
        List<WhitelistConfigDTO.DressFilter> dressFilterList = null;
        String popTheme = earphoneDTOW != null ? earphoneDTOW.getPopTheme() : null;
        WhitelistConfigDTO whitelistConfigDTOA = AbstractC1508a.f().a(address);
        if (whitelistConfigDTOA != null && (function = whitelistConfigDTOA.getFunction()) != null) {
            dressFilterList = function.getDressFilterList();
        }
        return (popTheme == null || popTheme.length() == 0 || !C(popTheme, dressFilterList)) ? BaseHealthModule.TRACK_FATIGUE_REMIND : popTheme;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final String e(int i10, String productId, String address) {
        Object next;
        int millis;
        final int i11;
        h.e(productId, "productId");
        h.e(address, "address");
        Object obj = n8.g.f26485c;
        final EquipmentCarouselDTO equipmentCarouselDTOC = g.a.a().c(address);
        if (equipmentCarouselDTOC == null || equipmentCarouselDTOC.getCarouselId() < 0) {
            A.b("PersonalDressRepository", "getCurrentPopThemeWithCarousel: no carousel equipment, fallback to getCurrentPopTheme");
            return c(address);
        }
        Object obj2 = AbstractC1353a.f26467c;
        Iterator it = AbstractC1353a.C0292a.a().b(i10, productId).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((CarouselDressDTO) next).getCarouselId() == equipmentCarouselDTOC.getCarouselId()) {
                break;
            }
        }
        final CarouselDressDTO carouselDressDTO = (CarouselDressDTO) next;
        if (carouselDressDTO == null || carouselDressDTO.getThemeIdList().isEmpty()) {
            A.b("PersonalDressRepository", "getCurrentPopThemeWithCarousel: no carousel dress found, fallback to getCurrentPopTheme");
            return c(address);
        }
        final int carouselThemeIndex = equipmentCarouselDTOC.getCarouselThemeIndex();
        int carouselType = carouselDressDTO.getCarouselType();
        long carouselStartTime = equipmentCarouselDTOC.getCarouselStartTime();
        int size = carouselDressDTO.getThemeIdList().size();
        if (size > 0) {
            if (carouselType == 0) {
                millis = carouselThemeIndex % size;
            } else if (carouselType != 1) {
                if (carouselType == 2) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (1 <= carouselStartTime && carouselStartTime < jCurrentTimeMillis) {
                        millis = ((int) ((jCurrentTimeMillis - carouselStartTime) / TimeUnit.DAYS.toMillis(7L))) % size;
                    }
                }
                i11 = 0;
            } else {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (1 <= carouselStartTime && carouselStartTime < jCurrentTimeMillis2) {
                    millis = ((int) ((jCurrentTimeMillis2 - carouselStartTime) / TimeUnit.DAYS.toMillis(1L))) % size;
                }
                i11 = 0;
            }
            i11 = millis;
        } else {
            i11 = 0;
        }
        if (i11 < 0 || i11 >= carouselDressDTO.getThemeIdList().size()) {
            A.c("PersonalDressRepository", new M(i11, carouselDressDTO, 14));
            return c(address);
        }
        final String str = carouselDressDTO.getThemeIdList().get(i11);
        if (carouselDressDTO.getCarouselType() == 0) {
            ForkJoinPool.commonPool().execute(new C8.b(address, equipmentCarouselDTOC, carouselThemeIndex < Integer.MAX_VALUE ? carouselThemeIndex + 1 : 0, 5));
        }
        A.c("PersonalDressRepository", new Supplier() { // from class: m8.c
            @Override // java.util.function.Supplier
            public final Object get() {
                EquipmentCarouselDTO equipmentCarouselDTO = equipmentCarouselDTOC;
                int carouselId = equipmentCarouselDTO.getCarouselId();
                int carouselType2 = carouselDressDTO.getCarouselType();
                long carouselStartTime2 = equipmentCarouselDTO.getCarouselStartTime();
                StringBuilder sbM = androidx.appcompat.widget.a.m(carouselId, carouselType2, "getCurrentPopThemeWithCarousel: use carousel theme carouselId=", " carouselType=", " carouselStartTime=");
                sbM.append(carouselStartTime2);
                sbM.append(" carouselThemeIndex=");
                sbM.append(carouselThemeIndex);
                sbM.append(" currentThemeIndex=");
                sbM.append(i11);
                sbM.append(" themeId=");
                sbM.append(str);
                return sbM.toString();
            }
        });
        return str;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void h(String address) {
        h.e(address, "address");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            A6.g.i(heyMelodyApplication, 1062, "param_address", address, heyMelodyApplication);
        } else {
            h.i("context");
            throw null;
        }
    }

    @Override // K7.b, android.os.Handler.Callback
    public final boolean handleMessage(Message msg) {
        String str;
        h.e(msg, "msg");
        Bundle data = msg.getData();
        switch (msg.what) {
            case 17001:
                A();
                h0.h(msg, null);
                break;
            case 17002:
                String string = data.getString("arg1");
                if (string == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e10 = h0.f1099c;
                    h0.j(msg, G(string), null);
                }
                break;
            case 17006:
                String string2 = data.getString("arg1");
                String string3 = data.getString("arg2");
                if (string2 == null || string3 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    u(string2, string3);
                    h0.h(msg, null);
                }
                break;
            case 17007:
                String string4 = data.getString("arg1");
                String string5 = data.getString("arg2");
                int i10 = data.getInt("arg3");
                boolean z2 = data.getBoolean("arg4");
                if (string4 == null || string5 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e11 = h0.f1099c;
                    h0.d(msg, s(string4, i10, string5, z2), null);
                }
                break;
            case 17008:
                String string6 = data.getString("arg1");
                if (string6 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    h(string6);
                    h0.h(msg, null);
                }
                break;
            case 17009:
                PersonalDressDTO.PersonalDressData personalDressData = (PersonalDressDTO.PersonalDressData) C0914u.g(data, "arg1", PersonalDressDTO.PersonalDressData.class);
                String string7 = data.getString("arg2");
                if (personalDressData == null || string7 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    int i11 = data.getInt("arg3");
                    com.oplus.melody.model.repository.zenmode.a aVar = new com.oplus.melody.model.repository.zenmode.a(msg);
                    E e12 = h0.f1099c;
                    h0.d(msg, j(personalDressData, string7, i11, aVar), null);
                }
                break;
            case 17010:
                String string8 = data.getString("arg1");
                int i12 = data.getInt("arg2");
                String string9 = data.getString("arg3");
                String string10 = data.getString("arg4");
                String string11 = data.getString("arg5");
                int i13 = data.getInt("arg6");
                if (string8 == null || string9 == null || string10 == null || string11 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e13 = h0.f1099c;
                    h0.d(msg, k(string8, string9, i12, i13, string10, string11), null);
                }
                break;
            case 17011:
                String string12 = data.getString("arg1");
                String string13 = data.getString("arg2");
                String string14 = data.getString("arg3");
                String string15 = data.getString("arg4");
                if (string12 == null || string13 == null || string14 == null || string15 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e14 = h0.f1099c;
                    h0.d(msg, l(string12, string13, string14, string15), null);
                }
                break;
            case 17012:
                String string16 = data.getString("arg1");
                String string17 = data.getString("arg2");
                String string18 = data.getString("arg3");
                String string19 = data.getString("arg4");
                if (string16 == null || string17 == null || string18 == null || string19 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    com.oplus.melody.model.repository.zenmode.a aVar2 = new com.oplus.melody.model.repository.zenmode.a(msg);
                    E e15 = h0.f1099c;
                    h0.d(msg, m(string16, string17, string18, string19, aVar2), null);
                }
                break;
            case 17013:
                E e16 = h0.f1099c;
                h0.j(msg, n(), null);
                break;
            case 17014:
                UpgradeStateInfo upgradeStateInfo = (UpgradeStateInfo) C0914u.g(data, "arg1", UpgradeStateInfo.class);
                if (upgradeStateInfo == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    y(upgradeStateInfo);
                    h0.h(msg, null);
                }
                break;
            case 17015:
                UpgradeStateInfo upgradeStateInfo2 = (UpgradeStateInfo) C0914u.g(data, "arg1", UpgradeStateInfo.class);
                if (upgradeStateInfo2 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    x(upgradeStateInfo2);
                    h0.h(msg, null);
                }
                break;
            case 17016:
                UpgradeStateInfo upgradeStateInfo3 = (UpgradeStateInfo) C0914u.g(data, "arg1", UpgradeStateInfo.class);
                if (upgradeStateInfo3 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    w(upgradeStateInfo3);
                    h0.h(msg, null);
                }
                break;
            case 17017:
                a();
                h0.h(msg, null);
                break;
            case 17020:
                String string20 = data.getString("arg1");
                int i14 = data.getInt("arg2");
                boolean z4 = data.getBoolean("arg3");
                if (string20 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e17 = h0.f1099c;
                    h0.d(msg, t(i14, z4, string20), null);
                }
                break;
            case 17021:
                String string21 = data.getString("arg1");
                int i15 = data.getInt("arg2");
                int i16 = data.getInt("arg3");
                boolean z10 = data.getBoolean("arg4");
                if (string21 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e18 = h0.f1099c;
                    h0.d(msg, r(z10, string21, i15, i16), null);
                }
                break;
            case 17022:
                String string22 = data.getString("arg1");
                str = string22 != null ? string22 : "";
                E e19 = h0.f1099c;
                h0.j(msg, d(str), null);
                break;
            case 17023:
                String string23 = data.getString("arg1");
                String string24 = data.getString("arg2");
                if (string23 == null || string24 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e20 = h0.f1099c;
                    CompletableFuture<File> completableFutureC = Z7.a.g().c(String.format(Locale.ENGLISH, "%s_%s", Arrays.copyOf(new Object[]{"theme_share", string24}, 2)), string23, string24, null);
                    h.d(completableFutureC, "downloadZipFile(...)");
                    h0.d(msg, completableFutureC, null);
                }
                break;
            case 17024:
                String string25 = data.getString("arg1");
                if (string25 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    v(string25);
                    h0.h(msg, null);
                }
                break;
            case 17025:
                String string26 = data.getString("arg1");
                int i17 = data.getInt("arg2");
                if (string26 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    E e21 = h0.f1099c;
                    h0.j(msg, i(i17, string26), null);
                }
                break;
            case 17026:
                String string27 = data.getString("arg1");
                int i18 = data.getInt("arg2");
                boolean z11 = data.getBoolean("arg3");
                if (string27 == null) {
                    h0.e(msg, "400: Bad Request", 400);
                } else {
                    q(i18, z11, string27);
                    h0.h(msg, null);
                }
                break;
            case 17027:
                String string28 = data.getString("arg1");
                if (string28 == null) {
                    string28 = "";
                }
                String string29 = data.getString("arg2");
                str = string29 != null ? string29 : "";
                E e22 = h0.f1099c;
                h0.j(msg, f(string28, str), null);
                break;
            case 17028:
                String string30 = data.getString("arg1");
                if (string30 == null) {
                    string30 = "";
                }
                String string31 = data.getString("arg2");
                z(string30, string31 != null ? string31 : "");
                h0.h(msg, null);
                break;
            case 17029:
                E e23 = h0.f1099c;
                h0.j(msg, g(), null);
                break;
            case 17030:
                p(data.getBoolean("arg1"));
                h0.h(msg, null);
                break;
        }
        return true;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture<Jb.l> j(PersonalDressDTO.PersonalDressData data, String productId, int i10, com.oplus.melody.model.repository.zenmode.c cVar) {
        h.e(data, "data");
        h.e(productId, "productId");
        if (TextUtils.isEmpty(data.getAnimUrl()) && TextUtils.isEmpty(data.getDarkAnimUrl())) {
            A.b("PersonalDressRepository", "anim url is empty");
            CompletableFuture<Jb.l> completableFuture = new CompletableFuture<>();
            completableFuture.completeExceptionally(MelodyException.e(400, "anim url is empty"));
            return completableFuture;
        }
        Map mapD0 = kotlin.collections.a.d0(new Pair(C1065d.c(data.getAnimUrl(), "_normal"), Long.valueOf(data.getAnimSize())), new Pair(C1065d.c(data.getDarkAnimUrl(), "_night"), Long.valueOf(data.getDarkAnimSize())));
        androidx.collection.a aVar = new androidx.collection.a();
        int darkAnimSize = data.getDarkAnimSize() + data.getAnimSize();
        if (1 >= darkAnimSize) {
            darkAnimSize = 1;
        }
        String themeId = data.getThemeId();
        int animSize = data.getAnimSize();
        int darkAnimSize2 = data.getDarkAnimSize();
        StringBuilder sbG = D0.g(animSize, "start to download personal popup resource, themeId:", themeId, " animSize:", " darkAnimSize:");
        sbG.append(darkAnimSize2);
        A.f("PersonalDressRepository", sbG.toString());
        a aVar2 = new a(cVar, aVar, darkAnimSize, mapD0);
        CompletableFuture<File> completableFutureC = Z7.a.g().c((TextUtils.isEmpty(data.getThemeId()) || TextUtils.equals(data.getThemeId(), BaseHealthModule.TRACK_FATIGUE_REMIND)) ? String.format(Locale.ENGLISH, "%s_%s_%d_%s", Arrays.copyOf(new Object[]{"popup", productId, Integer.valueOf(i10), "normal"}, 4)) : String.format(Locale.ENGLISH, "%s-%s-%d-%s-%s", Arrays.copyOf(new Object[]{"popup", productId, Integer.valueOf(i10), data.getThemeId(), "normal"}, 5)), data.getAnimUrl(), data.getAnimSHA256(), new d(aVar2));
        h.d(completableFutureC, "downloadZipFile(...)");
        CompletableFuture<Void> completableFutureThenAccept = completableFutureC.thenAccept((Consumer<? super File>) new H(new C1017a(this, 3), 28));
        String str = (TextUtils.isEmpty(data.getThemeId()) || TextUtils.equals(data.getThemeId(), BaseHealthModule.TRACK_FATIGUE_REMIND)) ? String.format(Locale.ENGLISH, "%s_%s_%d_%s", Arrays.copyOf(new Object[]{"popup", productId, Integer.valueOf(i10), "night"}, 4)) : String.format(Locale.ENGLISH, "%s-%s-%d-%s-%s", Arrays.copyOf(new Object[]{"popup", productId, Integer.valueOf(i10), data.getThemeId(), "night"}, 5));
        String darkAnimUrl = data.getDarkAnimUrl();
        String darkAnimSHA256 = data.getDarkAnimSHA256();
        if (TextUtils.isEmpty(darkAnimUrl)) {
            darkAnimUrl = data.getAnimUrl();
            darkAnimSHA256 = data.getAnimSHA256();
        }
        CompletableFuture<File> completableFutureC2 = Z7.a.g().c(str, darkAnimUrl, darkAnimSHA256, new c(aVar2));
        h.d(completableFutureC2, "downloadZipFile(...)");
        CompletableFuture<Jb.l> completableFutureWhenComplete = CompletableFuture.allOf(completableFutureThenAccept, completableFutureC2.thenAccept((Consumer<? super File>) new C0368b(new C1020d(this, 3), 24))).thenApply((Function<? super Void, ? extends U>) new com.oplus.melody.model.repository.zenmode.e(new n(15), 12)).whenComplete((BiConsumer<? super U, ? super Throwable>) new A9.q(new Nb.a(5, cVar, aVar2), 20));
        h.d(completableFutureWhenComplete, "whenComplete(...)");
        return completableFutureWhenComplete;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture k(String productId, String str, int i10, int i11, String str2, String str3) {
        h.e(productId, "productId");
        Locale locale = Locale.ENGLISH;
        CompletableFuture<File> completableFutureB = Z7.a.g().b(String.format(locale, "%s_%s", Arrays.copyOf(new Object[]{"popup_preview", productId}, 2)), str, str2, ".mp4", String.format(locale, "%d_%d_%s", Arrays.copyOf(new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), str3}, 3)), null);
        h.d(completableFutureB, "downloadDressResourceFile(...)");
        return completableFutureB;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture<File> l(String productId, String str, String str2, String str3) {
        h.e(productId, "productId");
        Locale locale = Locale.ENGLISH;
        CompletableFuture<File> completableFutureB = Z7.a.g().b(String.format(locale, "%s_%s", Arrays.copyOf(new Object[]{"tone_preview", productId}, 2)), str, str2, ".mp3", String.format(locale, "%s", Arrays.copyOf(new Object[]{str3}, 1)), null);
        h.d(completableFutureB, "downloadDressResourceFile(...)");
        return completableFutureB;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture<File> m(String productId, String str, String str2, String str3, com.oplus.melody.model.repository.zenmode.c cVar) {
        h.e(productId, "productId");
        Locale locale = Locale.ENGLISH;
        CompletableFuture<File> completableFutureB = Z7.a.g().b(String.format(locale, "%s_%s", Arrays.copyOf(new Object[]{"tone", productId}, 2)), str, str2, ".bin", String.format(locale, "%s", Arrays.copyOf(new Object[]{str3}, 1)), cVar);
        h.d(completableFutureB, "downloadDressResourceFile(...)");
        return completableFutureB;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final s<ToneStateInfoDTO> n() {
        return C0379m.g(this.f20071q, new g0.e(16));
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final boolean o(String address, final String themeId, final boolean z2, final boolean z4) {
        h.e(address, "address");
        h.e(themeId, "themeId");
        A.c("PersonalDressRepository", new Supplier() { // from class: m8.b
            @Override // java.util.function.Supplier
            public final Object get() {
                return "setCurrentPopTheme topic:" + themeId + " popup:" + z2 + " custom:" + z4;
            }
        });
        return O(address, themeId, z4);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void p(boolean z2) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        C0908n.e(heyMelodyApplication, "key_custom_feature_mark", Boolean.valueOf(z2));
        g().m(Boolean.valueOf(z2));
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void q(final int i10, final boolean z2, final String productId) {
        h.e(productId, "productId");
        A.c("PersonalDressRepository", new Supplier() { // from class: m8.a
            @Override // java.util.function.Supplier
            public final Object get() {
                this.f26335a.getClass();
                StringBuilder sbI = D0.i("setNewDressMark key:", com.oplus.melody.model.repository.personaldress.e.N(i10, productId), " mark:");
                sbI.append(z2);
                return sbI.toString();
            }
        });
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        C0908n.e(heyMelodyApplication, N(i10, productId), Boolean.valueOf(z2));
        i(i10, productId).m(Boolean.valueOf(z2));
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture r(boolean z2, String productId, int i10, int i11) {
        final String str;
        final int i12;
        final int i13;
        h.e(productId, "productId");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String string = heyMelodyApplication.getString(R.string.melody_common_language_tag);
        h.d(string, "getLocaleLanguage(...)");
        StringBuilder sb2 = new StringBuilder("requestDressBySeriesInfo(");
        sb2.append(productId);
        sb2.append(", ");
        sb2.append(string);
        sb2.append(", ");
        sb2.append(i10);
        sb2.append(", ");
        String strB = g0.e.b(sb2, i11, ")");
        CompletableFuture<?> completableFutureB = C.b(this.f20068C, strB);
        if (completableFutureB == null || z2) {
            A.c("PersonalDressRepository", new D(strB, 8));
            com.oplus.melody.model.net.n nVarB = com.oplus.melody.model.net.n.b();
            str = productId;
            i12 = i10;
            i13 = i11;
            completableFutureB = nVarB.g(productId, string, i10, i11).thenApply((Function<? super String, ? extends U>) new i(nVarB, 29)).thenApplyAsync((Function<? super U, ? extends U>) new com.oplus.melody.model.repository.zenmode.e(new com.oplus.melody.model.repository.earphone.u(str, this, i12, strB, i13, string), 13));
            C c6 = this.f20068C;
            h.b(completableFutureB);
            c6.c(strB, completableFutureB);
        } else {
            A.c("PersonalDressRepository", new D6.c(strB, 20));
            str = productId;
            i12 = i10;
            i13 = i11;
        }
        CompletableFuture<T> completableFutureExceptionally = new q0(completableFutureB, 5L, TimeUnit.SECONDS).exceptionally(new Function() { // from class: m8.h
            /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
            @Override // java.util.function.Function
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object apply(java.lang.Object r14) {
                /*
                    r13 = this;
                    java.lang.Throwable r14 = (java.lang.Throwable) r14
                    com.oplus.melody.model.repository.personaldress.e r14 = r13.f26360a
                    int r0 = r2
                    java.lang.String r1 = r3
                    com.oplus.melody.model.repository.personaldress.DressSeriesDTO r2 = r14.F(r0, r1)
                    int r3 = r4
                    r4 = 0
                    if (r2 == 0) goto L39
                    java.util.List r2 = r2.getSeriesList()
                    if (r2 == 0) goto L39
                    java.util.Iterator r2 = r2.iterator()
                L1b:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L2f
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    com.oplus.melody.model.repository.personaldress.DressSeriesDTO$SeriesData r6 = (com.oplus.melody.model.repository.personaldress.DressSeriesDTO.SeriesData) r6
                    int r6 = r6.getId()
                    if (r6 != r3) goto L1b
                    goto L30
                L2f:
                    r5 = r4
                L30:
                    com.oplus.melody.model.repository.personaldress.DressSeriesDTO$SeriesData r5 = (com.oplus.melody.model.repository.personaldress.DressSeriesDTO.SeriesData) r5
                    if (r5 == 0) goto L39
                    java.util.List r2 = r5.getThemeIdList()
                    goto L3a
                L39:
                    r2 = r4
                L3a:
                    if (r2 == 0) goto L94
                    boolean r5 = r2.isEmpty()
                    if (r5 != 0) goto L94
                    com.oplus.melody.model.repository.personaldress.PersonalDressDTO r14 = r14.E(r0, r1)
                    if (r14 == 0) goto L72
                    java.util.List r14 = r14.getPersonalDressData()
                    if (r14 == 0) goto L72
                    java.util.ArrayList r5 = new java.util.ArrayList
                    r5.<init>()
                    java.util.Iterator r14 = r14.iterator()
                L57:
                    boolean r6 = r14.hasNext()
                    if (r6 == 0) goto L73
                    java.lang.Object r6 = r14.next()
                    r7 = r6
                    com.oplus.melody.model.repository.personaldress.PersonalDressDTO$PersonalDressData r7 = (com.oplus.melody.model.repository.personaldress.PersonalDressDTO.PersonalDressData) r7
                    java.lang.String r7 = r7.getThemeId()
                    boolean r7 = Kb.q.o(r2, r7)
                    if (r7 == 0) goto L57
                    r5.add(r6)
                    goto L57
                L72:
                    r5 = r4
                L73:
                    if (r5 == 0) goto L94
                    boolean r14 = r5.isEmpty()
                    if (r14 != 0) goto L94
                    com.oplus.melody.model.repository.personaldress.DressBySeriesDTO r6 = new com.oplus.melody.model.repository.personaldress.DressBySeriesDTO
                    r9 = 0
                    r10 = 0
                    r7 = 0
                    r8 = 0
                    r11 = 15
                    r12 = 0
                    r6.<init>(r7, r8, r9, r10, r11, r12)
                    r6.setProductId(r1)
                    r6.setColor(r0)
                    r6.setSeriesId(r3)
                    r6.setPersonalDressData(r5)
                    return r6
                L94:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: m8.h.apply(java.lang.Object):java.lang.Object");
            }
        });
        h.d(completableFutureExceptionally, "exceptionally(...)");
        return completableFutureExceptionally;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture s(String address, int i10, String productId, boolean z2) {
        int i11;
        String str;
        h.e(address, "address");
        h.e(productId, "productId");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String string = heyMelodyApplication.getString(R.string.melody_common_language_tag);
        h.d(string, "getLocaleLanguage(...)");
        String str2 = "requestPersonalDressInfo(" + productId + ", " + string + ", " + i10 + ")";
        CompletableFuture<?> completableFutureB = C.b(this.f20068C, str2);
        if (completableFutureB == null || z2) {
            A.c("PersonalDressRepository", new Ca.s(20, str2, this));
            com.oplus.melody.model.net.n nVarB = com.oplus.melody.model.net.n.b();
            i11 = i10;
            str = productId;
            completableFutureB = nVarB.h(i10, productId, string).thenApply((Function) new C0928l(nVarB, 3)).thenApplyAsync((Function) new Aa.c(new m8.d(str, this, i11, address, string, str2), 23));
            C c6 = this.f20068C;
            h.b(completableFutureB);
            c6.c(str2, completableFutureB);
        } else {
            A.c("PersonalDressRepository", new Ca.b(str2, 22));
            i11 = i10;
            str = productId;
        }
        CompletableFuture<T> completableFutureExceptionally = new q0(completableFutureB, 5L, TimeUnit.SECONDS).exceptionally((Function) new R9.b(this, i11, str));
        h.d(completableFutureExceptionally, "exceptionally(...)");
        return completableFutureExceptionally;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final CompletableFuture t(int i10, boolean z2, String productId) {
        int i11;
        String str;
        h.e(productId, "productId");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String string = heyMelodyApplication.getString(R.string.melody_common_language_tag);
        h.d(string, "getLocaleLanguage(...)");
        String str2 = "requestPersonalDressSeriesInfo(" + productId + ", " + string + ", " + i10 + ")";
        CompletableFuture<?> completableFutureB = C.b(this.f20068C, str2);
        if (completableFutureB == null || z2) {
            A.c("PersonalDressRepository", new Ca.b(str2, 23));
            com.oplus.melody.model.net.n nVarB = com.oplus.melody.model.net.n.b();
            CompletableFuture completableFutureThenApply = nVarB.i(i10, productId, string).thenApply((Function) new A6.c(nVarB, 29));
            CompletableFuture<Jb.l> completableFuture = this.f20073s;
            new E8.d(9);
            i11 = i10;
            str = productId;
            completableFutureB = completableFutureThenApply.thenCombine((CompletionStage) completableFuture, (BiFunction) new m8.e()).thenApplyAsync((Function) new p(new m8.f(this, i11, str, string, str2), 26));
            C c6 = this.f20068C;
            h.b(completableFutureB);
            c6.c(str2, completableFutureB);
        } else {
            A.c("PersonalDressRepository", new D6.f(str2, 21));
            i11 = i10;
            str = productId;
        }
        CompletableFuture<T> completableFutureExceptionally = new q0(completableFutureB, 5L, TimeUnit.SECONDS).exceptionally((Function) new C0873o0(this, i11, str));
        h.d(completableFutureExceptionally, "exceptionally(...)");
        return completableFutureExceptionally;
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    @SuppressLint({"WrongConstant"})
    public final void u(String str, String address) {
        h.e(address, "address");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            com.google.android.play.core.appupdate.c.V(heyMelodyApplication, 0, 4, address, str);
        } else {
            h.i("context");
            throw null;
        }
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void v(String address) {
        h.e(address, "address");
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            A6.g.i(heyMelodyApplication, DataTypeConstants.DEBUG_TYPE, "param_address", address, heyMelodyApplication);
        } else {
            h.i("context");
            throw null;
        }
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void w(UpgradeStateInfo transferInfo) {
        h.e(transferInfo, "transferInfo");
        C0379m.k(this.f20071q, transferInfo);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void x(UpgradeStateInfo transferInfo) {
        h.e(transferInfo, "transferInfo");
        C0379m.k(this.f20071q, transferInfo);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void y(UpgradeStateInfo transferInfo) {
        h.e(transferInfo, "transferInfo");
        C0379m.k(this.f20071q, transferInfo);
    }

    @Override // com.oplus.melody.model.repository.personaldress.a
    public final void z(String productId, String colorId) {
        h.e(productId, "productId");
        h.e(colorId, "colorId");
        A.c("PersonalDressRepository", new com.oplus.melody.model.db.C(productId, colorId, 2));
        f(productId, colorId).m(L(productId, colorId));
    }
}
