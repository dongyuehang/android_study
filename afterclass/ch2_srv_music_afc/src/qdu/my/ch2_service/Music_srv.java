package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
//Mediaplayer��android�ṩ��ý�崦����
public class Music_srv extends Service{
    MediaPlayer mp;
    static boolean music_flag;
    //ý�������onreate�д�������onstartcommand�в��ţ���ondestroy������
	@Override
	public void onCreate(){
		super.onCreate();
		//��service����ͬʱ�������ַ��񹤾߶���
		mp = MediaPlayer.create(this, R.raw.main);
		//����װ����create����ý�幤�߶���,����ý����Դ
		//��һ������Ϊ�ö��������İ�׿������ڶ�������Ϊý����Դid		
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//System.out.println("music started.....");
		if(mp !=null)
			if(!mp.isPlaying()){//�жϲ���״̬�����ز�������
		       mp.start();//����
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
		        mp.pause();//ֹͣ����
		        music_flag = mp.isPlaying();
			}
		    mp.release();//�ͷ�ý�����
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
