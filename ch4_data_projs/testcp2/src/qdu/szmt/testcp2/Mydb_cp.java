package qdu.szmt.testcp2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class Mydb_cp extends ContentProvider{
	Mydbhelper mdbh = null;
	//��Ҫ׼������
	//URI   Э��://host/path
	public static String uri_str = "content://qdu.szmt.testcp/";
	public static String path_single = "mydata/#";//����#��ͨ�������ƥ��һ��ID��
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
	public String getType(Uri uri) {//�����ڸú����У����岻ͬ��URI���صĶ�Ӧ������MIME����
		if(uri.toString() == Content_URI.toString())//��Ϊ�������ݣ�������з�������
			return "vnd.android.cursor.dir/mytext";
		if(uri.toString() == uri_str + path_single)//��Ϊ�������ݣ��򷵻ض�Ӧ����
			return "vnd.android.cursor.item/mytext";
		//���ﷵ�ص����Ͷ����Զ����MIME���ͣ�����/֮ǰ�������ǰ�׿ ϵͳ������
		return null;
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Uri insert(Uri uri, ContentValues values) {//�βε�uri����Ϊ���������ݵ����������ݱ�Ķ���uri���൱��contentprovider�ı�
		Uri newuri = null ;                                        //�ú������ص� uri�����ǵ��еģ���Ӧ�²���content provider�����ݡ�
		if(mdbh != null &&mdbh.db != null)
			//mdbh.adddata(data);
			if(uri.toString() == uri_str+path){
				long id = mdbh.db.insert(Mydbhelper.TABLE_NAME, null, values);
				if(id >0){
					//�ֶ�����contentprovider��һ�У�Ϊmydata�²�����������uri
					newuri = Uri.parse(uri_str + path + id);//��������URI����
				}
			}
		return newuri;
	}



	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		//provider��query�����������resolver����Ĳ�������
		//���ݲ�ͬ�Ĳ��ҷ�ʽ�����������ݿ������ȡֵ
		//�ú�����ʵ��������ƥ���resovler��query����
		//ȡֵ�п���ȡ���л��߶���
		Cursor c = null;
		if(uri.toString().equals(uri_str+path_single)){
			//�ж��Ƿ�Ϊ����uri ���磺 content://qdu.szmt.testcp/mydata/13
			if(mdbh!=null && mdbh.db != null)
				c = mdbh.db.query(Mydbhelper.TABLE_NAME, null, 
						Mydbhelper.KEY_ID + " = " + uri.getPathSegments().get(1)
						, null, null, null, null);
		}else if(uri.toString().equals(uri_str+path)){
			c = mdbh.db.query(Mydbhelper.TABLE_NAME, null, null, null, null, null, null);
		}
		c.setNotificationUri(getContext().getContentResolver(), uri);
		//��provider�������ݲ����仯������֪ͨ����ƥ���resolver
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
