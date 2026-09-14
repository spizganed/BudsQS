package com.oplus.melody.ui.component.detail.questiontips;

import A9.e;
import C0.a;
import D7.C0373g;
import E9.h;
import F8.i;
import Jb.b;
import Wb.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.InterfaceC0601m;
import com.coui.appcompat.preference.COUIRecommendedPreference;
import com.heytap.headset.R;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0905k;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.AbsItem;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import java.util.ArrayList;
import java.util.List;
import kc.C1264t;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class QuestionTipsItem extends COUIRecommendedPreference {
    public static final String ITEM_NAME = "questionTips";
    private Context mContext;
    private DetailMainViewModel mViewModel;

    public QuestionTipsItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        setHeaderText(context.getString(R.string.melody_ui_smart_guess_title));
        ArrayList arrayList = new ArrayList();
        Intent dolbyIntent = getDolbyIntent(this.mContext);
        if (dolbyIntent != null && hasDolbyFunction(this.mContext)) {
            arrayList.add(new COUIRecommendedPreference.c(context.getString(R.string.melody_ui_dolby_atmos_title), new e(1, this, dolbyIntent)));
        }
        if (hasEarProtectFunction(this.mContext)) {
            arrayList.add(new COUIRecommendedPreference.c(context.getString(R.string.melody_common_ear_protect_title), new a(this, 7)));
        }
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(null, this.mViewModel.f20398c);
        if (whitelistConfigDTOC != null && hasCleanGuide(whitelistConfigDTOC.getFunction())) {
            arrayList.add(new COUIRecommendedPreference.c(context.getString(R.string.melody_common_guide_clean_title), new h(this, 1)));
        }
        setData(arrayList);
    }

    private static Intent getDolbyIntent(Context context) {
        Intent intent = new Intent();
        if (D4.a.a()) {
            intent.setAction("oplus.intent.action.settings.DOLBY_MAIN");
        } else {
            intent.setAction("com.oppo.dolby.DolbyMainActivity");
        }
        intent.addCategory("android.intent.category.DEFAULT");
        kotlin.jvm.internal.h.e(context, "context");
        C0905k.h(context, intent);
        if (intent.getComponent() != null) {
            return intent;
        }
        return null;
    }

    public static boolean hasCleanGuide(WhitelistConfigDTO.Function function) {
        return function != null && function.getCleanGuide() == 1;
    }

    private static boolean hasDolbyFunction(Context context) {
        return getDolbyIntent(context) != null && C0373g.f1080e;
    }

    private static boolean hasEarProtectFunction(Context context) {
        return false;
    }

    public static boolean hasFunction(Context context, WhitelistConfigDTO.Function function) {
        return hasDolbyFunction(context) || hasEarProtectFunction(context) || hasCleanGuide(function);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$0(Intent intent, View view) {
        try {
            Context context = this.mContext;
            kotlin.jvm.internal.h.e(context, "context");
            kotlin.jvm.internal.h.e(intent, "intent");
            C0905k.j(context, intent);
            DetailMainViewModel detailMainViewModel = this.mViewModel;
            String str = detailMainViewModel.f20400e;
            String str2 = detailMainViewModel.f20397b;
            C1264t.t(AppConstant$FunctionType.DOLBY_ATMOS.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
        } catch (Exception unused) {
            A.h(ITEM_NAME, "DolbyAtmos start dolby setting failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$1(View view) {
        A.b(ITEM_NAME, "click protect title");
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.HEARING_PROTECT.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$new$2(View view) {
        A.b(ITEM_NAME, "click clean guide");
        b<List<l<String, Class<?>>>> bVar = i.f1668g;
        i iVarA = i.a.a("/ui/clean_dirty");
        iVarA.f("device_mac_info", this.mViewModel.f20397b);
        iVarA.a(9);
        iVarA.b(this.mContext);
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.CLEAN_GUIDE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    public void setBackgroundType(AbsItem.BackgroundType backgroundType) {
    }
}
