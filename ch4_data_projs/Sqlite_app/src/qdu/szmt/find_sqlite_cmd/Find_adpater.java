package qdu.szmt.find_sqlite_cmd;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Find_adpater extends BaseAdapter {
	Context myc;
	List<HashMap<String,Object>> mylist;
    public Find_adpater(Context myc, List<HashMap<String,Object>> mylist){
    	this.myc = myc; this.mylist = mylist;
    }
	@Override
	public int getCount() {
		return mylist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
    static class ViewHolder{
    	TextView text_v;
    	ImageView img_v;
    }
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
	    ViewHolder vh = new ViewHolder();
	    if(convertView == null){
	    	convertView = LayoutInflater.from(myc).inflate(R.layout.list_layout, null);
	    	
	    	vh.text_v = (TextView) convertView.findViewById(R.id.list_tv);
	    	vh.img_v = (ImageView) convertView.findViewById(R.id.list_imgv);
	    	
	    	convertView.setTag(vh);
	    }else{
	    	vh = (ViewHolder) convertView.getTag();
	    }
	    
	    vh.text_v.setText((String)mylist.get(position).get("list_text"));
	    vh.img_v.setImageResource((Integer)mylist.get(position).get("list_img"));
		return convertView;
	}

}
