package com.oplus.melody.model.db;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: CarouselDressDao.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b!\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\tH'J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u000fH'J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0016"}, d2 = {"Lcom/oplus/melody/model/db/CarouselDressDao;", "Lcom/oplus/melody/model/db/MelodyBaseDao;", "Lcom/oplus/melody/model/db/CarouselDressEntity;", "<init>", "()V", "insert", "", "entity", "queryAll", "Landroidx/lifecycle/LiveData;", "", "queryByProductIdColor", "productId", "", "colorId", "", "queryById", "carouselId", "update", "delete", "deleteByProductIdColor", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class CarouselDressDao extends w<CarouselDressEntity> {
    public abstract int d(CarouselDressEntity carouselDressEntity);

    public abstract int e(int i10, String str);

    public long f(CarouselDressEntity carouselDressEntity) {
        long[] jArrB = b(Kb.k.b(carouselDressEntity));
        com.oplus.melody.common.util.A.c("CarouselDressDao", new C0919a(jArrB, 0));
        if (jArrB != null && jArrB.length != 0) {
            long j5 = jArrB[0];
            if (j5 >= 0) {
                return j5;
            }
        }
        return j(carouselDressEntity);
    }

    public abstract androidx.lifecycle.s<List<CarouselDressEntity>> g();

    public abstract CarouselDressEntity h(int i10);

    public abstract List i(int i10, String str);

    public abstract int j(CarouselDressEntity carouselDressEntity);
}
