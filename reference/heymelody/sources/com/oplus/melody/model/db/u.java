package com.oplus.melody.model.db;

import android.bluetooth.BluetoothAdapter;
import com.oplus.melody.btsdk.api.data.KeyFunctionInfo;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19789a;

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f19789a) {
            case 0:
                return BluetoothAdapter.checkBluetoothAddress(((HearingEnhancementEntity) obj).getAddress());
            case 1:
                return Objects.nonNull((KeyFunctionInfo) obj);
            case 2:
                return Objects.nonNull((ZenModeInfoDO) obj);
            case 3:
                return ((a8.b) obj).getIsSelected() == 1;
            default:
                return ((a8.b) obj).getIsSelected() == 1;
        }
    }
}
