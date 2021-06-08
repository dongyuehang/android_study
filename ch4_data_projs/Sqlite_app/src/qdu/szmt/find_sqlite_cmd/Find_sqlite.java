package qdu.szmt.find_sqlite_cmd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;


public class Find_sqlite extends Activity{
	List<HashMap<String,Object>> mylist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findlayout);
		
		String [] mysteps = getResources().getStringArray(R.array.find_contents);
		int[] img_ids = {R.drawable.find_cmd,R.drawable.find_adbpath,R.drawable.goto_shell1,
		                        R.drawable.goto_shell2, R.drawable.goto_shell3, R.drawable.goto_sqlite};
		int find_steps = mysteps.length;
		mylist = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i< find_steps;i++){
			HashMap<String,Object> hm = new HashMap<String, Object>();
			hm.put("list_text", mysteps[i]);
			hm.put("list_img", img_ids[i]);
			mylist.add(hm);
		}
		
		BaseAdapter myba = new Find_adpater(this,mylist);
		ListView lv = (ListView) findViewById(R.id.find_steps);
		lv.setAdapter(myba);
		
		
	}
}
