package com.oplus.melody.ui.base;

import D7.C0379m;
import F8.f;
import android.text.TextUtils;
import androidx.lifecycle.s;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: DetailBaseViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010\u0004\u001a\u00020\u0005J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/ui/base/DetailBaseViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "macAddress", "", "deviceName", "getDeviceName", "()Ljava/lang/String;", "setDeviceName", "(Ljava/lang/String;)V", "aliasName", "getAliasName", "setAliasName", "productId", "getProductId", "setProductId", "colorId", "", "getColorId", "()I", "setColorId", "(I)V", "addr", "address", "getAddress", "setAddress", "getConnectionState", "Landroidx/lifecycle/LiveData;", "getEffectiveConnectionState", "uibase_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class DetailBaseViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20397b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20398c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f20399d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f20400e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20401f = -1;

    public final s<Integer> d(String macAddress) {
        h.e(macAddress, "macAddress");
        return C0379m.b(C0379m.g(AbstractC0939b.E().v(macAddress), new f(new PropertyReference1Impl() { // from class: com.oplus.melody.ui.base.DetailBaseViewModel$getConnectionState$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, cc.e
            public final Object get(Object obj) {
                return Integer.valueOf(((EarphoneDTO) obj).getConnectionState());
            }
        }, 0)));
    }

    public final void e(String addr) {
        h.e(addr, "addr");
        if (TextUtils.equals(this.f20397b, addr)) {
            return;
        }
        this.f20397b = addr;
        AbstractC0939b.E().J0(addr);
    }
}
