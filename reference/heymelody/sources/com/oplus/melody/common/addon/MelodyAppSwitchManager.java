package com.oplus.melody.common.addon;

import Jb.l;
import S7.c;
import T8.d;
import android.content.Context;
import com.oplus.app.OplusAppEnterInfo;
import com.oplus.app.OplusAppExitInfo;
import com.oplus.app.OplusAppSwitchConfig;
import com.oplus.app.OplusAppSwitchManager;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.S;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAppSwitchManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyAppSwitchManager;", "", "<init>", "()V", "TAG", "", "observers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/oplus/melody/common/addon/MelodyOnAppSwitchObserver;", "registerAppSwitchObserver", "", "context", "Landroid/content/Context;", "observer", "activities", "", "packages", "unregisterAppSwitchObserver", "", "isAppSwitchObserverRegistered", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyAppSwitchManager {
    public static final String TAG = "MelodyAppSwitchManager";
    public static final MelodyAppSwitchManager INSTANCE = new MelodyAppSwitchManager();
    private static final ConcurrentHashMap<MelodyOnAppSwitchObserver, Object> observers = new ConcurrentHashMap<>();

    private MelodyAppSwitchManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String registerAppSwitchObserver$lambda$1$0(MelodyOnAppSwitchObserver melodyOnAppSwitchObserver) {
        return "registerAppSwitchObserver.onSuccess " + melodyOnAppSwitchObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String unregisterAppSwitchObserver$lambda$1$0(MelodyOnAppSwitchObserver melodyOnAppSwitchObserver) {
        return "unregisterAppSwitchObserver.onSuccess " + melodyOnAppSwitchObserver;
    }

    public final boolean isAppSwitchObserverRegistered(MelodyOnAppSwitchObserver observer) {
        h.e(observer, "observer");
        return observers.containsKey(observer);
    }

    public final boolean registerAppSwitchObserver(Context context, final MelodyOnAppSwitchObserver observer, List<String> activities, List<String> packages) {
        Object objA;
        OplusAppSwitchConfig oplusAppSwitchConfig;
        OplusAppSwitchManager.OnAppSwitchObserver onAppSwitchObserver;
        h.e(context, "context");
        h.e(observer, "observer");
        h.e(activities, "activities");
        h.e(packages, "packages");
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(context.getPackageName())) {
            return false;
        }
        if (isAppSwitchObserverRegistered(observer)) {
            return true;
        }
        try {
            oplusAppSwitchConfig = new OplusAppSwitchConfig();
            oplusAppSwitchConfig.addAppConfig(1, activities);
            oplusAppSwitchConfig.addAppConfig(2, packages);
            onAppSwitchObserver = new OplusAppSwitchManager.OnAppSwitchObserver() { // from class: com.oplus.melody.common.addon.MelodyAppSwitchManager$registerAppSwitchObserver$1$newObserver$1
                public void onActivityEnter(OplusAppEnterInfo oInfo) {
                    if (A.l()) {
                        A.f(MelodyAppSwitchManager.TAG, "onActivityEnter " + oInfo);
                    }
                    if (oInfo != null) {
                        MelodyOnAppSwitchObserver melodyOnAppSwitchObserver = observer;
                        String targetName = oInfo.targetName;
                        h.d(targetName, "targetName");
                        melodyOnAppSwitchObserver.onActivityEnter(new MelodyAppEnterInfo(targetName));
                    }
                }

                public void onActivityExit(OplusAppExitInfo oInfo) {
                    if (A.l()) {
                        A.f(MelodyAppSwitchManager.TAG, "onActivityExit " + oInfo);
                    }
                    if (oInfo != null) {
                        MelodyOnAppSwitchObserver melodyOnAppSwitchObserver = observer;
                        String targetName = oInfo.targetName;
                        h.d(targetName, "targetName");
                        melodyOnAppSwitchObserver.onActivityExit(new MelodyAppExitInfo(targetName));
                    }
                }

                public void onAppEnter(OplusAppEnterInfo oInfo) {
                    if (A.l()) {
                        A.f(MelodyAppSwitchManager.TAG, "onAppEnter " + oInfo);
                    }
                    if (oInfo != null) {
                        MelodyOnAppSwitchObserver melodyOnAppSwitchObserver = observer;
                        String targetName = oInfo.targetName;
                        h.d(targetName, "targetName");
                        melodyOnAppSwitchObserver.onAppEnter(new MelodyAppEnterInfo(targetName));
                    }
                }

                public void onAppExit(OplusAppExitInfo oInfo) {
                    if (A.l()) {
                        A.f(MelodyAppSwitchManager.TAG, "onAppExit " + oInfo);
                    }
                    if (oInfo != null) {
                        MelodyOnAppSwitchObserver melodyOnAppSwitchObserver = observer;
                        String targetName = oInfo.targetName;
                        h.d(targetName, "targetName");
                        melodyOnAppSwitchObserver.onAppExit(new MelodyAppExitInfo(targetName));
                    }
                }
            };
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (!OplusAppSwitchManager.getInstance().registerAppSwitchObserver(context, onAppSwitchObserver, oplusAppSwitchConfig)) {
            throw MelodyException.e(0, "failed to register " + observer);
        }
        observers.put(observer, onAppSwitchObserver);
        objA = l.f2618a;
        boolean z2 = objA instanceof Result.Failure;
        boolean z4 = !z2;
        if (!z2) {
            A.c(TAG, new c(observer, 23));
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.i(TAG, "registerAppSwitchObserver.onFailure " + observer, thA);
        }
        return z4;
    }

    public final void unregisterAppSwitchObserver(Context context, MelodyOnAppSwitchObserver observer) {
        Object objA;
        h.e(context, "context");
        h.e(observer, "observer");
        List<String> list = S.f19463a;
        if ("com.heytap.headset".equals(context.getPackageName())) {
            return;
        }
        try {
            objA = observers.remove(observer);
            if (objA == null) {
                objA = null;
            } else if (!OplusAppSwitchManager.getInstance().unregisterAppSwitchObserver(context, (OplusAppSwitchManager.OnAppSwitchObserver) objA)) {
                throw MelodyException.e(0, "failed to unregister " + observer);
            }
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (!(objA instanceof Result.Failure)) {
            A.c(TAG, new d(observer, 25));
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            A.i(TAG, "unregisterAppSwitchObserver.onFailure " + observer, thA);
        }
    }
}
