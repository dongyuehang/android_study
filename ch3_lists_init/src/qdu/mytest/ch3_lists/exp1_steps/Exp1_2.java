package qdu.mytest.ch3_lists.exp1_steps;

import qdu.mytest.ch3_lists.R;
import qdu.mytest.ch3_lists.R.id;
import qdu.mytest.ch3_lists.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Exp1_2 extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//dongyh Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.arradp2);
		
		String str[] = {"Tom","Jerry","Mike","John","dongyh"};
		ArrayAdapter<Object> aa = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, str);
		//��һ������  �������
		//�ڶ�������  �б�ؼ��Ĳ�����ʽ  ����ʹ��������ж������ʽ
		//ע����һ����ʽ�����ǰ�׿ϵͳ���ã����ᳫ��APP������
		//����������
		ListView lv = (ListView)this.findViewById(R.id.listview1);
		lv.setAdapter(aa);
	}
}
