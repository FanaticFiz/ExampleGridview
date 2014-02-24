package com.example.iqtest;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@ SuppressLint("ShowToast")
public class Activity5 extends Activity
{
	private	int					counter;
	private GridView			mGrid;
	private gridadapter_Game	mAdapter;
	private	Toast				toast;
			Animation 			animationRC;
			
	@ Override
	protected void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity5);
		
		// Привязываемся к грид на форме, стандартный грид нам не подходит, используем свой собственный 
		mGrid = (GridView)findViewById(R.id.gridView1);
        mGrid.setNumColumns(4);
        mGrid.setEnabled(true);
        mAdapter = new gridadapter_Game(this);
        mGrid.setAdapter(mAdapter);
        animationRC = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        
        // Обработчик нажатий
        mGrid.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            	{
            		v.startAnimation(animationRC);
            		counter++;
            		mAdapter.moov(position);
            		if (mAdapter.proverka()) {
						// Win
            			toast = Toast.makeText(getBaseContext(), "Да ты крут!!! Всегото "+counter+" Ходов.", 5000);
            			toast.show(); 
    	        		Intent intentG = new Intent();
    	        		intentG.setClass(Activity5.this, Activity6.class);
    	        		startActivity(intentG);
					}else {
						// wrong
					}
        		}                	             
        });  
	}
}
