package com.oplus.melody.ui.component.fitdetection;

import Ca.f;
import F8.a;
import android.os.Bundle;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.oplus.melody.ui.component.detail.AbsItem;

/* JADX INFO: loaded from: classes3.dex */
public class FitDetectionActivity extends a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final /* synthetic */ int f21538U = 0;

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FitDetectionFragment fitDetectionFragment = new FitDetectionFragment();
        fitDetectionFragment.setArguments(getIntent().getExtras());
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = new COUIBottomSheetDialogFragment();
        cOUIBottomSheetDialogFragment.setMainPanelFragment(fitDetectionFragment);
        cOUIBottomSheetDialogFragment.show(u(), AbsItem.DIALOG_FRAGMENT_TAG);
        fitDetectionFragment.D(new f(this, 7));
    }
}
