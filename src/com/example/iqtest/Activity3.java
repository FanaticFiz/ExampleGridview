package com.example.iqtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity3 extends Activity {

	private	String		s;
	private	Animation	animation;
	private TextView	myText;
	private	ImageView	myImage,myImUps;
	private	EditText 	myEdit;
	private	ImageButton myBut;
	private	Boolean		priznak		=	false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity3);
		
		animation = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);

		final RelativeLayout 	myActivity 	= (RelativeLayout) 	findViewById(R.id.myRel);
		myEdit	= 	(EditText)	findViewById(R.id.editText1);
		myText 	= 	(TextView) 	findViewById(R.id.textView1);
		myImage =	(ImageView)	findViewById(R.id.imageView1);
		myImUps = 	(ImageView)	findViewById(R.id.BombIm);
		
		myBut = (ImageButton) findViewById(R.id.BombImBut1);
		myBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				s = myEdit.getText().toString();
				if (s.equals("мультивибратор")) {
					myText.setText("Упс...");
					myImage.setImageDrawable(getResources().getDrawable( R.drawable.mv2));
					myEdit.setVisibility(View.INVISIBLE);
					myBut.setVisibility(View.INVISIBLE);
					myImUps.setVisibility(View.VISIBLE);
					priznak=true;
				}else {
					myActivity.startAnimation(animation);
				}
			}
		});
	}
	
	public void myImClick(View v) {
		if (priznak) {
			Intent intent = new Intent();
			intent.setClass(Activity3.this, Activity4.class);
			startActivity(intent);				
		}
	}

}
