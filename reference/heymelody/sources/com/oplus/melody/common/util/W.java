package com.oplus.melody.common.util;

import android.text.TextUtils;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.model.repository.zenmode.ZenModePlayStateDTO;
import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class W implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19478b;

    public /* synthetic */ W(String str, int i10) {
        this.f19477a = i10;
        this.f19478b = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f19477a) {
            case 0:
                return Y.n(this.f19478b, (WhitelistConfigDTO) obj);
            default:
                ZenModePlayStateDTO zenModePlayStateDTO = (ZenModePlayStateDTO) obj;
                return zenModePlayStateDTO != null && TextUtils.equals(zenModePlayStateDTO.getAddress(), this.f19478b);
        }
    }
}
