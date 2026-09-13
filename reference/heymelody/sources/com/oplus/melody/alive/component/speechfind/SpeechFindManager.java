package com.oplus.melody.alive.component.speechfind;

import C6.b;
import C6.c;
import C6.d;
import C6.e;
import D7.C0379m;
import D7.C0381o;
import D7.o0;
import L7.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.model.bluetooth.BluetoothReceiveDTO;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SpeechFindManager extends K7.a {
    public static final String ACTION_COMMAND = "com.pods.find.COMMAND";
    public static final String ACTION_CONNECTION_STATE = "com.pods.find.CONNECTION_STATE";
    public static final String ACTION_RESPONSE_COMMAND = "com.pods.find.RESPONSE_COMMAND";
    public static final String ACTION_RESPONSE_HEADSET = "com.pods.find.RESPONSE_HEADSET";
    public static final String ACTION_WEAR_STATE = "com.pods.find.WEAR_STATE";
    public static final int CMD_EXIT_FIND = 3;
    public static final int CMD_FIND = 2;
    public static final int CMD_QUERY = 1;
    public static final String CODE = "code";
    public static final String CONN_STATE = "conn_state";
    public static final String HEADSET_LIST = "headset_list";
    public static final String LEFT_WEAR_STATE = "left_wear_state";
    public static final String MAC = "mac";
    public static final String PERMISSION_IOT_SAFE = "com.oplus.permission.safe.IOT";
    public static final int RESPONSE_DISCONNECT = 2;
    public static final int RESPONSE_OK = 0;
    public static final String RIGHT_WEAR_STATE = "right_wear_state";
    public static final String SEQ = "seq";
    public static final String TAG = "SpeechFindManager";
    public static final String TYPE = "type";
    private Context mContext;
    private final BroadcastReceiver mReceiver = new a();
    private C0381o<b> mRecord;
    private Map<String, b> mSpeechFindDOMap;

    public class a extends BroadcastReceiver {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r12v10 */
        /* JADX WARN: Type inference failed for: r12v3, types: [int] */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        /* JADX WARN: Type inference failed for: r13v10 */
        /* JADX WARN: Type inference failed for: r13v13 */
        /* JADX WARN: Type inference failed for: r13v14 */
        /* JADX WARN: Type inference failed for: r13v15 */
        /* JADX WARN: Type inference failed for: r13v16 */
        /* JADX WARN: Type inference failed for: r13v17 */
        /* JADX WARN: Type inference failed for: r13v3, types: [int] */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v9 */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [int] */
        /* JADX WARN: Type inference failed for: r14v10 */
        /* JADX WARN: Type inference failed for: r14v11 */
        /* JADX WARN: Type inference failed for: r14v9 */
        /* JADX WARN: Type inference failed for: r4v10, types: [int] */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r9v4, types: [C6.a, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.StringBuilder] */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onReceive(android.content.Context r17, android.content.Intent r18) {
            /*
                Method dump skipped, instruction units count: 609
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.alive.component.speechfind.SpeechFindManager.a.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getHeadsetState$0(t tVar, BluetoothReceiveDTO bluetoothReceiveDTO) {
        Parcelable data = bluetoothReceiveDTO.getData();
        if (data instanceof DeviceInfo) {
            if (bluetoothReceiveDTO.getEventId() == 1048594 || bluetoothReceiveDTO.getEventId() == 1048595) {
                b bVar = new b(bluetoothReceiveDTO.getEventId(), (DeviceInfo) data);
                b bVar2 = this.mSpeechFindDOMap.get(bVar.getAddress() + 1048594);
                if (bVar2 == null || bVar.getConnected() != bVar2.getConnected()) {
                    tVar.l(bVar);
                }
                this.mSpeechFindDOMap.put(bVar.getAddress() + 1048594, bVar);
                return;
            }
            if (bluetoothReceiveDTO.getEventId() == 1048598) {
                b bVar3 = new b(bluetoothReceiveDTO.getEventId(), (DeviceInfo) data);
                b bVar4 = this.mSpeechFindDOMap.get(bVar3.getAddress() + 1048598);
                if (bVar4 == null || bVar3.getLeftInEar() != bVar4.getLeftInEar() || bVar3.getRightInEar() != bVar4.getRightInEar()) {
                    tVar.l(bVar3);
                }
                this.mSpeechFindDOMap.put(bVar3.getAddress() + 1048598, bVar3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onHeadsetStateChanged$1(b bVar) {
        return "onHeadsetStateChanged connected:" + bVar.getConnected() + " adr:" + A.r(bVar.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onHeadsetStateChanged$2(boolean z2, boolean z4, b bVar) {
        return "onHeadsetStateChanged left:" + z2 + " right:" + z4 + " adr:" + A.r(bVar.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHeadsetStateChanged(b bVar) {
        switch (bVar.getEventId()) {
            case 1048594:
            case 1048595:
                A.c(TAG, new B6.a(bVar, 1));
                Intent intent = new Intent(ACTION_CONNECTION_STATE);
                intent.putExtra(MAC, bVar.getAddress());
                intent.putExtra(CONN_STATE, bVar.getConnected() ? 1 : 0);
                C0905k.i(this.mContext, intent, PERMISSION_IOT_SAFE);
                break;
            case 1048598:
                boolean leftInEar = bVar.getLeftInEar();
                boolean rightInEar = bVar.getRightInEar();
                A.c(TAG, new c(leftInEar, rightInEar, bVar, 0));
                Intent intent2 = new Intent(ACTION_WEAR_STATE);
                intent2.putExtra(MAC, bVar.getAddress());
                intent2.putExtra(LEFT_WEAR_STATE, leftInEar ? 1 : 0);
                intent2.putExtra(RIGHT_WEAR_STATE, rightInEar ? 1 : 0);
                C0905k.i(this.mContext, intent2, PERMISSION_IOT_SAFE);
                break;
        }
    }

    public s<b> getHeadsetState() {
        t tVar = new t();
        Object obj = L7.a.f3010c;
        tVar.m(a.C0032a.a().a(), new d(0, this, tVar));
        return C0379m.b(tVar);
    }

    @Override // K7.a
    public void init(Context context) {
        A.b(TAG, "init");
        this.mContext = context;
        this.mSpeechFindDOMap = new androidx.collection.a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_COMMAND);
        C0905k.f(context, this.mReceiver, intentFilter, PERMISSION_IOT_SAFE, o0.c.f1145c.a());
        this.mRecord = C0379m.i(getHeadsetState(), new e(this, 0), C0379m.f1127a);
    }

    @Override // K7.a
    public void terminate() {
        super.terminate();
        this.mRecord.a();
        C0905k.o(this.mContext, this.mReceiver);
    }
}
