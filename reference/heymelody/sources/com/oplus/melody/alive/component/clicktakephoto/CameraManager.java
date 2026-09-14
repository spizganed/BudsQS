package com.oplus.melody.alive.component.clicktakephoto;

import B6.f;
import D7.C0379m;
import D7.C0391z;
import D7.o0;
import D7.q0;
import L7.a;
import X3.l;
import Y.r;
import a9.RunnableC0537c;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.media3.exoplayer.C0625v;
import com.oplus.melody.common.addon.MelodyAppEnterInfo;
import com.oplus.melody.common.addon.MelodyAppExitInfo;
import com.oplus.melody.common.addon.MelodyAppSwitchManager;
import com.oplus.melody.common.addon.MelodyOnAppSwitchObserver;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0900f;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.S;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes.dex */
public class CameraManager extends K7.a {
    private static final long CAMERA_STATUS_SEND_DELAY_TIME = 500;
    private static final String TAG = "CameraManager";
    private e mCameraViewModel;
    private Context mContext;
    private final HashMap<String, CompletableFuture<SetCommandStateDTO>> mFutureMap = new HashMap<>();
    private final MelodyOnAppSwitchObserver mOplusObserver = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$init$0() {
        return "init ".concat(getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onEvent$1(com.oplus.melody.alive.component.clicktakephoto.a aVar) {
        return C0625v.i(aVar.mAddress, new StringBuilder("start capture "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onEvent$2(com.oplus.melody.alive.component.clicktakephoto.a aVar) {
        return C0625v.i(aVar.mAddress, new StringBuilder("EVENT_ID_BT_CAPABILITY_INIT_COMPLETE "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onEvent$3(com.oplus.melody.alive.component.clicktakephoto.a aVar) {
        WhitelistConfigDTO.Function function;
        WhitelistConfigDTO whitelistConfigDTOA = AbstractC1508a.f().a(aVar.mAddress);
        if (whitelistConfigDTOA == null || (function = whitelistConfigDTOA.getFunction()) == null) {
            return;
        }
        if (Y.e(function.getClickTakePic(), false) || Y.e(function.getClickTakePicNew(), false)) {
            sendSystemCameraStatus(aVar.mAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$sendSystemCameraStatus$5(int i10, String str) {
        return C0625v.i(str, androidx.appcompat.widget.a.n(i10, "sendSystemCameraStatus start status=", ", adr = "));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$sendSystemCameraStatus$6(SetCommandStateDTO setCommandStateDTO) {
        return "sendSystemCameraStatus setCommandState=" + setCommandStateDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendSystemCameraStatus$7(SetCommandStateDTO setCommandStateDTO) {
        A.c(TAG, new f(3, setCommandStateDTO));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$sendSystemCameraStatus$8(Throwable th) {
        A.i(TAG, "sendSystemCameraStatus failure", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$sendSystemCameraStatusToAllConnectedHeadset$4() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            A.h(TAG, "sendSystemCameraStatusToAllConnectedHeadset address is empty!");
            return;
        }
        Set<BluetoothDevice> setD = C0391z.f1171d.d(defaultAdapter);
        if (setD == null) {
            setD = Collections.EMPTY_SET;
        }
        for (BluetoothDevice bluetoothDevice : setD) {
            if (bluetoothDevice != null && !TextUtils.isEmpty(bluetoothDevice.getAddress()) && AbstractC0939b.E().a(bluetoothDevice.getAddress(), 2)) {
                sendSystemCameraStatus(bluetoothDevice.getAddress());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEvent(com.oplus.melody.alive.component.clicktakephoto.a aVar) {
        switch (aVar.mEventId) {
            case 1048631:
                Context context = this.mContext;
                if (C0900f.a() && C0900f.b(context)) {
                    A.c(TAG, new l(aVar, 10));
                    startCameraCapture();
                } else {
                    r.l(aVar.mAddress, TAG, new StringBuilder("EVENT_ID_BT_REQUEST_CAMERA_OPERATION camera not ready! "));
                    sendSystemCameraStatus(aVar.mAddress);
                }
                break;
            case 1048632:
                A.b(TAG, "EVENT_ID_BT_REQUEST_CAMERA_STATUS");
                sendSystemCameraStatus(aVar.mAddress);
                break;
            case 1048649:
                A.c(TAG, new T8.d(aVar, 17));
                o0.c.f1145c.a().postDelayed(new b(0, this, aVar), CAMERA_STATUS_SEND_DELAY_TIME);
                break;
        }
    }

    private void registerCameraAppChanged() {
        MelodyAppSwitchManager.INSTANCE.registerAppSwitchObserver(this.mContext, this.mOplusObserver, Arrays.asList("com.oplus.camera.Camera", "com.oppo.camera.Camera"), Arrays.asList("com.oplus.camera", "com.oppo.camera"));
    }

    @Override // K7.a
    public void init(Context context) {
        A.c(TAG, new S7.c(this, 20));
        this.mContext = context.getApplicationContext();
        this.mCameraViewModel = new e();
        Object obj = L7.a.f3010c;
        C0379m.i(C0379m.f(a.C0032a.a().a(), new r(24)), new C6.e(this, 18), o0.c.f1145c);
        registerCameraAppChanged();
    }

    public void sendSystemCameraStatus(String str) {
        CompletableFuture<SetCommandStateDTO> completableFutureC0;
        if (TextUtils.isEmpty(str)) {
            A.h(TAG, "sendSystemCameraStatus address is empty!");
            return;
        }
        if (this.mCameraViewModel == null) {
            A.h(TAG, "sendSystemCameraStatus mCameraViewModel is null!");
            return;
        }
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mFutureMap.get(str);
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        int i10 = ((C0900f.a() && C0900f.b(this.mContext)) ? 1 : 0) ^ 1;
        A.c(TAG, new Aa.a(i10, str, 7));
        this.mCameraViewModel.getClass();
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            completableFutureC0 = AbstractC0939b.E().c0(i10, str);
        } else {
            A.h("CameraViewModel", "set status empty");
            completableFutureC0 = q0.b(MelodyException.e(0, "add is null"));
        }
        this.mFutureMap.put(str, completableFutureC0);
        completableFutureC0.thenAccept((Consumer<? super SetCommandStateDTO>) new B6.e(1)).exceptionally((Function<Throwable, ? extends Void>) new A6.c(25));
    }

    public void sendSystemCameraStatusToAllConnectedHeadset() {
        o0.c.f1145c.execute(new RunnableC0537c(this, 13));
    }

    public boolean startCameraCapture() {
        Intent intent = new Intent("com.oplus.camera.IOT_CAPTURE");
        if (S.v(this.mContext, "com.oplus.camera")) {
            intent.setPackage("com.oplus.camera");
        } else {
            intent.setPackage("com.oppo.camera");
        }
        C0905k.i(this.mContext, intent, "oplus.permission.OPLUS_COMPONENT_SAFE");
        return true;
    }

    public class a implements MelodyOnAppSwitchObserver {
        public a() {
        }

        @Override // com.oplus.melody.common.addon.MelodyOnAppSwitchObserver
        public final void onActivityEnter(MelodyAppEnterInfo melodyAppEnterInfo) {
            A.c(CameraManager.TAG, new c(melodyAppEnterInfo, 0));
            if (TextUtils.equals(melodyAppEnterInfo.getTargetName(), "com.oplus.camera.Camera") || TextUtils.equals(melodyAppEnterInfo.getTargetName(), "com.oppo.camera.Camera")) {
                CameraManager.this.sendSystemCameraStatusToAllConnectedHeadset();
            }
        }

        @Override // com.oplus.melody.common.addon.MelodyOnAppSwitchObserver
        public final void onActivityExit(MelodyAppExitInfo melodyAppExitInfo) {
            A.c(CameraManager.TAG, new d(melodyAppExitInfo, 0));
            if (TextUtils.equals(melodyAppExitInfo.getTargetName(), "com.oplus.camera.Camera") || TextUtils.equals(melodyAppExitInfo.getTargetName(), "com.oppo.camera.Camera")) {
                CameraManager.this.sendSystemCameraStatusToAllConnectedHeadset();
            }
        }

        @Override // com.oplus.melody.common.addon.MelodyOnAppSwitchObserver
        public final void onAppEnter(MelodyAppEnterInfo melodyAppEnterInfo) {
        }

        @Override // com.oplus.melody.common.addon.MelodyOnAppSwitchObserver
        public final void onAppExit(MelodyAppExitInfo melodyAppExitInfo) {
        }
    }
}
