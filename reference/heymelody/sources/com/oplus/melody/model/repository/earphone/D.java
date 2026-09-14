package com.oplus.melody.model.repository.earphone;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class D implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19868b;

    public /* synthetic */ D(String str, int i10) {
        this.f19867a = i10;
        this.f19868b = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19867a) {
            case 0:
                return "refreshBondDevices ignore from " + this.f19868b;
            case 1:
                return " rlm spp earphone reset colorId 0 , prdId = " + this.f19868b;
            case 2:
                return "addSoundDownLoadListener already completed! resIdStr = " + this.f19868b;
            case 3:
                return t8.q.c("melody-model-zen2").getString(com.oplus.melody.model.repository.zenmode.s.F("active", this.f19868b), null);
            case 4:
                return "getSceneListV2 REMOTE START " + this.f19868b;
            case 5:
                return "removeSoundDownLoadListener resIdStr = " + this.f19868b;
            case 6:
                return "requestPicUrls: already contained key=" + this.f19868b;
            case 7:
                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(this.f19868b);
                if (earphoneDTOW != null) {
                    return earphoneDTOW.getEarStatus();
                }
                return null;
            case 8:
                return g0.f.b(this.f19868b, " start", new StringBuilder());
            case 9:
                return "processWhitelistContent: add " + this.f19868b;
            case 10:
                return "isHeaderTrackerMode: " + this.f19868b;
            case 11:
                return A6.g.f("exitApp address:", com.oplus.melody.common.util.A.r(this.f19868b), " exit game eq");
            case 12:
                return A6.g.f("enterApp address:", com.oplus.melody.common.util.A.r(this.f19868b), " enter game eq");
            default:
                return "mAppListener onAppEnter:" + this.f19868b;
        }
    }
}
