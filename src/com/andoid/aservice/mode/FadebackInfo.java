package com.andoid.aservice.mode;

import cn.trinea.android.common.util.SingletonUtils;

public class FadebackInfo extends SingletonUtils<FadebackInfo>{

	private String packageName;
	private int version;
	/**动作:active、delete、download、install**/
	private String action;
	/**状态:fail、success**/
	private String state;
	/**备注信息，比如下载失败的时候是下载失败的原因**/
	private String msg;
	
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	protected FadebackInfo newInstance() {
		// TODO Auto-generated method stub
		return new FadebackInfo();
	}

}
