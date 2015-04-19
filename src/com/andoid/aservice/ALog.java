package com.andoid.aservice;

import android.util.Log;

public class ALog {
	
	public static void e(String tag,String msg)
	{
		if(ACommons.isTest)
		{
			Log.e(tag, msg);
		}
	}
}
