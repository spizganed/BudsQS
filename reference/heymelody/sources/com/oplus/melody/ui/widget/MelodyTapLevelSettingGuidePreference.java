package com.oplus.melody.ui.widget;

import Jb.l;
import O9.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;
import u8.C1554b;
import u8.C1559g;

/* JADX INFO: compiled from: MelodyTapLevelSettingGuidePreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyTapLevelSettingGuidePreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationLayout", "Lcom/oplus/melody/ui/widget/MelodyAnimationLayout;", "defaultImage", "Landroid/widget/ImageView;", "productId", "", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "initDoneCallback", "Lkotlin/Function0;", "", "getInitDoneCallback", "()Lkotlin/jvm/functions/Function0;", "setInitDoneCallback", "(Lkotlin/jvm/functions/Function0;)V", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "showAnimation", "zipConfig", "Lcom/oplus/melody/model/zipdata/ControlSourceDO;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyTapLevelSettingGuidePreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MelodyAnimationLayout f21933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f21934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21935c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public d f21936p;

    public MelodyTapLevelSettingGuidePreference(Context context) {
        this(context, null);
    }

    public final void e(C1554b c1554b) {
        List<MelodyResourceDO> leftLottieRes;
        l lVar;
        if (c1554b != null && (leftLottieRes = c1554b.getLeftLottieRes()) != null) {
            ImageView imageView = this.f21934b;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            C1559g c1559g = new C1559g();
            c1559g.setLottieResList(leftLottieRes);
            MelodyAnimationLayout melodyAnimationLayout = this.f21933a;
            if (melodyAnimationLayout != null) {
                melodyAnimationLayout.b(c1559g, c1554b.getRootPath());
                lVar = l.f2618a;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                return;
            }
        }
        ImageView imageView2 = this.f21934b;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        ImageView imageView;
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.guide_control_device);
        h.c(viewA, "null cannot be cast to non-null type com.oplus.melody.ui.widget.MelodyAnimationLayout");
        this.f21933a = (MelodyAnimationLayout) viewA;
        View viewA2 = holder.a(R.id.default_image);
        h.c(viewA2, "null cannot be cast to non-null type android.widget.ImageView");
        this.f21934b = (ImageView) viewA2;
        String strD = AbstractC1508a.f().d(this.f21935c);
        h.d(strD, "getDeviceType(...)");
        if (Y.i(strD) && (imageView = this.f21934b) != null) {
            imageView.setImageResource(R.drawable.melody_ui_detail_default_img_ows);
        }
        d dVar = this.f21936p;
        if (dVar != null) {
            dVar.invoke();
        }
    }

    public MelodyTapLevelSettingGuidePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MelodyTapLevelSettingGuidePreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setWidgetLayoutResource(R.layout.melody_ui_tap_level_setting_guide_layout);
    }
}
