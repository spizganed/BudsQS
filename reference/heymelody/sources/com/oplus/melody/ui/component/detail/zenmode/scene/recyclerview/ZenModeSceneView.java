package com.oplus.melody.ui.component.detail.zenmode.scene.recyclerview;

import F9.s;
import O7.i;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.ui.component.detail.zenmode.scene.b;
import com.oplus.melody.ui.component.detail.zenmode.scene.e;
import com.oplus.melody.ui.widget.MelodyLottieAnimationView;
import da.C0975b;
import da.InterfaceC0976c;
import da.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ZenModeSceneView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC0976c f21510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f21511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f21512c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f21513p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MelodyLottieAnimationView f21514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CircularProgressView f21515r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f21516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d f21517t;

    public ZenModeSceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d.a aVar = new d.a();
        aVar.f22307a = "";
        aVar.f22308b = -1;
        aVar.f22309c = null;
        aVar.f22310d = null;
        aVar.f22311e = "";
        aVar.f22312f = false;
        this.f21517t = new d(aVar);
        LayoutInflater.from(context).inflate(R.layout.melody_ui_layout_zen_mode_scene, this);
        this.f21511b = (ImageView) findViewById(R.id.zen_mode_scene_view_background);
        this.f21512c = (ImageView) findViewById(R.id.zen_mode_scene_view_mask);
        this.f21513p = (ImageView) findViewById(R.id.zen_mode_download_image);
        this.f21514q = (MelodyLottieAnimationView) findViewById(R.id.zen_mode_playing_anim);
        this.f21515r = (CircularProgressView) findViewById(R.id.zen_mode_download_progress_image);
    }

    public void setCallBack(InterfaceC0976c interfaceC0976c) {
        this.f21510a = interfaceC0976c;
    }

    public void setChosenView(ImageView imageView) {
        this.f21516s = imageView;
    }

    public void setInfo(d dVar) {
        EarphoneDTO earphoneDTOW;
        int i10;
        MediaPlayer mediaPlayer;
        this.f21517t = dVar;
        if (this.f21511b != null) {
            Glide.with(this).load(this.f21517t.f22302d).transform(new CircleCrop()).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(this.f21511b);
        }
        ImageView imageView = this.f21516s;
        int i11 = 0;
        int i12 = 8;
        if (imageView != null) {
            imageView.setVisibility(this.f21517t.h ? 0 : 8);
        }
        MelodyLottieAnimationView melodyLottieAnimationView = this.f21514q;
        if (melodyLottieAnimationView != null) {
            d dVar2 = this.f21517t;
            boolean z2 = dVar2.f22304f && dVar2.h;
            if ((melodyLottieAnimationView.getVisibility() == 0) != z2) {
                this.f21514q.setVisibility(z2 ? 0 : 8);
            }
        }
        ImageView imageView2 = this.f21512c;
        if (imageView2 != null) {
            d dVar3 = this.f21517t;
            imageView2.setVisibility((!dVar3.f22304f || dVar3.h) ? 0 : 8);
            ImageView imageView3 = this.f21512c;
            d dVar4 = this.f21517t;
            imageView3.setBackgroundResource((dVar4.f22304f && dVar4.h) ? R.drawable.melody_ui_ic_zen_mode_playing_panel : R.drawable.melody_ui_ic_zen_mode_download_panel);
        }
        ImageView imageView4 = this.f21513p;
        if (imageView4 != null) {
            d dVar5 = this.f21517t;
            imageView4.setVisibility((dVar5.f22304f || dVar5.f22305g) ? 8 : 0);
        }
        CircularProgressView circularProgressView = this.f21515r;
        if (circularProgressView != null) {
            d dVar6 = this.f21517t;
            if (!dVar6.f22304f && dVar6.f22305g) {
                i12 = 0;
            }
            circularProgressView.setVisibility(i12);
            this.f21515r.setProgress(this.f21517t.f22306i);
        }
        d dVar7 = this.f21517t;
        if (dVar7.h && dVar7.f22304f && (earphoneDTOW = AbstractC0939b.E().w(this.f21517t.f22299a)) != null && earphoneDTOW.getConnectionState() == 2) {
            b bVar = b.C0235b.f21441a;
            bVar.getClass();
            if (!b.a() && !bVar.f21437g) {
                e eVar = e.a.f21449a;
                boolean zEquals = TextUtils.equals(eVar.f21445a, this.f21517t.f22301c.getResId());
                if (!zEquals || eVar.f21447c != 2) {
                    if (!zEquals || (i10 = eVar.f21447c) != 3) {
                        final String resId = this.f21517t.f22301c.getResId();
                        if (!TextUtils.isEmpty(this.f21517t.f22301c.getProductId())) {
                            resId = this.f21517t.f22301c.getProductId() + "_" + this.f21517t.f22301c.getColor() + "_" + this.f21517t.f22301c.getResId();
                        }
                        if (eVar.f21448d) {
                            eVar.a();
                            eVar.f21446b = new MediaPlayer();
                            try {
                                eVar.f21446b.setDataSource(com.oplus.drs.core.d.s(resId));
                                eVar.f21446b.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.oplus.melody.ui.component.detail.zenmode.scene.d
                                    {
                                        e eVar2 = e.a.f21449a;
                                    }

                                    @Override // android.media.MediaPlayer.OnPreparedListener
                                    public final void onPrepared(MediaPlayer mediaPlayer2) {
                                        e eVar2 = e.a.f21449a;
                                        eVar2.f21445a = resId;
                                        eVar2.f21447c = 2;
                                        eVar2.f21446b.start();
                                    }
                                });
                                eVar.f21446b.setOnCompletionListener(new i(1));
                                eVar.f21446b.prepareAsync();
                            } catch (Exception e10) {
                                A.i("ZenModePlayer", "createPlayer", e10);
                            }
                        }
                    } else if (eVar.f21448d && (mediaPlayer = eVar.f21446b) != null && i10 == 3) {
                        eVar.f21447c = 2;
                        mediaPlayer.start();
                    }
                }
            }
        }
        boolean z4 = dVar.h;
        C0975b c0975b = (C0975b) ((s) this.f21510a).f1745b;
        ArrayList arrayList = c0975b.f22291e;
        int size = arrayList.size();
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            if (((d) obj).f22305g) {
                return;
            }
        }
        c0975b.f22293g = true;
    }

    public void setProgress(int i10) {
        CircularProgressView circularProgressView = this.f21515r;
        if (circularProgressView != null) {
            circularProgressView.setProgress(i10);
        }
    }
}
