package com.oplus.melody.model.db;

import com.google.gson.reflect.TypeToken;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q1.InterfaceC1431a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class F implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19686a;

    public /* synthetic */ F(int i10) {
        this.f19686a = i10;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws Exception {
        q1.c cVarV0;
        switch (this.f19686a) {
            case 0:
                cVarV0 = ((InterfaceC1431a) obj).v0("SELECT `persnoal_dress`.`id` AS `id`, `persnoal_dress`.`productId` AS `productId`, `persnoal_dress`.`colorId` AS `colorId`, `persnoal_dress`.`animSHA256` AS `animSHA256`, `persnoal_dress`.`materialType` AS `materialType`, `persnoal_dress`.`animSize` AS `animSize`, `persnoal_dress`.`animUploadTime` AS `animUploadTime`, `persnoal_dress`.`animUrl` AS `animUrl`, `persnoal_dress`.`darkAnimSHA256` AS `darkAnimSHA256`, `persnoal_dress`.`darkAnimSize` AS `darkAnimSize`, `persnoal_dress`.`darkAnimUploadTime` AS `darkAnimUploadTime`, `persnoal_dress`.`darkAnimUrl` AS `darkAnimUrl`, `persnoal_dress`.`darkPreviewAnim` AS `darkPreviewAnim`, `persnoal_dress`.`darkPreviewAnimSHA256` AS `darkPreviewAnimSHA256`, `persnoal_dress`.`darkPreviewAnimSize` AS `darkPreviewAnimSize`, `persnoal_dress`.`isStatic` AS `isStatic`, `persnoal_dress`.`previewAnim` AS `previewAnim`, `persnoal_dress`.`previewAnimSHA256` AS `previewAnimSHA256`, `persnoal_dress`.`previewAnimSize` AS `previewAnimSize`, `persnoal_dress`.`previewDetailImgUrl` AS `previewDetailImgUrl`, `persnoal_dress`.`previewListImgUrl` AS `previewListImgUrl`, `persnoal_dress`.`summary` AS `summary`, `persnoal_dress`.`themeId` AS `themeId`, `persnoal_dress`.`title` AS `title`, `persnoal_dress`.`toneSHA256` AS `toneSHA256`, `persnoal_dress`.`toneSize` AS `toneSize`, `persnoal_dress`.`toneUploadTime` AS `toneUploadTime`, `persnoal_dress`.`toneUrl` AS `toneUrl`, `persnoal_dress`.`tonePreviewSHA256` AS `tonePreviewSHA256`, `persnoal_dress`.`tonePreviewSize` AS `tonePreviewSize`, `persnoal_dress`.`tonePreviewUrl` AS `tonePreviewUrl`, `persnoal_dress`.`publishStatus` AS `publishStatus`, `persnoal_dress`.`priority` AS `priority`, `persnoal_dress`.`tags` AS `tags`, `persnoal_dress`.`cardZipUrl` AS `cardZipUrl`, `persnoal_dress`.`cardZipSHA256` AS `cardZipSHA256`, `persnoal_dress`.`downloadCount` AS `downloadCount`, `persnoal_dress`.`activity` AS `activity` FROM persnoal_dress");
                try {
                    ArrayList arrayList = new ArrayList();
                    while (cVarV0.l0()) {
                        arrayList.add(new PersonalDressEntity(cVarV0.isNull(0) ? null : cVarV0.o(0), cVarV0.isNull(1) ? null : cVarV0.o(1), (int) cVarV0.getLong(2), cVarV0.isNull(3) ? null : cVarV0.o(3), (int) cVarV0.getLong(4), (int) cVarV0.getLong(5), cVarV0.isNull(6) ? null : cVarV0.o(6), cVarV0.isNull(7) ? null : cVarV0.o(7), cVarV0.isNull(8) ? null : cVarV0.o(8), (int) cVarV0.getLong(9), cVarV0.isNull(10) ? null : cVarV0.o(10), cVarV0.isNull(11) ? null : cVarV0.o(11), cVarV0.isNull(12) ? null : cVarV0.o(12), cVarV0.isNull(13) ? null : cVarV0.o(13), (int) cVarV0.getLong(14), (int) cVarV0.getLong(15), cVarV0.isNull(16) ? null : cVarV0.o(16), cVarV0.isNull(17) ? null : cVarV0.o(17), (int) cVarV0.getLong(18), cVarV0.isNull(19) ? null : cVarV0.o(19), cVarV0.isNull(20) ? null : cVarV0.o(20), cVarV0.isNull(21) ? null : cVarV0.o(21), cVarV0.isNull(22) ? null : cVarV0.o(22), cVarV0.isNull(23) ? null : cVarV0.o(23), cVarV0.isNull(24) ? null : cVarV0.o(24), (int) cVarV0.getLong(25), cVarV0.isNull(26) ? null : cVarV0.o(26), cVarV0.isNull(27) ? null : cVarV0.o(27), cVarV0.isNull(28) ? null : cVarV0.o(28), (int) cVarV0.getLong(29), cVarV0.isNull(30) ? null : cVarV0.o(30), (int) cVarV0.getLong(31), (int) cVarV0.getLong(32), (List) C0917x.d(cVarV0.isNull(33) ? null : cVarV0.o(33), new TypeToken<List<PersonalDressDTO.Tag>>() { // from class: com.oplus.melody.model.db.MelodyTypeConverters.6
                        }.getType()), cVarV0.isNull(34) ? null : cVarV0.o(34), cVarV0.isNull(35) ? null : cVarV0.o(35), (int) cVarV0.getLong(36), ((int) cVarV0.getLong(37)) != 0));
                        break;
                    }
                    return arrayList;
                } finally {
                }
            default:
                cVarV0 = ((InterfaceC1431a) obj).v0("SELECT `persnoal_dress_series`.`primaryId` AS `primaryId`, `persnoal_dress_series`.`id` AS `id`, `persnoal_dress_series`.`productId` AS `productId`, `persnoal_dress_series`.`colorId` AS `colorId`, `persnoal_dress_series`.`identifyId` AS `identifyId`, `persnoal_dress_series`.`seriesName` AS `seriesName`, `persnoal_dress_series`.`summary` AS `summary`, `persnoal_dress_series`.`priority` AS `priority`, `persnoal_dress_series`.`themeCount` AS `themeCount`, `persnoal_dress_series`.`bannerImgUrl` AS `bannerImgUrl`, `persnoal_dress_series`.`createTime` AS `createTime`, `persnoal_dress_series`.`updateTime` AS `updateTime`, `persnoal_dress_series`.`bottomColor` AS `bottomColor`, `persnoal_dress_series`.`themeIdList` AS `themeIdList` FROM persnoal_dress_series");
                try {
                    ArrayList arrayList2 = new ArrayList();
                    while (cVarV0.l0()) {
                        PersonalDressSeriesEntity personalDressSeriesEntity = new PersonalDressSeriesEntity();
                        personalDressSeriesEntity.setPrimaryId((int) cVarV0.getLong(0));
                        personalDressSeriesEntity.setId((int) cVarV0.getLong(1));
                        String strO = null;
                        personalDressSeriesEntity.setMProductId(cVarV0.isNull(2) ? null : cVarV0.o(2));
                        personalDressSeriesEntity.setMColorId((int) cVarV0.getLong(3));
                        personalDressSeriesEntity.setIdentifyId(cVarV0.isNull(4) ? null : cVarV0.o(4));
                        personalDressSeriesEntity.setSeriesName((Map) C0917x.d(cVarV0.isNull(5) ? null : cVarV0.o(5), new TypeToken<Map<String, String>>() { // from class: com.oplus.melody.model.db.MelodyTypeConverters.4
                        }.getType()));
                        personalDressSeriesEntity.setSummary((Map) C0917x.d(cVarV0.isNull(6) ? null : cVarV0.o(6), new TypeToken<Map<String, String>>() { // from class: com.oplus.melody.model.db.MelodyTypeConverters.4
                        }.getType()));
                        personalDressSeriesEntity.setPriority((int) cVarV0.getLong(7));
                        personalDressSeriesEntity.setThemeCount((int) cVarV0.getLong(8));
                        personalDressSeriesEntity.setBannerImgUrl(cVarV0.isNull(9) ? null : cVarV0.o(9));
                        personalDressSeriesEntity.setCreateTime(cVarV0.isNull(10) ? null : cVarV0.o(10));
                        personalDressSeriesEntity.setUpdateTime(cVarV0.isNull(11) ? null : cVarV0.o(11));
                        personalDressSeriesEntity.setBottomColor(cVarV0.isNull(12) ? null : cVarV0.o(12));
                        if (!cVarV0.isNull(13)) {
                            strO = cVarV0.o(13);
                        }
                        personalDressSeriesEntity.setThemeIdList(MelodyTypeConverters.a(strO));
                        arrayList2.add(personalDressSeriesEntity);
                        break;
                    }
                    return arrayList2;
                } finally {
                }
        }
    }
}
