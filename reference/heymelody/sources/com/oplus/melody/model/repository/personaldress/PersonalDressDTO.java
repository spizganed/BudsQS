package com.oplus.melody.model.repository.personaldress;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.drs.rom.sdk.comm.db.ClientDataEntity;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlinx.parcelize.Parcelize;

/* JADX INFO: compiled from: PersonalDressDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\"#B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "productId", "", "color", "", "personalDressData", "", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getColor", "()I", "setColor", "(I)V", "getPersonalDressData", "()Ljava/util/List;", "setPersonalDressData", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "PersonalDressData", "Tag", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PersonalDressDTO extends com.oplus.melody.common.data.a implements Parcelable {
    public static final Parcelable.Creator<PersonalDressDTO> CREATOR = new a();
    private int color;
    private List<PersonalDressData> personalDressData;
    private String productId;

    /* JADX INFO: compiled from: PersonalDressDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b}\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B¯\u0003\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0006\u0012\b\b\u0002\u0010,\u001a\u00020-¢\u0006\u0004\b.\u0010/J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0006HÆ\u0003J\u0012\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010¦\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010§\u0001\u001a\u00020-HÆ\u0003J²\u0003\u0010¨\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010+\u001a\u00020\u00062\b\b\u0002\u0010,\u001a\u00020-HÆ\u0001J\u0007\u0010©\u0001\u001a\u00020\u0006J\u001b\u0010ª\u0001\u001a\u00030«\u00012\b\u0010¬\u0001\u001a\u00030\u00ad\u00012\u0007\u0010®\u0001\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00101\"\u0004\b=\u00103R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00101\"\u0004\bC\u00103R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00101\"\u0004\bE\u00103R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00101\"\u0004\bG\u00103R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00101\"\u0004\bI\u00103R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00105\"\u0004\bK\u00107R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00101\"\u0004\bM\u00103R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00105\"\u0004\bP\u00107R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00101\"\u0004\bR\u00103R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00101\"\u0004\bT\u00103R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00105\"\u0004\bV\u00107R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00101\"\u0004\bX\u00103R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00101\"\u0004\bZ\u00103R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00101\"\u0004\b`\u00103R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\\\"\u0004\bb\u0010^R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00101\"\u0004\bd\u00103R\u001a\u0010\u001e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00105\"\u0004\bf\u00107R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u00101\"\u0004\bh\u00103R\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00101\"\u0004\bj\u00103R\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00101\"\u0004\bl\u00103R\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00105\"\u0004\bn\u00107R\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00101\"\u0004\bp\u00103R\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00105\"\u0004\br\u00107R\u001a\u0010%\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00105\"\u0004\bt\u00107R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00101\"\u0004\bz\u00103R\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u00101\"\u0004\b|\u00103R\u001a\u0010+\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u00105\"\u0004\b~\u00107R\u001d\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006¯\u0001"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$PersonalDressData;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "animSHA256", "", "animType", "", "animSize", "animUploadTime", "animUrl", "darkAnimSHA256", "darkAnimSize", "darkAnimUploadTime", "darkAnimUrl", "darkPreviewAnim", "darkPreviewAnimSHA256", "darkPreviewAnimSize", "id", "materialType", "isStatic", "previewAnim", "previewAnimSHA256", "previewAnimSize", "previewDetailImgUrl", "previewListImgUrl", "summary", "Landroid/os/Bundle;", "themeId", "title", "toneSHA256", "toneSize", "toneUploadTime", "toneUrl", "tonePreviewSHA256", "tonePreviewSize", "tonePreviewUrl", "publishStatus", ClientDataEntity.COL_PRIORITY, "tags", "", "Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$Tag;", "cardZipUrl", "cardZipSHA256", "downloadCount", "activity", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IILjava/util/List;Ljava/lang/String;Ljava/lang/String;IZ)V", "getAnimSHA256", "()Ljava/lang/String;", "setAnimSHA256", "(Ljava/lang/String;)V", "getAnimType", "()I", "setAnimType", "(I)V", "getAnimSize", "setAnimSize", "getAnimUploadTime", "setAnimUploadTime", "getAnimUrl", "setAnimUrl", "getDarkAnimSHA256", "setDarkAnimSHA256", "getDarkAnimSize", "setDarkAnimSize", "getDarkAnimUploadTime", "setDarkAnimUploadTime", "getDarkAnimUrl", "setDarkAnimUrl", "getDarkPreviewAnim", "setDarkPreviewAnim", "getDarkPreviewAnimSHA256", "setDarkPreviewAnimSHA256", "getDarkPreviewAnimSize", "setDarkPreviewAnimSize", "getId", "setId", "getMaterialType", "setMaterialType", "setStatic", "getPreviewAnim", "setPreviewAnim", "getPreviewAnimSHA256", "setPreviewAnimSHA256", "getPreviewAnimSize", "setPreviewAnimSize", "getPreviewDetailImgUrl", "setPreviewDetailImgUrl", "getPreviewListImgUrl", "setPreviewListImgUrl", "getSummary", "()Landroid/os/Bundle;", "setSummary", "(Landroid/os/Bundle;)V", "getThemeId", "setThemeId", "getTitle", "setTitle", "getToneSHA256", "setToneSHA256", "getToneSize", "setToneSize", "getToneUploadTime", "setToneUploadTime", "getToneUrl", "setToneUrl", "getTonePreviewSHA256", "setTonePreviewSHA256", "getTonePreviewSize", "setTonePreviewSize", "getTonePreviewUrl", "setTonePreviewUrl", "getPublishStatus", "setPublishStatus", "getPriority", "setPriority", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getCardZipUrl", "setCardZipUrl", "getCardZipSHA256", "setCardZipSHA256", "getDownloadCount", "setDownloadCount", "getActivity", "()Z", "setActivity", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class PersonalDressData extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<PersonalDressData> CREATOR = new a();
        private boolean activity;
        private String animSHA256;
        private int animSize;
        private int animType;
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
        private int isStatic;
        private int materialType;
        private String previewAnim;
        private String previewAnimSHA256;
        private int previewAnimSize;
        private String previewDetailImgUrl;
        private String previewListImgUrl;
        private int priority;
        private int publishStatus;
        private Bundle summary;
        private List<Tag> tags;
        private String themeId;
        private Bundle title;
        private String tonePreviewSHA256;
        private int tonePreviewSize;
        private String tonePreviewUrl;
        private String toneSHA256;
        private int toneSize;
        private String toneUploadTime;
        private String toneUrl;

        /* JADX INFO: compiled from: PersonalDressDTO.kt */
        public static final class a implements Parcelable.Creator<PersonalDressData> {
            @Override // android.os.Parcelable.Creator
            public final PersonalDressData createFromParcel(Parcel parcel) {
                ArrayList arrayList;
                h.e(parcel, "parcel");
                String string = parcel.readString();
                int i10 = parcel.readInt();
                int i11 = parcel.readInt();
                String string2 = parcel.readString();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                int i12 = parcel.readInt();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                int i13 = parcel.readInt();
                String string9 = parcel.readString();
                int i14 = parcel.readInt();
                int i15 = parcel.readInt();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                int i16 = parcel.readInt();
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                Bundle bundle = parcel.readBundle(PersonalDressData.class.getClassLoader());
                String string14 = parcel.readString();
                Bundle bundle2 = parcel.readBundle(PersonalDressData.class.getClassLoader());
                String string15 = parcel.readString();
                int i17 = parcel.readInt();
                String string16 = parcel.readString();
                String string17 = parcel.readString();
                String string18 = parcel.readString();
                int i18 = parcel.readInt();
                String string19 = parcel.readString();
                int i19 = parcel.readInt();
                int i20 = parcel.readInt();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i21 = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(i21);
                    int iB = 0;
                    while (iB != i21) {
                        iB = A6.b.b(Tag.CREATOR, parcel, arrayList2, iB, 1);
                        i21 = i21;
                        i10 = i10;
                    }
                    arrayList = arrayList2;
                    string = string;
                }
                return new PersonalDressData(string, i10, i11, string2, string3, string4, i12, string5, string6, string7, string8, i13, string9, i14, i15, string10, string11, i16, string12, string13, bundle, string14, bundle2, string15, i17, string16, string17, string18, i18, string19, i19, i20, arrayList, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            public final PersonalDressData[] newArray(int i10) {
                return new PersonalDressData[i10];
            }
        }

        public PersonalDressData() {
            this(null, 0, 0, null, null, null, 0, null, null, null, null, 0, null, 0, 0, null, null, 0, null, null, null, null, null, null, 0, null, null, null, 0, null, 0, 0, null, null, null, 0, false, -1, 31, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PersonalDressData copy$default(PersonalDressData personalDressData, String str, int i10, int i11, String str2, String str3, String str4, int i12, String str5, String str6, String str7, String str8, int i13, String str9, int i14, int i15, String str10, String str11, int i16, String str12, String str13, Bundle bundle, String str14, Bundle bundle2, String str15, int i17, String str16, String str17, String str18, int i18, String str19, int i19, int i20, List list, String str20, String str21, int i21, boolean z2, int i22, int i23, Object obj) {
            boolean z4;
            int i24;
            Bundle bundle3;
            String str22;
            Bundle bundle4;
            String str23;
            int i25;
            String str24;
            String str25;
            String str26;
            int i26;
            String str27;
            int i27;
            int i28;
            List list2;
            String str28;
            String str29;
            int i29;
            String str30;
            int i30;
            String str31;
            String str32;
            String str33;
            String str34;
            int i31;
            String str35;
            int i32;
            String str36;
            String str37;
            int i33;
            String str38;
            String str39;
            int i34;
            int i35;
            String str40;
            String str41;
            String str42 = (i22 & 1) != 0 ? personalDressData.animSHA256 : str;
            int i36 = (i22 & 2) != 0 ? personalDressData.animType : i10;
            int i37 = (i22 & 4) != 0 ? personalDressData.animSize : i11;
            String str43 = (i22 & 8) != 0 ? personalDressData.animUploadTime : str2;
            String str44 = (i22 & 16) != 0 ? personalDressData.animUrl : str3;
            String str45 = (i22 & 32) != 0 ? personalDressData.darkAnimSHA256 : str4;
            int i38 = (i22 & 64) != 0 ? personalDressData.darkAnimSize : i12;
            String str46 = (i22 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? personalDressData.darkAnimUploadTime : str5;
            String str47 = (i22 & 256) != 0 ? personalDressData.darkAnimUrl : str6;
            String str48 = (i22 & 512) != 0 ? personalDressData.darkPreviewAnim : str7;
            String str49 = (i22 & 1024) != 0 ? personalDressData.darkPreviewAnimSHA256 : str8;
            int i39 = (i22 & 2048) != 0 ? personalDressData.darkPreviewAnimSize : i13;
            String str50 = (i22 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? personalDressData.id : str9;
            int i40 = (i22 & 8192) != 0 ? personalDressData.materialType : i14;
            String str51 = str42;
            int i41 = (i22 & 16384) != 0 ? personalDressData.isStatic : i15;
            String str52 = (i22 & 32768) != 0 ? personalDressData.previewAnim : str10;
            String str53 = (i22 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? personalDressData.previewAnimSHA256 : str11;
            int i42 = (i22 & 131072) != 0 ? personalDressData.previewAnimSize : i16;
            String str54 = (i22 & 262144) != 0 ? personalDressData.previewDetailImgUrl : str12;
            String str55 = (i22 & 524288) != 0 ? personalDressData.previewListImgUrl : str13;
            Bundle bundle5 = (i22 & 1048576) != 0 ? personalDressData.summary : bundle;
            String str56 = (i22 & 2097152) != 0 ? personalDressData.themeId : str14;
            Bundle bundle6 = (i22 & 4194304) != 0 ? personalDressData.title : bundle2;
            String str57 = (i22 & 8388608) != 0 ? personalDressData.toneSHA256 : str15;
            int i43 = (i22 & 16777216) != 0 ? personalDressData.toneSize : i17;
            String str58 = (i22 & 33554432) != 0 ? personalDressData.toneUploadTime : str16;
            String str59 = (i22 & 67108864) != 0 ? personalDressData.toneUrl : str17;
            String str60 = (i22 & 134217728) != 0 ? personalDressData.tonePreviewSHA256 : str18;
            int i44 = (i22 & 268435456) != 0 ? personalDressData.tonePreviewSize : i18;
            String str61 = (i22 & 536870912) != 0 ? personalDressData.tonePreviewUrl : str19;
            int i45 = (i22 & 1073741824) != 0 ? personalDressData.publishStatus : i19;
            int i46 = (i22 & Integer.MIN_VALUE) != 0 ? personalDressData.priority : i20;
            List list3 = (i23 & 1) != 0 ? personalDressData.tags : list;
            String str62 = (i23 & 2) != 0 ? personalDressData.cardZipUrl : str20;
            String str63 = (i23 & 4) != 0 ? personalDressData.cardZipSHA256 : str21;
            int i47 = (i23 & 8) != 0 ? personalDressData.downloadCount : i21;
            if ((i23 & 16) != 0) {
                i24 = i47;
                z4 = personalDressData.activity;
                str22 = str56;
                bundle4 = bundle6;
                str23 = str57;
                i25 = i43;
                str24 = str58;
                str25 = str59;
                str26 = str60;
                i26 = i44;
                str27 = str61;
                i27 = i45;
                i28 = i46;
                list2 = list3;
                str28 = str62;
                str29 = str63;
                i29 = i41;
                i30 = i38;
                str31 = str46;
                str32 = str47;
                str33 = str48;
                str34 = str49;
                i31 = i39;
                str35 = str50;
                i32 = i40;
                str36 = str52;
                str37 = str53;
                i33 = i42;
                str38 = str54;
                str39 = str55;
                bundle3 = bundle5;
                i34 = i36;
                i35 = i37;
                str40 = str43;
                str41 = str44;
                str30 = str45;
            } else {
                z4 = z2;
                i24 = i47;
                bundle3 = bundle5;
                str22 = str56;
                bundle4 = bundle6;
                str23 = str57;
                i25 = i43;
                str24 = str58;
                str25 = str59;
                str26 = str60;
                i26 = i44;
                str27 = str61;
                i27 = i45;
                i28 = i46;
                list2 = list3;
                str28 = str62;
                str29 = str63;
                i29 = i41;
                str30 = str45;
                i30 = i38;
                str31 = str46;
                str32 = str47;
                str33 = str48;
                str34 = str49;
                i31 = i39;
                str35 = str50;
                i32 = i40;
                str36 = str52;
                str37 = str53;
                i33 = i42;
                str38 = str54;
                str39 = str55;
                i34 = i36;
                i35 = i37;
                str40 = str43;
                str41 = str44;
            }
            return personalDressData.copy(str51, i34, i35, str40, str41, str30, i30, str31, str32, str33, str34, i31, str35, i32, i29, str36, str37, i33, str38, str39, bundle3, str22, bundle4, str23, i25, str24, str25, str26, i26, str27, i27, i28, list2, str28, str29, i24, z4);
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
        public final int getDarkPreviewAnimSize() {
            return this.darkPreviewAnimSize;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final int getMaterialType() {
            return this.materialType;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getIsStatic() {
            return this.isStatic;
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
        public final int getPreviewAnimSize() {
            return this.previewAnimSize;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getPreviewDetailImgUrl() {
            return this.previewDetailImgUrl;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAnimType() {
            return this.animType;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getPreviewListImgUrl() {
            return this.previewListImgUrl;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final Bundle getSummary() {
            return this.summary;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getThemeId() {
            return this.themeId;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final Bundle getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final String getToneSHA256() {
            return this.toneSHA256;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final int getToneSize() {
            return this.toneSize;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final String getToneUploadTime() {
            return this.toneUploadTime;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final String getToneUrl() {
            return this.toneUrl;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final String getTonePreviewSHA256() {
            return this.tonePreviewSHA256;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final int getTonePreviewSize() {
            return this.tonePreviewSize;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getAnimSize() {
            return this.animSize;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final String getTonePreviewUrl() {
            return this.tonePreviewUrl;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final int getPublishStatus() {
            return this.publishStatus;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        public final List<Tag> component33() {
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
        public final int getDownloadCount() {
            return this.downloadCount;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final boolean getActivity() {
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
        public final int getDarkAnimSize() {
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

        public final PersonalDressData copy(String animSHA256, int animType, int animSize, String animUploadTime, String animUrl, String darkAnimSHA256, int darkAnimSize, String darkAnimUploadTime, String darkAnimUrl, String darkPreviewAnim, String darkPreviewAnimSHA256, int darkPreviewAnimSize, String id, int materialType, int isStatic, String previewAnim, String previewAnimSHA256, int previewAnimSize, String previewDetailImgUrl, String previewListImgUrl, Bundle summary, String themeId, Bundle title, String toneSHA256, int toneSize, String toneUploadTime, String toneUrl, String tonePreviewSHA256, int tonePreviewSize, String tonePreviewUrl, int publishStatus, int priority, List<Tag> tags, String cardZipUrl, String cardZipSHA256, int downloadCount, boolean activity) {
            return new PersonalDressData(animSHA256, animType, animSize, animUploadTime, animUrl, darkAnimSHA256, darkAnimSize, darkAnimUploadTime, darkAnimUrl, darkPreviewAnim, darkPreviewAnimSHA256, darkPreviewAnimSize, id, materialType, isStatic, previewAnim, previewAnimSHA256, previewAnimSize, previewDetailImgUrl, previewListImgUrl, summary, themeId, title, toneSHA256, toneSize, toneUploadTime, toneUrl, tonePreviewSHA256, tonePreviewSize, tonePreviewUrl, publishStatus, priority, tags, cardZipUrl, cardZipSHA256, downloadCount, activity);
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

        public final int getAnimType() {
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

        public final Bundle getSummary() {
            return this.summary;
        }

        public final List<Tag> getTags() {
            return this.tags;
        }

        public final String getThemeId() {
            return this.themeId;
        }

        public final Bundle getTitle() {
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

        public final int isStatic() {
            return this.isStatic;
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

        public final void setAnimType(int i10) {
            this.animType = i10;
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
            this.id = str;
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

        public final void setStatic(int i10) {
            this.isStatic = i10;
        }

        public final void setSummary(Bundle bundle) {
            this.summary = bundle;
        }

        public final void setTags(List<Tag> list) {
            this.tags = list;
        }

        public final void setThemeId(String str) {
            this.themeId = str;
        }

        public final void setTitle(Bundle bundle) {
            this.title = bundle;
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
            h.e(dest, "dest");
            dest.writeString(this.animSHA256);
            dest.writeInt(this.animType);
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
            dest.writeString(this.id);
            dest.writeInt(this.materialType);
            dest.writeInt(this.isStatic);
            dest.writeString(this.previewAnim);
            dest.writeString(this.previewAnimSHA256);
            dest.writeInt(this.previewAnimSize);
            dest.writeString(this.previewDetailImgUrl);
            dest.writeString(this.previewListImgUrl);
            dest.writeBundle(this.summary);
            dest.writeString(this.themeId);
            dest.writeBundle(this.title);
            dest.writeString(this.toneSHA256);
            dest.writeInt(this.toneSize);
            dest.writeString(this.toneUploadTime);
            dest.writeString(this.toneUrl);
            dest.writeString(this.tonePreviewSHA256);
            dest.writeInt(this.tonePreviewSize);
            dest.writeString(this.tonePreviewUrl);
            dest.writeInt(this.publishStatus);
            dest.writeInt(this.priority);
            List<Tag> list = this.tags;
            if (list == null) {
                dest.writeInt(0);
            } else {
                Iterator itG = A6.e.g(dest, 1, list);
                while (itG.hasNext()) {
                    ((Tag) itG.next()).writeToParcel(dest, flags);
                }
            }
            dest.writeString(this.cardZipUrl);
            dest.writeString(this.cardZipSHA256);
            dest.writeInt(this.downloadCount);
            dest.writeInt(this.activity ? 1 : 0);
        }

        public PersonalDressData(String str, int i10, int i11, String str2, String str3, String str4, int i12, String str5, String str6, String str7, String str8, int i13, String str9, int i14, int i15, String str10, String str11, int i16, String str12, String str13, Bundle bundle, String str14, Bundle bundle2, String str15, int i17, String str16, String str17, String str18, int i18, String str19, int i19, int i20, List<Tag> list, String str20, String str21, int i21, boolean z2) {
            this.animSHA256 = str;
            this.animType = i10;
            this.animSize = i11;
            this.animUploadTime = str2;
            this.animUrl = str3;
            this.darkAnimSHA256 = str4;
            this.darkAnimSize = i12;
            this.darkAnimUploadTime = str5;
            this.darkAnimUrl = str6;
            this.darkPreviewAnim = str7;
            this.darkPreviewAnimSHA256 = str8;
            this.darkPreviewAnimSize = i13;
            this.id = str9;
            this.materialType = i14;
            this.isStatic = i15;
            this.previewAnim = str10;
            this.previewAnimSHA256 = str11;
            this.previewAnimSize = i16;
            this.previewDetailImgUrl = str12;
            this.previewListImgUrl = str13;
            this.summary = bundle;
            this.themeId = str14;
            this.title = bundle2;
            this.toneSHA256 = str15;
            this.toneSize = i17;
            this.toneUploadTime = str16;
            this.toneUrl = str17;
            this.tonePreviewSHA256 = str18;
            this.tonePreviewSize = i18;
            this.tonePreviewUrl = str19;
            this.publishStatus = i19;
            this.priority = i20;
            this.tags = list;
            this.cardZipUrl = str20;
            this.cardZipSHA256 = str21;
            this.downloadCount = i21;
            this.activity = z2;
        }

        public /* synthetic */ PersonalDressData(String str, int i10, int i11, String str2, String str3, String str4, int i12, String str5, String str6, String str7, String str8, int i13, String str9, int i14, int i15, String str10, String str11, int i16, String str12, String str13, Bundle bundle, String str14, Bundle bundle2, String str15, int i17, String str16, String str17, String str18, int i18, String str19, int i19, int i20, List list, String str20, String str21, int i21, boolean z2, int i22, int i23, kotlin.jvm.internal.d dVar) {
            this((i22 & 1) != 0 ? null : str, (i22 & 2) != 0 ? 0 : i10, (i22 & 4) != 0 ? 0 : i11, (i22 & 8) != 0 ? null : str2, (i22 & 16) != 0 ? null : str3, (i22 & 32) != 0 ? null : str4, (i22 & 64) != 0 ? 0 : i12, (i22 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : str5, (i22 & 256) != 0 ? null : str6, (i22 & 512) != 0 ? null : str7, (i22 & 1024) != 0 ? null : str8, (i22 & 2048) != 0 ? 0 : i13, (i22 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? null : str9, (i22 & 8192) != 0 ? 0 : i14, (i22 & 16384) != 0 ? 0 : i15, (i22 & 32768) != 0 ? null : str10, (i22 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? null : str11, (i22 & 131072) != 0 ? 0 : i16, (i22 & 262144) != 0 ? null : str12, (i22 & 524288) != 0 ? null : str13, (i22 & 1048576) != 0 ? null : bundle, (i22 & 2097152) != 0 ? null : str14, (i22 & 4194304) != 0 ? null : bundle2, (i22 & 8388608) != 0 ? null : str15, (i22 & 16777216) != 0 ? 0 : i17, (i22 & 33554432) != 0 ? null : str16, (i22 & 67108864) != 0 ? null : str17, (i22 & 134217728) != 0 ? null : str18, (i22 & 268435456) != 0 ? 0 : i18, (i22 & 536870912) != 0 ? null : str19, (i22 & 1073741824) != 0 ? 0 : i19, (i22 & Integer.MIN_VALUE) != 0 ? 0 : i20, (i23 & 1) != 0 ? null : list, (i23 & 2) != 0 ? null : str20, (i23 & 4) != 0 ? null : str21, (i23 & 8) != 0 ? 0 : i21, (i23 & 16) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: PersonalDressDTO.kt */
    @Parcelize
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/oplus/melody/model/repository/personaldress/PersonalDressDTO$Tag;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "icon", "", "id", "", "tagName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getTagName", "setTagName", "component1", "component2", "component3", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Tag extends com.oplus.melody.common.data.a implements Parcelable {
        public static final Parcelable.Creator<Tag> CREATOR = new a();
        private String icon;
        private int id;
        private String tagName;

        /* JADX INFO: compiled from: PersonalDressDTO.kt */
        public static final class a implements Parcelable.Creator<Tag> {
            @Override // android.os.Parcelable.Creator
            public final Tag createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new Tag(parcel.readString(), parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Tag[] newArray(int i10) {
                return new Tag[i10];
            }
        }

        public Tag() {
            this(null, 0, null, 7, null);
        }

        public static /* synthetic */ Tag copy$default(Tag tag, String str, int i10, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = tag.icon;
            }
            if ((i11 & 2) != 0) {
                i10 = tag.id;
            }
            if ((i11 & 4) != 0) {
                str2 = tag.tagName;
            }
            return tag.copy(str, i10, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTagName() {
            return this.tagName;
        }

        public final Tag copy(String icon, int id, String tagName) {
            return new Tag(icon, id, tagName);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTagName() {
            return this.tagName;
        }

        public final void setIcon(String str) {
            this.icon = str;
        }

        public final void setId(int i10) {
            this.id = i10;
        }

        public final void setTagName(String str) {
            this.tagName = str;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            h.e(dest, "dest");
            dest.writeString(this.icon);
            dest.writeInt(this.id);
            dest.writeString(this.tagName);
        }

        public Tag(String str, int i10, String str2) {
            this.icon = str;
            this.id = i10;
            this.tagName = str2;
        }

        public /* synthetic */ Tag(String str, int i10, String str2, int i11, kotlin.jvm.internal.d dVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : str2);
        }
    }

    /* JADX INFO: compiled from: PersonalDressDTO.kt */
    public static final class a implements Parcelable.Creator<PersonalDressDTO> {
        @Override // android.os.Parcelable.Creator
        public final PersonalDressDTO createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            h.e(parcel, "parcel");
            String string = parcel.readString();
            int i10 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i11 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i11);
                int iB = 0;
                while (iB != i11) {
                    iB = A6.b.b(PersonalDressData.CREATOR, parcel, arrayList2, iB, 1);
                }
                arrayList = arrayList2;
            }
            return new PersonalDressDTO(string, i10, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final PersonalDressDTO[] newArray(int i10) {
            return new PersonalDressDTO[i10];
        }
    }

    public PersonalDressDTO() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonalDressDTO copy$default(PersonalDressDTO personalDressDTO, String str, int i10, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = personalDressDTO.productId;
        }
        if ((i11 & 2) != 0) {
            i10 = personalDressDTO.color;
        }
        if ((i11 & 4) != 0) {
            list = personalDressDTO.personalDressData;
        }
        return personalDressDTO.copy(str, i10, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final List<PersonalDressData> component3() {
        return this.personalDressData;
    }

    public final PersonalDressDTO copy(String productId, int color, List<PersonalDressData> personalDressData) {
        return new PersonalDressDTO(productId, color, personalDressData);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getColor() {
        return this.color;
    }

    public final List<PersonalDressData> getPersonalDressData() {
        return this.personalDressData;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final void setColor(int i10) {
        this.color = i10;
    }

    public final void setPersonalDressData(List<PersonalDressData> list) {
        this.personalDressData = list;
    }

    public final void setProductId(String str) {
        this.productId = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        h.e(dest, "dest");
        dest.writeString(this.productId);
        dest.writeInt(this.color);
        List<PersonalDressData> list = this.personalDressData;
        if (list == null) {
            dest.writeInt(0);
            return;
        }
        Iterator itG = A6.e.g(dest, 1, list);
        while (itG.hasNext()) {
            ((PersonalDressData) itG.next()).writeToParcel(dest, flags);
        }
    }

    public PersonalDressDTO(String str, int i10, List<PersonalDressData> list) {
        this.productId = str;
        this.color = i10;
        this.personalDressData = list;
    }

    public /* synthetic */ PersonalDressDTO(String str, int i10, List list, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : list);
    }
}
