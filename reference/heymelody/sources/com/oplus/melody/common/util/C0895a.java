package com.oplus.melody.common.util;

import D7.C0384s;
import D7.C0386u;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.oplus.melody.common.util.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityLifecycle.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0895a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f19481a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19482b = 0;

    /* JADX INFO: renamed from: com.oplus.melody.common.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityLifecycle.java */
    public static final class C0225a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0895a f19483a = new C0895a();
    }

    /* JADX INFO: renamed from: com.oplus.melody.common.util.a$b */
    /* JADX INFO: compiled from: ActivityLifecycle.java */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public final boolean a() {
        return this.f19482b > 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        A.c("ActivityLifecycle", new C0384s(19, this, activity));
        ArrayList arrayList = this.f19481a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((b) obj).c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        A.c("ActivityLifecycle", new C0386u(19, this, activity));
        ArrayList arrayList = this.f19481a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((b) obj).b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        A.b("ActivityLifecycle", "onActivityPaused");
        ArrayList arrayList = this.f19481a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((b) obj).d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        A.b("ActivityLifecycle", "onActivityResumed");
        ArrayList arrayList = this.f19481a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((b) obj).a();
        }
        if (A.k() && S.t(activity) && TextUtils.equals(activity.getPackageName(), E7.a.c(activity))) {
            Class<?> cls = activity.getClass();
            String name = cls.getName();
            if (!name.startsWith("com.oplus.melody") || name.startsWith("com.oplus.melody.demo") || name.startsWith("com.oplus.melody.diagnosis") || name.startsWith("com.oplus.melody.collectlogs") || name.startsWith("com.oplus.melody.component.discovery") || name.endsWith("ZenModePlayJumpActivity")) {
                return;
            }
            A.w("ActivityLifecycle", "建议此页面在前台进程显示：".concat(cls.getSimpleName()), null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        A.b("ActivityLifecycle", "onActivitySaveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.f19482b++;
        A.c("ActivityLifecycle", new T8.d(this, 26));
        ArrayList arrayList = this.f19481a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((b) obj).e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.f19482b--;
        A.c("ActivityLifecycle", new S7.c(this, 24));
        ArrayList arrayList = this.f19481a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((b) obj).f();
        }
    }
}
