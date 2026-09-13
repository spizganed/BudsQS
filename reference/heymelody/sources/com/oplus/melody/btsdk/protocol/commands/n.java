package com.oplus.melody.btsdk.protocol.commands;

import D7.C0391z;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentProviderClient;
import b9.C0738g;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.J;
import com.oplus.melody.model.db.C0928l;
import com.oplus.melody.ui.component.tutorialguide.AuditionPreviewView;
import e4.C1008a;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import t8.C1533a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19327a;

    public /* synthetic */ n(int i10) {
        this.f19327a = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Throwable th;
        boolean z2 = false;
        switch (this.f19327a) {
            case 0:
                return A6.g.d(1044, new StringBuilder("setFreeDialogRecoveryTime UNSUPPORTED cmd=0x"));
            case 1:
                return A6.g.d(1048, new StringBuilder("setEqInfo UNSUPPORTED cmd=0x"));
            case 2:
                if (C0391z.f1171d.l() && t8.q.j()) {
                    return (Set) ((Set) Optional.ofNullable(BluetoothAdapter.getDefaultAdapter()).map(new C0738g(25)).orElse(Collections.EMPTY_SET)).stream().map(new C0928l(17)).collect(Collectors.toSet());
                }
                throw MelodyException.e(0, "refreshBondDevices no permission");
            case 3:
                C1533a.a(C0906l.f19501a);
                A.h("EarphoneRepository", "checkTriplePinch callSummary not support any summary");
                return Boolean.FALSE;
            case 4:
                List<C1008a> listD = e4.e.f22901p.d();
                if (listD != null && !listD.isEmpty()) {
                    try {
                        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                        if (heyMelodyApplication == null) {
                            kotlin.jvm.internal.h.i("context");
                            throw null;
                        }
                        contentProviderClientAcquireUnstableContentProviderClient = heyMelodyApplication.getContentResolver().acquireUnstableContentProviderClient(e4.e.f22903r);
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            try {
                                contentProviderClientAcquireUnstableContentProviderClient.call("melody_method_request_uri_permission", null, null);
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    A.i("DevicesCardRepository", "checkRequestUriPermission", th);
                                } finally {
                                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    }
                                }
                            }
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        z2 = true;
                    } catch (Throwable th3) {
                        contentProviderClientAcquireUnstableContentProviderClient = null;
                        th = th3;
                    }
                }
                return Boolean.valueOf(z2);
            case 5:
                return "onChange. isMelodyStatementAccepted = " + e4.e.f22908w;
            case 6:
                return "requestPermissions mNotificationPreShouldShowRationale = " + m4.f.f26309z + ", mNotificationPostShouldShowRationale = " + m4.f.f26301A;
            case 7:
                return "m_spp_le.createSocket, mSocket != null";
            default:
                int i10 = AuditionPreviewView.f21644B;
                return A6.b.d(J.a.f19444a.f19443b, "updatePreviewView, MediaPlayer stop, playState = ");
        }
    }
}
