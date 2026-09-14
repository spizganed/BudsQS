package com.oplus.melody.btsdk.protocol.commands;

import com.oplus.melody.ui.component.multidevicesconnnect.MultipleDevicesConnectionActivity;
import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19319b;

    public /* synthetic */ k(int i10, int i11) {
        this.f19318a = i11;
        this.f19319b = i10;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i10 = this.f19319b;
        switch (this.f19318a) {
            case 0:
                return "setSpatialAudioType  complete, status = " + i10;
            case 1:
                return "setTapLevelSettingValue = " + i10;
            case 2:
                return "setVolumeValueInfo = " + i10;
            case 3:
                return "Receive find mode response status = " + i10;
            case 4:
                return "Receive set screen off broadcast delay time response status = " + i10;
            case 5:
                return "Receive set noise reduction response status = " + i10;
            case 6:
                return "Receive compactness detection response status = " + i10;
            case 7:
                return "setHeadsetSpatialType = " + i10;
            case 8:
                return "isCalling mode:" + i10;
            case 9:
                return "getLocalCompatibleType: melodyExist version=" + i10;
            case 10:
                return "onEarphoneGameModeChange gameMode = " + i10;
            case 11:
                return "isMelodySupportCombine versionCode = " + i10;
            case 12:
                return "requestUpdateCardDataFromMelody count: " + i10;
            case 13:
                return "handleRecvMultiSppCmdInfo, cmdNum: " + i10;
            case 14:
                return "downloadSceneV2 percent=" + i10;
            case 15:
                return "onReceive: blueState:" + i10;
            case 16:
                return "onAudioFocusChange focusChange = " + i10;
            case 17:
                return "ExitFindModeState setFindMode setCommandStatus = " + i10;
            case 18:
                return "onServiceConnected " + i10;
            case 19:
                return "closeProfileProxy: " + i10;
            case 20:
                return "calculateCurrentPercent " + i10;
            case 21:
                return "onCharacteristicRead mExecutingCommand is null, status = " + i10;
            case 22:
                int i11 = MultipleDevicesConnectionActivity.f21642V;
                return "openFragment firmWareVersion = " + i10;
            case 23:
                return "onConnectionConnected: state=" + i10;
            case 24:
                return "onConnectionStateChanged state = " + i10;
            case 25:
                return "handleDevicePreferenceClick handheldConnectionState = " + i10;
            case 26:
                return "setServiceTimerValue timeValue: " + i10;
            default:
                return "getSpeechMultiConversationSwitchFromCache cache result = " + i10;
        }
    }
}
