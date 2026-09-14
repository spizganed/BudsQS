package com.oplus.melody.model.repository.earphone;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f19980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EarphoneStatusDO f19981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f19982d;

    public /* synthetic */ s(Integer num, EarphoneStatusDO earphoneStatusDO, String str, int i10) {
        this.f19979a = i10;
        this.f19980b = num;
        this.f19981c = earphoneStatusDO;
        this.f19982d = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f19979a) {
            case 0:
                return "onA2dpConnectChange newState=" + this.f19980b + " oldState=" + this.f19981c.getMA2dpConnectionState() + " mac=" + com.oplus.melody.common.util.A.r(this.f19982d);
            case 1:
                return "onHeadsetAclConnectChange newState=" + this.f19980b + " oldState=" + this.f19981c.getMAclConnectState() + " mac=" + com.oplus.melody.common.util.A.r(this.f19982d);
            default:
                return "onHeadsetConnectChange newState=" + this.f19980b + " oldState=" + this.f19981c.getMHeadsetConnectionState() + " mac=" + com.oplus.melody.common.util.A.r(this.f19982d);
        }
    }
}
