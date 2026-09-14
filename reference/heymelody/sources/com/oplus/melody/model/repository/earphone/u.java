package com.oplus.melody.model.repository.earphone;

import android.os.RemoteException;
import com.oplus.melody.btsdk.api.data.VersionInfo;
import com.oplus.melody.common.data.WhitelistConfigDTO;
import com.oplus.melody.model.constant.CallSummaryStatusType;
import com.oplus.melody.model.db.PersonalDressSeriesDao;
import com.oplus.melody.model.db.PersonalDressSeriesEntity;
import com.oplus.melody.model.net.data.PersonalDressInfoDO;
import com.oplus.melody.model.repository.personaldress.DressBySeriesDTO;
import com.oplus.melody.model.repository.personaldress.DressSeriesDTO;
import com.oplus.melody.model.repository.personaldress.PersonalDressDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s8.AbstractC1508a;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements Wb.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19990a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19992c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f19993p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ K7.b f19994q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f19995r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f19996s;

    public /* synthetic */ u(L l4, EarphoneDTO earphoneDTO, UserInteractionDTO userInteractionDTO, int i10, int i11, String str) {
        this.f19994q = l4;
        this.f19995r = earphoneDTO;
        this.f19996s = userInteractionDTO;
        this.f19992c = i10;
        this.f19993p = i11;
        this.f19991b = str;
    }

    @Override // Wb.l
    public final Object d(Object obj) throws RemoteException {
        Va.b bVar;
        List<DressSeriesDTO.SeriesData> seriesList;
        WhitelistConfigDTO.Function function;
        switch (this.f19990a) {
            case 0:
                CallSummaryStatusType callSummaryStatusType = (CallSummaryStatusType) obj;
                L l4 = (L) this.f19994q;
                l4.getClass();
                com.oplus.melody.common.util.A.c("EarphoneRepository", new S7.c(callSummaryStatusType, 27));
                int iOrdinal = callSummaryStatusType.ordinal();
                String str = (iOrdinal == 0 || (iOrdinal != 1 && iOrdinal == 2)) ? "start_global_summary" : "stop_global_summary";
                O7.f fVarB = O7.f.b();
                t tVar = new t(l4, (EarphoneDTO) this.f19995r, (UserInteractionDTO) this.f19996s, this.f19992c, this.f19993p, this.f19991b, 1);
                fVarB.getClass();
                com.oplus.melody.common.util.A.c("AISummaryHelper", new Ca.b(str, 6));
                fVarB.f3624g = tVar;
                if (str.equals("start_global_summary")) {
                    Va.b bVar2 = fVarB.f3621d;
                    if (bVar2 != null) {
                        bVar2.L();
                    }
                } else if (str.equals("stop_global_summary") && (bVar = fVarB.f3621d) != null) {
                    bVar.v0();
                }
                return null;
            default:
                List list = (List) obj;
                com.oplus.melody.common.util.A.c("PersonalDressRepository", new com.oplus.melody.model.repository.zenmode.p(1, (String) this.f19995r, list));
                AbstractC1508a abstractC1508aF = AbstractC1508a.f();
                String str2 = this.f19991b;
                DressSeriesDTO.SeriesData seriesData = null;
                Object obj2 = null;
                seriesData = null;
                WhitelistConfigDTO whitelistConfigDTOC = abstractC1508aF.c(str2, null);
                List<WhitelistConfigDTO.DressFilter> dressFilterList = (whitelistConfigDTOC == null || (function = whitelistConfigDTOC.getFunction()) == null) ? null : function.getDressFilterList();
                kotlin.jvm.internal.h.b(list);
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    com.oplus.melody.model.repository.personaldress.e eVar = (com.oplus.melody.model.repository.personaldress.e) this.f19994q;
                    if (!zHasNext) {
                        int i10 = this.f19992c;
                        DressSeriesDTO dressSeriesDTOF = eVar.F(i10, str2);
                        int i11 = this.f19993p;
                        if (dressSeriesDTOF != null && (seriesList = dressSeriesDTOF.getSeriesList()) != null) {
                            Iterator<T> it2 = seriesList.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    Object next = it2.next();
                                    if (((DressSeriesDTO.SeriesData) next).getId() == i11) {
                                        obj2 = next;
                                    }
                                }
                            }
                            seriesData = (DressSeriesDTO.SeriesData) obj2;
                        }
                        int i12 = 0;
                        if (seriesData != null) {
                            PersonalDressSeriesEntity personalDressSeriesEntity = new PersonalDressSeriesEntity();
                            personalDressSeriesEntity.setPrimaryId(seriesData.getPrimaryId());
                            personalDressSeriesEntity.setMProductId(str2);
                            personalDressSeriesEntity.setMColorId(i10);
                            personalDressSeriesEntity.setId(seriesData.getId());
                            personalDressSeriesEntity.setIdentifyId(seriesData.getIdentifyId());
                            personalDressSeriesEntity.setSeriesName(seriesData.getSeriesName());
                            personalDressSeriesEntity.setSummary(seriesData.getSummary());
                            personalDressSeriesEntity.setPriority(seriesData.getPriority());
                            personalDressSeriesEntity.setThemeCount(seriesData.getThemeCount());
                            personalDressSeriesEntity.setBannerImgUrl(seriesData.getBannerImgUrl());
                            personalDressSeriesEntity.setCreateTime(seriesData.getCreateTime());
                            personalDressSeriesEntity.setUpdateTime(seriesData.getUpdateTime());
                            personalDressSeriesEntity.setBottomColor(seriesData.getBottomColor());
                            ArrayList arrayList2 = new ArrayList(Kb.m.i(arrayList));
                            int size = arrayList.size();
                            int i13 = 0;
                            while (i13 < size) {
                                Object obj3 = arrayList.get(i13);
                                i13++;
                                String themeIdentifier = ((PersonalDressInfoDO) obj3).getThemeIdentifier();
                                if (themeIdentifier == null) {
                                    themeIdentifier = VersionInfo.VENDOR_CODE_ERROR_VERSION;
                                }
                                arrayList2.add(themeIdentifier);
                            }
                            personalDressSeriesEntity.setThemeIdList(Kb.q.G(arrayList2));
                            PersonalDressSeriesDao personalDressSeriesDao = eVar.f20074t;
                            if (personalDressSeriesDao != null) {
                                personalDressSeriesDao.e(personalDressSeriesEntity);
                            }
                        }
                        DressBySeriesDTO dressBySeriesDTO = new DressBySeriesDTO(0, null, 0, null, 15, null);
                        dressBySeriesDTO.setProductId(str2);
                        dressBySeriesDTO.setColor(i10);
                        dressBySeriesDTO.setSeriesId(i11);
                        ArrayList arrayList3 = new ArrayList(Kb.m.i(arrayList));
                        int size2 = arrayList.size();
                        while (i12 < size2) {
                            Object obj4 = arrayList.get(i12);
                            i12++;
                            PersonalDressInfoDO personalDressInfoDO = (PersonalDressInfoDO) obj4;
                            PersonalDressDTO.PersonalDressData personalDressData = new PersonalDressDTO.PersonalDressData(null, 0, 0, null, null, null, 0, null, null, null, null, 0, null, 0, 0, null, null, 0, null, null, null, null, null, null, 0, null, null, null, 0, null, 0, 0, null, null, null, 0, false, -1, 31, null);
                            kotlin.jvm.internal.h.b(personalDressInfoDO);
                            com.oplus.melody.model.repository.personaldress.e.P(personalDressData, personalDressInfoDO, (String) this.f19996s);
                            arrayList3.add(personalDressData);
                        }
                        dressBySeriesDTO.setPersonalDressData(arrayList3);
                        return dressBySeriesDTO;
                    }
                    Object next2 = it.next();
                    if (eVar.C(((PersonalDressInfoDO) next2).getThemeIdentifier(), dressFilterList)) {
                        arrayList.add(next2);
                    }
                }
                break;
        }
    }

    public /* synthetic */ u(String str, com.oplus.melody.model.repository.personaldress.e eVar, int i10, String str2, int i11, String str3) {
        this.f19991b = str;
        this.f19994q = eVar;
        this.f19992c = i10;
        this.f19995r = str2;
        this.f19993p = i11;
        this.f19996s = str3;
    }
}
