package com.oplus.melody.ui.component.detail.dress.custom;

import Ca.q;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import c9.m;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0911q;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import com.oplus.melody.ui.component.detail.dress.custom.a;
import ec.l;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.h;
import u8.C1555c;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: compiled from: TemplateCreateVideo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends m {
    @Override // c9.m
    public final boolean a() {
        C1558f mDiscoveryStates;
        C1557e connectedState;
        C1555c c1555c = this.f13523f;
        File file = this.h;
        MelodyResourceDO bgVideoRes = (c1555c == null || (mDiscoveryStates = c1555c.getMDiscoveryStates()) == null || (connectedState = mDiscoveryStates.getConnectedState()) == null) ? null : connectedState.getBgVideoRes();
        File file2 = this.f13524g;
        if (c1555c == null || file == null || bgVideoRes == null || file2 == null) {
            A.h("TemplateCreateVideo", "createBackground error config:" + (c1555c == null) + " dressDir:" + (file == null) + " bgVideoRes:" + (bgVideoRes == null) + " bgFile:" + (file2 == null));
            return false;
        }
        Object obj = a.f20940a;
        String strB = a.C0234a.b(this.f13520c);
        String path = bgVideoRes.getPath();
        h.d(path, "getPath(...)");
        if (!l.C(path, strB)) {
            bgVideoRes.setPath(bgVideoRes.getPath() + strB);
        }
        String path2 = bgVideoRes.getPath();
        h.d(path2, "getPath(...)");
        File file3 = new File(file, path2);
        if (file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
            A.c("TemplateCreateVideo", new q(file3, 2));
        } else if (!C0911q.b(file2, file3)) {
            A.h("TemplateCreateVideo", "copy mBgVideoRes error return");
            return false;
        }
        LinkedHashSet linkedHashSet = this.f13535s;
        String absolutePath = file3.getAbsolutePath();
        h.d(absolutePath, "getAbsolutePath(...)");
        linkedHashSet.add(absolutePath);
        if (!this.f13533q) {
            String absolutePath2 = file3.getAbsolutePath();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(absolutePath2);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(100L, 3);
            try {
                mediaMetadataRetriever.release();
            } catch (IOException e10) {
                A.i("MelodyThumbnailUtils", "createVideoThumbnail release", e10);
            }
            String path3 = c1555c.getMIcon();
            h.e(path3, "path");
            File file4 = new File(file, path3);
            if (frameAtTime == null || !C0911q.t(file4, frameAtTime)) {
                A.h("TemplateCreateVideo", "write icon fail iconData==null:" + (frameAtTime == null));
                return false;
            }
            String absolutePath3 = file4.getAbsolutePath();
            h.d(absolutePath3, "getAbsolutePath(...)");
            linkedHashSet.add(absolutePath3);
        }
        return true;
    }
}
