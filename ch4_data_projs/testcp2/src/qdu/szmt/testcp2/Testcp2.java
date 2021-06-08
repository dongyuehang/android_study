package qdu.szmt.testcp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Testcp2 extends Activity{
    EditText et_insert;
    TextView tv_getall;
    Mydbhelper mdbh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_testcp);
		
		mdbh = new Mydbhelper(this);
		mdbh.open();
		//插入数据按钮事件处理
		findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mdbh != null){
					mdbh.adddata("abcdef");
				}
				//System.out.println("=========getall: \n" + mdbh.getall());
			}
		});
		
		findViewById(R.id.btn_getall).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((TextView)findViewById(R.id.tv_showdata)).setText(
						"=========getall: \n" + mdbh.getall()
				);
			}
		});
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(mdbh!=null)
			mdbh.close();
	}
	
	
}
