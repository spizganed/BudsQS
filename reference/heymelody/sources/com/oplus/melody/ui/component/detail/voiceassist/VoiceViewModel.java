package com.oplus.melody.ui.component.detail.voiceassist;

import D7.C0379m;
import androidx.lifecycle.t;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.base.BaseViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: VoiceViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\"\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\"\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0005J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0007J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J(\u0010\u0015\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "isVoiceAssistEnabled", "", "address", "", "setVoiceAssistEnable", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "enable", "setVoiceIncomingCallControlEnable", "setVoiceCommandEnable", "setSpeechPerceptionStatus", "getVoiceAssistStatus", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/ui/component/detail/voiceassist/VoiceAssistVO;", "macAddress", "getConnectionState", "", "setMultiConversationSwitch", "", "open", "isPhoneFullDuplex", "updateDB", "isMultiConversationEnable", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class VoiceViewModel extends BaseViewModel {
    public static t d(String macAddress) {
        kotlin.jvm.internal.h.e(macAddress, "macAddress");
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new androidx.appcompat.widget.a(24)));
    }
}
