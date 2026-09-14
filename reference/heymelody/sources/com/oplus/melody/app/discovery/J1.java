package com.oplus.melody.app.discovery;

import android.view.View;
import android.view.ViewGroup;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class J1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f18951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f18952d;

    public /* synthetic */ J1(Object obj, int i10, int i11, int i12) {
        this.f18949a = i12;
        this.f18950b = i10;
        this.f18951c = i11;
        this.f18952d = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        ViewGroup.LayoutParams layoutParams;
        switch (this.f18949a) {
            case 0:
                View view = (View) this.f18952d;
                return "bottomSheetBottomMargin:" + this.f18950b + " coordinatorHeight:" + this.f18951c + " coordinatorParamsHeight:" + ((view == null || (layoutParams = view.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.height));
            default:
                StringBuilder sb2 = new StringBuilder("onResponseCommandEvent, status: ");
                sb2.append(this.f18950b);
                sb2.append(", eventCode: ");
                sb2.append(this.f18951c);
                sb2.append(", rspData: ");
                String strE = E8.a.e((byte[]) this.f18952d);
                sb2.append(strE == null ? null : new String(E8.a.B(strE), StandardCharsets.UTF_8));
                return sb2.toString();
        }
    }
}
