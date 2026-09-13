package com.oplus.melody.ui.component.detail.feedback;

import Jb.a;
import L8.X;
import P8.c;
import Wb.l;
import a9.C0531H;
import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.v;
import androidx.preference.Preference;
import b8.C0731a;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference;
import e9.C1020d;
import java.util.concurrent.ForkJoinPool;
import kotlin.Metadata;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import t8.t;

/* JADX INFO: compiled from: FeedbackItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/oplus/melody/ui/component/detail/feedback/FeedbackItem;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FeedbackItem extends MelodyUiCOUIJumpPreference {
    public static final String ITEM_NAME = "FeedbackItem";

    /* JADX INFO: compiled from: FeedbackItem.kt */
    public static final class b implements v, f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f21007a;

        public b(l lVar) {
            this.f21007a = lVar;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof v) && (obj instanceof f)) {
                return h.a(getFunctionDelegate(), ((f) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.f
        public final a<?> getFunctionDelegate() {
            return this.f21007a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.v
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21007a.d(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        setTitle(R.string.melody_common_feedback);
        setOnPreferenceClickListener(new c(context, viewModel));
        C0731a.f13070c.getClass();
        C0731a.f13071p.e(lifecycleOwner, new b(new C1020d(this, 1)));
        ForkJoinPool.commonPool().execute(new X(viewModel));
        viewModel.d(viewModel.f20397b).e(lifecycleOwner, new b(new C0531H(this, 12)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(Context context, DetailMainViewModel detailMainViewModel, Preference it) {
        h.e(it, "it");
        if (!(context instanceof Activity)) {
            A.h(ITEM_NAME, "context is not activity!");
            return false;
        }
        Activity activity = (Activity) context;
        String str = detailMainViewModel.f20397b;
        C0731a.f13070c.getClass();
        if (activity == null) {
            A.x("FeedbackRepository", "openFeedbackPage activity is null!");
            return true;
        }
        t.a();
        A.x("FeedbackRepository", "openFeedbackPage not support feedback!");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$1(FeedbackItem feedbackItem, Integer num) {
        if (num == null || num.intValue() <= 0) {
            feedbackItem.setEndRedDotMode(0);
        } else {
            feedbackItem.setEndRedDotMode(1);
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(DetailMainViewModel detailMainViewModel) {
        detailMainViewModel.getClass();
        C0731a.f13070c.getClass();
        t.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l _init_$lambda$3(FeedbackItem feedbackItem, Integer num) {
        feedbackItem.setEnabled(num != null && num.intValue() == 2);
        return Jb.l.f2618a;
    }
}
