package com.example.iqtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Activity7 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity7);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity7, menu);
		return true;
	}

}
