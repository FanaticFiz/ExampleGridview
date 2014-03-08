package com.example.iqtest;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
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
	private	Animation		animation_wrong_moovs;
	private	int				counter;
	private TextView		mainText,mainText2,mainText3,mainText4;
	private	EditText 		myText,myText2;
	private	ImageButton 	myMainB;
	private	RelativeLayout 	rlMain;
	
	@ Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Calendar c = Calendar.getInstance();
		
		animation_wrong_moovs = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
		
		counter = 0;
		mainText 	= 	(TextView) 	findViewById(R.id.textView1);
		mainText2 	= 	(TextView) 	findViewById(R.id.textView2);
		mainText3 	= 	(TextView) 	findViewById(R.id.TextView3);
		mainText4	= 	(TextView) 	findViewById(R.id.TextView4);
		myText	 	= 	(EditText)	findViewById(R.id.editText1);
		myText2 	= 	(EditText)	findViewById(R.id.editText2);		
		myMainB 	= 	(ImageButton) findViewById(R.id.BombImBut1);
		
		rlMain = (RelativeLayout) findViewById(R.id.RLmain);
		
		if ( (c.get(c.MONTH)+1==3) && (c.get(c.DAY_OF_MONTH)>=8)) 
		{
		
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
						intentG.setClass(MainActivity.this, Activity2.class);
						startActivity(intentG);
					}else {
						rlMain.startAnimation(animation_wrong_moovs);
					}
				}
			});
		}else {
			mainText.setText("рано еще... ))");
		}
	}
	
	private Boolean proverka()
	{
		String name = myText.getText().toString();
		String data = myText2.getText().toString();
		if ((name.equals("Игорь"))&&(data.equals("08.03.1984")))	{	return true;	} 
		else 													{	return false;	}
	}
}
