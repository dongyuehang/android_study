package qdu.my.ch1_activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //�¼�����һ�㶼��oncreate�����
        //�¼�����UI��������1.�¼�Դ����������UI����� 2.ע��������  3.��������������
        //ȷ���¼�Դ����ǰΪ����xml��������Button����Ҫͨ��findviewbyid����
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {//��������			
			@Override
			public void onClick(View v) {
				
			}
		});
        /***************************
        //ע�ắ���Ĳ���������Ҫ����������������
        //1)ȷ����������������ͣ�����API����һ�㶨��Ϊ�ӿ�
        //2���Զ���classʵ�ָýӿ�
        class Myclicklistener implements View.OnClickListener{
			@Override
			public void onClick(View v) {//�ص������ӣ�����
				
			}
        	
        }
        //new Myclicklistener();
        //3������������������Ϊע�ắ���Ĳ���
        //ע���������������¼�Դ���ö�Ӧ��ע�ắ��
        btn1.setOnClickListener(new Myclicklistener());
        ****************************/
    }

}
