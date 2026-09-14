package com.oplus.melody.model.repository.earphone;

import kotlin.Metadata;

/* JADX INFO: renamed from: com.oplus.melody.model.repository.earphone.P, reason: from Kotlin metadata */
/* JADX INFO: compiled from: PersonalNoiseDTO.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/oplus/melody/model/repository/earphone/PersonalNoiseDTO;", "Lcom/oplus/melody/common/data/BaseBean;", "noiseReductionResult", "", "existResult", "<init>", "(II)V", "getNoiseReductionResult", "()I", "setNoiseReductionResult", "(I)V", "getExistResult", "setExistResult", "component1", "component2", "copy", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class PersonalNoiseDTO extends com.oplus.melody.common.data.a {
    private int existResult;
    private int noiseReductionResult;

    /* JADX WARN: Illegal instructions before constructor call */
    public PersonalNoiseDTO() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public static /* synthetic */ PersonalNoiseDTO copy$default(PersonalNoiseDTO personalNoiseDTO, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = personalNoiseDTO.noiseReductionResult;
        }
        if ((i12 & 2) != 0) {
            i11 = personalNoiseDTO.existResult;
        }
        return personalNoiseDTO.copy(i10, i11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNoiseReductionResult() {
        return this.noiseReductionResult;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getExistResult() {
        return this.existResult;
    }

    public final PersonalNoiseDTO copy(int i10, int i11) {
        return new PersonalNoiseDTO(i10, i11);
    }

    public final int getExistResult() {
        return this.existResult;
    }

    public final int getNoiseReductionResult() {
        return this.noiseReductionResult;
    }

    public final void setExistResult(int i10) {
        this.existResult = i10;
    }

    public final void setNoiseReductionResult(int i10) {
        this.noiseReductionResult = i10;
    }

    public PersonalNoiseDTO(int i10, int i11) {
        this.noiseReductionResult = i10;
        this.existResult = i11;
    }

    public /* synthetic */ PersonalNoiseDTO(int i10, int i11, int i12, kotlin.jvm.internal.d dVar) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 0 : i11);
    }
}
