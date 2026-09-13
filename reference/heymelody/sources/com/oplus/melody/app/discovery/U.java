package com.oplus.melody.app.discovery;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: DiscoveryDialogActivity.java */
/* JADX INFO: loaded from: classes.dex */
public final class U extends CustomTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1 f18999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f19000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogActivity f19001c;

    public U(ImageView imageView, DiscoveryDialogActivity discoveryDialogActivity, C1 c12) {
        this.f19001c = discoveryDialogActivity;
        this.f18999a = c12;
        this.f19000b = imageView;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object obj, Transition transition) {
        Drawable drawable = (Drawable) obj;
        DiscoveryDialogActivity discoveryDialogActivity = this.f19001c;
        C1 c12 = this.f18999a;
        ImageView imageView = this.f19000b;
        DiscoveryDialogActivity.I(discoveryDialogActivity, c12, imageView, drawable);
        imageView.setImageDrawable(drawable);
        discoveryDialogActivity.f18844H0 = true;
        imageView.setVisibility(0);
        imageView.animate().alpha(1.0f).setDuration(300L).start();
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
    }
}
