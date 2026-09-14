package com.oplus.melody.model.repository.earphone;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ L f20009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f20010c;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f20011p;

    public /* synthetic */ y(L l4, String str, int i10, int i11) {
        this.f20008a = i11;
        this.f20009b = l4;
        this.f20010c = str;
        this.f20011p = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f20008a) {
            case 0:
                this.f20009b.f19932u.g(this.f20011p, this.f20010c);
                break;
            default:
                this.f20009b.f19932u.k(this.f20011p, this.f20010c);
                break;
        }
    }
}
