package com.oplus.melody.model.db;

/* JADX INFO: compiled from: DataCollectDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f19781j;

    @Override // G0.c
    public final void b(q1.c cVar, Object obj) {
        switch (this.f19781j) {
            case 0:
                DataCollectEntity dataCollectEntity = (DataCollectEntity) obj;
                cVar.h(1, dataCollectEntity.getId());
                cVar.h(2, dataCollectEntity.getMDataType());
                cVar.h(3, dataCollectEntity.getMTime());
                cVar.h(4, dataCollectEntity.getMDataContentType());
                if (dataCollectEntity.getMDataContent() != null) {
                    cVar.V(5, dataCollectEntity.getMDataContent());
                } else {
                    cVar.a(5);
                }
                break;
            case 1:
                ProvisionalWhitelistEntity provisionalWhitelistEntity = (ProvisionalWhitelistEntity) obj;
                if (provisionalWhitelistEntity.getPid() == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, provisionalWhitelistEntity.getPid());
                }
                if (provisionalWhitelistEntity.getName() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, provisionalWhitelistEntity.getName());
                }
                if (provisionalWhitelistEntity.getBrand() == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, provisionalWhitelistEntity.getBrand());
                }
                if (provisionalWhitelistEntity.getType() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, provisionalWhitelistEntity.getType());
                }
                if (provisionalWhitelistEntity.getUuid() == null) {
                    cVar.a(5);
                } else {
                    cVar.V(5, provisionalWhitelistEntity.getUuid());
                }
                cVar.h(6, provisionalWhitelistEntity.getFastDiscovery());
                break;
            default:
                M m9 = (M) obj;
                cVar.h(1, m9.getUtc());
                if (m9.getProductName() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, m9.getProductName());
                }
                if (m9.getProductId() == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, m9.getProductId());
                }
                if (m9.getMacAddress() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, m9.getMacAddress());
                }
                cVar.h(5, m9.getNormalTimes());
                cVar.h(6, m9.getMildTimes());
                cVar.h(7, m9.getBadTimes());
                cVar.h(8, m9.getUnKnowns());
                break;
        }
    }

    @Override // G0.c
    public final String c() {
        switch (this.f19781j) {
            case 0:
                return "INSERT OR IGNORE INTO `data_collect` (`id`,`dataType`,`time`,`dataContentType`,`dataContent`) VALUES (nullif(?, 0),?,?,?,?)";
            case 1:
                return "INSERT OR IGNORE INTO `provisional_whitelist` (`pid`,`name`,`brand`,`type`,`uuid`,`fastDiscovery`) VALUES (?,?,?,?,?,?)";
            default:
                return "INSERT OR REPLACE INTO `spine_history_data` (`utc_time`,`product_name`,`product_id`,`product_mac`,`normal_times`,`mild_times`,`bad_times`,`unknown_times`) VALUES (?,?,?,?,?,?,?,?)";
        }
    }
}
