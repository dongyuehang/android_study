package com.example.ch1_act_lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act_lifec extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_lifec);
		
		//�ҵ��ؼ���ָ��(����)
        findViewById(R.id.btn_ch).setOnClickListener(
        		//new Mylistener()
        		new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//System.out.println("btn  pressed");
					//��ʽintent ��ת
					Intent it = new Intent(Act_lifec.this, Act_next.class);//������������ȥ					
					//��������intent�����齨�л��ĺ���
					startActivity(it);
					//�齨֮�����ת�����ӹ�ϵ�����ӹ�ϵ�ο�ջ�ṹ
				}
			});//��������
	        
			System.out.println("act1 : create");//Log.i()
		 }
//	class Mylistener implements View.OnClickListener{
//		@Override
//		public void onClick(View v) {
//			System.out.println("btn  pressed");
//		}		
//	}

	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("act1 : start");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		System.out.println("act1 : restart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("act1 : resume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("act1 : pause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("act1 : stop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("act1 : destroy");
	}
	
	

}
