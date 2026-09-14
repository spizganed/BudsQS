package com.oplus.melody.ui.component.detail.about;

import E9.h;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f20600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f20601c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RelativeLayout f20602p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f20603q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Animation f20604r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f20605s;

    public interface a {
    }

    public NetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20599a = context;
        LayoutInflater.from(getContext()).inflate(R.layout.melody_ui_about_view_network, (ViewGroup) this, true);
        this.f20600b = (RelativeLayout) findViewById(R.id.rl_network_error);
        this.f20601c = (RelativeLayout) findViewById(R.id.rl_loading);
        this.f20603q = (ImageView) findViewById(R.id.iv_loading);
        this.f20602p = (RelativeLayout) findViewById(R.id.rl_network_failed);
        this.f20600b.setOnClickListener(this);
        a(2);
    }

    public final void a(int i10) {
        setVisibility(0);
        if (i10 == 1) {
            this.f20600b.setVisibility(0);
            this.f20602p.setVisibility(4);
            this.f20601c.setVisibility(4);
            this.f20603q.clearAnimation();
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.f20600b.setVisibility(0);
                this.f20602p.setVisibility(0);
                this.f20601c.setVisibility(4);
                this.f20603q.clearAnimation();
                return;
            }
            return;
        }
        this.f20600b.setVisibility(4);
        this.f20602p.setVisibility(4);
        this.f20601c.setVisibility(0);
        if (this.f20604r == null) {
            this.f20604r = AnimationUtils.loadAnimation(this.f20599a, R.anim.melody_ui_about_loading_rotate);
        }
        Animation animation = this.f20604r;
        if (animation != null) {
            animation.setInterpolator(new LinearInterpolator());
            this.f20603q.startAnimation(this.f20604r);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        if ((view.getId() == R.id.rl_network_error || view.getId() == R.id.rl_network_failed) && (aVar = this.f20605s) != null) {
            PrivacyActivity privacyActivity = (PrivacyActivity) ((h) aVar).f1398b;
            privacyActivity.f20608V.a(2);
            privacyActivity.f20609W.loadUrl("open_source".equals(privacyActivity.f20607U) ? "file:///android_asset/html/open_source_licenses.html" : "");
        }
    }

    public void setOnReloadListener(a aVar) {
        this.f20605s = aVar;
    }
}
