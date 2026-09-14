package com.oplus.melody.app.discovery;

import com.oplus.melody.model.repository.earphone.EarphoneDTO;
import java.util.function.Function;

/* JADX INFO: renamed from: com.oplus.melody.app.discovery.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0864k0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DiscoveryDialogViewModel f19125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EarphoneDTO f19127d;

    public /* synthetic */ C0864k0(DiscoveryDialogViewModel discoveryDialogViewModel, String str, EarphoneDTO earphoneDTO, int i10) {
        this.f19124a = i10;
        this.f19125b = discoveryDialogViewModel;
        this.f19126c = str;
        this.f19127d = earphoneDTO;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        E0 e02 = (E0) obj;
        switch (this.f19124a) {
        }
        return this.f19125b.d(this.f19126c, this.f19127d, e02);
    }
}
