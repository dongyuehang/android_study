package qdu.szmt.find_sqlite_cmd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
    private static final String DB_NAME = "people.db";
    private static final int DB_VERSION = 1;
    private static final String DB_PEOPLEINFO = "peopleinfo";
    
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_HEIGHT = "height";
    
    private SQLiteDatabase db;
    private final Context myc;
    private Mydbhelper mydbherlper;
    public DBAdapter(Context myc){this.myc = myc;}
    public void open(){
    	mydbherlper = new Mydbhelper(myc, DB_NAME, null, DB_VERSION);
    	try{
    	    db = mydbherlper.getWritableDatabase();
    	}catch(Exception e){
    		db = mydbherlper.getReadableDatabase();
    	}
    }
    public void close(){
    	if(db!=null){
    		db.close();
    		db = null;
    	}
    }
    class Mydbhelper extends SQLiteOpenHelper{
		public Mydbhelper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			if(db != null)
			db.execSQL("create table " + DB_PEOPLEINFO + "( " + KEY_ID + " integer primary key autoincrement, " + 
		                KEY_NAME + " text not null, " + KEY_AGE + " integer, " + KEY_HEIGHT + " float);" );
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("drop table if exists " + DB_PEOPLEINFO);
			onCreate(db);
		}
    	
    }
    //select * from tablename where bookname = JAVA .....
	public String getAll() {
		Cursor c_results = db.query(DB_PEOPLEINFO,new String[]{KEY_ID,KEY_NAME,KEY_AGE,KEY_HEIGHT},null,null,null,null,null);
		int re_size = c_results.getCount();
		if(re_size == 0 || !c_results.moveToFirst())
			return " Пе";
		String s_results = "";
		for(int i = 0; i< re_size; i++){
			s_results += "ID: " + c_results.getInt(0)
			          + ", NAME: " + c_results.getString(c_results.getColumnIndex(KEY_NAME))
			          + ", AGE: " + c_results.getString(c_results.getColumnIndex(KEY_AGE))
			          + ", HEIGHT: " + c_results.getString(c_results.getColumnIndex(KEY_HEIGHT))
			          +"\n";
		}			
		return s_results;
	}
}