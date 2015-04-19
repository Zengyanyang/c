package com.andoid.aservice.mode;


import android.content.Context;
import cn.trinea.android.common.util.ShellUtils;

import com.andoid.aservice.ACommons;

public class DeviceInfo  {
	public String imei;
	public String uuid;
	public int version;
	public String netType;
	public String channel;
	/**是否平板*/
	public boolean isTablet;
	public String macAddress;
	public String systemVersion;
	public String sdkVersion;
	/**设置型号**/
	public String model;
	/**系统语言**/
	public String language;
	/**分辨率**/
	public String resolution;
	/**屏幕大小**/
	public String size;
	/**ram大小**/
	public String ram;
	public String rom;
	public boolean hasSim;
	public boolean isUpdateDeviceInfo;
	public boolean isRoot;
	public String email;
	public boolean isTest;
	
	/**
	 * 初始化字段
	 * @param mContext
	 */
	public void initData(Context mContext)
	{
		
	}
	
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public boolean isTablet() {
		return isTablet;
	}

	public void setTablet(boolean isTablet) {
		this.isTablet = isTablet;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getSdkVersion() {
		return sdkVersion;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public boolean isHasSim() {
		return hasSim;
	}

	public void setHasSim(boolean hasSim) {
		this.hasSim = hasSim;
	}

	public boolean isUpdateDeviceInfo() {
		return isUpdateDeviceInfo;
	}

	public void setUpdateDeviceInfo(boolean isUpdateDeviceInfo) {
		this.isUpdateDeviceInfo = isUpdateDeviceInfo;
	}

	public boolean isRoot() {
		return ShellUtils.checkRootPermission();
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isTest() {
		return ACommons.isTest;
	}
	
}
