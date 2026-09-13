package com.oplus.melody.ui.component.detail.voiceassist;

import com.oplus.melody.model.repository.earphone.EarphoneDTO;

/* JADX INFO: compiled from: VoiceAssistVO.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends com.oplus.melody.common.data.a {
    private final String mAddress;
    private final boolean mConnected;
    private final boolean mIncomingCallControlEnable;
    private final boolean mVoiceAssistEnable;
    private final boolean mVoiceCommandEnable;

    public m(EarphoneDTO earphoneDTO) {
        this.mAddress = earphoneDTO.getMacAddress();
        this.mConnected = earphoneDTO.getConnectionState() == 2;
        this.mVoiceAssistEnable = earphoneDTO.getVoiceAssistStatus() == 1;
        this.mVoiceCommandEnable = earphoneDTO.getVoiceCommandStatus() == 1;
        this.mIncomingCallControlEnable = earphoneDTO.getVoiceIncomingCallControlStatus() == 1;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public boolean isIncomingCallControlEnable() {
        return this.mIncomingCallControlEnable;
    }

    public boolean isVoiceAssistEnable() {
        return this.mVoiceAssistEnable;
    }

    public boolean isVoiceCommandEnable() {
        return this.mVoiceCommandEnable;
    }
}
