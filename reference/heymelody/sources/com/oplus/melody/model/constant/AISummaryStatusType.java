package com.oplus.melody.model.constant;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: AISummaryStatusType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/oplus/melody/model/constant/AISummaryStatusType;", "", SpeechFindManager.CODE, "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "SUMMARY_RESULT_STATE", "START_SUMMARY_SUCCESS", "STOP_SUMMARY_SUCCESS", "SUMMARY_RESULT_SUCCESS", "BIND_SERVICE_SUCCESS", "BIND_SERVICE_FAIL", "DEFAULT_FAILURE", "CALL_NOT_SUPPORT", "DEVICE_NOT_SUPPORT", "CALL_SUMMARY_ENABLE", "START_SUMMARY_FAIL", "CLOSE_SUMMARY_FAIL", "SUMMARY_READY_PREPARE", "CALL_SUMMARY_DOING", "POWER_SAVE_MODE", "CHILDREN_MODE", "VIP_MODE", "ZEN_MODE", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AISummaryStatusType {
    SUMMARY_RESULT_STATE(100),
    START_SUMMARY_SUCCESS(101),
    STOP_SUMMARY_SUCCESS(102),
    SUMMARY_RESULT_SUCCESS(1),
    BIND_SERVICE_SUCCESS(2),
    BIND_SERVICE_FAIL(3),
    DEFAULT_FAILURE(-1),
    /* JADX INFO: Fake field, exist only in values array */
    CALL_NOT_SUPPORT(-2),
    /* JADX INFO: Fake field, exist only in values array */
    DEVICE_NOT_SUPPORT(-3),
    /* JADX INFO: Fake field, exist only in values array */
    CALL_SUMMARY_ENABLE(-4),
    /* JADX INFO: Fake field, exist only in values array */
    START_SUMMARY_FAIL(-5),
    /* JADX INFO: Fake field, exist only in values array */
    CLOSE_SUMMARY_FAIL(-6),
    /* JADX INFO: Fake field, exist only in values array */
    SUMMARY_READY_PREPARE(-7),
    /* JADX INFO: Fake field, exist only in values array */
    CALL_SUMMARY_DOING(-8),
    /* JADX INFO: Fake field, exist only in values array */
    POWER_SAVE_MODE(-100),
    /* JADX INFO: Fake field, exist only in values array */
    CHILDREN_MODE(-101),
    /* JADX INFO: Fake field, exist only in values array */
    VIP_MODE(-102),
    /* JADX INFO: Fake field, exist only in values array */
    ZEN_MODE(-103);

    private final int code;

    AISummaryStatusType(int i10) {
        this.code = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }
}
