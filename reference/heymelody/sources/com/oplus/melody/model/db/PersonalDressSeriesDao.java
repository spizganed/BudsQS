package com.oplus.melody.model.db;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PersonalDressSeriesDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b!\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tH'J\"\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/model/db/PersonalDressSeriesDao;", "Lcom/oplus/melody/model/db/MelodyBaseDao;", "Lcom/oplus/melody/model/db/PersonalDressSeriesEntity;", "<init>", "()V", "insert", "", "entity", "queryAll", "Landroidx/lifecycle/LiveData;", "", "queryByProductIdColor", "productId", "", "color", "update", "delete", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PersonalDressSeriesDao extends w<PersonalDressSeriesEntity> {
    public abstract androidx.lifecycle.s<List<PersonalDressSeriesEntity>> d();

    public abstract int e(PersonalDressSeriesEntity personalDressSeriesEntity);
}
