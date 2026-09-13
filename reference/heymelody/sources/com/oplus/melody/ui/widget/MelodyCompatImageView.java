package com.oplus.melody.ui.widget;

import A9.d;
import Aa.c;
import D7.H;
import D7.o0;
import D9.b;
import Ea.C0400i;
import Ea.C0401j;
import Ea.C0402k;
import Ea.C0403l;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import com.coui.appcompat.tintimageview.COUITintImageView;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import h0.l;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyCompatImageView extends COUITintImageView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f21778q = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimationDrawable f21779c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CompletableFuture<Void> f21780p;

    public MelodyCompatImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public static /* synthetic */ CompletableFuture a(MelodyCompatImageView melodyCompatImageView, List list, List list2) {
        A.c("MelodyCompatImageView", new b(1, list2));
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        b(animationDrawable, list2);
        melodyCompatImageView.setAnimationDrawable(animationDrawable);
        return melodyCompatImageView.c(list);
    }

    public static void b(AnimationDrawable animationDrawable, List<Drawable> list) {
        if (animationDrawable == null) {
            return;
        }
        A.c("MelodyCompatImageView", new C0401j(0, list));
        for (Drawable drawable : list) {
            if (drawable != null) {
                animationDrawable.addFrame(drawable, 33);
            }
        }
    }

    private void setAnimationDrawable(AnimationDrawable animationDrawable) {
        AnimationDrawable animationDrawable2 = this.f21779c;
        this.f21779c = animationDrawable;
        if (animationDrawable2 == animationDrawable) {
            return;
        }
        if (animationDrawable2 != null) {
            animationDrawable2.stop();
        }
        if (animationDrawable != null) {
            A.c("MelodyCompatImageView", new d(animationDrawable, 7));
            setImageDrawable(animationDrawable);
            animationDrawable.start();
        }
    }

    public final CompletableFuture<List<Drawable>> c(List<String> list) {
        List list2 = (List) list.stream().map(new c(this, 2)).collect(Collectors.toList());
        return CompletableFuture.allOf((CompletableFuture[]) list2.toArray(new CompletableFuture[list2.size()])).thenApply((Function<? super Void, ? extends U>) new C0403l(list2, 0));
    }

    public final void d(MelodyResourceDO melodyResourceDO, String str, int i10, boolean z2) {
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        File fileN = com.oplus.drs.core.d.n(heyMelodyApplication, melodyResourceDO, str);
        String str2 = (String) getTag(R.id.melody_ui_image_path_tag);
        if (fileN != null && !TextUtils.equals(str2, fileN.getAbsolutePath())) {
            setTag(R.id.melody_ui_image_path_tag, fileN.getAbsolutePath());
            if (str2 != null) {
                Glide.with(heyMelodyApplication).clear(this);
            }
        }
        if (!z2 || fileN == null) {
            Glide.with(heyMelodyApplication).load(fileN).error(i10).into(this);
        } else {
            Glide.with(heyMelodyApplication).load(fileN).signature(new ObjectKey(Long.valueOf(fileN.lastModified()))).error(i10).into(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        CompletableFuture<Void> completableFuture = this.f21780p;
        this.f21780p = null;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        setAnimationDrawable(null);
        super.onDetachedFromWindow();
    }

    public void setAnimationPathList(List<String> list) {
        List<String> listSubList;
        CompletableFuture<Void> completableFuture = this.f21780p;
        this.f21780p = null;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        A.c("MelodyCompatImageView", new C0400i(0, list));
        if (list.size() > 1) {
            List<String> listSubList2 = list.subList(0, 1);
            listSubList = list.subList(1, list.size());
            list = listSubList2;
        } else {
            listSubList = Collections.EMPTY_LIST;
        }
        CompletableFuture<List<Drawable>> completableFutureC = c(list);
        C0402k c0402k = new C0402k(0, this, listSubList);
        l lVar = o0.c.f1144b;
        this.f21780p = completableFutureC.thenComposeAsync((Function<? super List<Drawable>, ? extends CompletionStage<U>>) c0402k, (Executor) lVar).thenAcceptAsync((Consumer<? super U>) new H(this, 2), (Executor) lVar);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f21779c != drawable) {
            this.f21779c = null;
            CompletableFuture<Void> completableFuture = this.f21780p;
            this.f21780p = null;
            if (completableFuture != null) {
                completableFuture.cancel(true);
            }
        }
    }
}
