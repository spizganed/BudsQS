package com.heytap.headset.component.about;

import D7.C0373g;
import P3.l;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.media3.session.N0;
import com.heytap.headset.R;
import com.heytap.upgrade.model.UpgradeInfo;
import com.oplus.melody.common.data.WhitelistContentDO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.K;
import com.oplus.melody.common.util.S;
import d4.b;
import d4.c;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes.dex */
public class FindAppUpgradeActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f17360p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatTextView f17361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatTextView f17362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatTextView f17363c;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.tv_app_upgrade_cancel) {
            finish();
            return;
        }
        if (id != R.id.tv_app_upgrade_ok) {
            return;
        }
        WhitelistContentDO whitelistContentDOH = AbstractC1508a.f().h();
        if (whitelistContentDOH != null && (str = Build.BRAND) != null) {
            String lowerCase = str.trim().toLowerCase();
            int iJ = S.j();
            Map<String, String> appMarket = whitelistContentDOH.getAppMarket();
            if (appMarket == null) {
                appMarket = Collections.EMPTY_MAP;
            }
            A.c("FindAppUpgradeActivity", new l(iJ, 0, whitelistContentDOH, lowerCase));
            if (appMarket.containsKey(lowerCase) || (iJ > 0 && iJ < 23)) {
                if (!C0905k.a(C0906l.f19501a, C0906l.f19501a.getPackageName(), appMarket.get(lowerCase))) {
                }
            }
            finish();
        }
        A.x("FindAppUpgradeActivity", "startDownload whitelist is null");
        c.f22253c.getClass();
        if (!C0373g.f1086l) {
            if (c.f22255q != null) {
                c.b bVar = b.f22252a;
                UpgradeInfo upgradeInfo = c.f22255q;
                h.b(upgradeInfo);
                ForkJoinPool.commonPool().execute(new N0(upgradeInfo, 7));
            } else {
                A.x("AppUpgradeRepository", "startDownload upgradeInfo is null!");
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.heymelody_app_activity_find_upgrade);
        ((AppCompatTextView) findViewById(R.id.tv_app_upgrade_cancel)).setOnClickListener(this);
        ((AppCompatTextView) findViewById(R.id.tv_app_upgrade_ok)).setOnClickListener(this);
        this.f17361a = (AppCompatTextView) findViewById(R.id.tv_app_upgrade_new_version);
        this.f17362b = (AppCompatTextView) findViewById(R.id.tv_app_upgrade_new_version_size);
        this.f17363c = (AppCompatTextView) findViewById(R.id.tv_app_upgrade_content);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("versionName");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        String stringExtra2 = intent.getStringExtra("apkFileSize");
        long j5 = !TextUtils.isEmpty(stringExtra2) ? Long.parseLong(stringExtra2) : -1L;
        if (j5 <= 0) {
            return;
        }
        this.f17361a.setText(getString(R.string.melody_common_upgrade_new_version) + " V" + stringExtra);
        this.f17362b.setText(getString(R.string.melody_common_upgrade_new_version_size) + ' ' + K.e(j5));
        String stringExtra3 = intent.getStringExtra("upgradeComment");
        if (!TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = stringExtra3.replace("//n", "/n");
        }
        this.f17363c.setText(stringExtra3);
    }
}
