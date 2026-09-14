package com.oplus.melody.ui.component.detail.multiconnection;

import A6.e;
import D7.C0373g;
import D7.C0379m;
import D7.C0381o;
import D7.C0386u;
import D7.C0388w;
import D7.L;
import D7.o0;
import E9.i;
import E9.j;
import E9.k;
import E9.m;
import E9.o;
import E9.p;
import E9.q;
import E9.r;
import E9.t;
import E9.v;
import F8.i;
import L8.g0;
import Wb.l;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.media3.session.D0;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.preference.COUIPreference;
import com.heytap.headset.R;
import com.oplus.melody.btsdk.api.data.HandheldDeviceInfo;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.widget.MelodyCOUIPreferenceCategory;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.leaudio.b;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.component.detail.multiconnection.MultiDevicesManagerItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import k8.AbstractC1239a;
import kc.C1264t;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import l9.C1286a;
import oa.d;
import t8.s;
import x3.C1656o;

/* JADX INFO: compiled from: MultiDevicesManagerItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020\u0016H\u0002J\u001e\u0010,\u001a\u00020%2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010.\u001a\u00020\u001cH\u0002J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0002J \u00102\u001a\u00020%2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u00104\u001a\u00020!H\u0002J$\u00105\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010\u001c2\u0006\u0010+\u001a\u00020\u0016H\u0002J\b\u0010;\u001a\u00020%H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u000207H\u0002J\b\u0010>\u001a\u00020%H\u0016J&\u0010B\u001a\u00020%\"\u0004\b\u0000\u0010C*\b\u0012\u0004\u0012\u0002HC0D2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HC0FH\u0002R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0018\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030A0@X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/oplus/melody/ui/component/detail/multiconnection/MultiDevicesManagerItem;", "Lcom/coui/appcompat/preference/COUIPreference;", "Lcom/oplus/melody/ui/component/detail/ItemLifecycle;", "Lcom/oplus/melody/common/helper/NoProguard;", "context", "Landroid/content/Context;", "viewModel", "Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/oplus/melody/ui/component/detail/DetailMainViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "mViewModel", "mLifecycleOwner", "mContext", "mDeviceRecyclerView", "Landroidx/recyclerview/widget/COUIRecyclerView;", "mManagerCard", "Landroid/view/ViewGroup;", "mDeviceListAdapter", "Lcom/oplus/melody/ui/component/detail/multiconnection/MultiDevicesManagerAdapter;", "mCurrentDeviceSize", "", "mConnectOperateConfirmDiaLog", "Landroidx/appcompat/app/AlertDialog;", "mConnectOperateTime", "", "mConnectOperateAddress", "", "mConnectionState", "mItemMinWidth", "mMultiConnectInfoList", "", "Lcom/oplus/melody/model/repository/multidevicesconnect/MultiConnectStateDTO$Element;", "mMultiConnectInfoCreateTime", "Ljava/lang/Long;", "onBindViewHolder", "", "holder", "Landroidx/preference/PreferenceViewHolder;", "onAttached", "onDetached", "onConnectStateChange", "connectState", "onMultiConnectInformationChanged", "multiConnectionStateInfos", "fromTag", "onLowPriorityHandheldChanged", "handheldDeviceInfo", "Lcom/oplus/melody/btsdk/api/data/HandheldDeviceInfo;", "handleDevicePreferenceClick", "multiConnectInfoList", "element", "showConnectOperateConfirmDialog", "isConnect", "", "willDisconnectHandheldName", "updateToConnectingView", "address", "goMultiDeviceConnectPage", "enableItem", "enable", "onDestroy", "mLiveDataRecordList", "", "Lcom/oplus/melody/common/helper/LiveDataRecord;", "recordObserve", "T", "Landroidx/lifecycle/LiveData;", "observer", "Landroidx/lifecycle/Observer;", "Companion", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MultiDevicesManagerItem extends COUIPreference implements g0 {
    public static final String ITEM_NAME = "MultiDevicesManagerItem";
    private static final String TAG = "MultiDevicesManagerItem";
    private String mConnectOperateAddress;
    private f mConnectOperateConfirmDiaLog;
    private long mConnectOperateTime;
    private int mConnectionState;
    private Context mContext;
    private int mCurrentDeviceSize;
    private E9.f mDeviceListAdapter;
    private COUIRecyclerView mDeviceRecyclerView;
    private int mItemMinWidth;
    private InterfaceC0601m mLifecycleOwner;
    private List<C0381o<?>> mLiveDataRecordList;
    private ViewGroup mManagerCard;
    private Long mMultiConnectInfoCreateTime;
    private List<MultiConnectStateDTO.Element> mMultiConnectInfoList;
    private DetailMainViewModel mViewModel;

    /* JADX INFO: compiled from: MultiDevicesManagerItem.kt */
    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: compiled from: MultiDevicesManagerItem.kt */
    public static final class c extends RecyclerView.o {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public final void f(Rect outRect, View view, RecyclerView recyclerView, RecyclerView.A state) {
            COUIRecyclerView cOUIRecyclerView;
            h.e(outRect, "outRect");
            h.e(state, "state");
            super.f(outRect, view, recyclerView, state);
            MultiDevicesManagerItem multiDevicesManagerItem = MultiDevicesManagerItem.this;
            E9.f fVar = multiDevicesManagerItem.mDeviceListAdapter;
            Collection collection = fVar != null ? fVar.f12264a.f12028f : null;
            if (collection == null || collection.isEmpty() || (cOUIRecyclerView = multiDevicesManagerItem.mDeviceRecyclerView) == null) {
                return;
            }
            int width = cOUIRecyclerView.getWidth();
            float f9 = width;
            float f10 = f9 / multiDevicesManagerItem.mItemMinWidth;
            E9.f fVar2 = multiDevicesManagerItem.mDeviceListAdapter;
            h.b(fVar2);
            int size = fVar2.f12264a.f12028f.size();
            if (size < f10) {
                view.getLayoutParams().width = width / size;
                return;
            }
            int i10 = (int) f10;
            float f11 = ((int) (100.0f * f10)) % 100 <= ((int) (((float) 100) * 0.28f)) ? i10 - (1 - 0.28f) : i10 + 0.28f;
            A.c("MultiDevicesManagerItem", new v(f11, f10, 0));
            view.getLayoutParams().width = (int) (f9 / f11);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiDevicesManagerItem(Context context, DetailMainViewModel viewModel, InterfaceC0601m lifecycleOwner) {
        super(context);
        h.e(context, "context");
        h.e(viewModel, "viewModel");
        h.e(lifecycleOwner, "lifecycleOwner");
        this.mViewModel = viewModel;
        this.mLifecycleOwner = lifecycleOwner;
        this.mContext = context;
        setLayoutResource(R.layout.melody_ui_multi_devices_manager_item);
        setBackgroundAnimationEnabled(false);
        this.mItemMinWidth = context.getResources().getDimensionPixelOffset(R.dimen.melody_ui_multi_connect_manager_item_min_width);
        E9.f fVar = new E9.f(context);
        this.mDeviceListAdapter = fVar;
        fVar.f1386c = new a();
        this.mLiveDataRecordList = new ArrayList();
    }

    private final void enableItem(boolean enable) {
        o0.c.f1143a.post(new i(this, enable, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableItem$lambda$0(MultiDevicesManagerItem multiDevicesManagerItem, boolean z2) {
        A.c("MultiDevicesManagerItem", new r(0, z2));
        ViewGroup viewGroup = multiDevicesManagerItem.mManagerCard;
        if (viewGroup != null) {
            viewGroup.setEnabled(z2);
        }
        ViewGroup viewGroup2 = multiDevicesManagerItem.mManagerCard;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(z2 ? 1.0f : 0.3f);
        }
        COUIRecyclerView cOUIRecyclerView = multiDevicesManagerItem.mDeviceRecyclerView;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.setEnabled(z2);
        }
        COUIRecyclerView cOUIRecyclerView2 = multiDevicesManagerItem.mDeviceRecyclerView;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setAlpha(z2 ? 1.0f : 0.3f);
        }
        PreferenceGroup parent = multiDevicesManagerItem.getParent();
        MelodyCOUIPreferenceCategory melodyCOUIPreferenceCategory = parent instanceof MelodyCOUIPreferenceCategory ? (MelodyCOUIPreferenceCategory) parent : null;
        if (melodyCOUIPreferenceCategory != null) {
            melodyCOUIPreferenceCategory.m(z2 ? R.string.melody_ui_multiple_devices_more : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String enableItem$lambda$0$0(boolean z2) {
        return e.f("enableItem enable = ", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goMultiDeviceConnectPage() {
        A.b("MultiDevicesManagerItem", "goMultiDeviceConnectPage: click");
        if (s.a(0)) {
            return;
        }
        b.C0229b.f19632a.b(this.mContext, this.mViewModel.f20397b, LeFilterConstants.FunType.MULTI_CONNECT.getFunType(), new C0.a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void goMultiDeviceConnectPage$lambda$0(MultiDevicesManagerItem multiDevicesManagerItem) {
        E8.a.w().getClass();
        Jb.b<List<l<String, Class<?>>>> bVar = F8.i.f1668g;
        F8.i iVarA = i.a.a("/ui/multi_connect");
        iVarA.f("device_mac_info", multiDevicesManagerItem.mViewModel.f20397b);
        iVarA.f("product_id", multiDevicesManagerItem.mViewModel.f20400e);
        iVarA.f("device_name", multiDevicesManagerItem.mViewModel.f20398c);
        iVarA.b(multiDevicesManagerItem.mContext);
        DetailMainViewModel detailMainViewModel = multiDevicesManagerItem.mViewModel;
        String str = detailMainViewModel.f20400e;
        String str2 = detailMainViewModel.f20397b;
        C1264t.t(AppConstant$FunctionType.MULTI_MANAGER_CONNECT.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDevicePreferenceClick(List<MultiConnectStateDTO.Element> multiConnectInfoList, MultiConnectStateDTO.Element element) {
        MultiConnectStateDTO.Element element2;
        Collection collection;
        Object next;
        if (multiConnectInfoList == null || multiConnectInfoList.isEmpty()) {
            A.x("MultiDevicesManagerItem", "handleDevicePreferenceClick multiConnectInfoList is empty!");
            return;
        }
        d.d();
        if (!d.f26574a.isEmpty()) {
            A.x("MultiDevicesManagerItem", "handleDevicePreferenceClick mConnectingRunnableMap is not empty!");
            return;
        }
        int connectionState = element.getConnectionState();
        A.c("MultiDevicesManagerItem", new L(connectionState, 1));
        if (connectionState == 1) {
            A.x("MultiDevicesManagerItem", "handleDevicePreferenceClick handheld is in connecting state!");
            return;
        }
        String deviceName = null;
        if (connectionState == 2) {
            showConnectOperateConfirmDialog(element, false, null);
            return;
        }
        if (connectionState == 4) {
            A.x("MultiDevicesManagerItem", "handleDevicePreferenceClick handheld is in disconnecting state!");
            return;
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        EarphoneDTO earphoneDTOI = detailMainViewModel.i(detailMainViewModel.f20397b);
        if (earphoneDTOI == null) {
            A6.b.g("handleDevicePreferenceClick earphoneDTO is null! adr = ", A.r(this.mViewModel.f20397b), "MultiDevicesManagerItem");
            return;
        }
        if (d.b(multiConnectInfoList, earphoneDTOI.getMultiConnectSwitchStatus() == 1)) {
            A.c("MultiDevicesManagerItem", new j(element, 0));
            AbstractC1239a.a().e(this.mViewModel.f20397b, 1, element.getAddress(), false);
            updateToConnectingView(element.getAddress(), 1);
            d.a(element, new k(0, this, element));
            DetailMainViewModel detailMainViewModel2 = this.mViewModel;
            String str = detailMainViewModel2.f20400e;
            String str2 = detailMainViewModel2.f20397b;
            C1264t.t(AppConstant$FunctionType.MULTI_CONNECT_MANAGER_CONNECT_DEVICE.getFunType(), str, str2, N.t(detailMainViewModel2.i(str2)), "");
            return;
        }
        if (Math.abs(SystemClock.elapsedRealtime() - this.mConnectOperateTime) < 2500.0d) {
            A.x("MultiDevicesManagerItem", "handleDevicePreferenceClick is trying connect!");
            return;
        }
        if (earphoneDTOI.getMultiConnectSwitchStatus() == 1) {
            this.mConnectOperateTime = SystemClock.elapsedRealtime();
            this.mConnectOperateAddress = element.getAddress();
            AbstractC1239a.a().g(this.mViewModel.f20397b, false);
            return;
        }
        E9.f fVar = this.mDeviceListAdapter;
        if (fVar == null || (collection = fVar.f12264a.f12028f) == null) {
            element2 = null;
        } else {
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((MultiConnectStateDTO.Element) next).isCurrentDevice()) {
                        break;
                    }
                }
            }
            element2 = (MultiConnectStateDTO.Element) next;
        }
        if (TextUtils.isEmpty(element2 != null ? element2.getDeviceName() : null)) {
            if (element2 != null) {
                deviceName = element2.getAddress();
            }
        } else if (element2 != null) {
            deviceName = element2.getDeviceName();
        }
        if (TextUtils.isEmpty(deviceName)) {
            A.x("MultiDevicesManagerItem", "handleDevicePreferenceClick disconnectHandheldName is empty!");
        } else {
            h.b(deviceName);
            showConnectOperateConfirmDialog(element, true, deviceName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleDevicePreferenceClick$lambda$0(int i10) {
        return A6.b.d(i10, "handleDevicePreferenceClick handheldConnectionState = ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleDevicePreferenceClick$lambda$1(MultiConnectStateDTO.Element element) {
        return C1656o.a("handleDevicePreferenceClick connectToHandheldDevice direct :", A.r(element.getAddress()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDevicePreferenceClick$lambda$2(MultiDevicesManagerItem multiDevicesManagerItem, MultiConnectStateDTO.Element element) {
        multiDevicesManagerItem.updateToConnectingView(element.getAddress(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(MultiDevicesManagerItem multiDevicesManagerItem, MultiConnectStateDTO multiConnectStateDTO) {
        List<MultiConnectStateDTO.Element> elements;
        if (multiConnectStateDTO == null || (elements = multiConnectStateDTO.getElements()) == null) {
            return;
        }
        multiDevicesManagerItem.mMultiConnectInfoCreateTime = multiConnectStateDTO.getCreateTime();
        multiDevicesManagerItem.onMultiConnectInformationChanged(elements, "fromObserve");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(MultiDevicesManagerItem multiDevicesManagerItem, C1286a c1286a) {
        if (c1286a == null || c1286a.getDeviceVersionList() == null) {
            A.b("MultiDevicesManagerItem", "getVersionInfoList result null");
        } else {
            multiDevicesManagerItem.onConnectStateChange(c1286a.isConnected() ? 2 : 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(MultiDevicesManagerItem multiDevicesManagerItem, String address) {
        h.e(address, "address");
        A.f("MultiDevicesManagerItem", "getLeAudioSwitchStatusChanged, addr: " + address + ", vm.addr: " + multiDevicesManagerItem.mViewModel.f20397b);
        if (!TextUtils.equals(address, multiDevicesManagerItem.mViewModel.f20397b)) {
            A.x("MultiDevicesManagerItem", "getLeAudioSwitchStatusChanged addr not same");
            return;
        }
        int i10 = 1;
        CompletableFuture.supplyAsync(new C0386u(2, multiDevicesManagerItem, address)).whenComplete((BiConsumer) new B9.b(new B9.a(multiDevicesManagerItem, i10), i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EarphoneDTO onBindViewHolder$lambda$4$0(MultiDevicesManagerItem multiDevicesManagerItem, String str) {
        return multiDevicesManagerItem.mViewModel.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l onBindViewHolder$lambda$4$1(MultiDevicesManagerItem multiDevicesManagerItem, EarphoneDTO earphoneDTO, Throwable th) {
        if (earphoneDTO != null) {
            o0.c.f1144b.execute(new B6.b(3, multiDevicesManagerItem, earphoneDTO));
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4$1$0(MultiDevicesManagerItem multiDevicesManagerItem, EarphoneDTO earphoneDTO) {
        multiDevicesManagerItem.onConnectStateChange(earphoneDTO.getConnectionState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List onBindViewHolder$lambda$5(com.oplus.melody.ui.component.detail.multiconnection.MultiDevicesManagerItem r12) {
        /*
            k8.a r0 = k8.AbstractC1239a.a()
            com.oplus.melody.ui.component.detail.DetailMainViewModel r1 = r12.mViewModel
            java.lang.String r1 = r1.f20397b
            com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO r0 = r0.c(r1)
            if (r0 == 0) goto L1a
            java.util.List r1 = r0.getElements()
            if (r1 == 0) goto L1a
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L3d
        L1a:
            java.lang.String r1 = "MultiDevicesManagerItem"
            java.lang.String r2 = "onBindViewHolder multiConnectInfos is empty!"
            com.oplus.melody.common.util.A.b(r1, r2)
            android.content.SharedPreferences r1 = com.oplus.melody.common.helper.MelodyAlivePreferencesHelper.e()
            com.oplus.melody.ui.component.detail.DetailMainViewModel r12 = r12.mViewModel
            java.lang.String r12 = r12.f20397b
            r2 = 20
            java.lang.String r12 = com.oplus.melody.common.helper.MelodyAlivePreferencesHelper.g(r2, r12)
            java.lang.String r2 = ""
            java.lang.String r12 = r1.getString(r12, r2)
            if (r12 == 0) goto L3d
            java.lang.Class<com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO> r0 = com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO.class
            com.oplus.melody.common.data.a r0 = com.oplus.melody.common.util.C0917x.c(r0, r12)
        L3d:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO r0 = (com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO) r0
            if (r0 == 0) goto L6f
            java.util.List r0 = r0.getElements()
            if (r0 == 0) goto L6f
            java.util.Iterator r0 = r0.iterator()
        L50:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L6f
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO$Element r2 = (com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO.Element) r2
            r10 = 75
            r11 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO$Element r1 = com.oplus.melody.model.repository.multidevicesconnect.MultiConnectStateDTO.Element.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.add(r1)
            goto L50
        L6f:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.melody.ui.component.detail.multiconnection.MultiDevicesManagerItem.onBindViewHolder$lambda$5(com.oplus.melody.ui.component.detail.multiconnection.MultiDevicesManagerItem):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Jb.l onBindViewHolder$lambda$6(MultiDevicesManagerItem multiDevicesManagerItem, List list) {
        E9.f fVar = multiDevicesManagerItem.mDeviceListAdapter;
        Collection collection = fVar != null ? fVar.f12264a.f12028f : null;
        if ((collection == null || collection.isEmpty()) && list != null && !list.isEmpty()) {
            multiDevicesManagerItem.onMultiConnectInformationChanged(list, "fromOnBindViewHolder");
        }
        return Jb.l.f2618a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void onBindViewHolder$lambda$8(Throwable th) {
        A.i("MultiDevicesManagerItem", "onBindViewHolder getMultiConnectState", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConnectStateChange(int connectState) {
        this.mConnectionState = connectState;
        enableItem(connectState == 2);
        if (this.mConnectionState == 2) {
            d.f26574a.clear();
        }
        b.C0229b.f19632a.a(this.mViewModel.f20397b, LeFilterConstants.FunType.MULTI_CONNECT.getFunType(), new E9.h(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectStateChange$lambda$0(MultiDevicesManagerItem multiDevicesManagerItem, boolean z2) {
        if (z2) {
            multiDevicesManagerItem.enableItem(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLowPriorityHandheldChanged(HandheldDeviceInfo handheldDeviceInfo) {
        MultiConnectStateDTO.Element element;
        MultiConnectStateDTO.Element element2;
        Collection collection;
        Object next;
        Collection collection2;
        Object next2;
        if (handheldDeviceInfo == null) {
            A.x("MultiDevicesManagerItem", "onLowPriorityHandheldChanged handheldDeviceInfo is null!");
            return;
        }
        if (TextUtils.isEmpty(this.mConnectOperateAddress)) {
            A.x("MultiDevicesManagerItem", "onLowPriorityHandheldChanged mConnectOperateAddress is empty!");
            return;
        }
        long createTime = handheldDeviceInfo.getCreateTime() - this.mConnectOperateTime;
        A.c("MultiDevicesManagerItem", new E9.s(0, createTime));
        this.mConnectOperateTime = 0L;
        if (createTime <= 0 || createTime >= 2500) {
            return;
        }
        E9.f fVar = this.mDeviceListAdapter;
        if (fVar == null || (collection2 = fVar.f12264a.f12028f) == null) {
            element = null;
        } else {
            Iterator it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                } else {
                    next2 = it.next();
                    if (ec.l.D(((MultiConnectStateDTO.Element) next2).getAddress(), this.mConnectOperateAddress, true)) {
                        break;
                    }
                }
            }
            element = (MultiConnectStateDTO.Element) next2;
        }
        if (element == null) {
            A.x("MultiDevicesManagerItem", "onLowPriorityHandheldChanged connectElement is empty!");
            this.mConnectOperateAddress = null;
            return;
        }
        if (!handheldDeviceInfo.hasLowLevelDevice()) {
            A.x("MultiDevicesManagerItem", "onLowPriorityHandheldChanged hasLowLevelDevice is false!");
            this.mConnectOperateAddress = null;
            return;
        }
        E9.f fVar2 = this.mDeviceListAdapter;
        if (fVar2 == null || (collection = fVar2.f12264a.f12028f) == null) {
            element2 = null;
        } else {
            Iterator it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    if (ec.l.D(((MultiConnectStateDTO.Element) next).getAddress(), handheldDeviceInfo.getHandheldAddress(), true)) {
                        break;
                    }
                }
            }
            element2 = (MultiConnectStateDTO.Element) next;
        }
        if (element2 == null) {
            A6.b.g("onLowPriorityHandheldChanged disconnectElement is empty! adr = ", handheldDeviceInfo.getHandheldAddress(), "MultiDevicesManagerItem");
            this.mConnectOperateAddress = null;
            return;
        }
        String address = TextUtils.isEmpty(element2.getDeviceName()) ? element2.getAddress() : element2.getDeviceName();
        if (TextUtils.isEmpty(address)) {
            A.x("MultiDevicesManagerItem", "onLowPriorityHandheldChanged disconnectHandheldName is empty!");
            this.mConnectOperateAddress = null;
        } else {
            showConnectOperateConfirmDialog(element, true, address);
            this.mConnectOperateAddress = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onLowPriorityHandheldChanged$lambda$0(long j5) {
        return D0.b("onLowPriorityHandheldChanged deltaTime = ", j5);
    }

    private final void onMultiConnectInformationChanged(List<MultiConnectStateDTO.Element> multiConnectionStateInfos, String fromTag) {
        if (A.l()) {
            A.f("MultiDevicesManagerItem", "onMultiConnectInformationChanged fromTag = " + fromTag + ", " + multiConnectionStateInfos);
        }
        this.mMultiConnectInfoList = multiConnectionStateInfos;
        LinkedHashMap linkedHashMap = d.f26574a;
        d.c(multiConnectionStateInfos, this.mMultiConnectInfoCreateTime, new t(this, 0));
        List<MultiConnectStateDTO.Element> listE = d.e(multiConnectionStateInfos);
        E9.f fVar = this.mDeviceListAdapter;
        if (fVar != null) {
            fVar.d(listE);
        }
        if (multiConnectionStateInfos.size() != this.mCurrentDeviceSize) {
            this.mCurrentDeviceSize = multiConnectionStateInfos.size();
            o0.c.f1143a.postDelayed(new A9.k(this, 4), 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMultiConnectInformationChanged$lambda$0(MultiDevicesManagerItem multiDevicesManagerItem) {
        List<MultiConnectStateDTO.Element> listE = d.e(multiDevicesManagerItem.mMultiConnectInfoList);
        E9.f fVar = multiDevicesManagerItem.mDeviceListAdapter;
        if (fVar != null) {
            fVar.d(listE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMultiConnectInformationChanged$lambda$1(MultiDevicesManagerItem multiDevicesManagerItem) {
        COUIRecyclerView cOUIRecyclerView = multiDevicesManagerItem.mDeviceRecyclerView;
        if (cOUIRecyclerView != null) {
            cOUIRecyclerView.invalidateItemDecorations();
        }
    }

    private final <T> void recordObserve(androidx.lifecycle.s<T> sVar, androidx.lifecycle.v<T> vVar) {
        this.mLiveDataRecordList.add(C0379m.j(sVar, this.mLifecycleOwner, vVar));
    }

    private final void showConnectOperateConfirmDialog(MultiConnectStateDTO.Element element, boolean isConnect, String willDisconnectHandheldName) {
        String string;
        String string2;
        f fVar;
        Context context = getContext();
        if (context == null || element == null) {
            return;
        }
        String address = element.getAddress();
        if (TextUtils.isEmpty(address)) {
            A.h("MultiDevicesManagerItem", "showConnectOperateConfirmDiaLog handheldAddress is empty!");
            return;
        }
        f fVar2 = this.mConnectOperateConfirmDiaLog;
        if (fVar2 != null && fVar2.isShowing() && (fVar = this.mConnectOperateConfirmDiaLog) != null) {
            fVar.dismiss();
        }
        String address2 = TextUtils.isEmpty(element.getDeviceName()) ? element.getAddress() : element.getDeviceName();
        if (isConnect) {
            string = context.getString(R.string.melody_common_multi_connect_connect_dialog_title);
            string2 = TextUtils.isEmpty(address2) ? context.getString(R.string.melody_common_multi_connect_connect_dialog_message2, willDisconnectHandheldName) : context.getString(R.string.melody_common_multi_connect_connect_dialog_message, address2, willDisconnectHandheldName);
        } else {
            string = context.getString(R.string.melody_common_multi_connect_disconnect_dialog_title);
            string2 = context.getString(R.string.melody_common_multi_connect_disconnect_dialog_message, address2);
        }
        R1.e eVar = new R1.e(context);
        eVar.o(string);
        eVar.g(string2);
        eVar.h(R.string.melody_ui_common_cancel, new E9.l(0));
        eVar.j(R.string.melody_ui_common_confirm, new m(isConnect, this, address, element));
        this.mConnectOperateConfirmDiaLog = eVar.setCancelable(true).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConnectOperateConfirmDialog$lambda$1(boolean z2, MultiDevicesManagerItem multiDevicesManagerItem, String str, MultiConnectStateDTO.Element element, DialogInterface dialogInterface, int i10) {
        if (z2) {
            A.c("MultiDevicesManagerItem", new D6.c(str, 3));
            AbstractC1239a.a().e(multiDevicesManagerItem.mViewModel.f20397b, 1, str, false);
            multiDevicesManagerItem.updateToConnectingView(element.getAddress(), 1);
            d.a(element, new Aa.d(3, multiDevicesManagerItem, element));
        } else if (element.isCurrentDevice()) {
            A.c("MultiDevicesManagerItem", new p(multiDevicesManagerItem, 1));
            AbstractC0939b.E().c(multiDevicesManagerItem.mViewModel.f20397b);
        } else {
            AbstractC1239a.a().e(multiDevicesManagerItem.mViewModel.f20397b, 2, str, false);
        }
        DetailMainViewModel detailMainViewModel = multiDevicesManagerItem.mViewModel;
        String str2 = detailMainViewModel.f20400e;
        String str3 = detailMainViewModel.f20397b;
        C1264t.t(z2 ? AppConstant$FunctionType.MULTI_CONNECT_MANAGER_CONNECT_DEVICE.getFunType() : AppConstant$FunctionType.MULTI_CONNECT_MANAGER_DISCONNECT_DEVICE.getFunType(), str2, str3, N.t(detailMainViewModel.i(str3)), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showConnectOperateConfirmDialog$lambda$1$0(String str) {
        return C1656o.a("showConnectOperateConfirmDiaLog connectToHandheldDevice:", A.r(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConnectOperateConfirmDialog$lambda$1$1(MultiDevicesManagerItem multiDevicesManagerItem, MultiConnectStateDTO.Element element) {
        multiDevicesManagerItem.updateToConnectingView(element.getAddress(), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String showConnectOperateConfirmDialog$lambda$1$2(MultiDevicesManagerItem multiDevicesManagerItem) {
        return C1656o.a("showConnectOperateConfirmDiaLog disconnectCurrentDevice:", A.r(multiDevicesManagerItem.mViewModel.f20397b));
    }

    private final void updateToConnectingView(String address, int connectState) {
        E9.f fVar;
        Collection<MultiConnectStateDTO.Element> collection;
        E9.f fVar2;
        if (address == null || address.length() == 0 || (fVar = this.mDeviceListAdapter) == null || (collection = fVar.f12264a.f12028f) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(Kb.m.i(collection));
        boolean z2 = false;
        for (MultiConnectStateDTO.Element element : collection) {
            h.b(element);
            MultiConnectStateDTO.Element elementCopy$default = MultiConnectStateDTO.Element.copy$default(element, null, null, 0, false, false, false, 0, 127, null);
            if (address.equalsIgnoreCase(elementCopy$default.getAddress()) && elementCopy$default.getConnectionState() != connectState) {
                elementCopy$default.setConnectionState(connectState);
                z2 = true;
            }
            arrayList.add(elementCopy$default);
        }
        if (!z2 || (fVar2 = this.mDeviceListAdapter) == null) {
            return;
        }
        fVar2.d(arrayList);
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        A.b("MultiDevicesManagerItem", "onAttached");
        PreferenceGroup parent = getParent();
        MelodyCOUIPreferenceCategory melodyCOUIPreferenceCategory = parent instanceof MelodyCOUIPreferenceCategory ? (MelodyCOUIPreferenceCategory) parent : null;
        if (melodyCOUIPreferenceCategory != null) {
            melodyCOUIPreferenceCategory.f14690x = new o(this, 0);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.m holder) {
        h.e(holder, "holder");
        super.onBindViewHolder(holder);
        A.b("MultiDevicesManagerItem", "onBindViewHolder");
        this.mManagerCard = (ViewGroup) holder.a(R.id.manager_card);
        COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) holder.a(R.id.device_list);
        this.mDeviceRecyclerView = cOUIRecyclerView;
        if (cOUIRecyclerView != null) {
            getContext();
            cOUIRecyclerView.setLayoutManager(new LinearLayoutManager(0));
        }
        COUIRecyclerView cOUIRecyclerView2 = this.mDeviceRecyclerView;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView2.setAdapter(this.mDeviceListAdapter);
        }
        COUIRecyclerView cOUIRecyclerView3 = this.mDeviceRecyclerView;
        if (cOUIRecyclerView3 != null) {
            cOUIRecyclerView3.addItemDecoration(new c());
        }
        final int i10 = 0;
        recordObserve(C0379m.b(AbstractC1239a.a().b(this.mViewModel.f20397b)), new androidx.lifecycle.v(this) { // from class: E9.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MultiDevicesManagerItem f1414b;

            {
                this.f1414b = this;
            }

            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                switch (i10) {
                    case 0:
                        MultiDevicesManagerItem.onBindViewHolder$lambda$0(this.f1414b, (MultiConnectStateDTO) obj);
                        break;
                    default:
                        MultiDevicesManagerItem.onBindViewHolder$lambda$3(this.f1414b, (C1286a) obj);
                        break;
                }
            }
        });
        boolean z2 = pa.l.z(this.mViewModel.f20397b, "connectDisconnectDevice");
        A.c("MultipleDevicesConnectionFragmentV2", new r(15, z2));
        if (z2) {
            androidx.lifecycle.s<HandheldDeviceInfo> sVarD = AbstractC1239a.a().d(this.mViewModel.f20397b, false);
            h.d(sVarD, "getPriorityHandheldDeviceInfo(...)");
            recordObserve(sVarD, new A6.l(this, 3));
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        recordObserve(detailMainViewModel.d(detailMainViewModel.f20397b), new C9.a(this, 4));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        final int i11 = 1;
        recordObserve(detailMainViewModel2.n(detailMainViewModel2.f20397b), new androidx.lifecycle.v(this) { // from class: E9.n

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MultiDevicesManagerItem f1414b;

            {
                this.f1414b = this;
            }

            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                switch (i11) {
                    case 0:
                        MultiDevicesManagerItem.onBindViewHolder$lambda$0(this.f1414b, (MultiConnectStateDTO) obj);
                        break;
                    default:
                        MultiDevicesManagerItem.onBindViewHolder$lambda$3(this.f1414b, (C1286a) obj);
                        break;
                }
            }
        });
        if (C0373g.d()) {
            androidx.lifecycle.s<String> sVarK = this.mViewModel.k();
            h.d(sVarK, "getLeAudioSwitchStatusChanged(...)");
            recordObserve(sVarK, new E9.a(this, 1));
        }
        CompletableFuture.supplyAsync(new p(this, 0)).thenAcceptAsync((Consumer) new q(new A9.j(this, 2), 0), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new C0388w(1));
    }

    @Override // L8.g0
    public void onDestroy() {
        f fVar;
        A.b("MultiDevicesManagerItem", "onDestroy");
        f fVar2 = this.mConnectOperateConfirmDiaLog;
        if (fVar2 != null && fVar2.isShowing() && (fVar = this.mConnectOperateConfirmDiaLog) != null) {
            fVar.dismiss();
        }
        this.mConnectOperateConfirmDiaLog = null;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        A.b("MultiDevicesManagerItem", "onDetached");
        Iterator<T> it = this.mLiveDataRecordList.iterator();
        while (it.hasNext()) {
            ((C0381o) it.next()).a();
        }
        this.mLiveDataRecordList.clear();
    }

    @Override // L8.g0
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z2) {
    }
}
