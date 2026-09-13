package com.oplus.melody.ui.component.fitdetection;

import Ca.f;
import Ca.g;
import D7.C0373g;
import D7.C0379m;
import D7.o0;
import Ea.C0400i;
import Ea.C0403l;
import Ea.F;
import Ea.X;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.widget.e;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.N;
import androidx.lifecycle.O;
import androidx.media3.session.D0;
import com.bumptech.glide.Glide;
import com.coui.appcompat.panel.COUIBottomSheetDialogFragment;
import com.coui.appcompat.panel.COUIPanelFragment;
import com.heytap.headset.R;
import com.oplus.drs.core.d;
import com.oplus.melody.btsdk.protocol.commands.q;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0895a;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.C0909o;
import com.oplus.melody.common.util.Y;
import com.oplus.melody.leaudio.LeFilterConstants;
import com.oplus.melody.model.repository.earphone.AbstractC0939b;
import com.oplus.melody.model.repository.earphone.D;
import com.oplus.melody.model.repository.earphone.EarStatusDTO;
import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import com.oplus.melody.model.repository.earphone.FitDetectionDTO;
import com.oplus.melody.model.repository.earphone.I;
import com.oplus.melody.model.repository.earphone.N;
import com.oplus.melody.model.repository.earphone.SetCommandStateDTO;
import com.oplus.melody.model.repository.zenmode.e;
import com.oplus.melody.ui.component.fitdetection.FitDetectionFragment;
import com.oplus.melody.ui.widget.MelodyCompatToolbar;
import h0.h;
import ja.b;
import ja.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.function.Function;
import kc.C1264t;
import kotlin.jvm.internal.j;
import s8.AbstractC1508a;
import t8.s;
import u8.C1554b;

/* JADX INFO: loaded from: classes3.dex */
public class FitDetectionFragment extends COUIPanelFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21539a = 0;
    private String mAddress;
    private Button mBtnStatus;
    private Toast mCheckToast;
    private int mColorId;
    private String mDeviceName;
    private Toast mErrorToast;
    private ImageView mIvDevice;
    private ImageView mIvLeftDevice;
    private ImageView mIvRightDevice;
    private long mLastPlayTimeMillis;
    private String mProductId;
    private TextView mTvLeftDetectionResult;
    private ImageView mTvLeftTag;
    private TextView mTvRightDetectionResult;
    private ImageView mTvRightTag;
    private TextView mTvSubTitle;
    private MelodyCompatToolbar mTvTitle;
    private FitDetectionViewModel mViewModel;
    private String mDeviceType = "";
    private int mConnectionState = 0;
    private CompletableFuture<SetCommandStateDTO> mSetCommandFuture = null;
    private DialogInterface.OnDismissListener mOnDismissListener = null;
    private final CountDownTimer mCountDownTimer = new a();

    public static void o(FitDetectionFragment fitDetectionFragment, C1554b c1554b) {
        int i10;
        int i11;
        if ("N".equals(fitDetectionFragment.mDeviceType)) {
            File fileN = d.n(fitDetectionFragment.getContext(), c1554b.getDetailImageRes(), c1554b.getRootPath());
            if (fileN != null) {
                fitDetectionFragment.mIvDevice.setImageURI(Uri.fromFile(fileN));
                return;
            }
            return;
        }
        File fileN2 = d.n(fitDetectionFragment.getContext(), c1554b.getLeftImageRes(), c1554b.getRootPath());
        File fileN3 = d.n(fitDetectionFragment.getContext(), c1554b.getRightImageRes(), c1554b.getRootPath());
        if (A.l()) {
            A.f("FitDetectionFragment", "tryToLoadResource, left: " + fileN2 + ", right: " + fileN3);
        }
        if (fileN2 != null && fileN3 != null) {
            fitDetectionFragment.mIvLeftDevice.setImageURI(Uri.fromFile(fileN2));
            fitDetectionFragment.mIvRightDevice.setImageURI(Uri.fromFile(fileN3));
            return;
        }
        if (Y.i(fitDetectionFragment.mDeviceType)) {
            i10 = R.drawable.melody_ui_image_ear_left_ows;
            i11 = R.drawable.melody_ui_image_ear_right_ows;
        } else {
            i10 = R.drawable.melody_ui_image_ear_left_default;
            i11 = R.drawable.melody_ui_image_ear_right_default;
        }
        Glide.with(fitDetectionFragment).load(fileN2).fallback(i10).error(i10).into(fitDetectionFragment.mIvLeftDevice);
        Glide.with(fitDetectionFragment).load(fileN3).fallback(i11).error(i11).into(fitDetectionFragment.mIvRightDevice);
    }

    public static void q(FitDetectionFragment fitDetectionFragment, List list) {
        if (fitDetectionFragment.mConnectionState == 0 || fitDetectionFragment.mLastPlayTimeMillis <= 0) {
            A.c("FitDetectionFragment", new I(fitDetectionFragment, 14));
            return;
        }
        A.c("FitDetectionFragment", new C0400i(6, list));
        if (list != null && !list.isEmpty()) {
            fitDetectionFragment.mCountDownTimer.cancel();
            Iterator it = list.iterator();
            FitDetectionDTO fitDetectionDTO = null;
            FitDetectionDTO fitDetectionDTO2 = null;
            while (it.hasNext()) {
                FitDetectionDTO fitDetectionDTO3 = (FitDetectionDTO) it.next();
                if (fitDetectionDTO3.getDeviceType() == 1) {
                    fitDetectionDTO = fitDetectionDTO3;
                } else if (fitDetectionDTO3.getDeviceType() == 2) {
                    fitDetectionDTO2 = fitDetectionDTO3;
                }
            }
            int detectStatus = 0;
            if (fitDetectionDTO == null || fitDetectionDTO2 == null || fitDetectionDTO.isDetectError() || fitDetectionDTO2.isDetectError()) {
                if (A.l()) {
                    A.b("FitDetectionFragment", "detectionComplete， leftInfo or rightInfo is null or detectError, detectionFail. leftInfo： " + fitDetectionDTO);
                }
                fitDetectionFragment.A(null);
                if (fitDetectionDTO == null && fitDetectionDTO2 == null) {
                    detectStatus = -1;
                } else if (fitDetectionDTO != null && fitDetectionDTO.isDetectError()) {
                    detectStatus = fitDetectionDTO.getDetectStatus();
                } else if (fitDetectionDTO2 != null && fitDetectionDTO2.isDetectError()) {
                    detectStatus = fitDetectionDTO2.getDetectStatus();
                }
                String str = fitDetectionFragment.mProductId;
                String str2 = fitDetectionFragment.mAddress;
                fitDetectionFragment.mViewModel.getClass();
                C1264t.x(str, str2, N.t(AbstractC0939b.E().w(str2)), Integer.toString(detectStatus));
            } else {
                String str3 = fitDetectionFragment.mProductId;
                String str4 = fitDetectionFragment.mAddress;
                fitDetectionFragment.mViewModel.getClass();
                C1264t.x(str3, str4, N.t(AbstractC0939b.E().w(str4)), fitDetectionDTO.getDetectStatus() + "|" + fitDetectionDTO2.getDetectStatus());
                boolean z2 = fitDetectionDTO.getDetectStatus() == 1 && fitDetectionDTO2.getDetectStatus() == 1;
                A.c("FitDetectionFragment", new X(z2, list, 6));
                fitDetectionFragment.mTvLeftDetectionResult.setVisibility(0);
                fitDetectionFragment.mTvRightDetectionResult.setVisibility(0);
                fitDetectionFragment.E(true);
                if (z2) {
                    fitDetectionFragment.mTvLeftDetectionResult.setText(R.string.melody_ui_fit_detection_result_good);
                    fitDetectionFragment.mTvRightDetectionResult.setText(R.string.melody_ui_fit_detection_result_good);
                    fitDetectionFragment.mTvLeftTag.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_good);
                    fitDetectionFragment.mTvRightTag.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_good);
                    fitDetectionFragment.mBtnStatus.setText(R.string.melody_ui_fit_detection_complete);
                    fitDetectionFragment.mTvTitle.setTitle(R.string.melody_ui_fit_detection_result_good_title);
                    fitDetectionFragment.mBtnStatus.setVisibility(4);
                    fitDetectionFragment.mTvSubTitle.setVisibility(4);
                } else {
                    fitDetectionFragment.mBtnStatus.setVisibility(0);
                    fitDetectionFragment.mBtnStatus.setText(R.string.melody_ui_fit_detection_redo);
                    fitDetectionFragment.mTvLeftDetectionResult.setText(fitDetectionDTO.getDetectStatus() != 1 ? R.string.melody_ui_fit_detection_result_no_good : R.string.melody_ui_fit_detection_result_good);
                    fitDetectionFragment.mTvRightDetectionResult.setText(fitDetectionDTO2.getDetectStatus() != 1 ? R.string.melody_ui_fit_detection_result_no_good : R.string.melody_ui_fit_detection_result_good);
                    fitDetectionFragment.mTvTitle.setTitle(R.string.melody_ui_fit_detection_result_no_good_title);
                    fitDetectionFragment.mTvSubTitle.setVisibility(0);
                    if (fitDetectionDTO.getDetectStatus() != 1 && fitDetectionDTO2.getDetectStatus() != 1) {
                        fitDetectionFragment.mTvSubTitle.setText(String.format(fitDetectionFragment.getString(R.string.melody_ui_fit_detection_result_no_good_tips), fitDetectionFragment.getString(R.string.melody_ui_fit_detection_both_device)));
                        fitDetectionFragment.mTvLeftTag.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_bad);
                        fitDetectionFragment.mTvRightTag.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_bad);
                    } else if (fitDetectionDTO.getDetectStatus() != 1) {
                        fitDetectionFragment.mTvSubTitle.setText(String.format(fitDetectionFragment.getString(R.string.melody_ui_fit_detection_result_no_good_tips), fitDetectionFragment.getString(R.string.melody_ui_fit_detection_left_device)));
                        fitDetectionFragment.mTvLeftTag.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_bad);
                        fitDetectionFragment.mTvRightTag.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_good);
                    } else if (fitDetectionDTO2.getDetectStatus() != 1) {
                        fitDetectionFragment.mTvSubTitle.setText(String.format(fitDetectionFragment.getString(R.string.melody_ui_fit_detection_result_no_good_tips), fitDetectionFragment.getString(R.string.melody_ui_fit_detection_right_device)));
                        fitDetectionFragment.mTvLeftTag.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_good);
                        fitDetectionFragment.mTvRightTag.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_bad);
                    }
                    if (fitDetectionDTO.getDetectStatus() == 1) {
                        fitDetectionFragment.mTvLeftDetectionResult.setText(R.string.melody_ui_fit_detection_result_good);
                    } else if (fitDetectionDTO.getDetectStatus() == 0) {
                        fitDetectionFragment.mTvLeftDetectionResult.setText(R.string.melody_ui_fit_detection_result_no_good);
                    } else if (fitDetectionDTO.getDetectStatus() == 6) {
                        fitDetectionFragment.mTvLeftDetectionResult.setText(R.string.melody_ui_fit_detection_result_poor);
                    }
                    if (fitDetectionDTO2.getDetectStatus() == 1) {
                        fitDetectionFragment.mTvRightDetectionResult.setText(R.string.melody_ui_fit_detection_result_good);
                    } else if (fitDetectionDTO2.getDetectStatus() == 0) {
                        fitDetectionFragment.mTvRightDetectionResult.setText(R.string.melody_ui_fit_detection_result_no_good);
                    } else if (fitDetectionDTO2.getDetectStatus() == 6) {
                        fitDetectionFragment.mTvRightDetectionResult.setText(R.string.melody_ui_fit_detection_result_poor);
                    }
                }
            }
        } else if (list != null) {
            A.b("FitDetectionFragment", "earphone return empty detectionList when onDetectionStatusInfo, detectionFail.");
            fitDetectionFragment.A(null);
        }
        fitDetectionFragment.mViewModel.getClass();
        AbstractC0939b.E().Y();
    }

    public static void r(FitDetectionFragment fitDetectionFragment, View view) {
        if (s.a(view.getId())) {
            return;
        }
        if (TextUtils.equals(fitDetectionFragment.mBtnStatus.getText(), fitDetectionFragment.getResources().getString(R.string.melody_ui_fit_detection_complete))) {
            fitDetectionFragment.B();
            return;
        }
        try {
            Toast toast = fitDetectionFragment.mCheckToast;
            if (toast != null) {
                toast.cancel();
                fitDetectionFragment.mCheckToast = null;
            }
        } catch (Exception e10) {
            A.i("FitDetectionFragment", "dismissCheckToast", e10);
        }
        try {
            Toast toast2 = fitDetectionFragment.mErrorToast;
            if (toast2 != null) {
                toast2.cancel();
                fitDetectionFragment.mErrorToast = null;
            }
        } catch (Exception e11) {
            A.i("FitDetectionFragment", "dismissErrorToast", e11);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = fitDetectionFragment.mLastPlayTimeMillis;
        if (j5 != 0 && jElapsedRealtime - j5 < 300) {
            A.b("FitDetectionFragment", "play button click too frequently, return");
            return;
        }
        if (BluetoothAdapter.checkBluetoothAddress(fitDetectionFragment.mAddress)) {
            FitDetectionViewModel fitDetectionViewModel = fitDetectionFragment.mViewModel;
            String str = fitDetectionFragment.mAddress;
            fitDetectionViewModel.getClass();
            if (A.l()) {
                A.b("FitDetectionViewModel", "getStatusInfoAsync " + A.r(str));
            }
            CompletableFuture.supplyAsync(new D(str, 7)).thenAcceptAsync((Consumer) new b(fitDetectionFragment, 1), (Executor) o0.c.f1144b).exceptionally((Function<Throwable, ? extends Void>) new C0403l(fitDetectionFragment, 21));
        } else {
            A.b("FitDetectionFragment", "mAddress is null when startFitDetection, return detectionFail.");
            fitDetectionFragment.A(null);
        }
        fitDetectionFragment.mLastPlayTimeMillis = jElapsedRealtime;
    }

    public static void s(FitDetectionFragment fitDetectionFragment, int i10) {
        fitDetectionFragment.mConnectionState = i10;
        A.c("FitDetectionFragment", new q(i10, 9));
        if (i10 == 1 || i10 == 2) {
            return;
        }
        fitDetectionFragment.B();
    }

    public static void t(FitDetectionFragment fitDetectionFragment, EarStatusDTO earStatusDTO) {
        if (earStatusDTO == null) {
            A.h("FitDetectionFragment", "mStatusInfoObserver.onChanged, statusInfo is null");
            return;
        }
        A.c("FitDetectionFragment", new com.oplus.melody.ui.component.detail.zenmode.scene.a(earStatusDTO, 6));
        if (earStatusDTO.bothInEar()) {
            A.c("FitDetectionFragment", new com.oplus.melody.model.db.s(fitDetectionFragment, 18));
            com.oplus.melody.leaudio.a.a(fitDetectionFragment.mAddress, LeFilterConstants.FunType.FIT_DETECT, false, true, new ja.d(fitDetectionFragment));
            return;
        }
        if (TextUtils.equals(fitDetectionFragment.mTvTitle.getTitle(), fitDetectionFragment.getString(R.string.melody_ui_fit_detection_no_device)) && C0895a.C0225a.f19483a.a()) {
            Toast toastMakeText = Toast.makeText(C0906l.f19501a, R.string.melody_ui_fit_detection_no_device, 1);
            fitDetectionFragment.mCheckToast = toastMakeText;
            toastMakeText.show();
        }
        fitDetectionFragment.C();
        fitDetectionFragment.mTvTitle.setTitle(R.string.melody_ui_fit_detection_no_device);
    }

    public static /* synthetic */ String u(FitDetectionFragment fitDetectionFragment) {
        return "onDetectionStatusChanged, mConnectionState is none or mLastPlayTime <= 0, state: " + fitDetectionFragment.mConnectionState;
    }

    public static /* synthetic */ void v(FitDetectionFragment fitDetectionFragment, EarphoneDTO earphoneDTO) {
        fitDetectionFragment.mColorId = N.w(earphoneDTO.getColorId(), earphoneDTO.getProductId());
        fitDetectionFragment.F();
        fitDetectionFragment.H(fitDetectionFragment.mColorId, fitDetectionFragment.mProductId, fitDetectionFragment.mDeviceName);
    }

    public static /* synthetic */ void w(FitDetectionFragment fitDetectionFragment, SetCommandStateDTO setCommandStateDTO) {
        if (setCommandStateDTO.getSetCommandStatus() == 0) {
            A.b("FitDetectionFragment", "doFitDetection.onChanged send success...");
            return;
        }
        A.h("FitDetectionFragment", "doFitDetection.onChanged send, setCommandState:" + A.e(setCommandStateDTO));
        String string = null;
        if (setCommandStateDTO.getSetCommandStatus() == 15) {
            if (!fitDetectionFragment.isAdded()) {
                A.h("FitDetectionFragment", "doFitDetection show failed. context is null");
                return;
            }
            G7.b bVar = new G7.b(fitDetectionFragment.requireActivity());
            bVar.n(R.string.melody_ui_voice_enhancing_multi_device_interrupt_tips);
            bVar.l(R.string.melody_ui_got_it, null);
            bVar.setCancelable(false).show();
        } else if (setCommandStateDTO.getSetCommandStatus() == 16) {
            string = fitDetectionFragment.getString(R.string.melody_ui_notify_new_ear, "20");
        }
        o0.d(new h(2, fitDetectionFragment, string));
        fitDetectionFragment.mCountDownTimer.cancel();
    }

    public static /* synthetic */ String x(FitDetectionFragment fitDetectionFragment, String str) {
        return "initParams, mDeviceName: " + A.q(fitDetectionFragment.mDeviceName) + ", mProductId: " + fitDetectionFragment.mProductId + ", color: " + str;
    }

    public static void z(FitDetectionFragment fitDetectionFragment) {
        CompletableFuture<SetCommandStateDTO> completableFuture = fitDetectionFragment.mSetCommandFuture;
        if (completableFuture != null) {
            completableFuture.cancel(true);
        }
        FitDetectionViewModel fitDetectionViewModel = fitDetectionFragment.mViewModel;
        String str = fitDetectionFragment.mAddress;
        fitDetectionViewModel.getClass();
        CompletableFuture<SetCommandStateDTO> completableFutureL0 = AbstractC0939b.E().L0(str);
        fitDetectionFragment.mSetCommandFuture = completableFutureL0;
        completableFutureL0.thenAccept((Consumer<? super SetCommandStateDTO>) new b(fitDetectionFragment, 0)).exceptionally((Function<Throwable, ? extends Void>) new e(fitDetectionFragment, 4));
        fitDetectionFragment.E(false);
        fitDetectionFragment.mBtnStatus.setVisibility(0);
        fitDetectionFragment.mBtnStatus.setText(R.string.melody_ui_fit_detection_btn_detecting);
        fitDetectionFragment.mTvTitle.setTitle(R.string.melody_ui_fit_detection_btn_detecting_tips);
        fitDetectionFragment.mTvSubTitle.setVisibility(4);
        fitDetectionFragment.mTvLeftDetectionResult.setVisibility(4);
        fitDetectionFragment.mTvRightDetectionResult.setVisibility(4);
        fitDetectionFragment.mTvLeftTag.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_normal);
        fitDetectionFragment.mTvRightTag.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_normal);
        fitDetectionFragment.mCountDownTimer.start();
    }

    public final void A(String str) {
        try {
            Toast toast = this.mErrorToast;
            if (toast != null) {
                toast.cancel();
                this.mErrorToast = null;
            }
        } catch (Exception e10) {
            A.i("FitDetectionFragment", "dismissErrorToast", e10);
        }
        if (this.mConnectionState != 2) {
            if (C0895a.C0225a.f19483a.a() && isAdded()) {
                Toast.makeText(C0906l.f19501a, R.string.melody_ui_fit_detection_break_toast, 1).show();
            }
            B();
            return;
        }
        if (C0895a.C0225a.f19483a.a() && isAdded()) {
            if (str == null) {
                str = getString(R.string.melody_ui_fit_detection_fail);
            }
            Toast toastMakeText = Toast.makeText(C0906l.f19501a, str, 1);
            this.mErrorToast = toastMakeText;
            toastMakeText.show();
        }
        C();
    }

    public final void B() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof COUIBottomSheetDialogFragment) {
            ((COUIBottomSheetDialogFragment) parentFragment).dismiss();
        }
        onDestroy();
    }

    public final void C() {
        E(true);
        this.mTvTitle.setTitle(R.string.melody_ui_fit_detection_title);
        this.mTvSubTitle.setText(R.string.melody_ui_fit_detection_pre_tips);
        this.mBtnStatus.setText(R.string.melody_ui_fit_detection_btn_start);
        this.mBtnStatus.setVisibility(0);
        this.mTvSubTitle.setVisibility(0);
        this.mTvLeftDetectionResult.setVisibility(4);
        this.mTvRightDetectionResult.setVisibility(4);
        this.mTvLeftTag.setImageResource(R.drawable.melody_ui_fit_detection_left_device_tag_normal);
        this.mTvRightTag.setImageResource(R.drawable.melody_ui_fit_detection_right_device_tag_normal);
    }

    public final void D(f fVar) {
        this.mOnDismissListener = fVar;
    }

    public final void E(boolean z2) {
        this.mBtnStatus.setEnabled(z2);
    }

    public final void F() {
        if ("N".equals(this.mDeviceType)) {
            this.mIvDevice.setImageResource(R.drawable.melody_ui_neck_headset_control_default);
        } else if (Y.i(this.mDeviceType)) {
            this.mIvLeftDevice.setImageResource(R.drawable.melody_ui_image_ear_left_ows);
            this.mIvRightDevice.setImageResource(R.drawable.melody_ui_image_ear_right_ows);
        } else {
            this.mIvLeftDevice.setImageResource(R.drawable.melody_ui_image_ear_left_default);
            this.mIvRightDevice.setImageResource(R.drawable.melody_ui_image_ear_right_default);
        }
    }

    public final void G() {
        if (BluetoothAdapter.checkBluetoothAddress(this.mAddress)) {
            FitDetectionViewModel fitDetectionViewModel = this.mViewModel;
            String str = this.mAddress;
            fitDetectionViewModel.getClass();
            AbstractC0939b.E().N0(str);
        }
    }

    public final void H(int i10, String str, String str2) {
        if (A.l()) {
            StringBuilder sbG = D0.g(i10, "tryToLoadResource, productId: ", str, ", colorId: ", ", deviceName: ");
            sbG.append(A.q(str2));
            A.b("FitDetectionFragment", sbG.toString());
        }
        this.mViewModel.f21541b.e(getViewLifecycleOwner(), new c(this, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coui.appcompat.panel.COUIPanelFragment
    public final void initView(View view) {
        A.b("FitDetectionFragment", "initView:");
        super.initView(view);
        View viewInflate = LayoutInflater.from(getContext()).inflate("N".equals(this.mDeviceType) ? R.layout.melody_ui_fragment_neck_fit_detection : R.layout.melody_ui_fragment_fit_detection, (ViewGroup) getContentView(), true);
        getDragView().setVisibility(4);
        MelodyCompatToolbar melodyCompatToolbar = (MelodyCompatToolbar) viewInflate.findViewById(R.id.toolbar);
        this.mTvTitle = melodyCompatToolbar;
        melodyCompatToolbar.setTitle(R.string.melody_ui_fit_detection_title);
        this.mTvTitle.setIsTitleCenterStyle(true);
        this.mTvTitle.inflateMenu(R.menu.melody_ui_menu_panel_cancel_done);
        this.mTvTitle.getMenu().findItem(R.id.done).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: ja.a
            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i10 = FitDetectionFragment.f21539a;
                this.f25048a.B();
                return false;
            }
        });
        MelodyCompatToolbar melodyCompatToolbar2 = this.mTvTitle;
        melodyCompatToolbar2.setPadding(melodyCompatToolbar2.getPaddingLeft(), 0, this.mTvTitle.getPaddingRight(), 0);
        TextView textView = (TextView) this.mTvTitle.getTitleView();
        if (textView != 0) {
            textView.setSingleLine(true);
            textView.setLines(1);
            int iF = C0909o.f(textView.getContext(), (int) textView.getTextSize());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 27) {
                e.a.b(textView);
            } else if (textView instanceof androidx.core.widget.b) {
                ((androidx.core.widget.b) textView).setAutoSizeTextTypeWithDefaults(1);
            }
            int i11 = iF / 2;
            if (i10 >= 27) {
                e.a.a(textView, i11, iF);
            } else if (textView instanceof androidx.core.widget.b) {
                ((androidx.core.widget.b) textView).setAutoSizeTextTypeUniformWithConfiguration(i11, iF, 2, 2);
            }
        }
        this.mTvSubTitle = (TextView) viewInflate.findViewById(R.id.tv_subtitle);
        Button button = (Button) viewInflate.findViewById(R.id.btn_status);
        this.mBtnStatus = button;
        button.setOnClickListener(new F(this, 13));
        if ("N".equals(this.mDeviceType)) {
            this.mIvDevice = (ImageView) viewInflate.findViewById(R.id.iv_device);
        } else {
            this.mIvLeftDevice = (ImageView) viewInflate.findViewById(R.id.iv_left_device);
            this.mIvRightDevice = (ImageView) viewInflate.findViewById(R.id.iv_right_device);
        }
        this.mTvLeftDetectionResult = (TextView) viewInflate.findViewById(R.id.tv_left_detection_status);
        this.mTvRightDetectionResult = (TextView) viewInflate.findViewById(R.id.tv_right_detection_status);
        this.mTvLeftTag = (ImageView) viewInflate.findViewById(R.id.tv_left_tag);
        this.mTvRightTag = (ImageView) viewInflate.findViewById(R.id.tv_right_tag);
        this.mTvSubTitle.setText(R.string.melody_ui_fit_detection_pre_tips);
        this.mBtnStatus.setText(R.string.melody_ui_fit_detection_btn_start);
    }

    @Override // com.coui.appcompat.panel.COUIPanelFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        if (getActivity() == null || getArguments() == null) {
            B();
            A.x("FitDetectionFragment", "onActivityCreated: finish");
            return;
        }
        Bundle arguments = getArguments();
        this.mAddress = arguments.getString("device_mac_info");
        this.mDeviceName = arguments.getString("device_name");
        this.mProductId = arguments.getString("product_id");
        String string = arguments.getString("product_color");
        this.mColorId = TextUtils.isEmpty(string) ? -1 : Integer.parseInt(string);
        A.c("FitDetectionFragment", new Ca.s(16, this, string));
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(this.mProductId, this.mDeviceName);
        if (whitelistConfigDTOC != null) {
            this.mDeviceType = whitelistConfigDTOC.getType();
        }
        super.onActivityCreated(bundle);
        androidx.fragment.app.f owner = getActivity();
        kotlin.jvm.internal.h.e(owner, "owner");
        O viewModelStore = owner.getViewModelStore();
        N.b defaultViewModelProviderFactory = owner.getDefaultViewModelProviderFactory();
        X.d dVarC = A6.b.c(defaultViewModelProviderFactory, "factory", viewModelStore, defaultViewModelProviderFactory, owner.getDefaultViewModelCreationExtras());
        kotlin.jvm.internal.b bVarA = j.a(FitDetectionViewModel.class);
        String strA = bVarA.a();
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        FitDetectionViewModel fitDetectionViewModel = (FitDetectionViewModel) dVarC.a(bVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strA));
        this.mViewModel = fitDetectionViewModel;
        String str = this.mProductId;
        int i10 = this.mColorId;
        Z7.a.g().e(i10, str).thenAcceptAsync((Consumer) new G8.s(i10, 2, fitDetectionViewModel, str)).exceptionally((Function<Throwable, ? extends Void>) new com.oplus.melody.model.repository.zenmode.f(7));
        if (this.mColorId == -1) {
            String str2 = this.mAddress;
            this.mViewModel.getClass();
            AbstractC0939b.E().v(str2).e(getViewLifecycleOwner(), new E9.a(this, 18));
        } else {
            F();
            H(this.mColorId, this.mProductId, this.mDeviceName);
        }
        this.mViewModel.getClass();
        AbstractC0939b.E().A().e(getViewLifecycleOwner(), new C9.a(this, 23));
        FitDetectionViewModel fitDetectionViewModel2 = this.mViewModel;
        String str3 = this.mAddress;
        fitDetectionViewModel2.getClass();
        C0379m.b(C0379m.g(AbstractC0939b.E().v(str3), new A6.f(0))).e(getViewLifecycleOwner(), new c(this, 0));
        com.oplus.melody.leaudio.a.a(this.mAddress, LeFilterConstants.FunType.FIT_DETECT, true, false, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        try {
            Toast toast = this.mCheckToast;
            if (toast != null) {
                toast.cancel();
                this.mCheckToast = null;
            }
        } catch (Exception e10) {
            A.i("FitDetectionFragment", "dismissCheckToast", e10);
        }
        G();
        this.mCountDownTimer.cancel();
        if (this.mViewModel != null) {
            AbstractC0939b.E().Y();
        }
        String str = this.mAddress;
        if (C0373g.f()) {
            ForkJoinPool.commonPool().execute(new g(str, 1));
        } else {
            A6.b.g("directDisconnectSpp.isSppOverLeSupport=false, addr: ", A.r(str), "m_spp_le.LeAudioConnectSppManager");
        }
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(null);
        }
    }

    public class a extends CountDownTimer {
        public a() {
            super(15000L, 15000L);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            A.b("FitDetectionFragment", "CountDownTimer detection overtime, detectionFail.");
            int i10 = FitDetectionFragment.f21539a;
            FitDetectionFragment fitDetectionFragment = FitDetectionFragment.this;
            fitDetectionFragment.G();
            fitDetectionFragment.A(null);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j5) {
        }
    }
}
