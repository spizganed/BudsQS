package com.heytap.headset.component.about;

import P3.g;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: AboutPreference.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\u000fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/heytap/headset/component/about/AboutPreference;", "Lcom/coui/appcompat/preference/COUIPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "clickListener", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "setClickListener", "(Landroid/view/View$OnClickListener;)V", "summaryMaxLines", "getSummaryMaxLines", "()I", "setSummaryMaxLines", "(I)V", "clearBg", "", "getClearBg", "()Z", "setClearBg", "(Z)V", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "setOnClickListener", "onClickListener", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AboutPreference extends COUIPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17359b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AboutPreference(Context context) {
        this(context, null);
        h.e(context, "context");
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        if (this.f17359b) {
            holder.itemView.setBackground(null);
        }
        holder.itemView.setOnClickListener(new g(0, this, holder));
        TextView textView = (TextView) holder.a(R.id.summary);
        if (textView != null) {
            textView.setMaxLines(this.f17358a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AboutPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        h.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AboutPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        h.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        this.f17358a = 99;
    }
}
