package com.oplus.melody.ui.component.detail.freedialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.f;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.heytap.headset.R;
import com.oplus.melody.common.util.A;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.freedialog.FreeDialogItem;
import com.oplus.melody.ui.component.detail.freedialog.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes3.dex */
public class FreeDialogPanelFragment extends COUIPanelFragment {
    private c mAdapter;
    private List<c.a> mContentItems = new ArrayList();
    private int mCurrentProtocol;
    private a mItemSelectListener;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture;
    private RecyclerView mSmartCallItemsView;
    private DetailMainViewModel mViewModel;

    public interface a {
        void a(c.a aVar);

        void b();
    }

    public static /* synthetic */ void o(FreeDialogPanelFragment freeDialogPanelFragment, Throwable th) {
        if (freeDialogPanelFragment.mItemSelectListener == null && (freeDialogPanelFragment.getParentFragment() instanceof COUIBottomSheetDialogFragment)) {
            ((COUIBottomSheetDialogFragment) freeDialogPanelFragment.getParentFragment()).dismiss();
        }
        if (th != null) {
            a aVar = freeDialogPanelFragment.mItemSelectListener;
            if (aVar != null) {
                aVar.b();
            }
            A.i("FreeDialogPanelFragment", "set setRecoveryTimeCommand", th);
        }
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public final void initView(View view) {
        super.initView(view);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.melody_ui_smart_call_view, (ViewGroup) null, false);
        ((ViewGroup) getContentView()).addView(viewInflate);
        getDragView().setVisibility(4);
        r(requireContext());
        this.mSmartCallItemsView = (RecyclerView) viewInflate.findViewById(R.id.smart_call_panel);
        getActivity();
        c cVar = new c(this.mContentItems);
        this.mAdapter = cVar;
        cVar.f21015b = this;
        cVar.f21016c = this.mCurrentProtocol;
        this.mSmartCallItemsView.setAdapter(cVar);
        RecyclerView recyclerView = this.mSmartCallItemsView;
        getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mCurrentProtocol = bundle.getInt("current_protocol");
        }
        f owner = requireActivity();
        h.e(owner, "owner");
        O viewModelStore = owner.getViewModelStore();
        N.b defaultViewModelProviderFactory = owner.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, owner.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(DetailMainViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.mViewModel = (DetailMainViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("current_protocol", this.mCurrentProtocol);
    }

    public final String q() {
        List<c.a> list = this.mContentItems;
        if (list != null && !list.isEmpty()) {
            for (c.a aVar : this.mContentItems) {
                if (aVar.f21017a == this.mCurrentProtocol) {
                    return aVar.f21018b;
                }
            }
        }
        return "";
    }

    public final void r(Context context) {
        this.mContentItems.clear();
        int[] iArr = {5, 10, 15, 0};
        String[] stringArray = context.getResources().getStringArray(R.array.melody_common_smart_call_tips);
        if (stringArray.length != 4) {
            A.h("FreeDialogPanelFragment", "key value is not equal");
            return;
        }
        for (int i10 = 0; i10 < stringArray.length; i10++) {
            int i11 = iArr[i10];
            String str = stringArray[i10];
            c.a aVar = new c.a();
            aVar.f21017a = i11;
            aVar.f21018b = str;
            this.mContentItems.add(aVar);
        }
    }

    public final void s(c.a aVar) {
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        CompletableFuture<SetCommandStateDTO> completableFutureN0 = AbstractC0939b.E().n0(this.mViewModel.f20397b, (byte) aVar.f21017a);
        this.mSetCommandFuture = completableFutureN0;
        completableFutureN0.thenAccept((Consumer<? super SetCommandStateDTO>) new d(this)).whenComplete((BiConsumer<? super Void, ? super Throwable>) new A9.c(this, 20));
        int i10 = aVar.f21017a;
        this.mCurrentProtocol = i10;
        this.mAdapter.f21016c = i10;
        a aVar2 = this.mItemSelectListener;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }

    public final void t(int i10) {
        this.mCurrentProtocol = i10;
        c cVar = this.mAdapter;
        if (cVar != null) {
            cVar.f21016c = i10;
        }
    }

    public final void u(FreeDialogItem.a aVar) {
        this.mItemSelectListener = aVar;
    }

    public final void v(DetailMainViewModel detailMainViewModel) {
        this.mViewModel = detailMainViewModel;
    }
}
