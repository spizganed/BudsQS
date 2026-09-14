package com.oplus.melody.app.discovery;

import androidx.media3.exoplayer.C0625v;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0839c implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19045b;

    public /* synthetic */ C0839c(String str, int i10) {
        this.f19044a = i10;
        this.f19045b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19044a) {
            case 0:
                return "m_bt_bat.showBatteryViews single" + this.f19045b;
            case 1:
                return "m_bt_bat.showBatteryViews TWO" + this.f19045b;
            case 2:
                return C0625v.i(this.f19045b, new StringBuilder("preloadActiveEarphone "));
            case 3:
                return C0625v.i(this.f19045b, new StringBuilder("performShareAudio "));
            case 4:
                return C0625v.i(this.f19045b, new StringBuilder("performShareAudio "));
            default:
                return "showBackgroundMask maskColor:" + this.f19045b;
        }
    }
}
