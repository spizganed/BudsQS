package com.oplus.melody.app.discovery;

import D7.C0379m;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.oplus.melody.app.discovery.DiscoveryDialogViewModel;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.r0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0878r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19184c;

    public /* synthetic */ RunnableC0878r0(int i10, Object obj, Object obj2) {
        this.f19182a = i10;
        this.f19183b = obj;
        this.f19184c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<Integer> dialogTags;
        G0.c cVar;
        View viewG;
        WhitelistConfigDTO.Function function;
        String id;
        switch (this.f19182a) {
            case 0:
                ((DiscoveryDialogViewModel.a) this.f19183b).a((Function) this.f19184c);
                break;
            case 1:
                C0850f1 c0850f1 = (C0850f1) this.f19183b;
                c0850f1.getClass();
                E0 e02 = (E0) this.f19184c;
                WhitelistConfigDTO whitelistConfigDTOE = I0.e(e02);
                DiscoveryDialogActivity discoveryDialogActivity = c0850f1.f18929b;
                if (whitelistConfigDTOE == null || (function = whitelistConfigDTOE.getFunction()) == null) {
                    dialogTags = null;
                } else {
                    dialogTags = function.getDialogTags();
                    if (dialogTags != null && dialogTags.contains(1) && (id = e02.getId()) != null && c0850f1.f19084o.add(id)) {
                        C0379m.b(C0379m.g(AbstractC0939b.E().v(id), new Z0())).e(discoveryDialogActivity, new Y0(c0850f1, 0));
                        AbstractC0939b.E().t(id);
                    }
                }
                if (com.oplus.melody.common.util.A.l()) {
                    com.oplus.melody.common.util.A.b("DiscoveryViewStateConnectedImpl", "loadTags " + dialogTags);
                }
                ArrayList arrayList = new ArrayList(3);
                if (c0850f1.f19074J) {
                    arrayList.add(c0850f1.f18931d);
                }
                arrayList.addAll(c0850f1.u());
                J6.d.f(1, 0, (View[]) arrayList.toArray(new View[0]));
                if (c0850f1.f19076L == 4 && (cVar = c0850f1.f19081Q) != null && (viewG = cVar.g()) != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewG.getLayoutParams();
                    if (c0850f1.f19077M < 0) {
                        c0850f1.f19077M = marginLayoutParams.bottomMargin;
                    }
                    MelodyCompatTextView melodyCompatTextView = c0850f1.f18932e;
                    if (melodyCompatTextView.getVisibility() == 8 || TextUtils.isEmpty(melodyCompatTextView.getText())) {
                        marginLayoutParams.bottomMargin = c0850f1.f19077M;
                        viewG.setLayoutParams(marginLayoutParams);
                    } else {
                        int i10 = (int) ((discoveryDialogActivity.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
                        marginLayoutParams.bottomMargin = c0850f1.f19077M + i10;
                        viewG.setLayoutParams(marginLayoutParams);
                        com.oplus.melody.common.util.A.c("DiscoveryViewStateConnectedImpl", new Ba.b(i10, 25));
                    }
                    break;
                }
                break;
            default:
                ((z1) this.f19183b).m((C1) this.f19184c, true);
                break;
        }
    }
}
