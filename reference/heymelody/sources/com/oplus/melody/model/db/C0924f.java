package com.oplus.melody.model.db;

import com.oplus.melody.common.util.C0917x;

/* JADX INFO: renamed from: com.oplus.melody.model.db.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CarouselDressDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C0924f extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f19765j;

    public /* synthetic */ C0924f(int i10) {
        this.f19765j = i10;
    }

    @Override // G0.c
    public final void b(q1.c cVar, Object obj) {
        switch (this.f19765j) {
            case 0:
                CarouselDressEntity carouselDressEntity = (CarouselDressEntity) obj;
                cVar.h(1, carouselDressEntity.getCarouselId());
                if (carouselDressEntity.getProductId() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, carouselDressEntity.getProductId());
                }
                cVar.h(3, carouselDressEntity.getColorId());
                if (carouselDressEntity.getName() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, carouselDressEntity.getName());
                }
                cVar.h(5, carouselDressEntity.getCarouselType());
                String strI = C0917x.i(carouselDressEntity.getThemeIdList());
                if (strI == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, strI);
                }
                cVar.h(7, carouselDressEntity.getCarouselId());
                break;
            case 1:
                HearingEnhancementEntity hearingEnhancementEntity = (HearingEnhancementEntity) obj;
                if (hearingEnhancementEntity.getUid() == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, hearingEnhancementEntity.getUid());
                }
                if (hearingEnhancementEntity.getName() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, hearingEnhancementEntity.getName());
                }
                if (hearingEnhancementEntity.getAddress() == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, hearingEnhancementEntity.getAddress());
                }
                String strI2 = C0917x.i(hearingEnhancementEntity.getData());
                if (strI2 == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, strI2);
                }
                cVar.h(5, hearingEnhancementEntity.getCreateTime());
                if (hearingEnhancementEntity.getLocalIndex() == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, hearingEnhancementEntity.getLocalIndex());
                }
                if (hearingEnhancementEntity.getUid() != null) {
                    cVar.V(7, hearingEnhancementEntity.getUid());
                } else {
                    cVar.a(7);
                }
                break;
            case 2:
                PersonalDressEntity personalDressEntity = (PersonalDressEntity) obj;
                if (personalDressEntity.getId() == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, personalDressEntity.getId());
                }
                if (personalDressEntity.getMProductId() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, personalDressEntity.getMProductId());
                }
                cVar.h(3, personalDressEntity.getMColorId());
                if (personalDressEntity.getAnimSHA256() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, personalDressEntity.getAnimSHA256());
                }
                cVar.h(5, personalDressEntity.getMaterialType());
                cVar.h(6, personalDressEntity.getAnimSize());
                if (personalDressEntity.getAnimUploadTime() == null) {
                    cVar.a(7);
                } else {
                    cVar.V(7, personalDressEntity.getAnimUploadTime());
                }
                if (personalDressEntity.getAnimUrl() == null) {
                    cVar.a(8);
                } else {
                    cVar.V(8, personalDressEntity.getAnimUrl());
                }
                if (personalDressEntity.getDarkAnimSHA256() == null) {
                    cVar.a(9);
                } else {
                    cVar.V(9, personalDressEntity.getDarkAnimSHA256());
                }
                cVar.h(10, personalDressEntity.getDarkAnimSize());
                if (personalDressEntity.getDarkAnimUploadTime() == null) {
                    cVar.a(11);
                } else {
                    cVar.V(11, personalDressEntity.getDarkAnimUploadTime());
                }
                if (personalDressEntity.getDarkAnimUrl() == null) {
                    cVar.a(12);
                } else {
                    cVar.V(12, personalDressEntity.getDarkAnimUrl());
                }
                if (personalDressEntity.getDarkPreviewAnim() == null) {
                    cVar.a(13);
                } else {
                    cVar.V(13, personalDressEntity.getDarkPreviewAnim());
                }
                if (personalDressEntity.getDarkPreviewAnimSHA256() == null) {
                    cVar.a(14);
                } else {
                    cVar.V(14, personalDressEntity.getDarkPreviewAnimSHA256());
                }
                cVar.h(15, personalDressEntity.getDarkPreviewAnimSize());
                cVar.h(16, personalDressEntity.getAnimStatic());
                if (personalDressEntity.getPreviewAnim() == null) {
                    cVar.a(17);
                } else {
                    cVar.V(17, personalDressEntity.getPreviewAnim());
                }
                if (personalDressEntity.getPreviewAnimSHA256() == null) {
                    cVar.a(18);
                } else {
                    cVar.V(18, personalDressEntity.getPreviewAnimSHA256());
                }
                cVar.h(19, personalDressEntity.getPreviewAnimSize());
                if (personalDressEntity.getPreviewDetailImgUrl() == null) {
                    cVar.a(20);
                } else {
                    cVar.V(20, personalDressEntity.getPreviewDetailImgUrl());
                }
                if (personalDressEntity.getPreviewListImgUrl() == null) {
                    cVar.a(21);
                } else {
                    cVar.V(21, personalDressEntity.getPreviewListImgUrl());
                }
                if (personalDressEntity.getSummary() == null) {
                    cVar.a(22);
                } else {
                    cVar.V(22, personalDressEntity.getSummary());
                }
                if (personalDressEntity.getThemeId() == null) {
                    cVar.a(23);
                } else {
                    cVar.V(23, personalDressEntity.getThemeId());
                }
                if (personalDressEntity.getTitle() == null) {
                    cVar.a(24);
                } else {
                    cVar.V(24, personalDressEntity.getTitle());
                }
                if (personalDressEntity.getToneSHA256() == null) {
                    cVar.a(25);
                } else {
                    cVar.V(25, personalDressEntity.getToneSHA256());
                }
                cVar.h(26, personalDressEntity.getToneSize());
                if (personalDressEntity.getToneUploadTime() == null) {
                    cVar.a(27);
                } else {
                    cVar.V(27, personalDressEntity.getToneUploadTime());
                }
                if (personalDressEntity.getToneUrl() == null) {
                    cVar.a(28);
                } else {
                    cVar.V(28, personalDressEntity.getToneUrl());
                }
                if (personalDressEntity.getTonePreviewSHA256() == null) {
                    cVar.a(29);
                } else {
                    cVar.V(29, personalDressEntity.getTonePreviewSHA256());
                }
                cVar.h(30, personalDressEntity.getTonePreviewSize());
                if (personalDressEntity.getTonePreviewUrl() == null) {
                    cVar.a(31);
                } else {
                    cVar.V(31, personalDressEntity.getTonePreviewUrl());
                }
                cVar.h(32, personalDressEntity.getPublishStatus());
                cVar.h(33, personalDressEntity.getPriority());
                String strI3 = C0917x.i(personalDressEntity.getTags());
                if (strI3 == null) {
                    cVar.a(34);
                } else {
                    cVar.V(34, strI3);
                }
                if (personalDressEntity.getCardZipUrl() == null) {
                    cVar.a(35);
                } else {
                    cVar.V(35, personalDressEntity.getCardZipUrl());
                }
                if (personalDressEntity.getCardZipSHA256() == null) {
                    cVar.a(36);
                } else {
                    cVar.V(36, personalDressEntity.getCardZipSHA256());
                }
                cVar.h(37, personalDressEntity.getDownloadCount());
                cVar.h(38, personalDressEntity.getActivity() ? 1L : 0L);
                if (personalDressEntity.getId() != null) {
                    cVar.V(39, personalDressEntity.getId());
                } else {
                    cVar.a(39);
                }
                break;
            default:
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
                String strI4 = C0917x.i(personalDressSeriesEntity.getSeriesName());
                if (strI4 == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, strI4);
                }
                String strI5 = C0917x.i(personalDressSeriesEntity.getSummary());
                if (strI5 == null) {
                    cVar.a(7);
                } else {
                    cVar.V(7, strI5);
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
                String strI6 = C0917x.i(personalDressSeriesEntity.getThemeIdList());
                if (strI6 == null) {
                    cVar.a(14);
                } else {
                    cVar.V(14, strI6);
                }
                cVar.h(15, personalDressSeriesEntity.getPrimaryId());
                break;
        }
    }

    @Override // G0.c
    public final String c() {
        switch (this.f19765j) {
            case 0:
                return "UPDATE OR ABORT `carousel_dress` SET `carouselId` = ?,`productId` = ?,`colorId` = ?,`name` = ?,`carouselType` = ?,`themeIdList` = ? WHERE `carouselId` = ?";
            case 1:
                return "UPDATE OR ABORT `hearing_enhancement` SET `u_id` = ?,`name` = ?,`address` = ?,`data` = ?,`create_time` = ?,`local_index` = ? WHERE `u_id` = ?";
            case 2:
                return "UPDATE OR ABORT `persnoal_dress` SET `id` = ?,`productId` = ?,`colorId` = ?,`animSHA256` = ?,`materialType` = ?,`animSize` = ?,`animUploadTime` = ?,`animUrl` = ?,`darkAnimSHA256` = ?,`darkAnimSize` = ?,`darkAnimUploadTime` = ?,`darkAnimUrl` = ?,`darkPreviewAnim` = ?,`darkPreviewAnimSHA256` = ?,`darkPreviewAnimSize` = ?,`isStatic` = ?,`previewAnim` = ?,`previewAnimSHA256` = ?,`previewAnimSize` = ?,`previewDetailImgUrl` = ?,`previewListImgUrl` = ?,`summary` = ?,`themeId` = ?,`title` = ?,`toneSHA256` = ?,`toneSize` = ?,`toneUploadTime` = ?,`toneUrl` = ?,`tonePreviewSHA256` = ?,`tonePreviewSize` = ?,`tonePreviewUrl` = ?,`publishStatus` = ?,`priority` = ?,`tags` = ?,`cardZipUrl` = ?,`cardZipSHA256` = ?,`downloadCount` = ?,`activity` = ? WHERE `id` = ?";
            default:
                return "UPDATE OR REPLACE `persnoal_dress_series` SET `primaryId` = ?,`id` = ?,`productId` = ?,`colorId` = ?,`identifyId` = ?,`seriesName` = ?,`summary` = ?,`priority` = ?,`themeCount` = ?,`bannerImgUrl` = ?,`createTime` = ?,`updateTime` = ?,`bottomColor` = ?,`themeIdList` = ? WHERE `primaryId` = ?";
        }
    }
}
