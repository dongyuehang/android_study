package qdu.szmt.testio2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Save_BC extends BroadcastReceiver{//һ���������㲥������û����ʾƥ��
	@Override
	public void onReceive(Context context, Intent arg1) {
		Toast.makeText(context, "�ļ�����ɹ�!",Toast.LENGTH_SHORT).show();
	}

}
