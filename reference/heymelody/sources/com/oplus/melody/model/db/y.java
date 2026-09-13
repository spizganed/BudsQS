package com.oplus.melody.model.db;

import android.content.Intent;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.ObservedTableStates;
import androidx.room.o;
import androidx.room.util.f;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.builders.ListBuilder;
import o5.C1371d;
import q1.InterfaceC1431a;

/* JADX INFO: compiled from: MelodyDatabase_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends androidx.room.o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MelodyDatabase_Impl f19791d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(MelodyDatabase_Impl melodyDatabase_Impl) {
        super(22, "3d8dad1ec3383061f0a3f3f63c499577", "18d1d2031ea0f3fb9de323e33c59ef66");
        this.f19791d = melodyDatabase_Impl;
    }

    @Override // androidx.room.o
    public final void a(InterfaceC1431a interfaceC1431a) {
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `melody_equipment` (`macAddress` TEXT NOT NULL, `productId` TEXT, `colorId` INTEGER NOT NULL, `name` TEXT, `autoOTASwitch` INTEGER NOT NULL DEFAULT -1, `channelSwitch` INTEGER NOT NULL DEFAULT -1, `popTheme` TEXT, `multiConversationSwitch` INTEGER NOT NULL DEFAULT -1, `reconnectPopupSwitch` INTEGER NOT NULL DEFAULT -1, PRIMARY KEY(`macAddress`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `hearing_enhancement` (`u_id` TEXT NOT NULL, `name` TEXT, `address` TEXT, `data` TEXT, `create_time` INTEGER NOT NULL, `local_index` TEXT, PRIMARY KEY(`u_id`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `zenmode_resource_info` (`resid` TEXT NOT NULL, `randomid` TEXT, `name_cn` TEXT, `name_en` TEXT, `imgurl` TEXT, `audiourl` TEXT, `audiobinurl` TEXT, `audiobinmd5` TEXT, `createtime` TEXT, `updatetime` TEXT, `audioexist` INTEGER NOT NULL, `productId` TEXT, `color` TEXT, PRIMARY KEY(`resid`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `connected_device` (`product_id` TEXT, `product_name` TEXT, `product_brand` TEXT, `product_type` TEXT, `cover_image` TEXT, `mac_address` TEXT NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`mac_address`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `persnoal_dress` (`id` TEXT NOT NULL, `productId` TEXT NOT NULL, `colorId` INTEGER NOT NULL, `animSHA256` TEXT, `materialType` INTEGER NOT NULL, `animSize` INTEGER NOT NULL, `animUploadTime` TEXT, `animUrl` TEXT, `darkAnimSHA256` TEXT, `darkAnimSize` INTEGER NOT NULL, `darkAnimUploadTime` TEXT, `darkAnimUrl` TEXT, `darkPreviewAnim` TEXT, `darkPreviewAnimSHA256` TEXT, `darkPreviewAnimSize` INTEGER NOT NULL, `isStatic` INTEGER NOT NULL, `previewAnim` TEXT, `previewAnimSHA256` TEXT, `previewAnimSize` INTEGER NOT NULL, `previewDetailImgUrl` TEXT, `previewListImgUrl` TEXT, `summary` TEXT, `themeId` TEXT, `title` TEXT, `toneSHA256` TEXT, `toneSize` INTEGER NOT NULL, `toneUploadTime` TEXT, `toneUrl` TEXT, `tonePreviewSHA256` TEXT, `tonePreviewSize` INTEGER NOT NULL, `tonePreviewUrl` TEXT, `publishStatus` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `tags` TEXT, `cardZipUrl` TEXT, `cardZipSHA256` TEXT, `downloadCount` INTEGER NOT NULL, `activity` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `persnoal_dress_series` (`primaryId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` INTEGER NOT NULL, `productId` TEXT NOT NULL, `colorId` INTEGER NOT NULL, `identifyId` TEXT, `seriesName` TEXT, `summary` TEXT, `priority` INTEGER NOT NULL, `themeCount` INTEGER NOT NULL, `bannerImgUrl` TEXT, `createTime` TEXT, `updateTime` TEXT, `bottomColor` TEXT, `themeIdList` TEXT)");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `spine_history_data` (`utc_time` INTEGER NOT NULL, `product_name` TEXT, `product_id` TEXT, `product_mac` TEXT, `normal_times` INTEGER NOT NULL, `mild_times` INTEGER NOT NULL, `bad_times` INTEGER NOT NULL, `unknown_times` INTEGER NOT NULL, PRIMARY KEY(`utc_time`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `data_collect` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `dataType` INTEGER NOT NULL, `time` INTEGER NOT NULL, `dataContentType` INTEGER NOT NULL, `dataContent` TEXT)");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `provisional_whitelist` (`pid` TEXT NOT NULL, `name` TEXT, `brand` TEXT, `type` TEXT, `uuid` TEXT, `fastDiscovery` INTEGER NOT NULL, PRIMARY KEY(`pid`))");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS `carousel_dress` (`carouselId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `productId` TEXT NOT NULL, `colorId` INTEGER NOT NULL, `name` TEXT NOT NULL, `carouselType` INTEGER NOT NULL, `themeIdList` TEXT NOT NULL)");
        C1371d.g(interfaceC1431a, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        C1371d.g(interfaceC1431a, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3d8dad1ec3383061f0a3f3f63c499577')");
    }

    @Override // androidx.room.o
    public final void b(InterfaceC1431a interfaceC1431a) {
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `melody_equipment`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `hearing_enhancement`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `zenmode_resource_info`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `connected_device`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `persnoal_dress`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `persnoal_dress_series`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `spine_history_data`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `data_collect`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `provisional_whitelist`");
        C1371d.g(interfaceC1431a, "DROP TABLE IF EXISTS `carousel_dress`");
    }

    @Override // androidx.room.o
    public final void d(InterfaceC1431a connection) {
        MelodyDatabase_Impl melodyDatabase_Impl = this.f19791d;
        melodyDatabase_Impl.getClass();
        kotlin.jvm.internal.h.e(connection, "connection");
        InvalidationTracker invalidationTrackerD = melodyDatabase_Impl.d();
        androidx.room.w wVar = invalidationTrackerD.f12268c;
        wVar.getClass();
        q1.c cVarV0 = connection.v0("PRAGMA query_only");
        try {
            cVarV0.l0();
            boolean Z10 = cVarV0.Z();
            com.google.android.play.core.appupdate.c.k(cVarV0, null);
            if (!Z10) {
                C1371d.g(connection, "PRAGMA temp_store = MEMORY");
                C1371d.g(connection, "PRAGMA recursive_triggers = 1");
                C1371d.g(connection, "DROP TABLE IF EXISTS room_table_modification_log");
                if (wVar.f12481d) {
                    C1371d.g(connection, "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                } else {
                    C1371d.g(connection, ec.l.F("CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)", "TEMP", ""));
                }
                ObservedTableStates observedTableStates = wVar.h;
                ReentrantLock reentrantLock = observedTableStates.f12296a;
                reentrantLock.lock();
                try {
                    observedTableStates.f12299d = true;
                    Jb.l lVar = Jb.l.f2618a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            synchronized (invalidationTrackerD.f12275k) {
                try {
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient = invalidationTrackerD.f12274j;
                    if (multiInstanceInvalidationClient != null) {
                        Intent intent = invalidationTrackerD.f12273i;
                        if (intent == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        if (multiInstanceInvalidationClient.f12281e.compareAndSet(true, false)) {
                            multiInstanceInvalidationClient.f12279c.bindService(intent, multiInstanceInvalidationClient.f12286k, 1);
                            InvalidationTracker invalidationTracker = multiInstanceInvalidationClient.f12278b;
                            MultiInstanceInvalidationClient.a observer = multiInstanceInvalidationClient.f12284i;
                            kotlin.jvm.internal.h.e(observer, "observer");
                            invalidationTracker.a(observer);
                        }
                        Jb.l lVar2 = Jb.l.f2618a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
        }
    }

    @Override // androidx.room.o
    public final void f(InterfaceC1431a connection) {
        kotlin.jvm.internal.h.e(connection, "connection");
        ListBuilder listBuilderA = Kb.k.a();
        q1.c cVarV0 = connection.v0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cVarV0.l0()) {
            try {
                listBuilderA.add(cVarV0.o(0));
            } finally {
            }
        }
        Jb.l lVar = Jb.l.f2618a;
        com.google.android.play.core.appupdate.c.k(cVarV0, null);
        ListIterator listIterator = listBuilderA.t().listIterator(0);
        while (true) {
            ListBuilder.a aVar = (ListBuilder.a) listIterator;
            if (!aVar.hasNext()) {
                return;
            }
            String str = (String) aVar.next();
            if (ec.l.H(str, "room_fts_content_sync_", false)) {
                C1371d.g(connection, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    @Override // androidx.room.o
    public final o.a g(InterfaceC1431a interfaceC1431a) {
        HashMap map = new HashMap(9);
        map.put("macAddress", new f.a("macAddress", "TEXT", null, 1, 1, true));
        map.put("productId", new f.a("productId", "TEXT", null, 0, 1, false));
        map.put("colorId", new f.a("colorId", "INTEGER", null, 0, 1, true));
        map.put("name", new f.a("name", "TEXT", null, 0, 1, false));
        map.put("autoOTASwitch", new f.a("autoOTASwitch", "INTEGER", VersionInfo.VENDOR_CODE_ERROR_VERSION, 0, 1, true));
        map.put("channelSwitch", new f.a("channelSwitch", "INTEGER", VersionInfo.VENDOR_CODE_ERROR_VERSION, 0, 1, true));
        map.put("popTheme", new f.a("popTheme", "TEXT", null, 0, 1, false));
        map.put("multiConversationSwitch", new f.a("multiConversationSwitch", "INTEGER", VersionInfo.VENDOR_CODE_ERROR_VERSION, 0, 1, true));
        map.put("reconnectPopupSwitch", new f.a("reconnectPopupSwitch", "INTEGER", VersionInfo.VENDOR_CODE_ERROR_VERSION, 0, 1, true));
        androidx.room.util.f fVar = new androidx.room.util.f("melody_equipment", map, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA = androidx.room.util.f.a(interfaceC1431a, "melody_equipment");
        if (!fVar.equals(fVarA)) {
            return new o.a("melody_equipment(com.oplus.melody.model.db.MelodyEquipmentEntity).\n Expected:\n" + fVar + "\n Found:\n" + fVarA, false);
        }
        HashMap map2 = new HashMap(6);
        map2.put("u_id", new f.a("u_id", "TEXT", null, 1, 1, true));
        map2.put("name", new f.a("name", "TEXT", null, 0, 1, false));
        map2.put("address", new f.a("address", "TEXT", null, 0, 1, false));
        map2.put(ClientDataEntity.COL_DATA, new f.a(ClientDataEntity.COL_DATA, "TEXT", null, 0, 1, false));
        map2.put(ClientDataEntity.COL_CREATE_TIME, new f.a(ClientDataEntity.COL_CREATE_TIME, "INTEGER", null, 0, 1, true));
        map2.put("local_index", new f.a("local_index", "TEXT", null, 0, 1, false));
        androidx.room.util.f fVar2 = new androidx.room.util.f("hearing_enhancement", map2, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA2 = androidx.room.util.f.a(interfaceC1431a, "hearing_enhancement");
        if (!fVar2.equals(fVarA2)) {
            return new o.a("hearing_enhancement(com.oplus.melody.model.db.HearingEnhancementEntity).\n Expected:\n" + fVar2 + "\n Found:\n" + fVarA2, false);
        }
        HashMap map3 = new HashMap(13);
        map3.put("resid", new f.a("resid", "TEXT", null, 1, 1, true));
        map3.put("randomid", new f.a("randomid", "TEXT", null, 0, 1, false));
        map3.put("name_cn", new f.a("name_cn", "TEXT", null, 0, 1, false));
        map3.put("name_en", new f.a("name_en", "TEXT", null, 0, 1, false));
        map3.put("imgurl", new f.a("imgurl", "TEXT", null, 0, 1, false));
        map3.put("audiourl", new f.a("audiourl", "TEXT", null, 0, 1, false));
        map3.put("audiobinurl", new f.a("audiobinurl", "TEXT", null, 0, 1, false));
        map3.put("audiobinmd5", new f.a("audiobinmd5", "TEXT", null, 0, 1, false));
        map3.put("createtime", new f.a("createtime", "TEXT", null, 0, 1, false));
        map3.put("updatetime", new f.a("updatetime", "TEXT", null, 0, 1, false));
        map3.put("audioexist", new f.a("audioexist", "INTEGER", null, 0, 1, true));
        map3.put("productId", new f.a("productId", "TEXT", null, 0, 1, false));
        map3.put("color", new f.a("color", "TEXT", null, 0, 1, false));
        androidx.room.util.f fVar3 = new androidx.room.util.f("zenmode_resource_info", map3, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA3 = androidx.room.util.f.a(interfaceC1431a, "zenmode_resource_info");
        if (!fVar3.equals(fVarA3)) {
            return new o.a("zenmode_resource_info(com.oplus.melody.model.db.ZenModeInformationEntity).\n Expected:\n" + fVar3 + "\n Found:\n" + fVarA3, false);
        }
        HashMap map4 = new HashMap(7);
        map4.put("product_id", new f.a("product_id", "TEXT", null, 0, 1, false));
        map4.put("product_name", new f.a("product_name", "TEXT", null, 0, 1, false));
        map4.put("product_brand", new f.a("product_brand", "TEXT", null, 0, 1, false));
        map4.put("product_type", new f.a("product_type", "TEXT", null, 0, 1, false));
        map4.put("cover_image", new f.a("cover_image", "TEXT", null, 0, 1, false));
        map4.put("mac_address", new f.a("mac_address", "TEXT", null, 1, 1, true));
        map4.put("time", new f.a("time", "INTEGER", null, 0, 1, true));
        androidx.room.util.f fVar4 = new androidx.room.util.f("connected_device", map4, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA4 = androidx.room.util.f.a(interfaceC1431a, "connected_device");
        if (!fVar4.equals(fVarA4)) {
            return new o.a("connected_device(com.oplus.melody.model.db.ConnectedDeviceEntity).\n Expected:\n" + fVar4 + "\n Found:\n" + fVarA4, false);
        }
        HashMap map5 = new HashMap(38);
        map5.put("id", new f.a("id", "TEXT", null, 1, 1, true));
        map5.put("productId", new f.a("productId", "TEXT", null, 0, 1, true));
        map5.put("colorId", new f.a("colorId", "INTEGER", null, 0, 1, true));
        map5.put("animSHA256", new f.a("animSHA256", "TEXT", null, 0, 1, false));
        map5.put("materialType", new f.a("materialType", "INTEGER", null, 0, 1, true));
        map5.put("animSize", new f.a("animSize", "INTEGER", null, 0, 1, true));
        map5.put("animUploadTime", new f.a("animUploadTime", "TEXT", null, 0, 1, false));
        map5.put("animUrl", new f.a("animUrl", "TEXT", null, 0, 1, false));
        map5.put("darkAnimSHA256", new f.a("darkAnimSHA256", "TEXT", null, 0, 1, false));
        map5.put("darkAnimSize", new f.a("darkAnimSize", "INTEGER", null, 0, 1, true));
        map5.put("darkAnimUploadTime", new f.a("darkAnimUploadTime", "TEXT", null, 0, 1, false));
        map5.put("darkAnimUrl", new f.a("darkAnimUrl", "TEXT", null, 0, 1, false));
        map5.put("darkPreviewAnim", new f.a("darkPreviewAnim", "TEXT", null, 0, 1, false));
        map5.put("darkPreviewAnimSHA256", new f.a("darkPreviewAnimSHA256", "TEXT", null, 0, 1, false));
        map5.put("darkPreviewAnimSize", new f.a("darkPreviewAnimSize", "INTEGER", null, 0, 1, true));
        map5.put("isStatic", new f.a("isStatic", "INTEGER", null, 0, 1, true));
        map5.put("previewAnim", new f.a("previewAnim", "TEXT", null, 0, 1, false));
        map5.put("previewAnimSHA256", new f.a("previewAnimSHA256", "TEXT", null, 0, 1, false));
        map5.put("previewAnimSize", new f.a("previewAnimSize", "INTEGER", null, 0, 1, true));
        map5.put("previewDetailImgUrl", new f.a("previewDetailImgUrl", "TEXT", null, 0, 1, false));
        map5.put("previewListImgUrl", new f.a("previewListImgUrl", "TEXT", null, 0, 1, false));
        map5.put("summary", new f.a("summary", "TEXT", null, 0, 1, false));
        map5.put("themeId", new f.a("themeId", "TEXT", null, 0, 1, false));
        map5.put("title", new f.a("title", "TEXT", null, 0, 1, false));
        map5.put("toneSHA256", new f.a("toneSHA256", "TEXT", null, 0, 1, false));
        map5.put("toneSize", new f.a("toneSize", "INTEGER", null, 0, 1, true));
        map5.put("toneUploadTime", new f.a("toneUploadTime", "TEXT", null, 0, 1, false));
        map5.put("toneUrl", new f.a("toneUrl", "TEXT", null, 0, 1, false));
        map5.put("tonePreviewSHA256", new f.a("tonePreviewSHA256", "TEXT", null, 0, 1, false));
        map5.put("tonePreviewSize", new f.a("tonePreviewSize", "INTEGER", null, 0, 1, true));
        map5.put("tonePreviewUrl", new f.a("tonePreviewUrl", "TEXT", null, 0, 1, false));
        map5.put("publishStatus", new f.a("publishStatus", "INTEGER", null, 0, 1, true));
        map5.put(ClientDataEntity.COL_PRIORITY, new f.a(ClientDataEntity.COL_PRIORITY, "INTEGER", null, 0, 1, true));
        map5.put("tags", new f.a("tags", "TEXT", null, 0, 1, false));
        map5.put("cardZipUrl", new f.a("cardZipUrl", "TEXT", null, 0, 1, false));
        map5.put("cardZipSHA256", new f.a("cardZipSHA256", "TEXT", null, 0, 1, false));
        map5.put("downloadCount", new f.a("downloadCount", "INTEGER", null, 0, 1, true));
        map5.put("activity", new f.a("activity", "INTEGER", null, 0, 1, true));
        androidx.room.util.f fVar5 = new androidx.room.util.f("persnoal_dress", map5, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA5 = androidx.room.util.f.a(interfaceC1431a, "persnoal_dress");
        if (!fVar5.equals(fVarA5)) {
            return new o.a("persnoal_dress(com.oplus.melody.model.db.PersonalDressEntity).\n Expected:\n" + fVar5 + "\n Found:\n" + fVarA5, false);
        }
        HashMap map6 = new HashMap(14);
        map6.put("primaryId", new f.a("primaryId", "INTEGER", null, 1, 1, true));
        map6.put("id", new f.a("id", "INTEGER", null, 0, 1, true));
        map6.put("productId", new f.a("productId", "TEXT", null, 0, 1, true));
        map6.put("colorId", new f.a("colorId", "INTEGER", null, 0, 1, true));
        map6.put("identifyId", new f.a("identifyId", "TEXT", null, 0, 1, false));
        map6.put("seriesName", new f.a("seriesName", "TEXT", null, 0, 1, false));
        map6.put("summary", new f.a("summary", "TEXT", null, 0, 1, false));
        map6.put(ClientDataEntity.COL_PRIORITY, new f.a(ClientDataEntity.COL_PRIORITY, "INTEGER", null, 0, 1, true));
        map6.put("themeCount", new f.a("themeCount", "INTEGER", null, 0, 1, true));
        map6.put("bannerImgUrl", new f.a("bannerImgUrl", "TEXT", null, 0, 1, false));
        map6.put("createTime", new f.a("createTime", "TEXT", null, 0, 1, false));
        map6.put("updateTime", new f.a("updateTime", "TEXT", null, 0, 1, false));
        map6.put("bottomColor", new f.a("bottomColor", "TEXT", null, 0, 1, false));
        map6.put("themeIdList", new f.a("themeIdList", "TEXT", null, 0, 1, false));
        androidx.room.util.f fVar6 = new androidx.room.util.f("persnoal_dress_series", map6, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA6 = androidx.room.util.f.a(interfaceC1431a, "persnoal_dress_series");
        if (!fVar6.equals(fVarA6)) {
            return new o.a("persnoal_dress_series(com.oplus.melody.model.db.PersonalDressSeriesEntity).\n Expected:\n" + fVar6 + "\n Found:\n" + fVarA6, false);
        }
        HashMap map7 = new HashMap(8);
        map7.put("utc_time", new f.a("utc_time", "INTEGER", null, 1, 1, true));
        map7.put("product_name", new f.a("product_name", "TEXT", null, 0, 1, false));
        map7.put("product_id", new f.a("product_id", "TEXT", null, 0, 1, false));
        map7.put("product_mac", new f.a("product_mac", "TEXT", null, 0, 1, false));
        map7.put("normal_times", new f.a("normal_times", "INTEGER", null, 0, 1, true));
        map7.put("mild_times", new f.a("mild_times", "INTEGER", null, 0, 1, true));
        map7.put("bad_times", new f.a("bad_times", "INTEGER", null, 0, 1, true));
        map7.put("unknown_times", new f.a("unknown_times", "INTEGER", null, 0, 1, true));
        androidx.room.util.f fVar7 = new androidx.room.util.f("spine_history_data", map7, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA7 = androidx.room.util.f.a(interfaceC1431a, "spine_history_data");
        if (!fVar7.equals(fVarA7)) {
            return new o.a("spine_history_data(com.oplus.melody.model.db.SpineHistoryDataEntity).\n Expected:\n" + fVar7 + "\n Found:\n" + fVarA7, false);
        }
        HashMap map8 = new HashMap(5);
        map8.put("id", new f.a("id", "INTEGER", null, 1, 1, true));
        map8.put(DcsCompatEventConverter.KEY_DATA_TYPE, new f.a(DcsCompatEventConverter.KEY_DATA_TYPE, "INTEGER", null, 0, 1, true));
        map8.put("time", new f.a("time", "INTEGER", null, 0, 1, true));
        map8.put("dataContentType", new f.a("dataContentType", "INTEGER", null, 0, 1, true));
        map8.put("dataContent", new f.a("dataContent", "TEXT", null, 0, 1, false));
        androidx.room.util.f fVar8 = new androidx.room.util.f("data_collect", map8, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA8 = androidx.room.util.f.a(interfaceC1431a, "data_collect");
        if (!fVar8.equals(fVarA8)) {
            return new o.a("data_collect(com.oplus.melody.model.db.DataCollectEntity).\n Expected:\n" + fVar8 + "\n Found:\n" + fVarA8, false);
        }
        HashMap map9 = new HashMap(6);
        map9.put("pid", new f.a("pid", "TEXT", null, 1, 1, true));
        map9.put("name", new f.a("name", "TEXT", null, 0, 1, false));
        map9.put("brand", new f.a("brand", "TEXT", null, 0, 1, false));
        map9.put(SpeechFindManager.TYPE, new f.a(SpeechFindManager.TYPE, "TEXT", null, 0, 1, false));
        map9.put("uuid", new f.a("uuid", "TEXT", null, 0, 1, false));
        map9.put("fastDiscovery", new f.a("fastDiscovery", "INTEGER", null, 0, 1, true));
        androidx.room.util.f fVar9 = new androidx.room.util.f("provisional_whitelist", map9, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA9 = androidx.room.util.f.a(interfaceC1431a, "provisional_whitelist");
        if (!fVar9.equals(fVarA9)) {
            return new o.a("provisional_whitelist(com.oplus.melody.model.db.ProvisionalWhitelistEntity).\n Expected:\n" + fVar9 + "\n Found:\n" + fVarA9, false);
        }
        HashMap map10 = new HashMap(6);
        map10.put("carouselId", new f.a("carouselId", "INTEGER", null, 1, 1, true));
        map10.put("productId", new f.a("productId", "TEXT", null, 0, 1, true));
        map10.put("colorId", new f.a("colorId", "INTEGER", null, 0, 1, true));
        map10.put("name", new f.a("name", "TEXT", null, 0, 1, true));
        map10.put("carouselType", new f.a("carouselType", "INTEGER", null, 0, 1, true));
        map10.put("themeIdList", new f.a("themeIdList", "TEXT", null, 0, 1, true));
        androidx.room.util.f fVar10 = new androidx.room.util.f("carousel_dress", map10, new HashSet(0), new HashSet(0));
        androidx.room.util.f fVarA10 = androidx.room.util.f.a(interfaceC1431a, "carousel_dress");
        if (fVar10.equals(fVarA10)) {
            return new o.a(null, true);
        }
        return new o.a("carousel_dress(com.oplus.melody.model.db.CarouselDressEntity).\n Expected:\n" + fVar10 + "\n Found:\n" + fVarA10, false);
    }

    @Override // androidx.room.o
    public final void c(InterfaceC1431a interfaceC1431a) {
    }

    @Override // androidx.room.o
    public final void e(InterfaceC1431a interfaceC1431a) {
    }
}
