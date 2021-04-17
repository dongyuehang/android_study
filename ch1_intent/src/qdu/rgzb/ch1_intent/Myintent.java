package qdu.rgzb.ch1_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Myintent extends Activity{
	Button btn_im;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myintent);
		
		btn_im = (Button) findViewById(R.id.btn_implicit);
		btn_im.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent("myaction", Uri.parse("myqdu://datatech.rjgc"));
				startActivity(it);
			}
		});
		
		findViewById(R.id.btn_explicit).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
	            startActivity( new Intent(Myintent.this, Act_explicit.class) );
			}
		});
	}

}
