package com.example.iqtest;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

public class ShowCustomDialog extends Dialog 
{
	private	Dialog		myCustomDialog;
	
	public ShowCustomDialog(Context context) {
		super(context, R.style.NoTitleDialog);
		this.setContentView(R.layout.activity_dialog);
		myCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		myCustomDialog.setCancelable(false);
		
	}

	public void SetText(String s) {
		
	}
	
	public void ShowCustomD() {
		myCustomDialog.show();
	}
	
	public void CloseCusD() {
		myCustomDialog.dismiss();
	}

}
