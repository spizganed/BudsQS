package com.oplus.melody.ui.component.detail.heymelodydownload;

import Jb.a;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import g9.t;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: HeyMelodyAppDownloadItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0012H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/ui/component/detail/heymelodydownload/HeyMelodyAppDownloadItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "mContext", "Landroid/content/Context;", "mViewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "mLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "getMContext", "()Landroid/content/Context;", "getMViewModel", "()Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "getMLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "onEarphoneDataChanged", "", "connectState", "", "(Ljava/lang/Integer;)V", "gotoAppDownloadPage", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HeyMelodyAppDownloadItem extends MelodyUiCOUIJumpPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "HeyMelodyAppDownload";
    public static final String TAG = "HeyMelodyAppDownloadItem";
    private final Context mContext;
    private final InterfaceC0601m mLifecycleOwner;
    private final MoreSettingViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.heymelodydownload.HeyMelodyAppDownloadItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: HeyMelodyAppDownloadItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            ((HeyMelodyAppDownloadItem) this.receiver).onEarphoneDataChanged(num);
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.heymelodydownload.HeyMelodyAppDownloadItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: HeyMelodyAppDownloadItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: HeyMelodyAppDownloadItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21082a;

        public b(l lVar) {
            this.f21082a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21082a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21082a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeyMelodyAppDownloadItem(Context mContext, MoreSettingViewModel mViewModel, InterfaceC0601m mLifecycleOwner) {
        super(mContext);
        h.e(mContext, "mContext");
        h.e(mViewModel, "mViewModel");
        h.e(mLifecycleOwner, "mLifecycleOwner");
        this.mContext = mContext;
        this.mViewModel = mViewModel;
        this.mLifecycleOwner = mLifecycleOwner;
        setTitle(R.string.melody_ui_heymelody_download_title);
        setSummary(R.string.melody_ui_heymelody_download_summary);
        mViewModel.f(mViewModel.f21136b).e(mLifecycleOwner, new b(new AnonymousClass1(1, this, HeyMelodyAppDownloadItem.class, "onEarphoneDataChanged", "onEarphoneDataChanged(Ljava/lang/Integer;)V", 0)));
        setOnPreferenceClickListener(new t(this, 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(HeyMelodyAppDownloadItem heyMelodyAppDownloadItem, Preference preference) {
        h.e(preference, "<unused var>");
        heyMelodyAppDownloadItem.gotoAppDownloadPage();
        MoreSettingViewModel moreSettingViewModel = heyMelodyAppDownloadItem.mViewModel;
        String str = moreSettingViewModel.f21137c;
        String str2 = moreSettingViewModel.f21136b;
        C1264t.t(AppConstant$FunctionType.HEY_MELODY_APP_DOWNLOAD.getFunType(), str, str2, N.t(moreSettingViewModel.e(str2)), "");
        return true;
    }

    private final void gotoAppDownloadPage() {
        J7.b.a().d();
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        J7.b.a().d();
        C0905k.a(heyMelodyApplication, "com.heytap.headset", "com.android.vending");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEarphoneDataChanged(Integer connectState) {
        setDisabled(connectState == null || connectState.intValue() != 2);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final InterfaceC0601m getMLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public final MoreSettingViewModel getMViewModel() {
        return this.mViewModel;
    }
}
