package com.andoid.aservice.mode;

import java.util.List;

public class ResulInfo {
	public String pushUrl;
	public int requestRate;
	public int apkNum;
	public int status;
	
	public UpdateInfo update;
	public List<AppInfo> appList;
	public List<DeleteInfo> deleteList;
	public List<ActiveInfo> activeList;
}
