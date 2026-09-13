package com.heytap.headset.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.ServiceUtils;
import kotlin.Metadata;
import t8.q;

/* JADX INFO: compiled from: KeepAliveJobService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lcom/heytap/headset/service/KeepAliveJobService;", "Landroid/app/job/JobService;", "<init>", "()V", "onStartJob", "", "jp", "Landroid/app/job/JobParameters;", "onStopJob", "startKeepAliveService", "", "Companion", "HeyMelody_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class KeepAliveJobService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17599a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jp) {
        A.b("KeepAliveJobService", "onStartJob");
        A.b("KeepAliveJobService", "startKeepAliveService, startFgService");
        ServiceUtils.startService(this, new Intent(this, (Class<?>) KeepAliveBgService.class));
        try {
            if (!q.l()) {
                return false;
            }
            b.a(this);
            return false;
        } catch (IllegalStateException e10) {
            A.i("KeepAliveJobService", "startKeepAliveService startFgService", e10);
            return false;
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jp) {
        A.b("KeepAliveJobService", "onStopJob");
        return true;
    }
}
