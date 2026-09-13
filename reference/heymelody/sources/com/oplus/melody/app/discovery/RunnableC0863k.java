package com.oplus.melody.app.discovery;

import F8.i;
import android.view.View;
import android.widget.ImageView;
import com.oplus.melody.track.constant.AppConstant$UserAction;
import java.util.List;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0863k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f19123c;

    public /* synthetic */ RunnableC0863k(Object obj, View view, int i10) {
        this.f19121a = i10;
        this.f19122b = obj;
        this.f19123c = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f19123c;
        Object obj = this.f19122b;
        switch (this.f19121a) {
            case 0:
                int i10 = DiscoveryDialogActivity.f18836L0;
                DiscoveryDialogActivity discoveryDialogActivity = (DiscoveryDialogActivity) obj;
                if (!discoveryDialogActivity.U()) {
                    discoveryDialogActivity.f18846J0 = false;
                    discoveryDialogActivity.f18847K0 = false;
                    ImageView imageView = (ImageView) view;
                    imageView.setVisibility(4);
                    imageView.setTranslationY(0.0f);
                    break;
                }
                break;
            default:
                C0850f1 c0850f1 = (C0850f1) obj;
                c0850f1.getClass();
                com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "onClick settingBtn");
                E0 e0D = c0850f1.d();
                if (e0D != null) {
                    DiscoveryDialogActivity discoveryDialogActivity2 = c0850f1.f18929b;
                    discoveryDialogActivity2.L();
                    if (com.oplus.melody.common.util.Y.j(I0.e(e0D))) {
                        com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "startRLMLinkActivity");
                        P7.a.a(view.getContext(), e0D.getId());
                    } else {
                        E8.a.w().getClass();
                        Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                        F8.i iVarA = i.a.a("/ui/detail");
                        iVarA.f("route_from", "DiscoveryViewStateConnectedImpl");
                        iVarA.f("device_mac_info", e0D.getId());
                        iVarA.f("device_name", e0D.getName());
                        iVarA.a(1);
                        iVarA.b(view.getContext());
                    }
                    discoveryDialogActivity2.R();
                }
                c0850f1.n(AppConstant$UserAction.ACTION_GO_SETTINGS);
                break;
        }
    }
}
