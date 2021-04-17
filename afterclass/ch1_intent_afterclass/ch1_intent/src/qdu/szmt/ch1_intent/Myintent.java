package qdu.szmt.ch1_intent;

import qdu.szmt.ch1_intent.R;
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
				//自定义的隐式跳转
				//intent第一个参数为字符串,指定action的值.
				//第二个参数为标准URI格式，对应协议（scheme）、域名/主机名/IP（host）、端口（port）、路径（path）
				//scheme://host:port/path
				//有了自定义intent对象，android系统会去进行intent filter进行选择
				//intent fileter为android组件注册时可以指定的内容
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
