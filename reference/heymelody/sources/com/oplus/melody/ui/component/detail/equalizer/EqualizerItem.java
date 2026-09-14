package com.oplus.melody.ui.component.detail.equalizer;

import A6.f;
import C9.a;
import Ca.n;
import D7.C0368b;
import D7.C0370d;
import D7.C0379m;
import D7.o0;
import Ea.C0403l;
import F8.i;
import G8.h;
import G8.v;
import L8.g0;
import Wb.l;
import a8.b;
import a8.c;
import a9.RunnableC0537c;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.fragment.app.C0585a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.InterfaceC0601m;
import androidx.media3.session.N0;
import androidx.preference.Preference;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0913t;
import com.oplus.melody.common.util.O;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyListPanelFragment;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import ea.C1023b;
import g9.o;
import g9.s;
import g9.t;
import g9.u;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import s8.AbstractC1508a;
import t8.C1532B;
import u8.C1553a;

/* JADX INFO: loaded from: classes3.dex */
public class EqualizerItem extends MelodyUiCOUIJumpPreference implements g0 {
    public static final String ITEM_NAME = "EqualizerItem";
    private static final String TAG = "EqualizerItem";
    private COUIBottomSheetDialogFragment mBottomSheetDialogFragment;
    private final Context mContext;
    private String mCurrentEqualizerSummary;
    private List<b> mCustomEqList;
    private int mEqType;
    private List<WhitelistConfigDTO.EqualizerMode> mEqualizerModes;
    private u mEqualizerVO;
    private final Consumer<MelodyListPanelFragment.a> mItemChooseConsumer;
    private String mLastEqualizerSummary;
    private final InterfaceC0601m mLifecycleOwner;
    private MelodyListPanelFragment mPanelFragment;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private boolean mSupportBassEngine;
    private boolean mSupportCustomEq;
    private final DetailMainViewModel mViewModel;

    public EqualizerItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        h hVar = new h(this, 12);
        this.mItemChooseConsumer = hVar;
        this.mSetCommandFuture = null;
        this.mCurrentEqualizerSummary = "";
        this.mLastEqualizerSummary = "";
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(o.a(context, detailMainViewModel.f20400e, detailMainViewModel.f20398c));
        setSummaryTextColor(context.getColorStateList(R.color.melody_ui_preference_summary_blue_state_color));
        setOnPreferenceClickListener(new s(this, 0));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(detailMainViewModel.f20397b), new A6.b(9))).e(interfaceC0601m, new a(this, 21));
        C0379m.b(C0379m.g(AbstractC0939b.E().v(detailMainViewModel.f20397b), new f(15))).e(interfaceC0601m, new C1023b(this, 2));
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(detailMainViewModel.f20400e, detailMainViewModel.f20398c);
        if (whitelistConfigDTOC != null && whitelistConfigDTOC.getFunction().getBassEngineSupport() == 1) {
            detailMainViewModel.f(detailMainViewModel.f20397b).e(interfaceC0601m, new E9.a(this, 16));
        }
        boolean z2 = Settings.Global.getInt(context.getContentResolver(), "oplus_system_folding_mode", 0) == 1;
        Fragment fragment = (Fragment) Optional.ofNullable(detailMainViewModel.j()).map(new C0940c(19)).orElse(null);
        if (fragment instanceof COUIBottomSheetDialogFragment) {
            this.mBottomSheetDialogFragment = (COUIBottomSheetDialogFragment) fragment;
            if (!C0913t.a() || z2 == detailMainViewModel.f20598m) {
                A.b("EqualizerItem", "revert dialog fragment");
                C0370d.c(MelodyListPanelFragment.a.class, hVar);
                this.mBottomSheetDialogFragment.setOnDismissListener(new t(this, 0));
            } else {
                A.x("EqualizerItem", "EqualizerItem, foldDevice changed, foldOpen=" + z2 + ", old=" + detailMainViewModel.f20598m);
                FragmentManager fragmentManagerJ = detailMainViewModel.j();
                fragmentManagerJ.getClass();
                C0585a c0585a = new C0585a(fragmentManagerJ);
                c0585a.m(this.mBottomSheetDialogFragment);
                c0585a.h(true, true);
            }
        }
        detailMainViewModel.f20598m = z2;
    }

    private void initEqualizerPanelFragment() {
        if (this.mPanelFragment == null) {
            MelodyListPanelFragment melodyListPanelFragment = new MelodyListPanelFragment();
            this.mPanelFragment = melodyListPanelFragment;
            melodyListPanelFragment.v("EqualizerItem");
            C0370d.c(MelodyListPanelFragment.a.class, this.mItemChooseConsumer);
        }
        if (this.mEqualizerModes != null) {
            refreshEqualizerModeInfo();
            this.mPanelFragment.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void lambda$new$0(MelodyListPanelFragment.a aVar) {
        if ("EqualizerItem".equals(aVar.f21872b)) {
            onSelectItemClick(aVar.f21874d.get(), (String) aVar.f764a, aVar.f21873c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$1(Preference preference) {
        A.b("EqualizerItem", "click equalizer");
        u uVar = this.mEqualizerVO;
        if (uVar != null) {
            this.mEqualizerModes = uVar.getEqualizerModeList();
        }
        if (this.mSupportCustomEq || this.mSupportBassEngine) {
            E8.a.w().getClass();
            Jb.b<List<l<String, Class<?>>>> bVar = i.f1668g;
            i iVarA = i.a.a("/ui/custom_eq");
            iVarA.f("product_id", this.mViewModel.f20400e);
            iVarA.f("device_mac_info", this.mViewModel.f20397b);
            iVarA.f("device_name", this.mViewModel.f20398c);
            iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
            iVarA.b(this.mContext);
        } else {
            initEqualizerPanelFragment();
            showPanelFragment(this.mPanelFragment);
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.EQUALIZER.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$2(Boolean bool) {
        u uVar = this.mEqualizerVO;
        if (uVar == null || !uVar.getSupportCustomEq()) {
            return;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.mSupportCustomEq = zBooleanValue;
        hideJumpView((zBooleanValue || this.mSupportBassEngine) ? false : true);
        c.e().f(this.mViewModel.f20397b);
        C0379m.b(c.e().c(this.mViewModel.f20397b)).e(this.mLifecycleOwner, new A6.l(this, 25));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$3(List list) {
        boolean zK = N.k(1051, list);
        this.mSupportBassEngine = zK;
        hideJumpView((this.mSupportCustomEq || zK) ? false : true);
        if (this.mSupportBassEngine) {
            c.e().g(this.mViewModel.f20397b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Fragment lambda$new$4(FragmentManager fragmentManager) {
        return fragmentManager.D("EqualizerItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5() {
        C0370d.d(this.mItemChooseConsumer);
        this.mPanelFragment = null;
        this.mBottomSheetDialogFragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onEarphoneDataChanged$15(b bVar) {
        return bVar.getIsSelected() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onSelectItemClick$6(int i10) {
        return A6.b.d(i10, "onItemClick: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C1553a lambda$refreshEqualizerModeInfo$11(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        return (C1553a) C1532B.d(file, C1553a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void lambda$refreshEqualizerModeInfo$12(u8.C1553a r8, java.lang.Throwable r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L9f
            android.content.Context r9 = r7.getContext()
            com.oplus.melody.model.zipdata.MelodyResourceDO r0 = r8.getEqualizerDynaudio()
            java.lang.String r1 = r8.getRootPath()
            java.io.File r9 = com.oplus.drs.core.d.i(r9, r0, r1)
            android.content.Context r0 = r7.getContext()
            com.oplus.melody.model.zipdata.MelodyResourceDO r1 = r8.getEqualizerJoeHisaishi()
            java.lang.String r2 = r8.getRootPath()
            java.io.File r0 = com.oplus.drs.core.d.i(r0, r1, r2)
            if (r9 != 0) goto L26
            if (r0 == 0) goto L9f
        L26:
            android.content.Context r9 = r7.mContext
            java.util.List<com.oplus.melody.common.data.WhitelistConfigDTO$EqualizerMode> r0 = r7.mEqualizerModes
            com.oplus.melody.ui.component.detail.DetailMainViewModel r1 = r7.mViewModel
            java.lang.String r1 = r1.f20398c
            r2 = 0
            if (r9 == 0) goto L96
            if (r0 != 0) goto L34
            goto L96
        L34:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r0 = r0.iterator()
        L3d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L8d
            java.lang.Object r4 = r0.next()
            com.oplus.melody.common.data.WhitelistConfigDTO$EqualizerMode r4 = (com.oplus.melody.common.data.WhitelistConfigDTO.EqualizerMode) r4
            int r4 = r4.getModeType()
            r5 = 16
            if (r4 == r5) goto L55
            switch(r4) {
                case 5: goto L55;
                case 6: goto L55;
                case 7: goto L55;
                case 8: goto L55;
                case 9: goto L55;
                case 10: goto L55;
                default: goto L54;
            }
        L54:
            goto L88
        L55:
            java.lang.String r4 = "OPPO Enco X2"
            boolean r4 = r4.equals(r1)     // Catch: java.lang.Exception -> L6e
            if (r4 == 0) goto L70
            com.oplus.melody.model.zipdata.MelodyResourceDO r4 = r8.getEqualizerJoeHisaishi()     // Catch: java.lang.Exception -> L6e
            java.lang.String r5 = r8.getRootPath()     // Catch: java.lang.Exception -> L6e
            java.io.File r4 = com.oplus.drs.core.d.i(r9, r4, r5)     // Catch: java.lang.Exception -> L6e
            android.net.Uri r4 = android.net.Uri.fromFile(r4)     // Catch: java.lang.Exception -> L6e
            goto L89
        L6e:
            r4 = move-exception
            goto L81
        L70:
            com.oplus.melody.model.zipdata.MelodyResourceDO r4 = r8.getEqualizerDynaudio()     // Catch: java.lang.Exception -> L6e
            java.lang.String r5 = r8.getRootPath()     // Catch: java.lang.Exception -> L6e
            java.io.File r4 = com.oplus.drs.core.d.i(r9, r4, r5)     // Catch: java.lang.Exception -> L6e
            android.net.Uri r4 = android.net.Uri.fromFile(r4)     // Catch: java.lang.Exception -> L6e
            goto L89
        L81:
            java.lang.String r5 = "DeviceControlPreferenceUtils"
            java.lang.String r6 = "getEqualizerModePic, error: "
            com.oplus.melody.common.util.A.i(r5, r6, r4)
        L88:
            r4 = 0
        L89:
            r3.add(r4)
            goto L3d
        L8d:
            android.net.Uri[] r8 = new android.net.Uri[r2]
            java.lang.Object[] r8 = r3.toArray(r8)
            android.net.Uri[] r8 = (android.net.Uri[]) r8
            goto L98
        L96:
            android.net.Uri[] r8 = new android.net.Uri[r2]
        L98:
            com.oplus.melody.ui.widget.MelodyListPanelFragment r9 = r7.mPanelFragment
            if (r9 == 0) goto L9f
            r9.C(r8)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.equalizer.EqualizerItem.lambda$refreshEqualizerModeInfo$12(u8.a, java.lang.Throwable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setEqModeToDevice$10(Throwable th) {
        o0.d(new N0(this, 9));
        A.i("EqualizerItem", "set equalizer mode", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEqModeToDevice$7() {
        setStatusText1(this.mLastEqualizerSummary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$setEqModeToDevice$8(int i10, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO.getSetCommandStatus() != 0) {
            o0.d(new RunnableC0537c(this, 18));
            A.x("EqualizerItem", "set equalizer mode failed");
            return;
        }
        this.mLastEqualizerSummary = this.mCurrentEqualizerSummary;
        A.b("EqualizerItem", "set equalizer mode succeed");
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        String strT = N.t(detailMainViewModel.i(str2));
        List<WhitelistConfigDTO.EqualizerMode> list = this.mEqualizerModes;
        int modeType = 1;
        if (list != null) {
            Iterator<WhitelistConfigDTO.EqualizerMode> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WhitelistConfigDTO.EqualizerMode next = it.next();
                if (next.getProtocolIndex() == i10) {
                    modeType = next.getModeType();
                    break;
                }
            }
        }
        C1264t.v(str, str2, modeType, 0, strT, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEqModeToDevice$9() {
        setStatusText1(this.mLastEqualizerSummary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPanelFragment$13() {
        C0370d.d(this.mItemChooseConsumer);
        this.mPanelFragment = null;
        this.mBottomSheetDialogFragment = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPanelFragment$14(FragmentManager fragmentManager) {
        this.mBottomSheetDialogFragment.show(fragmentManager, "EqualizerItem");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$updateSummaryByCustomEq$16(b bVar) {
        return bVar.getIsSelected() == 1;
    }

    private void onSelectItemClick(MelodyListPanelFragment melodyListPanelFragment, String str, boolean z2) {
        if (this.mBottomSheetDialogFragment == null || melodyListPanelFragment == null) {
            A.h("EqualizerItem", "onSelectItemClick mBottomSheetDialogFragment is null return");
            return;
        }
        int iC = o.c(this.mContext, str, this.mViewModel.f20398c, this.mEqualizerModes);
        A.c("EqualizerItem", new O(iC, 7));
        this.mCurrentEqualizerSummary = str;
        setStatusText1(str);
        setEqModeToDevice(iC);
        Fragment parentFragment = melodyListPanelFragment.getParentFragment();
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            ((COUIBottomSheetDialogFragment) parentFragment).dismiss();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void refreshEqualizerModeInfo() {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.equalizer.EqualizerItem.refreshEqualizerModeInfo():void");
    }

    private void setEqModeToDevice(int i10) {
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureL0 = AbstractC0939b.E().l0(i10, this.mViewModel.f20397b);
        this.mSetCommandFuture = completableFutureL0;
        completableFutureL0.thenAccept((Consumer<? super SetCommandStateDTO>) new g9.h(this, i10, 1)).exceptionally((Function<Throwable, ? extends Void>) new C0403l(this, 19));
    }

    private void showPanelFragment(COUIPanelFragment cOUIPanelFragment) {
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment = this.mBottomSheetDialogFragment;
        if (cOUIBottomSheetDialogFragment != null && cOUIBottomSheetDialogFragment.isAdded()) {
            this.mBottomSheetDialogFragment.dismiss();
        }
        COUIBottomSheetDialogFragment cOUIBottomSheetDialogFragment2 = new COUIBottomSheetDialogFragment();
        this.mBottomSheetDialogFragment = cOUIBottomSheetDialogFragment2;
        cOUIBottomSheetDialogFragment2.setMainPanelFragment(cOUIPanelFragment);
        this.mBottomSheetDialogFragment.setOnDismissListener(new n(this, 27));
        Optional.ofNullable(this.mViewModel.j()).ifPresent(new C0368b(this, 20));
    }

    @Override // L8.g0
    public void onDestroy() {
        C0370d.d(this.mItemChooseConsumer);
    }

    public void onEarphoneDataChanged(u uVar) {
        this.mEqualizerVO = uVar;
        List<WhitelistConfigDTO.EqualizerMode> equalizerModeList = uVar.getEqualizerModeList();
        this.mEqualizerModes = equalizerModeList;
        this.mEqType = o.e(uVar.getType(), equalizerModeList);
        boolean z2 = false;
        setEnabled(uVar.getConnectionState() == 2);
        boolean z4 = this.mEqType != 0;
        List<b> list = this.mCustomEqList;
        if (list != null && list.stream().anyMatch(new v(3))) {
            z2 = true;
        }
        if (z4 == z2) {
            c.e().f(this.mViewModel.f20397b);
        }
        String strD = o.d(this.mContext, this.mEqType, this.mViewModel.f20398c);
        if (A.l()) {
            A.b("EqualizerItem", "onEarphoneDataChanged mEqType:" + this.mEqType + " name:" + strD + " protocolType:" + uVar.getType() + " selectedRecommend:" + z4 + " selectedCustom:" + z2 + " mEqualizerModes:" + this.mEqualizerModes);
        }
        if (!TextUtils.isEmpty(strD)) {
            setStatusText1(strD);
            this.mCurrentEqualizerSummary = strD;
            this.mLastEqualizerSummary = strD;
        }
        if (this.mBottomSheetDialogFragment == null || uVar.getConnectionState() == 2) {
            return;
        }
        this.mBottomSheetDialogFragment.dismiss();
    }

    public void updateSummaryByCustomEq(List<b> list) {
        boolean z2;
        if (list == null) {
            A.h("EqualizerItem", "updateSummaryByCustomEq list error");
            return;
        }
        this.mCustomEqList = list;
        Optional<b> optionalFindFirst = list.stream().filter(new A6.h(6)).findFirst();
        if (optionalFindFirst.isPresent()) {
            setStatusText1(optionalFindFirst.get().getName());
            z2 = true;
        } else {
            String strD = o.d(this.mContext, this.mEqType, this.mViewModel.f20398c);
            if (!TextUtils.isEmpty(strD)) {
                setStatusText1(strD);
            }
            z2 = false;
        }
        boolean z4 = this.mEqType != 0;
        if (z2 == z4) {
            c.e().h(this.mViewModel.f20397b);
        }
        if (A.l()) {
            A.b("EqualizerItem", "updateSummaryByCustomEq selectedRecommend:" + z4 + " selectedCustom:" + z2 + " mCustomEqList:" + this.mCustomEqList);
        }
    }

    @Override // L8.g0
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z2) {
    }
}
