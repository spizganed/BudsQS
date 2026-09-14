package com.oplus.melody.ui.component.detail.sound.playing;

import Ca.v;
import Y.q;
import com.oplus.melody.ui.base.BaseViewModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: SoundPlayingViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fJ\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fJ\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0011J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000fJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fJ\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0006\u0010&\u001a\u00020\u0011J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0011J\u0006\u0010)\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/oplus/melody/ui/component/detail/sound/playing/SoundPlayingViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "mZipConfig", "Lcom/oplus/melody/model/repository/zenmode/ZenZipConfigDO;", "getMZipConfig", "()Lcom/oplus/melody/model/repository/zenmode/ZenZipConfigDO;", "setMZipConfig", "(Lcom/oplus/melody/model/repository/zenmode/ZenZipConfigDO;)V", "mExoVideoPlayerHelper", "Lcom/oplus/melody/ui/helper/VideoExoPlayerHelper;", "currentMediaItem", "Landroidx/media3/common/MediaItem;", "getPlayingMediaItem", "Landroidx/lifecycle/LiveData;", "getServiceTimerState", "", "getPlayState", "Lcom/oplus/melody/model/repository/soundplay/PlayState;", "getVideoPlayState", "", "playPause", "isPlaying", "", "initVideoPlayer", "setCurrentMediaItem", "mediaItem", "playVideo", "pauseVideo", "stopVideo", "releaseVideoPlayer", "getRemainingTime", "", "getTimerState", "getTimerValue", "setTimerValue", "value", "cancelCountDownTime", "setServiceTimerValue", "stopTimer", "startTimer", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SoundPlayingViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f21243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f21244c;
}
