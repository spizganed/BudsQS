package com.oplus.melody.app.discovery;

import com.oplus.melody.model.net.data.ZenModeInfoDO;
import java.util.function.BiConsumer;
import u8.C1557e;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0893z implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f19237d;

    public /* synthetic */ C0893z(Object obj, Object obj2, Object obj3, int i10) {
        this.f19234a = i10;
        this.f19235b = obj;
        this.f19236c = obj2;
        this.f19237d = obj3;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Object obj3 = this.f19237d;
        Object obj4 = this.f19236c;
        Object obj5 = this.f19235b;
        switch (this.f19234a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                ((DiscoveryDialogActivity) obj5).X((C1) obj4, (C1557e) obj3);
                break;
            default:
                ZenModeInfoDO zenModeInfoDO = (ZenModeInfoDO) obj;
                Throwable th = (Throwable) obj2;
                com.oplus.melody.model.repository.zenmode.s sVar = (com.oplus.melody.model.repository.zenmode.s) obj5;
                sVar.getClass();
                String str = (String) obj4;
                String str2 = (String) obj3;
                if (zenModeInfoDO != null && th == null) {
                    sVar.A(str, zenModeInfoDO, str2);
                } else {
                    sVar.C(str, str2);
                }
                break;
        }
    }
}
