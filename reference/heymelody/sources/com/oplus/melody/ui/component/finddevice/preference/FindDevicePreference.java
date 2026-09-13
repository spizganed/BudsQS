package com.oplus.melody.ui.component.finddevice.preference;

import D7.o0;
import E9.r;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.exoplayer.J;
import androidx.media3.session.N0;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.btsdk.protocol.commands.h;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.finddevice.FindDeviceViewModel;
import com.oplus.melody.ui.widget.MelodyCompatLoadingView;
import fa.l;
import t8.t;

/* JADX INFO: loaded from: classes3.dex */
public class FindDevicePreference extends COUIPreference implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f21529u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f21530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f21531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f21532c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l f21533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MelodyCompatLoadingView f21534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f21535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FindDeviceViewModel f21536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21537t;

    public class a extends SparseArray<String> {
    }

    static {
        a aVar = new a();
        aVar.put(1, "init");
        aVar.put(2, "connecting");
        aVar.put(3, "playing");
        aVar.put(4, "init_show_map_button");
        aVar.put(5, "init_invalid_location");
        aVar.put(6, "stoped");
        f21529u = aVar;
    }

    public static void i(Context context, ImageView imageView, int i10) {
        if (context == null || imageView == null) {
            return;
        }
        if (!P1.a.h(context)) {
            imageView.setImageResource(i10);
            return;
        }
        Drawable drawableM = d.m(context, i10);
        drawableM.mutate().setTint(P1.a.b(context, R.attr.couiColorPrimary, 0));
        imageView.setImageDrawable(drawableM);
    }

    public final void e(boolean z2) {
        A.c("FindDevicePreference", new r(13, z2));
        MelodyCompatLoadingView melodyCompatLoadingView = this.f21534q;
        if (melodyCompatLoadingView == null) {
            return;
        }
        if (!z2) {
            melodyCompatLoadingView.setVisibility(8);
            return;
        }
        melodyCompatLoadingView.setEnabled(true);
        this.f21534q.setVisibility(0);
        this.f21534q.postInvalidate();
    }

    public final void f(boolean z2) {
        if (this.f21532c == null) {
            return;
        }
        j(true);
        if (z2) {
            this.f21532c.post(new N0(this, 10));
        } else if (this.f21532c != null) {
            i(getContext(), this.f21532c, R.drawable.melody_ui_finddevice_play_button);
        }
    }

    public final void h() {
        A.b("FindDevicePreference", "resetPlayToneButton");
        e(false);
        f(false);
        j(true);
        setEnabled(true);
    }

    public final void j(boolean z2) {
        ImageView imageView = this.f21532c;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
    }

    public final void k(int i10) {
        TextView textView = this.f21530a;
        if (textView == null) {
            return;
        }
        if (i10 != -1) {
            if (textView.getVisibility() != 0) {
                this.f21530a.setVisibility(0);
            }
            this.f21530a.setText(i10);
        } else if (textView.getVisibility() != 8) {
            this.f21530a.setVisibility(8);
        }
    }

    public final void l(boolean z2) {
        ImageView imageView = this.f21531b;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void m(int i10, boolean z2) {
        A.c("FindDevicePreference", new h(i10, 17));
        if (this.f21536s.f21527g) {
            A.b("FindDevicePreference", "showMapButton");
            if (this.f21531b != null) {
                t.b();
            }
        }
        o0.d(new J(this, i10, z2, 1));
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        this.f21530a = (TextView) mVar.a(android.R.id.summary);
        ImageView imageView = (ImageView) mVar.a(R.id.viewmap_select_button);
        this.f21531b = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) mVar.a(R.id.playtone_button_icon);
        this.f21532c = imageView2;
        imageView2.setOnClickListener(this);
        i(getContext(), this.f21532c, R.drawable.melody_ui_finddevice_play_button);
        MelodyCompatLoadingView melodyCompatLoadingView = (MelodyCompatLoadingView) mVar.a(R.id.scanning_progress);
        this.f21534q = melodyCompatLoadingView;
        melodyCompatLoadingView.setLoadingViewColor(getContext().getColor(R.color.melody_ui_guide_text_color_loading));
        this.f21534q.setLoadingViewBgCircleColor(getContext().getColor(R.color.melody_ui_transparent));
        this.f21534q.setOnClickListener(this);
        l(false);
        m(this.f21535r, this.f21537t == 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c0  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r8) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.finddevice.preference.FindDevicePreference.onClick(android.view.View):void");
    }
}
