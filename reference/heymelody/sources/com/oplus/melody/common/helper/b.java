package com.oplus.melody.common.helper;

import D7.C0382p;
import D7.C0383q;
import D7.RunnableC0380n;
import D7.o0;
import Jb.l;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Binder;
import android.os.SystemClock;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0917x;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAlivePreferencesImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeyMelodyApplication f19408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.b<SharedPreferences.OnSharedPreferenceChangeListener> f19410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0383q f19411d;

    /* JADX INFO: compiled from: MelodyAlivePreferencesImpl.kt */
    public static final class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedList<MelodyAlivePreferencesHelper.a> f19412a = new LinkedList<>();

        public a() {
        }

        public final boolean a() {
            int iUpdate;
            LinkedList<MelodyAlivePreferencesHelper.a> linkedList = this.f19412a;
            int i10 = 0;
            if (!linkedList.isEmpty()) {
                A7.b.f86a.getClass();
                boolean zB = A7.b.b();
                b bVar = b.this;
                HeyMelodyApplication heyMelodyApplication = bVar.f19408a;
                String str = bVar.f19409b;
                if (zB) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        ContentValues contentValues = new ContentValues();
                        Type type = MelodyAlivePreferencesHelper.f19403a;
                        String strI = C0917x.i(linkedList);
                        h.d(strI, "toJsonString(...)");
                        contentValues.put("5ce76944-230f-4694-bad6-a24d3038665c", strI);
                        iUpdate = heyMelodyApplication.getContentResolver().update(MelodyAlivePreferencesHelper.c(heyMelodyApplication, str), contentValues, null, null);
                        A.c("MelodyAlivePreferencesImpl", new C0382p(i10, jElapsedRealtime, bVar));
                    } finally {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                } else {
                    A6.b.g("submit ignore ", str, "MelodyAlivePreferencesImpl");
                    iUpdate = 0;
                }
                if (iUpdate > 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            ForkJoinPool.commonPool().execute(new RunnableC0380n(this, 1));
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("clear", null, null, 6, null));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return a();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String key, boolean z2) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("putBoolean", key, Boolean.valueOf(z2)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String key, float f9) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("putFloat", key, Float.valueOf(f9)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String key, int i10) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("putInt", key, Integer.valueOf(i10)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String key, long j5) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("putLong", key, Long.valueOf(j5)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String key, String str) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("putString", key, str));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String key, Set<String> set) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("putStringSet", key, set));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String key) {
            h.e(key, "key");
            this.f19412a.add(new MelodyAlivePreferencesHelper.a("remove", key, null, 4, null));
            return this;
        }
    }

    public b(HeyMelodyApplication mContext, String mName) {
        h.e(mContext, "mContext");
        h.e(mName, "mName");
        this.f19408a = mContext;
        this.f19409b = mName;
        this.f19410c = new androidx.collection.b<>(0);
        this.f19411d = new C0383q(this, o0.c.f1143a);
    }

    public final <T> T a(String str, String str2, T t10) {
        Type type = MelodyAlivePreferencesHelper.f19403a;
        HeyMelodyApplication heyMelodyApplication = this.f19408a;
        A7.b.f86a.getClass();
        boolean zB = A7.b.b();
        String str3 = this.f19409b;
        String string = "";
        if (zB) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Cursor cursorQuery = heyMelodyApplication.getContentResolver().query(MelodyAlivePreferencesHelper.c(heyMelodyApplication, str3, str, str2), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst() && str.equals(cursorQuery.getString(cursorQuery.getColumnIndex("key")))) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                            h.d(string, "getString(...)");
                        }
                        l lVar = l.f2618a;
                        cursorQuery.close();
                    } finally {
                    }
                }
                A.f("MelodyAlivePreferencesImpl", "queryString " + str3 + "#" + str + " time=" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th;
            }
        } else {
            A.f("MelodyAlivePreferencesImpl", "queryString ignore " + str3 + "#" + str);
        }
        return (T) MelodyAlivePreferencesHelper.a(t10, string);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String key) {
        h.e(key, "key");
        return ((Boolean) a(key, VersionInfo.VENDOR_CODE_DEFAULT_VERSION, Boolean.FALSE)).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a();
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HeyMelodyApplication heyMelodyApplication = this.f19408a;
        androidx.collection.a aVar = new androidx.collection.a();
        A7.b.f86a.getClass();
        boolean zB = A7.b.b();
        String str = this.f19409b;
        if (!zB) {
            A6.b.g("getAll ignore ", str, "MelodyAlivePreferencesImpl");
            return aVar;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Cursor cursorQuery = heyMelodyApplication.getContentResolver().query(MelodyAlivePreferencesHelper.c(heyMelodyApplication, str), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("key");
                        int columnIndex2 = cursorQuery.getColumnIndex("value");
                        do {
                            String string = cursorQuery.getString(columnIndex);
                            Type type = MelodyAlivePreferencesHelper.f19403a;
                            String string2 = cursorQuery.getString(columnIndex2);
                            h.d(string2, "getString(...)");
                            aVar.put(string, MelodyAlivePreferencesHelper.a(null, string2));
                        } while (cursorQuery.moveToNext());
                    }
                    l lVar = l.f2618a;
                    cursorQuery.close();
                } finally {
                }
            }
            return aVar;
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String key, boolean z2) {
        h.e(key, "key");
        return ((Boolean) a(key, "5", Boolean.valueOf(z2))).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String key, float f9) {
        h.e(key, "key");
        return ((Number) a(key, BaseHealthModule.TRACK_ACTIVE_DETECT, Float.valueOf(f9))).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String key, int i10) {
        h.e(key, "key");
        return ((Number) a(key, BaseHealthModule.TRACK_FATIGUE_REMIND, Integer.valueOf(i10))).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String key, long j5) {
        h.e(key, "key");
        return ((Number) a(key, BaseHealthModule.TRACK_CERVICAL_REMIND, Long.valueOf(j5))).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String key, String str) {
        h.e(key, "key");
        return (String) a(key, "4", str);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String key, Set<String> set) {
        h.e(key, "key");
        return (Set) a(key, "6", set);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        h.e(listener, "listener");
        synchronized (this.f19410c) {
            try {
                if (this.f19410c.add(listener) && this.f19410c.f7498c == 1) {
                    HeyMelodyApplication heyMelodyApplication = this.f19408a;
                    Type type = MelodyAlivePreferencesHelper.f19403a;
                    C0905k.b(heyMelodyApplication, MelodyAlivePreferencesHelper.c(heyMelodyApplication, this.f19409b), this.f19411d);
                }
                l lVar = l.f2618a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        h.e(listener, "listener");
        synchronized (this.f19410c) {
            try {
                if (this.f19410c.remove(listener) && this.f19410c.isEmpty()) {
                    C0905k.n(this.f19408a, this.f19411d);
                }
                l lVar = l.f2618a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
