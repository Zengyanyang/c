package com.andoid.aservice;

import java.util.HashMap;
import java.util.Map;

import cn.trinea.android.common.util.HttpUtils;
import cn.trinea.android.common.util.JSONUtils;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
	}
	
	public void onClick(View view)
	{
//		startService(new Intent(this,AService.class));
		Map<String,String> parasMap = new HashMap<String,String>();
		parasMap.put("data", RequestInfo.)
		HttpUtils.httpPostString(ACommons.host, parasMap);
	}
}
