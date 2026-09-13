package com.oplus.melody.ui.widget;

import E8.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.preference.m;
import com.heytap.headset.R;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodyTagJumpPreference.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001&B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\b\u0010 \u001a\u0004\u0018\u00010\u000fJ\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/oplus/melody/ui/widget/MelodyTagJumpPreference;", "Lcom/oplus/melody/ui/widget/MelodyUiCOUIJumpPreference;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTagText", "", "mTagVisible", "", "mOriginalTitle", "", "initAttrs", "", "onBindViewHolder", "holder", "Landroidx/preference/PreferenceViewHolder;", "updateTitleWithTag", "titleView", "Landroid/widget/TextView;", "createTagDrawable", "Lcom/oplus/melody/ui/widget/MelodyTagJumpPreference$TextDrawable;", "text", "setTagText", "getTagText", "setTagVisible", "visible", "isTagVisible", "setTitle", "title", "TextDrawable", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodyTagJumpPreference extends MelodyUiCOUIJumpPreference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f21926c;

    /* JADX INFO: compiled from: MelodyTagJumpPreference.kt */
    public static final class a extends GradientDrawable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f21928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f21929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f21930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f21931e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f21932f;

        public a(Context context, String text, int i10) {
            h.e(text, "text");
            this.f21927a = text;
            Paint paint = new Paint(1);
            paint.setColor(context.getColor(R.color.coui_color_white));
            paint.setTextSize(TypedValue.applyDimension(2, 10.0f, context.getResources().getDisplayMetrics()));
            paint.setTextAlign(Paint.Align.CENTER);
            this.f21928b = paint;
            this.f21929c = TypedValue.applyDimension(1, 6.0f, context.getResources().getDisplayMetrics());
            this.f21930d = TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics());
            float fApplyDimension = TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics());
            this.f21931e = paint.measureText(text);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            this.f21932f = fontMetrics.descent - fontMetrics.ascent;
            setShape(0);
            setCornerRadius(fApplyDimension);
            setColor(i10);
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            h.e(canvas, "canvas");
            super.draw(canvas);
            float fExactCenterX = getBounds().exactCenterX();
            float fExactCenterY = getBounds().exactCenterY();
            Paint paint = this.f21928b;
            canvas.drawText(this.f21927a, fExactCenterX, fExactCenterY - ((paint.getFontMetrics().ascent + paint.getFontMetrics().descent) / 2), paint);
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public final int getIntrinsicHeight() {
            return (int) ((this.f21930d * 2) + this.f21932f);
        }

        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public final int getIntrinsicWidth() {
            return (int) ((this.f21929c * 2) + this.f21931e);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTagJumpPreference(Context context) {
        super(context);
        h.e(context, "context");
        this.f21925b = true;
    }

    public final void f(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.f1368f);
            h.d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.f21924a = typedArrayObtainStyledAttributes.getString(0);
            this.f21925b = typedArrayObtainStyledAttributes.getBoolean(1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // com.oplus.melody.ui.widget.MelodyUiCOUIJumpPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public final void onBindViewHolder(m holder) {
        String str;
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        View viewA = holder.a(android.R.id.title);
        TextView textView = viewA instanceof TextView ? (TextView) viewA : null;
        if (textView == null) {
            return;
        }
        if (this.f21926c == null) {
            this.f21926c = getTitle();
        }
        CharSequence title = this.f21926c;
        if (title == null && (title = getTitle()) == null) {
            title = "";
        }
        if (!this.f21925b || (str = this.f21924a) == null || str.length() == 0) {
            textView.setText(title);
            return;
        }
        Context context = textView.getContext();
        h.d(context, "getContext(...)");
        String str2 = this.f21924a;
        h.b(str2);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.couiColorPrimary, typedValue, true);
        a aVar = new a(context, str2, typedValue.data);
        aVar.setBounds(0, 0, aVar.getIntrinsicWidth(), aVar.getIntrinsicHeight());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(title);
        spannableStringBuilder.append((CharSequence) "  ");
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.setSpan(new ImageSpan(aVar, 2), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        textView.setText(spannableStringBuilder);
    }

    @Override // androidx.preference.Preference
    public final void setTitle(CharSequence title) {
        this.f21926c = title;
        super.setTitle(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTagJumpPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
        this.f21925b = true;
        f(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTagJumpPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        h.e(context, "context");
        this.f21925b = true;
        f(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodyTagJumpPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        h.e(context, "context");
        this.f21925b = true;
        f(attributeSet);
    }
}
