package qdu.my.ch1_intent_extra2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Excer extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_excer);
		
		Intent it = getIntent();//�ú�����ȡ����˴�������intent����
//		String mystr = it.getStringExtra("mystr");
//	    int myint = it.getIntExtra("myint", 0);//�ڶ�������Ϊȡֵʧ��ʱ��Ĭ��ֵ
//		double myd = it.getDoubleExtra("mydouble", 1.0);
		Bundle bd = it.getExtras();//�ú�����ӦputExtras���������ΪBundle����
		System.out.println("mystr:" + bd.getString("mystr") + "   myint:" + bd.getInt("myint") +
				"   mydouble:" + bd.getDouble("mydouble"));
		//System.out.println("mystr:" + mystr + "   myint:" + myint + "   mydouble:" + myd);
		
	}	
}
