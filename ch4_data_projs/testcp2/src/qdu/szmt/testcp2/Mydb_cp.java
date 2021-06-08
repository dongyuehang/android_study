package qdu.szmt.testcp2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class Mydb_cp extends ContentProvider{
	Mydbhelper mdbh = null;
	//需要准备常量
	//URI   协议://host/path
	public static String uri_str = "content://qdu.szmt.testcp/";
	public static String path_single = "mydata/#";//这里#是通配符，将匹配一个ID号
	public static String path = "mydata";
	public static Uri Content_URI = Uri.parse(uri_str+path);//content://qdu.szmt.testcp/mydata
	//MIME  type/subtype
	@Override
	public boolean onCreate() {
		mdbh = new Mydbhelper(this.getContext());
		mdbh.open();
		return false;
	}
//	public Cursor getall(Uri uri){
//		Cursor c = null;
//		if(mdbh != null &&mdbh.db != null){
//			//mdbh.getall();
//			//c = this.query(Content_URI, null, null, null, null);
//			c = mdbh.db.query(Mydbhelper.TABLE_NAME, null, null, null, null, null, null);
//		}
//		return c;
//	}
	@Override
	public String getType(Uri uri) {//必须在该函数中，定义不同的URI返回的对应的数据MIME类型
		if(uri.toString() == Content_URI.toString())//若为多行数据，则定义多行返回类型
			return "vnd.android.cursor.dir/mytext";
		if(uri.toString() == uri_str + path_single)//若为单行数据，则返回对应类型
			return "vnd.android.cursor.item/mytext";
		//这里返回的类型都是自定义的MIME类型，其中/之前的类型是安卓 系统给定的
		return null;
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Uri insert(Uri uri, ContentValues values) {//形参的uri对象为待插入数据的类似于数据表的多行uri，相当于contentprovider的表
		Uri newuri = null ;                                        //该函数返回的 uri对象，是单行的，对应新插入content provider的数据。
		if(mdbh != null &&mdbh.db != null)
			//mdbh.adddata(data);
			if(uri.toString() == uri_str+path){
				long id = mdbh.db.insert(Mydbhelper.TABLE_NAME, null, values);
				if(id >0){
					//手动生成contentprovider的一行：为mydata新产生的行设置uri
					newuri = Uri.parse(uri_str + path + id);//创建单行URI对象
				}
			}
		return newuri;
	}



	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		//provider的query函数负责接收resolver传入的查找请求
		//根据不同的查找方式，决定从数据库中如何取值
		//该函数的实参来自于匹配的resovler的query函数
		//取值有可能取单行或者多行
		Cursor c = null;
		if(uri.toString().equals(uri_str+path_single)){
			//判断是否为单行uri 行如： content://qdu.szmt.testcp/mydata/13
			if(mdbh!=null && mdbh.db != null)
				c = mdbh.db.query(Mydbhelper.TABLE_NAME, null, 
						Mydbhelper.KEY_ID + " = " + uri.getPathSegments().get(1)
						, null, null, null, null);
		}else if(uri.toString().equals(uri_str+path)){
			c = mdbh.db.query(Mydbhelper.TABLE_NAME, null, null, null, null, null, null);
		}
		c.setNotificationUri(getContext().getContentResolver(), uri);
		//在provider中若内容产生变化，主动通知给相匹配的resolver
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
