package com.oplus.melody.model.constant;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: AITranslationStatusType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/oplus/melody/model/constant/ControlAITranslationResult;", "", SpeechFindManager.CODE, "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "CONTROL_SUCCESS", "CONTROL_FAIL", "CONTROL_UNKNOWN_ERROR", "CONTROL_FAIL_CODE", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum ControlAITranslationResult {
    CONTROL_SUCCESS(0),
    CONTROL_FAIL(-1),
    CONTROL_UNKNOWN_ERROR(-2),
    CONTROL_FAIL_CODE(1000);

    private final int code;

    ControlAITranslationResult(int i10) {
        this.code = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }
}
