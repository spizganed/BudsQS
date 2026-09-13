package com.oplus.melody.common.helper;

import Wb.l;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.preference.k;
import com.google.gson.reflect.TypeToken;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.util.C0908n;
import com.oplus.melody.common.util.C0917x;
import ec.m;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyAlivePreferencesHelper.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MelodyAlivePreferencesHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f19403a = new TypeToken<Set<? extends String>>() { // from class: com.oplus.melody.common.helper.MelodyAlivePreferencesHelper$mStringSetType$1
    }.getType();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type f19404b = new TypeToken<List<? extends a>>() { // from class: com.oplus.melody.common.helper.MelodyAlivePreferencesHelper$mActionListType$1
    }.getType();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Jb.b f19405c = kotlin.a.a(new com.oplus.melody.common.helper.a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Jb.b f19406d = kotlin.a.a(new A7.a(2));

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Object a(Object obj, String s4) {
        h.e(s4, "s");
        int iM = m.M(s4, '|', 0, 6);
        if (iM != -1) {
            String strSubstring = s4.substring(iM + 1);
            h.d(strSubstring, "substring(...)");
            String strSubstring2 = s4.substring(0, iM);
            h.d(strSubstring2, "substring(...)");
            switch (strSubstring2.hashCode()) {
                case 49:
                    if (strSubstring2.equals(BaseHealthModule.TRACK_FATIGUE_REMIND)) {
                        return Integer.valueOf(Integer.parseInt(strSubstring));
                    }
                    break;
                case 50:
                    if (strSubstring2.equals(BaseHealthModule.TRACK_CERVICAL_REMIND)) {
                        return Long.valueOf(Long.parseLong(strSubstring));
                    }
                    break;
                case 51:
                    if (strSubstring2.equals(BaseHealthModule.TRACK_ACTIVE_DETECT)) {
                        return Float.valueOf(Float.parseFloat(strSubstring));
                    }
                    break;
                case 52:
                    if (strSubstring2.equals("4")) {
                        return strSubstring;
                    }
                    break;
                case 53:
                    if (strSubstring2.equals("5")) {
                        return Boolean.valueOf(Boolean.parseBoolean(strSubstring));
                    }
                    break;
                case 54:
                    if (strSubstring2.equals("6")) {
                        return C0917x.d(strSubstring, f19403a);
                    }
                    break;
            }
        }
        return obj;
    }

    public static String b(Object obj) {
        String str = obj instanceof Boolean ? "5" : obj instanceof Integer ? BaseHealthModule.TRACK_FATIGUE_REMIND : obj instanceof Long ? BaseHealthModule.TRACK_CERVICAL_REMIND : ((obj instanceof Float) || h.a(obj, e.f25389a)) ? BaseHealthModule.TRACK_ACTIVE_DETECT : obj instanceof CharSequence ? "4" : obj instanceof Set ? "6" : VersionInfo.VENDOR_CODE_DEFAULT_VERSION;
        if (str.equals("6")) {
            obj = C0917x.i(obj);
        }
        return str + "|" + obj;
    }

    public static Uri c(HeyMelodyApplication context, String... strArr) {
        h.e(context, "context");
        Uri.Builder builderBuildUpon = Uri.parse("content://" + context.getPackageName() + ".alive.PreferencesProvider").buildUpon();
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                break;
            }
            builderBuildUpon.appendPath(str);
        }
        Uri uriBuild = builderBuildUpon.build();
        h.d(uriBuild, "build(...)");
        return uriBuild;
    }

    public static SharedPreferences d(Context context) {
        h.e(context, "context");
        A7.b.f86a.getClass();
        if (A7.b.b()) {
            String strA = C0908n.a();
            h.d(strA, "getDefaultSharedPreferencesName(...)");
            return f(strA);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(k.a(context), 0);
        h.d(sharedPreferences, "getDefaultSharedPreferences(...)");
        return sharedPreferences;
    }

    public static final SharedPreferences e() {
        return (SharedPreferences) f19406d.getValue();
    }

    public static SharedPreferences f(String str) {
        return (SharedPreferences) ((l) f19405c.getValue()).d(str);
    }

    public static final String g(int i10, String mac) {
        h.e(mac, "mac");
        return mac + "_" + i10;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Object h(SharedPreferences sharedPreferences, String str, String str2) {
        if (!sharedPreferences.contains(str)) {
            return null;
        }
        switch (str2.hashCode()) {
            case 48:
                if (str2.equals(VersionInfo.VENDOR_CODE_DEFAULT_VERSION)) {
                    return Boolean.TRUE;
                }
                return null;
            case 49:
                if (str2.equals(BaseHealthModule.TRACK_FATIGUE_REMIND)) {
                    return Integer.valueOf(sharedPreferences.getInt(str, 0));
                }
                return null;
            case 50:
                if (str2.equals(BaseHealthModule.TRACK_CERVICAL_REMIND)) {
                    return Long.valueOf(sharedPreferences.getLong(str, 0L));
                }
                return null;
            case 51:
                if (str2.equals(BaseHealthModule.TRACK_ACTIVE_DETECT)) {
                    return Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                }
                return null;
            case 52:
                if (str2.equals("4")) {
                    return sharedPreferences.getString(str, "");
                }
                return null;
            case 53:
                if (str2.equals("5")) {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                }
                return null;
            case 54:
                if (str2.equals("6")) {
                    return sharedPreferences.getStringSet(str, EmptySet.f25352a);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static androidx.collection.b i(SharedPreferences sharedPreferences, List list) {
        androidx.collection.b bVar = new androidx.collection.b(0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String action = aVar.getAction();
            switch (action.hashCode()) {
                case -2018571198:
                    if (action.equals("putStringSet")) {
                        h.b(editorEdit);
                        EmptySet emptySet = EmptySet.f25352a;
                        Set<String> set = (Set) a(emptySet, aVar.getValue());
                        if (!sharedPreferences.contains(aVar.getKey()) || !h.a(set, sharedPreferences.getStringSet(aVar.getKey(), emptySet))) {
                            editorEdit.putStringSet(aVar.getKey(), set);
                            break;
                        }
                    }
                    break;
                case -976920992:
                    if (action.equals("putInt")) {
                        h.b(editorEdit);
                        int iIntValue = ((Number) a(0, aVar.getValue())).intValue();
                        if (!sharedPreferences.contains(aVar.getKey()) || iIntValue != sharedPreferences.getInt(aVar.getKey(), 0)) {
                            editorEdit.putInt(aVar.getKey(), iIntValue);
                            break;
                        }
                    }
                    break;
                case -934610812:
                    if (action.equals("remove")) {
                        h.b(editorEdit);
                        if (sharedPreferences.contains(aVar.getKey())) {
                            editorEdit.remove(aVar.getKey());
                            break;
                        }
                    }
                    break;
                case -462997504:
                    if (action.equals("putString")) {
                        h.b(editorEdit);
                        String str = (String) a("", aVar.getValue());
                        if (!sharedPreferences.contains(aVar.getKey()) || !h.a(str, sharedPreferences.getString(aVar.getKey(), ""))) {
                            editorEdit.putString(aVar.getKey(), str);
                            break;
                        }
                    }
                    break;
                case -219689429:
                    if (action.equals("putLong")) {
                        h.b(editorEdit);
                        long jLongValue = ((Number) a(0L, aVar.getValue())).longValue();
                        if (!sharedPreferences.contains(aVar.getKey()) || jLongValue != sharedPreferences.getLong(aVar.getKey(), 0L)) {
                            editorEdit.putLong(aVar.getKey(), jLongValue);
                            break;
                        }
                    }
                    break;
                case 94746189:
                    if (action.equals("clear")) {
                        h.b(editorEdit);
                        if (sharedPreferences.contains("melody_migrated")) {
                            editorEdit.clear().putBoolean("melody_migrated", true);
                        } else {
                            editorEdit.clear();
                        }
                    } else {
                        continue;
                    }
                    break;
                case 478450201:
                    if (action.equals("putBoolean")) {
                        h.b(editorEdit);
                        boolean zBooleanValue = ((Boolean) a(Boolean.FALSE, aVar.getValue())).booleanValue();
                        if (!sharedPreferences.contains(aVar.getKey()) || zBooleanValue != sharedPreferences.getBoolean(aVar.getKey(), false)) {
                            editorEdit.putBoolean(aVar.getKey(), zBooleanValue);
                            break;
                        }
                    }
                    break;
                case 1773932685:
                    if (action.equals("putFloat")) {
                        h.b(editorEdit);
                        float fFloatValue = ((Number) a(Float.valueOf(0.0f), aVar.getValue())).floatValue();
                        if (!sharedPreferences.contains(aVar.getKey()) || fFloatValue != sharedPreferences.getFloat(aVar.getKey(), 0.0f)) {
                            editorEdit.putFloat(aVar.getKey(), fFloatValue);
                            break;
                        }
                    }
                    break;
            }
            bVar.add(aVar.getKey());
        }
        editorEdit.apply();
        return bVar;
    }

    /* JADX INFO: compiled from: MelodyAlivePreferencesHelper.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/oplus/melody/common/helper/MelodyAlivePreferencesHelper$Action;", "Lcom/oplus/melody/common/data/BaseBean;", "action", "", "key", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getAction", "()Ljava/lang/String;", "getKey", "getValue", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class a extends com.oplus.melody.common.data.a {
        private final String action;
        private final String key;
        private final String value;

        public a(String action, String key, Object obj) {
            h.e(action, "action");
            h.e(key, "key");
            this.action = action;
            this.key = key;
            this.value = MelodyAlivePreferencesHelper.b(obj);
        }

        public final String getAction() {
            return this.action;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getValue() {
            return this.value;
        }

        public /* synthetic */ a(String str, String str2, Object obj, int i10, d dVar) {
            this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : obj);
        }
    }
}
