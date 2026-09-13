package com.oplus.melody.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: renamed from: com.oplus.melody.common.util.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CollectionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0901g {
    public static boolean a(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> ArrayList<T> b(Collection<T> collection) {
        return a(collection) ? new ArrayList<>(0) : new ArrayList<>(collection);
    }

    public static <K, V> androidx.collection.a<K, V> c(Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            return new androidx.collection.a<>(0);
        }
        androidx.collection.a<K, V> aVar = new androidx.collection.a<>(map.size());
        aVar.putAll(map);
        return aVar;
    }
}
