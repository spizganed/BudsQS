package com.heytap.headset.component.mydevicelist.batteryview;

import W3.a;
import W3.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: BatterysView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0018\u001a\u00020\u0019R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/heytap/headset/component/mydevicelist/batteryview/BatterysView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "kotlin.jvm.PlatformType", "mMultiShowInfos", "", "Lcom/heytap/headset/component/mydevicelist/batteryview/BatteryViewItem;", "mBatteryViewAdapter", "Lcom/heytap/headset/component/mydevicelist/batteryview/BatteryViewAdapter;", "mListMultiInfo", "Landroidx/recyclerview/widget/RecyclerView;", "onFinishInflate", "", "initView", "showLinked", "linkInfos", "showTitle", "", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BatterysView extends FrameLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f17494q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f17496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f17497c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RecyclerView f17498p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatterysView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f17495a = "BatterysView";
        this.f17496b = new ArrayList();
        View viewFindViewById = View.inflate(getContext(), R.layout.heymelody_app_batterys_view, this).findViewById(R.id.mListMultiInfo);
        h.d(viewFindViewById, "findViewById(...)");
        this.f17498p = (RecyclerView) viewFindViewById;
    }

    public final void a(ArrayList arrayList) {
        this.f17496b = arrayList;
        A.c(this.f17495a, new c(arrayList, 0));
        RecyclerView recyclerView = this.f17498p;
        if (recyclerView == null) {
            h.i("mListMultiInfo");
            throw null;
        }
        recyclerView.setVisibility(0);
        a aVar = this.f17497c;
        if (aVar != null) {
            ArrayList list = this.f17496b;
            h.e(list, "list");
            aVar.f5482b = list;
            aVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.x1(0);
        RecyclerView recyclerView = this.f17498p;
        if (recyclerView == null) {
            h.i("mListMultiInfo");
            throw null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        Context context = getContext();
        h.d(context, "getContext(...)");
        ArrayList mListData = this.f17496b;
        h.e(mListData, "mListData");
        a aVar = new a();
        aVar.f5481a = context;
        aVar.f5482b = mListData;
        this.f17497c = aVar;
        recyclerView.setAdapter(aVar);
    }
}
