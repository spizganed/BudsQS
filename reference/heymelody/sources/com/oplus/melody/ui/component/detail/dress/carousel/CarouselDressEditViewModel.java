package com.oplus.melody.ui.component.detail.dress.carousel;

import D1.f;
import D7.C0374h;
import D7.C0389x;
import D7.G;
import E9.e;
import Ea.C0403l;
import Ea.C0406o;
import Kb.m;
import Wb.l;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.L;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import b9.C0738g;
import b9.s;
import b9.v;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.personaldress.a;
import com.oplus.melody.model.repository.personaldress.carousel.CarouselDressDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.h;
import t8.q;

/* JADX INFO: compiled from: CarouselDressEditViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 p2\u00020\u0001:\u0001pB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u00106\u001a\u0002072\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\b\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010<\u001a\u00020\u001aJ\u0012\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0>J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00110>J\u000e\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\u0011J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050>J\u000e\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\u0005J\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00110>J\u000e\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\u0011J\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000>J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050JH\u0002J\u0016\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u001aJ\u0012\u0010N\u001a\u0004\u0018\u0001012\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0014\u0010O\u001a\u0002072\f\u0010P\u001a\b\u0012\u0004\u0012\u0002010$J\b\u0010Q\u001a\u000207H\u0002J\u0010\u0010R\u001a\u0002072\b\b\u0002\u0010S\u001a\u00020\u001aJ\"\u0010T\u001a\u0002012\u0006\u0010U\u001a\u00020V2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010JH\u0002J$\u0010X\u001a\u0002072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050$2\f\u00108\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J$\u0010Z\u001a\u0004\u0018\u0001012\u0006\u0010[\u001a\u00020\\2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010JH\u0002J$\u0010]\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u00052\b\u0010^\u001a\u0004\u0018\u00010\u00052\b\u0010_\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010`\u001a\u0002072\u0006\u0010a\u001a\u0002012\u0016\b\u0002\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u000207\u0018\u00010cJ\u0018\u0010d\u001a\u0002072\u0006\u0010L\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0011H\u0002J\u0010\u0010f\u001a\u0002072\u0006\u0010L\u001a\u00020\u0005H\u0002J\u000e\u0010g\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0iJ\u0006\u0010j\u001a\u00020kJ\u0006\u0010l\u001a\u000207J\u0014\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00110>2\u0006\u0010n\u001a\u00020\u0005J\u0014\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00110>2\u0006\u0010n\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00050\u00050 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00110\u00110 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0 X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00110\u00110 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001105X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressEditViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mDeviceName", "getMDeviceName", "setMDeviceName", "mProductId", "getMProductId", "setMProductId", "mColorId", "", "getMColorId", "()I", "setMColorId", "(I)V", "mCarouselDressId", "getMCarouselDressId", "setMCarouselDressId", "mIsDataInitialized", "", "mCarouselDto", "Lcom/oplus/melody/model/repository/personaldress/carousel/CarouselDressDTO;", "mCarouselNameUserEdited", "mCarouselTypeUserEdited", "mCarouselName", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "mCarouselType", "mDressGroupsData", "", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectGroup;", "mMergedDressGroupsData", "Landroidx/lifecycle/MediatorLiveData;", "getMMergedDressGroupsData", "()Landroidx/lifecycle/MediatorLiveData;", "mMergedDressGroupsData$delegate", "Lkotlin/Lazy;", "mDefaultCover", "Ljava/io/File;", "mErrorState", "mSelectedThemesList", "", "Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSelectVO;", "mDownloadingThemeIds", "", "mDownloadProgressMap", "", "mergeDressGroupsData", "", "dressGroups", "customDressDTO", "Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO;", "carouselDto", "isEditMode", "getDressGroupsData", "Landroidx/lifecycle/LiveData;", "getErrorState", "setErrorState", "state", "getCarouselName", "setCarouselName", "name", "getCarouselType", "setCarouselType", SpeechFindManager.TYPE, "getSelectedThemesList", "getSelectedThemeIdSet", "", "setThemeSelected", "themeId", "selected", "findDressVO", "updateSelectedThemesOrder", "orderedList", "updateDressGroupsSelection", "requestDressList", "force", "transformToCarouselVO", ClientDataEntity.COL_DATA, "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "selectedIds", "restoreSelectedThemesList", "themeIdList", "transformCustomDressToCarouselVO", "customData", "Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO$CustomDressData;", "checkThemeDownloaded", "animSHA256", "darkAnimSHA256", "downloadTheme", "dressVO", "onProgress", "Lkotlin/Function1;", "updateThemeProgress", "progress", "updateThemeDownloadStatus", "isThemeDownloading", "requestDefaultCover", "Ljava/util/concurrent/CompletableFuture;", "getDefaultCoverProvider", "Lcom/oplus/melody/ui/component/detail/dress/DefaultCoverProvider;", "saveCarouselDress", "getConnectionState", "macAddress", "getHeadsetConnectionState", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressEditViewModel extends L {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20790g;
    public CarouselDressDTO h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20792j;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public File f20797o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20785b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20786c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20787d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20788e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20789f = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final u<String> f20793k = new u<>("");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u<Integer> f20794l = new u<>(1);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u<List<s>> f20795m = new u<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Jb.b f20796n = kotlin.a.a(new e(this, 11));

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final u<Integer> f20798p = new u<>(0);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final u<List<v>> f20799q = new u<>(new ArrayList());

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinkedHashSet f20800r = new LinkedHashSet();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedHashMap f20801s = new LinkedHashMap();

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return f.l(Integer.valueOf(((s) t11).f13123b), Integer.valueOf(((s) t10).f13123b));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return f.l(Long.valueOf(((v) t11).f13144i), Long.valueOf(((v) t10).f13144i));
        }
    }

    /* JADX INFO: compiled from: CarouselDressEditViewModel.kt */
    public static final class c implements androidx.lifecycle.v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20802a;

        public c(l lVar) {
            this.f20802a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20802a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20802a.d(obj);
        }
    }

    public static void h(CarouselDressEditViewModel carouselDressEditViewModel) {
        int i10 = 0;
        if (carouselDressEditViewModel.f20790g) {
            A.b("CarouselDressEditViewModel", "initData: already initialized, skip");
            return;
        }
        carouselDressEditViewModel.f20798p.i(2);
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        com.oplus.melody.model.repository.personaldress.a aVarA = a.C0231a.a();
        CompletableFuture completableFutureThenApply = aVarA.s(carouselDressEditViewModel.f20785b, carouselDressEditViewModel.f20788e, carouselDressEditViewModel.f20787d, false).thenApply((Function) new Aa.c(new G(10), 9));
        CompletableFuture completableFutureExceptionally = completableFutureThenApply != null ? completableFutureThenApply.exceptionally((Function) new A6.c(21)) : null;
        CompletableFuture completableFutureThenCompose = aVarA.t(carouselDressEditViewModel.f20788e, false, carouselDressEditViewModel.f20787d).thenCompose((Function) new C0403l(new C0374h(6, aVarA, carouselDressEditViewModel), 16));
        CompletableFuture completableFutureExceptionally2 = completableFutureThenCompose != null ? completableFutureThenCompose.exceptionally((Function) new C0738g(i10)) : null;
        if (completableFutureExceptionally != null) {
            completableFutureExceptionally.thenCombine((CompletionStage) completableFutureExceptionally2, (BiFunction) new C0389x(new C0406o(carouselDressEditViewModel, 7), 3));
        }
    }

    public final boolean d(String str, String str2, String str3) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String str4 = d.v(heyMelodyApplication) ? "night" : "normal";
        if (str4.equals("night") && str3 != null) {
            str2 = str3;
        }
        if (str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        String str5 = str.equals(BaseHealthModule.TRACK_FATIGUE_REMIND) ? String.format(Locale.ENGLISH, "popup_%s_%d_%s", Arrays.copyOf(new Object[]{this.f20787d, Integer.valueOf(this.f20788e), str4}, 3)) : String.format(Locale.ENGLISH, "popup-%s-%d-%s-%s", Arrays.copyOf(new Object[]{this.f20787d, Integer.valueOf(this.f20788e), str, str4}, 4));
        File fileK = Z7.a.k(str5);
        SharedPreferences sharedPreferencesC = q.c("melody-model-download");
        h.d(sharedPreferencesC, "get(...)");
        return fileK.isDirectory() && TextUtils.equals(sharedPreferencesC.getString(str5.concat(".zip"), null), str2);
    }

    public final t<List<s>> e() {
        return (t) this.f20796n.getValue();
    }

    public final Set<String> f() {
        List<v> listD = this.f20799q.d();
        if (listD != null) {
            ArrayList arrayList = new ArrayList(m.i(listD));
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(((v) it.next()).f13137a);
            }
            Set<String> setI = Kb.q.I(arrayList);
            if (setI != null) {
                return setI;
            }
        }
        return EmptySet.f25352a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(java.util.List<b9.s> r25, com.oplus.melody.model.repository.personaldress.CustomDressDTO r26, com.oplus.melody.model.repository.personaldress.carousel.CarouselDressDTO r27) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.carousel.CarouselDressEditViewModel.g(java.util.List, com.oplus.melody.model.repository.personaldress.CustomDressDTO, com.oplus.melody.model.repository.personaldress.carousel.CarouselDressDTO):void");
    }

    public final v i(PersonalDressDTO.PersonalDressData personalDressData, Set<String> set) {
        String string;
        Set<String> setF = set == null ? f() : set;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        ArrayList arrayList = null;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        String string2 = heyMelodyApplication.getString(R.string.melody_common_language_tag);
        h.d(string2, "getLocaleLanguage(...)");
        String themeId = personalDressData.getThemeId();
        String str = themeId == null ? "" : themeId;
        boolean zD = d(str, personalDressData.getAnimSHA256(), personalDressData.getDarkAnimSHA256());
        Bundle title = personalDressData.getTitle();
        if (title == null || (string = title.getString(string2)) == null) {
            string = "";
        }
        String previewListImgUrl = personalDressData.getPreviewListImgUrl();
        String str2 = previewListImgUrl == null ? "" : previewListImgUrl;
        boolean z2 = zD && setF.contains(str);
        boolean z4 = personalDressData.getMaterialType() == 0 || personalDressData.getMaterialType() == 2;
        boolean z10 = personalDressData.getMaterialType() == 1 || personalDressData.getMaterialType() == 2;
        long priority = personalDressData.getPriority();
        List<PersonalDressDTO.Tag> tags = personalDressData.getTags();
        if (tags != null) {
            arrayList = new ArrayList();
            Iterator<T> it = tags.iterator();
            while (it.hasNext()) {
                String icon = ((PersonalDressDTO.Tag) it.next()).getIcon();
                if (icon != null) {
                    arrayList.add(icon);
                }
            }
        }
        return new v(str, string, str2, zD, z2, -1, z4, z10, priority, arrayList, personalDressData);
    }

    public final void j() {
        List<s> listD = e().d();
        if (listD == null) {
            return;
        }
        Set<String> setF = f();
        ArrayList arrayList = new ArrayList(m.i(listD));
        for (s sVar : listD) {
            int i10 = sVar.f13122a;
            List<v> list = sVar.f13124c;
            ArrayList arrayList2 = new ArrayList(m.i(list));
            for (v vVar : list) {
                arrayList2.add(v.a(vVar, false, vVar.f13140d && setF.contains(vVar.f13137a), 0, 2031));
            }
            arrayList.add(new s(i10, sVar.f13123b, arrayList2, sVar.f13125d));
        }
        e().i(arrayList);
    }

    public final void k(int i10, String str) {
        List<s> listD = e().d();
        if (listD == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(m.i(listD));
        for (s sVar : listD) {
            int i11 = sVar.f13122a;
            List<v> list = sVar.f13124c;
            ArrayList arrayList2 = new ArrayList(m.i(list));
            for (v vVarA : list) {
                if (h.a(vVarA.f13137a, str)) {
                    vVarA = v.a(vVarA, false, false, i10, 2015);
                }
                arrayList2.add(vVarA);
            }
            arrayList.add(new s(i11, sVar.f13123b, arrayList2, sVar.f13125d));
        }
        e().i(arrayList);
    }
}
