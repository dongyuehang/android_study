package qdu.szmt.cr;

import android.net.Uri;

public class Profile {
	public static String uri_str = "content://qdu.szmt.testcp/";
	public static String path_single = "mydata/#";//����#��ͨ�������ƥ��һ��ID��
	public static String path = "mydata";
	public static Uri Content_URI = Uri.parse(uri_str+path);
	public static final String TABLE_NAME = "testcp";
	public static final String KEY_ID = "_id";
	public static final String KEY_DATA = "test_data";
}
