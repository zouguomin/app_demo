package com.example.demo02service;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class EchoService extends Service {

	private final EchoServiceBinder echoServiceBinder = new EchoServiceBinder();
	
	public class EchoServiceBinder extends Binder {
		
		public EchoService getService(){
			return EchoService.this;
		}
		
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		System.out.println("onBind");
		return echoServiceBinder;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		System.out.println("onCreate");
		startTimer();
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
	    System.out.println("onDestroy");
	    stopTimer();
		super.onDestroy();
	}
	
	public int getCurrentNum() {
		return i;
	}
	
	private Timer timer = null;
	private TimerTask task = null;
	private int i = 0;
	
	public void startTimer() {
		if (timer == null) {
			timer = new Timer();
			task = new TimerTask() {
				
				@Override
				public void run() {
					i ++;
					System.out.println(i);
					
				}
			};
		}
		
		timer.schedule(task, 1000, 1000);
	}
	
	public void stopTimer() {
		if (timer != null) {
			
			task.cancel();
			timer.cancel();
			timer = null;
			task = null;
		}
				
	}
	

}
