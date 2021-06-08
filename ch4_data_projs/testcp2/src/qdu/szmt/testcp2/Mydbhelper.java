package qdu.szmt.testcp2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


public class Mydbhelper {
	Context c;
	Myopenhelper mh;
	SQLiteDatabase db;
	public Mydbhelper(Context c) {
		this.c = c;
		mh =  new Myopenhelper();
	}

	public static final String DB_NAME = "testcp.db";
	public static final int DB_VERSION =1;
	
	public static final String TABLE_NAME = "testcp";
	public static final String KEY_ID = "_id";
	public static final String KEY_DATA = "test_data";	
    
    class Myopenhelper extends SQLiteOpenHelper{
		public Myopenhelper() {
			super(c, DB_NAME, null, DB_VERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			//create table tectcp(_id integer primary key autoincreament, test_data text not null);
			String sql_str ="create table " + TABLE_NAME + " ( " +
		                    KEY_ID + " integer primary key autoincrement, "
		                    + KEY_DATA + " text not null);";
			db.execSQL(sql_str);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}    	
    }
    public void open(){
    	if(mh != null){
    		try{
    	     db = mh.getWritableDatabase();
    	    }catch(SQLiteException e1){
    	    	try{
    	    		db = mh.getReadableDatabase();
    	    	}catch(SQLiteException e2){
    	    		System.out.println("数据库无法连接");
    	    	}
    	    }
    	}else{
    		System.out.println("数据库不存在");
    	}
    }
    public void close(){
    	if(db!=null)
    		db.close();
    }
    
	public void adddata(String data) {
		if(db != null){
			ContentValues cv = new ContentValues();
			cv.put(KEY_DATA, data);
			db.insert(TABLE_NAME, null, cv);
		}
	}
	//db.query -> select  from tablenae where id = ?
	public String getall(){
		Cursor c = null;
		if(db!=null)
		    c = db.query(TABLE_NAME, null, null, null, null, null, null, null);
		String str = "";
		if(c != null)
			c.moveToFirst();
		for(int i = 0 ; i < c.getCount(); i++){
		    str += "ID: " + c.getInt(c.getColumnIndex(KEY_ID))
		    	   + "  data: " + c.getString(c.getColumnIndex(KEY_DATA))
		    	   + "\n";
		          
		    c.moveToNext();
		}
		return str;
	}
    
    
}
