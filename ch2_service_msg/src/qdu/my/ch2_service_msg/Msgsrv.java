package qdu.my.ch2_service_msg;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

public class Msgsrv extends Service{
	//1.׼��handler���󣬲���дhandlemsg����������Ϣ�Ľ���
	//������Ϣ������Ҳ��������̣߳�
	//�����ڲ���̳�handler
	//2.��handler�����װ��messenger����
	//3.���ش�����󣬸ö���������messenger
	class Myhandler extends Handler{
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			//�����Ͷ˵�����send����������Ϣ���������ú����β�
			if(msg.what == 1){
				System.out.println("���ճɹ�, arg1:"  + msg.arg1);
			}
		}
		
	}
	Messenger msgr = new Messenger(new Myhandler());//��handler������Ϊmessegner���캯���Ĳ���
//	Mybinder mb = new Mybinder();
//    class Mybinder extends Binder{
//    	public void getmsg(){}
//    }
	@Override
	public IBinder onBind(Intent intent) {
		return msgr.getBinder();
	}

}
