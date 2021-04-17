package qdu.mytest.ch3_lists;

import qdu.mytest.ch3_lists.exp3_steps.Step1_exp3;
import qdu.mytest.ch3_lists.exp3_steps.Step2_exp3;
import qdu.mytest.ch3_lists.exp3_steps.Step3_exp3;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Exp3_lists extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// DYH Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_exp3);
		
		String str[] = {"Step1","Step2","Step3"};
		ArrayAdapter<Object> aa = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, str);
		ListView lv = (ListView)this.findViewById(R.id.listv_exp3);
		lv.setAdapter(aa);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-DYH generated method stub
				switch(position){
					case 0:
						startActivity(new Intent(Exp3_lists.this, Step1_exp3.class));
						break;
					case 1:
						startActivity(new Intent(Exp3_lists.this, Step2_exp3.class));
						break;
					case 2:
						startActivity(new Intent(Exp3_lists.this, Step3_exp3.class));
						break;
					//case 3:
						//startActivity(new Intent(Exp3_lists.this, Step4_exp3.class));
						//break;
					//case 4:
						//startActivity(new Intent(Exp3_lists.this, Step5_exp3.class));
						//break;
					default:
					    
				}
			}
		});
	}

}
