package com.oplus.melody.model.db;

import com.oplus.drs.core.provider.DcsCompatEventConverter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DataCollectDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b!\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tH'J*\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH'J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH'J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/model/db/DataCollectDao;", "Lcom/oplus/melody/model/db/MelodyBaseDao;", "Lcom/oplus/melody/model/db/DataCollectEntity;", "<init>", "()V", "insert", "", "entity", "queryAll", "Landroidx/lifecycle/LiveData;", "", "queryData", DcsCompatEventConverter.KEY_DATA_TYPE, "fromTime", "", "toTime", "update", "deleteExpiredData", "", "time", "delete", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DataCollectDao extends w<DataCollectEntity> {
    public abstract void d(long j5);

    public abstract List<DataCollectEntity> e(int i10, long j5, long j9);
}
