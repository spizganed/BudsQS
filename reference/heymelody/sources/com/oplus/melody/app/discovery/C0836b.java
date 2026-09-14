package com.oplus.melody.app.discovery;

import android.content.res.Configuration;
import androidx.media3.exoplayer.C0625v;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0836b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19040b;

    public /* synthetic */ C0836b(Object obj, int i10) {
        this.f19039a = i10;
        this.f19040b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Object obj = this.f19040b;
        switch (this.f19039a) {
            case 0:
                return "showBatteryViews batteriesRes=" + ((MelodyResourceDO) obj);
            case 1:
                int i10 = DiscoveryDialogActivity.f18836L0;
                return "old fontScale:" + ((Configuration) obj).fontScale;
            case 2:
                int i11 = DiscoveryDialogActivity.f18836L0;
                return "checkBatteryShowVideo tag:" + obj;
            case 3:
                return C0625v.i(((DiscoveryDialogViewModel) obj).f18889i, new StringBuilder("onCleared mShowCleanAddress:"));
            default:
                return "click retry shareAudioState:" + ((E0) obj).getShareAudioState();
        }
    }
}
