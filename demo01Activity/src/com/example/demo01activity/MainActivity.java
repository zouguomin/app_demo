package com.example.demo01activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button btnStartAty1;
	private TextView tvMainOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 先决条件
        
        tvMainOut = (TextView) findViewById(R.id.tvMainOut);
        
        btnStartAty1 = (Button) findViewById(R.id.btnStartAty1);
        btnStartAty1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(MainActivity.this, Aty1.class);
				
				//i.putExtra("txt", "Hello aty1");
				Bundle data = new Bundle();
				data.putString("txt", "Hello aty1");
				i.putExtras(data);
				
				//startActivity(i);
				startActivityForResult(i, 0);
				
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	String result = data.getStringExtra("result");
    	tvMainOut.setText(result);
    	
    	super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
