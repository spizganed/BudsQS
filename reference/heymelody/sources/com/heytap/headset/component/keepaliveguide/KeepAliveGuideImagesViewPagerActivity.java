package com.heytap.headset.component.keepaliveguide;

import E9.e;
import Ea.E;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import g4.C1069a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: KeepAliveGuideImagesViewPagerActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/heytap/headset/component/keepaliveguide/KeepAliveGuideImagesViewPagerActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "settingsItemStr", "", "settingItem", "Lcom/heytap/headset/repository/keepalive/KeepAliveGuideConfigDTO$SettingItem;", "pageIndicator", "Landroid/widget/TextView;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "imagesAdapter", "Lcom/heytap/headset/component/keepaliveguide/KeepAliveGuideImagesViewPagerActivity$ImagesAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "Companion", "ImagesAdapter", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveGuideImagesViewPagerActivity extends F8.a {

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public static final /* synthetic */ int f17396Z = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public String f17397U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public C1069a.c f17398V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public TextView f17399W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public ViewPager2 f17400X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public a f17401Y;

    /* JADX INFO: compiled from: KeepAliveGuideImagesViewPagerActivity.kt */
    public static final class a extends z<C1069a.C0254a, C0206a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final KeepAliveGuideImagesViewPagerActivity f17402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f17403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Jb.b f17404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f17405e;

        /* JADX INFO: renamed from: com.heytap.headset.component.keepaliveguide.KeepAliveGuideImagesViewPagerActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KeepAliveGuideImagesViewPagerActivity.kt */
        public final class C0206a extends RecyclerView.E {
            public C0206a(ImageView imageView) {
                super(imageView);
            }
        }

        public a(KeepAliveGuideImagesViewPagerActivity keepAliveGuideImagesViewPagerActivity, String str) {
            super(new com.heytap.headset.component.keepaliveguide.a());
            this.f17402b = keepAliveGuideImagesViewPagerActivity;
            this.f17403c = str;
            this.f17404d = kotlin.a.a(new e(this, 8));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.E e10, int i10) {
            String image;
            File fileO;
            C0206a holder = (C0206a) e10;
            h.e(holder, "holder");
            C1069a.C0254a c0254aC = c(i10);
            KeepAliveGuideImagesViewPagerActivity context = this.f17402b;
            h.e(context, "context");
            String rootPath = this.f17403c;
            h.e(rootPath, "rootPath");
            if (c0254aC == null || (image = c0254aC.getImage()) == null || (fileO = d.o(context, rootPath, image)) == null) {
                return;
            }
            RequestBuilder<Drawable> requestBuilderLoad = Glide.with((Context) context).load(fileO);
            View view = holder.itemView;
            h.c(view, "null cannot be cast to non-null type android.widget.ImageView");
            requestBuilderLoad.into((ImageView) view);
            holder.itemView.setOnClickListener(new E(a.this, 7));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.E onCreateViewHolder(ViewGroup parent, int i10) {
            h.e(parent, "parent");
            Object value = this.f17404d.getValue();
            h.d(value, "getValue(...)");
            View viewInflate = ((LayoutInflater) value).inflate(R.layout.heymelody_app_item_image_keep_alive, parent, false);
            h.c(viewInflate, "null cannot be cast to non-null type android.widget.ImageView");
            return new C0206a((ImageView) viewInflate);
        }
    }

    /* JADX INFO: compiled from: KeepAliveGuideImagesViewPagerActivity.kt */
    public static final class b {
        public b() {
        }
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.coui_center_dialog_exit);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.heytap.headset.component.keepaliveguide.KeepAliveGuideImagesViewPagerActivity.onCreate(android.os.Bundle):void");
    }
}
