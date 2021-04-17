package qdu.my.ch1_intent_extra;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class NextAct extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nextact);
		
		String msgstr = getIntent().getStringExtra("msg");
	
		if(msgstr.hashCode() == 0)
			msgstr = "空串";
		((TextView)findViewById(R.id.txtv_showmsg)).setText("接受结果为：" + msgstr);
		
		//**************styles**************
		String get_code = this.getString(R.string.rcv_intent_code);
        SpannableString spstr = new SpannableString(get_code);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spstr.setSpan(colorSpan, 0, spstr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        
        TextView showgetcode = (TextView)findViewById(R.id.txtv_getmsg_code);
        showgetcode.setText(spstr);
	}
}
