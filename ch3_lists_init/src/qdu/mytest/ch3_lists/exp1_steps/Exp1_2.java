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
		//第一个参数  组件引用
		//第二个参数  列表控件的布局样式  这里使用了类库中定义的样式
		//注意这一类样式本身是安卓系统自用，不提倡在APP中引用
		//第三个参数
		ListView lv = (ListView)this.findViewById(R.id.listview1);
		lv.setAdapter(aa);
	}
}
