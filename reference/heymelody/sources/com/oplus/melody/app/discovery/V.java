package com.oplus.melody.app.discovery;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: DiscoveryDialogActivity.java */
/* JADX INFO: loaded from: classes.dex */
public final class V extends CustomTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1 f19004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f19005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RunnableC0857i f19006c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f19007p;

    public V(DiscoveryDialogActivity discoveryDialogActivity, C1 c12, ImageView imageView, RunnableC0857i runnableC0857i) {
        this.f19007p = discoveryDialogActivity;
        this.f19004a = c12;
        this.f19005b = imageView;
        this.f19006c = runnableC0857i;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object obj, Transition transition) {
        Drawable drawable = (Drawable) obj;
        DiscoveryDialogActivity discoveryDialogActivity = this.f19007p;
        C1 c12 = this.f19004a;
        ImageView imageView = this.f19005b;
        DiscoveryDialogActivity.I(discoveryDialogActivity, c12, imageView, drawable);
        imageView.setImageDrawable(drawable);
        discoveryDialogActivity.f18844H0 = true;
        imageView.setVisibility(0);
        RunnableC0857i runnableC0857i = this.f19006c;
        if (runnableC0857i != null) {
            runnableC0857i.run();
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
    }
}
