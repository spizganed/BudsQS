package com.oplus.melody.model.repository.zenmode;

import D7.i0;
import D7.j0;
import android.text.TextUtils;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f20176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f20178d;

    public /* synthetic */ j(int i10, Object obj, Object obj2, String str) {
        this.f20175a = i10;
        this.f20177c = obj;
        this.f20176b = str;
        this.f20178d = (Serializable) obj2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f20175a) {
            case 0:
                A.i("ZenModeRepository", "downloadZenModeAudioResource", (Throwable) obj);
                ((c) this.f20177c).b(0, this.f20176b, "Download zenmode audio bin file fail!");
                return (File) this.f20178d;
            case 1:
                List<ZenModeInfoDO> list = (List) obj;
                s sVar = (s) this.f20177c;
                sVar.getClass();
                String str = this.f20176b;
                if (list == null || list.isEmpty()) {
                    throw MelodyException.e(0, "getActiveSceneV2 " + A.r(str) + " EMPTY");
                }
                for (ZenModeInfoDO zenModeInfoDO : list) {
                    if (TextUtils.equals(zenModeInfoDO.getResId(), (String) this.f20178d) && ZenModeRepository.l(zenModeInfoDO).exists()) {
                        return zenModeInfoDO;
                    }
                }
                ZenModeInfoDO zenModeInfoDO2 = (ZenModeInfoDO) list.get(0);
                sVar.y(str, zenModeInfoDO2.getResId());
                return zenModeInfoDO2;
            default:
                return ((j0) obj).d(this.f20176b, i0.a((Class[]) this.f20177c, (Object[]) this.f20178d));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ j(String str, Class[] clsArr, Object[] objArr) {
        this.f20175a = 2;
        this.f20176b = str;
        this.f20177c = clsArr;
        this.f20178d = objArr;
    }
}
