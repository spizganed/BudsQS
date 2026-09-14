package com.oplus.melody.ui.widget;

import D7.L;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.preference.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.coui.appcompat.indicator.COUIPageIndicator;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.common.util.A;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyViewPagerGuidePreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001cR\u000e\u0010\f\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyViewPagerGuidePreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mIndicator", "Lcom/coui/appcompat/indicator/COUIPageIndicator;", "viewPagerData", "", "Lcom/oplus/melody/ui/component/detail/aitranslation/GuideViewPagerDataVO;", "mMelodyViewPagerAdapter", "Lcom/oplus/melody/ui/widget/MelodyViewPagerGuidePreference$MelodyViewPagerAdapter;", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "setViewPagerData", ClientDataEntity.COL_DATA, "", "Companion", "MelodyViewPagerAdapter", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyViewPagerGuidePreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewPager2 f21975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public COUIPageIndicator f21976c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f21977p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f21978q;

    /* JADX INFO: compiled from: MelodyViewPagerGuidePreference.kt */
    public final class a extends RecyclerView.Adapter<C0236a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f21979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f21980b;

        /* JADX INFO: renamed from: com.oplus.melody.ui.widget.MelodyViewPagerGuidePreference$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MelodyViewPagerGuidePreference.kt */
        public final class C0236a extends RecyclerView.E {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImageView f21981a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TextView f21982b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final TextView f21983c;

            public C0236a(View view) {
                super(view);
                View viewFindViewById = view.findViewById(R.id.view_pager_img);
                h.d(viewFindViewById, "findViewById(...)");
                this.f21981a = (ImageView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(R.id.view_pager_hint);
                h.d(viewFindViewById2, "findViewById(...)");
                this.f21982b = (TextView) viewFindViewById2;
                View viewFindViewById3 = view.findViewById(R.id.view_pager_title);
                h.d(viewFindViewById3, "findViewById(...)");
                this.f21983c = (TextView) viewFindViewById3;
            }
        }

        public a(Context mContext, ArrayList data) {
            h.e(mContext, "mContext");
            h.e(data, "data");
            this.f21979a = mContext;
            this.f21980b = data;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f21980b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.E e10, int i10) {
            C0236a holder = (C0236a) e10;
            h.e(holder, "holder");
            ArrayList arrayList = this.f21980b;
            File imageFile = ((Q8.b) arrayList.get(i10)).getImageFile();
            Context context = this.f21979a;
            ImageView imageView = holder.f21981a;
            if (imageFile != null) {
                Glide.with(context).load(imageFile).into(imageView);
            }
            int drawable = ((Q8.b) arrayList.get(i10)).getDrawable();
            if (drawable != -1) {
                Glide.with(context).load(Integer.valueOf(drawable)).into(imageView);
            }
            holder.f21982b.setText(((Q8.b) arrayList.get(i10)).getHint());
            int title = ((Q8.b) arrayList.get(i10)).getTitle();
            TextView textView = holder.f21983c;
            if (title == -1) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(((Q8.b) arrayList.get(i10)).getTitle());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.E onCreateViewHolder(ViewGroup parent, int i10) {
            h.e(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.melody_ui_ai_translation_guide_item, parent, false);
            h.b(viewInflate);
            return new C0236a(viewInflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyViewPagerGuidePreference(Context context) {
        super(context);
        h.e(context, "context");
        this.f21977p = new ArrayList();
        this.f21974a = context;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(R.id.container_indicator);
        h.c(viewA, "null cannot be cast to non-null type com.coui.appcompat.indicator.COUIPageIndicator");
        this.f21976c = (COUIPageIndicator) viewA;
        View viewA2 = holder.a(R.id.ai_translation_container_vp2);
        h.c(viewA2, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        this.f21975b = (ViewPager2) viewA2;
        COUIPageIndicator cOUIPageIndicator = this.f21976c;
        if (cOUIPageIndicator != null) {
            cOUIPageIndicator.setCurrentPosition(0);
        }
        COUIPageIndicator cOUIPageIndicator2 = this.f21976c;
        ArrayList arrayList = this.f21977p;
        if (cOUIPageIndicator2 != null) {
            cOUIPageIndicator2.setDotsCount(arrayList.size());
        }
        Context context = this.f21974a;
        if (context == null) {
            h.i("mContext");
            throw null;
        }
        a aVar = new a(context, arrayList);
        this.f21978q = aVar;
        ViewPager2 viewPager2 = this.f21975b;
        if (viewPager2 != null) {
            viewPager2.setAdapter(aVar);
            viewPager2.a(new b());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyViewPagerGuidePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f21977p = new ArrayList();
        this.f21974a = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyViewPagerGuidePreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        this.f21977p = new ArrayList();
    }

    /* JADX INFO: compiled from: MelodyViewPagerGuidePreference.kt */
    public static final class b extends ViewPager2.e {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void b(float f9, int i10, int i11) {
            COUIPageIndicator cOUIPageIndicator = MelodyViewPagerGuidePreference.this.f21976c;
            if (cOUIPageIndicator != null) {
                cOUIPageIndicator.a(f9, i10);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void c(int i10) {
            COUIPageIndicator cOUIPageIndicator = MelodyViewPagerGuidePreference.this.f21976c;
            if (cOUIPageIndicator != null) {
                cOUIPageIndicator.f14199b.f14241x = i10;
            }
            A.c("MelodyViewPagerGuidePreference", new L(i10, 5));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public final void a(int i10) {
        }
    }
}
