package com.oplus.melody.model.scan;

import C6.e;
import D6.f;
import D7.C0379m;
import D7.o0;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.u;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.HeadsetRssiDetectionDTO;
import com.oplus.melody.model.repository.earphone.L;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import o8.AbstractC1382a;

/* JADX INFO: compiled from: OplusBleRssiManager.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u<Map<String, HeadsetRssiDetectionDTO>> f20226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f20227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f20228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f20229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f20230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final L f20231g;

    /* JADX INFO: compiled from: OplusBleRssiManager.java */
    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f20232a;

        public a(b bVar) {
            super(o0.c.f1145c.b());
            this.f20232a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = this.f20232a.get();
            if (bVar == null) {
                return;
            }
            String str = (String) message.obj;
            if (A.l()) {
                A.b("OplusBleRssiManager", "handleMessage tag=" + message.what + ", address=" + A.r(str));
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (bVar.f20227c.remove(str) != null) {
                A.c("OplusBleRssiManagerThreshold", new f(str, 17));
            }
            bVar.f20231g.Y0(str);
        }
    }

    public b(Context context, L l4) {
        new ConcurrentHashMap();
        this.f20225a = new a(this);
        this.f20226b = new u<>();
        this.f20227c = new ConcurrentHashMap();
        this.f20228d = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f20229e = new ArrayList();
        this.f20230f = context;
        this.f20231g = l4;
        Object obj = AbstractC1382a.f26570c;
        C0379m.i(AbstractC1382a.C0294a.a().b(), new e(this, 23), C0379m.f1127a);
    }

    public final synchronized void a() {
        if (this.f20230f == null) {
            A.x("OplusBleRssiManager", "unregisterSensor, mContext is null");
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        float f9 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
