package com.oplus.melody.ui.component.tutorialguide;

import Ea.E;
import Jb.l;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyCompatButton;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: TutorialGuideButtonPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideButtonPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class TutorialGuideButtonPreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Wb.a<l> f21664a;

    public TutorialGuideButtonPreference() {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialGuideButtonPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        h.e(context, "context");
        this.f21664a = new A7.a(18);
        setLayoutResource(R.layout.melody_ui_guide_function_preference_button_layout);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.control_guide_continue_button);
        h.c(viewA, "null cannot be cast to non-null type com.oplus.melody.ui.widget.MelodyCompatButton");
        ((MelodyCompatButton) viewA).setOnClickListener(new E(this, 19));
    }
}
