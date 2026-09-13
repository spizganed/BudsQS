package com.heytap.headset.component.about;

import F9.s;
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

/* JADX INFO: loaded from: classes.dex */
public class NetworkView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f17365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f17366c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RelativeLayout f17367p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f17368q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Animation f17369r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f17370s;

    public interface a {
    }

    public NetworkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17364a = context;
        LayoutInflater.from(getContext()).inflate(R.layout.heymelody_app_view_network, (ViewGroup) this, true);
        this.f17365b = (RelativeLayout) findViewById(R.id.rl_network_error);
        this.f17366c = (RelativeLayout) findViewById(R.id.rl_loading);
        this.f17368q = (ImageView) findViewById(R.id.iv_loading);
        this.f17367p = (RelativeLayout) findViewById(R.id.rl_network_failed);
        this.f17365b.setOnClickListener(this);
        a(2);
    }

    public final void a(int i10) {
        setVisibility(0);
        if (i10 == 1) {
            this.f17365b.setVisibility(0);
            this.f17367p.setVisibility(4);
            this.f17366c.setVisibility(4);
            this.f17368q.clearAnimation();
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.f17365b.setVisibility(0);
                this.f17367p.setVisibility(0);
                this.f17366c.setVisibility(4);
                this.f17368q.clearAnimation();
                return;
            }
            return;
        }
        this.f17365b.setVisibility(4);
        this.f17367p.setVisibility(4);
        this.f17366c.setVisibility(0);
        if (this.f17369r == null) {
            this.f17369r = AnimationUtils.loadAnimation(this.f17364a, R.anim.melody_ui_about_loading_rotate);
        }
        Animation animation = this.f17369r;
        if (animation != null) {
            animation.setInterpolator(new LinearInterpolator());
            this.f17368q.startAnimation(this.f17369r);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar;
        if ((view.getId() == R.id.rl_network_error || view.getId() == R.id.rl_network_failed) && (aVar = this.f17370s) != null) {
            PrivacyActivity privacyActivity = (PrivacyActivity) ((s) aVar).f1745b;
            privacyActivity.f17372V.a(2);
            privacyActivity.f17373W.loadUrl(PrivacyActivity.I(privacyActivity.f17371U));
        }
    }

    public void setOnReloadListener(a aVar) {
        this.f17370s = aVar;
    }
}
