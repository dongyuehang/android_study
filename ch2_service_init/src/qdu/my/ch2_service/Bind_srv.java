package qdu.my.ch2_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
/**
 * ��ģʽ��
 * 1������������̳�service����д��Ҫ�İ�ģʽ���������ں��������嵥�ļ�ע��
 * 2����ģʽ��ͨ��android IPC��ʵ�ֵģ������Ҫ�������Ӷ���
 *   ���նˣ�
 *      a.���������̳�Binder���������������
 *      b.��serviceҪ�ṩ�ķ������ڸ����У���Ϊ��Ա������
 *      c.�����������onbind�����з���
 *   �����ˣ�
 *      a.����������̳�ServiceConnection�ӿڣ����������Ӷ���
 *      b.������ܹ����ӳɹ�������Ի�ȡ�����ṩ�Ĵ�����󣬲����л�ȡ����
 *      c.��������ͨ��bindservice�����󶨷���
 */
public class Bind_srv extends Service{
	class Mybinder extends Binder{
		public void getsrv(){
			System.out.println("srv provided.......");
		}
	}
	Mybinder mb = new Mybinder();
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("bind srv create");
	}
	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("bind srv on bind");
		return mb;//���ش������
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("bind srv destroy");
	}
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("bind srv unbind");
		return super.onUnbind(intent);
	}
	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		System.out.println("bind srv rebind");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("bind srv onstart");
		return super.onStartCommand(intent, flags, startId);
	}

}
