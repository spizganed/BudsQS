package com.oplus.melody.ui.component.detail.noisereduction;

import A6.b;
import A6.e;
import A6.f;
import A9.i;
import D7.C0373g;
import D7.C0379m;
import D7.C0384s;
import D7.L;
import D7.RunnableC0380n;
import D7.o0;
import Ea.C0399h;
import Ea.C0404m;
import F9.l;
import F9.r;
import F9.s;
import F9.u;
import F9.w;
import L8.V;
import L8.g0;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.m;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0908n;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.NoiseReductionInfoDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.noisereduction.NoiseReductionItem;
import com.oplus.melody.ui.component.detail.personalnoise.PersonalNoiseItem;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import com.oplus.melody.ui.widget.devicecontrol.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;
import t8.k;

/* JADX INFO: loaded from: classes3.dex */
public class NoiseReductionItem extends COUIPreference implements g0 {
    public static final String ADAPTIVE_NOISE_TIPS_SHOWED = "adaptive_noise_tips_showed";
    public static final String ITEM_NAME = "NoiseReductionItem";
    private boolean hasObserve;
    private DeviceControlWidget mActionView;
    private C0399h mCOUIToolTips;
    private LinearLayout mChildItemLayout;
    private l mChildModeManager;
    private Context mContext;
    private boolean mIsAttached;
    private boolean mIsInTutorialGuide;
    private boolean mIsItemHidden;
    public InterfaceC0601m mLifecycleOwner;
    private COUICardListSelectedItemLayout mNoiseCard;
    private final ArrayList<WhitelistConfigDTO.NoiseReductionMode> mNoiseReductionModeList;
    private w mNoiseReductionVO;
    private final DeviceControlWidget.a mOnModeActionClickListener;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private boolean mSupportPersonalNoise;
    private Runnable mToolTipsRunnable;
    public DetailMainViewModel mViewModel;

    public NoiseReductionItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mNoiseReductionModeList = new ArrayList<>();
        this.mSetCommandFuture = null;
        this.mIsInTutorialGuide = false;
        this.mIsAttached = false;
        this.mCOUIToolTips = null;
        this.mToolTipsRunnable = new RunnableC0380n(this, 2);
        this.mContext = null;
        this.mSupportPersonalNoise = false;
        this.mIsItemHidden = false;
        this.mOnModeActionClickListener = new a();
        A.b(ITEM_NAME, "NoiseReductionItem..");
        setBackgroundAnimationEnabled(false);
        setLayoutResource(R.layout.melody_ui_recycler_item_mode_action);
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        AbstractC1508a abstractC1508aF = AbstractC1508a.f();
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(detailMainViewModel2.f20400e, detailMainViewModel2.f20398c);
        EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(this.mViewModel.f20397b);
        if (whitelistConfigDTOC != null && whitelistConfigDTOC.getFunction() != null && earphoneDTOW != null) {
            WhitelistConfigDTO.Function function = whitelistConfigDTOC.getFunction();
            HashMap<String, Class<?>> map = V.f3092n;
            if (Y.r(function, k.c(earphoneDTOW.getDeviceVersionList()))) {
                this.mSupportPersonalNoise = true;
            }
        }
        l lVar = new l(context, this.mViewModel);
        this.mChildModeManager = lVar;
        lVar.f1731k = this.mSupportPersonalNoise;
        setSelectable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndShowAdaptiveTips() {
        View childAt;
        if ((getContext() instanceof Activity) && (((Activity) getContext()).isFinishing() || ((Activity) getContext()).isDestroyed())) {
            return;
        }
        w wVar = this.mNoiseReductionVO;
        if (wVar == null) {
            A.j(ITEM_NAME, "checkAndShowAdaptiveTips mNoiseReductionVO is null!");
            return;
        }
        if (this.mIsItemHidden) {
            A.j(ITEM_NAME, "checkAndShowAdaptiveTips mIsItemHidden=true");
            return;
        }
        if (wVar.getConnectionState() != 2) {
            return;
        }
        String noiseReductionModeName = getNoiseReductionModeName(10);
        if (this.mActionView == null || TextUtils.isEmpty(noiseReductionModeName)) {
            return;
        }
        if (r.b(this.mNoiseReductionVO.getCurrentNoiseReductionModeIndex(), this.mNoiseReductionVO.getNoiseReductionModeList()) == 10) {
            C0399h c0399h = this.mCOUIToolTips;
            if (c0399h != null && c0399h.isShowing()) {
                this.mCOUIToolTips.dismiss();
                this.mCOUIToolTips.r(null);
            }
            C0908n.b(getContext()).edit().putBoolean(ADAPTIVE_NOISE_TIPS_SHOWED, true).apply();
            A.b(ITEM_NAME, "checkAndShowAdaptiveTips, already MODE_NOISE_ADAPTIVE mode, return");
            return;
        }
        A.c(ITEM_NAME, new C0404m(this, 3));
        C0399h c0399h2 = this.mCOUIToolTips;
        if ((c0399h2 == null || (!c0399h2.isShowing() && this.mCOUIToolTips.q())) && this.mIsAttached) {
            int i10 = 0;
            if (C0908n.b(getContext()).getBoolean(ADAPTIVE_NOISE_TIPS_SHOWED, false)) {
                return;
            }
            if (this.mCOUIToolTips == null) {
                C0399h c0399h3 = new C0399h(getContext());
                this.mCOUIToolTips = c0399h3;
                c0399h3.n(false);
                this.mCOUIToolTips.m(getContext().getResources().getString(R.string.melody_ui_noise_reduction_adaptive_noise_tips));
                this.mCOUIToolTips.f27813G = new s(this, 0);
            }
            DeviceControlWidget deviceControlWidget = this.mActionView;
            if (noiseReductionModeName != null) {
                if (deviceControlWidget.getChildCount() > 0) {
                    int childCount = deviceControlWidget.getChildCount();
                    while (i10 < childCount) {
                        View childAt2 = deviceControlWidget.getChildAt(i10);
                        if ((childAt2 instanceof c) && TextUtils.equals(noiseReductionModeName, ((c) childAt2).getName())) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (i10 != -1 || (childAt = this.mActionView.getChildAt(i10)) == null) {
                }
                this.mCOUIToolTips.r(childAt);
                C0399h c0399h4 = this.mCOUIToolTips;
                if (c0399h4.f1528X || !c0399h4.q()) {
                    return;
                }
                this.mCOUIToolTips.p(childAt);
                return;
            }
            deviceControlWidget.getClass();
            i10 = -1;
            if (i10 != -1) {
            }
        }
    }

    private static ModeItem createModeItem(Context context, int i10, Drawable drawable, String str, boolean z2, boolean z4) {
        int iB = P1.a.b(context, R.attr.couiColorLabelTheme, 0);
        ModeItem modeItem = new ModeItem();
        modeItem.p(drawable);
        modeItem.q(String.valueOf(i10));
        modeItem.s(str);
        modeItem.u(z2);
        modeItem.t(z4);
        modeItem.w(true);
        modeItem.n(Integer.valueOf(iB));
        return modeItem;
    }

    private String getNoiseReductionModeName(int i10) {
        DeviceControlWidget deviceControlWidget;
        if (this.mNoiseReductionModeList.isEmpty()) {
            return null;
        }
        for (int i11 = 0; i11 < this.mNoiseReductionModeList.size() - 1; i11++) {
            if (this.mNoiseReductionModeList.get(i11).getModeType() == i10 && (deviceControlWidget = this.mActionView) != null && deviceControlWidget.getModeList().size() > i11) {
                return this.mActionView.getModeList().get(i11).getName();
            }
        }
        return null;
    }

    private boolean isNoiseReductionModeSupported(WhitelistConfigDTO.NoiseReductionMode noiseReductionMode, NoiseReductionInfoDTO noiseReductionInfoDTO) {
        if (noiseReductionMode == null || (noiseReductionMode.getDecideByEarDevice() && (noiseReductionInfoDTO == null || !noiseReductionInfoDTO.isSupportNoiseReductionModeValue(noiseReductionMode.getProtocolIndex())))) {
            A.c(ITEM_NAME, new Ca.r(noiseReductionMode, 8));
            return false;
        }
        noiseReductionMode.getModeType();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$checkAndShowAdaptiveTips$0() {
        StringBuilder sb2 = new StringBuilder("checkAndShowAdaptiveTips start, mIsDetached: ");
        sb2.append(this.mIsAttached);
        sb2.append(", showing: ");
        C0399h c0399h = this.mCOUIToolTips;
        sb2.append(c0399h != null ? Boolean.valueOf(c0399h.isShowing()) : null);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAndShowAdaptiveTips$1() {
        this.mCOUIToolTips.r(null);
        C0908n.b(getContext()).edit().putBoolean(ADAPTIVE_NOISE_TIPS_SHOWED, true).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isNoiseReductionModeSupported$6(WhitelistConfigDTO.NoiseReductionMode noiseReductionMode) {
        return "isNoiseReductionModeSupported, not supported : " + noiseReductionMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$onBindViewHolder$2(m mVar) {
        return "onBindViewHolder hasObserve = " + this.hasObserve + ", holder = " + mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$onBindViewHolder$3() {
        return "onBindViewHolder start observe.. mIsInTutorialGuide = " + this.mIsInTutorialGuide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onHiddenChanged$7(boolean z2) {
        return e.f("onHiddenChanged hidden = ", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$updateActionView$4(List list) {
        return "updateActionView noiseReductionModeList = " + list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$updateActionView$5(int i10) {
        return b.d(i10, "updateActionView currentNoiseReductionType = ");
    }

    private void setContentViewEnable(boolean z2) {
        DeviceControlWidget deviceControlWidget = this.mActionView;
        if (deviceControlWidget == null) {
            return;
        }
        deviceControlWidget.setEnable(z2);
    }

    private void setItemSoundEffectDisabled() {
        int childCount;
        ViewGroup viewGroup;
        int childCount2;
        ViewGroup viewGroup2;
        int childCount3;
        DeviceControlWidget deviceControlWidget = this.mActionView;
        if (deviceControlWidget != null && (childCount = deviceControlWidget.getChildCount()) > 0) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.mActionView.getChildAt(i10);
                if (childAt != null) {
                    childAt.setSoundEffectsEnabled(false);
                    if ((childAt instanceof ViewGroup) && (childCount2 = (viewGroup = (ViewGroup) childAt).getChildCount()) > 0) {
                        for (int i11 = 0; i11 < childCount2; i11++) {
                            View childAt2 = viewGroup.getChildAt(i11);
                            if (childAt2 != null) {
                                childAt2.setSoundEffectsEnabled(false);
                                if ((childAt2 instanceof ViewGroup) && (childCount3 = (viewGroup2 = (ViewGroup) childAt2).getChildCount()) > 0) {
                                    for (int i12 = 0; i12 < childCount3; i12++) {
                                        View childAt3 = viewGroup2.getChildAt(i12);
                                        if (childAt3 != null) {
                                            childAt3.setSoundEffectsEnabled(false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActionView(DeviceControlWidget deviceControlWidget, w wVar, int i10) {
        int i11;
        List listE;
        int i12;
        int i13;
        int i14;
        Context context = getContext();
        List<WhitelistConfigDTO.NoiseReductionMode> noiseReductionModeList = wVar.getNoiseReductionModeList();
        NoiseReductionInfoDTO supportNoiseReductionInfo = wVar.getSupportNoiseReductionInfo();
        A.c(ITEM_NAME, new D9.b(2, noiseReductionModeList));
        if (!C0901g.a(noiseReductionModeList)) {
            int iB = r.b(i10, noiseReductionModeList);
            A.c(ITEM_NAME, new Ba.b(iB, 2));
            HashMap map = new HashMap();
            for (WhitelistConfigDTO.NoiseReductionMode noiseReductionMode : noiseReductionModeList) {
                if (noiseReductionMode != null) {
                    map.put(Integer.valueOf(noiseReductionMode.getModeType()), noiseReductionMode);
                }
            }
            synchronized (this.mNoiseReductionModeList) {
                try {
                    this.mNoiseReductionModeList.clear();
                    ArrayList arrayList = new ArrayList();
                    int noiseReductionUIVersion = wVar.getNoiseReductionUIVersion();
                    ArrayList arrayList2 = new ArrayList();
                    int i15 = 3;
                    if (noiseReductionUIVersion == 2) {
                        i11 = 4;
                        listE = com.google.android.play.core.appupdate.c.e(new Integer[]{4, 3, 5, 10, 2, 6, 1});
                    } else {
                        i11 = 4;
                        listE = com.google.android.play.core.appupdate.c.e(new Integer[]{4, 3, 5, 10, 1, 2, 6});
                    }
                    arrayList2.addAll(listE);
                    int size = arrayList2.size();
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < size) {
                        int i18 = i16 + 1;
                        int iIntValue = ((Integer) arrayList2.get(i16)).intValue();
                        if (iIntValue == i11 && map.containsKey(Integer.valueOf(i11))) {
                            WhitelistConfigDTO.NoiseReductionMode noiseReductionMode2 = (WhitelistConfigDTO.NoiseReductionMode) map.get(Integer.valueOf(i11));
                            if (isNoiseReductionModeSupported(noiseReductionMode2, supportNoiseReductionInfo)) {
                                Drawable drawableM = d.m(context, R.drawable.melody_ui_reduction_noise_strong);
                                String string = context.getString(R.string.melody_ui_noise_reduction_action_strong_reduction);
                                boolean z2 = iB == i11;
                                i12 = i11;
                                i14 = i17;
                                i13 = i15;
                                arrayList.add(createModeItem(context, i14, drawableM, string, z2, false));
                                this.mNoiseReductionModeList.add(noiseReductionMode2);
                                i14++;
                            } else {
                                i12 = i11;
                                i13 = i15;
                                i14 = i17;
                            }
                        } else {
                            i12 = i11;
                            i13 = i15;
                            i14 = i17;
                            if (iIntValue == i13 && map.containsKey(Integer.valueOf(i13))) {
                                WhitelistConfigDTO.NoiseReductionMode noiseReductionMode3 = (WhitelistConfigDTO.NoiseReductionMode) map.get(Integer.valueOf(i13));
                                if (isNoiseReductionModeSupported(noiseReductionMode3, supportNoiseReductionInfo)) {
                                    arrayList.add(createModeItem(context, i14, d.m(context, R.drawable.melody_ui_reduction_noise_weak), context.getString(R.string.melody_ui_noise_reduction_action_weak_reduction), iB == i13, false));
                                    this.mNoiseReductionModeList.add(noiseReductionMode3);
                                    i14++;
                                }
                            } else if (iIntValue == 5 && map.containsKey(5)) {
                                WhitelistConfigDTO.NoiseReductionMode noiseReductionMode4 = (WhitelistConfigDTO.NoiseReductionMode) map.get(5);
                                if (isNoiseReductionModeSupported(noiseReductionMode4, supportNoiseReductionInfo)) {
                                    arrayList.add(createModeItem(context, i14, d.m(context, R.drawable.melody_ui_reduction_noise_strong), context.getString(R.string.melody_ui_noise_reduction_action_reduction), r.c(noiseReductionMode4, iB), false));
                                    this.mNoiseReductionModeList.add(noiseReductionMode4);
                                    i14++;
                                }
                            } else {
                                if (iIntValue == 10 && map.containsKey(10)) {
                                    WhitelistConfigDTO.NoiseReductionMode noiseReductionMode5 = (WhitelistConfigDTO.NoiseReductionMode) map.get(10);
                                    if (isNoiseReductionModeSupported(noiseReductionMode5, supportNoiseReductionInfo)) {
                                        arrayList.add(createModeItem(context, i14, d.m(context, R.drawable.melody_ui_reduction_noise_adaptive), context.getString(R.string.melody_common_noise_reduction_action_auto), r.c(noiseReductionMode5, iB), false));
                                        this.mNoiseReductionModeList.add(noiseReductionMode5);
                                    }
                                } else if (iIntValue == 1 && map.containsKey(1)) {
                                    WhitelistConfigDTO.NoiseReductionMode noiseReductionMode6 = (WhitelistConfigDTO.NoiseReductionMode) map.get(1);
                                    if (isNoiseReductionModeSupported(noiseReductionMode6, supportNoiseReductionInfo)) {
                                        Drawable drawableM2 = d.m(context, R.drawable.melody_ui_reduction_noise_close);
                                        String string2 = context.getString(R.string.melody_ui_noise_reduction_action_close_reduction);
                                        boolean z4 = true;
                                        if (iB != 1) {
                                            z4 = false;
                                        }
                                        arrayList.add(createModeItem(context, i14, drawableM2, string2, z4, false));
                                        this.mNoiseReductionModeList.add(noiseReductionMode6);
                                    }
                                } else if (iIntValue == 2 && map.containsKey(2)) {
                                    WhitelistConfigDTO.NoiseReductionMode noiseReductionMode7 = (WhitelistConfigDTO.NoiseReductionMode) map.get(2);
                                    if (isNoiseReductionModeSupported(noiseReductionMode7, supportNoiseReductionInfo)) {
                                        arrayList.add(createModeItem(context, i14, d.m(context, R.drawable.melody_ui_reduction_noise_transparent), context.getString(R.string.melody_ui_noise_reduction_action_pass_through_reduction), r.c(noiseReductionMode7, iB), false));
                                        this.mNoiseReductionModeList.add(noiseReductionMode7);
                                        i17 = i14 + 1;
                                        i15 = i13;
                                        i16 = i18;
                                        i11 = i12;
                                    }
                                } else if (iIntValue == 6 && map.containsKey(6)) {
                                    WhitelistConfigDTO.NoiseReductionMode noiseReductionMode8 = (WhitelistConfigDTO.NoiseReductionMode) map.get(6);
                                    if (isNoiseReductionModeSupported(noiseReductionMode8, supportNoiseReductionInfo)) {
                                        arrayList.add(createModeItem(context, i14, d.m(context, R.drawable.melody_ui_reduction_noise_transparent), context.getString(R.string.melody_ui_noise_reduction_action_pass_through_reduction_voice), iB == 6, false));
                                        this.mNoiseReductionModeList.add(noiseReductionMode8);
                                    }
                                }
                                i14++;
                            }
                        }
                        i17 = i14;
                        i15 = i13;
                        i16 = i18;
                        i11 = i12;
                    }
                    if (!this.mIsInTutorialGuide) {
                        this.mChildModeManager.a(this.mNoiseReductionModeList, iB, wVar);
                    }
                    if (A.l()) {
                        A.b(ITEM_NAME, "updateActionView noiseItemList = " + arrayList);
                    }
                    if (arrayList.size() > 0) {
                        deviceControlWidget.b(arrayList);
                    }
                } finally {
                }
            }
        }
        setItemSoundEffectDisabled();
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        this.mIsAttached = true;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(m mVar) {
        PersonalNoiseItem personalNoiseItem;
        super.onBindViewHolder(mVar);
        A.c(ITEM_NAME, new C0384s(4, this, mVar));
        this.mChildItemLayout = (LinearLayout) mVar.a(R.id.childItemLayout);
        DeviceControlWidget deviceControlWidget = (DeviceControlWidget) mVar.a(R.id.modeActionView);
        this.mActionView = deviceControlWidget;
        deviceControlWidget.setOnActionListener(this.mOnModeActionClickListener);
        if (!C0373g.e()) {
            DeviceControlWidget deviceControlWidget2 = this.mActionView;
            deviceControlWidget2.setPadding(deviceControlWidget2.getPaddingLeft(), C0906l.f19501a.getResources().getDimensionPixelOffset(R.dimen.melody_ui_noise_reduction_action_item_margin_top), this.mActionView.getPaddingRight(), this.mActionView.getPaddingBottom());
        }
        l lVar = this.mChildModeManager;
        LinearLayout parentView = this.mChildItemLayout;
        lVar.getClass();
        h.e(parentView, "parentView");
        lVar.f1724c = parentView;
        if (!this.hasObserve) {
            this.hasObserve = true;
            A.c(ITEM_NAME, new B6.a(this, 9));
            AbstractC0939b.E().J(this.mViewModel.f20397b);
            C0379m.b(C0379m.g(AbstractC0939b.E().v(this.mViewModel.f20397b), new f(14))).e(this.mLifecycleOwner, new A6.l(this, 4));
        }
        if (this.mSupportPersonalNoise && (personalNoiseItem = (PersonalNoiseItem) mVar.a(R.id.personal_noise_switch)) != null) {
            personalNoiseItem.setVisibility(0);
            personalNoiseItem.initItem(this.mContext, this.mViewModel, this.mLifecycleOwner);
        }
        if (C0373g.e()) {
            mVar.itemView.setBackground(null);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) mVar.a(R.id.child_item_container);
            if (cOUICardListSelectedItemLayout != null) {
                ((ViewGroup.MarginLayoutParams) cOUICardListSelectedItemLayout.getLayoutParams()).topMargin = C0906l.f19501a.getResources().getDimensionPixelOffset(R.dimen.melody_ui_noise_reduction_item_margin_top);
            }
        }
    }

    @Override // L8.g0
    public void onDestroy() {
        ViewTreeObserver viewTreeObserver;
        A.b(ITEM_NAME, "onDestroy..");
        l lVar = this.mChildModeManager;
        if (lVar != null) {
            Iterator<Map.Entry<Integer, F9.a>> it = lVar.f1725d.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onDestroy();
            }
        }
        C0399h c0399h = this.mCOUIToolTips;
        if (c0399h != null) {
            View view = c0399h.f1530Z;
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnPreDrawListener(c0399h.f1533c0);
            }
            c0399h.f1530Z = null;
            c0399h.i();
            c0399h.f27816K = false;
            c0399h.f1531a0.removeCallbacks(c0399h.f1532b0);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        this.mIsAttached = false;
    }

    public void onEarphoneDataChanged(w noiseReductionVO) {
        if (A.l()) {
            A.b(ITEM_NAME, "onEarphoneDataChanged noiseReductionVO = " + noiseReductionVO);
        }
        this.mNoiseReductionVO = noiseReductionVO;
        if (!this.mIsInTutorialGuide) {
            l lVar = this.mChildModeManager;
            lVar.getClass();
            h.e(noiseReductionVO, "noiseReductionVO");
            Iterator<Map.Entry<Integer, F9.a>> it = lVar.f1725d.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().c(noiseReductionVO);
            }
        }
        if (this.mNoiseReductionVO.getConnectionState() != 2) {
            updateActionView(this.mActionView, noiseReductionVO, -1);
            setContentViewEnable(false);
            return;
        }
        updateActionView(this.mActionView, noiseReductionVO, noiseReductionVO.getCurrentNoiseReductionModeIndex());
        setContentViewEnable(true);
        Handler handler = o0.c.f1143a;
        handler.removeCallbacks(this.mToolTipsRunnable);
        handler.postDelayed(this.mToolTipsRunnable, 500L);
    }

    @Override // L8.g0
    public void onHiddenChanged(boolean z2) {
        ViewTreeObserver viewTreeObserver;
        A.c(ITEM_NAME, new i(2, z2));
        Handler handler = o0.c.f1143a;
        handler.removeCallbacks(this.mToolTipsRunnable);
        this.mIsItemHidden = z2;
        if (!z2) {
            w wVar = this.mNoiseReductionVO;
            if (wVar == null || wVar.getConnectionState() != 2) {
                return;
            }
            handler.postDelayed(this.mToolTipsRunnable, 500L);
            return;
        }
        C0399h c0399h = this.mCOUIToolTips;
        if (c0399h != null) {
            View view = c0399h.f1530Z;
            if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnPreDrawListener(c0399h.f1533c0);
            }
            c0399h.f1530Z = null;
            c0399h.i();
            c0399h.f27816K = false;
            c0399h.f1531a0.removeCallbacks(c0399h.f1532b0);
            this.mCOUIToolTips = null;
        }
    }

    public void setIsInTutorialGuide() {
        this.mIsInTutorialGuide = true;
    }

    public class a implements DeviceControlWidget.a {
        public a() {
        }

        @Override // com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget.a
        public final void a(ModeItem modeItem, boolean z2) {
            final WhitelistConfigDTO.NoiseReductionMode noiseReductionMode;
            final Context context = NoiseReductionItem.this.getContext();
            if (NoiseReductionItem.this.mNoiseReductionVO == null) {
                A.h(NoiseReductionItem.ITEM_NAME, "onButtonClick mNoiseReductionVO is null!");
                return;
            }
            if (NoiseReductionItem.this.mNoiseReductionVO.getConnectionState() != 2) {
                A.x(NoiseReductionItem.ITEM_NAME, "onButtonClick not connected!");
                return;
            }
            if (modeItem != null && z2) {
                if (!NoiseReductionItem.this.mNoiseReductionVO.isCapabilityReady()) {
                    A.x(NoiseReductionItem.ITEM_NAME, "onButtonClick isCapabilityReady is false!");
                    return;
                }
                modeItem.u(true);
                synchronized (NoiseReductionItem.this.mNoiseReductionModeList) {
                    try {
                        if (NoiseReductionItem.this.mNoiseReductionVO != null) {
                            EarStatusDTO earStatus = NoiseReductionItem.this.mNoiseReductionVO.getEarStatus();
                            if (A.l()) {
                                A.b(NoiseReductionItem.ITEM_NAME, "onButtonClick isSupportEarStatus() " + NoiseReductionItem.this.mNoiseReductionVO.isSupportEarStatus() + ", earStatus = " + earStatus);
                            }
                            if (NoiseReductionItem.this.mNoiseReductionVO.isSupportEarStatus() && earStatus != null && earStatus.bothNotInEar()) {
                                NoiseReductionItem noiseReductionItem = NoiseReductionItem.this;
                                noiseReductionItem.updateActionView(noiseReductionItem.mActionView, NoiseReductionItem.this.mNoiseReductionVO, NoiseReductionItem.this.mNoiseReductionVO.getCurrentNoiseReductionModeIndex());
                                Toast.makeText(context, R.string.melody_ui_detail_main_need_wear_earphone2, 0).show();
                                return;
                            }
                        }
                        int i10 = modeItem.getId() != null ? Integer.parseInt(modeItem.getId()) : -1;
                        if (i10 == -1) {
                            A.h(NoiseReductionItem.ITEM_NAME, "onButtonClick position is -1!");
                            return;
                        }
                        if (i10 < NoiseReductionItem.this.mNoiseReductionModeList.size() && (noiseReductionMode = (WhitelistConfigDTO.NoiseReductionMode) NoiseReductionItem.this.mNoiseReductionModeList.get(i10)) != null) {
                            if (NoiseReductionItem.this.mSetCommandFuture != null) {
                                NoiseReductionItem.this.mSetCommandFuture.cancel(true);
                            }
                            NoiseReductionItem noiseReductionItem2 = NoiseReductionItem.this;
                            noiseReductionItem2.mSetCommandFuture = AbstractC0939b.E().k0(noiseReductionMode.getProtocolIndex(), noiseReductionItem2.mViewModel.f20397b);
                            if (NoiseReductionItem.this.mSetCommandFuture != null) {
                                NoiseReductionItem.this.mSetCommandFuture.thenAccept(new Consumer() { // from class: F9.t
                                    @Override // java.util.function.Consumer
                                    public final void accept(Object obj) {
                                        SetCommandStateDTO setCommandStateDTO = (SetCommandStateDTO) obj;
                                        NoiseReductionItem.a aVar = this.f1746a;
                                        aVar.getClass();
                                        Context context2 = context;
                                        if (context2 == null || setCommandStateDTO == null || TextUtils.isEmpty(setCommandStateDTO.getAddress())) {
                                            return;
                                        }
                                        String address = setCommandStateDTO.getAddress();
                                        NoiseReductionItem noiseReductionItem3 = NoiseReductionItem.this;
                                        if (address.equals(noiseReductionItem3.mViewModel.f20397b)) {
                                            int setCommandStatus = setCommandStateDTO.getSetCommandStatus();
                                            A.c(NoiseReductionItem.ITEM_NAME, new L(setCommandStatus, 6));
                                            if (setCommandStatus != 0) {
                                                noiseReductionItem3.mActionView.post(new C8.b(aVar, setCommandStatus, context2, 1));
                                                return;
                                            }
                                            WhitelistConfigDTO.NoiseReductionMode noiseReductionMode2 = noiseReductionMode;
                                            if (noiseReductionMode2.getModeType() == 10) {
                                                o0.c.f1144b.execute(new A9.k(aVar, 7));
                                            }
                                            r.e(noiseReductionMode2.getModeType(), noiseReductionItem3.mViewModel.f20397b);
                                        }
                                    }
                                }).exceptionally((Function<Throwable, ? extends Void>) new u(0, this, context));
                            }
                            if (!NoiseReductionItem.this.mIsInTutorialGuide) {
                                l lVar = NoiseReductionItem.this.mChildModeManager;
                                lVar.d(lVar.f1725d.get(Integer.valueOf(i10)), null, lVar.f1728g);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget.a
        public final void b(ModeItem modeItem) {
        }
    }
}
