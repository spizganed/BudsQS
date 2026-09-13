package com.oplus.melody.model.repository.earphone;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CurrentNoiseModeDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/CurrentNoiseModeDTO;", "Lcom/oplus/melody/common/data/BaseBean;", SpeechFindManager.TYPE, "", "<init>", "(I)V", "getType", "()I", "setType", "mOpenNoiseReductionMode", "Landroidx/collection/ArrayMap;", "", "isNoiseReductionModeOpened", "key", "setCurrentNoiseReductionModeValue", "", "index", "value", "component1", "copy", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class CurrentNoiseModeDTO extends com.oplus.melody.common.data.a {
    private final androidx.collection.a<Integer, Boolean> mOpenNoiseReductionMode;
    private int type;

    public CurrentNoiseModeDTO() {
        this(0, 1, null);
    }

    public static /* synthetic */ CurrentNoiseModeDTO copy$default(CurrentNoiseModeDTO currentNoiseModeDTO, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = currentNoiseModeDTO.type;
        }
        return currentNoiseModeDTO.copy(i10);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final CurrentNoiseModeDTO copy(int i10) {
        return new CurrentNoiseModeDTO(i10);
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isNoiseReductionModeOpened(int key) {
        Boolean bool = this.mOpenNoiseReductionMode.get(Integer.valueOf(key));
        return bool != null && bool.booleanValue();
    }

    public final void setCurrentNoiseReductionModeValue(int index, boolean value) {
        this.mOpenNoiseReductionMode.put(Integer.valueOf(index), Boolean.valueOf(value));
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public CurrentNoiseModeDTO(int i10) {
        this.type = i10;
        this.mOpenNoiseReductionMode = new androidx.collection.a<>();
    }

    public /* synthetic */ CurrentNoiseModeDTO(int i10, int i11, kotlin.jvm.internal.d dVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
