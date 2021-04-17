package qdu.mytest.ch3_lists.exp3_steps;

import java.util.List;
import java.util.Map;

import qdu.mytest.ch3_lists.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class Mybaseadp1 extends BaseAdapter{
	Context mycontext;
	List<Map<String,Object>> mylist;
	ImageView iv;
	TextView tv_name,tv_desc;
    public Mybaseadp1(Context mycontext,  List<Map<String,Object>> mylist){
    	this.mycontext = mycontext;
    	this.mylist = mylist;
    }
	@Override
	public int getCount() {
		return mylist.size();//决定列表控件item个数
	}
	@Override
	public Object getItem(int position) {//获取某个（position）item的引用（指针）
		return null;
	}
	@Override
	public long getItemId(int position) {
		return 0;
	}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	//该函数在绘制当前（position）item时调用
    	//position
    	//convertView系统传入的一个View对象，该对象作为某一个item的显示（绘制）的对象
		convertView = LayoutInflater.from(mycontext).inflate(R.layout.ly_mylv,null);
		//inflate是安卓将xml实例化（转换代码）的工具。
		iv = (ImageView) convertView.findViewById(R.id.icon);
		tv_name = (TextView) convertView.findViewById(R.id.name);
		tv_desc = (TextView) convertView.findViewById(R.id.dexc);
				
		iv.setImageResource((Integer)mylist.get(position).get("icon"));
		tv_name.setText((String)mylist.get(position).get("name"));
		tv_desc.setText((String)mylist.get(position).get("desc"));
		
		return convertView;
	}
	
}
