package com.oplus.melody.ui.widget;

import E8.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.heytap.headset.R;

/* JADX INFO: loaded from: classes3.dex */
public class MelodySwitchPreference extends FrameLayout implements View.OnClickListener {
    public static final int BACKGROUND_WITH_ALL_RADIUS = 0;
    public static final int BACKGROUND_WITH_DOWN_RADIUS = 1;
    public static final int BACKGROUND_WITH_NO_RADIUS = 2;
    public static final int BACKGROUND_WITH_UP_RADIUS = 3;
    private static final float DISALBE_VIEW_ALPHA = 0.3f;
    private static final float ENABLE_VIEW_ALPHA = 1.0f;
    private static final String TAG = "MelodySwitchView";
    private boolean mClickableWhenDisabled;
    private RelativeLayout mContentLayout;
    private Context mContext;
    private a mDetailClickListener;
    private boolean mDisabled;
    private View mDividerView;
    private ImageView mJumpPrefNext;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private String mSummaryContent;
    private TextView mSummaryView;
    private COUISwitch mSwitchView;
    private String mTitleContent;
    private TextView mTitleView;

    public interface a {
    }

    public MelodySwitchPreference(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.melody_ui_switch_preference_view, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f1367e);
        this.mTitleContent = typedArrayObtainStyledAttributes.getString(1);
        this.mSummaryContent = typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initTitleView() {
        if (TextUtils.isEmpty(this.mTitleContent)) {
            return;
        }
        this.mTitleView.setText(this.mTitleContent);
    }

    private void invalidateSummary() {
        if (TextUtils.isEmpty(this.mSummaryContent)) {
            this.mContentLayout.setPadding(getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_single_text_vertical_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_single_text_vertical_padding));
            this.mSummaryView.setVisibility(8);
        } else {
            this.mContentLayout.setPadding(getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_multi_text_vertical_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_link_action_padding), getResources().getDimensionPixelSize(R.dimen.melody_ui_iot_cell_multi_text_vertical_padding));
            if (this.mSummaryView.getVisibility() != 0) {
                this.mSummaryView.setVisibility(0);
            }
            this.mSummaryView.setText(this.mSummaryContent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return (!this.mDisabled || this.mClickableWhenDisabled) && super.dispatchTouchEvent(motionEvent);
    }

    public String getSummary() {
        return this.mSummaryView.getText().toString();
    }

    public boolean isChecked() {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            return cOUISwitch.isChecked();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.switch_btn || this.mDividerView.getVisibility() == 0) {
            return;
        }
        this.mSwitchView.setChecked(!r2.isChecked());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mTitleView = (TextView) findViewById(R.id.switch_preference_title);
        this.mSummaryView = (TextView) findViewById(R.id.switch_preference_summary);
        this.mContentLayout = (RelativeLayout) findViewById(R.id.content_layout);
        this.mSwitchView = (COUISwitch) findViewById(R.id.switch_btn);
        this.mDividerView = findViewById(R.id.divider);
        this.mJumpPrefNext = (ImageView) findViewById(R.id.jump_pref_next);
        setOnClickListener(this);
        this.mSwitchView.setOnClickListener(this);
        initTitleView();
        invalidateSummary();
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
    }

    @Override // android.view.View
    public void setAllowClickWhenDisabled(boolean z2) {
        this.mClickableWhenDisabled = z2;
        super.setAllowClickWhenDisabled(z2);
    }

    public void setBackgroundType(int i10) {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        if (i10 == 1) {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(this.mContext.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_down_radius));
            dimensionPixelOffset2 = 0;
        } else if (i10 == 2) {
            setBackground(this.mContext.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_no_radius));
            dimensionPixelOffset2 = 0;
            dimensionPixelOffset = 0;
        } else if (i10 != 3) {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(this.mContext.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_all_radius));
        } else {
            dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.melody_ui_iot_cell_text_vertical_offset);
            setBackground(this.mContext.getDrawable(R.drawable.melody_ui_iot_udevice_preview_shape_up_radius));
            dimensionPixelOffset = 0;
        }
        setPadding(0, dimensionPixelOffset2, 0, dimensionPixelOffset);
    }

    public void setChecked(boolean z2) {
        this.mSwitchView.setOnCheckedChangeListener(null);
        this.mSwitchView.setChecked(z2);
        this.mSwitchView.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    }

    public void setDisabled(boolean z2) {
        this.mDisabled = z2;
        this.mContentLayout.setAlpha(z2 ? 0.3f : 1.0f);
        this.mSwitchView.setEnabled(!z2);
        this.mDividerView.setAlpha(this.mDisabled ? 0.3f : 1.0f);
        ImageView imageView = this.mJumpPrefNext;
        if (imageView != null) {
            imageView.setAlpha(this.mDisabled ? 0.3f : 1.0f);
        }
    }

    public void setDividerVisibility(boolean z2) {
        View view = this.mDividerView;
        if (view != null) {
            if (z2) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public void setJumpNextVisibility(boolean z2) {
        if (z2) {
            setDividerVisibility(false);
            setSwitchVisibility(false);
            ImageView imageView = this.mJumpPrefNext;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        setDividerVisibility(true);
        setSwitchVisibility(true);
        ImageView imageView2 = this.mJumpPrefNext;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    public void setOnSwitchChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        this.mSwitchView.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setSummary(int i10) {
        setSummary(getResources().getString(i10));
    }

    public void setSummaryColor(int i10) {
        this.mSummaryView.setTextColor(i10);
    }

    public void setSwitchSoundEffectsEnabled(boolean z2) {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(z2);
        }
        setSoundEffectsEnabled(z2);
    }

    public void setSwitchVisibility(boolean z2) {
        COUISwitch cOUISwitch = this.mSwitchView;
        if (cOUISwitch != null) {
            if (z2) {
                cOUISwitch.setVisibility(0);
            } else {
                cOUISwitch.setVisibility(8);
            }
        }
    }

    public void setTitle(int i10) {
        this.mTitleView.setText(i10);
    }

    public MelodySwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSummary(String str) {
        this.mSummaryContent = str;
        invalidateSummary();
    }

    public void setTitle(String str) {
        this.mTitleView.setText(str);
    }

    public MelodySwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mClickableWhenDisabled = false;
        init(context, attributeSet);
    }

    public void setOnDetailClickListener(a aVar) {
    }
}
