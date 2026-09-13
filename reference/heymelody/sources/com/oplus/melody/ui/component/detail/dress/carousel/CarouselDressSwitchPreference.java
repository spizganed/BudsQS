package com.oplus.melody.ui.component.detail.dress.carousel;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.preference.m;
import com.coui.appcompat.preference.COUISwitchWithDividerPreference;
import com.google.android.play.core.appupdate.c;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: CarouselDressSwitchPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/oplus/melody/ui/component/detail/dress/carousel/CarouselDressSwitchPreference;", "Lcom/coui/appcompat/preference/COUISwitchWithDividerPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CarouselDressSwitchPreference extends COUISwitchWithDividerPreference {
    @Override // com.coui.appcompat.preference.COUISwitchWithDividerPreference, com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        holder.itemView.setMinimumHeight(getContext().getResources().getDimensionPixelSize(R.dimen.melody_ui_carousel_dress_item_min_height));
        View view = holder.itemView;
        if (view instanceof LinearLayout) {
            h.c(view, "null cannot be cast to non-null type android.widget.LinearLayout");
            ((LinearLayout) view).setGravity(16);
        }
        View viewFindViewById = holder.itemView.findViewById(R.id.main_layout);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            if (layoutParams.height != -1) {
                layoutParams.height = -1;
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }
        int iZ = c.z(this);
        if (iZ == 3 || iZ == 4) {
            holder.itemView.invalidateOutline();
        }
    }
}
