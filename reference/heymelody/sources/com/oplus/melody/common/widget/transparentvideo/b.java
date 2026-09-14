package com.oplus.melody.common.widget.transparentvideo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.oplus.melody.common.util.A;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: GLTextureView.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f19561w = new j();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f19562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f19563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f19564c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f19566q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f19567r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g f19568s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f19569t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19570u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19571v;

    /* JADX INFO: compiled from: GLTextureView.java */
    public abstract class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f19572a;

        public a(int[] iArr) {
            if (b.this.f19570u == 2) {
                int length = iArr.length;
                int[] iArr2 = new int[length + 2];
                int i10 = length - 1;
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                iArr2[i10] = 12352;
                iArr2[length] = 4;
                iArr2[length + 1] = 12344;
                iArr = iArr2;
            }
            this.f19572a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.common.widget.transparentvideo.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GLTextureView.java */
    public class C0227b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f19574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f19576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f19577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f19578g;
        public final int h;

        public C0227b(int i10, int i11) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, i10, 12325, i11, 12326, 0, 12344});
            this.f19574c = new int[1];
            this.f19575d = 8;
            this.f19576e = 8;
            this.f19577f = 8;
            this.f19578g = i10;
            this.h = i11;
        }

        public final int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10) {
            int[] iArr = this.f19574c;
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i10, iArr)) {
                return iArr[0];
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public class c implements f {
        public c() {
        }
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public static class d implements g {
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public interface e {
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public interface f {
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public interface g {
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<b> f19581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EGL10 f19582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EGLDisplay f19583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EGLSurface f19584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public EGLConfig f19585e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EGLContext f19586f;

        public static void d(int i10, String str) {
            String str2 = str + " failed: " + i10;
            b.b("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + str2);
            throw new RuntimeException(str2);
        }

        public final boolean a() {
            b.b("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f19582b == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f19583c == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f19585e == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            b();
            b bVar = this.f19581a.get();
            EGLSurface eGLSurfaceEglCreateWindowSurface = null;
            if (bVar != null) {
                g gVar = bVar.f19568s;
                EGL10 egl10 = this.f19582b;
                EGLDisplay eGLDisplay = this.f19583c;
                EGLConfig eGLConfig = this.f19585e;
                SurfaceTexture surfaceTexture = bVar.getSurfaceTexture();
                ((d) gVar).getClass();
                try {
                    eGLSurfaceEglCreateWindowSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, surfaceTexture, null);
                } catch (IllegalArgumentException e10) {
                    j jVar = b.f19561w;
                    A.h("GLTextureView", A.e("eglCreateWindowSurface" + e10));
                }
                this.f19584d = eGLSurfaceEglCreateWindowSurface;
            } else {
                this.f19584d = null;
            }
            EGLSurface eGLSurface = this.f19584d;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.f19582b.eglGetError() != 12299) {
                    return false;
                }
                b.b("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                return false;
            }
            if (this.f19582b.eglMakeCurrent(this.f19583c, eGLSurface, eGLSurface, this.f19586f)) {
                return true;
            }
            b.b("EGLHelper", "eglMakeCurrent failed: " + this.f19582b.eglGetError());
            return false;
        }

        public final void b() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f19584d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f19582b.eglMakeCurrent(this.f19583c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            b bVar = this.f19581a.get();
            if (bVar != null) {
                g gVar = bVar.f19568s;
                EGL10 egl10 = this.f19582b;
                EGLDisplay eGLDisplay = this.f19583c;
                EGLSurface eGLSurface3 = this.f19584d;
                ((d) gVar).getClass();
                egl10.eglDestroySurface(eGLDisplay, eGLSurface3);
            }
            this.f19584d = null;
        }

        public final void c() {
            EGLConfig eGLConfig;
            b.b("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f19582b = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f19583c = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f19582b.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            b bVar = this.f19581a.get();
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (bVar == null) {
                this.f19585e = null;
                this.f19586f = null;
            } else {
                e eVar = bVar.f19566q;
                EGL10 egl102 = this.f19582b;
                EGLDisplay eGLDisplay = this.f19583c;
                a aVar = (a) eVar;
                int[] iArr = new int[1];
                if (!egl102.eglChooseConfig(eGLDisplay, aVar.f19572a, null, 0, iArr)) {
                    throw new IllegalArgumentException("eglChooseConfig failed");
                }
                int i10 = 0;
                int i11 = iArr[0];
                if (i11 <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i11];
                if (!egl102.eglChooseConfig(eGLDisplay, aVar.f19572a, eGLConfigArr, i11, iArr)) {
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                C0227b c0227b = (C0227b) aVar;
                while (true) {
                    if (i10 >= i11) {
                        eGLConfig = null;
                        break;
                    }
                    eGLConfig = eGLConfigArr[i10];
                    int iA = c0227b.a(egl102, eGLDisplay, eGLConfig, 12325);
                    int iA2 = c0227b.a(egl102, eGLDisplay, eGLConfig, 12326);
                    if (iA >= c0227b.h && iA2 >= 0) {
                        int iA3 = c0227b.a(egl102, eGLDisplay, eGLConfig, 12324);
                        int iA4 = c0227b.a(egl102, eGLDisplay, eGLConfig, 12323);
                        int iA5 = c0227b.a(egl102, eGLDisplay, eGLConfig, 12322);
                        int iA6 = c0227b.a(egl102, eGLDisplay, eGLConfig, 12321);
                        if (iA3 == c0227b.f19575d && iA4 == c0227b.f19576e && iA5 == c0227b.f19577f && iA6 == c0227b.f19578g) {
                            break;
                        }
                    }
                    i10++;
                }
                if (eGLConfig == null) {
                    throw new IllegalArgumentException("No config chosen");
                }
                this.f19585e = eGLConfig;
                f fVar = bVar.f19567r;
                EGL10 egl103 = this.f19582b;
                EGLDisplay eGLDisplay2 = this.f19583c;
                int i12 = b.this.f19570u;
                int[] iArr2 = {12440, i12, 12344};
                if (i12 == 0) {
                    iArr2 = null;
                }
                this.f19586f = egl103.eglCreateContext(eGLDisplay2, eGLConfig, eGLContext, iArr2);
            }
            EGLContext eGLContext2 = this.f19586f;
            if (eGLContext2 == null || eGLContext2 == eGLContext) {
                this.f19586f = null;
                d(this.f19582b.eglGetError(), "createContext");
                throw null;
            }
            b.b("EglHelper", "createContext " + this.f19586f + " tid=" + Thread.currentThread().getId());
            this.f19584d = null;
        }
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public static class i extends Thread {

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public h f19588B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public final WeakReference<b> f19589C;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19592c;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f19593p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f19594q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f19595r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f19596s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f19597t;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f19602y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final ArrayList<Runnable> f19603z = new ArrayList<>();

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public boolean f19587A = true;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f19598u = 0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f19599v = 0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f19601x = true;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f19600w = 1;

        public i(WeakReference<b> weakReference) {
            this.f19589C = weakReference;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:217:0x0172 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r2v44 */
        /* JADX WARN: Type inference failed for: r2v45, types: [java.io.Writer] */
        /* JADX WARN: Type inference failed for: r2v81 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:172:0x0380 -> B:175:0x038f). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 928
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.common.widget.transparentvideo.b.i.a():void");
        }

        public final boolean b() {
            if (!this.f19592c || this.f19593p || this.f19598u <= 0 || this.f19599v <= 0) {
                return false;
            }
            return this.f19601x || this.f19600w == 1;
        }

        public final void c() {
            j jVar = b.f19561w;
            synchronized (jVar) {
                this.f19590a = true;
                jVar.notifyAll();
                while (!this.f19591b) {
                    try {
                        b.f19561w.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public final void d(int i10) {
            if (i10 < 0 || i10 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            j jVar = b.f19561w;
            synchronized (jVar) {
                this.f19600w = i10;
                jVar.notifyAll();
            }
        }

        public final void e() {
            if (this.f19595r) {
                h hVar = this.f19588B;
                hVar.getClass();
                b.b("EglHelper", "finish() tid=" + Thread.currentThread().getId());
                if (hVar.f19586f != null) {
                    b bVar = hVar.f19581a.get();
                    if (bVar != null) {
                        f fVar = bVar.f19567r;
                        EGL10 egl10 = hVar.f19582b;
                        EGLDisplay eGLDisplay = hVar.f19583c;
                        EGLContext eGLContext = hVar.f19586f;
                        ((c) fVar).getClass();
                        if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                            b.b("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                            StringBuilder sb2 = new StringBuilder("tid=");
                            sb2.append(Thread.currentThread().getId());
                            b.b("DefaultContextFactory", sb2.toString());
                            h.d(egl10.eglGetError(), "eglDestroyContex");
                            throw null;
                        }
                    }
                    hVar.f19586f = null;
                }
                EGLDisplay eGLDisplay2 = hVar.f19583c;
                if (eGLDisplay2 != null) {
                    hVar.f19582b.eglTerminate(eGLDisplay2);
                    hVar.f19583c = null;
                }
                this.f19595r = false;
                j jVar = b.f19561w;
                if (jVar.f19608e == this) {
                    jVar.f19608e = null;
                }
                jVar.notifyAll();
            }
        }

        public final void f() {
            if (this.f19596s) {
                this.f19596s = false;
                h hVar = this.f19588B;
                hVar.getClass();
                b.b("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
                hVar.b();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("GLThread " + getId());
            b.b("GLThread", "starting tid=" + getId());
            try {
                a();
                b.f19561w.b(this);
            } catch (InterruptedException unused) {
                j jVar = b.f19561w;
                b.f19561w.b(this);
            } catch (Throwable th) {
                j jVar2 = b.f19561w;
                b.f19561w.b(this);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public i f19608e;

        public final synchronized void a(GL10 gl10) {
            if (!this.f19605b) {
                if (!this.f19604a) {
                    this.f19604a = true;
                }
                String strGlGetString = gl10.glGetString(7937);
                this.f19606c = !strGlGetString.startsWith("Q3Dimension MSM7500 ");
                notifyAll();
                this.f19607d = !this.f19606c;
                b.b("GLThreadManager", "checkGLDriver renderer = \"" + strGlGetString + "\" multipleContextsAllowed = " + this.f19606c + " mLimitedGLESContexts = " + this.f19607d);
                this.f19605b = true;
            }
        }

        public final synchronized void b(i iVar) {
            try {
                b.b("GLThread", "exiting tid=" + iVar.getId());
                iVar.f19591b = true;
                if (this.f19608e == iVar) {
                    this.f19608e = null;
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public interface k {
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public static class l extends Writer implements AutoCloseable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StringBuilder f19609a = new StringBuilder();

        public final void b() {
            StringBuilder sb2 = this.f19609a;
            if (sb2.length() > 0) {
                b.b("GLTextureView", sb2.toString());
                sb2.delete(0, sb2.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            b();
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
            b();
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                char c6 = cArr[i10 + i12];
                if (c6 == '\n') {
                    b();
                } else {
                    this.f19609a.append(c6);
                }
            }
        }
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public interface m {
    }

    /* JADX INFO: compiled from: GLTextureView.java */
    public class n extends C0227b {
        public n(boolean z2) {
            super(0, z2 ? 16 : 0);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19562a = new WeakReference<>(this);
        setSurfaceTextureListener(this);
    }

    public static void b(String str, String str2) {
        A.j(str, A.e(str2));
    }

    public final void a() {
        if (this.f19563b != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public final void c(int i10, int i11) {
        i iVar = this.f19563b;
        iVar.getClass();
        j jVar = f19561w;
        synchronized (jVar) {
            iVar.f19598u = i10;
            iVar.f19599v = i11;
            iVar.f19587A = true;
            iVar.f19601x = true;
            iVar.f19602y = false;
            jVar.notifyAll();
            while (!iVar.f19591b && !iVar.f19602y && iVar.f19595r && iVar.f19596s && iVar.b()) {
                b("Main thread", "onWindowResize waiting for render complete from tid=" + iVar.getId());
                try {
                    f19561w.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            i iVar = this.f19563b;
            if (iVar != null) {
                iVar.c();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.f19569t;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f19571v;
    }

    public int getRenderMode() {
        int i10;
        i iVar = this.f19563b;
        iVar.getClass();
        synchronized (f19561w) {
            i10 = iVar.f19600w;
        }
        return i10;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        int i10;
        super.onAttachedToWindow();
        b("GLTextureView", "onAttachedToWindow reattach =" + this.f19565p);
        if (this.f19565p && this.f19564c != null) {
            i iVar = this.f19563b;
            if (iVar != null) {
                synchronized (f19561w) {
                    i10 = iVar.f19600w;
                }
            } else {
                i10 = 1;
            }
            i iVar2 = new i(this.f19562a);
            this.f19563b = iVar2;
            if (i10 != 1) {
                iVar2.d(i10);
            }
            this.f19563b.start();
        }
        this.f19565p = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        b("GLTextureView", "onDetachedFromWindow");
        i iVar = this.f19563b;
        if (iVar != null) {
            iVar.c();
        }
        this.f19565p = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        getSurfaceTexture();
        c(i12 - i10, i13 - i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        i iVar = this.f19563b;
        iVar.getClass();
        j jVar = f19561w;
        synchronized (jVar) {
            b("GLThread", "surfaceCreated tid=" + iVar.getId());
            iVar.f19592c = true;
            jVar.notifyAll();
            while (iVar.f19594q && !iVar.f19591b) {
                try {
                    f19561w.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        c(i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        i iVar = this.f19563b;
        iVar.getClass();
        j jVar = f19561w;
        synchronized (jVar) {
            b("GLThread", "surfaceDestroyed tid=" + iVar.getId());
            iVar.f19592c = false;
            jVar.notifyAll();
            while (!iVar.f19594q && !iVar.f19591b) {
                try {
                    f19561w.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        c(i10, i11);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        i iVar = this.f19563b;
        iVar.getClass();
        j jVar = f19561w;
        synchronized (jVar) {
            iVar.f19601x = true;
            jVar.notifyAll();
        }
    }

    public void setDebugFlags(int i10) {
        this.f19569t = i10;
    }

    public void setEGLConfigChooser(e eVar) {
        a();
        this.f19566q = eVar;
    }

    public void setEGLContextClientVersion(int i10) {
        a();
        this.f19570u = i10;
    }

    public void setEGLContextFactory(f fVar) {
        a();
        this.f19567r = fVar;
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        a();
        this.f19568s = gVar;
    }

    public void setPreserveEGLContextOnPause(boolean z2) {
        this.f19571v = z2;
    }

    public void setRenderMode(int i10) {
        this.f19563b.d(i10);
    }

    public void setRenderer(m mVar) {
        a();
        if (this.f19566q == null) {
            this.f19566q = new n(true);
        }
        if (this.f19567r == null) {
            this.f19567r = new c();
        }
        if (this.f19568s == null) {
            this.f19568s = new d();
        }
        this.f19564c = mVar;
        i iVar = new i(this.f19562a);
        this.f19563b = iVar;
        iVar.start();
    }

    public void setEGLConfigChooser(boolean z2) {
        setEGLConfigChooser(new n(z2));
    }

    public void setGLWrapper(k kVar) {
    }
}
