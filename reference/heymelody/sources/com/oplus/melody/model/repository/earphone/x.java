package com.oplus.melody.model.repository.earphone;

import D7.q0;
import android.content.Intent;
import androidx.media3.exoplayer.C0625v;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.app.discovery.DiscoveryDialogActivity;
import com.oplus.melody.app.discovery.I0;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import z7.C1725a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f20007d;

    public /* synthetic */ x(int i10, int i11, String str) {
        this.f20004a = 2;
        this.f20006c = i10;
        this.f20007d = i11;
        this.f20005b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f20004a) {
            case 0:
                String str = (String) this.f20005b;
                int i10 = this.f20006c;
                int i11 = this.f20007d;
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                Intent intentU = com.google.android.play.core.appupdate.c.u(heyMelodyApplication, 1040);
                intentU.putExtra("param_address", str);
                intentU.putExtra("param_spine_range_status", i10);
                intentU.putExtra("param_spine_range_step", i11);
                com.google.android.play.core.appupdate.c.Q(heyMelodyApplication, intentU);
                return new q0(5L, TimeUnit.SECONDS);
            case 1:
                String str2 = (String) this.f20005b;
                int i12 = this.f20006c;
                int i13 = this.f20007d;
                HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
                Intent intentU2 = com.google.android.play.core.appupdate.c.u(heyMelodyApplication2, 1027);
                intentU2.putExtra("param_address", str2);
                intentU2.putExtra("param_hearing_type", 4);
                intentU2.putExtra("param_detect_status", i12);
                intentU2.putExtra("param_hearing_uid", i13);
                intentU2.putExtra("param_detect_value", 0);
                com.google.android.play.core.appupdate.c.Q(heyMelodyApplication2, intentU2);
                return new q0(5L, TimeUnit.SECONDS);
            case 2:
                StringBuilder sb2 = new StringBuilder("handleBinauralRecordConnectionStateChanged state = ");
                sb2.append(this.f20006c);
                sb2.append(", preState = ");
                sb2.append(this.f20007d);
                sb2.append(", address = ");
                A.a aVar = C1725a.f29476a;
                return C0625v.i((String) this.f20005b, sb2);
            default:
                int i14 = DiscoveryDialogActivity.f18836L0;
                return "moveToStateAsync ENTER " + ((I0) this.f20005b).f18928a + " viewFlags=" + this.f20006c + " traceHashCode:" + this.f20007d;
        }
    }

    public /* synthetic */ x(Object obj, int i10, int i11, int i12) {
        this.f20004a = i12;
        this.f20005b = obj;
        this.f20006c = i10;
        this.f20007d = i11;
    }
}
