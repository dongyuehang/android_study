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
	 * 定义成员变量
	 */
	Button btn_nobind,btn_bind,btngetsrv;
	ImageView iv_music,iv_lifecycle;
	Intent it,it2,it_nobind_music;	
	Myconn mc = new Myconn();//创建链接对象，绑定时使用（作为bindservice的第二个实参）
	Mybinder mb;
	boolean music_flag = false;//false:停止播放状态     true：播放状态
	/**
	 * 声明并创建侦听器对象
	 */
	View.OnClickListener ls = new View.OnClickListener() {
		@Override
		public void onClick(View v) {//回调函数的参数是指向当前的事件源对象	
			switch(v.getId()){ //获取事件源对象在界面中（xml）定义的id号
			    case R.id.btn_bind:
			    	it2 = new Intent(My1st_service.this, Bind_srv.class);
					//绑定服务,发起邦定动作        
			        bindService(it2, mc, Context.BIND_AUTO_CREATE);
			    	break;
			    case R.id.btn_nobind:
			    	it = new Intent(My1st_service.this, Nobind_srv.class);
				    startService(it);
			    	break;
			    case R.id.btn_getsrv:
			    	if(mb!=null)
						mb.getsrv();//在一个单独的按钮中获取服务，将邦定动作和获取服务动作分开（分到不同的事件处理中），线程安全			    	
			}
				
		}
	};	
	
	/**
	 * 绑定模式的链接类
	 */
	class Myconn implements ServiceConnection{
				
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {//Binder继承了接口IBinder			
			mb = (Mybinder)service;//保留代理对象的引用			
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {}
		
	}
	/**
	 * activity生命周期函数
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.my1stsrv_ly);
        //为各界面元素赋值对象
        btn_nobind = (Button) findViewById(R.id.btn_nobind);
        btn_bind = (Button) findViewById(R.id.btn_bind);
        btngetsrv = (Button) findViewById(R.id.btn_getsrv);
        iv_music = (ImageView) findViewById(R.id.iv_music);        
        iv_lifecycle = ((ImageView)findViewById(R.id.imgv));
        //设置界面元素
        iv_lifecycle.setImageResource(R.drawable.life_srv);
        iv_music.setImageResource(R.drawable.pause);        
        btngetsrv.setEnabled(false);//按钮不可用
        
        //获取服务按钮事件处理
        btngetsrv.setOnClickListener(ls);
        //绑定按钮事件处理
        btn_bind.setOnClickListener(ls);
        //非邦定按钮事件处理
        btn_nobind.setOnClickListener(ls);
        //音乐按钮事件处理
        iv_music.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//非邦定模式启动service，在service中播放音乐				
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
        //调用成员函数
        mystyle();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//在界面销毁同时销毁其启动的服务
		if(it != null)
		    stopService(it);
		if(it2 != null)
			unbindService(mc);//解除邦定，断开连接
	}
	/**
	 * 当前类的自定义成员函数
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
