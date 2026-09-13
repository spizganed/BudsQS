package com.oplus.melody.common.data;

import A6.e;
import I3.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\f~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001B\u0087\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010#J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010d\u001a\u00020\u0007HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0011\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003J\u0011\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018HÆ\u0003J\u0011\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010 HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010^J\u008e\u0002\u0010v\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00182\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010wJ\u0006\u0010x\u001a\u00020\u0007J\u0016\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u0007R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR \u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00108\"\u0004\bF\u0010:R \u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010<\"\u0004\bH\u0010>R \u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00108\"\u0004\bJ\u0010:R \u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u00108\"\u0004\bL\u0010:R&\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR&\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010N\"\u0004\bR\u0010PR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR \u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00108\"\u0004\bV\u0010:R \u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00108\"\u0004\bX\u0010:R \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010a\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`¨\u0006\u0085\u0001"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "name", "minVersion", "", "delayDetection", "", "earbudsMsg", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$MsgThreshold;", "earTemperature", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "earbudsCharge", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;", "paramCheck", "exceptions", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ExceptionThreshold;", "earbudsRssi", "earboxCharge", "boxTemperature", "usbTemperature", "supportList", "", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Support;", "colorList", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ColorMap;", "micList", "earChargeExp", "earBatDropExp", "earHealth", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeHealthThreshold;", "batDropLevel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$MsgThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ExceptionThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeHealthThreshold;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getMinVersion", "()I", "setMinVersion", "(I)V", "getDelayDetection", "()Ljava/lang/Long;", "setDelayDetection", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getEarbudsMsg", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$MsgThreshold;", "setEarbudsMsg", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$MsgThreshold;)V", "getEarTemperature", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "setEarTemperature", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getEarbudsCharge", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;", "setEarbudsCharge", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;)V", "getParamCheck", "setParamCheck", "getExceptions", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ExceptionThreshold;", "setExceptions", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ExceptionThreshold;)V", "getEarbudsRssi", "setEarbudsRssi", "getEarboxCharge", "setEarboxCharge", "getBoxTemperature", "setBoxTemperature", "getUsbTemperature", "setUsbTemperature", "getSupportList", "()Ljava/util/List;", "setSupportList", "(Ljava/util/List;)V", "getColorList", "setColorList", "getMicList", "setMicList", "getEarChargeExp", "setEarChargeExp", "getEarBatDropExp", "setEarBatDropExp", "getEarHealth", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeHealthThreshold;", "setEarHealth", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeHealthThreshold;)V", "getBatDropLevel", "()Ljava/lang/Integer;", "setBatDropLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$MsgThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ExceptionThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeHealthThreshold;Ljava/lang/Integer;)Lcom/oplus/melody/common/data/DiagnosisConfigDTO;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Threshold", "ExceptionThreshold", "MsgThreshold", "ChargeThreshold", "Support", "ColorMap", "ChargeHealthThreshold", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DiagnosisConfigDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<DiagnosisConfigDTO> CREATOR = new a();

    @b("batDropLevel")
    private Integer batDropLevel;

    @b("boxTemperature")
    private Threshold boxTemperature;

    @b("colorList")
    private List<ColorMap> colorList;

    @b("delayDetection")
    private Long delayDetection;

    @b("earBatDropExp")
    private Threshold earBatDropExp;

    @b("earChargeExp")
    private Threshold earChargeExp;

    @b("earHealth")
    private ChargeHealthThreshold earHealth;

    @b("earTemperature")
    private Threshold earTemperature;

    @b("earboxCharge")
    private ChargeThreshold earboxCharge;

    @b("earbudsCharge")
    private ChargeThreshold earbudsCharge;

    @b("earbudsMsg")
    private MsgThreshold earbudsMsg;

    @b("earbudsRssi")
    private Threshold earbudsRssi;

    @b("exceptions")
    private ExceptionThreshold exceptions;

    @b("id")
    private String id;

    @b("micList")
    private List<String> micList;

    @b("minVersion")
    private int minVersion;

    @b("name")
    private String name;

    @b("paramCheck")
    private Threshold paramCheck;

    @b("supportList")
    private List<Support> supportList;

    @b("usbTemperature")
    private Threshold usbTemperature;

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeHealthThreshold;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "excellent", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "good", "poor", "<init>", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getExcellent", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "setExcellent", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getGood", "setGood", "getPoor", "setPoor", "component1", "component2", "component3", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ChargeHealthThreshold extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<ChargeHealthThreshold> CREATOR = new a();

        @b("excellent")
        private Threshold excellent;

        @b("good")
        private Threshold good;

        @b("poor")
        private Threshold poor;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<ChargeHealthThreshold> {
            @Override // android.os.Parcelable.Creator
            public final ChargeHealthThreshold createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new ChargeHealthThreshold(parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Threshold.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            public final ChargeHealthThreshold[] newArray(int i10) {
                return new ChargeHealthThreshold[i10];
            }
        }

        public ChargeHealthThreshold() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ ChargeHealthThreshold copy$default(ChargeHealthThreshold chargeHealthThreshold, Threshold threshold, Threshold threshold2, Threshold threshold3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                threshold = chargeHealthThreshold.excellent;
            }
            if ((i10 & 2) != 0) {
                threshold2 = chargeHealthThreshold.good;
            }
            if ((i10 & 4) != 0) {
                threshold3 = chargeHealthThreshold.poor;
            }
            return chargeHealthThreshold.copy(threshold, threshold2, threshold3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Threshold getExcellent() {
            return this.excellent;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Threshold getGood() {
            return this.good;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Threshold getPoor() {
            return this.poor;
        }

        public final ChargeHealthThreshold copy(Threshold excellent, Threshold good, Threshold poor) {
            return new ChargeHealthThreshold(excellent, good, poor);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final Threshold getExcellent() {
            return this.excellent;
        }

        public final Threshold getGood() {
            return this.good;
        }

        public final Threshold getPoor() {
            return this.poor;
        }

        public final void setExcellent(Threshold threshold) {
            this.excellent = threshold;
        }

        public final void setGood(Threshold threshold) {
            this.good = threshold;
        }

        public final void setPoor(Threshold threshold) {
            this.poor = threshold;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            Threshold threshold = this.excellent;
            if (threshold == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold.writeToParcel(dest, flags);
            }
            Threshold threshold2 = this.good;
            if (threshold2 == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold2.writeToParcel(dest, flags);
            }
            Threshold threshold3 = this.poor;
            if (threshold3 == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold3.writeToParcel(dest, flags);
            }
        }

        public ChargeHealthThreshold(Threshold threshold, Threshold threshold2, Threshold threshold3) {
            this.excellent = threshold;
            this.good = threshold2;
            this.poor = threshold3;
        }

        public /* synthetic */ ChargeHealthThreshold(Threshold threshold, Threshold threshold2, Threshold threshold3, int i10, d dVar) {
            this((i10 & 1) != 0 ? null : threshold, (i10 & 2) != 0 ? null : threshold2, (i10 & 4) != 0 ? null : threshold3);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ChargeThreshold;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "per", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "vol", "<init>", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getPer", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "setPer", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getVol", "setVol", "component1", "component2", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ChargeThreshold extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<ChargeThreshold> CREATOR = new a();

        @b("per")
        private Threshold per;

        @b("vol")
        private Threshold vol;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<ChargeThreshold> {
            @Override // android.os.Parcelable.Creator
            public final ChargeThreshold createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new ChargeThreshold(parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Threshold.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            public final ChargeThreshold[] newArray(int i10) {
                return new ChargeThreshold[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ChargeThreshold() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ChargeThreshold copy$default(ChargeThreshold chargeThreshold, Threshold threshold, Threshold threshold2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                threshold = chargeThreshold.per;
            }
            if ((i10 & 2) != 0) {
                threshold2 = chargeThreshold.vol;
            }
            return chargeThreshold.copy(threshold, threshold2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Threshold getPer() {
            return this.per;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Threshold getVol() {
            return this.vol;
        }

        public final ChargeThreshold copy(Threshold per, Threshold vol) {
            return new ChargeThreshold(per, vol);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final Threshold getPer() {
            return this.per;
        }

        public final Threshold getVol() {
            return this.vol;
        }

        public final void setPer(Threshold threshold) {
            this.per = threshold;
        }

        public final void setVol(Threshold threshold) {
            this.vol = threshold;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            Threshold threshold = this.per;
            if (threshold == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold.writeToParcel(dest, flags);
            }
            Threshold threshold2 = this.vol;
            if (threshold2 == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold2.writeToParcel(dest, flags);
            }
        }

        public ChargeThreshold(Threshold threshold, Threshold threshold2) {
            this.per = threshold;
            this.vol = threshold2;
        }

        public /* synthetic */ ChargeThreshold(Threshold threshold, Threshold threshold2, int i10, d dVar) {
            this((i10 & 1) != 0 ? null : threshold, (i10 & 2) != 0 ? null : threshold2);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ColorMap;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "colorId", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getColorId", "()I", "setColorId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ColorMap extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<ColorMap> CREATOR = new a();

        @b("id")
        private int colorId;

        @b("name")
        private String name;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<ColorMap> {
            @Override // android.os.Parcelable.Creator
            public final ColorMap createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new ColorMap(parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final ColorMap[] newArray(int i10) {
                return new ColorMap[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ColorMap() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ColorMap copy$default(ColorMap colorMap, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = colorMap.colorId;
            }
            if ((i11 & 2) != 0) {
                str = colorMap.name;
            }
            return colorMap.copy(i10, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColorId() {
            return this.colorId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final ColorMap copy(int colorId, String name) {
            h.e(name, "name");
            return new ColorMap(colorId, name);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getColorId() {
            return this.colorId;
        }

        public final String getName() {
            return this.name;
        }

        public final void setColorId(int i10) {
            this.colorId = i10;
        }

        public final void setName(String str) {
            h.e(str, "<set-?>");
            this.name = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.colorId);
            dest.writeString(this.name);
        }

        public ColorMap(int i10, String name) {
            h.e(name, "name");
            this.colorId = i10;
            this.name = name;
        }

        public /* synthetic */ ColorMap(int i10, String str, int i11, d dVar) {
            this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? "" : str);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001e\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$ExceptionThreshold;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "crashThreshold", "", "twsDisThreshold", "phoneDisThreshold", "callCatonThreshold", "musicCatonThreshold", "<init>", "(IIIII)V", "getCrashThreshold", "()I", "setCrashThreshold", "(I)V", "getTwsDisThreshold", "setTwsDisThreshold", "getPhoneDisThreshold", "setPhoneDisThreshold", "getCallCatonThreshold", "setCallCatonThreshold", "getMusicCatonThreshold", "setMusicCatonThreshold", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ExceptionThreshold extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<ExceptionThreshold> CREATOR = new a();

        @b("callCatonThreshold")
        private int callCatonThreshold;

        @b("crashThreshold")
        private int crashThreshold;

        @b("musicCatonThreshold")
        private int musicCatonThreshold;

        @b("phoneDisThreshold")
        private int phoneDisThreshold;

        @b("twsDisThreshold")
        private int twsDisThreshold;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<ExceptionThreshold> {
            @Override // android.os.Parcelable.Creator
            public final ExceptionThreshold createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new ExceptionThreshold(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final ExceptionThreshold[] newArray(int i10) {
                return new ExceptionThreshold[i10];
            }
        }

        public ExceptionThreshold() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public static /* synthetic */ ExceptionThreshold copy$default(ExceptionThreshold exceptionThreshold, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                i10 = exceptionThreshold.crashThreshold;
            }
            if ((i15 & 2) != 0) {
                i11 = exceptionThreshold.twsDisThreshold;
            }
            if ((i15 & 4) != 0) {
                i12 = exceptionThreshold.phoneDisThreshold;
            }
            if ((i15 & 8) != 0) {
                i13 = exceptionThreshold.callCatonThreshold;
            }
            if ((i15 & 16) != 0) {
                i14 = exceptionThreshold.musicCatonThreshold;
            }
            int i16 = i14;
            int i17 = i12;
            return exceptionThreshold.copy(i10, i11, i17, i13, i16);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCrashThreshold() {
            return this.crashThreshold;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTwsDisThreshold() {
            return this.twsDisThreshold;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPhoneDisThreshold() {
            return this.phoneDisThreshold;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getCallCatonThreshold() {
            return this.callCatonThreshold;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getMusicCatonThreshold() {
            return this.musicCatonThreshold;
        }

        public final ExceptionThreshold copy(int crashThreshold, int twsDisThreshold, int phoneDisThreshold, int callCatonThreshold, int musicCatonThreshold) {
            return new ExceptionThreshold(crashThreshold, twsDisThreshold, phoneDisThreshold, callCatonThreshold, musicCatonThreshold);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getCallCatonThreshold() {
            return this.callCatonThreshold;
        }

        public final int getCrashThreshold() {
            return this.crashThreshold;
        }

        public final int getMusicCatonThreshold() {
            return this.musicCatonThreshold;
        }

        public final int getPhoneDisThreshold() {
            return this.phoneDisThreshold;
        }

        public final int getTwsDisThreshold() {
            return this.twsDisThreshold;
        }

        public final void setCallCatonThreshold(int i10) {
            this.callCatonThreshold = i10;
        }

        public final void setCrashThreshold(int i10) {
            this.crashThreshold = i10;
        }

        public final void setMusicCatonThreshold(int i10) {
            this.musicCatonThreshold = i10;
        }

        public final void setPhoneDisThreshold(int i10) {
            this.phoneDisThreshold = i10;
        }

        public final void setTwsDisThreshold(int i10) {
            this.twsDisThreshold = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.crashThreshold);
            dest.writeInt(this.twsDisThreshold);
            dest.writeInt(this.phoneDisThreshold);
            dest.writeInt(this.callCatonThreshold);
            dest.writeInt(this.musicCatonThreshold);
        }

        public ExceptionThreshold(int i10, int i11, int i12, int i13, int i14) {
            this.crashThreshold = i10;
            this.twsDisThreshold = i11;
            this.phoneDisThreshold = i12;
            this.callCatonThreshold = i13;
            this.musicCatonThreshold = i14;
        }

        public /* synthetic */ ExceptionThreshold(int i10, int i11, int i12, int i13, int i14, int i15, d dVar) {
            this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020!R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$MsgThreshold;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", SpeechFindManager.MAC, "", "sn", "hwVer", "Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "swVer", "color", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getMac", "()Ljava/lang/String;", "setMac", "(Ljava/lang/String;)V", "getSn", "setSn", "getHwVer", "()Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "setHwVer", "(Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;)V", "getSwVer", "setSwVer", "getColor", "setColor", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MsgThreshold extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<MsgThreshold> CREATOR = new a();

        @b("color")
        private Threshold color;

        @b("hw_ver")
        private Threshold hwVer;

        @b(SpeechFindManager.MAC)
        private String mac;

        @b("sn")
        private String sn;

        @b("sw_ver")
        private Threshold swVer;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<MsgThreshold> {
            @Override // android.os.Parcelable.Creator
            public final MsgThreshold createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new MsgThreshold(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Threshold.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            public final MsgThreshold[] newArray(int i10) {
                return new MsgThreshold[i10];
            }
        }

        public MsgThreshold() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ MsgThreshold copy$default(MsgThreshold msgThreshold, String str, String str2, Threshold threshold, Threshold threshold2, Threshold threshold3, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = msgThreshold.mac;
            }
            if ((i10 & 2) != 0) {
                str2 = msgThreshold.sn;
            }
            if ((i10 & 4) != 0) {
                threshold = msgThreshold.hwVer;
            }
            if ((i10 & 8) != 0) {
                threshold2 = msgThreshold.swVer;
            }
            if ((i10 & 16) != 0) {
                threshold3 = msgThreshold.color;
            }
            Threshold threshold4 = threshold3;
            Threshold threshold5 = threshold;
            return msgThreshold.copy(str, str2, threshold5, threshold2, threshold4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMac() {
            return this.mac;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSn() {
            return this.sn;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Threshold getHwVer() {
            return this.hwVer;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Threshold getSwVer() {
            return this.swVer;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Threshold getColor() {
            return this.color;
        }

        public final MsgThreshold copy(String mac, String sn, Threshold hwVer, Threshold swVer, Threshold color) {
            return new MsgThreshold(mac, sn, hwVer, swVer, color);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final Threshold getColor() {
            return this.color;
        }

        public final Threshold getHwVer() {
            return this.hwVer;
        }

        public final String getMac() {
            return this.mac;
        }

        public final String getSn() {
            return this.sn;
        }

        public final Threshold getSwVer() {
            return this.swVer;
        }

        public final void setColor(Threshold threshold) {
            this.color = threshold;
        }

        public final void setHwVer(Threshold threshold) {
            this.hwVer = threshold;
        }

        public final void setMac(String str) {
            this.mac = str;
        }

        public final void setSn(String str) {
            this.sn = str;
        }

        public final void setSwVer(Threshold threshold) {
            this.swVer = threshold;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.mac);
            dest.writeString(this.sn);
            Threshold threshold = this.hwVer;
            if (threshold == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold.writeToParcel(dest, flags);
            }
            Threshold threshold2 = this.swVer;
            if (threshold2 == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold2.writeToParcel(dest, flags);
            }
            Threshold threshold3 = this.color;
            if (threshold3 == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                threshold3.writeToParcel(dest, flags);
            }
        }

        public MsgThreshold(String str, String str2, Threshold threshold, Threshold threshold2, Threshold threshold3) {
            this.mac = str;
            this.sn = str2;
            this.hwVer = threshold;
            this.swVer = threshold2;
            this.color = threshold3;
        }

        public /* synthetic */ MsgThreshold(String str, String str2, Threshold threshold, Threshold threshold2, Threshold threshold3, int i10, d dVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : threshold, (i10 & 8) != 0 ? null : threshold2, (i10 & 16) != 0 ? null : threshold3);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Support;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "cmd", "", "<init>", "(Ljava/lang/String;)V", "getCmd", "()Ljava/lang/String;", "setCmd", "component1", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Support extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Support> CREATOR = new a();

        @b("cmd")
        private String cmd;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<Support> {
            @Override // android.os.Parcelable.Creator
            public final Support createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Support(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Support[] newArray(int i10) {
                return new Support[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Support() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Support copy$default(Support support, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = support.cmd;
            }
            return support.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCmd() {
            return this.cmd;
        }

        public final Support copy(String cmd) {
            h.e(cmd, "cmd");
            return new Support(cmd);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getCmd() {
            return this.cmd;
        }

        public final void setCmd(String str) {
            h.e(str, "<set-?>");
            this.cmd = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.cmd);
        }

        public Support(String cmd) {
            h.e(cmd, "cmd");
            this.cmd = cmd;
        }

        public /* synthetic */ Support(String str, int i10, d dVar) {
            this((i10 & 1) != 0 ? "" : str);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/common/data/DiagnosisConfigDTO$Threshold;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "min", "", "max", "per", "<init>", "(III)V", "getMin", "()I", "setMin", "(I)V", "getMax", "setMax", "getPer", "setPer", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Threshold extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Threshold> CREATOR = new a();

        @b("max")
        private int max;

        @b("min")
        private int min;

        @b("per")
        private int per;

        /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
        public static final class a implements Parcelable.Creator<Threshold> {
            @Override // android.os.Parcelable.Creator
            public final Threshold createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Threshold(parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final Threshold[] newArray(int i10) {
                return new Threshold[i10];
            }
        }

        public Threshold() {
            this(0, 0, 0, 7, null);
        }

        public static /* synthetic */ Threshold copy$default(Threshold threshold, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = threshold.min;
            }
            if ((i13 & 2) != 0) {
                i11 = threshold.max;
            }
            if ((i13 & 4) != 0) {
                i12 = threshold.per;
            }
            return threshold.copy(i10, i11, i12);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMin() {
            return this.min;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMax() {
            return this.max;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPer() {
            return this.per;
        }

        public final Threshold copy(int min, int max, int per) {
            return new Threshold(min, max, per);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getMax() {
            return this.max;
        }

        public final int getMin() {
            return this.min;
        }

        public final int getPer() {
            return this.per;
        }

        public final void setMax(int i10) {
            this.max = i10;
        }

        public final void setMin(int i10) {
            this.min = i10;
        }

        public final void setPer(int i10) {
            this.per = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.min);
            dest.writeInt(this.max);
            dest.writeInt(this.per);
        }

        public Threshold(int i10, int i11, int i12) {
            this.min = i10;
            this.max = i11;
            this.per = i12;
        }

        public /* synthetic */ Threshold(int i10, int i11, int i12, int i13, d dVar) {
            this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
        }
    }

    /* JADX INFO: compiled from: DiagnosisConfigDTO.kt */
    public static final class a implements Parcelable.Creator<DiagnosisConfigDTO> {
        @Override // android.os.Parcelable.Creator
        public final DiagnosisConfigDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String str;
            ArrayList arrayList2;
            String str2;
            ChargeHealthThreshold chargeHealthThresholdCreateFromParcel;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            MsgThreshold msgThresholdCreateFromParcel = parcel.readInt() == 0 ? null : MsgThreshold.CREATOR.createFromParcel(parcel);
            Threshold thresholdCreateFromParcel = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            ChargeThreshold chargeThresholdCreateFromParcel = parcel.readInt() == 0 ? null : ChargeThreshold.CREATOR.createFromParcel(parcel);
            Threshold thresholdCreateFromParcel2 = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            ExceptionThreshold exceptionThresholdCreateFromParcel = parcel.readInt() == 0 ? null : ExceptionThreshold.CREATOR.createFromParcel(parcel);
            Threshold thresholdCreateFromParcel3 = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            ChargeThreshold chargeThresholdCreateFromParcel2 = parcel.readInt() == 0 ? null : ChargeThreshold.CREATOR.createFromParcel(parcel);
            Threshold thresholdCreateFromParcel4 = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            Threshold thresholdCreateFromParcel5 = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                str = string;
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                str = string;
                int iB = 0;
                while (iB != i11) {
                    iB = A6.b.b(Support.CREATOR, parcel, arrayList, iB, 1);
                    i11 = i11;
                    string2 = string2;
                }
            }
            String str3 = string2;
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int i12 = parcel.readInt();
                arrayList2 = new ArrayList(i12);
                int iB2 = 0;
                while (iB2 != i12) {
                    iB2 = A6.b.b(ColorMap.CREATOR, parcel, arrayList2, iB2, 1);
                    i12 = i12;
                    arrayList = arrayList;
                }
            }
            ArrayList arrayList3 = arrayList;
            String str4 = str;
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            Threshold thresholdCreateFromParcel6 = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            Threshold thresholdCreateFromParcel7 = parcel.readInt() == 0 ? null : Threshold.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                str2 = str4;
                chargeHealthThresholdCreateFromParcel = null;
            } else {
                str2 = str4;
                chargeHealthThresholdCreateFromParcel = ChargeHealthThreshold.CREATOR.createFromParcel(parcel);
            }
            return new DiagnosisConfigDTO(str2, str3, i10, lValueOf, msgThresholdCreateFromParcel, thresholdCreateFromParcel, chargeThresholdCreateFromParcel, thresholdCreateFromParcel2, exceptionThresholdCreateFromParcel, thresholdCreateFromParcel3, chargeThresholdCreateFromParcel2, thresholdCreateFromParcel4, thresholdCreateFromParcel5, arrayList3, arrayList2, arrayListCreateStringArrayList, thresholdCreateFromParcel6, thresholdCreateFromParcel7, chargeHealthThresholdCreateFromParcel, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        public final DiagnosisConfigDTO[] newArray(int i10) {
            return new DiagnosisConfigDTO[i10];
        }
    }

    public DiagnosisConfigDTO() {
        this(null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiagnosisConfigDTO copy$default(DiagnosisConfigDTO diagnosisConfigDTO, String str, String str2, int i10, Long l4, MsgThreshold msgThreshold, Threshold threshold, ChargeThreshold chargeThreshold, Threshold threshold2, ExceptionThreshold exceptionThreshold, Threshold threshold3, ChargeThreshold chargeThreshold2, Threshold threshold4, Threshold threshold5, List list, List list2, List list3, Threshold threshold6, Threshold threshold7, ChargeHealthThreshold chargeHealthThreshold, Integer num, int i11, Object obj) {
        Integer num2;
        ChargeHealthThreshold chargeHealthThreshold2;
        String str3 = (i11 & 1) != 0 ? diagnosisConfigDTO.id : str;
        String str4 = (i11 & 2) != 0 ? diagnosisConfigDTO.name : str2;
        int i12 = (i11 & 4) != 0 ? diagnosisConfigDTO.minVersion : i10;
        Long l10 = (i11 & 8) != 0 ? diagnosisConfigDTO.delayDetection : l4;
        MsgThreshold msgThreshold2 = (i11 & 16) != 0 ? diagnosisConfigDTO.earbudsMsg : msgThreshold;
        Threshold threshold8 = (i11 & 32) != 0 ? diagnosisConfigDTO.earTemperature : threshold;
        ChargeThreshold chargeThreshold3 = (i11 & 64) != 0 ? diagnosisConfigDTO.earbudsCharge : chargeThreshold;
        Threshold threshold9 = (i11 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? diagnosisConfigDTO.paramCheck : threshold2;
        ExceptionThreshold exceptionThreshold2 = (i11 & 256) != 0 ? diagnosisConfigDTO.exceptions : exceptionThreshold;
        Threshold threshold10 = (i11 & 512) != 0 ? diagnosisConfigDTO.earbudsRssi : threshold3;
        ChargeThreshold chargeThreshold4 = (i11 & 1024) != 0 ? diagnosisConfigDTO.earboxCharge : chargeThreshold2;
        Threshold threshold11 = (i11 & 2048) != 0 ? diagnosisConfigDTO.boxTemperature : threshold4;
        Threshold threshold12 = (i11 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? diagnosisConfigDTO.usbTemperature : threshold5;
        List list4 = (i11 & 8192) != 0 ? diagnosisConfigDTO.supportList : list;
        String str5 = str3;
        List list5 = (i11 & 16384) != 0 ? diagnosisConfigDTO.colorList : list2;
        List list6 = (i11 & 32768) != 0 ? diagnosisConfigDTO.micList : list3;
        Threshold threshold13 = (i11 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? diagnosisConfigDTO.earChargeExp : threshold6;
        Threshold threshold14 = (i11 & 131072) != 0 ? diagnosisConfigDTO.earBatDropExp : threshold7;
        ChargeHealthThreshold chargeHealthThreshold3 = (i11 & 262144) != 0 ? diagnosisConfigDTO.earHealth : chargeHealthThreshold;
        if ((i11 & 524288) != 0) {
            chargeHealthThreshold2 = chargeHealthThreshold3;
            num2 = diagnosisConfigDTO.batDropLevel;
        } else {
            num2 = num;
            chargeHealthThreshold2 = chargeHealthThreshold3;
        }
        return diagnosisConfigDTO.copy(str5, str4, i12, l10, msgThreshold2, threshold8, chargeThreshold3, threshold9, exceptionThreshold2, threshold10, chargeThreshold4, threshold11, threshold12, list4, list5, list6, threshold13, threshold14, chargeHealthThreshold2, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Threshold getEarbudsRssi() {
        return this.earbudsRssi;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ChargeThreshold getEarboxCharge() {
        return this.earboxCharge;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Threshold getBoxTemperature() {
        return this.boxTemperature;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Threshold getUsbTemperature() {
        return this.usbTemperature;
    }

    public final List<Support> component14() {
        return this.supportList;
    }

    public final List<ColorMap> component15() {
        return this.colorList;
    }

    public final List<String> component16() {
        return this.micList;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Threshold getEarChargeExp() {
        return this.earChargeExp;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Threshold getEarBatDropExp() {
        return this.earBatDropExp;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final ChargeHealthThreshold getEarHealth() {
        return this.earHealth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Integer getBatDropLevel() {
        return this.batDropLevel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMinVersion() {
        return this.minVersion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getDelayDetection() {
        return this.delayDetection;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MsgThreshold getEarbudsMsg() {
        return this.earbudsMsg;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Threshold getEarTemperature() {
        return this.earTemperature;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ChargeThreshold getEarbudsCharge() {
        return this.earbudsCharge;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Threshold getParamCheck() {
        return this.paramCheck;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ExceptionThreshold getExceptions() {
        return this.exceptions;
    }

    public final DiagnosisConfigDTO copy(String id, String name, int minVersion, Long delayDetection, MsgThreshold earbudsMsg, Threshold earTemperature, ChargeThreshold earbudsCharge, Threshold paramCheck, ExceptionThreshold exceptions, Threshold earbudsRssi, ChargeThreshold earboxCharge, Threshold boxTemperature, Threshold usbTemperature, List<Support> supportList, List<ColorMap> colorList, List<String> micList, Threshold earChargeExp, Threshold earBatDropExp, ChargeHealthThreshold earHealth, Integer batDropLevel) {
        return new DiagnosisConfigDTO(id, name, minVersion, delayDetection, earbudsMsg, earTemperature, earbudsCharge, paramCheck, exceptions, earbudsRssi, earboxCharge, boxTemperature, usbTemperature, supportList, colorList, micList, earChargeExp, earBatDropExp, earHealth, batDropLevel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Integer getBatDropLevel() {
        return this.batDropLevel;
    }

    public final Threshold getBoxTemperature() {
        return this.boxTemperature;
    }

    public final List<ColorMap> getColorList() {
        return this.colorList;
    }

    public final Long getDelayDetection() {
        return this.delayDetection;
    }

    public final Threshold getEarBatDropExp() {
        return this.earBatDropExp;
    }

    public final Threshold getEarChargeExp() {
        return this.earChargeExp;
    }

    public final ChargeHealthThreshold getEarHealth() {
        return this.earHealth;
    }

    public final Threshold getEarTemperature() {
        return this.earTemperature;
    }

    public final ChargeThreshold getEarboxCharge() {
        return this.earboxCharge;
    }

    public final ChargeThreshold getEarbudsCharge() {
        return this.earbudsCharge;
    }

    public final MsgThreshold getEarbudsMsg() {
        return this.earbudsMsg;
    }

    public final Threshold getEarbudsRssi() {
        return this.earbudsRssi;
    }

    public final ExceptionThreshold getExceptions() {
        return this.exceptions;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getMicList() {
        return this.micList;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }

    public final String getName() {
        return this.name;
    }

    public final Threshold getParamCheck() {
        return this.paramCheck;
    }

    public final List<Support> getSupportList() {
        return this.supportList;
    }

    public final Threshold getUsbTemperature() {
        return this.usbTemperature;
    }

    public final void setBatDropLevel(Integer num) {
        this.batDropLevel = num;
    }

    public final void setBoxTemperature(Threshold threshold) {
        this.boxTemperature = threshold;
    }

    public final void setColorList(List<ColorMap> list) {
        this.colorList = list;
    }

    public final void setDelayDetection(Long l4) {
        this.delayDetection = l4;
    }

    public final void setEarBatDropExp(Threshold threshold) {
        this.earBatDropExp = threshold;
    }

    public final void setEarChargeExp(Threshold threshold) {
        this.earChargeExp = threshold;
    }

    public final void setEarHealth(ChargeHealthThreshold chargeHealthThreshold) {
        this.earHealth = chargeHealthThreshold;
    }

    public final void setEarTemperature(Threshold threshold) {
        this.earTemperature = threshold;
    }

    public final void setEarboxCharge(ChargeThreshold chargeThreshold) {
        this.earboxCharge = chargeThreshold;
    }

    public final void setEarbudsCharge(ChargeThreshold chargeThreshold) {
        this.earbudsCharge = chargeThreshold;
    }

    public final void setEarbudsMsg(MsgThreshold msgThreshold) {
        this.earbudsMsg = msgThreshold;
    }

    public final void setEarbudsRssi(Threshold threshold) {
        this.earbudsRssi = threshold;
    }

    public final void setExceptions(ExceptionThreshold exceptionThreshold) {
        this.exceptions = exceptionThreshold;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setMicList(List<String> list) {
        this.micList = list;
    }

    public final void setMinVersion(int i10) {
        this.minVersion = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setParamCheck(Threshold threshold) {
        this.paramCheck = threshold;
    }

    public final void setSupportList(List<Support> list) {
        this.supportList = list;
    }

    public final void setUsbTemperature(Threshold threshold) {
        this.usbTemperature = threshold;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.minVersion);
        Long l4 = this.delayDetection;
        if (l4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l4.longValue());
        }
        MsgThreshold msgThreshold = this.earbudsMsg;
        if (msgThreshold == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            msgThreshold.writeToParcel(dest, flags);
        }
        Threshold threshold = this.earTemperature;
        if (threshold == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold.writeToParcel(dest, flags);
        }
        ChargeThreshold chargeThreshold = this.earbudsCharge;
        if (chargeThreshold == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            chargeThreshold.writeToParcel(dest, flags);
        }
        Threshold threshold2 = this.paramCheck;
        if (threshold2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold2.writeToParcel(dest, flags);
        }
        ExceptionThreshold exceptionThreshold = this.exceptions;
        if (exceptionThreshold == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            exceptionThreshold.writeToParcel(dest, flags);
        }
        Threshold threshold3 = this.earbudsRssi;
        if (threshold3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold3.writeToParcel(dest, flags);
        }
        ChargeThreshold chargeThreshold2 = this.earboxCharge;
        if (chargeThreshold2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            chargeThreshold2.writeToParcel(dest, flags);
        }
        Threshold threshold4 = this.boxTemperature;
        if (threshold4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold4.writeToParcel(dest, flags);
        }
        Threshold threshold5 = this.usbTemperature;
        if (threshold5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold5.writeToParcel(dest, flags);
        }
        List<Support> list = this.supportList;
        if (list == null) {
            dest.writeInt(0);
        } else {
            Iterator itG = e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((Support) itG.next()).writeToParcel(dest, flags);
            }
        }
        List<ColorMap> list2 = this.colorList;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            Iterator itG2 = e.g(dest, 1, list2);
            while (itG2.hasNext()) {
                ((ColorMap) itG2.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeStringList(this.micList);
        Threshold threshold6 = this.earChargeExp;
        if (threshold6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold6.writeToParcel(dest, flags);
        }
        Threshold threshold7 = this.earBatDropExp;
        if (threshold7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            threshold7.writeToParcel(dest, flags);
        }
        ChargeHealthThreshold chargeHealthThreshold = this.earHealth;
        if (chargeHealthThreshold == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            chargeHealthThreshold.writeToParcel(dest, flags);
        }
        Integer num = this.batDropLevel;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    public DiagnosisConfigDTO(String str, String str2, int i10, Long l4, MsgThreshold msgThreshold, Threshold threshold, ChargeThreshold chargeThreshold, Threshold threshold2, ExceptionThreshold exceptionThreshold, Threshold threshold3, ChargeThreshold chargeThreshold2, Threshold threshold4, Threshold threshold5, List<Support> list, List<ColorMap> list2, List<String> list3, Threshold threshold6, Threshold threshold7, ChargeHealthThreshold chargeHealthThreshold, Integer num) {
        this.id = str;
        this.name = str2;
        this.minVersion = i10;
        this.delayDetection = l4;
        this.earbudsMsg = msgThreshold;
        this.earTemperature = threshold;
        this.earbudsCharge = chargeThreshold;
        this.paramCheck = threshold2;
        this.exceptions = exceptionThreshold;
        this.earbudsRssi = threshold3;
        this.earboxCharge = chargeThreshold2;
        this.boxTemperature = threshold4;
        this.usbTemperature = threshold5;
        this.supportList = list;
        this.colorList = list2;
        this.micList = list3;
        this.earChargeExp = threshold6;
        this.earBatDropExp = threshold7;
        this.earHealth = chargeHealthThreshold;
        this.batDropLevel = num;
    }

    public /* synthetic */ DiagnosisConfigDTO(String str, String str2, int i10, Long l4, MsgThreshold msgThreshold, Threshold threshold, ChargeThreshold chargeThreshold, Threshold threshold2, ExceptionThreshold exceptionThreshold, Threshold threshold3, ChargeThreshold chargeThreshold2, Threshold threshold4, Threshold threshold5, List list, List list2, List list3, Threshold threshold6, Threshold threshold7, ChargeHealthThreshold chargeHealthThreshold, Integer num, int i11, d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : l4, (i11 & 16) != 0 ? null : msgThreshold, (i11 & 32) != 0 ? null : threshold, (i11 & 64) != 0 ? null : chargeThreshold, (i11 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : threshold2, (i11 & 256) != 0 ? null : exceptionThreshold, (i11 & 512) != 0 ? null : threshold3, (i11 & 1024) != 0 ? null : chargeThreshold2, (i11 & 2048) != 0 ? null : threshold4, (i11 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : threshold5, (i11 & 8192) != 0 ? null : list, (i11 & 16384) != 0 ? null : list2, (i11 & 32768) != 0 ? null : list3, (i11 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? null : threshold6, (i11 & 131072) != 0 ? null : threshold7, (i11 & 262144) != 0 ? null : chargeHealthThreshold, (i11 & 524288) != 0 ? null : num);
    }
}
