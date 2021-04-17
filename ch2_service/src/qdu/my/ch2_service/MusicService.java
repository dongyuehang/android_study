package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service{
	static boolean isplay;//��¼��ǰ����״̬
	MediaPlayer player;
	Music_binder mb = new Music_binder();
	class Music_binder extends Binder{
		public void startmusic(){
			if(!player.isPlaying()){
				player.start();//��û�в��ţ��򲥷�����
				isplay=player.isPlaying();//���õ�ǰ״̬Ϊ���ڲ�������
				System.out.println("���ַ���ʼ isplay: "+ isplay);
			}
		}
		public void stopmusic(){
			if(player.isPlaying()){
			    player.pause();
			    isplay=player.isPlaying();
			    System.out.println("���ַ�����ͣ isplay: " + isplay);
			}//player.release();
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("���ַ������");
		return null;//mb;
	}
	
	
	@Override
	public boolean onUnbind(Intent intent) {
//		System.out.println("���ַ�������");
//		if(player != null)
//			player.stop();
//		    player.release();
		return super.onUnbind(intent);
	}


	@Override
	public void onCreate() {
		//����MediaPlayer���󣬲����ز��ŵ�����
		player=MediaPlayer.create(this, R.raw.main);
		super.onCreate();
		System.out.println("���ַ�����󴴽�");
	}
	
	//�������ֵĲ���
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(!player.isPlaying()){
			player.start();//��û�в��ţ��򲥷�����
			isplay=player.isPlaying();//���õ�ǰ״̬Ϊ���ڲ�������
			System.out.println("onstart, ���ַ���ʼ");
		}
		return super.onStartCommand(intent, flags, startId);
	}
	//����ֹͣʱ��ֹͣ���ֵĲ���
	@Override
	public void onDestroy() {
		player.stop();
		isplay=player.isPlaying();//����״̬Ϊֹͣ״̬
		player.release();//�ͷ���Դ
		super.onDestroy();
		System.out.println("���ַ�������ͷ�");
	}
}
