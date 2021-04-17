package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Nobind_srv extends Service{
    /**
     * oncreate onstartcommand ondestroy是非绑定模式生命周期函数
     */
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("nobind create");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("nobind start");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("nobind destory");
	}
    /**
     * 	oncreate onbind  onunbind ondetory是绑定模式生命周期函数
     */
	@Override
	public IBinder onBind(Intent intent) {
		//不管哪种启动方式，必须重写的函数
		System.out.println("srv bind");
		return null;
	}
}
