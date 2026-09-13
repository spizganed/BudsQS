package com.oplus.melody.app.discovery;

import androidx.media3.exoplayer.C0625v;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0845e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19057b;

    public /* synthetic */ C0845e(String str, int i10) {
        this.f19056a = i10;
        this.f19057b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        String str = this.f19057b;
        switch (this.f19056a) {
            case 0:
                return "m_bt_bat.showBatteryViews BOX and one" + str;
            case 1:
                return "m_bt_bat.showBatteryViews none" + str;
            case 2:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return "dialogCancel " + str;
            case 3:
                int i11 = DiscoveryDialogActivity.f18836L0;
                return C0625v.i(str, new StringBuilder("setCurrentEarphone "));
            case 4:
                return C0625v.i(str, new StringBuilder("getDiscoveries: remove shared device from other, macAddress="));
            case 5:
                return "setActionFrom " + str;
            default:
                return "goGuideEntrance router GUIDE_ENTRANCE " + str;
        }
    }
}
