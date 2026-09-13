package com.oplus.melody.common.data;

import Aa.c;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.CallableC0915v;
import com.oplus.melody.common.util.K;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BaseBean.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Cloneable {
    private static final String TAG = "BaseBean";
    private static final ConcurrentHashMap<Class<?>, List<Field>> sClassFields = new ConcurrentHashMap<>();

    public static <T extends a> T copyOf(T t10, Class<T> cls) {
        if (t10 == null) {
            return (T) newInstance(cls);
        }
        T tCast = cls.cast(t10.clone());
        Objects.requireNonNull(tCast);
        return tCast;
    }

    public static <T extends a> T deepCopyOf(T t10, Class<T> cls) {
        if (t10 == null) {
            return (T) newInstance(cls);
        }
        Object objJ = C0917x.j("deepClone", new CallableC0915v(t10, 0));
        if (objJ != null) {
            return (T) objJ;
        }
        throw MelodyException.e(0, "deepClone failed " + t10.getClass());
    }

    private static List<Field> getClassFields(Class<?> cls) {
        if (cls == a.class || cls == Object.class || cls == null) {
            return Collections.EMPTY_LIST;
        }
        ConcurrentHashMap<Class<?>, List<Field>> concurrentHashMap = sClassFields;
        List<Field> list = concurrentHashMap.get(cls);
        if (list != null) {
            return list;
        }
        List<Field> listComputeIfAbsent = concurrentHashMap.computeIfAbsent(cls, new c(getClassFields(cls.getSuperclass()), 1));
        listComputeIfAbsent.size();
        cls.toString();
        return listComputeIfAbsent;
    }

    public static int hashCodeOf(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj instanceof Object[] ? Arrays.deepHashCode((Object[]) obj) : obj instanceof byte[] ? Arrays.hashCode((byte[]) obj) : obj instanceof int[] ? Arrays.hashCode((int[]) obj) : obj instanceof long[] ? Arrays.hashCode((long[]) obj) : obj instanceof char[] ? Arrays.hashCode((char[]) obj) : obj instanceof short[] ? Arrays.hashCode((short[]) obj) : obj instanceof boolean[] ? Arrays.hashCode((boolean[]) obj) : obj instanceof double[] ? Arrays.hashCode((double[]) obj) : obj instanceof float[] ? Arrays.hashCode((float[]) obj) : obj.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$getClassFields$0(List list, Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList(list.size() + declaredFields.length);
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                arrayList.add(field);
            }
        }
        arrayList.sort(Comparator.comparing(new A6.c(2)));
        arrayList.addAll(list);
        return Collections.unmodifiableList(arrayList);
    }

    public static <T extends a> T newInstance(Class<T> cls) {
        T t10 = (T) C0917x.c(cls, "{}");
        Objects.requireNonNull(t10);
        return t10;
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw MelodyException.e(0, "clone not supported");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Class<?> cls = getClass();
        if (cls != obj.getClass()) {
            return false;
        }
        try {
            for (Field field : getClassFields(cls)) {
                Object obj2 = field.get(this);
                Object obj3 = field.get(obj);
                if (!Objects.deepEquals(obj2, obj3)) {
                    return false;
                }
                if (A.k() && hashCodeOf(obj2) != hashCodeOf(obj3)) {
                    A.w(TAG, "数据序列化哈希异常 " + cls.getName() + '#' + field.getName(), null);
                }
            }
        } catch (Exception e10) {
            A.i(TAG, cls.getName().concat(".equals"), e10);
        }
        return true;
    }

    public final Map<String, Integer> getFieldHashCodes() {
        androidx.collection.a aVar = new androidx.collection.a();
        Class<?> cls = getClass();
        try {
            for (Field field : getClassFields(cls)) {
                aVar.put(field.getName(), Integer.valueOf(hashCodeOf(field.get(this))));
            }
        } catch (Exception e10) {
            A.i(TAG, cls.getName().concat(".getFieldHashCodes"), e10);
        }
        return aVar;
    }

    public final int hashCode() {
        Class<?> cls = getClass();
        int iHashCodeOf = 0;
        try {
            Iterator<Field> it = getClassFields(cls).iterator();
            while (it.hasNext()) {
                iHashCodeOf = hashCodeOf(it.next().get(this)) + (iHashCodeOf * 31);
            }
            return iHashCodeOf;
        } catch (Exception e10) {
            A.i(TAG, cls.getName().concat(".hashCode"), e10);
            return iHashCodeOf;
        }
    }

    public final String toString() {
        if (A.l()) {
            return getClass().getSimpleName() + A.e(this);
        }
        return getClass().getName() + '@' + K.f(this);
    }
}
