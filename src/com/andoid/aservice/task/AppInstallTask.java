package com.andoid.aservice.task;

import java.util.HashMap;
import java.util.Map;

import android.app.DownloadManager;
import android.app.Service;
import android.content.Context;
import cn.trinea.android.common.util.DownloadManagerPro;
import cn.trinea.android.common.util.PackageUtils;

import com.andoid.aservice.ALog;
import com.andoid.aservice.db.AppInfoDb;
import com.andoid.aservice.mode.AppInfo;


public class AppInstallTask implements AITask {

	private static final String TAG = "AppInstallTask";
	
	private Context mContext;
	private AppInfo app;
	private DownloadManagerPro downManager;
	private AppInfoDb appDb;
	public AppInstallTask(Context mContext,AppInfo app)
	{
		this.mContext = mContext;
		this.app = app;
		DownloadManager dm = (DownloadManager)mContext.getSystemService(Service.DOWNLOAD_SERVICE);
		downManager = new DownloadManagerPro(dm);
		appDb = new AppInfoDb(mContext);
	}
	@Override
	public void run() {
		ALog.e(TAG, "----------start-------------");
		if(!PackageUtils.isExistApplication(mContext, app.packageName))
		{
			long downid = downManager.downFile(app.url);
			Map<String,String> v = new HashMap<String,String>();
			v.put("downid", String.valueOf(downid));
			v.put("state", "0");
			appDb.Insert(app,v);
		}
		
		ALog.e(TAG, "----------end-------------");
	}
}
