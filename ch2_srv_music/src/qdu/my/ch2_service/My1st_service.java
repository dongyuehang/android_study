package qdu.my.ch2_service;


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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import qdu.my.ch2_service.Bind_srv.Mybinder;


public class My1st_service extends Activity{
	/**
	 * �����Ա����
	 */
	Button btn_nobind,btn_bind,btngetsrv;
	ImageView iv_music,iv_lifecycle;
	Intent it,it2,it_nobind_music;	
	Myconn mc = new Myconn();//�������Ӷ��󣬰�ʱʹ�ã���Ϊbindservice�ĵڶ���ʵ�Σ�
	Mybinder mb;
	boolean music_flag = false;//false:ֹͣ����״̬     true������״̬
	/**
	 * ��������������������
	 */
	View.OnClickListener ls = new View.OnClickListener() {
		@Override
		public void onClick(View v) {//�ص������Ĳ�����ָ��ǰ���¼�Դ����	
			switch(v.getId()){ //��ȡ�¼�Դ�����ڽ����У�xml�������id��
			    case R.id.btn_bind:
			    	it2 = new Intent(My1st_service.this, Bind_srv.class);
					//�󶨷���,��������        
			        bindService(it2, mc, Context.BIND_AUTO_CREATE);
			    	break;
			    case R.id.btn_nobind:
			    	it = new Intent(My1st_service.this, Nobind_srv.class);
				    startService(it);
			    	break;
			    case R.id.btn_getsrv:
			    	if(mb!=null)
						mb.getsrv();//��һ�������İ�ť�л�ȡ���񣬽�������ͻ�ȡ�������ֿ����ֵ���ͬ���¼������У����̰߳�ȫ			    	
			}
				
		}
	};	
	
	/**
	 * ��ģʽ��������
	 */
	class Myconn implements ServiceConnection{
				
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {//Binder�̳��˽ӿ�IBinder			
			mb = (Mybinder)service;//����������������			
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {}
		
	}
	/**
	 * activity�������ں���
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.my1stsrv_ly);
        //Ϊ������Ԫ�ظ�ֵ����
        btn_nobind = (Button) findViewById(R.id.btn_nobind);
        btn_bind = (Button) findViewById(R.id.btn_bind);
        btngetsrv = (Button) findViewById(R.id.btn_getsrv);
        iv_music = (ImageView) findViewById(R.id.iv_music);        
        iv_lifecycle = ((ImageView)findViewById(R.id.imgv));
        //���ý���Ԫ��
        iv_lifecycle.setImageResource(R.drawable.life_srv);
        iv_music.setImageResource(R.drawable.pause);        
        btngetsrv.setEnabled(false);//��ť������
        
        //��ȡ����ť�¼�����
        btngetsrv.setOnClickListener(ls);
        //�󶨰�ť�¼�����
        btn_bind.setOnClickListener(ls);
        //�ǰ��ť�¼�����
        btn_nobind.setOnClickListener(ls);
        //���ְ�ť�¼�����
        iv_music.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//�ǰģʽ����service����service�в�������				
				if(music_flag){
					iv_music.setImageResource(R.drawable.pause);
				    music_flag = false;
				    if(it_nobind_music != null)
				         stopService(it_nobind_music);
				}else{
					iv_music.setImageResource(R.drawable.start);
					music_flag = true;
					it_nobind_music = new Intent(My1st_service.this, Music_srv.class);
					startService(it_nobind_music);
				}
				    
			}
		});
        //���ó�Ա����
        mystyle();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//�ڽ�������ͬʱ�����������ķ���
		if(it != null)
		    stopService(it);
		if(it2 != null)
			unbindService(mc);//�������Ͽ�����
	}
	/**
	 * ��ǰ����Զ����Ա����
	 */
	public void mystyle(){
		//*****************************styles*************************
        String send_code = this.getString(R.string.basic_qdu_steps);
        SpannableString spstr = new SpannableString(send_code);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spstr.setSpan(colorSpan, spstr.length()-4, spstr.length()-2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spstr.setSpan(new StrikethroughSpan(), spstr.length()-4, spstr.length()-2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        TextView sendcode = (TextView)findViewById(R.id.tv_steps);
        sendcode.setText(spstr);
	}
}
