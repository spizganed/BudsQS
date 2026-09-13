package com.oplus.melody.leaudio;

import Ca.r;
import D7.C0391z;
import D7.o0;
import Ea.C0395d;
import I7.f;
import I7.j;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.coui.appcompat.uiutil.AnimLevel;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistContentDO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.common.util.RunnableC0903i;
import com.oplus.melody.common.util.S;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.db.B;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.track.Track;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;
import t8.q;

/* JADX INFO: compiled from: LeAudioFilterFunHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f19630a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f19631b = new ArrayList();

    /* JADX INFO: compiled from: LeAudioFilterFunHelper.java */
    public interface a {
        void c();
    }

    /* JADX INFO: renamed from: com.oplus.melody.leaudio.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LeAudioFilterFunHelper.java */
    public static final class C0229b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f19632a = new b();
    }

    /* JADX INFO: compiled from: LeAudioFilterFunHelper.java */
    public interface c {
        void j(boolean z2);
    }

    public b() {
        c();
    }

    public static void d(Context context, String str) {
        try {
            C0391z.f1171d.getClass();
            BluetoothDevice bluetoothDeviceI = C0391z.i(str);
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", bluetoothDeviceI);
            Intent intent = new Intent("wireless.settings.DEVICE_PROFILES_SETTINGS");
            intent.putExtra(":settings:show_fragment_args", bundle);
            intent.putExtra("highlight_args_key", "LE_AUDIO");
            intent.addFlags(343932928);
            h.e(context, "context");
            C0905k.j(context, intent);
            A.f("m_bt_le.LeAudioFilterFunHelper", "gotoWirelessSettings, device: " + bluetoothDeviceI + ", getExtras: " + intent.getExtras());
        } catch (Exception e10) {
            A.i("m_bt_le.LeAudioFilterFunHelper", "gotoWirelessSettings: ", e10);
        }
    }

    public final void a(String str, String str2, c cVar) {
        CompletableFuture.supplyAsync(new f(this, str, str2, 0)).whenCompleteAsync((BiConsumer) new C0395d(2, str, cVar), (Executor) o0.c.f1144b);
    }

    public final void b(final Context context, final String str, final String str2, final a aVar) {
        CompletableFuture.supplyAsync(new j(this, str, str2, 0)).whenCompleteAsync(new BiConsumer() { // from class: I7.k
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                int funId;
                int i10 = 0;
                Boolean bool = (Boolean) obj;
                this.f2269a.getClass();
                StringBuilder sb2 = new StringBuilder("clickFunction.whenComplete, address: ");
                String str3 = str;
                sb2.append(str3);
                sb2.append(", needFilter: ");
                sb2.append(bool);
                sb2.append(", funType: ");
                String funType = str2;
                sb2.append(funType);
                A.g("m_bt_le.LeAudioFilterFunHelper", sb2.toString(), (Throwable) obj2);
                if (!bool.booleanValue()) {
                    b.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.c();
                        return;
                    }
                    return;
                }
                EarphoneDTO earphoneDTOW = AbstractC0939b.E().w(str3);
                if (earphoneDTOW != null) {
                    String productId = earphoneDTOW.getProductId();
                    String macAddress = earphoneDTOW.getMacAddress();
                    String strT = N.t(earphoneDTOW);
                    ArrayList arrayList = LeFilterConstants.f19611a;
                    kotlin.jvm.internal.h.e(funType, "funType");
                    LeFilterConstants.FunType[] funTypeArrValues = LeFilterConstants.FunType.values();
                    int length = funTypeArrValues.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            funId = LeFilterConstants.FunType.NONE.getFunId();
                            break;
                        }
                        LeFilterConstants.FunType funType2 = funTypeArrValues[i11];
                        if (TextUtils.equals(funType2.getFunType(), funType)) {
                            funId = funType2.getFunId();
                            break;
                        }
                        i11++;
                    }
                    if (TextUtils.isEmpty(productId) || !B8.a.d(productId, macAddress)) {
                        A6.b.g("trackLeFilterFunClick, someone is null, earbudsId: ", productId, "AppTrackHelper");
                    } else {
                        ForkJoinPool.commonPool().execute(new RunnableC0903i(16, new B(funId, productId, macAddress, strT), new Track("melody_le_filter_function_click", "10610001")));
                    }
                }
                boolean zEquals = LeFilterConstants.FunType.MULTI_CONNECT.getFunType().equals(funType);
                Context context2 = context;
                String string = zEquals ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_multi_device) : LeFilterConstants.FunType.HI_QUALITY_AUDIO.getFunType().equals(funType) ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_hi_res) : LeFilterConstants.FunType.SPATIAL_AUDIO.getFunType().equals(funType) ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_spatial_audio) : LeFilterConstants.FunType.SOUND_RECORD.getFunType().equals(funType) ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_ear_record) : LeFilterConstants.FunType.CHANNEL_SWITCH.getFunType().equals(funType) ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_change_channel) : LeFilterConstants.FunType.GAME_MODE.getFunType().equals(funType) ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_game_mode) : LeFilterConstants.FunType.AUTO_SWITCH_LINK.getFunType().equals(funType) ? context2.getResources().getString(R.string.melody_common_dialog_close_le_summary_auto_switch_link) : "";
                if (TextUtils.isEmpty(string) || !((q.n() || (B8.a.f() && q.q())) && S.p())) {
                    E8.a.S(context2, R.string.melody_common_le_not_support_function_tips);
                    return;
                }
                G7.b bVar = new G7.b(context2);
                bVar.f4444E.f(true, AnimLevel.MID_END);
                bVar.o(string);
                bVar.l(R.string.melody_common_dialog_go_setting, new Ca.d(2, context2, str3));
                bVar.h(R.string.dialog_cancel, new l(i10));
                bVar.setCancelable(false).create().show();
            }
        }, (Executor) o0.c.f1144b);
    }

    public final void c() {
        WhitelistContentDO whitelistContentDOH = AbstractC1508a.f().h();
        ArrayList arrayList = this.f19631b;
        arrayList.clear();
        if (whitelistContentDOH != null && whitelistContentDOH.getLeAllFilterFunctions() != null) {
            arrayList.addAll(whitelistContentDOH.getLeAllFilterFunctions());
        }
        A.c("m_bt_le.LeAudioFilterFunHelper", new r(this, 18));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0136 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.leaudio.b.e(java.lang.String, java.lang.String):boolean");
    }
}
