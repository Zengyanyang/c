package com.andoid.aservice.task;

import android.content.Context;
import cn.trinea.android.common.util.PackageUtils;

import com.andoid.aservice.ALog;
import com.andoid.aservice.mode.DeleteInfo;


public class AppDeleteTask implements AITask {

	private static final String TAG = "AppDeleteTask";
	private Context mContext;
	private DeleteInfo app;
	public AppDeleteTask(Context mContext,DeleteInfo app)
	{
		this.mContext = mContext;
		this.app = app;
	}
	
	@Override
	public void run() {
		if(PackageUtils.isExistApplication(mContext, app.packageName))
		{
			ALog.e(TAG, "----------start-------------");
			PackageUtils.uninstall(mContext, app.packageName);
			ALog.e(TAG, "----------end-------------");
		}
	}
}
