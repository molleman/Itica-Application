package com.itica.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IticaActivity extends Activity {
    private ImageButton directoryButton;
	private ImageButton directMeButton;
	private ImageButton newsButton;
	private ImageButton offersButton;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setUpViews();
    }

	private void setUpViews() {
		directoryButton = (ImageButton)findViewById(R.id.directory_button1);
		directMeButton = (ImageButton)findViewById(R.id.locate_me_button1);
		newsButton = (ImageButton)findViewById(R.id.news_button1);
		offersButton = (ImageButton)findViewById(R.id.offer_button1);
		
		directoryButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				Intent intent = new Intent(IticaActivity.this,DirectoryActivity.class);
				startActivity(intent);
				
			}
		});
		directMeButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				Intent intent = new Intent(IticaActivity.this,DirectMeActivity.class);
				startActivity(intent);
				
			}
		});
		
		newsButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				Intent intent = new Intent(IticaActivity.this,NewsActivity.class);
				startActivity(intent);
				
			}
		});
		
		offersButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				Intent intent = new Intent(IticaActivity.this,OffersActivity.class);
				startActivity(intent);
				
			}
		});
	}
    
    
}