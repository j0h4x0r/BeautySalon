package org.beautysalon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button faceButton = (Button)findViewById(R.id.face_button);
		faceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent faceIntent = new Intent(MainActivity.this, FaceActivity.class);
				startActivity(faceIntent);
			}
			
		});
		
		Button hairButton = (Button)findViewById(R.id.hair_button);
		hairButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent hairIntent = new Intent(MainActivity.this, HairActivity.class);
				startActivity(hairIntent);
			}
			
		});
		
		Button loginButton = (Button)findViewById(R.id.login_button);
		loginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
				startActivity(loginIntent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
