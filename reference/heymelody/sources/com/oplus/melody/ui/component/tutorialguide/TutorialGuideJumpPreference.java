package com.oplus.melody.ui.component.tutorialguide;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.m;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: TutorialGuideJumpPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideJumpPreference;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class TutorialGuideJumpPreference extends MelodyUiCOUIJumpPreference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TutorialGuideJumpPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        h.e(context, "context");
        setLayoutResource(R.layout.melody_ui_tutorial_guide_jump_preference);
    }

    @Override // com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
    }
}
