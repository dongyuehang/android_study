package qdu.mytest.ch3_lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lists_main extends Activity{
	Button btn_exp1,btn_exp2,btn_exp3,
	    btn_excer1,btn_excer2,btn_excer3;
	
	View.OnClickListener ls = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.btn_exp1:
				startActivity( new Intent(Lists_main.this, Exp1_lists.class) );				
				break;
			case R.id.btn_exp2:				
				startActivity(new Intent(Lists_main.this, Exp2_lists.class));
				break;
			case R.id.btn_exp3:
				startActivity( new Intent(Lists_main.this, Exp3_lists.class) );
				break;
			case R.id.btn_excer1:
				
				break;
			case R.id.btn_excer2:
				startActivity( new Intent(Lists_main.this, Excer2_lists.class) );
				break;
			case R.id.btn_excer3:
				startActivity( new Intent(Lists_main.this, Excer3_lists.class) );
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lists_main);
		
		btn_exp1 = (Button) findViewById(R.id.btn_exp1);
		btn_exp2 = (Button) findViewById(R.id.btn_exp2);
		btn_exp3 = (Button) findViewById(R.id.btn_exp3);
		btn_excer1 = (Button) findViewById(R.id.btn_excer1);
		btn_excer2 = (Button) findViewById(R.id.btn_excer2);
		btn_excer3 = (Button) findViewById(R.id.btn_excer3);
		
		btn_exp1.setOnClickListener(ls);
		btn_exp2.setOnClickListener(ls);
		btn_exp3.setOnClickListener(ls);
		btn_excer1.setEnabled(false);//its easy, no need for exercise...
		btn_excer2.setOnClickListener(ls);
		btn_excer3.setOnClickListener(ls);
		
		((Button)findViewById(R.id.btn_gv_exp)).setOnClickListener(
            new View.OnClickListener() {				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(Lists_main.this, Exp_grid_view.class));
				}
			}
		);
	}
	
}
