package com.oplus.melody.ui.component.detail.meetingassist;

import B9.b;
import D7.o0;
import F8.d;
import Z7.a;
import android.os.Bundle;
import android.view.MenuItem;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: MeetingAssistActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/ui/component/detail/meetingassist/MeetingAssistActivity;", "Lcom/oplus/melody/ui/base/BaseLoadingActivity;", "<init>", "()V", "future", "Ljava/util/concurrent/CompletableFuture;", "Lcom/oplus/melody/model/zipdata/MicToneZipConfig;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onRetryClick", "openFragment", "fetchResource", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MeetingAssistActivity extends d {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f21131a0 = 0;

    @Override // F8.d
    public final void J() {
        a.g().d(0, 12, "000000").whenCompleteAsync((BiConsumer) new b(new B9.a(this, 0), 0), (Executor) o0.c.f1144b);
    }

    @Override // F8.d, F8.a, androidx.fragment.app.f, c.i, B.ActivityC0360h, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a.g().d(0, 12, "000000").whenCompleteAsync((BiConsumer) new b(new B9.a(this, 0), 0), (Executor) o0.c.f1144b);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem item) {
        h.e(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        getOnBackPressedDispatcher().c();
        return true;
    }
}
