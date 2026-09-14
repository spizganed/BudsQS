package com.oplus.melody.ui.component.detail.opsreduction;

import A6.f;
import C6.e;
import D7.C0379m;
import G9.b;
import G9.c;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import androidx.preference.m;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.opsreduction.buttonseekbar.NoiseReductionButtonSeekBarView;
import com.oplus.melody.ui.component.detail.opsreduction.buttonseekbar.NoiseReductionInfoBus;
import com.oplus.melody.ui.widget.MelodyCompatSectionSeekBar;
import com.oplus.melody.ui.widget.devicecontrol.DeviceControlWidget;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class OpsReductionItem extends Preference {
    public static final String ITEM_NAME = "OpsReductionItem";
    InterfaceC0601m mLifecycleOwner;
    DetailMainViewModel mViewModel;

    public OpsReductionItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        setSelectable(false);
        setLayoutResource(R.layout.melody_ui_recycler_item_ops_reduction);
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(m mVar) {
        NoiseReductionButtonSeekBarView noiseReductionButtonSeekBarView = (NoiseReductionButtonSeekBarView) mVar.a(R.id.ops_noise_reduction_view);
        InterfaceC0601m interfaceC0601m = this.mLifecycleOwner;
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        noiseReductionButtonSeekBarView.f21151b = detailMainViewModel;
        if (noiseReductionButtonSeekBarView.f21147A) {
            A.b("NoiseReductionButtonSeekBarView", "init has init!");
            return;
        }
        noiseReductionButtonSeekBarView.f21147A = true;
        String str = detailMainViewModel.f20397b;
        NoiseReductionInfoBus noiseReductionInfoBus = new NoiseReductionInfoBus(0);
        noiseReductionInfoBus.address = str;
        noiseReductionInfoBus.title = 0;
        noiseReductionButtonSeekBarView.f21155r = noiseReductionInfoBus;
        LayoutInflater.from(noiseReductionButtonSeekBarView.getContext()).inflate(R.layout.melody_ui_ops_noise_reduction_switch_layout, noiseReductionButtonSeekBarView);
        c cVar = noiseReductionButtonSeekBarView.f21150a;
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        cVar.f2003d = heyMelodyApplication;
        cVar.f2000a = heyMelodyApplication.getResources().getColor(R.color.melody_ui_color_noise_reduction_switch_text_primary, null);
        cVar.f2001b = cVar.f2003d.getResources().getColor(R.color.melody_ui_color_noise_reduction_switch_text_secondary, null);
        cVar.f2002c = cVar.f2003d.getResources().getColor(R.color.melody_ui_color_noise_reduction_switch_text_disabled, null);
        cVar.f2004e = (TextView) noiseReductionButtonSeekBarView.findViewById(R.id.mode_text_first);
        cVar.f2005f = (TextView) noiseReductionButtonSeekBarView.findViewById(R.id.mode_text_second);
        cVar.f2006g = (TextView) noiseReductionButtonSeekBarView.findViewById(R.id.mode_text_third);
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(language) && language.startsWith("en")) {
            cVar.f2004e.setText(R.string.melody_ui_noise_reduction_weak_mode_175);
            cVar.f2005f.setText(R.string.melody_ui_noise_reduction_intellect_mode_175);
            cVar.f2006g.setText(R.string.melody_ui_noise_reduction_strong_mode_175);
        }
        MelodyCompatSectionSeekBar melodyCompatSectionSeekBar = (MelodyCompatSectionSeekBar) noiseReductionButtonSeekBarView.findViewById(R.id.seek_bar);
        noiseReductionButtonSeekBarView.f21152c = melodyCompatSectionSeekBar;
        melodyCompatSectionSeekBar.setNumber(2);
        noiseReductionButtonSeekBarView.f21152c.setThumbIndex(1);
        DeviceControlWidget deviceControlWidget = (DeviceControlWidget) noiseReductionButtonSeekBarView.findViewById(R.id.ops_noise_reduction_mode_action);
        noiseReductionButtonSeekBarView.f21153p = deviceControlWidget;
        deviceControlWidget.setOnActionListener(noiseReductionButtonSeekBarView);
        noiseReductionButtonSeekBarView.f21153p.setBackground(null);
        if (noiseReductionButtonSeekBarView.f21153p.getChildAt(0) != null) {
            noiseReductionButtonSeekBarView.f21153p.getChildAt(0).setBackground(null);
        }
        noiseReductionButtonSeekBarView.f21158u = new Handler(Looper.getMainLooper());
        noiseReductionButtonSeekBarView.f21159v = new G9.a(noiseReductionButtonSeekBarView, 0);
        noiseReductionButtonSeekBarView.f21152c.setOnSectionSeekBarChangeListener(new b(noiseReductionButtonSeekBarView));
        noiseReductionButtonSeekBarView.h();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(noiseReductionButtonSeekBarView.f21151b.f20397b), new f(13))).e(interfaceC0601m, new C9.a(noiseReductionButtonSeekBarView, 5));
        AbstractC0939b.E().J(noiseReductionButtonSeekBarView.f21151b.f20397b);
        DetailMainViewModel detailMainViewModel2 = noiseReductionButtonSeekBarView.f21151b;
        detailMainViewModel2.m(detailMainViewModel2.f20397b).e(interfaceC0601m, new e(noiseReductionButtonSeekBarView, 7));
    }
}
