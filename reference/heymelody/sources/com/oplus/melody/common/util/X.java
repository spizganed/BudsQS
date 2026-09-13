package com.oplus.melody.common.util;

import com.oplus.melody.common.data.WhitelistConfigDTO;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class X implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19480b;

    public /* synthetic */ X(String str, int i10) {
        this.f19479a = i10;
        this.f19480b = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f19479a) {
            case 0:
                WhitelistConfigDTO whitelistConfigDTO = (WhitelistConfigDTO) obj;
                if (whitelistConfigDTO != null) {
                    if (this.f19480b.equalsIgnoreCase(whitelistConfigDTO.getId())) {
                    }
                }
                break;
            default:
                a8.b bVar = (a8.b) obj;
                String name = bVar.getName();
                String str = this.f19480b;
                if (!name.equals(str) && bVar.getName().startsWith(str)) {
                    if (Pattern.compile("\\d*$").matcher(bVar.getName().substring(str.length())).matches()) {
                    }
                }
                break;
        }
        return false;
    }
}
