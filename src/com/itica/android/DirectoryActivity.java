package com.itica.android;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DirectoryActivity extends IticaManagerActivity {
	
	
	private EditText chipperInput;
	private Button testButton;
	private LinearLayout chipperList;
	private ListView chipperlistView;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directory);
        setUpViews();
        //createChippersText();
    }

	private void setUpViews() {
		
		chipperInput = (EditText)findViewById(R.id.chipper_edit_text);
		testButton = (Button)findViewById(R.id.test_button);
		chipperlistView = (ListView)findViewById(R.id.ListView01);
		chipperList = (LinearLayout)findViewById(R.id.linearLayout3);
		
		
		chipperlistView.setAdapter(new ChipperAdapter(this,R.layout.chipper_row,getIticaManagerApplication().getChippers()));
		chipperlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				getIticaManagerApplication().setCurrentChipper((Chipper)chipperlistView.getAdapter().getItem(arg2));
				Intent intent = new Intent(DirectoryActivity.this,ChipperInfoActivity.class);
				startActivity(intent);
			}
			
			
		});
		
		chipperInput.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				chipperInput.setText("");
			}
		});
		
		testButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				
				
			}
		});
		
	}

	private void createChippersText() {
		
		//i need to create a view in here for each chipper. + set a listener or a handler on these
		//pieces of ui that will bring me to chipper info activity
		
		for(Chipper chipper : getIticaManagerApplication().getChippers()){
			final TextView t = new TextView(DirectoryActivity.this);
			t.setText(chipper.getName());
			t.setTag(chipper);
			t.setPadding(0,10,0,10);
			
			chipperList.addView(t);
			//chipperInput.setText("suck my balls");
			t.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View arg0) {
					Intent intent = new Intent(DirectoryActivity.this,ChipperInfoActivity.class);
					startActivity(intent);
					getIticaManagerApplication().setCurrentChipper((Chipper)t.getTag());
				}
			});
			
		} 
		
	}
	

}
