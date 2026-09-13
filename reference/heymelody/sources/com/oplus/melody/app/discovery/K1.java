package com.oplus.melody.app.discovery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.panel.COUIPanelContentLayout;
import com.heytap.headset.HeyMelodyApplication;
import com.heytap.headset.R;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0909o;
import g0.C1065d;
import java.util.List;
import java.util.function.Supplier;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: compiled from: MelodyDialogWrapperImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class K1 implements E1 {
    public static final int h = Color.argb(138, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public COUIBottomSheetDialog f18958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f18959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f18960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public H1 f18961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18963g;

    public static int o(COUIBottomSheetDialog cOUIBottomSheetDialog) {
        Resources resources;
        View viewFindViewById = cOUIBottomSheetDialog != null ? cOUIBottomSheetDialog.findViewById(R.id.touch_outside) : null;
        Drawable background = viewFindViewById != null ? viewFindViewById.getBackground() : null;
        Integer numValueOf = background instanceof ColorDrawable ? Integer.valueOf(((ColorDrawable) background).getColor()) : null;
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        Context context = cOUIBottomSheetDialog != null ? cOUIBottomSheetDialog.getContext() : null;
        int identifier = (context == null || (resources = context.getResources()) == null) ? 0 : resources.getIdentifier("coui_color_mask", "color", context.getPackageName());
        if (context != null && identifier != 0) {
            try {
                return context.getColor(identifier);
            } catch (Exception unused) {
            }
        }
        return h;
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void a() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setNavColor(Integer.MAX_VALUE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.view.View$OnLayoutChangeListener, com.oplus.melody.app.discovery.H1] */
    @Override // com.oplus.melody.app.discovery.E1
    public final void c(F8.a activity) {
        COUIBottomSheetDialog cOUIBottomSheetDialog;
        ViewGroup viewGroup;
        Window window;
        Window window2;
        FrameLayout drawLayout;
        kotlin.jvm.internal.h.e(activity, "activity");
        com.oplus.melody.common.util.A.b("MelodyDialogWrapperImpl", "createBottomSheetDialog");
        COUIBottomSheetDialog cOUIBottomSheetDialog2 = new COUIBottomSheetDialog(activity, R.style.MelodyAppBottomSheetDialog);
        this.f18958b = cOUIBottomSheetDialog2;
        cOUIBottomSheetDialog2.setContentView(R.layout.melody_app_dialog_discovery);
        cOUIBottomSheetDialog2.setCancelable(true);
        if (this.f18957a) {
            g();
        }
        cOUIBottomSheetDialog2.getBehavior().setDraggable(false);
        COUIPanelContentLayout dragableLinearLayout = cOUIBottomSheetDialog2.getDragableLinearLayout();
        if (dragableLinearLayout != null && (drawLayout = dragableLinearLayout.getDrawLayout()) != null) {
            drawLayout.setVisibility(8);
        }
        cOUIBottomSheetDialog2.setCanceledOnTouchOutside(false);
        COUIBottomSheetDialog cOUIBottomSheetDialog3 = this.f18958b;
        WindowManager.LayoutParams attributes = null;
        this.f18959c = cOUIBottomSheetDialog3 != null ? cOUIBottomSheetDialog3.findViewById(R.id.design_bottom_sheet) : null;
        COUIBottomSheetDialog cOUIBottomSheetDialog4 = this.f18958b;
        this.f18960d = cOUIBottomSheetDialog4 != null ? cOUIBottomSheetDialog4.findViewById(R.id.melody_app_discovery_container) : null;
        n();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = activity.getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_dialog_width);
        this.f18962f = activity.getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_dialog_height);
        final int i10 = (int) (r4.widthPixels / activity.getResources().getDisplayMetrics().density);
        final boolean zIsSmallScreenDp = COUIResponsiveUtils.isSmallScreenDp((int) (r5.widthPixels / activity.getResources().getDisplayMetrics().density));
        com.oplus.melody.common.util.A.c("MelodyDialogWrapperImpl", new Supplier() { // from class: com.oplus.melody.app.discovery.F1
            @Override // java.util.function.Supplier
            public final Object get() {
                StringBuilder sbM = androidx.appcompat.widget.a.m(ref$IntRef.element, this.f18962f, "dialogWidth:", " dialogHeight:", " screenWidthDp:");
                sbM.append(i10);
                sbM.append(" isSmallScreen:");
                sbM.append(zIsSmallScreenDp);
                return sbM.toString();
            }
        });
        if (zIsSmallScreenDp) {
            int iE = C0909o.e(activity);
            ref$IntRef.element = iE;
            this.f18962f = (int) (iE / (ref$IntRef.element / this.f18962f));
            com.oplus.melody.common.util.A.c("MelodyDialogWrapperImpl", new Supplier() { // from class: com.oplus.melody.app.discovery.G1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return C1065d.e("new dialogWidth:", " dialogHeight:", ref$IntRef.element, this.f18962f);
                }
            });
            COUIBottomSheetDialog cOUIBottomSheetDialog5 = this.f18958b;
            ViewGroup viewGroup2 = cOUIBottomSheetDialog5 != null ? (ViewGroup) cOUIBottomSheetDialog5.findViewById(R.id.melody_app_elements_container) : null;
            if (viewGroup2 != null) {
                viewGroup2.setPadding(0, 0, 0, activity.getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_elements_container_padding_bottom));
            }
        } else if (this.f18963g && (cOUIBottomSheetDialog = this.f18958b) != null && (viewGroup = (ViewGroup) cOUIBottomSheetDialog.findViewById(R.id.melody_app_elements_container)) != null) {
            viewGroup.setPadding(0, 0, 0, activity.getResources().getDimensionPixelOffset(R.dimen.melody_app_discovery_elements_container_padding_bottom));
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog6 = this.f18958b;
        if (cOUIBottomSheetDialog6 != null) {
            cOUIBottomSheetDialog6.setWidth(ref$IntRef.element);
        }
        View view = this.f18960d;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = ref$IntRef.element;
        }
        if (layoutParams != null) {
            layoutParams.height = this.f18962f;
        }
        View view2 = this.f18960d;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
        if (activity.getResources().getConfiguration().orientation == 2) {
            COUIBottomSheetDialog cOUIBottomSheetDialog7 = this.f18958b;
            final View viewFindViewById = cOUIBottomSheetDialog7 != null ? cOUIBottomSheetDialog7.findViewById(R.id.coordinator) : null;
            View view3 = this.f18959c;
            if (view3 != 0) {
                ?? r12 = new View.OnLayoutChangeListener() { // from class: com.oplus.melody.app.discovery.H1
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view4, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                        ViewGroup.LayoutParams layoutParams2;
                        K1 k12 = this.f18924a;
                        View view5 = k12.f18959c;
                        ViewGroup.LayoutParams layoutParams3 = view5 != null ? view5.getLayoutParams() : null;
                        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                        int i19 = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
                        View view6 = viewFindViewById;
                        int height = view6 != null ? view6.getHeight() : 0;
                        int i20 = k12.f18962f + i19;
                        com.oplus.melody.common.util.A.c("MelodyDialogWrapperImpl", new J1(view6, i19, height, 0));
                        if (i19 <= 0 || height >= i20 || view6 == null || (layoutParams2 = view6.getLayoutParams()) == null) {
                            return;
                        }
                        layoutParams2.height = i20;
                    }
                };
                this.f18961e = r12;
                view3.addOnLayoutChangeListener(r12);
            }
        }
        HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
        if (heyMelodyApplication == null) {
            kotlin.jvm.internal.h.i("context");
            throw null;
        }
        List<String> list = com.oplus.melody.common.util.S.f19463a;
        if ("com.heytap.headset".equals(heyMelodyApplication.getPackageName())) {
            COUIBottomSheetDialog cOUIBottomSheetDialog8 = this.f18958b;
            if (cOUIBottomSheetDialog8 != null && (window2 = cOUIBottomSheetDialog8.getWindow()) != null) {
                attributes = window2.getAttributes();
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                if (attributes != null) {
                    attributes.layoutInDisplayCutoutMode = 3;
                }
            } else if (i11 >= 28 && attributes != null) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            COUIBottomSheetDialog cOUIBottomSheetDialog9 = this.f18958b;
            if (cOUIBottomSheetDialog9 == null || (window = cOUIBottomSheetDialog9.getWindow()) == null) {
                return;
            }
            window.setAttributes(attributes);
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void d(boolean z2) {
        this.f18957a = z2;
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void dismiss() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss();
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void e(r rVar) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnKeyListener(rVar);
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void f() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void g() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setPanelBackground(new ColorDrawable(0));
        }
        int iO = o(this.f18958b);
        COUIBottomSheetDialog cOUIBottomSheetDialog2 = this.f18958b;
        if (cOUIBottomSheetDialog2 != null) {
            cOUIBottomSheetDialog2.setNavColor(iO);
        }
        n();
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void h(ViewOnTouchListenerC0881t viewOnTouchListenerC0881t) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOutSideViewTouchListener(viewOnTouchListenerC0881t);
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void i(DiscoveryDialogActivity discoveryDialogActivity) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOutSideViewTouchListener(null);
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog2 = this.f18958b;
        if (cOUIBottomSheetDialog2 != null) {
            cOUIBottomSheetDialog2.setOnDismissListener(null);
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog3 = this.f18958b;
        if (cOUIBottomSheetDialog3 != null) {
            cOUIBottomSheetDialog3.setOnKeyListener(null);
        }
        COUIBottomSheetDialog cOUIBottomSheetDialog4 = this.f18958b;
        if (cOUIBottomSheetDialog4 != null) {
            cOUIBottomSheetDialog4.dismiss();
        }
        H1 h12 = this.f18961e;
        if (h12 != null) {
            View view = this.f18959c;
            if (view != null) {
                view.removeOnLayoutChangeListener(h12);
            }
            com.oplus.melody.common.util.A.b("MelodyDialogWrapperImpl", "remove mBottomSheetChangeListener");
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final boolean isShowing() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        return cOUIBottomSheetDialog != null && cOUIBottomSheetDialog.isShowing();
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final int j() {
        return o(this.f18958b);
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final <T extends View> T k(int i10) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            return (T) cOUIBottomSheetDialog.findViewById(i10);
        }
        return null;
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void l(DialogInterfaceOnDismissListenerC0879s dialogInterfaceOnDismissListenerC0879s) {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.setOnDismissListener(dialogInterfaceOnDismissListenerC0879s);
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void m(boolean z2) {
        this.f18963g = z2;
    }

    public final void n() {
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog == null) {
            return;
        }
        cOUIBottomSheetDialog.setOutsideMaskColor(0);
        View viewFindViewById = cOUIBottomSheetDialog.findViewById(R.id.panel_outside);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundColor(0);
        }
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void show() {
        View view;
        COUIBottomSheetDialog cOUIBottomSheetDialog = this.f18958b;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.show();
        }
        n();
        if (!this.f18963g || (view = this.f18959c) == null) {
            return;
        }
        view.post(new O0(view, 1));
    }

    @Override // com.oplus.melody.app.discovery.E1
    public final void b(View view) {
    }
}
