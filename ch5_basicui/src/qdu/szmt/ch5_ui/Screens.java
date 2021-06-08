package qdu.szmt.ch5_ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Screens extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_screens);
		((TextView)findViewById(R.id.tv_unit)).setText(
		    Html.fromHtml(getResources().getString(R.string.units_measurement))
		);
		
		((TextView)findViewById(R.id.tv_unit_trans)).setText(
			Html.fromHtml(getResources().getString(R.string.units_trans))
	    );
		
		((TextView)findViewById(R.id.tv_unit_codes)).setText(
			Html.fromHtml(getResources().getString(R.string.unit_codes))
	    );
	}

}
