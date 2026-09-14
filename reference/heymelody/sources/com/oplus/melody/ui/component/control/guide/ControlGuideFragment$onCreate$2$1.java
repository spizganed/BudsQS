package com.oplus.melody.ui.component.control.guide;

import D7.o0;
import E9.t;
import Ea.C0404m;
import I8.C0425a;
import J8.c;
import Wb.l;
import android.os.Handler;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.UserInteractionDTO;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: ControlGuideFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class ControlGuideFragment$onCreate$2$1 extends FunctionReferenceImpl implements l<UserInteractionDTO, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(UserInteractionDTO userInteractionDTO) {
        final UserInteractionDTO p02 = userInteractionDTO;
        h.e(p02, "p0");
        ControlGuideFragment controlGuideFragment = (ControlGuideFragment) this.receiver;
        if (!controlGuideFragment.f20474I) {
            A.b("ControlGuideFragment", "onCommandInvoked not GuideMode return");
        } else if (p02.getAction() <= 0) {
            A.c("ControlGuideFragment", new B6.a(p02, 15));
        } else if ((h.a(controlGuideFragment.f20469C, "050C10") || h.a(controlGuideFragment.f20469C, "050C14")) && p02.getFunction() != 21) {
            A.c("ControlGuideFragment", new C0404m(p02, 10));
        } else {
            c cVar = controlGuideFragment.f20484v;
            if (cVar == null) {
                h.i("mGuidePageStatus");
                throw null;
            }
            final int i10 = cVar.f2595c;
            final int i11 = cVar.f2596d;
            final int i12 = cVar.f2597e;
            final int i13 = cVar.f2598f;
            final int i14 = 1;
            if (i10 == p02.getAction() && i13 == p02.getButton() && (i11 == 4 || i11 == p02.getDeviceType())) {
                i14 = 0;
            }
            A.c("ControlGuideFragment", new Supplier() { // from class: I8.g
                @Override // java.util.function.Supplier
                public final Object get() {
                    return "onCommandInvoked: " + p02 + " requiredAction:" + i10 + " requiredButton:" + i13 + " requiredDeviceType:" + i11 + " requiredOperation:" + i12 + " isCommandRight:" + i14;
                }
            });
            S.z(controlGuideFragment.getActivity());
            Handler handler = o0.c.f1143a;
            t tVar = controlGuideFragment.f20477L;
            handler.removeCallbacks(tVar);
            handler.postDelayed(tVar, 120000L);
            ControlGuideViewModel controlGuideViewModel = controlGuideFragment.f20482t;
            if (controlGuideViewModel == null) {
                h.i("mControlGuideVM");
                throw null;
            }
            controlGuideViewModel.f20498g.m(new C0425a(controlGuideViewModel.f20500j, i12, i14));
        }
        return Jb.l.f2618a;
    }
}
