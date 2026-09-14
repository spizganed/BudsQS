package com.oplus.melody.ui.component.control.guide;

import Ea.W;
import I8.A;
import I8.C0426b;
import J8.c;
import Kb.m;
import Wb.l;
import androidx.fragment.app.f;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.KeyFunctionInfoDTO;
import com.oplus.melody.ui.component.control.guide.ControlGuideFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import u8.C1559g;

/* JADX INFO: compiled from: ControlGuideFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class ControlGuideFragment$initView$3 extends FunctionReferenceImpl implements l<C0426b, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(C0426b c0426b) {
        KeyFunctionInfoDTO keyFunctionInfoDTO;
        C0426b c0426b2 = c0426b;
        ControlGuideFragment controlGuideFragment = (ControlGuideFragment) this.receiver;
        controlGuideFragment.getClass();
        controlGuideFragment.f20476K = (c0426b2 != null ? c0426b2.getPairDeviceGuide() : null) != null;
        if ((c0426b2 != null ? c0426b2.getControlPages() : null) != null) {
            List<I8.l> controlPages = c0426b2.getControlPages();
            h.d(controlPages, "getControlPages(...)");
            ArrayList arrayList = new ArrayList(m.i(controlPages));
            for (I8.l lVar : controlPages) {
                C1559g animation = lVar.getAnimation();
                h.d(animation, "getAnimation(...)");
                String title = lVar.getTitle();
                h.d(title, "getTitle(...)");
                String title2 = lVar.getTitle();
                h.d(title2, "getTitle(...)");
                String intro = lVar.getIntro();
                h.d(intro, "getIntro(...)");
                String guideHint = lVar.getGuideHint();
                h.d(guideHint, "getGuideHint(...)");
                arrayList.add(new A(animation, title, title2, intro, guideHint));
            }
            ControlGuideFragment.a aVar = controlGuideFragment.f20480r;
            if (aVar == null) {
                h.i("mPageAdapter");
                throw null;
            }
            String rootPath = c0426b2.getRootPath();
            h.d(rootPath, "getRootPath(...)");
            aVar.f1907a = arrayList;
            aVar.f20489b = rootPath;
            aVar.notifyDataSetChanged();
            c cVar = controlGuideFragment.f20484v;
            if (cVar == null) {
                h.i("mGuidePageStatus");
                throw null;
            }
            cVar.f2601j = c0426b2;
            int i10 = cVar.f2593a.f20500j;
            Integer numDecode = Integer.decode(c0426b2.getControlPages().get(i10).getAction());
            h.d(numDecode, "decode(...)");
            cVar.f2595c = numDecode.intValue();
            C0426b c0426b3 = cVar.f2601j;
            if (c0426b3 == null) {
                h.i("mGuideVO");
                throw null;
            }
            Integer numDecode2 = Integer.decode(c0426b3.getControlPages().get(i10).getEarType());
            h.d(numDecode2, "decode(...)");
            cVar.f2596d = numDecode2.intValue();
            C0426b c0426b4 = cVar.f2601j;
            if (c0426b4 == null) {
                h.i("mGuideVO");
                throw null;
            }
            cVar.f2597e = c0426b4.getControlPages().get(i10).getGuideStepCode();
            C0426b c0426b5 = cVar.f2601j;
            if (c0426b5 == null) {
                h.i("mGuideVO");
                throw null;
            }
            cVar.f2598f = c0426b5.getControlPages().get(i10).getButton();
            C0426b c0426b6 = cVar.f2601j;
            if (c0426b6 == null) {
                h.i("mGuideVO");
                throw null;
            }
            cVar.f2599g = c0426b6.getControlPages().size();
            cVar.f2594b.post(new W(cVar, i10, 2));
            List<I8.l> controlPages2 = c0426b2.getControlPages();
            h.d(controlPages2, "getControlPages(...)");
            ArrayList arrayList2 = new ArrayList(m.i(controlPages2));
            for (I8.l lVar2 : controlPages2) {
                Integer numDecode3 = Integer.decode(lVar2.getFunction());
                if (numDecode3 != null && numDecode3.intValue() == -1) {
                    keyFunctionInfoDTO = null;
                } else {
                    Integer numDecode4 = Integer.decode(lVar2.getEarType());
                    h.d(numDecode4, "decode(...)");
                    int iIntValue = numDecode4.intValue();
                    int button = lVar2.getButton();
                    Integer numDecode5 = Integer.decode(lVar2.getAction());
                    h.d(numDecode5, "decode(...)");
                    int iIntValue2 = numDecode5.intValue();
                    h.b(numDecode3);
                    keyFunctionInfoDTO = new KeyFunctionInfoDTO(iIntValue, button, iIntValue2, numDecode3.intValue());
                }
                arrayList2.add(keyFunctionInfoDTO);
            }
            if (controlGuideFragment.f20482t == null) {
                h.i("mControlGuideVM");
                throw null;
            }
            f fVar = controlGuideFragment.f20478p;
            h.b(fVar);
            AbstractC0939b.E().u0(controlGuideFragment.f20467A, fVar, arrayList2, 1046);
        }
        return Jb.l.f2618a;
    }
}
