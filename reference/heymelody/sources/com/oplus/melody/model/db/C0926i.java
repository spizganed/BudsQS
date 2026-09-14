package com.oplus.melody.model.db;

/* JADX INFO: renamed from: com.oplus.melody.model.db.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConnectedDeviceDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C0926i extends G0.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f19771j;

    @Override // G0.c
    public final void b(q1.c cVar, Object obj) {
        switch (this.f19771j) {
            case 0:
                C0929m c0929m = (C0929m) obj;
                if (c0929m.getId() == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, c0929m.getId());
                }
                if (c0929m.getName() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, c0929m.getName());
                }
                if (c0929m.getBrand() == null) {
                    cVar.a(3);
                } else {
                    cVar.V(3, c0929m.getBrand());
                }
                if (c0929m.getType() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, c0929m.getType());
                }
                if (c0929m.getCoverImage() == null) {
                    cVar.a(5);
                } else {
                    cVar.V(5, c0929m.getCoverImage());
                }
                if (c0929m.getMacAddress() == null) {
                    cVar.a(6);
                } else {
                    cVar.V(6, c0929m.getMacAddress());
                }
                cVar.h(7, c0929m.mTime);
                break;
            default:
                E e10 = (E) obj;
                if (e10.getMacAddress() == null) {
                    cVar.a(1);
                } else {
                    cVar.V(1, e10.getMacAddress());
                }
                if (e10.getProductId() == null) {
                    cVar.a(2);
                } else {
                    cVar.V(2, e10.getProductId());
                }
                cVar.h(3, e10.getColorId());
                if (e10.getName() == null) {
                    cVar.a(4);
                } else {
                    cVar.V(4, e10.getName());
                }
                cVar.h(5, e10.getAutoOTASwitch());
                cVar.h(6, e10.getChannelSwitch());
                if (e10.getPopTheme() == null) {
                    cVar.a(7);
                } else {
                    cVar.V(7, e10.getPopTheme());
                }
                cVar.h(8, e10.getMultiConversationSwitch());
                cVar.h(9, e10.getReconnectPopupSwitch());
                break;
        }
    }

    @Override // G0.c
    public final String c() {
        switch (this.f19771j) {
            case 0:
                return "INSERT OR IGNORE INTO `connected_device` (`product_id`,`product_name`,`product_brand`,`product_type`,`cover_image`,`mac_address`,`time`) VALUES (?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `melody_equipment` (`macAddress`,`productId`,`colorId`,`name`,`autoOTASwitch`,`channelSwitch`,`popTheme`,`multiConversationSwitch`,`reconnectPopupSwitch`) VALUES (?,?,?,?,?,?,?,?,?)";
        }
    }
}
