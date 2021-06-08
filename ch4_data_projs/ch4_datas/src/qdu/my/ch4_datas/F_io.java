package qdu.my.ch4_datas;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class F_io extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_fio);
		
		findViewById(R.id.btn_fio_exp).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//这里是实现从当前app打开另一个app并显示其注册的MAIN Activity
				Intent it = new Intent(Intent.ACTION_MAIN);
				//提供要跳转app的包名，activity类名
				ComponentName cn = new ComponentName("qdu.szmt.testio2", "qdu.szmt.testio2.TestIO");
				it.setComponent(cn);
				startActivity(new Intent(it));
			}
		});
		
		findViewById(R.id.btn_fio_exer).setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(Intent.ACTION_MAIN);
				ComponentName cn = new ComponentName("qdu.szmt.testio22", "qdu.szmt.testio22.TestIO");
				it.setComponent(cn);
				startActivity(new Intent(it));
			}
		});
	}

}
