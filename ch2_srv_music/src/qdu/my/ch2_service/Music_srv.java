package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Music_srv extends Service{
    
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("music started.....");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("music stopped.....");
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
