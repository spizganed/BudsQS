package com.oplus.melody.model.repository.earphone;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.oplus.melody.btsdk.api.data.MultiConnectInformationElement;
import com.oplus.melody.ui.component.detail.headmotion.HeadMotionItem;
import com.oplus.mydevices.sdk.device.DeviceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.M, reason: from Kotlin metadata */
/* JADX INFO: compiled from: EarphoneStatusDO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0003\bæ\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u00ad\u0003B\u008f\b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0010\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00105\u001a\u00020\u0007\u0012\b\b\u0002\u00106\u001a\u00020\u0005\u0012\b\b\u0002\u00107\u001a\u00020\u0005\u0012\b\b\u0002\u00108\u001a\u00020\u0005\u0012\b\b\u0002\u00109\u001a\u00020\u0005\u0012\b\b\u0002\u0010:\u001a\u00020\u0005\u0012\b\b\u0002\u0010;\u001a\u00020\u0005\u0012\b\b\u0002\u0010<\u001a\u00020\u0005\u0012\b\b\u0002\u0010=\u001a\u00020\u0005\u0012\b\b\u0002\u0010>\u001a\u00020\u0005\u0012\b\b\u0002\u0010?\u001a\u00020\u0005\u0012\b\b\u0002\u0010@\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u0012\b\b\u0002\u0010B\u001a\u00020!\u0012\b\b\u0002\u0010C\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010\u0012\b\b\u0002\u0010J\u001a\u00020\u0005\u0012\b\b\u0002\u0010K\u001a\u00020!\u0012\b\b\u0002\u0010L\u001a\u00020!\u0012\b\b\u0002\u0010M\u001a\u00020!\u0012\b\b\u0002\u0010N\u001a\u00020\u0005\u0012\b\b\u0002\u0010O\u001a\u00020\u0005\u0012\b\b\u0002\u0010P\u001a\u00020\u0005\u0012\b\b\u0002\u0010Q\u001a\u00020\u0005\u0012\b\b\u0002\u0010R\u001a\u00020\u0005\u0012\b\b\u0002\u0010S\u001a\u00020\u0005\u0012\b\b\u0002\u0010T\u001a\u00020\u0005\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010V\u001a\u00020\u0005\u0012\b\b\u0002\u0010W\u001a\u00020!\u0012\b\b\u0002\u0010X\u001a\u00020\u0005\u0012\b\b\u0002\u0010Y\u001a\u00020\u0005\u0012\b\b\u0002\u0010Z\u001a\u00020!\u0012\b\b\u0002\u0010[\u001a\u00020!\u0012\b\b\u0002\u0010\\\u001a\u00020\u0005\u0012\b\b\u0002\u0010]\u001a\u00020\u0005\u0012\b\b\u0002\u0010^\u001a\u00020\u0005\u0012\b\b\u0002\u0010_\u001a\u00020\u0005\u0012\b\b\u0002\u0010`\u001a\u00020\u0005\u0012\b\b\u0002\u0010a\u001a\u00020\u0005\u0012\b\b\u0002\u0010b\u001a\u00020\u0005\u0012\b\b\u0002\u0010c\u001a\u00020\u0005\u0012\b\b\u0002\u0010d\u001a\u00020\u0005\u0012\b\b\u0002\u0010e\u001a\u00020!\u0012\b\b\u0002\u0010f\u001a\u00020!\u0012\b\b\u0002\u0010g\u001a\u00020\u0005\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010i\u001a\u00020\u0005\u0012\b\b\u0002\u0010j\u001a\u00020\u0005¢\u0006\u0004\bk\u0010lJ\u0016\u0010Ñ\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0016\u0010Ò\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\f\u0010Ó\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010Ô\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010Õ\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010Ö\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010×\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\f\u0010Ø\u0002\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010Ù\u0002\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\n\u0010Ú\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Û\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ü\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Ý\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010Þ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ß\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010à\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010á\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010â\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ã\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ä\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010å\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010æ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ç\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010è\u0002\u001a\u00020!HÆ\u0003J\n\u0010é\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ê\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ë\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ì\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010í\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010î\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ï\u0002\u001a\u00020\u0005HÆ\u0003J\u0012\u0010ð\u0002\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0012\u0010ñ\u0002\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0010HÆ\u0003J\u0012\u0010ò\u0002\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0010HÆ\u0003J\f\u0010ó\u0002\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010ô\u0002\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010õ\u0002\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010ö\u0002\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010÷\u0002\u001a\u0004\u0018\u000104HÆ\u0003J\n\u0010ø\u0002\u001a\u00020\u0007HÆ\u0003J\n\u0010ù\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ú\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010û\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ü\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ý\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010þ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010ÿ\u0002\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0081\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0082\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0083\u0003\u001a\u00020\u0005HÆ\u0003J\u0012\u0010\u0084\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010HÆ\u0003J\n\u0010\u0085\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u0086\u0003\u001a\u00020\u0005HÆ\u0003J\u0012\u0010\u0087\u0003\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0010HÆ\u0003J\u0012\u0010\u0088\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010HÆ\u0003J\u0012\u0010\u0089\u0003\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0010HÆ\u0003J\u0012\u0010\u008a\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010HÆ\u0003J\n\u0010\u008b\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008c\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u008d\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u008e\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u008f\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0090\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0091\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0092\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0093\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0094\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0095\u0003\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0097\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0098\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u0099\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009a\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009b\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u009c\u0003\u001a\u00020!HÆ\u0003J\n\u0010\u009d\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009e\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010\u009f\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010 \u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010¡\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010¢\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010£\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010¤\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010¥\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010¦\u0003\u001a\u00020!HÆ\u0003J\n\u0010§\u0003\u001a\u00020!HÆ\u0003J\n\u0010¨\u0003\u001a\u00020\u0005HÆ\u0003J\f\u0010©\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010ª\u0003\u001a\u00020\u0005HÆ\u0003J\n\u0010«\u0003\u001a\u00020\u0005HÆ\u0003J\u0092\b\u0010¬\u0003\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u00052\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00102\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010/2\n\b\u0002\u00102\u001a\u0004\u0018\u00010/2\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u00020\u00072\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020\u00052\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00052\b\b\u0002\u0010<\u001a\u00020\u00052\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00052\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\b\b\u0002\u0010B\u001a\u00020!2\b\b\u0002\u0010C\u001a\u00020\u00052\u0010\b\u0002\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u00102\u0010\b\u0002\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u00102\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020!2\b\b\u0002\u0010L\u001a\u00020!2\b\b\u0002\u0010M\u001a\u00020!2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020\u00052\b\b\u0002\u0010Q\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u00052\b\b\u0002\u0010S\u001a\u00020\u00052\b\b\u0002\u0010T\u001a\u00020\u00052\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010V\u001a\u00020\u00052\b\b\u0002\u0010W\u001a\u00020!2\b\b\u0002\u0010X\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u00052\b\b\u0002\u0010Z\u001a\u00020!2\b\b\u0002\u0010[\u001a\u00020!2\b\b\u0002\u0010\\\u001a\u00020\u00052\b\b\u0002\u0010]\u001a\u00020\u00052\b\b\u0002\u0010^\u001a\u00020\u00052\b\b\u0002\u0010_\u001a\u00020\u00052\b\b\u0002\u0010`\u001a\u00020\u00052\b\b\u0002\u0010a\u001a\u00020\u00052\b\b\u0002\u0010b\u001a\u00020\u00052\b\b\u0002\u0010c\u001a\u00020\u00052\b\b\u0002\u0010d\u001a\u00020\u00052\b\b\u0002\u0010e\u001a\u00020!2\b\b\u0002\u0010f\u001a\u00020!2\b\b\u0002\u0010g\u001a\u00020\u00052\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010i\u001a\u00020\u00052\b\b\u0002\u0010j\u001a\u00020\u0005HÆ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010n\"\u0004\br\u0010pR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010t\"\u0004\bx\u0010vR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010t\"\u0004\bz\u0010vR\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010t\"\u0004\b|\u0010vR\u001c\u0010\r\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010t\"\u0004\b~\u0010vR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010t\"\u0005\b\u0080\u0001\u0010vR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001e\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001e\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u0086\u0001\"\u0006\b\u008a\u0001\u0010\u0088\u0001R\u001e\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0086\u0001\"\u0006\b\u008c\u0001\u0010\u0088\u0001R\u001e\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u0086\u0001\"\u0006\b\u008e\u0001\u0010\u0088\u0001R\u001e\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0086\u0001\"\u0006\b\u0090\u0001\u0010\u0088\u0001R\u001e\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0086\u0001\"\u0006\b\u0092\u0001\u0010\u0088\u0001R\u001e\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0086\u0001\"\u0006\b\u0094\u0001\u0010\u0088\u0001R\u001e\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0086\u0001\"\u0006\b\u0096\u0001\u0010\u0088\u0001R\u001e\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0086\u0001\"\u0006\b\u0098\u0001\u0010\u0088\u0001R\u001e\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u0086\u0001\"\u0006\b\u009a\u0001\u0010\u0088\u0001R\u001e\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u0086\u0001\"\u0006\b\u009c\u0001\u0010\u0088\u0001R\u001e\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0086\u0001\"\u0006\b\u009e\u0001\u0010\u0088\u0001R\u001e\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010\u0086\u0001\"\u0006\b \u0001\u0010\u0088\u0001R\u001e\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010\u0086\u0001\"\u0006\b¢\u0001\u0010\u0088\u0001R\u001e\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u001e\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0001\u0010\u0086\u0001\"\u0006\b¨\u0001\u0010\u0088\u0001R\u001e\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010\u0086\u0001\"\u0006\bª\u0001\u0010\u0088\u0001R\u001e\u0010$\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0001\u0010\u0086\u0001\"\u0006\b¬\u0001\u0010\u0088\u0001R\u001e\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0001\u0010\u0086\u0001\"\u0006\b®\u0001\u0010\u0088\u0001R\u001e\u0010&\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010\u0086\u0001\"\u0006\b°\u0001\u0010\u0088\u0001R\u001e\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b±\u0001\u0010\u0086\u0001\"\u0006\b²\u0001\u0010\u0088\u0001R\u001e\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b³\u0001\u0010\u0086\u0001\"\u0006\b´\u0001\u0010\u0088\u0001R&\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010\u0082\u0001\"\u0006\b¶\u0001\u0010\u0084\u0001R&\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010\u0082\u0001\"\u0006\b¸\u0001\u0010\u0084\u0001R&\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010\u0082\u0001\"\u0006\bº\u0001\u0010\u0084\u0001R \u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R \u00100\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¿\u0001\u0010¼\u0001\"\u0006\bÀ\u0001\u0010¾\u0001R \u00101\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010¼\u0001\"\u0006\bÂ\u0001\u0010¾\u0001R \u00102\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÃ\u0001\u0010¼\u0001\"\u0006\bÄ\u0001\u0010¾\u0001R \u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R\u001e\u00105\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R\u001e\u00106\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÍ\u0001\u0010\u0086\u0001\"\u0006\bÎ\u0001\u0010\u0088\u0001R\u001e\u00107\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÏ\u0001\u0010\u0086\u0001\"\u0006\bÐ\u0001\u0010\u0088\u0001R\u001e\u00108\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010\u0086\u0001\"\u0006\bÒ\u0001\u0010\u0088\u0001R\u001e\u00109\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÓ\u0001\u0010\u0086\u0001\"\u0006\bÔ\u0001\u0010\u0088\u0001R\u001e\u0010:\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÕ\u0001\u0010\u0086\u0001\"\u0006\bÖ\u0001\u0010\u0088\u0001R\u001e\u0010;\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b×\u0001\u0010\u0086\u0001\"\u0006\bØ\u0001\u0010\u0088\u0001R\u001e\u0010<\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÙ\u0001\u0010\u0086\u0001\"\u0006\bÚ\u0001\u0010\u0088\u0001R\u001e\u0010=\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÛ\u0001\u0010\u0086\u0001\"\u0006\bÜ\u0001\u0010\u0088\u0001R\u001e\u0010>\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÝ\u0001\u0010\u0086\u0001\"\u0006\bÞ\u0001\u0010\u0088\u0001R\u001e\u0010?\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bß\u0001\u0010\u0086\u0001\"\u0006\bà\u0001\u0010\u0088\u0001R\u001e\u0010@\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bá\u0001\u0010\u0086\u0001\"\u0006\bâ\u0001\u0010\u0088\u0001R&\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bã\u0001\u0010\u0082\u0001\"\u0006\bä\u0001\u0010\u0084\u0001R\u001d\u0010B\u001a\u00020!X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bB\u0010¤\u0001\"\u0006\bå\u0001\u0010¦\u0001R\u001e\u0010C\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bæ\u0001\u0010\u0086\u0001\"\u0006\bç\u0001\u0010\u0088\u0001R&\u0010D\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bè\u0001\u0010\u0082\u0001\"\u0006\bé\u0001\u0010\u0084\u0001R&\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bê\u0001\u0010\u0082\u0001\"\u0006\bë\u0001\u0010\u0084\u0001R&\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bì\u0001\u0010\u0082\u0001\"\u0006\bí\u0001\u0010\u0084\u0001R&\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bî\u0001\u0010\u0082\u0001\"\u0006\bï\u0001\u0010\u0084\u0001R\u001e\u0010J\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bð\u0001\u0010\u0086\u0001\"\u0006\bñ\u0001\u0010\u0088\u0001R\u001e\u0010K\u001a\u00020!X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bò\u0001\u0010¤\u0001\"\u0006\bó\u0001\u0010¦\u0001R\u001e\u0010L\u001a\u00020!X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0001\u0010¤\u0001\"\u0006\bõ\u0001\u0010¦\u0001R\u001e\u0010M\u001a\u00020!X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bö\u0001\u0010¤\u0001\"\u0006\b÷\u0001\u0010¦\u0001R\u001e\u0010N\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bø\u0001\u0010\u0086\u0001\"\u0006\bù\u0001\u0010\u0088\u0001R\u001e\u0010O\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bú\u0001\u0010\u0086\u0001\"\u0006\bû\u0001\u0010\u0088\u0001R\u001e\u0010P\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bü\u0001\u0010\u0086\u0001\"\u0006\bý\u0001\u0010\u0088\u0001R\u001e\u0010Q\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bþ\u0001\u0010\u0086\u0001\"\u0006\bÿ\u0001\u0010\u0088\u0001R\u001e\u0010R\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0002\u0010\u0086\u0001\"\u0006\b\u0081\u0002\u0010\u0088\u0001R\u001e\u0010S\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0002\u0010\u0086\u0001\"\u0006\b\u0083\u0002\u0010\u0088\u0001R\u001e\u0010T\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0002\u0010\u0086\u0001\"\u0006\b\u0085\u0002\u0010\u0088\u0001R \u0010U\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002\"\u0006\b\u0088\u0002\u0010\u0089\u0002R\u001e\u0010V\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0002\u0010\u0086\u0001\"\u0006\b\u008b\u0002\u0010\u0088\u0001R\u001d\u0010W\u001a\u00020!X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bW\u0010¤\u0001\"\u0006\b\u008c\u0002\u0010¦\u0001R\u001e\u0010X\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0002\u0010\u0086\u0001\"\u0006\b\u008e\u0002\u0010\u0088\u0001R\u001e\u0010Y\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008f\u0002\u0010\u0086\u0001\"\u0006\b\u0090\u0002\u0010\u0088\u0001R\u001d\u0010Z\u001a\u00020!X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bZ\u0010¤\u0001\"\u0006\b\u0091\u0002\u0010¦\u0001R\u001d\u0010[\u001a\u00020!X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b[\u0010¤\u0001\"\u0006\b\u0092\u0002\u0010¦\u0001R\u001e\u0010\\\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0002\u0010\u0086\u0001\"\u0006\b\u0094\u0002\u0010\u0088\u0001R\u001e\u0010]\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0002\u0010\u0086\u0001\"\u0006\b\u0096\u0002\u0010\u0088\u0001R\u001e\u0010^\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0002\u0010\u0086\u0001\"\u0006\b\u0098\u0002\u0010\u0088\u0001R\u001e\u0010_\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0002\u0010\u0086\u0001\"\u0006\b\u009a\u0002\u0010\u0088\u0001R\u001e\u0010`\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0002\u0010\u0086\u0001\"\u0006\b\u009c\u0002\u0010\u0088\u0001R\u001e\u0010a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0002\u0010\u0086\u0001\"\u0006\b\u009e\u0002\u0010\u0088\u0001R\u001e\u0010b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0002\u0010\u0086\u0001\"\u0006\b \u0002\u0010\u0088\u0001R\u001e\u0010c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0002\u0010\u0086\u0001\"\u0006\b¢\u0002\u0010\u0088\u0001R\u001e\u0010d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0002\u0010\u0086\u0001\"\u0006\b¤\u0002\u0010\u0088\u0001R\u001d\u0010e\u001a\u00020!X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\be\u0010¤\u0001\"\u0006\b¥\u0002\u0010¦\u0001R\u001d\u0010f\u001a\u00020!X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bf\u0010¤\u0001\"\u0006\b¦\u0002\u0010¦\u0001R\u001e\u0010g\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b§\u0002\u0010\u0086\u0001\"\u0006\b¨\u0002\u0010\u0088\u0001R \u0010h\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0002\u0010\u0087\u0002\"\u0006\bª\u0002\u0010\u0089\u0002R\u001e\u0010i\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b«\u0002\u0010\u0086\u0001\"\u0006\b¬\u0002\u0010\u0088\u0001R\u001e\u0010j\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u00ad\u0002\u0010\u0086\u0001\"\u0006\b®\u0002\u0010\u0088\u0001R\u000f\u0010¯\u0002\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010°\u0002\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010±\u0002\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010²\u0002\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010³\u0002\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0002\u0010Ê\u0001\"\u0006\bµ\u0002\u0010Ì\u0001R2\u0010·\u0002\u001a\u00020\u00052\u0007\u0010¶\u0002\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u0018\u0012\u0006\b¸\u0002\u0010¹\u0002\u001a\u0006\bº\u0002\u0010\u0086\u0001\"\u0006\b»\u0002\u0010\u0088\u0001R\u001f\u0010¼\u0002\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0002\u0010Ê\u0001\"\u0006\b¾\u0002\u0010Ì\u0001R2\u0010¿\u0002\u001a\u00020\u00052\u0007\u0010¶\u0002\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u0018\u0012\u0006\bÀ\u0002\u0010¹\u0002\u001a\u0006\bÁ\u0002\u0010\u0086\u0001\"\u0006\bÂ\u0002\u0010\u0088\u0001R\u001f\u0010Ã\u0002\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0002\u0010Ê\u0001\"\u0006\bÅ\u0002\u0010Ì\u0001R2\u0010Æ\u0002\u001a\u00020\u00052\u0007\u0010¶\u0002\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u0018\u0012\u0006\bÇ\u0002\u0010¹\u0002\u001a\u0006\bÈ\u0002\u0010\u0086\u0001\"\u0006\bÉ\u0002\u0010\u0088\u0001R\u001f\u0010Ê\u0002\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bË\u0002\u0010Ê\u0001\"\u0006\bÌ\u0002\u0010Ì\u0001R2\u0010Í\u0002\u001a\u00020\u00052\u0007\u0010¶\u0002\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u0018\u0012\u0006\bÎ\u0002\u0010¹\u0002\u001a\u0006\bÏ\u0002\u0010\u0086\u0001\"\u0006\bÐ\u0002\u0010\u0088\u0001¨\u0006®\u0003"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO;", "Lcom/oplus/melody/common/data/BaseBean;", "leAudioConnectionStateMap", "", "", "", "leAudioConnectionTimeMap", "", "boxBatteryStatus", "Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;", "leftBatteryStatus", "rightBatteryStatus", "headsetBoxBatteryStatus", "headsetLeftBatteryStatus", "headsetRightBatteryStatus", "headsetVersionList", "", "Lcom/oplus/melody/model/repository/earphone/DeviceVersionDTO;", "headsetActive", "a2dpActive", "leActive", "pairingState", "noiseReductionModeIndex", "intelligentNoiseReductionModeIndex", "wearDetectionStatus", "vocalEnhanceStatus", "personalNoiseStatus", "hearingEnhanceUsageStatus", "clickToTakePhotoStatus", "headsetSoundRecordStatus", "eqType", "multiConnectStatus", "supportMultiDeviceConnect", "", "zenModeStatus", "hiQualityAudioStatus", "longPowerModeStatus", "freeDialogStatus", "voiceAssistStatus", "voiceCommandStatus", "voiceIncomingCallControlStatus", "deviceVersionList", "keyFunctionInfoList", "Lcom/oplus/melody/model/repository/earphone/KeyFunctionInfoDTO;", "multiDevicesConnectInfos", "Lcom/oplus/melody/btsdk/api/data/MultiConnectInformationElement;", "switchNoiseReductionInfo", "Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;", "switchLeftEarNoiseReductionInfo", "switchRightEarNoiseReductionInfo", "supportNoiseReductionInfo", "earStatus", "Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;", "earStatusReceivedMillis", "fullDialogRecoveryTime", "safeRemindStatus", "gameModeStatus", "spatialSoundStatus", "autoVolumeStatus", "bassEngineStatus", "spineLiveMonitorStatus", "spineCervicalStatus", "spineExerciseStatus", "saveLogStatus", "gameEqualizerStatus", "capability", "isCapabilityReady", "codecType", "earTones", "Lcom/oplus/melody/model/repository/earphone/EarToneDTO;", "codecList", "spineRangeDetection", "", "spineCalibrationResult", "spineCalibrateState", "supportCustomEq", "supportSmartBluetooth", "supportBindAccount", "headsetSpatialType", "phoneSpatialType", "aiSummaryType", "aiTranslationAppStatus", "volumeValueInfo", "tapLevelSettingValue", "tapLevelDefaultValue", "accountKey", "gameSoundStatus", "isVersionListReceived", "sppOverGattConnectionState", "gameModeMainStatus", "isDeviceBonded", "isInitCmdCompleted", "adaptiveVolume", "adaptiveEar", "speechPerception", "micControl", "longPressVolume", "swiftPair", HeadMotionItem.ITEM_NAME, "headMotionType", "sleepDetection", "isConnectedShown", "isInitialized", "hearingOptimizeStatus", "boxSn", "oneEarNoiseReduceMode", "bothEarNoiseReduceMode", "<init>", "(Ljava/util/Map;Ljava/util/Map;Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;Ljava/util/List;IIIIIIIIIIIIIIZIIIIIIILjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;JIIIIIIIIIIILjava/util/List;ZILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;IZZZIIIIIIILjava/lang/String;IZIIZZIIIIIIIIIZZILjava/lang/String;II)V", "getLeAudioConnectionStateMap", "()Ljava/util/Map;", "setLeAudioConnectionStateMap", "(Ljava/util/Map;)V", "getLeAudioConnectionTimeMap", "setLeAudioConnectionTimeMap", "getBoxBatteryStatus", "()Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;", "setBoxBatteryStatus", "(Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;)V", "getLeftBatteryStatus", "setLeftBatteryStatus", "getRightBatteryStatus", "setRightBatteryStatus", "getHeadsetBoxBatteryStatus", "setHeadsetBoxBatteryStatus", "getHeadsetLeftBatteryStatus", "setHeadsetLeftBatteryStatus", "getHeadsetRightBatteryStatus", "setHeadsetRightBatteryStatus", "getHeadsetVersionList", "()Ljava/util/List;", "setHeadsetVersionList", "(Ljava/util/List;)V", "getHeadsetActive", "()I", "setHeadsetActive", "(I)V", "getA2dpActive", "setA2dpActive", "getLeActive", "setLeActive", "getPairingState", "setPairingState", "getNoiseReductionModeIndex", "setNoiseReductionModeIndex", "getIntelligentNoiseReductionModeIndex", "setIntelligentNoiseReductionModeIndex", "getWearDetectionStatus", "setWearDetectionStatus", "getVocalEnhanceStatus", "setVocalEnhanceStatus", "getPersonalNoiseStatus", "setPersonalNoiseStatus", "getHearingEnhanceUsageStatus", "setHearingEnhanceUsageStatus", "getClickToTakePhotoStatus", "setClickToTakePhotoStatus", "getHeadsetSoundRecordStatus", "setHeadsetSoundRecordStatus", "getEqType", "setEqType", "getMultiConnectStatus", "setMultiConnectStatus", "getSupportMultiDeviceConnect", "()Z", "setSupportMultiDeviceConnect", "(Z)V", "getZenModeStatus", "setZenModeStatus", "getHiQualityAudioStatus", "setHiQualityAudioStatus", "getLongPowerModeStatus", "setLongPowerModeStatus", "getFreeDialogStatus", "setFreeDialogStatus", "getVoiceAssistStatus", "setVoiceAssistStatus", "getVoiceCommandStatus", "setVoiceCommandStatus", "getVoiceIncomingCallControlStatus", "setVoiceIncomingCallControlStatus", "getDeviceVersionList", "setDeviceVersionList", "getKeyFunctionInfoList", "setKeyFunctionInfoList", "getMultiDevicesConnectInfos", "setMultiDevicesConnectInfos", "getSwitchNoiseReductionInfo", "()Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;", "setSwitchNoiseReductionInfo", "(Lcom/oplus/melody/model/repository/earphone/NoiseReductionInfoDTO;)V", "getSwitchLeftEarNoiseReductionInfo", "setSwitchLeftEarNoiseReductionInfo", "getSwitchRightEarNoiseReductionInfo", "setSwitchRightEarNoiseReductionInfo", "getSupportNoiseReductionInfo", "setSupportNoiseReductionInfo", "getEarStatus", "()Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;", "setEarStatus", "(Lcom/oplus/melody/model/repository/earphone/EarStatusDTO;)V", "getEarStatusReceivedMillis", "()J", "setEarStatusReceivedMillis", "(J)V", "getFullDialogRecoveryTime", "setFullDialogRecoveryTime", "getSafeRemindStatus", "setSafeRemindStatus", "getGameModeStatus", "setGameModeStatus", "getSpatialSoundStatus", "setSpatialSoundStatus", "getAutoVolumeStatus", "setAutoVolumeStatus", "getBassEngineStatus", "setBassEngineStatus", "getSpineLiveMonitorStatus", "setSpineLiveMonitorStatus", "getSpineCervicalStatus", "setSpineCervicalStatus", "getSpineExerciseStatus", "setSpineExerciseStatus", "getSaveLogStatus", "setSaveLogStatus", "getGameEqualizerStatus", "setGameEqualizerStatus", "getCapability", "setCapability", "setCapabilityReady", "getCodecType", "setCodecType", "getEarTones", "setEarTones", "getCodecList", "setCodecList", "getSpineRangeDetection", "setSpineRangeDetection", "getSpineCalibrationResult", "setSpineCalibrationResult", "getSpineCalibrateState", "setSpineCalibrateState", "getSupportCustomEq", "setSupportCustomEq", "getSupportSmartBluetooth", "setSupportSmartBluetooth", "getSupportBindAccount", "setSupportBindAccount", "getHeadsetSpatialType", "setHeadsetSpatialType", "getPhoneSpatialType", "setPhoneSpatialType", "getAiSummaryType", "setAiSummaryType", "getAiTranslationAppStatus", "setAiTranslationAppStatus", "getVolumeValueInfo", "setVolumeValueInfo", "getTapLevelSettingValue", "setTapLevelSettingValue", "getTapLevelDefaultValue", "setTapLevelDefaultValue", "getAccountKey", "()Ljava/lang/String;", "setAccountKey", "(Ljava/lang/String;)V", "getGameSoundStatus", "setGameSoundStatus", "setVersionListReceived", "getSppOverGattConnectionState", "setSppOverGattConnectionState", "getGameModeMainStatus", "setGameModeMainStatus", "setDeviceBonded", "setInitCmdCompleted", "getAdaptiveVolume", "setAdaptiveVolume", "getAdaptiveEar", "setAdaptiveEar", "getSpeechPerception", "setSpeechPerception", "getMicControl", "setMicControl", "getLongPressVolume", "setLongPressVolume", "getSwiftPair", "setSwiftPair", "getHeadMotion", "setHeadMotion", "getHeadMotionType", "setHeadMotionType", "getSleepDetection", "setSleepDetection", "setConnectedShown", "setInitialized", "getHearingOptimizeStatus", "setHearingOptimizeStatus", "getBoxSn", "setBoxSn", "getOneEarNoiseReduceMode", "setOneEarNoiseReduceMode", "getBothEarNoiseReduceMode", "setBothEarNoiseReduceMode", "mAclConnectState", "mHeadsetConnectionState", "mA2dpConnectionState", "mConnectionState", "sppConnectionTime", "getSppConnectionTime", "setSppConnectionTime", "state", "connectionState", "getConnectionState$annotations", "()V", "getConnectionState", "setConnectionState", "aclConnectionTime", "getAclConnectionTime", "setAclConnectionTime", "aclConnectionState", "getAclConnectionState$annotations", "getAclConnectionState", "setAclConnectionState", "headsetConnectionTime", "getHeadsetConnectionTime", "setHeadsetConnectionTime", "headsetConnectionState", "getHeadsetConnectionState$annotations", "getHeadsetConnectionState", "setHeadsetConnectionState", "a2dpConnectionTime", "getA2dpConnectionTime", "setA2dpConnectionTime", "a2dpConnectionState", "getA2dpConnectionState$annotations", "getA2dpConnectionState", "setA2dpConnectionState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "copy", "BatteryStatus", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EarphoneStatusDO extends com.oplus.melody.common.data.a {
    private int a2dpActive;
    private long a2dpConnectionTime;
    private String accountKey;
    private long aclConnectionTime;
    private int adaptiveEar;
    private int adaptiveVolume;
    private int aiSummaryType;
    private int aiTranslationAppStatus;
    private int autoVolumeStatus;
    private int bassEngineStatus;
    private int bothEarNoiseReduceMode;
    private a boxBatteryStatus;
    private String boxSn;
    private List<Integer> capability;
    private int clickToTakePhotoStatus;
    private List<Integer> codecList;
    private int codecType;
    private List<DeviceVersionDTO> deviceVersionList;
    private EarStatusDTO earStatus;
    private long earStatusReceivedMillis;
    private List<EarToneDTO> earTones;
    private int eqType;
    private int freeDialogStatus;
    private int fullDialogRecoveryTime;
    private int gameEqualizerStatus;
    private int gameModeMainStatus;
    private int gameModeStatus;
    private int gameSoundStatus;
    private int headMotion;
    private int headMotionType;
    private int headsetActive;
    private a headsetBoxBatteryStatus;
    private long headsetConnectionTime;
    private a headsetLeftBatteryStatus;
    private a headsetRightBatteryStatus;
    private int headsetSoundRecordStatus;
    private int headsetSpatialType;
    private List<DeviceVersionDTO> headsetVersionList;
    private int hearingEnhanceUsageStatus;
    private int hearingOptimizeStatus;
    private int hiQualityAudioStatus;
    private int intelligentNoiseReductionModeIndex;
    private boolean isCapabilityReady;
    private boolean isConnectedShown;
    private boolean isDeviceBonded;
    private boolean isInitCmdCompleted;
    private boolean isInitialized;
    private boolean isVersionListReceived;
    private List<KeyFunctionInfoDTO> keyFunctionInfoList;
    private int leActive;
    private Map<String, Integer> leAudioConnectionStateMap;
    private Map<String, Long> leAudioConnectionTimeMap;
    private a leftBatteryStatus;
    private int longPowerModeStatus;
    private int longPressVolume;
    private int mA2dpConnectionState;
    private int mAclConnectState;
    private int mConnectionState;
    private int mHeadsetConnectionState;
    private int micControl;
    private int multiConnectStatus;
    private List<MultiConnectInformationElement> multiDevicesConnectInfos;
    private int noiseReductionModeIndex;
    private int oneEarNoiseReduceMode;
    private int pairingState;
    private int personalNoiseStatus;
    private int phoneSpatialType;
    private a rightBatteryStatus;
    private int safeRemindStatus;
    private int saveLogStatus;
    private int sleepDetection;
    private int spatialSoundStatus;
    private int speechPerception;
    private int spineCalibrateState;
    private List<Integer> spineCalibrationResult;
    private int spineCervicalStatus;
    private int spineExerciseStatus;
    private int spineLiveMonitorStatus;
    private List<Float> spineRangeDetection;
    private long sppConnectionTime;
    private int sppOverGattConnectionState;
    private boolean supportBindAccount;
    private boolean supportCustomEq;
    private boolean supportMultiDeviceConnect;
    private NoiseReductionInfoDTO supportNoiseReductionInfo;
    private boolean supportSmartBluetooth;
    private int swiftPair;
    private NoiseReductionInfoDTO switchLeftEarNoiseReductionInfo;
    private NoiseReductionInfoDTO switchNoiseReductionInfo;
    private NoiseReductionInfoDTO switchRightEarNoiseReductionInfo;
    private int tapLevelDefaultValue;
    private int tapLevelSettingValue;
    private int vocalEnhanceStatus;
    private int voiceAssistStatus;
    private int voiceCommandStatus;
    private int voiceIncomingCallControlStatus;
    private int volumeValueInfo;
    private int wearDetectionStatus;
    private int zenModeStatus;

    /* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.M$a */
    /* JADX INFO: compiled from: EarphoneStatusDO.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/EarphoneStatusDO$BatteryStatus;", "Lcom/oplus/melody/common/data/BaseBean;", "battery", "", "isCharging", "", "<init>", "(IZ)V", "getBattery", "()I", "setBattery", "(I)V", "()Z", "setCharging", "(Z)V", "component1", "component2", "copy", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class a extends com.oplus.melody.common.data.a {
        private int battery;
        private boolean isCharging;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(0, 0 == true ? 1 : 0, 3, null);
        }

        public static /* synthetic */ a copy$default(a aVar, int i10, boolean z2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = aVar.battery;
            }
            if ((i11 & 2) != 0) {
                z2 = aVar.isCharging;
            }
            return aVar.copy(i10, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getBattery() {
            return this.battery;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsCharging() {
            return this.isCharging;
        }

        public final a copy(int i10, boolean z2) {
            return new a(i10, z2);
        }

        public final int getBattery() {
            return this.battery;
        }

        public final boolean isCharging() {
            return this.isCharging;
        }

        public final void setBattery(int i10) {
            this.battery = i10;
        }

        public final void setCharging(boolean z2) {
            this.isCharging = z2;
        }

        public a(int i10, boolean z2) {
            this.battery = i10;
            this.isCharging = z2;
        }

        public /* synthetic */ a(int i10, boolean z2, int i11, kotlin.jvm.internal.d dVar) {
            this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? false : z2);
        }
    }

    public EarphoneStatusDO() {
        this(null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false, 0, null, null, null, null, 0, false, false, false, 0, 0, 0, 0, 0, 0, 0, null, 0, false, 0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, null, 0, 0, -1, -1, 134217727, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EarphoneStatusDO copy$default(EarphoneStatusDO earphoneStatusDO, Map map, Map map2, a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, List list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, boolean z2, int i24, int i25, int i26, int i27, int i28, int i29, int i30, List list2, List list3, List list4, NoiseReductionInfoDTO noiseReductionInfoDTO, NoiseReductionInfoDTO noiseReductionInfoDTO2, NoiseReductionInfoDTO noiseReductionInfoDTO3, NoiseReductionInfoDTO noiseReductionInfoDTO4, EarStatusDTO earStatusDTO, long j5, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, List list5, boolean z4, int i42, List list6, List list7, List list8, List list9, int i43, boolean z10, boolean z11, boolean z12, int i44, int i45, int i46, int i47, int i48, int i49, int i50, String str, int i51, boolean z13, int i52, int i53, boolean z14, boolean z15, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, int i62, boolean z16, boolean z17, int i63, String str2, int i64, int i65, int i66, int i67, int i68, Object obj) {
        int i69;
        Map map3;
        long j9;
        Map map4 = (i66 & 1) != 0 ? earphoneStatusDO.leAudioConnectionStateMap : map;
        Map map5 = (i66 & 2) != 0 ? earphoneStatusDO.leAudioConnectionTimeMap : map2;
        a aVar7 = (i66 & 4) != 0 ? earphoneStatusDO.boxBatteryStatus : aVar;
        a aVar8 = (i66 & 8) != 0 ? earphoneStatusDO.leftBatteryStatus : aVar2;
        a aVar9 = (i66 & 16) != 0 ? earphoneStatusDO.rightBatteryStatus : aVar3;
        a aVar10 = (i66 & 32) != 0 ? earphoneStatusDO.headsetBoxBatteryStatus : aVar4;
        a aVar11 = (i66 & 64) != 0 ? earphoneStatusDO.headsetLeftBatteryStatus : aVar5;
        a aVar12 = (i66 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? earphoneStatusDO.headsetRightBatteryStatus : aVar6;
        List list10 = (i66 & 256) != 0 ? earphoneStatusDO.headsetVersionList : list;
        int i70 = (i66 & 512) != 0 ? earphoneStatusDO.headsetActive : i10;
        int i71 = (i66 & 1024) != 0 ? earphoneStatusDO.a2dpActive : i11;
        int i72 = (i66 & 2048) != 0 ? earphoneStatusDO.leActive : i12;
        Map map6 = map4;
        int i73 = (i66 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? earphoneStatusDO.pairingState : i13;
        int i74 = (i66 & 8192) != 0 ? earphoneStatusDO.noiseReductionModeIndex : i14;
        int i75 = (i66 & 16384) != 0 ? earphoneStatusDO.intelligentNoiseReductionModeIndex : i15;
        int i76 = (i66 & 32768) != 0 ? earphoneStatusDO.wearDetectionStatus : i16;
        int i77 = (i66 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? earphoneStatusDO.vocalEnhanceStatus : i17;
        int i78 = (i66 & 131072) != 0 ? earphoneStatusDO.personalNoiseStatus : i18;
        int i79 = (i66 & 262144) != 0 ? earphoneStatusDO.hearingEnhanceUsageStatus : i19;
        int i80 = (i66 & 524288) != 0 ? earphoneStatusDO.clickToTakePhotoStatus : i20;
        int i81 = (i66 & 1048576) != 0 ? earphoneStatusDO.headsetSoundRecordStatus : i21;
        int i82 = (i66 & 2097152) != 0 ? earphoneStatusDO.eqType : i22;
        int i83 = (i66 & 4194304) != 0 ? earphoneStatusDO.multiConnectStatus : i23;
        boolean z18 = (i66 & 8388608) != 0 ? earphoneStatusDO.supportMultiDeviceConnect : z2;
        int i84 = (i66 & 16777216) != 0 ? earphoneStatusDO.zenModeStatus : i24;
        int i85 = (i66 & 33554432) != 0 ? earphoneStatusDO.hiQualityAudioStatus : i25;
        int i86 = (i66 & 67108864) != 0 ? earphoneStatusDO.longPowerModeStatus : i26;
        int i87 = (i66 & 134217728) != 0 ? earphoneStatusDO.freeDialogStatus : i27;
        int i88 = (i66 & 268435456) != 0 ? earphoneStatusDO.voiceAssistStatus : i28;
        int i89 = (i66 & 536870912) != 0 ? earphoneStatusDO.voiceCommandStatus : i29;
        int i90 = (i66 & 1073741824) != 0 ? earphoneStatusDO.voiceIncomingCallControlStatus : i30;
        List list11 = (i66 & Integer.MIN_VALUE) != 0 ? earphoneStatusDO.deviceVersionList : list2;
        List list12 = (i67 & 1) != 0 ? earphoneStatusDO.keyFunctionInfoList : list3;
        List list13 = (i67 & 2) != 0 ? earphoneStatusDO.multiDevicesConnectInfos : list4;
        NoiseReductionInfoDTO noiseReductionInfoDTO5 = (i67 & 4) != 0 ? earphoneStatusDO.switchNoiseReductionInfo : noiseReductionInfoDTO;
        NoiseReductionInfoDTO noiseReductionInfoDTO6 = (i67 & 8) != 0 ? earphoneStatusDO.switchLeftEarNoiseReductionInfo : noiseReductionInfoDTO2;
        NoiseReductionInfoDTO noiseReductionInfoDTO7 = (i67 & 16) != 0 ? earphoneStatusDO.switchRightEarNoiseReductionInfo : noiseReductionInfoDTO3;
        NoiseReductionInfoDTO noiseReductionInfoDTO8 = (i67 & 32) != 0 ? earphoneStatusDO.supportNoiseReductionInfo : noiseReductionInfoDTO4;
        EarStatusDTO earStatusDTO2 = (i67 & 64) != 0 ? earphoneStatusDO.earStatus : earStatusDTO;
        if ((i67 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0) {
            i69 = i75;
            map3 = map5;
            j9 = earphoneStatusDO.earStatusReceivedMillis;
        } else {
            i69 = i75;
            map3 = map5;
            j9 = j5;
        }
        return earphoneStatusDO.copy(map6, map3, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, list10, i70, i71, i72, i73, i74, i69, i76, i77, i78, i79, i80, i81, i82, i83, z18, i84, i85, i86, i87, i88, i89, i90, list11, list12, list13, noiseReductionInfoDTO5, noiseReductionInfoDTO6, noiseReductionInfoDTO7, noiseReductionInfoDTO8, earStatusDTO2, j9, (i67 & 256) != 0 ? earphoneStatusDO.fullDialogRecoveryTime : i31, (i67 & 512) != 0 ? earphoneStatusDO.safeRemindStatus : i32, (i67 & 1024) != 0 ? earphoneStatusDO.gameModeStatus : i33, (i67 & 2048) != 0 ? earphoneStatusDO.spatialSoundStatus : i34, (i67 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? earphoneStatusDO.autoVolumeStatus : i35, (i67 & 8192) != 0 ? earphoneStatusDO.bassEngineStatus : i36, (i67 & 16384) != 0 ? earphoneStatusDO.spineLiveMonitorStatus : i37, (i67 & 32768) != 0 ? earphoneStatusDO.spineCervicalStatus : i38, (i67 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? earphoneStatusDO.spineExerciseStatus : i39, (i67 & 131072) != 0 ? earphoneStatusDO.saveLogStatus : i40, (i67 & 262144) != 0 ? earphoneStatusDO.gameEqualizerStatus : i41, (i67 & 524288) != 0 ? earphoneStatusDO.capability : list5, (i67 & 1048576) != 0 ? earphoneStatusDO.isCapabilityReady : z4, (i67 & 2097152) != 0 ? earphoneStatusDO.codecType : i42, (i67 & 4194304) != 0 ? earphoneStatusDO.earTones : list6, (i67 & 8388608) != 0 ? earphoneStatusDO.codecList : list7, (i67 & 16777216) != 0 ? earphoneStatusDO.spineRangeDetection : list8, (i67 & 33554432) != 0 ? earphoneStatusDO.spineCalibrationResult : list9, (i67 & 67108864) != 0 ? earphoneStatusDO.spineCalibrateState : i43, (i67 & 134217728) != 0 ? earphoneStatusDO.supportCustomEq : z10, (i67 & 268435456) != 0 ? earphoneStatusDO.supportSmartBluetooth : z11, (i67 & 536870912) != 0 ? earphoneStatusDO.supportBindAccount : z12, (i67 & 1073741824) != 0 ? earphoneStatusDO.headsetSpatialType : i44, (i67 & Integer.MIN_VALUE) != 0 ? earphoneStatusDO.phoneSpatialType : i45, (i68 & 1) != 0 ? earphoneStatusDO.aiSummaryType : i46, (i68 & 2) != 0 ? earphoneStatusDO.aiTranslationAppStatus : i47, (i68 & 4) != 0 ? earphoneStatusDO.volumeValueInfo : i48, (i68 & 8) != 0 ? earphoneStatusDO.tapLevelSettingValue : i49, (i68 & 16) != 0 ? earphoneStatusDO.tapLevelDefaultValue : i50, (i68 & 32) != 0 ? earphoneStatusDO.accountKey : str, (i68 & 64) != 0 ? earphoneStatusDO.gameSoundStatus : i51, (i68 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? earphoneStatusDO.isVersionListReceived : z13, (i68 & 256) != 0 ? earphoneStatusDO.sppOverGattConnectionState : i52, (i68 & 512) != 0 ? earphoneStatusDO.gameModeMainStatus : i53, (i68 & 1024) != 0 ? earphoneStatusDO.isDeviceBonded : z14, (i68 & 2048) != 0 ? earphoneStatusDO.isInitCmdCompleted : z15, (i68 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? earphoneStatusDO.adaptiveVolume : i54, (i68 & 8192) != 0 ? earphoneStatusDO.adaptiveEar : i55, (i68 & 16384) != 0 ? earphoneStatusDO.speechPerception : i56, (i68 & 32768) != 0 ? earphoneStatusDO.micControl : i57, (i68 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? earphoneStatusDO.longPressVolume : i58, (i68 & 131072) != 0 ? earphoneStatusDO.swiftPair : i59, (i68 & 262144) != 0 ? earphoneStatusDO.headMotion : i60, (i68 & 524288) != 0 ? earphoneStatusDO.headMotionType : i61, (i68 & 1048576) != 0 ? earphoneStatusDO.sleepDetection : i62, (i68 & 2097152) != 0 ? earphoneStatusDO.isConnectedShown : z16, (i68 & 4194304) != 0 ? earphoneStatusDO.isInitialized : z17, (i68 & 8388608) != 0 ? earphoneStatusDO.hearingOptimizeStatus : i63, (i68 & 16777216) != 0 ? earphoneStatusDO.boxSn : str2, (i68 & 33554432) != 0 ? earphoneStatusDO.oneEarNoiseReduceMode : i64, (i68 & 67108864) != 0 ? earphoneStatusDO.bothEarNoiseReduceMode : i65);
    }

    public final Map<String, Integer> component1() {
        return this.leAudioConnectionStateMap;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getHeadsetActive() {
        return this.headsetActive;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getA2dpActive() {
        return this.a2dpActive;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getLeActive() {
        return this.leActive;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getPairingState() {
        return this.pairingState;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getNoiseReductionModeIndex() {
        return this.noiseReductionModeIndex;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getIntelligentNoiseReductionModeIndex() {
        return this.intelligentNoiseReductionModeIndex;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getWearDetectionStatus() {
        return this.wearDetectionStatus;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getVocalEnhanceStatus() {
        return this.vocalEnhanceStatus;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getPersonalNoiseStatus() {
        return this.personalNoiseStatus;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getHearingEnhanceUsageStatus() {
        return this.hearingEnhanceUsageStatus;
    }

    public final Map<String, Long> component2() {
        return this.leAudioConnectionTimeMap;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getClickToTakePhotoStatus() {
        return this.clickToTakePhotoStatus;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getHeadsetSoundRecordStatus() {
        return this.headsetSoundRecordStatus;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getEqType() {
        return this.eqType;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getMultiConnectStatus() {
        return this.multiConnectStatus;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final boolean getSupportMultiDeviceConnect() {
        return this.supportMultiDeviceConnect;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final int getZenModeStatus() {
        return this.zenModeStatus;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getHiQualityAudioStatus() {
        return this.hiQualityAudioStatus;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final int getLongPowerModeStatus() {
        return this.longPowerModeStatus;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final int getFreeDialogStatus() {
        return this.freeDialogStatus;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final int getVoiceAssistStatus() {
        return this.voiceAssistStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final a getBoxBatteryStatus() {
        return this.boxBatteryStatus;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final int getVoiceCommandStatus() {
        return this.voiceCommandStatus;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final int getVoiceIncomingCallControlStatus() {
        return this.voiceIncomingCallControlStatus;
    }

    public final List<DeviceVersionDTO> component32() {
        return this.deviceVersionList;
    }

    public final List<KeyFunctionInfoDTO> component33() {
        return this.keyFunctionInfoList;
    }

    public final List<MultiConnectInformationElement> component34() {
        return this.multiDevicesConnectInfos;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final NoiseReductionInfoDTO getSwitchNoiseReductionInfo() {
        return this.switchNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final NoiseReductionInfoDTO getSwitchLeftEarNoiseReductionInfo() {
        return this.switchLeftEarNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final NoiseReductionInfoDTO getSwitchRightEarNoiseReductionInfo() {
        return this.switchRightEarNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final NoiseReductionInfoDTO getSupportNoiseReductionInfo() {
        return this.supportNoiseReductionInfo;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final EarStatusDTO getEarStatus() {
        return this.earStatus;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final a getLeftBatteryStatus() {
        return this.leftBatteryStatus;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final long getEarStatusReceivedMillis() {
        return this.earStatusReceivedMillis;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final int getFullDialogRecoveryTime() {
        return this.fullDialogRecoveryTime;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final int getSafeRemindStatus() {
        return this.safeRemindStatus;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final int getGameModeStatus() {
        return this.gameModeStatus;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final int getSpatialSoundStatus() {
        return this.spatialSoundStatus;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final int getAutoVolumeStatus() {
        return this.autoVolumeStatus;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final int getBassEngineStatus() {
        return this.bassEngineStatus;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final int getSpineLiveMonitorStatus() {
        return this.spineLiveMonitorStatus;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final int getSpineCervicalStatus() {
        return this.spineCervicalStatus;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final int getSpineExerciseStatus() {
        return this.spineExerciseStatus;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final a getRightBatteryStatus() {
        return this.rightBatteryStatus;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final int getSaveLogStatus() {
        return this.saveLogStatus;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final int getGameEqualizerStatus() {
        return this.gameEqualizerStatus;
    }

    public final List<Integer> component52() {
        return this.capability;
    }

    /* JADX INFO: renamed from: component53, reason: from getter */
    public final boolean getIsCapabilityReady() {
        return this.isCapabilityReady;
    }

    /* JADX INFO: renamed from: component54, reason: from getter */
    public final int getCodecType() {
        return this.codecType;
    }

    public final List<EarToneDTO> component55() {
        return this.earTones;
    }

    public final List<Integer> component56() {
        return this.codecList;
    }

    public final List<Float> component57() {
        return this.spineRangeDetection;
    }

    public final List<Integer> component58() {
        return this.spineCalibrationResult;
    }

    /* JADX INFO: renamed from: component59, reason: from getter */
    public final int getSpineCalibrateState() {
        return this.spineCalibrateState;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final a getHeadsetBoxBatteryStatus() {
        return this.headsetBoxBatteryStatus;
    }

    /* JADX INFO: renamed from: component60, reason: from getter */
    public final boolean getSupportCustomEq() {
        return this.supportCustomEq;
    }

    /* JADX INFO: renamed from: component61, reason: from getter */
    public final boolean getSupportSmartBluetooth() {
        return this.supportSmartBluetooth;
    }

    /* JADX INFO: renamed from: component62, reason: from getter */
    public final boolean getSupportBindAccount() {
        return this.supportBindAccount;
    }

    /* JADX INFO: renamed from: component63, reason: from getter */
    public final int getHeadsetSpatialType() {
        return this.headsetSpatialType;
    }

    /* JADX INFO: renamed from: component64, reason: from getter */
    public final int getPhoneSpatialType() {
        return this.phoneSpatialType;
    }

    /* JADX INFO: renamed from: component65, reason: from getter */
    public final int getAiSummaryType() {
        return this.aiSummaryType;
    }

    /* JADX INFO: renamed from: component66, reason: from getter */
    public final int getAiTranslationAppStatus() {
        return this.aiTranslationAppStatus;
    }

    /* JADX INFO: renamed from: component67, reason: from getter */
    public final int getVolumeValueInfo() {
        return this.volumeValueInfo;
    }

    /* JADX INFO: renamed from: component68, reason: from getter */
    public final int getTapLevelSettingValue() {
        return this.tapLevelSettingValue;
    }

    /* JADX INFO: renamed from: component69, reason: from getter */
    public final int getTapLevelDefaultValue() {
        return this.tapLevelDefaultValue;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final a getHeadsetLeftBatteryStatus() {
        return this.headsetLeftBatteryStatus;
    }

    /* JADX INFO: renamed from: component70, reason: from getter */
    public final String getAccountKey() {
        return this.accountKey;
    }

    /* JADX INFO: renamed from: component71, reason: from getter */
    public final int getGameSoundStatus() {
        return this.gameSoundStatus;
    }

    /* JADX INFO: renamed from: component72, reason: from getter */
    public final boolean getIsVersionListReceived() {
        return this.isVersionListReceived;
    }

    /* JADX INFO: renamed from: component73, reason: from getter */
    public final int getSppOverGattConnectionState() {
        return this.sppOverGattConnectionState;
    }

    /* JADX INFO: renamed from: component74, reason: from getter */
    public final int getGameModeMainStatus() {
        return this.gameModeMainStatus;
    }

    /* JADX INFO: renamed from: component75, reason: from getter */
    public final boolean getIsDeviceBonded() {
        return this.isDeviceBonded;
    }

    /* JADX INFO: renamed from: component76, reason: from getter */
    public final boolean getIsInitCmdCompleted() {
        return this.isInitCmdCompleted;
    }

    /* JADX INFO: renamed from: component77, reason: from getter */
    public final int getAdaptiveVolume() {
        return this.adaptiveVolume;
    }

    /* JADX INFO: renamed from: component78, reason: from getter */
    public final int getAdaptiveEar() {
        return this.adaptiveEar;
    }

    /* JADX INFO: renamed from: component79, reason: from getter */
    public final int getSpeechPerception() {
        return this.speechPerception;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final a getHeadsetRightBatteryStatus() {
        return this.headsetRightBatteryStatus;
    }

    /* JADX INFO: renamed from: component80, reason: from getter */
    public final int getMicControl() {
        return this.micControl;
    }

    /* JADX INFO: renamed from: component81, reason: from getter */
    public final int getLongPressVolume() {
        return this.longPressVolume;
    }

    /* JADX INFO: renamed from: component82, reason: from getter */
    public final int getSwiftPair() {
        return this.swiftPair;
    }

    /* JADX INFO: renamed from: component83, reason: from getter */
    public final int getHeadMotion() {
        return this.headMotion;
    }

    /* JADX INFO: renamed from: component84, reason: from getter */
    public final int getHeadMotionType() {
        return this.headMotionType;
    }

    /* JADX INFO: renamed from: component85, reason: from getter */
    public final int getSleepDetection() {
        return this.sleepDetection;
    }

    /* JADX INFO: renamed from: component86, reason: from getter */
    public final boolean getIsConnectedShown() {
        return this.isConnectedShown;
    }

    /* JADX INFO: renamed from: component87, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    /* JADX INFO: renamed from: component88, reason: from getter */
    public final int getHearingOptimizeStatus() {
        return this.hearingOptimizeStatus;
    }

    /* JADX INFO: renamed from: component89, reason: from getter */
    public final String getBoxSn() {
        return this.boxSn;
    }

    public final List<DeviceVersionDTO> component9() {
        return this.headsetVersionList;
    }

    /* JADX INFO: renamed from: component90, reason: from getter */
    public final int getOneEarNoiseReduceMode() {
        return this.oneEarNoiseReduceMode;
    }

    /* JADX INFO: renamed from: component91, reason: from getter */
    public final int getBothEarNoiseReduceMode() {
        return this.bothEarNoiseReduceMode;
    }

    public final EarphoneStatusDO copy(Map<String, Integer> leAudioConnectionStateMap, Map<String, Long> leAudioConnectionTimeMap, a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, List<DeviceVersionDTO> list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, boolean z2, int i24, int i25, int i26, int i27, int i28, int i29, int i30, List<DeviceVersionDTO> list2, List<KeyFunctionInfoDTO> list3, List<MultiConnectInformationElement> list4, NoiseReductionInfoDTO noiseReductionInfoDTO, NoiseReductionInfoDTO noiseReductionInfoDTO2, NoiseReductionInfoDTO noiseReductionInfoDTO3, NoiseReductionInfoDTO noiseReductionInfoDTO4, EarStatusDTO earStatusDTO, long j5, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, List<Integer> list5, boolean z4, int i42, List<EarToneDTO> list6, List<Integer> list7, List<Float> list8, List<Integer> list9, int i43, boolean z10, boolean z11, boolean z12, int i44, int i45, int i46, int i47, int i48, int i49, int i50, String str, int i51, boolean z13, int i52, int i53, boolean z14, boolean z15, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, int i62, boolean z16, boolean z17, int i63, String str2, int i64, int i65) {
        kotlin.jvm.internal.h.e(leAudioConnectionStateMap, "leAudioConnectionStateMap");
        kotlin.jvm.internal.h.e(leAudioConnectionTimeMap, "leAudioConnectionTimeMap");
        return new EarphoneStatusDO(leAudioConnectionStateMap, leAudioConnectionTimeMap, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, list, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, z2, i24, i25, i26, i27, i28, i29, i30, list2, list3, list4, noiseReductionInfoDTO, noiseReductionInfoDTO2, noiseReductionInfoDTO3, noiseReductionInfoDTO4, earStatusDTO, j5, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, list5, z4, i42, list6, list7, list8, list9, i43, z10, z11, z12, i44, i45, i46, i47, i48, i49, i50, str, i51, z13, i52, i53, z14, z15, i54, i55, i56, i57, i58, i59, i60, i61, i62, z16, z17, i63, str2, i64, i65);
    }

    public final int getA2dpActive() {
        return this.a2dpActive;
    }

    /* JADX INFO: renamed from: getA2dpConnectionState, reason: from getter */
    public final int getMA2dpConnectionState() {
        return this.mA2dpConnectionState;
    }

    public final long getA2dpConnectionTime() {
        return this.a2dpConnectionTime;
    }

    public final String getAccountKey() {
        return this.accountKey;
    }

    /* JADX INFO: renamed from: getAclConnectionState, reason: from getter */
    public final int getMAclConnectState() {
        return this.mAclConnectState;
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

    public final int getAutoVolumeStatus() {
        return this.autoVolumeStatus;
    }

    public final int getBassEngineStatus() {
        return this.bassEngineStatus;
    }

    public final int getBothEarNoiseReduceMode() {
        return this.bothEarNoiseReduceMode;
    }

    public final a getBoxBatteryStatus() {
        return this.boxBatteryStatus;
    }

    public final String getBoxSn() {
        return this.boxSn;
    }

    public final List<Integer> getCapability() {
        return this.capability;
    }

    public final int getClickToTakePhotoStatus() {
        return this.clickToTakePhotoStatus;
    }

    public final List<Integer> getCodecList() {
        return this.codecList;
    }

    public final int getCodecType() {
        return this.codecType;
    }

    /* JADX INFO: renamed from: getConnectionState, reason: from getter */
    public final int getMConnectionState() {
        return this.mConnectionState;
    }

    public final List<DeviceVersionDTO> getDeviceVersionList() {
        return this.deviceVersionList;
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

    public final int getFreeDialogStatus() {
        return this.freeDialogStatus;
    }

    public final int getFullDialogRecoveryTime() {
        return this.fullDialogRecoveryTime;
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

    public final int getHeadsetActive() {
        return this.headsetActive;
    }

    public final a getHeadsetBoxBatteryStatus() {
        return this.headsetBoxBatteryStatus;
    }

    /* JADX INFO: renamed from: getHeadsetConnectionState, reason: from getter */
    public final int getMHeadsetConnectionState() {
        return this.mHeadsetConnectionState;
    }

    public final long getHeadsetConnectionTime() {
        return this.headsetConnectionTime;
    }

    public final a getHeadsetLeftBatteryStatus() {
        return this.headsetLeftBatteryStatus;
    }

    public final a getHeadsetRightBatteryStatus() {
        return this.headsetRightBatteryStatus;
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

    public final int getHiQualityAudioStatus() {
        return this.hiQualityAudioStatus;
    }

    public final int getIntelligentNoiseReductionModeIndex() {
        return this.intelligentNoiseReductionModeIndex;
    }

    public final List<KeyFunctionInfoDTO> getKeyFunctionInfoList() {
        return this.keyFunctionInfoList;
    }

    public final int getLeActive() {
        return this.leActive;
    }

    public final Map<String, Integer> getLeAudioConnectionStateMap() {
        return this.leAudioConnectionStateMap;
    }

    public final Map<String, Long> getLeAudioConnectionTimeMap() {
        return this.leAudioConnectionTimeMap;
    }

    public final a getLeftBatteryStatus() {
        return this.leftBatteryStatus;
    }

    public final int getLongPowerModeStatus() {
        return this.longPowerModeStatus;
    }

    public final int getLongPressVolume() {
        return this.longPressVolume;
    }

    public final int getMicControl() {
        return this.micControl;
    }

    public final int getMultiConnectStatus() {
        return this.multiConnectStatus;
    }

    public final List<MultiConnectInformationElement> getMultiDevicesConnectInfos() {
        return this.multiDevicesConnectInfos;
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

    public final a getRightBatteryStatus() {
        return this.rightBatteryStatus;
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

    public final int getSpineCalibrateState() {
        return this.spineCalibrateState;
    }

    public final List<Integer> getSpineCalibrationResult() {
        return this.spineCalibrationResult;
    }

    public final int getSpineCervicalStatus() {
        return this.spineCervicalStatus;
    }

    public final int getSpineExerciseStatus() {
        return this.spineExerciseStatus;
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

    public final int getZenModeStatus() {
        return this.zenModeStatus;
    }

    public final boolean isCapabilityReady() {
        return this.isCapabilityReady;
    }

    public final boolean isConnectedShown() {
        return this.isConnectedShown;
    }

    public final boolean isDeviceBonded() {
        return this.isDeviceBonded;
    }

    public final boolean isInitCmdCompleted() {
        return this.isInitCmdCompleted;
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final boolean isVersionListReceived() {
        return this.isVersionListReceived;
    }

    public final void setA2dpActive(int i10) {
        this.a2dpActive = i10;
    }

    public final void setA2dpConnectionState(int i10) {
        int i11 = this.mA2dpConnectionState;
        this.mA2dpConnectionState = i10;
        if (i10 != i11) {
            this.a2dpConnectionTime = System.currentTimeMillis();
        }
    }

    public final void setA2dpConnectionTime(long j5) {
        this.a2dpConnectionTime = j5;
    }

    public final void setAccountKey(String str) {
        this.accountKey = str;
    }

    public final void setAclConnectionState(int i10) {
        int i11 = this.mAclConnectState;
        this.mAclConnectState = i10;
        if (i10 != i11) {
            this.aclConnectionTime = System.currentTimeMillis();
        }
    }

    public final void setAclConnectionTime(long j5) {
        this.aclConnectionTime = j5;
    }

    public final void setAdaptiveEar(int i10) {
        this.adaptiveEar = i10;
    }

    public final void setAdaptiveVolume(int i10) {
        this.adaptiveVolume = i10;
    }

    public final void setAiSummaryType(int i10) {
        this.aiSummaryType = i10;
    }

    public final void setAiTranslationAppStatus(int i10) {
        this.aiTranslationAppStatus = i10;
    }

    public final void setAutoVolumeStatus(int i10) {
        this.autoVolumeStatus = i10;
    }

    public final void setBassEngineStatus(int i10) {
        this.bassEngineStatus = i10;
    }

    public final void setBothEarNoiseReduceMode(int i10) {
        this.bothEarNoiseReduceMode = i10;
    }

    public final void setBoxBatteryStatus(a aVar) {
        this.boxBatteryStatus = aVar;
    }

    public final void setBoxSn(String str) {
        this.boxSn = str;
    }

    public final void setCapability(List<Integer> list) {
        this.capability = list;
    }

    public final void setCapabilityReady(boolean z2) {
        this.isCapabilityReady = z2;
    }

    public final void setClickToTakePhotoStatus(int i10) {
        this.clickToTakePhotoStatus = i10;
    }

    public final void setCodecList(List<Integer> list) {
        this.codecList = list;
    }

    public final void setCodecType(int i10) {
        this.codecType = i10;
    }

    public final void setConnectedShown(boolean z2) {
        this.isConnectedShown = z2;
    }

    public final void setConnectionState(int i10) {
        int i11 = this.mConnectionState;
        this.mConnectionState = i10;
        if (i10 != i11) {
            this.sppConnectionTime = System.currentTimeMillis();
        }
    }

    public final void setDeviceBonded(boolean z2) {
        this.isDeviceBonded = z2;
    }

    public final void setDeviceVersionList(List<DeviceVersionDTO> list) {
        this.deviceVersionList = list;
    }

    public final void setEarStatus(EarStatusDTO earStatusDTO) {
        this.earStatus = earStatusDTO;
    }

    public final void setEarStatusReceivedMillis(long j5) {
        this.earStatusReceivedMillis = j5;
    }

    public final void setEarTones(List<EarToneDTO> list) {
        this.earTones = list;
    }

    public final void setEqType(int i10) {
        this.eqType = i10;
    }

    public final void setFreeDialogStatus(int i10) {
        this.freeDialogStatus = i10;
    }

    public final void setFullDialogRecoveryTime(int i10) {
        this.fullDialogRecoveryTime = i10;
    }

    public final void setGameEqualizerStatus(int i10) {
        this.gameEqualizerStatus = i10;
    }

    public final void setGameModeMainStatus(int i10) {
        this.gameModeMainStatus = i10;
    }

    public final void setGameModeStatus(int i10) {
        this.gameModeStatus = i10;
    }

    public final void setGameSoundStatus(int i10) {
        this.gameSoundStatus = i10;
    }

    public final void setHeadMotion(int i10) {
        this.headMotion = i10;
    }

    public final void setHeadMotionType(int i10) {
        this.headMotionType = i10;
    }

    public final void setHeadsetActive(int i10) {
        this.headsetActive = i10;
    }

    public final void setHeadsetBoxBatteryStatus(a aVar) {
        this.headsetBoxBatteryStatus = aVar;
    }

    public final void setHeadsetConnectionState(int i10) {
        int i11 = this.mHeadsetConnectionState;
        this.mHeadsetConnectionState = i10;
        if (i10 != i11) {
            this.headsetConnectionTime = System.currentTimeMillis();
        }
    }

    public final void setHeadsetConnectionTime(long j5) {
        this.headsetConnectionTime = j5;
    }

    public final void setHeadsetLeftBatteryStatus(a aVar) {
        this.headsetLeftBatteryStatus = aVar;
    }

    public final void setHeadsetRightBatteryStatus(a aVar) {
        this.headsetRightBatteryStatus = aVar;
    }

    public final void setHeadsetSoundRecordStatus(int i10) {
        this.headsetSoundRecordStatus = i10;
    }

    public final void setHeadsetSpatialType(int i10) {
        this.headsetSpatialType = i10;
    }

    public final void setHeadsetVersionList(List<DeviceVersionDTO> list) {
        this.headsetVersionList = list;
    }

    public final void setHearingEnhanceUsageStatus(int i10) {
        this.hearingEnhanceUsageStatus = i10;
    }

    public final void setHearingOptimizeStatus(int i10) {
        this.hearingOptimizeStatus = i10;
    }

    public final void setHiQualityAudioStatus(int i10) {
        this.hiQualityAudioStatus = i10;
    }

    public final void setInitCmdCompleted(boolean z2) {
        this.isInitCmdCompleted = z2;
    }

    public final void setInitialized(boolean z2) {
        this.isInitialized = z2;
    }

    public final void setIntelligentNoiseReductionModeIndex(int i10) {
        this.intelligentNoiseReductionModeIndex = i10;
    }

    public final void setKeyFunctionInfoList(List<KeyFunctionInfoDTO> list) {
        this.keyFunctionInfoList = list;
    }

    public final void setLeActive(int i10) {
        this.leActive = i10;
    }

    public final void setLeAudioConnectionStateMap(Map<String, Integer> map) {
        kotlin.jvm.internal.h.e(map, "<set-?>");
        this.leAudioConnectionStateMap = map;
    }

    public final void setLeAudioConnectionTimeMap(Map<String, Long> map) {
        kotlin.jvm.internal.h.e(map, "<set-?>");
        this.leAudioConnectionTimeMap = map;
    }

    public final void setLeftBatteryStatus(a aVar) {
        this.leftBatteryStatus = aVar;
    }

    public final void setLongPowerModeStatus(int i10) {
        this.longPowerModeStatus = i10;
    }

    public final void setLongPressVolume(int i10) {
        this.longPressVolume = i10;
    }

    public final void setMicControl(int i10) {
        this.micControl = i10;
    }

    public final void setMultiConnectStatus(int i10) {
        this.multiConnectStatus = i10;
    }

    public final void setMultiDevicesConnectInfos(List<MultiConnectInformationElement> list) {
        this.multiDevicesConnectInfos = list;
    }

    public final void setNoiseReductionModeIndex(int i10) {
        this.noiseReductionModeIndex = i10;
    }

    public final void setOneEarNoiseReduceMode(int i10) {
        this.oneEarNoiseReduceMode = i10;
    }

    public final void setPairingState(int i10) {
        this.pairingState = i10;
    }

    public final void setPersonalNoiseStatus(int i10) {
        this.personalNoiseStatus = i10;
    }

    public final void setPhoneSpatialType(int i10) {
        this.phoneSpatialType = i10;
    }

    public final void setRightBatteryStatus(a aVar) {
        this.rightBatteryStatus = aVar;
    }

    public final void setSafeRemindStatus(int i10) {
        this.safeRemindStatus = i10;
    }

    public final void setSaveLogStatus(int i10) {
        this.saveLogStatus = i10;
    }

    public final void setSleepDetection(int i10) {
        this.sleepDetection = i10;
    }

    public final void setSpatialSoundStatus(int i10) {
        this.spatialSoundStatus = i10;
    }

    public final void setSpeechPerception(int i10) {
        this.speechPerception = i10;
    }

    public final void setSpineCalibrateState(int i10) {
        this.spineCalibrateState = i10;
    }

    public final void setSpineCalibrationResult(List<Integer> list) {
        this.spineCalibrationResult = list;
    }

    public final void setSpineCervicalStatus(int i10) {
        this.spineCervicalStatus = i10;
    }

    public final void setSpineExerciseStatus(int i10) {
        this.spineExerciseStatus = i10;
    }

    public final void setSpineLiveMonitorStatus(int i10) {
        this.spineLiveMonitorStatus = i10;
    }

    public final void setSpineRangeDetection(List<Float> list) {
        this.spineRangeDetection = list;
    }

    public final void setSppConnectionTime(long j5) {
        this.sppConnectionTime = j5;
    }

    public final void setSppOverGattConnectionState(int i10) {
        this.sppOverGattConnectionState = i10;
    }

    public final void setSupportBindAccount(boolean z2) {
        this.supportBindAccount = z2;
    }

    public final void setSupportCustomEq(boolean z2) {
        this.supportCustomEq = z2;
    }

    public final void setSupportMultiDeviceConnect(boolean z2) {
        this.supportMultiDeviceConnect = z2;
    }

    public final void setSupportNoiseReductionInfo(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.supportNoiseReductionInfo = noiseReductionInfoDTO;
    }

    public final void setSupportSmartBluetooth(boolean z2) {
        this.supportSmartBluetooth = z2;
    }

    public final void setSwiftPair(int i10) {
        this.swiftPair = i10;
    }

    public final void setSwitchLeftEarNoiseReductionInfo(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.switchLeftEarNoiseReductionInfo = noiseReductionInfoDTO;
    }

    public final void setSwitchNoiseReductionInfo(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.switchNoiseReductionInfo = noiseReductionInfoDTO;
    }

    public final void setSwitchRightEarNoiseReductionInfo(NoiseReductionInfoDTO noiseReductionInfoDTO) {
        this.switchRightEarNoiseReductionInfo = noiseReductionInfoDTO;
    }

    public final void setTapLevelDefaultValue(int i10) {
        this.tapLevelDefaultValue = i10;
    }

    public final void setTapLevelSettingValue(int i10) {
        this.tapLevelSettingValue = i10;
    }

    public final void setVersionListReceived(boolean z2) {
        this.isVersionListReceived = z2;
    }

    public final void setVocalEnhanceStatus(int i10) {
        this.vocalEnhanceStatus = i10;
    }

    public final void setVoiceAssistStatus(int i10) {
        this.voiceAssistStatus = i10;
    }

    public final void setVoiceCommandStatus(int i10) {
        this.voiceCommandStatus = i10;
    }

    public final void setVoiceIncomingCallControlStatus(int i10) {
        this.voiceIncomingCallControlStatus = i10;
    }

    public final void setVolumeValueInfo(int i10) {
        this.volumeValueInfo = i10;
    }

    public final void setWearDetectionStatus(int i10) {
        this.wearDetectionStatus = i10;
    }

    public final void setZenModeStatus(int i10) {
        this.zenModeStatus = i10;
    }

    public EarphoneStatusDO(Map<String, Integer> leAudioConnectionStateMap, Map<String, Long> leAudioConnectionTimeMap, a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, List<DeviceVersionDTO> list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, boolean z2, int i24, int i25, int i26, int i27, int i28, int i29, int i30, List<DeviceVersionDTO> list2, List<KeyFunctionInfoDTO> list3, List<MultiConnectInformationElement> list4, NoiseReductionInfoDTO noiseReductionInfoDTO, NoiseReductionInfoDTO noiseReductionInfoDTO2, NoiseReductionInfoDTO noiseReductionInfoDTO3, NoiseReductionInfoDTO noiseReductionInfoDTO4, EarStatusDTO earStatusDTO, long j5, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, List<Integer> list5, boolean z4, int i42, List<EarToneDTO> list6, List<Integer> list7, List<Float> list8, List<Integer> list9, int i43, boolean z10, boolean z11, boolean z12, int i44, int i45, int i46, int i47, int i48, int i49, int i50, String str, int i51, boolean z13, int i52, int i53, boolean z14, boolean z15, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, int i62, boolean z16, boolean z17, int i63, String str2, int i64, int i65) {
        kotlin.jvm.internal.h.e(leAudioConnectionStateMap, "leAudioConnectionStateMap");
        kotlin.jvm.internal.h.e(leAudioConnectionTimeMap, "leAudioConnectionTimeMap");
        this.leAudioConnectionStateMap = leAudioConnectionStateMap;
        this.leAudioConnectionTimeMap = leAudioConnectionTimeMap;
        this.boxBatteryStatus = aVar;
        this.leftBatteryStatus = aVar2;
        this.rightBatteryStatus = aVar3;
        this.headsetBoxBatteryStatus = aVar4;
        this.headsetLeftBatteryStatus = aVar5;
        this.headsetRightBatteryStatus = aVar6;
        this.headsetVersionList = list;
        this.headsetActive = i10;
        this.a2dpActive = i11;
        this.leActive = i12;
        this.pairingState = i13;
        this.noiseReductionModeIndex = i14;
        this.intelligentNoiseReductionModeIndex = i15;
        this.wearDetectionStatus = i16;
        this.vocalEnhanceStatus = i17;
        this.personalNoiseStatus = i18;
        this.hearingEnhanceUsageStatus = i19;
        this.clickToTakePhotoStatus = i20;
        this.headsetSoundRecordStatus = i21;
        this.eqType = i22;
        this.multiConnectStatus = i23;
        this.supportMultiDeviceConnect = z2;
        this.zenModeStatus = i24;
        this.hiQualityAudioStatus = i25;
        this.longPowerModeStatus = i26;
        this.freeDialogStatus = i27;
        this.voiceAssistStatus = i28;
        this.voiceCommandStatus = i29;
        this.voiceIncomingCallControlStatus = i30;
        this.deviceVersionList = list2;
        this.keyFunctionInfoList = list3;
        this.multiDevicesConnectInfos = list4;
        this.switchNoiseReductionInfo = noiseReductionInfoDTO;
        this.switchLeftEarNoiseReductionInfo = noiseReductionInfoDTO2;
        this.switchRightEarNoiseReductionInfo = noiseReductionInfoDTO3;
        this.supportNoiseReductionInfo = noiseReductionInfoDTO4;
        this.earStatus = earStatusDTO;
        this.earStatusReceivedMillis = j5;
        this.fullDialogRecoveryTime = i31;
        this.safeRemindStatus = i32;
        this.gameModeStatus = i33;
        this.spatialSoundStatus = i34;
        this.autoVolumeStatus = i35;
        this.bassEngineStatus = i36;
        this.spineLiveMonitorStatus = i37;
        this.spineCervicalStatus = i38;
        this.spineExerciseStatus = i39;
        this.saveLogStatus = i40;
        this.gameEqualizerStatus = i41;
        this.capability = list5;
        this.isCapabilityReady = z4;
        this.codecType = i42;
        this.earTones = list6;
        this.codecList = list7;
        this.spineRangeDetection = list8;
        this.spineCalibrationResult = list9;
        this.spineCalibrateState = i43;
        this.supportCustomEq = z10;
        this.supportSmartBluetooth = z11;
        this.supportBindAccount = z12;
        this.headsetSpatialType = i44;
        this.phoneSpatialType = i45;
        this.aiSummaryType = i46;
        this.aiTranslationAppStatus = i47;
        this.volumeValueInfo = i48;
        this.tapLevelSettingValue = i49;
        this.tapLevelDefaultValue = i50;
        this.accountKey = str;
        this.gameSoundStatus = i51;
        this.isVersionListReceived = z13;
        this.sppOverGattConnectionState = i52;
        this.gameModeMainStatus = i53;
        this.isDeviceBonded = z14;
        this.isInitCmdCompleted = z15;
        this.adaptiveVolume = i54;
        this.adaptiveEar = i55;
        this.speechPerception = i56;
        this.micControl = i57;
        this.longPressVolume = i58;
        this.swiftPair = i59;
        this.headMotion = i60;
        this.headMotionType = i61;
        this.sleepDetection = i62;
        this.isConnectedShown = z16;
        this.isInitialized = z17;
        this.hearingOptimizeStatus = i63;
        this.boxSn = str2;
        this.oneEarNoiseReduceMode = i64;
        this.bothEarNoiseReduceMode = i65;
    }

    public static /* synthetic */ void getA2dpConnectionState$annotations() {
    }

    public static /* synthetic */ void getAclConnectionState$annotations() {
    }

    public static /* synthetic */ void getConnectionState$annotations() {
    }

    public static /* synthetic */ void getHeadsetConnectionState$annotations() {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EarphoneStatusDO(Map map, Map map2, a aVar, a aVar2, a aVar3, a aVar4, a aVar5, a aVar6, List list, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, boolean z2, int i24, int i25, int i26, int i27, int i28, int i29, int i30, List list2, List list3, List list4, NoiseReductionInfoDTO noiseReductionInfoDTO, NoiseReductionInfoDTO noiseReductionInfoDTO2, NoiseReductionInfoDTO noiseReductionInfoDTO3, NoiseReductionInfoDTO noiseReductionInfoDTO4, EarStatusDTO earStatusDTO, long j5, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, List list5, boolean z4, int i42, List list6, List list7, List list8, List list9, int i43, boolean z10, boolean z11, boolean z12, int i44, int i45, int i46, int i47, int i48, int i49, int i50, String str, int i51, boolean z13, int i52, int i53, boolean z14, boolean z15, int i54, int i55, int i56, int i57, int i58, int i59, int i60, int i61, int i62, boolean z16, boolean z17, int i63, String str2, int i64, int i65, int i66, int i67, int i68, kotlin.jvm.internal.d dVar) {
        Map mapB0 = (i66 & 1) != 0 ? kotlin.collections.a.b0() : map;
        Map mapB02 = (i66 & 2) != 0 ? kotlin.collections.a.b0() : map2;
        a aVar7 = (i66 & 4) != 0 ? null : aVar;
        a aVar8 = (i66 & 8) != 0 ? null : aVar2;
        a aVar9 = (i66 & 16) != 0 ? null : aVar3;
        a aVar10 = (i66 & 32) != 0 ? null : aVar4;
        a aVar11 = (i66 & 64) != 0 ? null : aVar5;
        a aVar12 = (i66 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? null : aVar6;
        List list10 = (i66 & 256) != 0 ? null : list;
        int i69 = (i66 & 512) != 0 ? 0 : i10;
        int i70 = (i66 & 1024) != 0 ? 0 : i11;
        int i71 = (i66 & 2048) != 0 ? 0 : i12;
        int i72 = (i66 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? -1 : i13;
        Map map3 = mapB0;
        int i73 = (i66 & 8192) != 0 ? -1 : i14;
        int i74 = (i66 & 16384) != 0 ? -1 : i15;
        int i75 = (i66 & 32768) != 0 ? -1 : i16;
        int i76 = (i66 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i17;
        int i77 = (i66 & 131072) != 0 ? -1 : i18;
        int i78 = (i66 & 262144) != 0 ? -1 : i19;
        int i79 = (i66 & 524288) != 0 ? -1 : i20;
        int i80 = (i66 & 1048576) != 0 ? -1 : i21;
        int i81 = (i66 & 2097152) != 0 ? 0 : i22;
        int i82 = (i66 & 4194304) != 0 ? -1 : i23;
        boolean z18 = (i66 & 8388608) != 0 ? false : z2;
        int i83 = (i66 & 16777216) != 0 ? -1 : i24;
        int i84 = (i66 & 33554432) != 0 ? -1 : i25;
        int i85 = (i66 & 67108864) != 0 ? -1 : i26;
        int i86 = (i66 & 134217728) != 0 ? -1 : i27;
        int i87 = (i66 & 268435456) != 0 ? -1 : i28;
        int i88 = (i66 & 536870912) != 0 ? -1 : i29;
        int i89 = (i66 & 1073741824) != 0 ? -1 : i30;
        List list11 = (i66 & Integer.MIN_VALUE) != 0 ? null : list2;
        this(map3, mapB02, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, list10, i69, i70, i71, i72, i73, i74, i75, i76, i77, i78, i79, i80, i81, i82, z18, i83, i84, i85, i86, i87, i88, i89, list11, (i67 & 1) != 0 ? null : list3, (i67 & 2) != 0 ? null : list4, (i67 & 4) != 0 ? null : noiseReductionInfoDTO, (i67 & 8) != 0 ? null : noiseReductionInfoDTO2, (i67 & 16) != 0 ? null : noiseReductionInfoDTO3, (i67 & 32) != 0 ? null : noiseReductionInfoDTO4, (i67 & 64) != 0 ? null : earStatusDTO, (i67 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? 0L : j5, (i67 & 256) != 0 ? 0 : i31, (i67 & 512) != 0 ? -1 : i32, (i67 & 1024) != 0 ? -1 : i33, (i67 & 2048) != 0 ? -1 : i34, (i67 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? -1 : i35, (i67 & 8192) != 0 ? -1 : i36, (i67 & 16384) != 0 ? -1 : i37, (i67 & 32768) != 0 ? -1 : i38, (i67 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i39, (i67 & 131072) != 0 ? -1 : i40, (i67 & 262144) != 0 ? -1 : i41, (i67 & 524288) != 0 ? null : list5, (i67 & 1048576) != 0 ? false : z4, (i67 & 2097152) != 0 ? 0 : i42, (i67 & 4194304) != 0 ? null : list6, (i67 & 8388608) != 0 ? null : list7, (i67 & 16777216) != 0 ? null : list8, (i67 & 33554432) != 0 ? null : list9, (i67 & 67108864) != 0 ? 0 : i43, (i67 & 134217728) != 0 ? false : z10, (i67 & 268435456) != 0 ? false : z11, (i67 & 536870912) != 0 ? false : z12, (i67 & 1073741824) != 0 ? 0 : i44, (i67 & Integer.MIN_VALUE) != 0 ? 0 : i45, (i68 & 1) != 0 ? 0 : i46, (i68 & 2) != 0 ? 0 : i47, (i68 & 4) != 0 ? 0 : i48, (i68 & 8) != 0 ? 0 : i49, (i68 & 16) != 0 ? 0 : i50, (i68 & 32) != 0 ? null : str, (i68 & 64) != 0 ? -1 : i51, (i68 & DeviceInfo.FEATURE_SUPPORT_IN_EAR_DETECTION_MUSIC_MUTE) != 0 ? false : z13, (i68 & 256) != 0 ? 0 : i52, (i68 & 512) != 0 ? -1 : i53, (i68 & 1024) != 0 ? false : z14, (i68 & 2048) != 0 ? false : z15, (i68 & DeviceInfo.FEATURE_SUPPORT_SEARCH) != 0 ? -1 : i54, (i68 & 8192) != 0 ? -1 : i55, (i68 & 16384) != 0 ? -1 : i56, (i68 & 32768) != 0 ? -1 : i57, (i68 & ArrayPool.STANDARD_BUFFER_SIZE_BYTES) != 0 ? -1 : i58, (i68 & 131072) != 0 ? -1 : i59, (i68 & 262144) != 0 ? -1 : i60, (i68 & 524288) != 0 ? -1 : i61, (i68 & 1048576) != 0 ? -1 : i62, (i68 & 2097152) != 0 ? false : z16, (i68 & 4194304) != 0 ? false : z17, (i68 & 8388608) == 0 ? i63 : -1, (i68 & 16777216) != 0 ? null : str2, (i68 & 33554432) != 0 ? 0 : i64, (i68 & 67108864) != 0 ? 0 : i65);
    }
}
