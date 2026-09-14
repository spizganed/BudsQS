package com.oplus.melody.ui.component.detail.opsreduction;

import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.NoiseReductionInfoDTO;
import java.util.ArrayList;
import java.util.List;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: OpsReductionVO.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.oplus.melody.common.data.a {
    private int mConnectionState;
    private int mCurrentNoiseReductionModeIndex;
    private List<WhitelistConfigDTO.NoiseReductionMode> mNoiseReductionModeList;
    private NoiseReductionInfoDTO mSupportNoiseReductionInfo;
    private NoiseReductionInfoDTO mSwitchNoiseReductionInfo;

    public a(EarphoneDTO earphoneDTO) {
        WhitelistConfigDTO.Function function;
        this.mCurrentNoiseReductionModeIndex = -1;
        this.mConnectionState = 0;
        this.mNoiseReductionModeList = new ArrayList();
        this.mSupportNoiseReductionInfo = null;
        this.mCurrentNoiseReductionModeIndex = earphoneDTO.getNoiseReductionModeIndex();
        this.mSwitchNoiseReductionInfo = earphoneDTO.getSwitchNoiseReductionInfo();
        this.mConnectionState = earphoneDTO.getConnectionState();
        this.mSupportNoiseReductionInfo = earphoneDTO.getSupportNoiseReductionInfo();
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(earphoneDTO.getProductId(), earphoneDTO.getName());
        if (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) {
            return;
        }
        this.mNoiseReductionModeList = function.getNoiseReductionMode();
    }

    public int getConnectionState() {
        return this.mConnectionState;
    }

    public int getCurrentNoiseReductionModeIndex() {
        return this.mCurrentNoiseReductionModeIndex;
    }

    public List<WhitelistConfigDTO.NoiseReductionMode> getNoiseReductionModeList() {
        return this.mNoiseReductionModeList;
    }

    public NoiseReductionInfoDTO getSupportNoiseReductionInfo() {
        return this.mSupportNoiseReductionInfo;
    }

    public NoiseReductionInfoDTO getSwitchNoiseReductionInfo() {
        return this.mSwitchNoiseReductionInfo;
    }
}
