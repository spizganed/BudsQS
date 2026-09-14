package com.oplus.melody.model.db;

import com.oplus.melody.common.util.C0917x;

/* JADX INFO: compiled from: PersonalDressSeriesDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class G extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f19687j;

    @Override // G0.c
    public final void b(q1.c cVar, Object obj) {
        switch (this.f19687j) {
            case 0:
                PersonalDressSeriesEntity personalDressSeriesEntity = (PersonalDressSeriesEntity) obj;
                cVar.h(1, personalDressSeriesEntity.getPrimaryId());
                cVar.h(2, personalDressSeriesEntity.getId());
                if (personalDressSeriesEntity.getMProductId() == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, personalDressSeriesEntity.getMProductId());
                }
                cVar.h(4, personalDressSeriesEntity.getMColorId());
                if (personalDressSeriesEntity.getIdentifyId() == null) {
                    cVar.a(5);
                } else {
                    cVar.V(5, personalDressSeriesEntity.getIdentifyId());
                }
                String strI = C0917x.i(personalDressSeriesEntity.getSeriesName());
                if (strI == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, strI);
                }
                String strI2 = C0917x.i(personalDressSeriesEntity.getSummary());
                if (strI2 == null) {
                    cVar.a(7);
                } else {
                    cVar.V(7, strI2);
                }
                cVar.h(8, personalDressSeriesEntity.getPriority());
                cVar.h(9, personalDressSeriesEntity.getThemeCount());
                if (personalDressSeriesEntity.getBannerImgUrl() == null) {
                    cVar.a(10);
                } else {
                    cVar.V(10, personalDressSeriesEntity.getBannerImgUrl());
                }
                if (personalDressSeriesEntity.getCreateTime() == null) {
                    cVar.a(11);
                } else {
                    cVar.V(11, personalDressSeriesEntity.getCreateTime());
                }
                if (personalDressSeriesEntity.getUpdateTime() == null) {
                    cVar.a(12);
                } else {
                    cVar.V(12, personalDressSeriesEntity.getUpdateTime());
                }
                if (personalDressSeriesEntity.getBottomColor() == null) {
                    cVar.a(13);
                } else {
                    cVar.V(13, personalDressSeriesEntity.getBottomColor());
                }
                String strI3 = C0917x.i(personalDressSeriesEntity.getThemeIdList());
                if (strI3 == null) {
                    cVar.a(14);
                } else {
                    cVar.V(14, strI3);
                }
                cVar.h(15, personalDressSeriesEntity.getPrimaryId());
                break;
            default:
                String str = ((N) obj).mResId;
                if (str != null) {
                    cVar.V(1, str);
                } else {
                    cVar.a(1);
                }
                break;
        }
    }

    @Override // G0.c
    public final String c() {
        switch (this.f19687j) {
            case 0:
                return "UPDATE OR ABORT `persnoal_dress_series` SET `primaryId` = ?,`id` = ?,`productId` = ?,`colorId` = ?,`identifyId` = ?,`seriesName` = ?,`summary` = ?,`priority` = ?,`themeCount` = ?,`bannerImgUrl` = ?,`createTime` = ?,`updateTime` = ?,`bottomColor` = ?,`themeIdList` = ? WHERE `primaryId` = ?";
            default:
                return "DELETE FROM `zenmode_resource_info` WHERE `resid` = ?";
        }
    }
}
