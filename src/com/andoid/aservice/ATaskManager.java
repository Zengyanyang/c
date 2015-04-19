package com.andoid.aservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.andoid.aservice.mode.AppInfo;
import com.andoid.aservice.mode.DeleteInfo;
import com.andoid.aservice.task.AppDeleteTask;
import com.andoid.aservice.task.AppInstallTask;

import android.content.Context;

/***
 * 任务管理器
 * @author Administrator
 *
 */
public class ATaskManager {
	private Context mContext;
	private ExecutorService pool;
	public ATaskManager(Context mContext)
	{
		this.mContext = mContext;
		pool = Executors.newSingleThreadExecutor();
	}
	
	public void doTask(Runnable task)
	{
		pool.execute(task);
	}
	
	public void addTask(Object task)
	{
		if(task instanceof AppInfo)
		{
			doTask(new AppInstallTask(mContext, (AppInfo)task));
		}
		else if(task instanceof DeleteInfo)
		{
			doTask(new AppDeleteTask(mContext, (DeleteInfo)task));
		}
	}
}
