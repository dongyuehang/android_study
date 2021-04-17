package qdu.my.ch2_service;


import qdu.my.ch2_service.Bind_srv.Mybinder;
import qdu.my.ch2_service.MusicService.Music_binder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class My1st_service extends Activity{
	Intent srv_it, srv_it2;
	Intent music_srv1;//����/ֹͣ���ַ����intent
	Mybinder mb1; Music_binder mb2;
	Myconn mc = new Myconn();
	class Myconn implements ServiceConnection{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//�������ӳɹ������
			//��һ�������Ǳ�ǣ�Ψһ��ʾ���ӣ����ƣ�
			//�����ӳɹ����з�������ṩ�������ߵĴ���binder�����󣬼��ڶ�������
			mb1 = (Mybinder)service;
//			if(service != null){
//				((Mybinder)service).getservice();
//			}
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {
			//�������ӷ������Ͽ�����
		}		
	}
	class Music_conn implements ServiceConnection{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mb2 = (Music_binder)service;
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {	}		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.my1stsrv_ly);
        
        ((ImageView)findViewById(R.id.imgv)).setImageResource(R.drawable.life_srv);
        
        //�ǰ󶨰�ť�¼�����
        findViewById(R.id.btn_nobind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//�ǰ󶨵�service��Ҫ�ֶ�stop��һ���ڸ�Activity��ondestory������ִ��
				//����ʹ��activity��ջ���٣�������Ȼ����
				srv_it = new Intent(My1st_service.this, Nobind_srv.class);
			    startService(srv_it);	
			}
		});
        
        //�󶨰�ť�¼�����
        //��ģʽ�����ڰ�service�󣨷��������󣩣���ʱ������Ҫ���ٷ�����󣬲��ؽ������ʷ��񣨻�ȡ��������ṩ�Ĺ��ܣ�
        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				srv_it2 = new Intent(My1st_service.this, Bind_srv.class);
				bindService(srv_it2, mc, Context.BIND_AUTO_CREATE);
				/**
				 * ��ģʽͨ��bindservice����ʵ��
				 * ��ڶ�������Ϊ��ģʽ��ͨ�Ź��ܶ�����ϵͳ�ṩͨ�ŷ�����󣬸ö�����Ҫ�̳к󴴽�
				 * 1���Զ�����̳�ServiceConnection
				 * 2) ��дonServiceConnected��������ͨ��������ȡ�����Binder����
				 * 3������binder�����ȡ����˶���ĺ���
				 * ������������Ϊ��ǣ�����һЩ���⹦��
				 * �����ʱ�Ƿ񴴽�����������ٷ���ʱ�Ƿ�Ҳ������������Ķ����
				 */
			}
		});
        //
        findViewById(R.id.btn_getsrv).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mb1.getservice();		
			}
		});
        
        //׼��������/ֹͣ���ַ����intent����
        music_srv1 = new Intent(this, MusicService.class);
        //bindService(music_srv1, new Music_conn(), Context.BIND_AUTO_CREATE);
        //ע�����ַ���Ľ����ؼ����¼�����
        findViewById(R.id.iv_musicsrv).setOnClickListener(music_srv_listener);
      //*****************************styles*************************
        String send_code = this.getString(R.string.basic_qdu_steps);
        SpannableString spstr = new SpannableString(send_code);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spstr.setSpan(colorSpan, spstr.length()-4, spstr.length()-2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spstr.setSpan(new StrikethroughSpan(), spstr.length()-4, spstr.length()-2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        TextView sendcode = (TextView)findViewById(R.id.tv_steps);
        sendcode.setText(spstr);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		stopService(srv_it);
		unbindService(mc);
		System.out.println("main activity destory");
	}
    //*********************Music service*********************
	//���ֲ�����ͣ�ļ���������
	View.OnClickListener music_srv_listener=new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			//������ֹͣMusicService
			if(MusicService.isplay==false){//�жϵ�ǰ����״̬
				startService(music_srv1);//����
				//mb2.startmusic();
				((ImageView)v).setImageDrawable(getResources().getDrawable(R.drawable.start));//����ͼƬΪstart
			}else{
				stopService(music_srv1);//ֹͣ
				//mb2.stopmusic();
				((ImageView)v).setImageDrawable(getResources().getDrawable(R.drawable.pause));//����ͼƬΪpause
			}			
		}		
	};
}
