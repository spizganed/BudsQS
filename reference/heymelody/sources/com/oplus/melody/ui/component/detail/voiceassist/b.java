package com.oplus.melody.ui.component.detail.voiceassist;

import android.os.Bundle;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import java.util.function.Consumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f21354c;

    public /* synthetic */ b(int i10, Object obj, Object obj2) {
        this.f21352a = i10;
        this.f21353b = obj;
        this.f21354c = obj2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Object obj2 = this.f21354c;
        Object obj3 = this.f21353b;
        switch (this.f21352a) {
            case 0:
                c cVar = (c) obj3;
                cVar.getClass();
                if (((SetCommandStateDTO) obj).getSetCommandStatus() != 0) {
                    cVar.f21360F.setChecked(!((Boolean) obj2).booleanValue());
                    A.x("VoiceAssistFragment", "set voice wake failed");
                } else {
                    A.b("VoiceAssistFragment", "set voice wake succeed");
                }
                break;
            default:
                HearingEnhancementEntity hearingEnhancementEntity = (HearingEnhancementEntity) obj;
                int i10 = HearingEnhancementActivity.f21566m0;
                HearingEnhancementActivity hearingEnhancementActivity = (HearingEnhancementActivity) obj3;
                hearingEnhancementActivity.getClass();
                if (hearingEnhancementEntity != null) {
                    A.f("HearingEnhancementActivity", "getUsageEnhanceEntityFuture, addr: " + hearingEnhancementEntity.getAddress() + ", name: " + hearingEnhancementEntity.getName() + ", index: " + hearingEnhancementEntity.getLocalIndex());
                } else {
                    A.x("HearingEnhancementActivity", "getUsageEnhanceEntityFuture entity is null");
                }
                hearingEnhancementActivity.P((Bundle) obj2);
                break;
        }
    }
}
