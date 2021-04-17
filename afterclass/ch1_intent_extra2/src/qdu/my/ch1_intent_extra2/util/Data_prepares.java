package qdu.my.ch1_intent_extra2.util;

import android.os.Bundle;

public class Data_prepares {
	private Bundle bd;
	public Data_prepares(){
		Bundle extras = new Bundle();
		extras.putString("mystr", "exercise string");
		extras.putInt("myint", 13);
		extras.putDouble("mydouble", 1.2);
		this.bd = extras;
	}
	public Bundle getdata(){
		return bd;
	}
}
