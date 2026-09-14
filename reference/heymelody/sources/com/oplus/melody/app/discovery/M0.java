package com.oplus.melody.app.discovery;

import com.oplus.melody.ui.widget.MelodyCompatTextView;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class M0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18975b;

    public /* synthetic */ M0(Object obj, int i10) {
        this.f18974a = i10;
        this.f18975b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f18974a) {
            case 0:
                Integer num = (Integer) obj;
                N0 n02 = (N0) this.f18975b;
                n02.getClass();
                com.oplus.melody.common.util.A.c("DiscoveryViewStateBindingImpl", new B(num, 1));
                int iIntValue = num.intValue();
                DiscoveryDialogActivity discoveryDialogActivity = n02.f18929b;
                discoveryDialogActivity.b0(iIntValue);
                if (num.intValue() == 4) {
                    discoveryDialogActivity.c0(3);
                    n02.j(6);
                } else if (num.intValue() != 5) {
                    discoveryDialogActivity.c0(5);
                    n02.q();
                } else {
                    discoveryDialogActivity.c0(3);
                    n02.q();
                }
                break;
            default:
                ((MelodyCompatTextView) this.f18975b).setText((String) obj);
                break;
        }
    }
}
