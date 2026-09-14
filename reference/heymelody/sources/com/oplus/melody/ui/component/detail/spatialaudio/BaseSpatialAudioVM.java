package com.oplus.melody.ui.component.detail.spatialaudio;

import R9.p;
import android.content.Context;
import androidx.lifecycle.u;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.base.BaseViewModel;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: BaseSpatialAudioVM.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0017J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001eH&J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0012H&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u001b\u001a\u00020\u0005H&J\"\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0005H&J\b\u0010)\u001a\u00020\u0018H&J\u0010\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020\u0012J\b\u0010,\u001a\u00020\u0018H\u0016J\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010.\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/oplus/melody/ui/component/detail/spatialaudio/BaseSpatialAudioVM;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mZipConfig", "Lcom/oplus/melody/ui/component/detail/spatialaudio/SpatialAudioZipConfig;", "getMZipConfig", "()Lcom/oplus/melody/ui/component/detail/spatialaudio/SpatialAudioZipConfig;", "setMZipConfig", "(Lcom/oplus/melody/ui/component/detail/spatialaudio/SpatialAudioZipConfig;)V", "mSpatialType", "Landroidx/lifecycle/MutableLiveData;", "", "getMSpatialType", "()Landroidx/lifecycle/MutableLiveData;", "setMSpatialType", "(Landroidx/lifecycle/MutableLiveData;)V", "initSpatialAudio", "", "context", "Landroid/content/Context;", "address", "zipConfig", "hasHeadTracker", "", "setSpatializerEnable", "enable", "setDesiredHeadTrackingMode", "mode", "getSpatializerType", "Landroidx/lifecycle/LiveData;", "onItemClick", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "id", "releaseSpatialAudio", "getSpatialPreviewAudio", "Ljava/io/File;", "updateSpatializerType", "getConnectionState", "macAddress", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class BaseSpatialAudioVM extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f21247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u<Integer> f21248d = new u<>();

    public abstract u d(String str);

    public boolean e(String str) {
        return true;
    }

    public void f(Context context, String address, p pVar) {
        h.e(context, "context");
        h.e(address, "address");
        this.f21246b = address;
        if (pVar != null) {
            this.f21247c = pVar;
        }
    }

    public abstract CompletableFuture<SetCommandStateDTO> g(int i10, String str);

    public abstract void h();

    public void i() {
    }
}
