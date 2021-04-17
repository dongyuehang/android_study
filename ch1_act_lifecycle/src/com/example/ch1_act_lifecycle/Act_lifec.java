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
		
		//找到控件的指针(引用)
        findViewById(R.id.btn_ch).setOnClickListener(
        		//new Mylistener()
        		new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//System.out.println("btn  pressed");
					//显式intent 跳转
					Intent it = new Intent(Act_lifec.this, Act_next.class);//从哪来，到哪去					
					//调用利用intent产生组建切换的函数
					startActivity(it);
					//组建之间的跳转有主从关系，主从关系参考栈结构
				}
			});//匿名对象
	        
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
