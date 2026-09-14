package com.oplus.melody.common.util;

import com.oplus.melody.ui.component.detail.equalizer.EqualizerItem;
import com.oplus.melody.ui.component.finddevice.FindDeviceActivity;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class O implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19455b;

    public /* synthetic */ O(int i10, int i11) {
        this.f19454a = i11;
        this.f19455b = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i10 = this.f19455b;
        switch (this.f19454a) {
            case 0:
                return "showNotification run " + i10;
            case 1:
                return "getLocalCompatibleType: opsPods exist version=" + i10;
            case 2:
                return "onBluetoothStateChanged " + i10;
            case 3:
                return "downloadSceneV2 ALIVE percent=" + i10;
            case 4:
                int i11 = FindDeviceActivity.f21521U;
                return "onResume notificationId:" + i10;
            case 5:
                ArrayList<String> arrayList = fa.l.f23140Q;
                return "showConfirmDialog " + i10;
            case 6:
                return "Zenmode OTA finished for device, status " + i10;
            case 7:
                return EqualizerItem.lambda$onSelectItemClick$6(i10);
            case 8:
                return "m_bt_le.handleBondStateChanged, unbound: preState:" + i10;
            case 9:
                return "EnterFindModeState setFindMode setCommandStatus = " + i10;
            case 10:
                return "onServiceDisconnected " + i10;
            case 11:
                return "onServiceConnected " + i10;
            case 12:
                return "EVENT_ID_BT_CONNECTION_STATE connectState = " + i10;
            case 13:
                return "toggleEditMode, currentMode: " + i10;
            case 14:
                return g0.e.b(new StringBuilder("deleteCarouselDress id:"), i10, " not found");
            case 15:
                return "isSpeechAssistHasMultiConversationSwitchFromCache cache result = " + i10;
            default:
                return "convert health error code " + i10;
        }
    }
}
