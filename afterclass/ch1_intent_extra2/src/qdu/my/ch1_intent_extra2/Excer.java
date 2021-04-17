package qdu.my.ch1_intent_extra2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Excer extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_excer);
		
		Intent it = getIntent();//该函数获取发起端传递来的intent对象
//		String mystr = it.getStringExtra("mystr");
//	    int myint = it.getIntExtra("myint", 0);//第二个参数为取值失败时的默认值
//		double myd = it.getDoubleExtra("mydouble", 1.0);
		Bundle bd = it.getExtras();//该函数对应putExtras，其参数都为Bundle类型
		System.out.println("mystr:" + bd.getString("mystr") + "   myint:" + bd.getInt("myint") +
				"   mydouble:" + bd.getDouble("mydouble"));
		//System.out.println("mystr:" + mystr + "   myint:" + myint + "   mydouble:" + myd);
		
	}	
}
