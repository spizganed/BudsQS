package com.oplus.melody.ui.component.control.guide;

import A6.e;
import D7.C0379m;
import D7.RunnableC0380n;
import D7.o0;
import E9.t;
import Ea.E;
import I8.p;
import Wb.l;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.v;
import c.s;
import c.u;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import g9.o;
import h1.C1084c;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;
import u8.C1554b;

/* JADX INFO: compiled from: GuideEarDetectFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0002J\u0012\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020&H\u0002J\b\u00100\u001a\u00020&H\u0002J\u0018\u00101\u001a\u00020&2\u0006\u00102\u001a\u0002032\u0006\u0010\u001f\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u000207H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/oplus/melody/ui/component/control/guide/GuideEarDetectFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mEarDetectViewModel", "Lcom/oplus/melody/ui/component/control/guide/EarDetectViewModel;", "mImageView", "Landroid/widget/ImageView;", "mLeftImageView", "mRightImageView", "mLeftImageViewTag", "mRightImageViewTag", "mContinueBtn", "Lcom/oplus/melody/ui/widget/MelodyCompatButton;", "mTipTextView", "Landroid/view/View;", "mSetCommandFuture", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/repository/earphone/SetCommandStateDTO;", "mAddress", "", "mDeviceName", "mProductId", "mColorId", "mFrom", "mIsTutorialGuide", "", "mIsFromGuideEntranceFragment", "isEnterGuide", "mDeviceType", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showDefaultImage", "onEarResourceChanged", "controlSourceDO", "Lcom/oplus/melody/model/zipdata/ControlSourceDO;", "onEarStatusChanged", "earDetectVO", "Lcom/oplus/melody/ui/component/control/guide/EarDetectVO;", "prepareEnterGuideControl", "enterGuideMode", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GuideEarDetectFragment extends Fragment {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f20515A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f20516B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f20517C = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EarDetectViewModel f20518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f20519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f20520c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f20521p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f20522q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f20523r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MelodyCompatButton f20524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f20525t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CompletableFuture<SetCommandStateDTO> f20526u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f20527v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f20528w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f20529x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f20530y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f20531z;

    /* JADX INFO: compiled from: GuideEarDetectFragment.kt */
    public static final class a extends s {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ GuideEarDetectFragment f20532d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z2, GuideEarDetectFragment guideEarDetectFragment) {
            super(z2);
            this.f20532d = guideEarDetectFragment;
        }

        @Override // c.s
        public final void b() {
            o0.b.a aVar = o0.b.f1142a;
            GuideEarDetectFragment guideEarDetectFragment = this.f20532d;
            aVar.schedule(new t(guideEarDetectFragment, 8), 500L, TimeUnit.MILLISECONDS);
            f activity = guideEarDetectFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: compiled from: GuideEarDetectFragment.kt */
    public static final class b implements v, kotlin.jvm.internal.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FunctionReferenceImpl f20533a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(l lVar) {
            this.f20533a = (FunctionReferenceImpl) lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof kotlin.jvm.internal.f)) {
                return h.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f20533a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [Wb.l, kotlin.jvm.internal.FunctionReferenceImpl] */
        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f20533a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.guide.GuideEarDetectFragment$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: GuideEarDetectFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements l<C1554b, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(C1554b c1554b) {
            C1554b c1554b2 = c1554b;
            GuideEarDetectFragment guideEarDetectFragment = (GuideEarDetectFragment) this.receiver;
            if (c1554b2 == null) {
                guideEarDetectFragment.getClass();
            } else if ("N".equals(guideEarDetectFragment.f20517C)) {
                RequestBuilder<Drawable> requestBuilderLoad = Glide.with(guideEarDetectFragment).load(d.n(guideEarDetectFragment.getActivity(), c1554b2.getDetailImageRes(), c1554b2.getRootPath()));
                ImageView imageView = guideEarDetectFragment.f20519b;
                if (imageView == null) {
                    h.i("mImageView");
                    throw null;
                }
                requestBuilderLoad.into(imageView);
            } else {
                RequestBuilder<Drawable> requestBuilderLoad2 = Glide.with(guideEarDetectFragment).load(d.n(guideEarDetectFragment.getActivity(), c1554b2.getLeftImageRes(), c1554b2.getRootPath()));
                ImageView imageView2 = guideEarDetectFragment.f20520c;
                if (imageView2 == null) {
                    h.i("mLeftImageView");
                    throw null;
                }
                requestBuilderLoad2.into(imageView2);
                RequestBuilder<Drawable> requestBuilderLoad3 = Glide.with(guideEarDetectFragment).load(d.n(guideEarDetectFragment.getActivity(), c1554b2.getRightImageRes(), c1554b2.getRootPath()));
                ImageView imageView3 = guideEarDetectFragment.f20521p;
                if (imageView3 == null) {
                    h.i("mRightImageView");
                    throw null;
                }
                requestBuilderLoad3.into(imageView3);
            }
            return Jb.l.f2618a;
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.control.guide.GuideEarDetectFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: GuideEarDetectFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements l<p, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(p pVar) {
            p p02 = pVar;
            h.e(p02, "p0");
            GuideEarDetectFragment guideEarDetectFragment = (GuideEarDetectFragment) this.receiver;
            if (!"N".equals(guideEarDetectFragment.f20517C)) {
                ImageView imageView = guideEarDetectFragment.f20520c;
                if (imageView == null) {
                    h.i("mLeftImageView");
                    throw null;
                }
                imageView.setAlpha(!p02.getMLeftEarWeared() ? 0.3f : 1.0f);
                ImageView imageView2 = guideEarDetectFragment.f20521p;
                if (imageView2 == null) {
                    h.i("mRightImageView");
                    throw null;
                }
                imageView2.setAlpha(p02.getMRightEarWeared() ? 1.0f : 0.3f);
                if (p02.getMLeftEarWeared()) {
                    ImageView imageView3 = guideEarDetectFragment.f20522q;
                    if (imageView3 == null) {
                        h.i("mLeftImageViewTag");
                        throw null;
                    }
                    imageView3.setImageResource(R.drawable.melody_ui_control_guide_left_device_tag_detected);
                    ImageView imageView4 = guideEarDetectFragment.f20522q;
                    if (imageView4 == null) {
                        h.i("mLeftImageViewTag");
                        throw null;
                    }
                    imageView4.setBackgroundResource(R.drawable.melody_ui_control_guide_left_device_tag_detected_bg);
                    ImageView imageView5 = guideEarDetectFragment.f20522q;
                    if (imageView5 == null) {
                        h.i("mLeftImageViewTag");
                        throw null;
                    }
                    imageView5.setBackgroundTintList(ColorStateList.valueOf(o.g(guideEarDetectFragment.getActivity(), R.attr.couiColorPrimary)));
                } else {
                    ImageView imageView6 = guideEarDetectFragment.f20522q;
                    if (imageView6 == null) {
                        h.i("mLeftImageViewTag");
                        throw null;
                    }
                    imageView6.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_normal);
                    ImageView imageView7 = guideEarDetectFragment.f20522q;
                    if (imageView7 == null) {
                        h.i("mLeftImageViewTag");
                        throw null;
                    }
                    imageView7.setBackground(null);
                }
                if (p02.getMRightEarWeared()) {
                    ImageView imageView8 = guideEarDetectFragment.f20523r;
                    if (imageView8 == null) {
                        h.i("mRightImageViewTag");
                        throw null;
                    }
                    imageView8.setImageResource(R.drawable.melody_ui_control_guide_right_device_tag_detected);
                    ImageView imageView9 = guideEarDetectFragment.f20523r;
                    if (imageView9 == null) {
                        h.i("mRightImageViewTag");
                        throw null;
                    }
                    imageView9.setBackgroundResource(R.drawable.melody_ui_control_guide_right_device_tag_detected_bg);
                    ImageView imageView10 = guideEarDetectFragment.f20523r;
                    if (imageView10 == null) {
                        h.i("mRightImageViewTag");
                        throw null;
                    }
                    imageView10.setBackgroundTintList(ColorStateList.valueOf(o.g(guideEarDetectFragment.getActivity(), R.attr.couiColorPrimary)));
                } else {
                    ImageView imageView11 = guideEarDetectFragment.f20523r;
                    if (imageView11 == null) {
                        h.i("mRightImageViewTag");
                        throw null;
                    }
                    imageView11.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_normal);
                    ImageView imageView12 = guideEarDetectFragment.f20523r;
                    if (imageView12 == null) {
                        h.i("mRightImageViewTag");
                        throw null;
                    }
                    imageView12.setBackground(null);
                }
            }
            boolean z2 = p02.getMLeftEarWeared() || p02.getMRightEarWeared();
            MelodyCompatButton melodyCompatButton = guideEarDetectFragment.f20524s;
            if (melodyCompatButton == null) {
                h.i("mContinueBtn");
                throw null;
            }
            melodyCompatButton.setEnabled(z2);
            View view = guideEarDetectFragment.f20525t;
            if (view != null) {
                view.setVisibility(z2 ? 0 : 8);
                return Jb.l.f2618a;
            }
            h.i("mTipTextView");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        h.e(menu, "menu");
        h.e(inflater, "inflater");
        if (this.f20515A) {
            inflater.inflate(R.menu.melody_ui_tutorial_guide_menu, menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        Bundle arguments = getArguments();
        this.f20527v = arguments != null ? arguments.getString("device_mac_info") : null;
        Bundle arguments2 = getArguments();
        this.f20528w = arguments2 != null ? arguments2.getString("device_name") : null;
        Bundle arguments3 = getArguments();
        this.f20530y = arguments3 != null ? arguments3.getString("product_color") : null;
        Bundle arguments4 = getArguments();
        this.f20529x = arguments4 != null ? arguments4.getString("product_id") : null;
        Bundle arguments5 = getArguments();
        this.f20531z = arguments5 != null ? arguments5.getString("route_from") : null;
        Bundle arguments6 = getArguments();
        this.f20515A = arguments6 != null ? arguments6.getBoolean("route_value2", false) : false;
        Bundle arguments7 = getArguments();
        this.f20516B = arguments7 != null ? arguments7.getBoolean("route_value3", false) : false;
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.f20529x, this.f20528w);
        if (whitelistConfigDTOC != null) {
            this.f20517C = whitelistConfigDTOC.getType();
        }
        return "N".equals(this.f20517C) ? inflater.inflate(R.layout.melody_ui_control_guide_neck_ear_detect, container, false) : inflater.inflate(R.layout.melody_ui_control_guide_ear_detect, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != R.id.go_next) {
            return super.onOptionsItemSelected(item);
        }
        ForkJoinPool.commonPool().execute(new RunnableC0380n(this, 9));
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        u onBackPressedDispatcher;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        if ("N".equals(this.f20517C)) {
            View viewFindViewById = view.findViewById(R.id.iv_device);
            h.d(viewFindViewById, "findViewById(...)");
            this.f20519b = (ImageView) viewFindViewById;
        } else {
            View viewFindViewById2 = view.findViewById(R.id.iv_left_device);
            h.d(viewFindViewById2, "findViewById(...)");
            this.f20520c = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.iv_right_device);
            h.d(viewFindViewById3, "findViewById(...)");
            this.f20521p = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.tv_left_tag);
            h.d(viewFindViewById4, "findViewById(...)");
            this.f20522q = (ImageView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.tv_right_tag);
            h.d(viewFindViewById5, "findViewById(...)");
            this.f20523r = (ImageView) viewFindViewById5;
        }
        if ("N".equals(this.f20517C)) {
            ImageView imageView = this.f20519b;
            if (imageView == null) {
                h.i("mImageView");
                throw null;
            }
            imageView.setImageResource(R.drawable.melody_ui_neck_headset_control_default);
        } else if (Y.i(this.f20517C)) {
            ImageView imageView2 = this.f20520c;
            if (imageView2 == null) {
                h.i("mLeftImageView");
                throw null;
            }
            imageView2.setImageResource(R.drawable.melody_ui_image_ear_left_ows);
            ImageView imageView3 = this.f20521p;
            if (imageView3 == null) {
                h.i("mRightImageView");
                throw null;
            }
            imageView3.setImageResource(R.drawable.melody_ui_image_ear_right_ows);
        } else {
            ImageView imageView4 = this.f20520c;
            if (imageView4 == null) {
                h.i("mLeftImageView");
                throw null;
            }
            imageView4.setImageResource(R.drawable.melody_ui_image_ear_left_default);
            ImageView imageView5 = this.f20521p;
            if (imageView5 == null) {
                h.i("mRightImageView");
                throw null;
            }
            imageView5.setImageResource(R.drawable.melody_ui_image_ear_right_default);
        }
        View viewFindViewById6 = view.findViewById(R.id.control_guide_continue);
        h.d(viewFindViewById6, "findViewById(...)");
        MelodyCompatButton melodyCompatButton = (MelodyCompatButton) viewFindViewById6;
        this.f20524s = melodyCompatButton;
        melodyCompatButton.setOnClickListener(new E(this, 1));
        View viewFindViewById7 = view.findViewById(R.id.control_guide_des_content);
        h.d(viewFindViewById7, "findViewById(...)");
        this.f20525t = viewFindViewById7;
        f activity = getActivity();
        h.c(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        i iVar = (i) activity;
        O viewModelStore = iVar.getViewModelStore();
        N.b defaultViewModelProviderFactory = iVar.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, iVar.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(EarDetectViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        EarDetectViewModel earDetectViewModel = (EarDetectViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f20518a = earDetectViewModel;
        earDetectViewModel.f20503b.e(getViewLifecycleOwner(), new b(new AnonymousClass2(1, this, GuideEarDetectFragment.class, "onEarResourceChanged", "onEarResourceChanged(Lcom/oplus/melody/model/zipdata/ControlSourceDO;)V", 0)));
        if (this.f20518a == null) {
            h.i("mEarDetectViewModel");
            throw null;
        }
        String str = this.f20527v;
        h.b(str);
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new e(9))).e(getViewLifecycleOwner(), new b(new AnonymousClass3(1, this, GuideEarDetectFragment.class, "onEarStatusChanged", "onEarStatusChanged(Lcom/oplus/melody/ui/component/control/guide/EarDetectVO;)V", 0)));
        if (this.f20516B && !this.f20515A) {
            ka.h.b(this.f20527v);
        }
        f activity2 = getActivity();
        if (activity2 == null || (onBackPressedDispatcher = activity2.getOnBackPressedDispatcher()) == null) {
            return;
        }
        a aVar = new a(false, this);
        s.a aVar2 = new s.a(aVar, new c.t(null, aVar));
        aVar.f13226a.add(aVar2);
        C1084c.a(onBackPressedDispatcher.b().f13235c, aVar2);
    }
}
