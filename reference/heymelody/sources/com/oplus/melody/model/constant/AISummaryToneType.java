package com.oplus.melody.model.constant;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;

/* JADX INFO: compiled from: AISummaryStatusType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/oplus/melody/model/constant/AISummaryToneType;", "", SpeechFindManager.CODE, "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "START_SUMMARY_TONE", "STOP_SUMMARY_TONE", "FAIL_SUMMARY_TONE", "NO_SUMMARY_TONE", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public enum AISummaryToneType {
    START_SUMMARY_TONE(0),
    STOP_SUMMARY_TONE(1),
    FAIL_SUMMARY_TONE(2),
    NO_SUMMARY_TONE(3);

    private final int code;

    AISummaryToneType(int i10) {
        this.code = i10;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }
}
