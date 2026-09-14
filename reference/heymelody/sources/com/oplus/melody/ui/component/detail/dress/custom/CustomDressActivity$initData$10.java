package com.oplus.melody.ui.component.detail.dress.custom;

import Wb.l;
import android.text.TextUtils;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
final /* synthetic */ class CustomDressActivity$initData$10 extends FunctionReferenceImpl implements l<String, Jb.l> {
    @Override // Wb.l
    public final Jb.l d(String str) {
        String str2 = str;
        CustomDressActivity customDressActivity = (CustomDressActivity) this.receiver;
        MelodyCompatButton melodyCompatButton = customDressActivity.f20877X;
        if (melodyCompatButton == null) {
            h.i("mSaveBtn");
            throw null;
        }
        melodyCompatButton.setEnabled(!TextUtils.isEmpty(str2));
        MelodyCompatButton melodyCompatButton2 = customDressActivity.f20876W;
        if (melodyCompatButton2 != null) {
            melodyCompatButton2.setEnabled(!TextUtils.isEmpty(str2));
            return Jb.l.f2618a;
        }
        h.i("mPreviewBtn");
        throw null;
    }
}
