package com.oplus.melody.model.db;

import q1.InterfaceC1431a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HearingEnhancementDao_Impl f19787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HearingEnhancementEntity f19788c;

    public /* synthetic */ t(HearingEnhancementDao_Impl hearingEnhancementDao_Impl, HearingEnhancementEntity hearingEnhancementEntity, int i10) {
        this.f19786a = i10;
        this.f19787b = hearingEnhancementDao_Impl;
        this.f19788c = hearingEnhancementEntity;
    }

    @Override // Wb.l
    public final Object d(Object obj) {
        switch (this.f19786a) {
            case 0:
                return Integer.valueOf(super/*com.oplus.melody.model.db.HearingEnhancementDao*/.e(this.f19788c));
            default:
                return Integer.valueOf(this.f19787b.f19690c.i((InterfaceC1431a) obj, this.f19788c));
        }
    }
}
