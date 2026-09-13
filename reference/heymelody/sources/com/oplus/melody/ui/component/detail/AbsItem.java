package com.oplus.melody.ui.component.detail;

import C9.a;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.InterfaceC0601m;
import com.oplus.melody.common.util.A;
import com.oplus.melody.ui.widget.MelodyJumpPreference;
import com.oplus.melody.ui.widget.MelodySwitchPreference;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsItem {
    public static final String DIALOG_FRAGMENT_TAG = "dialog_fragment_tag";
    private static final String TAG = "AbsItem";
    public Context mContext;
    public InterfaceC0601m mLifecycleOwner;
    public DetailMainViewModel mViewModel;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class BackgroundType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BackgroundType[] f20592a = {new BackgroundType("BACKGROUND_WITH_ALL_RADIUS", 0), new BackgroundType("BACKGROUND_WITH_DOWN_RADIUS", 1), new BackgroundType("BACKGROUND_WITH_NO_RADIUS", 2), new BackgroundType("BACKGROUND_WITH_UP_RADIUS", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        BackgroundType EF5;

        public BackgroundType() {
            throw null;
        }

        public static BackgroundType valueOf(String str) {
            return (BackgroundType) Enum.valueOf(BackgroundType.class, str);
        }

        public static BackgroundType[] values() {
            return (BackgroundType[]) f20592a.clone();
        }
    }

    public abstract View getItemView();

    public void onConnectionChange(Integer num) {
        if (getItemView() == null) {
            A.h(TAG, "item view is null");
            return;
        }
        View itemView = getItemView();
        if (itemView instanceof MelodyJumpPreference) {
            ((MelodyJumpPreference) itemView).setDisabled(num.intValue() != 2);
        } else if (itemView instanceof MelodySwitchPreference) {
            ((MelodySwitchPreference) itemView).setDisabled(num.intValue() != 2);
        }
    }

    public void registerConnectStatusChange() {
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        if (detailMainViewModel == null) {
            A.h(TAG, "model is null, set failed");
        } else {
            detailMainViewModel.d(detailMainViewModel.f20397b).e(this.mLifecycleOwner, new a(this, 8));
        }
    }

    public void onDestroy() {
    }

    public void setBackgroundType(BackgroundType backgroundType) {
    }
}
