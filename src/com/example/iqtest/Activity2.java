package com.example.iqtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Activity2 extends Activity {

	String		s;
	Animation	animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		animation = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);

		final RelativeLayout myActivity = (RelativeLayout) findViewById(R.id.myRel);
		final EditText myEdit = (EditText) findViewById(R.id.editText1);
		ImageButton myBut = (ImageButton) findViewById(R.id.imageButton1);
		myBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				s = myEdit.getText().toString();
				if (s.equals("телескоп")) {
					Intent intent = new Intent();
					intent.setClass(Activity2.this, Activity3.class);
					startActivity(intent);
				}else {
					myActivity.startAnimation(animation);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
