package com.andoid.aservice;

import com.andoid.aservice.mode.DeviceInfo;

import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;

/***
 * 系统配置
 * @author Administrator
 *
 */
public class AConfigurations {
	private static AConfigurations instance;
	private AConfigurations()
	{
		
	}
	
	private Context mContext;
	private SharedPreferences sp;
	/**设置信息**/
	private DeviceInfo di;
	/****
	 * 最后一次访问服务器时间
	 */
	private long lastVisitTime = 0;
	/***业务请求频率(单位为天)**/
	private int requestRate = ACommons.REQUEST_RATE;
	
	public static AConfigurations getInstance()
	{
		if(instance == null)
		{
			instance = new AConfigurations();
		}
		return instance;
	}
	
	public void init(Context mContext)
	{
		this.mContext = mContext;
		sp = mContext.getSharedPreferences(ACommons.SHEARE_PF, Service.MODE_APPEND);
		di = new DeviceInfo();
		di.initData(mContext);
	}
	
	public DeviceInfo getDeviceInfo()
	{
		return di;
	}
	
	/***
	 * 获取最后一次访问服务器时间
	 * @return
	 */
	public long getLastVisitTime()
	{
		lastVisitTime = sp.getLong(ACommons.SP_REQUEST_TIME_STEMP, 0);
		return lastVisitTime;
	}
	
	/***
	 * 设置最后一次访问时间截
	 */
	public void setLastVisitTime()
	{
		long time = System.currentTimeMillis();
		sp.edit().putLong(ACommons.SP_REQUEST_TIME_STEMP, time).commit();
	}
	
	public int getRequestRate() {
		return sp.getInt(ACommons.SP_REQUEST_RATE, ACommons.REQUEST_RATE);
	}

	public void setRequestRate(int requestRate) {
		this.requestRate = requestRate;
		sp.edit().putInt(ACommons.SP_REQUEST_RATE, requestRate).commit();
	}
}
