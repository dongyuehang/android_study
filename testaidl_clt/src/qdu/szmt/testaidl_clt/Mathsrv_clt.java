package qdu.szmt.testaidl_clt;

import qdu.szmt.testaidl.IMathSrv;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

public class Mathsrv_clt extends Activity{
	IMathSrv mathsrv = null;
    ServiceConnection sc = new ServiceConnection(){
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mathsrv = IMathSrv.Stub.asInterface(service);
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {
			mathsrv = null;
		}
	};
	
	TextView tv;
    boolean isBound = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mylayout);
		
		tv = (TextView) findViewById(R.id.tv1);
		findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isBound){
				    Intent serviceit = new Intent();
				    serviceit.setAction("qdu.szmt.testaidl.MathService");
				    bindService(serviceit, sc, Service.BIND_AUTO_CREATE);
				    //System.out.println("binding done...");
				    tv.setText("binding done...");
				    isBound = true;
				}
			}
		});
		
		findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isBound){
					unbindService(sc);
					mathsrv = null;
					//System.out.println("unbinded...");
					tv.setText("unbinded...");
					isBound = false;
				}
			}
		});
		
		findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mathsrv != null){
					long a = Math.round(Math.random()*100);
					long b = Math.round(Math.random()*100);
					long result = 0;
					try {
						result = mathsrv.Add(a, b);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					tv.setText("we got "+ a + " + " + b + " = " + result);
				}
			}
		});
	}
	
	
}
