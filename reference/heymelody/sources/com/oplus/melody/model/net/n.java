package com.oplus.melody.model.net;

import android.annotation.SuppressLint;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.net.data.CoverImageInfoDO;
import com.oplus.melody.model.net.data.DevicePictureInfoDO;
import com.oplus.melody.model.net.data.FirmwareInfoDO;
import com.oplus.melody.model.net.data.PersonalDressInfoDO;
import com.oplus.melody.model.net.data.PersonalDressSeriesInfoDO;
import com.oplus.melody.model.net.data.ResourceFetchDO;
import com.oplus.melody.model.net.data.ResourceInfoDO;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends K7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile n f19833c;

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class a extends C0935d<List<CoverImageInfoDO>> {
        private a() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class b extends C0935d<List<DevicePictureInfoDO>> {
        private b() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class c extends C0935d<FirmwareInfoDO> {
        private c() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class d extends C0935d<PersonalDressInfoDO> {
        private d() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class e extends C0935d<List<PersonalDressInfoDO>> {
        private e() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class f extends C0935d<List<PersonalDressSeriesInfoDO>> {
        private f() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class g extends C0935d<ResourceFetchDO> {
        private g() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class h extends C0935d<ResourceInfoDO> {
        private h() {
        }
    }

    /* JADX INFO: compiled from: SmartHomeIotCallHelper.java */
    public static final class i extends C0935d<List<ZenModeInfoDO>> {
        private i() {
        }
    }

    public n() {
        super(DcsCompatEventConverter.DATA_TYPE_COMMON_MIX_LIST);
    }

    public static n b() {
        if (f19833c == null) {
            synchronized (n.class) {
                try {
                    if (f19833c == null) {
                        if (E7.a.d(C0906l.f19501a)) {
                            f19833c = new E();
                        } else {
                            f19833c = new o();
                        }
                    }
                } finally {
                }
            }
        }
        return f19833c;
    }

    @SuppressLint({"WrongConstant"})
    public static Object m(Class cls, String str) {
        C0935d c0935d = (C0935d) C0917x.c(cls, str);
        if (c0935d == null) {
            throw MelodyException.e(0, "resp is null");
        }
        int code = c0935d.getCode();
        if (code == 0 || code == 200) {
            return c0935d.getData();
        }
        throw MelodyException.e(code, c0935d.getMsg());
    }

    public abstract CompletableFuture<File> a(String str, String str2, String str3, com.oplus.melody.model.repository.zenmode.c cVar);

    public abstract CompletableFuture c(ArrayList arrayList);

    public abstract CompletableFuture d(int i10, String str, String str2);

    public abstract CompletableFuture e(int i10, String str, String str2);

    public abstract CompletableFuture<String> f(String str, String str2, String str3, String str4, String str5, String str6);

    public abstract CompletableFuture<String> g(String str, String str2, int i10, int i11);

    public abstract CompletableFuture h(int i10, String str, String str2);

    public abstract CompletableFuture i(int i10, String str, String str2);

    public abstract CompletableFuture j(int i10, int i11, String str);

    public abstract CompletableFuture k(int i10, String str, String str2);

    public abstract CompletableFuture<String> l(String str, String str2, String str3);
}
