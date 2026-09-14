package com.oplus.melody.model.db;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class HearingEnhancementDao extends w<HearingEnhancementEntity> {
    public abstract int d(HearingEnhancementEntity hearingEnhancementEntity);

    public int e(HearingEnhancementEntity hearingEnhancementEntity) {
        long[] jArrB = b(Collections.singletonList(hearingEnhancementEntity));
        com.oplus.melody.common.util.A.c("HearingEnhancementDao", new s(jArrB, 0));
        return (jArrB == null || jArrB.length <= 0 || jArrB[0] < 0) ? h(hearingEnhancementEntity) : jArrB.length;
    }

    public abstract androidx.lifecycle.s<List<HearingEnhancementEntity>> f();

    public abstract List<HearingEnhancementEntity> g(String str);

    public abstract int h(HearingEnhancementEntity hearingEnhancementEntity);
}
