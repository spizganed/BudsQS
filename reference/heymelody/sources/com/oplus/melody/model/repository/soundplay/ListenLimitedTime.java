package com.oplus.melody.model.repository.soundplay;

import Kb.b;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ListenLimitedTime.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u001b"}, d2 = {"Lcom/oplus/melody/model/repository/soundplay/ListenLimitedTime;", "", "valueInMinute", "", "<init>", "(Ljava/lang/String;II)V", "getValueInMinute", "()I", "UNLIMITED", "ONE_MINUTE", "FIVE_MINUTE", "TEN_MINUTE", "FIFTEEN_MINUTE", "TWENTY_MINUTE", "TWENTY_FIVE_MINUTE", "THIRTY_MINUTE", "FORTY_FIVE_MINUTE", "SIXTY_MINUTE", "NINETY_MINUTE", "ONE_HUNDRED_AND_TWENTY_MINUTE", "ONE_HUNDRED_AND_EIGHTY_MINUTE", "THREE_HUNDRED_AND_SIXTY_MINUTE", "valueInMillion", "", "getValueInMillion", "()J", "Companion", "model_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ListenLimitedTime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ListenLimitedTime f20100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ListenLimitedTime f20101c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ ListenLimitedTime[] f20102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ Pb.a f20103q;
    private final int valueInMinute;

    /* JADX INFO: compiled from: ListenLimitedTime.kt */
    public static final class a {
        public static ListenLimitedTime a(int i10) {
            Object next;
            b bVar = (b) ListenLimitedTime.f20103q;
            bVar.getClass();
            b.C0028b c0028b = new b.C0028b();
            while (true) {
                if (!c0028b.hasNext()) {
                    next = null;
                    break;
                }
                next = c0028b.next();
                if (((ListenLimitedTime) next).getValueInMinute() == i10) {
                    break;
                }
            }
            ListenLimitedTime listenLimitedTime = (ListenLimitedTime) next;
            return listenLimitedTime == null ? ListenLimitedTime.f20100b : listenLimitedTime;
        }
    }

    static {
        ListenLimitedTime listenLimitedTime = new ListenLimitedTime("UNLIMITED", 0, -1);
        f20100b = listenLimitedTime;
        ListenLimitedTime listenLimitedTime2 = new ListenLimitedTime("ONE_MINUTE", 1, 1);
        ListenLimitedTime listenLimitedTime3 = new ListenLimitedTime("FIVE_MINUTE", 2, 5);
        ListenLimitedTime listenLimitedTime4 = new ListenLimitedTime("TEN_MINUTE", 3, 10);
        ListenLimitedTime listenLimitedTime5 = new ListenLimitedTime("FIFTEEN_MINUTE", 4, 15);
        ListenLimitedTime listenLimitedTime6 = new ListenLimitedTime("TWENTY_MINUTE", 5, 20);
        ListenLimitedTime listenLimitedTime7 = new ListenLimitedTime("TWENTY_FIVE_MINUTE", 6, 25);
        ListenLimitedTime listenLimitedTime8 = new ListenLimitedTime("THIRTY_MINUTE", 7, 30);
        f20101c = listenLimitedTime8;
        ListenLimitedTime[] listenLimitedTimeArr = {listenLimitedTime, listenLimitedTime2, listenLimitedTime3, listenLimitedTime4, listenLimitedTime5, listenLimitedTime6, listenLimitedTime7, listenLimitedTime8, new ListenLimitedTime("FORTY_FIVE_MINUTE", 8, 45), new ListenLimitedTime("SIXTY_MINUTE", 9, 60), new ListenLimitedTime("NINETY_MINUTE", 10, 90), new ListenLimitedTime("ONE_HUNDRED_AND_TWENTY_MINUTE", 11, 120), new ListenLimitedTime("ONE_HUNDRED_AND_EIGHTY_MINUTE", 12, 180), new ListenLimitedTime("THREE_HUNDRED_AND_SIXTY_MINUTE", 13, 360)};
        f20102p = listenLimitedTimeArr;
        f20103q = kotlin.enums.a.a(listenLimitedTimeArr);
        f20099a = new a();
    }

    public ListenLimitedTime(String str, int i10, int i11) {
        this.valueInMinute = i11;
    }

    public static ListenLimitedTime valueOf(String str) {
        return (ListenLimitedTime) Enum.valueOf(ListenLimitedTime.class, str);
    }

    public static ListenLimitedTime[] values() {
        return (ListenLimitedTime[]) f20102p.clone();
    }

    public final long a() {
        return ((long) this.valueInMinute) * 60000;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getValueInMinute() {
        return this.valueInMinute;
    }
}
