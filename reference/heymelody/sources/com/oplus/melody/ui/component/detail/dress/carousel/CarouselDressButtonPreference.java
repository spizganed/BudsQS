package com.oplus.melody.ui.component.detail.dress.carousel;

import androidx.preference.m;
import com.coui.appcompat.preference.COUIButtonPreference;
import com.google.android.play.core.appupdate.c;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CarouselDressButtonPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressButtonPreference;", "Lcom/coui/appcompat/preference/COUIButtonPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressButtonPreference extends COUIButtonPreference {
    @Override // com.coui.appcompat.preference.COUIButtonPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        holder.itemView.setMinimumHeight(getContext().getResources().getDimensionPixelSize(R.dimen.melody_ui_carousel_dress_item_min_height));
        int iZ = c.z(this);
        if (iZ == 3 || iZ == 4) {
            holder.itemView.invalidateOutline();
        }
    }
}
