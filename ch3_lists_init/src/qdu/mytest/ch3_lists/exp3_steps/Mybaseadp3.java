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

public class Mybaseadp3 extends BaseAdapter {
	Context mycontext;
	List<Map<String,Object>> mylist;
	
    public Mybaseadp3(Context mycontext,  List<Map<String,Object>> mylist){
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
	static class ViewHolder{//�ڲ��࣬�����б�ؼ������ж�Ӧ�ؼ����͵�����
		ImageView iv;
		TextView tv_name,tv_desc;
	}
	//step3 ��step2�����ϣ�ͨ��settag��gettag��findviewbyid�������Ż�
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	ViewHolder vh;
    	if(convertView == null){
			convertView = LayoutInflater.from(mycontext).inflate(R.layout.ly_mylv,null);
			vh = new ViewHolder();//�����ڲ������
			vh.iv = (ImageView) convertView.findViewById(R.id.icon);
			vh.tv_name = (TextView) convertView.findViewById(R.id.name);
			vh.tv_desc = (TextView) convertView.findViewById(R.id.dexc);
			convertView.setTag(vh);//setTAG�������ڲ���vh������� ��ǰ�б�ؼ���item������ʾ��view����
    	}else {
			vh = (ViewHolder) convertView.getTag();
		}
    	
		
		vh.iv.setImageResource((Integer)mylist.get(position).get("icon"));
		vh.tv_name.setText((String)mylist.get(position).get("name"));
		vh.tv_desc.setText((String)mylist.get(position).get("desc"));
		
		return convertView;
	}
}
