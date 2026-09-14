package com.oplus.melody.model.constant;

import Pb.a;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AISummaryStatusType.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/oplus/melody/model/constant/CallSummaryStatusType;", "", SpeechFindManager.CODE, "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "NO_SUMMARY", "CALL_SUMMARY_ASR", "CALL_SUMMARY_DOING", "CALL_SUMMARY_PREPARE", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CallSummaryStatusType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CallSummaryStatusType f19649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CallSummaryStatusType[] f19650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ a f19651c;
    private final int code;

    static {
        CallSummaryStatusType callSummaryStatusType = new CallSummaryStatusType("NO_SUMMARY", 0, 0);
        f19649a = callSummaryStatusType;
        CallSummaryStatusType[] callSummaryStatusTypeArr = {callSummaryStatusType, new CallSummaryStatusType("CALL_SUMMARY_ASR", 1, 1), new CallSummaryStatusType("CALL_SUMMARY_DOING", 2, 11), new CallSummaryStatusType("CALL_SUMMARY_PREPARE", 3, 12)};
        f19650b = callSummaryStatusTypeArr;
        f19651c = kotlin.enums.a.a(callSummaryStatusTypeArr);
    }

    public CallSummaryStatusType(String str, int i10, int i11) {
        this.code = i11;
    }

    public static CallSummaryStatusType valueOf(String str) {
        return (CallSummaryStatusType) Enum.valueOf(CallSummaryStatusType.class, str);
    }

    public static CallSummaryStatusType[] values() {
        return (CallSummaryStatusType[]) f19650b.clone();
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }
}
