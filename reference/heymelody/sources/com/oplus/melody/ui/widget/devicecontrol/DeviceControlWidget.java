package com.oplus.melody.ui.widget.devicecontrol;

import A9.d;
import C6.g;
import Kb.l;
import Kb.m;
import Kb.q;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.oplus.iotui.model.ModeItem;
import com.oplus.melody.common.util.A;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: DeviceControlWidget.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0010\u0018\u0000 72\u00020\u0001:\u000267B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0014\u0010\u0017\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0016\u0010\u0019\u001a\u00020\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0014H\u0002J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000eJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aJ\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aH\u0002J\b\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020+H\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0002J\u0016\u00102\u001a\u00020\u00162\f\u00103\u001a\b\u0012\u0004\u0012\u00020+0\u001aH\u0002J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aH\u0002R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/oplus/melody/ui/widget/devicecontrol/DeviceControlWidget;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mManualChangeTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "mListener", "Lcom/oplus/melody/ui/widget/devicecontrol/DeviceControlWidget$OnActionListener;", "mHandler", "com/oplus/melody/ui/widget/devicecontrol/DeviceControlWidget$mHandler$1", "Lcom/oplus/melody/ui/widget/devicecontrol/DeviceControlWidget$mHandler$1;", "mList", "", "Lcom/oplus/iotui/model/ModeItem;", "onDetachedFromWindow", "", "submitModeList", "modeList", "notifyModeItems", "", "notifyModeItem", "it", "setOnActionListener", "listener", "getModeList", "setViewMinHeight", "height", "", "setEnable", "enable", "", "getChildModeIndex", "modeName", "setModeItems", "actions", "generateModeButton", "Landroid/view/View;", "setModeButton", "modeItem", "modeRootView", "setNormalModeButton", "button", "Lcom/oplus/melody/ui/widget/devicecontrol/NormalModeButton;", "addViews", "views", "listDeepCopy", "list", "OnActionListener", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeviceControlWidget extends LinearLayoutCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f21986q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f21987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f21988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.oplus.melody.ui.widget.devicecontrol.a f21989c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f21990p;

    /* JADX INFO: compiled from: DeviceControlWidget.kt */
    public interface a {
        void a(ModeItem modeItem, boolean z2);

        void b(ModeItem modeItem);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceControlWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f21987a = new ConcurrentHashMap<>();
        this.f21989c = new com.oplus.melody.ui.widget.devicecontrol.a(this, Looper.getMainLooper());
        this.f21990p = new ArrayList();
    }

    private final void setModeItems(List<? extends ModeItem> actions) {
        ArrayList arrayList = new ArrayList(m.i(actions));
        for (ModeItem modeItem : actions) {
            Context context = getContext();
            h.d(context, "getContext(...)");
            c cVar = new c(context);
            cVar.setId(View.generateViewId());
            a(modeItem, cVar);
            cVar.setTag(modeItem.getId());
            arrayList.add(cVar);
        }
        setOrientation(0);
        removeAllViews();
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            int i12 = i10 + 1;
            if (i10 < 0) {
                l.h();
                throw null;
            }
            View view = (View) obj;
            LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(0, -2);
            ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
            view.setLayoutParams(layoutParams);
            addView(view);
            i10 = i12;
        }
    }

    public final void a(ModeItem modeItem, View view) {
        c cVar = (c) view;
        String name = modeItem.getName();
        if (name != null) {
            cVar.setName(name);
        }
        Drawable icon = modeItem.getIcon();
        if (icon != null) {
            cVar.setIcon(icon);
        }
        Integer color = modeItem.getColor();
        if (color != null) {
            cVar.setSelectedColor(color.intValue());
        }
        cVar.setShowGrayBg(modeItem.getShowGrayBg());
        boolean selected = modeItem.getSelected();
        boolean enabled = modeItem.getEnabled();
        boolean isLoading = modeItem.getIsLoading();
        cVar.setLoadingState(isLoading);
        cVar.setEnableState(enabled);
        A.c("UDeviceNormalModeButton", new C6.c(cVar, selected, isLoading, 1));
        if (!Boolean.valueOf(selected).equals(cVar.f22001t)) {
            cVar.f22001t = Boolean.valueOf(selected);
            cVar.f21995b.setSelected(selected);
            if (cVar.f21994a) {
                cVar.d();
            } else {
                cVar.f21997p.setVisibility(8);
                cVar.e(cVar.f22001t, isLoading);
            }
        }
        cVar.setListener(new b(this, modeItem));
    }

    public final void b(ArrayList modeList) {
        h.e(modeList, "modeList");
        A.c("UDeviceActionContainer", new g(modeList, 1));
        try {
            ArrayList arrayList = this.f21990p;
            ArrayList arrayList2 = new ArrayList(m.i(arrayList));
            int size = arrayList.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList.get(i11);
                i11++;
                arrayList2.add(((ModeItem) obj).getId());
            }
            ArrayList arrayList3 = new ArrayList(m.i(modeList));
            int size2 = modeList.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj2 = modeList.get(i12);
                i12++;
                arrayList3.add(((ModeItem) obj2).getId());
            }
            if (arrayList2.equals(arrayList3)) {
                int size3 = modeList.size();
                while (i10 < size3) {
                    Object obj3 = modeList.get(i10);
                    i10++;
                    ModeItem modeItem = (ModeItem) obj3;
                    View viewFindViewWithTag = findViewWithTag(modeItem.getId());
                    if (viewFindViewWithTag != null) {
                        a(modeItem, viewFindViewWithTag);
                    } else {
                        A.c("UDeviceActionContainer", new d(modeItem, 17));
                    }
                }
            } else {
                setModeItems(modeList);
            }
        } catch (Exception unused) {
            A.h("UDeviceActionContainer", "submit list error!");
            this.f21990p.clear();
        }
        this.f21990p = modeList;
    }

    public final List<ModeItem> getModeList() {
        return q.F(this.f21990p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f21989c.removeCallbacksAndMessages(null);
    }

    public final void setEnable(boolean enable) {
        if (enable) {
            b(this.f21990p);
        } else {
            ArrayList arrayList = this.f21990p;
            ArrayList arrayList2 = new ArrayList(m.i(arrayList));
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ModeItem modeItem = (ModeItem) obj;
                ModeItem modeItem2 = new ModeItem();
                modeItem2.q(modeItem.getId());
                modeItem2.p(modeItem.getIcon());
                modeItem2.n(modeItem.getColor());
                modeItem2.s(modeItem.getName());
                modeItem2.u(modeItem.getSelected());
                modeItem2.t(modeItem.getNeedLoading());
                modeItem2.w(modeItem.getSinglePress());
                modeItem2.r(modeItem.getIsLoading());
                modeItem2.o(modeItem.getEnabled());
                modeItem2.x(modeItem.getStateData());
                arrayList2.add(modeItem2);
            }
            int size2 = arrayList2.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj2 = arrayList2.get(i11);
                i11++;
                ModeItem modeItem3 = (ModeItem) obj2;
                modeItem3.o(false);
                View viewFindViewWithTag = findViewWithTag(modeItem3.getId());
                if (viewFindViewWithTag != null) {
                    a(modeItem3, viewFindViewWithTag);
                } else {
                    A.c("UDeviceActionContainer", new d(modeItem3, 17));
                }
            }
        }
        setAlpha(enable ? 1.0f : 0.3f);
    }

    public final void setOnActionListener(a listener) {
        h.e(listener, "listener");
        this.f21988b = listener;
    }

    public final void setViewMinHeight(int height) {
        setMinimumHeight(height);
    }
}
