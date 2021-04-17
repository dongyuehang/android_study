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
	Intent music_srv1;//启动/停止音乐服务的intent
	Mybinder mb1; Music_binder mb2;
	Myconn mc = new Myconn();
	class Myconn implements ServiceConnection{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//服务连接成功后调用
			//第一个参数是标记，唯一标示连接（名称）
			//在连接成功后，有服务对象提供给发起者的代理（binder）对象，即第二个参数
			mb1 = (Mybinder)service;
//			if(service != null){
//				((Mybinder)service).getservice();
//			}
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {
			//服务连接非正常断开调用
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
        
        //非绑定按钮事件处理
        findViewById(R.id.btn_nobind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//非绑定的service需要手动stop，一般在该Activity的ondestory函数中执行
				//否则即使该activity出栈销毁，服务仍然运行
				srv_it = new Intent(My1st_service.this, Nobind_srv.class);
			    startService(srv_it);	
			}
		});
        
        //绑定按钮事件处理
        //绑定模式可以在绑定service后（服务启动后），随时（不需要销毁服务对象，并重建）访问服务（获取服务对象提供的功能）
        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				srv_it2 = new Intent(My1st_service.this, Bind_srv.class);
				bindService(srv_it2, mc, Context.BIND_AUTO_CREATE);
				/**
				 * 绑定模式通过bindservice函数实现
				 * 其第二个参数为绑定模式的通信功能对象，由系统提供通信服务对象，该对象需要继承后创建
				 * 1）自定义类继承ServiceConnection
				 * 2) 重写onServiceConnected函数，并通过参数获取服务端Binder对象
				 * 3）根据binder对象调取服务端定义的函数
				 * 第三个参数做为标记，决定一些特殊功能
				 * 比如绑定时是否创建服务对象，销毁服务时是否也销毁启动组件的对象等
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
        
        //准备好启动/停止音乐服务的intent对象
        music_srv1 = new Intent(this, MusicService.class);
        //bindService(music_srv1, new Music_conn(), Context.BIND_AUTO_CREATE);
        //注册音乐服务的交互控件的事件处理
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
	//音乐播放暂停的监听器对象
	View.OnClickListener music_srv_listener=new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			//启动和停止MusicService
			if(MusicService.isplay==false){//判断当前播放状态
				startService(music_srv1);//启动
				//mb2.startmusic();
				((ImageView)v).setImageDrawable(getResources().getDrawable(R.drawable.start));//设置图片为start
			}else{
				stopService(music_srv1);//停止
				//mb2.stopmusic();
				((ImageView)v).setImageDrawable(getResources().getDrawable(R.drawable.pause));//设置图片为pause
			}			
		}		
	};
}
