package qdu.mytest.ch3_lists.exp3_steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qdu.mytest.ch3_lists.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Step1_exp3 extends Activity{
	//������������
    String[] name={"����","����","����"};
    //����������������
    String[] desc={"����","����","����"};
    //����ͷ������
    int[] icon=new int[]
{R.drawable.icon1,R.drawable.icon2,R.drawable.icon3};
    List< Map<String,Object> > list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.step1_exp3);
		
		list= new ArrayList<Map<String,Object>>();
        for(int i=0;i<name.length;i++){
            Map<String, Object> listitem=new HashMap<String, Object>();
            listitem.put("icon",icon[i]);
            listitem.put("name",name[i]);
            listitem.put("desc",desc[i]);
            list.add(listitem);
        }
        BaseAdapter ba =new Mybaseadp1(this,list);
        ListView mylv = (ListView)this.findViewById(R.id.exp3_step1_lv);
        if(ba != null)
            mylv.setAdapter(ba);
	}
}
