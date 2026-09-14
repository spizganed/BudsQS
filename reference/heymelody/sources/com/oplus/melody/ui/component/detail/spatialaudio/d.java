package com.oplus.melody.ui.component.detail.spatialaudio;

import Ea.C0406o;
import Ea.DialogInterfaceOnClickListenerC0412v;
import Jb.l;
import O9.i;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.f;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.spatialaudio.BaseSpatialAudioVM;
import com.oplus.melody.ui.component.detail.spatialaudio.d;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpatialAudioHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f21291a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f21292b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f21293c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BaseSpatialAudioVM f21294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static f f21295e;

    /* JADX INFO: compiled from: SpatialAudioHelper.kt */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: SpatialAudioHelper.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f21296a;

        public b(i iVar) {
            this.f21296a = iVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21296a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Exception {
            this.f21296a.d(obj);
        }
    }

    public static void a(Context context, final String address, final boolean z2, final a aVar) {
        h.e(context, "context");
        h.e(address, "address");
        A.f("SpatialAudioHelper", "dealSwitchNoticeDialog, address: " + address + ", switchSpatial: " + z2);
        if (f21295e == null) {
            G7.b bVar = new G7.b(context);
            bVar.l(R.string.melody_ui_multi_devices_dialog_open, new DialogInterface.OnClickListener() { // from class: R9.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    androidx.appcompat.app.f fVar = com.oplus.melody.ui.component.detail.spatialaudio.d.f21295e;
                    if (fVar != null) {
                        fVar.dismiss();
                    }
                    com.oplus.melody.ui.component.detail.spatialaudio.d.f21295e = null;
                    StringBuilder sb2 = new StringBuilder("dealSwitchNoticeDialog, address: ");
                    String str = address;
                    sb2.append(str);
                    sb2.append(", callBack: ");
                    d.a aVar2 = aVar;
                    sb2.append(aVar2);
                    A.f("SpatialAudioHelper", sb2.toString());
                    com.oplus.melody.ui.component.detail.spatialaudio.d dVar = com.oplus.melody.ui.component.detail.spatialaudio.d.f21291a;
                    boolean z4 = z2;
                    if (z4) {
                        dVar.getClass();
                        if (com.oplus.melody.ui.component.detail.spatialaudio.d.c(str)) {
                            aVar2.b();
                            return;
                        }
                    }
                    if (z4) {
                        return;
                    }
                    dVar.getClass();
                    if (com.oplus.melody.ui.component.detail.spatialaudio.d.b(str)) {
                        BaseSpatialAudioVM baseSpatialAudioVM = com.oplus.melody.ui.component.detail.spatialaudio.d.f21294d;
                        if (baseSpatialAudioVM == null) {
                            kotlin.jvm.internal.h.i("spatialAudioViewModel");
                            throw null;
                        }
                        CompletableFuture<SetCommandStateDTO> completableFutureG = baseSpatialAudioVM.g(0, str);
                        if (completableFutureG != null) {
                            completableFutureG.whenComplete((BiConsumer<? super SetCommandStateDTO, ? super Throwable>) new A9.c(new C0406o(aVar2, 2), 5));
                        }
                    }
                }
            });
            bVar.h(R.string.melody_ui_common_cancel, new DialogInterfaceOnClickListenerC0412v(aVar, 4));
            f21295e = bVar.setCancelable(false).create();
            l lVar = l.f2618a;
        }
        int i10 = z2 ? R.string.melody_ui_open_spatial_audio_confirm : R.string.melody_ui_open_hi_res_confirm;
        String string = z2 ? context.getResources().getString(R.string.melody_ui_open_spatial_audio_content) : context.getResources().getString(R.string.melody_ui_open_hi_res_content);
        h.b(string);
        f fVar = f21295e;
        if (fVar != null) {
            fVar.setTitle(i10);
        }
        f fVar2 = f21295e;
        if (fVar2 != null) {
            fVar2.e(string);
        }
        f fVar3 = f21295e;
        if (fVar3 != null) {
            fVar3.show();
        }
    }

    public static boolean b(String str) {
        Integer num;
        if (!t8.v.b(str) && (num = f21293c.get(str)) != null && num.intValue() > 0) {
            Boolean bool = f21292b.get(str);
            if (bool != null ? bool.booleanValue() : false) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str);
        boolean z2 = false;
        if (earphoneDTOW != null) {
            if (earphoneDTOW.getHighToneQualityStatus() == 1) {
                Boolean bool = f21292b.get(str);
                if (bool != null ? bool.booleanValue() : false) {
                    z2 = true;
                }
            }
            A.f("SpatialAudioHelper", "isHiResModeOpen, address: " + str + ", isOpen: " + z2 + ", highToneStatus: " + earphoneDTOW.getHighToneQualityStatus());
        }
        return z2;
    }
}
