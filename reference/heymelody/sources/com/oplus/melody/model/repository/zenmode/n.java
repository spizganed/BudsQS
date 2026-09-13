package com.oplus.melody.model.repository.zenmode;

import android.os.SystemClock;
import com.oplus.melody.common.data.WhitelistContentDO;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import java.util.function.Supplier;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f20192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20193c;

    public /* synthetic */ n(int i10, long j5, Object obj) {
        this.f20191a = i10;
        this.f20193c = obj;
        this.f20192b = j5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f20191a) {
            case 0:
                return "downloadSceneV2 LOCAL " + ((ZenModeInfoDO) this.f20193c).getResId() + " time=" + (SystemClock.elapsedRealtime() - this.f20192b);
            default:
                WhitelistContentDO whitelistContentDO = (WhitelistContentDO) ((Ref$ObjectRef) this.f20193c).element;
                return "readLocalWhitelistFile: ver=" + (whitelistContentDO != null ? Integer.valueOf(whitelistContentDO.getVersionCode()) : null) + " time=" + (SystemClock.elapsedRealtime() - this.f20192b);
        }
    }
}
