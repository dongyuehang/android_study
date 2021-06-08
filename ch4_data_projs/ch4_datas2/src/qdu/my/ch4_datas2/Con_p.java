package qdu.my.ch4_datas2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Con_p extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_con_p);
		((TextView)findViewById(R.id.tv_cp_intro)).setText(Html.fromHtml(getString(R.string.cp_intro)));
		((TextView)findViewById(R.id.tv_cp_introcp)).setText(Html.fromHtml(getString(R.string.cp_introcp)));
		((TextView)findViewById(R.id.tv_cp_introCR)).setText(Html.fromHtml(getString(R.string.cp_intro_CR)));
		
		findViewById(R.id.btn_cp_sys).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
				    startActivity(new Intent().setComponent(
						new ComponentName("qdu.szmt.test_cp_sys", "qdu.szmt.test_cp_sys.C_p_sys")
					));
				}catch (Exception e) {
					Toast.makeText(Con_p.this, "未找到相应APP的界面，请确认其已安装", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}
