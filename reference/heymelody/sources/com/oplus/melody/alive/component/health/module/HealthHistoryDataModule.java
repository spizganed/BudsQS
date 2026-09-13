package com.oplus.melody.alive.component.health.module;

import A6.k;
import D7.C0379m;
import D7.RunnableC0369c;
import Kb.l;
import Y.r;
import com.heytap.health.rpc.RpcMsg;
import com.oplus.drs.core.provider.DcsCompatEventConverter;
import com.oplus.melody.common.helper.MelodyException;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0917x;
import com.oplus.melody.model.db.M;
import g8.AbstractC1073a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.h;
import x3.C1656o;
import z6.C1722a;

/* JADX INFO: compiled from: HealthHistoryDataModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J*\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00180\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthHistoryDataModule;", "Lcom/oplus/melody/alive/component/health/module/BaseHealthModule;", "<init>", "()V", "mRepository", "Lcom/oplus/melody/model/repository/health/SpineHealthRepository;", "mLastDeviceAddress", "", "mLastFetchTime", "", "handleHealthEvent", "", "msg", "Lcom/heytap/health/rpc/RpcMsg;", "handleActiveEarphoneEvent", "dto", "Lcom/oplus/melody/alive/component/health/repo/SpineHeadsetDO;", "processDeviceChanged", "address", "convertToItem", "Lcom/oplus/melody/alive/component/health/module/HealthHistoryDataModule$Item;", "item", "Lcom/oplus/melody/model/db/SpineHistoryDataEntity;", "splitList", "", "list", "groupSize", "", "RequestBean", "ResponseBean", "Item", "Companion", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthHistoryDataModule extends BaseHealthModule {
    public static final int CID_SPINE_HISTORY_DATA = 4;
    public static final int DATA_GAP = 1000;
    public static final String KEY_DATA = "datas";
    public static final String TAG = "HealthHistoryDataModule";
    private String mLastDeviceAddress;
    private long mLastFetchTime;
    private final AbstractC1073a mRepository;
    private static final long SECONDS_3 = TimeUnit.SECONDS.toMillis(3);

    /* JADX INFO: compiled from: HealthHistoryDataModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0011\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthHistoryDataModule$Item;", "", "model", "", MelodyInfoModule.KEY_UID, "startTime", "", "endTime", "goodDuration", "mildDuration", "badDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIII)V", "getModel", "()Ljava/lang/String;", "getUid", "getStartTime", "()I", "getEndTime", "setEndTime", "(I)V", "getGoodDuration", "getMildDuration", "getBadDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Item {
        private final int badDuration;
        private int endTime;
        private final int goodDuration;
        private final int mildDuration;
        private final String model;
        private final int startTime;
        private final String uid;

        public Item(String model, String uid, int i10, int i11, int i12, int i13, int i14) {
            h.e(model, "model");
            h.e(uid, "uid");
            this.model = model;
            this.uid = uid;
            this.startTime = i10;
            this.endTime = i11;
            this.goodDuration = i12;
            this.mildDuration = i13;
            this.badDuration = i14;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                str = item.model;
            }
            if ((i15 & 2) != 0) {
                str2 = item.uid;
            }
            if ((i15 & 4) != 0) {
                i10 = item.startTime;
            }
            if ((i15 & 8) != 0) {
                i11 = item.endTime;
            }
            if ((i15 & 16) != 0) {
                i12 = item.goodDuration;
            }
            if ((i15 & 32) != 0) {
                i13 = item.mildDuration;
            }
            if ((i15 & 64) != 0) {
                i14 = item.badDuration;
            }
            int i16 = i13;
            int i17 = i14;
            int i18 = i12;
            int i19 = i10;
            return item.copy(str, str2, i19, i11, i18, i16, i17);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUid() {
            return this.uid;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getStartTime() {
            return this.startTime;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getEndTime() {
            return this.endTime;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getGoodDuration() {
            return this.goodDuration;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getMildDuration() {
            return this.mildDuration;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getBadDuration() {
            return this.badDuration;
        }

        public final Item copy(String model, String uid, int startTime, int endTime, int goodDuration, int mildDuration, int badDuration) {
            h.e(model, "model");
            h.e(uid, "uid");
            return new Item(model, uid, startTime, endTime, goodDuration, mildDuration, badDuration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return h.a(this.model, item.model) && h.a(this.uid, item.uid) && this.startTime == item.startTime && this.endTime == item.endTime && this.goodDuration == item.goodDuration && this.mildDuration == item.mildDuration && this.badDuration == item.badDuration;
        }

        public final int getBadDuration() {
            return this.badDuration;
        }

        public final int getEndTime() {
            return this.endTime;
        }

        public final int getGoodDuration() {
            return this.goodDuration;
        }

        public final int getMildDuration() {
            return this.mildDuration;
        }

        public final String getModel() {
            return this.model;
        }

        public final int getStartTime() {
            return this.startTime;
        }

        public final String getUid() {
            return this.uid;
        }

        public int hashCode() {
            return Integer.hashCode(this.badDuration) + ((Integer.hashCode(this.mildDuration) + ((Integer.hashCode(this.goodDuration) + ((Integer.hashCode(this.endTime) + ((Integer.hashCode(this.startTime) + A6.e.b(this.model.hashCode() * 31, 31, this.uid)) * 31)) * 31)) * 31)) * 31);
        }

        public final void setEndTime(int i10) {
            this.endTime = i10;
        }

        public String toString() {
            String str = this.model;
            String str2 = this.uid;
            int i10 = this.startTime;
            int i11 = this.endTime;
            int i12 = this.goodDuration;
            int i13 = this.mildDuration;
            int i14 = this.badDuration;
            StringBuilder sbI = r.i("Item(model=", str, ", uid=", str2, ", startTime=");
            r.m(sbI, i10, ", endTime=", i11, ", goodDuration=");
            r.m(sbI, i12, ", mildDuration=", i13, ", badDuration=");
            return g0.e.b(sbI, i14, ")");
        }
    }

    /* JADX INFO: compiled from: HealthHistoryDataModule.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthHistoryDataModule$RequestBean;", "", "startTime", "", "endTime", "<init>", "(II)V", "getStartTime", "()I", "getEndTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RequestBean {
        private final int endTime;
        private final int startTime;

        public RequestBean(int i10, int i11) {
            this.startTime = i10;
            this.endTime = i11;
        }

        public static /* synthetic */ RequestBean copy$default(RequestBean requestBean, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = requestBean.startTime;
            }
            if ((i12 & 2) != 0) {
                i11 = requestBean.endTime;
            }
            return requestBean.copy(i10, i11);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getStartTime() {
            return this.startTime;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getEndTime() {
            return this.endTime;
        }

        public final RequestBean copy(int startTime, int endTime) {
            return new RequestBean(startTime, endTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestBean)) {
                return false;
            }
            RequestBean requestBean = (RequestBean) other;
            return this.startTime == requestBean.startTime && this.endTime == requestBean.endTime;
        }

        public final int getEndTime() {
            return this.endTime;
        }

        public final int getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            return Integer.hashCode(this.endTime) + (Integer.hashCode(this.startTime) * 31);
        }

        public String toString() {
            return "RequestBean(startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
        }
    }

    /* JADX INFO: compiled from: HealthHistoryDataModule.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/oplus/melody/alive/component/health/module/HealthHistoryDataModule$ResponseBean;", "", "resultCode", "", "hasMore", "", DcsCompatEventConverter.KEY_DATA_LIST, "", "Lcom/oplus/melody/alive/component/health/module/HealthHistoryDataModule$Item;", "<init>", "(IZLjava/util/List;)V", "getResultCode", "()I", "getHasMore", "()Z", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "alive_ballPallExportAallRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ResponseBean {
        private List<Item> dataList;
        private final boolean hasMore;
        private final int resultCode;

        public ResponseBean(int i10, boolean z2, List<Item> list) {
            this.resultCode = i10;
            this.hasMore = z2;
            this.dataList = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ResponseBean copy$default(ResponseBean responseBean, int i10, boolean z2, List list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = responseBean.resultCode;
            }
            if ((i11 & 2) != 0) {
                z2 = responseBean.hasMore;
            }
            if ((i11 & 4) != 0) {
                list = responseBean.dataList;
            }
            return responseBean.copy(i10, z2, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getResultCode() {
            return this.resultCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final List<Item> component3() {
            return this.dataList;
        }

        public final ResponseBean copy(int resultCode, boolean hasMore, List<Item> dataList) {
            return new ResponseBean(resultCode, hasMore, dataList);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResponseBean)) {
                return false;
            }
            ResponseBean responseBean = (ResponseBean) other;
            return this.resultCode == responseBean.resultCode && this.hasMore == responseBean.hasMore && h.a(this.dataList, responseBean.dataList);
        }

        public final List<Item> getDataList() {
            return this.dataList;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final int getResultCode() {
            return this.resultCode;
        }

        public int hashCode() {
            int iHashCode = (Boolean.hashCode(this.hasMore) + (Integer.hashCode(this.resultCode) * 31)) * 31;
            List<Item> list = this.dataList;
            return iHashCode + (list == null ? 0 : list.hashCode());
        }

        public final void setDataList(List<Item> list) {
            this.dataList = list;
        }

        public String toString() {
            return "ResponseBean(resultCode=" + this.resultCode + ", hasMore=" + this.hasMore + ", dataList=" + this.dataList + ")";
        }
    }

    public HealthHistoryDataModule() {
        int i10 = AbstractC1073a.f23306c;
        AbstractC1073a abstractC1073a = (AbstractC1073a) D1.f.x(AbstractC1073a.class);
        if (abstractC1073a == null) {
            throw MelodyException.e(501, "SpineHealthRepository is null");
        }
        this.mRepository = abstractC1073a;
        this.mLastDeviceAddress = "";
        k mSpineHealthModel = getMSpineHealthModel();
        C0379m.i(C0379m.b(C0379m.g(mSpineHealthModel.f68a, new A6.b(1))), new C6.e(this, 19), C0379m.f1127a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(HealthHistoryDataModule healthHistoryDataModule, A6.a aVar) {
        h.b(aVar);
        healthHistoryDataModule.handleActiveEarphoneEvent(aVar);
    }

    private final Item convertToItem(M m9) {
        String strC = com.oplus.melody.model.db.r.c(m9.getProductName());
        if (strC == null) {
            strC = "";
        }
        String strC2 = com.oplus.melody.model.db.r.c(m9.getMacAddress());
        return new Item(strC, strC2 != null ? strC2 : "", m9.getUtc(), m9.getUtc(), m9.getNormalTimes(), m9.getMildTimes(), m9.getBadTimes());
    }

    private final void handleActiveEarphoneEvent(A6.a aVar) {
        if (aVar.isConnected()) {
            processDeviceChanged(aVar.getAddress());
            this.mLastDeviceAddress = aVar.getAddress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleHealthEvent$lambda$0$0(RequestBean requestBean) {
        return "handleHealthEvent: startTime=" + new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", Locale.US).format(new Date(((long) requestBean.getStartTime()) * 1000)) + " endTime = " + new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", Locale.US).format(new Date(((long) requestBean.getEndTime()) * 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleHealthEvent$lambda$0$1(HealthHistoryDataModule healthHistoryDataModule, RequestBean requestBean, RpcMsg rpcMsg) {
        int i10 = 1;
        ArrayList arrayList = new ArrayList();
        List<M> listD = healthHistoryDataModule.mRepository.d(requestBean.getStartTime(), requestBean.getEndTime());
        if (listD != null) {
            for (M m9 : listD) {
                h.b(m9);
                arrayList.add(healthHistoryDataModule.convertToItem(m9));
            }
        }
        if (arrayList.size() > 1) {
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                if (i12 != arrayList.size()) {
                    ((Item) arrayList.get(i11)).setEndTime(((Item) arrayList.get(i12)).getStartTime());
                }
                i11 = i12;
            }
        }
        List<List<Item>> listSplitList = healthHistoryDataModule.splitList(arrayList, 1000);
        ResponseBean responseBean = new ResponseBean(1, listSplitList.size() > 1, null);
        for (List<Item> list : listSplitList) {
            A.c(TAG, new N9.d(arrayList, listSplitList, list, i10));
            responseBean.setDataList(list);
            int i13 = C1722a.f29471a;
            C1722a.a(4, rpcMsg.getMsgId(), C0917x.i(responseBean));
        }
        if (System.currentTimeMillis() - healthHistoryDataModule.mLastFetchTime > SECONDS_3) {
            A.b(TAG, "handleHealthEvent: fetch latest spine data");
            healthHistoryDataModule.processDeviceChanged(healthHistoryDataModule.mLastDeviceAddress);
            healthHistoryDataModule.mLastFetchTime = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handleHealthEvent$lambda$0$1$1$0(List list, List list2, List list3) {
        int size = list.size();
        int size2 = list2.size();
        int size3 = list3.size();
        StringBuilder sbM = androidx.appcompat.widget.a.m(size, size2, "handleHealthEvent: totalSize=", " groupSize=", " itemSize=");
        sbM.append(size3);
        return sbM.toString();
    }

    private final void processDeviceChanged(String address) {
        ForkJoinPool.commonPool().execute(new RunnableC0369c(22, this, address));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processDeviceChanged$lambda$0(HealthHistoryDataModule healthHistoryDataModule, String str) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        M mE = healthHistoryDataModule.mRepository.e();
        if (mE != null) {
            ref$IntRef.element = mE.getUtc();
        }
        A.c(TAG, new d(ref$IntRef, 2));
        healthHistoryDataModule.mRepository.c(ref$IntRef.element, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processDeviceChanged$lambda$0$0(Ref$IntRef ref$IntRef) {
        return C1656o.a("processDeviceChanged: fetch spine related data ", new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss", Locale.US).format(new Date(((long) ref$IntRef.element) * 1000)));
    }

    private final List<List<Item>> splitList(List<Item> list, int groupSize) {
        int i10 = 0;
        if (list.isEmpty()) {
            return l.f(list);
        }
        int size = list.size();
        int i11 = ((size + groupSize) - 1) / groupSize;
        ArrayList arrayList = new ArrayList(i11);
        while (i10 < i11) {
            int i12 = i10 * groupSize;
            i10++;
            int i13 = i10 * groupSize;
            if (i13 >= size) {
                i13 = size;
            }
            arrayList.add(list.subList(i12, i13));
        }
        return arrayList;
    }

    @Override // com.oplus.melody.alive.component.health.module.BaseHealthModule
    public void handleHealthEvent(final RpcMsg msg) {
        final RequestBean requestBean;
        h.e(msg, "msg");
        if (msg.getData() == null) {
            A.h(TAG, "handleHealthEvent: msg data is null");
        } else {
            if (msg.getCid() != 4 || (requestBean = (RequestBean) C0917x.e(msg.getData(), RequestBean.class)) == null) {
                return;
            }
            A.c(TAG, new d(requestBean, 0));
            ForkJoinPool.commonPool().execute(new Runnable() { // from class: com.oplus.melody.alive.component.health.module.e
                @Override // java.lang.Runnable
                public final void run() {
                    HealthHistoryDataModule.handleHealthEvent$lambda$0$1(this.f18797a, requestBean, msg);
                }
            });
        }
    }
}
