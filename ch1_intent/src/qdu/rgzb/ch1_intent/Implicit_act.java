package qdu.rgzb.ch1_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Implicit_act extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.implicit_ly);
		
		findViewById(R.id.btn_default_action).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")) );
			}
		});
	}

}
