package qdu.szmt.ch5_ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Basicui extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_basicui);
		
		((ListView)findViewById(R.id.lv_topics)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch(position){
				    case 0:
				    	startActivity(new Intent(Basicui.this, Screens.class));
				    	break;
				    case 1:
				    	startActivity(new Intent(Basicui.this, Ui_view.class));
				    	break;
				    case 2:
				    	
				}
			}		
		});
	}

}
