package qdu.my.ch4_datas;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class S_p extends Activity{
	TextView tv_sp_codes1,tv_sp_codes2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_sh_p);
		
		tv_sp_codes1 = (TextView) findViewById(R.id.tv_sp_codes1);
		//安卓Textview文本框支持html格式
		tv_sp_codes1.setText(
				(Html.fromHtml(getString(R.string.sp_codes1)))
	    );
		
		tv_sp_codes2 = (TextView) findViewById(R.id.tv_sp_codes2);
		tv_sp_codes2.setText((Html.fromHtml(getString(R.string.sp_code2))));
	}
}
