package qdu.szmt.testio2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Save_BC extends BroadcastReceiver{//一般来讲，广播接收器没有显示匹配
	@Override
	public void onReceive(Context context, Intent arg1) {
		Toast.makeText(context, "文件保存成功!",Toast.LENGTH_SHORT).show();
	}

}
