package com.andoid.aservice.task;

import android.content.Context;

import com.andoid.aservice.ALog;
import com.andoid.aservice.mode.AppInfo;


public class AppInstallTask implements AITask {

	private static final String TAG = "AppInstallTask";
	
	private Context mContext;
	private AppInfo app;
	public AppInstallTask(Context mContext,AppInfo app)
	{
		this.mContext = mContext;
		this.app = app;
	}
	@Override
	public void run() {
		ALog.e(TAG, "----------start-------------");
		
		try {
			Thread.sleep(4*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ALog.e(TAG, "");
		ALog.e(TAG, "----------end-------------");
	}
}
