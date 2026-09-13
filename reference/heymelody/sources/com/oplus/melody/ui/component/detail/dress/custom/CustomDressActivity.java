package com.oplus.melody.ui.component.detail.dress.custom;

import A6.i;
import Ca.n;
import D7.C0379m;
import D7.C0384s;
import D7.o0;
import E9.h;
import E9.o;
import Ea.DialogInterfaceOnClickListenerC0412v;
import F9.s;
import G8.u;
import Q7.j;
import Wb.l;
import a9.C0531H;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.M;
import androidx.core.view.T;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.media3.session.D0;
import androidx.media3.session.q1;
import b9.C0738g;
import c9.C0770b;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.C0914u;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.personaldress.a;
import com.oplus.melody.ui.component.detail.dress.custom.a;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyCropActivity;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import com.oplus.melody.ui.widget.MelodyVideoAnimationView;
import e.C0984e;
import f.C1034b;
import f.e;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import p2.C1395b;
import s8.AbstractC1508a;
import u8.C1555c;

/* JADX INFO: compiled from: CustomDressActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u009f\u00012\u00020\u0001:\u0006\u009f\u0001 \u0001¡\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0014J\u0006\u0010T\u001a\u00020IJ\u0010\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020QH\u0016J\b\u0010Y\u001a\u00020QH\u0016J\b\u0010Z\u001a\u00020QH\u0014J\u0012\u0010[\u001a\u00020F2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010^\u001a\u00020F2\u0006\u0010_\u001a\u00020*H\u0016J\u0006\u0010`\u001a\u00020QJ\b\u0010c\u001a\u00020QH\u0002J\u0017\u0010d\u001a\u00020Q2\b\u0010e\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010fJ\u0012\u0010g\u001a\u00020Q2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002J\u0017\u0010j\u001a\u00020Q2\b\u0010k\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010lJ\u0010\u0010m\u001a\u00020Q2\u0006\u0010n\u001a\u00020FH\u0002J\u0012\u0010o\u001a\u00020Q2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J\u0012\u0010r\u001a\u00020Q2\b\u0010s\u001a\u0004\u0018\u00010qH\u0002J\u0017\u0010t\u001a\u00020Q2\b\u0010u\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010fJ\u0012\u0010v\u001a\u00020Q2\b\u0010w\u001a\u0004\u0018\u00010qH\u0002J\u0017\u0010x\u001a\u00020Q2\b\u0010y\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010lJ\u0017\u0010z\u001a\u00020Q2\b\u0010{\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010lJ\u0017\u0010|\u001a\u00020Q2\b\u0010}\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010fJ\u0017\u0010~\u001a\u00020Q2\b\u0010{\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010lJ\b\u0010\u007f\u001a\u00020QH\u0002J\t\u0010\u0080\u0001\u001a\u00020QH\u0002J\u0012\u0010\u0081\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020FH\u0002J\t\u0010\u0083\u0001\u001a\u00020QH\u0002J\u0019\u0010\u0084\u0001\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010lJ\u0019\u0010\u0086\u0001\u001a\u00020Q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0002\u0010lJ\u0019\u0010\u0087\u0001\u001a\u00020Q2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010fJ\u0007\u0010\u0089\u0001\u001a\u00020QJ\u001b\u0010\u008f\u0001\u001a\u00020Q2\u0007\u0010\u0090\u0001\u001a\u00020L2\u0007\u0010\u0091\u0001\u001a\u00020qH\u0002J\u0012\u0010\u0094\u0001\u001a\u00020Q2\u0007\u0010\u0095\u0001\u001a\u00020<H\u0002J\u001b\u0010\u0096\u0001\u001a\u00020Q2\u0007\u0010\u0090\u0001\u001a\u00020L2\u0007\u0010\u0091\u0001\u001a\u00020qH\u0002J\u0012\u0010\u0097\u0001\u001a\u00020Q2\u0007\u0010\u0098\u0001\u001a\u00020qH\u0002J\u0012\u0010\u0099\u0001\u001a\u00020Q2\u0007\u0010\u009a\u0001\u001a\u00020<H\u0002J\t\u0010\u009b\u0001\u001a\u00020QH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020Q2\u0007\u0010\u009d\u0001\u001a\u00020\u0005H\u0002J\u0011\u0010\u009e\u0001\u001a\u00020Q2\u0006\u0010e\u001a\u00020IH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00107\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108X\u0082\u000e¢\u0006\u0004\n\u0002\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u008a\u0001\u001a\n\u0012\u0005\u0012\u00030\u008c\u00010\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u008d\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0092\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0093\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¢\u0001"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/custom/CustomDressActivity;", "Lcom/oplus/melody/ui/base/BaseActivity;", "<init>", "()V", "mPickResLayout", "Landroid/view/View;", "mPickResBtn", "Landroidx/appcompat/widget/AppCompatImageButton;", "mBottomBtnContainer", "mPreviewBtn", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mSaveBtn", "mApplyBtn", "mDeleteBtn", "mDefaultBatteryLayout", "mVerticalBatteryLayout", "mBelowBatteryLayout", "mBoxImg", "Landroid/widget/ImageView;", "mBudsImg", "mResLoadingView", "Lcom/oplus/melody/ui/widget/MelodyLottieAnimationView;", "mErrorLayout", "mReloadBtn", "mVideoContainer", "Landroid/widget/FrameLayout;", "mImageResView", "mMaskView", "mLimitLayout", "mAdjustContainer", "Landroidx/fragment/app/FragmentContainerView;", "mLimitImageTv", "Landroid/widget/TextView;", "mLimitVideoTv", "mLimitDurationTv", "mViewModel", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomDressViewModel;", "mModelLayout", "mModelBtnLayout", "mModelPromptTv", "mModelBtnSettingTv", "mEditMenu", "Landroid/view/MenuItem;", "mReUploadMenu", "mDefaultLeftBattery", "Lcom/oplus/melody/ui/widget/battery/BatteryViewWrapperDefault;", "mDefaultRightBattery", "mDefaultBoxBattery", "mVerticalLeftBattery", "Lcom/oplus/melody/ui/widget/battery/BatteryViewWrapperStyle1;", "mVerticalRightBattery", "mVerticalBoxBattery", "mBelowLeftBattery", "mBelowRightBattery", "mBelowBoxBattery", "mBatteryCells", "", "Lcom/oplus/melody/ui/widget/battery/BatteryViewWrapper;", "[Lcom/oplus/melody/ui/widget/battery/BatteryViewWrapper;", "mVideoPlayFile", "Ljava/io/File;", "mAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "mBlurHandler", "Landroid/os/Handler;", "mBlurRunnable", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomDressActivity$BlurRunnable;", "mCheckPlayRunnable", "Lcom/oplus/melody/ui/component/detail/dress/custom/CustomDressActivity$CheckPlayRunnable;", "mIsBlurring", "", "mIsApplying", "mLayoutId", "", "mPlayVideoFuture", "Ljava/util/concurrent/CompletableFuture;", "Landroid/net/Uri;", "mVideoView", "Lcom/oplus/melody/ui/widget/MelodyVideoAnimationView;", "mIsReplaceMimeType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onStart", "onStop", "onDestroy", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "initView", "mClickListener", "Landroid/view/View$OnClickListener;", "showPickUpDialog", "onPopupSourceStateChanged", "state", "(Ljava/lang/Integer;)V", "onUiModelChanged", "uiModel", "Lcom/oplus/melody/ui/component/detail/dress/custom/UiModel;", "onSavingChanged", "saving", "(Ljava/lang/Boolean;)V", "updateVideoPlayMode", "isEdit", "onMaskChanged", "mask", "", "onDressNameChanged", "name", "onBlurProgressChanged", "progress", "onPromptChanged", "prompt", "onShowPromptChanged", "showPrompt", "onDarkImgChanged", "darkImg", "applyComponentDisplayColorMode", "mode", "applyAutoComponentDisplayColor", "applyDefaultComponentColors", "applyLightComponentColors", "applyDirectComponentColor", "isDarkComponent", "restoreComponentLayoutColors", "onShowModelChanged", "show", "onShowBatteryChanged", "onBatteryStyleChanged", "style", "initData", "pickMediaLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/PickVisualMediaRequest;", "documentLauncher", "Landroid/content/Intent;", "parsePickMedia", "uri", SpeechFindManager.TYPE, "mCameraLauncher", "mCropLauncher", "updateModelImage", "path", "saveAlbumTempFile", "updateUiModel", "mimeType", "jumpCropActivity", "file", "loadHeadsetPicture", "makeAllTextViewLight", "view", "onConnectionStateChange", "Companion", "CheckPlayRunnable", "BlurRunnable", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CustomDressActivity extends F8.a {

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    public static final /* synthetic */ int f20854T0 = 0;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public Fa.c f20855A0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public Fa.c f20856B0;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public Fa.a[] f20857C0;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public File f20858D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public f f20859E0;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public Handler f20860F0;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public a f20861G0;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public b f20862H0;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public boolean f20863I0;

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public boolean f20864J0;

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public int f20865K0;

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public CompletableFuture<Uri> f20866L0;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public MelodyVideoAnimationView f20867M0;

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public boolean f20868N0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public final o f20869O0 = new o(this, 12);

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public final C0984e f20870P0 = (C0984e) t(new C1034b(), new h(this, 21));

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public final C0984e f20871Q0 = (C0984e) t(new e(), new s(this, 25));

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    public final C0984e f20872R0 = (C0984e) t(new e(), new n(this, 22));

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    public final C0984e f20873S0 = (C0984e) t(new e(), new q1(this, 3));

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public View f20874U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public View f20875V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public MelodyCompatButton f20876W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public MelodyCompatButton f20877X;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public MelodyCompatButton f20878Y;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public MelodyCompatButton f20879Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public View f20880a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public View f20881b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public View f20882c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ImageView f20883d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public ImageView f20884e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public MelodyLottieAnimationView f20885f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public View f20886g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public FrameLayout f20887h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public ImageView f20888i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public View f20889j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public View f20890k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public FragmentContainerView f20891l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public CustomDressViewModel f20892m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public View f20893n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public View f20894o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public TextView f20895p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public TextView f20896q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public MenuItem f20897r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public MenuItem f20898s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public Fa.b f20899t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public Fa.b f20900u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public Fa.b f20901v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public Fa.c f20902w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public Fa.c f20903x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public Fa.c f20904y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public Fa.c f20905z0;

    /* JADX INFO: compiled from: CustomDressActivity.kt */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<CustomDressActivity> f20906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20907b;

        public a(int i10, WeakReference weakReference) {
            this.f20906a = weakReference;
            this.f20907b = i10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            Throwable th;
            int i10;
            int i11;
            CustomDressActivity customDressActivity = this.f20906a.get();
            if (customDressActivity == null) {
                return;
            }
            CustomDressViewModel customDressViewModel = customDressActivity.f20892m0;
            String str2 = "mViewModel";
            if (customDressViewModel == null) {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
            Bitmap bitmap = customDressViewModel.f20925l;
            if (bitmap == null || (i10 = this.f20907b) < 1) {
                str = "mViewModel";
                th = null;
            } else {
                Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                int width = bitmapCopy.getWidth();
                int height = bitmapCopy.getHeight();
                int i12 = width * height;
                int[] iArr = new int[i12];
                bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
                int i13 = width - 1;
                int i14 = height - 1;
                int i15 = i10 + i10;
                int i16 = i15 + 1;
                th = null;
                int[] iArr2 = new int[i12];
                int[] iArr3 = new int[i12];
                int[] iArr4 = new int[i12];
                int i17 = 0;
                int[] iArr5 = new int[Math.max(width, height)];
                int i18 = (i15 + 2) >> 1;
                int i19 = i18 * i18;
                int i20 = i19 * 256;
                int[] iArr6 = new int[i20];
                for (int i21 = 0; i21 < i20; i21++) {
                    iArr6[i21] = i21 / i19;
                }
                int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i16, 3);
                int i22 = i10 + 1;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                while (i23 < height) {
                    int[][] iArr8 = iArr7;
                    int i26 = -i10;
                    int i27 = i17;
                    int i28 = i27;
                    int i29 = i28;
                    int i30 = i29;
                    int i31 = i30;
                    int i32 = i31;
                    int i33 = i32;
                    int i34 = i33;
                    int i35 = i34;
                    while (i26 <= i10) {
                        int i36 = i22;
                        String str3 = str2;
                        int i37 = i17;
                        int i38 = iArr[Math.min(i13, Math.max(i26, i37)) + i24];
                        int[] iArr9 = iArr8[i26 + i10];
                        iArr9[i37] = (i38 & 16711680) >> 16;
                        iArr9[1] = (i38 & 65280) >> 8;
                        iArr9[2] = i38 & 255;
                        int iAbs = i36 - Math.abs(i26);
                        int i39 = iArr9[i37];
                        i27 = (i39 * iAbs) + i27;
                        int i40 = iArr9[1];
                        i28 = (i40 * iAbs) + i28;
                        int i41 = iArr9[2];
                        i29 = (iAbs * i41) + i29;
                        if (i26 > 0) {
                            i33 += i39;
                            i34 += i40;
                            i35 += i41;
                        } else {
                            i30 += i39;
                            i31 += i40;
                            i32 += i41;
                        }
                        i26++;
                        i22 = i36;
                        str2 = str3;
                        i17 = 0;
                    }
                    int i42 = i22;
                    String str4 = str2;
                    int i43 = i10;
                    int i44 = 0;
                    while (i44 < width) {
                        iArr2[i24] = iArr6[i27];
                        iArr3[i24] = iArr6[i28];
                        iArr4[i24] = iArr6[i29];
                        int i45 = i27 - i30;
                        int i46 = i28 - i31;
                        int i47 = i29 - i32;
                        int[] iArr10 = iArr8[((i43 - i10) + i16) % i16];
                        int i48 = i30 - iArr10[0];
                        int i49 = i31 - iArr10[1];
                        int i50 = i32 - iArr10[2];
                        if (i23 == 0) {
                            i11 = i44;
                            iArr5[i11] = Math.min(i44 + i10 + 1, i13);
                        } else {
                            i11 = i44;
                        }
                        int i51 = iArr[i25 + iArr5[i11]];
                        int i52 = (i51 & 16711680) >> 16;
                        iArr10[0] = i52;
                        int i53 = (i51 & 65280) >> 8;
                        iArr10[1] = i53;
                        int i54 = i51 & 255;
                        iArr10[2] = i54;
                        int i55 = i33 + i52;
                        int i56 = i34 + i53;
                        int i57 = i35 + i54;
                        i27 = i45 + i55;
                        i28 = i46 + i56;
                        i29 = i47 + i57;
                        i43 = (i43 + 1) % i16;
                        int[] iArr11 = iArr8[i43 % i16];
                        int i58 = iArr11[0];
                        i30 = i48 + i58;
                        int i59 = iArr11[1];
                        i31 = i49 + i59;
                        int i60 = iArr11[2];
                        i32 = i50 + i60;
                        i33 = i55 - i58;
                        i34 = i56 - i59;
                        i35 = i57 - i60;
                        i24++;
                        i44 = i11 + 1;
                    }
                    i25 += width;
                    i23++;
                    iArr7 = iArr8;
                    i22 = i42;
                    str2 = str4;
                    i17 = 0;
                }
                int[][] iArr12 = iArr7;
                int i61 = i22;
                str = str2;
                int i62 = 0;
                while (i62 < width) {
                    int i63 = -i10;
                    int i64 = i63 * width;
                    int i65 = 0;
                    int i66 = 0;
                    int i67 = 0;
                    int i68 = 0;
                    int i69 = 0;
                    int i70 = 0;
                    int i71 = 0;
                    int i72 = 0;
                    int i73 = 0;
                    while (i63 <= i10) {
                        int i74 = i62;
                        int iMax = Math.max(0, i64) + i74;
                        int[] iArr13 = iArr12[i63 + i10];
                        iArr13[0] = iArr2[iMax];
                        iArr13[1] = iArr3[iMax];
                        iArr13[2] = iArr4[iMax];
                        int iAbs2 = i61 - Math.abs(i63);
                        i65 = (iArr2[iMax] * iAbs2) + i65;
                        i66 = (iArr3[iMax] * iAbs2) + i66;
                        i67 = (iArr4[iMax] * iAbs2) + i67;
                        if (i63 > 0) {
                            i71 += iArr13[0];
                            i72 += iArr13[1];
                            i73 += iArr13[2];
                        } else {
                            i68 += iArr13[0];
                            i69 += iArr13[1];
                            i70 += iArr13[2];
                        }
                        if (i63 < i14) {
                            i64 += width;
                        }
                        i63++;
                        i62 = i74;
                    }
                    int i75 = i62;
                    int i76 = i10;
                    int i77 = i75;
                    for (int i78 = 0; i78 < height; i78++) {
                        iArr[i77] = (iArr[i77] & (-16777216)) | (iArr6[i65] << 16) | (iArr6[i66] << 8) | iArr6[i67];
                        int i79 = i65 - i68;
                        int i80 = i66 - i69;
                        int i81 = i67 - i70;
                        int[] iArr14 = iArr12[((i76 - i10) + i16) % i16];
                        int i82 = i68 - iArr14[0];
                        int i83 = i69 - iArr14[1];
                        int i84 = i70 - iArr14[2];
                        int i85 = i77;
                        if (i75 == 0) {
                            iArr5[i78] = Math.min(i78 + i61, i14) * width;
                        }
                        int i86 = i75 + iArr5[i78];
                        int i87 = iArr2[i86];
                        iArr14[0] = i87;
                        int i88 = iArr3[i86];
                        iArr14[1] = i88;
                        int i89 = iArr4[i86];
                        iArr14[2] = i89;
                        int i90 = i71 + i87;
                        int i91 = i72 + i88;
                        int i92 = i73 + i89;
                        i65 = i79 + i90;
                        i66 = i80 + i91;
                        i67 = i81 + i92;
                        i76 = (i76 + 1) % i16;
                        int[] iArr15 = iArr12[i76];
                        int i93 = iArr15[0];
                        i68 = i82 + i93;
                        int i94 = iArr15[1];
                        i69 = i83 + i94;
                        int i95 = iArr15[2];
                        i70 = i84 + i95;
                        i71 = i90 - i93;
                        i72 = i91 - i94;
                        i73 = i92 - i95;
                        i77 = i85 + width;
                    }
                    i62 = i75 + 1;
                }
                bitmapCopy.setPixels(iArr, 0, width, 0, 0, width, height);
                bitmap = bitmapCopy;
            }
            customDressViewModel.f20926m = bitmap;
            CustomDressViewModel customDressViewModel2 = customDressActivity.f20892m0;
            if (customDressViewModel2 == null) {
                kotlin.jvm.internal.h.i(str);
                throw th;
            }
            Bitmap bitmap2 = customDressViewModel2.f20926m;
            if (bitmap2 != null) {
                ImageView imageView = customDressActivity.f20888i0;
                if (imageView == null) {
                    kotlin.jvm.internal.h.i("mImageResView");
                    throw th;
                }
                imageView.post(new B6.b(27, customDressActivity, bitmap2));
                CustomDressViewModel customDressViewModel3 = customDressActivity.f20892m0;
                if (customDressViewModel3 == null) {
                    kotlin.jvm.internal.h.i(str);
                    throw th;
                }
                customDressViewModel3.g(Double.valueOf(Da.c.a(bitmap2)));
            }
            customDressActivity.f20863I0 = false;
        }
    }

    /* JADX INFO: compiled from: CustomDressActivity.kt */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<CustomDressActivity> f20908a;

        public b(WeakReference<CustomDressActivity> weakReference) {
            this.f20908a = weakReference;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CustomDressActivity customDressActivity = this.f20908a.get();
            if (customDressActivity == null) {
                return;
            }
            MelodyVideoAnimationView melodyVideoAnimationView = customDressActivity.f20867M0;
            if (melodyVideoAnimationView != null) {
                melodyVideoAnimationView.d();
            }
            customDressActivity.f20862H0 = null;
            A.c("CustomDressActivity", new c9.f(customDressActivity, 1));
        }
    }

    /* JADX INFO: compiled from: CustomDressActivity.kt */
    public static final class c implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20909a;

        public c(l lVar) {
            this.f20909a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return kotlin.jvm.internal.h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20909a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20909a.d(obj);
        }
    }

    public static void M(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextColor(Q1.a.b(textView.getCurrentTextColor()));
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.h.d(childAt, "getChildAt(...)");
                M(childAt);
            }
        }
    }

    public final void I(Boolean bool) {
        if (Build.VERSION.SDK_INT >= 29) {
            View view = this.f20893n0;
            if (view == null) {
                kotlin.jvm.internal.h.i("mModelLayout");
                throw null;
            }
            view.setForceDarkAllowed(true);
            ImageView imageView = this.f20888i0;
            if (imageView == null) {
                kotlin.jvm.internal.h.i("mImageResView");
                throw null;
            }
            imageView.setForceDarkAllowed(true);
            if (Q1.a.a(this)) {
                ImageView imageView2 = this.f20888i0;
                if (imageView2 == null) {
                    kotlin.jvm.internal.h.i("mImageResView");
                    throw null;
                }
                imageView2.setColorFilter(new LightingColorFilter(-2236963, 0));
            }
        }
        Fa.a[] aVarArr = this.f20857C0;
        if (aVarArr != null) {
            for (Fa.a aVar : aVarArr) {
                aVar.a(true);
                aVar.f();
            }
        }
        TextView textView = this.f20895p0;
        if (textView == null) {
            kotlin.jvm.internal.h.i("mModelPromptTv");
            throw null;
        }
        textView.setTextColor(getColor(R.color.melody_ui_custom_dress_model_prompt_text_color));
        TextView textView2 = this.f20896q0;
        if (textView2 == null) {
            kotlin.jvm.internal.h.i("mModelBtnSettingTv");
            throw null;
        }
        textView2.setTextColor(getColor(R.color.coui_btn_secondary_text_color));
        TextView textView3 = this.f20896q0;
        if (textView3 == null) {
            kotlin.jvm.internal.h.i("mModelBtnSettingTv");
            throw null;
        }
        textView3.setBackgroundTintList(ColorStateList.valueOf(C1395b.a(this, R.attr.couiColorContainer8)));
        if (Q1.a.a(this) || !Boolean.TRUE.equals(bool)) {
            Fa.a[] aVarArr2 = this.f20857C0;
            if (aVarArr2 != null) {
                for (Fa.a aVar2 : aVarArr2) {
                    aVar2.d(false);
                }
            }
            TextView textView4 = this.f20895p0;
            if (textView4 != null) {
                textView4.setTextColor(getColor(R.color.melody_ui_custom_dress_model_prompt_text_color));
                return;
            } else {
                kotlin.jvm.internal.h.i("mModelPromptTv");
                throw null;
            }
        }
        Fa.a[] aVarArr3 = this.f20857C0;
        if (aVarArr3 != null) {
            for (Fa.a aVar3 : aVarArr3) {
                aVar3.d(true);
            }
        }
        TextView textView5 = this.f20895p0;
        if (textView5 == null) {
            kotlin.jvm.internal.h.i("mModelPromptTv");
            throw null;
        }
        M(textView5);
        View view2 = this.f20894o0;
        if (view2 == null) {
            kotlin.jvm.internal.h.i("mModelBtnLayout");
            throw null;
        }
        M(view2);
    }

    public final void J(Integer num) {
        int iIntValue = num != null ? num.intValue() : 0;
        if (iIntValue == 1) {
            K(false);
        } else if (iIntValue != 2) {
            CustomDressViewModel customDressViewModel = this.f20892m0;
            if (customDressViewModel == null) {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
            I(customDressViewModel.f20933t.d());
        } else {
            K(true);
        }
        CustomDressViewModel customDressViewModel2 = this.f20892m0;
        if (customDressViewModel2 != null) {
            N(customDressViewModel2.f20932s.d());
        } else {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
    }

    public final void K(boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            View view = this.f20893n0;
            if (view == null) {
                kotlin.jvm.internal.h.i("mModelLayout");
                throw null;
            }
            view.setForceDarkAllowed(false);
            ImageView imageView = this.f20888i0;
            if (imageView == null) {
                kotlin.jvm.internal.h.i("mImageResView");
                throw null;
            }
            imageView.setForceDarkAllowed(false);
        }
        Fa.a[] aVarArr = this.f20857C0;
        if (aVarArr != null) {
            for (Fa.a aVar : aVarArr) {
                aVar.a(false);
            }
        }
        int color = z2 ? Color.parseColor("#FFFFFFFF") : Color.parseColor("#FF000000");
        CustomDressViewModel customDressViewModel = this.f20892m0;
        if (customDressViewModel == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        Integer numD = customDressViewModel.f20913D.d();
        boolean z4 = (numD != null ? numD.intValue() : 0) != 0;
        int color2 = z4 ? Color.parseColor("#8A2DC84E") : color;
        int color3 = z4 ? z2 ? Color.parseColor("#89FFFFFF") : Color.parseColor("#89000000") : color;
        int color4 = z2 ? Color.parseColor("#26FFFFFF") : Color.parseColor("#14000000");
        Fa.a[] aVarArr2 = this.f20857C0;
        if (aVarArr2 != null) {
            for (Fa.a aVar2 : aVarArr2) {
                aVar2.c(color3);
                aVar2.b(color3);
                aVar2.e(color2);
            }
        }
        TextView textView = this.f20895p0;
        if (textView == null) {
            kotlin.jvm.internal.h.i("mModelPromptTv");
            throw null;
        }
        textView.setTextColor(color);
        TextView textView2 = this.f20896q0;
        if (textView2 == null) {
            kotlin.jvm.internal.h.i("mModelBtnSettingTv");
            throw null;
        }
        textView2.setTextColor(color);
        TextView textView3 = this.f20896q0;
        if (textView3 == null) {
            kotlin.jvm.internal.h.i("mModelBtnSettingTv");
            throw null;
        }
        textView3.setBackgroundTintList(ColorStateList.valueOf(color4));
    }

    public final void L(File file) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_res_width);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_res_height);
        Intent intent = new Intent(this, (Class<?>) MelodyCropActivity.class);
        CustomDressViewModel customDressViewModel = this.f20892m0;
        if (customDressViewModel == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        intent.putExtra("device_mac_info", customDressViewModel.f20916b);
        CustomDressViewModel customDressViewModel2 = this.f20892m0;
        if (customDressViewModel2 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        intent.putExtra("device_name", customDressViewModel2.f20917c);
        CustomDressViewModel customDressViewModel3 = this.f20892m0;
        if (customDressViewModel3 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        intent.putExtra("product_id", customDressViewModel3.f20918d);
        intent.setData(Uri.fromFile(file));
        intent.putExtra("crop_width", dimensionPixelOffset);
        intent.putExtra("crop_height", dimensionPixelOffset2);
        if (this.f20892m0 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        intent.putExtra("out_path", new File(CustomDressViewModel.e(), "custom_dress_crop.png").getAbsolutePath());
        this.f20873S0.a(intent);
    }

    public final void N(String str) {
        CustomDressViewModel customDressViewModel = this.f20892m0;
        if (customDressViewModel == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        Integer numD = customDressViewModel.f20938y.d();
        int iIntValue = numD != null ? numD.intValue() : 0;
        if (iIntValue != 2 && (iIntValue != 0 || !d.v(this))) {
            View view = this.f20889j0;
            if (view != null) {
                view.setBackgroundColor(0);
                return;
            } else {
                kotlin.jvm.internal.h.i("mMaskView");
                throw null;
            }
        }
        if (str != null) {
            try {
                View view2 = this.f20889j0;
                if (view2 != null) {
                    view2.setBackgroundColor(Color.parseColor(str));
                } else {
                    kotlin.jvm.internal.h.i("mMaskView");
                    throw null;
                }
            } catch (Exception unused) {
                A.h("CustomDressActivity", "updateMask error mask:".concat(str));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.Map] */
    public final void O(Uri uri, String str) {
        Long lValueOf;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        A.c("CustomDressActivity", new Ca.s(11, str, uri));
        if (com.oplus.melody.ui.component.detail.dress.custom.a.f20940a.get(str) == null) {
            A.c("CustomDressActivity", new D6.f(str, 14));
            E8.a.T(this, getString(R.string.melody_ui_pick_file_format_no_support_hint));
            return;
        }
        try {
            ContentResolver contentResolver = getContentResolver();
            lValueOf = (contentResolver == null || (parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r")) == null) ? null : Long.valueOf(parcelFileDescriptorOpenFileDescriptor.getStatSize());
        } catch (Exception e10) {
            A.i("CustomDressActivity", "parsePickMedia, error: ", e10);
        }
        if ("video".equals(a.C0234a.a(str)) && (lValueOf == null || lValueOf.longValue() > 104857600)) {
            E8.a.T(this, getString(R.string.melody_ui_pick_file_size_too_big_hint));
            return;
        }
        if (str.equals("image/gif") && (lValueOf == null || lValueOf.longValue() > 104857600)) {
            E8.a.T(this, getString(R.string.melody_ui_pick_file_size_too_big_hint));
            return;
        }
        View view = this.f20874U;
        if (view == null) {
            kotlin.jvm.internal.h.i("mPickResLayout");
            throw null;
        }
        view.setVisibility(8);
        MelodyLottieAnimationView melodyLottieAnimationView = this.f20885f0;
        if (melodyLottieAnimationView == null) {
            kotlin.jvm.internal.h.i("mResLoadingView");
            throw null;
        }
        melodyLottieAnimationView.setVisibility(0);
        CustomDressViewModel customDressViewModel = this.f20892m0;
        if (customDressViewModel == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        kotlin.jvm.internal.h.e(uri, "uri");
        CompletableFuture completableFutureSupplyAsync = CompletableFuture.supplyAsync(new j(customDressViewModel, str, uri, 1), ForkJoinPool.commonPool());
        kotlin.jvm.internal.h.d(completableFutureSupplyAsync, "supplyAsync(...)");
        completableFutureSupplyAsync.whenCompleteAsync((BiConsumer) new A9.s(new P8.b(4, str, this), 28), (Executor) o0.c.f1144b);
    }

    public final void P() {
        G7.b bVar = new G7.b(this, R.style.COUIAlertDialog_Bottom);
        bVar.d(R.array.melody_ui_custom_dress_select_items, new DialogInterfaceOnClickListenerC0412v(this, 7));
        bVar.h(R.string.melody_ui_common_cancel, new G8.j(this, 7));
        f fVarCreate = bVar.create();
        this.f20859E0 = fVarCreate;
        if (fVarCreate != null) {
            fVarCreate.show();
        }
    }

    public final void Q(String str) {
        C1555c c1555c;
        InputStream inputStreamOpenRawResource;
        if (!this.f20868N0) {
            CustomDressViewModel customDressViewModel = this.f20892m0;
            if (customDressViewModel != null) {
                kotlin.jvm.internal.h.d(CompletableFuture.supplyAsync(new C0384s(18, str, customDressViewModel), ForkJoinPool.commonPool()).exceptionally((Function) new i(19)), "exceptionally(...)");
                return;
            } else {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
        }
        CustomDressViewModel customDressViewModel2 = this.f20892m0;
        if (customDressViewModel2 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        customDressViewModel2.f20926m = null;
        Object obj = com.oplus.melody.ui.component.detail.dress.custom.a.f20940a;
        String strA = a.C0234a.a(str);
        if (strA.equals("video")) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
            inputStreamOpenRawResource = heyMelodyApplication.getResources().openRawResource(R.raw.melody_ui_custom_dress_video_config);
            try {
                c1555c = (C1555c) C0917x.f(inputStreamOpenRawResource, C1555c.class);
                E8.a.i(inputStreamOpenRawResource, null);
            } finally {
            }
        } else if (strA.equals("image")) {
            HeyMelodyApplication heyMelodyApplication2 = C0906l.f19501a;
            if (heyMelodyApplication2 == null) {
                kotlin.jvm.internal.h.i("context");
                throw null;
            }
            inputStreamOpenRawResource = heyMelodyApplication2.getResources().openRawResource(R.raw.melody_ui_custom_dress_image_config);
            try {
                c1555c = (C1555c) C0917x.f(inputStreamOpenRawResource, C1555c.class);
                E8.a.i(inputStreamOpenRawResource, null);
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } else {
            A.h("CustomDressViewModel", "updateConfig mimeType:" + str + " error");
            c1555c = null;
        }
        if (c1555c != null) {
            customDressViewModel2.f20929p = c1555c;
        }
        customDressViewModel2.f20930q.i(new c9.n(str, true));
        if (a.C0234a.a(str).equals("video") || str.equals("image/gif")) {
            customDressViewModel2.g(null);
        }
    }

    @Override // F8.a, androidx.appcompat.app.i, c.i, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.h.e(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i10 = C0909o.e(this) > getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_horizontal_layout_mini_width) ? R.layout.melody_ui_activity_custom_dress_tablet : R.layout.melody_ui_activity_custom_dress;
        if (this.f20865K0 != i10) {
            A.b("CustomDressActivity", "onConfigurationChanged recreate");
            this.f20865K0 = i10;
            recreate();
        }
    }

    @Override // F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        int i10 = 4;
        super.onCreate(savedInstanceState);
        int i11 = 1;
        A.c("CustomDressActivity", new L6.b(i11, savedInstanceState));
        O viewModelStore = getViewModelStore();
        N.b defaultViewModelProviderFactory = getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = kotlin.jvm.internal.j.a(CustomDressViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        CustomDressViewModel customDressViewModel = (CustomDressViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20892m0 = customDressViewModel;
        String strH = C0914u.h(getIntent(), "dress_id");
        if (strH == null) {
            strH = "";
        }
        if (!TextUtils.isEmpty(strH)) {
            customDressViewModel.f20920f = strH;
        }
        String strH2 = C0914u.h(getIntent(), "device_mac_info");
        if (strH2 == null) {
            strH2 = "";
        }
        customDressViewModel.f20916b = strH2;
        String strH3 = C0914u.h(getIntent(), "device_name");
        if (strH3 == null) {
            strH3 = "";
        }
        customDressViewModel.f20917c = strH3;
        String strH4 = C0914u.h(getIntent(), "product_id");
        if (strH4 == null) {
            strH4 = "";
        }
        customDressViewModel.f20918d = strH4;
        String strH5 = C0914u.h(getIntent(), "product_color");
        customDressViewModel.f20919e = strH5 != null ? strH5 : "";
        if (TextUtils.isEmpty(customDressViewModel.f20916b) || TextUtils.isEmpty(customDressViewModel.f20917c) || TextUtils.isEmpty(customDressViewModel.f20918d) || TextUtils.isEmpty(customDressViewModel.f20919e)) {
            A.h("CustomDressActivity", "mAddress isEmpty:" + TextUtils.isEmpty(customDressViewModel.f20916b) + "mDeviceName isEmpty:" + TextUtils.isEmpty(customDressViewModel.f20917c) + "mProductId isEmpty:" + TextUtils.isEmpty(customDressViewModel.f20918d) + "mColorId isEmpty:" + TextUtils.isEmpty(customDressViewModel.f20919e));
        }
        int i12 = C0909o.e(this) > getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_dress_horizontal_layout_mini_width) ? R.layout.melody_ui_activity_custom_dress_tablet : R.layout.melody_ui_activity_custom_dress;
        this.f20865K0 = i12;
        setContentView(i12);
        y((MelodyCompatToolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a aVarX = x();
        if (aVarX != null) {
            aVarX.n(true);
            aVarX.r(true);
            aVarX.u(getString(R.string.melody_ui_custom_dress_title));
        }
        View viewFindViewById = findViewById(R.id.layout_custom_pick_res);
        kotlin.jvm.internal.h.d(viewFindViewById, "findViewById(...)");
        this.f20874U = viewFindViewById;
        int iG = g9.o.g(this, R.attr.couiColorPrimary);
        View view = this.f20874U;
        if (view == null) {
            kotlin.jvm.internal.h.i("mPickResLayout");
            throw null;
        }
        view.setBackgroundColor(E.b.h(iG, 38));
        View viewFindViewById2 = findViewById(R.id.btn_custom_pick_res);
        kotlin.jvm.internal.h.d(viewFindViewById2, "findViewById(...)");
        o oVar = this.f20869O0;
        ((AppCompatImageButton) viewFindViewById2).setOnClickListener(oVar);
        View viewFindViewById3 = findViewById(R.id.custom_dress_bottom_btn_container);
        kotlin.jvm.internal.h.d(viewFindViewById3, "findViewById(...)");
        this.f20875V = viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.btn_custom_preview_dress);
        kotlin.jvm.internal.h.d(viewFindViewById4, "findViewById(...)");
        MelodyCompatButton melodyCompatButton = (MelodyCompatButton) viewFindViewById4;
        this.f20876W = melodyCompatButton;
        melodyCompatButton.setOnClickListener(oVar);
        View viewFindViewById5 = findViewById(R.id.btn_custom_save_dress);
        kotlin.jvm.internal.h.d(viewFindViewById5, "findViewById(...)");
        MelodyCompatButton melodyCompatButton2 = (MelodyCompatButton) viewFindViewById5;
        this.f20877X = melodyCompatButton2;
        melodyCompatButton2.setOnClickListener(oVar);
        View viewFindViewById6 = findViewById(R.id.btn_custom_apply_dress);
        kotlin.jvm.internal.h.d(viewFindViewById6, "findViewById(...)");
        MelodyCompatButton melodyCompatButton3 = (MelodyCompatButton) viewFindViewById6;
        this.f20878Y = melodyCompatButton3;
        melodyCompatButton3.setOnClickListener(oVar);
        View viewFindViewById7 = findViewById(R.id.btn_custom_delete_dress);
        kotlin.jvm.internal.h.d(viewFindViewById7, "findViewById(...)");
        MelodyCompatButton melodyCompatButton4 = (MelodyCompatButton) viewFindViewById7;
        this.f20879Z = melodyCompatButton4;
        melodyCompatButton4.setOnClickListener(oVar);
        View viewFindViewById8 = findViewById(R.id.anim_custom_dress_res_loading);
        kotlin.jvm.internal.h.d(viewFindViewById8, "findViewById(...)");
        this.f20885f0 = (MelodyLottieAnimationView) viewFindViewById8;
        View viewFindViewById9 = findViewById(R.id.custom_dress_error_container);
        kotlin.jvm.internal.h.d(viewFindViewById9, "findViewById(...)");
        this.f20886g0 = viewFindViewById9;
        View viewFindViewById10 = findViewById(R.id.custom_dress_reload_btn);
        kotlin.jvm.internal.h.d(viewFindViewById10, "findViewById(...)");
        ((MelodyCompatButton) viewFindViewById10).setOnClickListener(oVar);
        View viewFindViewById11 = findViewById(R.id.custom_dress_video_container);
        kotlin.jvm.internal.h.d(viewFindViewById11, "findViewById(...)");
        this.f20887h0 = (FrameLayout) viewFindViewById11;
        View viewFindViewById12 = findViewById(R.id.iv_custom_image_res);
        kotlin.jvm.internal.h.d(viewFindViewById12, "findViewById(...)");
        this.f20888i0 = (ImageView) viewFindViewById12;
        View viewFindViewById13 = findViewById(R.id.model_mask);
        kotlin.jvm.internal.h.d(viewFindViewById13, "findViewById(...)");
        this.f20889j0 = viewFindViewById13;
        View viewFindViewById14 = findViewById(R.id.model_default_battery_layout);
        kotlin.jvm.internal.h.d(viewFindViewById14, "findViewById(...)");
        this.f20880a0 = viewFindViewById14;
        View viewFindViewById15 = findViewById(R.id.model_vertical_battery_layout);
        kotlin.jvm.internal.h.d(viewFindViewById15, "findViewById(...)");
        this.f20881b0 = viewFindViewById15;
        View viewFindViewById16 = findViewById(R.id.model_horizontal_battery_layout);
        kotlin.jvm.internal.h.d(viewFindViewById16, "findViewById(...)");
        this.f20882c0 = viewFindViewById16;
        View viewFindViewById17 = findViewById(R.id.model_box);
        kotlin.jvm.internal.h.d(viewFindViewById17, "findViewById(...)");
        this.f20883d0 = (ImageView) viewFindViewById17;
        View viewFindViewById18 = findViewById(R.id.model_buds);
        kotlin.jvm.internal.h.d(viewFindViewById18, "findViewById(...)");
        this.f20884e0 = (ImageView) viewFindViewById18;
        View viewFindViewById19 = findViewById(R.id.layout_custom_pick_res_limit);
        kotlin.jvm.internal.h.d(viewFindViewById19, "findViewById(...)");
        this.f20890k0 = viewFindViewById19;
        View viewFindViewById20 = findViewById(R.id.custom_dress_adjust_container);
        kotlin.jvm.internal.h.d(viewFindViewById20, "findViewById(...)");
        this.f20891l0 = (FragmentContainerView) viewFindViewById20;
        View viewFindViewById21 = findViewById(R.id.layout_custom_dress_res);
        kotlin.jvm.internal.h.d(viewFindViewById21, "findViewById(...)");
        this.f20893n0 = viewFindViewById21;
        View viewFindViewById22 = findViewById(R.id.model_bottom_btn_layout);
        kotlin.jvm.internal.h.d(viewFindViewById22, "findViewById(...)");
        this.f20894o0 = viewFindViewById22;
        View viewFindViewById23 = findViewById(R.id.model_prompt_tv);
        kotlin.jvm.internal.h.d(viewFindViewById23, "findViewById(...)");
        this.f20895p0 = (TextView) viewFindViewById23;
        View viewFindViewById24 = findViewById(R.id.model_btn_setting_tv);
        kotlin.jvm.internal.h.d(viewFindViewById24, "findViewById(...)");
        this.f20896q0 = (TextView) viewFindViewById24;
        View viewFindViewById25 = findViewById(R.id.tv_custom_pick_res_limit_image);
        kotlin.jvm.internal.h.d(viewFindViewById25, "findViewById(...)");
        ((TextView) viewFindViewById25).setText(getString(R.string.melody_ui_pick_image_format, "GIF/PNG/JPEG/JPG/BMP"));
        View viewFindViewById26 = findViewById(R.id.tv_custom_pick_res_limit_video);
        kotlin.jvm.internal.h.d(viewFindViewById26, "findViewById(...)");
        ((TextView) viewFindViewById26).setText(getString(R.string.melody_ui_pick_video_format, "MP4"));
        View viewFindViewById27 = findViewById(R.id.tv_custom_pick_res_limit_duration);
        kotlin.jvm.internal.h.d(viewFindViewById27, "findViewById(...)");
        View view2 = this.f20880a0;
        if (view2 == null) {
            kotlin.jvm.internal.h.i("mDefaultBatteryLayout");
            throw null;
        }
        View viewFindViewById28 = view2.findViewById(R.id.model_default_left_battery);
        kotlin.jvm.internal.h.d(viewFindViewById28, "findViewById(...)");
        Fa.b bVar = new Fa.b(viewFindViewById28);
        this.f20899t0 = bVar;
        bVar.h(0);
        Fa.b bVar2 = this.f20899t0;
        if (bVar2 != null) {
            bVar2.g(100, false);
        }
        View view3 = this.f20880a0;
        if (view3 == null) {
            kotlin.jvm.internal.h.i("mDefaultBatteryLayout");
            throw null;
        }
        View viewFindViewById29 = view3.findViewById(R.id.model_default_right_battery);
        kotlin.jvm.internal.h.d(viewFindViewById29, "findViewById(...)");
        Fa.b bVar3 = new Fa.b(viewFindViewById29);
        this.f20900u0 = bVar3;
        bVar3.h(0);
        Fa.b bVar4 = this.f20900u0;
        if (bVar4 != null) {
            bVar4.g(100, false);
        }
        View view4 = this.f20880a0;
        if (view4 == null) {
            kotlin.jvm.internal.h.i("mDefaultBatteryLayout");
            throw null;
        }
        View viewFindViewById30 = view4.findViewById(R.id.model_default_box_battery);
        kotlin.jvm.internal.h.d(viewFindViewById30, "findViewById(...)");
        Fa.b bVar5 = new Fa.b(viewFindViewById30);
        this.f20901v0 = bVar5;
        bVar5.h(0);
        Fa.b bVar6 = this.f20901v0;
        if (bVar6 != null) {
            bVar6.g(100, false);
        }
        View view5 = this.f20881b0;
        if (view5 == null) {
            kotlin.jvm.internal.h.i("mVerticalBatteryLayout");
            throw null;
        }
        View viewFindViewById31 = view5.findViewById(R.id.melody_ui_battery_group_left);
        kotlin.jvm.internal.h.d(viewFindViewById31, "findViewById(...)");
        Fa.c cVar = new Fa.c(viewFindViewById31);
        this.f20902w0 = cVar;
        cVar.g(R.drawable.melody_ui_battery_device_left);
        Fa.c cVar2 = this.f20902w0;
        if (cVar2 != null) {
            cVar2.i(0);
        }
        Fa.c cVar3 = this.f20902w0;
        if (cVar3 != null) {
            cVar3.h(100, false);
        }
        View view6 = this.f20881b0;
        if (view6 == null) {
            kotlin.jvm.internal.h.i("mVerticalBatteryLayout");
            throw null;
        }
        int i13 = 3;
        View viewFindViewById32 = view6.findViewById(R.id.melody_ui_battery_group_right);
        kotlin.jvm.internal.h.d(viewFindViewById32, "findViewById(...)");
        Fa.c cVar4 = new Fa.c(viewFindViewById32);
        this.f20903x0 = cVar4;
        cVar4.g(R.drawable.melody_ui_battery_device_right);
        Fa.c cVar5 = this.f20903x0;
        if (cVar5 != null) {
            cVar5.i(0);
        }
        Fa.c cVar6 = this.f20903x0;
        if (cVar6 != null) {
            cVar6.h(100, false);
        }
        int i14 = 6;
        View view7 = this.f20881b0;
        if (view7 == null) {
            kotlin.jvm.internal.h.i("mVerticalBatteryLayout");
            throw null;
        }
        View viewFindViewById33 = view7.findViewById(R.id.melody_ui_battery_group_box);
        kotlin.jvm.internal.h.d(viewFindViewById33, "findViewById(...)");
        Fa.c cVar7 = new Fa.c(viewFindViewById33);
        this.f20904y0 = cVar7;
        cVar7.g(R.drawable.melody_ui_battery_device_box);
        Fa.c cVar8 = this.f20904y0;
        if (cVar8 != null) {
            cVar8.i(0);
        }
        Fa.c cVar9 = this.f20904y0;
        if (cVar9 != null) {
            cVar9.h(100, false);
        }
        View view8 = this.f20882c0;
        if (view8 == null) {
            kotlin.jvm.internal.h.i("mBelowBatteryLayout");
            throw null;
        }
        View viewFindViewById34 = view8.findViewById(R.id.melody_ui_battery_group_left);
        kotlin.jvm.internal.h.d(viewFindViewById34, "findViewById(...)");
        Fa.c cVar10 = new Fa.c(viewFindViewById34);
        this.f20905z0 = cVar10;
        cVar10.g(R.drawable.melody_ui_battery_device_left);
        Fa.c cVar11 = this.f20905z0;
        if (cVar11 != null) {
            cVar11.i(0);
        }
        Fa.c cVar12 = this.f20905z0;
        if (cVar12 != null) {
            cVar12.h(100, false);
        }
        View view9 = this.f20882c0;
        if (view9 == null) {
            kotlin.jvm.internal.h.i("mBelowBatteryLayout");
            throw null;
        }
        View viewFindViewById35 = view9.findViewById(R.id.melody_ui_battery_group_right);
        kotlin.jvm.internal.h.d(viewFindViewById35, "findViewById(...)");
        Fa.c cVar13 = new Fa.c(viewFindViewById35);
        this.f20855A0 = cVar13;
        cVar13.g(R.drawable.melody_ui_battery_device_right);
        Fa.c cVar14 = this.f20855A0;
        if (cVar14 != null) {
            cVar14.i(0);
        }
        Fa.c cVar15 = this.f20855A0;
        if (cVar15 != null) {
            cVar15.h(100, false);
        }
        View view10 = this.f20882c0;
        if (view10 == null) {
            kotlin.jvm.internal.h.i("mBelowBatteryLayout");
            throw null;
        }
        View viewFindViewById36 = view10.findViewById(R.id.melody_ui_battery_group_box);
        kotlin.jvm.internal.h.d(viewFindViewById36, "findViewById(...)");
        Fa.c cVar16 = new Fa.c(viewFindViewById36);
        this.f20856B0 = cVar16;
        cVar16.g(R.drawable.melody_ui_battery_device_box);
        Fa.c cVar17 = this.f20856B0;
        if (cVar17 != null) {
            cVar17.i(0);
        }
        Fa.c cVar18 = this.f20856B0;
        if (cVar18 != null) {
            cVar18.h(100, false);
        }
        Fa.b bVar7 = this.f20899t0;
        kotlin.jvm.internal.h.b(bVar7);
        Fa.b bVar8 = this.f20900u0;
        kotlin.jvm.internal.h.b(bVar8);
        Fa.b bVar9 = this.f20901v0;
        kotlin.jvm.internal.h.b(bVar9);
        Fa.c cVar19 = this.f20902w0;
        kotlin.jvm.internal.h.b(cVar19);
        Fa.c cVar20 = this.f20903x0;
        kotlin.jvm.internal.h.b(cVar20);
        Fa.c cVar21 = this.f20904y0;
        kotlin.jvm.internal.h.b(cVar21);
        Fa.c cVar22 = this.f20905z0;
        kotlin.jvm.internal.h.b(cVar22);
        Fa.c cVar23 = this.f20855A0;
        kotlin.jvm.internal.h.b(cVar23);
        Fa.c cVar24 = this.f20856B0;
        kotlin.jvm.internal.h.b(cVar24);
        this.f20857C0 = new Fa.a[]{bVar7, bVar8, bVar9, cVar19, cVar20, cVar21, cVar22, cVar23, cVar24};
        View view11 = this.f20893n0;
        if (view11 == null) {
            kotlin.jvm.internal.h.i("mModelLayout");
            throw null;
        }
        ViewGroup.LayoutParams layoutParams = view11.getLayoutParams();
        if (this.f20865K0 == R.layout.melody_ui_activity_custom_dress && layoutParams.width == -1) {
            View view12 = this.f20893n0;
            if (view12 == null) {
                kotlin.jvm.internal.h.i("mModelLayout");
                throw null;
            }
            view12.post(new B6.b(26, this, layoutParams));
        }
        View viewFindViewById37 = findViewById(R.id.activity_custom_dress_main);
        kotlin.jvm.internal.h.d(viewFindViewById37, "findViewById(...)");
        ViewGroup.LayoutParams layoutParams2 = viewFindViewById37.getLayoutParams();
        kotlin.jvm.internal.h.c(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams.topMargin = Ja.a.a(this);
        u uVar = new u(marginLayoutParams, viewFindViewById37, this, i10);
        WeakHashMap<View, T> weakHashMap = M.f8369a;
        M.d.c(viewFindViewById37, uVar);
        A.c("CustomDressActivity", new C0770b(this, i11));
        CustomDressViewModel customDressViewModel2 = this.f20892m0;
        if (customDressViewModel2 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        Object obj = com.oplus.melody.model.repository.personaldress.a.f20060c;
        a.C0231a.a().d(customDressViewModel2.f20916b).e(this, new c(new C0531H(this, i14)));
        CustomDressViewModel customDressViewModel3 = this.f20892m0;
        if (customDressViewModel3 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        if (customDressViewModel3.f20929p == null) {
            if (TextUtils.isEmpty(customDressViewModel3.f20920f)) {
                CustomDressViewModel customDressViewModel4 = this.f20892m0;
                if (customDressViewModel4 == null) {
                    kotlin.jvm.internal.h.i("mViewModel");
                    throw null;
                }
                customDressViewModel4.f(false);
                View view13 = this.f20890k0;
                if (view13 == null) {
                    kotlin.jvm.internal.h.i("mLimitLayout");
                    throw null;
                }
                view13.setVisibility(0);
            } else {
                CustomDressViewModel customDressViewModel5 = this.f20892m0;
                if (customDressViewModel5 == null) {
                    kotlin.jvm.internal.h.i("mViewModel");
                    throw null;
                }
                customDressViewModel5.f20928o = 0;
                kotlin.jvm.internal.h.d(CompletableFuture.supplyAsync(new S7.c(customDressViewModel5, 19), ForkJoinPool.commonPool()).exceptionally((Function) new C0738g(i13)), "exceptionally(...)");
            }
        }
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        CustomDressViewModel customDressViewModel6 = this.f20892m0;
        if (customDressViewModel6 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        if (Y.j(abstractC1508aF.c(customDressViewModel6.f20918d, customDressViewModel6.f20917c))) {
            CustomDressViewModel customDressViewModel7 = this.f20892m0;
            if (customDressViewModel7 == null) {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
            C0379m.b(C0379m.g(AbstractC0939b.E().v(customDressViewModel7.f20916b), new D0(9))).e(this, new c(new CustomDressActivity$initData$3(1, this, CustomDressActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
        } else {
            CustomDressViewModel customDressViewModel8 = this.f20892m0;
            if (customDressViewModel8 == null) {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
            C0379m.b(C0379m.g(AbstractC0939b.E().v(customDressViewModel8.f20916b), new androidx.appcompat.widget.a(18))).e(this, new c(new CustomDressActivity$initData$4(1, this, CustomDressActivity.class, "onConnectionStateChange", "onConnectionStateChange(I)V", 0)));
        }
        CustomDressViewModel customDressViewModel9 = this.f20892m0;
        if (customDressViewModel9 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel9.f20914E).e(this, new c(new CustomDressActivity$initData$5(1, this, CustomDressActivity.class, "onPopupSourceStateChanged", "onPopupSourceStateChanged(Ljava/lang/Integer;)V", 0)));
        CustomDressViewModel customDressViewModel10 = this.f20892m0;
        if (customDressViewModel10 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        customDressViewModel10.f20930q.e(this, new c(new CustomDressActivity$initData$6(1, this, CustomDressActivity.class, "onUiModelChanged", "onUiModelChanged(Lcom/oplus/melody/ui/component/detail/dress/custom/UiModel;)V", 0)));
        CustomDressViewModel customDressViewModel11 = this.f20892m0;
        if (customDressViewModel11 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel11.f20931r).e(this, new c(new CustomDressActivity$initData$7(1, this, CustomDressActivity.class, "onSavingChanged", "onSavingChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel12 = this.f20892m0;
        if (customDressViewModel12 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel12.f20932s).e(this, new c(new CustomDressActivity$initData$8(1, this, CustomDressActivity.class, "onMaskChanged", "onMaskChanged(Ljava/lang/String;)V", 0)));
        CustomDressViewModel customDressViewModel13 = this.f20892m0;
        if (customDressViewModel13 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel13.f20934u).e(this, new c(new CustomDressActivity$initData$9(1, this, CustomDressActivity.class, "onBlurProgressChanged", "onBlurProgressChanged(Ljava/lang/Integer;)V", 0)));
        CustomDressViewModel customDressViewModel14 = this.f20892m0;
        if (customDressViewModel14 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel14.f20935v).e(this, new c(new CustomDressActivity$initData$10(1, this, CustomDressActivity.class, "onDressNameChanged", "onDressNameChanged(Ljava/lang/String;)V", 0)));
        CustomDressViewModel customDressViewModel15 = this.f20892m0;
        if (customDressViewModel15 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel15.f20939z).e(this, new c(new CustomDressActivity$initData$11(1, this, CustomDressActivity.class, "onPromptChanged", "onPromptChanged(Ljava/lang/String;)V", 0)));
        CustomDressViewModel customDressViewModel16 = this.f20892m0;
        if (customDressViewModel16 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel16.f20910A).e(this, new c(new CustomDressActivity$initData$12(1, this, CustomDressActivity.class, "onShowPromptChanged", "onShowPromptChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel17 = this.f20892m0;
        if (customDressViewModel17 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel17.f20933t).e(this, new c(new CustomDressActivity$initData$13(1, this, CustomDressActivity.class, "onDarkImgChanged", "onDarkImgChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel18 = this.f20892m0;
        if (customDressViewModel18 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel18.f20938y).e(this, new c(new CustomDressActivity$initData$14(1, this, CustomDressActivity.class, "applyComponentDisplayColorMode", "applyComponentDisplayColorMode(Ljava/lang/Integer;)V", 0)));
        CustomDressViewModel customDressViewModel19 = this.f20892m0;
        if (customDressViewModel19 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel19.f20911B).e(this, new c(new CustomDressActivity$initData$15(1, this, CustomDressActivity.class, "onShowModelChanged", "onShowModelChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel20 = this.f20892m0;
        if (customDressViewModel20 == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        C0379m.b(customDressViewModel20.f20912C).e(this, new c(new CustomDressActivity$initData$16(1, this, CustomDressActivity.class, "onShowBatteryChanged", "onShowBatteryChanged(Ljava/lang/Boolean;)V", 0)));
        CustomDressViewModel customDressViewModel21 = this.f20892m0;
        if (customDressViewModel21 != null) {
            C0379m.b(customDressViewModel21.f20913D).e(this, new c(new CustomDressActivity$initData$17(1, this, CustomDressActivity.class, "onBatteryStyleChanged", "onBatteryStyleChanged(Ljava/lang/Integer;)V", 0)));
        } else {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.melody_ui_custom_dress_menu, menu);
        this.f20897r0 = menu != null ? menu.findItem(R.id.custom_dress_menu_edit) : null;
        CustomDressViewModel customDressViewModel = this.f20892m0;
        if (customDressViewModel == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        c9.n nVarD = customDressViewModel.f20930q.d();
        Boolean boolValueOf = nVarD != null ? Boolean.valueOf(nVarD.f13537b) : null;
        MenuItem menuItem = this.f20897r0;
        boolean z2 = false;
        if (menuItem != null) {
            CustomDressViewModel customDressViewModel2 = this.f20892m0;
            if (customDressViewModel2 == null) {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
            menuItem.setVisible(customDressViewModel2.h >= 2 && !kotlin.jvm.internal.h.a(boolValueOf, Boolean.TRUE));
        }
        MenuItem menuItemFindItem = menu != null ? menu.findItem(R.id.custom_dress_menu_re_upload) : null;
        this.f20898s0 = menuItemFindItem;
        if (menuItemFindItem != null) {
            CustomDressViewModel customDressViewModel3 = this.f20892m0;
            if (customDressViewModel3 == null) {
                kotlin.jvm.internal.h.i("mViewModel");
                throw null;
            }
            if (customDressViewModel3.h >= 2 && kotlin.jvm.internal.h.a(boolValueOf, Boolean.TRUE)) {
                z2 = true;
            }
            menuItemFindItem.setVisible(z2);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        A.c("CustomDressActivity", new S7.c(this, 18));
        CompletableFuture<Uri> completableFuture = this.f20866L0;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        b bVar = this.f20862H0;
        if (bVar != null) {
            o0.c.f1143a.removeCallbacks(bVar);
        }
        MelodyVideoAnimationView melodyVideoAnimationView = this.f20867M0;
        if (melodyVideoAnimationView != null) {
            int currentPosition = melodyVideoAnimationView.getCurrentPosition();
            if (currentPosition > 0) {
                CustomDressViewModel customDressViewModel = this.f20892m0;
                if (customDressViewModel == null) {
                    kotlin.jvm.internal.h.i("mViewModel");
                    throw null;
                }
                customDressViewModel.f20928o = currentPosition;
            }
            A.c("CustomDressActivity", new Ga.a(this, currentPosition, 5));
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.h.e(item, "item");
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R.id.custom_dress_menu_edit) {
            if (itemId != R.id.custom_dress_menu_re_upload) {
                return super.onOptionsItemSelected(item);
            }
            if (t8.s.a(0)) {
                return true;
            }
            this.f20868N0 = true;
            P();
            return true;
        }
        CustomDressViewModel customDressViewModel = this.f20892m0;
        if (customDressViewModel == null) {
            kotlin.jvm.internal.h.i("mViewModel");
            throw null;
        }
        c9.n nVarD = customDressViewModel.f20930q.d();
        String str = nVarD != null ? nVarD.f13536a : "";
        CustomDressViewModel customDressViewModel2 = this.f20892m0;
        if (customDressViewModel2 != null) {
            customDressViewModel2.f20930q.i(new c9.n(str, true));
            return true;
        }
        kotlin.jvm.internal.h.i("mViewModel");
        throw null;
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStart() {
        super.onStart();
        A.b("CustomDressActivity", "onStart");
    }

    @Override // F8.a, androidx.appcompat.app.i, androidx.fragment.app.f, android.app.Activity
    public final void onStop() {
        super.onStop();
        A.b("CustomDressActivity", "onStop");
        Handler handler = this.f20860F0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
