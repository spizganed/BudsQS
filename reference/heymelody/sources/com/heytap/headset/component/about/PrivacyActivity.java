package com.heytap.headset.component.about;

import A9.k;
import Aa.e;
import D7.C0373g;
import D7.RunnableC0380n;
import D7.o0;
import E9.t;
import P3.m;
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
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyActivity extends F8.a {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f17371U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public NetworkView f17372V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public WebView f17373W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public WebSettings f17374X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public LinearLayout f17375Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public Context f17376Z;

    public class a extends s {
        public a() {
            super(true);
        }

        @Override // c.s
        public final void b() {
            PrivacyActivity privacyActivity = PrivacyActivity.this;
            if (privacyActivity.f17373W.canGoBack()) {
                privacyActivity.f17373W.goBack();
            } else {
                f(false);
                privacyActivity.getOnBackPressedDispatcher().c();
            }
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrivacyActivity f17378a;

        public b(PrivacyActivity privacyActivity) {
            this.f17378a = privacyActivity;
        }

        @JavascriptInterface
        public void download() {
            A.b("PrivacyActivity", "download..");
            o0.d(new RunnableC0380n(this, 17));
        }

        @JavascriptInterface
        public void navigateToOldVersion() {
            A.b("PrivacyActivity", "navigateToOldVersion..");
            o0.d(new t(this, 16));
        }

        @JavascriptInterface
        public void navigateToPersonalInfoList() {
            A.b("PrivacyActivity", "navigateToPersonalInfoList..");
            o0.d(new k(this, 18));
        }

        @JavascriptInterface
        public void navigateToPrivacyPolicy() {
            A.b("PrivacyActivity", "navigateToPrivacyPolicy..");
            o0.d(new e(this, 11));
        }

        @JavascriptInterface
        public void navigateToSetting() {
            A.b("PrivacyActivity", "navigateToSetting: ");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.f17378a.getPackageName(), null));
            C0905k.j(PrivacyActivity.this, intent);
        }
    }

    public static String I(String str) {
        if ("privacy".equals(str)) {
            J7.b.a().d();
            return "zh".equals(Locale.getDefault().getLanguage()) ? "file:///android_asset/html/HeyMelody_Privacy_Policy_zh_SG.html" : "file:///android_asset/html/HeyMelody_Privacy_Policy_en_SG.html";
        }
        if (!"user_agreement".equals(str)) {
            return "open_source".equals(str) ? "file:///android_asset/html/open_source_licenses.html" : "personal_information_list".equals(str) ? "file:///android_asset/html/HeyMelody_Personal_Information_List.html" : "";
        }
        J7.b.a().d();
        return "zh".equals(Locale.getDefault().getLanguage()) ? "file:///android_asset/html/HeyMelody_User_Agreement_zh_SG.html" : "file:///android_asset/html/HeyMelody_User_Agreement_en_SG.html";
    }

    @Override // F8.a
    public final void E() {
        if (C0373g.f1086l) {
            setTheme(R.style.CombineMelodyActivityTheme);
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        this.f17376Z = context;
        super.attachBaseContext(context);
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.heymelody_app_activity_privacy);
        D(R.id.root_main, true);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        x().o();
        x().n(true);
        x().p(false);
        this.f17372V = (NetworkView) findViewById(R.id.view_net);
        this.f17375Y = (LinearLayout) findViewById(R.id.ll_web);
        WebView webView = new WebView(getApplicationContext());
        this.f17373W = webView;
        webView.setOverScrollMode(2);
        this.f17373W.setHorizontalScrollBarEnabled(false);
        this.f17373W.setVerticalScrollBarEnabled(false);
        this.f17373W.setBackgroundColor(getColor(R.color.coui_transparence));
        this.f17375Y.addView(this.f17373W);
        this.f17372V.setOnReloadListener(new F9.s(this, 7));
        Intent intent = getIntent();
        if (intent != null) {
            this.f17371U = intent.getStringExtra("privacy_type");
        }
        this.f17373W.setWebViewClient(new m(this));
        WebSettings settings = this.f17373W.getSettings();
        this.f17374X = settings;
        settings.setJavaScriptEnabled(true);
        this.f17374X.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        this.f17374X.setLoadWithOverviewMode(true);
        this.f17374X.setAllowFileAccess(false);
        this.f17374X.setAllowFileAccessFromFileURLs(false);
        this.f17374X.setAllowUniversalAccessFromFileURLs(false);
        this.f17374X.setAllowContentAccess(false);
        this.f17373W.addJavascriptInterface(new b(this), "HeyTap");
        this.f17373W.loadUrl(I(this.f17371U));
        getOnBackPressedDispatcher().a(this, new a());
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            WebView webView = this.f17373W;
            if (webView != null) {
                if (webView.getParent() != null && (this.f17373W.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f17373W.getParent()).removeView(this.f17373W);
                }
                this.f17373W.stopLoading();
                this.f17373W.getSettings().setJavaScriptEnabled(false);
                this.f17373W.clearHistory();
                this.f17373W.removeAllViews();
                this.f17373W.destroy();
                this.f17373W = null;
                A.b("PrivacyActivity", "webViewDestroy: ");
            }
        } catch (Throwable th) {
            A.o(5, "PrivacyActivity", "webViewDestroy", th);
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        WebView webView = this.f17373W;
        if (webView == null || !webView.canGoBack()) {
            finish();
            return true;
        }
        this.f17373W.goBack();
        return true;
    }
}
