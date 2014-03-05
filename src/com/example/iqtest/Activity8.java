package com.example.iqtest;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;

public class Activity8 extends Activity	{
	
	private EditText 	myEdit;
	private ImageButton	myBut;
	
	@ Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity8);
		
		myEdit 		= 	(EditText) 		findViewById(R.id.editText1);
		myBut 		=	(ImageButton)	findViewById(R.id.imageButton1);

		myBut.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)
			{
				if (myEdit.getText().toString().equals("с8")) 	{	
					Intent intentG = new Intent(); 
					intentG.setClass(Activity8.this,Activity9.class); 
					startActivity(intentG);					
				}
			}
		});
	}
}
