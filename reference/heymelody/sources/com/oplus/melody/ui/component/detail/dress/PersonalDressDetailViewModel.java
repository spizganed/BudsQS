package com.oplus.melody.ui.component.detail.dress;

import A6.p;
import A9.c;
import A9.n;
import A9.o;
import A9.s;
import B9.f;
import D7.C0379m;
import D7.C0381o;
import E8.e;
import Ea.C0403l;
import Ea.C0406o;
import F8.i;
import O7.l;
import T8.d;
import a9.C0550p;
import a9.C0552r;
import a9.v;
import a9.w;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.L;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarToneDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.personaldress.ToneFileVerifyInformationDTO;
import com.oplus.melody.model.repository.personaldress.ToneStateInfoDTO;
import com.oplus.melody.model.repository.personaldress.a;
import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import u8.C1554b;

/* JADX INFO: compiled from: PersonalDressDetailViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 U2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0014J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020\u000bJ\f\u0010-\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010.\u001a\u00020%J\u0006\u0010/\u001a\u00020\u0006J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006J$\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0006J\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fJ\u000e\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u000bJ\u0006\u00108\u001a\u00020%J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fJ\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100\u001fJ\b\u0010;\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010<\u001a\u00020\u000bJ\u0010\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u0010H\u0002J\u0012\u0010?\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010>\u001a\u00020\u0010J\u001a\u0010@\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010A\u001a\u00020#J\u001a\u0010B\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010A\u001a\u00020#J\u000e\u0010C\u001a\u00020%2\u0006\u00101\u001a\u00020\u0006J\u0016\u0010D\u001a\u0006\u0012\u0002\b\u00030\u001c2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030\u001cJ\f\u0010F\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cJ,\u0010G\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010A\u001a\u00020#2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000bH\u0002J$\u0010J\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000bH\u0002J&\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000bH\u0002J>\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0O0\u001c2\b\u0010Q\u001a\u0004\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020#2\u0006\u0010>\u001a\u00020\u0010H\u0002J&\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020P0O0\u001c2\b\u0010Q\u001a\u0004\u0018\u00010\u00072\u0006\u0010>\u001a\u00020\u0010H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u000b0\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mPreviewAnimFileMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/io/File;", "mPreviewToneFileMap", "mProgressLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "mErrorStateLiveData", "Lcom/oplus/melody/model/helper/MelodyLiveData;", "kotlin.jvm.PlatformType", "mThemeDataLiveData", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "mAddress", "mDeviceName", "mProductId", "mColorId", "mShareIndex", "mToneStateLiveDataRecord", "Lcom/oplus/melody/common/helper/LiveDataRecord;", "Lcom/oplus/melody/model/repository/personaldress/ToneStateInfoDTO;", "mDefaultControlSource", "Lcom/oplus/melody/model/zipdata/ControlSourceDO;", "mTransferToneFuture", "Ljava/util/concurrent/CompletableFuture;", "mApplyFuture", "mEarphoneLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressEarphoneVO;", "mToneStateLiveData", "mCleared", "", "onCleared", "", "setDeviceInfo", "intent", "Landroid/content/Intent;", "getAddress", "getDeviceName", "getProductId", "getColorId", "getEarphoneVO", "requestEarBudsToneData", "getCurrentPopTheme", "getPreviewVideoSource", "themeId", "previewUrl", "previewSha256", "getPreviewToneSource", "getErrorState", "setErrorState", "error", "refresh", "getApplyProgress", "getThemeData", "getDefaultControlSource", "getShareIndex", "downloadAllSource", ClientDataEntity.COL_DATA, "setThemePop", "setThemeTone", "toneInDevice", "setThemePopAndTone", "previewThemePop", "resetApply", "future", "getApplyFuture", "setThemeToneWithProgress", "progress0", "progress1", "requestPopSource", "progressStart", "progressEnd", "requestToneSource", "transferTone", "", "Lcom/oplus/melody/model/repository/earphone/EarToneDTO;", "toneFile", "start", "end", "selectToneTheme", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressDetailViewModel extends L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, File> f20707b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, File> f20708c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u<Integer> f20709d = new u<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l<Integer> f20710e = new l<>(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u<PersonalDressDTO.PersonalDressData> f20711f = new u<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f20712g = "";
    public String h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f20713i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20714j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0381o<ToneStateInfoDTO> f20715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C1554b f20716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w f20717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CompletableFuture<?> f20718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public t f20719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f20720p;

    /* JADX INFO: compiled from: PersonalDressDetailViewModel.kt */
    public static final class a implements RequestListener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletableFuture<Integer> f20721a;

        public a(CompletableFuture<Integer> completableFuture) {
            this.f20721a = completableFuture;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z2) {
            h.e(target, "target");
            this.f20721a.completeExceptionally(glideException);
            return true;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onResourceReady(Drawable drawable, Object model, Target<Drawable> target, DataSource dataSource, boolean z2) {
            Drawable resource = drawable;
            h.e(resource, "resource");
            h.e(model, "model");
            h.e(target, "target");
            h.e(dataSource, "dataSource");
            this.f20721a.complete(1);
            return true;
        }
    }

    /* JADX INFO: compiled from: PersonalDressDetailViewModel.kt */
    public static final class b implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ S9.b f20722a;

        public b(S9.b bVar) {
            this.f20722a = bVar;
        }

        @Override // java.util.function.Function
        public final /* synthetic */ Object apply(Object obj) {
            return this.f20722a.d(obj);
        }
    }

    @Override // androidx.lifecycle.L
    public final void c() {
        this.f20720p = true;
        A.c("PersonalDressDetailViewModel", new d(this, 7));
        CompletableFuture<?> completableFuture = this.f20718n;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        w wVar = this.f20717m;
        if (wVar != null) {
            wVar.cancel(true);
        }
        C0381o<ToneStateInfoDTO> c0381o = this.f20715k;
        if (c0381o != null) {
            c0381o.a();
        }
        this.f20715k = null;
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        a.C0231a.a().a();
    }

    public final void d(PersonalDressDTO.PersonalDressData personalDressData) {
        A.f("PersonalDressDetailViewModel", "downloadAllSource themeId:" + personalDressData.getThemeId() + " previewDetailImgUrl:" + personalDressData.getPreviewDetailImgUrl());
        CompletableFuture completableFuture = new CompletableFuture();
        if (TextUtils.isEmpty(personalDressData.getPreviewDetailImgUrl())) {
            Z7.a.g().e(this.f20714j, this.f20713i).thenApply((Function) new p(new e(6), 14)).whenComplete((BiConsumer) new s(new P8.b(1, this, completableFuture), 23));
        } else {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            Glide.with(heyMelodyApplication).load(personalDressData.getPreviewDetailImgUrl()).addListener(new a(completableFuture)).preload();
        }
        completableFuture.whenComplete((BiConsumer) new c(new C0406o(this, 5), 11));
    }

    public final CompletableFuture<File> e(String str, String str2, String str3) {
        File file = this.f20707b.get(str);
        if (file != null) {
            CompletableFuture<File> completableFutureCompletedFuture = CompletableFuture.completedFuture(file);
            h.d(completableFutureCompletedFuture, "completedFuture(...)");
            return completableFutureCompletedFuture;
        }
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        CompletableFuture<File> completableFutureWhenComplete = a.C0231a.a().k(this.f20713i, str2, this.f20714j, 0, str3, str).whenComplete((BiConsumer) new s(new C0550p(str2, this, str), 22));
        h.d(completableFutureWhenComplete, "whenComplete(...)");
        return completableFutureWhenComplete;
    }

    public final void f(String str) {
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/app/discovery");
        iVarA.f1674f = null;
        iVarA.f("device_mac_info", this.f20712g);
        iVarA.f("product_id", this.f20713i);
        iVarA.f("device_name", this.h);
        iVarA.f("product_color", String.valueOf(this.f20714j));
        iVarA.f("dress_id", str);
        iVarA.f("route_from", "onPreviewPopup");
        iVarA.a(1);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication != null) {
            iVarA.b(heyMelodyApplication);
        } else {
            h.i("context");
            throw null;
        }
    }

    public final CompletableFuture<List<EarToneDTO>> g(File file, PersonalDressDTO.PersonalDressData data) {
        ToneFileVerifyInformationDTO toneFileVerifyInformationDTO;
        String string;
        String str = BaseHealthModule.TRACK_FATIGUE_REMIND;
        if (file == null) {
            toneFileVerifyInformationDTO = new ToneFileVerifyInformationDTO(1, 0, 0, BaseHealthModule.TRACK_FATIGUE_REMIND);
        } else {
            h.e(data, "data");
            String themeId = data.getThemeId();
            if (themeId != null) {
                int i10 = Integer.parseInt(themeId);
                Bundle title = data.getTitle();
                if (title != null && (string = title.getString("zh_CN")) != null) {
                    str = string;
                }
                toneFileVerifyInformationDTO = new ToneFileVerifyInformationDTO(i10, (int) file.length(), D5.c.s(file), str);
            } else {
                toneFileVerifyInformationDTO = null;
            }
        }
        CompletableFuture<List<EarToneDTO>> completableFutureThenCompose = AbstractC0939b.E().H0(this.f20712g, toneFileVerifyInformationDTO).thenApply((Function<? super SetCommandStateDTO, ? extends U>) new o(new n(7), 19)).thenCompose((Function<? super U, ? extends CompletionStage<U>>) new p(new B9.d(this, 23), 13));
        h.d(completableFutureThenCompose, "thenCompose(...)");
        return completableFutureThenCompose;
    }

    public final CompletableFuture<?> h(PersonalDressDTO.PersonalDressData personalDressData, boolean z2, int i10, int i11) {
        A.c("PersonalDressDetailViewModel", new f(8, personalDressData, this));
        if (this.f20720p) {
            CompletableFuture<?> completableFuture = new CompletableFuture<>();
            completableFuture.completeExceptionally(MelodyException.e(0, "PersonalDressDetailViewModel cleared"));
            return completableFuture;
        }
        if (h.a(personalDressData.getThemeId(), BaseHealthModule.TRACK_FATIGUE_REMIND) && TextUtils.isEmpty(personalDressData.getToneUrl())) {
            C0379m.k(this.f20709d, 99);
            return g(null, personalDressData);
        }
        C0379m.k(this.f20709d, Integer.valueOf(i10));
        String themeId = personalDressData.getThemeId();
        String str = themeId == null ? "" : themeId;
        String toneUrl = personalDressData.getToneUrl();
        String str2 = toneUrl == null ? "" : toneUrl;
        String toneSHA256 = personalDressData.getToneSHA256();
        String str3 = toneSHA256 == null ? "" : toneSHA256;
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        CompletableFuture completableFutureThenCompose = a.C0231a.a().m(this.f20713i, str2, str3, str, new v(this, i10, i11)).thenCompose((Function<? super File, ? extends CompletionStage<U>>) new C0403l(new C0552r(this, i11, z2, personalDressData), 11));
        h.d(completableFutureThenCompose, "thenCompose(...)");
        return completableFutureThenCompose;
    }
}
