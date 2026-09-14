package com.oplus.melody.ui.component.control.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.oplus.melody.ui.widget.MelodyRecommendedPreference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyTipsPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ.\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/ui/component/control/preference/MelodyTipsPreference;", "Lcom/oplus/melody/ui/widget/MelodyRecommendedPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "address", "", "productName", "productId", "colorId", "mEntities", "", "Lcom/oplus/melody/ui/widget/MelodyRecommendedPreference$MelodyRecommendedEntity;", "bindEarphone", "", "initView", "setEnabled", "enabled", "", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyTipsPreference extends MelodyRecommendedPreference {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f20580q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f20581r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f20582s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f20583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f20584u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f20585v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTipsPreference(Context context) {
        super(context);
        h.e(context, "context");
        this.f20581r = "";
        this.f20582s = "";
        this.f20583t = "";
        this.f20584u = "";
        this.f20580q = context;
    }

    @Override // androidx.preference.Preference
    public final void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        ArrayList arrayList = this.f20585v;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((MelodyRecommendedPreference.a) obj).f21904c = enabled;
            }
            if (arrayList.isEmpty()) {
                setVisible(false);
                return;
            }
            setVisible(true);
            this.f21898a = arrayList;
            notifyChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTipsPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f20581r = "";
        this.f20582s = "";
        this.f20583t = "";
        this.f20584u = "";
        this.f20580q = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTipsPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        this.f20581r = "";
        this.f20582s = "";
        this.f20583t = "";
        this.f20584u = "";
        this.f20580q = context;
    }
}
