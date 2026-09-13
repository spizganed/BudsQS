package com.oplus.melody.ui.component.detail.spinehealth;

import A6.l;
import Ea.DialogInterfaceOnClickListenerC0413w;
import H9.a;
import J7.b;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import kc.C1264t;
import kotlin.jvm.internal.h;

/* JADX INFO: loaded from: classes3.dex */
public class SpineHealthItem extends MelodyUiCOUIJumpPreference {
    private static final String HEALTH_PKG_NAME = "com.heytap.health";
    private static final String HEALTH_PKG_NAME_EXP = "com.heytap.health.international";
    public static final String ITEM_NAME = "SpineHealthItem";
    private static final String TAG = "SpineHealthItem";
    private Context mContext;
    private f mDownloadConfirmDialog;

    public SpineHealthItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mContext = context;
        setTitle(R.string.melody_ui_spine_health_title);
        setSummary(R.string.melody_ui_spine_health_summary);
        setOnPreferenceClickListener(new a(this, context, detailMainViewModel, 1));
        detailMainViewModel.d(detailMainViewModel.f20397b).e(interfaceC0601m, new l(this, 12));
        AbstractC0939b.E().I(detailMainViewModel.f20397b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(Context context, DetailMainViewModel detailMainViewModel, Preference preference) {
        A.b("SpineHealthItem", "click SpineHealthItem");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("healthap://app/path=154?extra_launch_type=7&tab=0&enter=false"));
        b.a().d();
        intent.setPackage(HEALTH_PKG_NAME_EXP);
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            intent.addFlags(32768);
            h.e(context, "context");
            C0905k.j(context, intent);
        } else {
            showDownloadConfirmDialog();
        }
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.SPINE_HEALTH.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Integer num) {
        setEnabled(num.intValue() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDownloadConfirmDialog$2(boolean z2, DialogInterface dialogInterface, int i10) {
        if (z2) {
            C0905k.a(this.mContext, HEALTH_PKG_NAME_EXP, "com.android.vending");
        } else {
            C0905k.a(this.mContext, HEALTH_PKG_NAME, "com.heytap.market");
        }
    }

    private void showDownloadConfirmDialog() {
        if (this.mDownloadConfirmDialog == null) {
            b.a().d();
            G7.b bVar = new G7.b(this.mContext);
            bVar.n(R.string.melody_ui_spine_health_dialog_download_ohealth_title);
            bVar.f(R.string.melody_ui_spine_health_dialog_download_ohealth_message);
            bVar.l(R.string.melody_ui_common_confirm, new T9.a(this, true, 0));
            bVar.h(R.string.melody_ui_common_cancel, new DialogInterfaceOnClickListenerC0413w(2));
            this.mDownloadConfirmDialog = bVar.setCancelable(true).create();
        }
        this.mDownloadConfirmDialog.show();
    }
}
