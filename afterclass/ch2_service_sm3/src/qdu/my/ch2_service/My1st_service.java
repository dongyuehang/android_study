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
	Myconn mc = new Myconn();//创建链接对象，绑定时使用（作为bindservice的第二个实参）
	Mybinder mb;
	//绑定模式的链接类
	class Myconn implements ServiceConnection{
		//该接口有两个需要重写的函数
		//connected函数是在链接成功后调用
		//disconnected在链接非正常断开后调用
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {//Binder继承了接口IBinder
			//第一个参数为对象标记名称，较少使用
			//第二个参数为接收端（服务）返回的代理对象
			mb = (Mybinder)service;//保留代理对象的引用
			//((Mybinder)service).getsrv();//获取service提供的服务。这里获取服务是线程安全的
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
        btngetsrv.setEnabled(false);//按钮不可用
        //获取服务按钮事件处理
        btngetsrv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mb!=null)
					mb.getsrv();//在一个单独的按钮中获取服务，将邦定动作和获取服务动作分开（分到不同的事件处理中），线程安全
			}
		});
        //绑定按钮事件处理
        findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				it2 = new Intent(My1st_service.this, Bind_srv.class);
				//绑定服务,发起邦定动作        
		        bindService(it2, mc, Context.BIND_AUTO_CREATE);
		        //mb.getsrv();//若服务获取成功，仍然是邦定之后紧接着获取服务，但在bindservice函数后接着获取服务会发生异常
		        //因为，bindservice函数为异步执行（多线程）
		        
		        //第一个参数为intent
		        //第二个参数为链接对象、
		        //第三个参数是标记，比如是否在绑定的同时创建服务对象；是否在服务销毁同时也将启动端销毁
		        //邦定服务，若不进行手动销毁，则会在启动端销毁后自动销毁。
		        //一般邦定服务会进行手动的解除邦定 调用unbindservice
			}
		});
        //非邦定按钮事件处理
        findViewById(R.id.btn_nobind).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//非绑定模式在startservice函数调用后,会创建service对象同时启动服务
				//非绑定的service需要手动stop，一般在该Activity的ondestory函数中执行
				//否则即使该activity出栈销毁，服务仍然运行
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
		//在界面销毁同时销毁其启动的服务
		if(it != null)
		    stopService(it);
		if(it2 != null)
			unbindService(mc);//解除邦定，断开连接
	}
}
