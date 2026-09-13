package com.oplus.melody.model.db;

/* JADX INFO: renamed from: com.oplus.melody.model.db.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CarouselDressDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C0923e extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f19764j;

    public /* synthetic */ C0923e(int i10) {
        this.f19764j = i10;
    }

    @Override // G0.c
    public final void b(q1.c cVar, Object obj) {
        switch (this.f19764j) {
            case 0:
                cVar.h(1, ((CarouselDressEntity) obj).getCarouselId());
                break;
            case 1:
                C0929m c0929m = (C0929m) obj;
                if (c0929m.getId() == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, c0929m.getId());
                }
                if (c0929m.getName() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, c0929m.getName());
                }
                if (c0929m.getBrand() == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, c0929m.getBrand());
                }
                if (c0929m.getType() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, c0929m.getType());
                }
                if (c0929m.getCoverImage() == null) {
                    cVar.a(5);
                } else {
                    cVar.V(5, c0929m.getCoverImage());
                }
                if (c0929m.getMacAddress() == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, c0929m.getMacAddress());
                }
                cVar.h(7, c0929m.mTime);
                if (c0929m.getMacAddress() != null) {
                    cVar.V(8, c0929m.getMacAddress());
                } else {
                    cVar.a(8);
                }
                break;
            case 2:
                HearingEnhancementEntity hearingEnhancementEntity = (HearingEnhancementEntity) obj;
                if (hearingEnhancementEntity.getUid() != null) {
                    cVar.V(1, hearingEnhancementEntity.getUid());
                } else {
                    cVar.a(1);
                }
                break;
            case 3:
                PersonalDressEntity personalDressEntity = (PersonalDressEntity) obj;
                if (personalDressEntity.getId() != null) {
                    cVar.V(1, personalDressEntity.getId());
                } else {
                    cVar.a(1);
                }
                break;
            default:
                cVar.h(1, ((PersonalDressSeriesEntity) obj).getPrimaryId());
                break;
        }
    }

    @Override // G0.c
    public final String c() {
        switch (this.f19764j) {
            case 0:
                return "DELETE FROM `carousel_dress` WHERE `carouselId` = ?";
            case 1:
                return "UPDATE OR ABORT `connected_device` SET `product_id` = ?,`product_name` = ?,`product_brand` = ?,`product_type` = ?,`cover_image` = ?,`mac_address` = ?,`time` = ? WHERE `mac_address` = ?";
            case 2:
                return "DELETE FROM `hearing_enhancement` WHERE `u_id` = ?";
            case 3:
                return "DELETE FROM `persnoal_dress` WHERE `id` = ?";
            default:
                return "DELETE FROM `persnoal_dress_series` WHERE `primaryId` = ?";
        }
    }
}
