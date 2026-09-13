package com.oplus.melody.model.net;

import androidx.media3.exoplayer.C0625v;
import androidx.media3.session.D0;
import com.oplus.melody.common.util.C0917x;
import ec.C1030a;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import retrofit2.g;
import uc.s;

/* JADX INFO: renamed from: com.oplus.melody.model.net.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonConverterFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C0934c extends g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0934c f19820a = new C0934c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaType f19821b;

    static {
        MediaType.INSTANCE.getClass();
        f19821b = MediaType.Companion.b("application/json; charset=UTF-8");
    }

    @Override // retrofit2.g.a
    public final retrofit2.g<?, okhttp3.h> a(Type type, Annotation[] annotationArr, Annotation[] methodAnnotations, retrofit2.z retrofit) {
        kotlin.jvm.internal.h.e(type, "type");
        kotlin.jvm.internal.h.e(methodAnnotations, "methodAnnotations");
        kotlin.jvm.internal.h.e(retrofit, "retrofit");
        return new C0625v(21);
    }

    @Override // retrofit2.g.a
    public final retrofit2.g<uc.s, ?> b(final Type type, Annotation[] annotations, retrofit2.z retrofit) {
        kotlin.jvm.internal.h.e(annotations, "annotations");
        kotlin.jvm.internal.h.e(retrofit, "retrofit");
        return new retrofit2.g() { // from class: com.oplus.melody.model.net.b
            @Override // retrofit2.g
            public final Object a(Object obj) throws IOException {
                String strJ;
                Charset charsetCharset$default;
                Type type2 = type;
                uc.s sVar = (uc.s) obj;
                try {
                    if (type2.equals(String.class)) {
                        strJ = sVar.j();
                    } else {
                        s.a aVar = sVar.f28267a;
                        if (aVar == null) {
                            Kc.d dVarD = sVar.d();
                            MediaType mediaTypeC = sVar.c();
                            if (mediaTypeC == null || (charsetCharset$default = MediaType.charset$default(mediaTypeC, null, 1, null)) == null) {
                                charsetCharset$default = C1030a.f22972b;
                            }
                            aVar = new s.a(dVarD, charsetCharset$default);
                            sVar.f28267a = aVar;
                        }
                        strJ = (String) C0917x.j("readCharStream", new com.oplus.anim.s(1, type2, aVar));
                    }
                    E8.a.i(sVar, null);
                    return strJ;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        E8.a.i(sVar, th);
                        throw th2;
                    }
                }
            }
        };
    }

    @Override // retrofit2.g.a
    public final retrofit2.g<?, String> c(Type type, Annotation[] annotationArr, retrofit2.z retrofit) {
        kotlin.jvm.internal.h.e(type, "type");
        kotlin.jvm.internal.h.e(retrofit, "retrofit");
        if (type.equals(String.class)) {
            return null;
        }
        return new D0(13);
    }
}
