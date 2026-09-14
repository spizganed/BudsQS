package com.oplus.melody.model.repository.zenmode;

import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import u8.C1554b;
import u8.C1561i;

/* JADX INFO: compiled from: ZenZipConfigDO.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends C1561i {
    private C1554b controlSourceV2;
    private MelodyResourceDO defaultMusic;
    private ZenModeInfoDO defaultSceneV2;
    private MelodyResourceDO defaultWhiteNoise;
    private MelodyResourceDO firstItemBackground;
    private MelodyResourceDO guideVideo;

    public C1554b getControlSourceV2() {
        return this.controlSourceV2;
    }

    public MelodyResourceDO getDefaultMusic() {
        return this.defaultMusic;
    }

    public ZenModeInfoDO getDefaultSceneV2() {
        return this.defaultSceneV2;
    }

    public MelodyResourceDO getDefaultWhiteNoise() {
        return this.defaultWhiteNoise;
    }

    public MelodyResourceDO getFirstItemBackground() {
        return this.firstItemBackground;
    }

    public MelodyResourceDO getGuideVideo() {
        return this.guideVideo;
    }

    public void setControlSourceV2(C1554b c1554b) {
        this.controlSourceV2 = c1554b;
    }

    public void setDefaultMusic(MelodyResourceDO melodyResourceDO) {
        this.defaultMusic = melodyResourceDO;
    }

    public void setDefaultSceneV2(ZenModeInfoDO zenModeInfoDO) {
        this.defaultSceneV2 = zenModeInfoDO;
    }

    public void setDefaultWhiteNoise(MelodyResourceDO melodyResourceDO) {
        this.defaultWhiteNoise = melodyResourceDO;
    }

    public void setFirstItemBackground(MelodyResourceDO melodyResourceDO) {
        this.firstItemBackground = melodyResourceDO;
    }

    public void setGuideVideo(MelodyResourceDO melodyResourceDO) {
        this.guideVideo = melodyResourceDO;
    }
}
