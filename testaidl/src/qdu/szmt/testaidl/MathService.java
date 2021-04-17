package qdu.szmt.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MathService extends Service{
    IMathSrv.Stub ims = new IMathSrv.Stub() {
		@Override
		public long Add(long a, long b) throws RemoteException {
			return a+b;
		}
	};
	@Override
	public IBinder onBind(Intent intent) {
		return ims;
	}
	@Override
	public boolean onUnbind(Intent intent) {
		return super.onUnbind(intent);
	}

}
