package qdu.mytest.ch3_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
/**
 * �б�ؼ�ListView ʾ��1
 */
public class Exp2_lists extends Activity{
	//������������
    private String[] name={"����","����","����"};
    //����������������
    private String[] desc={"����","����","����"};
    
    //����ͷ������
    private int[] icon=new int[]
        {R.drawable.icon1,R.drawable.icon2,R.drawable.icon3};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_exp2);
		//����һ��list���ϣ�list���ϵ�Ԫ����MAP
        List<Map<String,Object>> list=
                 new ArrayList<Map<String,Object>>();
        for(int i=0;i<name.length;i++){
            Map<String, Object> listitem=new HashMap<String, Object>();
            listitem.put("icon",icon[i]);
            listitem.put("name",name[i]);
            listitem.put("desc",desc[i]);
            list.add(listitem);
        }
        
        //��listview֮ǰ������֯���ݽṹ
        //�����ݽṹ�����������
        //���������Զ������ͺ�����ṩ������
        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.ly_mylv, new String[]{"desc","icon","name","info"}, 
      		new int[]{R.id.dexc,R.id.icon,R.id.name});
        //����1��ָ����ǰ�������
        //����2�����ݽṹ
        //����3��listview�Ĳ����ļ�
        //����4������5��������2��3֮��Ķ�Ӧ��ϵ
        //����4ָ�����ݽṹ�ֶ�Ӧ��ֵ������5ָ���������id������˳��һһ��Ӧ
        
        //�����������õ�listview��
        ((ListView)findViewById(R.id.mylv)).setAdapter(sa); 
	}
	@Override
	protected void onResume() {
		super.onResume();
		String msg = "����ʹ����Simpleadapter,��������󲢴���5������.���������������ע��.";
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
    
    
}
