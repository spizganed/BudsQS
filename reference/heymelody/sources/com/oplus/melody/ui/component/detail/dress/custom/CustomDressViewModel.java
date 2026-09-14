package com.oplus.melody.ui.component.detail.dress.custom;

import Ea.X;
import O7.l;
import android.graphics.Bitmap;
import android.os.SystemClock;
import androidx.lifecycle.L;
import androidx.lifecycle.u;
import c9.j;
import c9.n;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import ec.k;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import u8.C1555c;

/* JADX INFO: compiled from: CustomDressViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u000108¢\u0006\u0002\u0010<J\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001a0rJ\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u001a0rJ\u0014\u0010t\u001a\b\u0012\u0004\u0012\u00020)0u2\u0006\u0010v\u001a\u00020)J\f\u0010w\u001a\b\u0012\u0004\u0012\u00020)0uJ\f\u0010x\u001a\b\u0012\u0004\u0012\u00020)0uJ\f\u0010y\u001a\b\u0012\u0004\u0012\u00020)0uJ\u0014\u0010z\u001a\b\u0012\u0004\u0012\u00020)0u2\u0006\u0010{\u001a\u00020\u0005J\u000e\u0010|\u001a\u00020o2\u0006\u0010{\u001a\u00020\u0005J\u000e\u0010}\u001a\u00020o2\u0006\u0010~\u001a\u00020)J\u0015\u0010\u007f\u001a\u0011\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010 0\u0080\u00010uJ \u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020 0u2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020\u0005J\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050rJ\t\u0010\u0086\u0001\u001a\u00020 H\u0002J\u001b\u0010\u0087\u0001\u001a\u00020 2\u0007\u0010\u0088\u0001\u001a\u00020\u00052\u0007\u0010\u0089\u0001\u001a\u00020YH\u0002J\t\u0010\u008a\u0001\u001a\u00020 H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020 J\u0007\u0010\u008c\u0001\u001a\u00020 J\t\u0010\u008d\u0001\u001a\u00020oH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001e\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0019\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010I0H¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0019\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0M¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0019\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050M¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010OR\u0019\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0M¢\u0006\b\n\u0000\u001a\u0004\bS\u0010OR\u0019\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0M¢\u0006\b\n\u0000\u001a\u0004\bU\u0010OR\u0019\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050M¢\u0006\b\n\u0000\u001a\u0004\bW\u0010OR\u0019\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0M¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010OR\u0019\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0M¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010OR\u0019\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0M¢\u0006\b\n\u0000\u001a\u0004\b^\u0010OR\u0019\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050M¢\u0006\b\n\u0000\u001a\u0004\b`\u0010OR\u0019\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0M¢\u0006\b\n\u0000\u001a\u0004\bb\u0010OR\u0019\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0M¢\u0006\b\n\u0000\u001a\u0004\bd\u0010OR\u0019\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0M¢\u0006\b\n\u0000\u001a\u0004\bf\u0010OR\u0019\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0M¢\u0006\b\n\u0000\u001a\u0004\bh\u0010OR\u0019\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0M¢\u0006\b\n\u0000\u001a\u0004\bj\u0010OR\u001c\u0010k\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\"\"\u0004\bm\u0010$¨\u0006\u008f\u0001"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/custom/CustomDressViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mDeviceName", "getMDeviceName", "setMDeviceName", "mProductId", "getMProductId", "setMProductId", "mColorId", "getMColorId", "setMColorId", "mDressId", "getMDressId", "setMDressId", "mAppliedDressId", "getMAppliedDressId", "setMAppliedDressId", "mDressVersion", "", "getMDressVersion", "()I", "setMDressVersion", "(I)V", "mBgFile", "Ljava/io/File;", "getMBgFile", "()Ljava/io/File;", "setMBgFile", "(Ljava/io/File;)V", "mSrcFile", "getMSrcFile", "setMSrcFile", "mSrcFileChanged", "", "getMSrcFileChanged", "()Z", "setMSrcFileChanged", "(Z)V", "mSrcBitmap", "Landroid/graphics/Bitmap;", "getMSrcBitmap", "()Landroid/graphics/Bitmap;", "setMSrcBitmap", "(Landroid/graphics/Bitmap;)V", "mBlurBitmap", "getMBlurBitmap", "setMBlurBitmap", "mLuminance", "", "getMLuminance", "()Ljava/lang/Double;", "setMLuminance", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "mVideoPlayPosition", "getMVideoPlayPosition", "setMVideoPlayPosition", "mCustomDress", "Lcom/oplus/melody/model/zipdata/CustomDressDO;", "getMCustomDress", "()Lcom/oplus/melody/model/zipdata/CustomDressDO;", "setMCustomDress", "(Lcom/oplus/melody/model/zipdata/CustomDressDO;)V", "mUiModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/oplus/melody/ui/component/detail/dress/custom/UiModel;", "getMUiModel", "()Landroidx/lifecycle/MutableLiveData;", "mIsSaving", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "getMIsSaving", "()Lcom/oplus/melody/model/helper/MelodyLiveData;", "mMask", "getMMask", "mDarkImg", "getMDarkImg", "mBlurProgress", "getMBlurProgress", "mDressName", "getMDressName", "mDialogTime", "", "getMDialogTime", "mComponentTime", "getMComponentTime", "mComponentUiMode", "getMComponentUiMode", "mPrompt", "getMPrompt", "mShowPrompt", "getMShowPrompt", "mShowModel", "getMShowModel", "mShowBattery", "getMShowBattery", "mBatteryStyle", "getMBatteryStyle", "mPopupSourceState", "getMPopupSourceState", "mCopyTempFile", "getMCopyTempFile", "setMCopyTempFile", "setLuminance", "", "luminance", "getConnectionState", "Landroidx/lifecycle/LiveData;", "getHeadsetConnectionState", "createDress", "Ljava/util/concurrent/CompletableFuture;", "isPreview", "applyDress", "deleteDress", "loadCurrentDress", "loadDefaultConfig", "mimeType", "updateConfig", "loadDefaultPopupSource", "fromClick", "getBoxBudsRes", "", "saveAlbumTempFile", "uri", "Landroid/net/Uri;", SpeechFindManager.TYPE, "getAppliedDressId", "createTempDir", "getAlbumTempFile", "suffix", "timestamp", "getNoAudioTempFile", "getCameraTempFile", "getCropTempFile", "onCleared", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomDressViewModel extends L {

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public File f20915F;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f20922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public File f20923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Bitmap f20925l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap f20926m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Double f20927n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public C1555c f20929p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20916b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20917c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20918d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20919e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f20920f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f20921g = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20928o = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u<n> f20930q = new u<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l<Boolean> f20931r = new l<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final l<String> f20932s = new l<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final l<Boolean> f20933t = new l<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l<Integer> f20934u = new l<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l<String> f20935v = new l<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l<Long> f20936w = new l<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l<Long> f20937x = new l<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l<Integer> f20938y = new l<>();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l<String> f20939z = new l<>();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final l<Boolean> f20910A = new l<>();

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final l<Boolean> f20911B = new l<>();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final l<Boolean> f20912C = new l<>();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final l<Integer> f20913D = new l<>();

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final l<Integer> f20914E = new l<>();

    public static File e() {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        File file = new File(heyMelodyApplication.getCacheDir(), "custom_dress");
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    @Override // androidx.lifecycle.L
    public final void c() {
        ForkJoinPool.commonPool().execute(new L6.c(2));
    }

    public final CompletableFuture<Boolean> d(final boolean z2) {
        n nVarD = this.f20930q.d();
        final String str = nVarD != null ? nVarD.f13536a : "";
        String strD = this.f20935v.d();
        final String str2 = strD == null ? "" : strD;
        if (!z2) {
            this.f20931r.m(Boolean.TRUE);
        }
        final long jElapsedRealtime = !z2 ? SystemClock.elapsedRealtime() : 0L;
        CompletableFuture<Boolean> completableFutureExceptionally = CompletableFuture.supplyAsync(new Supplier() { // from class: c9.i
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:428:0x072e  */
            /* JADX WARN: Removed duplicated region for block: B:431:0x0737  */
            /* JADX WARN: Removed duplicated region for block: B:432:0x073f  */
            /* JADX WARN: Type inference failed for: r11v3, types: [T, java.io.File] */
            @Override // java.util.function.Supplier
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object get() {
                /*
                    Method dump skipped, instruction units count: 1960
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: c9.i.get():java.lang.Object");
            }
        }).whenComplete((BiConsumer) new A9.c(new j(z2, this, str), 14)).exceptionally((Function) new A6.c(23));
        h.d(completableFutureExceptionally, "exceptionally(...)");
        return completableFutureExceptionally;
    }

    public final void f(boolean z2) {
        Integer numB;
        A.c("CustomDressViewModel", new X(this, z2, 4));
        l<Integer> lVar = this.f20914E;
        if ((z2 || lVar.d() == null) && (numB = k.B(this.f20919e)) != null) {
            int iIntValue = numB.intValue();
            lVar.m(2);
            CompletableFuture completableFutureF = Z7.a.g().f(iIntValue, false, this.f20918d);
            if (completableFutureF != null) {
                completableFutureF.whenComplete((BiConsumer) new B9.b(new B9.a(this, 12), 24));
            }
        }
    }

    public final void g(Double d10) {
        Boolean boolValueOf;
        this.f20927n = d10;
        if (d10 != null) {
            boolValueOf = Boolean.valueOf(d10.doubleValue() < 0.3d);
        } else {
            boolValueOf = null;
        }
        this.f20933t.m(boolValueOf);
    }
}
