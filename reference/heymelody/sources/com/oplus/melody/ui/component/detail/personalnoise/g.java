package com.oplus.melody.ui.component.detail.personalnoise;

import com.oplus.melody.model.repository.earphone.EarphoneDTO;

/* JADX INFO: compiled from: PersonalNoiseStatusVO.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends com.oplus.melody.common.data.a {
    private final String mAddress;
    private final boolean mPersonalNoiseStatusOn;

    public g(EarphoneDTO earphoneDTO) {
        this.mAddress = earphoneDTO.getMacAddress();
        this.mPersonalNoiseStatusOn = earphoneDTO.getPersonalNoiseStatus() == 1;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public boolean isPersonalNoiseStatusOn() {
        return this.mPersonalNoiseStatusOn;
    }
}
