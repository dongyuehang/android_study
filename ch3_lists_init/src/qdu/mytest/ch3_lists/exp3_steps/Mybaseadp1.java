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
		return mylist.size();//�����б�ؼ�item����
	}
	@Override
	public Object getItem(int position) {//��ȡĳ����position��item�����ã�ָ�룩
		return null;
	}
	@Override
	public long getItemId(int position) {
		return 0;
	}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	//�ú����ڻ��Ƶ�ǰ��position��itemʱ����
    	//position
    	//convertViewϵͳ�����һ��View���󣬸ö�����Ϊĳһ��item����ʾ�����ƣ��Ķ���
		convertView = LayoutInflater.from(mycontext).inflate(R.layout.ly_mylv,null);
		//inflate�ǰ�׿��xmlʵ������ת�����룩�Ĺ��ߡ�
		iv = (ImageView) convertView.findViewById(R.id.icon);
		tv_name = (TextView) convertView.findViewById(R.id.name);
		tv_desc = (TextView) convertView.findViewById(R.id.dexc);
				
		iv.setImageResource((Integer)mylist.get(position).get("icon"));
		tv_name.setText((String)mylist.get(position).get("name"));
		tv_desc.setText((String)mylist.get(position).get("desc"));
		
		return convertView;
	}
	
}
