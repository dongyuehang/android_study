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
						//�ṩҪ��תapp�İ�����activity����
						//��app��û��intent filterָ�������棬��activity��ע������Ӧ������android��export=true�����Լ��۲졣
						ComponentName cn = new ComponentName("qdu.szmt.find_sqlite_cmd", "qdu.szmt.find_sqlite_cmd.Find_sqlite");
						Intent it = new Intent();
						it.setComponent(cn);
						try{
						startActivity(new Intent(it));
						}catch (Exception e) {
							Toast.makeText(Sqlite_intro.this, "δ�ҵ���ӦAPP�Ľ��棬��ȷ�����Ѱ�װ", Toast.LENGTH_LONG).show();
						}
						break;
					case 1:
						//�򻯴���
						try{
						startActivity(new Intent().setComponent(
							new ComponentName("qdu.szmt.find_sqlite_cmd", "qdu.szmt.find_sqlite_cmd.Go_sqlite")
						));}catch(Exception e){
							Toast.makeText(Sqlite_intro.this, "δ�ҵ���ӦAPP�Ľ��棬��ȷ�����Ѱ�װ", Toast.LENGTH_LONG).show();
						}
					}
				}		    	
			}	
		);
	}
}
