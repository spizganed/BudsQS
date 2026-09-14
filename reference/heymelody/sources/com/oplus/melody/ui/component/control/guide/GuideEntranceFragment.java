package com.oplus.melody.ui.component.control.guide;

import D7.C0368b;
import D7.C0378l;
import D7.RunnableC0380n;
import D7.o0;
import Ea.W;
import F8.i;
import F9.s;
import I8.B;
import I8.u;
import I8.w;
import Wb.l;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.C0699e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.z;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.coui.appcompat.indicator.COUIPageIndicator;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.control.guide.GuideEntranceFragment;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import com.oplus.melody.ui.widget.MelodyCompatImageView;
import com.oplus.melody.ui.widget.MelodyCompatTextView;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import ka.g;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import p2.C1395b;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: GuideEntranceFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u00012\u00020\u0002:\b23456789B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020#H\u0016J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0016J\b\u0010,\u001a\u00020#H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment;", "Lcom/coui/appcompat/panel/COUIPanelFragment;", "Lcom/oplus/melody/ui/component/control/guide/LoadHeadImageResCallback;", "<init>", "()V", "mGuideViewModel", "Lcom/oplus/melody/ui/component/control/guide/ControlGuideViewModel;", "mContext", "Landroid/content/Context;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mPageIndicator", "Lcom/coui/appcompat/indicator/COUIPageIndicator;", "mViewPagerAdapter", "Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ViewPagerAdapter;", "mCheckListener", "Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$OnCheckListener;", "mAddress", "", "mProductId", "mColorId", "", "Ljava/lang/Integer;", "mProductName", "mFrom", "mGuideEntranceMode", "Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$GuideEntranceMode;", "mCurrentPagePosition", "mHasShowGuideUnavailableToast", "", "mDeviceType", "mIsMultiConnectNeedReboot", "mCloseFragmentRunnable", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "panelView", "Landroid/view/View;", "onDestroy", "updateDataAndSubmit", "loadHeadImageRes", "showGuideUnavailableToast", "onHeadsetResLoaded", "headSetResVO", "Lcom/oplus/melody/ui/component/control/guide/HeadSetResVO;", "setOnCheckListener", "listener", "Companion", "OnCheckListener", "ViewPagerAdapter", "ViewPagerViewType", "GuideEntranceMode", "GalleryData", "TriangleData", "ControlGuideData", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GuideEntranceFragment extends COUIPanelFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f20546a = 0;
    private String mAddress;
    private c mCheckListener;
    private Integer mColorId;
    private Context mContext;
    private String mFrom;
    private ControlGuideViewModel mGuideViewModel;
    private boolean mHasShowGuideUnavailableToast;
    private boolean mIsMultiConnectNeedReboot;
    private COUIPageIndicator mPageIndicator;
    private String mProductId;
    private String mProductName;
    private ViewPager2 mViewPager;
    private e mViewPagerAdapter;
    private GuideEntranceMode mGuideEntranceMode = GuideEntranceMode.f20547a;
    private int mCurrentPagePosition = -1;
    private String mDeviceType = "";
    private Runnable mCloseFragmentRunnable = new Aa.e(this, 9);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$GuideEntranceMode;", "", "<init>", "(Ljava/lang/String;I)V", "INTRO_CONTROL_GUIDE", "INTRO_TRIANGLE_AND_CONTROL_GUIDE", "INTRO_OPEN_MULTI_CONNECT", "TUTORIAL_GUIDE", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class GuideEntranceMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GuideEntranceMode f20547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final GuideEntranceMode f20548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final GuideEntranceMode f20549c;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final GuideEntranceMode f20550p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ GuideEntranceMode[] f20551q;

        static {
            GuideEntranceMode guideEntranceMode = new GuideEntranceMode("INTRO_CONTROL_GUIDE", 0);
            f20547a = guideEntranceMode;
            GuideEntranceMode guideEntranceMode2 = new GuideEntranceMode("INTRO_TRIANGLE_AND_CONTROL_GUIDE", 1);
            f20548b = guideEntranceMode2;
            GuideEntranceMode guideEntranceMode3 = new GuideEntranceMode("INTRO_OPEN_MULTI_CONNECT", 2);
            f20549c = guideEntranceMode3;
            GuideEntranceMode guideEntranceMode4 = new GuideEntranceMode("TUTORIAL_GUIDE", 3);
            f20550p = guideEntranceMode4;
            f20551q = new GuideEntranceMode[]{guideEntranceMode, guideEntranceMode2, guideEntranceMode3, guideEntranceMode4};
        }

        public GuideEntranceMode() {
            throw null;
        }

        public static GuideEntranceMode valueOf(String str) {
            return (GuideEntranceMode) Enum.valueOf(GuideEntranceMode.class, str);
        }

        public static GuideEntranceMode[] values() {
            return (GuideEntranceMode[]) f20551q.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ViewPagerViewType;", "", "<init>", "(Ljava/lang/String;I)V", "INTRO_TRIANGLE", "INTRO_CONTROL_GUIDE", "INTRO_OPEN_MULTI_CONNECT", "TUTORIAL_GUIDE", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewPagerViewType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewPagerViewType[] f20552a = {new ViewPagerViewType("INTRO_TRIANGLE", 0), new ViewPagerViewType("INTRO_CONTROL_GUIDE", 1), new ViewPagerViewType("INTRO_OPEN_MULTI_CONNECT", 2), new ViewPagerViewType("TUTORIAL_GUIDE", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        ViewPagerViewType EF5;

        public ViewPagerViewType() {
            throw null;
        }

        public static ViewPagerViewType valueOf(String str) {
            return (ViewPagerViewType) Enum.valueOf(ViewPagerViewType.class, str);
        }

        public static ViewPagerViewType[] values() {
            return (ViewPagerViewType[]) f20552a.clone();
        }
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010(R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006)"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ControlGuideData;", "Lcom/oplus/melody/common/data/BaseBean;", "address", "", "productId", "colorId", "", "productName", "leftResPath", "rightResPath", "resPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getProductId", "setProductId", "getColorId", "()Ljava/lang/Integer;", "setColorId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getProductName", "setProductName", "getLeftResPath", "setLeftResPath", "getRightResPath", "setRightResPath", "getResPath", "setResPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ControlGuideData;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class a extends com.oplus.melody.common.data.a {
        private String address;
        private Integer colorId;
        private String leftResPath;
        private String productId;
        private String productName;
        private String resPath;
        private String rightResPath;

        public a() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ a copy$default(a aVar, String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = aVar.address;
            }
            if ((i10 & 2) != 0) {
                str2 = aVar.productId;
            }
            if ((i10 & 4) != 0) {
                num = aVar.colorId;
            }
            if ((i10 & 8) != 0) {
                str3 = aVar.productName;
            }
            if ((i10 & 16) != 0) {
                str4 = aVar.leftResPath;
            }
            if ((i10 & 32) != 0) {
                str5 = aVar.rightResPath;
            }
            if ((i10 & 64) != 0) {
                str6 = aVar.resPath;
            }
            String str7 = str5;
            String str8 = str6;
            String str9 = str4;
            Integer num2 = num;
            return aVar.copy(str, str2, num2, str3, str9, str7, str8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getProductId() {
            return this.productId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getColorId() {
            return this.colorId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getProductName() {
            return this.productName;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getLeftResPath() {
            return this.leftResPath;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getRightResPath() {
            return this.rightResPath;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getResPath() {
            return this.resPath;
        }

        public final a copy(String str, String str2, Integer num, String str3, String str4, String str5, String str6) {
            return new a(str, str2, num, str3, str4, str5, str6);
        }

        public final String getAddress() {
            return this.address;
        }

        public final Integer getColorId() {
            return this.colorId;
        }

        public final String getLeftResPath() {
            return this.leftResPath;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final String getProductName() {
            return this.productName;
        }

        public final String getResPath() {
            return this.resPath;
        }

        public final String getRightResPath() {
            return this.rightResPath;
        }

        public final void setAddress(String str) {
            this.address = str;
        }

        public final void setColorId(Integer num) {
            this.colorId = num;
        }

        public final void setLeftResPath(String str) {
            this.leftResPath = str;
        }

        public final void setProductId(String str) {
            this.productId = str;
        }

        public final void setProductName(String str) {
            this.productName = str;
        }

        public final void setResPath(String str) {
            this.resPath = str;
        }

        public final void setRightResPath(String str) {
            this.rightResPath = str;
        }

        public a(String str, String str2, Integer num, String str3, String str4, String str5, String str6) {
            this.address = str;
            this.productId = str2;
            this.colorId = num;
            this.productName = str3;
            this.leftResPath = str4;
            this.rightResPath = str5;
            this.resPath = str6;
        }

        public /* synthetic */ a(String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i10, kotlin.jvm.internal.d dVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6);
        }
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    public interface c {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$TriangleData;", "Lcom/oplus/melody/common/data/BaseBean;", "address", "", "imageResId", "", "title", "summary", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getImageResId", "()Ljava/lang/Integer;", "setImageResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTitle", "setTitle", "getSummary", "setSummary", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$TriangleData;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class d extends com.oplus.melody.common.data.a {
        private String address;
        private Integer imageResId;
        private String summary;
        private String title;

        public d() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ d copy$default(d dVar, String str, Integer num, String str2, String str3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = dVar.address;
            }
            if ((i10 & 2) != 0) {
                num = dVar.imageResId;
            }
            if ((i10 & 4) != 0) {
                str2 = dVar.title;
            }
            if ((i10 & 8) != 0) {
                str3 = dVar.summary;
            }
            return dVar.copy(str, num, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getImageResId() {
            return this.imageResId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        public final d copy(String str, Integer num, String str2, String str3) {
            return new d(str, num, str2, str3);
        }

        public final String getAddress() {
            return this.address;
        }

        public final Integer getImageResId() {
            return this.imageResId;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setAddress(String str) {
            this.address = str;
        }

        public final void setImageResId(Integer num) {
            this.imageResId = num;
        }

        public final void setSummary(String str) {
            this.summary = str;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public d(String str, Integer num, String str2, String str3) {
            this.address = str;
            this.imageResId = num;
            this.title = str2;
            this.summary = str3;
        }

        public /* synthetic */ d(String str, Integer num, String str2, String str3, int i10, kotlin.jvm.internal.d dVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3);
        }
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    public static final class e extends z<b, b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ControlGuideViewModel f20553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f20554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f20555d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f20556e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Jb.b f20557f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public b f20558g;
        public c h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public GuideEntranceFragment f20559i;

        /* JADX INFO: compiled from: GuideEntranceFragment.kt */
        public static final class a extends p.e<b> {
            @Override // androidx.recyclerview.widget.p.e
            public final boolean a(b bVar, b bVar2) {
                b bVar3 = bVar;
                b bVar4 = bVar2;
                int viewType = bVar3.getViewType();
                ViewPagerViewType[] viewPagerViewTypeArr = ViewPagerViewType.f20552a;
                if (viewType == 2 || viewType == 0) {
                    if (bVar3.getViewType() != bVar4.getViewType()) {
                        return false;
                    }
                    d triangleData = bVar3.getTriangleData();
                    Integer imageResId = triangleData != null ? triangleData.getImageResId() : null;
                    d triangleData2 = bVar4.getTriangleData();
                    if (!h.a(imageResId, triangleData2 != null ? triangleData2.getImageResId() : null)) {
                        return false;
                    }
                    d triangleData3 = bVar3.getTriangleData();
                    String title = triangleData3 != null ? triangleData3.getTitle() : null;
                    d triangleData4 = bVar4.getTriangleData();
                    if (!h.a(title, triangleData4 != null ? triangleData4.getTitle() : null)) {
                        return false;
                    }
                    d triangleData5 = bVar3.getTriangleData();
                    String summary = triangleData5 != null ? triangleData5.getSummary() : null;
                    d triangleData6 = bVar4.getTriangleData();
                    if (!h.a(summary, triangleData6 != null ? triangleData6.getSummary() : null)) {
                        return false;
                    }
                } else {
                    if ((viewType != 1 && viewType != 3) || bVar3.getViewType() != bVar4.getViewType()) {
                        return false;
                    }
                    a controlGuideData = bVar3.getControlGuideData();
                    String address = controlGuideData != null ? controlGuideData.getAddress() : null;
                    a controlGuideData2 = bVar4.getControlGuideData();
                    if (!h.a(address, controlGuideData2 != null ? controlGuideData2.getAddress() : null)) {
                        return false;
                    }
                    a controlGuideData3 = bVar3.getControlGuideData();
                    String productId = controlGuideData3 != null ? controlGuideData3.getProductId() : null;
                    a controlGuideData4 = bVar4.getControlGuideData();
                    if (!h.a(productId, controlGuideData4 != null ? controlGuideData4.getProductId() : null)) {
                        return false;
                    }
                    a controlGuideData5 = bVar3.getControlGuideData();
                    Integer colorId = controlGuideData5 != null ? controlGuideData5.getColorId() : null;
                    a controlGuideData6 = bVar4.getControlGuideData();
                    if (!h.a(colorId, controlGuideData6 != null ? controlGuideData6.getColorId() : null)) {
                        return false;
                    }
                    a controlGuideData7 = bVar3.getControlGuideData();
                    String productName = controlGuideData7 != null ? controlGuideData7.getProductName() : null;
                    a controlGuideData8 = bVar4.getControlGuideData();
                    if (!h.a(productName, controlGuideData8 != null ? controlGuideData8.getProductName() : null)) {
                        return false;
                    }
                    a controlGuideData9 = bVar3.getControlGuideData();
                    String rightResPath = controlGuideData9 != null ? controlGuideData9.getRightResPath() : null;
                    a controlGuideData10 = bVar4.getControlGuideData();
                    if (!h.a(rightResPath, controlGuideData10 != null ? controlGuideData10.getRightResPath() : null)) {
                        return false;
                    }
                    a controlGuideData11 = bVar3.getControlGuideData();
                    String leftResPath = controlGuideData11 != null ? controlGuideData11.getLeftResPath() : null;
                    a controlGuideData12 = bVar4.getControlGuideData();
                    if (!h.a(leftResPath, controlGuideData12 != null ? controlGuideData12.getLeftResPath() : null)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // androidx.recyclerview.widget.p.e
            public final boolean b(b bVar, b bVar2) {
                b bVar3 = bVar;
                b bVar4 = bVar2;
                int viewType = bVar3.getViewType();
                ViewPagerViewType[] viewPagerViewTypeArr = ViewPagerViewType.f20552a;
                if (viewType == 2 || viewType == 0) {
                    if (bVar3.getViewType() != bVar4.getViewType()) {
                        return false;
                    }
                    d triangleData = bVar3.getTriangleData();
                    Integer imageResId = triangleData != null ? triangleData.getImageResId() : null;
                    d triangleData2 = bVar4.getTriangleData();
                    if (!h.a(imageResId, triangleData2 != null ? triangleData2.getImageResId() : null)) {
                        return false;
                    }
                    d triangleData3 = bVar3.getTriangleData();
                    String title = triangleData3 != null ? triangleData3.getTitle() : null;
                    d triangleData4 = bVar4.getTriangleData();
                    if (!h.a(title, triangleData4 != null ? triangleData4.getTitle() : null)) {
                        return false;
                    }
                    d triangleData5 = bVar3.getTriangleData();
                    String summary = triangleData5 != null ? triangleData5.getSummary() : null;
                    d triangleData6 = bVar4.getTriangleData();
                    if (!h.a(summary, triangleData6 != null ? triangleData6.getSummary() : null)) {
                        return false;
                    }
                } else {
                    if ((viewType != 1 && viewType != 3) || bVar3.getViewType() != bVar4.getViewType()) {
                        return false;
                    }
                    a controlGuideData = bVar3.getControlGuideData();
                    String address = controlGuideData != null ? controlGuideData.getAddress() : null;
                    a controlGuideData2 = bVar4.getControlGuideData();
                    if (!h.a(address, controlGuideData2 != null ? controlGuideData2.getAddress() : null)) {
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: compiled from: GuideEntranceFragment.kt */
        public final class b extends RecyclerView.E {
            public b(ViewGroup viewGroup) {
                super(viewGroup);
            }

            public final void a(ControlGuideViewModel controlGuideViewModel, View view, Context context, d dVar, boolean z2) {
                if (view == null || context == null || dVar == null) {
                    return;
                }
                TextView textView = (TextView) view.findViewById(R.id.title);
                TextView textView2 = (TextView) view.findViewById(R.id.summary);
                MelodyLottieAnimationView melodyLottieAnimationView = (MelodyLottieAnimationView) view.findViewById(R.id.lottie_view);
                MelodyCompatTextView melodyCompatTextView = (MelodyCompatTextView) view.findViewById(R.id.melody_ui_late_set);
                MelodyCompatButton melodyCompatButton = (MelodyCompatButton) view.findViewById(R.id.melody_ui_open_multi_connect);
                textView.setText(dVar.getTitle());
                textView2.setText(dVar.getSummary());
                Integer imageResId = dVar.getImageResId();
                if (imageResId != null) {
                    melodyLottieAnimationView.setAnimation(imageResId.intValue());
                    melodyLottieAnimationView.playAnimation();
                }
                if (z2) {
                    melodyCompatTextView.setVisibility(0);
                    melodyCompatButton.setVisibility(0);
                    e eVar = e.this;
                    int i10 = 0;
                    melodyCompatTextView.setOnClickListener(new u(eVar, dVar, controlGuideViewModel, i10));
                    melodyCompatButton.setOnClickListener(new w(eVar, dVar, controlGuideViewModel, i10));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ControlGuideViewModel controlGuideViewModel, Context contxt, String deviceType, String str) {
            super(new a());
            h.e(contxt, "contxt");
            h.e(deviceType, "deviceType");
            this.f20553b = controlGuideViewModel;
            this.f20554c = contxt;
            this.f20555d = deviceType;
            this.f20556e = str;
            this.f20557f = kotlin.a.a(new E9.e(this, 2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i10) {
            C0699e<T> c0699e = this.f12264a;
            List<T> list = c0699e.f12028f;
            if (list != 0 && i10 < list.size()) {
                return ((b) c0699e.f12028f.get(i10)).getViewType();
            }
            ViewPagerViewType[] viewPagerViewTypeArr = ViewPagerViewType.f20552a;
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.E e10, int i10) {
            b bVar;
            boolean z2;
            b holder = (b) e10;
            h.e(holder, "holder");
            A.h("GuideEntranceFragment", "onBindViewHolder position = " + i10);
            b bVarC = c(i10);
            h.d(bVarC, "getItem(...)");
            b bVar2 = bVarC;
            final c cVar = this.h;
            final GuideEntranceFragment guideEntranceFragment = this.f20559i;
            final Context context = this.f20554c;
            h.e(context, "context");
            int viewType = bVar2.getViewType();
            ViewPagerViewType[] viewPagerViewTypeArr = ViewPagerViewType.f20552a;
            ControlGuideViewModel controlGuideViewModel = this.f20553b;
            if (viewType == 0) {
                bVar = holder;
                bVar.a(controlGuideViewModel, holder.itemView, context, bVar2.getTriangleData(), false);
            } else {
                bVar = holder;
                if (bVar2.getViewType() == 1 || bVar2.getViewType() == 3) {
                    final int viewType2 = bVar2.getViewType();
                    View view = bVar.itemView;
                    final a controlGuideData = bVar2.getControlGuideData();
                    e eVar = e.this;
                    if (view != null && controlGuideData != null) {
                        if (viewType2 == 3) {
                            ((TextView) view.findViewById(R.id.melody_ui_entrance_title)).setText(R.string.melody_common_control_guide_title);
                            ((TextView) view.findViewById(R.id.melody_ui_entrance_des)).setText(R.string.melody_common_control_guide_entrance_des_new);
                        }
                        View viewFindViewById = view.findViewById(R.id.melody_ui_control_guide_start);
                        h.d(viewFindViewById, "findViewById(...)");
                        MelodyCompatButton melodyCompatButton = (MelodyCompatButton) viewFindViewById;
                        View viewFindViewById2 = view.findViewById(R.id.melody_ui_control_guide_exit);
                        h.d(viewFindViewById2, "findViewById(...)");
                        MelodyCompatTextView melodyCompatTextView = (MelodyCompatTextView) viewFindViewById2;
                        String str = eVar.f20555d;
                        if ("N".equals(str)) {
                            View viewFindViewById3 = view.findViewById(R.id.melody_ui_control_guide_device);
                            h.d(viewFindViewById3, "findViewById(...)");
                            MelodyCompatImageView melodyCompatImageView = (MelodyCompatImageView) viewFindViewById3;
                            if (TextUtils.isEmpty(controlGuideData.getResPath())) {
                                melodyCompatImageView.setImageResource(R.drawable.melody_ui_neck_headset_control_default);
                            } else {
                                h.b(Glide.with(context).load(controlGuideData.getResPath()).into(melodyCompatImageView));
                            }
                        } else {
                            View viewFindViewById4 = view.findViewById(R.id.melody_ui_control_guide_left_device);
                            h.d(viewFindViewById4, "findViewById(...)");
                            MelodyCompatImageView melodyCompatImageView2 = (MelodyCompatImageView) viewFindViewById4;
                            View viewFindViewById5 = view.findViewById(R.id.melody_ui_control_guide_right_device);
                            h.d(viewFindViewById5, "findViewById(...)");
                            MelodyCompatImageView melodyCompatImageView3 = (MelodyCompatImageView) viewFindViewById5;
                            if (!TextUtils.isEmpty(controlGuideData.getLeftResPath())) {
                                h.b(Glide.with(context).load(controlGuideData.getLeftResPath()).into(melodyCompatImageView2));
                            } else if (Y.i(str)) {
                                melodyCompatImageView2.setImageResource(R.drawable.melody_ui_image_ear_left_ows);
                            } else {
                                melodyCompatImageView2.setImageResource(R.drawable.melody_ui_image_ear_left_default);
                            }
                            if (!TextUtils.isEmpty(controlGuideData.getRightResPath())) {
                                h.b(Glide.with(context).load(controlGuideData.getRightResPath()).into(melodyCompatImageView3));
                            } else if (Y.i(str)) {
                                melodyCompatImageView2.setImageResource(R.drawable.melody_ui_image_ear_right_ows);
                            } else {
                                melodyCompatImageView3.setImageResource(R.drawable.melody_ui_image_ear_right_default);
                            }
                        }
                        boolean zIsEmpty = "N".equals(str) ? TextUtils.isEmpty(controlGuideData.getResPath()) : TextUtils.isEmpty(controlGuideData.getRightResPath());
                        Context context2 = eVar.f20554c;
                        if (zIsEmpty) {
                            melodyCompatButton.setDrawableColor(C1395b.a(context2, R.attr.couiBtnDrawableColorDisabled));
                            z2 = false;
                        } else {
                            melodyCompatButton.setDrawableColor(C1395b.a(context2, R.attr.couiColorPrimary));
                            z2 = true;
                        }
                        final String str2 = this.f20556e;
                        final boolean z4 = z2;
                        melodyCompatButton.setOnClickListener(new View.OnClickListener() { // from class: I8.x
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                GuideEntranceFragment.a aVar = controlGuideData;
                                boolean z10 = z4;
                                String str3 = str2;
                                int i11 = viewType2;
                                Context context3 = context;
                                GuideEntranceFragment.c cVar2 = cVar;
                                GuideEntranceFragment guideEntranceFragment2 = guideEntranceFragment;
                                com.oplus.melody.common.util.A.c("GuideEntranceFragment", new z(z10, str3, i11));
                                t8.q.w(aVar.getAddress(), true);
                                if (!z10) {
                                    if (guideEntranceFragment2 != null) {
                                        guideEntranceFragment2.C();
                                    }
                                    if (guideEntranceFragment2 != null) {
                                        guideEntranceFragment2.A();
                                        return;
                                    }
                                    return;
                                }
                                if (kotlin.jvm.internal.h.a(str3, "discover")) {
                                    Intent intent = new Intent();
                                    intent.putExtra("device_mac_info", aVar.getAddress());
                                    intent.putExtra("product_id", aVar.getProductId());
                                    intent.putExtra("device_name", aVar.getProductName());
                                    Integer colorId = aVar.getColorId();
                                    intent.putExtra("product_color", colorId != null ? String.valueOf(colorId.intValue()) : null);
                                    GuideEntranceFragment.ViewPagerViewType[] viewPagerViewTypeArr2 = GuideEntranceFragment.ViewPagerViewType.f20552a;
                                    intent.putExtra("route_value2", i11 == 3);
                                    intent.putExtra("route_value3", true);
                                    intent.putExtra("route_from", str3);
                                    E8.a.w().getClass();
                                    Jb.b<List<Wb.l<String, Class<?>>>> bVar3 = F8.i.f1668g;
                                    F8.i iVarA = i.a.a("/ui/detail");
                                    iVarA.f("route_from", "GuideEntranceFragment");
                                    iVarA.f("device_mac_info", aVar.getAddress());
                                    iVarA.a(1);
                                    iVarA.f("second_navigation", "/ui/control_guide/ear_detect");
                                    iVarA.f1670b.putExtra("second_intent", intent);
                                    HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                                    if (heyMelodyApplication == null) {
                                        kotlin.jvm.internal.h.i("context");
                                        throw null;
                                    }
                                    iVarA.b(heyMelodyApplication);
                                } else {
                                    E8.a.w().getClass();
                                    Jb.b<List<Wb.l<String, Class<?>>>> bVar4 = F8.i.f1668g;
                                    F8.i iVarA2 = i.a.a("/ui/control_guide/ear_detect");
                                    iVarA2.f("device_mac_info", aVar.getAddress());
                                    iVarA2.f("product_id", aVar.getProductId());
                                    iVarA2.f("device_name", aVar.getProductName());
                                    Integer colorId2 = aVar.getColorId();
                                    iVarA2.f("product_color", colorId2 != null ? String.valueOf(colorId2.intValue()) : null);
                                    GuideEntranceFragment.ViewPagerViewType[] viewPagerViewTypeArr3 = GuideEntranceFragment.ViewPagerViewType.f20552a;
                                    iVarA2.f1670b.putExtra("route_value2", i11 == 3);
                                    iVarA2.f1670b.putExtra("route_value3", true);
                                    iVarA2.f("route_from", str3);
                                    iVarA2.a(8);
                                    iVarA2.b(context3);
                                }
                                if (cVar2 != null) {
                                    cVar2.a();
                                }
                            }
                        });
                        melodyCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: I8.y
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                GuideEntranceFragment.c cVar2 = cVar;
                                if (cVar2 != null) {
                                    cVar2.c();
                                }
                                GuideEntranceFragment.a aVar = controlGuideData;
                                t8.q.w(aVar.getAddress(), true);
                                E8.a.S(context, R.string.melody_common_control_guide_exit_toast);
                                C1264t.p(aVar.getProductId(), aVar.getAddress(), 0, -1);
                            }
                        });
                    }
                } else if (bVar2.getViewType() == 2) {
                    bVar.a(controlGuideViewModel, bVar.itemView, context, bVar2.getTriangleData(), true);
                }
            }
            this.f20558g = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.E onCreateViewHolder(ViewGroup parent, int i10) {
            ViewGroup viewGroup;
            h.e(parent, "parent");
            ViewPagerViewType[] viewPagerViewTypeArr = ViewPagerViewType.f20552a;
            Jb.b bVar = this.f20557f;
            if (i10 == 2 || i10 == 0) {
                Object value = bVar.getValue();
                h.d(value, "getValue(...)");
                View viewInflate = ((LayoutInflater) value).inflate(R.layout.melody_ui_triangle_guide_layout, parent, false);
                h.c(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
                viewGroup = (ViewGroup) viewInflate;
            } else if (i10 != 3 && i10 != 1) {
                A.h("GuideEntranceFragment", "onCreateViewHolder viewType is invalid!!");
                viewGroup = null;
            } else if ("N".equals(this.f20555d)) {
                Object value2 = bVar.getValue();
                h.d(value2, "getValue(...)");
                View viewInflate2 = ((LayoutInflater) value2).inflate(R.layout.melody_ui_control_guide_neck_entrance_layout, parent, false);
                h.c(viewInflate2, "null cannot be cast to non-null type android.view.ViewGroup");
                viewGroup = (ViewGroup) viewInflate2;
            } else {
                Object value3 = bVar.getValue();
                h.d(value3, "getValue(...)");
                View viewInflate3 = ((LayoutInflater) value3).inflate(R.layout.melody_ui_control_guide_entrance_layout, parent, false);
                h.c(viewInflate3, "null cannot be cast to non-null type android.view.ViewGroup");
                viewGroup = (ViewGroup) viewInflate3;
            }
            h.b(viewGroup);
            return new b(viewGroup);
        }
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    public static final class f extends ViewPager2.e {
        public f() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void a(int i10) {
            if (GuideEntranceFragment.this.mPageIndicator != null) {
                return;
            }
            h.i("mPageIndicator");
            throw null;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
        @Override // androidx.viewpager2.widget.ViewPager2.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(float r4, int r5, int r6) {
            /*
                r3 = this;
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment r6 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.this
                com.coui.appcompat.indicator.COUIPageIndicator r0 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.v(r6)
                r1 = 0
                if (r0 == 0) goto L8e
                r0.a(r4, r5)
                int r4 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.s(r6)
                if (r5 == r4) goto L6c
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$e r4 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.x(r6)
                if (r4 == 0) goto L6c
                androidx.recyclerview.widget.e<T> r4 = r4.f12264a
                java.util.List<T> r4 = r4.f12028f
                if (r4 == 0) goto L6c
                int r0 = r4.size()
                if (r5 >= r0) goto L6c
                java.lang.Object r0 = r4.get(r5)
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$b r0 = (com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.b) r0
                if (r0 == 0) goto L36
                int r0 = r0.getViewType()
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$ViewPagerViewType[] r2 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.ViewPagerViewType.f20552a
                r2 = 1
                if (r0 != r2) goto L36
                goto L47
            L36:
                java.lang.Object r0 = r4.get(r5)
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$b r0 = (com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.b) r0
                if (r0 == 0) goto L6c
                int r0 = r0.getViewType()
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$ViewPagerViewType[] r2 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.ViewPagerViewType.f20552a
                r2 = 3
                if (r0 != r2) goto L6c
            L47:
                java.lang.Object r4 = r4.get(r5)
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$b r4 = (com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.b) r4
                if (r4 == 0) goto L5a
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$a r4 = r4.getControlGuideData()
                if (r4 == 0) goto L5a
                java.lang.String r4 = r4.getRightResPath()
                goto L5b
            L5a:
                r4 = r1
            L5b:
                if (r4 != 0) goto L6c
                boolean r4 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.u(r6)
                if (r4 != 0) goto L69
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.z(r6)
                r6.C()
            L69:
                r6.A()
            L6c:
                com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.y(r6, r5)
                com.oplus.melody.ui.component.control.guide.ControlGuideViewModel r4 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.t(r6)
                if (r4 == 0) goto L88
                androidx.viewpager2.widget.ViewPager2 r5 = com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.w(r6)
                if (r5 == 0) goto L82
                int r5 = r5.getCurrentItem()
                r4.f20494c = r5
                return
            L82:
                java.lang.String r4 = "mViewPager"
                kotlin.jvm.internal.h.i(r4)
                throw r1
            L88:
                java.lang.String r4 = "mGuideViewModel"
                kotlin.jvm.internal.h.i(r4)
                throw r1
            L8e:
                java.lang.String r4 = "mPageIndicator"
                kotlin.jvm.internal.h.i(r4)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.control.guide.GuideEntranceFragment.f.b(float, int, int):void");
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void c(int i10) {
            COUIPageIndicator cOUIPageIndicator = GuideEntranceFragment.this.mPageIndicator;
            if (cOUIPageIndicator != null) {
                cOUIPageIndicator.f14199b.f14241x = i10;
            } else {
                h.i("mPageIndicator");
                throw null;
            }
        }
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    public static final class g implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f20562a;

        public g(l lVar) {
            this.f20562a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20562a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20562a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.guide.GuideEntranceFragment$onCreate$4, reason: invalid class name */
    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements l<B, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(B b4) {
            B p02 = b4;
            h.e(p02, "p0");
            GuideEntranceFragment guideEntranceFragment = (GuideEntranceFragment) this.receiver;
            int i10 = GuideEntranceFragment.f20546a;
            guideEntranceFragment.getClass();
            if (!TextUtils.isEmpty(p02.getMRightEarResPath())) {
                guideEntranceFragment.D();
            }
            return Jb.l.f2618a;
        }
    }

    public static void o(GuideEntranceFragment guideEntranceFragment, int i10) {
        ViewPager2 viewPager2 = guideEntranceFragment.mViewPager;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i10);
        } else {
            h.i("mViewPager");
            throw null;
        }
    }

    public static void p(GuideEntranceFragment guideEntranceFragment, int i10) {
        List<T> list;
        guideEntranceFragment.D();
        e eVar = guideEntranceFragment.mViewPagerAdapter;
        if (eVar == null || (list = eVar.f12264a.f12028f) == 0 || i10 < 0 || i10 >= list.size()) {
            return;
        }
        ViewPager2 viewPager2 = guideEntranceFragment.mViewPager;
        if (viewPager2 != null) {
            viewPager2.d(i10, false);
        } else {
            h.i("mViewPager");
            throw null;
        }
    }

    public static void q(GuideEntranceFragment guideEntranceFragment) {
        c cVar = guideEntranceFragment.mCheckListener;
        if (cVar != null) {
            cVar.b();
        }
    }

    public static void r(GuideEntranceFragment guideEntranceFragment) {
        String str = guideEntranceFragment.mAddress;
        if (str != null) {
            String str2 = guideEntranceFragment.mProductId;
            if (guideEntranceFragment.mGuideViewModel == null) {
                h.i("mGuideViewModel");
                throw null;
            }
            C1264t.t(AppConstant$FunctionType.AUTO_SWITCH_LINK_OPEN_MULTI_GUIDE.getFunType(), str2, str, N.t(AbstractC0939b.E().w(str)), VersionInfo.VENDOR_CODE_DEFAULT_VERSION);
        }
    }

    public final void A() {
        A.b("GuideEntranceFragment", "loadHeadImageRes");
        ControlGuideViewModel controlGuideViewModel = this.mGuideViewModel;
        if (controlGuideViewModel == null) {
            h.i("mGuideViewModel");
            throw null;
        }
        String str = this.mProductId;
        h.b(str);
        Integer num = this.mColorId;
        String strValueOf = num != null ? String.valueOf(num.intValue()) : null;
        h.b(strValueOf);
        String deviceType = this.mDeviceType;
        h.e(deviceType, "deviceType");
        Z7.a.g().e(Integer.parseInt(strValueOf), str).thenAcceptAsync((Consumer) new C0368b(new C0378l(1, deviceType, controlGuideViewModel), 5)).whenComplete((BiConsumer<? super Void, ? super Throwable>) new B9.b(new B9.a(controlGuideViewModel, 2), 5));
    }

    public final void B(g.b bVar) {
        this.mCheckListener = bVar;
    }

    public final void C() {
        if (getContext() == null) {
            return;
        }
        GuideEntranceMode guideEntranceMode = this.mGuideEntranceMode;
        if (guideEntranceMode == GuideEntranceMode.f20548b) {
            A.b("GuideEntranceFragment", "showGuideUnavailableToast");
            E8.a.S(getContext(), R.string.melody_common_guide_control_no_res);
        } else if (guideEntranceMode == GuideEntranceMode.f20550p) {
            A.b("GuideEntranceFragment", "showGuideUnavailableToast");
            E8.a.S(getContext(), R.string.melody_common_tutorial_guide_network_error);
        }
    }

    public final void D() {
        int i10;
        ArrayList arrayList = new ArrayList();
        GuideEntranceMode guideEntranceMode = this.mGuideEntranceMode;
        GuideEntranceMode guideEntranceMode2 = GuideEntranceMode.f20548b;
        Integer numValueOf = Integer.valueOf(R.raw.melody_ui_bind_account_auto_switch);
        if (guideEntranceMode == guideEntranceMode2) {
            ViewPagerViewType[] viewPagerViewTypeArr = ViewPagerViewType.f20552a;
            d dVar = new d(null, null, null, null, 15, null);
            dVar.setAddress(this.mAddress);
            dVar.setImageResId(Integer.valueOf(R.raw.melody_ui_bind_account_inductive_connection));
            Context context = getContext();
            dVar.setTitle(context != null ? context.getString(R.string.melody_common_bind_account_inductive_connection_title) : null);
            Context context2 = getContext();
            dVar.setSummary(context2 != null ? context2.getString(R.string.melody_common_bind_account_inductive_connection_summary) : null);
            Jb.l lVar = Jb.l.f2618a;
            arrayList.add(new b(0, dVar, null));
            d dVar2 = new d(null, null, null, null, 15, null);
            dVar2.setAddress(this.mAddress);
            dVar2.setImageResId(numValueOf);
            Context context3 = getContext();
            dVar2.setTitle(context3 != null ? context3.getString(R.string.melody_common_bind_account_auto_switch_title) : null);
            Context context4 = getContext();
            dVar2.setSummary(context4 != null ? context4.getString(R.string.melody_common_bind_account_auto_switch_summary_v2) : null);
            arrayList.add(new b(0, dVar2, null));
        }
        GuideEntranceMode guideEntranceMode3 = this.mGuideEntranceMode;
        GuideEntranceMode guideEntranceMode4 = GuideEntranceMode.f20547a;
        if (guideEntranceMode3 == guideEntranceMode4 || guideEntranceMode3 == GuideEntranceMode.f20550p || guideEntranceMode3 == guideEntranceMode2) {
            ViewPagerViewType[] viewPagerViewTypeArr2 = ViewPagerViewType.f20552a;
            if (guideEntranceMode3 == GuideEntranceMode.f20550p) {
                ViewPagerViewType[] viewPagerViewTypeArr3 = ViewPagerViewType.f20552a;
                i10 = 3;
            } else {
                i10 = 1;
            }
            a aVar = new a(null, null, null, null, null, null, null, 127, null);
            aVar.setAddress(this.mAddress);
            aVar.setProductId(this.mProductId);
            aVar.setColorId(this.mColorId);
            aVar.setProductName(this.mProductName);
            ControlGuideViewModel controlGuideViewModel = this.mGuideViewModel;
            if (controlGuideViewModel == null) {
                h.i("mGuideViewModel");
                throw null;
            }
            O7.l<B> lVar2 = controlGuideViewModel.f20497f;
            B bD = lVar2 != null ? lVar2.d() : null;
            if (bD != null) {
                aVar.setLeftResPath(bD.getMLeftEarResPath());
                aVar.setRightResPath(bD.getMRightEarResPath());
                aVar.setResPath(bD.getMEarResPath());
            }
            Jb.l lVar3 = Jb.l.f2618a;
            arrayList.add(new b(i10, null, aVar));
        }
        GuideEntranceMode guideEntranceMode5 = this.mGuideEntranceMode;
        GuideEntranceMode guideEntranceMode6 = GuideEntranceMode.f20549c;
        if (guideEntranceMode5 == guideEntranceMode6) {
            ViewPagerViewType[] viewPagerViewTypeArr4 = ViewPagerViewType.f20552a;
            d dVar3 = new d(null, null, null, null, 15, null);
            dVar3.setAddress(this.mAddress);
            dVar3.setImageResId(numValueOf);
            Context context5 = getContext();
            dVar3.setTitle(context5 != null ? context5.getString(R.string.melody_common_bind_account_auto_switch_title) : null);
            if (this.mIsMultiConnectNeedReboot) {
                Context context6 = getContext();
                dVar3.setSummary(context6 != null ? context6.getString(R.string.melody_common_open_auto_switch_tip_need_reboot) : null);
            } else {
                Context context7 = getContext();
                dVar3.setSummary(context7 != null ? context7.getString(R.string.melody_common_open_auto_switch_tip) : null);
            }
            Jb.l lVar4 = Jb.l.f2618a;
            arrayList.add(new b(2, dVar3, null));
        }
        GuideEntranceMode guideEntranceMode7 = this.mGuideEntranceMode;
        if (guideEntranceMode7 == guideEntranceMode4 || guideEntranceMode7 == GuideEntranceMode.f20550p || guideEntranceMode7 == guideEntranceMode6) {
            COUIPageIndicator cOUIPageIndicator = this.mPageIndicator;
            if (cOUIPageIndicator == null) {
                h.i("mPageIndicator");
                throw null;
            }
            cOUIPageIndicator.setDotsCount(0);
        } else {
            COUIPageIndicator cOUIPageIndicator2 = this.mPageIndicator;
            if (cOUIPageIndicator2 == null) {
                h.i("mPageIndicator");
                throw null;
            }
            cOUIPageIndicator2.setDotsCount(arrayList.size());
        }
        e eVar = this.mViewPagerAdapter;
        if (eVar != null) {
            eVar.d(arrayList);
        }
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public final void initView(View panelView) {
        A.b("GuideEntranceFragment", "initView:");
        super.initView(panelView);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.melody_ui_intro_of_triangle_and_control_guide, (ViewGroup) null, false);
        h.d(viewInflate, "inflate(...)");
        View viewFindViewById = viewInflate.findViewById(R.id.view_pager);
        h.d(viewFindViewById, "findViewById(...)");
        this.mViewPager = (ViewPager2) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.page_indicator);
        h.d(viewFindViewById2, "findViewById(...)");
        this.mPageIndicator = (COUIPageIndicator) viewFindViewById2;
        ControlGuideViewModel controlGuideViewModel = this.mGuideViewModel;
        if (controlGuideViewModel == null) {
            h.i("mGuideViewModel");
            throw null;
        }
        Context context = this.mContext;
        if (context == null) {
            h.i("mContext");
            throw null;
        }
        e eVar = new e(controlGuideViewModel, context, this.mDeviceType, this.mFrom);
        this.mViewPagerAdapter = eVar;
        eVar.h = this.mCheckListener;
        eVar.f20559i = this;
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager2.setAdapter(eVar);
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 == null) {
            h.i("mViewPager");
            throw null;
        }
        viewPager22.a(new f());
        COUIPageIndicator cOUIPageIndicator = this.mPageIndicator;
        if (cOUIPageIndicator == null) {
            h.i("mPageIndicator");
            throw null;
        }
        cOUIPageIndicator.setOnDotClickListener(new s(this, 5));
        View contentView = getContentView();
        h.c(contentView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) contentView).addView(viewInflate);
        getDragView().setVisibility(4);
        A();
        ControlGuideViewModel controlGuideViewModel2 = this.mGuideViewModel;
        if (controlGuideViewModel2 == null) {
            h.i("mGuideViewModel");
            throw null;
        }
        o0.c.f1143a.postDelayed(new W(this, controlGuideViewModel2.f20494c, 1), 50L);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        String string;
        String str;
        super.onCreate(savedInstanceState);
        A.b("GuideEntranceFragment", "onCreate:");
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        this.mContext = fVarRequireActivity;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mAddress = arguments.getString("device_mac_info");
            this.mProductId = arguments.getString("product_id");
            this.mProductName = arguments.getString("device_name");
            this.mColorId = Integer.valueOf(arguments.getInt("product_color"));
            this.mFrom = arguments.getString("route_from");
            string = arguments.getString("route_value");
            this.mIsMultiConnectNeedReboot = arguments.getBoolean("route_value2", false);
        } else {
            string = null;
        }
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.mProductId, this.mProductName);
        if (whitelistConfigDTOC != null) {
            this.mDeviceType = whitelistConfigDTOC.getType();
        }
        if (string != null) {
            GuideEntranceMode guideEntranceModeValueOf = GuideEntranceMode.valueOf(string);
            this.mGuideEntranceMode = guideEntranceModeValueOf;
            if (guideEntranceModeValueOf == GuideEntranceMode.f20550p && (str = this.mProductId) != null && str.length() != 0 && this.mColorId != null) {
                Z7.a aVarG = Z7.a.g();
                String str2 = this.mProductId;
                Integer num = this.mColorId;
                h.b(num);
                aVarG.d(num.intValue(), 10, str2);
            }
        }
        androidx.fragment.app.f fVarRequireActivity2 = requireActivity();
        h.d(fVarRequireActivity2, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity2.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity2.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity2.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(ControlGuideViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        ControlGuideViewModel controlGuideViewModel = (ControlGuideViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.mGuideViewModel = controlGuideViewModel;
        controlGuideViewModel.f20499i = this.mProductId;
        controlGuideViewModel.f20497f.e(this, new g(new AnonymousClass4(1, this, GuideEntranceFragment.class, "onHeadsetResLoaded", "onHeadsetResLoaded(Lcom/oplus/melody/ui/component/control/guide/HeadSetResVO;)V", 0)));
        if (this.mGuideEntranceMode == GuideEntranceMode.f20549c) {
            o0.c.f1143a.postDelayed(this.mCloseFragmentRunnable, 60000L);
            ForkJoinPool.commonPool().execute(new RunnableC0380n(this, 10));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        View view;
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 29) {
            Handler handler = o0.c.f1143a;
            if (handler.hasCallbacks(this.mCloseFragmentRunnable)) {
                handler.removeCallbacks(this.mCloseFragmentRunnable);
            }
        }
        e eVar = this.mViewPagerAdapter;
        if (eVar != null) {
            eVar.h = null;
            eVar.f20559i = null;
            e.b bVar = eVar.f20558g;
            if (bVar != null && (view = bVar.itemView) != null) {
                MelodyCompatButton melodyCompatButton = (MelodyCompatButton) view.findViewById(R.id.melody_ui_control_guide_start);
                if (melodyCompatButton != null) {
                    melodyCompatButton.setOnClickListener(null);
                }
                MelodyCompatTextView melodyCompatTextView = (MelodyCompatTextView) view.findViewById(R.id.melody_ui_control_guide_exit);
                if (melodyCompatTextView != null) {
                    melodyCompatTextView.setOnClickListener(null);
                }
                MelodyCompatTextView melodyCompatTextView2 = (MelodyCompatTextView) view.findViewById(R.id.melody_ui_late_set);
                if (melodyCompatTextView2 != null) {
                    melodyCompatTextView2.setOnClickListener(null);
                }
                MelodyCompatButton melodyCompatButton2 = (MelodyCompatButton) view.findViewById(R.id.melody_ui_open_multi_connect);
                if (melodyCompatButton2 != null) {
                    melodyCompatButton2.setOnClickListener(null);
                }
            }
        }
        ViewPager2 viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            viewPager2.setAdapter(null);
        } else {
            h.i("mViewPager");
            throw null;
        }
    }

    /* JADX INFO: compiled from: GuideEntranceFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$GalleryData;", "Lcom/oplus/melody/common/data/BaseBean;", "viewType", "", "triangleData", "Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$TriangleData;", "controlGuideData", "Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ControlGuideData;", "<init>", "(ILcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$TriangleData;Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ControlGuideData;)V", "getViewType", "()I", "setViewType", "(I)V", "getTriangleData", "()Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$TriangleData;", "setTriangleData", "(Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$TriangleData;)V", "getControlGuideData", "()Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ControlGuideData;", "setControlGuideData", "(Lcom/oplus/melody/ui/component/control/guide/GuideEntranceFragment$ControlGuideData;)V", "component1", "component2", "component3", "copy", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class b extends com.oplus.melody.common.data.a {
        private a controlGuideData;
        private d triangleData;
        private int viewType;

        public b(int i10, d dVar, a aVar) {
            this.viewType = i10;
            this.triangleData = dVar;
            this.controlGuideData = aVar;
        }

        public static /* synthetic */ b copy$default(b bVar, int i10, d dVar, a aVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = bVar.viewType;
            }
            if ((i11 & 2) != 0) {
                dVar = bVar.triangleData;
            }
            if ((i11 & 4) != 0) {
                aVar = bVar.controlGuideData;
            }
            return bVar.copy(i10, dVar, aVar);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getViewType() {
            return this.viewType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final d getTriangleData() {
            return this.triangleData;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final a getControlGuideData() {
            return this.controlGuideData;
        }

        public final b copy(int i10, d dVar, a aVar) {
            return new b(i10, dVar, aVar);
        }

        public final a getControlGuideData() {
            return this.controlGuideData;
        }

        public final d getTriangleData() {
            return this.triangleData;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setControlGuideData(a aVar) {
            this.controlGuideData = aVar;
        }

        public final void setTriangleData(d dVar) {
            this.triangleData = dVar;
        }

        public final void setViewType(int i10) {
            this.viewType = i10;
        }

        public /* synthetic */ b(int i10, d dVar, a aVar, int i11, kotlin.jvm.internal.d dVar2) {
            this(i10, (i11 & 2) != 0 ? null : dVar, (i11 & 4) != 0 ? null : aVar);
        }
    }
}
