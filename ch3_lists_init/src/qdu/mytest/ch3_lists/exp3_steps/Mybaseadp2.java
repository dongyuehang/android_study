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
//step2 该适配器在getView函数中通过判断，减少了view对象的inflate过程，提高性能
public class Mybaseadp2 extends BaseAdapter {
	Context mycontext;
	List<Map<String,Object>> mylist;
	ImageView iv;
	TextView tv_name,tv_desc;
    public Mybaseadp2(Context mycontext,  List<Map<String,Object>> mylist){
    	this.mycontext = mycontext;
    	this.mylist = mylist;
    }
	@Override
	public int getCount() {
		return mylist.size();
	}
	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	//view对象可以不必每次都重新创建并inflate
    	if(convertView == null)
			convertView = LayoutInflater.from(mycontext).inflate(R.layout.ly_mylv,null);		    
    	
    	iv = (ImageView) convertView.findViewById(R.id.icon);
		tv_name = (TextView) convertView.findViewById(R.id.name);
		tv_desc = (TextView) convertView.findViewById(R.id.dexc);
		
		iv.setImageResource((Integer)mylist.get(position).get("icon"));
		tv_name.setText((String)mylist.get(position).get("name"));
		tv_desc.setText((String)mylist.get(position).get("desc"));
		
		return convertView;
	}
}
