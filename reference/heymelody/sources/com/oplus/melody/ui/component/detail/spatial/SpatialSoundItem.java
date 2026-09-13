package com.oplus.melody.ui.component.detail.spatial;

import A6.d;
import A6.e;
import A9.i;
import D7.C0379m;
import Jb.a;
import Wb.l;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUISwitchPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.spatial.SpatialSoundItem;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: SpatialSoundItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/ui/component/detail/spatial/SpatialSoundItem;", "Lcom/coui/appcompat/preference/COUISwitchPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mContext", "mViewModel", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "onSpatialSoundChanged", "", "spatialSoundVO", "Lcom/oplus/melody/ui/component/detail/spatial/SpatialSoundVO;", "setSpatialSoundStatus", "isChecked", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpatialSoundItem extends COUISwitchPreference {
    public static final String ITEM_NAME = "SpatialSoundItem";
    public static final String TAG = "SpatialSoundItem";
    private Context mContext;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.spatial.SpatialSoundItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: SpatialSoundItem.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<Q9.b, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Q9.b bVar) {
            Q9.b p02 = bVar;
            h.e(p02, "p0");
            ((SpatialSoundItem) this.receiver).onSpatialSoundChanged(p02);
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: compiled from: SpatialSoundItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21245a;

        public b(l lVar) {
            this.f21245a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21245a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21245a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpatialSoundItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mContext = context;
        this.mViewModel = viewModel;
        setTitle(context.getString(R.string.melody_ui_spatial_effect_title));
        setSummary(this.mContext.getString(R.string.melody_ui_spatial_effect_summary));
        setOnPreferenceChangeListener(new C0.a(this, 15));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new e(14))).e(lifecycleOwner, new b(new AnonymousClass2(1, this, SpatialSoundItem.class, "onSpatialSoundChanged", "onSpatialSoundChanged(Lcom/oplus/melody/ui/component/detail/spatial/SpatialSoundVO;)V", 0)));
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new b(new Aa.b(this, 16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(SpatialSoundItem spatialSoundItem, Preference preference, Object obj) {
        h.e(preference, "preference");
        h.c(obj, "null cannot be cast to non-null type kotlin.Boolean");
        spatialSoundItem.setSpatialSoundStatus(((Boolean) obj).booleanValue());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(SpatialSoundItem spatialSoundItem, Integer num) {
        spatialSoundItem.setEnabled(num != null && num.intValue() == 2);
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSpatialSoundChanged(Q9.b bVar) {
        setChecked(bVar.getIsSpatialSoundOn());
    }

    private final void setSpatialSoundStatus(final boolean isChecked) {
        CompletableFuture<Void> completableFutureThenAccept;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureE0 = AbstractC0939b.E().E0(27, isChecked, this.mViewModel.f20397b);
        this.mSetCommandFuture = completableFutureE0;
        if (completableFutureE0 == null || (completableFutureThenAccept = completableFutureE0.thenAccept((Consumer<? super SetCommandStateDTO>) new G8.h(new l() { // from class: Q9.a
            @Override // Wb.l
            public final Object d(Object obj) {
                return SpatialSoundItem.setSpatialSoundStatus$lambda$0(isChecked, (SetCommandStateDTO) obj);
            }
        }, 6))) == null) {
            return;
        }
        completableFutureThenAccept.exceptionally((Function<Throwable, ? extends Void>) new d(18));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l setSpatialSoundStatus$lambda$0(boolean z2, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || setCommandStateDTO.getSetCommandStatus() != 0) {
            A.b("SpatialSoundItem", "switch spatial sound status failed");
        } else {
            A.c("SpatialSoundItem", new i(10, z2));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String setSpatialSoundStatus$lambda$0$0(boolean z2) {
        return e.f("switch spatial sound status succeed, isChecked = ", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setSpatialSoundStatus$lambda$2(Throwable th) {
        A.i("SpatialSoundItem", "switch spatial sound status throws", th);
        return null;
    }
}
