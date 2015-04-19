package com.andoid.aservice.db;

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import cn.trinea.android.common.util.DbHelper;

import com.andoid.aservice.mode.AppInfo;

public class AppInfoDb extends BaseDatabase{
	public static final String TB = "appinfo";
	public static final String[] CLOUM = new String[]{"_id",
		"packageName","hash","url","type","size","version","activity","downid","state"}; 
	
	private Context mContext;
	private DbHelper dbHelper;
	public AppInfoDb(Context mContext)
	{
		this.mContext = mContext;
		dbHelper = new DbHelper(mContext);
		TABLE_NAME = TB;
	}
	
	public void Insert(AppInfo app,Map<String,String> v)
	{
		ContentValues values = new ContentValues();
		values.put("packageName", app.packageName);
		values.put("hash", app.hash);
		values.put("url", app.url);
		values.put("hash", app.hash);
		values.put("type", app.type);
		values.put("size", app.size);
		values.put("version", app.version);
		values.put("activity", app.activity);
		if(v != null)
		{
			if(v.containsKey("downid"))values.put("downid", v.get("downid"));
			if(v.containsKey("state"))values.put("state", v.get("state"));
		}
		Insert(dbHelper.getWritableDatabase(), values);
	}
}
