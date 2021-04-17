package com.example.ch1_act_lifecycle;

import android.app.Activity;
import android.os.Bundle;

public class Act_next extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_next);
		System.out.println("act2 : create");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("act2 : start");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		System.out.println("act2 : restart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("act2 : resume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("act2 : pause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("act2 : stop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("act2 : destroy");
	}
}
