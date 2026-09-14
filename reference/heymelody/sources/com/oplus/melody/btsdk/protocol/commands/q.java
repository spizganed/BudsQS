package com.oplus.melody.btsdk.protocol.commands;

import com.oplus.melody.ui.component.fitdetection.FitDetectionFragment;
import com.oplus.melody.ui.component.hearingenhance.HearingEnhancementActivity;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19332b;

    public /* synthetic */ q(int i10, int i11) {
        this.f19331a = i11;
        this.f19332b = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i10 = this.f19332b;
        switch (this.f19331a) {
            case 0:
                return "Receive set switch feature response status = " + i10;
            case 1:
                return "Receive CMD_SET_ZEN_VERIFY_INFO_RSP response status = " + i10;
            case 2:
                return "getDensityFromSwitch sysDisplay = " + i10;
            case 3:
                return "showDownloadNotification progress=" + i10;
            case 4:
                return "ACTION_STATE_CHANGED, blueState " + i10;
            case 5:
                return "onTrackChanged " + i10;
            case 6:
                return "run setBassEngineValue " + i10;
            case 7:
                return "The status of commit confirm is " + i10;
            case 8:
                return "onCallStateChanged state = " + i10;
            case 9:
                int i11 = FitDetectionFragment.f21539a;
                return "onConnectionStateChanged, connectState: " + i10;
            case 10:
                return "BondStateChanged bondState = " + i10;
            case 11:
                return "onDeviceBondStateChanged bondState = " + i10;
            case 12:
                int i12 = HearingEnhancementActivity.f21566m0;
                return "onBluetoothStateChanged, state: " + i10;
            case 13:
                return "onConnectionStateChanged state = " + i10;
            case 14:
                return "handleSocketConnectException(), mSocketConState " + i10;
            case 15:
                return "handleCloseDataClientConnection, commandConnectionState is : " + i10;
            case 16:
                return "showSetPriorityDialog which = " + i10;
            case 17:
                return "onPlayerCommandRequest:" + i10;
            case 18:
                return "timeValue error: " + i10;
            case 19:
                return "onConnectionChanged: " + i10;
            default:
                return "convert spine activity detect error code " + i10;
        }
    }
}
