package com.oplus.melody.ui.component.tutorialguide;

import D7.o0;
import E9.e;
import Ea.E;
import Jb.b;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.btsdk.protocol.commands.n;
import com.oplus.melody.btsdk.protocol.commands.r;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.B;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.J;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import q9.m;

/* JADX INFO: compiled from: AuditionPreviewView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0010J\u000e\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u000eJ\u0010\u00102\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u00010\u001dJ\u000e\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u0012J\u000e\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\u0016J\u000e\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u0016J\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u0012J\u0006\u0010<\u001a\u00020)J\u0006\u0010=\u001a\u00020)R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u0006?"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/AuditionPreviewView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAudioPreviewLottie", "Lcom/oplus/melody/ui/widget/MelodyLottieAnimationView;", "mAudioPreviewTv", "Landroid/widget/TextView;", "mAudioFile", "Ljava/io/File;", "mFragment", "Landroidx/fragment/app/Fragment;", "mConnectState", "", "mColorProperty", "Lcom/airbnb/lottie/model/KeyPath;", "mIsDisableByLeaMode", "", "mInLeaModeTipStrResId", "mInLeaDialog", "Landroidx/appcompat/app/AlertDialog;", "mInLeaDialogBuilder", "Lcom/oplus/melody/common/widget/MelodyAlertDialogBuilder;", "mAddress", "", "mAutoPlay", "mHasAutoPlay", "mViewInitTime", "", "mAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "getMAudioFocusChangeListener", "()Landroid/media/AudioManager$OnAudioFocusChangeListener;", "mAudioFocusChangeListener$delegate", "Lkotlin/Lazy;", "updatePreviewView", "", "playPreviewAudio", "showInLeaDialog", "setAddress", "address", "setFragment", "fragment", "setAudioFile", "file", "setAudioName", "name", "setConnectState", "connectState", "setAutoPlay", "autoPlay", "setIsDisableByLeaMode", "isDisableByLeaMode", "setInLeaModeTipStrResId", "resId", "stop", "onDestroy", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AuditionPreviewView extends LinearLayout {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final /* synthetic */ int f21644B = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final b f21645A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MelodyLottieAnimationView f21646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f21647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f21648c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Fragment f21649p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21650q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final KeyPath f21651r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21652s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21653t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f21654u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public G7.b f21655v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f21656w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f21657x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f21658y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f21659z;

    /* JADX INFO: compiled from: AuditionPreviewView.kt */
    public static final class a implements SimpleLottieValueCallback<Integer> {
        public a() {
        }

        @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
        public final Integer getValue(LottieFrameInfo<Integer> frameInfo) {
            h.e(frameInfo, "frameInfo");
            return Integer.valueOf(P1.a.b(AuditionPreviewView.this.getContext(), R.attr.couiColorPrimary, 0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuditionPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f21651r = new KeyPath("**");
        this.f21645A = kotlin.a.a(new e(this, 14));
        View.inflate(getContext(), R.layout.melody_ui_tutorial_guide_audio_preview, this);
        View viewFindViewById = findViewById(R.id.lottie_music_preview);
        h.d(viewFindViewById, "findViewById(...)");
        MelodyLottieAnimationView melodyLottieAnimationView = (MelodyLottieAnimationView) viewFindViewById;
        this.f21646a = melodyLottieAnimationView;
        View viewFindViewById2 = findViewById(R.id.tv_music_preview);
        h.d(viewFindViewById2, "findViewById(...)");
        this.f21647b = (TextView) viewFindViewById2;
        setSelected(false);
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        melodyLottieAnimationView.setImageDrawable(d.m(heyMelodyApplication, R.drawable.melody_ui_tutorial_guide_play_icon));
        setOnClickListener(new E(this, 18));
        this.f21659z = System.currentTimeMillis();
    }

    private final AudioManager.OnAudioFocusChangeListener getMAudioFocusChangeListener() {
        return (AudioManager.OnAudioFocusChangeListener) this.f21645A.getValue();
    }

    public final void a() {
        try {
            A.c("AuditionPreviewView", new r(11));
            J.a.f19444a.e();
        } catch (Exception e10) {
            A.i("AuditionPreviewView", "onStop, stop MediaPlayer, error: ", e10);
        }
        B.a.f19427a.a(getMAudioFocusChangeListener(), "AuditionPreviewView");
        setSelected(false);
        b();
    }

    public final void b() {
        if (isSelected()) {
            this.f21658y = true;
            B.a.f19427a.b(getMAudioFocusChangeListener(), "AuditionPreviewView");
            o0.c.f1145c.execute(new m(this, 1));
            this.f21646a.setImageDrawable(null);
            this.f21646a.setAnimation(R.raw.melody_ui_spatial_audio_preview_anim);
            this.f21646a.addValueCallback(this.f21651r, LottieProperty.COLOR, new a());
            this.f21646a.playAnimation();
            return;
        }
        try {
            A.c("AuditionPreviewView", new n(8));
            J.a.f19444a.e();
        } catch (Exception e10) {
            A.i("AuditionPreviewView", "updatePreviewView, stop MediaPlayer, error: ", e10);
        }
        B.a.f19427a.a(getMAudioFocusChangeListener(), "AuditionPreviewView");
        MelodyLottieAnimationView melodyLottieAnimationView = this.f21646a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            h.i("context");
            throw null;
        }
        melodyLottieAnimationView.setImageDrawable(d.m(heyMelodyApplication, R.drawable.melody_ui_tutorial_guide_play_icon));
        this.f21646a.clearValueCallback(this.f21651r, LottieProperty.COLOR);
    }

    public final void setAddress(String address) {
        this.f21656w = address;
    }

    public final void setAudioFile(File file) {
        h.e(file, "file");
        this.f21648c = file;
    }

    public final void setAudioName(String name) {
        this.f21647b.setText(name);
    }

    public final void setAutoPlay(boolean autoPlay) {
        this.f21657x = autoPlay;
    }

    public final void setConnectState(int connectState) {
        this.f21650q = connectState;
        if (connectState != 2) {
            setSelected(false);
            b();
        } else {
            if (!this.f21657x || this.f21658y || isSelected() || System.currentTimeMillis() - this.f21659z >= 300) {
                return;
            }
            setSelected(true);
            b();
        }
    }

    public final void setFragment(Fragment fragment) {
        h.e(fragment, "fragment");
        this.f21649p = fragment;
    }

    public final void setInLeaModeTipStrResId(int resId) {
        this.f21653t = resId;
    }

    public final void setIsDisableByLeaMode(boolean isDisableByLeaMode) {
        this.f21652s = isDisableByLeaMode;
    }
}
