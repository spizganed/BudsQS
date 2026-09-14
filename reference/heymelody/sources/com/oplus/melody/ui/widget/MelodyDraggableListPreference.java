package com.oplus.melody.ui.widget;

import A6.e;
import A9.j;
import Ea.ViewOnClickListenerC0410t;
import Kb.q;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.m;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.u.e;
import b9.v;
import com.heytap.headset.R;
import com.oplus.melody.ui.widget.MelodyDraggableListPreference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyDraggableListPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u00046789B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0015J\u0014\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bJ\b\u0010&\u001a\u00020\u001cH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bJ\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0018J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u001cJ\"\u0010-\u001a\u00020\u001c2\u001a\u0010.\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aJ\"\u0010/\u001a\u00020\u001c2\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001eJ\b\u00100\u001a\u00020\u001cH\u0002J\u0018\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\u0010\u00105\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0007H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyDraggableListPreference;", "Landroidx/preference/Preference;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTitleTextView", "Landroid/widget/TextView;", "mEmptyHintTextView", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Lcom/oplus/melody/ui/widget/MelodyDraggableListPreference$DraggableListAdapter;", "mItemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "mEmptyHintText", "", "mItems", "", "Lcom/oplus/melody/ui/widget/MelodyDraggableListPreference$DraggableItem;", "mOnItemsChangedListener", "Lkotlin/Function1;", "", "", "mOnItemDeleteListener", "Lkotlin/Function2;", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setEmptyHintText", "text", "setItems", "items", "updateEmptyStateVisibility", "getItems", "addItem", "item", "removeItemAt", "position", "clearItems", "setOnItemsChangedListener", "listener", "setOnItemDeleteListener", "notifyItemsChanged", "onItemMove", "fromPosition", "toPosition", "onItemMoveCompleted", "onItemDelete", "DraggableItem", "DraggableListAdapter", "DraggableListViewHolder", "DraggableItemTouchHelperCallback", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyDraggableListPreference extends Preference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f21833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f21834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f21835c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f21836p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public u f21837q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f21838r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f21839s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public j f21840t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public H6.a f21841u;

    /* JADX INFO: compiled from: MelodyDraggableListPreference.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v f21844c;

        public a(String id, String title, v vVar) {
            h.e(id, "id");
            h.e(title, "title");
            this.f21842a = id;
            this.f21843b = title;
            this.f21844c = vVar;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return h.a(this.f21842a, aVar.f21842a) && h.a(this.f21843b, aVar.f21843b) && this.f21844c.equals(aVar.f21844c);
        }

        public final int hashCode() {
            return this.f21844c.hashCode() + e.b(this.f21842a.hashCode() * 31, 31, this.f21843b);
        }

        public final String toString() {
            return "DraggableItem(id=" + this.f21842a + ", title=" + this.f21843b + ", extra=" + this.f21844c + ")";
        }
    }

    /* JADX INFO: compiled from: MelodyDraggableListPreference.kt */
    public final class b extends u.d {
        public b() {
            this.f12229a = -1;
        }

        public final void d(RecyclerView recyclerView, RecyclerView.E viewHolder) {
            h.e(recyclerView, "recyclerView");
            h.e(viewHolder, "viewHolder");
            View view = viewHolder.itemView;
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setElevation(0.0f);
            MelodyDraggableListPreference melodyDraggableListPreference = MelodyDraggableListPreference.this;
            j jVar = melodyDraggableListPreference.f21840t;
            if (jVar != null) {
                jVar.d(q.F(melodyDraggableListPreference.f21839s));
            }
        }

        public final int e(RecyclerView recyclerView, RecyclerView.E viewHolder) {
            h.e(recyclerView, "recyclerView");
            h.e(viewHolder, "viewHolder");
            return MelodyDraggableListPreference.this.f21839s.size() <= 1 ? 0 : 196611;
        }

        public final void f(Canvas c6, RecyclerView recyclerView, RecyclerView.E viewHolder, float f9, float f10, boolean z2) {
            h.e(c6, "c");
            h.e(viewHolder, "viewHolder");
            viewHolder.itemView.setTranslationX(f9);
            viewHolder.itemView.setTranslationY(f10);
        }
    }

    /* JADX INFO: compiled from: MelodyDraggableListPreference.kt */
    public final class c extends RecyclerView.Adapter<d> {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return MelodyDraggableListPreference.this.f21839s.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.E e10, int i10) {
            final d holder = (d) e10;
            h.e(holder, "holder");
            a item = (a) MelodyDraggableListPreference.this.f21839s.get(i10);
            h.e(item, "item");
            holder.f21848b.setText(item.f21843b);
            final MelodyDraggableListPreference melodyDraggableListPreference = MelodyDraggableListPreference.this;
            holder.f21847a.setOnTouchListener(new View.OnTouchListener() { // from class: Ea.s
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    androidx.recyclerview.widget.u uVar;
                    if (motionEvent.getActionMasked() == 0 && (uVar = melodyDraggableListPreference.f21837q) != null) {
                        MelodyDraggableListPreference.b bVar = uVar.f12208m;
                        RecyclerView recyclerView = uVar.f12212q;
                        MelodyDraggableListPreference.d dVar = holder;
                        if (!((u.d.a(bVar.e(recyclerView, dVar), recyclerView.getLayoutDirection()) & 16711680) != 0)) {
                            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
                        } else if (dVar.itemView.getParent() != uVar.f12212q) {
                            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
                        } else {
                            VelocityTracker velocityTracker = uVar.f12214s;
                            if (velocityTracker != null) {
                                velocityTracker.recycle();
                            }
                            uVar.f12214s = VelocityTracker.obtain();
                            uVar.f12204i = 0.0f;
                            uVar.h = 0.0f;
                            uVar.r(dVar, 2);
                        }
                    }
                    return false;
                }
            });
            holder.f21849c.setOnClickListener(new ViewOnClickListenerC0410t(0, holder, melodyDraggableListPreference));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.E onCreateViewHolder(ViewGroup parent, int i10) {
            h.e(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.melody_ui_draggable_list_item, parent, false);
            h.b(viewInflate);
            return MelodyDraggableListPreference.this.new d(viewInflate);
        }
    }

    /* JADX INFO: compiled from: MelodyDraggableListPreference.kt */
    public final class d extends RecyclerView.E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f21847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f21848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f21849c;

        public d(View view) {
            super(view);
            View viewFindViewById = view.findViewById(R.id.drag_handle);
            h.d(viewFindViewById, "findViewById(...)");
            this.f21847a = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.item_title);
            h.d(viewFindViewById2, "findViewById(...)");
            this.f21848b = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.delete_button);
            h.d(viewFindViewById3, "findViewById(...)");
            this.f21849c = (ImageView) viewFindViewById3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MelodyDraggableListPreference(Context context) {
        this(context, null, 0, 0, 14, null);
        h.e(context, "context");
    }

    public final void e(List<a> items) {
        h.e(items, "items");
        ArrayList arrayList = this.f21839s;
        arrayList.clear();
        arrayList.addAll(items);
        c cVar = this.f21836p;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        f();
        RecyclerView recyclerView = this.f21835c;
        if (recyclerView != null) {
            recyclerView.post(new Aa.e(this, 3));
        }
    }

    public final void f() {
        boolean zIsEmpty = this.f21839s.isEmpty();
        String str = this.f21838r;
        boolean z2 = str == null || str.length() == 0;
        TextView textView = this.f21834b;
        if (textView != null) {
            textView.setVisibility((!zIsEmpty || z2) ? 8 : 0);
        }
        RecyclerView recyclerView = this.f21835c;
        if (recyclerView != null) {
            recyclerView.setVisibility(zIsEmpty ? 8 : 0);
        }
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        TextView textView;
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        com.google.android.play.core.appupdate.c.S(com.google.android.play.core.appupdate.c.z(this), holder.itemView);
        View viewA = holder.a(R.id.draggable_list_title);
        this.f21833a = viewA instanceof TextView ? (TextView) viewA : null;
        View viewA2 = holder.a(R.id.draggable_list_empty_hint);
        this.f21834b = viewA2 instanceof TextView ? (TextView) viewA2 : null;
        View viewA3 = holder.a(R.id.draggable_list_recycler_view);
        this.f21835c = viewA3 instanceof RecyclerView ? (RecyclerView) viewA3 : null;
        TextView textView2 = this.f21833a;
        if (textView2 != null) {
            textView2.setText(getTitle());
        }
        TextView textView3 = this.f21833a;
        if (textView3 != null) {
            CharSequence title = getTitle();
            textView3.setVisibility((title == null || title.length() == 0) ? 8 : 0);
        }
        String str = this.f21838r;
        if (str != null && (textView = this.f21834b) != null) {
            textView.setText(str);
        }
        f();
        this.f21836p = new c();
        RecyclerView recyclerView = this.f21835c;
        if (recyclerView != null) {
            recyclerView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAdapter(this.f21836p);
            recyclerView.setNestedScrollingEnabled(false);
        }
        u uVar = new u(new b());
        this.f21837q = uVar;
        RecyclerView recyclerView2 = this.f21835c;
        RecyclerView recyclerView3 = uVar.f12212q;
        if (recyclerView3 == recyclerView2) {
            return;
        }
        u.b bVar = uVar.f12220y;
        if (recyclerView3 != null) {
            recyclerView3.removeItemDecoration(uVar);
            uVar.f12212q.removeOnItemTouchListener(bVar);
            uVar.f12212q.removeOnChildAttachStateChangeListener(uVar);
            ArrayList arrayList = uVar.f12211p;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                u.f fVar = (u.f) arrayList.get(0);
                fVar.f12238s.cancel();
                uVar.f12208m.d(uVar.f12212q, fVar.f12236q);
            }
            arrayList.clear();
            uVar.f12217v = null;
            VelocityTracker velocityTracker = uVar.f12214s;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                uVar.f12214s = null;
            }
            u.e eVar = uVar.f12219x;
            if (eVar != null) {
                eVar.f12230a = false;
                uVar.f12219x = null;
            }
            if (uVar.f12218w != null) {
                uVar.f12218w = null;
            }
        }
        uVar.f12212q = recyclerView2;
        if (recyclerView2 != null) {
            Resources resources = recyclerView2.getResources();
            uVar.f12202f = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
            uVar.f12203g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
            ViewConfiguration.get(uVar.f12212q.getContext()).getScaledTouchSlop();
            uVar.f12212q.addItemDecoration(uVar);
            uVar.f12212q.addOnItemTouchListener(bVar);
            uVar.f12212q.addOnChildAttachStateChangeListener(uVar);
            uVar.f12219x = uVar.new e();
            uVar.f12218w = new GestureDetector(uVar.f12212q.getContext(), uVar.f12219x);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MelodyDraggableListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        h.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MelodyDraggableListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        h.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyDraggableListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        this.f21839s = new ArrayList();
        setLayoutResource(R.layout.melody_ui_preference_draggable_list);
        setSelectable(false);
    }

    public /* synthetic */ MelodyDraggableListPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.d dVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }
}
