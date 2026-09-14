package com.oplus.melody.ui.component.detail.longpressvolume;

import A9.r;
import A9.s;
import I8.C0426b;
import android.content.Context;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.KeyFunctionInfoDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: LongPressVolumeViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\bJ4\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150#J=\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000f2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00150'R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006,"}, d2 = {"Lcom/oplus/melody/ui/component/detail/longpressvolume/LongPressVolumeViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "mFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/ui/component/control/guide/ControlGuideConfigVO;", "isShouldShowDialog", "", "()Z", "setShouldShowDialog", "(Z)V", "getEarphoneDirect", "Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "macAddress", "", "getKeyFunctionInfo", "Landroidx/lifecycle/LiveData;", "", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "getKeyFunctions", "", "context", "Landroid/content/Context;", "address", "getLongPressVolumeStatus", "Lcom/oplus/melody/ui/component/detail/longpressvolume/LongPressVolumeSwitchInfoVO;", "setLongPressVolumeStatus", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "enable", "setKeyFunction", "curFunction", "", "devType", "callback", "Lkotlin/Function0;", "fetchResource", "pid", "color", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "config", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LongPressVolumeViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompletableFuture<C0426b> f21118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21119c;

    public static void d(Context context, String address, int i10, int i11, Wb.a aVar) {
        h.e(address, "address");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyFunctionInfoDTO(i11, 1, 4, i10));
        CompletableFuture completableFutureU0 = AbstractC0939b.E().u0(address, context, arrayList, 1025);
        if (completableFutureU0 != null) {
            completableFutureU0.whenComplete((BiConsumer) new s(new r(0, aVar), 0));
        }
    }
}
