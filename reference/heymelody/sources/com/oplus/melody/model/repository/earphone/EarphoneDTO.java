package com.oplus.melody.model.repository.earphone;

import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.common.util.C0901g;
import com.oplus.melody.model.repository.earphone.EarphoneStatusDO;
import com.oplus.melody.ui.component.detail.headmotion.HeadMotionItem;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.parcelize.Parcelize;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: EarphoneDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b\u008a\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Þ\u00022\u00020\u00012\u00020\u0002:\u0002Þ\u0002BÁ\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0006\u0010%\u001a\u00020\b\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010'\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020\n\u0012\u0006\u0010)\u001a\u00020\n\u0012\u0006\u0010*\u001a\u00020\n\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\u0006\u0010.\u001a\u00020\n\u0012\u0006\u0010/\u001a\u00020\n\u0012\u0006\u00100\u001a\u000201\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00103\u001a\u000201\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00105\u001a\u00020\b\u0012\u0006\u00106\u001a\u00020\n\u0012\u0006\u00107\u001a\u00020\n\u0012\u0006\u00108\u001a\u00020\n\u0012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0:\u0012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010:\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\b\u0010?\u001a\u0004\u0018\u00010@\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\b\u0010B\u001a\u0004\u0018\u00010@\u0012\b\u0010C\u001a\u0004\u0018\u00010@\u0012\b\u0010D\u001a\u0004\u0018\u00010E\u0012\u0006\u0010F\u001a\u000201\u0012\u0006\u0010G\u001a\u00020\b\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0,\u0012\u0006\u0010I\u001a\u00020\n\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0,\u0012\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0,\u0012\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0,\u0012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020O0,\u0012\u0006\u0010P\u001a\u00020\n\u0012\u0006\u0010Q\u001a\u00020\n\u0012\u0006\u0010R\u001a\u00020\n\u0012\u0006\u0010S\u001a\u00020\n\u0012\u0006\u0010T\u001a\u00020\n\u0012\u0006\u0010U\u001a\u00020\n\u0012\u0006\u0010V\u001a\u00020\n\u0012\u0006\u0010W\u001a\u00020\n\u0012\u0006\u0010X\u001a\u00020\n\u0012\u0006\u0010Y\u001a\u00020\n\u0012\u0006\u0010Z\u001a\u00020\n\u0012\u0006\u0010[\u001a\u00020\n\u0012\u0006\u0010\\\u001a\u00020\n\u0012\u0006\u0010]\u001a\u00020\n\u0012\u0006\u0010^\u001a\u00020\n\u0012\u0006\u0010_\u001a\u00020\n\u0012\u0006\u0010`\u001a\u00020\n\u0012\u0006\u0010a\u001a\u00020\n\u0012\u0006\u0010b\u001a\u00020\n\u0012\u0006\u0010c\u001a\u00020\b\u0012\u0006\u0010d\u001a\u00020\b\u0012\u0006\u0010e\u001a\u00020\b\u0012\b\u0010f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010g\u001a\u00020\n\u0012\u0006\u0010h\u001a\u00020\b\u0012\u0006\u0010i\u001a\u00020\n\u0012\u0006\u0010j\u001a\u00020\n\u0012\u0006\u0010k\u001a\u00020\b\u0012\u0006\u0010l\u001a\u00020\b\u0012\u0006\u0010m\u001a\u00020\n\u0012\u0006\u0010n\u001a\u00020\n\u0012\u0006\u0010o\u001a\u00020\n\u0012\u0006\u0010p\u001a\u00020\n\u0012\u0006\u0010q\u001a\u00020\n\u0012\u0006\u0010r\u001a\u00020\n\u0012\u0006\u0010s\u001a\u00020\n\u0012\u0006\u0010t\u001a\u00020\n\u0012\u0006\u0010u\u001a\u00020\n\u0012\u0006\u0010v\u001a\u00020\n\u0012\u0006\u0010w\u001a\u00020\n\u0012\b\u0010x\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010y\u001a\u00020\n\u0012\u0006\u0010z\u001a\u00020\n¢\u0006\u0004\b{\u0010|J\u0011\u0010ê\u0001\u001a\u00020\u00002\b\u0010f\u001a\u0004\u0018\u00010\u0004J\n\u0010ë\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010ì\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010í\u0001\u001a\u00020\u0004HÆ\u0003J\n\u0010î\u0001\u001a\u00020\bHÆ\u0003J\n\u0010ï\u0001\u001a\u00020\nHÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010ò\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ó\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ô\u0001\u001a\u00020\nHÆ\u0003J\n\u0010õ\u0001\u001a\u00020\bHÆ\u0003J\n\u0010ö\u0001\u001a\u00020\nHÆ\u0003J\n\u0010÷\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ø\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ù\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ú\u0001\u001a\u00020\nHÆ\u0003J\n\u0010û\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ü\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ý\u0001\u001a\u00020\nHÆ\u0003J\n\u0010þ\u0001\u001a\u00020\nHÆ\u0003J\n\u0010ÿ\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0080\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0081\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0082\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0083\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0084\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0085\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0086\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0087\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0088\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0089\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u008a\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u008b\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u008c\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u008d\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u008e\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u008f\u0002\u001a\u00020\nHÆ\u0003J\u0010\u0010\u0090\u0002\u001a\b\u0012\u0004\u0012\u00020-0,HÆ\u0003J\n\u0010\u0091\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0092\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0093\u0002\u001a\u000201HÆ\u0003J\n\u0010\u0094\u0002\u001a\u000201HÆ\u0003J\n\u0010\u0095\u0002\u001a\u000201HÆ\u0003J\n\u0010\u0096\u0002\u001a\u000201HÆ\u0003J\n\u0010\u0097\u0002\u001a\u00020\bHÆ\u0003J\n\u0010\u0098\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u0099\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u009a\u0002\u001a\u00020\nHÆ\u0003J\u0016\u0010\u009b\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0:HÆ\u0003J\u0016\u0010\u009c\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010:HÆ\u0003J\u0010\u0010\u009d\u0002\u001a\b\u0012\u0004\u0012\u00020=0,HÆ\u0003J\u0010\u0010\u009e\u0002\u001a\b\u0012\u0004\u0012\u00020-0,HÆ\u0003J\f\u0010\u009f\u0002\u001a\u0004\u0018\u00010@HÆ\u0003J\f\u0010 \u0002\u001a\u0004\u0018\u00010@HÆ\u0003J\f\u0010¡\u0002\u001a\u0004\u0018\u00010@HÆ\u0003J\f\u0010¢\u0002\u001a\u0004\u0018\u00010@HÆ\u0003J\f\u0010£\u0002\u001a\u0004\u0018\u00010EHÆ\u0003J\n\u0010¤\u0002\u001a\u000201HÆ\u0003J\n\u0010¥\u0002\u001a\u00020\bHÆ\u0003J\u0010\u0010¦\u0002\u001a\b\u0012\u0004\u0012\u00020\n0,HÆ\u0003J\n\u0010§\u0002\u001a\u00020\nHÆ\u0003J\u0010\u0010¨\u0002\u001a\b\u0012\u0004\u0012\u00020\n0,HÆ\u0003J\u0010\u0010©\u0002\u001a\b\u0012\u0004\u0012\u00020L0,HÆ\u0003J\u0010\u0010ª\u0002\u001a\b\u0012\u0004\u0012\u00020\n0,HÆ\u0003J\u0010\u0010«\u0002\u001a\b\u0012\u0004\u0012\u00020O0,HÆ\u0003J\n\u0010¬\u0002\u001a\u00020\nHÆ\u0003J\n\u0010\u00ad\u0002\u001a\u00020\nHÆ\u0003J\n\u0010®\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¯\u0002\u001a\u00020\nHÆ\u0003J\n\u0010°\u0002\u001a\u00020\nHÆ\u0003J\n\u0010±\u0002\u001a\u00020\nHÆ\u0003J\n\u0010²\u0002\u001a\u00020\nHÆ\u0003J\n\u0010³\u0002\u001a\u00020\nHÆ\u0003J\n\u0010´\u0002\u001a\u00020\nHÆ\u0003J\n\u0010µ\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¶\u0002\u001a\u00020\nHÆ\u0003J\n\u0010·\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¸\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¹\u0002\u001a\u00020\nHÆ\u0003J\n\u0010º\u0002\u001a\u00020\nHÆ\u0003J\n\u0010»\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¼\u0002\u001a\u00020\nHÆ\u0003J\n\u0010½\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¾\u0002\u001a\u00020\nHÆ\u0003J\n\u0010¿\u0002\u001a\u00020\bHÆ\u0003J\n\u0010À\u0002\u001a\u00020\bHÆ\u0003J\n\u0010Á\u0002\u001a\u00020\bHÆ\u0003J\f\u0010Â\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010Ã\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ä\u0002\u001a\u00020\bHÆ\u0003J\n\u0010Å\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Æ\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ç\u0002\u001a\u00020\bHÆ\u0003J\n\u0010È\u0002\u001a\u00020\bHÆ\u0003J\n\u0010É\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ê\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ë\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ì\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Í\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Î\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ï\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ð\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ñ\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ò\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ó\u0002\u001a\u00020\nHÆ\u0003J\f\u0010Ô\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010Õ\u0002\u001a\u00020\nHÆ\u0003J\n\u0010Ö\u0002\u001a\u00020\nHÆ\u0003J\u009c\t\u0010×\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\n2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\n2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u0010.\u001a\u00020\n2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u0002012\b\b\u0002\u00105\u001a\u00020\b2\b\b\u0002\u00106\u001a\u00020\n2\b\b\u0002\u00107\u001a\u00020\n2\b\b\u0002\u00108\u001a\u00020\n2\u0014\b\u0002\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0:2\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010:2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,2\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020-0,2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010F\u001a\u0002012\b\b\u0002\u0010G\u001a\u00020\b2\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0,2\b\b\u0002\u0010I\u001a\u00020\n2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0,2\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020L0,2\u000e\b\u0002\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0,2\u000e\b\u0002\u0010N\u001a\b\u0012\u0004\u0012\u00020O0,2\b\b\u0002\u0010P\u001a\u00020\n2\b\b\u0002\u0010Q\u001a\u00020\n2\b\b\u0002\u0010R\u001a\u00020\n2\b\b\u0002\u0010S\u001a\u00020\n2\b\b\u0002\u0010T\u001a\u00020\n2\b\b\u0002\u0010U\u001a\u00020\n2\b\b\u0002\u0010V\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n2\b\b\u0002\u0010X\u001a\u00020\n2\b\b\u0002\u0010Y\u001a\u00020\n2\b\b\u0002\u0010Z\u001a\u00020\n2\b\b\u0002\u0010[\u001a\u00020\n2\b\b\u0002\u0010\\\u001a\u00020\n2\b\b\u0002\u0010]\u001a\u00020\n2\b\b\u0002\u0010^\u001a\u00020\n2\b\b\u0002\u0010_\u001a\u00020\n2\b\b\u0002\u0010`\u001a\u00020\n2\b\b\u0002\u0010a\u001a\u00020\n2\b\b\u0002\u0010b\u001a\u00020\n2\b\b\u0002\u0010c\u001a\u00020\b2\b\b\u0002\u0010d\u001a\u00020\b2\b\b\u0002\u0010e\u001a\u00020\b2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010g\u001a\u00020\n2\b\b\u0002\u0010h\u001a\u00020\b2\b\b\u0002\u0010i\u001a\u00020\n2\b\b\u0002\u0010j\u001a\u00020\n2\b\b\u0002\u0010k\u001a\u00020\b2\b\b\u0002\u0010l\u001a\u00020\b2\b\b\u0002\u0010m\u001a\u00020\n2\b\b\u0002\u0010n\u001a\u00020\n2\b\b\u0002\u0010o\u001a\u00020\n2\b\b\u0002\u0010p\u001a\u00020\n2\b\b\u0002\u0010q\u001a\u00020\n2\b\b\u0002\u0010r\u001a\u00020\n2\b\b\u0002\u0010s\u001a\u00020\n2\b\b\u0002\u0010t\u001a\u00020\n2\b\b\u0002\u0010u\u001a\u00020\n2\b\b\u0002\u0010v\u001a\u00020\n2\b\b\u0002\u0010w\u001a\u00020\n2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010y\u001a\u00020\n2\b\b\u0002\u0010z\u001a\u00020\nHÆ\u0001J\u0007\u0010Ø\u0002\u001a\u00020\nJ\u001b\u0010Ù\u0002\u001a\u00030Ú\u00022\b\u0010Û\u0002\u001a\u00030Ü\u00022\u0007\u0010Ý\u0002\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010~R\u0012\u0010\u0006\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010~R\u0012\u0010\u0007\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b\u0007\u0010\u0081\u0001R\u0013\u0010\t\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010~R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010~R\u0013\u0010\r\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0083\u0001R\u0013\u0010\u000e\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0083\u0001R\u0013\u0010\u000f\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0083\u0001R\u0013\u0010\u0010\u001a\u00020\b¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u0081\u0001R\u0013\u0010\u0011\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u0083\u0001R\u0013\u0010\u0012\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0083\u0001R\u0013\u0010\u0013\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u0083\u0001R\u0013\u0010\u0014\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u0083\u0001R\u0013\u0010\u0015\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0083\u0001R\u0013\u0010\u0016\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0083\u0001R\u0013\u0010\u0017\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0083\u0001R\u0013\u0010\u0018\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0083\u0001R\u0013\u0010\u0019\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0083\u0001R\u0013\u0010\u001a\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0083\u0001R\u0013\u0010\u001b\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0083\u0001R\u001e\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0083\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0013\u0010\u001d\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0083\u0001R\u0013\u0010\u001e\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u0083\u0001R\u0013\u0010\u001f\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u0083\u0001R\u0013\u0010 \u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u0083\u0001R\u0013\u0010!\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u009c\u0001\u0010\u0083\u0001R\u0013\u0010\"\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0083\u0001R\u0012\u0010#\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b#\u0010\u0081\u0001R\u0012\u0010$\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b$\u0010\u0081\u0001R\u0012\u0010%\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b%\u0010\u0081\u0001R\u0013\u0010&\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u0083\u0001R\u0013\u0010'\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u0083\u0001R\u0013\u0010(\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010\u0083\u0001R\u0013\u0010)\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010\u0083\u0001R\u0013\u0010*\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b¢\u0001\u0010\u0083\u0001R\u0019\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001R\u0013\u0010.\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010\u0083\u0001R\u0013\u0010/\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b¦\u0001\u0010\u0083\u0001R\u0013\u00100\u001a\u000201¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R\u0013\u00102\u001a\u000201¢\u0006\n\n\u0000\u001a\u0006\b©\u0001\u0010¨\u0001R\u0013\u00103\u001a\u000201¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010¨\u0001R\u0013\u00104\u001a\u000201¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010¨\u0001R\u0012\u00105\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\b5\u0010\u0081\u0001R\u0013\u00106\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b¬\u0001\u0010\u0083\u0001R\u0013\u00107\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b\u00ad\u0001\u0010\u0083\u0001R\u0013\u00108\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b®\u0001\u0010\u0083\u0001R\u001f\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0:¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u001f\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010:¢\u0006\n\n\u0000\u001a\u0006\b±\u0001\u0010°\u0001R\u0019\u0010<\u001a\b\u0012\u0004\u0012\u00020=0,¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010¤\u0001R\u0019\u0010>\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010¤\u0001R\u0015\u0010?\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u0015\u0010A\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010µ\u0001R\u0015\u0010B\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0000\u001a\u0006\b·\u0001\u0010µ\u0001R\u0015\u0010C\u001a\u0004\u0018\u00010@¢\u0006\n\n\u0000\u001a\u0006\b¸\u0001\u0010µ\u0001R\u0015\u0010D\u001a\u0004\u0018\u00010E¢\u0006\n\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001R\u0013\u0010F\u001a\u000201¢\u0006\n\n\u0000\u001a\u0006\b»\u0001\u0010¨\u0001R\u0012\u0010G\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\bG\u0010\u0081\u0001R\u0019\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0,¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010¤\u0001R\u0013\u0010I\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010\u0083\u0001R\u0019\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0,¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¤\u0001R\u0019\u0010K\u001a\b\u0012\u0004\u0012\u00020L0,¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010¤\u0001R\u0019\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0,¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010¤\u0001R\u0019\u0010N\u001a\b\u0012\u0004\u0012\u00020O0,¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010¤\u0001R\u0013\u0010P\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÂ\u0001\u0010\u0083\u0001R\u0013\u0010Q\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÃ\u0001\u0010\u0083\u0001R\u0013\u0010R\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0083\u0001R\u0013\u0010S\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010\u0083\u0001R\u0013\u0010T\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÆ\u0001\u0010\u0083\u0001R\u0013\u0010U\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÇ\u0001\u0010\u0083\u0001R\u0013\u0010V\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010\u0083\u0001R\u0013\u0010W\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÉ\u0001\u0010\u0083\u0001R\u0013\u0010X\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0083\u0001R\u0013\u0010Y\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bË\u0001\u0010\u0083\u0001R\u0013\u0010Z\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÌ\u0001\u0010\u0083\u0001R\u0013\u0010[\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÍ\u0001\u0010\u0083\u0001R\u0013\u0010\\\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010\u0083\u0001R\u0013\u0010]\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010\u0083\u0001R\u0013\u0010^\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010\u0083\u0001R\u0013\u0010_\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÑ\u0001\u0010\u0083\u0001R\u0013\u0010`\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÒ\u0001\u0010\u0083\u0001R\u0013\u0010a\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÓ\u0001\u0010\u0083\u0001R\u0013\u0010b\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÔ\u0001\u0010\u0083\u0001R\u0013\u0010c\u001a\u00020\b¢\u0006\n\n\u0000\u001a\u0006\bÕ\u0001\u0010\u0081\u0001R\u0013\u0010d\u001a\u00020\b¢\u0006\n\n\u0000\u001a\u0006\bÖ\u0001\u0010\u0081\u0001R\u0013\u0010e\u001a\u00020\b¢\u0006\n\n\u0000\u001a\u0006\b×\u0001\u0010\u0081\u0001R\u0014\u0010f\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bØ\u0001\u0010~R\u0013\u0010g\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÙ\u0001\u0010\u0083\u0001R\u0012\u0010h\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\bh\u0010\u0081\u0001R\u0013\u0010i\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÚ\u0001\u0010\u0083\u0001R\u0013\u0010j\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÛ\u0001\u0010\u0083\u0001R\u0012\u0010k\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\bk\u0010\u0081\u0001R\u0012\u0010l\u001a\u00020\b¢\u0006\t\n\u0000\u001a\u0005\bl\u0010\u0081\u0001R\u0013\u0010m\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÜ\u0001\u0010\u0083\u0001R\u0013\u0010n\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÝ\u0001\u0010\u0083\u0001R\u0013\u0010o\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bÞ\u0001\u0010\u0083\u0001R\u0013\u0010p\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bß\u0001\u0010\u0083\u0001R\u0013\u0010q\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bà\u0001\u0010\u0083\u0001R\u0013\u0010r\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010\u0083\u0001R\u0013\u0010s\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bâ\u0001\u0010\u0083\u0001R\u0013\u0010t\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bã\u0001\u0010\u0083\u0001R\u0013\u0010u\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bä\u0001\u0010\u0083\u0001R\u0013\u0010v\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bå\u0001\u0010\u0083\u0001R\u0013\u0010w\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bæ\u0001\u0010\u0083\u0001R\u0014\u0010x\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bç\u0001\u0010~R\u0013\u0010y\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bè\u0001\u0010\u0083\u0001R\u0013\u0010z\u001a\u00020\n¢\u0006\n\n\u0000\u001a\u0006\bé\u0001\u0010\u0083\u0001¨\u0006ß\u0002"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/EarphoneDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "Landroid/os/Parcelable;", "macAddress", "", "productId", "productType", "isSupportSpp", "", "colorId", "", "name", "popTheme", "wearDetectionStatus", "hearingEnhanceUsageStatus", "multiConnectSwitchStatus", "supportMultiDeviceConnect", "zenModeSwitchStatus", "clickToTakePicStatus", "headsetSoundRecordStatus", "highToneQualityStatus", "hearingOptimizeStatus", "autoVolumeStatus", "longPowerModeStatus", "freeDialogStatus", "freeDialogRecoveryTime", "voiceAssistStatus", "voiceCommandStatus", "voiceIncomingCallControlStatus", "noiseReductionModeIndex", "intelligentNoiseReductionModeIndex", "eqType", "boxBattery", "leftBattery", "rightBattery", "isBoxCharging", "isLeftCharging", "isRightCharging", "headsetBoxBattery", "headsetLeftBattery", "headsetRightBattery", "headsetConnectionState", "a2dpConnectionState", "headsetVersionList", "", "Lcom/oplus/melody/model/repository/earphone/DeviceVersionDTO;", "connectionState", "aclConnectionState", "aclConnectionTime", "", "a2dpConnectionTime", "headsetConnectionTime", "sppConnectionTime", "isActive", "pairingState", "autoOTASwitch", "channelSwitch", "leAudioConnectionStateMap", "", "leAudioConnectionTimeMap", "keyFunctionInfoList", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "deviceVersionList", "switchNoiseReductionInfo", "Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;", "switchLeftEarNoiseReductionInfo", "switchRightEarNoiseReductionInfo", "supportNoiseReductionInfo", "earStatus", "Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;", "earStatusReceivedMillis", "isCapabilityReady", "earCapability", "codecType", "codecList", "spineRangeDetection", "", "spineCalibrationResult", "earTones", "Lcom/oplus/melody/model/repository/earphone/EarToneDTO;", "vocalEnhanceStatus", "personalNoiseStatus", "safeRemindStatus", "gameModeStatus", "bassEngineStatus", "spatialSoundStatus", "saveLogStatus", "gameEqualizerStatus", "spineLiveMonitorStatus", "spineCervicalStatus", "spineExerciseRemindStatus", "spineCalibratedStatus", "headsetSpatialType", "phoneSpatialType", "aiSummaryType", "aiTranslationAppStatus", "volumeValueInfo", "tapLevelSettingValue", "tapLevelDefaultValue", "supportCustomEq", "supportSmartBluetooth", "supportBindAccount", "accountKey", "gameSoundStatus", "isVersionListReceived", "sppOverGattConnectionState", "gameModeMainStatus", "isDeviceBonded", "isInitCmdCompleted", "adaptiveVolume", "adaptiveEar", "speechPerception", "micControl", "longPressVolume", "multiConversationSwitch", "swiftPair", HeadMotionItem.ITEM_NAME, "headMotionType", "sleepDetection", "reconnectPopupSwitch", "boxSn", "oneEarNoiseReduceMode", "bothEarNoiseReduceMode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;IIIZIIIIIIIIIIIIIIIIIIZZZIIIIILjava/util/List;IIJJJJZIIILjava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;JZLjava/util/List;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIIIIIIIIIIIIIIIIZZZLjava/lang/String;IZIIZZIIIIIIIIIIILjava/lang/String;II)V", "getMacAddress", "()Ljava/lang/String;", "getProductId", "getProductType", "()Z", "getColorId", "()I", "getName", "getPopTheme", "getWearDetectionStatus", "getHearingEnhanceUsageStatus", "getMultiConnectSwitchStatus", "getSupportMultiDeviceConnect", "getZenModeSwitchStatus", "getClickToTakePicStatus", "getHeadsetSoundRecordStatus", "getHighToneQualityStatus", "getHearingOptimizeStatus", "getAutoVolumeStatus", "getLongPowerModeStatus", "getFreeDialogStatus", "getFreeDialogRecoveryTime", "getVoiceAssistStatus", "getVoiceCommandStatus", "getVoiceIncomingCallControlStatus", "setVoiceIncomingCallControlStatus", "(I)V", "getNoiseReductionModeIndex", "getIntelligentNoiseReductionModeIndex", "getEqType", "getBoxBattery", "getLeftBattery", "getRightBattery", "getHeadsetBoxBattery", "getHeadsetLeftBattery", "getHeadsetRightBattery", "getHeadsetConnectionState", "getA2dpConnectionState", "getHeadsetVersionList", "()Ljava/util/List;", "getConnectionState", "getAclConnectionState", "getAclConnectionTime", "()J", "getA2dpConnectionTime", "getHeadsetConnectionTime", "getSppConnectionTime", "getPairingState", "getAutoOTASwitch", "getChannelSwitch", "getLeAudioConnectionStateMap", "()Ljava/util/Map;", "getLeAudioConnectionTimeMap", "getKeyFunctionInfoList", "getDeviceVersionList", "getSwitchNoiseReductionInfo", "()Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;", "getSwitchLeftEarNoiseReductionInfo", "getSwitchRightEarNoiseReductionInfo", "getSupportNoiseReductionInfo", "getEarStatus", "()Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;", "getEarStatusReceivedMillis", "getEarCapability", "getCodecType", "getCodecList", "getSpineRangeDetection", "getSpineCalibrationResult", "getEarTones", "getVocalEnhanceStatus", "getPersonalNoiseStatus", "getSafeRemindStatus", "getGameModeStatus", "getBassEngineStatus", "getSpatialSoundStatus", "getSaveLogStatus", "getGameEqualizerStatus", "getSpineLiveMonitorStatus", "getSpineCervicalStatus", "getSpineExerciseRemindStatus", "getSpineCalibratedStatus", "getHeadsetSpatialType", "getPhoneSpatialType", "getAiSummaryType", "getAiTranslationAppStatus", "getVolumeValueInfo", "getTapLevelSettingValue", "getTapLevelDefaultValue", "getSupportCustomEq", "getSupportSmartBluetooth", "getSupportBindAccount", "getAccountKey", "getGameSoundStatus", "getSppOverGattConnectionState", "getGameModeMainStatus", "getAdaptiveVolume", "getAdaptiveEar", "getSpeechPerception", "getMicControl", "getLongPressVolume", "getMultiConversationSwitch", "getSwiftPair", "getHeadMotion", "getHeadMotionType", "getSleepDetection", "getReconnectPopupSwitch", "getBoxSn", "getOneEarNoiseReduceMode", "getBothEarNoiseReduceMode", "copyWithAccountKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "component97", "component98", "component99", "component100", "component101", "component102", "component103", "component104", "component105", "component106", "component107", "component108", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EarphoneDTO extends com.oplus.melody.common.data.a implements Parcelable {
    private final int a2dpConnectionState;
    private final long a2dpConnectionTime;
    private final String accountKey;
    private final int aclConnectionState;
    private final long aclConnectionTime;
    private final int adaptiveEar;
    private final int adaptiveVolume;
    private final int aiSummaryType;
    private final int aiTranslationAppStatus;
    private final int autoOTASwitch;
    private final int autoVolumeStatus;
    private final int bassEngineStatus;
    private final int bothEarNoiseReduceMode;
    private final int boxBattery;
    private final String boxSn;
    private final int channelSwitch;
    private final int clickToTakePicStatus;
    private final List<Integer> codecList;
    private final int codecType;
    private final int colorId;
    private final int connectionState;
    private final List<DeviceVersionDTO> deviceVersionList;
    private final List<Integer> earCapability;
    private final EarStatusDTO earStatus;
    private final long earStatusReceivedMillis;
    private final List<EarToneDTO> earTones;
    private final int eqType;
    private final int freeDialogRecoveryTime;
    private final int freeDialogStatus;
    private final int gameEqualizerStatus;
    private final int gameModeMainStatus;
    private final int gameModeStatus;
    private final int gameSoundStatus;
    private final int headMotion;
    private final int headMotionType;
    private final int headsetBoxBattery;
    private final int headsetConnectionState;
    private final long headsetConnectionTime;
    private final int headsetLeftBattery;
    private final int headsetRightBattery;
    private final int headsetSoundRecordStatus;
    private final int headsetSpatialType;
    private final List<DeviceVersionDTO> headsetVersionList;
    private final int hearingEnhanceUsageStatus;
    private final int hearingOptimizeStatus;
    private final int highToneQualityStatus;
    private final int intelligentNoiseReductionModeIndex;
    private final boolean isActive;
    private final boolean isBoxCharging;
    private final boolean isCapabilityReady;
    private final boolean isDeviceBonded;
    private final boolean isInitCmdCompleted;
    private final boolean isLeftCharging;
    private final boolean isRightCharging;
    private final boolean isSupportSpp;
    private final boolean isVersionListReceived;
    private final List<KeyFunctionInfoDTO> keyFunctionInfoList;
    private final Map<String, Integer> leAudioConnectionStateMap;
    private final Map<String, Long> leAudioConnectionTimeMap;
    private final int leftBattery;
    private final int longPowerModeStatus;
    private final int longPressVolume;
    private final String macAddress;
    private final int micControl;
    private final int multiConnectSwitchStatus;
    private final int multiConversationSwitch;
    private final String name;
    private final int noiseReductionModeIndex;
    private final int oneEarNoiseReduceMode;
    private final int pairingState;
    private final int personalNoiseStatus;
    private final int phoneSpatialType;
    private final String popTheme;
    private final String productId;
    private final String productType;
    private final int reconnectPopupSwitch;
    private final int rightBattery;
    private final int safeRemindStatus;
    private final int saveLogStatus;
    private final int sleepDetection;
    private final int spatialSoundStatus;
    private final int speechPerception;
    private final int spineCalibratedStatus;
    private final List<Integer> spineCalibrationResult;
    private final int spineCervicalStatus;
    private final int spineExerciseRemindStatus;
    private final int spineLiveMonitorStatus;
    private final List<Float> spineRangeDetection;
    private final long sppConnectionTime;
    private final int sppOverGattConnectionState;
    private final boolean supportBindAccount;
    private final boolean supportCustomEq;
    private final boolean supportMultiDeviceConnect;
    private final NoiseReductionInfoDTO supportNoiseReductionInfo;
    private final boolean supportSmartBluetooth;
    private final int swiftPair;
    private final NoiseReductionInfoDTO switchLeftEarNoiseReductionInfo;
    private final NoiseReductionInfoDTO switchNoiseReductionInfo;
    private final NoiseReductionInfoDTO switchRightEarNoiseReductionInfo;
    private final int tapLevelDefaultValue;
    private final int tapLevelSettingValue;
    private final int vocalEnhanceStatus;
    private final int voiceAssistStatus;
    private final int voiceCommandStatus;
    private int voiceIncomingCallControlStatus;
    private final int volumeValueInfo;
    private final int wearDetectionStatus;
    private final int zenModeSwitchStatus;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    public static final Parcelable.Creator<EarphoneDTO> CREATOR = new b();

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.EarphoneDTO$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: EarphoneDTO.kt */
    public static final class Companion {
    }

    /* JADX INFO: compiled from: EarphoneDTO.kt */
    public static final class b implements Parcelable.Creator<EarphoneDTO> {
        @Override // android.os.Parcelable.Creator
        public final EarphoneDTO createFromParcel(Parcel parcel) {
            boolean z2;
            kotlin.jvm.internal.h.e(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            boolean z4 = false;
            if (parcel.readInt() != 0) {
                z2 = false;
                z4 = true;
            } else {
                z2 = false;
            }
            int i10 = parcel.readInt();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            boolean z10 = parcel.readInt() != 0 ? true : z2;
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
            boolean z11 = parcel.readInt() != 0 ? true : z2;
            boolean z12 = parcel.readInt() != 0 ? true : z2;
            boolean z13 = parcel.readInt() != 0 ? true : z2;
            int i32 = parcel.readInt();
            int i33 = parcel.readInt();
            int i34 = parcel.readInt();
            int i35 = parcel.readInt();
            int i36 = parcel.readInt();
            int i37 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i37);
            int iB = 0;
            while (iB != i37) {
                iB = A6.b.b(DeviceVersionDTO.CREATOR, parcel, arrayList, iB, 1);
                i37 = i37;
                string2 = string2;
            }
            int i38 = parcel.readInt();
            int i39 = parcel.readInt();
            long j5 = parcel.readLong();
            long j9 = parcel.readLong();
            long j10 = parcel.readLong();
            long j11 = parcel.readLong();
            boolean z14 = parcel.readInt() != 0;
            int i40 = parcel.readInt();
            int i41 = parcel.readInt();
            int i42 = parcel.readInt();
            int i43 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i43);
            int i44 = 0;
            while (i44 != i43) {
                linkedHashMap.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
                i44++;
                i43 = i43;
            }
            int i45 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i45);
            int i46 = 0;
            while (i46 != i45) {
                linkedHashMap2.put(parcel.readString(), Long.valueOf(parcel.readLong()));
                i46++;
                i45 = i45;
            }
            int i47 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i47);
            int iB2 = 0;
            while (iB2 != i47) {
                iB2 = A6.b.b(KeyFunctionInfoDTO.CREATOR, parcel, arrayList2, iB2, 1);
                i47 = i47;
                string2 = string2;
            }
            String str = string2;
            int i48 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i48);
            int iB3 = 0;
            while (iB3 != i48) {
                iB3 = A6.b.b(DeviceVersionDTO.CREATOR, parcel, arrayList3, iB3, 1);
                i48 = i48;
                arrayList2 = arrayList2;
            }
            ArrayList arrayList4 = arrayList2;
            NoiseReductionInfoDTO noiseReductionInfoDTOCreateFromParcel = parcel.readInt() == 0 ? null : NoiseReductionInfoDTO.CREATOR.createFromParcel(parcel);
            NoiseReductionInfoDTO noiseReductionInfoDTOCreateFromParcel2 = parcel.readInt() == 0 ? null : NoiseReductionInfoDTO.CREATOR.createFromParcel(parcel);
            NoiseReductionInfoDTO noiseReductionInfoDTOCreateFromParcel3 = parcel.readInt() == 0 ? null : NoiseReductionInfoDTO.CREATOR.createFromParcel(parcel);
            NoiseReductionInfoDTO noiseReductionInfoDTOCreateFromParcel4 = parcel.readInt() == 0 ? null : NoiseReductionInfoDTO.CREATOR.createFromParcel(parcel);
            EarStatusDTO earStatusDTOCreateFromParcel = parcel.readInt() == 0 ? null : EarStatusDTO.CREATOR.createFromParcel(parcel);
            long j12 = parcel.readLong();
            boolean z15 = parcel.readInt() != 0;
            int i49 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(i49);
            int i50 = 0;
            while (i50 != i49) {
                arrayList5.add(Integer.valueOf(parcel.readInt()));
                i50++;
                i49 = i49;
            }
            int i51 = parcel.readInt();
            int i52 = parcel.readInt();
            ArrayList arrayList6 = new ArrayList(i52);
            for (int i53 = 0; i53 != i52; i53++) {
                arrayList6.add(Integer.valueOf(parcel.readInt()));
            }
            int i54 = parcel.readInt();
            ArrayList arrayList7 = new ArrayList(i54);
            for (int i55 = 0; i55 != i54; i55++) {
                arrayList7.add(Float.valueOf(parcel.readFloat()));
            }
            int i56 = parcel.readInt();
            ArrayList arrayList8 = new ArrayList(i56);
            int i57 = 0;
            while (i57 != i56) {
                arrayList8.add(Integer.valueOf(parcel.readInt()));
                i57++;
                i56 = i56;
            }
            int i58 = parcel.readInt();
            ArrayList arrayList9 = new ArrayList(i58);
            int iB4 = 0;
            while (iB4 != i58) {
                iB4 = A6.b.b(EarToneDTO.CREATOR, parcel, arrayList9, iB4, 1);
                i58 = i58;
                noiseReductionInfoDTOCreateFromParcel3 = noiseReductionInfoDTOCreateFromParcel3;
            }
            return new EarphoneDTO(string, str, string3, z4, i10, string4, string5, i11, i12, i13, z10, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, z11, z12, z13, i32, i33, i34, i35, i36, arrayList, i38, i39, j5, j9, j10, j11, z14, i40, i41, i42, linkedHashMap, linkedHashMap2, arrayList4, arrayList3, noiseReductionInfoDTOCreateFromParcel, noiseReductionInfoDTOCreateFromParcel2, noiseReductionInfoDTOCreateFromParcel3, noiseReductionInfoDTOCreateFromParcel4, earStatusDTOCreateFromParcel, j12, z15, arrayList5, i51, arrayList6, arrayList7, arrayList8, arrayList9, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EarphoneDTO[] newArray(int i10) {
            return new EarphoneDTO[i10];
        }
    }

    public EarphoneDTO(String macAddress, String productId, String productType, boolean z2, int i10, String str, String str2, int i11, int i12, int i13, boolean z4, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, boolean z10, boolean z11, boolean z12, int i32, int i33, int i34, int i35, int i36, List<DeviceVersionDTO> headsetVersionList, int i37, int i38, long j5, long j9, long j10, long j11, boolean z13, int i39, int i40, int i41, Map<String, Integer> leAudioConnectionStateMap, Map<String, Long> leAudioConnectionTimeMap, List<KeyFunctionInfoDTO> keyFunctionInfoList, List<DeviceVersionDTO> deviceVersionList, NoiseReductionInfoDTO noiseReductionInfoDTO, NoiseReductionInfoDTO noiseReductionInfoDTO2, NoiseReductionInfoDTO noiseReductionInfoDTO3, NoiseReductionInfoDTO noiseReductionInfoDTO4, EarStatusDTO earStatusDTO, long j12, boolean z14, List<Integer> earCapability, int i42, List<Integer> codecList, List<Float> spineRangeDetection, List<Integer> spineCalibrationResult, List<EarToneDTO> earTones, int i43, int i44, int i45, int i46, int i47, int i48, int i49, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, boolean z15, boolean z16, boolean z17, String str3, int i62, boolean z18, int i63, int i64, boolean z19, boolean z20, int i65, int i66, int i67, int i68, int i69, int i70, int i71, int i72, int i73, int i74, int i75, String str4, int i76, int i77) {
        kotlin.jvm.internal.h.e(macAddress, "macAddress");
        kotlin.jvm.internal.h.e(productId, "productId");
        kotlin.jvm.internal.h.e(productType, "productType");
        kotlin.jvm.internal.h.e(headsetVersionList, "headsetVersionList");
        kotlin.jvm.internal.h.e(leAudioConnectionStateMap, "leAudioConnectionStateMap");
        kotlin.jvm.internal.h.e(leAudioConnectionTimeMap, "leAudioConnectionTimeMap");
        kotlin.jvm.internal.h.e(keyFunctionInfoList, "keyFunctionInfoList");
        kotlin.jvm.internal.h.e(deviceVersionList, "deviceVersionList");
        kotlin.jvm.internal.h.e(earCapability, "earCapability");
        kotlin.jvm.internal.h.e(codecList, "codecList");
        kotlin.jvm.internal.h.e(spineRangeDetection, "spineRangeDetection");
        kotlin.jvm.internal.h.e(spineCalibrationResult, "spineCalibrationResult");
        kotlin.jvm.internal.h.e(earTones, "earTones");
        this.macAddress = macAddress;
        this.productId = productId;
        this.productType = productType;
        this.isSupportSpp = z2;
        this.colorId = i10;
        this.name = str;
        this.popTheme = str2;
        this.wearDetectionStatus = i11;
        this.hearingEnhanceUsageStatus = i12;
        this.multiConnectSwitchStatus = i13;
        this.supportMultiDeviceConnect = z4;
        this.zenModeSwitchStatus = i14;
        this.clickToTakePicStatus = i15;
        this.headsetSoundRecordStatus = i16;
        this.highToneQualityStatus = i17;
        this.hearingOptimizeStatus = i18;
        this.autoVolumeStatus = i19;
        this.longPowerModeStatus = i20;
        this.freeDialogStatus = i21;
        this.freeDialogRecoveryTime = i22;
        this.voiceAssistStatus = i23;
        this.voiceCommandStatus = i24;
        this.voiceIncomingCallControlStatus = i25;
        this.noiseReductionModeIndex = i26;
        this.intelligentNoiseReductionModeIndex = i27;
        this.eqType = i28;
        this.boxBattery = i29;
        this.leftBattery = i30;
        this.rightBattery = i31;
        this.isBoxCharging = z10;
        this.isLeftCharging = z11;
        this.isRightCharging = z12;
        this.headsetBoxBattery = i32;
        this.headsetLeftBattery = i33;
        this.headsetRightBattery = i34;
        this.headsetConnectionState = i35;
        this.a2dpConnectionState = i36;
        this.headsetVersionList = headsetVersionList;
        this.connectionState = i37;
        this.aclConnectionState = i38;
        this.aclConnectionTime = j5;
        this.a2dpConnectionTime = j9;
        this.headsetConnectionTime = j10;
        this.sppConnectionTime = j11;
        this.isActive = z13;
        this.pairingState = i39;
        this.autoOTASwitch = i40;
        this.channelSwitch = i41;
        this.leAudioConnectionStateMap = leAudioConnectionStateMap;
        this.leAudioConnectionTimeMap = leAudioConnectionTimeMap;
        this.keyFunctionInfoList = keyFunctionInfoList;
        this.deviceVersionList = deviceVersionList;
        this.switchNoiseReductionInfo = noiseReductionInfoDTO;
        this.switchLeftEarNoiseReductionInfo = noiseReductionInfoDTO2;
        this.switchRightEarNoiseReductionInfo = noiseReductionInfoDTO3;
        this.supportNoiseReductionInfo = noiseReductionInfoDTO4;
        this.earStatus = earStatusDTO;
        this.earStatusReceivedMillis = j12;
        this.isCapabilityReady = z14;
        this.earCapability = earCapability;
        this.codecType = i42;
        this.codecList = codecList;
        this.spineRangeDetection = spineRangeDetection;
        this.spineCalibrationResult = spineCalibrationResult;
        this.earTones = earTones;
        this.vocalEnhanceStatus = i43;
        this.personalNoiseStatus = i44;
        this.safeRemindStatus = i45;
        this.gameModeStatus = i46;
        this.bassEngineStatus = i47;
        this.spatialSoundStatus = i48;
        this.saveLogStatus = i49;
        this.gameEqualizerStatus = i50;
        this.spineLiveMonitorStatus = i51;
        this.spineCervicalStatus = i52;
        this.spineExerciseRemindStatus = i53;
        this.spineCalibratedStatus = i54;
        this.headsetSpatialType = i55;
        this.phoneSpatialType = i56;
        this.aiSummaryType = i57;
        this.aiTranslationAppStatus = i58;
        this.volumeValueInfo = i59;
        this.tapLevelSettingValue = i60;
        this.tapLevelDefaultValue = i61;
        this.supportCustomEq = z15;
        this.supportSmartBluetooth = z16;
        this.supportBindAccount = z17;
        this.accountKey = str3;
        this.gameSoundStatus = i62;
        this.isVersionListReceived = z18;
        this.sppOverGattConnectionState = i63;
        this.gameModeMainStatus = i64;
        this.isDeviceBonded = z19;
        this.isInitCmdCompleted = z20;
        this.adaptiveVolume = i65;
        this.adaptiveEar = i66;
        this.speechPerception = i67;
        this.micControl = i68;
        this.longPressVolume = i69;
        this.multiConversationSwitch = i70;
        this.swiftPair = i71;
        this.headMotion = i72;
        this.headMotionType = i73;
        this.sleepDetection = i74;
        this.reconnectPopupSwitch = i75;
        this.boxSn = str4;
        this.oneEarNoiseReduceMode = i76;
        this.bothEarNoiseReduceMode = i77;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EarphoneDTO copy$default(EarphoneDTO earphoneDTO, String str, String str2, String str3, boolean z2, int i10, String str4, String str5, int i11, int i12, int i13, boolean z4, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, boolean z10, boolean z11, boolean z12, int i32, int i33, int i34, int i35, int i36, List list, int i37, int i38, long j5, long j9, long j10, long j11, boolean z13, int i39, int i40, int i41, Map map, Map map2, List list2, List list3, NoiseReductionInfoDTO noiseReductionInfoDTO, NoiseReductionInfoDTO noiseReductionInfoDTO2, NoiseReductionInfoDTO noiseReductionInfoDTO3, NoiseReductionInfoDTO noiseReductionInfoDTO4, EarStatusDTO earStatusDTO, long j12, boolean z14, List list4, int i42, List list5, List list6, List list7, List list8, int i43, int i44, int i45, int i46, int i47, int i48, int i49, int i50, int i51, int i52, int i53, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, boolean z15, boolean z16, boolean z17, String str6, int i62, boolean z18, int i63, int i64, boolean z19, boolean z20, int i65, int i66, int i67, int i68, int i69, int i70, int i71, int i72, int i73, int i74, int i75, String str7, int i76, int i77, int i78, int i79, int i80, int i81, Object obj) {
        int i82;
        String str8;
        long j13;
        String str9 = (i78 & 1) != 0 ? earphoneDTO.macAddress : str;
        String str10 = (i78 & 2) != 0 ? earphoneDTO.productId : str2;
        String str11 = (i78 & 4) != 0 ? earphoneDTO.productType : str3;
        boolean z21 = (i78 & 8) != 0 ? earphoneDTO.isSupportSpp : z2;
        int i83 = (i78 & 16) != 0 ? earphoneDTO.colorId : i10;
        String str12 = (i78 & 32) != 0 ? earphoneDTO.name : str4;
        String str13 = (i78 & 64) != 0 ? earphoneDTO.popTheme : str5;
        int i84 = (i78 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? earphoneDTO.wearDetectionStatus : i11;
        int i85 = (i78 & 256) != 0 ? earphoneDTO.hearingEnhanceUsageStatus : i12;
        int i86 = (i78 & 512) != 0 ? earphoneDTO.multiConnectSwitchStatus : i13;
        boolean z22 = (i78 & 1024) != 0 ? earphoneDTO.supportMultiDeviceConnect : z4;
        String str14 = str9;
        int i87 = (i78 & 2048) != 0 ? earphoneDTO.zenModeSwitchStatus : i14;
        int i88 = (i78 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? earphoneDTO.clickToTakePicStatus : i15;
        int i89 = (i78 & 8192) != 0 ? earphoneDTO.headsetSoundRecordStatus : i16;
        int i90 = (i78 & 16384) != 0 ? earphoneDTO.highToneQualityStatus : i17;
        int i91 = (i78 & 32768) != 0 ? earphoneDTO.hearingOptimizeStatus : i18;
        int i92 = (i78 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? earphoneDTO.autoVolumeStatus : i19;
        int i93 = (i78 & 131072) != 0 ? earphoneDTO.longPowerModeStatus : i20;
        int i94 = (i78 & 262144) != 0 ? earphoneDTO.freeDialogStatus : i21;
        int i95 = (i78 & 524288) != 0 ? earphoneDTO.freeDialogRecoveryTime : i22;
        int i96 = (i78 & 1048576) != 0 ? earphoneDTO.voiceAssistStatus : i23;
        int i97 = (i78 & 2097152) != 0 ? earphoneDTO.voiceCommandStatus : i24;
        int i98 = (i78 & 4194304) != 0 ? earphoneDTO.voiceIncomingCallControlStatus : i25;
        int i99 = (i78 & 8388608) != 0 ? earphoneDTO.noiseReductionModeIndex : i26;
        int i100 = (i78 & 16777216) != 0 ? earphoneDTO.intelligentNoiseReductionModeIndex : i27;
        int i101 = (i78 & 33554432) != 0 ? earphoneDTO.eqType : i28;
        int i102 = (i78 & 67108864) != 0 ? earphoneDTO.boxBattery : i29;
        int i103 = (i78 & 134217728) != 0 ? earphoneDTO.leftBattery : i30;
        int i104 = (i78 & 268435456) != 0 ? earphoneDTO.rightBattery : i31;
        boolean z23 = (i78 & 536870912) != 0 ? earphoneDTO.isBoxCharging : z10;
        boolean z24 = (i78 & 1073741824) != 0 ? earphoneDTO.isLeftCharging : z11;
        boolean z25 = (i78 & Integer.MIN_VALUE) != 0 ? earphoneDTO.isRightCharging : z12;
        int i105 = (i79 & 1) != 0 ? earphoneDTO.headsetBoxBattery : i32;
        int i106 = (i79 & 2) != 0 ? earphoneDTO.headsetLeftBattery : i33;
        int i107 = (i79 & 4) != 0 ? earphoneDTO.headsetRightBattery : i34;
        int i108 = (i79 & 8) != 0 ? earphoneDTO.headsetConnectionState : i35;
        int i109 = (i79 & 16) != 0 ? earphoneDTO.a2dpConnectionState : i36;
        List list9 = (i79 & 32) != 0 ? earphoneDTO.headsetVersionList : list;
        int i110 = (i79 & 64) != 0 ? earphoneDTO.connectionState : i37;
        int i111 = (i79 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? earphoneDTO.aclConnectionState : i38;
        if ((i79 & 256) != 0) {
            i82 = i90;
            str8 = str10;
            j13 = earphoneDTO.aclConnectionTime;
        } else {
            i82 = i90;
            str8 = str10;
            j13 = j5;
        }
        int i112 = i82;
        long j14 = j13;
        long j15 = (i79 & 512) != 0 ? earphoneDTO.a2dpConnectionTime : j9;
        long j16 = (i79 & 1024) != 0 ? earphoneDTO.headsetConnectionTime : j10;
        long j17 = (i79 & 2048) != 0 ? earphoneDTO.sppConnectionTime : j11;
        boolean z26 = (i79 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? earphoneDTO.isActive : z13;
        int i113 = (i79 & 8192) != 0 ? earphoneDTO.pairingState : i39;
        int i114 = (i79 & 16384) != 0 ? earphoneDTO.autoOTASwitch : i40;
        int i115 = (i79 & 32768) != 0 ? earphoneDTO.channelSwitch : i41;
        Map map3 = (i79 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? earphoneDTO.leAudioConnectionStateMap : map;
        Map map4 = (i79 & 131072) != 0 ? earphoneDTO.leAudioConnectionTimeMap : map2;
        List list10 = (i79 & 262144) != 0 ? earphoneDTO.keyFunctionInfoList : list2;
        List list11 = (i79 & 524288) != 0 ? earphoneDTO.deviceVersionList : list3;
        NoiseReductionInfoDTO noiseReductionInfoDTO5 = (i79 & 1048576) != 0 ? earphoneDTO.switchNoiseReductionInfo : noiseReductionInfoDTO;
        NoiseReductionInfoDTO noiseReductionInfoDTO6 = (i79 & 2097152) != 0 ? earphoneDTO.switchLeftEarNoiseReductionInfo : noiseReductionInfoDTO2;
        NoiseReductionInfoDTO noiseReductionInfoDTO7 = (i79 & 4194304) != 0 ? earphoneDTO.switchRightEarNoiseReductionInfo : noiseReductionInfoDTO3;
        NoiseReductionInfoDTO noiseReductionInfoDTO8 = (i79 & 8388608) != 0 ? earphoneDTO.supportNoiseReductionInfo : noiseReductionInfoDTO4;
        EarStatusDTO earStatusDTO2 = (i79 & 16777216) != 0 ? earphoneDTO.earStatus : earStatusDTO;
        long j18 = (i79 & 33554432) != 0 ? earphoneDTO.earStatusReceivedMillis : j12;
        boolean z27 = (i79 & 67108864) != 0 ? earphoneDTO.isCapabilityReady : z14;
        return earphoneDTO.copy(str14, str8, str11, z21, i83, str12, str13, i84, i85, i86, z22, i87, i88, i89, i112, i91, i92, i93, i94, i95, i96, i97, i98, i99, i100, i101, i102, i103, i104, z23, z24, z25, i105, i106, i107, i108, i109, list9, i110, i111, j14, j15, j16, j17, z26, i113, i114, i115, map3, map4, list10, list11, noiseReductionInfoDTO5, noiseReductionInfoDTO6, noiseReductionInfoDTO7, noiseReductionInfoDTO8, earStatusDTO2, j18, z27, (i79 & 134217728) != 0 ? earphoneDTO.earCapability : list4, (i79 & 268435456) != 0 ? earphoneDTO.codecType : i42, (i79 & 536870912) != 0 ? earphoneDTO.codecList : list5, (i79 & 1073741824) != 0 ? earphoneDTO.spineRangeDetection : list6, (i79 & Integer.MIN_VALUE) != 0 ? earphoneDTO.spineCalibrationResult : list7, (i80 & 1) != 0 ? earphoneDTO.earTones : list8, (i80 & 2) != 0 ? earphoneDTO.vocalEnhanceStatus : i43, (i80 & 4) != 0 ? earphoneDTO.personalNoiseStatus : i44, (i80 & 8) != 0 ? earphoneDTO.safeRemindStatus : i45, (i80 & 16) != 0 ? earphoneDTO.gameModeStatus : i46, (i80 & 32) != 0 ? earphoneDTO.bassEngineStatus : i47, (i80 & 64) != 0 ? earphoneDTO.spatialSoundStatus : i48, (i80 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? earphoneDTO.saveLogStatus : i49, (i80 & 256) != 0 ? earphoneDTO.gameEqualizerStatus : i50, (i80 & 512) != 0 ? earphoneDTO.spineLiveMonitorStatus : i51, (i80 & 1024) != 0 ? earphoneDTO.spineCervicalStatus : i52, (i80 & 2048) != 0 ? earphoneDTO.spineExerciseRemindStatus : i53, (i80 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? earphoneDTO.spineCalibratedStatus : i54, (i80 & 8192) != 0 ? earphoneDTO.headsetSpatialType : i55, (i80 & 16384) != 0 ? earphoneDTO.phoneSpatialType : i56, (i80 & 32768) != 0 ? earphoneDTO.aiSummaryType : i57, (i80 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? earphoneDTO.aiTranslationAppStatus : i58, (i80 & 131072) != 0 ? earphoneDTO.volumeValueInfo : i59, (i80 & 262144) != 0 ? earphoneDTO.tapLevelSettingValue : i60, (i80 & 524288) != 0 ? earphoneDTO.tapLevelDefaultValue : i61, (i80 & 1048576) != 0 ? earphoneDTO.supportCustomEq : z15, (i80 & 2097152) != 0 ? earphoneDTO.supportSmartBluetooth : z16, (i80 & 4194304) != 0 ? earphoneDTO.supportBindAccount : z17, (i80 & 8388608) != 0 ? earphoneDTO.accountKey : str6, (i80 & 16777216) != 0 ? earphoneDTO.gameSoundStatus : i62, (i80 & 33554432) != 0 ? earphoneDTO.isVersionListReceived : z18, (i80 & 67108864) != 0 ? earphoneDTO.sppOverGattConnectionState : i63, (i80 & 134217728) != 0 ? earphoneDTO.gameModeMainStatus : i64, (i80 & 268435456) != 0 ? earphoneDTO.isDeviceBonded : z19, (i80 & 536870912) != 0 ? earphoneDTO.isInitCmdCompleted : z20, (i80 & 1073741824) != 0 ? earphoneDTO.adaptiveVolume : i65, (i80 & Integer.MIN_VALUE) != 0 ? earphoneDTO.adaptiveEar : i66, (i81 & 1) != 0 ? earphoneDTO.speechPerception : i67, (i81 & 2) != 0 ? earphoneDTO.micControl : i68, (i81 & 4) != 0 ? earphoneDTO.longPressVolume : i69, (i81 & 8) != 0 ? earphoneDTO.multiConversationSwitch : i70, (i81 & 16) != 0 ? earphoneDTO.swiftPair : i71, (i81 & 32) != 0 ? earphoneDTO.headMotion : i72, (i81 & 64) != 0 ? earphoneDTO.headMotionType : i73, (i81 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? earphoneDTO.sleepDetection : i74, (i81 & 256) != 0 ? earphoneDTO.reconnectPopupSwitch : i75, (i81 & 512) != 0 ? earphoneDTO.boxSn : str7, (i81 & 1024) != 0 ? earphoneDTO.oneEarNoiseReduceMode : i76, (i81 & 2048) != 0 ? earphoneDTO.bothEarNoiseReduceMode : i77);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final EarphoneDTO createFrom(com.oplus.melody.model.db.E entity, EarphoneStatusDO src) {
        String type;
        int i10;
        INSTANCE.getClass();
        kotlin.jvm.internal.h.e(entity, "entity");
        kotlin.jvm.internal.h.e(src, "src");
        J7.b.a().f();
        int autoOTASwitch = entity.getAutoOTASwitch();
        WhitelistConfigDTO whitelistConfigDTOC = AbstractC1508a.f().c(entity.getProductId(), entity.getName());
        String macAddress = entity.getMacAddress();
        kotlin.jvm.internal.h.d(macAddress, "getMacAddress(...)");
        String productId = entity.getProductId();
        kotlin.jvm.internal.h.d(productId, "getProductId(...)");
        int colorId = entity.getColorId();
        String name = entity.getName();
        String popTheme = entity.getPopTheme();
        int channelSwitch = entity.getChannelSwitch();
        int multiConversationSwitch = entity.getMultiConversationSwitch();
        int reconnectPopupSwitch = entity.getReconnectPopupSwitch();
        if (whitelistConfigDTOC == null || (type = whitelistConfigDTOC.getType()) == null) {
            type = "";
        }
        String str = type;
        boolean z2 = false;
        if (whitelistConfigDTOC == null || !whitelistConfigDTOC.getSupportSpp()) {
            i10 = 0;
        } else {
            i10 = 0;
            z2 = true;
        }
        EarphoneStatusDO.a leftBatteryStatus = src.getLeftBatteryStatus();
        int battery = leftBatteryStatus != null ? leftBatteryStatus.getBattery() : i10;
        EarphoneStatusDO.a leftBatteryStatus2 = src.getLeftBatteryStatus();
        boolean z4 = (leftBatteryStatus2 == null || !leftBatteryStatus2.isCharging()) ? i10 : 1;
        EarphoneStatusDO.a rightBatteryStatus = src.getRightBatteryStatus();
        int battery2 = rightBatteryStatus != null ? rightBatteryStatus.getBattery() : i10;
        EarphoneStatusDO.a rightBatteryStatus2 = src.getRightBatteryStatus();
        boolean z10 = (rightBatteryStatus2 == null || !rightBatteryStatus2.isCharging()) ? i10 : 1;
        EarphoneStatusDO.a boxBatteryStatus = src.getBoxBatteryStatus();
        int battery3 = boxBatteryStatus != null ? boxBatteryStatus.getBattery() : i10;
        EarphoneStatusDO.a boxBatteryStatus2 = src.getBoxBatteryStatus();
        boolean z11 = (boxBatteryStatus2 == null || !boxBatteryStatus2.isCharging()) ? i10 : 1;
        EarphoneStatusDO.a headsetBoxBatteryStatus = src.getHeadsetBoxBatteryStatus();
        int battery4 = headsetBoxBatteryStatus != null ? headsetBoxBatteryStatus.getBattery() : i10;
        EarphoneStatusDO.a headsetLeftBatteryStatus = src.getHeadsetLeftBatteryStatus();
        int battery5 = headsetLeftBatteryStatus != null ? headsetLeftBatteryStatus.getBattery() : i10;
        EarphoneStatusDO.a headsetRightBatteryStatus = src.getHeadsetRightBatteryStatus();
        int battery6 = headsetRightBatteryStatus != null ? headsetRightBatteryStatus.getBattery() : i10;
        int connectionState = src.getMConnectionState();
        int headsetConnectionState = src.getMHeadsetConnectionState();
        int a2dpConnectionState = src.getMA2dpConnectionState();
        androidx.collection.a aVarC = C0901g.c(src.getLeAudioConnectionStateMap());
        int aclConnectionState = src.getMAclConnectState();
        long aclConnectionTime = src.getAclConnectionTime();
        long a2dpConnectionTime = src.getA2dpConnectionTime();
        long headsetConnectionTime = src.getHeadsetConnectionTime();
        androidx.collection.a aVarC2 = C0901g.c(src.getLeAudioConnectionTimeMap());
        long sppConnectionTime = src.getSppConnectionTime();
        boolean z12 = (src.getHeadsetActive() > 0 || src.getA2dpActive() > 0 || src.getLeActive() > 0) ? 1 : i10;
        int pairingState = src.getPairingState();
        int noiseReductionModeIndex = src.getNoiseReductionModeIndex();
        int intelligentNoiseReductionModeIndex = src.getIntelligentNoiseReductionModeIndex();
        int wearDetectionStatus = src.getWearDetectionStatus();
        int multiConnectStatus = src.getMultiConnectStatus();
        boolean supportMultiDeviceConnect = src.getSupportMultiDeviceConnect();
        int zenModeStatus = src.getZenModeStatus();
        int clickToTakePhotoStatus = src.getClickToTakePhotoStatus();
        int headsetSoundRecordStatus = src.getHeadsetSoundRecordStatus();
        int vocalEnhanceStatus = src.getVocalEnhanceStatus();
        int personalNoiseStatus = src.getPersonalNoiseStatus();
        int hiQualityAudioStatus = src.getHiQualityAudioStatus();
        int hearingOptimizeStatus = src.getHearingOptimizeStatus();
        int autoVolumeStatus = src.getAutoVolumeStatus();
        int longPowerModeStatus = src.getLongPowerModeStatus();
        int freeDialogStatus = src.getFreeDialogStatus();
        int hearingEnhanceUsageStatus = src.getHearingEnhanceUsageStatus();
        int eqType = src.getEqType();
        int fullDialogRecoveryTime = src.getFullDialogRecoveryTime();
        boolean zIsVersionListReceived = src.isVersionListReceived();
        ArrayList arrayListB = C0901g.b(src.getDeviceVersionList());
        ArrayList arrayListB2 = C0901g.b(src.getHeadsetVersionList());
        ArrayList arrayListB3 = C0901g.b(src.getKeyFunctionInfoList());
        NoiseReductionInfoDTO switchNoiseReductionInfo = src.getSwitchNoiseReductionInfo();
        NoiseReductionInfoDTO noiseReductionInfoDTOCopy$default = switchNoiseReductionInfo != null ? NoiseReductionInfoDTO.copy$default(switchNoiseReductionInfo, 0, 0, 0, 7, null) : null;
        NoiseReductionInfoDTO switchLeftEarNoiseReductionInfo = src.getSwitchLeftEarNoiseReductionInfo();
        NoiseReductionInfoDTO noiseReductionInfoDTOCopy$default2 = switchLeftEarNoiseReductionInfo != null ? NoiseReductionInfoDTO.copy$default(switchLeftEarNoiseReductionInfo, 0, 0, 0, 7, null) : null;
        NoiseReductionInfoDTO switchRightEarNoiseReductionInfo = src.getSwitchRightEarNoiseReductionInfo();
        NoiseReductionInfoDTO noiseReductionInfoDTOCopy$default3 = switchRightEarNoiseReductionInfo != null ? NoiseReductionInfoDTO.copy$default(switchRightEarNoiseReductionInfo, 0, 0, 0, 7, null) : null;
        NoiseReductionInfoDTO supportNoiseReductionInfo = src.getSupportNoiseReductionInfo();
        NoiseReductionInfoDTO noiseReductionInfoDTOCopy$default4 = supportNoiseReductionInfo != null ? NoiseReductionInfoDTO.copy$default(supportNoiseReductionInfo, 0, 0, 0, 7, null) : null;
        EarStatusDTO earStatus = src.getEarStatus();
        EarStatusDTO earStatusDTOCopy$default = earStatus != null ? EarStatusDTO.copy$default(earStatus, 0, 0, 0, 7, null) : null;
        long earStatusReceivedMillis = src.getEarStatusReceivedMillis();
        int voiceAssistStatus = src.getVoiceAssistStatus();
        int voiceCommandStatus = src.getVoiceCommandStatus();
        int voiceIncomingCallControlStatus = src.getVoiceIncomingCallControlStatus();
        int safeRemindStatus = src.getSafeRemindStatus();
        int gameModeStatus = src.getGameModeStatus();
        int bassEngineStatus = src.getBassEngineStatus();
        ArrayList arrayListB4 = C0901g.b(src.getCapability());
        return new EarphoneDTO(macAddress, productId, str, z2, colorId, name, popTheme, wearDetectionStatus, hearingEnhanceUsageStatus, multiConnectStatus, supportMultiDeviceConnect, zenModeStatus, clickToTakePhotoStatus, headsetSoundRecordStatus, hiQualityAudioStatus, hearingOptimizeStatus, autoVolumeStatus, longPowerModeStatus, freeDialogStatus, fullDialogRecoveryTime, voiceAssistStatus, voiceCommandStatus, voiceIncomingCallControlStatus, noiseReductionModeIndex, intelligentNoiseReductionModeIndex, eqType, battery3, battery, battery2, z11, z4, z10, battery4, battery5, battery6, headsetConnectionState, a2dpConnectionState, arrayListB2, connectionState, aclConnectionState, aclConnectionTime, a2dpConnectionTime, headsetConnectionTime, sppConnectionTime, z12, pairingState, autoOTASwitch, channelSwitch, aVarC, aVarC2, arrayListB3, arrayListB, noiseReductionInfoDTOCopy$default, noiseReductionInfoDTOCopy$default2, noiseReductionInfoDTOCopy$default3, noiseReductionInfoDTOCopy$default4, earStatusDTOCopy$default, earStatusReceivedMillis, src.isCapabilityReady(), arrayListB4, src.getCodecType(), C0901g.b(src.getCodecList()), C0901g.b(src.getSpineRangeDetection()), C0901g.b(src.getSpineCalibrationResult()), C0901g.b(src.getEarTones()), vocalEnhanceStatus, personalNoiseStatus, safeRemindStatus, gameModeStatus, bassEngineStatus, src.getSpatialSoundStatus(), src.getSaveLogStatus(), src.getGameEqualizerStatus(), src.getSpineLiveMonitorStatus(), src.getSpineCervicalStatus(), src.getSpineExerciseStatus(), src.getSpineCalibrateState(), src.getHeadsetSpatialType(), src.getPhoneSpatialType(), src.getAiSummaryType(), src.getAiTranslationAppStatus(), src.getVolumeValueInfo(), src.getTapLevelSettingValue(), src.getTapLevelDefaultValue(), src.getSupportCustomEq(), src.getSupportSmartBluetooth(), src.getSupportBindAccount(), src.getAccountKey(), src.getGameSoundStatus(), zIsVersionListReceived, src.getSppOverGattConnectionState(), src.getGameModeMainStatus(), src.isDeviceBonded(), src.isInitCmdCompleted(), src.getAdaptiveVolume(), src.getAdaptiveEar(), src.getSpeechPerception(), src.getMicControl(), src.getLongPressVolume(), multiConversationSwitch, src.getSwiftPair(), src.getHeadMotion(), src.getHeadMotionType(), src.getSleepDetection(), reconnectPopupSwitch, src.getBoxSn(), src.getOneEarNoiseReduceMode(), src.getBothEarNoiseReduceMode());
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMacAddress() {
        return this.macAddress;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getMultiConnectSwitchStatus() {
        return this.multiConnectSwitchStatus;
    }

    /* JADX INFO: renamed from: component100, reason: from getter */
    public final int getMultiConversationSwitch() {
        return this.multiConversationSwitch;
    }

    /* JADX INFO: renamed from: component101, reason: from getter */
    public final int getSwiftPair() {
        return this.swiftPair;
    }

    /* JADX INFO: renamed from: component102, reason: from getter */
    public final int getHeadMotion() {
        return this.headMotion;
    }

    /* JADX INFO: renamed from: component103, reason: from getter */
    public final int getHeadMotionType() {
        return this.headMotionType;
    }

    /* JADX INFO: renamed from: component104, reason: from getter */
    public final int getSleepDetection() {
        return this.sleepDetection;
    }

    /* JADX INFO: renamed from: component105, reason: from getter */
    public final int getReconnectPopupSwitch() {
        return this.reconnectPopupSwitch;
    }

    /* JADX INFO: renamed from: component106, reason: from getter */
    public final String getBoxSn() {
        return this.boxSn;
    }

    /* JADX INFO: renamed from: component107, reason: from getter */
    public final int getOneEarNoiseReduceMode() {
        return this.oneEarNoiseReduceMode;
    }

    /* JADX INFO: renamed from: component108, reason: from getter */
    public final int getBothEarNoiseReduceMode() {
        return this.bothEarNoiseReduceMode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSupportMultiDeviceConnect() {
        return this.supportMultiDeviceConnect;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getZenModeSwitchStatus() {
        return this.zenModeSwitchStatus;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getClickToTakePicStatus() {
        return this.clickToTakePicStatus;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getHeadsetSoundRecordStatus() {
        return this.headsetSoundRecordStatus;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getHighToneQualityStatus() {
        return this.highToneQualityStatus;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getHearingOptimizeStatus() {
        return this.hearingOptimizeStatus;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getAutoVolumeStatus() {
        return this.autoVolumeStatus;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getLongPowerModeStatus() {
        return this.longPowerModeStatus;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getFreeDialogStatus() {
        return this.freeDialogStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getFreeDialogRecoveryTime() {
        return this.freeDialogRecoveryTime;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getVoiceAssistStatus() {
        return this.voiceAssistStatus;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getVoiceCommandStatus() {
        return this.voiceCommandStatus;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getVoiceIncomingCallControlStatus() {
        return this.voiceIncomingCallControlStatus;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final int getNoiseReductionModeIndex() {
        return this.noiseReductionModeIndex;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final int getIntelligentNoiseReductionModeIndex() {
        return this.intelligentNoiseReductionModeIndex;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getEqType() {
        return this.eqType;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final int getBoxBattery() {
        return this.boxBattery;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getLeftBattery() {
        return this.leftBattery;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final int getRightBattery() {
        return this.rightBattery;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getProductType() {
        return this.productType;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final boolean getIsBoxCharging() {
        return this.isBoxCharging;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final boolean getIsLeftCharging() {
        return this.isLeftCharging;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final boolean getIsRightCharging() {
        return this.isRightCharging;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final int getHeadsetBoxBattery() {
        return this.headsetBoxBattery;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final int getHeadsetLeftBattery() {
        return this.headsetLeftBattery;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final int getHeadsetRightBattery() {
        return this.headsetRightBattery;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final int getHeadsetConnectionState() {
        return this.headsetConnectionState;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final int getA2dpConnectionState() {
        return this.a2dpConnectionState;
    }

    public final List<DeviceVersionDTO> component38() {
        return this.headsetVersionList;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final int getConnectionState() {
        return this.connectionState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSupportSpp() {
        return this.isSupportSpp;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final int getAclConnectionState() {
        return this.aclConnectionState;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final long getAclConnectionTime() {
        return this.aclConnectionTime;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final long getA2dpConnectionTime() {
        return this.a2dpConnectionTime;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final long getHeadsetConnectionTime() {
        return this.headsetConnectionTime;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final long getSppConnectionTime() {
        return this.sppConnectionTime;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final int getPairingState() {
        return this.pairingState;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final int getAutoOTASwitch() {
        return this.autoOTASwitch;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final int getChannelSwitch() {
        return this.channelSwitch;
    }

    public final Map<String, Integer> component49() {
        return this.leAudioConnectionStateMap;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getColorId() {
        return this.colorId;
    }

    public final Map<String, Long> component50() {
        return this.leAudioConnectionTimeMap;
    }

    public final List<KeyFunctionInfoDTO> component51() {
        return this.keyFunctionInfoList;
    }

    public final List<DeviceVersionDTO> component52() {
        return this.deviceVersionList;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final NoiseReductionInfoDTO getSwitchNoiseReductionInfo() {
        return this.switchNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final NoiseReductionInfoDTO getSwitchLeftEarNoiseReductionInfo() {
        return this.switchLeftEarNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component55, reason: from getter */
    public final NoiseReductionInfoDTO getSwitchRightEarNoiseReductionInfo() {
        return this.switchRightEarNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component56, reason: from getter */
    public final NoiseReductionInfoDTO getSupportNoiseReductionInfo() {
        return this.supportNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component57, reason: from getter */
    public final EarStatusDTO getEarStatus() {
        return this.earStatus;
    }

    /* JADX INFO: renamed from: component58, reason: from getter */
    public final long getEarStatusReceivedMillis() {
        return this.earStatusReceivedMillis;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final boolean getIsCapabilityReady() {
        return this.isCapabilityReady;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Integer> component60() {
        return this.earCapability;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final int getCodecType() {
        return this.codecType;
    }

    public final List<Integer> component62() {
        return this.codecList;
    }

    public final List<Float> component63() {
        return this.spineRangeDetection;
    }

    public final List<Integer> component64() {
        return this.spineCalibrationResult;
    }

    public final List<EarToneDTO> component65() {
        return this.earTones;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final int getVocalEnhanceStatus() {
        return this.vocalEnhanceStatus;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final int getPersonalNoiseStatus() {
        return this.personalNoiseStatus;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final int getSafeRemindStatus() {
        return this.safeRemindStatus;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final int getGameModeStatus() {
        return this.gameModeStatus;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPopTheme() {
        return this.popTheme;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final int getBassEngineStatus() {
        return this.bassEngineStatus;
    }

    /* JADX INFO: renamed from: component71, reason: from getter */
    public final int getSpatialSoundStatus() {
        return this.spatialSoundStatus;
    }

    /* JADX INFO: renamed from: component72, reason: from getter */
    public final int getSaveLogStatus() {
        return this.saveLogStatus;
    }

    /* JADX INFO: renamed from: component73, reason: from getter */
    public final int getGameEqualizerStatus() {
        return this.gameEqualizerStatus;
    }

    /* JADX INFO: renamed from: component74, reason: from getter */
    public final int getSpineLiveMonitorStatus() {
        return this.spineLiveMonitorStatus;
    }

    /* JADX INFO: renamed from: component75, reason: from getter */
    public final int getSpineCervicalStatus() {
        return this.spineCervicalStatus;
    }

    /* JADX INFO: renamed from: component76, reason: from getter */
    public final int getSpineExerciseRemindStatus() {
        return this.spineExerciseRemindStatus;
    }

    /* JADX INFO: renamed from: component77, reason: from getter */
    public final int getSpineCalibratedStatus() {
        return this.spineCalibratedStatus;
    }

    /* JADX INFO: renamed from: component78, reason: from getter */
    public final int getHeadsetSpatialType() {
        return this.headsetSpatialType;
    }

    /* JADX INFO: renamed from: component79, reason: from getter */
    public final int getPhoneSpatialType() {
        return this.phoneSpatialType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getWearDetectionStatus() {
        return this.wearDetectionStatus;
    }

    /* JADX INFO: renamed from: component80, reason: from getter */
    public final int getAiSummaryType() {
        return this.aiSummaryType;
    }

    /* JADX INFO: renamed from: component81, reason: from getter */
    public final int getAiTranslationAppStatus() {
        return this.aiTranslationAppStatus;
    }

    /* JADX INFO: renamed from: component82, reason: from getter */
    public final int getVolumeValueInfo() {
        return this.volumeValueInfo;
    }

    /* JADX INFO: renamed from: component83, reason: from getter */
    public final int getTapLevelSettingValue() {
        return this.tapLevelSettingValue;
    }

    /* JADX INFO: renamed from: component84, reason: from getter */
    public final int getTapLevelDefaultValue() {
        return this.tapLevelDefaultValue;
    }

    /* JADX INFO: renamed from: component85, reason: from getter */
    public final boolean getSupportCustomEq() {
        return this.supportCustomEq;
    }

    /* JADX INFO: renamed from: component86, reason: from getter */
    public final boolean getSupportSmartBluetooth() {
        return this.supportSmartBluetooth;
    }

    /* JADX INFO: renamed from: component87, reason: from getter */
    public final boolean getSupportBindAccount() {
        return this.supportBindAccount;
    }

    /* JADX INFO: renamed from: component88, reason: from getter */
    public final String getAccountKey() {
        return this.accountKey;
    }

    /* JADX INFO: renamed from: component89, reason: from getter */
    public final int getGameSoundStatus() {
        return this.gameSoundStatus;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getHearingEnhanceUsageStatus() {
        return this.hearingEnhanceUsageStatus;
    }

    /* JADX INFO: renamed from: component90, reason: from getter */
    public final boolean getIsVersionListReceived() {
        return this.isVersionListReceived;
    }

    /* JADX INFO: renamed from: component91, reason: from getter */
    public final int getSppOverGattConnectionState() {
        return this.sppOverGattConnectionState;
    }

    /* JADX INFO: renamed from: component92, reason: from getter */
    public final int getGameModeMainStatus() {
        return this.gameModeMainStatus;
    }

    /* JADX INFO: renamed from: component93, reason: from getter */
    public final boolean getIsDeviceBonded() {
        return this.isDeviceBonded;
    }

    /* JADX INFO: renamed from: component94, reason: from getter */
    public final boolean getIsInitCmdCompleted() {
        return this.isInitCmdCompleted;
    }

    /* JADX INFO: renamed from: component95, reason: from getter */
    public final int getAdaptiveVolume() {
        return this.adaptiveVolume;
    }

    /* JADX INFO: renamed from: component96, reason: from getter */
    public final int getAdaptiveEar() {
        return this.adaptiveEar;
    }

    /* JADX INFO: renamed from: component97, reason: from getter */
    public final int getSpeechPerception() {
        return this.speechPerception;
    }

    /* JADX INFO: renamed from: component98, reason: from getter */
    public final int getMicControl() {
        return this.micControl;
    }

    /* JADX INFO: renamed from: component99, reason: from getter */
    public final int getLongPressVolume() {
        return this.longPressVolume;
    }

    public final EarphoneDTO copy(String macAddress, String productId, String productType, boolean isSupportSpp, int colorId, String name, String popTheme, int wearDetectionStatus, int hearingEnhanceUsageStatus, int multiConnectSwitchStatus, boolean supportMultiDeviceConnect, int zenModeSwitchStatus, int clickToTakePicStatus, int headsetSoundRecordStatus, int highToneQualityStatus, int hearingOptimizeStatus, int autoVolumeStatus, int longPowerModeStatus, int freeDialogStatus, int freeDialogRecoveryTime, int voiceAssistStatus, int voiceCommandStatus, int voiceIncomingCallControlStatus, int noiseReductionModeIndex, int intelligentNoiseReductionModeIndex, int eqType, int boxBattery, int leftBattery, int rightBattery, boolean isBoxCharging, boolean isLeftCharging, boolean isRightCharging, int headsetBoxBattery, int headsetLeftBattery, int headsetRightBattery, int headsetConnectionState, int a2dpConnectionState, List<DeviceVersionDTO> headsetVersionList, int connectionState, int aclConnectionState, long aclConnectionTime, long a2dpConnectionTime, long headsetConnectionTime, long sppConnectionTime, boolean isActive, int pairingState, int autoOTASwitch, int channelSwitch, Map<String, Integer> leAudioConnectionStateMap, Map<String, Long> leAudioConnectionTimeMap, List<KeyFunctionInfoDTO> keyFunctionInfoList, List<DeviceVersionDTO> deviceVersionList, NoiseReductionInfoDTO switchNoiseReductionInfo, NoiseReductionInfoDTO switchLeftEarNoiseReductionInfo, NoiseReductionInfoDTO switchRightEarNoiseReductionInfo, NoiseReductionInfoDTO supportNoiseReductionInfo, EarStatusDTO earStatus, long earStatusReceivedMillis, boolean isCapabilityReady, List<Integer> earCapability, int codecType, List<Integer> codecList, List<Float> spineRangeDetection, List<Integer> spineCalibrationResult, List<EarToneDTO> earTones, int vocalEnhanceStatus, int personalNoiseStatus, int safeRemindStatus, int gameModeStatus, int bassEngineStatus, int spatialSoundStatus, int saveLogStatus, int gameEqualizerStatus, int spineLiveMonitorStatus, int spineCervicalStatus, int spineExerciseRemindStatus, int spineCalibratedStatus, int headsetSpatialType, int phoneSpatialType, int aiSummaryType, int aiTranslationAppStatus, int volumeValueInfo, int tapLevelSettingValue, int tapLevelDefaultValue, boolean supportCustomEq, boolean supportSmartBluetooth, boolean supportBindAccount, String accountKey, int gameSoundStatus, boolean isVersionListReceived, int sppOverGattConnectionState, int gameModeMainStatus, boolean isDeviceBonded, boolean isInitCmdCompleted, int adaptiveVolume, int adaptiveEar, int speechPerception, int micControl, int longPressVolume, int multiConversationSwitch, int swiftPair, int headMotion, int headMotionType, int sleepDetection, int reconnectPopupSwitch, String boxSn, int oneEarNoiseReduceMode, int bothEarNoiseReduceMode) {
        kotlin.jvm.internal.h.e(macAddress, "macAddress");
        kotlin.jvm.internal.h.e(productId, "productId");
        kotlin.jvm.internal.h.e(productType, "productType");
        kotlin.jvm.internal.h.e(headsetVersionList, "headsetVersionList");
        kotlin.jvm.internal.h.e(leAudioConnectionStateMap, "leAudioConnectionStateMap");
        kotlin.jvm.internal.h.e(leAudioConnectionTimeMap, "leAudioConnectionTimeMap");
        kotlin.jvm.internal.h.e(keyFunctionInfoList, "keyFunctionInfoList");
        kotlin.jvm.internal.h.e(deviceVersionList, "deviceVersionList");
        kotlin.jvm.internal.h.e(earCapability, "earCapability");
        kotlin.jvm.internal.h.e(codecList, "codecList");
        kotlin.jvm.internal.h.e(spineRangeDetection, "spineRangeDetection");
        kotlin.jvm.internal.h.e(spineCalibrationResult, "spineCalibrationResult");
        kotlin.jvm.internal.h.e(earTones, "earTones");
        return new EarphoneDTO(macAddress, productId, productType, isSupportSpp, colorId, name, popTheme, wearDetectionStatus, hearingEnhanceUsageStatus, multiConnectSwitchStatus, supportMultiDeviceConnect, zenModeSwitchStatus, clickToTakePicStatus, headsetSoundRecordStatus, highToneQualityStatus, hearingOptimizeStatus, autoVolumeStatus, longPowerModeStatus, freeDialogStatus, freeDialogRecoveryTime, voiceAssistStatus, voiceCommandStatus, voiceIncomingCallControlStatus, noiseReductionModeIndex, intelligentNoiseReductionModeIndex, eqType, boxBattery, leftBattery, rightBattery, isBoxCharging, isLeftCharging, isRightCharging, headsetBoxBattery, headsetLeftBattery, headsetRightBattery, headsetConnectionState, a2dpConnectionState, headsetVersionList, connectionState, aclConnectionState, aclConnectionTime, a2dpConnectionTime, headsetConnectionTime, sppConnectionTime, isActive, pairingState, autoOTASwitch, channelSwitch, leAudioConnectionStateMap, leAudioConnectionTimeMap, keyFunctionInfoList, deviceVersionList, switchNoiseReductionInfo, switchLeftEarNoiseReductionInfo, switchRightEarNoiseReductionInfo, supportNoiseReductionInfo, earStatus, earStatusReceivedMillis, isCapabilityReady, earCapability, codecType, codecList, spineRangeDetection, spineCalibrationResult, earTones, vocalEnhanceStatus, personalNoiseStatus, safeRemindStatus, gameModeStatus, bassEngineStatus, spatialSoundStatus, saveLogStatus, gameEqualizerStatus, spineLiveMonitorStatus, spineCervicalStatus, spineExerciseRemindStatus, spineCalibratedStatus, headsetSpatialType, phoneSpatialType, aiSummaryType, aiTranslationAppStatus, volumeValueInfo, tapLevelSettingValue, tapLevelDefaultValue, supportCustomEq, supportSmartBluetooth, supportBindAccount, accountKey, gameSoundStatus, isVersionListReceived, sppOverGattConnectionState, gameModeMainStatus, isDeviceBonded, isInitCmdCompleted, adaptiveVolume, adaptiveEar, speechPerception, micControl, longPressVolume, multiConversationSwitch, swiftPair, headMotion, headMotionType, sleepDetection, reconnectPopupSwitch, boxSn, oneEarNoiseReduceMode, bothEarNoiseReduceMode);
    }

    public final EarphoneDTO copyWithAccountKey(String accountKey) {
        return copy$default(this, null, null, null, false, 0, null, null, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, 0, 0, 0, 0, 0, null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0, null, null, null, null, null, null, null, null, null, 0L, false, null, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, false, accountKey, 0, false, 0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, -1, -1, -8388609, 4095, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int getA2dpConnectionState() {
        return this.a2dpConnectionState;
    }

    public final long getA2dpConnectionTime() {
        return this.a2dpConnectionTime;
    }

    public final String getAccountKey() {
        return this.accountKey;
    }

    public final int getAclConnectionState() {
        return this.aclConnectionState;
    }

    public final long getAclConnectionTime() {
        return this.aclConnectionTime;
    }

    public final int getAdaptiveEar() {
        return this.adaptiveEar;
    }

    public final int getAdaptiveVolume() {
        return this.adaptiveVolume;
    }

    public final int getAiSummaryType() {
        return this.aiSummaryType;
    }

    public final int getAiTranslationAppStatus() {
        return this.aiTranslationAppStatus;
    }

    public final int getAutoOTASwitch() {
        return this.autoOTASwitch;
    }

    public final int getAutoVolumeStatus() {
        return this.autoVolumeStatus;
    }

    public final int getBassEngineStatus() {
        return this.bassEngineStatus;
    }

    public final int getBothEarNoiseReduceMode() {
        return this.bothEarNoiseReduceMode;
    }

    public final int getBoxBattery() {
        return this.boxBattery;
    }

    public final String getBoxSn() {
        return this.boxSn;
    }

    public final int getChannelSwitch() {
        return this.channelSwitch;
    }

    public final int getClickToTakePicStatus() {
        return this.clickToTakePicStatus;
    }

    public final List<Integer> getCodecList() {
        return this.codecList;
    }

    public final int getCodecType() {
        return this.codecType;
    }

    public final int getColorId() {
        return this.colorId;
    }

    public final int getConnectionState() {
        return this.connectionState;
    }

    public final List<DeviceVersionDTO> getDeviceVersionList() {
        return this.deviceVersionList;
    }

    public final List<Integer> getEarCapability() {
        return this.earCapability;
    }

    public final EarStatusDTO getEarStatus() {
        return this.earStatus;
    }

    public final long getEarStatusReceivedMillis() {
        return this.earStatusReceivedMillis;
    }

    public final List<EarToneDTO> getEarTones() {
        return this.earTones;
    }

    public final int getEqType() {
        return this.eqType;
    }

    public final int getFreeDialogRecoveryTime() {
        return this.freeDialogRecoveryTime;
    }

    public final int getFreeDialogStatus() {
        return this.freeDialogStatus;
    }

    public final int getGameEqualizerStatus() {
        return this.gameEqualizerStatus;
    }

    public final int getGameModeMainStatus() {
        return this.gameModeMainStatus;
    }

    public final int getGameModeStatus() {
        return this.gameModeStatus;
    }

    public final int getGameSoundStatus() {
        return this.gameSoundStatus;
    }

    public final int getHeadMotion() {
        return this.headMotion;
    }

    public final int getHeadMotionType() {
        return this.headMotionType;
    }

    public final int getHeadsetBoxBattery() {
        return this.headsetBoxBattery;
    }

    public final int getHeadsetConnectionState() {
        return this.headsetConnectionState;
    }

    public final long getHeadsetConnectionTime() {
        return this.headsetConnectionTime;
    }

    public final int getHeadsetLeftBattery() {
        return this.headsetLeftBattery;
    }

    public final int getHeadsetRightBattery() {
        return this.headsetRightBattery;
    }

    public final int getHeadsetSoundRecordStatus() {
        return this.headsetSoundRecordStatus;
    }

    public final int getHeadsetSpatialType() {
        return this.headsetSpatialType;
    }

    public final List<DeviceVersionDTO> getHeadsetVersionList() {
        return this.headsetVersionList;
    }

    public final int getHearingEnhanceUsageStatus() {
        return this.hearingEnhanceUsageStatus;
    }

    public final int getHearingOptimizeStatus() {
        return this.hearingOptimizeStatus;
    }

    public final int getHighToneQualityStatus() {
        return this.highToneQualityStatus;
    }

    public final int getIntelligentNoiseReductionModeIndex() {
        return this.intelligentNoiseReductionModeIndex;
    }

    public final List<KeyFunctionInfoDTO> getKeyFunctionInfoList() {
        return this.keyFunctionInfoList;
    }

    public final Map<String, Integer> getLeAudioConnectionStateMap() {
        return this.leAudioConnectionStateMap;
    }

    public final Map<String, Long> getLeAudioConnectionTimeMap() {
        return this.leAudioConnectionTimeMap;
    }

    public final int getLeftBattery() {
        return this.leftBattery;
    }

    public final int getLongPowerModeStatus() {
        return this.longPowerModeStatus;
    }

    public final int getLongPressVolume() {
        return this.longPressVolume;
    }

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final int getMicControl() {
        return this.micControl;
    }

    public final int getMultiConnectSwitchStatus() {
        return this.multiConnectSwitchStatus;
    }

    public final int getMultiConversationSwitch() {
        return this.multiConversationSwitch;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNoiseReductionModeIndex() {
        return this.noiseReductionModeIndex;
    }

    public final int getOneEarNoiseReduceMode() {
        return this.oneEarNoiseReduceMode;
    }

    public final int getPairingState() {
        return this.pairingState;
    }

    public final int getPersonalNoiseStatus() {
        return this.personalNoiseStatus;
    }

    public final int getPhoneSpatialType() {
        return this.phoneSpatialType;
    }

    public final String getPopTheme() {
        return this.popTheme;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductType() {
        return this.productType;
    }

    public final int getReconnectPopupSwitch() {
        return this.reconnectPopupSwitch;
    }

    public final int getRightBattery() {
        return this.rightBattery;
    }

    public final int getSafeRemindStatus() {
        return this.safeRemindStatus;
    }

    public final int getSaveLogStatus() {
        return this.saveLogStatus;
    }

    public final int getSleepDetection() {
        return this.sleepDetection;
    }

    public final int getSpatialSoundStatus() {
        return this.spatialSoundStatus;
    }

    public final int getSpeechPerception() {
        return this.speechPerception;
    }

    public final int getSpineCalibratedStatus() {
        return this.spineCalibratedStatus;
    }

    public final List<Integer> getSpineCalibrationResult() {
        return this.spineCalibrationResult;
    }

    public final int getSpineCervicalStatus() {
        return this.spineCervicalStatus;
    }

    public final int getSpineExerciseRemindStatus() {
        return this.spineExerciseRemindStatus;
    }

    public final int getSpineLiveMonitorStatus() {
        return this.spineLiveMonitorStatus;
    }

    public final List<Float> getSpineRangeDetection() {
        return this.spineRangeDetection;
    }

    public final long getSppConnectionTime() {
        return this.sppConnectionTime;
    }

    public final int getSppOverGattConnectionState() {
        return this.sppOverGattConnectionState;
    }

    public final boolean getSupportBindAccount() {
        return this.supportBindAccount;
    }

    public final boolean getSupportCustomEq() {
        return this.supportCustomEq;
    }

    public final boolean getSupportMultiDeviceConnect() {
        return this.supportMultiDeviceConnect;
    }

    public final NoiseReductionInfoDTO getSupportNoiseReductionInfo() {
        return this.supportNoiseReductionInfo;
    }

    public final boolean getSupportSmartBluetooth() {
        return this.supportSmartBluetooth;
    }

    public final int getSwiftPair() {
        return this.swiftPair;
    }

    public final NoiseReductionInfoDTO getSwitchLeftEarNoiseReductionInfo() {
        return this.switchLeftEarNoiseReductionInfo;
    }

    public final NoiseReductionInfoDTO getSwitchNoiseReductionInfo() {
        return this.switchNoiseReductionInfo;
    }

    public final NoiseReductionInfoDTO getSwitchRightEarNoiseReductionInfo() {
        return this.switchRightEarNoiseReductionInfo;
    }

    public final int getTapLevelDefaultValue() {
        return this.tapLevelDefaultValue;
    }

    public final int getTapLevelSettingValue() {
        return this.tapLevelSettingValue;
    }

    public final int getVocalEnhanceStatus() {
        return this.vocalEnhanceStatus;
    }

    public final int getVoiceAssistStatus() {
        return this.voiceAssistStatus;
    }

    public final int getVoiceCommandStatus() {
        return this.voiceCommandStatus;
    }

    public final int getVoiceIncomingCallControlStatus() {
        return this.voiceIncomingCallControlStatus;
    }

    public final int getVolumeValueInfo() {
        return this.volumeValueInfo;
    }

    public final int getWearDetectionStatus() {
        return this.wearDetectionStatus;
    }

    public final int getZenModeSwitchStatus() {
        return this.zenModeSwitchStatus;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isBoxCharging() {
        return this.isBoxCharging;
    }

    public final boolean isCapabilityReady() {
        return this.isCapabilityReady;
    }

    public final boolean isDeviceBonded() {
        return this.isDeviceBonded;
    }

    public final boolean isInitCmdCompleted() {
        return this.isInitCmdCompleted;
    }

    public final boolean isLeftCharging() {
        return this.isLeftCharging;
    }

    public final boolean isRightCharging() {
        return this.isRightCharging;
    }

    public final boolean isSupportSpp() {
        return this.isSupportSpp;
    }

    public final boolean isVersionListReceived() {
        return this.isVersionListReceived;
    }

    public final void setVoiceIncomingCallControlStatus(int i10) {
        this.voiceIncomingCallControlStatus = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.h.e(dest, "dest");
        dest.writeString(this.macAddress);
        dest.writeString(this.productId);
        dest.writeString(this.productType);
        dest.writeInt(this.isSupportSpp ? 1 : 0);
        dest.writeInt(this.colorId);
        dest.writeString(this.name);
        dest.writeString(this.popTheme);
        dest.writeInt(this.wearDetectionStatus);
        dest.writeInt(this.hearingEnhanceUsageStatus);
        dest.writeInt(this.multiConnectSwitchStatus);
        dest.writeInt(this.supportMultiDeviceConnect ? 1 : 0);
        dest.writeInt(this.zenModeSwitchStatus);
        dest.writeInt(this.clickToTakePicStatus);
        dest.writeInt(this.headsetSoundRecordStatus);
        dest.writeInt(this.highToneQualityStatus);
        dest.writeInt(this.hearingOptimizeStatus);
        dest.writeInt(this.autoVolumeStatus);
        dest.writeInt(this.longPowerModeStatus);
        dest.writeInt(this.freeDialogStatus);
        dest.writeInt(this.freeDialogRecoveryTime);
        dest.writeInt(this.voiceAssistStatus);
        dest.writeInt(this.voiceCommandStatus);
        dest.writeInt(this.voiceIncomingCallControlStatus);
        dest.writeInt(this.noiseReductionModeIndex);
        dest.writeInt(this.intelligentNoiseReductionModeIndex);
        dest.writeInt(this.eqType);
        dest.writeInt(this.boxBattery);
        dest.writeInt(this.leftBattery);
        dest.writeInt(this.rightBattery);
        dest.writeInt(this.isBoxCharging ? 1 : 0);
        dest.writeInt(this.isLeftCharging ? 1 : 0);
        dest.writeInt(this.isRightCharging ? 1 : 0);
        dest.writeInt(this.headsetBoxBattery);
        dest.writeInt(this.headsetLeftBattery);
        dest.writeInt(this.headsetRightBattery);
        dest.writeInt(this.headsetConnectionState);
        dest.writeInt(this.a2dpConnectionState);
        List<DeviceVersionDTO> list = this.headsetVersionList;
        dest.writeInt(list.size());
        Iterator<DeviceVersionDTO> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.connectionState);
        dest.writeInt(this.aclConnectionState);
        dest.writeLong(this.aclConnectionTime);
        dest.writeLong(this.a2dpConnectionTime);
        dest.writeLong(this.headsetConnectionTime);
        dest.writeLong(this.sppConnectionTime);
        dest.writeInt(this.isActive ? 1 : 0);
        dest.writeInt(this.pairingState);
        dest.writeInt(this.autoOTASwitch);
        dest.writeInt(this.channelSwitch);
        Map<String, Integer> map = this.leAudioConnectionStateMap;
        dest.writeInt(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeInt(entry.getValue().intValue());
        }
        Map<String, Long> map2 = this.leAudioConnectionTimeMap;
        dest.writeInt(map2.size());
        for (Map.Entry<String, Long> entry2 : map2.entrySet()) {
            dest.writeString(entry2.getKey());
            dest.writeLong(entry2.getValue().longValue());
        }
        List<KeyFunctionInfoDTO> list2 = this.keyFunctionInfoList;
        dest.writeInt(list2.size());
        Iterator<KeyFunctionInfoDTO> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(dest, flags);
        }
        List<DeviceVersionDTO> list3 = this.deviceVersionList;
        dest.writeInt(list3.size());
        Iterator<DeviceVersionDTO> it3 = list3.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(dest, flags);
        }
        NoiseReductionInfoDTO noiseReductionInfoDTO = this.switchNoiseReductionInfo;
        if (noiseReductionInfoDTO == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            noiseReductionInfoDTO.writeToParcel(dest, flags);
        }
        NoiseReductionInfoDTO noiseReductionInfoDTO2 = this.switchLeftEarNoiseReductionInfo;
        if (noiseReductionInfoDTO2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            noiseReductionInfoDTO2.writeToParcel(dest, flags);
        }
        NoiseReductionInfoDTO noiseReductionInfoDTO3 = this.switchRightEarNoiseReductionInfo;
        if (noiseReductionInfoDTO3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            noiseReductionInfoDTO3.writeToParcel(dest, flags);
        }
        NoiseReductionInfoDTO noiseReductionInfoDTO4 = this.supportNoiseReductionInfo;
        if (noiseReductionInfoDTO4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            noiseReductionInfoDTO4.writeToParcel(dest, flags);
        }
        EarStatusDTO earStatusDTO = this.earStatus;
        if (earStatusDTO == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            earStatusDTO.writeToParcel(dest, flags);
        }
        dest.writeLong(this.earStatusReceivedMillis);
        dest.writeInt(this.isCapabilityReady ? 1 : 0);
        List<Integer> list4 = this.earCapability;
        dest.writeInt(list4.size());
        Iterator<Integer> it4 = list4.iterator();
        while (it4.hasNext()) {
            dest.writeInt(it4.next().intValue());
        }
        dest.writeInt(this.codecType);
        List<Integer> list5 = this.codecList;
        dest.writeInt(list5.size());
        Iterator<Integer> it5 = list5.iterator();
        while (it5.hasNext()) {
            dest.writeInt(it5.next().intValue());
        }
        List<Float> list6 = this.spineRangeDetection;
        dest.writeInt(list6.size());
        Iterator<Float> it6 = list6.iterator();
        while (it6.hasNext()) {
            dest.writeFloat(it6.next().floatValue());
        }
        List<Integer> list7 = this.spineCalibrationResult;
        dest.writeInt(list7.size());
        Iterator<Integer> it7 = list7.iterator();
        while (it7.hasNext()) {
            dest.writeInt(it7.next().intValue());
        }
        List<EarToneDTO> list8 = this.earTones;
        dest.writeInt(list8.size());
        Iterator<EarToneDTO> it8 = list8.iterator();
        while (it8.hasNext()) {
            it8.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.vocalEnhanceStatus);
        dest.writeInt(this.personalNoiseStatus);
        dest.writeInt(this.safeRemindStatus);
        dest.writeInt(this.gameModeStatus);
        dest.writeInt(this.bassEngineStatus);
        dest.writeInt(this.spatialSoundStatus);
        dest.writeInt(this.saveLogStatus);
        dest.writeInt(this.gameEqualizerStatus);
        dest.writeInt(this.spineLiveMonitorStatus);
        dest.writeInt(this.spineCervicalStatus);
        dest.writeInt(this.spineExerciseRemindStatus);
        dest.writeInt(this.spineCalibratedStatus);
        dest.writeInt(this.headsetSpatialType);
        dest.writeInt(this.phoneSpatialType);
        dest.writeInt(this.aiSummaryType);
        dest.writeInt(this.aiTranslationAppStatus);
        dest.writeInt(this.volumeValueInfo);
        dest.writeInt(this.tapLevelSettingValue);
        dest.writeInt(this.tapLevelDefaultValue);
        dest.writeInt(this.supportCustomEq ? 1 : 0);
        dest.writeInt(this.supportSmartBluetooth ? 1 : 0);
        dest.writeInt(this.supportBindAccount ? 1 : 0);
        dest.writeString(this.accountKey);
        dest.writeInt(this.gameSoundStatus);
        dest.writeInt(this.isVersionListReceived ? 1 : 0);
        dest.writeInt(this.sppOverGattConnectionState);
        dest.writeInt(this.gameModeMainStatus);
        dest.writeInt(this.isDeviceBonded ? 1 : 0);
        dest.writeInt(this.isInitCmdCompleted ? 1 : 0);
        dest.writeInt(this.adaptiveVolume);
        dest.writeInt(this.adaptiveEar);
        dest.writeInt(this.speechPerception);
        dest.writeInt(this.micControl);
        dest.writeInt(this.longPressVolume);
        dest.writeInt(this.multiConversationSwitch);
        dest.writeInt(this.swiftPair);
        dest.writeInt(this.headMotion);
        dest.writeInt(this.headMotionType);
        dest.writeInt(this.sleepDetection);
        dest.writeInt(this.reconnectPopupSwitch);
        dest.writeString(this.boxSn);
        dest.writeInt(this.oneEarNoiseReduceMode);
        dest.writeInt(this.bothEarNoiseReduceMode);
    }
}
