package qdu.my.ch4_datas2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Sqlite_intro extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_sqlite);
		
		((ListView)findViewById(R.id.lv_sqsteps)).setOnItemClickListener(
		    new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position){
					case 0:
						//提供要跳转app的包名，activity类名
						//若app中没有intent filter指定主界面，则activity的注册属性应当包含android：export=true，请自己观察。
						ComponentName cn = new ComponentName("qdu.szmt.find_sqlite_cmd", "qdu.szmt.find_sqlite_cmd.Find_sqlite");
						Intent it = new Intent();
						it.setComponent(cn);
						try{
						startActivity(new Intent(it));
						}catch (Exception e) {
							Toast.makeText(Sqlite_intro.this, "未找到相应APP的界面，请确认其已安装", Toast.LENGTH_LONG).show();
						}
						break;
					case 1:
						//简化代码
						try{
						startActivity(new Intent().setComponent(
							new ComponentName("qdu.szmt.find_sqlite_cmd", "qdu.szmt.find_sqlite_cmd.Go_sqlite")
						));}catch(Exception e){
							Toast.makeText(Sqlite_intro.this, "未找到相应APP的界面，请确认其已安装", Toast.LENGTH_LONG).show();
						}
					}
				}		    	
			}	
		);
	}
}
