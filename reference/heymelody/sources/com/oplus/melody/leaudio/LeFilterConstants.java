package com.oplus.melody.leaudio;

import com.oplus.melody.common.data.WhitelistConfigDTO;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: LeFilterConstants.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LeFilterConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f19611a;

    /* JADX INFO: compiled from: LeFilterConstants.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/oplus/melody/leaudio/LeFilterConstants$FunType;", "", "funId", "", "funType", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getFunId", "()I", "getFunType", "()Ljava/lang/String;", "NONE", "HIGH_AUDIO", "HI_QUALITY_AUDIO", "GOLD_HEARING", "SPATIAL_AUDIO", "ZEN_MODE", "PERSONAL_TONE", "SOUND_RECORD", "VOICE_WAKE", "MULTI_CONNECT", "FIT_DETECT", "FIRMWARE_UPDATE", "COLLECT_LOG", "DIAGNOSTIC", "CHANNEL_SWITCH", "GAME_MODE", "AUTO_SWITCH_LINK", "leaudio_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum FunType {
        NONE(0, 0),
        HIGH_AUDIO(1, 101),
        HI_QUALITY_AUDIO(2, 102),
        GOLD_HEARING(3, 103),
        SPATIAL_AUDIO(4, 104),
        ZEN_MODE(5, 105),
        PERSONAL_TONE(6, 106),
        SOUND_RECORD(7, 107),
        VOICE_WAKE(8, 108),
        MULTI_CONNECT(9, 109),
        FIT_DETECT(10, 110),
        FIRMWARE_UPDATE(11, 111),
        COLLECT_LOG(12, 112),
        DIAGNOSTIC(13, 113),
        CHANNEL_SWITCH(14, 114),
        GAME_MODE(15, 115),
        AUTO_SWITCH_LINK(16, 116);

        private final int funId;
        private final String funType;

        FunType(int i10, int i11) {
            this.funId = i11;
            this.funType = str;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getFunId() {
            return this.funId;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final String getFunType() {
            return this.funType;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f19611a = arrayList;
        WhitelistConfigDTO.LeFilterFunction leFilterFunction = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction.setFunctionType(FunType.HIGH_AUDIO.getFunType());
        leFilterFunction.setMinFirmVersion(999);
        arrayList.add(leFilterFunction);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction2 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction2.setFunctionType(FunType.HI_QUALITY_AUDIO.getFunType());
        leFilterFunction2.setMinFirmVersion(999);
        arrayList.add(leFilterFunction2);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction3 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction3.setFunctionType(FunType.GOLD_HEARING.getFunType());
        leFilterFunction3.setMinFirmVersion(999);
        arrayList.add(leFilterFunction3);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction4 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction4.setFunctionType(FunType.SPATIAL_AUDIO.getFunType());
        leFilterFunction4.setMinFirmVersion(999);
        arrayList.add(leFilterFunction4);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction5 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction5.setFunctionType(FunType.ZEN_MODE.getFunType());
        leFilterFunction5.setMinFirmVersion(999);
        arrayList.add(leFilterFunction5);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction6 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction6.setFunctionType(FunType.PERSONAL_TONE.getFunType());
        leFilterFunction6.setMinFirmVersion(999);
        arrayList.add(leFilterFunction6);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction7 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction7.setFunctionType(FunType.SOUND_RECORD.getFunType());
        leFilterFunction7.setMinFirmVersion(999);
        arrayList.add(leFilterFunction7);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction8 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction8.setFunctionType(FunType.VOICE_WAKE.getFunType());
        leFilterFunction8.setMinFirmVersion(999);
        arrayList.add(leFilterFunction8);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction9 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction9.setFunctionType(FunType.MULTI_CONNECT.getFunType());
        leFilterFunction9.setMinFirmVersion(999);
        arrayList.add(leFilterFunction9);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction10 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction10.setFunctionType(FunType.FIT_DETECT.getFunType());
        leFilterFunction10.setMinFirmVersion(999);
        arrayList.add(leFilterFunction10);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction11 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction11.setFunctionType(FunType.FIRMWARE_UPDATE.getFunType());
        leFilterFunction11.setMinFirmVersion(999);
        arrayList.add(leFilterFunction11);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction12 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction12.setFunctionType(FunType.COLLECT_LOG.getFunType());
        leFilterFunction12.setMinFirmVersion(999);
        arrayList.add(leFilterFunction12);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction13 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction13.setFunctionType(FunType.DIAGNOSTIC.getFunType());
        leFilterFunction13.setMinFirmVersion(999);
        arrayList.add(leFilterFunction13);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction14 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction14.setFunctionType(FunType.CHANNEL_SWITCH.getFunType());
        leFilterFunction14.setMinFirmVersion(999);
        arrayList.add(leFilterFunction14);
        WhitelistConfigDTO.LeFilterFunction leFilterFunction15 = new WhitelistConfigDTO.LeFilterFunction(0, 0, null, false, null, 31, null);
        leFilterFunction15.setFunctionType(FunType.GAME_MODE.getFunType());
        leFilterFunction15.setMinFirmVersion(999);
        arrayList.add(leFilterFunction15);
    }

    public static final ArrayList a(String name, ArrayList allList) {
        WhitelistConfigDTO.Function function;
        List<WhitelistConfigDTO.LeFilterFunction> leFilterFunctions;
        h.e(name, "name");
        h.e(allList, "allList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (allList.isEmpty()) {
            allList = f19611a;
        }
        arrayList2.addAll(allList);
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(null, name);
        if (whitelistConfigDTOC != null && (function = whitelistConfigDTOC.getFunction()) != null && (leFilterFunctions = function.getLeFilterFunctions()) != null) {
            arrayList.addAll(leFilterFunctions);
        }
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            WhitelistConfigDTO.LeFilterFunction leFilterFunction = (WhitelistConfigDTO.LeFilterFunction) obj;
            int size2 = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size2) {
                    arrayList.add(leFilterFunction);
                    break;
                }
                Object obj2 = arrayList.get(i11);
                i11++;
                if (h.a(((WhitelistConfigDTO.LeFilterFunction) obj2).getFunctionType(), leFilterFunction.getFunctionType())) {
                    break;
                }
            }
        }
        return arrayList;
    }
}
