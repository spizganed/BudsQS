package com.oplus.melody.model.db;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PersonalDressDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b!\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tH'J\"\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/model/db/PersonalDressDao;", "Lcom/oplus/melody/model/db/MelodyBaseDao;", "Lcom/oplus/melody/model/db/PersonalDressEntity;", "<init>", "()V", "insert", "", "entity", "queryAll", "Landroidx/lifecycle/LiveData;", "", "queryByProductIdColor", "productId", "", "color", "update", "delete", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PersonalDressDao extends w<PersonalDressEntity> {
    public abstract int d(PersonalDressEntity personalDressEntity);

    public int e(PersonalDressEntity personalDressEntity) {
        long[] jArrB = b(Kb.k.b(personalDressEntity));
        com.oplus.melody.common.util.A.c("PersonalDressDao", new T8.d(jArrB, 28));
        return (jArrB == null || jArrB.length == 0 || jArrB[0] < 0) ? g(personalDressEntity) : jArrB.length;
    }

    public abstract androidx.lifecycle.s<List<PersonalDressEntity>> f();

    public abstract int g(PersonalDressEntity personalDressEntity);
}
