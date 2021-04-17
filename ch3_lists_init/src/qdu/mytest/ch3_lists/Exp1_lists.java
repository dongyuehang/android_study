package qdu.mytest.ch3_lists;

import qdu.mytest.ch3_lists.exp1_steps.Exp1_1;
import qdu.mytest.ch3_lists.exp1_steps.Exp1_2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Exp1_lists extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_exp1);
		
		findViewById(R.id.btn_exp1_p1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity( new Intent(Exp1_lists.this, Exp1_1.class) );
			}
		});
		
		findViewById(R.id.btn_exp1_p2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity( new Intent(Exp1_lists.this, Exp1_2.class) );
			}
		});
	}

}
