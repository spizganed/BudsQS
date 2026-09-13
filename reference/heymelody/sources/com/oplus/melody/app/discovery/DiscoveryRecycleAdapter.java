package com.oplus.melody.app.discovery;

import D7.o0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.headset.R;
import com.oplus.melody.model.zipdata.MelodyResourceDO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import u8.C1557e;
import u8.C1558f;

/* JADX INFO: loaded from: classes.dex */
final class DiscoveryRecycleAdapter extends RecyclerView.Adapter<H0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiscoveryDialogViewModel f18898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutInflater f18899c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f18897a = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<DiscoveryRecycleItemVO> f18900d = Collections.EMPTY_LIST;

    public DiscoveryRecycleAdapter(Context context, DiscoveryDialogViewModel discoveryDialogViewModel) {
        this.f18899c = LayoutInflater.from(context);
        this.f18898b = discoveryDialogViewModel;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f18900d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i10) {
        long j5;
        String macAddress = this.f18900d.get(i10).getMacAddress();
        synchronized (this.f18897a) {
            try {
                int iIndexOf = this.f18897a.indexOf(macAddress);
                if (iIndexOf < 0 && this.f18897a.add(macAddress)) {
                    iIndexOf = this.f18897a.indexOf(macAddress);
                }
                j5 = iIndexOf;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.E e10, int i10) {
        final H0 h02 = (H0) e10;
        com.oplus.melody.common.util.A.c("DiscoveryRecycleAdapter", new Ea.M(i10, h02, 8));
        final DiscoveryRecycleItemVO discoveryRecycleItemVO = this.f18900d.get(i10);
        h02.getClass();
        String productId = discoveryRecycleItemVO.getProductId();
        this.f18898b.i(discoveryRecycleItemVO.getColorId(), productId, discoveryRecycleItemVO.getMacAddress()).thenAcceptAsync(new Consumer() { // from class: com.oplus.melody.app.discovery.G0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C1557e readyState;
                MelodyResourceDO imageRes;
                C1 c12 = (C1) obj;
                DiscoveryRecycleItemVO discoveryRecycleItemVO2 = discoveryRecycleItemVO;
                H0 h03 = h02;
                if (c12 != null) {
                    h03.getClass();
                    C1558f discoveryStates = c12.getDiscoveryStates();
                    if (discoveryStates != null && (readyState = discoveryStates.getReadyState()) != null && (imageRes = readyState.getImageRes()) != null) {
                        h03.a(imageRes, c12, discoveryRecycleItemVO2);
                        return;
                    }
                }
                h03.a(null, c12, discoveryRecycleItemVO2);
            }
        }, (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new C0867l0(2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.E onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new H0(this.f18899c.inflate(R.layout.melody_app_recycle_item_discovery, viewGroup, false));
    }
}
