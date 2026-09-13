package com.oplus.melody.common.addon;

import kotlin.Metadata;

/* JADX INFO: compiled from: MelodyOnAppSwitchObserver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyOnAppSwitchObserver;", "", "onAppEnter", "", "info", "Lcom/oplus/melody/common/addon/MelodyAppEnterInfo;", "onAppExit", "Lcom/oplus/melody/common/addon/MelodyAppExitInfo;", "onActivityEnter", "onActivityExit", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface MelodyOnAppSwitchObserver {
    void onActivityEnter(MelodyAppEnterInfo info);

    void onActivityExit(MelodyAppExitInfo info);

    void onAppEnter(MelodyAppEnterInfo info);

    void onAppExit(MelodyAppExitInfo info);
}
