package com.oplus.melody.ui.component.detail.sound.main;

import D7.C0379m;
import D7.o0;
import Ea.C0403l;
import Ea.E;
import F8.c;
import F8.i;
import M9.b;
import N9.i;
import N9.o;
import P9.d;
import Wb.l;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InterfaceC0575p;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.lifecycle.s;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.COUILinearLayoutManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.K;
import com.oplus.melody.model.net.data.ZenModeInfoDO;
import com.oplus.melody.model.repository.soundplay.PlayState;
import com.oplus.melody.model.repository.zenmode.SoundCacheCleanEvent;
import com.oplus.melody.model.repository.zenmode.ZenModeRepository;
import com.oplus.melody.model.repository.zenmode.t;
import com.oplus.melody.ui.component.detail.sound.main.SoundMainFragment;
import com.oplus.melody.ui.component.detail.sound.main.SoundMainViewModel;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import com.oplus.melody.ui.widget.MelodyCrossRecyclerView;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import t8.q;

/* JADX INFO: compiled from: SoundMainFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010,\u001a\u00020\"H\u0016J\b\u0010-\u001a\u00020\"H\u0016J\u0010\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020 H\u0002J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\"H\u0002J\b\u00105\u001a\u00020\"H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/oplus/melody/ui/component/detail/sound/main/SoundMainFragment;", "Lcom/oplus/melody/ui/base/BaseFragment;", "<init>", "()V", "mViewModel", "Lcom/oplus/melody/ui/component/detail/sound/main/SoundMainViewModel;", "mAdapter", "Lcom/oplus/melody/ui/component/detail/sound/main/SoundCategoryAdapter;", "musicImg", "Landroid/widget/ImageView;", "musicName", "Landroid/widget/TextView;", "musicCategoryNameTv", "musicTime", "mPlayPanel", "Landroid/view/View;", "mPlayBtnLay", "Landroid/widget/FrameLayout;", "mPlayBtn", "mBackgroundSoundSettingsBottomSheet", "Lcom/oplus/melody/ui/component/detail/sound/settings/SoundBackgroundSettingsBottomSheet;", "mSoundCategoryMap", "Ljava/util/LinkedHashMap;", "", "Lcom/oplus/melody/ui/component/detail/sound/main/SoundCategoryVO;", "Lkotlin/collections/LinkedHashMap;", "mCleanCacheState", "Lcom/oplus/melody/model/repository/zenmode/SoundCacheCleanEvent;", "mSpCurrentMediaId", "mSpCurrentSoundItem", "Lcom/oplus/melody/ui/component/detail/sound/main/SoundItemVO;", "mPlayState", "Lcom/oplus/melody/model/repository/soundplay/PlayState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onPause", "onResume", "playStateChange", "playState", "playingMediaItemChange", "mediaId", "onCleanCacheStateChange", "cleanState", "restoreDefaultSoundToPlaylist", "onDestroyView", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SoundMainFragment extends c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public SoundCacheCleanEvent f21220A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f21221B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public i f21222C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public PlayState f21223D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SoundMainViewModel f21224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public N9.b f21225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f21226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f21227s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f21228t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f21229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f21230v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public FrameLayout f21231w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f21232x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d f21233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public LinkedHashMap<String, N9.c> f21234z;

    /* JADX INFO: compiled from: SoundMainFragment.kt */
    public static final class a implements InterfaceC0575p {
        public a() {
        }

        @Override // androidx.core.view.InterfaceC0575p
        public final boolean g(MenuItem menuItem) {
            t tVar;
            ZenModeInfoDO defaultSceneV2;
            t tVar2;
            ZenModeInfoDO defaultSceneV22;
            t tVar3;
            ZenModeInfoDO defaultSceneV23;
            h.e(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.setting) {
                return false;
            }
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
            F8.i iVarA = i.a.a("/ui/sound/settings");
            SoundMainFragment soundMainFragment = SoundMainFragment.this;
            SoundMainViewModel soundMainViewModel = soundMainFragment.f21224p;
            String audioSha256 = null;
            iVarA.f("route_value", (soundMainViewModel == null || (tVar3 = soundMainViewModel.f21240e) == null || (defaultSceneV23 = tVar3.getDefaultSceneV2()) == null) ? null : defaultSceneV23.getResId());
            SoundMainViewModel soundMainViewModel2 = soundMainFragment.f21224p;
            iVarA.f("route_value2", (soundMainViewModel2 == null || (tVar2 = soundMainViewModel2.f21240e) == null || (defaultSceneV22 = tVar2.getDefaultSceneV2()) == null) ? null : defaultSceneV22.getAudioUrl());
            SoundMainViewModel soundMainViewModel3 = soundMainFragment.f21224p;
            if (soundMainViewModel3 != null && (tVar = soundMainViewModel3.f21240e) != null && (defaultSceneV2 = tVar.getDefaultSceneV2()) != null) {
                audioSha256 = defaultSceneV2.getAudioSha256();
            }
            iVarA.f("route_value3", audioSha256);
            iVarA.b(soundMainFragment.getActivity());
            return true;
        }

        @Override // androidx.core.view.InterfaceC0575p
        public final void j(Menu menu, MenuInflater menuInflater) {
            h.e(menu, "menu");
            h.e(menuInflater, "menuInflater");
            menuInflater.inflate(R.menu.melody_ui_sound_menu, menu);
        }
    }

    /* JADX INFO: compiled from: SoundMainFragment.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21236a;

        public b(l lVar) {
            this.f21236a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final Jb.a<?> getFunctionDelegate() {
            return this.f21236a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21236a.d(obj);
        }
    }

    /* JADX INFO: renamed from: com.oplus.melody.ui.component.detail.sound.main.SoundMainFragment$onViewCreated$8, reason: invalid class name */
    /* JADX INFO: compiled from: SoundMainFragment.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements l<PlayState, Jb.l> {
        @Override // Wb.l
        public final Jb.l d(PlayState playState) {
            PlayState p02 = playState;
            h.e(p02, "p0");
            ((SoundMainFragment) this.receiver).r(p02);
            return Jb.l.f2618a;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        Bundle arguments;
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            A.h("SoundMainFragment", "onCreate args is null");
            requireActivity().finish();
            return;
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        h.d(fVarRequireActivity, "requireActivity(...)");
        O viewModelStore = fVarRequireActivity.getViewModelStore();
        N.b defaultViewModelProviderFactory = fVarRequireActivity.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, fVarRequireActivity.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(SoundMainViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        SoundMainViewModel soundMainViewModel = (SoundMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.f21224p = soundMainViewModel;
        Bundle arguments2 = getArguments();
        soundMainViewModel.f21240e = (t) C0917x.c(t.class, arguments2 != null ? arguments2.getString("resZipConfig") : null);
        SoundMainViewModel soundMainViewModel2 = this.f21224p;
        if (soundMainViewModel2 != null) {
            Bundle arguments3 = getArguments();
            soundMainViewModel2.f21237b = arguments3 != null ? arguments3.getString("device_mac_info") : null;
        }
        SoundMainViewModel soundMainViewModel3 = this.f21224p;
        if ((soundMainViewModel3 != null ? soundMainViewModel3.f21237b : null) == null) {
            A.h("SoundMainFragment", "onCreate address is null");
            requireActivity().finish();
            return;
        }
        if (soundMainViewModel3 != null) {
            Bundle arguments4 = getArguments();
            soundMainViewModel3.f21238c = arguments4 != null ? arguments4.getString("product_id") : null;
        }
        SoundMainViewModel soundMainViewModel4 = this.f21224p;
        if ((soundMainViewModel4 != null ? soundMainViewModel4.f21238c : null) == null) {
            A.h("SoundMainFragment", "onCreate productId is null");
            requireActivity().finish();
            return;
        }
        if (soundMainViewModel4 != null) {
            Bundle arguments5 = getArguments();
            soundMainViewModel4.f21239d = arguments5 != null ? arguments5.getString("product_color") : null;
        }
        SoundMainViewModel soundMainViewModel5 = this.f21224p;
        if ((soundMainViewModel5 != null ? soundMainViewModel5.f21239d : null) == null) {
            A.h("SoundMainFragment", "onCreate color is null");
            requireActivity().finish();
        } else {
            if (soundMainViewModel5 == null || (arguments = getArguments()) == null) {
                return;
            }
            arguments.getString("device_name");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        h.e(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.melody_ui_fragment_sound, container, false);
        h.d(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        COUIBottomSheetDialog cOUIBottomSheetDialog;
        d dVar = this.f21233y;
        if (dVar != null && (cOUIBottomSheetDialog = dVar.f4019b) != null) {
            cOUIBottomSheetDialog.dismiss();
        }
        this.f21233y = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        A.b("SoundMainFragment", "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        A.b("SoundMainFragment", "onResume");
    }

    @Override // F8.c, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        int i10 = 11;
        int i11 = 4;
        final int i12 = 0;
        h.e(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) view.findViewById(R.id.toolbar);
        final int i13 = 1;
        if (melodyCompatToolbar != null) {
            androidx.fragment.app.f activity = getActivity();
            F8.d dVar = activity instanceof F8.d ? (F8.d) activity : null;
            if (dVar != null) {
                dVar.y(melodyCompatToolbar);
                androidx.appcompat.app.a aVarX = dVar.x();
                if (aVarX != null) {
                    aVarX.n(true);
                    aVarX.r(true);
                    aVarX.t(R.string.melody_ui_sound_title_space);
                }
            }
        }
        androidx.fragment.app.f fVarRequireActivity = requireActivity();
        a aVar = new a();
        InterfaceC0601m viewLifecycleOwner = getViewLifecycleOwner();
        h.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        fVarRequireActivity.f13202c.b(aVar, viewLifecycleOwner, Lifecycle.State.f8899c);
        MelodyCrossRecyclerView melodyCrossRecyclerView = (MelodyCrossRecyclerView) view.findViewById(R.id.sound_categories);
        requireContext();
        melodyCrossRecyclerView.setLayoutManager(new COUILinearLayoutManager(1));
        melodyCrossRecyclerView.setItemAnimator(null);
        melodyCrossRecyclerView.setHasFixedSize(true);
        View viewFindViewById = view.findViewById(R.id.play_panel);
        this.f21230v = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: N9.m

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ SoundMainFragment f3477b;

                {
                    this.f3477b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SoundMainFragment soundMainFragment = this.f3477b;
                    switch (i12) {
                        case 0:
                            E8.a.w().getClass();
                            Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                            F8.i iVarA = i.a.a("/ui/sound/playing");
                            SoundMainViewModel soundMainViewModel = soundMainFragment.f21224p;
                            iVarA.f("device_mac_info", soundMainViewModel != null ? soundMainViewModel.f21237b : null);
                            SoundMainViewModel soundMainViewModel2 = soundMainFragment.f21224p;
                            iVarA.f("product_id", soundMainViewModel2 != null ? soundMainViewModel2.f21238c : null);
                            SoundMainViewModel soundMainViewModel3 = soundMainFragment.f21224p;
                            iVarA.f("product_color", soundMainViewModel3 != null ? soundMainViewModel3.f21239d : null);
                            iVarA.b(soundMainFragment.requireActivity());
                            soundMainFragment.requireActivity().overridePendingTransition(R.anim.melody_ui_slide_in_bottom, 0);
                            break;
                        default:
                            if (soundMainFragment.f21224p != null) {
                                Object obj = M9.b.h;
                                b.a.a().e();
                            }
                            break;
                    }
                }
            });
        }
        this.f21226r = (ImageView) view.findViewById(R.id.music_img);
        this.f21227s = (TextView) view.findViewById(R.id.music_name);
        this.f21228t = (TextView) view.findViewById(R.id.music_category_name);
        this.f21229u = (TextView) view.findViewById(R.id.music_time);
        this.f21231w = (FrameLayout) view.findViewById(R.id.play_btn_lay);
        this.f21232x = (ImageView) view.findViewById(R.id.play_btn);
        FrameLayout frameLayout = this.f21231w;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: N9.m

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ SoundMainFragment f3477b;

                {
                    this.f3477b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SoundMainFragment soundMainFragment = this.f3477b;
                    switch (i13) {
                        case 0:
                            E8.a.w().getClass();
                            Jb.b<List<Wb.l<String, Class<?>>>> bVar = F8.i.f1668g;
                            F8.i iVarA = i.a.a("/ui/sound/playing");
                            SoundMainViewModel soundMainViewModel = soundMainFragment.f21224p;
                            iVarA.f("device_mac_info", soundMainViewModel != null ? soundMainViewModel.f21237b : null);
                            SoundMainViewModel soundMainViewModel2 = soundMainFragment.f21224p;
                            iVarA.f("product_id", soundMainViewModel2 != null ? soundMainViewModel2.f21238c : null);
                            SoundMainViewModel soundMainViewModel3 = soundMainFragment.f21224p;
                            iVarA.f("product_color", soundMainViewModel3 != null ? soundMainViewModel3.f21239d : null);
                            iVarA.b(soundMainFragment.requireActivity());
                            soundMainFragment.requireActivity().overridePendingTransition(R.anim.melody_ui_slide_in_bottom, 0);
                            break;
                        default:
                            if (soundMainFragment.f21224p != null) {
                                Object obj = M9.b.h;
                                b.a.a().e();
                            }
                            break;
                    }
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R.id.background_sound_settings_btn);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new E(this, 4));
        }
        o oVar = new o(this, i12);
        WeakReference weakReference = new WeakReference(this);
        InterfaceC0601m viewLifecycleOwner2 = getViewLifecycleOwner();
        h.d(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        SoundMainViewModel soundMainViewModel = this.f21224p;
        N9.b bVar = new N9.b(weakReference, viewLifecycleOwner2, soundMainViewModel != null ? soundMainViewModel.f21238c : null, soundMainViewModel != null ? soundMainViewModel.f21237b : null, soundMainViewModel != null ? soundMainViewModel.f21239d : null, oVar);
        this.f21225q = bVar;
        melodyCrossRecyclerView.setAdapter(bVar);
        int i14 = q.c("melody-model-settings").getInt("sound_settings_countdown_time", -1);
        if (this.f21224p != null) {
            Object obj = M9.b.h;
            b.a.a().g(i14);
        }
        SoundMainViewModel soundMainViewModel2 = this.f21224p;
        if (soundMainViewModel2 != null) {
            CompletableFuture completableFutureM = ZenModeRepository.j().m(K.b(-1, soundMainViewModel2.f21239d), soundMainViewModel2.f21238c);
            CompletableFuture completableFutureThenComposeAsync = completableFutureM != null ? completableFutureM.thenComposeAsync((Function) new C0403l(new B9.d(soundMainViewModel2, i10), i11), (Executor) o0.c.f1144b) : null;
            if (completableFutureThenComposeAsync != null) {
                completableFutureThenComposeAsync.whenCompleteAsync((BiConsumer) new B9.b(new B9.a(this, 3), 7), (Executor) o0.c.f1144b);
            }
        }
        if (this.f21224p != null) {
            Object obj2 = M9.b.h;
            b.a.a().f("get_timer_state", null);
        }
        if (this.f21224p != null) {
            Object obj3 = M9.b.h;
            C0379m.b(C0379m.b(b.a.a().f3344c)).e(getViewLifecycleOwner(), new b(new B9.d(this, 10)));
        }
        if (this.f21224p != null) {
            Object obj4 = M9.b.h;
            C0379m.b(C0379m.b(b.a.a().f3345d)).e(getViewLifecycleOwner(), new b(new AnonymousClass8(1, this, SoundMainFragment.class, "playStateChange", "playStateChange(Lcom/oplus/melody/model/repository/soundplay/PlayState;)V", 0)));
        }
        if (this.f21224p != null) {
            s<SoundCacheCleanEvent> sVarQ = ZenModeRepository.j().q();
            h.d(sVarQ, "getSoundCleanCacheState(...)");
            C0379m.b(sVarQ).e(getViewLifecycleOwner(), new b(new o(this, i13)));
        }
        if (this.f21224p != null) {
            Object obj5 = M9.b.h;
            C0379m.b(b.a.a().f3347f).e(getViewLifecycleOwner(), new b(new Aa.b(this, i10)));
        }
        if (this.f21224p != null) {
            Object obj6 = M9.b.h;
            C0379m.b(b.a.a().f3348g).e(getViewLifecycleOwner(), new b(new A9.j(this, 9)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r(com.oplus.melody.model.repository.soundplay.PlayState r5) {
        /*
            r4 = this;
            Ea.m r0 = new Ea.m
            r1 = 18
            r0.<init>(r5, r1)
            java.lang.String r1 = "SoundMainFragment"
            com.oplus.melody.common.util.A.c(r1, r0)
            r4.f21223D = r5
            com.oplus.melody.model.repository.soundplay.PlayState r0 = com.oplus.melody.model.repository.soundplay.PlayState.f20119a
            r1 = 0
            r2 = 2131232185(0x7f0805b9, float:1.8080472E38)
            if (r5 != r0) goto L55
            N9.i r5 = r4.f21222C
            if (r5 != 0) goto L46
            com.oplus.melody.ui.component.detail.sound.main.SoundMainViewModel r5 = r4.f21224p
            if (r5 == 0) goto L39
            java.lang.Object r5 = M9.b.h
            M9.b r5 = M9.b.a.a()
            androidx.lifecycle.u<Y.q> r5 = r5.f3344c
            androidx.lifecycle.t r5 = D7.C0379m.b(r5)
            androidx.lifecycle.t r5 = D7.C0379m.b(r5)
            java.lang.Object r5 = r5.d()
            Y.q r5 = (Y.q) r5
            if (r5 == 0) goto L39
            java.lang.String r5 = r5.f6333a
            goto L3a
        L39:
            r5 = 0
        L3a:
            if (r5 != 0) goto L46
            android.view.View r5 = r4.f21230v
            if (r5 == 0) goto L4d
            r0 = 8
            r5.setVisibility(r0)
            goto L4d
        L46:
            android.view.View r5 = r4.f21230v
            if (r5 == 0) goto L4d
            r5.setVisibility(r1)
        L4d:
            android.widget.ImageView r5 = r4.f21232x
            if (r5 == 0) goto L81
            r5.setImageResource(r2)
            return
        L55:
            com.oplus.melody.model.repository.soundplay.PlayState r0 = com.oplus.melody.model.repository.soundplay.PlayState.f20121c
            if (r5 == r0) goto L66
            com.oplus.melody.model.repository.soundplay.PlayState r3 = com.oplus.melody.model.repository.soundplay.PlayState.f20122p
            if (r5 != r3) goto L5e
            goto L66
        L5e:
            android.widget.ImageView r5 = r4.f21232x
            if (r5 == 0) goto L81
            r5.setImageResource(r2)
            return
        L66:
            android.view.View r3 = r4.f21230v
            if (r3 == 0) goto L6d
            r3.setVisibility(r1)
        L6d:
            if (r5 != r0) goto L7a
            android.widget.ImageView r5 = r4.f21232x
            if (r5 == 0) goto L81
            r0 = 2131232214(0x7f0805d6, float:1.808053E38)
            r5.setImageResource(r0)
            return
        L7a:
            android.widget.ImageView r5 = r4.f21232x
            if (r5 == 0) goto L81
            r5.setImageResource(r2)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.sound.main.SoundMainFragment.r(com.oplus.melody.model.repository.soundplay.PlayState):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(String str) {
        String str2;
        ZenModeInfoDO soundInfoDO;
        String imgUrl;
        ImageView imageView;
        ZenModeInfoDO soundInfoDO2;
        String name;
        TextView textView;
        Collection<N9.c> collection;
        T t10;
        Object next;
        A.c("SoundMainFragment", new D6.c(str, 7));
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        N9.b bVar = this.f21225q;
        if (bVar == null || (collection = bVar.f1907a) == null) {
            str2 = null;
        } else {
            for (N9.c cVar : collection) {
                List<N9.i> list = cVar.f3442c;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            next = it.next();
                            if (h.a(((N9.i) next).getSoundInfoDO().getResId(), str)) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    t10 = (N9.i) next;
                } else {
                    t10 = 0;
                }
                ref$ObjectRef.element = t10;
                if (t10 != 0) {
                    str2 = cVar.f3441b;
                    break;
                }
            }
            str2 = null;
        }
        N9.i iVar = (N9.i) ref$ObjectRef.element;
        if (iVar != null && (soundInfoDO2 = iVar.getSoundInfoDO()) != null && (name = soundInfoDO2.getName()) != null && (textView = this.f21227s) != null) {
            textView.setText(name);
        }
        N9.i iVar2 = (N9.i) ref$ObjectRef.element;
        if (iVar2 != null && (soundInfoDO = iVar2.getSoundInfoDO()) != null && (imgUrl = soundInfoDO.getImgUrl()) != null && (imageView = this.f21226r) != null) {
            HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
            if (heyMelodyApplication == null) {
                h.i("context");
                throw null;
            }
            Glide.with(heyMelodyApplication).load(imgUrl).transform(new CircleCrop()).into(imageView);
        }
        TextView textView2 = this.f21228t;
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }
}
