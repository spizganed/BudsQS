package com.heytap.headset.component.keepaliveguide;

import O7.l;
import com.oplus.melody.ui.base.BaseViewModel;
import g4.C1069a;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeepAliveGuideViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016J\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00130\u0011J\u0006\u0010\u0018\u001a\u00020\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/heytap/headset/component/keepaliveguide/KeepAliveGuideViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "rootPath", "", "phoneConfigs", "", "Lcom/heytap/headset/repository/keepalive/KeepAliveGuideConfigDTO$PhoneConfig;", "value", "brand", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "phoneConfigList", "phoneConfigLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "supportedBrandMapLiveData", "", "getRootPath", "getPhoneConfigLiveData", "Landroidx/lifecycle/LiveData;", "getSupportedBrandMapLiveData", "loadConfig", "", "initKeepAliveGuideConfig", "Ljava/util/concurrent/CompletableFuture;", "", "updatePhoneConfig", "updateSupportedBrandMap", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveGuideViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f17409c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f17410d = "other";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f17411e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l<C1069a.b> f17412f = new l<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l<Map<String, String>> f17413g = new l<>();

    public final void d() {
        ArrayList arrayList = this.f17411e;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        C1069a.b bVar = null;
        int i10 = 0;
        while (true) {
            l<C1069a.b> lVar = this.f17412f;
            if (i10 >= size) {
                lVar.m(bVar);
                return;
            }
            Object obj = arrayList.get(i10);
            i10++;
            C1069a.b bVar2 = (C1069a.b) obj;
            if (ec.l.D(this.f17410d, bVar2.getBrand(), true)) {
                lVar.m(bVar2);
                return;
            } else if ("other".equalsIgnoreCase(bVar2.getBrand())) {
                bVar = bVar2;
            }
        }
    }
}
