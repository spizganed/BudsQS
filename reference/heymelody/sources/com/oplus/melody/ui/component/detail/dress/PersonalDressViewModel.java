package com.oplus.melody.ui.component.detail.dress;

import A9.n;
import A9.o;
import D1.f;
import D7.C0374h;
import D7.C0389x;
import Ea.C0403l;
import Ea.C0406o;
import Wb.l;
import a9.C0529F;
import a9.y;
import android.os.Bundle;
import androidx.lifecycle.L;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import c9.h;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.EarToneDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.melody.model.repository.personaldress.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;

/* JADX INFO: compiled from: PersonalDressViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180,J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110,J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0011J\u001c\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000202\u0018\u00010\u00180,2\u0006\u00103\u001a\u00020\u0011JR\u00104\u001a\u00020/2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u00010\u00052\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#H\u0002J\u0006\u0010<\u001a\u00020/J\u000e\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020?J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A0,J\u0012\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00180,J\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110,2\u0006\u0010E\u001a\u00020\u0005J\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110,2\u0006\u0010E\u001a\u00020\u0005J\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00110,2\u0006\u0010H\u001a\u00020\u0005J\u000e\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0JJ\u0006\u0010K\u001a\u00020LR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00110\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006N"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/PersonalDressViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mDeviceName", "getMDeviceName", "setMDeviceName", "mProductId", "getMProductId", "setMProductId", "mColorId", "", "getMColorId", "()I", "setMColorId", "(I)V", "mDressGroupsData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressGroup;", "mDefaultCover", "Ljava/io/File;", "mErrorState", "kotlin.jvm.PlatformType", "mSelectedDressId", "mEarTonesMap", "", "Lcom/oplus/melody/model/repository/earphone/EarToneDTO;", "mEarSupportTone", "", "mIsUsingCarousel", "mMergedDressGroupsData", "Landroidx/lifecycle/MediatorLiveData;", "getMMergedDressGroupsData", "()Landroidx/lifecycle/MediatorLiveData;", "mMergedDressGroupsData$delegate", "Lkotlin/Lazy;", "getDressGroupsData", "Landroidx/lifecycle/LiveData;", "getErrorState", "setErrorState", "", "state", "getDressListBySeriesData", "Lcom/oplus/melody/ui/component/detail/dress/PersonalDressVO;", "seriesId", "mergeDressGroups", "dressGroups", "customDress", "Lcom/oplus/melody/model/repository/personaldress/CustomDressDTO;", "selectedThemeId", "earTonesMap", "earSupportTone", "isUsingCarousel", "requestDressList", "transformDressVO", ClientDataEntity.COL_DATA, "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "getToneTransferStateLiveData", "Lcom/oplus/melody/ui/component/detail/dress/ToneTransferVO;", "getCarouselDressListLiveData", "Lcom/oplus/melody/model/repository/personaldress/carousel/CarouselDressDTO;", "getConnectionState", "macAddress", "getHeadsetConnectionState", "getReconnectPopupSwitchData", "address", "requestDefaultCover", "Ljava/util/concurrent/CompletableFuture;", "getDefaultCoverProvider", "Lcom/oplus/melody/ui/component/detail/dress/DefaultCoverProvider;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PersonalDressViewModel extends L {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public File f20760g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f20761i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, EarToneDTO> f20762j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20763k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20764l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20755b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20756c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20757d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20758e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u<List<y>> f20759f = new u<>();
    public final u<Integer> h = new u<>(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Jb.b f20765m = kotlin.a.a(new O9.d(this, 8));

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return f.l(Integer.valueOf(((y) t11).f7176b), Integer.valueOf(((y) t10).f7176b));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return f.l(Long.valueOf(((C0529F) t11).getPriority()), Long.valueOf(((C0529F) t10).getPriority()));
        }
    }

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return f.l(Long.valueOf(((h) t11).getPriority()), Long.valueOf(((h) t10).getPriority()));
        }
    }

    /* JADX INFO: compiled from: PersonalDressViewModel.kt */
    public static final class d implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20766a;

        public d(l lVar) {
            this.f20766a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return kotlin.jvm.internal.h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20766a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20766a.d(obj);
        }
    }

    public static C0529F f(PersonalDressDTO.PersonalDressData data) {
        String string;
        kotlin.jvm.internal.h.e(data, "data");
        C0529F c0529f = new C0529F();
        c0529f.setThemeId(data.getThemeId());
        Bundle title = data.getTitle();
        ArrayList arrayList = null;
        if (title != null) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
            string = title.getString(heyMelodyApplication.getString(R.string.melody_common_language_tag));
        } else {
            string = null;
        }
        c0529f.setTitle(string);
        c0529f.setImgUrl(data.getPreviewListImgUrl());
        c0529f.setDressData(data);
        c0529f.setSupportPop(data.getMaterialType() == 0 || data.getMaterialType() == 2);
        c0529f.setSupportTone(data.getMaterialType() == 1 || data.getMaterialType() == 2);
        c0529f.setPriority(data.getPriority());
        List<PersonalDressDTO.Tag> tags = data.getTags();
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
        c0529f.setTags(arrayList);
        return c0529f;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(java.util.List<a9.y> r16, com.oplus.melody.model.repository.personaldress.CustomDressDTO r17, java.lang.String r18, java.util.Map<java.lang.String, com.oplus.melody.model.repository.earphone.EarToneDTO> r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.dress.PersonalDressViewModel.d(java.util.List, com.oplus.melody.model.repository.personaldress.CustomDressDTO, java.lang.String, java.util.Map, boolean, boolean):void");
    }

    public final void e() {
        CompletableFuture completableFutureThenCombine;
        int i10 = 2;
        this.h.i(2);
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        com.oplus.melody.model.repository.personaldress.a aVarA = a.C0231a.a();
        CompletableFuture completableFutureThenApply = aVarA.s(this.f20755b, this.f20758e, this.f20757d, false).thenApply((Function) new C0403l(new n(8), 12));
        CompletableFuture completableFutureExceptionally = completableFutureThenApply != null ? completableFutureThenApply.exceptionally((Function) new A6.d(28)) : null;
        CompletableFuture completableFutureThenCompose = aVarA.t(this.f20758e, false, this.f20757d).thenCompose((Function) new o(new C0374h(5, aVarA, this), 22));
        CompletableFuture completableFutureExceptionally2 = completableFutureThenCompose != null ? completableFutureThenCompose.exceptionally((Function) new A6.d(29)) : null;
        if (completableFutureExceptionally == null || (completableFutureThenCombine = completableFutureExceptionally.thenCombine((CompletionStage) completableFutureExceptionally2, (BiFunction) new C0389x(new C0406o(this, 6), i10))) == null) {
            return;
        }
        completableFutureThenCombine.exceptionally((Function) new o(this, 23));
    }
}
