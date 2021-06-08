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
				//������ʵ�ִӵ�ǰapp����һ��app����ʾ��ע���MAIN Activity
				Intent it = new Intent(Intent.ACTION_MAIN);
				//�ṩҪ��תapp�İ�����activity����
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
