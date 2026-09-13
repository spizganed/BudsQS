package com.oplus.melody.ui.component.control.preference;

import G8.x;
import H8.h;
import K8.b;
import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentManager;
import com.coui.appcompat.preference.COUIPreference;
import com.oplus.melody.ui.component.control.b;
import com.oplus.melody.ui.component.control.dialog.CustomLongPressPanelFragment;
import com.oplus.melody.ui.component.control.dialog.MultiSelectVO;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CustomMultiSelectPreference extends COUIPreference implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.a f20569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MultiSelectVO f20570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FragmentManager f20571c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public h f20572p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public x f20573q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CustomLongPressPanelFragment f20574r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f20575s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f20576t;

    public CustomMultiSelectPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20575s = false;
        this.f20576t = 0;
    }

    public static ArrayList e(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null || charSequenceArr.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (CharSequence charSequence : charSequenceArr) {
            arrayList.add((String) charSequence);
        }
        return arrayList;
    }

    @Override // K8.b
    public final void b(int i10) {
        this.f20570b.setTitleResId(i10);
    }

    public final void f(String str) {
        super.setAssignment(str);
    }

    @Override // K8.b
    public final Object getTag() {
        return this.f20569a;
    }

    public final void h(Object obj) {
        if (obj != null) {
            if (obj instanceof List) {
                this.f20570b.setChooseValueList((List) obj);
            } else if (obj instanceof String) {
                this.f20570b.setChooseValue(obj.toString());
            }
        }
    }
}
