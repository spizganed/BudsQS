package com.oplus.melody.ui.component.hearingenhance;

import A6.f;
import D7.C0379m;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.hearingenhance.EarRestoreDataDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import k7.n;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public final class HearingEnhancementViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21584e;

    public static CompletableFuture g(int i10, String str) {
        return com.oplus.melody.model.repository.hearingenhance.a.o().u(i10, str);
    }

    public static void i(HearingEnhancementEntity hearingEnhancementEntity) {
        ForkJoinPool.commonPool().execute(new n(hearingEnhancementEntity, 6));
    }

    public static CompletableFuture j(String str, int i10, int i11, String str2, ArrayList arrayList) {
        return com.oplus.melody.model.repository.hearingenhance.a.o().E(str, i10, i11, str2, arrayList);
    }

    public static void k(int i10, String str) {
        A.c("HearingEnhancementViewModel", new Aa.a(i10, str, 15));
        if (i10 <= 0) {
            CompletableFuture.completedFuture(new SetCommandStateDTO());
            return;
        }
        ArrayList<EarRestoreDataDTO> arrayList = new ArrayList<>();
        arrayList.add(new EarRestoreDataDTO(1, 1, new byte[]{(byte) i10}));
        com.oplus.melody.model.repository.hearingenhance.a.o().F(str, arrayList);
    }

    public final s<Integer> d(String str) {
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new f(0)));
    }

    public final EarphoneDTO e(String str) {
        return AbstractC0939b.E().w(str);
    }

    public final t f(String str) {
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new f(11)));
    }

    public final boolean h() {
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(null, this.f21581b);
        if (whitelistConfigDTOC != null) {
            return Y.e(whitelistConfigDTOC.getFunction().getEarScan(), false);
        }
        return false;
    }
}
