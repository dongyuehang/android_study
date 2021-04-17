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
 * 列表控件ListView 示例1
 */
public class Exp2_lists extends Activity{
	//定义名字数组
    private String[] name={"张三","王五","赵六"};
    //定义描述任务数组
    private String[] desc={"唱歌","跳舞","打球"};
    
    //定义头像数组
    private int[] icon=new int[]
        {R.drawable.icon1,R.drawable.icon2,R.drawable.icon3};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_exp2);
		//创建一个list集合，list集合的元素是MAP
        List<Map<String,Object>> list=
                 new ArrayList<Map<String,Object>>();
        for(int i=0;i<name.length;i++){
            Map<String, Object> listitem=new HashMap<String, Object>();
            listitem.put("icon",icon[i]);
            listitem.put("name",name[i]);
            listitem.put("desc",desc[i]);
            list.add(listitem);
        }
        
        //在listview之前必须组织数据结构
        //将数据结构与适配器结合
        //适配器有自定义类型和类库提供的类型
        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.ly_mylv, new String[]{"desc","icon","name","info"}, 
      		new int[]{R.id.dexc,R.id.icon,R.id.name});
        //参数1，指定当前界面组件
        //参数2，数据结构
        //参数3，listview的布局文件
        //参数4，参数5决定参数2和3之间的对应关系
        //参数4指定数据结构种对应的值，参数5指定界面组件id，按照顺序一一对应
        
        //将适配器设置到listview中
        ((ListView)findViewById(R.id.mylv)).setAdapter(sa); 
	}
	@Override
	protected void onResume() {
		super.onResume();
		String msg = "本例使用了Simpleadapter,创建其对象并传入5个参数.各参数意义见代码注释.";
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
    
    
}
