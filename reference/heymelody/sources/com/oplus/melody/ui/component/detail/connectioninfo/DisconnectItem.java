package com.oplus.melody.ui.component.detail.connectioninfo;

import Aa.e;
import C0.a;
import Q7.n;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import java.util.concurrent.ForkJoinPool;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: DisconnectItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/connectioninfo/DisconnectItem;", "Lcom/coui/appcompat/preference/COUIPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DisconnectItem extends COUIPreference {
    public static final String ITEM_NAME = "DisconnectItem";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisconnectItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(context.getString(R.string.melody_ui_detail_main_menu_disconnect));
        Resources resources = context.getResources();
        if (resources != null) {
            setTitleColor(ColorStateList.valueOf(resources.getColor(R.color.coui_color_primary_text_red, null)));
        }
        setOnPreferenceClickListener(new a(viewModel, 19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$1(DetailMainViewModel detailMainViewModel, Preference it) {
        h.e(it, "it");
        if (TextUtils.isEmpty(detailMainViewModel.f20397b)) {
            return true;
        }
        AbstractC0939b.E().c(detailMainViewModel.f20397b);
        ForkJoinPool.commonPool().execute(new e(detailMainViewModel, 21));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$0(DetailMainViewModel detailMainViewModel) {
        String str = detailMainViewModel.f20397b;
        Object obj = n.f4193c;
        if (n.a.a().d(str)) {
            n.a.a().o(detailMainViewModel.f20397b);
        }
    }
}
