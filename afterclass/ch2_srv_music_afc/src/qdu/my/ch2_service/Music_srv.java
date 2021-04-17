package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
//Mediaplayer是android提供的媒体处理工具
public class Music_srv extends Service{
    MediaPlayer mp;
    static boolean music_flag;
    //媒体对象在onreate中创建，在onstartcommand中播放，在ondestroy中销毁
	@Override
	public void onCreate(){
		super.onCreate();
		//在service创建同时创建音乐服务工具对象
		mp = MediaPlayer.create(this, R.raw.main);
		//自组装函数create创建媒体工具对象,并绑定媒体资源
		//第一个参数为该对象依附的安卓组件，第二个参数为媒体资源id		
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//System.out.println("music started.....");
		if(mp !=null)
			if(!mp.isPlaying()){//判断播放状态，返回布尔类型
		       mp.start();//播放
		       music_flag = mp.isPlaying();
			}
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		//System.out.println("music stopped.....");
		if(mp != null){
			if(mp.isPlaying()){
		        mp.pause();//停止播放
		        music_flag = mp.isPlaying();
			}
		    mp.release();//释放媒体对象
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
