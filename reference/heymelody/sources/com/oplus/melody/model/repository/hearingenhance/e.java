package com.oplus.melody.model.repository.hearingenhance;

import com.oplus.melody.common.util.A;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20027b;

    public /* synthetic */ e(Object obj, int i10) {
        this.f20026a = i10;
        this.f20027b = obj;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f20026a) {
            case 0:
                CompletableFuture completableFuture = (CompletableFuture) obj2;
                if (completableFuture != null && !completableFuture.isDone()) {
                    A.b("HearingEnhancementRepository", "sendProcessHearingDetectionData compute old future.cancel!");
                    completableFuture.cancel(true);
                }
                return (CompletableFuture) ((d) this.f20027b).get();
            default:
                HearingEnhancementEntity hearingEnhancementEntity = (HearingEnhancementEntity) obj2;
                HearingEnhancementEntity hearingEnhancementEntity2 = (HearingEnhancementEntity) this.f20027b;
                if (Objects.equals(hearingEnhancementEntity, hearingEnhancementEntity2)) {
                    return hearingEnhancementEntity;
                }
                if (A.l()) {
                    StringBuilder sb2 = new StringBuilder("HearingEnhancementRepository.queryAll new one, entity addr: ");
                    sb2.append(hearingEnhancementEntity2.getAddress());
                    sb2.append(", uid: ");
                    sb2.append(hearingEnhancementEntity2.getUid());
                    sb2.append(", name: ");
                    sb2.append(hearingEnhancementEntity2.getName());
                    sb2.append(", recordName: ");
                    sb2.append(hearingEnhancementEntity2.getData() != null ? hearingEnhancementEntity2.getData().getRecordName() : null);
                    sb2.append(", index: ");
                    sb2.append(hearingEnhancementEntity2.getLocalIndex());
                    sb2.append(", createTime: ");
                    sb2.append(hearingEnhancementEntity2.getCreateTime());
                    A.f("HearingEnhancementRepository", sb2.toString());
                }
                return hearingEnhancementEntity2;
        }
    }
}
