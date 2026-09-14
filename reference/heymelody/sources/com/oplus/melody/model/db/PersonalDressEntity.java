package com.oplus.melody.model.db;

import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: PersonalDressEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u007f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B·\u0003\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\b\b\u0002\u0010,\u001a\u00020-¢\u0006\u0004\b.\u0010/J\n\u0010\u0084\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0007HÆ\u0003J\u0012\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010©\u0001\u001a\u00020-HÆ\u0003Jº\u0003\u0010ª\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00072\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010+\u001a\u00020\u00072\b\b\u0002\u0010,\u001a\u00020-HÆ\u0001J\u0007\u0010«\u0001\u001a\u00020\u0007J\u001b\u0010¬\u0001\u001a\u00030\u00ad\u00012\b\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020\u0007R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R \u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00101\"\u0004\bA\u00103R \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00101\"\u0004\bC\u00103R \u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00101\"\u0004\bE\u00103R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00107\"\u0004\bG\u00109R \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00101\"\u0004\bI\u00103R \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00101\"\u0004\bM\u00103R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00101\"\u0004\bO\u00103R\u001e\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00107\"\u0004\bQ\u00109R\u001e\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00107\"\u0004\bS\u00109R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00101\"\u0004\bU\u00103R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00101\"\u0004\bW\u00103R\u001e\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00107\"\u0004\bY\u00109R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00101\"\u0004\b[\u00103R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00101\"\u0004\b]\u00103R \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00101\"\u0004\b_\u00103R \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u00101\"\u0004\ba\u00103R \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103R \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00101\"\u0004\be\u00103R\u001e\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00107\"\u0004\bg\u00109R \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00101\"\u0004\bi\u00103R \u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00101\"\u0004\bk\u00103R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u00101\"\u0004\bm\u00103R\u001e\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u00107\"\u0004\bo\u00109R \u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00101\"\u0004\bq\u00103R\u001e\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u00107\"\u0004\bs\u00109R\u001e\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00107\"\u0004\bu\u00109R&\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR \u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u00101\"\u0004\b{\u00103R \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u00101\"\u0004\b}\u00103R\u001e\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00107\"\u0004\b\u007f\u00109R\"\u0010,\u001a\u00020-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001¨\u0006±\u0001"}, d2 = {"Lcom/oplus/melody/model/db/PersonalDressEntity;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "id", "", "mProductId", "mColorId", "", "animSHA256", "materialType", "animSize", "animUploadTime", "animUrl", "darkAnimSHA256", "darkAnimSize", "darkAnimUploadTime", "darkAnimUrl", "darkPreviewAnim", "darkPreviewAnimSHA256", "darkPreviewAnimSize", "animStatic", "previewAnim", "previewAnimSHA256", "previewAnimSize", "previewDetailImgUrl", "previewListImgUrl", "summary", "themeId", "title", "toneSHA256", "toneSize", "toneUploadTime", "toneUrl", "tonePreviewSHA256", "tonePreviewSize", "tonePreviewUrl", "publishStatus", ClientDataEntity.COL_PRIORITY, "tags", "", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$Tag;", "cardZipUrl", "cardZipSHA256", "downloadCount", "activity", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/util/List;Ljava/lang/String;Ljava/lang/String;IZ)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getMProductId", "setMProductId", "getMColorId", "()I", "setMColorId", "(I)V", "getAnimSHA256", "setAnimSHA256", "getMaterialType", "setMaterialType", "getAnimSize", "setAnimSize", "getAnimUploadTime", "setAnimUploadTime", "getAnimUrl", "setAnimUrl", "getDarkAnimSHA256", "setDarkAnimSHA256", "getDarkAnimSize", "setDarkAnimSize", "getDarkAnimUploadTime", "setDarkAnimUploadTime", "getDarkAnimUrl", "setDarkAnimUrl", "getDarkPreviewAnim", "setDarkPreviewAnim", "getDarkPreviewAnimSHA256", "setDarkPreviewAnimSHA256", "getDarkPreviewAnimSize", "setDarkPreviewAnimSize", "getAnimStatic", "setAnimStatic", "getPreviewAnim", "setPreviewAnim", "getPreviewAnimSHA256", "setPreviewAnimSHA256", "getPreviewAnimSize", "setPreviewAnimSize", "getPreviewDetailImgUrl", "setPreviewDetailImgUrl", "getPreviewListImgUrl", "setPreviewListImgUrl", "getSummary", "setSummary", "getThemeId", "setThemeId", "getTitle", "setTitle", "getToneSHA256", "setToneSHA256", "getToneSize", "setToneSize", "getToneUploadTime", "setToneUploadTime", "getToneUrl", "setToneUrl", "getTonePreviewSHA256", "setTonePreviewSHA256", "getTonePreviewSize", "setTonePreviewSize", "getTonePreviewUrl", "setTonePreviewUrl", "getPublishStatus", "setPublishStatus", "getPriority", "setPriority", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getCardZipUrl", "setCardZipUrl", "getCardZipSHA256", "setCardZipSHA256", "getDownloadCount", "setDownloadCount", "getActivity", "()Z", "setActivity", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PersonalDressEntity extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PersonalDressEntity> CREATOR = new a();
    private boolean activity;
    private String animSHA256;
    private int animSize;
    private int animStatic;
    private String animUploadTime;
    private String animUrl;
    private String cardZipSHA256;
    private String cardZipUrl;
    private String darkAnimSHA256;
    private int darkAnimSize;
    private String darkAnimUploadTime;
    private String darkAnimUrl;
    private String darkPreviewAnim;
    private String darkPreviewAnimSHA256;
    private int darkPreviewAnimSize;
    private int downloadCount;
    private String id;
    private int mColorId;
    private String mProductId;
    private int materialType;
    private String previewAnim;
    private String previewAnimSHA256;
    private int previewAnimSize;
    private String previewDetailImgUrl;
    private String previewListImgUrl;
    private int priority;
    private int publishStatus;
    private String summary;
    private List<PersonalDressDTO.Tag> tags;
    private String themeId;
    private String title;
    private String tonePreviewSHA256;
    private int tonePreviewSize;
    private String tonePreviewUrl;
    private String toneSHA256;
    private int toneSize;
    private String toneUploadTime;
    private String toneUrl;

    /* JADX INFO: compiled from: PersonalDressEntity.kt */
    public static final class a implements Parcelable.Creator<PersonalDressEntity> {
        @Override // android.os.Parcelable.Creator
        public final PersonalDressEntity createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            kotlin.jvm.internal.h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            String string3 = parcel.readString();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            int i13 = parcel.readInt();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            int i14 = parcel.readInt();
            int i15 = parcel.readInt();
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            int i16 = parcel.readInt();
            String string13 = parcel.readString();
            String string14 = parcel.readString();
            String string15 = parcel.readString();
            String string16 = parcel.readString();
            String string17 = parcel.readString();
            String string18 = parcel.readString();
            int i17 = parcel.readInt();
            String string19 = parcel.readString();
            String string20 = parcel.readString();
            String string21 = parcel.readString();
            int i18 = parcel.readInt();
            String string22 = parcel.readString();
            int i19 = parcel.readInt();
            int i20 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i21 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i21);
                int iB = 0;
                while (iB != i21) {
                    iB = A6.b.b(PersonalDressDTO.Tag.CREATOR, parcel, arrayList2, iB, 1);
                    i21 = i21;
                    string2 = string2;
                }
                arrayList = arrayList2;
                string = string;
            }
            return new PersonalDressEntity(string, string2, i10, string3, i11, i12, string4, string5, string6, i13, string7, string8, string9, string10, i14, i15, string11, string12, i16, string13, string14, string15, string16, string17, string18, i17, string19, string20, string21, i18, string22, i19, i20, arrayList, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalDressEntity[] newArray(int i10) {
            return new PersonalDressEntity[i10];
        }
    }

    public PersonalDressEntity() {
        this(null, null, 0, null, 0, 0, null, null, null, 0, null, null, null, null, 0, 0, null, null, 0, null, null, null, null, null, null, 0, null, null, null, 0, null, 0, 0, null, null, null, 0, false, -1, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonalDressEntity copy$default(PersonalDressEntity personalDressEntity, String str, String str2, int i10, String str3, int i11, int i12, String str4, String str5, String str6, int i13, String str7, String str8, String str9, String str10, int i14, int i15, String str11, String str12, int i16, String str13, String str14, String str15, String str16, String str17, String str18, int i17, String str19, String str20, String str21, int i18, String str22, int i19, int i20, List list, String str23, String str24, int i21, boolean z2, int i22, int i23, Object obj) {
        boolean z4;
        int i24;
        String str25;
        String str26;
        String str27;
        String str28;
        int i25;
        String str29;
        String str30;
        String str31;
        int i26;
        String str32;
        int i27;
        int i28;
        List list2;
        String str33;
        String str34;
        int i29;
        String str35;
        String str36;
        String str37;
        int i30;
        String str38;
        String str39;
        String str40;
        String str41;
        int i31;
        String str42;
        String str43;
        int i32;
        String str44;
        String str45;
        String str46;
        int i33;
        String str47;
        int i34;
        int i35;
        String str48 = (i22 & 1) != 0 ? personalDressEntity.id : str;
        String str49 = (i22 & 2) != 0 ? personalDressEntity.mProductId : str2;
        int i36 = (i22 & 4) != 0 ? personalDressEntity.mColorId : i10;
        String str50 = (i22 & 8) != 0 ? personalDressEntity.animSHA256 : str3;
        int i37 = (i22 & 16) != 0 ? personalDressEntity.materialType : i11;
        int i38 = (i22 & 32) != 0 ? personalDressEntity.animSize : i12;
        String str51 = (i22 & 64) != 0 ? personalDressEntity.animUploadTime : str4;
        String str52 = (i22 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? personalDressEntity.animUrl : str5;
        String str53 = (i22 & 256) != 0 ? personalDressEntity.darkAnimSHA256 : str6;
        int i39 = (i22 & 512) != 0 ? personalDressEntity.darkAnimSize : i13;
        String str54 = (i22 & 1024) != 0 ? personalDressEntity.darkAnimUploadTime : str7;
        String str55 = (i22 & 2048) != 0 ? personalDressEntity.darkAnimUrl : str8;
        String str56 = (i22 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? personalDressEntity.darkPreviewAnim : str9;
        String str57 = (i22 & 8192) != 0 ? personalDressEntity.darkPreviewAnimSHA256 : str10;
        String str58 = str48;
        int i40 = (i22 & 16384) != 0 ? personalDressEntity.darkPreviewAnimSize : i14;
        int i41 = (i22 & 32768) != 0 ? personalDressEntity.animStatic : i15;
        String str59 = (i22 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? personalDressEntity.previewAnim : str11;
        String str60 = (i22 & 131072) != 0 ? personalDressEntity.previewAnimSHA256 : str12;
        int i42 = (i22 & 262144) != 0 ? personalDressEntity.previewAnimSize : i16;
        String str61 = (i22 & 524288) != 0 ? personalDressEntity.previewDetailImgUrl : str13;
        String str62 = (i22 & 1048576) != 0 ? personalDressEntity.previewListImgUrl : str14;
        String str63 = (i22 & 2097152) != 0 ? personalDressEntity.summary : str15;
        String str64 = (i22 & 4194304) != 0 ? personalDressEntity.themeId : str16;
        String str65 = (i22 & 8388608) != 0 ? personalDressEntity.title : str17;
        String str66 = (i22 & 16777216) != 0 ? personalDressEntity.toneSHA256 : str18;
        int i43 = (i22 & 33554432) != 0 ? personalDressEntity.toneSize : i17;
        String str67 = (i22 & 67108864) != 0 ? personalDressEntity.toneUploadTime : str19;
        String str68 = (i22 & 134217728) != 0 ? personalDressEntity.toneUrl : str20;
        String str69 = (i22 & 268435456) != 0 ? personalDressEntity.tonePreviewSHA256 : str21;
        int i44 = (i22 & 536870912) != 0 ? personalDressEntity.tonePreviewSize : i18;
        String str70 = (i22 & 1073741824) != 0 ? personalDressEntity.tonePreviewUrl : str22;
        int i45 = (i22 & Integer.MIN_VALUE) != 0 ? personalDressEntity.publishStatus : i19;
        int i46 = (i23 & 1) != 0 ? personalDressEntity.priority : i20;
        List list3 = (i23 & 2) != 0 ? personalDressEntity.tags : list;
        String str71 = (i23 & 4) != 0 ? personalDressEntity.cardZipUrl : str23;
        String str72 = (i23 & 8) != 0 ? personalDressEntity.cardZipSHA256 : str24;
        int i47 = (i23 & 16) != 0 ? personalDressEntity.downloadCount : i21;
        if ((i23 & 32) != 0) {
            i24 = i47;
            z4 = personalDressEntity.activity;
            str26 = str64;
            str27 = str65;
            str28 = str66;
            i25 = i43;
            str29 = str67;
            str30 = str68;
            str31 = str69;
            i26 = i44;
            str32 = str70;
            i27 = i45;
            i28 = i46;
            list2 = list3;
            str33 = str71;
            str34 = str72;
            i29 = i40;
            str36 = str52;
            str37 = str53;
            i30 = i39;
            str38 = str54;
            str39 = str55;
            str40 = str56;
            str41 = str57;
            i31 = i41;
            str42 = str59;
            str43 = str60;
            i32 = i42;
            str44 = str61;
            str45 = str62;
            str25 = str63;
            str46 = str49;
            i33 = i36;
            str47 = str50;
            i34 = i37;
            i35 = i38;
            str35 = str51;
        } else {
            z4 = z2;
            i24 = i47;
            str25 = str63;
            str26 = str64;
            str27 = str65;
            str28 = str66;
            i25 = i43;
            str29 = str67;
            str30 = str68;
            str31 = str69;
            i26 = i44;
            str32 = str70;
            i27 = i45;
            i28 = i46;
            list2 = list3;
            str33 = str71;
            str34 = str72;
            i29 = i40;
            str35 = str51;
            str36 = str52;
            str37 = str53;
            i30 = i39;
            str38 = str54;
            str39 = str55;
            str40 = str56;
            str41 = str57;
            i31 = i41;
            str42 = str59;
            str43 = str60;
            i32 = i42;
            str44 = str61;
            str45 = str62;
            str46 = str49;
            i33 = i36;
            str47 = str50;
            i34 = i37;
            i35 = i38;
        }
        return personalDressEntity.copy(str58, str46, i33, str47, i34, i35, str35, str36, str37, i30, str38, str39, str40, str41, i29, i31, str42, str43, i32, str44, str45, str25, str26, str27, str28, i25, str29, str30, str31, i26, str32, i27, i28, list2, str33, str34, i24, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getDarkAnimSize() {
        return this.darkAnimSize;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getDarkAnimUploadTime() {
        return this.darkAnimUploadTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDarkAnimUrl() {
        return this.darkAnimUrl;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getDarkPreviewAnim() {
        return this.darkPreviewAnim;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDarkPreviewAnimSHA256() {
        return this.darkPreviewAnimSHA256;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getDarkPreviewAnimSize() {
        return this.darkPreviewAnimSize;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getAnimStatic() {
        return this.animStatic;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getPreviewAnim() {
        return this.previewAnim;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getPreviewAnimSHA256() {
        return this.previewAnimSHA256;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getPreviewAnimSize() {
        return this.previewAnimSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMProductId() {
        return this.mProductId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getPreviewDetailImgUrl() {
        return this.previewDetailImgUrl;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getPreviewListImgUrl() {
        return this.previewListImgUrl;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getThemeId() {
        return this.themeId;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getToneSHA256() {
        return this.toneSHA256;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getToneSize() {
        return this.toneSize;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final String getToneUploadTime() {
        return this.toneUploadTime;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getToneUrl() {
        return this.toneUrl;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final String getTonePreviewSHA256() {
        return this.tonePreviewSHA256;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMColorId() {
        return this.mColorId;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final int getTonePreviewSize() {
        return this.tonePreviewSize;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getTonePreviewUrl() {
        return this.tonePreviewUrl;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final int getPublishStatus() {
        return this.publishStatus;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    public final List<PersonalDressDTO.Tag> component34() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getCardZipUrl() {
        return this.cardZipUrl;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getCardZipSHA256() {
        return this.cardZipSHA256;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final int getDownloadCount() {
        return this.downloadCount;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final boolean getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAnimSHA256() {
        return this.animSHA256;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getMaterialType() {
        return this.materialType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAnimSize() {
        return this.animSize;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAnimUploadTime() {
        return this.animUploadTime;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAnimUrl() {
        return this.animUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDarkAnimSHA256() {
        return this.darkAnimSHA256;
    }

    public final PersonalDressEntity copy(String id, String mProductId, int mColorId, String animSHA256, int materialType, int animSize, String animUploadTime, String animUrl, String darkAnimSHA256, int darkAnimSize, String darkAnimUploadTime, String darkAnimUrl, String darkPreviewAnim, String darkPreviewAnimSHA256, int darkPreviewAnimSize, int animStatic, String previewAnim, String previewAnimSHA256, int previewAnimSize, String previewDetailImgUrl, String previewListImgUrl, String summary, String themeId, String title, String toneSHA256, int toneSize, String toneUploadTime, String toneUrl, String tonePreviewSHA256, int tonePreviewSize, String tonePreviewUrl, int publishStatus, int priority, List<PersonalDressDTO.Tag> tags, String cardZipUrl, String cardZipSHA256, int downloadCount, boolean activity) {
        kotlin.jvm.internal.h.e(id, "id");
        kotlin.jvm.internal.h.e(mProductId, "mProductId");
        return new PersonalDressEntity(id, mProductId, mColorId, animSHA256, materialType, animSize, animUploadTime, animUrl, darkAnimSHA256, darkAnimSize, darkAnimUploadTime, darkAnimUrl, darkPreviewAnim, darkPreviewAnimSHA256, darkPreviewAnimSize, animStatic, previewAnim, previewAnimSHA256, previewAnimSize, previewDetailImgUrl, previewListImgUrl, summary, themeId, title, toneSHA256, toneSize, toneUploadTime, toneUrl, tonePreviewSHA256, tonePreviewSize, tonePreviewUrl, publishStatus, priority, tags, cardZipUrl, cardZipSHA256, downloadCount, activity);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean getActivity() {
        return this.activity;
    }

    public final String getAnimSHA256() {
        return this.animSHA256;
    }

    public final int getAnimSize() {
        return this.animSize;
    }

    public final int getAnimStatic() {
        return this.animStatic;
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

    public final int getDarkAnimSize() {
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

    public final int getDarkPreviewAnimSize() {
        return this.darkPreviewAnimSize;
    }

    public final int getDownloadCount() {
        return this.downloadCount;
    }

    public final String getId() {
        return this.id;
    }

    public final int getMColorId() {
        return this.mColorId;
    }

    public final String getMProductId() {
        return this.mProductId;
    }

    public final int getMaterialType() {
        return this.materialType;
    }

    public final String getPreviewAnim() {
        return this.previewAnim;
    }

    public final String getPreviewAnimSHA256() {
        return this.previewAnimSHA256;
    }

    public final int getPreviewAnimSize() {
        return this.previewAnimSize;
    }

    public final String getPreviewDetailImgUrl() {
        return this.previewDetailImgUrl;
    }

    public final String getPreviewListImgUrl() {
        return this.previewListImgUrl;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getPublishStatus() {
        return this.publishStatus;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<PersonalDressDTO.Tag> getTags() {
        return this.tags;
    }

    public final String getThemeId() {
        return this.themeId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTonePreviewSHA256() {
        return this.tonePreviewSHA256;
    }

    public final int getTonePreviewSize() {
        return this.tonePreviewSize;
    }

    public final String getTonePreviewUrl() {
        return this.tonePreviewUrl;
    }

    public final String getToneSHA256() {
        return this.toneSHA256;
    }

    public final int getToneSize() {
        return this.toneSize;
    }

    public final String getToneUploadTime() {
        return this.toneUploadTime;
    }

    public final String getToneUrl() {
        return this.toneUrl;
    }

    public final void setActivity(boolean z2) {
        this.activity = z2;
    }

    public final void setAnimSHA256(String str) {
        this.animSHA256 = str;
    }

    public final void setAnimSize(int i10) {
        this.animSize = i10;
    }

    public final void setAnimStatic(int i10) {
        this.animStatic = i10;
    }

    public final void setAnimUploadTime(String str) {
        this.animUploadTime = str;
    }

    public final void setAnimUrl(String str) {
        this.animUrl = str;
    }

    public final void setCardZipSHA256(String str) {
        this.cardZipSHA256 = str;
    }

    public final void setCardZipUrl(String str) {
        this.cardZipUrl = str;
    }

    public final void setDarkAnimSHA256(String str) {
        this.darkAnimSHA256 = str;
    }

    public final void setDarkAnimSize(int i10) {
        this.darkAnimSize = i10;
    }

    public final void setDarkAnimUploadTime(String str) {
        this.darkAnimUploadTime = str;
    }

    public final void setDarkAnimUrl(String str) {
        this.darkAnimUrl = str;
    }

    public final void setDarkPreviewAnim(String str) {
        this.darkPreviewAnim = str;
    }

    public final void setDarkPreviewAnimSHA256(String str) {
        this.darkPreviewAnimSHA256 = str;
    }

    public final void setDarkPreviewAnimSize(int i10) {
        this.darkPreviewAnimSize = i10;
    }

    public final void setDownloadCount(int i10) {
        this.downloadCount = i10;
    }

    public final void setId(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.id = str;
    }

    public final void setMColorId(int i10) {
        this.mColorId = i10;
    }

    public final void setMProductId(String str) {
        kotlin.jvm.internal.h.e(str, "<set-?>");
        this.mProductId = str;
    }

    public final void setMaterialType(int i10) {
        this.materialType = i10;
    }

    public final void setPreviewAnim(String str) {
        this.previewAnim = str;
    }

    public final void setPreviewAnimSHA256(String str) {
        this.previewAnimSHA256 = str;
    }

    public final void setPreviewAnimSize(int i10) {
        this.previewAnimSize = i10;
    }

    public final void setPreviewDetailImgUrl(String str) {
        this.previewDetailImgUrl = str;
    }

    public final void setPreviewListImgUrl(String str) {
        this.previewListImgUrl = str;
    }

    public final void setPriority(int i10) {
        this.priority = i10;
    }

    public final void setPublishStatus(int i10) {
        this.publishStatus = i10;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final void setTags(List<PersonalDressDTO.Tag> list) {
        this.tags = list;
    }

    public final void setThemeId(String str) {
        this.themeId = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTonePreviewSHA256(String str) {
        this.tonePreviewSHA256 = str;
    }

    public final void setTonePreviewSize(int i10) {
        this.tonePreviewSize = i10;
    }

    public final void setTonePreviewUrl(String str) {
        this.tonePreviewUrl = str;
    }

    public final void setToneSHA256(String str) {
        this.toneSHA256 = str;
    }

    public final void setToneSize(int i10) {
        this.toneSize = i10;
    }

    public final void setToneUploadTime(String str) {
        this.toneUploadTime = str;
    }

    public final void setToneUrl(String str) {
        this.toneUrl = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.mProductId);
        dest.writeInt(this.mColorId);
        dest.writeString(this.animSHA256);
        dest.writeInt(this.materialType);
        dest.writeInt(this.animSize);
        dest.writeString(this.animUploadTime);
        dest.writeString(this.animUrl);
        dest.writeString(this.darkAnimSHA256);
        dest.writeInt(this.darkAnimSize);
        dest.writeString(this.darkAnimUploadTime);
        dest.writeString(this.darkAnimUrl);
        dest.writeString(this.darkPreviewAnim);
        dest.writeString(this.darkPreviewAnimSHA256);
        dest.writeInt(this.darkPreviewAnimSize);
        dest.writeInt(this.animStatic);
        dest.writeString(this.previewAnim);
        dest.writeString(this.previewAnimSHA256);
        dest.writeInt(this.previewAnimSize);
        dest.writeString(this.previewDetailImgUrl);
        dest.writeString(this.previewListImgUrl);
        dest.writeString(this.summary);
        dest.writeString(this.themeId);
        dest.writeString(this.title);
        dest.writeString(this.toneSHA256);
        dest.writeInt(this.toneSize);
        dest.writeString(this.toneUploadTime);
        dest.writeString(this.toneUrl);
        dest.writeString(this.tonePreviewSHA256);
        dest.writeInt(this.tonePreviewSize);
        dest.writeString(this.tonePreviewUrl);
        dest.writeInt(this.publishStatus);
        dest.writeInt(this.priority);
        List<PersonalDressDTO.Tag> list = this.tags;
        if (list == null) {
            dest.writeInt(0);
        } else {
            Iterator itG = A6.e.g(dest, 1, list);
            while (itG.hasNext()) {
                ((PersonalDressDTO.Tag) itG.next()).writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.cardZipUrl);
        dest.writeString(this.cardZipSHA256);
        dest.writeInt(this.downloadCount);
        dest.writeInt(this.activity ? 1 : 0);
    }

    public PersonalDressEntity(String id, String mProductId, int i10, String str, int i11, int i12, String str2, String str3, String str4, int i13, String str5, String str6, String str7, String str8, int i14, int i15, String str9, String str10, int i16, String str11, String str12, String str13, String str14, String str15, String str16, int i17, String str17, String str18, String str19, int i18, String str20, int i19, int i20, List<PersonalDressDTO.Tag> list, String str21, String str22, int i21, boolean z2) {
        kotlin.jvm.internal.h.e(id, "id");
        kotlin.jvm.internal.h.e(mProductId, "mProductId");
        this.id = id;
        this.mProductId = mProductId;
        this.mColorId = i10;
        this.animSHA256 = str;
        this.materialType = i11;
        this.animSize = i12;
        this.animUploadTime = str2;
        this.animUrl = str3;
        this.darkAnimSHA256 = str4;
        this.darkAnimSize = i13;
        this.darkAnimUploadTime = str5;
        this.darkAnimUrl = str6;
        this.darkPreviewAnim = str7;
        this.darkPreviewAnimSHA256 = str8;
        this.darkPreviewAnimSize = i14;
        this.animStatic = i15;
        this.previewAnim = str9;
        this.previewAnimSHA256 = str10;
        this.previewAnimSize = i16;
        this.previewDetailImgUrl = str11;
        this.previewListImgUrl = str12;
        this.summary = str13;
        this.themeId = str14;
        this.title = str15;
        this.toneSHA256 = str16;
        this.toneSize = i17;
        this.toneUploadTime = str17;
        this.toneUrl = str18;
        this.tonePreviewSHA256 = str19;
        this.tonePreviewSize = i18;
        this.tonePreviewUrl = str20;
        this.publishStatus = i19;
        this.priority = i20;
        this.tags = list;
        this.cardZipUrl = str21;
        this.cardZipSHA256 = str22;
        this.downloadCount = i21;
        this.activity = z2;
    }

    public /* synthetic */ PersonalDressEntity(String str, String str2, int i10, String str3, int i11, int i12, String str4, String str5, String str6, int i13, String str7, String str8, String str9, String str10, int i14, int i15, String str11, String str12, int i16, String str13, String str14, String str15, String str16, String str17, String str18, int i17, String str19, String str20, String str21, int i18, String str22, int i19, int i20, List list, String str23, String str24, int i21, boolean z2, int i22, int i23, kotlin.jvm.internal.d dVar) {
        this((i22 & 1) != 0 ? VersionInfo.VENDOR_CODE_DEFAULT_VERSION : str, (i22 & 2) == 0 ? str2 : VersionInfo.VENDOR_CODE_DEFAULT_VERSION, (i22 & 4) != 0 ? 0 : i10, (i22 & 8) != 0 ? null : str3, (i22 & 16) != 0 ? 0 : i11, (i22 & 32) != 0 ? 0 : i12, (i22 & 64) != 0 ? null : str4, (i22 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : str5, (i22 & 256) != 0 ? null : str6, (i22 & 512) != 0 ? 0 : i13, (i22 & 1024) != 0 ? null : str7, (i22 & 2048) != 0 ? null : str8, (i22 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : str9, (i22 & 8192) != 0 ? null : str10, (i22 & 16384) != 0 ? 0 : i14, (i22 & 32768) != 0 ? 0 : i15, (i22 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? null : str11, (i22 & 131072) != 0 ? null : str12, (i22 & 262144) != 0 ? 0 : i16, (i22 & 524288) != 0 ? null : str13, (i22 & 1048576) != 0 ? null : str14, (i22 & 2097152) != 0 ? null : str15, (i22 & 4194304) != 0 ? null : str16, (i22 & 8388608) != 0 ? null : str17, (i22 & 16777216) != 0 ? null : str18, (i22 & 33554432) != 0 ? 0 : i17, (i22 & 67108864) != 0 ? null : str19, (i22 & 134217728) != 0 ? null : str20, (i22 & 268435456) != 0 ? null : str21, (i22 & 536870912) != 0 ? 0 : i18, (i22 & 1073741824) != 0 ? null : str22, (i22 & Integer.MIN_VALUE) != 0 ? 0 : i19, (i23 & 1) != 0 ? 0 : i20, (i23 & 2) != 0 ? null : list, (i23 & 4) != 0 ? null : str23, (i23 & 8) != 0 ? null : str24, (i23 & 16) != 0 ? 0 : i21, (i23 & 32) != 0 ? false : z2);
    }
}
