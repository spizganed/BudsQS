package com.heytap.headset.component.mydevicelist;

import Ca.g;
import D7.C0373g;
import D7.C0391z;
import Ea.ViewOnClickListenerC0410t;
import I8.w;
import Kb.q;
import X7.b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.collection.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.z;
import com.heytap.headset.R;
import com.heytap.headset.component.mydevicelist.batteryview.BatterysView;
import com.oplus.melody.btsdk.protocol.commands.r;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.widget.MelodyCompatCheckBox;
import e4.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ForkJoinPool;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MyDeviceListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends z<V3.a, b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f17467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.b<String> f17468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Jb.b f17469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f17470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17472g;
    public final int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f17473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17475k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathInterpolator f17476l;

    /* JADX INFO: renamed from: com.heytap.headset.component.mydevicelist.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MyDeviceListAdapter.kt */
    public static final class C0207a extends p.e<V3.a> {
        @Override // androidx.recyclerview.widget.p.e
        public final boolean a(V3.a aVar, V3.a aVar2) {
            return aVar.equals(aVar2);
        }

        @Override // androidx.recyclerview.widget.p.e
        public final boolean b(V3.a aVar, V3.a aVar2) {
            return h.a(aVar.getAddress(), aVar2.getAddress());
        }
    }

    /* JADX INFO: compiled from: MyDeviceListAdapter.kt */
    public final class b extends RecyclerView.E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MelodyCompatCheckBox f17477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f17478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17479c;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final AppCompatTextView f17480p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final AppCompatImageView f17481q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final AppCompatTextView f17482r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final AppCompatTextView f17483s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final AppCompatTextView f17484t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final RelativeLayout f17485u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final BatterysView f17486v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final AppCompatTextView f17487w;

        public b(View view) {
            super(view);
            View viewFindViewById = view.findViewById(R.id.check_box);
            h.d(viewFindViewById, "findViewById(...)");
            this.f17477a = (MelodyCompatCheckBox) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.check_box_container);
            h.d(viewFindViewById2, "findViewById(...)");
            this.f17478b = viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.reconnect);
            h.d(viewFindViewById3, "findViewById(...)");
            this.f17480p = (AppCompatTextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.iv_headset);
            h.d(viewFindViewById4, "findViewById(...)");
            this.f17481q = (AppCompatImageView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.tv_name);
            h.d(viewFindViewById5, "findViewById(...)");
            this.f17482r = (AppCompatTextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.tv_connect_state);
            h.d(viewFindViewById6, "findViewById(...)");
            this.f17483s = (AppCompatTextView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.tv_disconnected);
            h.d(viewFindViewById7, "findViewById(...)");
            this.f17484t = (AppCompatTextView) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.rl_item);
            h.d(viewFindViewById8, "findViewById(...)");
            this.f17485u = (RelativeLayout) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.battery_view);
            h.d(viewFindViewById9, "findViewById(...)");
            this.f17486v = (BatterysView) viewFindViewById9;
            View viewFindViewById10 = view.findViewById(R.id.tv_mac);
            h.d(viewFindViewById10, "findViewById(...)");
            this.f17487w = (AppCompatTextView) viewFindViewById10;
        }

        public static W3.b a(Context context, int i10, boolean z2, int i11) {
            W3.b bVar = new W3.b();
            bVar.f5485a = i10;
            Locale locale = Locale.getDefault();
            String string = context.getString(R.string.melody_ui_percent);
            h.d(string, "getString(...)");
            String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
            bVar.f5486b = true;
            bVar.f5487c = z2;
            bVar.f5488d = i11;
            return bVar;
        }

        public final void b(int i10) {
            boolean z2 = a.this.f17471f;
            AppCompatTextView appCompatTextView = this.f17480p;
            if (z2 || C0373g.f1086l) {
                appCompatTextView.setVisibility(4);
            } else if (i10 == 1) {
                appCompatTextView.setText(R.string.melody_ui_connecting);
                appCompatTextView.setVisibility(0);
            } else if (i10 != 2) {
                appCompatTextView.setText(R.string.melody_common_connect);
                appCompatTextView.setVisibility(0);
            } else {
                appCompatTextView.setVisibility(4);
            }
            boolean z4 = C0373g.f1086l;
            AppCompatImageView appCompatImageView = this.f17481q;
            RelativeLayout relativeLayout = this.f17485u;
            AppCompatTextView appCompatTextView2 = this.f17482r;
            AppCompatTextView appCompatTextView3 = this.f17484t;
            if ((!z4 && (i10 == 2 || i10 == 1 || i10 == 0)) || (z4 && i10 == 2)) {
                relativeLayout.setBackgroundResource(R.drawable.heymelody_app_mydevicelist_item_bg);
                appCompatTextView3.setVisibility(8);
                appCompatTextView2.setEnabled(true);
                appCompatImageView.setAlpha(1.0f);
                appCompatTextView2.setAlpha(1.0f);
                appCompatTextView3.setAlpha(1.0f);
                return;
            }
            relativeLayout.setBackgroundResource(R.drawable.heymelody_app_mydevicelist_item_bg_disable);
            appCompatTextView2.setEnabled(false);
            appCompatImageView.setAlpha(0.3f);
            appCompatTextView2.setAlpha(0.3f);
            appCompatTextView3.setAlpha(0.3f);
            if (C0373g.f1086l) {
                appCompatTextView3.setVisibility(8);
            } else {
                appCompatTextView3.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: MyDeviceListAdapter.kt */
    public interface c {
        void a(V3.a aVar);

        void b(V3.a aVar);

        void c();
    }

    /* JADX INFO: compiled from: MyDeviceListAdapter.kt */
    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MelodyCompatCheckBox f17490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f17491c;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ b f17492p;

        public d(boolean z2, MelodyCompatCheckBox melodyCompatCheckBox, View view, b bVar) {
            this.f17489a = z2;
            this.f17490b = melodyCompatCheckBox;
            this.f17491c = view;
            this.f17492p = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animation) {
            h.e(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animation) {
            h.e(animation, "animation");
            if (!this.f17489a) {
                MelodyCompatCheckBox melodyCompatCheckBox = this.f17490b;
                if (melodyCompatCheckBox != null) {
                    melodyCompatCheckBox.setVisibility(4);
                }
                View view = this.f17491c;
                if (view != null) {
                    view.setVisibility(4);
                }
                if (melodyCompatCheckBox != null) {
                    melodyCompatCheckBox.setState(0);
                }
                if (melodyCompatCheckBox != null) {
                    melodyCompatCheckBox.c();
                }
            }
            this.f17492p.f17479c = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animation) {
            h.e(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animation) {
            h.e(animation, "animation");
            if (this.f17489a) {
                MelodyCompatCheckBox melodyCompatCheckBox = this.f17490b;
                if (melodyCompatCheckBox != null) {
                    melodyCompatCheckBox.setVisibility(0);
                }
                View view = this.f17491c;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            this.f17492p.f17479c = true;
        }
    }

    public a(Context context) {
        super(new C0207a());
        this.f17467b = context;
        this.f17468c = new androidx.collection.b<>(0);
        this.f17469d = kotlin.a.a(new J8.d(this, 6));
        this.f17472g = -1;
        this.h = -1;
        this.f17473i = -1;
        this.f17474j = 1;
        this.f17475k = 20;
        this.f17476l = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f17472g = context.getResources().getDimensionPixelOffset(R.dimen.heymelody_app_mydevicelist_item_title_maxline_width);
        this.h = context.getResources().getDimensionPixelOffset(R.dimen.heymelody_app_mydevicelist_item_title_secondmax_line_width);
        this.f17473i = context.getResources().getDimensionPixelOffset(R.dimen.heymelody_app_mydevicelist_item_state_padding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(b holder, int i10) {
        Context context;
        h.e(holder, "holder");
        V3.a aVarC = c(i10);
        if (aVarC == null || (context = this.f17467b) == null || !BluetoothAdapter.checkBluetoothAddress(aVarC.getAddress())) {
            return;
        }
        C0391z c0391z = C0391z.f1171d;
        String address = aVarC.getAddress();
        c0391z.getClass();
        BluetoothDevice bluetoothDeviceI = C0391z.i(address);
        AppCompatTextView appCompatTextView = holder.f17482r;
        if (bluetoothDeviceI != null) {
            String strF = c0391z.f(bluetoothDeviceI);
            if (TextUtils.isEmpty(strF)) {
                appCompatTextView.setText(aVarC.getName());
            } else {
                appCompatTextView.setText(strF);
            }
        } else {
            appCompatTextView.setText(aVarC.getName());
        }
        try {
            h.b(D5.c.y(context, "N".equals(aVarC.getType()) ? R.drawable.melody_ui_detail_default_img_neck : Y.i(aVarC.getType()) ? R.drawable.melody_ui_detail_default_img_ows : R.drawable.melody_ui_detail_default_img, aVarC.getCoverImage()).into(holder.f17481q));
        } catch (Exception e10) {
            A.i("MyDeviceListAdapter", "bindView load image exception!", e10);
        }
        boolean zIsConnected = aVarC.isConnected();
        a aVar = a.this;
        BatterysView batterysView = holder.f17486v;
        AppCompatTextView appCompatTextView2 = holder.f17483s;
        Context context2 = aVar.f17467b;
        if (zIsConnected) {
            appCompatTextView2.setVisibility(0);
            batterysView.setVisibility(0);
            int i11 = aVar.f17472g;
            if (i11 > 0) {
                appCompatTextView.setMaxWidth(i11);
            }
            if (aVarC.getIsCurrentUse()) {
                int i12 = aVar.f17473i;
                if (i12 > 0) {
                    appCompatTextView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.oplus.drs.core.d.m(context2, R.drawable.heymelody_app_icon_device_in_using), (Drawable) null);
                    appCompatTextView2.setCompoundDrawablePadding(i12);
                }
            } else {
                appCompatTextView2.setCompoundDrawablesRelative(null, null, null, null);
            }
        } else {
            appCompatTextView2.setVisibility(8);
            batterysView.setVisibility(8);
            int i13 = aVar.h;
            if (i13 > 0) {
                appCompatTextView.setMaxWidth(i13);
            }
        }
        if (aVarC.getIsSpp()) {
            if (aVarC.getConnectionState() == 2) {
                if (!Y.l(aVarC.getType())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVarC.getLeftBattery() > 0) {
                        context2.getString(R.string.melody_ui_left_ear);
                        arrayList.add(b.a(context2, aVarC.getLeftBattery(), aVarC.getIsLeftCharging(), 1));
                    }
                    if (aVarC.getRightBattery() > 0) {
                        context2.getString(R.string.melody_ui_right_ear);
                        arrayList.add(b.a(context2, aVarC.getRightBattery(), aVarC.getIsRightCharging(), 2));
                    }
                    if (aVarC.getBoxBattery() > 0) {
                        context2.getString(R.string.melody_ui_ear_box);
                        arrayList.add(b.a(context2, aVarC.getBoxBattery(), aVarC.getIsBoxCharging(), 3));
                    }
                    batterysView.a(arrayList);
                } else if (aVarC.getLeftBattery() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(b.a(context2, aVarC.getLeftBattery(), aVarC.getIsLeftCharging(), 255));
                    batterysView.a(arrayList2);
                }
            }
        } else if (aVarC.getHeadsetConnectionState() == 2) {
            if (!Y.l(aVarC.getType())) {
                ArrayList arrayList3 = new ArrayList();
                if (aVarC.getHeadsetLeftBattery() > 0) {
                    context2.getString(R.string.melody_ui_left_ear);
                    arrayList3.add(b.a(context2, aVarC.getHeadsetLeftBattery(), false, 1));
                }
                if (aVarC.getHeadsetRightBattery() > 0) {
                    context2.getString(R.string.melody_ui_right_ear);
                    arrayList3.add(b.a(context2, aVarC.getHeadsetRightBattery(), false, 2));
                }
                if (aVarC.getHeadsetBoxBattery() > 0) {
                    context2.getString(R.string.melody_ui_ear_box);
                    arrayList3.add(b.a(context2, aVarC.getHeadsetBoxBattery(), false, 3));
                }
                batterysView.a(arrayList3);
            } else if (aVarC.getHeadsetLeftBattery() > 0) {
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(b.a(context2, aVarC.getHeadsetLeftBattery(), false, 255));
                batterysView.a(arrayList4);
            }
        }
        if (aVarC.getIsSpp()) {
            holder.b(aVarC.getConnectionState());
        } else {
            holder.b(aVarC.getHeadsetConnectionState());
        }
        com.heytap.headset.component.mydevicelist.b bVar = new com.heytap.headset.component.mydevicelist.b(aVar);
        MelodyCompatCheckBox melodyCompatCheckBox = holder.f17477a;
        melodyCompatCheckBox.setOnStateChangeListener(bVar);
        boolean z2 = aVar.f17471f;
        View view = holder.f17478b;
        if (z2) {
            if (q.o(aVar.f17468c, aVarC.getAddress())) {
                melodyCompatCheckBox.setState(2);
            } else {
                melodyCompatCheckBox.setState(0);
            }
            if (!holder.f17479c) {
                melodyCompatCheckBox.setVisibility(0);
                view.setVisibility(0);
                melodyCompatCheckBox.setTranslationX(0.0f);
                melodyCompatCheckBox.setAlpha(1.0f);
            }
        } else if (!holder.f17479c) {
            melodyCompatCheckBox.setVisibility(4);
            view.setVisibility(4);
        }
        holder.f17485u.setOnClickListener(new w(aVar, aVarC, holder, 1));
        holder.f17480p.setOnClickListener(new ViewOnClickListenerC0410t(3, aVar, aVarC));
        J7.b.a().c();
        J7.b.a().f();
        holder.f17487w.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        androidx.collection.b<String> bVar = this.f17468c;
        bVar.getClass();
        b.a aVar = new b.a();
        while (aVar.hasNext()) {
            String str = (String) aVar.next();
            if (str.length() > 0) {
                if (C0373g.f1086l) {
                    e.f22900c.getClass();
                    A.c("DevicesCardRepository", new r(2));
                    ForkJoinPool.commonPool().execute(new g(str, 3));
                } else {
                    Object obj = X7.b.f5996c;
                    b.a.a().a(str);
                    AbstractC0939b.E().c(str);
                }
            }
        }
        bVar.clear();
    }

    public final void g(b bVar, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        MelodyCompatCheckBox melodyCompatCheckBox = bVar.f17477a;
        int i10 = this.f17475k;
        if (z2) {
            float f9 = this.f17474j;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(melodyCompatCheckBox, "translationX", i10 * f9, f9 * 0);
            h.d(objectAnimatorOfFloat, "ofFloat(...)");
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(melodyCompatCheckBox, "alpha", 0.0f, 1.0f);
            h.d(objectAnimatorOfFloat2, "ofFloat(...)");
        } else {
            float f10 = this.f17474j;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(melodyCompatCheckBox, "translationX", 0 * f10, f10 * i10);
            h.d(objectAnimatorOfFloat, "ofFloat(...)");
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(melodyCompatCheckBox, "alpha", 1.0f, 0.0f);
            h.d(objectAnimatorOfFloat2, "ofFloat(...)");
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(this.f17476l);
        objectAnimatorOfFloat2.addListener(new d(z2, melodyCompatCheckBox, bVar.f17478b, bVar));
        animatorSet.start();
    }

    public final void h(b holder, int i10) {
        h.e(holder, "holder");
        if (this.f17471f) {
            holder.f17480p.setVisibility(4);
            return;
        }
        V3.a aVarC = c(i10);
        if (aVarC != null) {
            if (aVarC.getIsSpp()) {
                holder.b(aVarC.getConnectionState());
            } else {
                holder.b(aVarC.getHeadsetConnectionState());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.E onCreateViewHolder(ViewGroup parent, int i10) {
        h.e(parent, "parent");
        Object value = this.f17469d.getValue();
        h.d(value, "getValue(...)");
        View viewInflate = ((LayoutInflater) value).inflate(R.layout.heymelody_app_mydevicelist_item, parent, false);
        h.b(viewInflate);
        return new b(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.E e10, int i10, List payloads) {
        V3.a aVarC;
        b holder = (b) e10;
        h.e(holder, "holder");
        h.e(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i10);
            return;
        }
        h(holder, i10);
        Object obj = payloads.get(0);
        h.c(obj, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) obj).intValue() != 1 || (aVarC = c(i10)) == null) {
            return;
        }
        boolean z2 = this.f17471f;
        MelodyCompatCheckBox melodyCompatCheckBox = holder.f17477a;
        if (!z2) {
            melodyCompatCheckBox.setState(0);
            melodyCompatCheckBox.setVisibility(4);
            return;
        }
        if (q.o(this.f17468c, aVarC.getAddress())) {
            melodyCompatCheckBox.setState(2);
        } else {
            melodyCompatCheckBox.setState(0);
        }
        melodyCompatCheckBox.setVisibility(0);
        holder.f17478b.setVisibility(0);
        melodyCompatCheckBox.setTranslationX(0.0f);
        melodyCompatCheckBox.setAlpha(1.0f);
    }
}
