package qdu.szmt.ch1_intent;

import qdu.szmt.ch1_intent.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Myintent extends Activity{
	Button btn_im;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myintent);
		
		btn_im = (Button) findViewById(R.id.btn_implicit);
		btn_im.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent("myaction", Uri.parse("myqdu://datatech.rjgc"));
				//�Զ������ʽ��ת
				//intent��һ������Ϊ�ַ���,ָ��action��ֵ.
				//�ڶ�������Ϊ��׼URI��ʽ����ӦЭ�飨scheme��������/������/IP��host�����˿ڣ�port����·����path��
				//scheme://host:port/path
				//�����Զ���intent����androidϵͳ��ȥ����intent filter����ѡ��
				//intent fileterΪandroid���ע��ʱ����ָ��������
				startActivity(it);
			}
		});
		
		findViewById(R.id.btn_explicit).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	            startActivity( new Intent(Myintent.this, Act_explicit.class) );
			}
		});
	}

}
