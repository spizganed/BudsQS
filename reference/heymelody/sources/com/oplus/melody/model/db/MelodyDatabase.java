package com.oplus.melody.model.db;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.os.UserManager;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0908n;
import com.oplus.melody.common.util.C0917x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import r1.InterfaceC1460b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MelodyDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile MelodyDatabase f19707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f19708m = new j(6, 7);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final k f19709n = new k(7, 8);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final l f19710o = new l(8, 9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m f19711p = new m(9, 10);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final n f19712q = new n(10, 11);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final o f19713r = new o(11, 12);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final p f19714s = new p(12, 13);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final q f19715t = new q(13, 14);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f19716u = new a(14, 15);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final b f19717v = new b(13, 15);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final c f19718w = new c(15, 16);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final d f19719x = new d(16, 17);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e f19720y = new e(17, 18);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final f f19721z = new f(18, 19);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final g f19704A = new g(19, 20);

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final h f19705B = new h(20, 21);

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final i f19706C = new i(21, 22);

    public class a extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "provisional_whitelist", "uuid", "TEXT", null);
        }
    }

    public class b extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "provisional_whitelist", "`pid` TEXT NOT NULL, `name` TEXT, `brand` TEXT, `type` TEXT, `uuid` TEXT, `fastDiscovery` INTEGER NOT NULL, PRIMARY KEY(`pid`)");
        }
    }

    public class c extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            interfaceC1460b.s("CREATE TABLE IF NOT EXISTS melody_equipment_tmp (`macAddress` TEXT NOT NULL, `productId` TEXT, `colorId` INTEGER NOT NULL, `name` TEXT, `autoOTASwitch` INTEGER NOT NULL DEFAULT -1, `channelSwitch` INTEGER NOT NULL DEFAULT -1, PRIMARY KEY(`macAddress`))");
            try {
                Cursor cursorS0 = interfaceC1460b.s0("SELECT * FROM melody_equipment");
                try {
                    if (cursorS0.moveToFirst()) {
                        int columnIndex = cursorS0.getColumnIndex("firmwareVersionIgnored");
                        int columnIndex2 = cursorS0.getColumnIndex("locationAddress");
                        int columnIndex3 = cursorS0.getColumnIndex("countryName");
                        int columnIndex4 = cursorS0.getColumnIndex("macAddress");
                        List listAsList = Arrays.asList("macAddress", "productId", "name");
                        List listAsList2 = Arrays.asList("colorId", "autoOTASwitch");
                        int columnCount = cursorS0.getColumnCount();
                        SharedPreferences.Editor editorEdit = MelodyAlivePreferencesHelper.e().edit();
                        do {
                            String strC = r.c(cursorS0.getString(columnIndex4));
                            ContentValues contentValues = new ContentValues();
                            for (int i10 = 0; i10 < columnCount; i10++) {
                                String columnName = cursorS0.getColumnName(i10);
                                if (listAsList.contains(columnName)) {
                                    contentValues.put(columnName, cursorS0.getString(i10));
                                } else if (listAsList2.contains(columnName)) {
                                    contentValues.put(columnName, Integer.valueOf(cursorS0.getInt(i10)));
                                }
                            }
                            contentValues.put("channelSwitch", Integer.valueOf(C0908n.d(strC)));
                            interfaceC1460b.F(contentValues, "melody_equipment_tmp");
                            String string = cursorS0.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                editorEdit.putString(MelodyAlivePreferencesHelper.g(14, strC), string);
                            }
                            editorEdit.putString(MelodyAlivePreferencesHelper.g(13, strC), C0917x.i(new LocationDTO(r.e(r.b(strC.concat("-lat"))), r.e(r.b(strC.concat("-lng"))), r.c(cursorS0.getString(columnIndex2)), r.c(cursorS0.getString(columnIndex3)), null, null, 0L)));
                        } while (cursorS0.moveToNext());
                        editorEdit.apply();
                    }
                    cursorS0.close();
                } finally {
                    interfaceC1460b.s("DROP TABLE melody_equipment");
                    interfaceC1460b.s("ALTER TABLE melody_equipment_tmp RENAME TO melody_equipment");
                }
            } catch (Exception e10) {
                com.oplus.melody.common.util.A.i("MelodyDatabase", "migrate16", e10);
            }
            interfaceC1460b.s("DROP TABLE melody_equipment");
            interfaceC1460b.s("ALTER TABLE melody_equipment_tmp RENAME TO melody_equipment");
        }
    }

    public class d extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "melody_equipment", "popTheme", "TEXT", null);
            interfaceC1460b.m();
            try {
                Cursor cursorS0 = interfaceC1460b.s0("SELECT macAddress FROM melody_equipment");
                try {
                    if (cursorS0.moveToFirst()) {
                        SharedPreferences sharedPreferencesE = MelodyAlivePreferencesHelper.e();
                        SharedPreferences.Editor editorEdit = sharedPreferencesE.edit();
                        do {
                            String string = cursorS0.getString(0);
                            String strC = r.c(string);
                            editorEdit.remove(MelodyAlivePreferencesHelper.g(9, strC));
                            String strG = MelodyAlivePreferencesHelper.g(11, strC);
                            String string2 = sharedPreferencesE.getString(strG, "");
                            if (TextUtils.isEmpty(string2)) {
                                String strG2 = MelodyAlivePreferencesHelper.g(11, string);
                                string2 = sharedPreferencesE.getString(strG2, "");
                                if (TextUtils.isEmpty(string2)) {
                                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                                    String str = "dress_" + com.oplus.melody.common.util.A.r(strC);
                                    string2 = (String) C0908n.c(heyMelodyApplication, str, "");
                                    if (!TextUtils.isEmpty(string2)) {
                                        C0908n.b(heyMelodyApplication).edit().remove(str).apply();
                                    }
                                } else {
                                    editorEdit.remove(strG2);
                                }
                            } else {
                                editorEdit.remove(strG);
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("popTheme", string2);
                            interfaceC1460b.d0("melody_equipment", contentValues, "macAddress = ?", new String[]{string});
                        } while (cursorS0.moveToNext());
                        editorEdit.apply();
                    }
                    interfaceC1460b.a0();
                    cursorS0.close();
                } catch (Throwable th) {
                    if (cursorS0 != null) {
                        try {
                            cursorS0.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e10) {
                com.oplus.melody.common.util.A.i("MelodyDatabase", "migrate17", e10);
            } finally {
                interfaceC1460b.l();
            }
        }
    }

    public class e extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "melody_equipment", "multiConversationSwitch", "INTEGER", -1);
        }
    }

    public class f extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.n(interfaceC1460b, "melody_equipment", "macAddress", new String[]{"macAddress"});
            MelodyDatabase.n(interfaceC1460b, "connected_device", "mac_address", new String[]{"mac_address"});
            MelodyDatabase.n(interfaceC1460b, "hearing_enhancement", "u_id", new String[]{"address"});
        }
    }

    public class g extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "melody_equipment", "reconnectPopupSwitch", "INTEGER", -1);
        }
    }

    public class h extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            Cursor cursorS0;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            interfaceC1460b.m();
            try {
                try {
                    cursorS0 = interfaceC1460b.s0("SELECT * FROM detail_source");
                } catch (Exception e10) {
                    com.oplus.melody.common.util.A.i("MelodyDatabase", "migrate21", e10);
                }
                try {
                    if (cursorS0.moveToFirst()) {
                        do {
                            int columnIndex = cursorS0.getColumnIndex("product_id");
                            int columnIndex2 = cursorS0.getColumnIndex("color_id");
                            int columnIndex3 = cursorS0.getColumnIndex("model_file_path");
                            String string = cursorS0.getString(columnIndex);
                            int i10 = cursorS0.getInt(columnIndex2);
                            String string2 = cursorS0.getString(columnIndex3);
                            if (!TextUtils.isEmpty(string) && i10 > 0 && !TextUtils.isEmpty(string2)) {
                                arrayList.add(string);
                                arrayList2.add(Integer.toString(i10));
                                arrayList3.add(string2);
                            }
                        } while (cursorS0.moveToNext());
                    }
                    interfaceC1460b.a0();
                    cursorS0.close();
                    try {
                        interfaceC1460b.s("DROP TABLE detail_source");
                        com.oplus.melody.common.util.A.h("MelodyDatabase", "migrate21 DROP TABLE ok, tableName: detail_source");
                    } catch (Exception e11) {
                        com.oplus.melody.common.util.A.i("MelodyDatabase", "migrate21, drop table error: ", e11);
                    }
                    if (arrayList3.isEmpty()) {
                        return;
                    }
                    ForkJoinPool.commonPool().execute(new D7.I(arrayList3, arrayList, arrayList2, 11));
                } catch (Throwable th) {
                    if (cursorS0 != null) {
                        try {
                            cursorS0.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } finally {
                interfaceC1460b.l();
            }
        }
    }

    public class i extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "carousel_dress", "`carouselId` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `productId` TEXT NOT NULL, `colorId` INTEGER NOT NULL, `name` TEXT NOT NULL DEFAULT '', `carouselType` INTEGER NOT NULL DEFAULT 0, `themeIdList` TEXT NOT NULL DEFAULT ''");
        }
    }

    public class j extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "connected_device", "`product_id` TEXT, `product_name` TEXT, `product_brand` TEXT, `product_type` TEXT, `cover_image` TEXT, `mac_address` TEXT NOT NULL, `time` INTEGER NOT NULL, PRIMARY KEY(`mac_address`)");
        }
    }

    public class k extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "persnoal_dress", "`id` TEXT NOT NULL, `productId` TEXT NOT NULL, `colorId` INTEGER NOT NULL, `animSHA256` TEXT, `materialType` INTEGER NOT NULL, `animSize` INTEGER NOT NULL, `animUploadTime` TEXT, `animUrl` TEXT, `darkAnimSHA256` TEXT, `darkAnimSize` INTEGER NOT NULL, `darkAnimUploadTime` TEXT, `darkAnimUrl` TEXT, `darkPreviewAnim` TEXT, `darkPreviewAnimSHA256` TEXT, `darkPreviewAnimSize` INTEGER NOT NULL, `isStatic` INTEGER NOT NULL, `previewAnim` TEXT, `previewAnimSHA256` TEXT, `previewAnimSize` INTEGER NOT NULL, `previewDetailImgUrl` TEXT, `previewListImgUrl` TEXT, `summary` TEXT, `themeId` TEXT, `title` TEXT, `toneSHA256` TEXT, `toneSize` INTEGER NOT NULL, `toneUploadTime` TEXT, `toneUrl` TEXT, `tonePreviewSHA256` TEXT, `tonePreviewSize` INTEGER NOT NULL, `tonePreviewUrl` TEXT, `publishStatus` INTEGER NOT NULL, PRIMARY KEY(`id`)");
        }
    }

    public class l extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "persnoal_dress", ClientDataEntity.COL_PRIORITY, "INTEGER", 0);
            MelodyDatabase.l(interfaceC1460b, "persnoal_dress", "tags", "TEXT", null);
            MelodyDatabase.l(interfaceC1460b, "persnoal_dress", "cardZipUrl", "TEXT", null);
            MelodyDatabase.l(interfaceC1460b, "persnoal_dress", "cardZipSHA256", "TEXT", null);
            MelodyDatabase.l(interfaceC1460b, "persnoal_dress", "downloadCount", "INTEGER", 0);
            MelodyDatabase.l(interfaceC1460b, "persnoal_dress", "activity", "INTEGER", 0);
            MelodyDatabase.m(interfaceC1460b, "persnoal_dress_series", "`id` INTEGER NOT NULL, `productId` TEXT NOT NULL, `colorId` INTEGER NOT NULL,`primaryId` INTEGER NOT NULL,`identifyId` TEXT,`seriesName` TEXT,`summary` TEXT,`priority` INTEGER NOT NULL,`themeCount` INTEGER NOT NULL,`bannerImgUrl` TEXT,`createTime` TEXT,`updateTime` TEXT,`bottomColor` TEXT,`themeIdList` TEXT,PRIMARY KEY(`primaryId`)");
        }
    }

    public class m extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "zenmode_resource_info", "productId", "TEXT", null);
            MelodyDatabase.l(interfaceC1460b, "zenmode_resource_info", "color", "TEXT", null);
        }
    }

    public class n extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "spine_history_data", "`utc_time` INTEGER NOT NULL, `product_name` TEXT, `product_id` TEXT, `product_mac` TEXT, `normal_times` INTEGER NOT NULL, `mild_times` INTEGER NOT NULL, `bad_times` INTEGER NOT NULL, `unknown_times` INTEGER NOT NULL, PRIMARY KEY(`utc_time`)");
        }
    }

    public class o extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.l(interfaceC1460b, "melody_equipment", "firmwareVersionIgnored", "TEXT", null);
        }
    }

    public class p extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "data_collect", "`id` INTEGER NOT NULL, `dataType` INTEGER NOT NULL, `time` INTEGER NOT NULL, `dataContentType` INTEGER NOT NULL, `dataContent` TEXT, PRIMARY KEY(`id`)");
        }
    }

    public class q extends l1.a {
        @Override // l1.a
        public final void a(InterfaceC1460b interfaceC1460b) {
            MelodyDatabase.m(interfaceC1460b, "provisional_whitelist", "`pid` TEXT NOT NULL, `name` TEXT, `brand` TEXT, `type` TEXT, `fastDiscovery` INTEGER NOT NULL, PRIMARY KEY(`pid`)");
        }
    }

    public static void l(InterfaceC1460b interfaceC1460b, String str, String str2, String str3, Integer num) {
        String str4 = "";
        if (num != null) {
            try {
                str4 = " NOT NULL DEFAULT " + num;
            } catch (SQLException e10) {
                com.oplus.melody.common.util.A.i("MelodyDatabase", "addColumn", e10);
                com.oplus.melody.common.util.A.e(e10);
                B8.a.e();
                return;
            }
        }
        interfaceC1460b.s("ALTER TABLE `" + str + "` ADD COLUMN `" + str2 + "` " + str3 + ' ' + str4);
    }

    public static void m(InterfaceC1460b interfaceC1460b, String str, String str2) {
        try {
            interfaceC1460b.s("CREATE TABLE IF NOT EXISTS `" + str + "` (" + str2 + ")");
        } catch (SQLException e10) {
            com.oplus.melody.common.util.A.i("MelodyDatabase", "createTable", e10);
            com.oplus.melody.common.util.A.e(e10);
            B8.a.e();
            throw new MelodyException(405, e10.toString(), e10);
        }
    }

    public static void n(InterfaceC1460b interfaceC1460b, String str, String str2, String[] strArr) {
        interfaceC1460b.m();
        try {
            Cursor cursorS0 = interfaceC1460b.s0("SELECT * FROM ".concat(str));
            try {
                if (cursorS0.moveToFirst()) {
                    List listAsList = Arrays.asList(strArr);
                    int columnIndex = cursorS0.getColumnIndex(str2);
                    int columnCount = cursorS0.getColumnCount();
                    do {
                        ContentValues contentValues = new ContentValues();
                        boolean z2 = false;
                        for (int i10 = 0; i10 < columnCount; i10++) {
                            String columnName = cursorS0.getColumnName(i10);
                            String string = cursorS0.getString(i10);
                            String strB = listAsList.contains(columnName) ? r.b(string) : r.c(string);
                            if (!TextUtils.equals(string, strB)) {
                                com.oplus.melody.common.util.A.f("MelodyDatabase", "hashTableColumns " + str + ':' + columnName + (char) 12304 + string + " -> " + strB + (char) 12305);
                                z2 = true;
                            }
                            contentValues.put(columnName, strB);
                        }
                        if (z2) {
                            String string2 = cursorS0.getString(columnIndex);
                            if (listAsList.contains(str2)) {
                                interfaceC1460b.k(str, str2 + " = ?", new String[]{string2});
                                interfaceC1460b.F(contentValues, str);
                            } else {
                                interfaceC1460b.d0(str, contentValues, str2 + " = ?", new String[]{string2});
                            }
                        }
                    } while (cursorS0.moveToNext());
                }
                interfaceC1460b.a0();
                cursorS0.close();
            } catch (Throwable th) {
                if (cursorS0 != null) {
                    try {
                        cursorS0.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            com.oplus.melody.common.util.A.i("MelodyDatabase", "hashTableColumns " + str, e10);
        } finally {
            interfaceC1460b.l();
        }
    }

    public static MelodyDatabase q(HeyMelodyApplication context) {
        kotlin.jvm.internal.h.e(context, "context");
        if (ec.m.P("melody-model.db")) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        RoomDatabase.a aVar = new RoomDatabase.a(context);
        ForkJoinPool executor = ForkJoinPool.commonPool();
        kotlin.jvm.internal.h.e(executor, "executor");
        aVar.f12325f = executor;
        aVar.f12332n = false;
        aVar.f12333o = true;
        l1.a[] aVarArr = {f19708m, f19709n, f19710o, f19711p, f19712q, f19713r, f19714s, f19715t, f19716u, f19717v, f19718w, f19719x, f19720y, f19721z, f19704A, f19705B, f19706C};
        for (int i10 = 0; i10 < 17; i10++) {
            l1.a aVar2 = aVarArr[i10];
            LinkedHashSet linkedHashSet = aVar.f12330l;
            linkedHashSet.add(Integer.valueOf(aVar2.f25616a));
            linkedHashSet.add(Integer.valueOf(aVar2.f25617b));
        }
        l1.a[] migrations = (l1.a[]) Arrays.copyOf(aVarArr, 17);
        RoomDatabase.c cVar = aVar.f12328j;
        cVar.getClass();
        kotlin.jvm.internal.h.e(migrations, "migrations");
        for (l1.a aVar3 : migrations) {
            cVar.a(aVar3);
        }
        aVar.f12323d.add(new x(context));
        return (MelodyDatabase) aVar.a();
    }

    public static MelodyDatabase t(HeyMelodyApplication heyMelodyApplication) {
        if (f19707l == null) {
            synchronized (MelodyDatabase.class) {
                try {
                    if (f19707l == null) {
                        if (!E7.a.d(heyMelodyApplication)) {
                            E7.a.c(heyMelodyApplication);
                            B8.a.e();
                        } else {
                            if (!((UserManager) heyMelodyApplication.getSystemService(UserManager.class)).isUserUnlocked()) {
                                com.oplus.melody.common.util.A.x("MelodyDatabase", "createDatabase, user not unlocked, exit self");
                                return null;
                            }
                            if (t8.m.c(heyMelodyApplication, true)) {
                                com.oplus.melody.common.util.A.x("MelodyDatabase", "createDatabase, isLowStorage = true, can't create database");
                                return null;
                            }
                            f19707l = q(heyMelodyApplication);
                        }
                    }
                } finally {
                }
            }
        }
        return f19707l;
    }

    public abstract CarouselDressDao o();

    public abstract ConnectedDeviceDao p();

    public abstract DataCollectDao r();

    public abstract MelodyEquipmentDao s();

    public abstract HearingEnhancementDao u();

    public abstract PersonalDressDao v();

    public abstract PersonalDressSeriesDao w();

    public abstract ProvisionalWhitelistDao x();

    public abstract SpineHistoryDataDao y();

    public abstract ZenModeResourceDao z();
}
