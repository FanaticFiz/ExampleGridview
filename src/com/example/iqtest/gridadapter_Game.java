package com.example.iqtest;

import java.util.ArrayList;
import java.util.Collections;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class gridadapter_Game extends BaseAdapter 
{
	private Context 			mContext;
	private ArrayList<String> 	arrayPicture; 		// массив картинок
	private Resources 			mRes; 		   		// Ресурсы приложени
	private int[] myArr	= new int[7];
	
	// Конструктор
	public gridadapter_Game(Context context) 
	{
		mContext 	= context;
	    mRes 		= mContext.getResources();
	    
	    // оздаем, заполняем и перемешиваем массив картинок...
	    arrayPicture = new ArrayList<String>();
	    for (int i = 0; i < 16; i++) {
	    	String s;
	    	if (i%2==0) {
	    		s = "hex01";
			}else {
				s = "hex02";
			}
	    	arrayPicture.add(s);
		}
	    Collections.shuffle(arrayPicture);
	}
	
	
	public void moov(int position)
	{
		switch (position) {
		case 0:		obmen(0, 1, 2, 3, 4, 8, 12);	break;//
		case 1:		obmen(0, 1, 2, 3, 5, 9, 13);	break;//
		case 2:		obmen(0, 1, 2, 3, 6, 10, 14);	break;//
		case 3:		obmen(0, 1, 2, 3, 7, 11, 15);	break;//
		
		case 4:		obmen(0, 5, 6, 7, 4, 8, 12);	break;//
		case 5:		obmen(1, 5, 9, 13, 4, 6, 7);	break;//
		case 6:		obmen(2, 6, 10, 14, 4, 5, 7);	break;//
		case 7:		obmen(4, 5, 6, 7, 3, 11, 15);	break;//

		case 8:		obmen(0, 9, 10, 11, 4, 8, 12);	break;//
		case 9:		obmen(8, 9, 10, 11, 1, 5, 13);	break;//
		case 10:	obmen(8, 9, 10, 11, 2, 6, 14);	break;//
		case 11:	obmen(8, 9, 10, 11, 3, 7, 15);	break;//

		case 12:	obmen(0, 4, 8, 13, 14, 15, 12);	break;//
		case 13:	obmen(1, 5, 9, 12, 13, 14, 15);	break;//
		case 14:	obmen(2, 6, 10, 12, 13, 14,15);	break;//
		case 15:	obmen(3, 7, 11, 12, 13, 14,15);	break;//

		default:
			break;
		}
		notifyDataSetChanged();
	}
	
	public void obmen(int n1, int n2, int n3, int n4, int n5, int n6, int n7)
	{
		myArr[0]=n1;	myArr[1]=n2;	myArr[2]=n3;	myArr[3]=n4;
		myArr[4]=n5;	myArr[5]=n6;	myArr[6]=n7;
		for (int i = 0; i < myArr.length; i++) {
			if 		(arrayPicture.get(myArr[i]).equals("hex01")) 	{	arrayPicture.set(myArr[i], "hex02");	}
			else if (arrayPicture.get(myArr[i]).equals("hex02")) 	{	arrayPicture.set(myArr[i], "hex01");	}
		}
	}
	
	public Boolean proverka()
	{
		int counter=0;
		for (int i = 0; i < arrayPicture.size(); i++) {
			if (arrayPicture.get(i).equals("hex02")) {
				counter++;
			}
		}
		if (counter==16) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public 	int 	getCount()				{	return arrayPicture.size();	}
	@Override
	public 	Object 	getItem(int position) 	{	return null;				}
	@Override
	public 	long 	getItemId(int position)	{	return 0;					}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		SquareImageView view; // для вывода картинки
		if (convertView == null)
			view = new SquareImageView(mContext);
		else
			view = (SquareImageView) convertView;

		// Получаем идентификатор ресурса для картинки,
	    // которая находится в векторе arrayPicture на позиции position
		Integer drawableId = mRes.getIdentifier(arrayPicture.get(position), "drawable", mContext.getPackageName());
		view.setImageResource(drawableId);
		
		return view;
	}
}
