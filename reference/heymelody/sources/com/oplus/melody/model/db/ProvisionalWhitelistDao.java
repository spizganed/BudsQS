package com.oplus.melody.model.db;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ProvisionalWhitelistDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\b'\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H'J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH'J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH'J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH'J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH'J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H'J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0017¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/model/db/ProvisionalWhitelistDao;", "Lcom/oplus/melody/model/db/MelodyBaseDao;", "Lcom/oplus/melody/model/db/ProvisionalWhitelistEntity;", "<init>", "()V", "queryAll", "Landroidx/lifecycle/LiveData;", "", "deleteIds", "", "ids", "", "", "setName", "pid", "name", "setType", SpeechFindManager.TYPE, "setBrand", "brand", "setUuid", "uuid", "setFastDiscovery", "fastDiscovery", "", "insertOrUpdate", "entity", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ProvisionalWhitelistDao extends w<ProvisionalWhitelistEntity> {
    public abstract void d(LinkedHashSet linkedHashSet);

    public void e(ProvisionalWhitelistEntity provisionalWhitelistEntity) {
        long[] jArrB = b(Kb.k.b(provisionalWhitelistEntity));
        if (jArrB == null || jArrB.length == 0 || jArrB[0] < 0) {
            String name = provisionalWhitelistEntity.getName();
            if (name != null) {
                i(provisionalWhitelistEntity.getPid(), name);
            }
            String type = provisionalWhitelistEntity.getType();
            if (type != null) {
                j(provisionalWhitelistEntity.getPid(), type);
            }
            String brand = provisionalWhitelistEntity.getBrand();
            if (brand != null) {
                g(provisionalWhitelistEntity.getPid(), brand);
            }
            String uuid = provisionalWhitelistEntity.getUuid();
            if (uuid != null) {
                k(provisionalWhitelistEntity.getPid(), uuid);
            }
            if (provisionalWhitelistEntity.getFastDiscovery() != 0) {
                h(provisionalWhitelistEntity.getFastDiscovery(), provisionalWhitelistEntity.getPid());
            }
        }
    }

    public abstract androidx.lifecycle.s<List<ProvisionalWhitelistEntity>> f();

    public abstract void g(String str, String str2);

    public abstract void h(int i10, String str);

    public abstract void i(String str, String str2);

    public abstract void j(String str, String str2);

    public abstract void k(String str, String str2);
}
