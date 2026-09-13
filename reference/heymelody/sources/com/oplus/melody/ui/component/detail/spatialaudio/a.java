package com.oplus.melody.ui.component.detail.spatialaudio;

import A9.p;
import A9.q;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.spatialaudio.SpatialAudioContentFragment;
import com.oplus.melody.ui.component.detail.spatialaudio.d;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import kc.C1264t;

/* JADX INFO: compiled from: SpatialAudioContentFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpatialAudioContentFragment f21254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpatialAudioContentFragment.a f21255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ModeItem f21256c;

    public a(ModeItem modeItem, SpatialAudioContentFragment.a aVar, SpatialAudioContentFragment spatialAudioContentFragment) {
        this.f21254a = spatialAudioContentFragment;
        this.f21255b = aVar;
        this.f21256c = modeItem;
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.d.a
    public final void a() {
        SpatialAudioContentFragment spatialAudioContentFragment = this.f21254a;
        C1264t.t(AppConstant$FunctionType.SPATIAL_HIRES_SWITCH_DIALOG.getFunType(), spatialAudioContentFragment.f21264E, spatialAudioContentFragment.f21265F, N.t(AbstractC0939b.E().w(spatialAudioContentFragment.f21265F)), "4");
    }

    @Override // com.oplus.melody.ui.component.detail.spatialaudio.d.a
    public final void b() {
        SpatialAudioContentFragment spatialAudioContentFragment = this.f21254a;
        spatialAudioContentFragment.f21268J = true;
        CompletableFuture<SetCommandStateDTO> completableFutureC = this.f21255b.c(this.f21256c);
        if (completableFutureC != null) {
            completableFutureC.whenComplete((BiConsumer<? super SetCommandStateDTO, ? super Throwable>) new q(new p(spatialAudioContentFragment, 1), 4));
        }
        C1264t.t(AppConstant$FunctionType.SPATIAL_HIRES_SWITCH_DIALOG.getFunType(), spatialAudioContentFragment.f21264E, spatialAudioContentFragment.f21265F, N.t(AbstractC0939b.E().w(spatialAudioContentFragment.f21265F)), BaseHealthModule.TRACK_ACTIVE_DETECT);
    }
}
