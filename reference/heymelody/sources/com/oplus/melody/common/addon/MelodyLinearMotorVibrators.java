package com.oplus.melody.common.addon;

import android.annotation.SuppressLint;
import android.content.Context;
import com.oplus.melody.common.util.A;
import com.oplus.os.LinearmotorVibrator;
import com.oplus.os.WaveformEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyLinearMotorVibrators.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/oplus/melody/common/addon/MelodyLinearMotorVibrators;", "", "<init>", "()V", "TAG", "", "vibrate", "", "context", "Landroid/content/Context;", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyLinearMotorVibrators {
    public static final MelodyLinearMotorVibrators INSTANCE = new MelodyLinearMotorVibrators();
    public static final String TAG = "MelodyLinearMotorVibrators";

    private MelodyLinearMotorVibrators() {
    }

    @SuppressLint({"WrongConstant"})
    public final boolean vibrate(Context context) {
        h.e(context, "context");
        try {
            Object systemService = context.getSystemService("linearmotor");
            if (!(systemService instanceof LinearmotorVibrator)) {
                return false;
            }
            ((LinearmotorVibrator) systemService).vibrate(new WaveformEffect.Builder().setEffectType(3).setAsynchronous(true).build());
            return true;
        } catch (Throwable th) {
            A.i(TAG, "vibrate", th);
            return false;
        }
    }
}
