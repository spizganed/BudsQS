package com.oplus.melody.app.discovery;

import android.text.TextUtils;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.model.db.PersonalDressEntity;
import com.oplus.melody.model.repository.personaldress.a;
import java.io.File;
import java.util.function.Supplier;
import u8.C1558f;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class D implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18832c;

    public /* synthetic */ D(int i10, Object obj, Object obj2) {
        this.f18830a = i10;
        this.f18831b = obj;
        this.f18832c = obj2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        Object obj = this.f18832c;
        Object obj2 = this.f18831b;
        switch (this.f18830a) {
            case 0:
                DiscoveryDialogViewModel discoveryDialogViewModel = ((DiscoveryDialogActivity) obj2).f18853Z;
                String id = ((E0) obj).getId();
                discoveryDialogViewModel.getClass();
                Object obj3 = com.oplus.melody.model.repository.personaldress.a.f20060c;
                PersonalDressEntity personalDressEntityB = a.C0231a.a().b(id);
                if (personalDressEntityB != null) {
                    String themeId = personalDressEntityB.getThemeId();
                    if (!TextUtils.isEmpty(themeId)) {
                        return themeId;
                    }
                }
                return BaseHealthModule.TRACK_FATIGUE_REMIND;
            case 1:
                StringBuilder sb2 = new StringBuilder("getCustomAttireZipConfig attireId=");
                sb2.append((String) obj2);
                sb2.append(" isDir=");
                File file = (File) obj;
                sb2.append(file.isDirectory());
                sb2.append(" exist=");
                sb2.append(file.exists());
                return sb2.toString();
            default:
                return "forceDarkAllowed:" + ((Boolean) obj2) + " statesDOVersion:" + ((C1558f) obj).getMinVersion();
        }
    }
}
