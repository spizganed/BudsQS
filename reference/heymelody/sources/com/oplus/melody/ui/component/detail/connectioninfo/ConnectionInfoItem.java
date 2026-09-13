package com.oplus.melody.ui.component.detail.connectioninfo;

import A9.k;
import C6.e;
import Ca.o;
import D7.C0368b;
import L7.a;
import L8.C0454a;
import L8.g0;
import P3.g;
import T8.d;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.f;
import androidx.lifecycle.InterfaceC0601m;
import androidx.preference.Preference;
import androidx.preference.m;
import com.heytap.headset.R;
import com.oplus.iotui.IoTLinkWidget;
import com.oplus.iotui.IoTLinkedCell;
import com.oplus.iotui.IoTLinkingCell;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.S;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import i8.AbstractC1148a;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectionInfoItem extends Preference implements g0 {
    public static final String ITEM_NAME = "connectionInfo";
    private static final String TAG = "ConnectionInfoItem";
    private boolean hasObserve;
    private final View.OnClickListener mDisconnectOnClickListener;
    private boolean mIsClickReconnectResult;
    public InterfaceC0601m mLifecycleOwner;
    private IoTLinkWidget mLinkActionView;
    private o mTurnOnBluetoothDialogHelper;
    public DetailMainViewModel mViewModel;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ConnectionInfoItem connectionInfoItem = ConnectionInfoItem.this;
            DetailMainViewModel detailMainViewModel = connectionInfoItem.mViewModel;
            if (detailMainViewModel == null || TextUtils.isEmpty(detailMainViewModel.f20397b)) {
                return;
            }
            AbstractC0939b.E().c(connectionInfoItem.mViewModel.f20397b);
            ForkJoinPool.commonPool().execute(new k(this, 27));
        }
    }

    public ConnectionInfoItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        super(context);
        this.mLinkActionView = null;
        this.mIsClickReconnectResult = false;
        this.mDisconnectOnClickListener = new a();
        setLayoutResource(R.layout.melody_ui_recycler_item_link_action);
        this.mViewModel = detailMainViewModel;
        this.mLifecycleOwner = interfaceC0601m;
    }

    private boolean checkShowCompatibleDialog() {
        if (TextUtils.isEmpty(this.mViewModel.f20398c) || TextUtils.isEmpty(this.mViewModel.f20397b)) {
            return false;
        }
        int iH = S.h(this.mViewModel.f20398c, AbstractC1508a.f().g());
        if (iH == -1) {
            int i10 = AbstractC1148a.f24096c;
            if (!((Boolean) Optional.ofNullable(AbstractC1148a.C0266a.a()).map(new A9.o(this, 16)).orElse(Boolean.FALSE)).booleanValue()) {
                return false;
            }
        }
        Ca.k.a(getContext(), iH, this.mViewModel.f20397b);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean lambda$checkShowCompatibleDialog$3(AbstractC1148a abstractC1148a) {
        return Boolean.valueOf(abstractC1148a.d(this.mViewModel.f20397b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onBindViewHolder$0(Boolean bool) {
        if (bool.booleanValue()) {
            AbstractC0939b.E().f(this.mViewModel.f20397b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onBindViewHolder$1(Context context, View view) {
        if (S.s(context) && checkShowCompatibleDialog()) {
            return;
        }
        Object obj = L7.a.f3010c;
        if (a.C0032a.a().i()) {
            this.mIsClickReconnectResult = true;
            AbstractC0939b.E().f(this.mViewModel.f20397b);
        } else {
            o oVar = this.mTurnOnBluetoothDialogHelper;
            if (oVar != null) {
                oVar.b(new C0368b(this, 11), oVar.a("melody_ui_one_space_dialog_bluetooth_open_message2"));
            } else {
                E8.a.T(context, context.getString(R.string.melody_ui_connect_bluetooth_off_toast));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$onEarphoneDataChanged$2(C0454a c0454a) {
        return "onEarphoneDataChanged connectionInfoVO = " + c0454a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEarphoneDataChanged(C0454a c0454a) {
        int headsetConnectionState;
        A.c(TAG, new d(c0454a, 6));
        if (c0454a == null) {
            return;
        }
        Context context = getContext();
        if (c0454a.getIsSpp()) {
            headsetConnectionState = c0454a.getConnectionState();
        } else {
            headsetConnectionState = c0454a.getHeadsetConnectionState();
            if (headsetConnectionState != 2 && headsetConnectionState != 4 && AbstractC0939b.E().S(this.mViewModel.f20397b)) {
                headsetConnectionState = 2;
            }
        }
        if (headsetConnectionState == 2) {
            this.mIsClickReconnectResult = false;
            IoTLinkWidget ioTLinkWidget = this.mLinkActionView;
            String string = context.getString(R.string.melody_ui_connected);
            View.OnClickListener onClickListener = this.mDisconnectOnClickListener;
            A.b(ioTLinkWidget.f18772a, "showLinked");
            ioTLinkWidget.f18773b.setVisibility(8);
            IoTLinkedCell ioTLinkedCell = ioTLinkWidget.f18774c;
            ioTLinkedCell.f18776b = onClickListener;
            ioTLinkedCell.f18775a.setText(string);
            ioTLinkedCell.setVisibility(0);
        } else if (headsetConnectionState == 1) {
            IoTLinkWidget ioTLinkWidget2 = this.mLinkActionView;
            String linkTitle = context.getString(R.string.melody_ui_unconnect);
            String linkContent = context.getString(R.string.melody_ui_connecting);
            ioTLinkWidget2.getClass();
            h.e(linkTitle, "linkTitle");
            h.e(linkContent, "linkContent");
            A.c(ioTLinkWidget2.f18772a, new c8.k(linkTitle, linkContent, 3));
            IoTLinkingCell ioTLinkingCell = ioTLinkWidget2.f18773b;
            ioTLinkingCell.getClass();
            ioTLinkingCell.f18780p.setText(linkTitle);
            TextView textView = ioTLinkingCell.f18779c;
            textView.setText(linkContent);
            ioTLinkingCell.f18778b.setVisibility(8);
            textView.setVisibility(0);
            ioTLinkingCell.setVisibility(0);
            ioTLinkWidget2.f18774c.setVisibility(8);
        } else {
            if (this.mIsClickReconnectResult && headsetConnectionState == 5) {
                this.mIsClickReconnectResult = false;
                if (S.s(context)) {
                    E8.a.T(context, context.getString(R.string.melody_ui_connect_fail_toast));
                }
            }
            IoTLinkWidget ioTLinkWidget3 = this.mLinkActionView;
            String linkTitle2 = context.getString(R.string.melody_ui_unconnect);
            String linkContent2 = context.getString(R.string.melody_common_connect);
            ioTLinkWidget3.getClass();
            h.e(linkTitle2, "linkTitle");
            h.e(linkContent2, "linkContent");
            A.c(ioTLinkWidget3.f18772a, new L6.d(linkTitle2, linkContent2, 4));
            IoTLinkingCell ioTLinkingCell2 = ioTLinkWidget3.f18773b;
            ioTLinkingCell2.getClass();
            ioTLinkingCell2.f18780p.setText(linkTitle2);
            TextView textView2 = ioTLinkingCell2.f18778b;
            textView2.setText(linkContent2);
            textView2.setVisibility(0);
            ioTLinkingCell2.f18779c.setVisibility(8);
            ioTLinkingCell2.setVisibility(0);
            ioTLinkWidget3.f18774c.setVisibility(8);
        }
        this.mLinkActionView.invalidate();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(m mVar) {
        Activity activity;
        Context context = getContext();
        IoTLinkWidget ioTLinkWidget = (IoTLinkWidget) mVar.a(R.id.device_link_action);
        this.mLinkActionView = ioTLinkWidget;
        ioTLinkWidget.setTitleTextAppearance(R.style.couiTextAppearanceBody);
        this.mLinkActionView.setTitleTextColor(P1.a.b(context, R.attr.couiColorLabelSecondary, 0));
        if (this.mLinkActionView.getF18773b() != null) {
            this.mLinkActionView.getF18773b().setLinkingBodyTextAppearance(R.style.couiTextAppearanceBody);
            this.mLinkActionView.getF18773b().setLinkingBodyTextColor(P1.a.b(context, R.attr.couiColorSecondNeutral, 0));
            this.mLinkActionView.getF18773b().setLinkAgainTextThemeColor(P1.a.b(context, R.attr.couiColorPrimary, 0));
        }
        Context baseContext = context;
        while (true) {
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
            if (!F8.a.class.isInstance(baseContext)) {
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            } else if (baseContext instanceof Activity) {
                activity = (Activity) baseContext;
            }
        }
        activity = null;
        F8.a aVar = (F8.a) activity;
        if (aVar != null) {
            SparseArray<Object> sparseArray = aVar.f1647R;
            this.mTurnOnBluetoothDialogHelper = (o) (sparseArray != null ? sparseArray.get(R.id.melody_ui_tag_activity_turn_on_bluetooth_helper) : null);
        } else {
            this.mTurnOnBluetoothDialogHelper = null;
        }
        this.mLinkActionView.setReconnectListener(new g(2, this, context));
        if (this.hasObserve) {
            return;
        }
        this.hasObserve = true;
        DetailMainViewModel.g(this.mViewModel.f20397b).e(this.mLifecycleOwner, new e(this, 16));
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        AbstractC0939b.E().O(context, detailMainViewModel.f20397b, detailMainViewModel.f20398c);
    }

    @Override // L8.g0
    public void onDestroy() {
        f fVar;
        o oVar = this.mTurnOnBluetoothDialogHelper;
        if (oVar != null && (fVar = oVar.f820c) != null) {
            fVar.dismiss();
        }
        IoTLinkWidget ioTLinkWidget = this.mLinkActionView;
        if (ioTLinkWidget != null) {
            ioTLinkWidget.setReconnectListener(null);
        }
    }

    @Override // L8.g0
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z2) {
    }
}
