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
	Intent it,it2;
	Myconn mc = new Myconn();//�������Ӷ��󣬰�ʱʹ�ã���Ϊbindservice�ĵڶ���ʵ�Σ�
	Mybinder mb;
	//��ģʽ��������
	class Myconn implements ServiceConnection{
		//�ýӿ���������Ҫ��д�ĺ���
		//connected�����������ӳɹ������
		//disconnected�����ӷ������Ͽ������
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {//Binder�̳��˽ӿ�IBinder
			//��һ������Ϊ���������ƣ�����ʹ��
			//�ڶ�������Ϊ���նˣ����񣩷��صĴ������
			mb = (Mybinder)service;//����������������
			//((Mybinder)service).getsrv();//��ȡservice�ṩ�ķ��������ȡ�������̰߳�ȫ��
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.my1stsrv_ly);
        
        ((ImageView)findViewById(R.id.imgv)).setImageResource(R.drawable.life_srv);
        Button btngetsrv = (Button) findViewById(R.id.btn_getsrv);
        btngetsrv.setEnabled(false);//��ť������
        //��ȡ����ť�¼�����
        btngetsrv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mb!=null)
					mb.getsrv();//��һ�������İ�ť�л�ȡ���񣬽�������ͻ�ȡ�������ֿ����ֵ���ͬ���¼������У����̰߳�ȫ
			}
		});
        //�󶨰�ť�¼�����
        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				it2 = new Intent(My1st_service.this, Bind_srv.class);
				//�󶨷���,��������        
		        bindService(it2, mc, Context.BIND_AUTO_CREATE);
		        //mb.getsrv();//�������ȡ�ɹ�����Ȼ�ǰ֮������Ż�ȡ���񣬵���bindservice��������Ż�ȡ����ᷢ���쳣
		        //��Ϊ��bindservice����Ϊ�첽ִ�У����̣߳�
		        
		        //��һ������Ϊintent
		        //�ڶ�������Ϊ���Ӷ���
		        //�����������Ǳ�ǣ������Ƿ��ڰ󶨵�ͬʱ������������Ƿ��ڷ�������ͬʱҲ������������
		        //��������������ֶ����٣���������������ٺ��Զ����١�
		        //һ�����������ֶ��Ľ��� ����unbindservice
			}
		});
        //�ǰ��ť�¼�����
        findViewById(R.id.btn_nobind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//�ǰ�ģʽ��startservice�������ú�,�ᴴ��service����ͬʱ��������
				//�ǰ󶨵�service��Ҫ�ֶ�stop��һ���ڸ�Activity��ondestory������ִ��
				//����ʹ��activity��ջ���٣�������Ȼ����
				it = new Intent(My1st_service.this, Nobind_srv.class);
			    startService(it);	
			}
		});
        
        
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
		//�ڽ�������ͬʱ�����������ķ���
		if(it != null)
		    stopService(it);
		if(it2 != null)
			unbindService(mc);//�������Ͽ�����
	}
}
