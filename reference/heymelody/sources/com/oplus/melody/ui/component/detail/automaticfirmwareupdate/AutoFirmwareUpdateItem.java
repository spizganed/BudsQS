package com.oplus.melody.ui.component.detail.automaticfirmwareupdate;

import A6.l;
import A9.k;
import Aa.d;
import C6.e;
import Ca.n;
import D7.C0373g;
import D7.C0379m;
import D7.C0381o;
import D7.o0;
import D7.q0;
import E9.a;
import E9.h;
import E9.t;
import F8.i;
import F9.s;
import Jb.b;
import L8.g0;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.media3.session.D0;
import androidx.preference.Preference;
import c8.AbstractC0763a;
import com.heytap.headset.R;
import com.oplus.melody.common.helper.MelodyAlivePreferencesHelper;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0912s;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.DeviceVersionDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.firmware.FirmwareDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.automaticfirmwareupdate.AutoFirmwareUpdateItem;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import kc.C1264t;
import l9.C1286a;
import x3.C1656o;

/* JADX INFO: loaded from: classes3.dex */
public class AutoFirmwareUpdateItem extends MelodyUiCOUIJumpPreference implements g0 {
    private static final String FIRMWARE_UPDATE_GUIDE_CANCEL_CLICK = "2";
    private static final String FIRMWARE_UPDATE_GUIDE_EXPOSURE = "0";
    private static final String FIRMWARE_UPDATE_GUIDE_UPDATE_CLICK = "1";
    public static final String ITEM_NAME = "AutoFirmwareUpdateItem";
    private static final int NECK_VERSION_LENGTH = 1;
    private static final int TWS_VERSION_LENGTH = 3;
    private Context mContext;
    private C1286a mDeviceVersion;
    private Runnable mDialogDelayRunnable;
    private C0381o<Integer> mDialogFlagsLiveDataRecord;
    private FirmwareDTO mFirmwareVersion;
    private InterfaceC0601m mLifecycleOwner;
    private f mNewVersionDialog;
    private DetailMainViewModel mViewModel;

    public AutoFirmwareUpdateItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(R.string.melody_common_firmware_upgrade_title);
        setOnPreferenceClickListener(new s(this, 9));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.n(detailMainViewModel2.f20397b).e(this.mLifecycleOwner, new e(this, 11));
        C0379m.b(AbstractC0763a.e().c(this.mViewModel.f20397b)).e(this.mLifecycleOwner, new a(this, 5));
        DetailMainViewModel detailMainViewModel3 = this.mViewModel;
        AbstractC0939b.E().P(this.mContext, detailMainViewModel3.f20397b, detailMainViewModel3.f20398c);
        AbstractC0939b.E().U(this.mViewModel.f20397b);
        if (C0373g.d()) {
            this.mViewModel.k().e(this.mLifecycleOwner, new l(this, 9));
        }
    }

    private void addUpgradeTips(String str) {
        o0.c.f1143a.postDelayed(new d(9, this, str), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDetailFunction() {
        E8.a.w().getClass();
        b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/firmware_upgrade");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
        iVarA.b(this.mContext);
        C1286a c1286a = this.mDeviceVersion;
        if (c1286a != null) {
            DetailMainViewModel detailMainViewModel = this.mViewModel;
            C1264t.t(AppConstant$FunctionType.CHECK_UPDATE.getFunType(), detailMainViewModel.f20400e, detailMainViewModel.f20397b, getVersionStr(c1286a), String.valueOf(this.mDeviceVersion.isOtaAutoCheckOn() ? 1 : 0));
        }
    }

    private String getVersionStr(C1286a c1286a) {
        c1286a.getIsSpp();
        return N.u(c1286a.getEarphoneType(), c1286a.getDeviceVersionList(), c1286a.getHeadsetVersionList());
    }

    private boolean hasNewVersion() {
        C1286a c1286a;
        if (this.mFirmwareVersion != null && (c1286a = this.mDeviceVersion) != null && c1286a.isConnected() && this.mDeviceVersion.isVersionReceived()) {
            final String softwareVersion = this.mFirmwareVersion.getSoftwareVersion();
            final String strH = N.h(this.mDeviceVersion.getMacAddress(), this.mDeviceVersion.getDeviceVersionList());
            z = C0912s.b(softwareVersion, strH == null ? "" : strH) > 0;
            A.c(ITEM_NAME, new Supplier() { // from class: R8.b
                @Override // java.util.function.Supplier
                public final Object get() {
                    return AutoFirmwareUpdateItem.lambda$hasNewVersion$16(z, strH, softwareVersion);
                }
            });
        }
        return z;
    }

    private void hideNewVersionDialog() {
        A.b(ITEM_NAME, "hideNewVersionDialog");
        C0381o<Integer> c0381o = this.mDialogFlagsLiveDataRecord;
        if (c0381o != null) {
            c0381o.a();
            this.mDialogFlagsLiveDataRecord = null;
        }
        Runnable runnable = this.mDialogDelayRunnable;
        this.mDialogDelayRunnable = null;
        if (runnable != null) {
            o0.c.f1143a.removeCallbacks(runnable);
        }
        f fVar = this.mNewVersionDialog;
        this.mNewVersionDialog = null;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        fVar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addUpgradeTips$14(String str) {
        setSummary(this.mContext.getString(R.string.melody_common_firmware_find_new_version_summary, str));
        setEndRedDotMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$hasNewVersion$16(boolean z2, String str, String str2) {
        return "hasNewVersion: " + z2 + " deviceVersion=" + str + " newVersion=" + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lambda$new$0(Preference preference) {
        C1286a c1286a = this.mDeviceVersion;
        if (c1286a == null || !c1286a.isVersionReceived()) {
            return false;
        }
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f20397b, LeFilterConstants.FunType.FIRMWARE_UPDATE.getFunType(), new n(this, 6));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ EarphoneDTO lambda$new$1(String str) {
        return this.mViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        onEarphoneDataChanged(this.mDeviceVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$3(EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new t(this, 19));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$4(String str) {
        StringBuilder sbI = D0.i("getLeAudioSwitchStatusChanged, addr: ", str, ", vm.addr: ");
        sbI.append(this.mViewModel.f20397b);
        A.f(ITEM_NAME, sbI.toString());
        if (TextUtils.equals(str, this.mViewModel.f20397b)) {
            CompletableFuture.supplyAsync(new B9.f(4, this, str)).whenComplete((BiConsumer) new A9.s(this, 18));
        } else {
            A.x(ITEM_NAME, "getLeAudioSwitchStatusChanged addr not same");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEarphoneDataChanged$5(boolean z2) {
        if (z2) {
            setDisabled(true);
            setAllowClickWhenDisabled(this.mDeviceVersion.isConnected());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onFirmwareNewVersion$7(String str) {
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.FIRMWARE_UPDATE.getFunType(), new A9.f(4, this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeUpgradeTips$15() {
        setEndRedDotMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNewVersionDialog$10(DialogInterface dialogInterface) {
        A.b(ITEM_NAME, "showNewVersionDialog onDismiss");
        this.mViewModel.q(32, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$showNewVersionDialog$11(String str, String str2, DialogInterface dialogInterface) {
        A.b(ITEM_NAME, "showNewVersionDialog onCancel");
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        C1264t.t(AppConstant$FunctionType.FIRMWARE_UPGRADE_GUIDE.getFunType(), detailMainViewModel.f20400e, detailMainViewModel.f20397b, getVersionStr(this.mDeviceVersion), C1656o.a("2", str));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        detailMainViewModel2.getClass();
        A.x("DetailMainViewModel", "setFirmwareVersionIgnored " + str2);
        MelodyAlivePreferencesHelper.e().edit().putString(MelodyAlivePreferencesHelper.g(14, detailMainViewModel2.f20397b), str2).apply();
        hideNewVersionDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showNewVersionDialog$12(DialogInterface dialogInterface, int i10) {
        A.b(ITEM_NAME, "showNewVersionDialog onCancelClick");
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$showNewVersionDialog$13(String str, DialogInterface dialogInterface, int i10) {
        A.b(ITEM_NAME, "showNewVersionDialog onUpdateClick");
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        C1264t.t(AppConstant$FunctionType.FIRMWARE_UPGRADE_GUIDE.getFunType(), detailMainViewModel.f20400e, detailMainViewModel.f20397b, getVersionStr(this.mDeviceVersion), C1656o.a("1", str));
        E8.a.w().getClass();
        Jb.b<List<Wb.l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/firmware_upgrade");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.f("product_id", this.mViewModel.f20400e);
        iVarA.f("device_name", this.mViewModel.f20398c);
        iVarA.f("product_color", String.valueOf(this.mViewModel.f20401f));
        iVarA.f("auto_firmware_update", Boolean.toString(true));
        iVarA.b(this.mContext);
        hideNewVersionDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$showNewVersionDialog$9(String str) {
        return C1656o.a("showNewVersionDialog version=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNewVersionDialogDelayed$8(String str, boolean z2, Integer num) {
        if (num.intValue() == 0) {
            showNewVersionDialog(str, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirmwareNewVersion(FirmwareDTO firmwareDTO) {
        if (firmwareDTO == null || this.mDeviceVersion == null) {
            return;
        }
        this.mFirmwareVersion = firmwareDTO;
        if (!hasNewVersion()) {
            removeUpgradeTips();
            showCurrentVersion();
            hideNewVersionDialog();
            return;
        }
        String versionStr = getVersionStr(this.mDeviceVersion);
        StringBuilder sb2 = new StringBuilder();
        String strH = N.h(this.mViewModel.f20397b, this.mDeviceVersion.getDeviceVersionList());
        if (!TextUtils.isEmpty(versionStr) && strH != null) {
            String softwareVersion = firmwareDTO.getSoftwareVersion();
            if (Y.l(this.mDeviceVersion.getEarphoneType())) {
                sb2.append(N.d(softwareVersion));
            } else {
                String[] strArrSplit = versionStr.split("\\.");
                sb2.append(softwareVersion);
                sb2.append(".");
                sb2.append(softwareVersion);
                sb2.append(".");
                sb2.append(strArrSplit[2]);
            }
        }
        if (sb2.length() > 0) {
            String string = sb2.toString();
            addUpgradeTips(string);
            Runnable runnable = this.mDialogDelayRunnable;
            if (runnable != null) {
                o0.c.f1143a.removeCallbacks(runnable);
            }
            B6.b bVar = new B6.b(8, this, string);
            this.mDialogDelayRunnable = bVar;
            o0.c.f1143a.postDelayed(bVar, 500L);
        }
    }

    private void removeUpgradeTips() {
        o0.c.f1143a.postDelayed(new k(this, 22), 500L);
    }

    private void requestFirmwareInfo() {
        C1286a c1286a = this.mDeviceVersion;
        if (c1286a == null) {
            return;
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        detailMainViewModel.getClass();
        DeviceVersionDTO deviceVersionDTOI = N.i(detailMainViewModel.f20397b, c1286a.getIsSpp() ? c1286a.getDeviceVersionList() : c1286a.getHeadsetVersionList());
        if (deviceVersionDTOI == null) {
            q0.b(MelodyException.e(0, "mainVersion NOT_FOUND"));
            return;
        }
        String running = deviceVersionDTOI.getRunning();
        String str = running == null ? "" : running;
        String hardware = deviceVersionDTOI.getHardware();
        String str2 = hardware == null ? "" : hardware;
        String vendorCode = deviceVersionDTOI.getVendorCode();
        AbstractC0763a.e().l(detailMainViewModel.f20397b, detailMainViewModel.f20400e, str2, str, vendorCode == null ? "" : vendorCode);
    }

    private void showCurrentVersion() {
        C1286a c1286a = this.mDeviceVersion;
        if (c1286a == null) {
            return;
        }
        String versionStr = getVersionStr(c1286a);
        if (TextUtils.isEmpty(versionStr)) {
            return;
        }
        setSummary(this.mContext.getString(R.string.melody_common_firmware_current_version_summary, versionStr));
    }

    private void showNewVersionDialog(final String str, boolean z2) {
        C1286a c1286a = this.mDeviceVersion;
        if (c1286a == null || c1286a.isOtaBatteryLow()) {
            A6.b.g("showNewVersionDialog isOtaBatteryLow ", str, ITEM_NAME);
            return;
        }
        if (this.mDeviceVersion.isOtaAutoCheckOn()) {
            A6.b.g("showNewVersionDialog isOtaAutoCheckOn ", str, ITEM_NAME);
            return;
        }
        f fVar = this.mNewVersionDialog;
        if (fVar != null && fVar.isShowing()) {
            A6.b.g("showNewVersionDialog isShowing ", str, ITEM_NAME);
            return;
        }
        if (AbstractC0763a.e().i(this.mViewModel.f20397b)) {
            A6.b.g("showNewVersionDialog isUpgradeOrLoading ", str, ITEM_NAME);
            return;
        }
        if (z2) {
            A6.b.g("showNewVersionDialog LEA disabled ", str, ITEM_NAME);
            return;
        }
        if (TextUtils.equals(str, MelodyAlivePreferencesHelper.e().getString(MelodyAlivePreferencesHelper.g(14, this.mDeviceVersion.getMacAddress()), null))) {
            A6.b.g("showNewVersionDialog versionIgnored ", str, ITEM_NAME);
            return;
        }
        A.c(ITEM_NAME, new Ca.b(str, 9));
        final String str2 = ":" + this.mFirmwareVersion.getSoftwareVersion();
        String str3 = this.mContext.getString(R.string.melody_common_firmware_find_new_version_title) + ' ' + str + '\n' + this.mContext.getString(R.string.melody_common_firmware_find_new_version_dialog_message2);
        this.mViewModel.q(32, 32);
        G7.b bVar = new G7.b(this.mContext);
        bVar.n(R.string.melody_common_firmware_upgrade_title);
        bVar.g(str3);
        f fVarShow = bVar.setOnDismissListener(new Ca.f(this, 4)).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: R8.c
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f4573a.lambda$showNewVersionDialog$11(str2, str, dialogInterface);
            }
        }).setNegativeButton(R.string.melody_ui_common_cancel, new E9.l(1)).setPositiveButton(R.string.melody_common_firmware_find_new_version_dialog_update, new Ca.e(1, this, str2)).show();
        this.mNewVersionDialog = fVarShow;
        fVarShow.setCanceledOnTouchOutside(false);
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        C1264t.t(AppConstant$FunctionType.FIRMWARE_UPGRADE_GUIDE.getFunType(), detailMainViewModel.f20400e, detailMainViewModel.f20397b, getVersionStr(this.mDeviceVersion), C1656o.a("0", str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showNewVersionDialogDelayed, reason: merged with bridge method [inline-methods] */
    public void lambda$onFirmwareNewVersion$6(final String str, final boolean z2) {
        if (this.mViewModel.h() == 0) {
            showNewVersionDialog(str, z2);
            return;
        }
        hideNewVersionDialog();
        A.b(ITEM_NAME, "showNewVersionDialog wait for DialogFlags");
        this.mDialogFlagsLiveDataRecord = C0379m.j(this.mViewModel.f20595j, this.mLifecycleOwner, new v() { // from class: R8.a
            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                this.f4567a.lambda$showNewVersionDialogDelayed$8(str, z2, (Integer) obj);
            }
        });
    }

    @Override // L8.g0
    public void onDestroy() {
        hideNewVersionDialog();
    }

    public void onEarphoneDataChanged(C1286a c1286a) {
        this.mDeviceVersion = c1286a;
        if (hasNewVersion()) {
            onFirmwareNewVersion(this.mFirmwareVersion);
        } else {
            if (this.mDeviceVersion.isConnected()) {
                requestFirmwareInfo();
            }
            removeUpgradeTips();
            showCurrentVersion();
            hideNewVersionDialog();
        }
        setDisabled(!this.mDeviceVersion.isConnected());
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.FIRMWARE_UPDATE.getFunType(), new h(this, 6));
    }

    @Override // L8.g0
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z2) {
    }
}
