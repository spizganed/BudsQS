package com.oplus.melody.ui.component.tutorialguide;

import com.oplus.melody.ui.base.BaseViewModel;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import qa.c;
import t8.C1532B;

/* JADX INFO: compiled from: TutorialGuideFunctionsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001a\u0004\u0018\u00010'R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideFunctionsViewModel;", "Lcom/oplus/melody/ui/base/BaseViewModel;", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mProductId", "getMProductId", "setMProductId", "mDeviceName", "getMDeviceName", "setMDeviceName", "mColorId", "getMColorId", "setMColorId", "mFunctionList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMFunctionList", "()Ljava/util/ArrayList;", "setMFunctionList", "(Ljava/util/ArrayList;)V", "resourceFile", "Ljava/io/File;", "getResourceFile", "()Ljava/io/File;", "setResourceFile", "(Ljava/io/File;)V", "localeMap", "", "getLocaleMap", "()Ljava/util/Map;", "setLocaleMap", "(Ljava/util/Map;)V", "convertToLocale", "Lcom/oplus/melody/ui/component/tutorialguide/TutorialGuideZipConfig;", "ui_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TutorialGuideFunctionsViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f21670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f21672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<String> f21673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public File f21674g;
    public androidx.collection.a h;

    public final c d() {
        File file = this.f21674g;
        if (file == null) {
            return null;
        }
        c cVar = (c) C1532B.d(file, c.class);
        androidx.collection.a aVarB = C1532B.b(cVar);
        this.h = aVarB;
        if (aVarB.isEmpty()) {
            return cVar;
        }
        cVar.setSpatialAudioFunctionSummary(C1532B.a(cVar.getSpatialAudioFunctionSummary(), this.h));
        cVar.setSpatialAuditionMusicName(C1532B.a(cVar.getSpatialAuditionMusicName(), this.h));
        cVar.setEqualizerFunctionSummary(C1532B.a(cVar.getEqualizerFunctionSummary(), this.h));
        cVar.setEqualizerAuditionMusicName(C1532B.a(cVar.getEqualizerAuditionMusicName(), this.h));
        cVar.setRealtimeNoiseFunctionSummary(C1532B.a(cVar.getRealtimeNoiseFunctionSummary(), this.h));
        cVar.setRealtimeNoiseFunctionIntroduce(C1532B.a(cVar.getRealtimeNoiseFunctionIntroduce(), this.h));
        cVar.setRealtimeNoiseAuditionMusicName(C1532B.a(cVar.getRealtimeNoiseAuditionMusicName(), this.h));
        cVar.setMultiConnectFunctionSummary(C1532B.a(cVar.getMultiConnectFunctionSummary(), this.h));
        cVar.setSmartBluetoothFunctionSummary(C1532B.a(cVar.getSmartBluetoothFunctionSummary(), this.h));
        cVar.setVoiceAssistFunctionSummary(C1532B.a(cVar.getVoiceAssistFunctionSummary(), this.h));
        cVar.setAiTranslationFunctionSummary(C1532B.a(cVar.getAiTranslationFunctionSummary(), this.h));
        cVar.setAiSummaryFunctionSummary(C1532B.a(cVar.getAiSummaryFunctionSummary(), this.h));
        cVar.setAiClearCallFunctionSummaryV2(C1532B.a(cVar.getAiClearCallFunctionSummaryV2(), this.h));
        cVar.setVoiceAssistFunctionSummaryV2(C1532B.a(cVar.getVoiceAssistFunctionSummaryV2(), this.h));
        cVar.setVoiceAssistViewPagerSummaryV2(C1532B.a(cVar.getVoiceAssistViewPagerSummaryV2(), this.h));
        cVar.setVoiceAssistFunctionSummaryCompat(C1532B.a(cVar.getVoiceAssistFunctionSummaryCompat(), this.h));
        cVar.setAdaptiveHearingSummary(C1532B.a(cVar.getAdaptiveHearingSummary(), this.h));
        cVar.setVoiceCommandSummary(C1532B.a(cVar.getVoiceCommandSummary(), this.h));
        cVar.setGameLowLatencySummary(C1532B.a(cVar.getGameLowLatencySummary(), this.h));
        cVar.setSpeechPerceptionSummary(C1532B.a(cVar.getSpeechPerceptionSummary(), this.h));
        cVar.setDropDetectionSummary(C1532B.a(cVar.getDropDetectionSummary(), this.h));
        cVar.setSpyTapSummary(C1532B.a(cVar.getSpyTapSummary(), this.h));
        return cVar;
    }
}
