package com.andoid.aservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/**
 * 主业务类
 * @author Administrator
 *
 */
public class AService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
