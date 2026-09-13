package com.oplus.melody.ui.component.detail.freedialog;

import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import java.util.function.Consumer;

/* JADX INFO: compiled from: FreeDialogPanelFragment.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Consumer<SetCommandStateDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FreeDialogPanelFragment f21019a;

    public d(FreeDialogPanelFragment freeDialogPanelFragment) {
        this.f21019a = freeDialogPanelFragment;
    }

    @Override // java.util.function.Consumer
    public final void accept(SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO.getSetCommandStatus() == 0) {
            A.b("FreeDialogPanelFragment", "set setRecoveryTimeCommand succeed");
            return;
        }
        FreeDialogPanelFragment freeDialogPanelFragment = this.f21019a;
        if (freeDialogPanelFragment.mItemSelectListener != null) {
            freeDialogPanelFragment.mItemSelectListener.b();
        }
        A.x("FreeDialogPanelFragment", "set setRecoveryTimeCommand failed");
    }
}
