package com.oplus.melody.ui.widget.sound;

import Ha.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MelodySoundPlayingConstraintLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/widget/sound/MelodySoundPlayingConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDispatchTouchEventListener", "Lcom/oplus/melody/ui/widget/sound/DispatchTouchEventListener;", "getMDispatchTouchEventListener", "()Lcom/oplus/melody/ui/widget/sound/DispatchTouchEventListener;", "setMDispatchTouchEventListener", "(Lcom/oplus/melody/ui/widget/sound/DispatchTouchEventListener;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MelodySoundPlayingConstraintLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22113a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MelodySoundPlayingConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.e(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        a aVar = this.f22113a;
        if (aVar != null ? aVar.dispatchTouchEvent(ev) : false) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

    /* JADX INFO: renamed from: getMDispatchTouchEventListener, reason: from getter */
    public final a getF22113a() {
        return this.f22113a;
    }

    public final void setMDispatchTouchEventListener(a aVar) {
        this.f22113a = aVar;
    }
}
