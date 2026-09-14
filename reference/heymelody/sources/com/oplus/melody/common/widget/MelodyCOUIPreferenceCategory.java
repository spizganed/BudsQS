package com.oplus.melody.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyCOUIPreferenceCategory.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/common/widget/MelodyCOUIPreferenceCategory;", "Lcom/coui/appcompat/preference/COUIPreferenceCategory;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mTextInRightResId", "", "Ljava/lang/Integer;", "mAttached", "", "setTextResInRight", "", "text", "onAttached", "onDetached", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyCOUIPreferenceCategory extends COUIPreferenceCategory {

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public Integer f19529O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f19530P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyCOUIPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
    }

    public final void m(int i10) {
        if (!this.f19530P) {
            this.f19529O = Integer.valueOf(i10);
            return;
        }
        if (i10 != 0) {
            String string = getContext().getString(i10);
            if (!TextUtils.equals(string, this.f14691y)) {
                this.f14691y = string;
                notifyChanged();
            }
        } else if (!TextUtils.equals(null, this.f14691y)) {
            this.f14691y = null;
            notifyChanged();
        }
        this.f19529O = null;
    }

    @Override // androidx.preference.PreferenceGroup, androidx.preference.Preference
    public final void onAttached() {
        super.onAttached();
        this.f19530P = true;
        Integer num = this.f19529O;
        if (num != null) {
            m(num.intValue());
        }
    }

    @Override // androidx.preference.PreferenceGroup, androidx.preference.Preference
    public final void onDetached() {
        this.f19530P = false;
        super.onDetached();
    }

    public /* synthetic */ MelodyCOUIPreferenceCategory(Context context, AttributeSet attributeSet, int i10, d dVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
