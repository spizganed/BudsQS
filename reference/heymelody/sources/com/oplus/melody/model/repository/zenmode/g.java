package com.oplus.melody.model.repository.zenmode;

import android.os.SystemClock;
import androidx.media3.session.D0;
import com.oplus.melody.common.util.A;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f20165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f20166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f20167d;

    public /* synthetic */ g(int i10, long j5, String str, String str2) {
        this.f20164a = i10;
        this.f20165b = j5;
        this.f20166c = str;
        this.f20167d = str2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        t tVar = (t) obj;
        Throwable th = (Throwable) obj2;
        switch (this.f20164a) {
            case 0:
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f20165b;
                String str = this.f20166c;
                String str2 = this.f20167d;
                if (tVar != null && th == null) {
                    A.c("ZenModeRepository", new h(str, str2, jElapsedRealtime));
                } else {
                    StringBuilder sbI = D0.i("getSoundZipConfig FAILURE from ", str, " mac=");
                    sbI.append(A.r(str2));
                    sbI.append(" time=");
                    sbI.append(jElapsedRealtime);
                    A.i("ZenModeRepository", sbI.toString(), th);
                }
                break;
            default:
                final long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.f20165b;
                final String str3 = this.f20166c;
                final String str4 = this.f20167d;
                if (tVar != null && th == null) {
                    A.c("ZenModeRepository", new Supplier() { // from class: com.oplus.melody.model.repository.zenmode.i
                        @Override // java.util.function.Supplier
                        public final Object get() {
                            return "getZipConfigV2 SUCCESS from " + str3 + " mac=" + A.r(str4) + " time=" + jElapsedRealtime2;
                        }
                    });
                } else {
                    StringBuilder sbI2 = D0.i("getZipConfigV2 FAILURE from ", str3, " mac=");
                    sbI2.append(A.r(str4));
                    sbI2.append(" time=");
                    sbI2.append(jElapsedRealtime2);
                    A.i("ZenModeRepository", sbI2.toString(), th);
                }
                break;
        }
    }
}
