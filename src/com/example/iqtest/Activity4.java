package com.example.iqtest;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;

public class Activity4 extends Activity 
{
	private TextView	TimerField,primer;
	private Animation	animation;
	private	int 		a1,a2,a3;
	private	ImageButton	iBut;
	private	EditText	edit;
	private Boolean		pr=false;
	private	CountDownTimer myT;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity4);
		
		animation = AnimationUtils.loadAnimation(this, R.anim.game_animation_wrongmoov);
		TimerField 	= (TextView) 	findViewById(R.id.TimerField);
		primer	 	= (TextView) 	findViewById(R.id.textView1);
		iBut		= (ImageButton)	findViewById(R.id.imageButton1);
		edit		= (EditText)	findViewById(R.id.editText1);
		newPrimer();
		
		myT = new CountDownTimer(60000, 1000) {
			public void onTick(long millisUntilFinished) {
				long sec = millisUntilFinished / 1000;
				TimerField.setText(""+sec);
				if (sec < 15) {
					TimerField.startAnimation(animation);
					TimerField.setTextColor(Color.RED);
				}
			}

			public void onFinish() {
					Toast.makeText(getApplicationContext(), "да ладно, пошутил я )))", Toast.LENGTH_LONG).show();
					pr = true;
			}
		}.start();
		
		
		iBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// проверяем то что ввели с решением примера
				if (edit.getText().length() != 0) {
					if ( (Integer.parseInt(edit.getText().toString()) == a3) || (pr) )	{
						Intent intentG = new Intent(); 
						intentG.setClass(Activity4.this,Activity5.class); 
						startActivity(intentG);
						myT.cancel();
					}
				}else if (pr) {
					Intent intentG = new Intent(); 
					intentG.setClass(Activity4.this,Activity5.class); 
					startActivity(intentG);
					myT.cancel();
				}
			}
		});
		
	}
	
	// Генерируем случайный пример
	public void newPrimer() {
		a1 = getRand(38,86);
		a2 = getRand(167,453);
		a3 = a1*a2;
		primer.setText(""+a1+ " * " +a2);
	}
	
	public int getRand(int min, int max) {
		  return (int) (Math.random() * (max - min) + min);
		}
}
