package com.oplus.melody.ui.component.detail.personalnoise;

import D7.C0370d;
import D7.C0379m;
import D7.H;
import D7.o0;
import E9.q;
import Ea.G;
import L8.C0454a;
import L8.RunnableC0474v;
import L8.g0;
import X3.w;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0586b;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.InterfaceC0601m;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import com.heytap.headset.R;
import com.oplus.melody.alive.component.health.module.BaseHealthModule;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.C0940c;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.PersonalNoiseDTO;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.track.constant.AppConstant$FunctionType;
import com.oplus.melody.ui.component.detail.DetailMainViewModel;
import com.oplus.melody.ui.widget.MelodySwitchPreference;
import java.lang.ref.WeakReference;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;

/* JADX INFO: loaded from: classes3.dex */
public class PersonalNoiseItem extends MelodySwitchPreference implements g0 {
    private static final long DETECTION_OVER_TIME = 15000;
    public static final String ITEM_NAME = "PersonalNoiseItem";
    private static final String PERSONALIZED_NOISE_CHECK_DIALOG = "PersonalizedNoiseCheckDialog";
    private static final String PERSONALIZED_NOISE_EXIST_DIALOG = "PersonalizedNoiseExistDialog";
    private static final String PERSONALIZED_NOISE_FAILED_DIALOG = "PersonalizedNoiseFailedDialog";
    private static final String PERSONALIZED_NOISE_NOT_EXIST_DIALOG = "PersonalizedNoiseNotExistDialog";
    private String mAddress;
    private boolean mBothInEar;
    private Consumer<com.oplus.melody.ui.component.detail.personalnoise.a> mClickChangeChangeConsumer;
    Context mContext;
    private CountDownTimer mCountDownTimer;
    private s<EarStatusDTO> mEarStatusLiveData;
    private boolean mIsCanceled;
    private boolean mIsPersonalizedNoiseFailedDialogShowing;
    InterfaceC0601m mLifecycleOwner;
    private CompletableFuture<PersonalNoiseDTO> mPersonalNoiseFuture;
    private s<PersonalNoiseDTO> mPersonalNoiseLiveData;
    private h mPersonalizedNoiseCheckDialog;
    private j mPersonalizedNoiseExistDialog;
    private m mPersonalizedNoiseFailedDialog;
    private n mPersonalizedNoiseNotExistDialog;
    private CompletableFuture<SetCommandStateDTO> mPersonalizedNoiseReductionFuture;
    private Toast mPersonalizedNoiseToast;
    private androidx.appcompat.app.f mPrecessAlertDialog;
    DetailMainViewModel mViewModel;

    public class a {
        public a() {
        }
    }

    public class b {
        public b() {
        }
    }

    public class c {
        public c() {
        }
    }

    public static final class e implements Consumer<com.oplus.melody.ui.component.detail.personalnoise.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<PersonalNoiseItem> f21168a;

        public e(PersonalNoiseItem personalNoiseItem) {
            this.f21168a = new WeakReference<>(personalNoiseItem);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Consumer
        public final void accept(com.oplus.melody.ui.component.detail.personalnoise.a aVar) {
            com.oplus.melody.ui.component.detail.personalnoise.a aVar2 = aVar;
            PersonalNoiseItem personalNoiseItem = this.f21168a.get();
            if (personalNoiseItem == null) {
                return;
            }
            int iIntValue = ((Integer) aVar2.f764a).intValue();
            if (iIntValue == 1) {
                personalNoiseItem.onRetry();
            } else if (iIntValue == 2) {
                personalNoiseItem.useDirectly();
            } else {
                if (iIntValue != 3) {
                    return;
                }
                personalNoiseItem.cancelCheck();
            }
        }
    }

    public PersonalNoiseItem(Context context) {
        super(context);
        this.mIsCanceled = false;
        this.mIsPersonalizedNoiseFailedDialogShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelCheck() {
        this.mIsCanceled = true;
        cancelTimer();
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mPersonalizedNoiseReductionFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = this.mAddress;
        detailMainViewModel.getClass();
        this.mPersonalizedNoiseReductionFuture = AbstractC0939b.E().x0(3, str);
    }

    private void cancelTimer() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mCountDownTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialogFragment(DialogInterfaceOnCancelListenerC0586b dialogInterfaceOnCancelListenerC0586b) {
        if (dialogInterfaceOnCancelListenerC0586b == null) {
            return;
        }
        if (dialogInterfaceOnCancelListenerC0586b.getActivity() == null || dialogInterfaceOnCancelListenerC0586b.getActivity().isFinishing() || dialogInterfaceOnCancelListenerC0586b.getActivity().isDestroyed() || !dialogInterfaceOnCancelListenerC0586b.isAdded()) {
            A.b(ITEM_NAME, "dismissDialogFragment skip, fragment not added");
            return;
        }
        try {
            dialogInterfaceOnCancelListenerC0586b.dismissAllowingStateLoss();
        } catch (Exception e10) {
            A.o(5, ITEM_NAME, "dismissDialogFragment failed", e10);
        }
    }

    private void dismissNoiseDialog() {
        dismissDialogFragment(this.mPersonalizedNoiseExistDialog);
        dismissDialogFragment(this.mPersonalizedNoiseNotExistDialog);
        dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
        dismissPersonalizedNoiseFailedDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissPersonalizedNoiseFailedDialog() {
        dismissDialogFragment(this.mPersonalizedNoiseFailedDialog);
        this.mPersonalizedNoiseFailedDialog = null;
        this.mIsPersonalizedNoiseFailedDialogShowing = false;
    }

    private void failHandle(int i10) {
        A.h(ITEM_NAME, "failHandle, status = " + i10);
        if (i10 == 9 || i10 == 8) {
            showPersonalizedNoiseFailedDialog(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$initItem$0(boolean z2) {
        return A6.e.f("PersonalNoiseItem: isChecked:", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$initItem$1(CompoundButton compoundButton, boolean z2) {
        A.c(ITEM_NAME, new G(19, z2));
        if (z2) {
            startPersonalizedNoise();
        } else {
            DetailMainViewModel detailMainViewModel = this.mViewModel;
            String str = this.mAddress;
            detailMainViewModel.getClass();
            AbstractC0939b.E().E0(12, false, str);
        }
        if (!z2) {
            DetailMainViewModel detailMainViewModel2 = this.mViewModel;
            String str2 = detailMainViewModel2.f20400e;
            String str3 = detailMainViewModel2.f20397b;
            C1264t.t(AppConstant$FunctionType.PERSON_NOISE.getFunType(), str2, str3, N.t(detailMainViewModel2.i(str3)), VersionInfo.VENDOR_CODE_DEFAULT_VERSION);
        }
        if (z2) {
            refreshNoiseSwitchView(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$initItem$2() {
        return "PersonalNoiseItem: mBothInEar:" + this.mBothInEar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initItem$3(EarStatusDTO earStatusDTO) {
        if (earStatusDTO == null) {
            A.b(ITEM_NAME, "PersonalNoiseItem: earStatusDTO is null");
            return;
        }
        this.mBothInEar = earStatusDTO.bothInEar();
        A.c(ITEM_NAME, new com.oplus.melody.model.db.s(this, 2));
        if (this.mBothInEar) {
            return;
        }
        dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initItem$4(Integer num) {
        if (num.intValue() != 2) {
            dismissNoiseDialog();
        }
        setEnabled(num.intValue() == 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$initItem$5(g gVar) {
        return "PersonalNoiseItem: receive PersonalNoiseStatus change ,personalNoiseStatusVO.isPersonalNoiseStatusOn():" + gVar.isPersonalNoiseStatusOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initItem$6(g gVar) {
        if (gVar != null) {
            A.c(ITEM_NAME, new I(gVar, 3));
            refreshNoiseSwitchView(gVar.isPersonalNoiseStatusOn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$initItem$7(PersonalNoiseDTO personalNoiseDTO) {
        return "onChanged: PersonalNoiseDTO:" + personalNoiseDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$initItem$8(PersonalNoiseDTO personalNoiseDTO) {
        A.c(ITEM_NAME, new com.oplus.melody.model.db.s(personalNoiseDTO, 3));
        if (personalNoiseDTO == null) {
            return;
        }
        if (this.mIsCanceled) {
            A.b(ITEM_NAME, "user have already operate cancel, return");
            return;
        }
        cancelTimer();
        if (personalNoiseDTO.getNoiseReductionResult() == 0) {
            if (!isChecked()) {
                DetailMainViewModel detailMainViewModel = this.mViewModel;
                String str = detailMainViewModel.f20400e;
                String str2 = detailMainViewModel.f20397b;
                C1264t.t(AppConstant$FunctionType.PERSON_NOISE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), BaseHealthModule.TRACK_FATIGUE_REMIND);
            }
            dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
            androidx.appcompat.app.f fVar = this.mPrecessAlertDialog;
            if (fVar != null) {
                fVar.dismiss();
            }
            m mVar = this.mPersonalizedNoiseFailedDialog;
            if (mVar != null && mVar.getDialog() != null && this.mPersonalizedNoiseFailedDialog.getDialog().isShowing()) {
                return;
            }
            showPersonalizedNoiseToast(this.mContext.getString(R.string.melody_ui_personalized_noise_reduction_check_complete));
            refreshNoiseSwitchView(true);
            DetailMainViewModel detailMainViewModel2 = this.mViewModel;
            String str3 = this.mAddress;
            detailMainViewModel2.getClass();
            AbstractC0939b.E().y(str3);
        } else {
            showPersonalizedNoiseFailedDialog(personalNoiseDTO.getNoiseReductionResult());
        }
        DetailMainViewModel detailMainViewModel3 = this.mViewModel;
        String str4 = this.mAddress;
        detailMainViewModel3.getClass();
        AbstractC0939b.E().a0(str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$onRetry$21() {
        return "onRetry: mBothInEar:" + this.mBothInEar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRetry$22(SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO == null || !TextUtils.equals(this.mAddress, setCommandStateDTO.getAddress())) {
            return;
        }
        if (setCommandStateDTO.getSetCommandStatus() != 15 && setCommandStateDTO.getSetCommandStatus() != 16) {
            if (setCommandStateDTO.getSetCommandStatus() != 0) {
                dismissPersonalizedNoiseFailedDialog();
                dismissDialogFragment(this.mPersonalizedNoiseNotExistDialog);
                dismissDialogFragment(this.mPersonalizedNoiseExistDialog);
                dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
                cancelTimer();
                failHandle(setCommandStateDTO.getSetCommandStatus());
                return;
            }
            return;
        }
        String string = setCommandStateDTO.getSetCommandStatus() == 15 ? this.mContext.getString(R.string.melody_ui_voice_enhancing_multi_device_interrupt_tips) : this.mContext.getString(R.string.melody_ui_notify_new_ear, "20");
        androidx.appcompat.app.f fVar = this.mPrecessAlertDialog;
        if (fVar != null) {
            fVar.dismiss();
        }
        G7.b bVar = new G7.b(this.mContext, R.style.COUIAlertDialog_Center);
        bVar.o(string);
        bVar.l(R.string.melody_ui_got_it, null);
        this.mPrecessAlertDialog = bVar.setCancelable(false).show();
        cancelTimer();
        dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$onRetry$23(Throwable th) {
        A.i(ITEM_NAME, "apply: ", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshNoiseSwitchView$10(boolean z2) {
        setChecked(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$refreshNoiseSwitchView$9(boolean z2) {
        return A6.e.f("refreshNoiseSwitchView isChecked = ", z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonalizedNoiseCheckDialog$20(FragmentManager fragmentManager) {
        this.mPersonalizedNoiseCheckDialog.show(fragmentManager, PERSONALIZED_NOISE_CHECK_DIALOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonalizedNoiseExistDialog$15(FragmentManager fragmentManager) {
        this.mPersonalizedNoiseExistDialog.show(fragmentManager, PERSONALIZED_NOISE_EXIST_DIALOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPersonalizedNoiseNotExistDialog$19(FragmentManager fragmentManager) {
        this.mPersonalizedNoiseNotExistDialog.show(fragmentManager, PERSONALIZED_NOISE_NOT_EXIST_DIALOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPersonalizedNoise$11(PersonalNoiseDTO personalNoiseDTO) {
        if (personalNoiseDTO != null) {
            if (personalNoiseDTO.getExistResult() != 0) {
                showPersonalizedNoiseExistDialog();
            } else {
                showPersonalizedNoiseNotExistDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$startPersonalizedNoise$12(Throwable th) {
        return "apply: exceptionally " + th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startPersonalizedNoise$13() {
        E8.a.S(C0906l.f19501a, R.string.melody_ui_fit_detection_fail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$startPersonalizedNoise$14(Throwable th) {
        if (th.getCause() instanceof CancellationException) {
            A.b(ITEM_NAME, "user operator canceled, return");
            return null;
        }
        A.c(ITEM_NAME, new X3.l(th, 14));
        o0.d(new RunnableC0474v(5));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$useDirectly$16() {
        refreshNoiseSwitchView(true);
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = this.mAddress;
        detailMainViewModel.getClass();
        AbstractC0939b.E().y(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$useDirectly$17(SetCommandStateDTO setCommandStateDTO) {
        if (TextUtils.equals(this.mAddress, setCommandStateDTO.getAddress())) {
            A.b(ITEM_NAME, "onClick: receive ACTION_APPLY_EXIST_RESULT ");
            if (setCommandStateDTO.getSetCommandStatus() == 0) {
                o0.d(new w(this, 19));
                DetailMainViewModel detailMainViewModel = this.mViewModel;
                String str = detailMainViewModel.f20400e;
                String str2 = detailMainViewModel.f20397b;
                C1264t.t(AppConstant$FunctionType.PERSON_NOISE.getFunType(), str, str2, N.t(detailMainViewModel.i(str2)), BaseHealthModule.TRACK_FATIGUE_REMIND);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$useDirectly$18(Throwable th) {
        A.i(ITEM_NAME, "apply: ", th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectStateChange(C0454a c0454a) {
        if (c0454a == null) {
            return;
        }
        if (c0454a.getIsSpp()) {
            if (c0454a.getConnectionState() == 2) {
                return;
            }
        } else if (c0454a.getHeadsetConnectionState() == 2) {
            return;
        }
        this.mIsCanceled = true;
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mPersonalizedNoiseReductionFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        cancelTimer();
        CompletableFuture<PersonalNoiseDTO> completableFuture2 = this.mPersonalNoiseFuture;
        if (completableFuture2 != null) {
            completableFuture2.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRetry() {
        A.c(ITEM_NAME, new X3.l(this, 15));
        if (!this.mBothInEar) {
            A.b(ITEM_NAME, "onRetry: !mBothInEar warm...");
            showPersonalizedNoiseToast(this.mContext.getString(R.string.melody_ui_personalized_noise_reduction_wear_check));
            return;
        }
        dismissPersonalizedNoiseFailedDialog();
        dismissDialogFragment(this.mPersonalizedNoiseNotExistDialog);
        dismissDialogFragment(this.mPersonalizedNoiseExistDialog);
        this.mIsCanceled = false;
        showPersonalizedNoiseCheckDialog();
        startTimer();
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mPersonalizedNoiseReductionFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = this.mAddress;
        detailMainViewModel.getClass();
        CompletableFuture<SetCommandStateDTO> completableFutureX0 = AbstractC0939b.E().x0(1, str);
        this.mPersonalizedNoiseReductionFuture = completableFutureX0;
        completableFutureX0.thenAcceptAsync((Consumer<? super SetCommandStateDTO>) new H(this, 23), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new C0940c(16));
    }

    private void refreshNoiseSwitchView(boolean z2) {
        A.c(ITEM_NAME, new A9.i(19, z2));
        o0.d(new T8.e(this, z2, 4));
    }

    private void showPersonalizedNoiseCheckDialog() {
        dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
        h hVar = new h();
        this.mPersonalizedNoiseCheckDialog = hVar;
        hVar.f21178a = new com.oplus.melody.ui.component.detail.personalnoise.e(this);
        hVar.f21179b = this.mAddress;
        hVar.setCancelable(false);
        Optional.ofNullable(this.mViewModel.j()).ifPresent(new q(this, 7));
    }

    private void showPersonalizedNoiseExistDialog() {
        dismissDialogFragment(this.mPersonalizedNoiseExistDialog);
        j jVar = new j();
        this.mPersonalizedNoiseExistDialog = jVar;
        jVar.f21186b = new a();
        jVar.f21187c = this.mAddress;
        Optional.ofNullable(this.mViewModel.j()).ifPresent(new com.oplus.melody.ui.component.detail.personalnoise.b(this, 0));
    }

    private void showPersonalizedNoiseFailedDialog(int i10) {
        dismissDialogFragment(this.mPersonalizedNoiseCheckDialog);
        if (this.mIsPersonalizedNoiseFailedDialogShowing) {
            A.b(ITEM_NAME, "showPersonalizedNoiseFailedDialog skip, dialog is already showing");
            return;
        }
        this.mIsPersonalizedNoiseFailedDialogShowing = true;
        m mVar = new m();
        this.mPersonalizedNoiseFailedDialog = mVar;
        mVar.f21197c = new c();
        mVar.setCancelable(false);
        m mVar2 = this.mPersonalizedNoiseFailedDialog;
        mVar2.f21196b = i10;
        mVar2.f21201s = this.mAddress;
        if (this.mViewModel.j() == null) {
            this.mIsPersonalizedNoiseFailedDialogShowing = false;
        } else {
            this.mPersonalizedNoiseFailedDialog.show(this.mViewModel.j(), PERSONALIZED_NOISE_FAILED_DIALOG);
        }
    }

    private void showPersonalizedNoiseNotExistDialog() {
        dismissDialogFragment(this.mPersonalizedNoiseNotExistDialog);
        n nVar = new n();
        this.mPersonalizedNoiseNotExistDialog = nVar;
        nVar.f21202a = new b();
        nVar.f21203b = this.mAddress;
        nVar.setCancelable(false);
        Optional.ofNullable(this.mViewModel.j()).ifPresent(new com.oplus.melody.ui.component.detail.personalnoise.b(this, 1));
    }

    private void showPersonalizedNoiseToast(String str) {
        Toast toast = this.mPersonalizedNoiseToast;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(this.mContext.getApplicationContext(), str, 0);
        this.mPersonalizedNoiseToast = toastMakeText;
        toastMakeText.show();
    }

    private void startPersonalizedNoise() {
        A.b(ITEM_NAME, "startPersonalizedNoise: ");
        if (!this.mBothInEar) {
            showPersonalizedNoiseToast(this.mContext.getString(R.string.melody_ui_personalized_noise_reduction_wear_check));
            return;
        }
        CompletableFuture<PersonalNoiseDTO> completableFutureM0 = AbstractC0939b.E().M0(this.mViewModel.f20397b);
        this.mPersonalNoiseFuture = completableFutureM0;
        if (completableFutureM0 != null) {
            completableFutureM0.thenAcceptAsync((Consumer<? super PersonalNoiseDTO>) new com.oplus.melody.ui.component.detail.personalnoise.c(this, 1), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new com.oplus.melody.model.repository.zenmode.f(4));
        }
    }

    private void startTimer() {
        cancelTimer();
        d dVar = new d();
        this.mCountDownTimer = dVar;
        dVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void useDirectly() {
        CompletableFuture<SetCommandStateDTO> completableFuture = this.mPersonalizedNoiseReductionFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        DetailMainViewModel detailMainViewModel = this.mViewModel;
        String str = this.mAddress;
        detailMainViewModel.getClass();
        CompletableFuture<SetCommandStateDTO> completableFutureX0 = AbstractC0939b.E().x0(2, str);
        this.mPersonalizedNoiseReductionFuture = completableFutureX0;
        completableFutureX0.thenAccept((Consumer<? super SetCommandStateDTO>) new com.oplus.melody.ui.component.detail.personalnoise.c(this, 0)).exceptionally((Function<Throwable, ? extends Void>) new com.oplus.melody.model.repository.zenmode.f(3));
    }

    public void initItem(Context context, DetailMainViewModel detailMainViewModel, InterfaceC0601m interfaceC0601m) {
        A.b(ITEM_NAME, "new PersonalNoiseItem: ");
        this.mContext = context;
        this.mViewModel = detailMainViewModel;
        this.mAddress = detailMainViewModel.f20397b;
        this.mLifecycleOwner = interfaceC0601m;
        setTitle(R.string.melody_ui_function_guide_personalized_noise_reduction_title);
        setSummary(R.string.melody_ui_function_guide_personalized_noise_reduction_summary);
        setOnSwitchChangeListener(new N1.b(this, 2));
        DetailMainViewModel detailMainViewModel2 = this.mViewModel;
        t tVarM = detailMainViewModel2.m(detailMainViewModel2.f20397b);
        this.mEarStatusLiveData = tVarM;
        final int i10 = 0;
        tVarM.e(interfaceC0601m, new v(this) { // from class: com.oplus.melody.ui.component.detail.personalnoise.d

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalNoiseItem f21174b;

            {
                this.f21174b = this;
            }

            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                switch (i10) {
                    case 0:
                        this.f21174b.lambda$initItem$3((EarStatusDTO) obj);
                        break;
                    default:
                        this.f21174b.lambda$initItem$8((PersonalNoiseDTO) obj);
                        break;
                }
            }
        });
        this.mViewModel.d(this.mAddress).e(interfaceC0601m, new C6.e(this, 24));
        DetailMainViewModel detailMainViewModel3 = this.mViewModel;
        String str = this.mAddress;
        detailMainViewModel3.getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str), new A6.g(12))).e(interfaceC0601m, new E9.a(this, 9));
        DetailMainViewModel detailMainViewModel4 = this.mViewModel;
        String str2 = this.mAddress;
        detailMainViewModel4.getClass();
        DetailMainViewModel.g(str2).e(interfaceC0601m, new A6.l(this, 18));
        DetailMainViewModel detailMainViewModel5 = this.mViewModel;
        String str3 = this.mAddress;
        detailMainViewModel5.getClass();
        t tVarB = C0379m.b(AbstractC0939b.E().G(str3));
        this.mPersonalNoiseLiveData = tVarB;
        final int i11 = 1;
        tVarB.e(interfaceC0601m, new v(this) { // from class: com.oplus.melody.ui.component.detail.personalnoise.d

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PersonalNoiseItem f21174b;

            {
                this.f21174b = this;
            }

            @Override // androidx.lifecycle.v
            public final void onChanged(Object obj) {
                switch (i11) {
                    case 0:
                        this.f21174b.lambda$initItem$3((EarStatusDTO) obj);
                        break;
                    default:
                        this.f21174b.lambda$initItem$8((PersonalNoiseDTO) obj);
                        break;
                }
            }
        });
        e eVar = new e(this);
        this.mClickChangeChangeConsumer = eVar;
        C0370d.c(com.oplus.melody.ui.component.detail.personalnoise.a.class, eVar);
    }

    @Override // L8.g0
    public void onDestroy() {
        A.b(ITEM_NAME, "onDestroy: ");
        C0370d.d(this.mClickChangeChangeConsumer);
        cancelTimer();
        dismissNoiseDialog();
        androidx.appcompat.app.f fVar = this.mPrecessAlertDialog;
        if (fVar != null) {
            fVar.dismiss();
            this.mPrecessAlertDialog = null;
        }
    }

    public PersonalNoiseItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsCanceled = false;
        this.mIsPersonalizedNoiseFailedDialogShowing = false;
    }

    public PersonalNoiseItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mIsCanceled = false;
        this.mIsPersonalizedNoiseFailedDialogShowing = false;
    }

    public class d extends CountDownTimer {
        public d() {
            super(PersonalNoiseItem.DETECTION_OVER_TIME, PersonalNoiseItem.DETECTION_OVER_TIME);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            A.c(PersonalNoiseItem.ITEM_NAME, new f(this, 0));
            if (PersonalNoiseItem.this.mViewModel.f20597l) {
                E8.a.S(C0906l.f19501a, R.string.melody_ui_fit_detection_fail);
            }
            PersonalNoiseItem personalNoiseItem = PersonalNoiseItem.this;
            personalNoiseItem.dismissDialogFragment(personalNoiseItem.mPersonalizedNoiseCheckDialog);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }

    @Override // L8.g0
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z2) {
    }
}
