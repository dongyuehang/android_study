package qdu.my.ch2_service_msg;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Button btn_bindsrv,btn_sendmsg;
    Intent it;
    //Mybinder mb;
    Messenger msgr;
    Myconn mc = new Myconn();
    class Myconn implements ServiceConnection{
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//mb = (Mybinder) service;
			msgr = new Messenger(service);//将绑定模式的代理对象包装成messenger对象
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {}
    	
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn_bindsrv = (Button) findViewById(R.id.btn_bindsrv);
        btn_sendmsg = (Button) findViewById(R.id.btn_sendmsg);
        
        btn_bindsrv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				it = new Intent(MainActivity.this, Msgsrv.class);
				bindService(it, mc, Context.BIND_AUTO_CREATE);
			}
		});
        
        btn_sendmsg.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Message msg = Message.obtain();//建立message对象
				//message对象可以设置what,arg1,arg2和bundle
				msg.what = 1;
				msg.arg1 = 13;
				try {
					msgr.send(msg);
				} catch (RemoteException e) { e.printStackTrace();
				}//messenger对象可以调用send函数，通过代理对象向服务端发送数据
				//参数为message对象，该对象内包装数据
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
