package com.oplus.melody.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.m;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.j;
import com.heytap.headset.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyRecommendedPreference extends Preference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f21898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f21899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21900c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f21901p;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f21903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21904c = true;

        public a(String str, b bVar) {
            this.f21902a = str;
            this.f21903b = bVar;
        }
    }

    public interface b {
        void c();
    }

    public static class c extends RecyclerView.Adapter<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f21905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f21906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList f21908d;

        public c() {
            throw null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f21908d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i10) {
            return i10 == 0 ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.E e10, int i10) {
            d dVar = (d) e10;
            a aVar = (a) this.f21908d.get(i10);
            TextView textView = dVar.f21909a;
            textView.setText(aVar.f21902a);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = dVar.f21910b;
            cOUICardListSelectedItemLayout.setRadius(this.f21906b);
            cOUICardListSelectedItemLayout.setBackgroundColor(this.f21907c);
            Context context = this.f21905a;
            if (i10 > 0) {
                if (i10 == this.f21908d.size() - 1) {
                    cOUICardListSelectedItemLayout.setPositionInGroup(3);
                    cOUICardListSelectedItemLayout.setPaddingRelative(cOUICardListSelectedItemLayout.getPaddingStart(), cOUICardListSelectedItemLayout.getPaddingTop(), cOUICardListSelectedItemLayout.getPaddingEnd(), context.getResources().getDimensionPixelOffset(R.dimen.recommended_recyclerView_padding_bottom));
                } else if (cOUICardListSelectedItemLayout.getPaddingBottom() == context.getResources().getDimensionPixelOffset(R.dimen.recommended_recyclerView_padding_bottom)) {
                    cOUICardListSelectedItemLayout.setPaddingRelative(cOUICardListSelectedItemLayout.getPaddingStart(), cOUICardListSelectedItemLayout.getPaddingTop(), cOUICardListSelectedItemLayout.getPaddingEnd(), 0);
                    cOUICardListSelectedItemLayout.setPositionInGroup(2);
                } else {
                    cOUICardListSelectedItemLayout.setPositionInGroup(2);
                }
                cOUICardListSelectedItemLayout.setOnClickListener(new com.oplus.melody.ui.widget.a(aVar));
            } else if (i10 == 0) {
                cOUICardListSelectedItemLayout.setClickable(false);
                cOUICardListSelectedItemLayout.setPositionInGroup(1);
            }
            if (i10 == 0) {
                return;
            }
            cOUICardListSelectedItemLayout.setEnabled(aVar.f21904c);
            textView.setTextColor(aVar.f21904c ? P1.a.b(context, R.attr.couiColorPrimaryNeutral, 0) : P1.a.b(context, R.attr.couiColorLabelTertiary, 0));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.E onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return i10 == 0 ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommended_head_textview, viewGroup, false)) : new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommended_common_textview, viewGroup, false));
        }
    }

    public static class d extends RecyclerView.E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f21909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final COUICardListSelectedItemLayout f21910b;

        public d(View view) {
            super(view);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view;
            this.f21910b = cOUICardListSelectedItemLayout;
            this.f21909a = (TextView) view.findViewById(R.id.txt_content);
            cOUICardListSelectedItemLayout.setClickable(true);
        }
    }

    public MelodyRecommendedPreference(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    public final void onBindViewHolder(m mVar) {
        super.onBindViewHolder(mVar);
        RecyclerView recyclerView = (RecyclerView) mVar.itemView;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            Context context = getContext();
            ArrayList arrayList = this.f21898a;
            String str = this.f21901p;
            c cVar = new c();
            ArrayList arrayList2 = new ArrayList();
            cVar.f21908d = arrayList2;
            cVar.f21905a = context;
            cVar.f21906b = this.f21899b;
            cVar.f21907c = this.f21900c;
            arrayList2.clear();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
                a aVar = new a();
                aVar.f21904c = true;
                aVar.f21902a = str;
                arrayList2.add(0, aVar);
            }
            cVar.notifyDataSetChanged();
            recyclerView.setAdapter(cVar);
        } else {
            c cVar2 = (c) adapter;
            ArrayList arrayList3 = this.f21898a;
            String str2 = this.f21901p;
            ArrayList arrayList4 = cVar2.f21908d;
            arrayList4.clear();
            if (arrayList3 != null) {
                arrayList4.addAll(arrayList3);
                a aVar2 = new a();
                aVar2.f21904c = true;
                aVar2.f21902a = str2;
                arrayList4.add(0, aVar2);
            }
            cVar2.notifyDataSetChanged();
        }
        recyclerView.setFocusable(false);
    }

    public MelodyRecommendedPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiRecommendedPreferenceStyle);
    }

    public MelodyRecommendedPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.Preference_COUIRecommendedPreference);
    }

    public MelodyRecommendedPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        setLayoutResource(R.layout.coui_recommended_preference_layout);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ub.a.f28104q, i10, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(1, P1.a.c(getContext(), R.attr.couiRoundCornerM));
        this.f21899b = dimension;
        int color = typedArrayObtainStyledAttributes.getColor(0, P1.a.b(getContext(), R.attr.couiColorContainer4, 0));
        this.f21900c = color;
        new j(dimension, color);
        String string = typedArrayObtainStyledAttributes.getString(2);
        this.f21901p = string;
        if (string == null) {
            this.f21901p = getContext().getResources().getString(R.string.bottom_recommended_header_title);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
