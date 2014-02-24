package com.example.iqtest;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class Activity6 extends Activity	{
	
	private EditText 	myEdit,myEdit2;
	private ImageButton	myBut;
	
	@ Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity6);
		
		myEdit 		= 	(EditText) 		findViewById(R.id.editText1);
		myEdit2		= 	(EditText) 		findViewById(R.id.editText2);
		myBut 		=	(ImageButton)	findViewById(R.id.imageButton1);
		
		myBut.setOnClickListener(new OnClickListener() {
			@ Override
			public void onClick(View v)
			{
				if (myEdit2.getText().toString().equals("21.03.1685")) {
					if (myEdit.getText().toString().equals("")) 	{	Toast.makeText(getApplicationContext(), "Ну а первое поле кто заполнять будет...", Toast.LENGTH_LONG).show();	}
					if (myEdit.getText().toString().equals("бах")) 	{	Toast.makeText(getApplicationContext(), "Ну с большой буквы же надо...", Toast.LENGTH_LONG).show();				}
					if (myEdit.getText().toString().equals("Бах")) 	{	
						Intent intentG = new Intent(); 
						intentG.setClass(Activity6.this,Activity7.class); 
						startActivity(intentG);					
					}
				}else {
					Toast.makeText(getApplicationContext(), "Неверная дата...", Toast.LENGTH_LONG).show();					
				}
			}
		});
	}

}
