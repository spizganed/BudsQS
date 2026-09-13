package com.oplus.melody.ui.component.detail.dropdetection;

import D7.C0379m;
import Y.r;
import androidx.lifecycle.L;
import androidx.lifecycle.t;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: DropDetectionViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dropdetection/DropDetectionViewModel;", "Landroidx/lifecycle/ViewModel;", "address", "", "<init>", "(Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "mSwitchLiveData", "Landroidx/lifecycle/LiveData;", "", "setSwitchEnable", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "enable", "getSwitchLiveData", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DropDetectionViewModel extends L {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f20951c;

    public DropDetectionViewModel(String address) {
        h.e(address, "address");
        this.f20950b = address;
        this.f20951c = C0379m.g(AbstractC0939b.E().v(address), new r(26));
    }
}
