package qdu.szmt.cr;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ContentResolver mycr;
    TextView showall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mycr = getContentResolver();//获取当前组件的contentresolver对象
        
        
        showall = (TextView)findViewById(R.id.tv_showall);
        String c_str = "";
        c_str = getall();
        if("".equals(c_str))
        	showall.setText("空");
        else 
            showall.setText(c_str);
        
        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String adddata = "";
				adddata = ((EditText)findViewById(R.id.et_adddata)).getText().toString();
				System.out.println("et_adddata: " + adddata);
				if(adddata.hashCode() != 0 || "".equals(adddata)){
					ContentValues cv = new ContentValues();
					cv.put(Profile.KEY_DATA, adddata);
					Uri result_uri = mycr.insert(Profile.Content_URI, cv);
					
					Toast.makeText(MainActivity.this, result_uri.toString(), Toast.LENGTH_LONG).show();
					String c_str = "";
			        c_str = getall();
			        if("".equals(c_str))
			        	showall.setText("空");
			        else 
			            showall.setText(c_str);
			        
			        System.out.println("c r insert done....");
				}
			}
		});
    }
    
    public String getall(){
    	String str = "";
    	Cursor c = mycr.query(Profile.Content_URI, null, null, null, null);
    	if(c!= null){
    		c.moveToFirst();
    		for(int i = 0 ; i< c.getCount(); i++){
    			str += "id: " + c.getInt(c.getColumnIndex("_id"))
    					+ " data: " + c.getString(c.getColumnIndex("test_data"))
    					+ "\n";
    			c.moveToNext();
    		}
    	}
    	return str;
    }
}
