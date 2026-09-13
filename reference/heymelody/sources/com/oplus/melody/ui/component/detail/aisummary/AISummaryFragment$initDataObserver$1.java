package com.oplus.melody.ui.component.detail.aisummary;

import A9.s;
import D7.o0;
import P8.b;
import P8.d;
import Wb.l;
import androidx.fragment.app.f;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.melody.common.util.A;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: AISummaryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class AISummaryFragment$initDataObserver$1 extends FunctionReferenceImpl implements l<d, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(d dVar) {
        f activity;
        d p02 = dVar;
        h.e(p02, "p0");
        AISummaryFragment aISummaryFragment = (AISummaryFragment) this.receiver;
        aISummaryFragment.getClass();
        A.c("AISummaryFragment", new B6.a(p02, 20));
        COUISwitchPreference cOUISwitchPreference = aISummaryFragment.f20623z;
        if (cOUISwitchPreference == null) {
            h.i("mAISummarySwitchPreference");
            throw null;
        }
        cOUISwitchPreference.setEnabled(p02.getConnected());
        COUIPreference cOUIPreference = aISummaryFragment.f20616A;
        if (cOUIPreference == null) {
            h.i("mMoreSettingPreference");
            throw null;
        }
        cOUIPreference.setEnabled(p02.getConnected());
        if (p02.getConnected()) {
            CompletableFuture.supplyAsync(new P8.a(aISummaryFragment, 1)).whenCompleteAsync((BiConsumer) new s(new b(0, aISummaryFragment, p02), 16), (Executor) o0.c.f1144b);
        } else {
            A.x("AISummaryFragment", "onAISummaryStateChanged not connected");
            String str = aISummaryFragment.f20621F;
            if (str == null) {
                h.i("mActionFrom");
                throw null;
            }
            if (str.equals("DetailMainFragment") && (activity = aISummaryFragment.getActivity()) != null) {
                activity.finish();
            }
        }
        return Jb.l.f2618a;
    }
}
