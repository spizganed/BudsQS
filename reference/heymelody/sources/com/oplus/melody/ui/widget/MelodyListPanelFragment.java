package com.oplus.melody.ui.widget;

import C7.c;
import D7.C0370d;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import i9.b;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class MelodyListPanelFragment extends COUIPanelFragment {
    private b mAdapter;
    private String mChooseEventKey;
    private String mCurrentChooseValue;
    private CharSequence[] mEntries;
    private CharSequence[] mEntryIntroSummaries;
    private CharSequence[] mEntryIntros;
    private int[] mEntryLabelIcons;
    private int[] mEntryLogos;
    private Uri[] mEntryResources;
    private CharSequence[] mEntrySummaries;
    private CharSequence[] mEntryValues;
    private View mIntroLayout;
    private TextView mIntroSummary;
    private TextView mIntroView;
    private ImageView mLogoView;
    private ImageView mPicView;
    private ListView mSelectView;
    private int[] mShowEntryDividers;
    private boolean mSoundEffectsEnabled = true;
    private int[] mTags;
    private CharSequence mTitle;
    private TextView mTitleView;
    private int[] mValues;

    public static final class a extends c<String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f21872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f21873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final WeakReference<MelodyListPanelFragment> f21874d;

        public a(boolean z2, String str, String str2, MelodyListPanelFragment melodyListPanelFragment) {
            super(str);
            this.f21873c = z2;
            this.f21872b = str2;
            this.f21874d = new WeakReference<>(melodyListPanelFragment);
        }
    }

    public final void A(int[] iArr) {
        this.mEntryLabelIcons = iArr;
    }

    public final void B(int[] iArr) {
        this.mEntryLogos = iArr;
    }

    public final void C(Uri[] uriArr) {
        this.mEntryResources = uriArr;
        r(this.mCurrentChooseValue);
    }

    public final void D(String[] strArr) {
        this.mEntrySummaries = strArr;
    }

    public final void E(CharSequence[] charSequenceArr) {
        this.mEntryValues = charSequenceArr;
    }

    public final void F(int[] iArr) {
        this.mShowEntryDividers = iArr;
    }

    public final void G() {
        this.mSoundEffectsEnabled = false;
        b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.f24105u = false;
        }
    }

    public final void H(int[] iArr) {
        this.mTags = iArr;
    }

    public final void I(String str) {
        this.mTitle = str;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public final void initView(View view) {
        A.b("EqualizerPanelFragment", "initView:");
        super.initView(view);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.melody_ui_select_dialog_content_view, (ViewGroup) null, false);
        ((ViewGroup) getContentView()).addView(viewInflate);
        getDragView().setVisibility(4);
        if (viewInflate == null) {
            return;
        }
        this.mTitleView = (TextView) viewInflate.findViewById(R.id.tvTitle);
        ListView listView = (ListView) viewInflate.findViewById(R.id.choose_list);
        this.mSelectView = listView;
        listView.setNestedScrollingEnabled(true);
        this.mPicView = (ImageView) viewInflate.findViewById(R.id.ivPic);
        this.mLogoView = (ImageView) viewInflate.findViewById(R.id.ivLogo);
        this.mIntroView = (TextView) viewInflate.findViewById(R.id.tvIntro);
        this.mIntroSummary = (TextView) viewInflate.findViewById(R.id.tvIntroSummary);
        this.mIntroLayout = viewInflate.findViewById(R.id.introLayout);
    }

    public final void o(String str) {
        if (this.mEntryIntros != null) {
            int iS = s(str);
            if (iS < 0) {
                this.mIntroView.setVisibility(8);
            } else {
                this.mIntroView.setVisibility(0);
                this.mIntroView.setText(this.mEntryIntros[iS]);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            A.b("EqualizerPanelFragment", "savedInstanceState is null");
            return;
        }
        this.mTitle = bundle.getCharSequence("title");
        this.mEntries = bundle.getCharSequenceArray("entries");
        this.mEntryValues = bundle.getCharSequenceArray("entriesValue");
        this.mEntrySummaries = bundle.getCharSequenceArray("entrySummaries");
        if (Build.VERSION.SDK_INT >= 33) {
            this.mEntryResources = (Uri[]) bundle.getParcelableArray("entriesRes", Uri.class);
        }
        this.mEntryLogos = bundle.getIntArray("entriesLogo");
        this.mEntryIntros = bundle.getCharSequenceArray("entriesIntro");
        this.mEntryIntroSummaries = bundle.getCharSequenceArray("entriesIntroSummary");
        this.mCurrentChooseValue = bundle.getString("chooseValue");
        this.mChooseEventKey = bundle.getString("chooseEventKey");
        this.mShowEntryDividers = bundle.getIntArray("showEntryDividers");
        this.mEntryLabelIcons = bundle.getIntArray("entryLabelIcons");
        this.mValues = bundle.getIntArray("values");
        this.mTags = bundle.getIntArray("tags");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.f24102r = null;
            this.mAdapter = null;
        }
        this.mSelectView.setAdapter((ListAdapter) null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ListView listView = this.mSelectView;
        Context context = getContext();
        CharSequence[] charSequenceArr = this.mEntries;
        CharSequence[] charSequenceArr2 = this.mEntryValues;
        CharSequence[] charSequenceArr3 = this.mEntrySummaries;
        String str = this.mCurrentChooseValue;
        int[] iArr = this.mShowEntryDividers;
        int[] iArr2 = this.mEntryLabelIcons;
        b bVar = new b(context, charSequenceArr, charSequenceArr2, charSequenceArr3);
        bVar.f24105u = true;
        bVar.f24108x = 0;
        bVar.f24109y = null;
        bVar.f24110z = null;
        bVar.f24104t = str;
        bVar.f24106v = iArr;
        bVar.f24107w = iArr2;
        bVar.f24108x = context.getResources().getDimensionPixelOffset(R.dimen.melody_ui_custom_eq_preference_tag_margin_start);
        this.mAdapter = bVar;
        bVar.f24102r = this;
        bVar.f24105u = this.mSoundEffectsEnabled;
        bVar.f24109y = this.mValues;
        bVar.f24110z = this.mTags;
        listView.setAdapter((ListAdapter) bVar);
        this.mTitleView.setText(this.mTitle);
        r(this.mCurrentChooseValue);
        q(this.mCurrentChooseValue);
        o(this.mCurrentChooseValue);
        p(this.mCurrentChooseValue);
        b bVar2 = this.mAdapter;
        if (bVar2 != null) {
            bVar2.f24104t = this.mCurrentChooseValue;
            bVar2.notifyDataSetChanged();
        }
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("title", this.mTitle);
        bundle.putCharSequenceArray("entries", this.mEntries);
        bundle.putCharSequenceArray("entriesValue", this.mEntryValues);
        bundle.putCharSequenceArray("entrySummaries", this.mEntrySummaries);
        bundle.putParcelableArray("entriesRes", this.mEntryResources);
        bundle.putIntArray("entriesLogo", this.mEntryLogos);
        bundle.putCharSequenceArray("entriesIntro", this.mEntryIntros);
        bundle.putCharSequenceArray("entriesIntroSummary", this.mEntryIntroSummaries);
        bundle.putString("chooseValue", this.mCurrentChooseValue);
        bundle.putString("chooseEventKey", this.mChooseEventKey);
        bundle.putIntArray("showEntryDividers", this.mShowEntryDividers);
        bundle.putIntArray("entryLabelIcons", this.mEntryLabelIcons);
        bundle.putIntArray("values", this.mValues);
        bundle.putIntArray("tags", this.mTags);
    }

    public final void p(String str) {
        if (this.mEntryIntroSummaries != null) {
            int iS = s(str);
            if (iS < 0) {
                this.mIntroSummary.setVisibility(8);
            } else {
                this.mIntroSummary.setVisibility(0);
                this.mIntroSummary.setText(this.mEntryIntroSummaries[iS]);
            }
        }
    }

    public final void q(String str) {
        if (this.mEntryLogos != null) {
            int iS = s(str);
            if (iS < 0) {
                this.mLogoView.setVisibility(8);
            } else {
                this.mLogoView.setVisibility(0);
                this.mLogoView.setImageResource(this.mEntryLogos[iS]);
            }
        }
    }

    public final void r(String str) {
        int iS;
        if (this.mEntryResources == null || (iS = s(str)) < 0) {
            return;
        }
        Uri[] uriArr = this.mEntryResources;
        if (iS < uriArr.length) {
            if (uriArr[iS] == null) {
                this.mIntroLayout.setVisibility(8);
                this.mPicView.setVisibility(8);
            } else {
                this.mIntroLayout.setVisibility(0);
                this.mPicView.setVisibility(0);
                this.mPicView.setImageURI(this.mEntryResources[iS]);
            }
        }
    }

    public final int s(String str) {
        if (this.mEntries == null) {
            return -1;
        }
        int i10 = 0;
        while (true) {
            CharSequence[] charSequenceArr = this.mEntries;
            if (i10 >= charSequenceArr.length) {
                return -1;
            }
            if (TextUtils.equals(str, charSequenceArr[i10])) {
                return i10;
            }
            i10++;
        }
    }

    public final void t() {
        b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.f24104t = this.mCurrentChooseValue;
            bVar.notifyDataSetChanged();
        }
    }

    public final boolean u(String str) {
        boolean z2 = !TextUtils.equals(str, this.mCurrentChooseValue);
        this.mCurrentChooseValue = str;
        b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.f24104t = str;
            bVar.notifyDataSetChanged();
        }
        r(str);
        q(str);
        o(str);
        p(str);
        C0370d.a(new a(z2, str, this.mChooseEventKey, this));
        return z2;
    }

    public final void v(String str) {
        this.mChooseEventKey = str;
    }

    public final void w(String str) {
        this.mCurrentChooseValue = str;
    }

    public final void x(CharSequence[] charSequenceArr) {
        this.mEntries = charSequenceArr;
    }

    public final void y(String[] strArr) {
        this.mEntryIntros = strArr;
    }

    public final void z(String[] strArr) {
        this.mEntryIntroSummaries = strArr;
    }
}
