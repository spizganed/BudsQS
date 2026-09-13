package com.oplus.melody.model.db;

import com.google.gson.reflect.TypeToken;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyTypeConverters {

    /* JADX INFO: renamed from: com.oplus.melody.model.db.MelodyTypeConverters$1, reason: invalid class name */
    class AnonymousClass1 extends TypeToken<List<Long>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.db.MelodyTypeConverters$2, reason: invalid class name */
    class AnonymousClass2 extends TypeToken<List<Integer>> {
    }

    /* JADX INFO: renamed from: com.oplus.melody.model.db.MelodyTypeConverters$5, reason: invalid class name */
    class AnonymousClass5 extends TypeToken<PersonalDressDTO.Tag> {
    }

    public static List<String> a(String str) {
        return (List) C0917x.d(str, new TypeToken<List<String>>() { // from class: com.oplus.melody.model.db.MelodyTypeConverters.3
        }.getType());
    }
}
