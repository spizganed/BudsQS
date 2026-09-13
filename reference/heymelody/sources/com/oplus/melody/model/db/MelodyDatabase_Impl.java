package com.oplus.melody.model.db;

import androidx.room.InvalidationTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MelodyDatabase_Impl extends MelodyDatabase {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public volatile MelodyEquipmentDao_Impl f19722D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public volatile HearingEnhancementDao_Impl f19723E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public volatile ZenModeResourceDao_Impl f19724F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public volatile PersonalDressDao_Impl f19725G;
    public volatile PersonalDressSeriesDao_Impl H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public volatile ConnectedDeviceDao_Impl f19726I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile SpineHistoryDataDao_Impl f19727J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public volatile DataCollectDao_Impl f19728K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public volatile ProvisionalWhitelistDao_Impl f19729L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public volatile CarouselDressDao_Impl f19730M;

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker a() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "melody_equipment", "hearing_enhancement", "zenmode_resource_info", "connected_device", "persnoal_dress", "persnoal_dress_series", "spine_history_data", "data_collect", "provisional_whitelist", "carousel_dress");
    }

    @Override // androidx.room.RoomDatabase
    public final androidx.room.p b() {
        return new y(this);
    }

    @Override // androidx.room.RoomDatabase
    public final List c(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set<Class<Object>> f() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map<Class<?>, List<Class<?>>> g() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(MelodyEquipmentDao.class, list);
        map.put(HearingEnhancementDao.class, list);
        map.put(ZenModeResourceDao.class, list);
        map.put(PersonalDressDao.class, list);
        map.put(PersonalDressSeriesDao.class, list);
        map.put(ConnectedDeviceDao.class, list);
        map.put(SpineHistoryDataDao.class, list);
        map.put(DataCollectDao.class, list);
        map.put(ProvisionalWhitelistDao.class, list);
        map.put(CarouselDressDao.class, list);
        return map;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final CarouselDressDao o() {
        CarouselDressDao_Impl carouselDressDao_Impl;
        if (this.f19730M != null) {
            return this.f19730M;
        }
        synchronized (this) {
            try {
                if (this.f19730M == null) {
                    this.f19730M = new CarouselDressDao_Impl(this);
                }
                carouselDressDao_Impl = this.f19730M;
            } catch (Throwable th) {
                throw th;
            }
        }
        return carouselDressDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final ConnectedDeviceDao p() {
        ConnectedDeviceDao_Impl connectedDeviceDao_Impl;
        if (this.f19726I != null) {
            return this.f19726I;
        }
        synchronized (this) {
            try {
                if (this.f19726I == null) {
                    this.f19726I = new ConnectedDeviceDao_Impl(this);
                }
                connectedDeviceDao_Impl = this.f19726I;
            } catch (Throwable th) {
                throw th;
            }
        }
        return connectedDeviceDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final DataCollectDao r() {
        DataCollectDao_Impl dataCollectDao_Impl;
        if (this.f19728K != null) {
            return this.f19728K;
        }
        synchronized (this) {
            try {
                if (this.f19728K == null) {
                    this.f19728K = new DataCollectDao_Impl(this);
                }
                dataCollectDao_Impl = this.f19728K;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataCollectDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final MelodyEquipmentDao s() {
        MelodyEquipmentDao_Impl melodyEquipmentDao_Impl;
        if (this.f19722D != null) {
            return this.f19722D;
        }
        synchronized (this) {
            try {
                if (this.f19722D == null) {
                    this.f19722D = new MelodyEquipmentDao_Impl(this);
                }
                melodyEquipmentDao_Impl = this.f19722D;
            } catch (Throwable th) {
                throw th;
            }
        }
        return melodyEquipmentDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final HearingEnhancementDao u() {
        HearingEnhancementDao_Impl hearingEnhancementDao_Impl;
        if (this.f19723E != null) {
            return this.f19723E;
        }
        synchronized (this) {
            try {
                if (this.f19723E == null) {
                    this.f19723E = new HearingEnhancementDao_Impl(this);
                }
                hearingEnhancementDao_Impl = this.f19723E;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hearingEnhancementDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final PersonalDressDao v() {
        PersonalDressDao_Impl personalDressDao_Impl;
        if (this.f19725G != null) {
            return this.f19725G;
        }
        synchronized (this) {
            try {
                if (this.f19725G == null) {
                    this.f19725G = new PersonalDressDao_Impl(this);
                }
                personalDressDao_Impl = this.f19725G;
            } catch (Throwable th) {
                throw th;
            }
        }
        return personalDressDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final PersonalDressSeriesDao w() {
        PersonalDressSeriesDao_Impl personalDressSeriesDao_Impl;
        if (this.H != null) {
            return this.H;
        }
        synchronized (this) {
            try {
                if (this.H == null) {
                    this.H = new PersonalDressSeriesDao_Impl(this);
                }
                personalDressSeriesDao_Impl = this.H;
            } catch (Throwable th) {
                throw th;
            }
        }
        return personalDressSeriesDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final ProvisionalWhitelistDao x() {
        ProvisionalWhitelistDao_Impl provisionalWhitelistDao_Impl;
        if (this.f19729L != null) {
            return this.f19729L;
        }
        synchronized (this) {
            try {
                if (this.f19729L == null) {
                    this.f19729L = new ProvisionalWhitelistDao_Impl(this);
                }
                provisionalWhitelistDao_Impl = this.f19729L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return provisionalWhitelistDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final SpineHistoryDataDao y() {
        SpineHistoryDataDao_Impl spineHistoryDataDao_Impl;
        if (this.f19727J != null) {
            return this.f19727J;
        }
        synchronized (this) {
            try {
                if (this.f19727J == null) {
                    this.f19727J = new SpineHistoryDataDao_Impl(this);
                }
                spineHistoryDataDao_Impl = this.f19727J;
            } catch (Throwable th) {
                throw th;
            }
        }
        return spineHistoryDataDao_Impl;
    }

    @Override // com.oplus.melody.model.db.MelodyDatabase
    public final ZenModeResourceDao z() {
        ZenModeResourceDao_Impl zenModeResourceDao_Impl;
        if (this.f19724F != null) {
            return this.f19724F;
        }
        synchronized (this) {
            try {
                if (this.f19724F == null) {
                    this.f19724F = new ZenModeResourceDao_Impl(this);
                }
                zenModeResourceDao_Impl = this.f19724F;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zenModeResourceDao_Impl;
    }
}
