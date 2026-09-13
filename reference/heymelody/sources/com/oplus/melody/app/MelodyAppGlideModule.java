package com.oplus.melody.app;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.oplus.melody.common.util.A;

/* JADX INFO: loaded from: classes.dex */
@GlideModule
public class MelodyAppGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule, com.bumptech.glide.module.AppliesOptions
    public final void applyOptions(Context context, GlideBuilder glideBuilder) {
        glideBuilder.setLogLevel(A.k() ? 3 : 5);
        glideBuilder.setImageDecoderEnabledForBitmaps(true);
    }

    @Override // com.bumptech.glide.module.AppGlideModule
    public final boolean isManifestParsingEnabled() {
        return false;
    }
}
