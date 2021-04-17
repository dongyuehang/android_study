package qdu.my.ch2_service_msg;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public class Msgsrv extends Service{
	//1.准备handler对象，并重写handlemsg函数处理消息的接收
	//这里消息是随机且并发（多线程）
	//定义内部类继承handler
	//2.将handler对象包装成messenger对象
	//3.返回代理对象，该对象来自于messenger
	class Myhandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			//若发送端调用了send函数，则消息将接受至该函数形参
			if(msg.what == 1){
				System.out.println("接收成功, arg1:"  + msg.arg1);
			}
		}
		
	}
	Messenger msgr = new Messenger(new Myhandler());//将handler对象作为messegner构造函数的参数
//	Mybinder mb = new Mybinder();
//    class Mybinder extends Binder{
//    	public void getmsg(){}
//    }
	@Override
	public IBinder onBind(Intent intent) {
		return msgr.getBinder();
	}

}
