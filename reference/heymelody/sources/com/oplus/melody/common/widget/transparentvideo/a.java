package com.oplus.melody.common.widget.transparentvideo;

import Ca.n;
import D7.RunnableC0369c;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.common.widget.transparentvideo.b;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: GLRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b.m, SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f19544A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f19545B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int f19546C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f19547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FloatBuffer f19548b;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float[] f19550p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19551q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19552r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f19553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f19554t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f19556v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SurfaceTexture f19557w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public n f19559y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f19560z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f19549c = new float[16];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f19558x = false;

    public a() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f19547a = fArr;
        float[] fArr2 = new float[16];
        this.f19550p = fArr2;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f19548b = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(fArr2, 0);
    }

    public static void a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        A.h("GLRenderer", str + ": glError " + iGlGetError);
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public static int b(int i10, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                A.h("GLRenderer", "Could not compile shader " + i10 + ":");
                A.h("GLRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                return 0;
            }
        }
        return iGlCreateShader;
    }

    public final void c() {
        synchronized (this) {
            try {
                if (this.f19558x) {
                    this.f19557w.updateTexImage();
                    this.f19557w.getTransformMatrix(this.f19550p);
                    this.f19558x = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        GLES20.glClear(16640);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.f19551q);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f19552r);
        this.f19548b.position(0);
        GLES20.glVertexAttribPointer(this.f19555u, 3, 5126, false, 20, (Buffer) this.f19548b);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f19555u);
        a("glEnableVertexAttribArray aPositionHandle");
        this.f19548b.position(3);
        GLES20.glVertexAttribPointer(this.f19556v, 3, 5126, false, 20, (Buffer) this.f19548b);
        a("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f19556v);
        a("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.f19549c, 0);
        GLES20.glUniformMatrix4fv(this.f19553s, 1, false, this.f19549c, 0);
        GLES20.glUniformMatrix4fv(this.f19554t, 1, false, this.f19550p, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
    }

    public final void d() {
        int iB;
        int iGlCreateProgram;
        int iB2 = b(35633, C0911q.r(C0906l.f19501a, R.raw.melody_common_vertex_shader));
        if (iB2 == 0 || (iB = b(35632, C0911q.r(C0906l.f19501a, R.raw.melody_common_alpha_shader))) == 0) {
            iGlCreateProgram = 0;
        } else {
            iGlCreateProgram = GLES20.glCreateProgram();
            if (iGlCreateProgram != 0) {
                GLES20.glAttachShader(iGlCreateProgram, iB2);
                a("glAttachShader");
                GLES20.glAttachShader(iGlCreateProgram, iB);
                a("glAttachShader");
                GLES20.glLinkProgram(iGlCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    A.h("GLRenderer", "Could not link program: ");
                    A.h("GLRenderer", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                    GLES20.glDeleteProgram(iGlCreateProgram);
                    iGlCreateProgram = 0;
                }
            }
        }
        this.f19551q = iGlCreateProgram;
        if (iGlCreateProgram == 0) {
            return;
        }
        this.f19555u = GLES20.glGetAttribLocation(iGlCreateProgram, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f19555u == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.f19556v = GLES20.glGetAttribLocation(this.f19551q, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.f19556v == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.f19553s = GLES20.glGetUniformLocation(this.f19551q, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.f19553s == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.f19554t = GLES20.glGetUniformLocation(this.f19551q, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.f19554t == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        int i10 = iArr2[0];
        this.f19552r = i10;
        GLES20.glBindTexture(36197, i10);
        a("glBindTexture textureID");
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f19552r);
        this.f19557w = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        Surface surface = new Surface(this.f19557w);
        n nVar = this.f19559y;
        nVar.getClass();
        int i11 = AlphaMovieView.f19531K;
        AlphaMovieView.f(new RunnableC0369c(4, (AlphaMovieView) nVar.f817b, surface));
        synchronized (this) {
            this.f19558x = false;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f19558x = true;
    }
}
