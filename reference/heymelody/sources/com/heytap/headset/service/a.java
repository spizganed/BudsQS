package com.heytap.headset.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IKeepAliveFgInterface.java */
/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {
    void E() throws RemoteException;

    /* JADX INFO: renamed from: com.heytap.headset.service.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IKeepAliveFgInterface.java */
    public static abstract class AbstractBinderC0208a extends Binder implements a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f17600e = 0;

        /* JADX INFO: renamed from: com.heytap.headset.service.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IKeepAliveFgInterface.java */
        public static class C0209a implements a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public IBinder f17601e;

            @Override // com.heytap.headset.service.a
            public final void E() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.heytap.headset.service.IKeepAliveFgInterface");
                    this.f17601e.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f17601e;
            }
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface("com.heytap.headset.service.IKeepAliveFgInterface");
            }
            if (i10 == 1598968902) {
                parcel2.writeString("com.heytap.headset.service.IKeepAliveFgInterface");
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            ((KeepAliveFgService$binder$1) this).E();
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
