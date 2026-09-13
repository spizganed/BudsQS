package com.oplus.melody.model.repository.whitelist;

import A9.q;
import Bc.e;
import D7.C0382p;
import D7.C0390y;
import D7.C0391z;
import D7.o0;
import Ea.C;
import F8.g;
import J8.d;
import Jb.b;
import Kb.l;
import a9.C0531H;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Base64;
import androidx.lifecycle.s;
import androidx.lifecycle.v;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.data.DiagnosisConfigDTO;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.data.WhitelistContentDO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.U;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.db.ProvisionalWhitelistEntity;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import la.C1294g;
import n8.C1354b;
import o8.AbstractC1382a;
import q9.m;
import r9.C1479c;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: WhitelistRepositoryServerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends AbstractC1508a {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final long f20140A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final WhitelistOutsideSnapshot f20141B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final List<String> f20142y = l.e("0000079A-D102-11E1-9B23-00025B00A5A5", "00001107-D102-11E1-9B23-00025B00A5A5");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f20143z;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<DiagnosisConfigDTO> f20144p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f20146r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f20148t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CompletableFuture<?> f20150v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile WhitelistOutsideSnapshot f20152x;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f20145q = kotlin.a.a(new G6.a(8));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final O7.l<WhitelistContentDO> f20147s = new O7.l<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m f20149u = new m(this, 3);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicBoolean f20151w = new AtomicBoolean(true);

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.whitelist.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WhitelistRepositoryServerImpl.kt */
    public static final class C0233a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wb.l f20153a;

        public C0233a(Wb.l lVar) {
            this.f20153a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20153a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20153a.d(obj);
        }
    }

    static {
        TimeUnit.MINUTES.toMillis(10L);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f20143z = timeUnit.toMillis(30L);
        f20140A = timeUnit.toMillis(3L);
        f20141B = new WhitelistOutsideSnapshot(VersionInfo.VENDOR_CODE_DEFAULT_VERSION, EmptyList.f25350a);
    }

    public a() {
        int i10 = 12;
        this.f20146r = kotlin.a.a(new e(this, i10));
        this.f20148t = kotlin.a.a(new d(this, i10));
        CompletableFuture<?> completableFutureWhenComplete = CompletableFuture.supplyAsync(new m4.e(this, 4)).thenCombine((CompletionStage) CompletableFuture.supplyAsync(new C1294g(this, 16)).exceptionally((Function) new s8.d(0)), (BiFunction) new C0390y(new g(this, 16), 4)).whenComplete((BiConsumer) new q(new s8.e(SystemClock.elapsedRealtime()), 24));
        h.d(completableFutureWhenComplete, "whenComplete(...)");
        this.f20150v = completableFutureWhenComplete;
        completableFutureWhenComplete.exceptionally((Function<Throwable, ? extends Object>) new s8.d(1)).thenAccept((Consumer<? super Object>) new E9.q(new C1479c(this, 1), 23));
    }

    public static WhitelistConfigDTO l(ProvisionalWhitelistEntity provisionalWhitelistEntity, WhitelistConfigDTO.Rssi rssi, int i10) {
        WhitelistConfigDTO.Rssi rssi2;
        A.c("WhitelistRepository", new C(i10, provisionalWhitelistEntity, 8));
        WhitelistConfigDTO whitelistConfigDTO = new WhitelistConfigDTO(null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, 0, false, null, null, 524287, null);
        whitelistConfigDTO.setId(provisionalWhitelistEntity.getPid());
        whitelistConfigDTO.setName(provisionalWhitelistEntity.getName());
        whitelistConfigDTO.setBrand(provisionalWhitelistEntity.getBrand());
        String type = provisionalWhitelistEntity.getType();
        if (type == null) {
            type = "";
        }
        whitelistConfigDTO.setType(type);
        if (provisionalWhitelistEntity.getUuid() != null) {
            whitelistConfigDTO.setUuid(provisionalWhitelistEntity.getUuid());
            whitelistConfigDTO.setSupportSpp(true);
        } else {
            whitelistConfigDTO.setSupportSpp(false);
        }
        WhitelistConfigDTO.Function function = new WhitelistConfigDTO.Function(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, 0, 0, null, 0, null, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, null, null, 0, 0, 0, 0, false, null, 0, 0, 0, 0, 0, null, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, -1, -1, -1, 536870911, null);
        function.setFastDiscovery(provisionalWhitelistEntity.getFastDiscovery());
        function.setHideFromUIList(1);
        whitelistConfigDTO.setFunction(function);
        if (rssi == null) {
            rssi2 = new WhitelistConfigDTO.Rssi(0, 0, 0, 0, 0, 31, null);
            rssi2.setFirstRssi(50);
            rssi2.setSecondRssi(55);
        } else {
            rssi2 = rssi;
        }
        whitelistConfigDTO.setRssi(rssi2);
        whitelistConfigDTO.setCoreFrom(i10);
        return whitelistConfigDTO;
    }

    public static Object m(InputStream inputStream, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        inputStream.read(bArr2);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE, bArr2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKeySpec, gCMParameterSpec);
        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(cipherInputStream);
            try {
                Object objF = C0917x.f(gZIPInputStream, WhitelistContentDO.class);
                gZIPInputStream.close();
                cipherInputStream.close();
                return objF;
            } finally {
            }
        } finally {
        }
    }

    public static void n(FileOutputStream fileOutputStream, byte[] bArr, File file) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        U.f19475a.nextBytes(bArr2);
        fileOutputStream.write(bArr2);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE, bArr2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, gCMParameterSpec);
        CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher);
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(cipherOutputStream);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    C0911q.d(fileInputStream, gZIPOutputStream);
                    Jb.l lVar = Jb.l.f2618a;
                    fileInputStream.close();
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    cipherOutputStream.close();
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static File o(String str) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            return new File(heyMelodyApplication.getFilesDir(), str);
        }
        h.i("context");
        throw null;
    }

    public static byte[] p() {
        byte[] bArrDecode;
        SharedPreferences sharedPreferencesC = t8.q.c("melody-model-settings");
        h.d(sharedPreferencesC, "getSettings(...)");
        String string = sharedPreferencesC.getString("whitelistSecretKey", null);
        if (string == null || string.length() == 0) {
            bArrDecode = new byte[0];
        } else {
            bArrDecode = Base64.decode(string, 0);
            h.d(bArrDecode, "decode(...)");
        }
        if (bArrDecode.length != 0) {
            return bArrDecode;
        }
        byte[] bArr = new byte[32];
        U.f19475a.nextBytes(bArr);
        SharedPreferences.Editor editorEdit = sharedPreferencesC.edit();
        String strEncodeToString = Base64.encodeToString(bArr, 0);
        h.d(strEncodeToString, "encodeToString(...)");
        editorEdit.putString("whitelistSecretKey", strEncodeToString);
        editorEdit.commit();
        return bArr;
    }

    public static String q(WhitelistConfigDTO whitelistConfigDTO) {
        return whitelistConfigDTO.getId() + "(" + A.q(whitelistConfigDTO.getName()) + ")";
    }

    public static WhitelistContentDO r(WhitelistContentDO whitelistContentDO, List list) {
        if (list != null && !list.isEmpty()) {
            com.oplus.melody.common.data.a aVarCopyOf = com.oplus.melody.common.data.a.copyOf(whitelistContentDO, WhitelistContentDO.class);
            h.d(aVarCopyOf, "copyOf(...)");
            whitelistContentDO = (WhitelistContentDO) aVarCopyOf;
            List<WhitelistConfigDTO> whiteList = whitelistContentDO.getWhiteList();
            if (whiteList == null) {
                whiteList = Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList(whiteList);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WhitelistConfigDTO whitelistConfigDTO = (WhitelistConfigDTO) it.next();
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        if (h.a(whitelistConfigDTO.getId(), ((WhitelistConfigDTO) obj).getId())) {
                            break;
                        }
                    }
                }
                arrayList.add(whitelistConfigDTO);
            }
            whitelistContentDO.setWhiteList(arrayList);
        }
        return whitelistContentDO;
    }

    @Override // s8.AbstractC1508a
    public final WhitelistConfigDTO a(String str) {
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str);
        if (earphoneDTOW != null) {
            return c(earphoneDTOW.getProductId(), earphoneDTOW.getName());
        }
        C0391z.f1171d.getClass();
        return Y.b(C0391z.i(str), g());
    }

    @Override // s8.AbstractC1508a
    public final WhitelistConfigDTO c(String str, String str2) {
        return Y.a(g(), str, str2);
    }

    @Override // s8.AbstractC1508a
    public final List<DiagnosisConfigDTO> e() {
        List<DiagnosisConfigDTO> list = this.f20144p;
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        h.d(list, "nullToEmpty(...)");
        return list;
    }

    @Override // s8.AbstractC1508a
    public final List<WhitelistConfigDTO> g() {
        WhitelistContentDO whitelistContentDOH = h();
        List<WhitelistConfigDTO> whiteList = whitelistContentDOH != null ? whitelistContentDOH.getWhiteList() : null;
        if (whiteList == null) {
            whiteList = Collections.EMPTY_LIST;
        }
        h.d(whiteList, "nullToEmpty(...)");
        return whiteList;
    }

    @Override // s8.AbstractC1508a
    public final WhitelistContentDO h() {
        try {
            return (WhitelistContentDO) this.f20150v.thenApply((Function<? super Object, ? extends U>) new C1354b(new C0531H(this, 18), 4)).get(f20140A, TimeUnit.MILLISECONDS);
        } catch (Exception e10) {
            A.x("WhitelistRepository", "getWhitelistContent: wait first task failed by ".concat(e10.getClass().getSimpleName()));
            return this.f20147s.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bb  */
    @Override // K7.b, android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r14) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.model.repository.whitelist.a.handleMessage(android.os.Message):boolean");
    }

    @Override // s8.AbstractC1508a
    public final s<WhitelistContentDO> i() {
        return (s) this.f20148t.getValue();
    }

    @Override // s8.AbstractC1508a
    public final WhitelistOutsideSnapshot j() {
        if (this.f20152x == null) {
            synchronized (this) {
                try {
                    if (this.f20152x == null) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        WhitelistOutsideSnapshot whitelistOutsideSnapshot = (WhitelistOutsideSnapshot) C0911q.q(o("melody-model-whitelist/outside_snapshot.json"), WhitelistOutsideSnapshot.class);
                        if (whitelistOutsideSnapshot == null) {
                            whitelistOutsideSnapshot = f20141B;
                        }
                        A.c("WhitelistRepository", new E9.s(2, jElapsedRealtime));
                        this.f20152x = whitelistOutsideSnapshot;
                    }
                    Jb.l lVar = Jb.l.f2618a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        WhitelistOutsideSnapshot whitelistOutsideSnapshot2 = this.f20152x;
        return whitelistOutsideSnapshot2 == null ? f20141B : whitelistOutsideSnapshot2;
    }

    @Override // s8.AbstractC1508a
    public final void k(String str) {
        J7.b.a().d();
        A.b("WhitelistRepository", "refreshWhitelist: IGNORE export");
    }

    public final void s(long j5, String str, boolean z2) {
        Handler handlerA = o0.c.f1145c.a();
        m mVar = this.f20149u;
        handlerA.removeCallbacks(mVar);
        if (z2) {
            Object obj = AbstractC1382a.f26570c;
            if (AbstractC1382a.C0294a.a().d()) {
                A.c("WhitelistRepository", new C0382p(str, j5));
                handlerA.postDelayed(mVar, j5);
                return;
            }
        }
        A.c("WhitelistRepository", new D6.f(str, 24));
    }
}
