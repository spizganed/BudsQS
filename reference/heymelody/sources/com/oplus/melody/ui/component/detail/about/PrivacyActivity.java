package com.oplus.melody.ui.component.detail.about;

import D7.i0;
import D7.j0;
import E9.h;
import M8.c;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import c.s;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;

/* JADX INFO: loaded from: classes3.dex */
public class PrivacyActivity extends F8.a {

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final /* synthetic */ int f20606X = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f20607U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public NetworkView f20608V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public WebView f20609W;

    public class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            PrivacyActivity privacyActivity = PrivacyActivity.this;
            if (privacyActivity.f20609W.canGoBack()) {
                privacyActivity.f20609W.goBack();
            } else {
                f(false);
                privacyActivity.getOnBackPressedDispatcher().c();
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrivacyActivity f20611a;

        public b(PrivacyActivity privacyActivity) {
            this.f20611a = privacyActivity;
        }

        @JavascriptInterface
        public void navigateToSetting() {
            A.b("PrivacyActivity", "navigateToSetting: ");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f20611a.getPackageName(), null));
            C0905k.j(PrivacyActivity.this, intent);
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Context context;
        super.onCreate(bundle);
        setContentView(R.layout.melody_ui_about_activity_privacy);
        D(R.id.root_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.o();
            aVarX.n(true);
            aVarX.p(false);
        }
        this.f20608V = (NetworkView) findViewById(R.id.view_net);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_web);
        Context context2 = C0906l.f19501a;
        if (context2.isDeviceProtectedStorage() && (context = (Context) j0.f(context2).d("createCredentialProtectedStorageContext", new i0[0])) != null) {
            context2 = context;
        }
        WebView webView = new WebView(context2);
        this.f20609W = webView;
        webView.setOverScrollMode(2);
        this.f20609W.setHorizontalScrollBarEnabled(false);
        this.f20609W.setVerticalScrollBarEnabled(false);
        this.f20609W.setBackgroundColor(getColor(R.color.coui_transparence));
        linearLayout.addView(this.f20609W);
        this.f20608V.setOnReloadListener(new h(this, 3));
        Intent intent = getIntent();
        if (intent != null) {
            this.f20607U = intent.getStringExtra("privacy_type");
        }
        this.f20609W.setWebViewClient(new c(this));
        WebSettings settings = this.f20609W.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        settings.setDomStorageEnabled(false);
        settings.setSavePassword(false);
        this.f20609W.addJavascriptInterface(new b(this), "Melody");
        this.f20609W.loadUrl("open_source".equals(this.f20607U) ? "file:///android_asset/html/open_source_licenses.html" : "");
        getOnBackPressedDispatcher().a(this, new a());
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            WebView webView = this.f20609W;
            if (webView != null) {
                if (webView.getParent() != null && (this.f20609W.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f20609W.getParent()).removeView(this.f20609W);
                }
                this.f20609W.stopLoading();
                WebSettings settings = this.f20609W.getSettings();
                settings.setJavaScriptEnabled(false);
                settings.setSavePassword(false);
                this.f20609W.clearHistory();
                this.f20609W.removeAllViews();
                this.f20609W.destroy();
                this.f20609W = null;
                A.b("PrivacyActivity", "webViewDestroy: ");
            }
        } catch (Exception e10) {
            A.c("PrivacyActivity", new M8.b(0, e10));
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        WebView webView = this.f20609W;
        if (webView == null || !webView.canGoBack()) {
            finish();
            return true;
        }
        this.f20609W.goBack();
        return true;
    }
}
