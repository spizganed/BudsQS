package com.oplus.melody.ui.component.detail.hearingenhancement;

import B9.f;
import D7.o0;
import E8.a;
import F8.i;
import Jb.b;
import W8.c;
import Wb.l;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.media3.session.D0;
import androidx.preference.Preference;
import c9.g;
import com.oplus.melody.common.util.A;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.db.HearingEnhancementEntity;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kc.C1264t;
import l9.C1286a;

/* JADX INFO: loaded from: classes3.dex */
public class HearingEnhancementItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "hearingEnhancement";
    public static final String TAG = "HearingEnhancementItem";
    private Context mContext;
    private List<HearingEnhancementEntity> mHearingList;
    private InterfaceC0601m mLifecycleOwner;
    private DetailMainViewModel mViewModel;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[PHI: r2
      0x0051: PHI (r2v3 int) = (r2v1 int), (r2v5 int) binds: [B:13:0x004f, B:9:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HearingEnhancementItem(android.content.Context r6, com.oplus.melody.ui.component.detail.DetailMainViewModel r7, androidx.lifecycle.InterfaceC0601m r8) {
        /*
            r5 = this;
            r5.<init>(r6)
            r5.mContext = r6
            r5.mViewModel = r7
            r5.mLifecycleOwner = r8
            java.lang.String r6 = r7.f20400e
            boolean r6 = com.oplus.melody.model.repository.earphone.N.o(r6)
            com.oplus.melody.ui.component.detail.DetailMainViewModel r7 = r5.mViewModel
            java.lang.String r7 = r7.f20398c
            s8.a r8 = s8.AbstractC1508a.f()
            r0 = 0
            com.oplus.melody.common.data.WhitelistConfigDTO r7 = r8.c(r0, r7)
            r8 = 2131886927(0x7f12034f, float:1.9408447E38)
            r0 = 2131887053(0x7f1203cd, float:1.9408702E38)
            r1 = 2131887815(0x7f1206c7, float:1.9410248E38)
            r2 = 2131887816(0x7f1206c8, float:1.941025E38)
            r3 = 2131887921(0x7f120731, float:1.9410463E38)
            if (r7 == 0) goto L4c
            com.oplus.melody.common.data.WhitelistConfigDTO$Function r7 = r7.getFunction()
            int r7 = r7.getEarScan()
            r4 = 0
            boolean r7 = com.oplus.melody.common.util.Y.e(r7, r4)
            if (r7 == 0) goto L46
            r6 = 2131886863(0x7f12030f, float:1.9408317E38)
            r1 = 2131886862(0x7f12030e, float:1.9408315E38)
            r7 = 2131886864(0x7f120310, float:1.9408319E38)
            goto L54
        L46:
            if (r6 == 0) goto L49
            r2 = r3
        L49:
            if (r6 == 0) goto L52
            goto L51
        L4c:
            if (r6 == 0) goto L4f
            r2 = r3
        L4f:
            if (r6 == 0) goto L52
        L51:
            r8 = r0
        L52:
            r7 = r8
            r6 = r2
        L54:
            r5.setTitle(r6)
            r5.setSummary(r1)
            W9.c r6 = new W9.c
            r8 = 4
            r6.<init>(r5, r7, r8)
            r5.setOnPreferenceClickListener(r6)
            com.oplus.melody.ui.component.detail.DetailMainViewModel r6 = r5.mViewModel
            java.lang.String r7 = r6.f20397b
            androidx.lifecycle.s r6 = r6.d(r7)
            androidx.lifecycle.m r7 = r5.mLifecycleOwner
            la.j0 r8 = new la.j0
            r0 = 8
            r8.<init>(r5, r0)
            r6.e(r7, r8)
            com.oplus.melody.ui.component.detail.DetailMainViewModel r6 = r5.mViewModel
            java.lang.String r7 = r6.f20397b
            androidx.lifecycle.s r6 = r6.n(r7)
            androidx.lifecycle.m r7 = r5.mLifecycleOwner
            m8.g r8 = new m8.g
            r0 = 5
            r8.<init>(r5, r0)
            r6.e(r7, r8)
            m4.e r6 = new m4.e
            r7 = 6
            r6.<init>(r5, r7)
            java.lang.String r7 = "HearingEnhancementItem"
            com.oplus.melody.common.util.A.c(r7, r6)
            Z7.a r6 = Z7.a.g()
            com.oplus.melody.ui.component.detail.DetailMainViewModel r7 = r5.mViewModel
            java.lang.String r8 = r7.f20400e
            int r7 = r7.f20401f
            r0 = 2
            r6.d(r7, r0, r8)
            boolean r6 = D7.C0373g.d()
            if (r6 == 0) goto Lba
            com.oplus.melody.ui.component.detail.DetailMainViewModel r6 = r5.mViewModel
            androidx.lifecycle.s r6 = r6.k()
            androidx.lifecycle.m r7 = r5.mLifecycleOwner
            s8.b r8 = new s8.b
            r0 = 2
            r8.<init>(r5, r0)
            r6.e(r7, r8)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.hearingenhancement.HearingEnhancementItem.<init>(android.content.Context, com.oplus.melody.ui.component.detail.DetailMainViewModel, androidx.lifecycle.m):void");
    }

    private void doDetailFunction(int i10, boolean z2) {
        a.w().getClass();
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/hearing_enhance");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
        iVarA.f("route_value", String.valueOf(i10));
        iVarA.f1670b.putExtra("route_value2", z2);
        iVarA.b(this.mContext);
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.HEARING_ENHANCE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(List list) {
        StringBuilder sb2 = new StringBuilder("setOnClickListener, hearingList=");
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(int i10, List list, Throwable th) {
        A.c(TAG, new D9.b(8, list));
        this.mHearingList = list;
        doDetailFunction(i10, (list == null || list.isEmpty()) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$2(final int i10) {
        List<HearingEnhancementEntity> list = this.mHearingList;
        if (list == null || list.isEmpty()) {
            com.oplus.melody.model.repository.hearingenhance.a.o().l(this.mViewModel.f20397b).whenCompleteAsync(new BiConsumer() { // from class: s9.a
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f27742a.lambda$new$1(i10, (List) obj, (Throwable) obj2);
                }
            }, (Executor) o0.c.f1144b);
        } else {
            doDetailFunction(i10, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$3(int i10, Preference preference) {
        A.b(TAG, "setOnClickListener");
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f20397b, LeFilterConstants.FunType.GOLD_HEARING.getFunType(), new c(this, i10, 6));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(C1286a c1286a) {
        if (c1286a == null || c1286a.getDeviceVersionList() == null) {
            A.b(TAG, "getVersionInfoList result null");
        } else {
            onEarphoneDataChanged(c1286a.isConnected() ? 2 : 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lambda$new$5() {
        return "HearingEnhancementItem pid=" + this.mViewModel.f20400e + " color=" + this.mViewModel.f20401f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EarphoneDTO lambda$new$6(String str) {
        return this.mViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$7(EarphoneDTO earphoneDTO) {
        onEarphoneDataChanged(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$8(EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new g0.i(15, this, earphoneDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$9(String str) {
        StringBuilder sbI = D0.i("getLeAudioSwitchStatusChanged, addr: ", str, ", vm.addr: ");
        sbI.append(this.mViewModel.f20397b);
        A.f(TAG, sbI.toString());
        if (TextUtils.equals(str, this.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new f(29, this, str)).whenComplete((BiConsumer) new g(this, 11));
        } else {
            A.x(TAG, "getLeAudioSwitchStatusChanged addr not same");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEarphoneDataChanged$10(int i10, boolean z2) {
        if (z2) {
            setDisabled(true);
            setAllowClickWhenDisabled(i10 == 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEarphoneDataChanged(int i10) {
        setDisabled(i10 != 2);
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.GOLD_HEARING.getFunType(), new E9.b(this, i10, 4));
    }
}
