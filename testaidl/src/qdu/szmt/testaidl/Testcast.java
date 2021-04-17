package qdu.szmt.testaidl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Testcast extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testcast);
		
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("qdu.szmt.testaidl_clt.Test_rcvr");
				intent.putExtra("msg", "hello cast from srvr");
			}
		});
	}
}
