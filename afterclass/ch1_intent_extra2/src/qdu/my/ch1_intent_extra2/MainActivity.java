package qdu.my.ch1_intent_extra2;

import qdu.my.ch1_intent_extra2.util.Data_prepares;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String msg = "Test string";
				Intent it = new Intent(MainActivity.this, NextAct.class);
				it.putExtra("msg", 
						(msg =((EditText)findViewById(R.id.Etxt_msg)).getText().toString().trim())== ""?"Test string":msg
				);
				it.putExtra("names",12.5);  
				startActivity(it);
				
			}
		});
        
        ((Button)findViewById(R.id.btnchoose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,Image_act.class);
                startActivityForResult(it,0x123);
            }
        });
        
        findViewById(R.id.btn_send_exerc).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent it = new Intent(MainActivity.this, Excer.class);
//				it.putExtra("mystr", "exercise string");
//				it.putExtra("myint", 13);
//				it.putExtra("mydouble", 1.2);

				it.putExtras(  (new Data_prepares()).getdata()  );
				startActivity(it);
			}
		});
        //*****************************styles*************************
        String send_code = this.getString(R.string.send_intent_code);
        SpannableString spstr = new SpannableString(send_code);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spstr.setSpan(colorSpan, 0, spstr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        
        TextView sendcode = (TextView)findViewById(R.id.txtv_sendcode);
        sendcode.setText(spstr);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0x123 && resultCode == 0x123)
        {
            Bundle bd = data.getExtras();
            int imgid = bd.getInt("imgid");
            ImageView img = (ImageView)findViewById(R.id.imgicon);
            img.setImageResource(imgid);
        }
    }
}
