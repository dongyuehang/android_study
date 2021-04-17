package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * 1)����service�࣬��дonbind����
 * 2)����bind���󣬲���onbind�����з���
 *   �Զ���Mybinder��̳а�׿�����android.os.Binder��
 *   ��Mybinder���Զ��庯����Ϊ�����齨���á�
 *   Binder��̳���IBinder�ӿڣ�IBinder����Ҫ����Դ��Linux���̼�ͨ�Ż���
 *   Service�İ�ģʽ��ʵ�ǰ�׿���̼�ͨ�ŵ�һ�ֱ�Ҫ�����ַ�ʽ
 *   ������Ҫ����Service�󶨵�ʵ�ֹ��̣�������ԭ�����ϸ����
 */
public class Bind_srv extends Service{
	Mybinder mb = new Mybinder();
	class Mybinder extends Binder{
		//�ɱ�����������õķ���ĺ���
		public void getservice(){
			System.out.println("Service porvided ......");
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("bindsrv bind");
		return mb;//���������Ҫ��onbind���������󶨺󣩷���
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("bindsrv unbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("bindsrv create");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("bindsrv destory");
	}
    //***********bindģʽ����ʹ��start����************
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("bindsrv shold not invoke this method");
		return super.onStartCommand(intent, flags, startId);
	}
}
