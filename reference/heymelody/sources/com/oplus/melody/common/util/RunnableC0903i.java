package com.oplus.melody.common.util;

import D7.o0;
import android.animation.ValueAnimator;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.metrics.NetworkEvent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.session.q1;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.DeviceInfo;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.track.track.Track;
import com.oplus.melody.ui.component.control.guide.GuideEntranceFragment;
import com.oplus.melody.ui.component.detail.highaudio.HighAudioPreferenceFragment;
import com.oplus.melody.ui.component.detail.voiceassist.VoiceAssistFragmentV3;
import com.oplus.melody.ui.component.hearingenhance.widget.VoiceWaveView;
import com.oplus.melody.ui.widget.MelodyRadioPreference;
import da.C0975b;
import h9.ViewOnClickListenerC1096a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kc.C1264t;
import o7.C1376d;
import o7.C1380h;
import v9.C1582a;
import z7.C1725a;

/* JADX INFO: renamed from: com.oplus.melody.common.util.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0903i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19495c;

    public /* synthetic */ RunnableC0903i(int i10, Object obj, Object obj2) {
        this.f19493a = i10;
        this.f19494b = obj;
        this.f19495c = obj2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        Runnable runnable;
        COUIPreferenceCategory cOUIPreferenceCategory;
        Object next;
        int i10 = 0;
        switch (this.f19493a) {
            case 0:
                BroadcastReceiver receiver = (BroadcastReceiver) this.f19495c;
                kotlin.jvm.internal.h.e(receiver, "receiver");
                Context context = (Context) this.f19494b;
                if (context == null) {
                    return;
                }
                try {
                    context.unregisterReceiver(receiver);
                    return;
                } catch (Throwable th) {
                    A.i("ContextExt", "unregisterReceiverCompat", th);
                    return;
                }
            case 1:
                com.oplus.melody.model.repository.earphone.L l4 = (com.oplus.melody.model.repository.earphone.L) this.f19494b;
                l4.getClass();
                EarphoneDTO earphoneDTOW = l4.w(((DeviceInfo) this.f19495c).getDeviceAddress());
                if (earphoneDTOW == null || !W6.b.f(earphoneDTOW.getMacAddress()) || !V.b(earphoneDTOW.getMacAddress()) || com.oplus.melody.model.repository.earphone.N.k(61192, earphoneDTOW.getEarCapability())) {
                    return;
                }
                V.c(earphoneDTOW.getMacAddress(), false);
                A.x("EarphoneRepository", "onCapabilityInitComplete setBrLeCoexistStatus=false ok");
                C1264t.t(AppConstant$FunctionType.GAME_LOW_LATENCY.getFunType(), earphoneDTOW.getProductId(), earphoneDTOW.getMacAddress(), com.oplus.melody.model.repository.earphone.N.t(earphoneDTOW), VersionInfo.VENDOR_CODE_DEFAULT_VERSION);
                B8.a.e();
                return;
            case 2:
                com.oplus.melody.model.repository.earphone.L l10 = (com.oplus.melody.model.repository.earphone.L) this.f19494b;
                l10.getClass();
                boolean zL = A.l();
                com.oplus.melody.model.db.E e10 = (com.oplus.melody.model.db.E) this.f19495c;
                if (zL) {
                    A.b("EarphoneRepository", "insertOrUpdate " + A.r(e10.getMacAddress()) + " name='" + A.q(e10.getName()) + "' productId=" + e10.getProductId() + " color=" + e10.getColorId());
                }
                l10.f19932u.d(e10);
                return;
            case 3:
                ((com.oplus.melody.ui.component.detail.voiceassist.c) this.f19494b).f21360F.setChecked(!((Boolean) this.f19495c).booleanValue());
                return;
            case 4:
                AbstractC0939b abstractC0939bE = AbstractC0939b.E();
                VoiceAssistFragmentV3 voiceAssistFragmentV3 = (VoiceAssistFragmentV3) this.f19494b;
                EarphoneDTO earphoneDTOW2 = abstractC0939bE.w(voiceAssistFragmentV3.f21316A);
                if (earphoneDTOW2 != null) {
                    C1264t.t(AppConstant$FunctionType.MORE_VOICE_SETTING.getFunType(), earphoneDTOW2.getProductId(), voiceAssistFragmentV3.f21316A, com.oplus.melody.model.repository.earphone.N.t(earphoneDTOW2), (String) this.f19495c);
                    return;
                }
                return;
            case 5:
                C0975b c0975b = C0975b.this;
                int iE = C0975b.e(c0975b, (String) this.f19495c);
                if (iE == -1) {
                    A.h("ZenModeSceneAdapter", "onCancel, position is invalid");
                    return;
                } else {
                    ((da.d) c0975b.f22291e.get(iE)).f22305g = false;
                    c0975b.notifyItemChanged(iE);
                    return;
                }
            case 6:
                ((g0.j) this.f19494b).f23261d.reportNetworkEvent((NetworkEvent) this.f19495c);
                return;
            case 7:
                h0.i iVar = (h0.i) this.f19494b;
                iVar.getClass();
                String str = b0.H.f12877a;
                androidx.media3.exoplayer.C.this.f9310s.d0((String) this.f19495c);
                return;
            case 8:
                ViewOnClickListenerC1096a viewOnClickListenerC1096a = (ViewOnClickListenerC1096a) this.f19494b;
                ViewGroup.LayoutParams layoutParams = viewOnClickListenerC1096a.f23763t.getLayoutParams();
                layoutParams.width = ((TextView) this.f19495c).getWidth();
                viewOnClickListenerC1096a.f23763t.setLayoutParams(layoutParams);
                return;
            case 9:
                ka.g gVar = (ka.g) this.f19494b;
                GuideEntranceFragment.GuideEntranceMode guideEntranceMode = gVar.f25289f;
                if ("INTRO_OPEN_MULTI_CONNECT".equals(guideEntranceMode != null ? guideEntranceMode.name() : null)) {
                    gVar.f25290g.putBoolean("route_value2", ka.h.a(gVar.h));
                }
                o0.c.f1143a.post(new g0.i(7, gVar, (androidx.fragment.app.p) this.f19495c));
                return;
            case 10:
                MediaCodecRenderer mediaCodecRenderer = (MediaCodecRenderer) this.f19494b;
                mediaCodecRenderer.f10096P.set(mediaCodecRenderer.Q((androidx.media3.exoplayer.N) this.f19495c, mediaCodecRenderer.f10084J, 0));
                return;
            case 11:
                VoiceWaveView voiceWaveView = ((na.c) this.f19494b).f26499b;
                ValueAnimator valueAnimator = voiceWaveView.f21617q;
                if (valueAnimator != null) {
                    valueAnimator.removeAllListeners();
                    voiceWaveView.f21617q.cancel();
                }
                ((q1) this.f19495c).l(null);
                return;
            case 12:
                C1376d c1376d = (C1376d) this.f19494b;
                if (c1376d.f26547p == null || (bluetoothGattCharacteristic = (BluetoothGattCharacteristic) this.f19495c) == null) {
                    return;
                }
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(C1380h.f26559I);
                if (descriptor == null) {
                    C1725a.f("m_bt_le.GattConnection", "setNotification Failed to getDescriptor." + c1376d);
                    return;
                }
                int iWriteDescriptor = c1376d.f26547p.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                if (iWriteDescriptor != 0) {
                    C1725a.f("m_bt_le.GattConnection", "setNotification Failed to writeDescriptor. enableNotify = true, resultCode = " + iWriteDescriptor + ", " + c1376d);
                    return;
                }
                A.a aVar = C1725a.f29476a;
                if (A.l()) {
                    C1725a.a("m_bt_le.GattConnection", "setNotification success to writeDescriptor. enableNotify = true, resultCode: " + iWriteDescriptor + ", " + c1376d);
                    return;
                }
                return;
            case 13:
                MultiConnectStateDTO.Element element = (MultiConnectStateDTO.Element) this.f19494b;
                WeakReference weakReference = (WeakReference) this.f19495c;
                LinkedHashMap linkedHashMap = oa.d.f26574a;
                if (linkedHashMap.containsKey(element.getAddress())) {
                    if (element.getConnectionState() != 2) {
                        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                        if (heyMelodyApplication == null) {
                            kotlin.jvm.internal.h.i("context");
                            throw null;
                        }
                        E8.a.T(heyMelodyApplication, heyMelodyApplication.getString(R.string.melody_common_multi_connect_connect_timeout));
                        if (weakReference != null && (runnable = (Runnable) weakReference.get()) != null) {
                            runnable.run();
                        }
                    }
                    String address = element.getAddress();
                    kotlin.jvm.internal.l.a(linkedHashMap);
                    WeakReference weakReference2 = (WeakReference) linkedHashMap.remove(address);
                    Runnable runnable2 = weakReference2 != null ? (Runnable) weakReference2.get() : null;
                    if (runnable2 != null) {
                        o0.c.f1143a.removeCallbacks(runnable2);
                        return;
                    }
                    return;
                }
                return;
            case 14:
                pa.l lVar = (pa.l) this.f19494b;
                lVar.getClass();
                String str2 = (String) this.f19495c;
                Preference preferenceF = (TextUtils.isEmpty(str2) || (cOUIPreferenceCategory = lVar.f26967F) == null) ? null : cOUIPreferenceCategory.f(str2);
                if (preferenceF != null) {
                    preferenceF.setSummary((CharSequence) null);
                }
                lVar.H.setVisible(true);
                return;
            case 15:
                List<C1582a> codecList = ((v9.c) this.f19495c).getCodecList();
                HighAudioPreferenceFragment highAudioPreferenceFragment = (HighAudioPreferenceFragment) this.f19494b;
                PreferenceCategory preferenceCategory = highAudioPreferenceFragment.f21089z;
                androidx.fragment.app.f activity = highAudioPreferenceFragment.getActivity();
                if (activity == null || preferenceCategory == null) {
                    A.h("HighAudioPreferenceFragment", "refreshCodecList act==null:" + (activity == null));
                    return;
                }
                int size = codecList.size();
                int i11 = 0;
                while (true) {
                    ArrayList arrayList = preferenceCategory.f11662c;
                    if (i11 >= size) {
                        ArrayList arrayList2 = new ArrayList();
                        int size2 = arrayList.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            Preference preferenceH = preferenceCategory.h(i12);
                            kotlin.jvm.internal.h.d(preferenceH, "getPreference(...)");
                            Iterator<T> it = codecList.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    next = it.next();
                                    if (kotlin.jvm.internal.h.a(String.valueOf(((C1582a) next).f28400a), preferenceH.getKey())) {
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            if (next == null) {
                                arrayList2.add(preferenceH);
                            }
                        }
                        int size3 = arrayList2.size();
                        while (i10 < size3) {
                            Object obj = arrayList2.get(i10);
                            i10++;
                            preferenceCategory.j((Preference) obj);
                        }
                        return;
                    }
                    String strValueOf = String.valueOf(codecList.get(i11).f28400a);
                    int size4 = arrayList.size();
                    MelodyRadioPreference melodyRadioPreference = null;
                    for (int i13 = 0; i13 < size4; i13++) {
                        Preference preferenceH2 = preferenceCategory.h(i13);
                        kotlin.jvm.internal.h.d(preferenceH2, "getPreference(...)");
                        if (kotlin.jvm.internal.h.a(strValueOf, preferenceH2.getKey())) {
                            preferenceH2.setOrder(i11);
                            melodyRadioPreference = (MelodyRadioPreference) preferenceH2;
                        }
                    }
                    if (melodyRadioPreference == null) {
                        MelodyRadioPreference melodyRadioPreference2 = new MelodyRadioPreference(activity, null);
                        melodyRadioPreference2.setTitle(codecList.get(i11).f28401b);
                        melodyRadioPreference2.setSummary(codecList.get(i11).f28402c);
                        melodyRadioPreference2.setChecked(codecList.get(i11).f28404e);
                        melodyRadioPreference2.setKey(strValueOf);
                        melodyRadioPreference2.setOrder(i11);
                        melodyRadioPreference2.setPersistent(false);
                        melodyRadioPreference2.setOnPreferenceChangeListener(highAudioPreferenceFragment.f21088E);
                        preferenceCategory.e(melodyRadioPreference2);
                    }
                    i11++;
                }
                break;
            default:
                ((Wb.l) this.f19494b).d((Track) this.f19495c);
                return;
        }
    }
}
