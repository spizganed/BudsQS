package com.oplus.melody.ui.component.detail.spatialaudio;

import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.spatialaudio.SpatialAudioContentFragment;
import kc.C1264t;
import q9.n;

/* JADX INFO: compiled from: SpatialAudioContentFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpatialAudioContentFragment.a f21257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModeItem f21258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SpatialAudioContentFragment f21259c;

    public b(ModeItem modeItem, SpatialAudioContentFragment.a aVar, SpatialAudioContentFragment spatialAudioContentFragment) {
        this.f21257a = aVar;
        this.f21258b = modeItem;
        this.f21259c = spatialAudioContentFragment;
    }

    @Override // q9.n.a
    public final void a() {
        SpatialAudioContentFragment spatialAudioContentFragment = this.f21259c;
        C1264t.t(AppConstant$FunctionType.GAME_EQ_SPATIAL_SWITCH_DIALOG.getFunType(), spatialAudioContentFragment.f21264E, spatialAudioContentFragment.f21265F, N.t(AbstractC0939b.E().w(spatialAudioContentFragment.f21265F)), "20");
    }

    @Override // q9.n.a
    public final void b() {
        this.f21257a.c(this.f21258b);
        SpatialAudioContentFragment spatialAudioContentFragment = this.f21259c;
        C1264t.t(AppConstant$FunctionType.GAME_EQ_SPATIAL_SWITCH_DIALOG.getFunType(), spatialAudioContentFragment.f21264E, spatialAudioContentFragment.f21265F, N.t(AbstractC0939b.E().w(spatialAudioContentFragment.f21265F)), "21");
    }
}
