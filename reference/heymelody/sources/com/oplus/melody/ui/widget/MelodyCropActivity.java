package com.oplus.melody.ui.widget;

import A6.g;
import A9.c;
import Ca.r;
import D7.C0379m;
import D7.Y;
import D7.o0;
import Ea.C0404m;
import Ea.C0406o;
import Ea.ViewOnClickListenerC0405n;
import Wb.l;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.view.M;
import androidx.core.view.e0;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: MelodyCropActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001dJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyCropActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mCropImv", "Lcom/oplus/melody/ui/widget/MelodyCropImageView;", "mOutPath", "", "mRotateBtnLayout", "Landroid/view/View;", "mAddress", "mDeviceName", "mProductId", "mOutWidth", "", "mOutHeight", "isSaveIng", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "getHeadsetConnectionState", "Landroidx/lifecycle/LiveData;", "getConnectionState", "onConnectionStateChange", "state", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyCropActivity extends F8.a {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final /* synthetic */ int f21782d0 = 0;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public MelodyCropImageView f21783U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public String f21784V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public View f21785W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public String f21786X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public String f21787Y = "";

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public String f21788Z = "";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f21789a0 = 250;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f21790b0 = 250;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f21791c0;

    /* JADX INFO: compiled from: MelodyCropActivity.kt */
    public static final class a implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f21792a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(l lVar) {
            this.f21792a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21792a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21792a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.widget.MelodyCropActivity$onCreate$6, reason: invalid class name */
    /* JADX INFO: compiled from: MelodyCropActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            MelodyCropActivity melodyCropActivity = (MelodyCropActivity) this.receiver;
            int i10 = MelodyCropActivity.f21782d0;
            melodyCropActivity.getClass();
            A.c("MelodyCropActivity", new Y(iIntValue, 2));
            if (iIntValue == 3) {
                melodyCropActivity.finish();
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.widget.MelodyCropActivity$onCreate$7, reason: invalid class name */
    /* JADX INFO: compiled from: MelodyCropActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements l<Integer, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(Integer num) {
            int iIntValue = num.intValue();
            MelodyCropActivity melodyCropActivity = (MelodyCropActivity) this.receiver;
            int i10 = MelodyCropActivity.f21782d0;
            melodyCropActivity.getClass();
            A.c("MelodyCropActivity", new Y(iIntValue, 2));
            if (iIntValue == 3) {
                melodyCropActivity.finish();
            }
            return Jb.l.f2618a;
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        String absolutePath;
        Uri data;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        View decorView;
        e0 e0VarI;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.melody_ui_activity_custom_crop);
        D(R.id.activity_custom_crop_main, true);
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (e0VarI = M.i(decorView)) != null) {
            e0VarI.a(false);
        }
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) findViewById(R.id.toolbar);
        melodyCompatToolbar.setTitleTextColor(getColor(R.color.melody_common_white));
        melodyCompatToolbar.setBackgroundColor(getColor(R.color.melody_ui_transparent));
        y(melodyCompatToolbar);
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
            aVarX.u(getString(R.string.melody_ui_custom_dress_crop_title));
            aVarX.q(R.drawable.melody_ui_crop_cancel);
        }
        View viewFindViewById = findViewById(R.id.img_crop_pic);
        h.d(viewFindViewById, "findViewById(...)");
        this.f21783U = (MelodyCropImageView) viewFindViewById;
        this.f21786X = C0914u.h(getIntent(), "device_mac_info");
        String strH = C0914u.h(getIntent(), "device_name");
        if (strH == null) {
            strH = "";
        }
        this.f21787Y = strH;
        String strH2 = C0914u.h(getIntent(), "product_id");
        this.f21788Z = strH2 != null ? strH2 : "";
        Intent intent = getIntent();
        int i10 = 250;
        this.f21789a0 = (intent == null || (extras3 = intent.getExtras()) == null) ? 250 : extras3.getInt("crop_width");
        Intent intent2 = getIntent();
        if (intent2 != null && (extras2 = intent2.getExtras()) != null) {
            i10 = extras2.getInt("crop_height");
        }
        this.f21790b0 = i10;
        if (this.f21786X == null) {
            finish();
            A.h("MelodyCropActivity", "onCreate mAddress is null");
            return;
        }
        MelodyCropImageView melodyCropImageView = this.f21783U;
        if (melodyCropImageView == null) {
            h.i("mCropImv");
            throw null;
        }
        melodyCropImageView.setWhRatio(this.f21789a0 / i10);
        Intent intent3 = getIntent();
        if (intent3 == null || (extras = intent3.getExtras()) == null || (absolutePath = extras.getString("out_path")) == null) {
            absolutePath = new File(getCacheDir(), "crop.jpg").getAbsolutePath();
            h.d(absolutePath, "getAbsolutePath(...)");
        }
        this.f21784V = absolutePath;
        Intent intent4 = getIntent();
        if (intent4 != null && (data = intent4.getData()) != null) {
            Bitmap bitmapA = Da.a.a(data.getPath(), 20971520L);
            if (bitmapA != null) {
                MelodyCropImageView melodyCropImageView2 = this.f21783U;
                if (melodyCropImageView2 == null) {
                    h.i("mCropImv");
                    throw null;
                }
                melodyCropImageView2.setImageBitmap(bitmapA);
            }
            A.c("MelodyCropActivity", new C0404m(bitmapA, 0));
        }
        View viewFindViewById2 = findViewById(R.id.layout_crop_rotate);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f21785W = viewFindViewById2;
        MelodyCropImageView melodyCropImageView3 = this.f21783U;
        if (melodyCropImageView3 == null) {
            h.i("mCropImv");
            throw null;
        }
        melodyCropImageView3.setRotateBtn(viewFindViewById2);
        View view = this.f21785W;
        if (view == null) {
            h.i("mRotateBtnLayout");
            throw null;
        }
        view.setOnClickListener(new ViewOnClickListenerC0405n(this, 0));
        if (com.oplus.melody.common.util.Y.j(AbstractC1508a.f().c(this.f21788Z, this.f21787Y))) {
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21786X), new A6.f(8))).e(this, new a(new AnonymousClass6(1, this, MelodyCropActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
        } else {
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.f21786X), new g(6))).e(this, new a(new AnonymousClass7(1, this, MelodyCropActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.melody_ui_crop_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
        } else if (itemId == R.id.crop_confirm) {
            if (this.f21791c0) {
                return false;
            }
            this.f21791c0 = true;
            CompletableFuture.supplyAsync(new r(this, 4), ForkJoinPool.commonPool()).whenCompleteAsync((BiConsumer) new c(new C0406o(this, 0), 1), (Executor) o0.c.f1144b);
        }
        return super.onOptionsItemSelected(item);
    }
}
