package com.oplus.melody.ui.component.control.preference;

import Ea.ViewOnClickListenerC0405n;
import G7.e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.headset.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyTipsView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002 !B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0013J\u0014\u0010\u001b\u001a\u00020\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0015R\u000e\u0010\f\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/oplus/melody/ui/component/control/preference/MelodyTipsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mTitle", "Landroid/widget/TextView;", "mTipItems", "Landroidx/recyclerview/widget/RecyclerView;", "mQuickAdapter", "Lcom/oplus/melody/common/widget/QuickAdapter;", "", "mClickListener", "Lcom/oplus/melody/ui/component/control/preference/MelodyTipsView$OnTipsItemClick;", "init", "", "onFinishInflate", "setTitle", "title", "setTipItems", "items", "", "setItemClickListener", "listener", "TipsAdapter", "OnTipsItemClick", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyTipsView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f20587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f20588c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f20589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f20590q;

    /* JADX INFO: compiled from: MelodyTipsView.kt */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: MelodyTipsView.kt */
    public final class b extends e<String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MelodyTipsView f20591b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MelodyTipsView melodyTipsView, EmptyList items) {
            super(items);
            h.e(items, "items");
            this.f20591b = melodyTipsView;
        }

        @Override // G7.e
        public final void c(e.a aVar, String str, int i10) {
            TextView textView;
            TextView textView2;
            String str2 = str;
            if (aVar != null && (textView2 = (TextView) aVar.a(R.id.tips_item_title)) != null) {
                textView2.setText(str2);
            }
            if (aVar == null || (textView = (TextView) aVar.a(R.id.tips_item_title)) == null) {
                return;
            }
            textView.setOnClickListener(new ViewOnClickListenerC0405n(this.f20591b, i10));
        }

        @Override // G7.e
        public final int d() {
            return R.layout.melody_ui_tips_list_item;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        Context context2 = getContext();
        h.d(context2, "getContext(...)");
        this.f20586a = context2;
        this.f20589p = new b(this, EmptyList.f25350a);
        View.inflate(getContext(), R.layout.melody_ui_tips_view_layout, this);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(R.id.tips_title);
        h.d(viewFindViewById, "findViewById(...)");
        this.f20587b = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tip_items);
        h.d(viewFindViewById2, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        this.f20588c = recyclerView;
        b bVar = this.f20589p;
        if (bVar == null) {
            h.i("mQuickAdapter");
            throw null;
        }
        recyclerView.setAdapter(bVar);
        RecyclerView recyclerView2 = this.f20588c;
        if (recyclerView2 == null) {
            h.i("mTipItems");
            throw null;
        }
        if (this.f20586a != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(1));
        } else {
            h.i("mContext");
            throw null;
        }
    }

    public final void setItemClickListener(a listener) {
        h.e(listener, "listener");
        this.f20590q = listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTipItems(List<String> items) {
        h.e(items, "items");
        b bVar = this.f20589p;
        if (bVar == null) {
            h.i("mQuickAdapter");
            throw null;
        }
        bVar.f1907a = items;
        bVar.notifyDataSetChanged();
    }

    public final void setTitle(String title) {
        h.e(title, "title");
        TextView textView = this.f20587b;
        if (textView != null) {
            textView.setText(title);
        } else {
            h.i("mTitle");
            throw null;
        }
    }
}
