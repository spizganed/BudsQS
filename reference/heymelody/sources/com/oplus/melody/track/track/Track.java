package com.oplus.melody.track.track;

import I3.b;
import Y.r;
import android.text.TextUtils;
import com.oplus.drs.track.TrackApi;
import com.oplus.drs.track.routing.TrackApiRouter;
import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import com.oplus.melody.common.util.A;
import com.oplus.melody.common.util.C0911q;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import org.json.JSONException;
import org.json.JSONObject;
import t8.q;
import v8.C1581a;
import x8.a;

/* JADX INFO: compiled from: Track.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\u001c\u0010\u001d\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0014J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bRD\u0010\u0010\u001a6\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u0012*\u001a\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00140\u00118\u0002X\u0083\u0004¢\u0006\u0002\n\u0000RD\u0010\u0015\u001a6\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0013 \u0012*\u001a\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00140\u00118\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/oplus/melody/track/track/Track;", "Ljava/io/Serializable;", "event", "", SpeechFindManager.TYPE, "trackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEvent", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "getType", "setType", "getTrackId", "setTrackId", "trackItems", "", "kotlin.jvm.PlatformType", "", "", "extItems", "pack", "Lcom/oplus/melody/track/track/TrackEntry;", "pack$track_release", "putProperty", "", "key", "value", "putProperties", "tracks", "putItemTimeCostStart", "putItemTimeCostEnd", "send", "Companion", "track_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class Track implements Serializable {

    @b("event")
    private String event;

    @b("extItems")
    private final Map<String, Object> extItems;

    @b("trackId")
    private String trackId;

    @b("trackItems")
    private final Map<String, Object> trackItems;

    @b(SpeechFindManager.TYPE)
    private String type;

    public Track(String str, String str2) {
        String string = UUID.randomUUID().toString();
        h.d(string, "toString(...)");
        this.event = str;
        this.type = str2;
        this.trackId = string;
        this.trackItems = Collections.synchronizedMap(new HashMap());
        this.extItems = Collections.synchronizedMap(new HashMap());
    }

    public final void a(Object obj, String str) {
        Map<String, Object> trackItems = this.trackItems;
        h.d(trackItems, "trackItems");
        trackItems.put(str, obj);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [Jb.b, java.lang.Object] */
    public final void d() throws JSONException {
        String type = this.type;
        String event = this.event;
        Map<String, Object> trackItems = this.trackItems;
        h.d(trackItems, "trackItems");
        h.e(type, "type");
        h.e(event, "event");
        if (trackItems.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, Object> entry : trackItems.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && !TextUtils.isEmpty(value.toString())) {
                map.put(key, value.toString());
            }
        }
        C1581a c1581a = a.f28979a;
        if (c1581a != null) {
            if (A.l()) {
                StringBuilder sbI = r.i("send, type: ", type, ", event: ", event, ", values: ");
                sbI.append(map);
                A.f("NearXTrackAdapter", sbI.toString());
            }
            if (!q.n()) {
                A.x("NearXTrackAdapter", "send, !isPrivacyStatementAccepted, return. event: ".concat(event));
                return;
            }
            B8.a.e();
            if (!B8.a.f()) {
                A.x("NearXTrackAdapter", "send, exp !isIndiaTrackEnable, return. event: ".concat(event));
                return;
            }
            if (map.isEmpty()) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry2 : map.entrySet()) {
                jSONObject.put((String) entry2.getKey(), (String) entry2.getValue());
            }
            TrackApi.Companion companion = TrackApi.INSTANCE;
            long j5 = ((C7.b) c1581a.f28398k.getValue()).f761a;
            companion.getClass();
            TrackApi trackApiRouter = TrackApiRouter.f18721a.getInstance(j5);
            if (c1581a.f28397j) {
                String string = q.c("melody-model-settings").getString("melody_app_sp_id", "");
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    q.c("melody-model-settings").edit().putString("melody_app_sp_id", string).apply();
                }
                if (A.l()) {
                    A.f("MelodyPreferences", "getMelodyAppSpId spId = " + string);
                }
                String strJ = C0911q.j(string);
                A.x("NearXTrackAdapter", "setCustomClientId, hashId: " + strJ);
                h.b(strJ);
                trackApiRouter.setCustomClientId(strJ);
                c1581a.f28397j = false;
            }
            trackApiRouter.track(type, event, jSONObject);
        }
    }
}
