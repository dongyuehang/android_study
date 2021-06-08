package qdu.szmt.find_sqlite_cmd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Go_sqlite extends Activity{
    DBAdapter mydb_adp = null;
    TextView showinfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.go_sqlite);
		showinfo = (TextView) findViewById(R.id.show_info);
		findViewById(R.id.create_db).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mydb_adp == null){
				    mydb_adp = new DBAdapter(Go_sqlite.this);
				    mydb_adp.open();
				    //System.out.println("");
				}else{
					mydb_adp.open();
				}
				
				if(mydb_adp != null)
				    showinfo.setText("数据库内容为：\n" + mydb_adp.getAll());
			}
		});
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		mydb_adp.close();
	}
	

}
