package com.oplus.melody.app.discovery;

import android.text.TextUtils;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import s8.AbstractC1508a;

/* JADX INFO: loaded from: classes.dex */
final class DiscoveryRecycleItemVO extends com.oplus.melody.common.data.a {
    private static final String TAG = "DiscoveryRecycleItemVO";
    private boolean mActive;
    private int mColorId;
    private String mMacAddress;
    private String mProductId;
    private String mProductName;
    private String mType;

    public static DiscoveryRecycleItemVO create(String str, String str2, String str3, int i10, String str4, boolean z2) {
        DiscoveryRecycleItemVO discoveryRecycleItemVO = new DiscoveryRecycleItemVO();
        discoveryRecycleItemVO.setMacAddress(str);
        discoveryRecycleItemVO.setProductName(str2);
        discoveryRecycleItemVO.setProductId(str3);
        discoveryRecycleItemVO.setType(str4);
        discoveryRecycleItemVO.setColorId(i10);
        discoveryRecycleItemVO.setActive(z2);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            StringBuilder sbI = Y.r.i("create deviceName='", str2, "' productId='", str3, "' productType='");
            sbI.append(str4);
            sbI.append("'");
            com.oplus.melody.common.util.A.f(TAG, sbI.toString());
            WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str3, str2);
            if (whitelistConfigDTOC != null) {
                if (TextUtils.isEmpty(str2)) {
                    discoveryRecycleItemVO.setProductName(whitelistConfigDTOC.getName());
                }
                if (TextUtils.isEmpty(str4)) {
                    discoveryRecycleItemVO.setType(whitelistConfigDTOC.getType());
                }
                if (TextUtils.isEmpty(str3)) {
                    discoveryRecycleItemVO.setProductId(whitelistConfigDTOC.getId());
                }
            }
        }
        return discoveryRecycleItemVO;
    }

    public int getColorId() {
        return this.mColorId;
    }

    public String getMacAddress() {
        return this.mMacAddress;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public String getType() {
        return this.mType;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public void setActive(boolean z2) {
        this.mActive = z2;
    }

    public void setColorId(int i10) {
        this.mColorId = i10;
    }

    public void setMacAddress(String str) {
        this.mMacAddress = str;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public void setProductName(String str) {
        this.mProductName = str;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
