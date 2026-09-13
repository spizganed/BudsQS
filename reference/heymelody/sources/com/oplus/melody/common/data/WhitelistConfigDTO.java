package com.oplus.melody.common.data;

import A6.b;
import A6.e;
import Kb.o;
import Wb.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.heytap.headset.HeyMelodyApplication;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0906l;
import com.oplus.melody.common.util.S;
import com.oplus.melody.ui.component.detail.collectlogs.CollectLogsItem;
import com.oplus.melody.ui.component.detail.diagnostic.DiagnosticItem;
import com.oplus.melody.ui.component.detail.finddevice.FindDeviceItem;
import com.oplus.melody.ui.component.detail.fitdetection.FitDetectionItem;
import com.oplus.melody.ui.component.detail.headmotion.HeadMotionItem;
import com.oplus.melody.ui.component.detail.hearingenhancement.HearingEnhancementItem;
import com.oplus.melody.ui.component.detail.vocalenhance.VocalEnhanceSwitchItem;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: WhitelistConfigDTO.kt */
/* JADX INFO: loaded from: classes.dex */
@Parcelize
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\bN\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0010pqrstuvwxyz{|}~\u007fBç\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010S\u001a\u00020\u000fJ\t\u0010T\u001a\u00020\u0004HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010X\u001a\u00020\u0004HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010[\u001a\u00020\u000fHÂ\u0003J\t\u0010\\\u001a\u00020\u000fHÆ\u0003J\t\u0010]\u001a\u00020\u000fHÆ\u0003J\t\u0010^\u001a\u00020\u000fHÆ\u0003J\t\u0010_\u001a\u00020\u000fHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010a\u001a\u00020\u0017HÆ\u0003J\t\u0010b\u001a\u00020\u0017HÆ\u0003J\t\u0010c\u001a\u00020\u000fHÆ\u0003J\t\u0010d\u001a\u00020\u0017HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u000fHÂ\u0003¢\u0006\u0002\u0010fJ\u0017\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dHÆ\u0003Jî\u0001\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0002\u0010iJ\u0006\u0010j\u001a\u00020\u000fJ\u0016\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0012\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0018\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\u001a\u0010\u0019\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00105\"\u0004\bI\u00107R\u001a\u0010\u001a\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\n\n\u0002\u0010N\u0012\u0004\bL\u0010MR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006\u0080\u0001"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "name", "children", "", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$Child;", "brand", SpeechFindManager.TYPE, "uuid", "rssi", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$Rssi;", "minRssi", "", "minVersion", "podsVersion", "opsPodsVersion", "coreFrom", "function", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$Function;", "supportSpp", "", "fuzzyMatchName", "defaultColor", "supportRlmDeviceFunction", "protocolType", "btDelayReport", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/oplus/melody/common/data/WhitelistConfigDTO$Rssi;IIIIILcom/oplus/melody/common/data/WhitelistConfigDTO$Function;ZZIZLjava/lang/Integer;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getBrand", "setBrand", "getType", "setType", "getUuid", "setUuid", "getRssi", "()Lcom/oplus/melody/common/data/WhitelistConfigDTO$Rssi;", "setRssi", "(Lcom/oplus/melody/common/data/WhitelistConfigDTO$Rssi;)V", "getMinVersion", "()I", "setMinVersion", "(I)V", "getPodsVersion", "setPodsVersion", "getOpsPodsVersion", "setOpsPodsVersion", "getCoreFrom", "setCoreFrom", "getFunction", "()Lcom/oplus/melody/common/data/WhitelistConfigDTO$Function;", "setFunction", "(Lcom/oplus/melody/common/data/WhitelistConfigDTO$Function;)V", "getSupportSpp", "()Z", "setSupportSpp", "(Z)V", "getFuzzyMatchName", "setFuzzyMatchName", "getDefaultColor", "setDefaultColor", "getSupportRlmDeviceFunction", "setSupportRlmDeviceFunction", "getProtocolType$annotations", "()V", "Ljava/lang/Integer;", "getBtDelayReport", "()Ljava/util/Map;", "setBtDelayReport", "(Ljava/util/Map;)V", "getMinRssi", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "()Ljava/lang/Integer;", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/oplus/melody/common/data/WhitelistConfigDTO$Rssi;IIIIILcom/oplus/melody/common/data/WhitelistConfigDTO$Function;ZZIZLjava/lang/Integer;Ljava/util/Map;)Lcom/oplus/melody/common/data/WhitelistConfigDTO;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Function", "Rssi", "PersonalNoiseCompat", "AiTranslateCompat", "PromptVolumeRange", "EntryStrModify", "Control", "ControlList", "EqualizerMode", "NoiseReductionMode", "GameMode", "LeFilterFunction", "GameSound", "Child", "MultiConnectFunction", "DressFilter", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WhitelistConfigDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<WhitelistConfigDTO> CREATOR = new a();
    private String brand;
    private Map<String, String> btDelayReport;
    private List<Child> children;
    private int coreFrom;
    private int defaultColor;
    private Function function;
    private boolean fuzzyMatchName;
    private String id;
    private int minRssi;
    private int minVersion;
    private String name;
    private int opsPodsVersion;
    private int podsVersion;
    private Integer protocolType;
    private Rssi rssi;
    private boolean supportRlmDeviceFunction;
    private boolean supportSpp;
    private String type;
    private String uuid;

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$AiTranslateCompat;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "needCheckLeSupport", "", "<init>", "(Z)V", "getNeedCheckLeSupport", "()Z", "setNeedCheckLeSupport", "component1", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AiTranslateCompat extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<AiTranslateCompat> CREATOR = new a();
        private boolean needCheckLeSupport;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<AiTranslateCompat> {
            @Override // android.os.Parcelable.Creator
            public final AiTranslateCompat createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new AiTranslateCompat(parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            public final AiTranslateCompat[] newArray(int i10) {
                return new AiTranslateCompat[i10];
            }
        }

        public AiTranslateCompat() {
            this(false, 1, null);
        }

        public static /* synthetic */ AiTranslateCompat copy$default(AiTranslateCompat aiTranslateCompat, boolean z2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z2 = aiTranslateCompat.needCheckLeSupport;
            }
            return aiTranslateCompat.copy(z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getNeedCheckLeSupport() {
            return this.needCheckLeSupport;
        }

        public final AiTranslateCompat copy(boolean needCheckLeSupport) {
            return new AiTranslateCompat(needCheckLeSupport);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean getNeedCheckLeSupport() {
            return this.needCheckLeSupport;
        }

        public final void setNeedCheckLeSupport(boolean z2) {
            this.needCheckLeSupport = z2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.needCheckLeSupport ? 1 : 0);
        }

        public AiTranslateCompat(boolean z2) {
            this.needCheckLeSupport = z2;
        }

        public /* synthetic */ AiTranslateCompat(boolean z2, int i10, d dVar) {
            this((i10 & 1) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$Child;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "name", "brand", "uuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getBrand", "setBrand", "getUuid", "setUuid", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Child extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Child> CREATOR = new a();
        private String brand;
        private String id;
        private String name;
        private String uuid;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<Child> {
            @Override // android.os.Parcelable.Creator
            public final Child createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Child(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Child[] newArray(int i10) {
                return new Child[i10];
            }
        }

        public Child() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Child copy$default(Child child, String str, String str2, String str3, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = child.id;
            }
            if ((i10 & 2) != 0) {
                str2 = child.name;
            }
            if ((i10 & 4) != 0) {
                str3 = child.brand;
            }
            if ((i10 & 8) != 0) {
                str4 = child.uuid;
            }
            return child.copy(str, str2, str3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        public final Child copy(String id, String name, String brand, String uuid) {
            return new Child(id, name, brand, uuid);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final void setBrand(String str) {
            this.brand = str;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final void setUuid(String str) {
            this.uuid = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.id);
            dest.writeString(this.name);
            dest.writeString(this.brand);
            dest.writeString(this.uuid);
        }

        public Child(String str, String str2, String str3, String str4) {
            this.id = str;
            this.name = str2;
            this.brand = str3;
            this.uuid = str4;
        }

        public /* synthetic */ Child(String str, String str2, String str3, String str4, int i10, d dVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jk\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0006\u00101\u001a\u00020\u0004J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00067"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$Control;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "action", "", "support", "ear", "showEar", "minSelectCount", "defaultFunction", "button", "group", "entryStrModify", "", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$EntryStrModify;", "<init>", "(IIIIIIIILjava/util/List;)V", "getAction", "()I", "setAction", "(I)V", "getSupport", "setSupport", "getEar", "setEar", "getShowEar", "setShowEar", "getMinSelectCount", "setMinSelectCount", "getDefaultFunction", "setDefaultFunction", "getButton", "setButton", "getGroup", "setGroup", "getEntryStrModify", "()Ljava/util/List;", "setEntryStrModify", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Control extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Control> CREATOR = new a();
        private int action;
        private int button;
        private int defaultFunction;
        private int ear;
        private List<EntryStrModify> entryStrModify;
        private int group;
        private int minSelectCount;
        private int showEar;
        private int support;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<Control> {
            @Override // android.os.Parcelable.Creator
            public final Control createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                h.e(parcel, "parcel");
                int i10 = parcel.readInt();
                int i11 = parcel.readInt();
                int i12 = parcel.readInt();
                int i13 = parcel.readInt();
                int i14 = parcel.readInt();
                int i15 = parcel.readInt();
                int i16 = parcel.readInt();
                int i17 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i18 = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(i18);
                    int iB = 0;
                    while (iB != i18) {
                        iB = b.b(EntryStrModify.CREATOR, parcel, arrayList2, iB, 1);
                    }
                    arrayList = arrayList2;
                }
                return new Control(i10, i11, i12, i13, i14, i15, i16, i17, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final Control[] newArray(int i10) {
                return new Control[i10];
            }
        }

        public Control() {
            this(0, 0, 0, 0, 0, 0, 0, 0, null, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Control copy$default(Control control, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List list, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i10 = control.action;
            }
            if ((i18 & 2) != 0) {
                i11 = control.support;
            }
            if ((i18 & 4) != 0) {
                i12 = control.ear;
            }
            if ((i18 & 8) != 0) {
                i13 = control.showEar;
            }
            if ((i18 & 16) != 0) {
                i14 = control.minSelectCount;
            }
            if ((i18 & 32) != 0) {
                i15 = control.defaultFunction;
            }
            if ((i18 & 64) != 0) {
                i16 = control.button;
            }
            if ((i18 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
                i17 = control.group;
            }
            if ((i18 & 256) != 0) {
                list = control.entryStrModify;
            }
            int i19 = i17;
            List list2 = list;
            int i20 = i15;
            int i21 = i16;
            int i22 = i14;
            int i23 = i12;
            return control.copy(i10, i11, i23, i13, i22, i20, i21, i19, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getAction() {
            return this.action;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSupport() {
            return this.support;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEar() {
            return this.ear;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getShowEar() {
            return this.showEar;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getMinSelectCount() {
            return this.minSelectCount;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getDefaultFunction() {
            return this.defaultFunction;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getButton() {
            return this.button;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getGroup() {
            return this.group;
        }

        public final List<EntryStrModify> component9() {
            return this.entryStrModify;
        }

        public final Control copy(int action, int support, int ear, int showEar, int minSelectCount, int defaultFunction, int button, int group, List<EntryStrModify> entryStrModify) {
            return new Control(action, support, ear, showEar, minSelectCount, defaultFunction, button, group, entryStrModify);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getButton() {
            return this.button;
        }

        public final int getDefaultFunction() {
            return this.defaultFunction;
        }

        public final int getEar() {
            return this.ear;
        }

        public final List<EntryStrModify> getEntryStrModify() {
            return this.entryStrModify;
        }

        public final int getGroup() {
            return this.group;
        }

        public final int getMinSelectCount() {
            return this.minSelectCount;
        }

        public final int getShowEar() {
            return this.showEar;
        }

        public final int getSupport() {
            return this.support;
        }

        public final void setAction(int i10) {
            this.action = i10;
        }

        public final void setButton(int i10) {
            this.button = i10;
        }

        public final void setDefaultFunction(int i10) {
            this.defaultFunction = i10;
        }

        public final void setEar(int i10) {
            this.ear = i10;
        }

        public final void setEntryStrModify(List<EntryStrModify> list) {
            this.entryStrModify = list;
        }

        public final void setGroup(int i10) {
            this.group = i10;
        }

        public final void setMinSelectCount(int i10) {
            this.minSelectCount = i10;
        }

        public final void setShowEar(int i10) {
            this.showEar = i10;
        }

        public final void setSupport(int i10) {
            this.support = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.action);
            dest.writeInt(this.support);
            dest.writeInt(this.ear);
            dest.writeInt(this.showEar);
            dest.writeInt(this.minSelectCount);
            dest.writeInt(this.defaultFunction);
            dest.writeInt(this.button);
            dest.writeInt(this.group);
            List<EntryStrModify> list = this.entryStrModify;
            if (list == null) {
                dest.writeInt(0);
                return;
            }
            Iterator itG = e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((EntryStrModify) itG.next()).writeToParcel(dest, flags);
            }
        }

        public Control(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List<EntryStrModify> list) {
            this.action = i10;
            this.support = i11;
            this.ear = i12;
            this.showEar = i13;
            this.minSelectCount = i14;
            this.defaultFunction = i15;
            this.button = i16;
            this.group = i17;
            this.entryStrModify = list;
        }

        public /* synthetic */ Control(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, List list, int i18, d dVar) {
            this((i18 & 1) != 0 ? 0 : i10, (i18 & 2) != 0 ? 0 : i11, (i18 & 4) != 0 ? 0 : i12, (i18 & 8) != 0 ? 0 : i13, (i18 & 16) != 0 ? 0 : i14, (i18 & 32) != 0 ? 0 : i15, (i18 & 64) != 0 ? 0 : i16, (i18 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 0 : i17, (i18 & 256) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J%\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$ControlList;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "version", "", "control", "", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$Control;", "<init>", "(ILjava/util/List;)V", "getVersion", "()I", "setVersion", "(I)V", "getControl", "()Ljava/util/List;", "setControl", "(Ljava/util/List;)V", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ControlList extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<ControlList> CREATOR = new a();
        private List<Control> control;
        private int version;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<ControlList> {
            @Override // android.os.Parcelable.Creator
            public final ControlList createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                h.e(parcel, "parcel");
                int i10 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i11 = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(i11);
                    int iB = 0;
                    while (iB != i11) {
                        iB = b.b(Control.CREATOR, parcel, arrayList2, iB, 1);
                    }
                    arrayList = arrayList2;
                }
                return new ControlList(i10, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            public final ControlList[] newArray(int i10) {
                return new ControlList[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ControlList() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ControlList copy$default(ControlList controlList, int i10, List list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = controlList.version;
            }
            if ((i11 & 2) != 0) {
                list = controlList.control;
            }
            return controlList.copy(i10, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        public final List<Control> component2() {
            return this.control;
        }

        public final ControlList copy(int version, List<Control> control) {
            return new ControlList(version, control);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final List<Control> getControl() {
            return this.control;
        }

        public final int getVersion() {
            return this.version;
        }

        public final void setControl(List<Control> list) {
            this.control = list;
        }

        public final void setVersion(int i10) {
            this.version = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.version);
            List<Control> list = this.control;
            if (list == null) {
                dest.writeInt(0);
                return;
            }
            Iterator itG = e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((Control) itG.next()).writeToParcel(dest, flags);
            }
        }

        public ControlList(int i10, List<Control> list) {
            this.version = i10;
            this.control = list;
        }

        public /* synthetic */ ControlList(int i10, List list, int i11, d dVar) {
            this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$DressFilter;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "dressList", "", "", "modelList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getDressList", "()Ljava/util/List;", "setDressList", "(Ljava/util/List;)V", "getModelList", "setModelList", "component1", "component2", "copy", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class DressFilter extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<DressFilter> CREATOR = new a();
        private List<String> dressList;
        private List<String> modelList;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<DressFilter> {
            @Override // android.os.Parcelable.Creator
            public final DressFilter createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new DressFilter(parcel.createStringArrayList(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            public final DressFilter[] newArray(int i10) {
                return new DressFilter[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DressFilter() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DressFilter copy$default(DressFilter dressFilter, List list, List list2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                list = dressFilter.dressList;
            }
            if ((i10 & 2) != 0) {
                list2 = dressFilter.modelList;
            }
            return dressFilter.copy(list, list2);
        }

        public final List<String> component1() {
            return this.dressList;
        }

        public final List<String> component2() {
            return this.modelList;
        }

        public final DressFilter copy(List<String> dressList, List<String> modelList) {
            return new DressFilter(dressList, modelList);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final List<String> getDressList() {
            return this.dressList;
        }

        public final List<String> getModelList() {
            return this.modelList;
        }

        public final void setDressList(List<String> list) {
            this.dressList = list;
        }

        public final void setModelList(List<String> list) {
            this.modelList = list;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeStringList(this.dressList);
            dest.writeStringList(this.modelList);
        }

        public DressFilter(List<String> list, List<String> list2) {
            this.dressList = list;
            this.modelList = list2;
        }

        public /* synthetic */ DressFilter(List list, List list2, int i10, d dVar) {
            this((i10 & 1) != 0 ? null : list, (i10 & 2) != 0 ? null : list2);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$EntryStrModify;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "targetFunction", "", "summaryVersion", "categoryVersion", "<init>", "(III)V", "getTargetFunction", "()I", "setTargetFunction", "(I)V", "getSummaryVersion", "setSummaryVersion", "getCategoryVersion", "setCategoryVersion", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EntryStrModify extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<EntryStrModify> CREATOR = new a();
        private int categoryVersion;
        private int summaryVersion;
        private int targetFunction;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<EntryStrModify> {
            @Override // android.os.Parcelable.Creator
            public final EntryStrModify createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new EntryStrModify(parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final EntryStrModify[] newArray(int i10) {
                return new EntryStrModify[i10];
            }
        }

        public EntryStrModify() {
            this(0, 0, 0, 7, null);
        }

        public static /* synthetic */ EntryStrModify copy$default(EntryStrModify entryStrModify, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i10 = entryStrModify.targetFunction;
            }
            if ((i13 & 2) != 0) {
                i11 = entryStrModify.summaryVersion;
            }
            if ((i13 & 4) != 0) {
                i12 = entryStrModify.categoryVersion;
            }
            return entryStrModify.copy(i10, i11, i12);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTargetFunction() {
            return this.targetFunction;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSummaryVersion() {
            return this.summaryVersion;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getCategoryVersion() {
            return this.categoryVersion;
        }

        public final EntryStrModify copy(int targetFunction, int summaryVersion, int categoryVersion) {
            return new EntryStrModify(targetFunction, summaryVersion, categoryVersion);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getCategoryVersion() {
            return this.categoryVersion;
        }

        public final int getSummaryVersion() {
            return this.summaryVersion;
        }

        public final int getTargetFunction() {
            return this.targetFunction;
        }

        public final void setCategoryVersion(int i10) {
            this.categoryVersion = i10;
        }

        public final void setSummaryVersion(int i10) {
            this.summaryVersion = i10;
        }

        public final void setTargetFunction(int i10) {
            this.targetFunction = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.targetFunction);
            dest.writeInt(this.summaryVersion);
            dest.writeInt(this.categoryVersion);
        }

        public EntryStrModify(int i10, int i11, int i12) {
            this.targetFunction = i10;
            this.summaryVersion = i11;
            this.categoryVersion = i12;
        }

        public /* synthetic */ EntryStrModify(int i10, int i11, int i12, int i13, d dVar) {
            this((i13 & 1) != 0 ? 0 : i10, (i13 & 2) != 0 ? 0 : i11, (i13 & 4) != 0 ? 0 : i12);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010)\u001a\u00020\u0004J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011¨\u0006/"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$EqualizerMode;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "protocolIndex", "", "modeType", "minFirmVersion", "minAppVersion", "tag", "order", "summaryId", "colorId", "<init>", "(IIIIIIII)V", "getProtocolIndex", "()I", "setProtocolIndex", "(I)V", "getModeType", "setModeType", "getMinFirmVersion", "setMinFirmVersion", "getMinAppVersion", "setMinAppVersion", "getTag", "setTag", "getOrder", "setOrder", "getSummaryId", "setSummaryId", "getColorId", "setColorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class EqualizerMode extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<EqualizerMode> CREATOR = new a();
        private int colorId;
        private int minAppVersion;
        private int minFirmVersion;
        private int modeType;
        private int order;
        private int protocolIndex;
        private int summaryId;
        private int tag;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<EqualizerMode> {
            @Override // android.os.Parcelable.Creator
            public final EqualizerMode createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new EqualizerMode(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final EqualizerMode[] newArray(int i10) {
                return new EqualizerMode[i10];
            }
        }

        public EqualizerMode() {
            this(0, 0, 0, 0, 0, 0, 0, 0, 255, null);
        }

        public static /* synthetic */ EqualizerMode copy$default(EqualizerMode equalizerMode, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i10 = equalizerMode.protocolIndex;
            }
            if ((i18 & 2) != 0) {
                i11 = equalizerMode.modeType;
            }
            if ((i18 & 4) != 0) {
                i12 = equalizerMode.minFirmVersion;
            }
            if ((i18 & 8) != 0) {
                i13 = equalizerMode.minAppVersion;
            }
            if ((i18 & 16) != 0) {
                i14 = equalizerMode.tag;
            }
            if ((i18 & 32) != 0) {
                i15 = equalizerMode.order;
            }
            if ((i18 & 64) != 0) {
                i16 = equalizerMode.summaryId;
            }
            if ((i18 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
                i17 = equalizerMode.colorId;
            }
            int i19 = i16;
            int i20 = i17;
            int i21 = i14;
            int i22 = i15;
            return equalizerMode.copy(i10, i11, i12, i13, i21, i22, i19, i20);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getProtocolIndex() {
            return this.protocolIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getModeType() {
            return this.modeType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getMinAppVersion() {
            return this.minAppVersion;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getTag() {
            return this.tag;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getOrder() {
            return this.order;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getSummaryId() {
            return this.summaryId;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getColorId() {
            return this.colorId;
        }

        public final EqualizerMode copy(int protocolIndex, int modeType, int minFirmVersion, int minAppVersion, int tag, int order, int summaryId, int colorId) {
            return new EqualizerMode(protocolIndex, modeType, minFirmVersion, minAppVersion, tag, order, summaryId, colorId);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getColorId() {
            return this.colorId;
        }

        public final int getMinAppVersion() {
            return this.minAppVersion;
        }

        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        public final int getModeType() {
            return this.modeType;
        }

        public final int getOrder() {
            return this.order;
        }

        public final int getProtocolIndex() {
            return this.protocolIndex;
        }

        public final int getSummaryId() {
            return this.summaryId;
        }

        public final int getTag() {
            return this.tag;
        }

        public final void setColorId(int i10) {
            this.colorId = i10;
        }

        public final void setMinAppVersion(int i10) {
            this.minAppVersion = i10;
        }

        public final void setMinFirmVersion(int i10) {
            this.minFirmVersion = i10;
        }

        public final void setModeType(int i10) {
            this.modeType = i10;
        }

        public final void setOrder(int i10) {
            this.order = i10;
        }

        public final void setProtocolIndex(int i10) {
            this.protocolIndex = i10;
        }

        public final void setSummaryId(int i10) {
            this.summaryId = i10;
        }

        public final void setTag(int i10) {
            this.tag = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.protocolIndex);
            dest.writeInt(this.modeType);
            dest.writeInt(this.minFirmVersion);
            dest.writeInt(this.minAppVersion);
            dest.writeInt(this.tag);
            dest.writeInt(this.order);
            dest.writeInt(this.summaryId);
            dest.writeInt(this.colorId);
        }

        public EqualizerMode(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            this.protocolIndex = i10;
            this.modeType = i11;
            this.minFirmVersion = i12;
            this.minAppVersion = i13;
            this.tag = i14;
            this.order = i15;
            this.summaryId = i16;
            this.colorId = i17;
        }

        public /* synthetic */ EqualizerMode(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, d dVar) {
            this((i18 & 1) != 0 ? 0 : i10, (i18 & 2) != 0 ? 0 : i11, (i18 & 4) != 0 ? 0 : i12, (i18 & 8) != 0 ? 0 : i13, (i18 & 16) != 0 ? 1 : i14, (i18 & 32) != 0 ? 0 : i15, (i18 & 64) != 0 ? 0 : i16, (i18 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 0 : i17);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0003\b\u0097\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B³\u000b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010-\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\"\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"\u0012\b\b\u0002\u00104\u001a\u00020\u0004\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\b\b\u0002\u0010<\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0004\u0012\b\b\u0002\u0010>\u001a\u00020\u0004\u0012\b\b\u0002\u0010?\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\"\u0012\b\b\u0002\u0010B\u001a\u00020\u0004\u0012\b\b\u0002\u0010C\u001a\u00020\u0004\u0012\b\b\u0002\u0010D\u001a\u00020\u0004\u0012\b\b\u0002\u0010E\u001a\u00020\u0004\u0012\b\b\u0002\u0010F\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010H\u001a\u00020\u0004\u0012\b\b\u0002\u0010I\u001a\u00020\u0004\u0012\b\b\u0002\u0010J\u001a\u00020\u0004\u0012\b\b\u0002\u0010K\u001a\u00020\u0004\u0012\b\b\u0002\u0010L\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\"\u0012\b\b\u0002\u0010O\u001a\u00020\u0004\u0012\b\b\u0002\u0010P\u001a\u00020\u0004\u0012\b\b\u0002\u0010Q\u001a\u00020\u0004\u0012\b\b\u0002\u0010R\u001a\u00020\u0004\u0012\b\b\u0002\u0010S\u001a\u00020\u0004\u0012\b\b\u0002\u0010T\u001a\u00020\u0004\u0012\b\b\u0002\u0010U\u001a\u00020\u0004\u0012\b\b\u0002\u0010V\u001a\u00020\u0004\u0012\b\b\u0002\u0010W\u001a\u00020\u0004\u0012\b\b\u0002\u0010X\u001a\u00020\u0004\u0012\b\b\u0002\u0010Y\u001a\u00020\u0004\u0012\b\b\u0002\u0010Z\u001a\u00020\u0004\u0012\b\b\u0002\u0010[\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010]\u001a\u00020\u0004\u0012\b\b\u0002\u0010^\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\"\u0012\b\b\u0002\u0010d\u001a\u00020\u0004\u0012\b\b\u0002\u0010e\u001a\u00020\u0004\u0012\b\b\u0002\u0010f\u001a\u00020\u0004\u0012\b\b\u0002\u0010g\u001a\u00020\u0004\u0012\b\b\u0002\u0010h\u001a\u00020i\u0012\u0010\b\u0002\u0010j\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\"\u0012\b\b\u0002\u0010l\u001a\u00020\u0004\u0012\b\b\u0002\u0010m\u001a\u00020\u0004\u0012\b\b\u0002\u0010n\u001a\u00020\u0004\u0012\b\b\u0002\u0010o\u001a\u00020\u0004\u0012\b\b\u0002\u0010p\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010r\u001a\u00020\u0004\u0012\b\b\u0002\u0010s\u001a\u00020\u0004\u0012\b\b\u0002\u0010t\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010v\u001a\u00020\u0004\u0012\b\b\u0002\u0010w\u001a\u00020\u0004\u0012\b\b\u0002\u0010x\u001a\u00020\u0004\u0012\b\b\u0002\u0010y\u001a\u00020\u0004\u0012\b\b\u0002\u0010z\u001a\u00020\u0004\u0012\b\b\u0002\u0010{\u001a\u00020\u0004\u0012\b\b\u0002\u0010|\u001a\u00020\u0004\u0012\b\b\u0002\u0010}\u001a\u00020\u0004\u0012\b\b\u0002\u0010~\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"\u0012\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u0004\u0012\u0012\b\u0002\u0010\u0085\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\"\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0004\u0012\u0011\b\u0002\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"\u0012\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0004¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0016\u0010\u009a\u0003\u001a\b\u0012\u0004\u0012\u0002010\"2\u0007\u0010\u009b\u0003\u001a\u00020\u0004J\n\u0010\u009c\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010\u009d\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010\u009e\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010\u009f\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010 \u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¡\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¢\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010£\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¤\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¥\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¦\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010§\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¨\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010©\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ª\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010«\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¬\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010\u00ad\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010®\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¯\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010°\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010±\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010²\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010³\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010´\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010µ\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¶\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010·\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¸\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010¹\u0003\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u0012\u0010º\u0003\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u0012\u0010»\u0003\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003J\u0012\u0010¼\u0003\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"HÆ\u0003J\n\u0010½\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¾\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010¿\u0003\u001a\u00020\u0004HÆ\u0003J\f\u0010À\u0003\u001a\u0004\u0018\u00010,HÆ\u0003J\n\u0010Á\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010Â\u0003\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\"HÆ\u0003J\u0012\u0010Ã\u0003\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"HÆ\u0003J\u0012\u0010Ä\u0003\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"HÆ\u0003J\u0012\u0010Å\u0003\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"HÆ\u0003J\n\u0010Æ\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010Ç\u0003\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"HÆ\u0003J\f\u0010È\u0003\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010É\u0003\u001a\u0004\u0018\u000109HÆ\u0003J\u0012\u0010Ê\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"HÆ\u0003J\n\u0010Ë\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ì\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Í\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Î\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ï\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010Ð\u0003\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\"HÆ\u0003J\n\u0010Ñ\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ò\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ó\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ô\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Õ\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010Ö\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"HÆ\u0003J\n\u0010×\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ø\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ù\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Ú\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Û\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010Ü\u0003\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\"HÆ\u0003J\n\u0010Ý\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010Þ\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ß\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010à\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010á\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010â\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ã\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ä\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010å\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010æ\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ç\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010è\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010é\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010ê\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"HÆ\u0003J\n\u0010ë\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ì\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010í\u0003\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"HÆ\u0003J\u0012\u0010î\u0003\u001a\u0004\u0018\u00010\u0004HÂ\u0003¢\u0006\u0003\u0010ï\u0003J\u0012\u0010ð\u0003\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\"HÆ\u0003J\n\u0010ñ\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ò\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ó\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ô\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010õ\u0003\u001a\u00020iHÆ\u0003J\u0012\u0010ö\u0003\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\"HÆ\u0003J\n\u0010÷\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ø\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ù\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ú\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010û\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010ü\u0003\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"HÆ\u0003J\n\u0010ý\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010þ\u0003\u001a\u00020\u0004HÆ\u0003J\n\u0010ÿ\u0003\u001a\u00020\u0004HÆ\u0003J\u0012\u0010\u0080\u0004\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"HÆ\u0003J\n\u0010\u0081\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0082\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0083\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0084\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0085\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0086\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0087\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0088\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0089\u0004\u001a\u00020\u0004HÆ\u0003J\u0012\u0010\u008a\u0004\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"HÆ\u0003J\n\u0010\u008b\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008c\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008d\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008e\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u008f\u0004\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0090\u0004\u001a\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\"HÆ\u0003J\n\u0010\u0091\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0092\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0093\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0094\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0095\u0004\u001a\u00020\u0004HÆ\u0003J\u0012\u0010\u0096\u0004\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"HÆ\u0003J\n\u0010\u0097\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0098\u0004\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0099\u0004\u001a\u00020\u0004HÆ\u0003Jº\u000b\u0010\u009a\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010-\u001a\u00020\u00042\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\"2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"2\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"2\b\b\u0002\u00104\u001a\u00020\u00042\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"2\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010>\u001a\u00020\u00042\b\b\u0002\u0010?\u001a\u00020\u00042\u0010\b\u0002\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\"2\b\b\u0002\u0010B\u001a\u00020\u00042\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010D\u001a\u00020\u00042\b\b\u0002\u0010E\u001a\u00020\u00042\b\b\u0002\u0010F\u001a\u00020\u00042\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\b\u0002\u0010H\u001a\u00020\u00042\b\b\u0002\u0010I\u001a\u00020\u00042\b\b\u0002\u0010J\u001a\u00020\u00042\b\b\u0002\u0010K\u001a\u00020\u00042\b\b\u0002\u0010L\u001a\u00020\u00042\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\"2\b\b\u0002\u0010O\u001a\u00020\u00042\b\b\u0002\u0010P\u001a\u00020\u00042\b\b\u0002\u0010Q\u001a\u00020\u00042\b\b\u0002\u0010R\u001a\u00020\u00042\b\b\u0002\u0010S\u001a\u00020\u00042\b\b\u0002\u0010T\u001a\u00020\u00042\b\b\u0002\u0010U\u001a\u00020\u00042\b\b\u0002\u0010V\u001a\u00020\u00042\b\b\u0002\u0010W\u001a\u00020\u00042\b\b\u0002\u0010X\u001a\u00020\u00042\b\b\u0002\u0010Y\u001a\u00020\u00042\b\b\u0002\u0010Z\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u00042\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\b\u0002\u0010]\u001a\u00020\u00042\b\b\u0002\u0010^\u001a\u00020\u00042\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\"2\b\b\u0002\u0010d\u001a\u00020\u00042\b\b\u0002\u0010e\u001a\u00020\u00042\b\b\u0002\u0010f\u001a\u00020\u00042\b\b\u0002\u0010g\u001a\u00020\u00042\b\b\u0002\u0010h\u001a\u00020i2\u0010\b\u0002\u0010j\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\"2\b\b\u0002\u0010l\u001a\u00020\u00042\b\b\u0002\u0010m\u001a\u00020\u00042\b\b\u0002\u0010n\u001a\u00020\u00042\b\b\u0002\u0010o\u001a\u00020\u00042\b\b\u0002\u0010p\u001a\u00020\u00042\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\b\u0002\u0010r\u001a\u00020\u00042\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u00042\u0010\b\u0002\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\b\b\u0002\u0010v\u001a\u00020\u00042\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u00042\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u00020\u00042\b\b\u0002\u0010{\u001a\u00020\u00042\b\b\u0002\u0010|\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020\u00042\b\b\u0002\u0010~\u001a\u00020\u00042\u0010\b\u0002\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u00042\u0012\b\u0002\u0010\u0085\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\"2\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u00042\u0011\b\u0002\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"2\t\b\u0002\u0010\u008d\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0004HÆ\u0001¢\u0006\u0003\u0010\u009b\u0004J\u0007\u0010\u009c\u0004\u001a\u00020\u0004J\u001b\u0010\u009d\u0004\u001a\u00030\u009e\u00042\b\u0010\u009f\u0004\u001a\u00030 \u00042\u0007\u0010¡\u0004\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001e\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0093\u0001\"\u0006\b\u0097\u0001\u0010\u0095\u0001R\u001e\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0093\u0001\"\u0006\b\u0099\u0001\u0010\u0095\u0001R\u001e\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u0093\u0001\"\u0006\b\u009b\u0001\u0010\u0095\u0001R\u001e\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u0093\u0001\"\u0006\b\u009d\u0001\u0010\u0095\u0001R\u001e\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u0093\u0001\"\u0006\b\u009f\u0001\u0010\u0095\u0001R\u001e\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010\u0093\u0001\"\u0006\b¡\u0001\u0010\u0095\u0001R\u001e\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0001\u0010\u0093\u0001\"\u0006\b£\u0001\u0010\u0095\u0001R\u001e\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0001\u0010\u0093\u0001\"\u0006\b¥\u0001\u0010\u0095\u0001R\u001e\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010\u0093\u0001\"\u0006\b§\u0001\u0010\u0095\u0001R*\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010\u0093\u0001\"\u0006\b«\u0001\u0010\u0095\u0001R\u001e\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u0093\u0001\"\u0006\b\u00ad\u0001\u0010\u0095\u0001R\u001e\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010\u0093\u0001\"\u0006\b¯\u0001\u0010\u0095\u0001R\u001e\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010\u0093\u0001\"\u0006\b±\u0001\u0010\u0095\u0001R\u001e\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010\u0093\u0001\"\u0006\b³\u0001\u0010\u0095\u0001R\u001e\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010\u0093\u0001\"\u0006\bµ\u0001\u0010\u0095\u0001R\u001e\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010\u0093\u0001\"\u0006\b·\u0001\u0010\u0095\u0001R\u001e\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010\u0093\u0001\"\u0006\b¹\u0001\u0010\u0095\u0001R\u001e\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010\u0093\u0001\"\u0006\b»\u0001\u0010\u0095\u0001R\u001e\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0001\u0010\u0093\u0001\"\u0006\b½\u0001\u0010\u0095\u0001R\u001e\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0001\u0010\u0093\u0001\"\u0006\b¿\u0001\u0010\u0095\u0001R\u001e\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010\u0093\u0001\"\u0006\bÁ\u0001\u0010\u0095\u0001R\u001e\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÂ\u0001\u0010\u0093\u0001\"\u0006\bÃ\u0001\u0010\u0095\u0001R\u001e\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0093\u0001\"\u0006\bÅ\u0001\u0010\u0095\u0001R\u001e\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010\u0093\u0001\"\u0006\bÇ\u0001\u0010\u0095\u0001R\u001e\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0001\u0010\u0093\u0001\"\u0006\bÉ\u0001\u0010\u0095\u0001R\u001e\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0093\u0001\"\u0006\bË\u0001\u0010\u0095\u0001R\u001e\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010\u0093\u0001\"\u0006\bÍ\u0001\u0010\u0095\u0001R\u001e\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0001\u0010\u0093\u0001\"\u0006\bÏ\u0001\u0010\u0095\u0001R&\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0006\bÒ\u0001\u0010Ó\u0001R&\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÔ\u0001\u0010Ñ\u0001\"\u0006\bÕ\u0001\u0010Ó\u0001R&\u0010%\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0001\u0010Ñ\u0001\"\u0006\b×\u0001\u0010Ó\u0001R&\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bØ\u0001\u0010Ñ\u0001\"\u0006\bÙ\u0001\u0010Ó\u0001R\u001e\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÚ\u0001\u0010\u0093\u0001\"\u0006\bÛ\u0001\u0010\u0095\u0001R\u001e\u0010)\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÜ\u0001\u0010\u0093\u0001\"\u0006\bÝ\u0001\u0010\u0095\u0001R\u001e\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0001\u0010\u0093\u0001\"\u0006\bß\u0001\u0010\u0095\u0001R \u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bà\u0001\u0010á\u0001\"\u0006\bâ\u0001\u0010ã\u0001R\u001e\u0010-\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bä\u0001\u0010\u0093\u0001\"\u0006\bå\u0001\u0010\u0095\u0001R&\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0001\u0010Ñ\u0001\"\u0006\bç\u0001\u0010Ó\u0001R&\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bè\u0001\u0010Ñ\u0001\"\u0006\bé\u0001\u0010Ó\u0001R&\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0001\u0010Ñ\u0001\"\u0006\bë\u0001\u0010Ó\u0001R&\u00103\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bì\u0001\u0010Ñ\u0001\"\u0006\bí\u0001\u0010Ó\u0001R\u001e\u00104\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bî\u0001\u0010\u0093\u0001\"\u0006\bï\u0001\u0010\u0095\u0001R&\u00105\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bð\u0001\u0010Ñ\u0001\"\u0006\bñ\u0001\u0010Ó\u0001R \u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R \u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bö\u0001\u0010÷\u0001\"\u0006\bø\u0001\u0010ù\u0001R&\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bú\u0001\u0010Ñ\u0001\"\u0006\bû\u0001\u0010Ó\u0001R\u001e\u0010;\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0001\u0010\u0093\u0001\"\u0006\bý\u0001\u0010\u0095\u0001R\u001e\u0010<\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010\u0093\u0001\"\u0006\bÿ\u0001\u0010\u0095\u0001R\u001e\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0002\u0010\u0093\u0001\"\u0006\b\u0081\u0002\u0010\u0095\u0001R\u001e\u0010>\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0002\u0010\u0093\u0001\"\u0006\b\u0083\u0002\u0010\u0095\u0001R\u001e\u0010?\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0093\u0001\"\u0006\b\u0085\u0002\u0010\u0095\u0001R&\u0010@\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0002\u0010Ñ\u0001\"\u0006\b\u0087\u0002\u0010Ó\u0001R\u001e\u0010B\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0002\u0010\u0093\u0001\"\u0006\b\u0089\u0002\u0010\u0095\u0001R\u001e\u0010C\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u0093\u0001\"\u0006\b\u008b\u0002\u0010\u0095\u0001R\u001e\u0010D\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0002\u0010\u0093\u0001\"\u0006\b\u008d\u0002\u0010\u0095\u0001R\u001e\u0010E\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0002\u0010\u0093\u0001\"\u0006\b\u008f\u0002\u0010\u0095\u0001R\u001e\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0002\u0010\u0093\u0001\"\u0006\b\u0091\u0002\u0010\u0095\u0001R&\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0002\u0010Ñ\u0001\"\u0006\b\u0093\u0002\u0010Ó\u0001R\u001e\u0010H\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0002\u0010\u0093\u0001\"\u0006\b\u0095\u0002\u0010\u0095\u0001R\u001e\u0010I\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0002\u0010\u0093\u0001\"\u0006\b\u0097\u0002\u0010\u0095\u0001R\u001e\u0010J\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0002\u0010\u0093\u0001\"\u0006\b\u0099\u0002\u0010\u0095\u0001R\u001e\u0010K\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0002\u0010\u0093\u0001\"\u0006\b\u009b\u0002\u0010\u0095\u0001R\u001e\u0010L\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009c\u0002\u0010\u0093\u0001\"\u0006\b\u009d\u0002\u0010\u0095\u0001R&\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0002\u0010Ñ\u0001\"\u0006\b\u009f\u0002\u0010Ó\u0001R\u001e\u0010O\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0002\u0010\u0093\u0001\"\u0006\b¡\u0002\u0010\u0095\u0001R\u001e\u0010P\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0002\u0010\u0093\u0001\"\u0006\b£\u0002\u0010\u0095\u0001R\u001e\u0010Q\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¤\u0002\u0010\u0093\u0001\"\u0006\b¥\u0002\u0010\u0095\u0001R\u001e\u0010R\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0002\u0010\u0093\u0001\"\u0006\b§\u0002\u0010\u0095\u0001R\u001e\u0010S\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0002\u0010\u0093\u0001\"\u0006\b©\u0002\u0010\u0095\u0001R\u001e\u0010T\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0002\u0010\u0093\u0001\"\u0006\b«\u0002\u0010\u0095\u0001R\u001e\u0010U\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0002\u0010\u0093\u0001\"\u0006\b\u00ad\u0002\u0010\u0095\u0001R\u001e\u0010V\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0002\u0010\u0093\u0001\"\u0006\b¯\u0002\u0010\u0095\u0001R\u001e\u0010W\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0002\u0010\u0093\u0001\"\u0006\b±\u0002\u0010\u0095\u0001R\u001e\u0010X\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0002\u0010\u0093\u0001\"\u0006\b³\u0002\u0010\u0095\u0001R\u001e\u0010Y\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0002\u0010\u0093\u0001\"\u0006\bµ\u0002\u0010\u0095\u0001R\u001e\u0010Z\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0002\u0010\u0093\u0001\"\u0006\b·\u0002\u0010\u0095\u0001R\u001e\u0010[\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0002\u0010\u0093\u0001\"\u0006\b¹\u0002\u0010\u0095\u0001R&\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0002\u0010Ñ\u0001\"\u0006\b»\u0002\u0010Ó\u0001R\u001e\u0010]\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¼\u0002\u0010\u0093\u0001\"\u0006\b½\u0002\u0010\u0095\u0001R\u001e\u0010^\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0002\u0010\u0093\u0001\"\u0006\b¿\u0002\u0010\u0095\u0001R&\u0010_\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0002\u0010Ñ\u0001\"\u0006\bÁ\u0002\u0010Ó\u0001R\u001f\u0010a\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\r\n\u0003\u0010Ã\u0002\u0012\u0006\bÂ\u0002\u0010©\u0001R&\u0010b\u001a\n\u0012\u0004\u0012\u00020c\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0002\u0010Ñ\u0001\"\u0006\bÅ\u0002\u0010Ó\u0001R\u001e\u0010d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0002\u0010\u0093\u0001\"\u0006\bÇ\u0002\u0010\u0095\u0001R\u001e\u0010e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÈ\u0002\u0010\u0093\u0001\"\u0006\bÉ\u0002\u0010\u0095\u0001R\u001e\u0010f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0002\u0010\u0093\u0001\"\u0006\bË\u0002\u0010\u0095\u0001R\u001e\u0010g\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0002\u0010\u0093\u0001\"\u0006\bÍ\u0002\u0010\u0095\u0001R\u001e\u0010h\u001a\u00020iX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0002\u0010Ï\u0002\"\u0006\bÐ\u0002\u0010Ñ\u0002R&\u0010j\u001a\n\u0012\u0004\u0012\u00020k\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÒ\u0002\u0010Ñ\u0001\"\u0006\bÓ\u0002\u0010Ó\u0001R\u001e\u0010l\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÔ\u0002\u0010\u0093\u0001\"\u0006\bÕ\u0002\u0010\u0095\u0001R\u001e\u0010m\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÖ\u0002\u0010\u0093\u0001\"\u0006\b×\u0002\u0010\u0095\u0001R\u001e\u0010n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bØ\u0002\u0010\u0093\u0001\"\u0006\bÙ\u0002\u0010\u0095\u0001R\u001e\u0010o\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÚ\u0002\u0010\u0093\u0001\"\u0006\bÛ\u0002\u0010\u0095\u0001R\u001e\u0010p\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÜ\u0002\u0010\u0093\u0001\"\u0006\bÝ\u0002\u0010\u0095\u0001R&\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÞ\u0002\u0010Ñ\u0001\"\u0006\bß\u0002\u0010Ó\u0001R\u001e\u0010r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bà\u0002\u0010\u0093\u0001\"\u0006\bá\u0002\u0010\u0095\u0001R\u001e\u0010s\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bâ\u0002\u0010\u0093\u0001\"\u0006\bã\u0002\u0010\u0095\u0001R\u001e\u0010t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bä\u0002\u0010\u0093\u0001\"\u0006\bå\u0002\u0010\u0095\u0001R&\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0002\u0010Ñ\u0001\"\u0006\bç\u0002\u0010Ó\u0001R\u001e\u0010v\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bè\u0002\u0010\u0093\u0001\"\u0006\bé\u0002\u0010\u0095\u0001R\u001e\u0010w\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0002\u0010\u0093\u0001\"\u0006\bë\u0002\u0010\u0095\u0001R\u001e\u0010x\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bì\u0002\u0010\u0093\u0001\"\u0006\bí\u0002\u0010\u0095\u0001R\u001e\u0010y\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bî\u0002\u0010\u0093\u0001\"\u0006\bï\u0002\u0010\u0095\u0001R\u001e\u0010z\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bð\u0002\u0010\u0093\u0001\"\u0006\bñ\u0002\u0010\u0095\u0001R\u001e\u0010{\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0002\u0010\u0093\u0001\"\u0006\bó\u0002\u0010\u0095\u0001R\u001e\u0010|\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0002\u0010\u0093\u0001\"\u0006\bõ\u0002\u0010\u0095\u0001R\u001e\u0010}\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bö\u0002\u0010\u0093\u0001\"\u0006\b÷\u0002\u0010\u0095\u0001R\u001e\u0010~\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bø\u0002\u0010\u0093\u0001\"\u0006\bù\u0002\u0010\u0095\u0001R&\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bú\u0002\u0010Ñ\u0001\"\u0006\bû\u0002\u0010Ó\u0001R\u001f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0002\u0010\u0093\u0001\"\u0006\bý\u0002\u0010\u0095\u0001R\u001f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0002\u0010\u0093\u0001\"\u0006\bÿ\u0002\u0010\u0095\u0001R\u001f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0003\u0010\u0093\u0001\"\u0006\b\u0081\u0003\u0010\u0095\u0001R\u001f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0003\u0010\u0093\u0001\"\u0006\b\u0083\u0003\u0010\u0095\u0001R\u001f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0003\u0010\u0093\u0001\"\u0006\b\u0085\u0003\u0010\u0095\u0001R(\u0010\u0085\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0086\u0001\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0003\u0010Ñ\u0001\"\u0006\b\u0087\u0003\u0010Ó\u0001R\u001f\u0010\u0087\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0003\u0010\u0093\u0001\"\u0006\b\u0089\u0003\u0010\u0095\u0001R\u001f\u0010\u0088\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0003\u0010\u0093\u0001\"\u0006\b\u008b\u0003\u0010\u0095\u0001R\u001f\u0010\u0089\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0003\u0010\u0093\u0001\"\u0006\b\u008d\u0003\u0010\u0095\u0001R\u001f\u0010\u008a\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0003\u0010\u0093\u0001\"\u0006\b\u008f\u0003\u0010\u0095\u0001R\u001f\u0010\u008b\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0003\u0010\u0093\u0001\"\u0006\b\u0091\u0003\u0010\u0095\u0001R'\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010\"X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0003\u0010Ñ\u0001\"\u0006\b\u0093\u0003\u0010Ó\u0001R\u001f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0094\u0003\u0010\u0093\u0001\"\u0006\b\u0095\u0003\u0010\u0095\u0001R\u001f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0096\u0003\u0010\u0093\u0001\"\u0006\b\u0097\u0003\u0010\u0095\u0001R\u001f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0003\u0010\u0093\u0001\"\u0006\b\u0099\u0003\u0010\u0095\u0001¨\u0006¢\u0004"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$Function;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "opsReduction", "", "zenMode", "batteryInfo", "heyMelodyDownload", "batteryRadix", "equalizer", "customEqualizer", "customEqMax", FindDeviceItem.ITEM_NAME, HeadMotionItem.ITEM_NAME, "heyFindDevice", "dolbyAtmos", FitDetectionItem.ITEM_NAME, "autoFirmwareUpdate", "wearDetection", "inBoxStatus", "clickTakePic", "clickTakePicNew", "headSetSoundRecord", "immersiveRecord", VocalEnhanceSwitchItem.ITEM_NAME, "personalNoise", "functionGuide", "fastDiscovery", "firmwareDiscovery", "openBoxPairing", "holdInBoxPairing", "pairingModeTip", "hideFromUIList", "control", "", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$Control;", "callControl", "musicControl", "controlList", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$ControlList;", "firmwareCheckCommandId", "firmwareFileCheckFlags", "promptVolume", "promptVolumeRange", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$PromptVolumeRange;", "noiseReductionUIVersion", "noiseReductionMode", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$NoiseReductionMode;", "equalizerMode", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$EqualizerMode;", "equalizerModeCompat", "equalizerModeByColor", "longPressType", "equalizerModeByVersion", "personalNoiseCompat", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$PersonalNoiseCompat;", "aiTranslateCompat", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$AiTranslateCompat;", "introductionGuideList", HearingEnhancementItem.ITEM_NAME, "hearingEnhancementNew", "hearingJudgeDb", "earScan", "multiDevicesConnect", "multiConnectFunctions", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$MultiConnectFunction;", "smartCall", "highToneQuality", "highAudio", "voiceWake", "voiceCommand", "voiceCommandItems", "incomingCallControl", "longPowerMode", "deviceLostRemind", "related", "gameMode", "gameModeList", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$GameMode;", CollectLogsItem.ITEM_NAME, "controlGuideSupport", "controlAutoVolumeSupport", "longPressVolume", "tapLevelSetting", DiagnosticItem.ITEM_NAME, "aiSummary", "aiSummaryToneSource", "aiClearCall", "aiTranslate", "functionIntroductionGuide", "bassEngineSupport", "spineHealth", "spatialTypes", "spatialVip", "supportPinch", "gameEqPkgList", "", "gameEqualizer", "gameSoundList", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$GameSound;", "rlmMoreFunction", "autoSwitchLink", "autoBTBond", "feedback", "showTurnAutoSwitchOnDialog", "", "leFilterFunctions", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$LeFilterFunction;", "customDress", "carouselDress", "spatialDescriptionType", "minOtaBattery", "spatialHiResMutex", "gameSoundMutexes", "cleanGuide", "honorWall", "strongNoiseReductionRealTime", "dialogTags", "tutorialGuide", "wearingVideoTutorial", "adaptiveVolume", "adaptiveEar", "speechPerception", "firmwareTrack", "meetingAssistant", "spatialEarphoneFirst", "defaultSoundChannelSwitchOn", "customEqFrequency", "spyTap", "swiftPair", "hearingOptimize", "customEqUiVersion", "appUpdateRemindVersion", "dressFilterList", "Lcom/oplus/melody/common/data/WhitelistConfigDTO$DressFilter;", "whiteNoise", "sleepDetection", "deviceInfo", "upgradeMtu", "brLeCoexist", "mutexFunctions", "pairingInBoxCount", "newFunctionGuide", "headsetFeedback", "<init>", "(IIIIIIIIIIIIIIIIIIIIIIIIIIIIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIILcom/oplus/melody/common/data/WhitelistConfigDTO$PromptVolumeRange;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/util/List;Lcom/oplus/melody/common/data/WhitelistConfigDTO$PersonalNoiseCompat;Lcom/oplus/melody/common/data/WhitelistConfigDTO$AiTranslateCompat;Ljava/util/List;IIIIILjava/util/List;IIIIILjava/util/List;IIIIILjava/util/List;IIIIIIIIIIIIILjava/util/List;IILjava/util/List;Ljava/lang/Integer;Ljava/util/List;IIIIZLjava/util/List;IIIIILjava/util/List;IIILjava/util/List;IIIIIIIIILjava/util/List;IIIIILjava/util/List;IIIIILjava/util/List;III)V", "getOpsReduction", "()I", "setOpsReduction", "(I)V", "getZenMode", "setZenMode", "getBatteryInfo", "setBatteryInfo", "getHeyMelodyDownload", "setHeyMelodyDownload", "getBatteryRadix", "setBatteryRadix", "getEqualizer", "setEqualizer", "getCustomEqualizer", "setCustomEqualizer", "getCustomEqMax", "setCustomEqMax", "getFindDevice", "setFindDevice", "getHeadMotion", "setHeadMotion", "getHeyFindDevice$annotations", "()V", "getHeyFindDevice", "setHeyFindDevice", "getDolbyAtmos", "setDolbyAtmos", "getFitDetection", "setFitDetection", "getAutoFirmwareUpdate", "setAutoFirmwareUpdate", "getWearDetection", "setWearDetection", "getInBoxStatus", "setInBoxStatus", "getClickTakePic", "setClickTakePic", "getClickTakePicNew", "setClickTakePicNew", "getHeadSetSoundRecord", "setHeadSetSoundRecord", "getImmersiveRecord", "setImmersiveRecord", "getVocalEnhance", "setVocalEnhance", "getPersonalNoise", "setPersonalNoise", "getFunctionGuide", "setFunctionGuide", "getFastDiscovery", "setFastDiscovery", "getFirmwareDiscovery", "setFirmwareDiscovery", "getOpenBoxPairing", "setOpenBoxPairing", "getHoldInBoxPairing", "setHoldInBoxPairing", "getPairingModeTip", "setPairingModeTip", "getHideFromUIList", "setHideFromUIList", "getControl", "()Ljava/util/List;", "setControl", "(Ljava/util/List;)V", "getCallControl", "setCallControl", "getMusicControl", "setMusicControl", "getControlList", "setControlList", "getFirmwareCheckCommandId", "setFirmwareCheckCommandId", "getFirmwareFileCheckFlags", "setFirmwareFileCheckFlags", "getPromptVolume", "setPromptVolume", "getPromptVolumeRange", "()Lcom/oplus/melody/common/data/WhitelistConfigDTO$PromptVolumeRange;", "setPromptVolumeRange", "(Lcom/oplus/melody/common/data/WhitelistConfigDTO$PromptVolumeRange;)V", "getNoiseReductionUIVersion", "setNoiseReductionUIVersion", "getNoiseReductionMode", "setNoiseReductionMode", "getEqualizerMode", "setEqualizerMode", "getEqualizerModeCompat", "setEqualizerModeCompat", "getEqualizerModeByColor", "setEqualizerModeByColor", "getLongPressType", "setLongPressType", "getEqualizerModeByVersion", "setEqualizerModeByVersion", "getPersonalNoiseCompat", "()Lcom/oplus/melody/common/data/WhitelistConfigDTO$PersonalNoiseCompat;", "setPersonalNoiseCompat", "(Lcom/oplus/melody/common/data/WhitelistConfigDTO$PersonalNoiseCompat;)V", "getAiTranslateCompat", "()Lcom/oplus/melody/common/data/WhitelistConfigDTO$AiTranslateCompat;", "setAiTranslateCompat", "(Lcom/oplus/melody/common/data/WhitelistConfigDTO$AiTranslateCompat;)V", "getIntroductionGuideList", "setIntroductionGuideList", "getHearingEnhancement", "setHearingEnhancement", "getHearingEnhancementNew", "setHearingEnhancementNew", "getHearingJudgeDb", "setHearingJudgeDb", "getEarScan", "setEarScan", "getMultiDevicesConnect", "setMultiDevicesConnect", "getMultiConnectFunctions", "setMultiConnectFunctions", "getSmartCall", "setSmartCall", "getHighToneQuality", "setHighToneQuality", "getHighAudio", "setHighAudio", "getVoiceWake", "setVoiceWake", "getVoiceCommand", "setVoiceCommand", "getVoiceCommandItems", "setVoiceCommandItems", "getIncomingCallControl", "setIncomingCallControl", "getLongPowerMode", "setLongPowerMode", "getDeviceLostRemind", "setDeviceLostRemind", "getRelated", "setRelated", "getGameMode", "setGameMode", "getGameModeList", "setGameModeList", "getCollectLogs", "setCollectLogs", "getControlGuideSupport", "setControlGuideSupport", "getControlAutoVolumeSupport", "setControlAutoVolumeSupport", "getLongPressVolume", "setLongPressVolume", "getTapLevelSetting", "setTapLevelSetting", "getDiagnostic", "setDiagnostic", "getAiSummary", "setAiSummary", "getAiSummaryToneSource", "setAiSummaryToneSource", "getAiClearCall", "setAiClearCall", "getAiTranslate", "setAiTranslate", "getFunctionIntroductionGuide", "setFunctionIntroductionGuide", "getBassEngineSupport", "setBassEngineSupport", "getSpineHealth", "setSpineHealth", "getSpatialTypes", "setSpatialTypes", "getSpatialVip", "setSpatialVip", "getSupportPinch", "setSupportPinch", "getGameEqPkgList", "setGameEqPkgList", "getGameEqualizer$annotations", "Ljava/lang/Integer;", "getGameSoundList", "setGameSoundList", "getRlmMoreFunction", "setRlmMoreFunction", "getAutoSwitchLink", "setAutoSwitchLink", "getAutoBTBond", "setAutoBTBond", "getFeedback", "setFeedback", "getShowTurnAutoSwitchOnDialog", "()Z", "setShowTurnAutoSwitchOnDialog", "(Z)V", "getLeFilterFunctions", "setLeFilterFunctions", "getCustomDress", "setCustomDress", "getCarouselDress", "setCarouselDress", "getSpatialDescriptionType", "setSpatialDescriptionType", "getMinOtaBattery", "setMinOtaBattery", "getSpatialHiResMutex", "setSpatialHiResMutex", "getGameSoundMutexes", "setGameSoundMutexes", "getCleanGuide", "setCleanGuide", "getHonorWall", "setHonorWall", "getStrongNoiseReductionRealTime", "setStrongNoiseReductionRealTime", "getDialogTags", "setDialogTags", "getTutorialGuide", "setTutorialGuide", "getWearingVideoTutorial", "setWearingVideoTutorial", "getAdaptiveVolume", "setAdaptiveVolume", "getAdaptiveEar", "setAdaptiveEar", "getSpeechPerception", "setSpeechPerception", "getFirmwareTrack", "setFirmwareTrack", "getMeetingAssistant", "setMeetingAssistant", "getSpatialEarphoneFirst", "setSpatialEarphoneFirst", "getDefaultSoundChannelSwitchOn", "setDefaultSoundChannelSwitchOn", "getCustomEqFrequency", "setCustomEqFrequency", "getSpyTap", "setSpyTap", "getSwiftPair", "setSwiftPair", "getHearingOptimize", "setHearingOptimize", "getCustomEqUiVersion", "setCustomEqUiVersion", "getAppUpdateRemindVersion", "setAppUpdateRemindVersion", "getDressFilterList", "setDressFilterList", "getWhiteNoise", "setWhiteNoise", "getSleepDetection", "setSleepDetection", "getDeviceInfo", "setDeviceInfo", "getUpgradeMtu", "setUpgradeMtu", "getBrLeCoexist", "setBrLeCoexist", "getMutexFunctions", "setMutexFunctions", "getPairingInBoxCount", "setPairingInBoxCount", "getNewFunctionGuide", "setNewFunctionGuide", "getHeadsetFeedback", "setHeadsetFeedback", "getEqualizerModeByColorId", "colorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "()Ljava/lang/Integer;", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "component97", "component98", "component99", "component100", "component101", "component102", "component103", "component104", "component105", "component106", "component107", "component108", "component109", "component110", "component111", "component112", "component113", "component114", "component115", "component116", "component117", "component118", "component119", "component120", "component121", "component122", "component123", "component124", "component125", "copy", "(IIIIIIIIIIIIIIIIIIIIIIIIIIIIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIILcom/oplus/melody/common/data/WhitelistConfigDTO$PromptVolumeRange;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/util/List;Lcom/oplus/melody/common/data/WhitelistConfigDTO$PersonalNoiseCompat;Lcom/oplus/melody/common/data/WhitelistConfigDTO$AiTranslateCompat;Ljava/util/List;IIIIILjava/util/List;IIIIILjava/util/List;IIIIILjava/util/List;IIIIIIIIIIIIILjava/util/List;IILjava/util/List;Ljava/lang/Integer;Ljava/util/List;IIIIZLjava/util/List;IIIIILjava/util/List;IIILjava/util/List;IIIIIIIIILjava/util/List;IIIIILjava/util/List;IIIIILjava/util/List;III)Lcom/oplus/melody/common/data/WhitelistConfigDTO$Function;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Function extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Function> CREATOR = new a();
        private int adaptiveEar;
        private int adaptiveVolume;
        private int aiClearCall;
        private int aiSummary;
        private int aiSummaryToneSource;
        private int aiTranslate;
        private AiTranslateCompat aiTranslateCompat;
        private int appUpdateRemindVersion;
        private int autoBTBond;
        private int autoFirmwareUpdate;
        private int autoSwitchLink;
        private int bassEngineSupport;
        private int batteryInfo;
        private int batteryRadix;
        private int brLeCoexist;
        private List<Control> callControl;
        private int carouselDress;
        private int cleanGuide;
        private int clickTakePic;
        private int clickTakePicNew;
        private int collectLogs;
        private List<Control> control;
        private int controlAutoVolumeSupport;
        private int controlGuideSupport;
        private List<ControlList> controlList;
        private int customDress;
        private List<Integer> customEqFrequency;
        private int customEqMax;
        private int customEqUiVersion;
        private int customEqualizer;
        private int defaultSoundChannelSwitchOn;
        private int deviceInfo;
        private int deviceLostRemind;
        private int diagnostic;
        private List<Integer> dialogTags;
        private int dolbyAtmos;
        private List<DressFilter> dressFilterList;
        private int earScan;
        private int equalizer;
        private List<EqualizerMode> equalizerMode;
        private List<EqualizerMode> equalizerModeByColor;
        private List<EqualizerMode> equalizerModeByVersion;
        private List<EqualizerMode> equalizerModeCompat;
        private int fastDiscovery;
        private int feedback;
        private int findDevice;
        private int firmwareCheckCommandId;
        private int firmwareDiscovery;
        private int firmwareFileCheckFlags;
        private int firmwareTrack;
        private int fitDetection;
        private int functionGuide;
        private int functionIntroductionGuide;
        private List<String> gameEqPkgList;
        private Integer gameEqualizer;
        private int gameMode;
        private List<GameMode> gameModeList;
        private List<GameSound> gameSoundList;
        private List<Integer> gameSoundMutexes;
        private int headMotion;
        private int headSetSoundRecord;
        private int headsetFeedback;
        private int hearingEnhancement;
        private int hearingEnhancementNew;
        private int hearingJudgeDb;
        private int hearingOptimize;
        private int heyFindDevice;
        private int heyMelodyDownload;
        private int hideFromUIList;
        private int highAudio;
        private int highToneQuality;
        private int holdInBoxPairing;
        private int honorWall;
        private int immersiveRecord;
        private int inBoxStatus;
        private int incomingCallControl;
        private List<Integer> introductionGuideList;
        private List<LeFilterFunction> leFilterFunctions;
        private int longPowerMode;
        private int longPressType;
        private int longPressVolume;
        private int meetingAssistant;
        private int minOtaBattery;
        private List<MultiConnectFunction> multiConnectFunctions;
        private int multiDevicesConnect;
        private List<Control> musicControl;
        private List<String> mutexFunctions;
        private int newFunctionGuide;
        private List<NoiseReductionMode> noiseReductionMode;
        private int noiseReductionUIVersion;
        private int openBoxPairing;
        private int opsReduction;
        private int pairingInBoxCount;
        private int pairingModeTip;
        private int personalNoise;
        private PersonalNoiseCompat personalNoiseCompat;
        private int promptVolume;
        private PromptVolumeRange promptVolumeRange;
        private int related;
        private int rlmMoreFunction;
        private boolean showTurnAutoSwitchOnDialog;
        private int sleepDetection;
        private int smartCall;
        private int spatialDescriptionType;
        private int spatialEarphoneFirst;
        private int spatialHiResMutex;
        private List<Integer> spatialTypes;
        private int spatialVip;
        private int speechPerception;
        private int spineHealth;
        private int spyTap;
        private int strongNoiseReductionRealTime;
        private int supportPinch;
        private int swiftPair;
        private int tapLevelSetting;
        private int tutorialGuide;
        private int upgradeMtu;
        private int vocalEnhance;
        private int voiceCommand;
        private List<Integer> voiceCommandItems;
        private int voiceWake;
        private int wearDetection;
        private int wearingVideoTutorial;
        private int whiteNoise;
        private int zenMode;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<Function> {
            @Override // android.os.Parcelable.Creator
            public final Function createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                int i10;
                ArrayList arrayList2;
                ArrayList arrayList3;
                ArrayList arrayList4;
                ArrayList arrayList5;
                PromptVolumeRange promptVolumeRange;
                ArrayList arrayList6;
                ArrayList arrayList7;
                ArrayList arrayList8;
                ArrayList arrayList9;
                PersonalNoiseCompat personalNoiseCompat;
                ArrayList arrayList10;
                ArrayList arrayList11;
                ArrayList arrayList12;
                AiTranslateCompat aiTranslateCompat;
                ArrayList arrayList13;
                PersonalNoiseCompat personalNoiseCompat2;
                ArrayList arrayList14;
                ArrayList arrayList15;
                AiTranslateCompat aiTranslateCompat2;
                ArrayList arrayList16;
                ArrayList arrayList17;
                AiTranslateCompat aiTranslateCompat3;
                ArrayList arrayList18;
                ArrayList arrayList19;
                AiTranslateCompat aiTranslateCompat4;
                ArrayList arrayList20;
                ArrayList arrayList21;
                AiTranslateCompat aiTranslateCompat5;
                ArrayList arrayList22;
                ArrayList arrayList23;
                AiTranslateCompat aiTranslateCompat6;
                ArrayList arrayList24;
                ArrayList arrayList25;
                AiTranslateCompat aiTranslateCompat7;
                ArrayList arrayList26;
                ArrayList arrayList27;
                AiTranslateCompat aiTranslateCompat8;
                ArrayList arrayList28;
                ArrayList arrayList29;
                AiTranslateCompat aiTranslateCompat9;
                ArrayList arrayList30;
                ArrayList arrayList31;
                ArrayList arrayList32;
                h.e(parcel, "parcel");
                int i11 = parcel.readInt();
                int i12 = parcel.readInt();
                int i13 = parcel.readInt();
                int i14 = parcel.readInt();
                int i15 = parcel.readInt();
                int i16 = parcel.readInt();
                int i17 = parcel.readInt();
                int i18 = parcel.readInt();
                int i19 = parcel.readInt();
                int i20 = parcel.readInt();
                int i21 = parcel.readInt();
                int i22 = parcel.readInt();
                int i23 = parcel.readInt();
                int i24 = parcel.readInt();
                int i25 = parcel.readInt();
                int i26 = parcel.readInt();
                int i27 = parcel.readInt();
                int i28 = parcel.readInt();
                int i29 = parcel.readInt();
                int i30 = parcel.readInt();
                int i31 = parcel.readInt();
                int i32 = parcel.readInt();
                int i33 = parcel.readInt();
                int i34 = parcel.readInt();
                int i35 = parcel.readInt();
                int i36 = parcel.readInt();
                int i37 = parcel.readInt();
                int i38 = parcel.readInt();
                int i39 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    i10 = i11;
                    arrayList = null;
                } else {
                    int i40 = parcel.readInt();
                    arrayList = new ArrayList(i40);
                    i10 = i11;
                    int iB = 0;
                    while (iB != i40) {
                        iB = b.b(Control.CREATOR, parcel, arrayList, iB, 1);
                        i40 = i40;
                        i12 = i12;
                    }
                }
                int i41 = i12;
                if (parcel.readInt() == 0) {
                    arrayList2 = null;
                } else {
                    int i42 = parcel.readInt();
                    arrayList2 = new ArrayList(i42);
                    int iB2 = 0;
                    while (iB2 != i42) {
                        iB2 = b.b(Control.CREATOR, parcel, arrayList2, iB2, 1);
                        i42 = i42;
                        arrayList = arrayList;
                    }
                }
                ArrayList arrayList33 = arrayList;
                if (parcel.readInt() == 0) {
                    arrayList3 = null;
                } else {
                    int i43 = parcel.readInt();
                    arrayList3 = new ArrayList(i43);
                    int iB3 = 0;
                    while (iB3 != i43) {
                        iB3 = b.b(Control.CREATOR, parcel, arrayList3, iB3, 1);
                        i43 = i43;
                        arrayList2 = arrayList2;
                    }
                }
                ArrayList arrayList34 = arrayList2;
                if (parcel.readInt() == 0) {
                    arrayList4 = null;
                } else {
                    int i44 = parcel.readInt();
                    ArrayList arrayList35 = new ArrayList(i44);
                    int iB4 = 0;
                    while (iB4 != i44) {
                        iB4 = b.b(ControlList.CREATOR, parcel, arrayList35, iB4, 1);
                        i44 = i44;
                        arrayList3 = arrayList3;
                    }
                    arrayList4 = arrayList35;
                }
                ArrayList arrayList36 = arrayList3;
                int i45 = i41;
                int i46 = parcel.readInt();
                int i47 = parcel.readInt();
                int i48 = parcel.readInt();
                PromptVolumeRange promptVolumeRangeCreateFromParcel = parcel.readInt() == 0 ? null : PromptVolumeRange.CREATOR.createFromParcel(parcel);
                int i49 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList5 = null;
                    promptVolumeRange = promptVolumeRangeCreateFromParcel;
                } else {
                    int i50 = parcel.readInt();
                    arrayList5 = new ArrayList(i50);
                    promptVolumeRange = promptVolumeRangeCreateFromParcel;
                    int iB5 = 0;
                    while (iB5 != i50) {
                        iB5 = b.b(NoiseReductionMode.CREATOR, parcel, arrayList5, iB5, 1);
                        i50 = i50;
                        i45 = i45;
                    }
                }
                int i51 = i45;
                if (parcel.readInt() == 0) {
                    arrayList6 = null;
                } else {
                    int i52 = parcel.readInt();
                    arrayList6 = new ArrayList(i52);
                    int iB6 = 0;
                    while (iB6 != i52) {
                        iB6 = b.b(EqualizerMode.CREATOR, parcel, arrayList6, iB6, 1);
                        i52 = i52;
                        arrayList5 = arrayList5;
                    }
                }
                ArrayList arrayList37 = arrayList5;
                if (parcel.readInt() == 0) {
                    arrayList7 = null;
                } else {
                    int i53 = parcel.readInt();
                    arrayList7 = new ArrayList(i53);
                    int iB7 = 0;
                    while (iB7 != i53) {
                        iB7 = b.b(EqualizerMode.CREATOR, parcel, arrayList7, iB7, 1);
                        i53 = i53;
                        arrayList6 = arrayList6;
                    }
                }
                ArrayList arrayList38 = arrayList6;
                if (parcel.readInt() == 0) {
                    arrayList8 = null;
                } else {
                    int i54 = parcel.readInt();
                    ArrayList arrayList39 = new ArrayList(i54);
                    int iB8 = 0;
                    while (iB8 != i54) {
                        iB8 = b.b(EqualizerMode.CREATOR, parcel, arrayList39, iB8, 1);
                        i54 = i54;
                        arrayList7 = arrayList7;
                    }
                    arrayList8 = arrayList39;
                }
                ArrayList arrayList40 = arrayList7;
                int i55 = i51;
                int i56 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList9 = null;
                } else {
                    int i57 = parcel.readInt();
                    arrayList9 = new ArrayList(i57);
                    int iB9 = 0;
                    while (iB9 != i57) {
                        iB9 = b.b(EqualizerMode.CREATOR, parcel, arrayList9, iB9, 1);
                        i57 = i57;
                        i55 = i55;
                    }
                }
                int i58 = i55;
                PersonalNoiseCompat personalNoiseCompatCreateFromParcel = parcel.readInt() == 0 ? null : PersonalNoiseCompat.CREATOR.createFromParcel(parcel);
                AiTranslateCompat aiTranslateCompatCreateFromParcel = parcel.readInt() == 0 ? null : AiTranslateCompat.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() == 0) {
                    personalNoiseCompat = personalNoiseCompatCreateFromParcel;
                    arrayList11 = arrayList9;
                    arrayList10 = null;
                } else {
                    int i59 = parcel.readInt();
                    personalNoiseCompat = personalNoiseCompatCreateFromParcel;
                    arrayList10 = new ArrayList(i59);
                    arrayList11 = arrayList9;
                    for (int i60 = 0; i60 != i59; i60++) {
                        arrayList10.add(Integer.valueOf(parcel.readInt()));
                    }
                }
                int i61 = i58;
                int i62 = parcel.readInt();
                ArrayList arrayList41 = arrayList11;
                int i63 = parcel.readInt();
                int i64 = parcel.readInt();
                int i65 = parcel.readInt();
                int i66 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    aiTranslateCompat = aiTranslateCompatCreateFromParcel;
                    arrayList13 = arrayList38;
                    personalNoiseCompat2 = personalNoiseCompat;
                    arrayList14 = arrayList10;
                    arrayList12 = null;
                } else {
                    int i67 = parcel.readInt();
                    ArrayList arrayList42 = arrayList10;
                    arrayList12 = new ArrayList(i67);
                    aiTranslateCompat = aiTranslateCompatCreateFromParcel;
                    int iB10 = 0;
                    while (iB10 != i67) {
                        iB10 = b.b(MultiConnectFunction.CREATOR, parcel, arrayList12, iB10, 1);
                        i67 = i67;
                        i61 = i61;
                    }
                    arrayList13 = arrayList38;
                    personalNoiseCompat2 = personalNoiseCompat;
                    arrayList14 = arrayList42;
                }
                int i68 = i61;
                int i69 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat10 = aiTranslateCompat;
                int i70 = parcel.readInt();
                int i71 = parcel.readInt();
                int i72 = i68;
                int i73 = parcel.readInt();
                int i74 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList16 = arrayList12;
                    aiTranslateCompat2 = aiTranslateCompat10;
                    arrayList15 = null;
                } else {
                    int i75 = parcel.readInt();
                    ArrayList arrayList43 = arrayList12;
                    arrayList15 = new ArrayList(i75);
                    aiTranslateCompat2 = aiTranslateCompat10;
                    int i76 = 0;
                    while (i76 != i75) {
                        arrayList15.add(Integer.valueOf(parcel.readInt()));
                        i76++;
                        i75 = i75;
                    }
                    arrayList16 = arrayList43;
                }
                int i77 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat11 = aiTranslateCompat2;
                int i78 = parcel.readInt();
                int i79 = parcel.readInt();
                int i80 = parcel.readInt();
                int i81 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList18 = arrayList15;
                    arrayList17 = null;
                    aiTranslateCompat3 = aiTranslateCompat11;
                } else {
                    int i82 = parcel.readInt();
                    ArrayList arrayList44 = arrayList15;
                    arrayList17 = new ArrayList(i82);
                    aiTranslateCompat3 = aiTranslateCompat11;
                    int iB11 = 0;
                    while (iB11 != i82) {
                        iB11 = b.b(GameMode.CREATOR, parcel, arrayList17, iB11, 1);
                        i82 = i82;
                        i72 = i72;
                    }
                    arrayList18 = arrayList44;
                }
                int i83 = i72;
                int i84 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat12 = aiTranslateCompat3;
                int i85 = parcel.readInt();
                int i86 = parcel.readInt();
                int i87 = i83;
                int i88 = parcel.readInt();
                int i89 = parcel.readInt();
                int i90 = parcel.readInt();
                int i91 = parcel.readInt();
                int i92 = parcel.readInt();
                int i93 = parcel.readInt();
                int i94 = parcel.readInt();
                int i95 = parcel.readInt();
                int i96 = parcel.readInt();
                int i97 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList20 = arrayList17;
                    aiTranslateCompat4 = aiTranslateCompat12;
                    arrayList19 = null;
                } else {
                    int i98 = parcel.readInt();
                    ArrayList arrayList45 = arrayList17;
                    arrayList19 = new ArrayList(i98);
                    aiTranslateCompat4 = aiTranslateCompat12;
                    int i99 = 0;
                    while (i99 != i98) {
                        arrayList19.add(Integer.valueOf(parcel.readInt()));
                        i99++;
                        i98 = i98;
                    }
                    arrayList20 = arrayList45;
                }
                int i100 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat13 = aiTranslateCompat4;
                int i101 = parcel.readInt();
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                if (parcel.readInt() == 0) {
                    arrayList22 = arrayList19;
                    arrayList21 = null;
                    aiTranslateCompat5 = aiTranslateCompat13;
                } else {
                    int i102 = parcel.readInt();
                    ArrayList arrayList46 = arrayList19;
                    arrayList21 = new ArrayList(i102);
                    aiTranslateCompat5 = aiTranslateCompat13;
                    int iB12 = 0;
                    while (iB12 != i102) {
                        iB12 = b.b(GameSound.CREATOR, parcel, arrayList21, iB12, 1);
                        i102 = i102;
                        i87 = i87;
                    }
                    arrayList22 = arrayList46;
                }
                int i103 = i87;
                int i104 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat14 = aiTranslateCompat5;
                int i105 = parcel.readInt();
                int i106 = parcel.readInt();
                int i107 = i103;
                int i108 = parcel.readInt();
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() == 0) {
                    arrayList24 = arrayList21;
                    aiTranslateCompat6 = aiTranslateCompat14;
                    arrayList23 = null;
                } else {
                    int i109 = parcel.readInt();
                    ArrayList arrayList47 = arrayList21;
                    arrayList23 = new ArrayList(i109);
                    aiTranslateCompat6 = aiTranslateCompat14;
                    int iB13 = 0;
                    while (iB13 != i109) {
                        iB13 = b.b(LeFilterFunction.CREATOR, parcel, arrayList23, iB13, 1);
                        i109 = i109;
                        i107 = i107;
                    }
                    arrayList24 = arrayList47;
                }
                int i110 = i107;
                int i111 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat15 = aiTranslateCompat6;
                int i112 = parcel.readInt();
                int i113 = parcel.readInt();
                int i114 = i110;
                int i115 = parcel.readInt();
                int i116 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList26 = arrayList23;
                    arrayList25 = null;
                    aiTranslateCompat7 = aiTranslateCompat15;
                } else {
                    int i117 = parcel.readInt();
                    ArrayList arrayList48 = arrayList23;
                    arrayList25 = new ArrayList(i117);
                    aiTranslateCompat7 = aiTranslateCompat15;
                    int i118 = 0;
                    while (i118 != i117) {
                        arrayList25.add(Integer.valueOf(parcel.readInt()));
                        i118++;
                        i117 = i117;
                    }
                    arrayList26 = arrayList48;
                }
                int i119 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat16 = aiTranslateCompat7;
                int i120 = parcel.readInt();
                int i121 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList28 = arrayList25;
                    aiTranslateCompat8 = aiTranslateCompat16;
                    arrayList27 = null;
                } else {
                    int i122 = parcel.readInt();
                    ArrayList arrayList49 = arrayList25;
                    arrayList27 = new ArrayList(i122);
                    aiTranslateCompat8 = aiTranslateCompat16;
                    int i123 = 0;
                    while (i123 != i122) {
                        arrayList27.add(Integer.valueOf(parcel.readInt()));
                        i123++;
                        i122 = i122;
                    }
                    arrayList28 = arrayList49;
                }
                int i124 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat17 = aiTranslateCompat8;
                int i125 = parcel.readInt();
                int i126 = parcel.readInt();
                int i127 = parcel.readInt();
                int i128 = parcel.readInt();
                int i129 = parcel.readInt();
                int i130 = parcel.readInt();
                int i131 = parcel.readInt();
                int i132 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList30 = arrayList27;
                    arrayList29 = null;
                    aiTranslateCompat9 = aiTranslateCompat17;
                } else {
                    int i133 = parcel.readInt();
                    ArrayList arrayList50 = arrayList27;
                    arrayList29 = new ArrayList(i133);
                    aiTranslateCompat9 = aiTranslateCompat17;
                    int i134 = 0;
                    while (i134 != i133) {
                        arrayList29.add(Integer.valueOf(parcel.readInt()));
                        i134++;
                        i133 = i133;
                    }
                    arrayList30 = arrayList50;
                }
                int i135 = parcel.readInt();
                AiTranslateCompat aiTranslateCompat18 = aiTranslateCompat9;
                int i136 = parcel.readInt();
                int i137 = parcel.readInt();
                int i138 = parcel.readInt();
                int i139 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList31 = arrayList29;
                    arrayList32 = null;
                } else {
                    int i140 = parcel.readInt();
                    arrayList31 = arrayList29;
                    ArrayList arrayList51 = new ArrayList(i140);
                    int iB14 = 0;
                    while (iB14 != i140) {
                        iB14 = b.b(DressFilter.CREATOR, parcel, arrayList51, iB14, 1);
                        i140 = i140;
                        i114 = i114;
                    }
                    arrayList32 = arrayList51;
                    aiTranslateCompat18 = aiTranslateCompat18;
                }
                return new Function(i10, i114, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, arrayList33, arrayList34, arrayList36, arrayList4, i46, i47, i48, promptVolumeRange, i49, arrayList37, arrayList13, arrayList40, arrayList8, i56, arrayList41, personalNoiseCompat2, aiTranslateCompat18, arrayList14, i62, i63, i64, i65, i66, arrayList16, i69, i70, i71, i73, i74, arrayList18, i77, i78, i79, i80, i81, arrayList20, i84, i85, i86, i88, i89, i90, i91, i92, i93, i94, i95, i96, i97, arrayList22, i100, i101, arrayListCreateStringArrayList, numValueOf, arrayList24, i104, i105, i106, i108, z2, arrayList26, i111, i112, i113, i115, i116, arrayList28, i119, i120, i121, arrayList30, i124, i125, i126, i127, i128, i129, i130, i131, i132, arrayList31, i135, i136, i137, i138, i139, arrayList32, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createStringArrayList(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final Function[] newArray(int i10) {
                return new Function[i10];
            }
        }

        public Function() {
            this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, 0, 0, 0, null, 0, null, null, null, null, 0, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, null, null, null, 0, 0, 0, 0, false, null, 0, 0, 0, 0, 0, null, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, null, 0, 0, 0, -1, -1, -1, 536870911, null);
        }

        /* JADX INFO: renamed from: component83, reason: from getter */
        private final Integer getGameEqualizer() {
            return this.gameEqualizer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Function copy$default(Function function, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, List list, List list2, List list3, List list4, int i39, int i40, int i41, PromptVolumeRange promptVolumeRange, int i42, List list5, List list6, List list7, List list8, int i43, List list9, PersonalNoiseCompat personalNoiseCompat, AiTranslateCompat aiTranslateCompat, List list10, int i44, int i45, int i46, int i47, int i48, List list11, int i49, int i50, int i51, int i52, int i53, List list12, int i54, int i55, int i56, int i57, int i58, List list13, int i59, int i60, int i61, int i62, int i63, int i64, int i65, int i66, int i67, int i68, int i69, int i70, int i71, List list14, int i72, int i73, List list15, Integer num, List list16, int i74, int i75, int i76, int i77, boolean z2, List list17, int i78, int i79, int i80, int i81, int i82, List list18, int i83, int i84, int i85, List list19, int i86, int i87, int i88, int i89, int i90, int i91, int i92, int i93, int i94, List list20, int i95, int i96, int i97, int i98, int i99, List list21, int i100, int i101, int i102, int i103, int i104, List list22, int i105, int i106, int i107, int i108, int i109, int i110, int i111, Object obj) {
            int i112 = (i108 & 1) != 0 ? function.opsReduction : i10;
            int i113 = (i108 & 2) != 0 ? function.zenMode : i11;
            int i114 = (i108 & 4) != 0 ? function.batteryInfo : i12;
            int i115 = (i108 & 8) != 0 ? function.heyMelodyDownload : i13;
            int i116 = (i108 & 16) != 0 ? function.batteryRadix : i14;
            int i117 = (i108 & 32) != 0 ? function.equalizer : i15;
            int i118 = (i108 & 64) != 0 ? function.customEqualizer : i16;
            int i119 = (i108 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? function.customEqMax : i17;
            int i120 = (i108 & 256) != 0 ? function.findDevice : i18;
            int i121 = (i108 & 512) != 0 ? function.headMotion : i19;
            int i122 = (i108 & 1024) != 0 ? function.heyFindDevice : i20;
            int i123 = i112;
            int i124 = (i108 & 2048) != 0 ? function.dolbyAtmos : i21;
            int i125 = (i108 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? function.fitDetection : i22;
            int i126 = (i108 & 8192) != 0 ? function.autoFirmwareUpdate : i23;
            int i127 = (i108 & 16384) != 0 ? function.wearDetection : i24;
            int i128 = (i108 & 32768) != 0 ? function.inBoxStatus : i25;
            int i129 = (i108 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? function.clickTakePic : i26;
            int i130 = (i108 & 131072) != 0 ? function.clickTakePicNew : i27;
            int i131 = (i108 & 262144) != 0 ? function.headSetSoundRecord : i28;
            int i132 = (i108 & 524288) != 0 ? function.immersiveRecord : i29;
            int i133 = (i108 & 1048576) != 0 ? function.vocalEnhance : i30;
            int i134 = (i108 & 2097152) != 0 ? function.personalNoise : i31;
            int i135 = (i108 & 4194304) != 0 ? function.functionGuide : i32;
            int i136 = (i108 & 8388608) != 0 ? function.fastDiscovery : i33;
            int i137 = (i108 & 16777216) != 0 ? function.firmwareDiscovery : i34;
            int i138 = (i108 & 33554432) != 0 ? function.openBoxPairing : i35;
            int i139 = (i108 & 67108864) != 0 ? function.holdInBoxPairing : i36;
            int i140 = (i108 & 134217728) != 0 ? function.pairingModeTip : i37;
            int i141 = (i108 & 268435456) != 0 ? function.hideFromUIList : i38;
            List list23 = (i108 & 536870912) != 0 ? function.control : list;
            List list24 = (i108 & 1073741824) != 0 ? function.callControl : list2;
            List list25 = (i108 & Integer.MIN_VALUE) != 0 ? function.musicControl : list3;
            List list26 = (i109 & 1) != 0 ? function.controlList : list4;
            int i142 = (i109 & 2) != 0 ? function.firmwareCheckCommandId : i39;
            int i143 = (i109 & 4) != 0 ? function.firmwareFileCheckFlags : i40;
            int i144 = (i109 & 8) != 0 ? function.promptVolume : i41;
            PromptVolumeRange promptVolumeRange2 = (i109 & 16) != 0 ? function.promptVolumeRange : promptVolumeRange;
            int i145 = (i109 & 32) != 0 ? function.noiseReductionUIVersion : i42;
            List list27 = (i109 & 64) != 0 ? function.noiseReductionMode : list5;
            List list28 = (i109 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? function.equalizerMode : list6;
            List list29 = (i109 & 256) != 0 ? function.equalizerModeCompat : list7;
            List list30 = (i109 & 512) != 0 ? function.equalizerModeByColor : list8;
            int i146 = (i109 & 1024) != 0 ? function.longPressType : i43;
            List list31 = (i109 & 2048) != 0 ? function.equalizerModeByVersion : list9;
            PersonalNoiseCompat personalNoiseCompat2 = (i109 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? function.personalNoiseCompat : personalNoiseCompat;
            AiTranslateCompat aiTranslateCompat2 = (i109 & 8192) != 0 ? function.aiTranslateCompat : aiTranslateCompat;
            List list32 = (i109 & 16384) != 0 ? function.introductionGuideList : list10;
            int i147 = (i109 & 32768) != 0 ? function.hearingEnhancement : i44;
            int i148 = (i109 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? function.hearingEnhancementNew : i45;
            int i149 = (i109 & 131072) != 0 ? function.hearingJudgeDb : i46;
            int i150 = (i109 & 262144) != 0 ? function.earScan : i47;
            int i151 = (i109 & 524288) != 0 ? function.multiDevicesConnect : i48;
            List list33 = (i109 & 1048576) != 0 ? function.multiConnectFunctions : list11;
            int i152 = (i109 & 2097152) != 0 ? function.smartCall : i49;
            int i153 = (i109 & 4194304) != 0 ? function.highToneQuality : i50;
            int i154 = (i109 & 8388608) != 0 ? function.highAudio : i51;
            int i155 = (i109 & 16777216) != 0 ? function.voiceWake : i52;
            int i156 = (i109 & 33554432) != 0 ? function.voiceCommand : i53;
            List list34 = (i109 & 67108864) != 0 ? function.voiceCommandItems : list12;
            int i157 = (i109 & 134217728) != 0 ? function.incomingCallControl : i54;
            int i158 = (i109 & 268435456) != 0 ? function.longPowerMode : i55;
            int i159 = (i109 & 536870912) != 0 ? function.deviceLostRemind : i56;
            int i160 = (i109 & 1073741824) != 0 ? function.related : i57;
            return function.copy(i123, i113, i114, i115, i116, i117, i118, i119, i120, i121, i122, i124, i125, i126, i127, i128, i129, i130, i131, i132, i133, i134, i135, i136, i137, i138, i139, i140, i141, list23, list24, list25, list26, i142, i143, i144, promptVolumeRange2, i145, list27, list28, list29, list30, i146, list31, personalNoiseCompat2, aiTranslateCompat2, list32, i147, i148, i149, i150, i151, list33, i152, i153, i154, i155, i156, list34, i157, i158, i159, i160, (i109 & Integer.MIN_VALUE) != 0 ? function.gameMode : i58, (i110 & 1) != 0 ? function.gameModeList : list13, (i110 & 2) != 0 ? function.collectLogs : i59, (i110 & 4) != 0 ? function.controlGuideSupport : i60, (i110 & 8) != 0 ? function.controlAutoVolumeSupport : i61, (i110 & 16) != 0 ? function.longPressVolume : i62, (i110 & 32) != 0 ? function.tapLevelSetting : i63, (i110 & 64) != 0 ? function.diagnostic : i64, (i110 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? function.aiSummary : i65, (i110 & 256) != 0 ? function.aiSummaryToneSource : i66, (i110 & 512) != 0 ? function.aiClearCall : i67, (i110 & 1024) != 0 ? function.aiTranslate : i68, (i110 & 2048) != 0 ? function.functionIntroductionGuide : i69, (i110 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? function.bassEngineSupport : i70, (i110 & 8192) != 0 ? function.spineHealth : i71, (i110 & 16384) != 0 ? function.spatialTypes : list14, (i110 & 32768) != 0 ? function.spatialVip : i72, (i110 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? function.supportPinch : i73, (i110 & 131072) != 0 ? function.gameEqPkgList : list15, (i110 & 262144) != 0 ? function.gameEqualizer : num, (i110 & 524288) != 0 ? function.gameSoundList : list16, (i110 & 1048576) != 0 ? function.rlmMoreFunction : i74, (i110 & 2097152) != 0 ? function.autoSwitchLink : i75, (i110 & 4194304) != 0 ? function.autoBTBond : i76, (i110 & 8388608) != 0 ? function.feedback : i77, (i110 & 16777216) != 0 ? function.showTurnAutoSwitchOnDialog : z2, (i110 & 33554432) != 0 ? function.leFilterFunctions : list17, (i110 & 67108864) != 0 ? function.customDress : i78, (i110 & 134217728) != 0 ? function.carouselDress : i79, (i110 & 268435456) != 0 ? function.spatialDescriptionType : i80, (i110 & 536870912) != 0 ? function.minOtaBattery : i81, (i110 & 1073741824) != 0 ? function.spatialHiResMutex : i82, (i110 & Integer.MIN_VALUE) != 0 ? function.gameSoundMutexes : list18, (i111 & 1) != 0 ? function.cleanGuide : i83, (i111 & 2) != 0 ? function.honorWall : i84, (i111 & 4) != 0 ? function.strongNoiseReductionRealTime : i85, (i111 & 8) != 0 ? function.dialogTags : list19, (i111 & 16) != 0 ? function.tutorialGuide : i86, (i111 & 32) != 0 ? function.wearingVideoTutorial : i87, (i111 & 64) != 0 ? function.adaptiveVolume : i88, (i111 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? function.adaptiveEar : i89, (i111 & 256) != 0 ? function.speechPerception : i90, (i111 & 512) != 0 ? function.firmwareTrack : i91, (i111 & 1024) != 0 ? function.meetingAssistant : i92, (i111 & 2048) != 0 ? function.spatialEarphoneFirst : i93, (i111 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? function.defaultSoundChannelSwitchOn : i94, (i111 & 8192) != 0 ? function.customEqFrequency : list20, (i111 & 16384) != 0 ? function.spyTap : i95, (i111 & 32768) != 0 ? function.swiftPair : i96, (i111 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? function.hearingOptimize : i97, (i111 & 131072) != 0 ? function.customEqUiVersion : i98, (i111 & 262144) != 0 ? function.appUpdateRemindVersion : i99, (i111 & 524288) != 0 ? function.dressFilterList : list21, (i111 & 1048576) != 0 ? function.whiteNoise : i100, (i111 & 2097152) != 0 ? function.sleepDetection : i101, (i111 & 4194304) != 0 ? function.deviceInfo : i102, (i111 & 8388608) != 0 ? function.upgradeMtu : i103, (i111 & 16777216) != 0 ? function.brLeCoexist : i104, (i111 & 33554432) != 0 ? function.mutexFunctions : list22, (i111 & 67108864) != 0 ? function.pairingInBoxCount : i105, (i111 & 134217728) != 0 ? function.newFunctionGuide : i106, (i111 & 268435456) != 0 ? function.headsetFeedback : i107);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int getEqualizerModeByColorId$lambda$5(l lVar, Object obj) {
            return ((Number) lVar.d(obj)).intValue();
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getOpsReduction() {
            return this.opsReduction;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final int getHeadMotion() {
            return this.headMotion;
        }

        public final List<Integer> component100() {
            return this.dialogTags;
        }

        /* JADX INFO: renamed from: component101, reason: from getter */
        public final int getTutorialGuide() {
            return this.tutorialGuide;
        }

        /* JADX INFO: renamed from: component102, reason: from getter */
        public final int getWearingVideoTutorial() {
            return this.wearingVideoTutorial;
        }

        /* JADX INFO: renamed from: component103, reason: from getter */
        public final int getAdaptiveVolume() {
            return this.adaptiveVolume;
        }

        /* JADX INFO: renamed from: component104, reason: from getter */
        public final int getAdaptiveEar() {
            return this.adaptiveEar;
        }

        /* JADX INFO: renamed from: component105, reason: from getter */
        public final int getSpeechPerception() {
            return this.speechPerception;
        }

        /* JADX INFO: renamed from: component106, reason: from getter */
        public final int getFirmwareTrack() {
            return this.firmwareTrack;
        }

        /* JADX INFO: renamed from: component107, reason: from getter */
        public final int getMeetingAssistant() {
            return this.meetingAssistant;
        }

        /* JADX INFO: renamed from: component108, reason: from getter */
        public final int getSpatialEarphoneFirst() {
            return this.spatialEarphoneFirst;
        }

        /* JADX INFO: renamed from: component109, reason: from getter */
        public final int getDefaultSoundChannelSwitchOn() {
            return this.defaultSoundChannelSwitchOn;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final int getHeyFindDevice() {
            return this.heyFindDevice;
        }

        public final List<Integer> component110() {
            return this.customEqFrequency;
        }

        /* JADX INFO: renamed from: component111, reason: from getter */
        public final int getSpyTap() {
            return this.spyTap;
        }

        /* JADX INFO: renamed from: component112, reason: from getter */
        public final int getSwiftPair() {
            return this.swiftPair;
        }

        /* JADX INFO: renamed from: component113, reason: from getter */
        public final int getHearingOptimize() {
            return this.hearingOptimize;
        }

        /* JADX INFO: renamed from: component114, reason: from getter */
        public final int getCustomEqUiVersion() {
            return this.customEqUiVersion;
        }

        /* JADX INFO: renamed from: component115, reason: from getter */
        public final int getAppUpdateRemindVersion() {
            return this.appUpdateRemindVersion;
        }

        public final List<DressFilter> component116() {
            return this.dressFilterList;
        }

        /* JADX INFO: renamed from: component117, reason: from getter */
        public final int getWhiteNoise() {
            return this.whiteNoise;
        }

        /* JADX INFO: renamed from: component118, reason: from getter */
        public final int getSleepDetection() {
            return this.sleepDetection;
        }

        /* JADX INFO: renamed from: component119, reason: from getter */
        public final int getDeviceInfo() {
            return this.deviceInfo;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final int getDolbyAtmos() {
            return this.dolbyAtmos;
        }

        /* JADX INFO: renamed from: component120, reason: from getter */
        public final int getUpgradeMtu() {
            return this.upgradeMtu;
        }

        /* JADX INFO: renamed from: component121, reason: from getter */
        public final int getBrLeCoexist() {
            return this.brLeCoexist;
        }

        public final List<String> component122() {
            return this.mutexFunctions;
        }

        /* JADX INFO: renamed from: component123, reason: from getter */
        public final int getPairingInBoxCount() {
            return this.pairingInBoxCount;
        }

        /* JADX INFO: renamed from: component124, reason: from getter */
        public final int getNewFunctionGuide() {
            return this.newFunctionGuide;
        }

        /* JADX INFO: renamed from: component125, reason: from getter */
        public final int getHeadsetFeedback() {
            return this.headsetFeedback;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getFitDetection() {
            return this.fitDetection;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final int getAutoFirmwareUpdate() {
            return this.autoFirmwareUpdate;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getWearDetection() {
            return this.wearDetection;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final int getInBoxStatus() {
            return this.inBoxStatus;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final int getClickTakePic() {
            return this.clickTakePic;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final int getClickTakePicNew() {
            return this.clickTakePicNew;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final int getHeadSetSoundRecord() {
            return this.headSetSoundRecord;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getZenMode() {
            return this.zenMode;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final int getImmersiveRecord() {
            return this.immersiveRecord;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final int getVocalEnhance() {
            return this.vocalEnhance;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final int getPersonalNoise() {
            return this.personalNoise;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final int getFunctionGuide() {
            return this.functionGuide;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final int getFastDiscovery() {
            return this.fastDiscovery;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final int getFirmwareDiscovery() {
            return this.firmwareDiscovery;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final int getOpenBoxPairing() {
            return this.openBoxPairing;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final int getHoldInBoxPairing() {
            return this.holdInBoxPairing;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final int getPairingModeTip() {
            return this.pairingModeTip;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final int getHideFromUIList() {
            return this.hideFromUIList;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getBatteryInfo() {
            return this.batteryInfo;
        }

        public final List<Control> component30() {
            return this.control;
        }

        public final List<Control> component31() {
            return this.callControl;
        }

        public final List<Control> component32() {
            return this.musicControl;
        }

        public final List<ControlList> component33() {
            return this.controlList;
        }

        /* JADX INFO: renamed from: component34, reason: from getter */
        public final int getFirmwareCheckCommandId() {
            return this.firmwareCheckCommandId;
        }

        /* JADX INFO: renamed from: component35, reason: from getter */
        public final int getFirmwareFileCheckFlags() {
            return this.firmwareFileCheckFlags;
        }

        /* JADX INFO: renamed from: component36, reason: from getter */
        public final int getPromptVolume() {
            return this.promptVolume;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final PromptVolumeRange getPromptVolumeRange() {
            return this.promptVolumeRange;
        }

        /* JADX INFO: renamed from: component38, reason: from getter */
        public final int getNoiseReductionUIVersion() {
            return this.noiseReductionUIVersion;
        }

        public final List<NoiseReductionMode> component39() {
            return this.noiseReductionMode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getHeyMelodyDownload() {
            return this.heyMelodyDownload;
        }

        public final List<EqualizerMode> component40() {
            return this.equalizerMode;
        }

        public final List<EqualizerMode> component41() {
            return this.equalizerModeCompat;
        }

        public final List<EqualizerMode> component42() {
            return this.equalizerModeByColor;
        }

        /* JADX INFO: renamed from: component43, reason: from getter */
        public final int getLongPressType() {
            return this.longPressType;
        }

        public final List<EqualizerMode> component44() {
            return this.equalizerModeByVersion;
        }

        /* JADX INFO: renamed from: component45, reason: from getter */
        public final PersonalNoiseCompat getPersonalNoiseCompat() {
            return this.personalNoiseCompat;
        }

        /* JADX INFO: renamed from: component46, reason: from getter */
        public final AiTranslateCompat getAiTranslateCompat() {
            return this.aiTranslateCompat;
        }

        public final List<Integer> component47() {
            return this.introductionGuideList;
        }

        /* JADX INFO: renamed from: component48, reason: from getter */
        public final int getHearingEnhancement() {
            return this.hearingEnhancement;
        }

        /* JADX INFO: renamed from: component49, reason: from getter */
        public final int getHearingEnhancementNew() {
            return this.hearingEnhancementNew;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getBatteryRadix() {
            return this.batteryRadix;
        }

        /* JADX INFO: renamed from: component50, reason: from getter */
        public final int getHearingJudgeDb() {
            return this.hearingJudgeDb;
        }

        /* JADX INFO: renamed from: component51, reason: from getter */
        public final int getEarScan() {
            return this.earScan;
        }

        /* JADX INFO: renamed from: component52, reason: from getter */
        public final int getMultiDevicesConnect() {
            return this.multiDevicesConnect;
        }

        public final List<MultiConnectFunction> component53() {
            return this.multiConnectFunctions;
        }

        /* JADX INFO: renamed from: component54, reason: from getter */
        public final int getSmartCall() {
            return this.smartCall;
        }

        /* JADX INFO: renamed from: component55, reason: from getter */
        public final int getHighToneQuality() {
            return this.highToneQuality;
        }

        /* JADX INFO: renamed from: component56, reason: from getter */
        public final int getHighAudio() {
            return this.highAudio;
        }

        /* JADX INFO: renamed from: component57, reason: from getter */
        public final int getVoiceWake() {
            return this.voiceWake;
        }

        /* JADX INFO: renamed from: component58, reason: from getter */
        public final int getVoiceCommand() {
            return this.voiceCommand;
        }

        public final List<Integer> component59() {
            return this.voiceCommandItems;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getEqualizer() {
            return this.equalizer;
        }

        /* JADX INFO: renamed from: component60, reason: from getter */
        public final int getIncomingCallControl() {
            return this.incomingCallControl;
        }

        /* JADX INFO: renamed from: component61, reason: from getter */
        public final int getLongPowerMode() {
            return this.longPowerMode;
        }

        /* JADX INFO: renamed from: component62, reason: from getter */
        public final int getDeviceLostRemind() {
            return this.deviceLostRemind;
        }

        /* JADX INFO: renamed from: component63, reason: from getter */
        public final int getRelated() {
            return this.related;
        }

        /* JADX INFO: renamed from: component64, reason: from getter */
        public final int getGameMode() {
            return this.gameMode;
        }

        public final List<GameMode> component65() {
            return this.gameModeList;
        }

        /* JADX INFO: renamed from: component66, reason: from getter */
        public final int getCollectLogs() {
            return this.collectLogs;
        }

        /* JADX INFO: renamed from: component67, reason: from getter */
        public final int getControlGuideSupport() {
            return this.controlGuideSupport;
        }

        /* JADX INFO: renamed from: component68, reason: from getter */
        public final int getControlAutoVolumeSupport() {
            return this.controlAutoVolumeSupport;
        }

        /* JADX INFO: renamed from: component69, reason: from getter */
        public final int getLongPressVolume() {
            return this.longPressVolume;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getCustomEqualizer() {
            return this.customEqualizer;
        }

        /* JADX INFO: renamed from: component70, reason: from getter */
        public final int getTapLevelSetting() {
            return this.tapLevelSetting;
        }

        /* JADX INFO: renamed from: component71, reason: from getter */
        public final int getDiagnostic() {
            return this.diagnostic;
        }

        /* JADX INFO: renamed from: component72, reason: from getter */
        public final int getAiSummary() {
            return this.aiSummary;
        }

        /* JADX INFO: renamed from: component73, reason: from getter */
        public final int getAiSummaryToneSource() {
            return this.aiSummaryToneSource;
        }

        /* JADX INFO: renamed from: component74, reason: from getter */
        public final int getAiClearCall() {
            return this.aiClearCall;
        }

        /* JADX INFO: renamed from: component75, reason: from getter */
        public final int getAiTranslate() {
            return this.aiTranslate;
        }

        /* JADX INFO: renamed from: component76, reason: from getter */
        public final int getFunctionIntroductionGuide() {
            return this.functionIntroductionGuide;
        }

        /* JADX INFO: renamed from: component77, reason: from getter */
        public final int getBassEngineSupport() {
            return this.bassEngineSupport;
        }

        /* JADX INFO: renamed from: component78, reason: from getter */
        public final int getSpineHealth() {
            return this.spineHealth;
        }

        public final List<Integer> component79() {
            return this.spatialTypes;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getCustomEqMax() {
            return this.customEqMax;
        }

        /* JADX INFO: renamed from: component80, reason: from getter */
        public final int getSpatialVip() {
            return this.spatialVip;
        }

        /* JADX INFO: renamed from: component81, reason: from getter */
        public final int getSupportPinch() {
            return this.supportPinch;
        }

        public final List<String> component82() {
            return this.gameEqPkgList;
        }

        public final List<GameSound> component84() {
            return this.gameSoundList;
        }

        /* JADX INFO: renamed from: component85, reason: from getter */
        public final int getRlmMoreFunction() {
            return this.rlmMoreFunction;
        }

        /* JADX INFO: renamed from: component86, reason: from getter */
        public final int getAutoSwitchLink() {
            return this.autoSwitchLink;
        }

        /* JADX INFO: renamed from: component87, reason: from getter */
        public final int getAutoBTBond() {
            return this.autoBTBond;
        }

        /* JADX INFO: renamed from: component88, reason: from getter */
        public final int getFeedback() {
            return this.feedback;
        }

        /* JADX INFO: renamed from: component89, reason: from getter */
        public final boolean getShowTurnAutoSwitchOnDialog() {
            return this.showTurnAutoSwitchOnDialog;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final int getFindDevice() {
            return this.findDevice;
        }

        public final List<LeFilterFunction> component90() {
            return this.leFilterFunctions;
        }

        /* JADX INFO: renamed from: component91, reason: from getter */
        public final int getCustomDress() {
            return this.customDress;
        }

        /* JADX INFO: renamed from: component92, reason: from getter */
        public final int getCarouselDress() {
            return this.carouselDress;
        }

        /* JADX INFO: renamed from: component93, reason: from getter */
        public final int getSpatialDescriptionType() {
            return this.spatialDescriptionType;
        }

        /* JADX INFO: renamed from: component94, reason: from getter */
        public final int getMinOtaBattery() {
            return this.minOtaBattery;
        }

        /* JADX INFO: renamed from: component95, reason: from getter */
        public final int getSpatialHiResMutex() {
            return this.spatialHiResMutex;
        }

        public final List<Integer> component96() {
            return this.gameSoundMutexes;
        }

        /* JADX INFO: renamed from: component97, reason: from getter */
        public final int getCleanGuide() {
            return this.cleanGuide;
        }

        /* JADX INFO: renamed from: component98, reason: from getter */
        public final int getHonorWall() {
            return this.honorWall;
        }

        /* JADX INFO: renamed from: component99, reason: from getter */
        public final int getStrongNoiseReductionRealTime() {
            return this.strongNoiseReductionRealTime;
        }

        public final Function copy(int opsReduction, int zenMode, int batteryInfo, int heyMelodyDownload, int batteryRadix, int equalizer, int customEqualizer, int customEqMax, int findDevice, int headMotion, int heyFindDevice, int dolbyAtmos, int fitDetection, int autoFirmwareUpdate, int wearDetection, int inBoxStatus, int clickTakePic, int clickTakePicNew, int headSetSoundRecord, int immersiveRecord, int vocalEnhance, int personalNoise, int functionGuide, int fastDiscovery, int firmwareDiscovery, int openBoxPairing, int holdInBoxPairing, int pairingModeTip, int hideFromUIList, List<Control> control, List<Control> callControl, List<Control> musicControl, List<ControlList> controlList, int firmwareCheckCommandId, int firmwareFileCheckFlags, int promptVolume, PromptVolumeRange promptVolumeRange, int noiseReductionUIVersion, List<NoiseReductionMode> noiseReductionMode, List<EqualizerMode> equalizerMode, List<EqualizerMode> equalizerModeCompat, List<EqualizerMode> equalizerModeByColor, int longPressType, List<EqualizerMode> equalizerModeByVersion, PersonalNoiseCompat personalNoiseCompat, AiTranslateCompat aiTranslateCompat, List<Integer> introductionGuideList, int hearingEnhancement, int hearingEnhancementNew, int hearingJudgeDb, int earScan, int multiDevicesConnect, List<MultiConnectFunction> multiConnectFunctions, int smartCall, int highToneQuality, int highAudio, int voiceWake, int voiceCommand, List<Integer> voiceCommandItems, int incomingCallControl, int longPowerMode, int deviceLostRemind, int related, int gameMode, List<GameMode> gameModeList, int collectLogs, int controlGuideSupport, int controlAutoVolumeSupport, int longPressVolume, int tapLevelSetting, int diagnostic, int aiSummary, int aiSummaryToneSource, int aiClearCall, int aiTranslate, int functionIntroductionGuide, int bassEngineSupport, int spineHealth, List<Integer> spatialTypes, int spatialVip, int supportPinch, List<String> gameEqPkgList, Integer gameEqualizer, List<GameSound> gameSoundList, int rlmMoreFunction, int autoSwitchLink, int autoBTBond, int feedback, boolean showTurnAutoSwitchOnDialog, List<LeFilterFunction> leFilterFunctions, int customDress, int carouselDress, int spatialDescriptionType, int minOtaBattery, int spatialHiResMutex, List<Integer> gameSoundMutexes, int cleanGuide, int honorWall, int strongNoiseReductionRealTime, List<Integer> dialogTags, int tutorialGuide, int wearingVideoTutorial, int adaptiveVolume, int adaptiveEar, int speechPerception, int firmwareTrack, int meetingAssistant, int spatialEarphoneFirst, int defaultSoundChannelSwitchOn, List<Integer> customEqFrequency, int spyTap, int swiftPair, int hearingOptimize, int customEqUiVersion, int appUpdateRemindVersion, List<DressFilter> dressFilterList, int whiteNoise, int sleepDetection, int deviceInfo, int upgradeMtu, int brLeCoexist, List<String> mutexFunctions, int pairingInBoxCount, int newFunctionGuide, int headsetFeedback) {
            return new Function(opsReduction, zenMode, batteryInfo, heyMelodyDownload, batteryRadix, equalizer, customEqualizer, customEqMax, findDevice, headMotion, heyFindDevice, dolbyAtmos, fitDetection, autoFirmwareUpdate, wearDetection, inBoxStatus, clickTakePic, clickTakePicNew, headSetSoundRecord, immersiveRecord, vocalEnhance, personalNoise, functionGuide, fastDiscovery, firmwareDiscovery, openBoxPairing, holdInBoxPairing, pairingModeTip, hideFromUIList, control, callControl, musicControl, controlList, firmwareCheckCommandId, firmwareFileCheckFlags, promptVolume, promptVolumeRange, noiseReductionUIVersion, noiseReductionMode, equalizerMode, equalizerModeCompat, equalizerModeByColor, longPressType, equalizerModeByVersion, personalNoiseCompat, aiTranslateCompat, introductionGuideList, hearingEnhancement, hearingEnhancementNew, hearingJudgeDb, earScan, multiDevicesConnect, multiConnectFunctions, smartCall, highToneQuality, highAudio, voiceWake, voiceCommand, voiceCommandItems, incomingCallControl, longPowerMode, deviceLostRemind, related, gameMode, gameModeList, collectLogs, controlGuideSupport, controlAutoVolumeSupport, longPressVolume, tapLevelSetting, diagnostic, aiSummary, aiSummaryToneSource, aiClearCall, aiTranslate, functionIntroductionGuide, bassEngineSupport, spineHealth, spatialTypes, spatialVip, supportPinch, gameEqPkgList, gameEqualizer, gameSoundList, rlmMoreFunction, autoSwitchLink, autoBTBond, feedback, showTurnAutoSwitchOnDialog, leFilterFunctions, customDress, carouselDress, spatialDescriptionType, minOtaBattery, spatialHiResMutex, gameSoundMutexes, cleanGuide, honorWall, strongNoiseReductionRealTime, dialogTags, tutorialGuide, wearingVideoTutorial, adaptiveVolume, adaptiveEar, speechPerception, firmwareTrack, meetingAssistant, spatialEarphoneFirst, defaultSoundChannelSwitchOn, customEqFrequency, spyTap, swiftPair, hearingOptimize, customEqUiVersion, appUpdateRemindVersion, dressFilterList, whiteNoise, sleepDetection, deviceInfo, upgradeMtu, brLeCoexist, mutexFunctions, pairingInBoxCount, newFunctionGuide, headsetFeedback);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getAdaptiveEar() {
            return this.adaptiveEar;
        }

        public final int getAdaptiveVolume() {
            return this.adaptiveVolume;
        }

        public final int getAiClearCall() {
            return this.aiClearCall;
        }

        public final int getAiSummary() {
            return this.aiSummary;
        }

        public final int getAiSummaryToneSource() {
            return this.aiSummaryToneSource;
        }

        public final int getAiTranslate() {
            return this.aiTranslate;
        }

        public final AiTranslateCompat getAiTranslateCompat() {
            return this.aiTranslateCompat;
        }

        public final int getAppUpdateRemindVersion() {
            return this.appUpdateRemindVersion;
        }

        public final int getAutoBTBond() {
            return this.autoBTBond;
        }

        public final int getAutoFirmwareUpdate() {
            return this.autoFirmwareUpdate;
        }

        public final int getAutoSwitchLink() {
            return this.autoSwitchLink;
        }

        public final int getBassEngineSupport() {
            return this.bassEngineSupport;
        }

        public final int getBatteryInfo() {
            return this.batteryInfo;
        }

        public final int getBatteryRadix() {
            return this.batteryRadix;
        }

        public final int getBrLeCoexist() {
            return this.brLeCoexist;
        }

        public final List<Control> getCallControl() {
            return this.callControl;
        }

        public final int getCarouselDress() {
            return this.carouselDress;
        }

        public final int getCleanGuide() {
            return this.cleanGuide;
        }

        public final int getClickTakePic() {
            return this.clickTakePic;
        }

        public final int getClickTakePicNew() {
            return this.clickTakePicNew;
        }

        public final int getCollectLogs() {
            return this.collectLogs;
        }

        public final List<Control> getControl() {
            return this.control;
        }

        public final int getControlAutoVolumeSupport() {
            return this.controlAutoVolumeSupport;
        }

        public final int getControlGuideSupport() {
            return this.controlGuideSupport;
        }

        public final List<ControlList> getControlList() {
            return this.controlList;
        }

        public final int getCustomDress() {
            return this.customDress;
        }

        public final List<Integer> getCustomEqFrequency() {
            return this.customEqFrequency;
        }

        public final int getCustomEqMax() {
            return this.customEqMax;
        }

        public final int getCustomEqUiVersion() {
            return this.customEqUiVersion;
        }

        public final int getCustomEqualizer() {
            return this.customEqualizer;
        }

        public final int getDefaultSoundChannelSwitchOn() {
            return this.defaultSoundChannelSwitchOn;
        }

        public final int getDeviceInfo() {
            return this.deviceInfo;
        }

        public final int getDeviceLostRemind() {
            return this.deviceLostRemind;
        }

        public final int getDiagnostic() {
            return this.diagnostic;
        }

        public final List<Integer> getDialogTags() {
            return this.dialogTags;
        }

        public final int getDolbyAtmos() {
            return this.dolbyAtmos;
        }

        public final List<DressFilter> getDressFilterList() {
            return this.dressFilterList;
        }

        public final int getEarScan() {
            return this.earScan;
        }

        public final int getEqualizer() {
            return this.equalizer;
        }

        public final List<EqualizerMode> getEqualizerMode() {
            return this.equalizerMode;
        }

        public final List<EqualizerMode> getEqualizerModeByColor() {
            return this.equalizerModeByColor;
        }

        public final List<EqualizerMode> getEqualizerModeByColorId(int colorId) {
            ArrayList arrayList = new ArrayList();
            List<EqualizerMode> list = this.equalizerModeCompat;
            if (list != null) {
                arrayList.addAll(list);
            }
            List<EqualizerMode> list2 = this.equalizerModeByColor;
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list2) {
                    if (((EqualizerMode) obj).getColorId() == colorId) {
                        arrayList2.add(obj);
                    }
                }
                arrayList.addAll(arrayList2);
            }
            List<EqualizerMode> list3 = this.equalizerModeByVersion;
            if (list3 != null) {
                HeyMelodyApplication heyMelodyApplication = C0906l.f19501a;
                if (heyMelodyApplication == null) {
                    h.i("context");
                    throw null;
                }
                int i10 = S.i(heyMelodyApplication);
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : list3) {
                    if (i10 >= ((EqualizerMode) obj2).getMinAppVersion()) {
                        arrayList3.add(obj2);
                    }
                }
                arrayList.addAll(arrayList3);
            }
            List<EqualizerMode> list4 = this.equalizerMode;
            if (list4 != null) {
                arrayList.addAll(list4);
            }
            final C7.d dVar = new C7.d(0);
            Comparator comparatorComparingInt = Comparator.comparingInt(new ToIntFunction() { // from class: C7.e
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj3) {
                    return WhitelistConfigDTO.Function.getEqualizerModeByColorId$lambda$5(dVar, obj3);
                }
            });
            h.d(comparatorComparingInt, "comparingInt(...)");
            o.n(arrayList, comparatorComparingInt);
            return arrayList;
        }

        public final List<EqualizerMode> getEqualizerModeByVersion() {
            return this.equalizerModeByVersion;
        }

        public final List<EqualizerMode> getEqualizerModeCompat() {
            return this.equalizerModeCompat;
        }

        public final int getFastDiscovery() {
            return this.fastDiscovery;
        }

        public final int getFeedback() {
            return this.feedback;
        }

        public final int getFindDevice() {
            return this.findDevice;
        }

        public final int getFirmwareCheckCommandId() {
            return this.firmwareCheckCommandId;
        }

        public final int getFirmwareDiscovery() {
            return this.firmwareDiscovery;
        }

        public final int getFirmwareFileCheckFlags() {
            return this.firmwareFileCheckFlags;
        }

        public final int getFirmwareTrack() {
            return this.firmwareTrack;
        }

        public final int getFitDetection() {
            return this.fitDetection;
        }

        public final int getFunctionGuide() {
            return this.functionGuide;
        }

        public final int getFunctionIntroductionGuide() {
            return this.functionIntroductionGuide;
        }

        public final List<String> getGameEqPkgList() {
            return this.gameEqPkgList;
        }

        public final int getGameMode() {
            return this.gameMode;
        }

        public final List<GameMode> getGameModeList() {
            return this.gameModeList;
        }

        public final List<GameSound> getGameSoundList() {
            return this.gameSoundList;
        }

        public final List<Integer> getGameSoundMutexes() {
            return this.gameSoundMutexes;
        }

        public final int getHeadMotion() {
            return this.headMotion;
        }

        public final int getHeadSetSoundRecord() {
            return this.headSetSoundRecord;
        }

        public final int getHeadsetFeedback() {
            return this.headsetFeedback;
        }

        public final int getHearingEnhancement() {
            return this.hearingEnhancement;
        }

        public final int getHearingEnhancementNew() {
            return this.hearingEnhancementNew;
        }

        public final int getHearingJudgeDb() {
            return this.hearingJudgeDb;
        }

        public final int getHearingOptimize() {
            return this.hearingOptimize;
        }

        public final int getHeyFindDevice() {
            return this.heyFindDevice;
        }

        public final int getHeyMelodyDownload() {
            return this.heyMelodyDownload;
        }

        public final int getHideFromUIList() {
            return this.hideFromUIList;
        }

        public final int getHighAudio() {
            return this.highAudio;
        }

        public final int getHighToneQuality() {
            return this.highToneQuality;
        }

        public final int getHoldInBoxPairing() {
            return this.holdInBoxPairing;
        }

        public final int getHonorWall() {
            return this.honorWall;
        }

        public final int getImmersiveRecord() {
            return this.immersiveRecord;
        }

        public final int getInBoxStatus() {
            return this.inBoxStatus;
        }

        public final int getIncomingCallControl() {
            return this.incomingCallControl;
        }

        public final List<Integer> getIntroductionGuideList() {
            return this.introductionGuideList;
        }

        public final List<LeFilterFunction> getLeFilterFunctions() {
            return this.leFilterFunctions;
        }

        public final int getLongPowerMode() {
            return this.longPowerMode;
        }

        public final int getLongPressType() {
            return this.longPressType;
        }

        public final int getLongPressVolume() {
            return this.longPressVolume;
        }

        public final int getMeetingAssistant() {
            return this.meetingAssistant;
        }

        public final int getMinOtaBattery() {
            return this.minOtaBattery;
        }

        public final List<MultiConnectFunction> getMultiConnectFunctions() {
            return this.multiConnectFunctions;
        }

        public final int getMultiDevicesConnect() {
            return this.multiDevicesConnect;
        }

        public final List<Control> getMusicControl() {
            return this.musicControl;
        }

        public final List<String> getMutexFunctions() {
            return this.mutexFunctions;
        }

        public final int getNewFunctionGuide() {
            return this.newFunctionGuide;
        }

        public final List<NoiseReductionMode> getNoiseReductionMode() {
            return this.noiseReductionMode;
        }

        public final int getNoiseReductionUIVersion() {
            return this.noiseReductionUIVersion;
        }

        public final int getOpenBoxPairing() {
            return this.openBoxPairing;
        }

        public final int getOpsReduction() {
            return this.opsReduction;
        }

        public final int getPairingInBoxCount() {
            return this.pairingInBoxCount;
        }

        public final int getPairingModeTip() {
            return this.pairingModeTip;
        }

        public final int getPersonalNoise() {
            return this.personalNoise;
        }

        public final PersonalNoiseCompat getPersonalNoiseCompat() {
            return this.personalNoiseCompat;
        }

        public final int getPromptVolume() {
            return this.promptVolume;
        }

        public final PromptVolumeRange getPromptVolumeRange() {
            return this.promptVolumeRange;
        }

        public final int getRelated() {
            return this.related;
        }

        public final int getRlmMoreFunction() {
            return this.rlmMoreFunction;
        }

        public final boolean getShowTurnAutoSwitchOnDialog() {
            return this.showTurnAutoSwitchOnDialog;
        }

        public final int getSleepDetection() {
            return this.sleepDetection;
        }

        public final int getSmartCall() {
            return this.smartCall;
        }

        public final int getSpatialDescriptionType() {
            return this.spatialDescriptionType;
        }

        public final int getSpatialEarphoneFirst() {
            return this.spatialEarphoneFirst;
        }

        public final int getSpatialHiResMutex() {
            return this.spatialHiResMutex;
        }

        public final List<Integer> getSpatialTypes() {
            return this.spatialTypes;
        }

        public final int getSpatialVip() {
            return this.spatialVip;
        }

        public final int getSpeechPerception() {
            return this.speechPerception;
        }

        public final int getSpineHealth() {
            return this.spineHealth;
        }

        public final int getSpyTap() {
            return this.spyTap;
        }

        public final int getStrongNoiseReductionRealTime() {
            return this.strongNoiseReductionRealTime;
        }

        public final int getSupportPinch() {
            return this.supportPinch;
        }

        public final int getSwiftPair() {
            return this.swiftPair;
        }

        public final int getTapLevelSetting() {
            return this.tapLevelSetting;
        }

        public final int getTutorialGuide() {
            return this.tutorialGuide;
        }

        public final int getUpgradeMtu() {
            return this.upgradeMtu;
        }

        public final int getVocalEnhance() {
            return this.vocalEnhance;
        }

        public final int getVoiceCommand() {
            return this.voiceCommand;
        }

        public final List<Integer> getVoiceCommandItems() {
            return this.voiceCommandItems;
        }

        public final int getVoiceWake() {
            return this.voiceWake;
        }

        public final int getWearDetection() {
            return this.wearDetection;
        }

        public final int getWearingVideoTutorial() {
            return this.wearingVideoTutorial;
        }

        public final int getWhiteNoise() {
            return this.whiteNoise;
        }

        public final int getZenMode() {
            return this.zenMode;
        }

        public final void setAdaptiveEar(int i10) {
            this.adaptiveEar = i10;
        }

        public final void setAdaptiveVolume(int i10) {
            this.adaptiveVolume = i10;
        }

        public final void setAiClearCall(int i10) {
            this.aiClearCall = i10;
        }

        public final void setAiSummary(int i10) {
            this.aiSummary = i10;
        }

        public final void setAiSummaryToneSource(int i10) {
            this.aiSummaryToneSource = i10;
        }

        public final void setAiTranslate(int i10) {
            this.aiTranslate = i10;
        }

        public final void setAiTranslateCompat(AiTranslateCompat aiTranslateCompat) {
            this.aiTranslateCompat = aiTranslateCompat;
        }

        public final void setAppUpdateRemindVersion(int i10) {
            this.appUpdateRemindVersion = i10;
        }

        public final void setAutoBTBond(int i10) {
            this.autoBTBond = i10;
        }

        public final void setAutoFirmwareUpdate(int i10) {
            this.autoFirmwareUpdate = i10;
        }

        public final void setAutoSwitchLink(int i10) {
            this.autoSwitchLink = i10;
        }

        public final void setBassEngineSupport(int i10) {
            this.bassEngineSupport = i10;
        }

        public final void setBatteryInfo(int i10) {
            this.batteryInfo = i10;
        }

        public final void setBatteryRadix(int i10) {
            this.batteryRadix = i10;
        }

        public final void setBrLeCoexist(int i10) {
            this.brLeCoexist = i10;
        }

        public final void setCallControl(List<Control> list) {
            this.callControl = list;
        }

        public final void setCarouselDress(int i10) {
            this.carouselDress = i10;
        }

        public final void setCleanGuide(int i10) {
            this.cleanGuide = i10;
        }

        public final void setClickTakePic(int i10) {
            this.clickTakePic = i10;
        }

        public final void setClickTakePicNew(int i10) {
            this.clickTakePicNew = i10;
        }

        public final void setCollectLogs(int i10) {
            this.collectLogs = i10;
        }

        public final void setControl(List<Control> list) {
            this.control = list;
        }

        public final void setControlAutoVolumeSupport(int i10) {
            this.controlAutoVolumeSupport = i10;
        }

        public final void setControlGuideSupport(int i10) {
            this.controlGuideSupport = i10;
        }

        public final void setControlList(List<ControlList> list) {
            this.controlList = list;
        }

        public final void setCustomDress(int i10) {
            this.customDress = i10;
        }

        public final void setCustomEqFrequency(List<Integer> list) {
            this.customEqFrequency = list;
        }

        public final void setCustomEqMax(int i10) {
            this.customEqMax = i10;
        }

        public final void setCustomEqUiVersion(int i10) {
            this.customEqUiVersion = i10;
        }

        public final void setCustomEqualizer(int i10) {
            this.customEqualizer = i10;
        }

        public final void setDefaultSoundChannelSwitchOn(int i10) {
            this.defaultSoundChannelSwitchOn = i10;
        }

        public final void setDeviceInfo(int i10) {
            this.deviceInfo = i10;
        }

        public final void setDeviceLostRemind(int i10) {
            this.deviceLostRemind = i10;
        }

        public final void setDiagnostic(int i10) {
            this.diagnostic = i10;
        }

        public final void setDialogTags(List<Integer> list) {
            this.dialogTags = list;
        }

        public final void setDolbyAtmos(int i10) {
            this.dolbyAtmos = i10;
        }

        public final void setDressFilterList(List<DressFilter> list) {
            this.dressFilterList = list;
        }

        public final void setEarScan(int i10) {
            this.earScan = i10;
        }

        public final void setEqualizer(int i10) {
            this.equalizer = i10;
        }

        public final void setEqualizerMode(List<EqualizerMode> list) {
            this.equalizerMode = list;
        }

        public final void setEqualizerModeByColor(List<EqualizerMode> list) {
            this.equalizerModeByColor = list;
        }

        public final void setEqualizerModeByVersion(List<EqualizerMode> list) {
            this.equalizerModeByVersion = list;
        }

        public final void setEqualizerModeCompat(List<EqualizerMode> list) {
            this.equalizerModeCompat = list;
        }

        public final void setFastDiscovery(int i10) {
            this.fastDiscovery = i10;
        }

        public final void setFeedback(int i10) {
            this.feedback = i10;
        }

        public final void setFindDevice(int i10) {
            this.findDevice = i10;
        }

        public final void setFirmwareCheckCommandId(int i10) {
            this.firmwareCheckCommandId = i10;
        }

        public final void setFirmwareDiscovery(int i10) {
            this.firmwareDiscovery = i10;
        }

        public final void setFirmwareFileCheckFlags(int i10) {
            this.firmwareFileCheckFlags = i10;
        }

        public final void setFirmwareTrack(int i10) {
            this.firmwareTrack = i10;
        }

        public final void setFitDetection(int i10) {
            this.fitDetection = i10;
        }

        public final void setFunctionGuide(int i10) {
            this.functionGuide = i10;
        }

        public final void setFunctionIntroductionGuide(int i10) {
            this.functionIntroductionGuide = i10;
        }

        public final void setGameEqPkgList(List<String> list) {
            this.gameEqPkgList = list;
        }

        public final void setGameMode(int i10) {
            this.gameMode = i10;
        }

        public final void setGameModeList(List<GameMode> list) {
            this.gameModeList = list;
        }

        public final void setGameSoundList(List<GameSound> list) {
            this.gameSoundList = list;
        }

        public final void setGameSoundMutexes(List<Integer> list) {
            this.gameSoundMutexes = list;
        }

        public final void setHeadMotion(int i10) {
            this.headMotion = i10;
        }

        public final void setHeadSetSoundRecord(int i10) {
            this.headSetSoundRecord = i10;
        }

        public final void setHeadsetFeedback(int i10) {
            this.headsetFeedback = i10;
        }

        public final void setHearingEnhancement(int i10) {
            this.hearingEnhancement = i10;
        }

        public final void setHearingEnhancementNew(int i10) {
            this.hearingEnhancementNew = i10;
        }

        public final void setHearingJudgeDb(int i10) {
            this.hearingJudgeDb = i10;
        }

        public final void setHearingOptimize(int i10) {
            this.hearingOptimize = i10;
        }

        public final void setHeyFindDevice(int i10) {
            this.heyFindDevice = i10;
        }

        public final void setHeyMelodyDownload(int i10) {
            this.heyMelodyDownload = i10;
        }

        public final void setHideFromUIList(int i10) {
            this.hideFromUIList = i10;
        }

        public final void setHighAudio(int i10) {
            this.highAudio = i10;
        }

        public final void setHighToneQuality(int i10) {
            this.highToneQuality = i10;
        }

        public final void setHoldInBoxPairing(int i10) {
            this.holdInBoxPairing = i10;
        }

        public final void setHonorWall(int i10) {
            this.honorWall = i10;
        }

        public final void setImmersiveRecord(int i10) {
            this.immersiveRecord = i10;
        }

        public final void setInBoxStatus(int i10) {
            this.inBoxStatus = i10;
        }

        public final void setIncomingCallControl(int i10) {
            this.incomingCallControl = i10;
        }

        public final void setIntroductionGuideList(List<Integer> list) {
            this.introductionGuideList = list;
        }

        public final void setLeFilterFunctions(List<LeFilterFunction> list) {
            this.leFilterFunctions = list;
        }

        public final void setLongPowerMode(int i10) {
            this.longPowerMode = i10;
        }

        public final void setLongPressType(int i10) {
            this.longPressType = i10;
        }

        public final void setLongPressVolume(int i10) {
            this.longPressVolume = i10;
        }

        public final void setMeetingAssistant(int i10) {
            this.meetingAssistant = i10;
        }

        public final void setMinOtaBattery(int i10) {
            this.minOtaBattery = i10;
        }

        public final void setMultiConnectFunctions(List<MultiConnectFunction> list) {
            this.multiConnectFunctions = list;
        }

        public final void setMultiDevicesConnect(int i10) {
            this.multiDevicesConnect = i10;
        }

        public final void setMusicControl(List<Control> list) {
            this.musicControl = list;
        }

        public final void setMutexFunctions(List<String> list) {
            this.mutexFunctions = list;
        }

        public final void setNewFunctionGuide(int i10) {
            this.newFunctionGuide = i10;
        }

        public final void setNoiseReductionMode(List<NoiseReductionMode> list) {
            this.noiseReductionMode = list;
        }

        public final void setNoiseReductionUIVersion(int i10) {
            this.noiseReductionUIVersion = i10;
        }

        public final void setOpenBoxPairing(int i10) {
            this.openBoxPairing = i10;
        }

        public final void setOpsReduction(int i10) {
            this.opsReduction = i10;
        }

        public final void setPairingInBoxCount(int i10) {
            this.pairingInBoxCount = i10;
        }

        public final void setPairingModeTip(int i10) {
            this.pairingModeTip = i10;
        }

        public final void setPersonalNoise(int i10) {
            this.personalNoise = i10;
        }

        public final void setPersonalNoiseCompat(PersonalNoiseCompat personalNoiseCompat) {
            this.personalNoiseCompat = personalNoiseCompat;
        }

        public final void setPromptVolume(int i10) {
            this.promptVolume = i10;
        }

        public final void setPromptVolumeRange(PromptVolumeRange promptVolumeRange) {
            this.promptVolumeRange = promptVolumeRange;
        }

        public final void setRelated(int i10) {
            this.related = i10;
        }

        public final void setRlmMoreFunction(int i10) {
            this.rlmMoreFunction = i10;
        }

        public final void setShowTurnAutoSwitchOnDialog(boolean z2) {
            this.showTurnAutoSwitchOnDialog = z2;
        }

        public final void setSleepDetection(int i10) {
            this.sleepDetection = i10;
        }

        public final void setSmartCall(int i10) {
            this.smartCall = i10;
        }

        public final void setSpatialDescriptionType(int i10) {
            this.spatialDescriptionType = i10;
        }

        public final void setSpatialEarphoneFirst(int i10) {
            this.spatialEarphoneFirst = i10;
        }

        public final void setSpatialHiResMutex(int i10) {
            this.spatialHiResMutex = i10;
        }

        public final void setSpatialTypes(List<Integer> list) {
            this.spatialTypes = list;
        }

        public final void setSpatialVip(int i10) {
            this.spatialVip = i10;
        }

        public final void setSpeechPerception(int i10) {
            this.speechPerception = i10;
        }

        public final void setSpineHealth(int i10) {
            this.spineHealth = i10;
        }

        public final void setSpyTap(int i10) {
            this.spyTap = i10;
        }

        public final void setStrongNoiseReductionRealTime(int i10) {
            this.strongNoiseReductionRealTime = i10;
        }

        public final void setSupportPinch(int i10) {
            this.supportPinch = i10;
        }

        public final void setSwiftPair(int i10) {
            this.swiftPair = i10;
        }

        public final void setTapLevelSetting(int i10) {
            this.tapLevelSetting = i10;
        }

        public final void setTutorialGuide(int i10) {
            this.tutorialGuide = i10;
        }

        public final void setUpgradeMtu(int i10) {
            this.upgradeMtu = i10;
        }

        public final void setVocalEnhance(int i10) {
            this.vocalEnhance = i10;
        }

        public final void setVoiceCommand(int i10) {
            this.voiceCommand = i10;
        }

        public final void setVoiceCommandItems(List<Integer> list) {
            this.voiceCommandItems = list;
        }

        public final void setVoiceWake(int i10) {
            this.voiceWake = i10;
        }

        public final void setWearDetection(int i10) {
            this.wearDetection = i10;
        }

        public final void setWearingVideoTutorial(int i10) {
            this.wearingVideoTutorial = i10;
        }

        public final void setWhiteNoise(int i10) {
            this.whiteNoise = i10;
        }

        public final void setZenMode(int i10) {
            this.zenMode = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.opsReduction);
            dest.writeInt(this.zenMode);
            dest.writeInt(this.batteryInfo);
            dest.writeInt(this.heyMelodyDownload);
            dest.writeInt(this.batteryRadix);
            dest.writeInt(this.equalizer);
            dest.writeInt(this.customEqualizer);
            dest.writeInt(this.customEqMax);
            dest.writeInt(this.findDevice);
            dest.writeInt(this.headMotion);
            dest.writeInt(this.heyFindDevice);
            dest.writeInt(this.dolbyAtmos);
            dest.writeInt(this.fitDetection);
            dest.writeInt(this.autoFirmwareUpdate);
            dest.writeInt(this.wearDetection);
            dest.writeInt(this.inBoxStatus);
            dest.writeInt(this.clickTakePic);
            dest.writeInt(this.clickTakePicNew);
            dest.writeInt(this.headSetSoundRecord);
            dest.writeInt(this.immersiveRecord);
            dest.writeInt(this.vocalEnhance);
            dest.writeInt(this.personalNoise);
            dest.writeInt(this.functionGuide);
            dest.writeInt(this.fastDiscovery);
            dest.writeInt(this.firmwareDiscovery);
            dest.writeInt(this.openBoxPairing);
            dest.writeInt(this.holdInBoxPairing);
            dest.writeInt(this.pairingModeTip);
            dest.writeInt(this.hideFromUIList);
            List<Control> list = this.control;
            if (list == null) {
                dest.writeInt(0);
            } else {
                Iterator itG = e.g(dest, 1, list);
                while (itG.hasNext()) {
                    ((Control) itG.next()).writeToParcel(dest, flags);
                }
            }
            List<Control> list2 = this.callControl;
            if (list2 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG2 = e.g(dest, 1, list2);
                while (itG2.hasNext()) {
                    ((Control) itG2.next()).writeToParcel(dest, flags);
                }
            }
            List<Control> list3 = this.musicControl;
            if (list3 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG3 = e.g(dest, 1, list3);
                while (itG3.hasNext()) {
                    ((Control) itG3.next()).writeToParcel(dest, flags);
                }
            }
            List<ControlList> list4 = this.controlList;
            if (list4 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG4 = e.g(dest, 1, list4);
                while (itG4.hasNext()) {
                    ((ControlList) itG4.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.firmwareCheckCommandId);
            dest.writeInt(this.firmwareFileCheckFlags);
            dest.writeInt(this.promptVolume);
            PromptVolumeRange promptVolumeRange = this.promptVolumeRange;
            if (promptVolumeRange == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                promptVolumeRange.writeToParcel(dest, flags);
            }
            dest.writeInt(this.noiseReductionUIVersion);
            List<NoiseReductionMode> list5 = this.noiseReductionMode;
            if (list5 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG5 = e.g(dest, 1, list5);
                while (itG5.hasNext()) {
                    ((NoiseReductionMode) itG5.next()).writeToParcel(dest, flags);
                }
            }
            List<EqualizerMode> list6 = this.equalizerMode;
            if (list6 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG6 = e.g(dest, 1, list6);
                while (itG6.hasNext()) {
                    ((EqualizerMode) itG6.next()).writeToParcel(dest, flags);
                }
            }
            List<EqualizerMode> list7 = this.equalizerModeCompat;
            if (list7 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG7 = e.g(dest, 1, list7);
                while (itG7.hasNext()) {
                    ((EqualizerMode) itG7.next()).writeToParcel(dest, flags);
                }
            }
            List<EqualizerMode> list8 = this.equalizerModeByColor;
            if (list8 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG8 = e.g(dest, 1, list8);
                while (itG8.hasNext()) {
                    ((EqualizerMode) itG8.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.longPressType);
            List<EqualizerMode> list9 = this.equalizerModeByVersion;
            if (list9 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG9 = e.g(dest, 1, list9);
                while (itG9.hasNext()) {
                    ((EqualizerMode) itG9.next()).writeToParcel(dest, flags);
                }
            }
            PersonalNoiseCompat personalNoiseCompat = this.personalNoiseCompat;
            if (personalNoiseCompat == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                personalNoiseCompat.writeToParcel(dest, flags);
            }
            AiTranslateCompat aiTranslateCompat = this.aiTranslateCompat;
            if (aiTranslateCompat == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                aiTranslateCompat.writeToParcel(dest, flags);
            }
            List<Integer> list10 = this.introductionGuideList;
            if (list10 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG10 = e.g(dest, 1, list10);
                while (itG10.hasNext()) {
                    dest.writeInt(((Number) itG10.next()).intValue());
                }
            }
            dest.writeInt(this.hearingEnhancement);
            dest.writeInt(this.hearingEnhancementNew);
            dest.writeInt(this.hearingJudgeDb);
            dest.writeInt(this.earScan);
            dest.writeInt(this.multiDevicesConnect);
            List<MultiConnectFunction> list11 = this.multiConnectFunctions;
            if (list11 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG11 = e.g(dest, 1, list11);
                while (itG11.hasNext()) {
                    ((MultiConnectFunction) itG11.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.smartCall);
            dest.writeInt(this.highToneQuality);
            dest.writeInt(this.highAudio);
            dest.writeInt(this.voiceWake);
            dest.writeInt(this.voiceCommand);
            List<Integer> list12 = this.voiceCommandItems;
            if (list12 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG12 = e.g(dest, 1, list12);
                while (itG12.hasNext()) {
                    dest.writeInt(((Number) itG12.next()).intValue());
                }
            }
            dest.writeInt(this.incomingCallControl);
            dest.writeInt(this.longPowerMode);
            dest.writeInt(this.deviceLostRemind);
            dest.writeInt(this.related);
            dest.writeInt(this.gameMode);
            List<GameMode> list13 = this.gameModeList;
            if (list13 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG13 = e.g(dest, 1, list13);
                while (itG13.hasNext()) {
                    ((GameMode) itG13.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.collectLogs);
            dest.writeInt(this.controlGuideSupport);
            dest.writeInt(this.controlAutoVolumeSupport);
            dest.writeInt(this.longPressVolume);
            dest.writeInt(this.tapLevelSetting);
            dest.writeInt(this.diagnostic);
            dest.writeInt(this.aiSummary);
            dest.writeInt(this.aiSummaryToneSource);
            dest.writeInt(this.aiClearCall);
            dest.writeInt(this.aiTranslate);
            dest.writeInt(this.functionIntroductionGuide);
            dest.writeInt(this.bassEngineSupport);
            dest.writeInt(this.spineHealth);
            List<Integer> list14 = this.spatialTypes;
            if (list14 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG14 = e.g(dest, 1, list14);
                while (itG14.hasNext()) {
                    dest.writeInt(((Number) itG14.next()).intValue());
                }
            }
            dest.writeInt(this.spatialVip);
            dest.writeInt(this.supportPinch);
            dest.writeStringList(this.gameEqPkgList);
            Integer num = this.gameEqualizer;
            if (num == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(num.intValue());
            }
            List<GameSound> list15 = this.gameSoundList;
            if (list15 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG15 = e.g(dest, 1, list15);
                while (itG15.hasNext()) {
                    ((GameSound) itG15.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.rlmMoreFunction);
            dest.writeInt(this.autoSwitchLink);
            dest.writeInt(this.autoBTBond);
            dest.writeInt(this.feedback);
            dest.writeInt(this.showTurnAutoSwitchOnDialog ? 1 : 0);
            List<LeFilterFunction> list16 = this.leFilterFunctions;
            if (list16 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG16 = e.g(dest, 1, list16);
                while (itG16.hasNext()) {
                    ((LeFilterFunction) itG16.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.customDress);
            dest.writeInt(this.carouselDress);
            dest.writeInt(this.spatialDescriptionType);
            dest.writeInt(this.minOtaBattery);
            dest.writeInt(this.spatialHiResMutex);
            List<Integer> list17 = this.gameSoundMutexes;
            if (list17 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG17 = e.g(dest, 1, list17);
                while (itG17.hasNext()) {
                    dest.writeInt(((Number) itG17.next()).intValue());
                }
            }
            dest.writeInt(this.cleanGuide);
            dest.writeInt(this.honorWall);
            dest.writeInt(this.strongNoiseReductionRealTime);
            List<Integer> list18 = this.dialogTags;
            if (list18 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG18 = e.g(dest, 1, list18);
                while (itG18.hasNext()) {
                    dest.writeInt(((Number) itG18.next()).intValue());
                }
            }
            dest.writeInt(this.tutorialGuide);
            dest.writeInt(this.wearingVideoTutorial);
            dest.writeInt(this.adaptiveVolume);
            dest.writeInt(this.adaptiveEar);
            dest.writeInt(this.speechPerception);
            dest.writeInt(this.firmwareTrack);
            dest.writeInt(this.meetingAssistant);
            dest.writeInt(this.spatialEarphoneFirst);
            dest.writeInt(this.defaultSoundChannelSwitchOn);
            List<Integer> list19 = this.customEqFrequency;
            if (list19 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG19 = e.g(dest, 1, list19);
                while (itG19.hasNext()) {
                    dest.writeInt(((Number) itG19.next()).intValue());
                }
            }
            dest.writeInt(this.spyTap);
            dest.writeInt(this.swiftPair);
            dest.writeInt(this.hearingOptimize);
            dest.writeInt(this.customEqUiVersion);
            dest.writeInt(this.appUpdateRemindVersion);
            List<DressFilter> list20 = this.dressFilterList;
            if (list20 == null) {
                dest.writeInt(0);
            } else {
                Iterator itG20 = e.g(dest, 1, list20);
                while (itG20.hasNext()) {
                    ((DressFilter) itG20.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.whiteNoise);
            dest.writeInt(this.sleepDetection);
            dest.writeInt(this.deviceInfo);
            dest.writeInt(this.upgradeMtu);
            dest.writeInt(this.brLeCoexist);
            dest.writeStringList(this.mutexFunctions);
            dest.writeInt(this.pairingInBoxCount);
            dest.writeInt(this.newFunctionGuide);
            dest.writeInt(this.headsetFeedback);
        }

        public Function(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, List<Control> list, List<Control> list2, List<Control> list3, List<ControlList> list4, int i39, int i40, int i41, PromptVolumeRange promptVolumeRange, int i42, List<NoiseReductionMode> list5, List<EqualizerMode> list6, List<EqualizerMode> list7, List<EqualizerMode> list8, int i43, List<EqualizerMode> list9, PersonalNoiseCompat personalNoiseCompat, AiTranslateCompat aiTranslateCompat, List<Integer> list10, int i44, int i45, int i46, int i47, int i48, List<MultiConnectFunction> list11, int i49, int i50, int i51, int i52, int i53, List<Integer> list12, int i54, int i55, int i56, int i57, int i58, List<GameMode> list13, int i59, int i60, int i61, int i62, int i63, int i64, int i65, int i66, int i67, int i68, int i69, int i70, int i71, List<Integer> list14, int i72, int i73, List<String> list15, Integer num, List<GameSound> list16, int i74, int i75, int i76, int i77, boolean z2, List<LeFilterFunction> list17, int i78, int i79, int i80, int i81, int i82, List<Integer> list18, int i83, int i84, int i85, List<Integer> list19, int i86, int i87, int i88, int i89, int i90, int i91, int i92, int i93, int i94, List<Integer> list20, int i95, int i96, int i97, int i98, int i99, List<DressFilter> list21, int i100, int i101, int i102, int i103, int i104, List<String> list22, int i105, int i106, int i107) {
            this.opsReduction = i10;
            this.zenMode = i11;
            this.batteryInfo = i12;
            this.heyMelodyDownload = i13;
            this.batteryRadix = i14;
            this.equalizer = i15;
            this.customEqualizer = i16;
            this.customEqMax = i17;
            this.findDevice = i18;
            this.headMotion = i19;
            this.heyFindDevice = i20;
            this.dolbyAtmos = i21;
            this.fitDetection = i22;
            this.autoFirmwareUpdate = i23;
            this.wearDetection = i24;
            this.inBoxStatus = i25;
            this.clickTakePic = i26;
            this.clickTakePicNew = i27;
            this.headSetSoundRecord = i28;
            this.immersiveRecord = i29;
            this.vocalEnhance = i30;
            this.personalNoise = i31;
            this.functionGuide = i32;
            this.fastDiscovery = i33;
            this.firmwareDiscovery = i34;
            this.openBoxPairing = i35;
            this.holdInBoxPairing = i36;
            this.pairingModeTip = i37;
            this.hideFromUIList = i38;
            this.control = list;
            this.callControl = list2;
            this.musicControl = list3;
            this.controlList = list4;
            this.firmwareCheckCommandId = i39;
            this.firmwareFileCheckFlags = i40;
            this.promptVolume = i41;
            this.promptVolumeRange = promptVolumeRange;
            this.noiseReductionUIVersion = i42;
            this.noiseReductionMode = list5;
            this.equalizerMode = list6;
            this.equalizerModeCompat = list7;
            this.equalizerModeByColor = list8;
            this.longPressType = i43;
            this.equalizerModeByVersion = list9;
            this.personalNoiseCompat = personalNoiseCompat;
            this.aiTranslateCompat = aiTranslateCompat;
            this.introductionGuideList = list10;
            this.hearingEnhancement = i44;
            this.hearingEnhancementNew = i45;
            this.hearingJudgeDb = i46;
            this.earScan = i47;
            this.multiDevicesConnect = i48;
            this.multiConnectFunctions = list11;
            this.smartCall = i49;
            this.highToneQuality = i50;
            this.highAudio = i51;
            this.voiceWake = i52;
            this.voiceCommand = i53;
            this.voiceCommandItems = list12;
            this.incomingCallControl = i54;
            this.longPowerMode = i55;
            this.deviceLostRemind = i56;
            this.related = i57;
            this.gameMode = i58;
            this.gameModeList = list13;
            this.collectLogs = i59;
            this.controlGuideSupport = i60;
            this.controlAutoVolumeSupport = i61;
            this.longPressVolume = i62;
            this.tapLevelSetting = i63;
            this.diagnostic = i64;
            this.aiSummary = i65;
            this.aiSummaryToneSource = i66;
            this.aiClearCall = i67;
            this.aiTranslate = i68;
            this.functionIntroductionGuide = i69;
            this.bassEngineSupport = i70;
            this.spineHealth = i71;
            this.spatialTypes = list14;
            this.spatialVip = i72;
            this.supportPinch = i73;
            this.gameEqPkgList = list15;
            this.gameEqualizer = num;
            this.gameSoundList = list16;
            this.rlmMoreFunction = i74;
            this.autoSwitchLink = i75;
            this.autoBTBond = i76;
            this.feedback = i77;
            this.showTurnAutoSwitchOnDialog = z2;
            this.leFilterFunctions = list17;
            this.customDress = i78;
            this.carouselDress = i79;
            this.spatialDescriptionType = i80;
            this.minOtaBattery = i81;
            this.spatialHiResMutex = i82;
            this.gameSoundMutexes = list18;
            this.cleanGuide = i83;
            this.honorWall = i84;
            this.strongNoiseReductionRealTime = i85;
            this.dialogTags = list19;
            this.tutorialGuide = i86;
            this.wearingVideoTutorial = i87;
            this.adaptiveVolume = i88;
            this.adaptiveEar = i89;
            this.speechPerception = i90;
            this.firmwareTrack = i91;
            this.meetingAssistant = i92;
            this.spatialEarphoneFirst = i93;
            this.defaultSoundChannelSwitchOn = i94;
            this.customEqFrequency = list20;
            this.spyTap = i95;
            this.swiftPair = i96;
            this.hearingOptimize = i97;
            this.customEqUiVersion = i98;
            this.appUpdateRemindVersion = i99;
            this.dressFilterList = list21;
            this.whiteNoise = i100;
            this.sleepDetection = i101;
            this.deviceInfo = i102;
            this.upgradeMtu = i103;
            this.brLeCoexist = i104;
            this.mutexFunctions = list22;
            this.pairingInBoxCount = i105;
            this.newFunctionGuide = i106;
            this.headsetFeedback = i107;
        }

        private static /* synthetic */ void getGameEqualizer$annotations() {
        }

        public static /* synthetic */ void getHeyFindDevice$annotations() {
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Function(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, List list, List list2, List list3, List list4, int i39, int i40, int i41, PromptVolumeRange promptVolumeRange, int i42, List list5, List list6, List list7, List list8, int i43, List list9, PersonalNoiseCompat personalNoiseCompat, AiTranslateCompat aiTranslateCompat, List list10, int i44, int i45, int i46, int i47, int i48, List list11, int i49, int i50, int i51, int i52, int i53, List list12, int i54, int i55, int i56, int i57, int i58, List list13, int i59, int i60, int i61, int i62, int i63, int i64, int i65, int i66, int i67, int i68, int i69, int i70, int i71, List list14, int i72, int i73, List list15, Integer num, List list16, int i74, int i75, int i76, int i77, boolean z2, List list17, int i78, int i79, int i80, int i81, int i82, List list18, int i83, int i84, int i85, List list19, int i86, int i87, int i88, int i89, int i90, int i91, int i92, int i93, int i94, List list20, int i95, int i96, int i97, int i98, int i99, List list21, int i100, int i101, int i102, int i103, int i104, List list22, int i105, int i106, int i107, int i108, int i109, int i110, int i111, d dVar) {
            int i112 = (i108 & 1) != 0 ? 0 : i10;
            int i113 = (i108 & 2) != 0 ? 0 : i11;
            int i114 = (i108 & 4) != 0 ? 1 : i12;
            int i115 = (i108 & 8) != 0 ? 1 : i13;
            int i116 = (i108 & 16) != 0 ? 10 : i14;
            int i117 = (i108 & 32) != 0 ? -1 : i15;
            int i118 = (i108 & 64) != 0 ? -1 : i16;
            int i119 = (i108 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 3 : i17;
            int i120 = (i108 & 256) != 0 ? -1 : i18;
            int i121 = (i108 & 512) != 0 ? -1 : i19;
            int i122 = (i108 & 1024) != 0 ? -1 : i20;
            int i123 = (i108 & 2048) != 0 ? -1 : i21;
            int i124 = i112;
            int i125 = (i108 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? -1 : i22;
            int i126 = (i108 & 8192) != 0 ? -1 : i23;
            int i127 = (i108 & 16384) != 0 ? -1 : i24;
            int i128 = (i108 & 32768) != 0 ? -1 : i25;
            int i129 = (i108 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i26;
            int i130 = (i108 & 131072) != 0 ? -1 : i27;
            int i131 = (i108 & 262144) != 0 ? -1 : i28;
            int i132 = (i108 & 524288) != 0 ? -1 : i29;
            int i133 = (i108 & 1048576) != 0 ? -1 : i30;
            int i134 = (i108 & 2097152) != 0 ? -1 : i31;
            int i135 = (i108 & 4194304) != 0 ? -1 : i32;
            int i136 = (i108 & 8388608) != 0 ? 0 : i33;
            int i137 = (i108 & 16777216) != 0 ? -1 : i34;
            int i138 = (i108 & 33554432) != 0 ? -1 : i35;
            int i139 = (i108 & 67108864) != 0 ? -1 : i36;
            int i140 = (i108 & 134217728) != 0 ? 0 : i37;
            int i141 = (i108 & 268435456) != 0 ? -1 : i38;
            List list23 = (i108 & 536870912) != 0 ? null : list;
            List list24 = (i108 & 1073741824) != 0 ? null : list2;
            List list25 = (i108 & Integer.MIN_VALUE) != 0 ? null : list3;
            List list26 = (i109 & 1) != 0 ? null : list4;
            int i142 = (i109 & 2) != 0 ? -1 : i39;
            int i143 = (i109 & 4) != 0 ? 0 : i40;
            int i144 = (i109 & 8) != 0 ? -1 : i41;
            PromptVolumeRange promptVolumeRange2 = (i109 & 16) != 0 ? null : promptVolumeRange;
            int i145 = (i109 & 32) != 0 ? 1 : i42;
            List list27 = (i109 & 64) != 0 ? null : list5;
            List list28 = list25;
            List list29 = (i109 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : list6;
            List list30 = (i109 & 256) != 0 ? null : list7;
            List list31 = (i109 & 512) != 0 ? null : list8;
            int i146 = (i109 & 1024) != 0 ? 0 : i43;
            List list32 = (i109 & 2048) != 0 ? null : list9;
            PersonalNoiseCompat personalNoiseCompat2 = (i109 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : personalNoiseCompat;
            AiTranslateCompat aiTranslateCompat2 = (i109 & 8192) != 0 ? null : aiTranslateCompat;
            List list33 = (i109 & 16384) != 0 ? null : list10;
            this(i124, i113, i114, i115, i116, i117, i118, i119, i120, i121, i122, i123, i125, i126, i127, i128, i129, i130, i131, i132, i133, i134, i135, i136, i137, i138, i139, i140, i141, list23, list24, list28, list26, i142, i143, i144, promptVolumeRange2, i145, list27, list29, list30, list31, i146, list32, personalNoiseCompat2, aiTranslateCompat2, list33, (i109 & 32768) != 0 ? -1 : i44, (i109 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i45, (i109 & 131072) != 0 ? -1 : i46, (i109 & 262144) != 0 ? -1 : i47, (i109 & 524288) != 0 ? -1 : i48, (i109 & 1048576) != 0 ? null : list11, (i109 & 2097152) != 0 ? -1 : i49, (i109 & 4194304) != 0 ? -1 : i50, (i109 & 8388608) != 0 ? -1 : i51, (i109 & 16777216) != 0 ? -1 : i52, (i109 & 33554432) != 0 ? -1 : i53, (i109 & 67108864) != 0 ? null : list12, (i109 & 134217728) != 0 ? -1 : i54, (i109 & 268435456) != 0 ? -1 : i55, (i109 & 536870912) != 0 ? -1 : i56, (i109 & 1073741824) != 0 ? -1 : i57, (i109 & Integer.MIN_VALUE) != 0 ? -1 : i58, (i110 & 1) != 0 ? null : list13, (i110 & 2) != 0 ? -1 : i59, (i110 & 4) != 0 ? -1 : i60, (i110 & 8) != 0 ? -1 : i61, (i110 & 16) != 0 ? -1 : i62, (i110 & 32) != 0 ? -1 : i63, (i110 & 64) != 0 ? -1 : i64, (i110 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? -1 : i65, (i110 & 256) != 0 ? 0 : i66, (i110 & 512) != 0 ? -1 : i67, (i110 & 1024) != 0 ? -1 : i68, (i110 & 2048) != 0 ? -1 : i69, (i110 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? -1 : i70, (i110 & 8192) != 0 ? -1 : i71, (i110 & 16384) != 0 ? null : list14, (i110 & 32768) != 0 ? 0 : i72, (i110 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i73, (i110 & 131072) != 0 ? null : list15, (i110 & 262144) != 0 ? null : num, (i110 & 524288) != 0 ? null : list16, (i110 & 1048576) != 0 ? -1 : i74, (i110 & 2097152) != 0 ? -1 : i75, (i110 & 4194304) != 0 ? -1 : i76, (i110 & 8388608) != 0 ? -1 : i77, (i110 & 16777216) != 0 ? false : z2, (i110 & 33554432) != 0 ? null : list17, (i110 & 67108864) != 0 ? -1 : i78, (i110 & 134217728) != 0 ? 1 : i79, (i110 & 268435456) != 0 ? 1 : i80, (i110 & 536870912) != 0 ? 30 : i81, (i110 & 1073741824) != 0 ? -1 : i82, (i110 & Integer.MIN_VALUE) != 0 ? null : list18, (i111 & 1) != 0 ? 0 : i83, (i111 & 2) != 0 ? 0 : i84, (i111 & 4) != 0 ? -1 : i85, (i111 & 8) != 0 ? null : list19, (i111 & 16) != 0 ? -1 : i86, (i111 & 32) != 0 ? -1 : i87, (i111 & 64) != 0 ? -1 : i88, (i111 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? -1 : i89, (i111 & 256) != 0 ? -1 : i90, (i111 & 512) != 0 ? -1 : i91, (i111 & 1024) != 0 ? -1 : i92, (i111 & 2048) != 0 ? -1 : i93, (i111 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? -1 : i94, (i111 & 8192) != 0 ? null : list20, (i111 & 16384) != 0 ? -1 : i95, (i111 & 32768) != 0 ? -1 : i96, (i111 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i97, (i111 & 131072) != 0 ? 1 : i98, (i111 & 262144) != 0 ? 0 : i99, (i111 & 524288) != 0 ? null : list21, (i111 & 1048576) != 0 ? 0 : i100, (i111 & 2097152) != 0 ? -1 : i101, (i111 & 4194304) != 0 ? -1 : i102, (i111 & 8388608) != 0 ? -1 : i103, (i111 & 16777216) != 0 ? -1 : i104, (i111 & 33554432) == 0 ? list22 : null, (i111 & 67108864) != 0 ? -1 : i105, (i111 & 134217728) != 0 ? 1 : i106, (i111 & 268435456) != 0 ? -1 : i107);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$GameMode;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "version", "", "gameMode", "<init>", "(II)V", "getVersion", "()I", "setVersion", "(I)V", "getGameMode", "setGameMode", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class GameMode extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<GameMode> CREATOR = new a();
        private int gameMode;
        private int version;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<GameMode> {
            @Override // android.os.Parcelable.Creator
            public final GameMode createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new GameMode(parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final GameMode[] newArray(int i10) {
                return new GameMode[i10];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public GameMode() {
            int i10 = 0;
            this(i10, i10, 3, null);
        }

        public static /* synthetic */ GameMode copy$default(GameMode gameMode, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = gameMode.version;
            }
            if ((i12 & 2) != 0) {
                i11 = gameMode.gameMode;
            }
            return gameMode.copy(i10, i11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getGameMode() {
            return this.gameMode;
        }

        public final GameMode copy(int version, int gameMode) {
            return new GameMode(version, gameMode);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getGameMode() {
            return this.gameMode;
        }

        public final int getVersion() {
            return this.version;
        }

        public final void setGameMode(int i10) {
            this.gameMode = i10;
        }

        public final void setVersion(int i10) {
            this.version = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.version);
            dest.writeInt(this.gameMode);
        }

        public GameMode(int i10, int i11) {
            this.version = i10;
            this.gameMode = i11;
        }

        public /* synthetic */ GameMode(int i10, int i11, int i12, d dVar) {
            this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$GameSound;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", SpeechFindManager.TYPE, "", "packageName", "", "packageNameList", "", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "getType", "()I", "setType", "(I)V", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getPackageNameList", "()Ljava/util/List;", "setPackageNameList", "(Ljava/util/List;)V", "isPackagesEmpty", "", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class GameSound extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<GameSound> CREATOR = new a();
        private String packageName;
        private List<String> packageNameList;
        private int type;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<GameSound> {
            @Override // android.os.Parcelable.Creator
            public final GameSound createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new GameSound(parcel.readInt(), parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            public final GameSound[] newArray(int i10) {
                return new GameSound[i10];
            }
        }

        public GameSound() {
            this(0, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GameSound copy$default(GameSound gameSound, int i10, String str, List list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = gameSound.type;
            }
            if ((i11 & 2) != 0) {
                str = gameSound.packageName;
            }
            if ((i11 & 4) != 0) {
                list = gameSound.packageNameList;
            }
            return gameSound.copy(i10, str, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPackageName() {
            return this.packageName;
        }

        public final List<String> component3() {
            return this.packageNameList;
        }

        public final GameSound copy(int type, String packageName, List<String> packageNameList) {
            return new GameSound(type, packageName, packageNameList);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final List<String> getPackageNameList() {
            return this.packageNameList;
        }

        public final int getType() {
            return this.type;
        }

        public final boolean isPackagesEmpty() {
            String str = this.packageName;
            if (str != null && str.length() != 0) {
                return false;
            }
            List<String> list = this.packageNameList;
            return list == null || list.isEmpty();
        }

        public final void setPackageName(String str) {
            this.packageName = str;
        }

        public final void setPackageNameList(List<String> list) {
            this.packageNameList = list;
        }

        public final void setType(int i10) {
            this.type = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.type);
            dest.writeString(this.packageName);
            dest.writeStringList(this.packageNameList);
        }

        public GameSound(int i10, String str, List<String> list) {
            this.type = i10;
            this.packageName = str;
            this.packageNameList = list;
        }

        public /* synthetic */ GameSound(int i10, String str, List list, int i11, d dVar) {
            this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004HÂ\u0003¢\u0006\u0002\u0010#JD\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\n\n\u0002\u0010\u001d\u0012\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$LeFilterFunction;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "minAppVersion", "", "minFirmVersion", "functionType", "", "needConnectSpp", "", "minVersion", "<init>", "(IILjava/lang/String;ZLjava/lang/Integer;)V", "getMinAppVersion", "()I", "setMinAppVersion", "(I)V", "getMinFirmVersion", "setMinFirmVersion", "getFunctionType", "()Ljava/lang/String;", "setFunctionType", "(Ljava/lang/String;)V", "getNeedConnectSpp", "()Z", "setNeedConnectSpp", "(Z)V", "getMinVersion$annotations", "()V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "()Ljava/lang/Integer;", "copy", "(IILjava/lang/String;ZLjava/lang/Integer;)Lcom/oplus/melody/common/data/WhitelistConfigDTO$LeFilterFunction;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LeFilterFunction extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<LeFilterFunction> CREATOR = new a();
        private String functionType;
        private int minAppVersion;
        private int minFirmVersion;
        private Integer minVersion;
        private boolean needConnectSpp;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<LeFilterFunction> {
            @Override // android.os.Parcelable.Creator
            public final LeFilterFunction createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new LeFilterFunction(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            public final LeFilterFunction[] newArray(int i10) {
                return new LeFilterFunction[i10];
            }
        }

        public LeFilterFunction() {
            this(0, 0, null, false, null, 31, null);
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        private final Integer getMinVersion() {
            return this.minVersion;
        }

        public static /* synthetic */ LeFilterFunction copy$default(LeFilterFunction leFilterFunction, int i10, int i11, String str, boolean z2, Integer num, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = leFilterFunction.minAppVersion;
            }
            if ((i12 & 2) != 0) {
                i11 = leFilterFunction.minFirmVersion;
            }
            if ((i12 & 4) != 0) {
                str = leFilterFunction.functionType;
            }
            if ((i12 & 8) != 0) {
                z2 = leFilterFunction.needConnectSpp;
            }
            if ((i12 & 16) != 0) {
                num = leFilterFunction.minVersion;
            }
            Integer num2 = num;
            String str2 = str;
            return leFilterFunction.copy(i10, i11, str2, z2, num2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMinAppVersion() {
            return this.minAppVersion;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFunctionType() {
            return this.functionType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getNeedConnectSpp() {
            return this.needConnectSpp;
        }

        public final LeFilterFunction copy(int minAppVersion, int minFirmVersion, String functionType, boolean needConnectSpp, Integer minVersion) {
            return new LeFilterFunction(minAppVersion, minFirmVersion, functionType, needConnectSpp, minVersion);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getFunctionType() {
            return this.functionType;
        }

        public final int getMinAppVersion() {
            return this.minAppVersion;
        }

        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        public final boolean getNeedConnectSpp() {
            return this.needConnectSpp;
        }

        public final void setFunctionType(String str) {
            this.functionType = str;
        }

        public final void setMinAppVersion(int i10) {
            this.minAppVersion = i10;
        }

        public final void setMinFirmVersion(int i10) {
            this.minFirmVersion = i10;
        }

        public final void setNeedConnectSpp(boolean z2) {
            this.needConnectSpp = z2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.minAppVersion);
            dest.writeInt(this.minFirmVersion);
            dest.writeString(this.functionType);
            dest.writeInt(this.needConnectSpp ? 1 : 0);
            Integer num = this.minVersion;
            if (num == null) {
                dest.writeInt(0);
            } else {
                dest.writeInt(1);
                dest.writeInt(num.intValue());
            }
        }

        public LeFilterFunction(int i10, int i11, String str, boolean z2, Integer num) {
            this.minAppVersion = i10;
            this.minFirmVersion = i11;
            this.functionType = str;
            this.needConnectSpp = z2;
            this.minVersion = num;
        }

        public /* synthetic */ LeFilterFunction(int i10, int i11, String str, boolean z2, Integer num, int i12, d dVar) {
            this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? false : z2, (i12 & 16) != 0 ? null : num);
        }

        private static /* synthetic */ void getMinVersion$annotations() {
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$MultiConnectFunction;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "functionType", "", "minFirmVersion", "", "<init>", "(Ljava/lang/String;I)V", "getFunctionType", "()Ljava/lang/String;", "setFunctionType", "(Ljava/lang/String;)V", "getMinFirmVersion", "()I", "setMinFirmVersion", "(I)V", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class MultiConnectFunction extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<MultiConnectFunction> CREATOR = new a();
        private String functionType;
        private int minFirmVersion;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<MultiConnectFunction> {
            @Override // android.os.Parcelable.Creator
            public final MultiConnectFunction createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new MultiConnectFunction(parcel.readString(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final MultiConnectFunction[] newArray(int i10) {
                return new MultiConnectFunction[i10];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public MultiConnectFunction() {
            this(null, 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ MultiConnectFunction copy$default(MultiConnectFunction multiConnectFunction, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = multiConnectFunction.functionType;
            }
            if ((i11 & 2) != 0) {
                i10 = multiConnectFunction.minFirmVersion;
            }
            return multiConnectFunction.copy(str, i10);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFunctionType() {
            return this.functionType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        public final MultiConnectFunction copy(String functionType, int minFirmVersion) {
            return new MultiConnectFunction(functionType, minFirmVersion);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getFunctionType() {
            return this.functionType;
        }

        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        public final void setFunctionType(String str) {
            this.functionType = str;
        }

        public final void setMinFirmVersion(int i10) {
            this.minFirmVersion = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.functionType);
            dest.writeInt(this.minFirmVersion);
        }

        public MultiConnectFunction(String str, int i10) {
            this.functionType = str;
            this.minFirmVersion = i10;
        }

        public /* synthetic */ MultiConnectFunction(String str, int i10, int i11, d dVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0004HÆ\u0003JM\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011¨\u0006-"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$NoiseReductionMode;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "protocolIndex", "", "modeType", "childrenMode", "", "decideByEarDevice", "", "weakNoiseReductionSummary", "intellectNoiseReductionSummary", "<init>", "(IILjava/util/List;ZII)V", "getProtocolIndex", "()I", "setProtocolIndex", "(I)V", "getModeType", "setModeType", "getChildrenMode", "()Ljava/util/List;", "setChildrenMode", "(Ljava/util/List;)V", "getDecideByEarDevice", "()Z", "setDecideByEarDevice", "(Z)V", "getWeakNoiseReductionSummary", "setWeakNoiseReductionSummary", "getIntellectNoiseReductionSummary", "setIntellectNoiseReductionSummary", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class NoiseReductionMode extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<NoiseReductionMode> CREATOR = new a();
        private List<NoiseReductionMode> childrenMode;
        private boolean decideByEarDevice;
        private int intellectNoiseReductionSummary;
        private int modeType;
        private int protocolIndex;
        private int weakNoiseReductionSummary;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<NoiseReductionMode> {
            @Override // android.os.Parcelable.Creator
            public final NoiseReductionMode createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                h.e(parcel, "parcel");
                int i10 = parcel.readInt();
                int i11 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i12 = parcel.readInt();
                    arrayList = new ArrayList(i12);
                    int iB = 0;
                    while (iB != i12) {
                        iB = b.b(NoiseReductionMode.CREATOR, parcel, arrayList, iB, 1);
                    }
                }
                return new NoiseReductionMode(i10, i11, arrayList, parcel.readInt() != 0, parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final NoiseReductionMode[] newArray(int i10) {
                return new NoiseReductionMode[i10];
            }
        }

        public NoiseReductionMode() {
            this(0, 0, null, false, 0, 0, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NoiseReductionMode copy$default(NoiseReductionMode noiseReductionMode, int i10, int i11, List list, boolean z2, int i12, int i13, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                i10 = noiseReductionMode.protocolIndex;
            }
            if ((i14 & 2) != 0) {
                i11 = noiseReductionMode.modeType;
            }
            if ((i14 & 4) != 0) {
                list = noiseReductionMode.childrenMode;
            }
            if ((i14 & 8) != 0) {
                z2 = noiseReductionMode.decideByEarDevice;
            }
            if ((i14 & 16) != 0) {
                i12 = noiseReductionMode.weakNoiseReductionSummary;
            }
            if ((i14 & 32) != 0) {
                i13 = noiseReductionMode.intellectNoiseReductionSummary;
            }
            int i15 = i12;
            int i16 = i13;
            return noiseReductionMode.copy(i10, i11, list, z2, i15, i16);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getProtocolIndex() {
            return this.protocolIndex;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getModeType() {
            return this.modeType;
        }

        public final List<NoiseReductionMode> component3() {
            return this.childrenMode;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getDecideByEarDevice() {
            return this.decideByEarDevice;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getWeakNoiseReductionSummary() {
            return this.weakNoiseReductionSummary;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getIntellectNoiseReductionSummary() {
            return this.intellectNoiseReductionSummary;
        }

        public final NoiseReductionMode copy(int protocolIndex, int modeType, List<NoiseReductionMode> childrenMode, boolean decideByEarDevice, int weakNoiseReductionSummary, int intellectNoiseReductionSummary) {
            return new NoiseReductionMode(protocolIndex, modeType, childrenMode, decideByEarDevice, weakNoiseReductionSummary, intellectNoiseReductionSummary);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final List<NoiseReductionMode> getChildrenMode() {
            return this.childrenMode;
        }

        public final boolean getDecideByEarDevice() {
            return this.decideByEarDevice;
        }

        public final int getIntellectNoiseReductionSummary() {
            return this.intellectNoiseReductionSummary;
        }

        public final int getModeType() {
            return this.modeType;
        }

        public final int getProtocolIndex() {
            return this.protocolIndex;
        }

        public final int getWeakNoiseReductionSummary() {
            return this.weakNoiseReductionSummary;
        }

        public final void setChildrenMode(List<NoiseReductionMode> list) {
            this.childrenMode = list;
        }

        public final void setDecideByEarDevice(boolean z2) {
            this.decideByEarDevice = z2;
        }

        public final void setIntellectNoiseReductionSummary(int i10) {
            this.intellectNoiseReductionSummary = i10;
        }

        public final void setModeType(int i10) {
            this.modeType = i10;
        }

        public final void setProtocolIndex(int i10) {
            this.protocolIndex = i10;
        }

        public final void setWeakNoiseReductionSummary(int i10) {
            this.weakNoiseReductionSummary = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.protocolIndex);
            dest.writeInt(this.modeType);
            List<NoiseReductionMode> list = this.childrenMode;
            if (list == null) {
                dest.writeInt(0);
            } else {
                Iterator itG = e.g(dest, 1, list);
                while (itG.hasNext()) {
                    ((NoiseReductionMode) itG.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeInt(this.decideByEarDevice ? 1 : 0);
            dest.writeInt(this.weakNoiseReductionSummary);
            dest.writeInt(this.intellectNoiseReductionSummary);
        }

        public NoiseReductionMode(int i10, int i11, List<NoiseReductionMode> list, boolean z2, int i12, int i13) {
            this.protocolIndex = i10;
            this.modeType = i11;
            this.childrenMode = list;
            this.decideByEarDevice = z2;
            this.weakNoiseReductionSummary = i12;
            this.intellectNoiseReductionSummary = i13;
        }

        public /* synthetic */ NoiseReductionMode(int i10, int i11, List list, boolean z2, int i12, int i13, int i14, d dVar) {
            this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? null : list, (i14 & 8) != 0 ? false : z2, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? 0 : i13);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$PersonalNoiseCompat;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "personalNoise", "", "minFirmVersion", "<init>", "(II)V", "getPersonalNoise", "()I", "setPersonalNoise", "(I)V", "getMinFirmVersion", "setMinFirmVersion", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PersonalNoiseCompat extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<PersonalNoiseCompat> CREATOR = new a();
        private int minFirmVersion;
        private int personalNoise;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<PersonalNoiseCompat> {
            @Override // android.os.Parcelable.Creator
            public final PersonalNoiseCompat createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new PersonalNoiseCompat(parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final PersonalNoiseCompat[] newArray(int i10) {
                return new PersonalNoiseCompat[i10];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public PersonalNoiseCompat() {
            int i10 = 0;
            this(i10, i10, 3, null);
        }

        public static /* synthetic */ PersonalNoiseCompat copy$default(PersonalNoiseCompat personalNoiseCompat, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = personalNoiseCompat.personalNoise;
            }
            if ((i12 & 2) != 0) {
                i11 = personalNoiseCompat.minFirmVersion;
            }
            return personalNoiseCompat.copy(i10, i11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPersonalNoise() {
            return this.personalNoise;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        public final PersonalNoiseCompat copy(int personalNoise, int minFirmVersion) {
            return new PersonalNoiseCompat(personalNoise, minFirmVersion);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getMinFirmVersion() {
            return this.minFirmVersion;
        }

        public final int getPersonalNoise() {
            return this.personalNoise;
        }

        public final void setMinFirmVersion(int i10) {
            this.minFirmVersion = i10;
        }

        public final void setPersonalNoise(int i10) {
            this.personalNoise = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.personalNoise);
            dest.writeInt(this.minFirmVersion);
        }

        public PersonalNoiseCompat(int i10, int i11) {
            this.personalNoise = i10;
            this.minFirmVersion = i11;
        }

        public /* synthetic */ PersonalNoiseCompat(int i10, int i11, int i12, d dVar) {
            this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$PromptVolumeRange;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "min", "", "max", "<init>", "(II)V", "getMin", "()I", "setMin", "(I)V", "getMax", "setMax", "component1", "component2", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PromptVolumeRange extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<PromptVolumeRange> CREATOR = new a();
        private int max;
        private int min;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<PromptVolumeRange> {
            @Override // android.os.Parcelable.Creator
            public final PromptVolumeRange createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new PromptVolumeRange(parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final PromptVolumeRange[] newArray(int i10) {
                return new PromptVolumeRange[i10];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public PromptVolumeRange() {
            int i10 = 0;
            this(i10, i10, 3, null);
        }

        public static /* synthetic */ PromptVolumeRange copy$default(PromptVolumeRange promptVolumeRange, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = promptVolumeRange.min;
            }
            if ((i12 & 2) != 0) {
                i11 = promptVolumeRange.max;
            }
            return promptVolumeRange.copy(i10, i11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMin() {
            return this.min;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMax() {
            return this.max;
        }

        public final PromptVolumeRange copy(int min, int max) {
            return new PromptVolumeRange(min, max);
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

        public final void setMax(int i10) {
            this.max = i10;
        }

        public final void setMin(int i10) {
            this.min = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.min);
            dest.writeInt(this.max);
        }

        public PromptVolumeRange(int i10, int i11) {
            this.min = i10;
            this.max = i11;
        }

        public /* synthetic */ PromptVolumeRange(int i10, int i11, int i12, d dVar) {
            this((i12 & 1) != 0 ? -1 : i10, (i12 & 2) != 0 ? -1 : i11);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006#"}, d2 = {"Lcom/oplus/melody/common/data/WhitelistConfigDTO$Rssi;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "firstRssi", "", "secondRssi", "leftOffset", "rightOffset", "flattenOffset", "<init>", "(IIIII)V", "getFirstRssi", "()I", "setFirstRssi", "(I)V", "getSecondRssi", "setSecondRssi", "getLeftOffset", "setLeftOffset", "getRightOffset", "setRightOffset", "getFlattenOffset", "setFlattenOffset", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Rssi extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Rssi> CREATOR = new a();
        private int firstRssi;
        private int flattenOffset;
        private int leftOffset;
        private int rightOffset;
        private int secondRssi;

        /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
        public static final class a implements Parcelable.Creator<Rssi> {
            @Override // android.os.Parcelable.Creator
            public final Rssi createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Rssi(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final Rssi[] newArray(int i10) {
                return new Rssi[i10];
            }
        }

        public Rssi() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public static /* synthetic */ Rssi copy$default(Rssi rssi, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                i10 = rssi.firstRssi;
            }
            if ((i15 & 2) != 0) {
                i11 = rssi.secondRssi;
            }
            if ((i15 & 4) != 0) {
                i12 = rssi.leftOffset;
            }
            if ((i15 & 8) != 0) {
                i13 = rssi.rightOffset;
            }
            if ((i15 & 16) != 0) {
                i14 = rssi.flattenOffset;
            }
            int i16 = i14;
            int i17 = i12;
            return rssi.copy(i10, i11, i17, i13, i16);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getFirstRssi() {
            return this.firstRssi;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSecondRssi() {
            return this.secondRssi;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getLeftOffset() {
            return this.leftOffset;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getRightOffset() {
            return this.rightOffset;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getFlattenOffset() {
            return this.flattenOffset;
        }

        public final Rssi copy(int firstRssi, int secondRssi, int leftOffset, int rightOffset, int flattenOffset) {
            return new Rssi(firstRssi, secondRssi, leftOffset, rightOffset, flattenOffset);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final int getFirstRssi() {
            return this.firstRssi;
        }

        public final int getFlattenOffset() {
            return this.flattenOffset;
        }

        public final int getLeftOffset() {
            return this.leftOffset;
        }

        public final int getRightOffset() {
            return this.rightOffset;
        }

        public final int getSecondRssi() {
            return this.secondRssi;
        }

        public final void setFirstRssi(int i10) {
            this.firstRssi = i10;
        }

        public final void setFlattenOffset(int i10) {
            this.flattenOffset = i10;
        }

        public final void setLeftOffset(int i10) {
            this.leftOffset = i10;
        }

        public final void setRightOffset(int i10) {
            this.rightOffset = i10;
        }

        public final void setSecondRssi(int i10) {
            this.secondRssi = i10;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeInt(this.firstRssi);
            dest.writeInt(this.secondRssi);
            dest.writeInt(this.leftOffset);
            dest.writeInt(this.rightOffset);
            dest.writeInt(this.flattenOffset);
        }

        public Rssi(int i10, int i11, int i12, int i13, int i14) {
            this.firstRssi = i10;
            this.secondRssi = i11;
            this.leftOffset = i12;
            this.rightOffset = i13;
            this.flattenOffset = i14;
        }

        public /* synthetic */ Rssi(int i10, int i11, int i12, int i13, int i14, int i15, d dVar) {
            this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
        }
    }

    /* JADX INFO: compiled from: WhitelistConfigDTO.kt */
    public static final class a implements Parcelable.Creator<WhitelistConfigDTO> {
        @Override // android.os.Parcelable.Creator
        public final WhitelistConfigDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            boolean z2;
            int i10;
            boolean z4;
            LinkedHashMap linkedHashMap;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                arrayList = new ArrayList(i11);
                int iB = 0;
                while (iB != i11) {
                    iB = b.b(Child.CREATOR, parcel, arrayList, iB, 1);
                }
            }
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            Rssi rssiCreateFromParcel = parcel.readInt() == 0 ? null : Rssi.CREATOR.createFromParcel(parcel);
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            int i15 = parcel.readInt();
            int i16 = parcel.readInt();
            Function functionCreateFromParcel = parcel.readInt() == 0 ? null : Function.CREATOR.createFromParcel(parcel);
            boolean z10 = true;
            boolean z11 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z2 = true;
            } else {
                z2 = true;
                z10 = false;
            }
            int i17 = parcel.readInt();
            if (parcel.readInt() != 0) {
                z4 = z2;
                i10 = i17;
            } else {
                i10 = i17;
                z4 = false;
            }
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i18 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i18);
                int i19 = 0;
                while (i19 != i18) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                    i19++;
                    string3 = string3;
                }
                linkedHashMap = linkedHashMap2;
            }
            return new WhitelistConfigDTO(string, string2, arrayList, string3, string4, string5, rssiCreateFromParcel, i12, i13, i14, i15, i16, functionCreateFromParcel, z11, z10, i10, z4, numValueOf, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final WhitelistConfigDTO[] newArray(int i10) {
            return new WhitelistConfigDTO[i10];
        }
    }

    public WhitelistConfigDTO() {
        this(null, null, null, null, null, null, null, 0, 0, 0, 0, 0, null, false, false, 0, false, null, null, 524287, null);
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    private final Integer getProtocolType() {
        return this.protocolType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    private final int getMinRssi() {
        return this.minRssi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhitelistConfigDTO copy$default(WhitelistConfigDTO whitelistConfigDTO, String str, String str2, List list, String str3, String str4, String str5, Rssi rssi, int i10, int i11, int i12, int i13, int i14, Function function, boolean z2, boolean z4, int i15, boolean z10, Integer num, Map map, int i16, Object obj) {
        Map map2;
        Integer num2;
        String str6 = (i16 & 1) != 0 ? whitelistConfigDTO.id : str;
        String str7 = (i16 & 2) != 0 ? whitelistConfigDTO.name : str2;
        List list2 = (i16 & 4) != 0 ? whitelistConfigDTO.children : list;
        String str8 = (i16 & 8) != 0 ? whitelistConfigDTO.brand : str3;
        String str9 = (i16 & 16) != 0 ? whitelistConfigDTO.type : str4;
        String str10 = (i16 & 32) != 0 ? whitelistConfigDTO.uuid : str5;
        Rssi rssi2 = (i16 & 64) != 0 ? whitelistConfigDTO.rssi : rssi;
        int i17 = (i16 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? whitelistConfigDTO.minRssi : i10;
        int i18 = (i16 & 256) != 0 ? whitelistConfigDTO.minVersion : i11;
        int i19 = (i16 & 512) != 0 ? whitelistConfigDTO.podsVersion : i12;
        int i20 = (i16 & 1024) != 0 ? whitelistConfigDTO.opsPodsVersion : i13;
        int i21 = (i16 & 2048) != 0 ? whitelistConfigDTO.coreFrom : i14;
        Function function2 = (i16 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? whitelistConfigDTO.function : function;
        boolean z11 = (i16 & 8192) != 0 ? whitelistConfigDTO.supportSpp : z2;
        String str11 = str6;
        boolean z12 = (i16 & 16384) != 0 ? whitelistConfigDTO.fuzzyMatchName : z4;
        int i22 = (i16 & 32768) != 0 ? whitelistConfigDTO.defaultColor : i15;
        boolean z13 = (i16 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? whitelistConfigDTO.supportRlmDeviceFunction : z10;
        Integer num3 = (i16 & 131072) != 0 ? whitelistConfigDTO.protocolType : num;
        if ((i16 & 262144) != 0) {
            num2 = num3;
            map2 = whitelistConfigDTO.btDelayReport;
        } else {
            map2 = map;
            num2 = num3;
        }
        return whitelistConfigDTO.copy(str11, str7, list2, str8, str9, str10, rssi2, i17, i18, i19, i20, i21, function2, z11, z12, i22, z13, num2, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getPodsVersion() {
        return this.podsVersion;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getOpsPodsVersion() {
        return this.opsPodsVersion;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getCoreFrom() {
        return this.coreFrom;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Function getFunction() {
        return this.function;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getSupportSpp() {
        return this.supportSpp;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final boolean getFuzzyMatchName() {
        return this.fuzzyMatchName;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getDefaultColor() {
        return this.defaultColor;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getSupportRlmDeviceFunction() {
        return this.supportRlmDeviceFunction;
    }

    public final Map<String, String> component19() {
        return this.btDelayReport;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Child> component3() {
        return this.children;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Rssi getRssi() {
        return this.rssi;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getMinVersion() {
        return this.minVersion;
    }

    public final WhitelistConfigDTO copy(String id, String name, List<Child> children, String brand, String type, String uuid, Rssi rssi, int minRssi, int minVersion, int podsVersion, int opsPodsVersion, int coreFrom, Function function, boolean supportSpp, boolean fuzzyMatchName, int defaultColor, boolean supportRlmDeviceFunction, Integer protocolType, Map<String, String> btDelayReport) {
        h.e(id, "id");
        h.e(type, "type");
        return new WhitelistConfigDTO(id, name, children, brand, type, uuid, rssi, minRssi, minVersion, podsVersion, opsPodsVersion, coreFrom, function, supportSpp, fuzzyMatchName, defaultColor, supportRlmDeviceFunction, protocolType, btDelayReport);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final Map<String, String> getBtDelayReport() {
        return this.btDelayReport;
    }

    public final List<Child> getChildren() {
        return this.children;
    }

    public final int getCoreFrom() {
        return this.coreFrom;
    }

    public final int getDefaultColor() {
        return this.defaultColor;
    }

    public final Function getFunction() {
        return this.function;
    }

    public final boolean getFuzzyMatchName() {
        return this.fuzzyMatchName;
    }

    public final String getId() {
        return this.id;
    }

    public final int getMinRssi() {
        Rssi rssi = this.rssi;
        return rssi != null ? rssi.getSecondRssi() : this.minRssi;
    }

    public final int getMinVersion() {
        return this.minVersion;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOpsPodsVersion() {
        return this.opsPodsVersion;
    }

    public final int getPodsVersion() {
        return this.podsVersion;
    }

    public final Rssi getRssi() {
        return this.rssi;
    }

    public final boolean getSupportRlmDeviceFunction() {
        return this.supportRlmDeviceFunction;
    }

    public final boolean getSupportSpp() {
        return this.supportSpp;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setBrand(String str) {
        this.brand = str;
    }

    public final void setBtDelayReport(Map<String, String> map) {
        this.btDelayReport = map;
    }

    public final void setChildren(List<Child> list) {
        this.children = list;
    }

    public final void setCoreFrom(int i10) {
        this.coreFrom = i10;
    }

    public final void setDefaultColor(int i10) {
        this.defaultColor = i10;
    }

    public final void setFunction(Function function) {
        this.function = function;
    }

    public final void setFuzzyMatchName(boolean z2) {
        this.fuzzyMatchName = z2;
    }

    public final void setId(String str) {
        h.e(str, "<set-?>");
        this.id = str;
    }

    public final void setMinVersion(int i10) {
        this.minVersion = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOpsPodsVersion(int i10) {
        this.opsPodsVersion = i10;
    }

    public final void setPodsVersion(int i10) {
        this.podsVersion = i10;
    }

    public final void setRssi(Rssi rssi) {
        this.rssi = rssi;
    }

    public final void setSupportRlmDeviceFunction(boolean z2) {
        this.supportRlmDeviceFunction = z2;
    }

    public final void setSupportSpp(boolean z2) {
        this.supportSpp = z2;
    }

    public final void setType(String str) {
        h.e(str, "<set-?>");
        this.type = str;
    }

    public final void setUuid(String str) {
        this.uuid = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        List<Child> list = this.children;
        if (list == null) {
            dest.writeInt(0);
        } else {
            Iterator itG = e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((Child) itG.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.brand);
        dest.writeString(this.type);
        dest.writeString(this.uuid);
        Rssi rssi = this.rssi;
        if (rssi == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            rssi.writeToParcel(dest, flags);
        }
        dest.writeInt(this.minRssi);
        dest.writeInt(this.minVersion);
        dest.writeInt(this.podsVersion);
        dest.writeInt(this.opsPodsVersion);
        dest.writeInt(this.coreFrom);
        Function function = this.function;
        if (function == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            function.writeToParcel(dest, flags);
        }
        dest.writeInt(this.supportSpp ? 1 : 0);
        dest.writeInt(this.fuzzyMatchName ? 1 : 0);
        dest.writeInt(this.defaultColor);
        dest.writeInt(this.supportRlmDeviceFunction ? 1 : 0);
        Integer num = this.protocolType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Map<String, String> map = this.btDelayReport;
        if (map == null) {
            dest.writeInt(0);
            return;
        }
        dest.writeInt(1);
        dest.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    public WhitelistConfigDTO(String id, String str, List<Child> list, String str2, String type, String str3, Rssi rssi, int i10, int i11, int i12, int i13, int i14, Function function, boolean z2, boolean z4, int i15, boolean z10, Integer num, Map<String, String> map) {
        h.e(id, "id");
        h.e(type, "type");
        this.id = id;
        this.name = str;
        this.children = list;
        this.brand = str2;
        this.type = type;
        this.uuid = str3;
        this.rssi = rssi;
        this.minRssi = i10;
        this.minVersion = i11;
        this.podsVersion = i12;
        this.opsPodsVersion = i13;
        this.coreFrom = i14;
        this.function = function;
        this.supportSpp = z2;
        this.fuzzyMatchName = z4;
        this.defaultColor = i15;
        this.supportRlmDeviceFunction = z10;
        this.protocolType = num;
        this.btDelayReport = map;
    }

    private static /* synthetic */ void getProtocolType$annotations() {
    }

    public /* synthetic */ WhitelistConfigDTO(String str, String str2, List list, String str3, String str4, String str5, Rssi rssi, int i10, int i11, int i12, int i13, int i14, Function function, boolean z2, boolean z4, int i15, boolean z10, Integer num, Map map, int i16, d dVar) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? null : list, (i16 & 8) != 0 ? null : str3, (i16 & 16) == 0 ? str4 : "", (i16 & 32) != 0 ? null : str5, (i16 & 64) != 0 ? null : rssi, (i16 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 50 : i10, (i16 & 256) != 0 ? 0 : i11, (i16 & 512) != 0 ? 0 : i12, (i16 & 1024) != 0 ? 0 : i13, (i16 & 2048) != 0 ? 0 : i14, (i16 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : function, (i16 & 8192) != 0 ? false : z2, (i16 & 16384) != 0 ? false : z4, (i16 & 32768) != 0 ? -1 : i15, (i16 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? false : z10, (i16 & 131072) != 0 ? null : num, (i16 & 262144) != 0 ? null : map);
    }
}
