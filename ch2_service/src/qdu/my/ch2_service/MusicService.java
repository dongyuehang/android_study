package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service{
	static boolean isplay;//记录当前播放状态
	MediaPlayer player;
	Music_binder mb = new Music_binder();
	class Music_binder extends Binder{
		public void startmusic(){
			if(!player.isPlaying()){
				player.start();//若没有播放，则播放音乐
				isplay=player.isPlaying();//设置当前状态为正在播放音乐
				System.out.println("音乐服务开始 isplay: "+ isplay);
			}
		}
		public void stopmusic(){
			if(player.isPlaying()){
			    player.pause();
			    isplay=player.isPlaying();
			    System.out.println("音乐服务暂停 isplay: " + isplay);
			}//player.release();
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("音乐服务就绪");
		return null;//mb;
	}
	
	
	@Override
	public boolean onUnbind(Intent intent) {
//		System.out.println("音乐服务解除绑定");
//		if(player != null)
//			player.stop();
//		    player.release();
		return super.onUnbind(intent);
	}


	@Override
	public void onCreate() {
		//创建MediaPlayer对象，并加载播放的音乐
		player=MediaPlayer.create(this, R.raw.main);
		super.onCreate();
		System.out.println("音乐服务对象创建");
	}
	
	//控制音乐的播放
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(!player.isPlaying()){
			player.start();//若没有播放，则播放音乐
			isplay=player.isPlaying();//设置当前状态为正在播放音乐
			System.out.println("onstart, 音乐服务开始");
		}
		return super.onStartCommand(intent, flags, startId);
	}
	//服务停止时，停止音乐的播放
	@Override
	public void onDestroy() {
		player.stop();
		isplay=player.isPlaying();//设置状态为停止状态
		player.release();//释放资源
		super.onDestroy();
		System.out.println("音乐服务对象释放");
	}
}
