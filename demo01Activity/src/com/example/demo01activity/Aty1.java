package com.example.demo01activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Aty1 extends Activity {
	
	private Button btnClose;
	private TextView tvOut;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aty1);
		
		btnClose = (Button) findViewById(R.id.btnClose);
		btnClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent i = new Intent();
				i.putExtra("result", "Hello MainActivity");
				
				setResult(0, i);
				
				finish();
			}
		});
		
		tvOut = (TextView) findViewById(R.id.tvOut);
		//tvOut.setText(getIntent().getStringExtra("txt"));
		Bundle data = getIntent().getExtras();
		String txt = data.getString("txt");
		
		tvOut.setText(txt);
	}
}
