package com.oplus.melody.btsdk.multidevice;

import D1.f;
import D7.C0370d;
import D7.C0371e;
import D7.C0372f;
import D7.C0388w;
import D7.C0391z;
import D7.J;
import D7.L;
import D7.Q;
import D7.RunnableC0369c;
import D7.Y;
import D7.f0;
import D7.m0;
import D7.o0;
import Ea.D;
import Ea.G;
import L8.C0456c;
import O7.o;
import X3.l;
import Y6.a;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.session.D0;
import b7.c;
import b7.d;
import c7.C0762a;
import com.oplus.melody.btsdk.api.data.BassEngineInfo;
import com.oplus.melody.btsdk.api.data.BluetoothReceiveData;
import com.oplus.melody.btsdk.api.data.CurrentNoiseModeInfo;
import com.oplus.melody.btsdk.api.data.DebugDataInfo;
import com.oplus.melody.btsdk.api.data.DebugFeatureInfo;
import com.oplus.melody.btsdk.api.data.DebugModuleInfo;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.data.DiagnosisJsonDataInfo;
import com.oplus.melody.btsdk.api.data.EarRestoreDataInfo;
import com.oplus.melody.btsdk.api.data.EqInfo;
import com.oplus.melody.btsdk.api.data.EqualizerModeInfo;
import com.oplus.melody.btsdk.api.data.FeatureSwitchInfo;
import com.oplus.melody.btsdk.api.data.GameSoundInfo;
import com.oplus.melody.btsdk.api.data.HandheldDeviceInfo;
import com.oplus.melody.btsdk.api.data.HeadMotionTryResult;
import com.oplus.melody.btsdk.api.data.HeadsetTipInfo;
import com.oplus.melody.btsdk.api.data.HearingDetectingInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhanceEarScanStatusInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhanceFreqPacketInfo;
import com.oplus.melody.btsdk.api.data.HearingEnhancementEarScanResult;
import com.oplus.melody.btsdk.api.data.HearingEnhancementInfo;
import com.oplus.melody.btsdk.api.data.HearingStatusInfo;
import com.oplus.melody.btsdk.api.data.IntelligentNoiseModeInfo;
import com.oplus.melody.btsdk.api.data.InterruptInfo;
import com.oplus.melody.btsdk.api.data.KeyFunctionInfo;
import com.oplus.melody.btsdk.api.data.MultiConnectInformations;
import com.oplus.melody.btsdk.api.data.NoiseReductionInfo;
import com.oplus.melody.btsdk.api.data.OneshotAudioDataInfo;
import com.oplus.melody.btsdk.api.data.OneshotEncodeState;
import com.oplus.melody.btsdk.api.data.OneshotExeResultInfo;
import com.oplus.melody.btsdk.api.data.OneshotStateInfo;
import com.oplus.melody.btsdk.api.data.PersonalizedNoiseReductionResult;
import com.oplus.melody.btsdk.api.data.PersonalizedNoiseReductionResultExist;
import com.oplus.melody.btsdk.api.data.RelatedDevice;
import com.oplus.melody.btsdk.api.data.RelatedDeviceInfo;
import com.oplus.melody.btsdk.api.data.SimpleStateInfo;
import com.oplus.melody.btsdk.api.data.ToneFileVertifyInformation;
import com.oplus.melody.btsdk.api.data.TriangleInfo;
import com.oplus.melody.btsdk.api.data.UpgradeStateInfo;
import com.oplus.melody.btsdk.api.data.ZenModeFileInformation;
import com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation;
import com.oplus.melody.btsdk.api.manager.DeviceInfoManager;
import com.oplus.melody.btsdk.manager.ZenModeUpgradeListener;
import com.oplus.melody.btsdk.ota.IUpgradeListener;
import com.oplus.melody.btsdk.protocol.SDKException;
import com.oplus.melody.btsdk.protocol.commands.TapLevelSettingInfo;
import com.oplus.melody.btsdk.protocol.commands.UserInteractionEventInfo;
import com.oplus.melody.btsdk.protocol.commands.g;
import com.oplus.melody.btsdk.protocol.commands.history.ConnectDevicesInfo;
import com.oplus.melody.btsdk.protocol.commands.i;
import com.oplus.melody.btsdk.protocol.commands.j;
import com.oplus.melody.btsdk.protocol.commands.k;
import com.oplus.melody.btsdk.protocol.commands.n;
import com.oplus.melody.btsdk.protocol.commands.p;
import com.oplus.melody.btsdk.protocol.commands.r;
import com.oplus.melody.btsdk.protocol.commands.s;
import com.oplus.melody.btsdk.protocol.commands.t;
import com.oplus.melody.btsdk.protocol.upgrade.UpgradeManager;
import com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.common.util.S;
import f7.C1046a;
import f7.C1047b;
import h7.C1090a;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import k7.h;
import m7.C1329b;
import m7.InterfaceC1328a;
import t7.AbstractC1530a;
import z7.C1725a;
import z7.C1726b;
import z7.C1727c;

/* JADX INFO: loaded from: classes.dex */
public class HeadsetCoreService implements IUpgradeListener {
    private BluetoothAdapter mBluetoothAdapter;
    private final t7.b mCallback;
    private final AbstractC1530a mConnectionStateListener;
    private Context mContext;
    private long mCostTime;
    private C0762a mDebugCommandManager;
    private InterfaceC1328a mDeviceConnectionApi;
    private DeviceInfoManager mDeviceInfoManager;
    private HandlerThread mHandlerThread;
    private final Set<Integer> mNoGetStateSet;
    private g mNotificationCommandManager;
    private C1047b mPacketFactory;
    private b7.c mPacketTimeoutProcessor;
    private U6.d mPluginContext;
    private final List<U6.c> mPlugins;
    private i mPollCommandManager;
    private b7.d mProtocolManager;
    private j mRequestCommandManager;
    private s mSetCommandManager;
    private final IUpgradeListener mToneUpgradeListener;
    private UpgradeManager mUpgradeManager;
    private t mUpgradePropertyProcessor;
    private e mWorkHandler;
    private ZenModeOTAManager mZenModeManager;

    public static final class ToneUpgradeListener implements IUpgradeListener {
        private final WeakReference<HeadsetCoreService> mService;

        public ToneUpgradeListener(HeadsetCoreService headsetCoreService) {
            this.mService = new WeakReference<>(headsetCoreService);
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void S(int i10, String str) {
            HeadsetCoreService headsetCoreService;
            C1725a.c("HeadsetCoreService", new Ba.b(i10, 18));
            UpgradeStateInfo upgradeStateInfo = new UpgradeStateInfo();
            upgradeStateInfo.mAddress = str;
            upgradeStateInfo.mUpgradeState = 1048587;
            upgradeStateInfo.mUpgradeFinishStatus = i10;
            BluetoothReceiveData bluetoothReceiveData = new BluetoothReceiveData(1048587, upgradeStateInfo);
            if (this.mService.get() != null) {
                HeadsetCoreService.m0(bluetoothReceiveData);
            }
            if (i10 == 0 || (headsetCoreService = this.mService.get()) == null) {
                return;
            }
            headsetCoreService.N(str);
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void b(int i10, String str) {
            C1725a.c("HeadsetCoreService", new Y(i10, 17));
            UpgradeStateInfo upgradeStateInfo = new UpgradeStateInfo();
            upgradeStateInfo.mAddress = str;
            upgradeStateInfo.mUpgradeState = 1048586;
            upgradeStateInfo.mUpgradePercent = i10;
            BluetoothReceiveData bluetoothReceiveData = new BluetoothReceiveData(1048586, upgradeStateInfo);
            if (this.mService.get() != null) {
                HeadsetCoreService.m0(bluetoothReceiveData);
            }
        }

        @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
        public final void c(String str) {
            C1725a.c("HeadsetCoreService", new C0371e(7));
            UpgradeStateInfo upgradeStateInfo = new UpgradeStateInfo();
            upgradeStateInfo.mAddress = str;
            upgradeStateInfo.mUpgradeState = 1048585;
            BluetoothReceiveData bluetoothReceiveData = new BluetoothReceiveData(1048585, upgradeStateInfo);
            if (this.mService.get() != null) {
                HeadsetCoreService.m0(bluetoothReceiveData);
            }
        }
    }

    public class a extends U6.d {
    }

    public class b implements t7.b {
        public b() {
        }

        @Override // t7.b
        public final void a(DeviceInfo deviceInfo, byte[] bArr) {
            C1046a c1046a;
            HeadsetCoreService.this.mPacketFactory.getClass();
            try {
                c1046a = new C1046a(bArr);
            } catch (SDKException e10) {
                C1725a.c("PacketFactory", new l(e10, 22));
                c1046a = null;
            }
            if (c1046a == null) {
                C1725a.f("HeadsetCoreService", "onMessageReceived packet not valid");
                return;
            }
            String deviceAddress = deviceInfo.getDeviceAddress();
            b7.c cVar = HeadsetCoreService.this.mPacketTimeoutProcessor;
            cVar.getClass();
            if (!BluetoothAdapter.checkBluetoothAddress(deviceAddress)) {
                C1725a.f("PacketTimeoutProcessor", "onReceivePacket: params is invalid");
            } else if ((c1046a.f23110a & 32768) != 0) {
                synchronized (cVar.f13060a) {
                    try {
                        SparseArray<c.a> sparseArray = cVar.f13060a.get(deviceAddress);
                        if (sparseArray == null) {
                            C1725a.b("PacketTimeoutProcessor", "onReceivePacket: address not found", deviceAddress);
                        } else {
                            synchronized (sparseArray) {
                                try {
                                    int iIndexOfKey = sparseArray.indexOfKey(c1046a.a());
                                    if (iIndexOfKey < 0) {
                                        C1725a.d("PacketTimeoutProcessor", new b7.b(c1046a, 0), deviceAddress);
                                    } else {
                                        c.a aVarValueAt = sparseArray.valueAt(iIndexOfKey);
                                        sparseArray.removeAt(iIndexOfKey);
                                        c1046a.toString();
                                        cVar.f13061b.removeCallbacks(aVarValueAt);
                                    }
                                } finally {
                                }
                            }
                        }
                    } finally {
                    }
                }
            } else {
                c1046a.toString();
            }
            HeadsetCoreService.this.j0(deviceAddress, c1046a);
        }
    }

    public class c extends AbstractC1530a {
        public c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0132  */
        @Override // t7.AbstractC1530a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(com.oplus.melody.btsdk.api.data.DeviceInfo r8, int r9, int r10, boolean r11) {
            /*
                Method dump skipped, instruction units count: 457
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.multidevice.HeadsetCoreService.c.a(com.oplus.melody.btsdk.api.data.DeviceInfo, int, int, boolean):void");
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HeadsetCoreService f19289a = new HeadsetCoreService(0);
    }

    public static class e extends Handler {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f19290d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<HeadsetCoreService> f19291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final U6.a f19292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Z6.g f19293c;

        public e(HeadsetCoreService headsetCoreService, Looper looper) {
            super(looper);
            this.f19291a = new WeakReference<>(headsetCoreService);
            this.f19292b = U6.a.b(headsetCoreService.F());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int iH;
            BluetoothDevice bluetoothDeviceB;
            int i10;
            BluetoothDevice bluetoothDeviceB2;
            int i11 = 8;
            int i12 = 10;
            boolean zMatches = false;
            Object[] objArr = 0;
            HeadsetCoreService headsetCoreService = this.f19291a.get();
            if (headsetCoreService == null) {
                return;
            }
            int i13 = message.what;
            if (i13 == 1) {
                A7.b.f86a.getClass();
                if (!A7.b.b()) {
                    if (this.f19293c == null) {
                        Z6.g gVar = new Z6.g(this);
                        this.f19293c = gVar;
                        A7.b.c(gVar);
                        return;
                    }
                    return;
                }
                C0391z c0391z = C0391z.f1171d;
                c0391z.getClass();
                if (!C0391z.m()) {
                    C1725a.f("HeadsetCoreService", "bluetooth not open ,when check device connect state!");
                    return;
                }
                Set<BluetoothDevice> setD = c0391z.d(headsetCoreService.mBluetoothAdapter);
                if (setD == null || setD.isEmpty()) {
                    C1725a.a("HeadsetCoreService", "Null when get bonded devices.");
                    return;
                }
                U6.a aVar = this.f19292b;
                aVar.d("isAnyProfileInitialized");
                if (aVar.f5170c.size() <= 0) {
                    C1725a.l("HeadsetCoreService", "Profiles has not been initialize complete, delay the message");
                    if (hasMessages(1)) {
                        return;
                    }
                    int i14 = message.arg1;
                    sendMessageDelayed(obtainMessage(1, i14 + 1, 0), i14 > 10 ? 5000L : 1000L);
                    return;
                }
                C1725a.a("HeadsetCoreService", "Start to connect device if needed.");
                DeviceInfo deviceInfo = null;
                for (BluetoothDevice bluetoothDeviceB3 : setD) {
                    if (bluetoothDeviceB3 != null && (!W6.b.k(bluetoothDeviceB3.getAddress()) || (bluetoothDeviceB3 = W6.b.b(bluetoothDeviceB3.getAddress())) != null)) {
                        String address = bluetoothDeviceB3.getAddress();
                        DeviceInfoManager deviceInfoManager = DeviceInfoManager.a.f19280a;
                        deviceInfoManager.getClass();
                        Y6.a aVar2 = a.C0090a.f6690a;
                        WhitelistConfigDTO whitelistConfigDTOB = com.oplus.melody.common.util.Y.b(bluetoothDeviceB3, aVar2.b());
                        deviceInfoManager.a(whitelistConfigDTOB != null ? f.m(whitelistConfigDTOB.getId()) : 0, bluetoothDeviceB3);
                        C1725a.b("HeadsetCoreService", "MSG_CHECK_AND_CONNECT_TO_DEVICE Start to connect device if needed.", address);
                        DeviceInfo deviceInfoF = deviceInfoManager.f(address);
                        if (this.f19292b.e(bluetoothDeviceB3)) {
                            deviceInfoManager.getClass();
                            DeviceInfoManager.d(deviceInfoF);
                            WhitelistConfigDTO whitelistConfigDTOB2 = com.oplus.melody.common.util.Y.b(bluetoothDeviceB3, aVar2.b());
                            if (whitelistConfigDTOB2 != null && whitelistConfigDTOB2.getSupportSpp()) {
                                headsetCoreService.u(address);
                            }
                        } else {
                            C1725a.c("HeadsetCoreService", new C8.a(address, 17));
                        }
                        deviceInfo = deviceInfoF;
                    }
                }
                if (deviceInfo == null) {
                    C1725a.a("HeadsetCoreService", "device not found");
                    return;
                } else {
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048577, deviceInfo));
                    return;
                }
            }
            if (i13 == 2) {
                String address2 = (String) message.obj;
                if (!BluetoothAdapter.checkBluetoothAddress(address2)) {
                    C1725a.m("HeadsetCoreService", "MSG_CONNECT_TO_DEVICE address is invalid", address2);
                    return;
                }
                if (!S.x(C0906l.f19501a)) {
                    C1725a.m("HeadsetCoreService", "MSG_CONNECT_TO_DEVICE background user process", address2);
                    return;
                }
                C0391z.f1171d.getClass();
                if (!C0391z.m()) {
                    C1725a.m("HeadsetCoreService", "MSG_CONNECT_TO_DEVICE bluetooth not open, when connect device!", address2);
                    return;
                }
                U6.a aVar3 = this.f19292b;
                aVar3.d("isAnyProfileInitialized");
                if (aVar3.f5170c.size() <= 0) {
                    sendMessageDelayed(obtainMessage(2, message.obj), 1000L);
                    return;
                }
                if (W6.b.k(address2) && (bluetoothDeviceB = W6.b.b(address2)) != null) {
                    address2 = bluetoothDeviceB.getAddress();
                }
                DeviceInfo deviceInfoF2 = headsetCoreService.mDeviceInfoManager.f(address2);
                if (deviceInfoF2 == null) {
                    C1725a.b("HeadsetCoreService", "Can't get the device information when connect to device", address2);
                    return;
                }
                WhitelistConfigDTO whitelistConfigDTOA = a.C0090a.f6690a.a(address2);
                if (whitelistConfigDTOA == null || !whitelistConfigDTOA.getSupportSpp()) {
                    C1725a.b("HeadsetCoreService", "not support spp , return", address2);
                    return;
                }
                if (!this.f19292b.f(address2)) {
                    C1725a.b("HeadsetCoreService", "profile not connected, abort", address2);
                    return;
                }
                if (C1726b.a(headsetCoreService.F())) {
                    h hVar = h.e.f25190a;
                    String deviceName = deviceInfoF2.getDeviceName();
                    hVar.getClass();
                    if (h.f(deviceName) || W6.b.j(address2)) {
                        C1725a.b("HeadsetCoreService", "pods support, refuse heymelody spp connect.", address2);
                        return;
                    }
                }
                if (W6.b.j(address2) || !((iH = headsetCoreService.H(address2)) == 2 || iH == 1)) {
                    Jb.b bVar = m0.f1129a;
                    if (m0.a(deviceInfoF2.getDevice())) {
                        C1725a.m("HeadsetCoreService", "shareAudio,No need to connect to SPP", address2);
                        return;
                    } else {
                        C1725a.m("HeadsetCoreService", "m_bt_le.Start to connect to device ", address2);
                        ((C1329b) headsetCoreService.mDeviceConnectionApi).b(deviceInfoF2);
                        return;
                    }
                }
                int deviceConnectState = deviceInfoF2.getDeviceConnectState();
                if (iH == deviceConnectState) {
                    C1725a.m("HeadsetCoreService", "Abort connect, the device state is already " + iH, address2);
                    return;
                } else {
                    HeadsetCoreService.o(headsetCoreService, deviceInfoF2, iH);
                    C1725a.m("HeadsetCoreService", "Abort connect, the device state notify from " + deviceConnectState + " to " + iH, address2);
                    return;
                }
            }
            if (i13 == 3) {
                String str = (String) message.obj;
                DeviceInfo deviceInfoF3 = headsetCoreService.mDeviceInfoManager.f(str);
                if (deviceInfoF3 == null) {
                    return;
                }
                if (message.arg1 != 1 && this.f19292b.f(str)) {
                    C1725a.b("HeadsetCoreService", "There's also profile connected for this device, do not disconnect.", str);
                    return;
                } else {
                    C1725a.m("HeadsetCoreService", "m_bt_le.disconnect from device", str);
                    ((C1329b) headsetCoreService.mDeviceConnectionApi).a(deviceInfoF3);
                    return;
                }
            }
            switch (i13) {
                case 7:
                    String str2 = (String) message.obj;
                    headsetCoreService.mNotificationCommandManager.a(str2);
                    headsetCoreService.mUpgradePropertyProcessor.b(str2);
                    DeviceInfo deviceInfoF4 = headsetCoreService.mDeviceInfoManager.f(str2);
                    if (deviceInfoF4 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_COMMAND_CAPABILITY_INIT_COMPLETE deviceInfo is null");
                    } else {
                        Set<Integer> setA = b7.d.b().a(str2);
                        if (setA == null || setA.isEmpty()) {
                            C1725a.f("HeadsetCoreService", "capability deviceInfo is null");
                        } else {
                            ArrayList arrayList = new ArrayList(setA);
                            Collections.sort(arrayList);
                            deviceInfoF4.setCapability(Collections.unmodifiableList(arrayList));
                            HeadsetCoreService.m0(new BluetoothReceiveData(1048649, deviceInfoF4));
                        }
                    }
                    break;
                case 8:
                    Object obj = message.obj;
                    if (obj instanceof SimpleStateInfo) {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048692, (SimpleStateInfo) obj));
                    } else {
                        A.f("HeadsetCoreService", "MSG_START_FREE_MUSIC unknown obj " + message.obj);
                    }
                    break;
                case 9:
                    Pair pair = (Pair) message.obj;
                    DeviceInfo deviceInfoF5 = headsetCoreService.mDeviceInfoManager.f((String) pair.first);
                    if (deviceInfoF5 != null) {
                        C1725a.e("HeadsetCoreService", "MSG_RECEIVE_REMOTE_VERSION left version = " + C1727c.b((List) pair.second) + ", right version =" + C1727c.c((List) pair.second));
                        deviceInfoF5.setVersionInfo((List) pair.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048599, deviceInfoF5));
                    } else {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_REMOTE_VERSION deviceInfo is null");
                    }
                    break;
                case 10:
                    Pair pair2 = (Pair) message.obj;
                    o0.b().execute(new H1.b(headsetCoreService, (String) pair2.first, (List) pair2.second, 3));
                    break;
                case 11:
                    Pair pair3 = (Pair) message.obj;
                    DeviceInfo deviceInfoF6 = headsetCoreService.mDeviceInfoManager.f((String) pair3.first);
                    if (deviceInfoF6 != null) {
                        deviceInfoF6.setKeyFunctions((List) pair3.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048602, deviceInfoF6));
                    } else {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_KEY_FUNCTION_INFO is null");
                    }
                    break;
                case 12:
                    Pair pair4 = (Pair) message.obj;
                    DeviceInfo deviceInfoF7 = headsetCoreService.mDeviceInfoManager.f((String) pair4.first);
                    if (deviceInfoF7 != null) {
                        deviceInfoF7.setStatusInfo((List) pair4.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048598, deviceInfoF7));
                    } else {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_EARBUDS_STATUS deviceInfo is null");
                    }
                    break;
                case 13:
                    Pair pair5 = (Pair) message.obj;
                    DeviceInfo deviceInfoF8 = headsetCoreService.mDeviceInfoManager.f((String) pair5.first);
                    if (deviceInfoF8 != null) {
                        deviceInfoF8.setUpgradeInfo((List) pair5.second);
                        headsetCoreService.mUpgradePropertyProcessor.a((String) pair5.first, (List) pair5.second);
                    } else {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_UPGRADE_CAPABILITIES deviceInfo is null");
                    }
                    break;
                case 14:
                    DeviceInfo deviceInfoF9 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF9 == null) {
                        C1725a.g("HeadsetCoreService", "MSG_RECEIVE_REMOTE_MTU Can't find the device ", (String) message.obj);
                    } else {
                        C1725a.c("HeadsetCoreService", new o(z ? 1 : 0, message));
                        deviceInfoF9.setMTU(message.arg1);
                    }
                    break;
                case 15:
                    DeviceInfo deviceInfoF10 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF10 != null) {
                        deviceInfoF10.getUpgradeInfo();
                    } else {
                        C1725a.f("HeadsetCoreService", "MSG_UPGRADE_PROPERTY_AVAILABLE deviceInfo is null");
                    }
                    break;
                case 16:
                    Set<BluetoothDevice> setD2 = C0391z.f1171d.d(headsetCoreService.mBluetoothAdapter);
                    if (setD2 == null) {
                        C1725a.f("HeadsetCoreService", "Null when get bonded devices.");
                    } else {
                        C1725a.c("HeadsetCoreService", new Z6.e(objArr == true ? 1 : 0, message));
                        Iterator<BluetoothDevice> it = setD2.iterator();
                        while (it.hasNext() && headsetCoreService.H(it.next().getAddress()) == 2) {
                            C1725a.a("HeadsetCoreService", "MSG_RECEIVE_OTA_BIN");
                        }
                    }
                    break;
                case 17:
                    DeviceInfo deviceInfoF11 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF11 == null) {
                        C1725a.g("HeadsetCoreService", "MSG_RECEIVE_COLOR_ID Can't find the deviceInfo ", (String) message.obj);
                    } else {
                        C1725a.c("HeadsetCoreService", new J(1, message));
                        deviceInfoF11.setColorId(message.arg1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048614, deviceInfoF11));
                    }
                    break;
                case 18:
                    Pair pair6 = (Pair) message.obj;
                    DeviceInfo deviceInfoF12 = headsetCoreService.mDeviceInfoManager.f((String) pair6.first);
                    if (deviceInfoF12 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_FEATURE_SWITCH_STATUS, Can't find the featureDeviceInfo ");
                    } else {
                        List<FeatureSwitchInfo> featureSwitchInfo = deviceInfoF12.getFeatureSwitchInfo();
                        if (featureSwitchInfo == null) {
                            featureSwitchInfo = Collections.EMPTY_LIST;
                        }
                        ArrayList arrayList2 = new ArrayList(featureSwitchInfo);
                        arrayList2.removeIf(new Z6.f(pair6, 0));
                        Object obj2 = pair6.second;
                        if (obj2 != null) {
                            arrayList2.addAll((Collection) obj2);
                        }
                        deviceInfoF12.setFeatureSwitchInfo(arrayList2);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048601, deviceInfoF12));
                    }
                    break;
                case 19:
                    Pair pair7 = (Pair) message.obj;
                    DeviceInfo deviceInfoF13 = headsetCoreService.mDeviceInfoManager.f((String) pair7.first);
                    if (deviceInfoF13 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_USER_INTERACTION_EVENT Can't find the deviceInfo ");
                    } else {
                        deviceInfoF13.setUserInteractionEventInfo((UserInteractionEventInfo) pair7.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048620, deviceInfoF13));
                    }
                    break;
                case 20:
                    Pair pair8 = (Pair) message.obj;
                    DeviceInfo deviceInfoF14 = headsetCoreService.mDeviceInfoManager.f((String) pair8.first);
                    if (deviceInfoF14 == null) {
                        C1725a.f("HeadsetCoreService", "Can't find the deviceInfo ");
                    } else {
                        NoiseReductionInfo noiseReductionInfo = (NoiseReductionInfo) pair8.second;
                        int type = noiseReductionInfo.getType();
                        if (type == 1) {
                            deviceInfoF14.setSwitchNoiseReductionInfo(noiseReductionInfo);
                        } else if (type == 3) {
                            deviceInfoF14.setSwitchLeftEarNoiseReductionInfo(noiseReductionInfo);
                        } else if (type == 4) {
                            deviceInfoF14.setSwitchRightEarNoiseReductionInfo(noiseReductionInfo);
                        }
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048604, deviceInfoF14));
                    }
                    break;
                case 21:
                    Pair pair9 = (Pair) message.obj;
                    DeviceInfo deviceInfoF15 = headsetCoreService.mDeviceInfoManager.f((String) pair9.first);
                    if (deviceInfoF15 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_COMPACTNESS_DETECTION_EVENT Can't find the deviceInfo ");
                    } else {
                        deviceInfoF15.setCompactnessDetectionInfo((List) pair9.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048603, deviceInfoF15));
                    }
                    break;
                case 22:
                    C1725a.c("HeadsetCoreService", new o(2, message));
                    DeviceInfo deviceInfoF16 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    int i15 = message.arg1;
                    if (deviceInfoF16 != null && !TextUtils.isEmpty(deviceInfoF16.getDeviceName())) {
                        String deviceName2 = deviceInfoF16.getDeviceName();
                        if (deviceName2 == null) {
                            deviceName2 = "";
                        }
                        switch (deviceName2) {
                            case "OPPO Enco M32":
                                i10 = 329744;
                                break;
                            case "OPPO Enco W31":
                                i10 = 395280;
                                break;
                            case "OPPO Enco W31 Lite":
                                i10 = 404496;
                                break;
                            default:
                                i10 = i15;
                                break;
                        }
                        if (i15 != i10) {
                            C1725a.l("HeadsetCoreService", "MSG_RECEIVE_REMOTE_PRODUCT_ID " + f.M(i15) + " > " + f.M(i10));
                            i15 = i10;
                        }
                    }
                    headsetCoreService.mDeviceInfoManager.h(i15, (String) message.obj);
                    break;
                case 23:
                    Pair pair10 = (Pair) message.obj;
                    DeviceInfo deviceInfoF17 = headsetCoreService.mDeviceInfoManager.f((String) pair10.first);
                    if (deviceInfoF17 == null) {
                        C1725a.f("HeadsetCoreService", "Can't find the deviceInfo ");
                    } else {
                        deviceInfoF17.setCurrentNoiseModeInfo((CurrentNoiseModeInfo) pair10.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048616, deviceInfoF17));
                    }
                    break;
                case 24:
                    Pair pair11 = (Pair) message.obj;
                    DeviceInfo deviceInfoF18 = headsetCoreService.mDeviceInfoManager.f((String) pair11.first);
                    if (deviceInfoF18 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_EQ_EVENT: cant find the deviceInfo");
                    } else {
                        deviceInfoF18.setEqualizerModeInfo((EqualizerModeInfo) pair11.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048617, deviceInfoF18));
                    }
                    break;
                case 25:
                    Pair pair12 = (Pair) message.obj;
                    HearingStatusInfo hearingStatusInfo = new HearingStatusInfo();
                    hearingStatusInfo.setAddress((String) pair12.first);
                    hearingStatusInfo.setHearingType(message.arg1);
                    hearingStatusInfo.setStatus(((Integer) pair12.second).intValue());
                    C1725a.c("HeadsetCoreService", new S7.c(hearingStatusInfo, i12));
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048621, hearingStatusInfo));
                    break;
                case 26:
                    Pair pair13 = (Pair) message.obj;
                    HearingEnhanceFreqPacketInfo hearingEnhanceFreqPacketInfo = new HearingEnhanceFreqPacketInfo();
                    hearingEnhanceFreqPacketInfo.setAddress((String) pair13.first);
                    hearingEnhanceFreqPacketInfo.setFreqPackets((List) pair13.second);
                    C1725a.c("HeadsetCoreService", new P3.d(hearingEnhanceFreqPacketInfo, 17));
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048622, hearingEnhanceFreqPacketInfo));
                    break;
                case 27:
                    Pair pair14 = (Pair) message.obj;
                    C1725a.e("HeadsetCoreService", "MSG_RECEIVE_HEARING_ENHANCEMENT_DATA, hearingDetectionInfoPair: " + pair14);
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048623, (HearingEnhancementInfo) pair14.second));
                    break;
                case 28:
                    Pair pair15 = (Pair) message.obj;
                    DeviceInfo deviceInfoF19 = headsetCoreService.mDeviceInfoManager.f((String) pair15.first);
                    if (deviceInfoF19 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_EAR_RESTORE_DATA_INFO Can't find the deviceInfo ");
                    } else {
                        C1725a.c("HeadsetCoreService", new Z6.h(pair15, 0));
                        deviceInfoF19.setEarRestoreDataInfoList((List) pair15.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048624, deviceInfoF19));
                    }
                    break;
                case 29:
                    Pair pair16 = (Pair) message.obj;
                    PersonalizedNoiseReductionResult personalizedNoiseReductionResult = (PersonalizedNoiseReductionResult) pair16.second;
                    personalizedNoiseReductionResult.setAddress((String) pair16.first);
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048629, personalizedNoiseReductionResult));
                    break;
                case 30:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048630, (PersonalizedNoiseReductionResultExist) ((Pair) message.obj).second));
                    break;
                case 31:
                    Pair pair17 = (Pair) message.obj;
                    DeviceInfo deviceInfoF20 = headsetCoreService.mDeviceInfoManager.f((String) pair17.first);
                    if (deviceInfoF20 == null) {
                        C1725a.f("HeadsetCoreService", "Can't find the deviceInfo ");
                    } else {
                        deviceInfoF20.setNoiseReductionInfo((NoiseReductionInfo) pair17.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048605, deviceInfoF20));
                    }
                    break;
                case 32:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048632, headsetCoreService.mDeviceInfoManager.f((String) message.obj)));
                    break;
                case 33:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048631, headsetCoreService.mDeviceInfoManager.f((String) message.obj)));
                    break;
                case 34:
                    MultiConnectInformations multiConnectInformations = (MultiConnectInformations) message.obj;
                    if (multiConnectInformations == null) {
                        C1725a.f("HeadsetCoreService", "multiConnectInfos is null");
                    } else {
                        DeviceInfo deviceInfoF21 = headsetCoreService.mDeviceInfoManager.f(multiConnectInformations.getAddress());
                        if (deviceInfoF21 == null) {
                            C1725a.f("HeadsetCoreService", "MSG_REQUEST_MULTI_CONNECT_INFO Can't find the deviceInfo ");
                        } else {
                            deviceInfoF21.setMultiConnectionInfo(multiConnectInformations.getMultiConnectInformationList());
                            HeadsetCoreService.m0(new BluetoothReceiveData(1048626, multiConnectInformations));
                        }
                    }
                    break;
                case 35:
                    Pair pair18 = (Pair) message.obj;
                    DeviceInfo deviceInfoF22 = headsetCoreService.mDeviceInfoManager.f((String) pair18.first);
                    if (deviceInfoF22 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_ZENMODE_STATUS_EVENT Can't find the deviceInfo ");
                    } else {
                        deviceInfoF22.setZenModeSwitchStatus(((Integer) pair18.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048627, deviceInfoF22));
                    }
                    break;
                case 36:
                    Pair pair19 = (Pair) message.obj;
                    if (headsetCoreService.mDeviceInfoManager.f((String) pair19.first) == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_ZENMODE_STATUS_EVENT Can't find the deviceInfo ");
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048628, (ZenModeFileInformation) pair19.second));
                    }
                    break;
                case 37:
                    DeviceInfo deviceInfoF23 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF23 == null) {
                        C1725a.g("HeadsetCoreService", "MSG_RECEIVE_SUPPORT_MULTIL_DEVICE_EVENT Can't find the device ", (String) message.obj);
                    } else {
                        deviceInfoF23.setSupportMultiDeviceConnect(message.arg1 == 1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048652, deviceInfoF23));
                    }
                    break;
                case 38:
                    DeviceInfo deviceInfoF24 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF24 == null) {
                        C1725a.g("HeadsetCoreService", "MSG_RECEIVE_FREE_DIALOG_RECOVERY_TIME Can't find the device ", (String) message.obj);
                    } else {
                        deviceInfoF24.setFullDialogRecoveryTime(message.arg1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048634, deviceInfoF24));
                    }
                    break;
                case 39:
                    ConnectDevicesInfo connectDevicesInfo = (ConnectDevicesInfo) message.obj;
                    if (connectDevicesInfo == null) {
                        C1725a.f("HeadsetCoreService", "connectDevicesInfo is null");
                    } else {
                        DeviceInfo deviceInfoF25 = headsetCoreService.mDeviceInfoManager.f(connectDevicesInfo.getAddress());
                        if (deviceInfoF25 == null) {
                            C1725a.f("HeadsetCoreService", "MSG_RECEIVE_CONNECT_DEVICES_EVENT Can't find the deviceInfo ");
                        } else {
                            deviceInfoF25.setConnectDeviceList(connectDevicesInfo.getConnectDeviceList());
                            HeadsetCoreService.m0(new BluetoothReceiveData(1048639, deviceInfoF25));
                        }
                    }
                    break;
                case 40:
                    DeviceInfo deviceInfoF26 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF26 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SUPPORT_RELATED Can't find the device "));
                    } else {
                        deviceInfoF26.setSupportRelated(message.arg1 == 1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048640, deviceInfoF26));
                    }
                    break;
                case 41:
                    DebugDataInfo debugDataInfo = (DebugDataInfo) message.obj;
                    if (debugDataInfo == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_DEBUG_SWITCH_EVENT dataInfo is null.");
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048641, debugDataInfo));
                    }
                    break;
                case 42:
                    DebugDataInfo debugDataInfo2 = (DebugDataInfo) message.obj;
                    if (debugDataInfo2 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_DEBUG_SEND_DATA_EVENT dataInfo is null.");
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048642, debugDataInfo2));
                    }
                    break;
                case 43:
                    DebugDataInfo debugDataInfo3 = (DebugDataInfo) message.obj;
                    if (debugDataInfo3 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_DEBUG_STOP_EVENT dataInfo is null.");
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048643, debugDataInfo3));
                    }
                    break;
                case 44:
                    Pair pair20 = (Pair) message.obj;
                    DeviceInfo deviceInfoF27 = headsetCoreService.mDeviceInfoManager.f((String) pair20.first);
                    if (deviceInfoF27 == null) {
                        C1725a.f("HeadsetCoreService", "Can't find the deviceInfo ");
                    } else {
                        deviceInfoF27.setIntelligentNoiseModeInfo((IntelligentNoiseModeInfo) pair20.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048606, deviceInfoF27));
                    }
                    break;
                case 45:
                    Pair pair21 = (Pair) message.obj;
                    HearingEnhanceEarScanStatusInfo hearingEnhanceEarScanStatusInfo = new HearingEnhanceEarScanStatusInfo();
                    hearingEnhanceEarScanStatusInfo.setAddress((String) pair21.first);
                    hearingEnhanceEarScanStatusInfo.setHearingType(message.arg1);
                    hearingEnhanceEarScanStatusInfo.setStatus(((Integer) pair21.second).intValue());
                    C1725a.c("HeadsetCoreService", new P3.d(hearingEnhanceEarScanStatusInfo, 18));
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048644, hearingEnhanceEarScanStatusInfo));
                    break;
                case 46:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048645, (HearingEnhancementEarScanResult) ((Pair) message.obj).second));
                    break;
                case 47:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048646, (HearingEnhancementEarScanResult) ((Pair) message.obj).second));
                    break;
                case 48:
                    Pair pair22 = (Pair) message.obj;
                    HearingEnhanceFreqPacketInfo hearingEnhanceFreqPacketInfo2 = new HearingEnhanceFreqPacketInfo();
                    hearingEnhanceFreqPacketInfo2.setAddress((String) pair22.first);
                    hearingEnhanceFreqPacketInfo2.setFreqPackets((List) pair22.second);
                    C1725a.c("HeadsetCoreService", new l(hearingEnhanceFreqPacketInfo2, 2));
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048647, hearingEnhanceFreqPacketInfo2));
                    break;
                case 49:
                    DiagnosisJsonDataInfo diagnosisJsonDataInfo = (DiagnosisJsonDataInfo) message.obj;
                    if (diagnosisJsonDataInfo == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_DEVICES_BURIED_POINT_EVENT dataInfo is null.");
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048648, diagnosisJsonDataInfo));
                    }
                    break;
                case 50:
                    DiagnosisJsonDataInfo diagnosisJsonDataInfo2 = (DiagnosisJsonDataInfo) message.obj;
                    if (diagnosisJsonDataInfo2 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_DIAGNOSTIC_DATA_EVENT result is null.");
                        break;
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048650, diagnosisJsonDataInfo2));
                        if (diagnosisJsonDataInfo2.getJsonData() != null && diagnosisJsonDataInfo2.getJsonData().contains("\"get_sn\"")) {
                            DeviceInfo deviceInfoF28 = headsetCoreService.mDeviceInfoManager.f(diagnosisJsonDataInfo2.getAddress());
                            if (deviceInfoF28 == null) {
                                C1725a.m("HeadsetCoreService", "MSG_RECEIVE_DIAGNOSTIC_DATA_EVENT deviceInfo is null, ", diagnosisJsonDataInfo2.getAddress());
                            } else {
                                try {
                                    DiagnosisJsonDataInfo.EarbudsSn earbudsSn = (DiagnosisJsonDataInfo.EarbudsSn) C0917x.c(DiagnosisJsonDataInfo.EarbudsSn.class, diagnosisJsonDataInfo2.getJsonData());
                                    if (earbudsSn != null && earbudsSn.getBoxSn() != null) {
                                        if (earbudsSn.getRsp()) {
                                            DiagnosisJsonDataInfo.Companion companion = DiagnosisJsonDataInfo.INSTANCE;
                                            String sn = earbudsSn.getBoxSn().getSn();
                                            companion.getClass();
                                            if (sn != null) {
                                                zMatches = Pattern.compile("^[A-Z0-9]{20,22}$").matcher(sn).matches();
                                            }
                                            if (zMatches) {
                                                deviceInfoF28.setBoxSn(earbudsSn.getBoxSn().getSn());
                                                HeadsetCoreService.m0(new BluetoothReceiveData(1048689, deviceInfoF28));
                                            }
                                        }
                                        A.f("HeadsetCoreService", "MSG_RECEIVE_DIAGNOSTIC_DATA_EVENT sn not match, earbudsSn: " + earbudsSn);
                                    }
                                    C1725a.m("HeadsetCoreService", "MSG_RECEIVE_DIAGNOSTIC_DATA_EVENT earbudsSn is null, ", diagnosisJsonDataInfo2.getAddress());
                                } catch (Exception e10) {
                                    A.i("HeadsetCoreService", "MSG_RECEIVE_DIAGNOSTIC_DATA_EVENT, error: ", e10);
                                    return;
                                }
                            }
                            break;
                        }
                    }
                    break;
                case 51:
                    Pair pair23 = (Pair) message.obj;
                    DeviceInfo deviceInfoF29 = headsetCoreService.mDeviceInfoManager.f((String) pair23.first);
                    if (deviceInfoF29 == null) {
                        C1725a.f("HeadsetCoreService", "handleMessage: MSG_RECEIVE_GAME_MODE_EVENT cant find the gameModeDeviceInfo");
                    } else {
                        int iIntValue = ((Integer) pair23.second).intValue();
                        deviceInfoF29.setGameMode(iIntValue);
                        DeviceInfo deviceInfoF30 = DeviceInfoManager.a.f19280a.f((String) pair23.first);
                        if (deviceInfoF30 == null) {
                            C1725a.f("HeadsetCoreService", "handleMessage: MSG_RECEIVE_GAME_MODE_EVENT deviceInfo is null");
                        } else {
                            List<FeatureSwitchInfo> featureSwitchInfo2 = deviceInfoF30.getFeatureSwitchInfo();
                            if (featureSwitchInfo2 != null && !featureSwitchInfo2.isEmpty()) {
                                for (FeatureSwitchInfo featureSwitchInfo3 : featureSwitchInfo2) {
                                    if (featureSwitchInfo3.getFeatureType() == 6) {
                                        if (iIntValue == 1) {
                                            featureSwitchInfo3.setStatus(1);
                                        } else {
                                            featureSwitchInfo3.setStatus(0);
                                        }
                                    }
                                }
                            }
                            HeadsetCoreService.m0(new BluetoothReceiveData(1048651, deviceInfoF29));
                        }
                    }
                    break;
                case 52:
                    Pair pair24 = (Pair) message.obj;
                    DeviceInfo deviceInfoF31 = headsetCoreService.mDeviceInfoManager.f((String) pair24.first);
                    if (deviceInfoF31 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_EAR_TONE_EVENT Can't find the deviceInfo ");
                    } else {
                        deviceInfoF31.setEarTone((List) pair24.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048653, deviceInfoF31));
                    }
                    break;
                case 53:
                    DeviceInfo deviceInfoF32 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF32 == null) {
                        C1725a.g("HeadsetCoreService", "MSG_RECEIVE_CODEC_TYPE_EVENT Can't find the device ", (String) message.obj);
                    } else {
                        deviceInfoF32.setCodecType(message.arg1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048654, deviceInfoF32));
                    }
                    break;
                case 54:
                    Pair pair25 = (Pair) message.obj;
                    DeviceInfo deviceInfoF33 = headsetCoreService.mDeviceInfoManager.f((String) pair25.first);
                    if (deviceInfoF33 == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_ALL_EQ_INFO, deviceInfo is null!");
                    } else {
                        deviceInfoF33.setEqInfoList((List) pair25.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048619, deviceInfoF33));
                    }
                    break;
                case 55:
                    DeviceInfo deviceInfoF34 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF34 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SUPPORT_CUSTOM_EQ Can't find the device "));
                    } else {
                        deviceInfoF34.setSupportCustomEq(message.arg1 == 1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048655, deviceInfoF34));
                    }
                    break;
                case 56:
                    Pair pair26 = (Pair) message.obj;
                    DeviceInfo deviceInfoF35 = headsetCoreService.mDeviceInfoManager.f((String) pair26.first);
                    if (deviceInfoF35 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SUPPORT_CUSTOM_EQ Can't find the device "));
                    } else {
                        deviceInfoF35.setCodecList((List) pair26.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048657, deviceInfoF35));
                    }
                    break;
                case 57:
                    Pair pair27 = (Pair) message.obj;
                    DeviceInfo deviceInfoF36 = headsetCoreService.mDeviceInfoManager.f((String) pair27.first);
                    if (deviceInfoF36 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_BASS_ENGINE_RESULT Can't find the device "));
                    } else {
                        deviceInfoF36.setBassEngineValue((BassEngineInfo) pair27.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048658, deviceInfoF36));
                    }
                    break;
                case 58:
                    DeviceInfo deviceInfoF37 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF37 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SUPPORT_BIND_ACCOUNT Can't find the device "));
                    } else {
                        deviceInfoF37.setSupportBindAccount(message.arg1 == 1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048661, deviceInfoF37));
                    }
                    break;
                case 59:
                    Pair pair28 = (Pair) message.obj;
                    DeviceInfo deviceInfoF38 = headsetCoreService.mDeviceInfoManager.f((String) pair28.first);
                    if (deviceInfoF38 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_ACCOUNT_KEY_RESULT Can't find the device "));
                    } else {
                        deviceInfoF38.setAccountKey((String) pair28.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048662, deviceInfoF38));
                    }
                    break;
                case 60:
                    DeviceInfo deviceInfoF39 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF39 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SUPPORT_TRIANGLE Can't find the device "));
                    } else {
                        deviceInfoF39.setSupportTriangle(message.arg1 == 1);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048659, deviceInfoF39));
                    }
                    break;
                case 61:
                    Pair pair29 = (Pair) message.obj;
                    DeviceInfo deviceInfoF40 = headsetCoreService.mDeviceInfoManager.f((String) pair29.first);
                    if (deviceInfoF40 == null) {
                        A6.f.f((String) pair29.first, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_TRIANGLE_INFO Can't find the device "));
                    } else {
                        TriangleInfo triangleInfo = deviceInfoF40.getTriangleInfo();
                        if (triangleInfo != null) {
                            deviceInfoF40.setTriangleInfo(triangleInfo.copyFrom((TriangleInfo) pair29.second));
                        } else {
                            deviceInfoF40.setTriangleInfo((TriangleInfo) pair29.second);
                        }
                        Parcel parcelObtain = Parcel.obtain();
                        deviceInfoF40.writeToParcel(parcelObtain, 0);
                        parcelObtain.setDataPosition(0);
                        DeviceInfo deviceInfoCreateFromParcel = DeviceInfo.CREATOR.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048660, deviceInfoCreateFromParcel));
                    }
                    break;
                case 62:
                    Pair pair30 = (Pair) message.obj;
                    DeviceInfo deviceInfoF41 = headsetCoreService.mDeviceInfoManager.f((String) pair30.first);
                    if (deviceInfoF41 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SCREEN_OFF_BROADCAST_DELAY_TIME_RESULT Can't find the device "));
                    } else {
                        deviceInfoF41.setScreenOffBroadcastDelayTime(((Integer) pair30.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048663, deviceInfoF41));
                    }
                    break;
                case 63:
                    Object obj3 = message.obj;
                    if (obj3 instanceof SimpleStateInfo) {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048693, (SimpleStateInfo) obj3));
                    } else {
                        A.f("HeadsetCoreService", "MSG_RECEIVE_VOICE_RECOGNITION unknown obj " + message.obj);
                    }
                    break;
                case 64:
                    Pair pair31 = (Pair) message.obj;
                    DeviceInfo deviceInfoF42 = headsetCoreService.mDeviceInfoManager.f((String) pair31.first);
                    if (deviceInfoF42 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SPINE_RANGE_RESULT Can't find the device "));
                    } else {
                        deviceInfoF42.setSpineRangeDetection((List) pair31.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048664, deviceInfoF42));
                    }
                    break;
                case 65:
                    Pair pair32 = (Pair) message.obj;
                    DeviceInfo deviceInfoF43 = headsetCoreService.mDeviceInfoManager.f((String) pair32.first);
                    if (deviceInfoF43 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SPINE_CALIBRATION_RESULT Can't find the device "));
                    } else {
                        deviceInfoF43.setSpineCalibrationResult((List) pair32.second);
                        Object obj4 = pair32.second;
                        if (obj4 != null && ((List) obj4).size() > 0 && ((Integer) ((List) pair32.second).get(0)).intValue() == 0) {
                            deviceInfoF43.setSpineCalibrationState(1);
                        }
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048665, deviceInfoF43));
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048669, deviceInfoF43));
                    }
                    break;
                case 66:
                    Pair pair33 = (Pair) message.obj;
                    DeviceInfo deviceInfoF44 = headsetCoreService.mDeviceInfoManager.f((String) pair33.first);
                    if (deviceInfoF44 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SPINE_CALIBRATION_RESULT Can't find the device "));
                    } else {
                        deviceInfoF44.setSpineHistoryDatas((List) pair33.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048666, deviceInfoF44));
                    }
                    break;
                case 67:
                    Pair pair34 = (Pair) message.obj;
                    DeviceInfo deviceInfoF45 = headsetCoreService.mDeviceInfoManager.f((String) pair34.first);
                    if (deviceInfoF45 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SPINE_FATIGUE_REMIND_EVENT Can't find the device "));
                    } else {
                        deviceInfoF45.setSpineFatigueTime(((Integer) pair34.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048667, deviceInfoF45));
                    }
                    break;
                case 68:
                    Pair pair35 = (Pair) message.obj;
                    DeviceInfo deviceInfoF46 = headsetCoreService.mDeviceInfoManager.f((String) pair35.first);
                    if (deviceInfoF46 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SPINE_CERVICAL_REMIND_EVENT Can't find the device "));
                    } else {
                        deviceInfoF46.setCervicalSpineRemindTime(((Integer) pair35.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048668, deviceInfoF46));
                    }
                    break;
                case 69:
                    Pair pair36 = (Pair) message.obj;
                    DeviceInfo deviceInfoF47 = headsetCoreService.mDeviceInfoManager.f((String) pair36.first);
                    if (deviceInfoF47 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SPINE_CALIBRATED_EVENT Can't find the device "));
                    } else {
                        deviceInfoF47.setSpineCalibrationState(((Integer) pair36.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048669, deviceInfoF47));
                    }
                    break;
                case 70:
                    Pair pair37 = (Pair) message.obj;
                    DeviceInfo deviceInfoF48 = headsetCoreService.mDeviceInfoManager.f((String) pair37.first);
                    if (deviceInfoF48 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_HEADSET_SPATIAL_TYPE_EVENT Can't find the device "));
                    } else {
                        deviceInfoF48.setHeadsetSpatialType(((Integer) pair37.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048670, deviceInfoF48));
                    }
                    break;
                case 71:
                    DebugFeatureInfo debugFeatureInfo = (DebugFeatureInfo) message.obj;
                    if (debugFeatureInfo == null) {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_DEBUG_SEND_FEATURE_EVENT featureInfo is null.");
                    } else {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048672, debugFeatureInfo));
                    }
                    break;
                case 72:
                    Pair pair38 = (Pair) message.obj;
                    DeviceInfo deviceInfoF49 = headsetCoreService.mDeviceInfoManager.f((String) pair38.first);
                    if (deviceInfoF49 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_GAME_SOUND_INFO Can't find the device "));
                    } else {
                        deviceInfoF49.setGameSoundInfo((GameSoundInfo) pair38.second);
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048673, deviceInfoF49));
                    }
                    break;
                case 73:
                    C0391z.f1171d.getClass();
                    if (C0391z.m()) {
                        Object[] objArr2 = message.arg1 == 1;
                        String address3 = (String) message.obj;
                        if (W6.b.k(address3) && (bluetoothDeviceB2 = W6.b.b(address3)) != null) {
                            address3 = bluetoothDeviceB2.getAddress();
                        }
                        DeviceInfo deviceInfoF50 = headsetCoreService.mDeviceInfoManager.f(address3);
                        if (deviceInfoF50 == null) {
                            C1725a.d("HeadsetCoreService", new Q(i12), address3);
                        } else if (objArr2 == true) {
                            WhitelistConfigDTO whitelistConfigDTOA2 = a.C0090a.f6690a.a(address3);
                            if (whitelistConfigDTOA2 == null || !whitelistConfigDTOA2.getSupportSpp()) {
                                C1725a.d("HeadsetCoreService", new A6.j(i11), address3);
                            } else if (C1726b.b(headsetCoreService.F()) || W6.b.j(address3)) {
                                C1725a.m("HeadsetCoreService", "m_spp_le.MSG_DIRECT_CONNECT_TO_SPP start to connect", address3);
                                n7.d dVar = ((C1329b) headsetCoreService.mDeviceConnectionApi).f26330g;
                                if (dVar != null) {
                                    dVar.a(deviceInfoF50, true);
                                }
                            } else {
                                C1725a.d("HeadsetCoreService", new C0371e(i11), address3);
                            }
                        } else {
                            C1725a.m("HeadsetCoreService", "m_spp_le.MSG_DIRECT_CONNECT_TO_SPP start to disconnect", address3);
                            n7.d dVar2 = ((C1329b) headsetCoreService.mDeviceConnectionApi).f26330g;
                            if (dVar2 != null) {
                                dVar2.a(deviceInfoF50, false);
                            }
                        }
                    } else {
                        C1725a.f("HeadsetCoreService", "m_spp_le.MSG_DIRECT_CONNECT_TO_SPP, bluetooth not open");
                    }
                    break;
                case 74:
                    h.e.f25190a.h(message.arg1 == 1);
                    break;
                case 75:
                    Pair pair39 = (Pair) message.obj;
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048675, new HeadsetTipInfo((String) pair39.first, ((Integer) pair39.second).intValue())));
                    break;
                case 76:
                    DeviceInfo deviceInfoF51 = headsetCoreService.mDeviceInfoManager.f((String) message.obj);
                    if (deviceInfoF51 != null) {
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048677, deviceInfoF51));
                    } else {
                        C1725a.f("HeadsetCoreService", "MSG_RECEIVE_REGISTER_MULTI_NOTIFICATION_COMPLETE deviceInfo is null");
                    }
                    break;
                case 77:
                    Pair pair40 = (Pair) message.obj;
                    DeviceInfo deviceInfoF52 = headsetCoreService.mDeviceInfoManager.f((String) pair40.first);
                    if (deviceInfoF52 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_AI_SUMMARY_TYPE_EVENT Can't find the device "));
                    } else {
                        deviceInfoF52.setAISummaryType(((Integer) pair40.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048678, deviceInfoF52));
                    }
                    break;
                case 78:
                    Pair pair41 = (Pair) message.obj;
                    DeviceInfo deviceInfoF53 = headsetCoreService.mDeviceInfoManager.f((String) pair41.first);
                    if (deviceInfoF53 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_VOLUME_VALUE_INFO Can't find the device "));
                    } else {
                        deviceInfoF53.setVolumeValueInfo(((Integer) pair41.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048679, deviceInfoF53));
                    }
                    break;
                case 79:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048680, (HandheldDeviceInfo) ((Pair) message.obj).second));
                    break;
                case 80:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048681, (OneshotAudioDataInfo) ((Pair) message.obj).second));
                    break;
                case 81:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048682, (OneshotStateInfo) ((Pair) message.obj).second));
                    break;
                case 82:
                    Pair pair42 = (Pair) message.obj;
                    DeviceInfo deviceInfoF54 = headsetCoreService.mDeviceInfoManager.f((String) pair42.first);
                    if (deviceInfoF54 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_SMART_BLUETOOTH_RESULT Can't find the device "));
                    } else {
                        deviceInfoF54.setSupportSmartBluetooth(((Boolean) pair42.second).booleanValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048685, deviceInfoF54));
                    }
                    break;
                case 83:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048683, (OneshotEncodeState) ((Pair) message.obj).second));
                    break;
                case 84:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048684, headsetCoreService.mDeviceInfoManager.f((String) message.obj)));
                    break;
                case 85:
                    Pair pair43 = (Pair) message.obj;
                    DeviceInfo deviceInfoF55 = headsetCoreService.mDeviceInfoManager.f((String) pair43.first);
                    if (deviceInfoF55 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_TRANSLATION_APP_RESULT Can't find the device "));
                    } else {
                        deviceInfoF55.setAITranslationAppStatus(((Integer) pair43.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048686, deviceInfoF55));
                    }
                    break;
                case 86:
                    Pair pair44 = (Pair) message.obj;
                    DeviceInfo deviceInfoF56 = headsetCoreService.mDeviceInfoManager.f((String) pair44.first);
                    if (deviceInfoF56 == null) {
                        A6.f.f((String) message.obj, "HeadsetCoreService", new StringBuilder("MSG_RECEIVE_TAP_LEVEL_SETTING_VALUE Can't find the device "));
                    } else {
                        boolean zIsNotificationInfo = ((TapLevelSettingInfo) pair44.second).isNotificationInfo();
                        deviceInfoF56.setTapLevelSettingValue(((TapLevelSettingInfo) pair44.second).getTapLevelSettingValue());
                        if (!zIsNotificationInfo) {
                            deviceInfoF56.setTapLevelDefaultValue(((TapLevelSettingInfo) pair44.second).getTapLevelDefaultValue());
                        }
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048687, deviceInfoF56));
                    }
                    break;
                case 87:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048688, (OneshotExeResultInfo) ((Pair) message.obj).second));
                    break;
                case 88:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048691, (InterruptInfo) message.obj));
                    break;
                case 89:
                    Pair pair45 = (Pair) message.obj;
                    DeviceInfo deviceInfoF57 = headsetCoreService.mDeviceInfoManager.f((String) pair45.first);
                    if (deviceInfoF57 == null) {
                        C1725a.g("HeadsetCoreService", "MSG_RECEIVE_HEAD_MOTION_TYPE_EVENT, deviceInfo is null", (String) pair45.first);
                    } else {
                        deviceInfoF57.setHeadMotionType(((Integer) pair45.second).intValue());
                        HeadsetCoreService.m0(new BluetoothReceiveData(1048695, deviceInfoF57));
                    }
                    break;
                case 90:
                    HeadsetCoreService.m0(new BluetoothReceiveData(1048696, (HeadMotionTryResult) ((Pair) message.obj).second));
                    break;
            }
        }
    }

    public /* synthetic */ HeadsetCoreService(int i10) {
        this();
    }

    public static String a(HeadsetCoreService headsetCoreService, C1046a c1046a) {
        headsetCoreService.getClass();
        return "no need get state transferId:" + (c1046a.f23111b & 255) + " size:" + headsetCoreService.mNoGetStateSet.size();
    }

    public static void m0(BluetoothReceiveData bluetoothReceiveData) {
        LinkedList<C0370d.a> linkedList;
        S6.a aVar = new S6.a(bluetoothReceiveData);
        synchronized (C0370d.f1060a) {
            try {
                linkedList = null;
                for (C0370d.a aVar2 : C0370d.f1062c) {
                    if (aVar2.f1063a.isInstance(aVar)) {
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                        }
                        linkedList.add(aVar2);
                    }
                }
                if (linkedList == null) {
                    C0370d.f1061b.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (linkedList == null) {
            A.x("EventBus", "postSticky WAIT " + S6.a.class);
            return;
        }
        S6.a.class.toString();
        linkedList.size();
        for (C0370d.a aVar3 : linkedList) {
            aVar3.getClass();
            aVar3.f1064b.execute(new RunnableC0369c(0, aVar3, aVar));
        }
    }

    public static void n(HeadsetCoreService headsetCoreService, DeviceInfo deviceInfo, int i10) {
        C1725a.c("HeadsetCoreService", new Z6.d(i10, deviceInfo));
        if (i10 == 2 || i10 == 3 || i10 == 5) {
            deviceInfo.setSppOverGattConnectionState(i10);
            m0(new BluetoothReceiveData(1048674, deviceInfo));
            if (i10 == 3 || i10 == 5) {
                headsetCoreService.mUpgradeManager.b(deviceInfo.getDeviceAddress());
                t tVar = headsetCoreService.mUpgradePropertyProcessor;
                String deviceAddress = deviceInfo.getDeviceAddress();
                if (deviceAddress != null) {
                    tVar.f19340b.remove(deviceAddress);
                } else {
                    tVar.getClass();
                }
                if (i10 == 5) {
                    C1725a.f("HeadsetCoreService", "m_spp_le.onDirectConnectSppStateChanged, spp over gatt connect failed");
                }
            }
        }
    }

    public static void o(HeadsetCoreService headsetCoreService, DeviceInfo deviceInfo, int i10) {
        headsetCoreService.mConnectionStateListener.a(deviceInfo, i10, 0, false);
    }

    public final void A(String str) {
        this.mPollCommandManager.b(str);
    }

    public final void A0(final int i10, final int i11, final int i12, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1051, str)) {
            C1725a.d("SetCommandManager", new Q(25), str);
        } else {
            C1725a.c("SetCommandManager", new Supplier() { // from class: com.oplus.melody.btsdk.protocol.commands.l
                @Override // java.util.function.Supplier
                public final Object get() {
                    return "setBassEngineValue = " + i10 + " " + i11 + " " + i12;
                }
            });
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1051, new byte[]{(byte) i10, (byte) i11, (byte) i12}));
        }
    }

    public final void B(String str) {
        this.mPollCommandManager.c(str);
    }

    public final void B0(boolean z2) {
        C1725a.c("HeadsetCoreService", new G(12, z2));
        this.mWorkHandler.obtainMessage(74, z2 ? 1 : 0, -1).sendToTarget();
    }

    public final void C(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(292, str)) {
            C1725a.d("PollCommandManager", new C0372f(12), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 292, C1047b.f23115b));
    }

    public final void C0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1039, str)) {
            C1725a.d("SetCommandManager", new C0371e(24), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1039, new byte[]{(byte) i10}));
            C1725a.c("SetCommandManager", new com.oplus.melody.btsdk.protocol.commands.h(i10, 5));
        }
    }

    public final boolean D(String str) {
        return this.mPollCommandManager.d(str);
    }

    public final void D0(String str, CurrentNoiseModeInfo currentNoiseModeInfo) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1028, str)) {
            C1725a.d("SetCommandManager", new C0372f(28), str);
        } else {
            if (currentNoiseModeInfo == null) {
                C1725a.f("SetCommandManager", "setCurrentNoiseReduction currentNoiseModeInfo is null, return; ");
                return;
            }
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1028, currentNoiseModeInfo.getData()));
        }
    }

    public final boolean E(String str) {
        return this.mPollCommandManager.e(str);
    }

    public final void E0(DebugFeatureInfo debugFeatureInfo) {
        C0762a c0762a = this.mDebugCommandManager;
        c0762a.getClass();
        if (debugFeatureInfo == null || debugFeatureInfo.getDebugModuleList() == null || debugFeatureInfo.getDebugModuleList().isEmpty()) {
            C1725a.f("DebugCommandManager", "setDebugFeatureInfo, info is null. " + debugFeatureInfo);
            return;
        }
        if (!c0762a.f13393d.c(3844, debugFeatureInfo.getAddress())) {
            C1725a.d("DebugCommandManager", new C0371e(9), debugFeatureInfo.getAddress());
            return;
        }
        int size = debugFeatureInfo.getDebugModuleList().size();
        byte[] bArr = new byte[(size * 2) + 2];
        bArr[0] = (byte) (debugFeatureInfo.getType() & 255);
        bArr[1] = (byte) (size & 255);
        int i10 = 2;
        for (int i11 = 0; i11 < size; i11++) {
            DebugModuleInfo debugModuleInfo = debugFeatureInfo.getDebugModuleList().get(i11);
            if (debugModuleInfo == null) {
                C1725a.f("DebugCommandManager", "setDebugFeatureInfo Failed when set modules. info: " + debugFeatureInfo);
                return;
            } else {
                bArr[i10] = (byte) (debugModuleInfo.getModule() & 255);
                bArr[i10 + 1] = (byte) (debugModuleInfo.getLevel() & 255);
                i10 += 2;
            }
        }
        Integer.toHexString(3844);
        E8.a.e(bArr);
        debugFeatureInfo.toString();
        c0762a.f13391b.u0(debugFeatureInfo.getAddress(), c0762a.f13390a.a(debugFeatureInfo.getAddress(), 3844, bArr));
    }

    public final Context F() {
        return this.mContext;
    }

    public final void F0(String str, ArrayList arrayList) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1041, str)) {
            C1725a.d("SetCommandManager", new Q(29), str);
            return;
        }
        if (arrayList == null || arrayList.size() == 0) {
            C1725a.g("SetCommandManager", "restoreDataInfos is null or 0. Command 1041", str);
            return;
        }
        int size = arrayList.size();
        int i10 = 0;
        int dataByteLength = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            dataByteLength += ((EarRestoreDataInfo) obj).getDataByteLength();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(dataByteLength + 1);
        byteBufferAllocate.put((byte) arrayList.size());
        int size2 = arrayList.size();
        while (i10 < size2) {
            Object obj2 = arrayList.get(i10);
            i10++;
            byte[] dataBytes = ((EarRestoreDataInfo) obj2).getDataBytes();
            if (dataBytes != null) {
                byteBufferAllocate.put(dataBytes);
            }
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1041, byteBufferAllocate.array()));
    }

    public final void G(String str) {
        this.mPollCommandManager.g(str);
    }

    public final void G0(String str, EqInfo eqInfo, int i10) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1048, str)) {
            C1725a.d("SetCommandManager", new n(1), str);
            return;
        }
        byte[] bArr = new byte[eqInfo.getSetCommandByteLength() + 1];
        try {
            bArr[0] = (byte) i10;
            bArr[1] = (byte) eqInfo.getMinValue();
            bArr[2] = (byte) eqInfo.getMaxValue();
            bArr[3] = (byte) eqInfo.getEqId();
            int i11 = 5;
            if (TextUtils.isEmpty(eqInfo.getName())) {
                bArr[4] = (byte) 0;
            } else {
                byte[] bytes = eqInfo.getName().getBytes(StandardCharsets.UTF_8);
                int length = bytes.length;
                bArr[4] = (byte) length;
                System.arraycopy(bytes, 0, bArr, 5, length);
                i11 = 5 + length;
            }
            if (eqInfo.getFrequency() != null && eqInfo.getFrequency().length != 0) {
                if (eqInfo.getDbValue() != null && eqInfo.getDbValue().length != 0) {
                    if (eqInfo.getFrequency().length != eqInfo.getDbValue().length) {
                        C1725a.f("SetCommandManager", "setEqInfo return false, eqInfo.getFrequency().length not equals eqInfo.getDbValue().length!");
                        return;
                    }
                    bArr[i11] = (byte) eqInfo.getFrequency().length;
                    for (int i12 = 0; i12 < eqInfo.getFrequency().length; i12++) {
                        D5.c.i(eqInfo.getFrequency()[i12], i11 + 1, 2, bArr);
                        i11 += 3;
                        bArr[i11] = (byte) eqInfo.getDbValue()[i12];
                    }
                    sVar.f19335b.u0(str, sVar.f19334a.a(str, 1048, bArr));
                    return;
                }
                C1725a.f("SetCommandManager", "setEqInfo return false, eqInfo.getDbValue() is empty");
                return;
            }
            C1725a.f("SetCommandManager", "setEqInfo return false, eqInfo.getFrequency() is empty");
        } catch (Exception e10) {
            C1725a.h("SetCommandManager", "setEqInfo eqInfo = " + eqInfo, e10);
        }
    }

    public final int H(String str) {
        DeviceInfo deviceInfoF = this.mDeviceInfoManager.f(str);
        if (deviceInfoF == null) {
            C1725a.f("HeadsetCoreService", "Can't get the device information when check device connect state.");
            return 3;
        }
        n7.d dVar = ((C1329b) this.mDeviceConnectionApi).f26330g;
        if (dVar != null) {
            return dVar.d(deviceInfoF);
        }
        return 3;
    }

    public final void H0(String str, EqualizerModeInfo equalizerModeInfo) {
        s sVar = this.mSetCommandManager;
        if (sVar.f19337d.c(1030, str)) {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1030, new byte[]{(byte) equalizerModeInfo.getEqualizerModeType()}));
        } else {
            C1725a.d("SetCommandManager", new A6.j(26), str);
        }
    }

    public final void I(String str) {
        DeviceInfo deviceInfoF = this.mDeviceInfoManager.f(str);
        if (deviceInfoF != null) {
            C1725a.a("HeadsetCoreService", "getDeviceInfo: start notify device info...");
            m0(new BluetoothReceiveData(1048578, deviceInfoF));
        }
    }

    public final void I0(String str, boolean z2) {
        s sVar = this.mSetCommandManager;
        if (sVar.f19337d.c(1024, str)) {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1024, new byte[]{z2 ? (byte) 1 : (byte) 0}));
        } else {
            C1725a.d("SetCommandManager", new C0371e(29), str);
        }
    }

    public final boolean J(String str) {
        return this.mPollCommandManager.x(str);
    }

    public final void J0(String str, byte b4) {
        int i10 = 0;
        s sVar = this.mSetCommandManager;
        if (sVar.f19337d.c(1044, str)) {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1044, new byte[]{b4}));
        } else {
            C1725a.d("SetCommandManager", new n(i10), str);
        }
    }

    public final void K(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(281, str)) {
            C1725a.d("PollCommandManager", new Q(16), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 281, C1047b.f23115b));
    }

    public final void K0(int i10, boolean z2, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1059, str)) {
            C1725a.d("SetCommandManager", new C0372f(25), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1059, new byte[]{(byte) i10, z2 ? (byte) 1 : (byte) 0}));
            C1725a.c("SetCommandManager", new com.oplus.melody.btsdk.protocol.commands.e(i10, 1, z2));
        }
    }

    public final boolean L(String str) {
        return this.mPollCommandManager.i(str);
    }

    public final void L0(int i10, int i11, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1056, str)) {
            C1725a.d("SetCommandManager", new C0371e(28), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1056, new byte[]{(byte) i10, (byte) i11}));
            C1725a.c("SetCommandManager", new R7.b(i10, i11, 3));
        }
    }

    public final boolean M(String str, int i10, byte[] bArr) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(287, str)) {
            C1725a.d("PollCommandManager", new C0371e(12), str);
            return false;
        }
        if (bArr == null || bArr.length == 0) {
            C1725a.a("PollCommandManager", "getEarScanFilterData, earScanData is null ");
            return false;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 6);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putShort((short) bArr.length);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.putInt(i10);
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 287, byteBufferAllocate.array()));
        return true;
    }

    public final void M0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (sVar.f19337d.c(1073, str)) {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1073, new byte[]{(byte) i10}));
            return;
        }
        C1725a.b("SetCommandManager", "setHeadMotionType UNSUPPORTED cmd=0x" + Integer.toHexString(1073), str);
    }

    public final boolean N(String str) {
        return this.mPollCommandManager.j(str);
    }

    public final void N0(int i10, String str) {
        int i11 = 0;
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1058, str)) {
            C1725a.d("SetCommandManager", new r(i11), str);
        } else {
            C1725a.c("SetCommandManager", new k(i10, 7));
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1058, new byte[]{(byte) i10}));
        }
    }

    public final void O(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(265, str)) {
            C1725a.d("PollCommandManager", new C0372f(10), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 265, C1047b.f23115b));
    }

    public final void O0(int i10, int i11, int i12, String str) {
        int i13 = 3;
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1050, str)) {
            C1725a.d("SetCommandManager", new Q(26), str);
            return;
        }
        byte[] bArr = {(byte) i10, (byte) i11, (byte) i12};
        C1725a.c("SetCommandManager", new com.oplus.melody.btsdk.protocol.commands.a(bArr, i13));
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1050, bArr));
    }

    public final void P(String str) {
        this.mPollCommandManager.f(str);
    }

    public final void P0(String str, Bundle bundle) {
        s sVar = this.mSetCommandManager;
        if (bundle == null) {
            sVar.getClass();
            return;
        }
        if (!sVar.f19337d.c(1043, str)) {
            C1725a.d("SetCommandManager", new Q(27), str);
            return;
        }
        int i10 = 3;
        int i11 = bundle.containsKey("param_host_triangle_version") ? 3 : 2;
        if (bundle.containsKey("param_host_triangle_is_screen_on")) {
            i11++;
        }
        if (bundle.containsKey("param_host_triangle_is_occupy_manual")) {
            i11++;
        }
        if (bundle.containsKey("param_host_triangle_is_auto_switch_link_opened")) {
            i11++;
        }
        if (bundle.containsKey("param_host_triangle_is_music_active")) {
            i11++;
        }
        if (i11 == 2) {
            return;
        }
        byte[] bArr = new byte[i11];
        if (bundle.containsKey("param_host_triangle_version")) {
            bArr[0] = (byte) (bArr[0] | 1);
            bArr[2] = (byte) bundle.getInt("param_host_triangle_version");
            A.a aVar = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("SetCommandManager", "setHostTriangleInfo PARAM_HOST_TRIANGLE_VERSION:" + ((int) bArr[2]));
            }
        } else {
            i10 = 2;
        }
        if (bundle.containsKey("param_host_triangle_is_screen_on")) {
            bArr[0] = (byte) (bArr[0] | 2);
            bArr[i10] = (byte) bundle.getInt("param_host_triangle_is_screen_on");
            A.a aVar2 = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("SetCommandManager", "setHostTriangleInfo PARAM_HOST_TRIANGLE_IS_SCREEN_ON:" + ((int) bArr[i10]));
            }
            i10++;
        }
        if (bundle.containsKey("param_host_triangle_is_occupy_manual")) {
            bArr[0] = (byte) (bArr[0] | 4);
            bArr[i10] = (byte) bundle.getInt("param_host_triangle_is_occupy_manual");
            A.a aVar3 = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("SetCommandManager", "setHostTriangleInfo PARAM_HOST_TRIANGLE_IS_OCCUPY_MANUAL:" + ((int) bArr[i10]));
            }
            i10++;
        }
        if (bundle.containsKey("param_host_triangle_is_auto_switch_link_opened")) {
            bArr[0] = (byte) (bArr[0] | 8);
            bArr[i10] = (byte) bundle.getInt("param_host_triangle_is_auto_switch_link_opened");
            A.a aVar4 = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("SetCommandManager", "setHostTriangleInfo PARAM_HOST_TRIANGLE_IS_AUTO_SWITCH_LINK_OPENED:" + ((int) bArr[i10]));
            }
            i10++;
        }
        if (bundle.containsKey("param_host_triangle_is_music_active")) {
            bArr[0] = (byte) (bArr[0] | 16);
            bArr[i10] = (byte) bundle.getInt("param_host_triangle_is_music_active");
            A.a aVar5 = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("SetCommandManager", "setHostTriangleInfo PARAM_HOST_TRIANGLE_IS_MUSIC_ACTIVE:" + ((int) bArr[i10]));
            }
        }
        bArr[1] = 0;
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1043, bArr));
    }

    public final void Q(String str) {
        this.mPollCommandManager.k(str);
    }

    public final void Q0(int i10, String str, ArrayList arrayList) {
        s sVar = this.mSetCommandManager;
        if (arrayList == null) {
            sVar.getClass();
            return;
        }
        if (!sVar.f19337d.c(i10, str)) {
            C1725a.d("SetCommandManager", new Y(i10, 28), str);
            return;
        }
        int size = arrayList.size();
        if (size == 0) {
            C1725a.f("SetCommandManager", "The size is 0 when set key function.");
            return;
        }
        int i11 = 1;
        byte[] bArr = new byte[(size * 4) + 1];
        bArr[0] = (byte) (size & 255);
        for (int i12 = 0; i12 < size; i12++) {
            if (!((KeyFunctionInfo) arrayList.get(i12)).copyIntoData(bArr, i11)) {
                C1725a.f("SetCommandManager", "Failed when set key function.");
                return;
            }
            i11 += 4;
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, i10, bArr));
        this.mPollCommandManager.r(264, str);
    }

    public final void R(String str) {
        this.mPollCommandManager.l(str);
    }

    public final void R0(int i10, int i11, String str) {
        StringBuilder sbG = D0.g(i10, "m_spp_le.setLeAudioAction address：", str, ", type： ", ", value： ");
        sbG.append(i11);
        C1725a.e("HeadsetCoreService", sbG.toString());
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1060, str)) {
            C1725a.d("SetCommandManager", new A6.j(20), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1060, new byte[]{(byte) i10, (byte) i11}));
            C1725a.d("SetCommandManager", new C0456c(i10, i11, 2), str);
        }
    }

    @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
    public final void S(int i10, String str) {
        StringBuilder sbN = androidx.appcompat.widget.a.n(i10, "m_spp_le.onUpgradeFinish: ", ", cost time: ");
        sbN.append(System.currentTimeMillis() - this.mCostTime);
        C1725a.m("HeadsetCoreService", sbN.toString(), str);
        this.mCostTime = 0L;
        UpgradeStateInfo upgradeStateInfo = new UpgradeStateInfo();
        upgradeStateInfo.mAddress = str;
        upgradeStateInfo.mUpgradeState = 1048584;
        upgradeStateInfo.mUpgradeFinishStatus = i10;
        m0(new BluetoothReceiveData(1048584, upgradeStateInfo));
    }

    public final void S0(int i10, int i11, String str) {
        s sVar = this.mSetCommandManager;
        sVar.getClass();
        C1725a.c("SetCommandManager", new Ea.Q(i10, i11, 4));
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1067, new byte[]{(byte) i10, (byte) i11}));
    }

    public final void T(String str) {
        this.mPollCommandManager.m(str);
    }

    public final void T0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (sVar.f19337d.c(1042, str)) {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1042, new byte[]{(byte) i10}));
        } else {
            C1725a.d("SetCommandManager", new A6.j(21), str);
        }
    }

    public final void U(String str) {
        i iVar = this.mPollCommandManager;
        if (iVar.f19313c.c(308, str)) {
            iVar.f19311a.u0(str, iVar.f19312b.a(str, 308, C1047b.f23115b));
        } else {
            C1725a.b("PollCommandManager", "getHeadMotionType UNSUPPORTED cmd=0x" + Integer.toHexString(308), str);
        }
    }

    public final void U0(String str, RelatedDeviceInfo relatedDeviceInfo) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1032, str)) {
            C1725a.d("SetCommandManager", new C0371e(26), str);
            return;
        }
        String hostAddress = relatedDeviceInfo.getHostAddress();
        if (TextUtils.isEmpty(hostAddress)) {
            C1725a.f("SetCommandManager", "setRelatedDeviceInfo return, hostAddress is empty");
            return;
        }
        int hostType = relatedDeviceInfo.getHostType();
        List<RelatedDevice> relatedDevices = relatedDeviceInfo.getRelatedDevices();
        if (relatedDevices.size() > 6) {
            C1725a.f("SetCommandManager", "setRelatedDeviceInfo return,related devices overload size:" + relatedDevices.size());
            return;
        }
        int i10 = 8;
        byte[] bArr = new byte[(relatedDevices.size() * 8) + 8];
        bArr[0] = (byte) hostType;
        byte[] bArrK = D5.c.K(hostAddress);
        if (bArrK == null) {
            C1725a.f("SetCommandManager", "setRelatedDeviceInfo hostAddress error return");
            return;
        }
        System.arraycopy(bArrK, 0, bArr, 1, 6);
        bArr[7] = (byte) relatedDevices.size();
        for (RelatedDevice relatedDevice : relatedDevices) {
            bArr[i10] = (byte) relatedDevice.getType();
            int i11 = i10 + 1;
            byte[] bArrK2 = D5.c.K(relatedDevice.getAddress());
            if (bArrK2 == null) {
                C1725a.f("SetCommandManager", "setRelatedDeviceInfo address error return");
                return;
            } else {
                System.arraycopy(bArrK2, 0, bArr, i11, 6);
                bArr[i10 + 7] = (byte) relatedDevice.getState();
                i10 += 8;
            }
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1032, bArr));
    }

    public final boolean V(String str) {
        return this.mPollCommandManager.o(str);
    }

    public final void V0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1053, new byte[]{(byte) i10}));
    }

    public final boolean W(int i10, String str, ArrayList arrayList) {
        i iVar = this.mPollCommandManager;
        int i11 = 0;
        if (!iVar.f19313c.c(278, str)) {
            C1725a.d("PollCommandManager", new C0372f(11), str);
            return false;
        }
        int size = arrayList == null ? 0 : arrayList.size();
        if (arrayList == null) {
            return true;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 3) + 5);
        byteBufferAllocate.put((byte) size);
        int size2 = arrayList.size();
        while (i11 < size2) {
            Object obj = arrayList.get(i11);
            i11++;
            byteBufferAllocate.put(((HearingDetectingInfo) obj).getData());
        }
        byteBufferAllocate.putInt(i10);
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 278, byteBufferAllocate.array()));
        return true;
    }

    public final void W0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1054, str)) {
            C1725a.d("SetCommandManager", new C0372f(23), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1054, new byte[]{(byte) i10}));
            C1725a.c("SetCommandManager", new k(i10, 0));
        }
    }

    public final boolean X(String str) {
        return this.mPollCommandManager.p(str);
    }

    public final void X0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        sVar.getClass();
        C1725a.c("SetCommandManager", new Y(i10, 29));
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1072, new byte[]{(byte) i10}));
    }

    public final void Y(int i10, String str) {
        this.mPollCommandManager.r(i10, str);
    }

    public final void Y0(int i10, int i11, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1057, str)) {
            C1725a.d("SetCommandManager", new Q(28), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1057, new byte[]{(byte) i10, (byte) i11}));
            C1725a.c("SetCommandManager", new R8.t(i10, i11, 2));
        }
    }

    public final void Z(String str, boolean z2) {
        i iVar = this.mPollCommandManager;
        if (iVar.f19313c.c(306, str)) {
            iVar.f19311a.u0(str, iVar.f19312b.a(str, 306, new byte[]{(byte) (z2 ? 2 : 1)}));
        } else {
            C1725a.d("PollCommandManager", new Q(14), str);
        }
    }

    public final void Z0(String str, NoiseReductionInfo noiseReductionInfo) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1028, str)) {
            C1725a.d("SetCommandManager", new A6.j(25), str);
        } else {
            if (noiseReductionInfo == null) {
                C1725a.f("SetCommandManager", "set noiseReductionInfo is null, return; ");
                return;
            }
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1028, noiseReductionInfo.getData()));
        }
    }

    public final boolean a0(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(274, str)) {
            C1725a.d("PollCommandManager", new A6.j(14), str);
            return false;
        }
        C1725a.a("PollCommandManager", "getMultiConnectInformation..");
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 274, C1047b.f23115b));
        return true;
    }

    public final void a1(String str, final int i10, final boolean z2, boolean z4) {
        Integer numValueOf;
        s sVar = this.mSetCommandManager;
        sVar.getClass();
        C1725a.c("SetCommandManager", new Supplier() { // from class: com.oplus.melody.btsdk.protocol.commands.o
            @Override // java.util.function.Supplier
            public final Object get() {
                return "setSwitchFeature featureId = " + i10 + ", status = " + z2 + ", cmd = 1027";
            }
        });
        if (sVar.f19337d.c(1027, str) || i10 == 31) {
            byte[] bArr = {(byte) i10, z2 ? (byte) 1 : (byte) 0};
            if (i10 == 31) {
                C1725a.l("SetCommandManager", "m_bt_le.setSwitchFeature.CMD_SWITCH_FEATURE_LEA, status = " + z2 + ", cmd = " + E8.a.D(1027));
            }
            C1046a c1046aA = sVar.f19334a.a(str, 1027, bArr);
            sVar.f19335b.u0(str, c1046aA);
            numValueOf = Integer.valueOf(c1046aA.f23111b & 255);
        } else {
            C1725a.d("SetCommandManager", new C0372f(29), str);
            numValueOf = null;
        }
        if (z4) {
            return;
        }
        C1725a.c("HeadsetCoreService", new f0(i10, numValueOf, 5));
        this.mNoGetStateSet.add(numValueOf);
    }

    @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
    public final void b(int i10, String str) {
        C1725a.c("HeadsetCoreService", new L(i10, 19));
        UpgradeStateInfo upgradeStateInfo = new UpgradeStateInfo();
        upgradeStateInfo.mAddress = str;
        upgradeStateInfo.mUpgradeState = 1048583;
        upgradeStateInfo.mUpgradePercent = i10;
        m0(new BluetoothReceiveData(1048583, upgradeStateInfo));
    }

    public final void b0(String str) {
        this.mPollCommandManager.s(str);
    }

    public final void b1(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1069, str)) {
            C1725a.d("SetCommandManager", new C0371e(21), str);
        } else {
            C1725a.c("SetCommandManager", new k(i10, 1));
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1069, new byte[]{(byte) i10}));
        }
    }

    @Override // com.oplus.melody.btsdk.ota.IUpgradeListener
    public final void c(String str) {
        if (this.mCostTime == 0) {
            this.mCostTime = System.currentTimeMillis();
        }
        C1725a.c("HeadsetCoreService", new A6.j(7));
        UpgradeStateInfo upgradeStateInfo = new UpgradeStateInfo();
        upgradeStateInfo.mAddress = str;
        upgradeStateInfo.mUpgradeState = 1048582;
        m0(new BluetoothReceiveData(1048582, upgradeStateInfo));
    }

    public final void c0(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(282, str)) {
            C1725a.d("PollCommandManager", new C0371e(16), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 282, C1047b.f23115b));
    }

    public final void c1(String str, ToneFileVertifyInformation toneFileVertifyInformation) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1047, str)) {
            C1725a.d("SetCommandManager", new C0372f(26), str);
            return;
        }
        byte[] data = toneFileVertifyInformation.getData();
        C1725a.c("SetCommandManager", new T8.d(toneFileVertifyInformation, 24));
        if (data.length == 0) {
            C1725a.f("SetCommandManager", "Set tone check information is invalidate.");
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1047, data));
        }
    }

    public final void d0(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(295, str)) {
            C1725a.d("PollCommandManager", new Q(21), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 295, C1047b.f23115b));
    }

    public final void d1(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1070, str)) {
            C1725a.d("SetCommandManager", new A6.j(27), str);
        } else {
            C1725a.c("SetCommandManager", new D(i10, 28));
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1070, new byte[]{(byte) i10}));
        }
    }

    public final void e0(int i10, int i11, String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(294, str)) {
            C1725a.d("PollCommandManager", new C0372f(18), str);
            return;
        }
        C1725a.c("PollCommandManager", new C0456c(i10, i11, 1));
        byte[] bArrC = E8.a.C(i10);
        byte[] bArrC2 = E8.a.C(i11);
        byte[] bArr = new byte[8];
        System.arraycopy(bArrC, 0, bArr, 0, 4);
        System.arraycopy(bArrC2, 0, bArr, 4, 4);
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 294, bArr));
    }

    public final void e1(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1063, str)) {
            C1725a.d("SetCommandManager", new C0372f(27), str);
        } else {
            C1725a.c("SetCommandManager", new k(i10, 2));
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1063, new byte[]{(byte) i10}));
        }
    }

    public final void f0(String str) {
        this.mPollCommandManager.z(str);
    }

    public final void f1(String str, ZenModeFileVertifyInformation zenModeFileVertifyInformation) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1040, str)) {
            C1725a.d("SetCommandManager", new C0371e(27), str);
            return;
        }
        byte[] data = zenModeFileVertifyInformation.getData();
        if (data.length == 0) {
            C1725a.f("SetCommandManager", "Set zen check information is invalidate.");
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1040, data));
        }
    }

    public final void g0(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(307, str)) {
            C1725a.d("PollCommandManager", new C0371e(13), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 307, C1047b.f23115b));
    }

    public final void g1(String str, boolean z2) {
        s sVar = this.mSetCommandManager;
        sVar.getClass();
        C1725a.c("SetCommandManager", new G(18, z2));
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1068, new byte[]{z2 ? (byte) 1 : (byte) 0, 0}));
    }

    public final boolean h0(String str) {
        return this.mPollCommandManager.B(str);
    }

    public final void h1(int i10, int i11, String str, String str2, IUpgradeListener iUpgradeListener) {
        StringBuilder sbM = androidx.appcompat.widget.a.m(i10, i11, "startUpgrade upgradeType=", " deviceType=", " file=");
        sbM.append(str2);
        sbM.append(" mac=");
        sbM.append(str);
        C1725a.e("HeadsetCoreService", sbM.toString());
        UpgradeManager upgradeManager = this.mUpgradeManager;
        upgradeManager.getClass();
        UpgradeManager.a aVar = new UpgradeManager.a();
        aVar.f19368f = str2;
        aVar.f19364b = iUpgradeListener;
        aVar.f19366d = i10;
        aVar.f19367e = i11;
        aVar.h = new com.google.android.play.core.appupdate.f(upgradeManager.f19359f, str2);
        upgradeManager.f19356c.put(str, aVar);
        UpgradeManager.b bVarD = upgradeManager.d();
        if (bVarD == null) {
            C1725a.g("UpgradeManager", "startUpgrade handler is null", str);
        } else {
            bVarD.removeMessages(9, str);
            bVarD.obtainMessage(9, str).sendToTarget();
        }
    }

    public final void i0(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(304, str)) {
            C1725a.d("PollCommandManager", new C0372f(14), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 304, C1047b.f23115b));
    }

    public final void i1(String str, String str2, int i10, int i11) {
        StringBuilder sbG = D0.g(i10, "startUpgrade ", str, " upgradeType=", " deviceType=");
        sbG.append(i11);
        sbG.append(" file=");
        sbG.append(str2);
        C1725a.e("HeadsetCoreService", sbG.toString());
        if (i11 == 4) {
            h1(i10, i11, str, str2, this.mToneUpgradeListener);
        } else {
            h1(i10, i11, str, str2, this);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0b53  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0b53 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0cc0  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0ccf  */
    /* JADX WARN: Type inference failed for: r0v163 */
    /* JADX WARN: Type inference failed for: r0v164, types: [int] */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r6v81, types: [android.os.Handler] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j0(java.lang.String r34, f7.C1046a r35) {
        /*
            Method dump skipped, instruction units count: 3652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.multidevice.HeadsetCoreService.j0(java.lang.String, f7.a):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j1(java.lang.String r7, java.io.File r8, com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation r9) {
        /*
            r6 = this;
            com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager r0 = r6.mZenModeManager
            com.oplus.melody.btsdk.multidevice.HeadsetCoreService r1 = r0.f19373c
            if (r7 != 0) goto L7
            goto L1c
        L7:
            com.oplus.melody.btsdk.api.manager.DeviceInfoManager r2 = com.oplus.melody.btsdk.api.manager.DeviceInfoManager.a.f19280a
            r2.getClass()
            int r2 = com.google.android.play.core.appupdate.c.A(r7)
            boolean r2 = com.google.android.play.core.appupdate.c.J(r2)
            if (r2 == 0) goto L1c
            h7.a r2 = new h7.a
            r2.<init>(r7, r1)
            goto L1d
        L1c:
            r2 = 0
        L1d:
            if (r2 != 0) goto L27
            java.lang.String r8 = "ZenModeOTAManager"
            java.lang.String r9 = "Can't find processor"
            z7.C1725a.b(r8, r9, r7)
            return
        L27:
            com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$b r1 = new com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$b
            r1.<init>(r2, r9, r6)
            java.lang.Object r9 = r0.f19376f
            monitor-enter(r9)
            android.os.HandlerThread r3 = r0.f19377g     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L3a
            com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$a r3 = r0.h     // Catch: java.lang.Throwable -> L38
            if (r3 != 0) goto L54
            goto L3a
        L38:
            r7 = move-exception
            goto L7c
        L3a:
            android.os.HandlerThread r3 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L38
            java.lang.String r4 = "ZenModeOTAManager"
            r5 = -2
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L38
            r0.f19377g = r3     // Catch: java.lang.Throwable -> L38
            r3.start()     // Catch: java.lang.Throwable -> L38
            com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$a r3 = new com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$a     // Catch: java.lang.Throwable -> L38
            android.os.HandlerThread r4 = r0.f19377g     // Catch: java.lang.Throwable -> L38
            android.os.Looper r4 = r4.getLooper()     // Catch: java.lang.Throwable -> L38
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L38
            r0.h = r3     // Catch: java.lang.Throwable -> L38
        L54:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L38
            r3.<init>()     // Catch: java.lang.Throwable -> L38
            a7.c r4 = new a7.c     // Catch: java.lang.Throwable -> L38
            r5 = 3
            r4.<init>(r8, r5)     // Catch: java.lang.Throwable -> L38
            r3.add(r4)     // Catch: java.lang.Throwable -> L38
            android.util.Pair r8 = new android.util.Pair     // Catch: java.lang.Throwable -> L38
            r8.<init>(r7, r3)     // Catch: java.lang.Throwable -> L38
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$b> r3 = r0.f19375e     // Catch: java.lang.Throwable -> L38
            r3.put(r7, r1)     // Catch: java.lang.Throwable -> L38
            com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$a r7 = r0.h     // Catch: java.lang.Throwable -> L38
            r1 = 1
            android.os.Message r7 = r7.obtainMessage(r1, r2)     // Catch: java.lang.Throwable -> L38
            r7.obj = r8     // Catch: java.lang.Throwable -> L38
            com.oplus.melody.btsdk.protocol.upgrade.ZenModeOTAManager$a r8 = r0.h     // Catch: java.lang.Throwable -> L38
            r8.sendMessage(r7)     // Catch: java.lang.Throwable -> L38
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L38
            return
        L7c:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L38
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.multidevice.HeadsetCoreService.j1(java.lang.String, java.io.File, com.oplus.melody.btsdk.api.data.ZenModeFileVertifyInformation):void");
    }

    public final boolean k0(String str) {
        C1090a c1090a;
        UpgradeManager upgradeManager = this.mUpgradeManager;
        if (str != null) {
            UpgradeManager.a aVarC = upgradeManager.c(str);
            return (aVarC == null || (c1090a = aVarC.f19363a) == null || !c1090a.d()) ? false : true;
        }
        upgradeManager.getClass();
        C1725a.f("UpgradeManager", "macAddress is null when isUpgrading");
        return false;
    }

    public final void k1(int i10, String str) {
        int i11 = 0;
        s sVar = this.mSetCommandManager;
        if (sVar.f19337d.c(1029, str)) {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1029, new byte[]{(byte) i10}));
        } else {
            C1725a.d("SetCommandManager", new p(i11), str);
        }
    }

    public final boolean l0(String str) {
        ZenModeOTAManager.b bVar = this.mZenModeManager.f19375e.get(str);
        if (bVar == null) {
            return false;
        }
        return bVar.f19380a.d();
    }

    public final void l1(int i10, int i11, int i12, String str) {
        C0762a c0762a = this.mDebugCommandManager;
        if (!c0762a.f13393d.c(3840, str)) {
            C1725a.d("DebugCommandManager", new A6.j(9), str);
            return;
        }
        c0762a.f13391b.u0(str, c0762a.f13390a.a(str, 3840, new byte[]{(byte) i10, (byte) i11, (byte) i12}));
        c0762a.f13394e = 0;
        c0762a.f13395f = 0;
    }

    public final void m1(String str, HearingDetectingInfo hearingDetectingInfo) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1038, str)) {
            C1725a.d("SetCommandManager", new A6.j(24), str);
            return;
        }
        if (hearingDetectingInfo == null) {
            C1725a.g("SetCommandManager", "switchProcessHearingDetectionParams called fail, infos is empty", str);
            return;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put(hearingDetectingInfo.getData());
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1038, byteBufferAllocate.array()));
    }

    public final void n0(Context context) {
        C1725a.a("HeadsetCoreService", "on create");
        this.mContext = context;
        this.mDeviceConnectionApi = C1329b.d.f26334a;
        this.mDeviceInfoManager = DeviceInfoManager.a.f19280a;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        HandlerThread handlerThread = new HandlerThread("HeadsetCoreService", 10);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mWorkHandler = new e(this, this.mHandlerThread.getLooper());
        this.mPacketFactory = C1047b.a.f23117a;
        this.mUpgradeManager = new UpgradeManager(context, this);
        this.mZenModeManager = new ZenModeOTAManager(context, this);
        this.mPollCommandManager = new i(this, this.mWorkHandler);
        this.mSetCommandManager = new s(this, this.mWorkHandler);
        this.mRequestCommandManager = new j(this, this.mWorkHandler);
        this.mNotificationCommandManager = new g(this, this.mWorkHandler);
        this.mDebugCommandManager = new C0762a(this, this.mWorkHandler);
        this.mProtocolManager = d.a.f13069a;
        this.mPacketTimeoutProcessor = new b7.c(this, this.mPacketFactory, this.mHandlerThread.getLooper());
        Looper looper = this.mWorkHandler.getLooper();
        t tVar = new t();
        tVar.f19339a = looper;
        tVar.f19341c = this;
        tVar.f19340b = new ConcurrentHashMap<>();
        this.mUpgradePropertyProcessor = tVar;
        this.mPluginContext = new a();
        Iterator<U6.c> it = this.mPlugins.iterator();
        while (it.hasNext()) {
            it.next().getClass();
        }
        ((C1329b) this.mDeviceConnectionApi).f26325b.add(this.mConnectionStateListener);
        ((C1329b) this.mDeviceConnectionApi).f26326c.add(this.mCallback);
        t();
    }

    public final void n1(int i10, String str) {
        C1725a.d("HeadsetCoreService", new D(i10, 10), str);
        UpgradeManager upgradeManager = this.mUpgradeManager;
        if (str != null) {
            upgradeManager.f(10, i10, str);
        } else {
            upgradeManager.getClass();
            C1725a.f("UpgradeManager", "macAddress is null when switchUpgradeType");
        }
    }

    public final void o0(String str) {
        e eVar = this.mWorkHandler;
        if (eVar == null) {
            C1725a.f("HeadsetCoreService", "onUpgradePropertyAvailable: work handler is null");
        } else {
            eVar.obtainMessage(15, str).sendToTarget();
        }
    }

    public final void o1(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1062, str)) {
            C1725a.d("SetCommandManager", new A6.j(23), str);
        } else {
            C1725a.c("SetCommandManager", new D(i10, 24));
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1062, new byte[]{(byte) i10}));
        }
    }

    public final void p(IUpgradeListener iUpgradeListener) {
        UpgradeManager upgradeManager = this.mUpgradeManager;
        synchronized (upgradeManager.f19357d) {
            upgradeManager.f19357d.add(iUpgradeListener);
        }
    }

    public final void p0(String str, int i10, String str2, boolean z2) {
        byte[] bArrB;
        byte[] bArr;
        int i11 = 25;
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1065, str)) {
            C1725a.d("SetCommandManager", new C0371e(i11), str);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            bArrB = null;
        } else {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit == null || strArrSplit.length == 0) {
                C1725a.g("SetCommandManager", "operateMultiConnectHandheldDevice splitHandheldAddress is empty!", str);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            for (String str3 : strArrSplit) {
                sb2.append(str3);
            }
            bArrB = E8.a.B(sb2.toString());
            if (bArrB == null) {
                C1725a.f("SetCommandManager", "operateMultiConnectHandheldDevice handheldAddressBytes is null!");
                return;
            }
            A.a aVar = C1725a.f29476a;
            if (A.l()) {
                C1725a.a("SetCommandManager", "operateMultiConnectHandheldDevice handheldAddressBytes.length= " + bArrB.length);
            }
            if (bArrB.length > 6) {
                A6.g.j(new StringBuilder("operateMultiConnectHandheldDevice length is valid! "), bArrB.length, "SetCommandManager");
                return;
            }
        }
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            if (bArrB == null) {
                C1725a.f("SetCommandManager", "operateMultiConnectHandheldDevice handheldAddressBytes is null!");
                return;
            }
            byte[] bArr2 = new byte[7];
            bArr2[0] = (byte) i10;
            System.arraycopy(bArrB, 0, bArr2, 1, bArrB.length);
            bArr = bArr2;
        } else {
            if (i10 != 4) {
                A6.f.g(i10, "operateMultiConnectHandheldDevice operationType not valid! ", "SetCommandManager");
                return;
            }
            if (z2) {
                bArr = new byte[2];
            } else if (bArrB == null) {
                C1725a.f("SetCommandManager", "operateMultiConnectHandheldDevice handheldAddressBytes is null!");
                return;
            } else {
                byte[] bArr3 = new byte[8];
                System.arraycopy(bArrB, 0, bArr3, 2, bArrB.length);
                bArr = bArr3;
            }
            bArr[0] = (byte) i10;
            bArr[1] = (byte) (!z2 ? 1 : 0);
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1065, bArr));
        C1725a.d("SetCommandManager", new C8.a(str2, i11), str);
    }

    public final void q(ZenModeUpgradeListener zenModeUpgradeListener) {
        ZenModeOTAManager zenModeOTAManager = this.mZenModeManager;
        synchronized (zenModeOTAManager.f19372b) {
            zenModeOTAManager.f19374d.add(zenModeUpgradeListener);
        }
    }

    public final void q0(final int i10, final int i11, String str, final int i12, final int i13) {
        byte[] bArrArray;
        s sVar = this.mSetCommandManager;
        sVar.getClass();
        C1725a.c("SetCommandManager", new Supplier() { // from class: com.oplus.melody.btsdk.protocol.commands.m
            @Override // java.util.function.Supplier
            public final Object get() {
                return "processHearingEnhancementDetection: " + i10 + "  " + i11 + " " + i12 + " " + i13;
            }
        });
        if (!sVar.f19337d.c(1037, str)) {
            C1725a.d("SetCommandManager", new C0372f(24), str);
            return;
        }
        if (i10 == 3) {
            bArrArray = new byte[]{(byte) i10, (byte) i11, (byte) i13};
        } else if (i10 == 4) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(6);
            byteBufferAllocate.put((byte) i10);
            byteBufferAllocate.put((byte) i11);
            byteBufferAllocate.putInt(i12);
            bArrArray = byteBufferAllocate.array();
        } else {
            bArrArray = new byte[]{(byte) i10, (byte) i11};
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1037, bArrArray));
    }

    public final void r(String str) {
        C1725a.b("HeadsetCoreService", "cancelUpgrade", str);
        this.mUpgradeManager.b(str);
    }

    public final boolean r0(String str, C1046a c1046a) {
        C1725a.d("HeadsetCoreService", new Z6.b(c1046a, 0), str);
        if (c1046a == null) {
            return false;
        }
        b7.c cVar = this.mPacketTimeoutProcessor;
        cVar.getClass();
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            C1725a.f("PacketTimeoutProcessor", "removeTimeoutListener: params is invalid");
            return false;
        }
        synchronized (cVar.f13060a) {
            try {
                SparseArray<c.a> sparseArray = cVar.f13060a.get(str);
                if (sparseArray == null) {
                    C1725a.b("PacketTimeoutProcessor", "removeTimeoutListener: address not found", str);
                } else {
                    synchronized (sparseArray) {
                        try {
                            int iIndexOfKey = sparseArray.indexOfKey(c1046a.a());
                            if (iIndexOfKey >= 0) {
                                c.a aVarValueAt = sparseArray.valueAt(iIndexOfKey);
                                sparseArray.removeAt(iIndexOfKey);
                                c1046a.toString();
                                cVar.f13061b.removeCallbacks(aVarValueAt);
                                return true;
                            }
                            C1725a.g("PacketTimeoutProcessor", "removeTimeoutListener: packet not exist " + c1046a, str);
                        } finally {
                        }
                    }
                }
            } finally {
            }
        }
        return false;
    }

    public final void s(String str) {
        this.mZenModeManager.a(2, -1, str);
    }

    public final void s0(IUpgradeListener iUpgradeListener) {
        ZenModeOTAManager zenModeOTAManager = this.mZenModeManager;
        synchronized (zenModeOTAManager.f19372b) {
            zenModeOTAManager.f19374d.remove(iUpgradeListener);
        }
    }

    public final void t() {
        e eVar = this.mWorkHandler;
        if (eVar == null) {
            C1725a.f("HeadsetCoreService", "connectDeviceIfNeeded: work handler is null");
        } else {
            eVar.obtainMessage(1).sendToTarget();
        }
    }

    public final void t0(String str, String str2) {
        C0762a c0762a = this.mDebugCommandManager;
        if (!c0762a.f13393d.c(3843, str)) {
            C1725a.d("DebugCommandManager", new C0372f(7), str);
            return;
        }
        if (TextUtils.isEmpty(str2) || !str2.contains("\"cmd\":")) {
            C1725a.f("DebugCommandManager", "sendDiagnosticCommand， jsonData is empty or wrong, jsonCmd: " + str2);
        } else {
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            C1725a.c("DebugCommandManager", new Ca.b(str2, 17));
            c0762a.f13391b.u0(str, c0762a.f13390a.a(str, 3843, bytes));
        }
    }

    public final void u(String str) {
        if (this.mWorkHandler == null) {
            C1725a.f("HeadsetCoreService", "connectToDevice: work handler is null");
        } else {
            C1725a.m("HeadsetCoreService", "m_bt_le.connectToDevice: MSG_CONNECT_TO_DEVICE", str);
            this.mWorkHandler.obtainMessage(2, str).sendToTarget();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u0(java.lang.String r9, f7.C1046a r10) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.btsdk.multidevice.HeadsetCoreService.u0(java.lang.String, f7.a):boolean");
    }

    public final void v(String str, long j5) {
        if (this.mWorkHandler == null) {
            C1725a.f("HeadsetCoreService", "connectToDevice: work handler is null");
            return;
        }
        A.j(C1725a.j("HeadsetCoreService"), C1725a.i(D0.b("m_bt_le.connectToDevice: MSG_CONNECT_TO_DEVICE, delayTime: ", j5), str));
        e eVar = this.mWorkHandler;
        eVar.sendMessageDelayed(eVar.obtainMessage(2, str), j5);
    }

    public final void v0(String str, int i10, int i11, byte[] bArr) {
        ByteBuffer byteBufferAllocate;
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1045, str)) {
            C1725a.d("SetCommandManager", new A6.j(22), str);
            return;
        }
        if (bArr == null) {
            C1725a.f("SetCommandManager", "sendProcessEarScanData earScanData is null");
            return;
        }
        if (i10 == 1 || i10 == 3) {
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(bArr.length + 7);
            byteBufferAllocate2.put((byte) i10);
            byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate2.putShort((short) bArr.length);
            byteBufferAllocate2.order(ByteOrder.BIG_ENDIAN);
            if (bArr.length > 0) {
                byteBufferAllocate2.put(bArr);
            }
            byteBufferAllocate2.putInt(i11);
            byteBufferAllocate = byteBufferAllocate2;
        } else {
            byteBufferAllocate = ByteBuffer.allocate(1);
            byteBufferAllocate.put((byte) i10);
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1045, byteBufferAllocate.array()));
    }

    public final void w(String str, boolean z2) {
        if (this.mWorkHandler == null) {
            C1725a.g("HeadsetCoreService", "m_spp_le.directConnectSpp: work handler is null, connect： " + z2, str);
        } else {
            C1725a.m("HeadsetCoreService", "m_spp_le.directConnectSpp: MSG_DIRECT_CONNECT_TO_SPP, connect： " + z2, str);
            this.mWorkHandler.obtainMessage(73, z2 ? 1 : 0, -1, str).sendToTarget();
        }
    }

    public final void w0(String str, int i10, int i11, String str2, ArrayList arrayList) {
        ByteBuffer byteBufferAllocate;
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1038, str)) {
            C1725a.d("SetCommandManager", new C0371e(22), str);
            return;
        }
        int i12 = 0;
        int size = arrayList == null ? 0 : arrayList.size();
        if (i10 != 1 && i10 != 3) {
            byteBufferAllocate = ByteBuffer.allocate(1);
            byteBufferAllocate.put((byte) i10);
        } else {
            if (arrayList == null) {
                C1725a.g("SetCommandManager", "sendProcessHearingDetectionData called fail, infos is empty", str);
                return;
            }
            byte[] bytes = TextUtils.isEmpty(str2) ? new byte[0] : str2.getBytes(Charset.defaultCharset());
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((size * 3) + 6 + bytes.length);
            byteBufferAllocate2.put((byte) i10);
            byteBufferAllocate2.put((byte) size);
            int size2 = arrayList.size();
            while (i12 < size2) {
                Object obj = arrayList.get(i12);
                i12++;
                byteBufferAllocate2.put(((HearingDetectingInfo) obj).getData());
            }
            byteBufferAllocate2.putInt(i11);
            if (bytes.length > 0) {
                byteBufferAllocate2.put(bytes);
            }
            byteBufferAllocate = byteBufferAllocate2;
        }
        sVar.f19335b.u0(str, sVar.f19334a.a(str, 1038, byteBufferAllocate.array()));
    }

    public final void x(String str) {
        if (this.mWorkHandler == null) {
            C1725a.f("HeadsetCoreService", "disconnectDevice: work handler is null");
        } else {
            A.j(C1725a.j("HeadsetCoreService"), C1725a.i("m_bt_le.disconnectDevice", str));
            this.mWorkHandler.obtainMessage(3, 0, -1, str).sendToTarget();
        }
    }

    public final void x0(int i10, int i11, String str) {
        int i12 = 2;
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1064, str)) {
            C1725a.d("SetCommandManager", new C0371e(23), str);
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1064, new byte[]{(byte) i10, (byte) i11}));
            C1725a.c("SetCommandManager", new R7.b(i10, i11, i12));
        }
    }

    public final void y(String str) {
        this.mPollCommandManager.a(str);
    }

    public final void y0(int i10, String str) {
        s sVar = this.mSetCommandManager;
        if (!sVar.f19337d.c(1061, str)) {
            C1725a.d("SetCommandManager", new C0371e(20), str);
        } else {
            C1725a.c("SetCommandManager", new Y(i10, 27));
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1061, new byte[]{(byte) i10}));
        }
    }

    public final void z(String str) {
        i iVar = this.mPollCommandManager;
        if (!iVar.f19313c.c(305, str)) {
            C1725a.d("PollCommandManager", new Q(17), str);
            return;
        }
        iVar.f19311a.u0(str, iVar.f19312b.a(str, 305, C1047b.f23115b));
    }

    public final void z0(int i10, String str, String str2) {
        byte[] bArr;
        s sVar = this.mSetCommandManager;
        sVar.getClass();
        if (i10 == 0) {
            C1725a.a("SetCommandManager", "setAccountKey, action is none!");
            return;
        }
        if (i10 == 1 && TextUtils.isEmpty(str2)) {
            C1725a.f("SetCommandManager", "setAccountKey accountKey is empty!");
            return;
        }
        if (i10 == 1) {
            byte[] bArrB = E8.a.B(str2);
            bArr = new byte[bArrB.length + 3];
            bArr[0] = (byte) i10;
            bArr[1] = 1;
            bArr[2] = (byte) bArrB.length;
            System.arraycopy(bArrB, 0, bArr, 3, bArrB.length);
        } else {
            bArr = i10 == 2 ? new byte[]{(byte) i10} : null;
        }
        if (bArr == null) {
            C1725a.f("SetCommandManager", "setAccountKey data is null!");
        } else {
            sVar.f19335b.u0(str, sVar.f19334a.a(str, 1052, bArr));
        }
    }

    private HeadsetCoreService() {
        this.mDeviceInfoManager = null;
        this.mProtocolManager = null;
        this.mCostTime = 0L;
        this.mNoGetStateSet = new CopyOnWriteArraySet();
        this.mToneUpgradeListener = new ToneUpgradeListener(this);
        this.mCallback = new b();
        this.mConnectionStateListener = new c();
        this.mPlugins = (List) Stream.of((Object[]) new String[]{"demo_beta", "demo_rc"}).map(new C0388w(18)).filter(new W6.a(1)).collect(Collectors.toList());
    }
}
