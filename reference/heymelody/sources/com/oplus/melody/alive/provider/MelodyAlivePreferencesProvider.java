package com.oplus.melody.alive.provider;

import F6.a;
import Jb.l;
import Kb.m;
import Kb.u;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import androidx.collection.b;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import t8.n;

/* JADX INFO: compiled from: MelodyAlivePreferencesProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JO\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000eJ;\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/alive/provider/MelodyAlivePreferencesProvider;", "Lcom/oplus/melody/alive/provider/MelodyAliveBaseProvider;", "<init>", "()V", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "", "values", "Landroid/content/ContentValues;", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "getPreferencesLocked", "Landroid/content/SharedPreferences;", "name", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyAlivePreferencesProvider extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f18803a = 0;

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Map<String, ?> mapA0;
        MatrixCursor matrixCursor;
        h.e(uri, "uri");
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return null;
        }
        synchronized (this) {
            try {
                String str = pathSegments.get(0);
                h.b(str);
                n.f27945a.getClass();
                SharedPreferences sharedPreferencesB = n.b(str);
                if (pathSegments.size() == 1) {
                    A.c("MelodyAlivePreferencesProvider", new C8.a(str, 3));
                    mapA0 = sharedPreferencesB.getAll();
                } else {
                    String str2 = pathSegments.get(1);
                    String str3 = pathSegments.size() > 2 ? pathSegments.get(2) : "4";
                    if (A.l()) {
                        A.f("MelodyAlivePreferencesProvider", "query " + str + "#" + str2);
                    }
                    Type type = MelodyAlivePreferencesHelper.f19403a;
                    h.b(str2);
                    h.b(str3);
                    mapA0 = u.a0(new Pair(str2, MelodyAlivePreferencesHelper.h(sharedPreferencesB, str2, str3)));
                }
                matrixCursor = new MatrixCursor(new String[]{"key", "value"});
                h.b(mapA0);
                for (Map.Entry<String, ?> entry : mapA0.entrySet()) {
                    matrixCursor.newRow().add("key", entry.getKey()).add("value", MelodyAlivePreferencesHelper.b(entry.getValue()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return matrixCursor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // F6.a, android.content.ContentProvider
    public final int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        h.e(uri, "uri");
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty() || values == null) {
            return 0;
        }
        synchronized (this) {
            try {
                String str = pathSegments.get(0);
                h.b(str);
                n.f27945a.getClass();
                SharedPreferences sharedPreferencesB = n.b(str);
                Type type = MelodyAlivePreferencesHelper.f19403a;
                String asString = values.getAsString("5ce76944-230f-4694-bad6-a24d3038665c");
                h.d(asString, "getAsString(...)");
                List<MelodyAlivePreferencesHelper.a> list = (List) C0917x.d(asString, MelodyAlivePreferencesHelper.f19404b);
                if (list == null) {
                    list = Collections.EMPTY_LIST;
                    h.d(list, "emptyList(...)");
                }
                ArrayList arrayList = new ArrayList(m.i(list));
                for (MelodyAlivePreferencesHelper.a aVar : list) {
                    arrayList.add(aVar.getAction() + "#" + aVar.getKey());
                }
                A.f("MelodyAlivePreferencesProvider", "update " + str + " " + arrayList);
                b bVarI = MelodyAlivePreferencesHelper.i(sharedPreferencesB, list);
                if (!bVarI.isEmpty()) {
                    Context context = getContext();
                    h.b(context);
                    ContentResolver contentResolver = context.getContentResolver();
                    ArrayList arrayList2 = new ArrayList(m.i(bVarI));
                    b.a aVar2 = new b.a();
                    while (aVar2.hasNext()) {
                        arrayList2.add(uri.buildUpon().appendPath((String) aVar2.next()).build());
                    }
                    if (Build.VERSION.SDK_INT >= 30) {
                        contentResolver.notifyChange(arrayList2, (ContentObserver) null, 0);
                    } else {
                        int size = arrayList2.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj = arrayList2.get(i10);
                            i10++;
                            contentResolver.notifyChange((Uri) obj, (ContentObserver) null, 0);
                        }
                    }
                }
                l lVar = l.f2618a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1;
    }
}
