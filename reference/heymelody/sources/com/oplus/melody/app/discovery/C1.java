package com.oplus.melody.app.discovery;

import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.List;
import u8.C1558f;
import u8.C1561i;

/* JADX INFO: compiled from: DiscoveryZipConfigVO.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1 extends C1561i {
    static final C1 EMPTY = new C1();
    private List<C1558f> mDiscoveryStateList;

    @I3.b("discoveryStates")
    private C1558f mDiscoveryStates;

    @I3.b("strangeRes")
    private MelodyResourceDO mStrangeRes;
    private Integer mVideoLandOffsetX;
    private Integer mVideoLandOffsetY;
    private Integer mVideoOffsetX;
    private Integer mVideoOffsetY;

    @I3.b("videoRes")
    private MelodyResourceDO mVideoRes;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getDiscoveryStates$0(C1558f c1558f, C1558f c1558f2) {
        return c1558f2.getMinVersion() - c1558f.getMinVersion();
    }

    public C1558f getDiscoveryStates() {
        if (!C0901g.a(this.mDiscoveryStateList)) {
            int i10 = com.oplus.melody.common.util.S.i(C0906l.f19501a);
            this.mDiscoveryStateList.sort(new B1());
            for (C1558f c1558f : this.mDiscoveryStateList) {
                if (i10 >= c1558f.getMinVersion()) {
                    return c1558f;
                }
            }
        }
        return this.mDiscoveryStates;
    }

    public boolean getEnterUpAnim() {
        MelodyResourceDO melodyResourceDO = this.mStrangeRes;
        return (melodyResourceDO == null || melodyResourceDO.getEnterUpAnim() == 0) ? false : true;
    }

    public MelodyResourceDO getStrangeRes() {
        return this.mStrangeRes;
    }

    public Integer getVideoLandOffsetX() {
        return this.mVideoLandOffsetX;
    }

    public Integer getVideoLandOffsetY() {
        return this.mVideoLandOffsetY;
    }

    public Integer getVideoOffsetX() {
        return this.mVideoOffsetX;
    }

    public Integer getVideoOffsetY() {
        return this.mVideoOffsetY;
    }

    public MelodyResourceDO getVideoRes() {
        return this.mVideoRes;
    }

    public void setDiscoveryStateList(List<C1558f> list) {
        this.mDiscoveryStateList = list;
    }

    public void setDiscoveryStates(C1558f c1558f) {
        this.mDiscoveryStates = c1558f;
    }

    public void setStrangeRes(MelodyResourceDO melodyResourceDO) {
        this.mStrangeRes = melodyResourceDO;
    }

    public void setVideoLandOffsetX(Integer num) {
        this.mVideoLandOffsetX = num;
    }

    public void setVideoLandOffsetY(Integer num) {
        this.mVideoLandOffsetY = num;
    }

    public void setVideoOffsetX(Integer num) {
        this.mVideoOffsetX = num;
    }

    public void setVideoOffsetY(Integer num) {
        this.mVideoOffsetY = num;
    }

    public void setVideoRes(MelodyResourceDO melodyResourceDO) {
        this.mVideoRes = melodyResourceDO;
    }
}
