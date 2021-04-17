package qdu.mytest.ch3_lists.exp3_steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qdu.mytest.ch3_lists.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class Step3_exp3 extends Activity{
	//定义名字数组
    String[] name={"张三","王五","赵六"};
    //定义描述任务数组
    String[] desc={"唱歌","跳舞","打球"};
    //定义头像数组
    int[] icon=new int[]
{R.drawable.icon1,R.drawable.icon2,R.drawable.icon3};
    List< Map<String,Object> > list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.step3_exp3);
		
		list= new ArrayList<Map<String,Object>>();
        for(int i=0;i<name.length;i++){
            Map<String, Object> listitem=new HashMap<String, Object>();
            listitem.put("icon",icon[i]);
            listitem.put("name",name[i]);
            listitem.put("desc",desc[i]);
            list.add(listitem);
        }
        BaseAdapter ba =new Mybaseadp3(this,list);
        ListView mylv = (ListView)this.findViewById(R.id.exp3_step3_lv);
        if(ba != null)
            mylv.setAdapter(ba);
	}
}
