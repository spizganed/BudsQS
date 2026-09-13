package com.oplus.melody.ui.component.detail.zenmode.scene;

import D7.o0;
import E9.q;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.Q;
import com.oplus.melody.model.db.N;
import com.oplus.melody.model.db.s;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.earphone.C0945h;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.zenmode.ZenModeRepository;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: ZenModeDataCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<N> f21431a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.oplus.melody.model.repository.zenmode.d f21434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f21435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<Context> f21436f;
    public boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<ZenModeInfoDO> f21439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f21440k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f21432b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f21433c = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21437g = false;

    /* JADX INFO: compiled from: ZenModeDataCache.java */
    public interface a {
        void d();
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.zenmode.scene.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ZenModeDataCache.java */
    public static final class C0235b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21441a = new b();
    }

    public static boolean a() {
        if (!Q.c("android.permission.READ_PHONE_STATE")) {
            return false;
        }
        int callState = ((TelephonyManager) C0906l.f19501a.getSystemService("phone")).getCallState();
        return callState == 2 || callState == 1;
    }

    public final void b(Context context, String str, String str2) {
        this.f21436f = new WeakReference<>(context);
        o0.c.f1145c.execute(new H1.b(this, str, str2, 9));
        A.b("ZenModeDataCache", "zen mode initializing, startFetchRemoteData");
        this.f21438i = true;
        String string = C0906l.f19501a.getString(R.string.melody_common_language_tag);
        if (!string.startsWith(Locale.ENGLISH.getLanguage())) {
            ZenModeRepository.j().s(str, str2, "en-US").whenComplete((BiConsumer<? super List<ZenModeInfoDO>, ? super Throwable>) new C0945h(8));
        }
        CompletableFuture<List<ZenModeInfoDO>> completableFutureS = ZenModeRepository.j().s(str, str2, string);
        if (completableFutureS != null) {
            completableFutureS.thenAccept((Consumer<? super List<ZenModeInfoDO>>) new q(this, 9));
        }
    }

    public final void c() {
        if (this.f21434d == null) {
            return;
        }
        A.c("ZenModeDataCache", new X3.l(this, 17));
        if (TextUtils.equals(String.valueOf(this.f21434d.getFileId()), VersionInfo.VENDOR_CODE_ERROR_VERSION)) {
            this.f21435e = C0906l.f19501a.getString(R.string.melody_ui_zen_mode_scene_first_item_title);
            return;
        }
        List<ZenModeInfoDO> list = this.f21439j;
        if (list == null || list.size() <= 0) {
            this.f21435e = this.f21434d.getFileName();
            A.c("ZenModeDataCache", new I(this, 5));
            return;
        }
        for (ZenModeInfoDO zenModeInfoDO : this.f21439j) {
            if (TextUtils.equals(String.valueOf(this.f21434d.getFileId()), zenModeInfoDO.getResId())) {
                this.f21435e = zenModeInfoDO.getName();
                A.c("ZenModeDataCache", new com.oplus.melody.ui.component.detail.zenmode.scene.a(this, 0));
                return;
            }
        }
        A.c("ZenModeDataCache", new s(this, 6));
        this.f21435e = this.f21434d.getFileName();
    }
}
