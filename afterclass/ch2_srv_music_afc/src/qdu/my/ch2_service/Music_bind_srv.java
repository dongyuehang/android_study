package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class Music_bind_srv extends Service{
	static boolean music_flag_bind;
	MediaPlayer mp;
    //�����ģʽ���ַ���Ĵ�����
	class Music_binder extends Binder{
		public void m_play(){//���ֲ��ŷ�����
			if(mp != null && !mp.isPlaying()){
			    mp.start();
			    mp.setLooping(true);
			    music_flag_bind = mp.isPlaying();
			    //System.out.println("music started....  music_flag_bind:" + music_flag_bind);
			}
		}
		public void m_pause(){//������ͣ������
			//System.out.println("pause service... music_flag_bind:" + music_flag_bind);
			if(mp!= null && mp.isPlaying()){
				mp.pause();
				music_flag_bind = mp.isPlaying();
				//System.out.println("music should have stopped ..... music_flag_bind:" + music_flag_bind);
			}
		}
	}
	Music_binder mb = new Music_binder();
	@Override
	public IBinder onBind(Intent intent) {
		return mb;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		if(mp == null)
		    mp = MediaPlayer.create(this, R.raw.main);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(mp != null){
			mp.stop();
			mp.release();
		}
	}
	
	
}
