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
        //事件处理一般都在oncreate中完成
        //事件处理（UI交互）：1.事件源（被操作的UI组件） 2.注册侦听器  3.创建侦听器对象
        //确定事件源，当前为布局xml中声明的Button，需要通过findviewbyid函数
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {//匿名对象			
			@Override
			public void onClick(View v) {
				
			}
		});
        /***************************
        //注册函数的参数就是需要创建的侦听器对象
        //1)确定侦听器对象的类型（来自API），一般定义为接口
        //2）自定义class实现该接口
        class Myclicklistener implements View.OnClickListener{
			@Override
			public void onClick(View v) {//回调（钩子）函数
				
			}
        	
        }
        //new Myclicklistener();
        //3）创建侦听器对象并作为注册函数的参数
        //注册侦听器，根据事件源调用对应的注册函数
        btn1.setOnClickListener(new Myclicklistener());
        ****************************/
    }

}
