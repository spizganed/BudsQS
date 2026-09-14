package com.oplus.melody.model.net.data;

import A6.b;
import A6.e;
import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: PersonalDressInfoDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BÉ\u0003\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b-\u0010.J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010f\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010?J\u0010\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010h\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010k\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010o\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010v\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u0011\u0010y\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010}\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010?JÐ\u0003\u0010~\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010\u007fJ\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\u001b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0006R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00100R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00100R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b8\u00102R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\b=\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u00100R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010@\u001a\u0004\b\u0012\u0010?R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bA\u00102R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u00100R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u00100R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bD\u00102R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00100R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bH\u00102R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00100R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bJ\u00102R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u00100R\u0013\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0013\u0010!\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00100R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bO\u00102R\u0013\u0010#\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0013\u0010$\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u00100R\u0015\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bR\u00102R\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0013\u0010)\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u00100R\u0013\u0010*\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00100R\u0015\u0010+\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u00103\u001a\u0004\bW\u00102R\u0015\u0010,\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010@\u001a\u0004\bX\u0010?¨\u0006\u0086\u0001"}, d2 = {"Lcom/oplus/melody/model/net/data/PersonalDressInfoDO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "animSHA256", "", "animType", "", "animSize", "animUploadTime", "animUrl", "darkAnimSHA256", "darkAnimSize", "darkAnimUploadTime", "darkAnimUrl", "darkPreviewAnim", "darkPreviewAnimSHA256", "darkPreviewAnimSize", "id", "isStatic", "", "materialType", "previewAnim", "previewAnimSHA256", "previewAnimSize", "previewDetailImgUrl", "previewListImgUrl", "previewToneSHA256", "previewToneSize", "previewToneUrl", "publishStatus", "summary", "themeIdentifier", "title", "toneSHA256", "toneSize", "toneUploadTime", "toneUrl", ClientDataEntity.COL_PRIORITY, "tags", "", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$Tag;", "cardZipUrl", "cardZipSHA256", "downloadCount", "activity", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAnimSHA256", "()Ljava/lang/String;", "getAnimType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnimSize", "getAnimUploadTime", "getAnimUrl", "getDarkAnimSHA256", "getDarkAnimSize", "getDarkAnimUploadTime", "getDarkAnimUrl", "getDarkPreviewAnim", "getDarkPreviewAnimSHA256", "getDarkPreviewAnimSize", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaterialType", "getPreviewAnim", "getPreviewAnimSHA256", "getPreviewAnimSize", "getPreviewDetailImgUrl", "getPreviewListImgUrl", "getPreviewToneSHA256", "getPreviewToneSize", "getPreviewToneUrl", "getPublishStatus", "getSummary", "getThemeIdentifier", "getTitle", "getToneSHA256", "getToneSize", "getToneUploadTime", "getToneUrl", "getPriority", "getTags", "()Ljava/util/List;", "getCardZipUrl", "getCardZipSHA256", "getDownloadCount", "getActivity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/oplus/melody/model/net/data/PersonalDressInfoDO;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PersonalDressInfoDO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PersonalDressInfoDO> CREATOR = new a();
    private final Boolean activity;
    private final String animSHA256;
    private final Integer animSize;
    private final Integer animType;
    private final String animUploadTime;
    private final String animUrl;
    private final String cardZipSHA256;
    private final String cardZipUrl;
    private final String darkAnimSHA256;
    private final Integer darkAnimSize;
    private final String darkAnimUploadTime;
    private final String darkAnimUrl;
    private final String darkPreviewAnim;
    private final String darkPreviewAnimSHA256;
    private final Integer darkPreviewAnimSize;
    private final Integer downloadCount;
    private final String id;
    private final Boolean isStatic;
    private final Integer materialType;
    private final String previewAnim;
    private final String previewAnimSHA256;
    private final Integer previewAnimSize;
    private final String previewDetailImgUrl;
    private final String previewListImgUrl;
    private final String previewToneSHA256;
    private final Integer previewToneSize;
    private final String previewToneUrl;
    private final Integer priority;
    private final Integer publishStatus;
    private final String summary;
    private final List<PersonalDressDTO.Tag> tags;
    private final String themeIdentifier;
    private final String title;
    private final String toneSHA256;
    private final Integer toneSize;
    private final String toneUploadTime;
    private final String toneUrl;

    /* JADX INFO: compiled from: PersonalDressInfoDO.kt */
    public static final class a implements Parcelable.Creator<PersonalDressInfoDO> {
        @Override // android.os.Parcelable.Creator
        public final PersonalDressInfoDO createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean bool;
            ArrayList arrayList;
            String str;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            Integer numValueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            Integer numValueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string9 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            Integer numValueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string10 = parcel.readString();
            Integer num = numValueOf5;
            String string11 = parcel.readString();
            Integer numValueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string12 = parcel.readString();
            Integer num2 = numValueOf6;
            String string13 = parcel.readString();
            String string14 = parcel.readString();
            Integer numValueOf7 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string15 = parcel.readString();
            Integer numValueOf8 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string16 = parcel.readString();
            Integer num3 = numValueOf7;
            Integer num4 = numValueOf8;
            String string17 = parcel.readString();
            String string18 = parcel.readString();
            String string19 = parcel.readString();
            Integer numValueOf9 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string20 = parcel.readString();
            boolean z2 = false;
            Integer num5 = numValueOf9;
            String string21 = parcel.readString();
            Integer numValueOf10 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                bool = boolValueOf;
                str = string;
                arrayList = null;
            } else {
                int i10 = parcel.readInt();
                bool = boolValueOf;
                arrayList = new ArrayList(i10);
                str = string;
                int iB = 0;
                while (iB != i10) {
                    iB = b.b(PersonalDressDTO.Tag.CREATOR, parcel, arrayList, iB, 1);
                    i10 = i10;
                    numValueOf = numValueOf;
                }
            }
            Integer num6 = numValueOf;
            Boolean boolValueOf2 = null;
            String string22 = parcel.readString();
            Boolean bool2 = bool;
            String string23 = parcel.readString();
            Integer numValueOf11 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() != 0) {
                    z2 = true;
                }
                boolValueOf2 = Boolean.valueOf(z2);
            }
            return new PersonalDressInfoDO(str, num6, numValueOf2, string2, string3, string4, numValueOf3, string5, string6, string7, string8, numValueOf4, string9, bool2, num, string10, string11, num2, string12, string13, string14, num3, string15, num4, string16, string17, string18, string19, num5, string20, string21, numValueOf10, arrayList, string22, string23, numValueOf11, boolValueOf2);
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalDressInfoDO[] newArray(int i10) {
            return new PersonalDressInfoDO[i10];
        }
    }

    public PersonalDressInfoDO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonalDressInfoDO copy$default(PersonalDressInfoDO personalDressInfoDO, String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, String str5, String str6, String str7, String str8, Integer num4, String str9, Boolean bool, Integer num5, String str10, String str11, Integer num6, String str12, String str13, String str14, Integer num7, String str15, Integer num8, String str16, String str17, String str18, String str19, Integer num9, String str20, String str21, Integer num10, List list, String str22, String str23, Integer num11, Boolean bool2, int i10, int i11, Object obj) {
        Boolean bool3;
        Integer num12;
        String str24;
        Integer num13;
        String str25;
        Integer num14;
        String str26;
        String str27;
        String str28;
        String str29;
        Integer num15;
        String str30;
        String str31;
        Integer num16;
        List list2;
        String str32;
        String str33;
        Integer num17;
        String str34;
        Integer num18;
        String str35;
        String str36;
        String str37;
        String str38;
        Integer num19;
        String str39;
        Boolean bool4;
        String str40;
        String str41;
        Integer num20;
        String str42;
        String str43;
        Integer num21;
        Integer num22;
        String str44;
        String str45;
        String str46 = (i10 & 1) != 0 ? personalDressInfoDO.animSHA256 : str;
        Integer num23 = (i10 & 2) != 0 ? personalDressInfoDO.animType : num;
        Integer num24 = (i10 & 4) != 0 ? personalDressInfoDO.animSize : num2;
        String str47 = (i10 & 8) != 0 ? personalDressInfoDO.animUploadTime : str2;
        String str48 = (i10 & 16) != 0 ? personalDressInfoDO.animUrl : str3;
        String str49 = (i10 & 32) != 0 ? personalDressInfoDO.darkAnimSHA256 : str4;
        Integer num25 = (i10 & 64) != 0 ? personalDressInfoDO.darkAnimSize : num3;
        String str50 = (i10 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? personalDressInfoDO.darkAnimUploadTime : str5;
        String str51 = (i10 & 256) != 0 ? personalDressInfoDO.darkAnimUrl : str6;
        String str52 = (i10 & 512) != 0 ? personalDressInfoDO.darkPreviewAnim : str7;
        String str53 = (i10 & 1024) != 0 ? personalDressInfoDO.darkPreviewAnimSHA256 : str8;
        Integer num26 = (i10 & 2048) != 0 ? personalDressInfoDO.darkPreviewAnimSize : num4;
        String str54 = (i10 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? personalDressInfoDO.id : str9;
        Boolean bool5 = (i10 & 8192) != 0 ? personalDressInfoDO.isStatic : bool;
        String str55 = str46;
        Integer num27 = (i10 & 16384) != 0 ? personalDressInfoDO.materialType : num5;
        String str56 = (i10 & 32768) != 0 ? personalDressInfoDO.previewAnim : str10;
        String str57 = (i10 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? personalDressInfoDO.previewAnimSHA256 : str11;
        Integer num28 = (i10 & 131072) != 0 ? personalDressInfoDO.previewAnimSize : num6;
        String str58 = (i10 & 262144) != 0 ? personalDressInfoDO.previewDetailImgUrl : str12;
        String str59 = (i10 & 524288) != 0 ? personalDressInfoDO.previewListImgUrl : str13;
        String str60 = (i10 & 1048576) != 0 ? personalDressInfoDO.previewToneSHA256 : str14;
        Integer num29 = (i10 & 2097152) != 0 ? personalDressInfoDO.previewToneSize : num7;
        String str61 = (i10 & 4194304) != 0 ? personalDressInfoDO.previewToneUrl : str15;
        Integer num30 = (i10 & 8388608) != 0 ? personalDressInfoDO.publishStatus : num8;
        String str62 = (i10 & 16777216) != 0 ? personalDressInfoDO.summary : str16;
        String str63 = (i10 & 33554432) != 0 ? personalDressInfoDO.themeIdentifier : str17;
        String str64 = (i10 & 67108864) != 0 ? personalDressInfoDO.title : str18;
        String str65 = (i10 & 134217728) != 0 ? personalDressInfoDO.toneSHA256 : str19;
        Integer num31 = (i10 & 268435456) != 0 ? personalDressInfoDO.toneSize : num9;
        String str66 = (i10 & 536870912) != 0 ? personalDressInfoDO.toneUploadTime : str20;
        String str67 = (i10 & 1073741824) != 0 ? personalDressInfoDO.toneUrl : str21;
        Integer num32 = (i10 & Integer.MIN_VALUE) != 0 ? personalDressInfoDO.priority : num10;
        List list3 = (i11 & 1) != 0 ? personalDressInfoDO.tags : list;
        String str68 = (i11 & 2) != 0 ? personalDressInfoDO.cardZipUrl : str22;
        String str69 = (i11 & 4) != 0 ? personalDressInfoDO.cardZipSHA256 : str23;
        Integer num33 = (i11 & 8) != 0 ? personalDressInfoDO.downloadCount : num11;
        if ((i11 & 16) != 0) {
            num12 = num33;
            bool3 = personalDressInfoDO.activity;
            num13 = num29;
            str25 = str61;
            num14 = num30;
            str26 = str62;
            str27 = str63;
            str28 = str64;
            str29 = str65;
            num15 = num31;
            str30 = str66;
            str31 = str67;
            num16 = num32;
            list2 = list3;
            str32 = str68;
            str33 = str69;
            num17 = num27;
            num18 = num25;
            str35 = str50;
            str36 = str51;
            str37 = str52;
            str38 = str53;
            num19 = num26;
            str39 = str54;
            bool4 = bool5;
            str40 = str56;
            str41 = str57;
            num20 = num28;
            str42 = str58;
            str43 = str59;
            str24 = str60;
            num21 = num23;
            num22 = num24;
            str44 = str47;
            str45 = str48;
            str34 = str49;
        } else {
            bool3 = bool2;
            num12 = num33;
            str24 = str60;
            num13 = num29;
            str25 = str61;
            num14 = num30;
            str26 = str62;
            str27 = str63;
            str28 = str64;
            str29 = str65;
            num15 = num31;
            str30 = str66;
            str31 = str67;
            num16 = num32;
            list2 = list3;
            str32 = str68;
            str33 = str69;
            num17 = num27;
            str34 = str49;
            num18 = num25;
            str35 = str50;
            str36 = str51;
            str37 = str52;
            str38 = str53;
            num19 = num26;
            str39 = str54;
            bool4 = bool5;
            str40 = str56;
            str41 = str57;
            num20 = num28;
            str42 = str58;
            str43 = str59;
            num21 = num23;
            num22 = num24;
            str44 = str47;
            str45 = str48;
        }
        return personalDressInfoDO.copy(str55, num21, num22, str44, str45, str34, num18, str35, str36, str37, str38, num19, str39, bool4, num17, str40, str41, num20, str42, str43, str24, num13, str25, num14, str26, str27, str28, str29, num15, str30, str31, num16, list2, str32, str33, num12, bool3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAnimSHA256() {
        return this.animSHA256;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDarkPreviewAnim() {
        return this.darkPreviewAnim;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDarkPreviewAnimSHA256() {
        return this.darkPreviewAnimSHA256;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getDarkPreviewAnimSize() {
        return this.darkPreviewAnimSize;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Boolean getIsStatic() {
        return this.isStatic;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getMaterialType() {
        return this.materialType;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getPreviewAnim() {
        return this.previewAnim;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getPreviewAnimSHA256() {
        return this.previewAnimSHA256;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getPreviewAnimSize() {
        return this.previewAnimSize;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getPreviewDetailImgUrl() {
        return this.previewDetailImgUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getAnimType() {
        return this.animType;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPreviewListImgUrl() {
        return this.previewListImgUrl;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getPreviewToneSHA256() {
        return this.previewToneSHA256;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Integer getPreviewToneSize() {
        return this.previewToneSize;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getPreviewToneUrl() {
        return this.previewToneUrl;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Integer getPublishStatus() {
        return this.publishStatus;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getThemeIdentifier() {
        return this.themeIdentifier;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getToneSHA256() {
        return this.toneSHA256;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Integer getToneSize() {
        return this.toneSize;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getAnimSize() {
        return this.animSize;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final String getToneUploadTime() {
        return this.toneUploadTime;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getToneUrl() {
        return this.toneUrl;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Integer getPriority() {
        return this.priority;
    }

    public final List<PersonalDressDTO.Tag> component33() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final String getCardZipUrl() {
        return this.cardZipUrl;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getCardZipSHA256() {
        return this.cardZipSHA256;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final Integer getDownloadCount() {
        return this.downloadCount;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final Boolean getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAnimUploadTime() {
        return this.animUploadTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnimUrl() {
        return this.animUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDarkAnimSHA256() {
        return this.darkAnimSHA256;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getDarkAnimSize() {
        return this.darkAnimSize;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDarkAnimUploadTime() {
        return this.darkAnimUploadTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDarkAnimUrl() {
        return this.darkAnimUrl;
    }

    public final PersonalDressInfoDO copy(String animSHA256, Integer animType, Integer animSize, String animUploadTime, String animUrl, String darkAnimSHA256, Integer darkAnimSize, String darkAnimUploadTime, String darkAnimUrl, String darkPreviewAnim, String darkPreviewAnimSHA256, Integer darkPreviewAnimSize, String id, Boolean isStatic, Integer materialType, String previewAnim, String previewAnimSHA256, Integer previewAnimSize, String previewDetailImgUrl, String previewListImgUrl, String previewToneSHA256, Integer previewToneSize, String previewToneUrl, Integer publishStatus, String summary, String themeIdentifier, String title, String toneSHA256, Integer toneSize, String toneUploadTime, String toneUrl, Integer priority, List<PersonalDressDTO.Tag> tags, String cardZipUrl, String cardZipSHA256, Integer downloadCount, Boolean activity) {
        return new PersonalDressInfoDO(animSHA256, animType, animSize, animUploadTime, animUrl, darkAnimSHA256, darkAnimSize, darkAnimUploadTime, darkAnimUrl, darkPreviewAnim, darkPreviewAnimSHA256, darkPreviewAnimSize, id, isStatic, materialType, previewAnim, previewAnimSHA256, previewAnimSize, previewDetailImgUrl, previewListImgUrl, previewToneSHA256, previewToneSize, previewToneUrl, publishStatus, summary, themeIdentifier, title, toneSHA256, toneSize, toneUploadTime, toneUrl, priority, tags, cardZipUrl, cardZipSHA256, downloadCount, activity);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final Boolean getActivity() {
        return this.activity;
    }

    public final String getAnimSHA256() {
        return this.animSHA256;
    }

    public final Integer getAnimSize() {
        return this.animSize;
    }

    public final Integer getAnimType() {
        return this.animType;
    }

    public final String getAnimUploadTime() {
        return this.animUploadTime;
    }

    public final String getAnimUrl() {
        return this.animUrl;
    }

    public final String getCardZipSHA256() {
        return this.cardZipSHA256;
    }

    public final String getCardZipUrl() {
        return this.cardZipUrl;
    }

    public final String getDarkAnimSHA256() {
        return this.darkAnimSHA256;
    }

    public final Integer getDarkAnimSize() {
        return this.darkAnimSize;
    }

    public final String getDarkAnimUploadTime() {
        return this.darkAnimUploadTime;
    }

    public final String getDarkAnimUrl() {
        return this.darkAnimUrl;
    }

    public final String getDarkPreviewAnim() {
        return this.darkPreviewAnim;
    }

    public final String getDarkPreviewAnimSHA256() {
        return this.darkPreviewAnimSHA256;
    }

    public final Integer getDarkPreviewAnimSize() {
        return this.darkPreviewAnimSize;
    }

    public final Integer getDownloadCount() {
        return this.downloadCount;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getMaterialType() {
        return this.materialType;
    }

    public final String getPreviewAnim() {
        return this.previewAnim;
    }

    public final String getPreviewAnimSHA256() {
        return this.previewAnimSHA256;
    }

    public final Integer getPreviewAnimSize() {
        return this.previewAnimSize;
    }

    public final String getPreviewDetailImgUrl() {
        return this.previewDetailImgUrl;
    }

    public final String getPreviewListImgUrl() {
        return this.previewListImgUrl;
    }

    public final String getPreviewToneSHA256() {
        return this.previewToneSHA256;
    }

    public final Integer getPreviewToneSize() {
        return this.previewToneSize;
    }

    public final String getPreviewToneUrl() {
        return this.previewToneUrl;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final Integer getPublishStatus() {
        return this.publishStatus;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<PersonalDressDTO.Tag> getTags() {
        return this.tags;
    }

    public final String getThemeIdentifier() {
        return this.themeIdentifier;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToneSHA256() {
        return this.toneSHA256;
    }

    public final Integer getToneSize() {
        return this.toneSize;
    }

    public final String getToneUploadTime() {
        return this.toneUploadTime;
    }

    public final String getToneUrl() {
        return this.toneUrl;
    }

    public final Boolean isStatic() {
        return this.isStatic;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.animSHA256);
        Integer num = this.animType;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.animSize;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.animUploadTime);
        dest.writeString(this.animUrl);
        dest.writeString(this.darkAnimSHA256);
        Integer num3 = this.darkAnimSize;
        if (num3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num3.intValue());
        }
        dest.writeString(this.darkAnimUploadTime);
        dest.writeString(this.darkAnimUrl);
        dest.writeString(this.darkPreviewAnim);
        dest.writeString(this.darkPreviewAnimSHA256);
        Integer num4 = this.darkPreviewAnimSize;
        if (num4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num4.intValue());
        }
        dest.writeString(this.id);
        Boolean bool = this.isStatic;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num5 = this.materialType;
        if (num5 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num5.intValue());
        }
        dest.writeString(this.previewAnim);
        dest.writeString(this.previewAnimSHA256);
        Integer num6 = this.previewAnimSize;
        if (num6 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num6.intValue());
        }
        dest.writeString(this.previewDetailImgUrl);
        dest.writeString(this.previewListImgUrl);
        dest.writeString(this.previewToneSHA256);
        Integer num7 = this.previewToneSize;
        if (num7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num7.intValue());
        }
        dest.writeString(this.previewToneUrl);
        Integer num8 = this.publishStatus;
        if (num8 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num8.intValue());
        }
        dest.writeString(this.summary);
        dest.writeString(this.themeIdentifier);
        dest.writeString(this.title);
        dest.writeString(this.toneSHA256);
        Integer num9 = this.toneSize;
        if (num9 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num9.intValue());
        }
        dest.writeString(this.toneUploadTime);
        dest.writeString(this.toneUrl);
        Integer num10 = this.priority;
        if (num10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num10.intValue());
        }
        List<PersonalDressDTO.Tag> list = this.tags;
        if (list == null) {
            dest.writeInt(0);
        } else {
            Iterator itG = e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((PersonalDressDTO.Tag) itG.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.cardZipUrl);
        dest.writeString(this.cardZipSHA256);
        Integer num11 = this.downloadCount;
        if (num11 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num11.intValue());
        }
        Boolean bool2 = this.activity;
        if (bool2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    public PersonalDressInfoDO(String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, String str5, String str6, String str7, String str8, Integer num4, String str9, Boolean bool, Integer num5, String str10, String str11, Integer num6, String str12, String str13, String str14, Integer num7, String str15, Integer num8, String str16, String str17, String str18, String str19, Integer num9, String str20, String str21, Integer num10, List<PersonalDressDTO.Tag> list, String str22, String str23, Integer num11, Boolean bool2) {
        this.animSHA256 = str;
        this.animType = num;
        this.animSize = num2;
        this.animUploadTime = str2;
        this.animUrl = str3;
        this.darkAnimSHA256 = str4;
        this.darkAnimSize = num3;
        this.darkAnimUploadTime = str5;
        this.darkAnimUrl = str6;
        this.darkPreviewAnim = str7;
        this.darkPreviewAnimSHA256 = str8;
        this.darkPreviewAnimSize = num4;
        this.id = str9;
        this.isStatic = bool;
        this.materialType = num5;
        this.previewAnim = str10;
        this.previewAnimSHA256 = str11;
        this.previewAnimSize = num6;
        this.previewDetailImgUrl = str12;
        this.previewListImgUrl = str13;
        this.previewToneSHA256 = str14;
        this.previewToneSize = num7;
        this.previewToneUrl = str15;
        this.publishStatus = num8;
        this.summary = str16;
        this.themeIdentifier = str17;
        this.title = str18;
        this.toneSHA256 = str19;
        this.toneSize = num9;
        this.toneUploadTime = str20;
        this.toneUrl = str21;
        this.priority = num10;
        this.tags = list;
        this.cardZipUrl = str22;
        this.cardZipSHA256 = str23;
        this.downloadCount = num11;
        this.activity = bool2;
    }

    public /* synthetic */ PersonalDressInfoDO(String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, String str5, String str6, String str7, String str8, Integer num4, String str9, Boolean bool, Integer num5, String str10, String str11, Integer num6, String str12, String str13, String str14, Integer num7, String str15, Integer num8, String str16, String str17, String str18, String str19, Integer num9, String str20, String str21, Integer num10, List list, String str22, String str23, Integer num11, Boolean bool2, int i10, int i11, d dVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : num2, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : str4, (i10 & 64) != 0 ? null : num3, (i10 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : str5, (i10 & 256) != 0 ? null : str6, (i10 & 512) != 0 ? null : str7, (i10 & 1024) != 0 ? null : str8, (i10 & 2048) != 0 ? null : num4, (i10 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : str9, (i10 & 8192) != 0 ? null : bool, (i10 & 16384) != 0 ? null : num5, (i10 & 32768) != 0 ? null : str10, (i10 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? null : str11, (i10 & 131072) != 0 ? null : num6, (i10 & 262144) != 0 ? null : str12, (i10 & 524288) != 0 ? null : str13, (i10 & 1048576) != 0 ? null : str14, (i10 & 2097152) != 0 ? null : num7, (i10 & 4194304) != 0 ? null : str15, (i10 & 8388608) != 0 ? null : num8, (i10 & 16777216) != 0 ? null : str16, (i10 & 33554432) != 0 ? null : str17, (i10 & 67108864) != 0 ? null : str18, (i10 & 134217728) != 0 ? null : str19, (i10 & 268435456) != 0 ? null : num9, (i10 & 536870912) != 0 ? null : str20, (i10 & 1073741824) != 0 ? null : str21, (i10 & Integer.MIN_VALUE) != 0 ? null : num10, (i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : str22, (i11 & 4) != 0 ? null : str23, (i11 & 8) != 0 ? null : num11, (i11 & 16) != 0 ? null : bool2);
    }
}
