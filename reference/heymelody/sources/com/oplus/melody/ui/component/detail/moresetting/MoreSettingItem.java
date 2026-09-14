package com.oplus.melody.ui.component.detail.moresetting;

import A6.e;
import D7.C0379m;
import D9.d;
import F8.i;
import Jb.a;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.fitdetection.FitDetectionItem;
import com.oplus.melody.ui.component.detail.heymelodydownload.HeyMelodyAppDownloadItem;
import com.oplus.melody.ui.component.detail.popup.ReconnectPopupItem;
import com.oplus.melody.ui.component.detail.promptvolume.PromptVolumeItem;
import com.oplus.melody.ui.component.detail.swiftpair.SwiftPairItem;
import com.oplus.melody.ui.component.detail.taplevelsetting.TapLevelSettingItem;
import com.oplus.melody.ui.component.detail.weardetection.ChannelSwitchItem;
import com.oplus.melody.ui.component.detail.weardetection.SmartPlayItem;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.ArrayList;
import java.util.List;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MoreSettingItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MoreSettingItem extends MelodyUiCOUIJumpPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String ITEM_NAME = "MoreSettingItem";

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.moresetting.MoreSettingItem$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MoreSettingItem.kt */
    public static final class Companion {
        public static ArrayList a(WhitelistConfigDTO whitelistConfigDTO, List list) {
            ArrayList arrayList = new ArrayList();
            SmartPlayItem.INSTANCE.getClass();
            WhitelistConfigDTO.Function function = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
            if (function != null && Y.e(function.getWearDetection(), false) && !"realme".equalsIgnoreCase(whitelistConfigDTO.getBrand())) {
                arrayList.add(SmartPlayItem.class);
            }
            ChannelSwitchItem.INSTANCE.getClass();
            WhitelistConfigDTO.Function function2 = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
            if (function2 != null && Y.e(function2.getWearDetection(), false)) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    h.i("context");
                    throw null;
                }
                List<String> list2 = S.f19463a;
                if ("com.oplus.melody".equals(heyMelodyApplication.getPackageName()) && !"realme".equalsIgnoreCase(whitelistConfigDTO.getBrand())) {
                    arrayList.add(ChannelSwitchItem.class);
                }
            }
            SwiftPairItem.INSTANCE.getClass();
            WhitelistConfigDTO.Function function3 = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
            if (function3 != null && Y.e(function3.getSwiftPair(), false)) {
                arrayList.add(SwiftPairItem.class);
            }
            if (FitDetectionItem.hasFunction(whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null)) {
                arrayList.add(FitDetectionItem.class);
            }
            ReconnectPopupItem.INSTANCE.getClass();
            HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
            if (heyMelodyApplication2 == null) {
                h.i("context");
                throw null;
            }
            List<String> list3 = S.f19463a;
            if ("com.oplus.melody".equals(heyMelodyApplication2.getPackageName())) {
                J7.b.a().d();
            }
            TapLevelSettingItem.Companion companion = TapLevelSettingItem.INSTANCE;
            WhitelistConfigDTO.Function function4 = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
            companion.getClass();
            if (function4 != null && Y.e(function4.getTapLevelSetting(), false) && N.k(307, list)) {
                arrayList.add(TapLevelSettingItem.class);
            }
            PromptVolumeItem.Companion companion2 = PromptVolumeItem.INSTANCE;
            WhitelistConfigDTO.Function function5 = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
            companion2.getClass();
            if (function5 != null && Y.e(function5.getPromptVolume(), false) && N.k(304, list)) {
                arrayList.add(PromptVolumeItem.class);
            }
            HeyMelodyApplication heyMelodyApplication3 = C0906l.f19501a;
            if (heyMelodyApplication3 == null) {
                h.i("context");
                throw null;
            }
            if ("com.oplus.melody".equals(heyMelodyApplication3.getPackageName())) {
                HeyMelodyAppDownloadItem.INSTANCE.getClass();
                WhitelistConfigDTO.Function function6 = whitelistConfigDTO != null ? whitelistConfigDTO.getFunction() : null;
                if (function6 != null && Y.e(function6.getHeyMelodyDownload(), false) && !"realme".equalsIgnoreCase(whitelistConfigDTO.getBrand())) {
                    arrayList.add(HeyMelodyAppDownloadItem.class);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: MoreSettingItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Aa.b f21135a;

        public b(Aa.b bVar) {
            this.f21135a = bVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21135a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21135a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreSettingItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_more_setting_title);
        setOnPreferenceClickListener(new d(viewModel, context, 0));
        String macAddress = viewModel.f20397b;
        h.e(macAddress, "macAddress");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new e(7))).e(lifecycleOwner, new b(new Aa.b(this, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(DetailMainViewModel detailMainViewModel, Context context, Preference it) {
        h.e(it, "it");
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/more_setting");
        iVarA.f("device_mac_info", detailMainViewModel.f20397b);
        iVarA.f("device_name", detailMainViewModel.f20398c);
        iVarA.f("product_id", detailMainViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(detailMainViewModel.f20401f));
        iVarA.b(context);
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.MORE_SETTING.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(MoreSettingItem moreSettingItem, int i10) {
        moreSettingItem.setEnabled(i10 == 2);
        return Jb.l.f2618a;
    }
}
