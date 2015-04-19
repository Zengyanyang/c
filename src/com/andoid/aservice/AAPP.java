package com.andoid.aservice;

import android.app.Application;

public class AAPP extends Application {
	@Override  
    public void onCreate() {  
        super.onCreate();  
        CrashHandler catchHandler = CrashHandler.getInstance();  
        catchHandler.init(getApplicationContext());  
    }
}
