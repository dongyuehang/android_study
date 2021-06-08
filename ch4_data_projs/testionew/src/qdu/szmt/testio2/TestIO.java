package qdu.szmt.testio2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestIO extends Activity{
	FileOutputStream fos = null;
	EditText et_fname;
	EditText et_fc;
	Button b_save;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mylayout);
		
		et_fname = (EditText) findViewById(R.id.filename);
		et_fc = (EditText) findViewById(R.id.filecontent);
		b_save = (Button) findViewById(R.id.savefile);
		
		b_save.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				try {
					String fname = (et_fname.getText()==null?"":et_fname.getText()).toString();
					if(fname != "")
					    fos = openFileOutput(fname+".txt", MODE_PRIVATE);
					else
						fos = openFileOutput("defaultname.txt", MODE_PRIVATE);
					//调用openFileOutput库函数
			        //第一个参数指定文件名称
			        //第二参数指定模式，当前是默认模式
					String strs = et_fc.getText().toString();
					fos.write(strs.getBytes());
										
					sendBroadcast(new Intent("qdu.szmt.testio2.Save_BC"));//发送广播   -> 广播接收器（BroadcastReceiver）
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					try {
						if(fos != null){
							fos.flush();
							fos.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				et_fname.setText(""); et_fc.setText("");
			}
		});
		
		
        
	}

}
