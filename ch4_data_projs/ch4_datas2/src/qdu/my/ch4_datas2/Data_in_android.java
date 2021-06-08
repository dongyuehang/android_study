package qdu.my.ch4_datas2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Data_in_android extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_data_in_ad);
		
		((ListView)findViewById(R.id.lv_topics)).setOnItemClickListener(
			new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					switch(position){
					case 0:
						startActivity(new Intent(Data_in_android.this, S_p.class));
						break;
					case 1:
						startActivity(new Intent(Data_in_android.this, F_io.class));
						break;
					case 2:
						startActivity(new Intent(Data_in_android.this, Sqlite_intro.class));
						break;
					case 3:
						startActivity(new Intent(Data_in_android.this, Con_p.class));
					}
				}
			}
		);
	}

}
