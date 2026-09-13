package com.oplus.melody.ui.component.detail.promptvolume;

import B9.d;
import D7.C0379m;
import Jb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.moresetting.MoreSettingViewModel;
import com.oplus.melody.ui.widget.MelodyPromptVolumeSeekBarPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: PromptVolumeItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/ui/component/detail/promptvolume/PromptVolumeItem;", "Lcom/oplus/melody/ui/widget/MelodyPromptVolumeSeekBarPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/moresetting/MoreSettingViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "onVolumeValueInfoChanged", "", "volumeValueInfoVO", "Lcom/oplus/melody/ui/component/detail/promptvolume/VolumeValueInfoVO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PromptVolumeItem extends MelodyPromptVolumeSeekBarPreference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final String TAG = "PromptVolumeItem";

    /* JADX INFO: compiled from: PromptVolumeItem.kt */
    public static final class a implements MelodyPromptVolumeSeekBarPreference.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MoreSettingViewModel f21208a;

        public a(MoreSettingViewModel moreSettingViewModel) {
            this.f21208a = moreSettingViewModel;
        }

        @Override // com.oplus.melody.ui.widget.MelodyPromptVolumeSeekBarPreference.b
        public final void a(int i10) {
            String macAddress = this.f21208a.f21136b;
            h.e(macAddress, "macAddress");
            AbstractC0939b.E().I0(i10, macAddress);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.promptvolume.PromptVolumeItem$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PromptVolumeItem.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: PromptVolumeItem.kt */
    public static final class c implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f21209a;

        public c(d dVar) {
            this.f21209a = dVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21209a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) throws Throwable {
            this.f21209a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptVolumeItem(Context context, MoreSettingViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        WhitelistConfigDTO.Function function;
        WhitelistConfigDTO.PromptVolumeRange promptVolumeRange;
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_ui_prompt_volume_title);
        WhitelistConfigDTO whitelistConfigDTO = viewModel.f21140f;
        if (whitelistConfigDTO != null && (function = whitelistConfigDTO.getFunction()) != null && (promptVolumeRange = function.getPromptVolumeRange()) != null) {
            if (promptVolumeRange.getMin() != -1) {
                setMOffset(promptVolumeRange.getMin());
            }
            if (promptVolumeRange.getMax() != -1) {
                setBarMaxValue(promptVolumeRange.getMax());
            }
        }
        setOnTrackChangeListener(new a(viewModel));
        String macAddress = viewModel.f21136b;
        h.e(macAddress, "macAddress");
        C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new A6.f(4))).e(lifecycleOwner, new c(new d(this, 7)));
        AbstractC0939b.E().N(macAddress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l _init_$lambda$1(PromptVolumeItem promptVolumeItem, I9.a volumeValueInfoVO) {
        h.e(volumeValueInfoVO, "volumeValueInfoVO");
        promptVolumeItem.onVolumeValueInfoChanged(volumeValueInfoVO);
        return l.f2618a;
    }

    private final void onVolumeValueInfoChanged(I9.a aVar) {
        A.f(TAG, "onVolumeValueInfoChanged volumeValueInfoVO = " + aVar);
        setEnabled(aVar.getConnectionState() == 2);
        int value = aVar.getValue();
        if (value != 0) {
            setProgress(value);
        }
    }
}
