package com.example.demo02service;

import com.example.demo02service.EchoService.EchoServiceBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener, ServiceConnection {
	
	private Button btnStartService, btnStopService, btnBindService, btnUnbindService, btnGetCurrentNum; 
	private Intent iService;
	private EchoService echoService = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iService = new Intent(this, EchoService.class);
		
		btnStartService = (Button) findViewById(R.id.btnStartSerivce);
		btnStopService = (Button) findViewById(R.id.btnStopSevice);
		btnBindService = (Button) findViewById(R.id.btnBindService);
		btnUnbindService = (Button) findViewById(R.id.btnUnbindService);
		btnGetCurrentNum = (Button) findViewById(R.id.btnGetCurrentNum);
		
		btnStartService.setOnClickListener(this);
		btnStopService.setOnClickListener(this);
		btnBindService.setOnClickListener(this);
		btnUnbindService.setOnClickListener(this);
		btnGetCurrentNum.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		
		Intent i = new Intent();
		
		switch (arg0.getId()) {
		case R.id.btnStartSerivce:
			startService(iService);
			break;

		case R.id.btnStopSevice:
			stopService(iService);
			break;
			
		case R.id.btnBindService:
			bindService(iService, this, Context.BIND_AUTO_CREATE);
			break;
			
		case R.id.btnUnbindService:
			unbindService(this);
			break;
			
		case R.id.btnGetCurrentNum:
			if (echoService != null)
				System.out.println("Current Number is " + echoService.getCurrentNum()); 
			break;
			
		default:
			break;
		}
		
	}


	@Override
	public void onServiceConnected(ComponentName arg0, IBinder binder) {
			System.out.println("onServiceConnected");
			echoService = ((EchoServiceBinder)binder).getService();
	}

	@Override
	public void onServiceDisconnected(ComponentName arg0) {
		System.out.println("onServiceDisconnected");
	}

}
