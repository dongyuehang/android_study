package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * 1)创建service类，重写onbind函数
 * 2)创建bind对象，并在onbind函数中返回
 *   自定义Mybinder类继承安卓类库中android.os.Binder类
 *   在Mybinder中自定义函数，为其他组建调用。
 *   Binder类继承自IBinder接口，IBinder的主要功能源自Linux进程间通信机制
 *   Service的绑定模式其实是安卓进程间通信的一种必要的体现方式
 *   本例主要体现Service绑定的实现过程，不进行原理的详细阐述
 */
public class Bind_srv extends Service{
	Mybinder mb = new Mybinder();
	class Mybinder extends Binder{
		//可被其他组件调用的服务的函数
		public void getservice(){
			System.out.println("Service porvided ......");
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("bindsrv bind");
		return mb;//代理对象需要在onbind函数（被绑定后）返回
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("bindsrv unbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("bindsrv create");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("bindsrv destory");
	}
    //***********bind模式不会使用start函数************
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("bindsrv shold not invoke this method");
		return super.onStartCommand(intent, flags, startId);
	}
}
