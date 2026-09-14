package com.oplus.melody.common.addon;

import android.app.ActivityManager;
import android.app.OplusActivityManager;
import com.oplus.melody.common.util.A;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyActivityManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyActivityManager;", "", "<init>", "()V", "TAG", "", "isProcessRunning", "", "processName", "(Ljava/lang/String;)Ljava/lang/Boolean;", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyActivityManager {
    public static final MelodyActivityManager INSTANCE = new MelodyActivityManager();
    public static final String TAG = "MelodyActivityManager";

    private MelodyActivityManager() {
    }

    public final Boolean isProcessRunning(String processName) {
        h.e(processName, "processName");
        try {
            List runningAppProcesses = new OplusActivityManager().getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return Boolean.FALSE;
            }
            boolean z2 = false;
            if (!runningAppProcesses.isEmpty()) {
                Iterator it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) it.next();
                    if (h.a(runningAppProcessInfo.processName, processName) && runningAppProcessInfo.pid > 0) {
                        z2 = true;
                        break;
                    }
                }
            }
            return Boolean.valueOf(z2);
        } catch (Throwable th) {
            A.i(TAG, "isProcessRunning error.", th);
            return null;
        }
    }
}
