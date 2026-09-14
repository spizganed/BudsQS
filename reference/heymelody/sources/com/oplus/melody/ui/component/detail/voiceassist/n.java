package com.oplus.melody.ui.component.detail.voiceassist;

import Wb.p;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import hc.r;
import java.util.List;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f21387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f21388c;

    public /* synthetic */ n(Object obj, boolean z2, int i10) {
        this.f21386a = i10;
        this.f21388c = obj;
        this.f21387b = z2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, kotlin.coroutines.d] */
    @Override // Wb.p
    public final Object invoke(Object obj, Object obj2) {
        boolean z2 = this.f21387b;
        Object obj3 = this.f21388c;
        switch (this.f21386a) {
            case 0:
                SetCommandStateDTO setCommandStateDTO = (SetCommandStateDTO) obj;
                Throwable th = (Throwable) obj2;
                List<Integer> list = VoiceCommandFragment.H;
                if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
                    A.i("VoiceCommandFragment", "setVoiceCommandEnable, error", th);
                    COUISwitchPreference cOUISwitchPreference = ((VoiceCommandFragment) obj3).f21340B;
                    if (cOUISwitchPreference != null) {
                        cOUISwitchPreference.setChecked(!z2);
                    }
                } else {
                    A.b("VoiceCommandFragment", "setVoiceCommandEnable, succeed");
                }
                return Jb.l.f2618a;
            default:
                kotlin.coroutines.d dVar = (kotlin.coroutines.d) obj;
                d.a aVar = (d.a) obj2;
                if (!(aVar instanceof r)) {
                    return dVar.A(aVar);
                }
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj3;
                if (((kotlin.coroutines.d) ref$ObjectRef.element).u(aVar.getKey()) != null) {
                    ref$ObjectRef.element = ((kotlin.coroutines.d) ref$ObjectRef.element).p0(aVar.getKey());
                    return dVar.A(((r) aVar).g0());
                }
                r rVarC = (r) aVar;
                if (z2) {
                    rVarC = rVarC.C();
                }
                return dVar.A(rVarC);
        }
    }
}
