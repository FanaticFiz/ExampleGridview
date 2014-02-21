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
import android.widget.TextView;

public class MainActivity extends Activity
{
	private	Animation	animation_wrong_moovs;
	public 	int			counter;
	TextView 			mainText1,mainText2,mainText3,mainText4;
	EditText 			myText,myText2;
	ImageButton 		myMainB;
	RelativeLayout 		rlMain;
	
	@ Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		animation_wrong_moovs = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
		
		counter = 0;
		mainText1 	= 	(TextView) 	findViewById(R.id.textView1);
		mainText2 	= 	(TextView) 	findViewById(R.id.textView2);
		mainText3 	= 	(TextView) 	findViewById(R.id.TextView3);
		mainText4	= 	(TextView) 	findViewById(R.id.TextView4);
		myText	 	= 	(EditText)	findViewById(R.id.editText1);
		myText2 	= 	(EditText)	findViewById(R.id.editText2);		
		myMainB 	= 	(ImageButton) findViewById(R.id.imageButton1);
		
		rlMain = (RelativeLayout) findViewById(R.id.RLmain);
		rlMain.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)
			{
				switch (counter) {
				case 0:	mainText2.setVisibility(0);		counter++;	break;
				case 1:	mainText3.setVisibility(0);		counter++;	break;
				case 2:	mainText4.setVisibility(0);
						myText.setVisibility(0);
						myText2.setVisibility(0);		
						myMainB.setVisibility(0);		counter++;  break;	
				default:											break;
				}
			}
		});
		
		myMainB.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)
			{
				if (proverka())	{
	        		Intent intentG = new Intent();
	        		intentG.setClass(MainActivity.this, Activity5.class);
	        		startActivity(intentG);
				}else {
					rlMain.startAnimation(animation_wrong_moovs);
				}
			}
		});
		
	}
	
	private Boolean proverka()
	{
		String name = myText.getText().toString();
		String data = myText2.getText().toString();
		if ((name.equals("игорь"))&&(data.equals("08.03.1984")))	{	return true;	} 
		else 														{	return false;	}
	}
	
	@ Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
