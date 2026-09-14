package com.heytap.headset.component.mydevicelist;

import A9.j;
import D7.C0379m;
import O7.l;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.oplus.melody.ui.base.BaseViewModel;
import e4.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import m4.f;

/* JADX INFO: compiled from: MyDeviceCardListViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/heytap/headset/component/mydevicelist/MyDeviceCardListViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "deviceItemMapLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "", "", "Lcom/heytap/headset/component/mydevicelist/MyDeviceItemVO;", "mRuntimePermissionAlert", "Lcom/heytap/headset/widget/RuntimePermissionAlert;", "initRuntimePermissionAlert", "", "activity", "Landroidx/activity/ComponentActivity;", "checkScanDeviceLocationPermission", "", "requestPermission", "(Z)Ljava/lang/Boolean;", "getDeviceItemMap", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "createItemVO", "deviceInfo", "Lcom/heytap/headset/repository/devicecard/DeviceCardDTO;", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MyDeviceCardListViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l<Map<String, V3.a>> f17414b = new l<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f17415c;

    /* JADX INFO: compiled from: MyDeviceCardListViewModel.kt */
    public static final class a implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f17416a;

        public a(j jVar) {
            this.f17416a = jVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f17416a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f17416a.d(obj);
        }
    }

    public final t d(InterfaceC0601m interfaceC0601m) {
        e.f22900c.getClass();
        C0379m.b(e.f22901p).e(interfaceC0601m, new a(new j(this, 17)));
        return C0379m.b(this.f17414b);
    }
}
