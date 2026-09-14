package com.oplus.melody.ui.component.control;

import Kb.l;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.model.repository.earphone.DeviceVersionDTO;
import com.oplus.melody.model.repository.earphone.KeyFunctionInfoDTO;
import com.oplus.melody.model.repository.earphone.NoiseReductionInfoDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: EarControlVO.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends com.oplus.melody.common.data.a {
    private String mBrand;
    private List<a> mCallControl;
    private int mConnectState;
    private List<a> mControl;
    private List<DeviceVersionDTO> mDeviceVersionList;
    private String mId;
    private List<KeyFunctionInfoDTO> mKeyFunctions;
    private NoiseReductionInfoDTO mLeftEarNoiseReductionInfoDTO;
    private List<a> mMusicControl;
    private String mName;
    private NoiseReductionInfoDTO mNoiseReductionInfoDTO;
    private int mNoiseReductionModeIndex;
    private NoiseReductionInfoDTO mRightEarNoiseReductionInfoDTO;
    private String mType;

    /* JADX INFO: compiled from: EarControlVO.java */
    public static final class a extends com.oplus.melody.common.data.a {
        private int mAction;
        private int mButton;
        private int mCurrentSupport;
        private int mDefaultFunction;
        private int mEar;
        private List<WhitelistConfigDTO.EntryStrModify> mEntryStrModify;
        private int mGroup;
        private int mMinSelectCount;
        private int mShowEar;
        private int mSupport;

        public a(int i10) {
            this.mAction = i10;
        }

        public int getAction() {
            return this.mAction;
        }

        public int getButton() {
            return this.mButton;
        }

        public int getCurrentSupport() {
            return this.mCurrentSupport;
        }

        public int getDefaultFunction() {
            return this.mDefaultFunction;
        }

        public int getEar() {
            return this.mEar;
        }

        public List<WhitelistConfigDTO.EntryStrModify> getEntryStrModify() {
            return this.mEntryStrModify;
        }

        public int getGroup() {
            return this.mGroup;
        }

        public int getMinSelectCount() {
            return this.mMinSelectCount;
        }

        public int getShowEar() {
            return this.mShowEar;
        }

        public int getSupport() {
            return this.mSupport;
        }

        public void setAction(int i10) {
            this.mAction = i10;
        }

        public void setButton(int i10) {
            this.mButton = i10;
        }

        public void setCurrentSupport(int i10) {
            this.mCurrentSupport = i10;
        }

        public void setDefaultFunction(int i10) {
            this.mDefaultFunction = i10;
        }

        public void setEar(int i10) {
            this.mEar = i10;
        }

        public void setEntryStrModify(List<WhitelistConfigDTO.EntryStrModify> list) {
            this.mEntryStrModify = list;
        }

        public void setGroup(int i10) {
            this.mGroup = i10;
        }

        public void setMinSelectCount(int i10) {
            this.mMinSelectCount = i10;
        }

        public void setShowEar(int i10) {
            this.mShowEar = i10;
        }

        public void setSupport(int i10) {
            this.mSupport = i10;
        }
    }

    public String getBrand() {
        return this.mBrand;
    }

    public List<a> getCallControl() {
        return this.mCallControl;
    }

    public int getConnectState() {
        return this.mConnectState;
    }

    public List<a> getControl() {
        return this.mControl;
    }

    public List<DeviceVersionDTO> getDeviceVersionList() {
        return this.mDeviceVersionList;
    }

    public String getId() {
        return this.mId;
    }

    public List<KeyFunctionInfoDTO> getKeyFunctions() {
        return this.mKeyFunctions;
    }

    public NoiseReductionInfoDTO getLeftEarNoiseReductionInfoVO() {
        return this.mLeftEarNoiseReductionInfoDTO;
    }

    public List<a> getMusicControl() {
        return this.mMusicControl;
    }

    public String getName() {
        return this.mName;
    }

    public NoiseReductionInfoDTO getNoiseReductionInfoVO() {
        return this.mNoiseReductionInfoDTO;
    }

    public int getNoiseReductionModeIndex() {
        return this.mNoiseReductionModeIndex;
    }

    public List<WhitelistConfigDTO.NoiseReductionMode> getNoiseReductionModeList(String str, String str2) {
        WhitelistConfigDTO.Function function;
        List<WhitelistConfigDTO.NoiseReductionMode> noiseReductionMode;
        WhitelistConfigDTO.NoiseReductionMode noiseReductionMode2;
        ArrayList arrayList = new ArrayList();
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(str, str2);
        if (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null || (noiseReductionMode = function.getNoiseReductionMode()) == null) {
            return arrayList;
        }
        int noiseReductionUIVersion = function.getNoiseReductionUIVersion();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(noiseReductionUIVersion == 2 ? l.e(4, 3, 5, 7, 10, 2, 6, 1) : l.e(4, 3, 5, 7, 10, 1, 2, 6));
        HashMap map = new HashMap();
        for (WhitelistConfigDTO.NoiseReductionMode noiseReductionMode3 : noiseReductionMode) {
            if (noiseReductionMode3 != null) {
                map.put(Integer.valueOf(noiseReductionMode3.getModeType()), noiseReductionMode3);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        h.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            h.d(next, "next(...)");
            int iIntValue = ((Number) next).intValue();
            if (map.containsKey(Integer.valueOf(iIntValue)) && (noiseReductionMode2 = (WhitelistConfigDTO.NoiseReductionMode) map.get(Integer.valueOf(iIntValue))) != null) {
                arrayList3.add(noiseReductionMode2);
            }
        }
        return arrayList3;
    }

    public NoiseReductionInfoDTO getRightEarNoiseReductionInfoVO() {
        return this.mRightEarNoiseReductionInfoDTO;
    }

    public String getType() {
        return this.mType;
    }

    public void setBrand(String str) {
        this.mBrand = str;
    }

    public void setCallControl(List<a> list) {
        this.mCallControl = list;
    }

    public void setConnectState(int i10) {
        this.mConnectState = i10;
    }

    public void setControl(List<a> list) {
        this.mControl = list;
    }

    public void setDeviceVersionList(List<DeviceVersionDTO> list) {
        this.mDeviceVersionList = list;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setKeyFunctions(List<KeyFunctionInfoDTO> list) {
        this.mKeyFunctions = list;
    }

    public void setLeftEarNoiseReductionInfoVO(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.mLeftEarNoiseReductionInfoDTO = noiseReductionInfoDTO;
    }

    public void setMusicControl(List<a> list) {
        this.mMusicControl = list;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setNoiseReductionInfoVO(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.mNoiseReductionInfoDTO = noiseReductionInfoDTO;
    }

    public void setNoiseReductionModeIndex(int i10) {
        this.mNoiseReductionModeIndex = i10;
    }

    public void setRightEarNoiseReductionInfoVO(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.mRightEarNoiseReductionInfoDTO = noiseReductionInfoDTO;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
