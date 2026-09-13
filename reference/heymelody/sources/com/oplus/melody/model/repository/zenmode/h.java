package com.oplus.melody.model.repository.zenmode;

import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.headsettip.HeadsetTipCleanDTO;
import java.util.function.Supplier;
import t8.z;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20168a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f20170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f20171d;

    public /* synthetic */ h(String str, long j5, HeadsetTipCleanDTO headsetTipCleanDTO) {
        this.f20169b = str;
        this.f20170c = j5;
        this.f20171d = headsetTipCleanDTO;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f20168a) {
            case 0:
                return "getSoundZipConfig SUCCESS from " + this.f20169b + " mac=" + A.r((String) this.f20171d) + " time=" + this.f20170c;
            default:
                String strR = A.r(this.f20169b);
                String str = z.f27961a.format(Long.valueOf(this.f20170c));
                String strB = z.b((HeadsetTipCleanDTO) this.f20171d);
                StringBuilder sbI = Y.r.i("completeTipClean ", strR, " currentTime:", str, " tipCleanDto:");
                sbI.append(strB);
                return sbI.toString();
        }
    }

    public /* synthetic */ h(String str, String str2, long j5) {
        this.f20169b = str;
        this.f20171d = str2;
        this.f20170c = j5;
    }
}
