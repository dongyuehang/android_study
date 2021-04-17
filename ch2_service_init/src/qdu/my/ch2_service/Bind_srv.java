package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * 绑定模式：
 * 1）创建服务类继承service，重写必要的绑定模式的生命周期函数，在清单文件注册
 * 2）绑定模式是通过android IPC来实现的，因此需要处理链接对象
 *   接收端：
 *      a.定义代理类继承Binder，并创建代理对象
 *      b.将service要提供的服务定义在该类中（作为成员函数）
 *      c.将代理对象在onbind函数中返回
 *   启动端：
 *      a.定义链接类继承ServiceConnection接口，并创建链接对象
 *      b.若邦定后能够链接成功，则可以获取服务提供的代理对象，并从中获取服务
 *      c.在启动端通过bindservice函数绑定服务
 */
public class Bind_srv extends Service{
	class Mybinder extends Binder{
		public void getsrv(){
			System.out.println("srv provided.......");
		}
	}
	Mybinder mb = new Mybinder();
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("bind srv create");
	}
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("bind srv on bind");
		return mb;//返回代理对象
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("bind srv destroy");
	}
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("bind srv unbind");
		return super.onUnbind(intent);
	}
	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		System.out.println("bind srv rebind");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("bind srv onstart");
		return super.onStartCommand(intent, flags, startId);
	}

}
