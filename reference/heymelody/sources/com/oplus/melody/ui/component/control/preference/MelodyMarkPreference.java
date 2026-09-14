package com.oplus.melody.ui.component.control.preference;

import Ea.E;
import U8.d;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.preference.m;
import com.coui.appcompat.preference.COUIMarkPreference;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyMarkPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/ui/component/control/preference/MelodyMarkPreference;", "Lcom/coui/appcompat/preference/COUIMarkPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mInfoButton", "Landroid/widget/ImageView;", "mInfoButtonVisibility", "", "mInfoButtonClickListener", "Landroid/view/View$OnClickListener;", "initView", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "setInfoButtonVisibility", "visibility", "setInfoButtonClickListener", "listener", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyMarkPreference extends COUIMarkPreference {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public d f20577A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f20578y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f20579z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyMarkPreference(Context context) {
        super(context);
        h.e(context, "context");
        this.f20579z = 8;
        setLayoutResource(R.layout.melody_ui_preference_mark);
    }

    @Override // com.coui.appcompat.preference.COUIMarkPreference, androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        ImageView imageView = (ImageView) holder.a(R.id.info_icon);
        this.f20578y = imageView;
        if (imageView != null) {
            imageView.setVisibility(this.f20579z);
        }
        ImageView imageView2 = this.f20578y;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new E(this, 3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyMarkPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f20579z = 8;
        setLayoutResource(R.layout.melody_ui_preference_mark);
    }
}
