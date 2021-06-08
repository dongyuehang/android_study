package qdu.szmt.test_cp_sys;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class C_p_sys extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ly_cp_sys);
		findViewById(R.id.btn_selectcontact).setEnabled(false);
		findViewById(R.id.btn_addcontact).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					addContact();
				} catch (RemoteException e) {
					e.printStackTrace();
				} catch (OperationApplicationException e) {
					e.printStackTrace();
				}
			}
		});
		
		findViewById(R.id.btn_allcontact).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getContacts();
			}
		});
	}
	void getContacts(){
	    //①查询raw_contacts表获得联系人的id
	    ContentResolver resolver = getContentResolver();
	    Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
	    //查询联系人数据
	    Cursor cursor = resolver.query(uri, null, null, null, null);
	    while(cursor.moveToNext())
	    {
	        //获取联系人姓名,手机号码
	        String cName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
	        String cNum = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
	        System.out.println("姓名:" + cName);
	        System.out.println("号码:" + cNum);
	        System.out.println("======================");
	    }
	    cursor.close();
	}
	 void addContact() throws RemoteException, OperationApplicationException {
		 String str_name = "张三";
		    //使用事务添加联系人
		    Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		    Uri dataUri =  Uri.parse("content://com.android.contacts/data");

		    ContentResolver resolver = getContentResolver();
		    ArrayList<ContentProviderOperation> operations = new ArrayList<ContentProviderOperation>();
		    ContentProviderOperation op1 = ContentProviderOperation.newInsert(uri)
		            .withValue("account_name", null)
		            .build();
		    operations.add(op1);

		    //依次是姓名，号码，邮编
		    ContentProviderOperation op2 = ContentProviderOperation.newInsert(dataUri)
		            .withValueBackReference("raw_contact_id", 0)
		            .withValue("mimetype", "vnd.android.cursor.item/name")
		            .withValue("data2", str_name)
		            .build();
		    operations.add(op2);

		    ContentProviderOperation op3 = ContentProviderOperation.newInsert(dataUri)
		            .withValueBackReference("raw_contact_id", 0)
		            .withValue("mimetype", "vnd.android.cursor.item/phone_v2")
		            .withValue("data1", "13798988888")
		            .withValue("data2", "2")
		            .build();
		    operations.add(op3);

		    ContentProviderOperation op4 = ContentProviderOperation.newInsert(dataUri)
		            .withValueBackReference("raw_contact_id", 0)
		            .withValue("mimetype", "vnd.android.cursor.item/email_v2")
		            .withValue("data1", "779878443@qq.com")
		            .withValue("data2", "2")
		            .build();
		    operations.add(op4);
		    //将上述内容添加到手机联系人中~
		    resolver.applyBatch("com.android.contacts", operations);
		    Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
		}
}
