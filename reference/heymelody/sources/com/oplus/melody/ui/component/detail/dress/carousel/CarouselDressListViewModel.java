package com.oplus.melody.ui.component.detail.dress.carousel;

import D1.f;
import D7.C0386u;
import Kb.m;
import Kb.q;
import Wb.l;
import androidx.lifecycle.L;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import androidx.media3.session.D0;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.personaldress.carousel.CarouselDressDTO;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CarouselDressListViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bJ\u0018\u0010%\u001a\u00020#2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0002J\u0012\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0019J\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180!J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0011J\u000e\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0011J\u0006\u00104\u001a\u00020#J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u00106\u001a\u00020\u0005J\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u00106\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001b0\u001b0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mDeviceName", "getMDeviceName", "setMDeviceName", "mProductId", "getMProductId", "setMProductId", "mColorId", "", "getMColorId", "()I", "setMColorId", "(I)V", "mMergedCarouselDressListLiveData", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/oplus/melody/model/repository/personaldress/carousel/CarouselDressDTO;", "mIsSourceAdded", "", "mAppliedCarouselId", "mIsEditMode", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getIsEditMode", "Landroidx/lifecycle/LiveData;", "setEditMode", "", "isEdit", "mergeCarouselDressList", "carouselList", "updateAppliedCarouselId", "equipmentCarousel", "Lcom/oplus/melody/model/repository/personaldress/carousel/EquipmentCarouselDTO;", "isThemeExists", "themeId", "hasInvalidThemes", "carousel", "getCarouselsWithInvalidThemes", "getCarouselDressListLiveData", "deleteCarouselDress", "id", "applyEquipmentCarousel", "carouselId", "unApplyEquipmentCarousel", "getConnectionState", "macAddress", "getHeadsetConnectionState", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressListViewModel extends L {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20820g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20815b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20816c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20817d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20818e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t<List<CarouselDressDTO>> f20819f = new t<>();
    public int h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u<Boolean> f20821i = new u<>(Boolean.FALSE);

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return f.l(Integer.valueOf(((CarouselDressDTO) t11).getCarouselId()), Integer.valueOf(((CarouselDressDTO) t10).getCarouselId()));
        }
    }

    /* JADX INFO: compiled from: CarouselDressListViewModel.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20822a;

        public b(l lVar) {
            this.f20822a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20822a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20822a.d(obj);
        }
    }

    public final boolean d(String themeId) {
        h.e(themeId, "themeId");
        if (themeId.length() == 0) {
            return false;
        }
        if (themeId.equals(BaseHealthModule.TRACK_FATIGUE_REMIND) || C1264t.d(this.f20817d, String.valueOf(this.f20818e), themeId).exists()) {
            return true;
        }
        StringBuilder sbG = D0.g(this.f20818e, "popup-", this.f20817d, "-", "-");
        sbG.append(themeId);
        sbG.append("-normal");
        File fileK = Z7.a.k(sbG.toString());
        StringBuilder sbG2 = D0.g(this.f20818e, "popup-", this.f20817d, "-", "-");
        sbG2.append(themeId);
        sbG2.append("-night");
        return fileK.isDirectory() || Z7.a.k(sbG2.toString()).isDirectory();
    }

    public final void e(List<CarouselDressDTO> list) {
        if (list == null) {
            A.x("CarouselDressListViewModel", "mergeCarouselDressList: carouselList is null, keep existing data");
            return;
        }
        ArrayList arrayList = new ArrayList(m.i(list));
        for (CarouselDressDTO carouselDressDTO : list) {
            int carouselId = carouselDressDTO.getCarouselId();
            int i10 = this.h;
            arrayList.add(CarouselDressDTO.copy$default(carouselDressDTO, 0, null, 0, null, 0, null, carouselId == i10 && i10 != -1, 63, null));
        }
        List<CarouselDressDTO> listD = q.D(arrayList, new a());
        A.c("CarouselDressListViewModel", new C0386u(18, this, listD));
        this.f20819f.l(listD);
    }
}
